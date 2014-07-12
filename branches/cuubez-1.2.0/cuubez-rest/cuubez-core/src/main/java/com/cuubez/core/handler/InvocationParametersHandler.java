/**
 *	Copyright [2013] [www.cuubez.com]
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.cuubez.core.handler;


import com.cuubez.core.context.MessageContext;
import com.cuubez.core.exception.CuubezException;
import com.cuubez.core.resource.metaData.*;
import com.cuubez.core.util.ConverterUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.HeaderParam;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

public class InvocationParametersHandler implements RequestHandler{

    private static Log log = LogFactory.getLog(InvocationParametersHandler.class);


    public void handleRequest(MessageContext messageContext) throws CuubezException {

        SelectedResourceMetaData selectedResourceMetaData = messageContext.getRequestContext().getSelectedResource();
        MethodMetaData selectedMetaData = selectedResourceMetaData.getSelectedMethodMetaData();
        Method selectedMethod = selectedMetaData.getReflectionMethod();

        final Annotation[][] paramAnnotations = selectedMethod.getParameterAnnotations();
        final Class[] paramTypes = selectedMethod.getParameterTypes();

        Object[] parameters = null;

        if (paramAnnotations != null && paramAnnotations.length > 0) {
            parameters = new Object[paramAnnotations.length];
        }


        for (int i = 0; i < paramAnnotations.length; i++) {

            boolean annotationFound = false;

            for (Annotation annotation : paramAnnotations[i]) {

                if (annotation instanceof PathParam) {
                    String name = ((PathParam) annotation).value();
                    parameters[i] = ConverterUtil.convert(getPathValue(selectedResourceMetaData.getPathVariableMetaDataList(), name), paramTypes[i]);
                    annotationFound = true;

                } else if (annotation instanceof QueryParam) {

                    String name = ((QueryParam) annotation).value();
                    parameters[i] = ConverterUtil.convert(getQueryValue(messageContext.getRequestContext().getUrlContext().getQueryVariableMetaDataList(), name), paramTypes[i]);

                    annotationFound = true;

                } else if (annotation instanceof HeaderParam) {

                    String name = ((HeaderParam) annotation).value();
                    parameters[i] = ConverterUtil.convert(getHeaderValue(messageContext.getRequestContext().getUrlContext().getHeaderVariableMetaDataList(), name), paramTypes[i]);
                    annotationFound = true;

                } else {
                    annotationFound = true;
                    log.error("Unsupported annotation found");
                }
            }


            if (!annotationFound) {
                messageContext.getRequestContext().getSelectedResource().getSelectedMethodMetaData().setInputObjectIndex(i);
                messageContext.getRequestContext().getSelectedResource().getSelectedMethodMetaData().setInputObjectType(paramTypes[i]);
            }
        }

        messageContext.getRequestContext().getSelectedResource().getSelectedMethodMetaData().setParameters(parameters);

    }


    private String getPathValue(List<PathVariableMetaData> pathVariableMetaDataList, String name) {

        if (pathVariableMetaDataList == null || pathVariableMetaDataList.size() == 0) {
            return null;
        }

        for (PathVariableMetaData pathVariableMetaData : pathVariableMetaDataList) {

            if (pathVariableMetaData.getName().equals(name)) {
                return pathVariableMetaData.getValue();
            }
        }

        return null;
    }

    private String getHeaderValue(List<HeaderVariableMetaData> headerVariableMetaDataList, String name) {

        if (headerVariableMetaDataList == null || headerVariableMetaDataList.size() == 0) {
            return null;
        }

        for (HeaderVariableMetaData headerVariableMetaData : headerVariableMetaDataList) {

            if (headerVariableMetaData.getName().equals(name)) {
                return headerVariableMetaData.getValue();
            }
        }

        return null;
    }

    private String getQueryValue(List<QueryVariableMetaData> queryVariableMetaDataList, String name) {

        if (queryVariableMetaDataList == null || queryVariableMetaDataList.size() == 0) {
            return null;
        }

        for (QueryVariableMetaData queryVariableMetaData : queryVariableMetaDataList) {

            if (queryVariableMetaData.getName().equals(name)) {
                return queryVariableMetaData.getValue();
            }
        }

        return null;
    }

}
