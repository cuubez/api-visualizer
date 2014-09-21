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
package com.cuubez.visualizer.processor;


import com.cuubez.visualizer.annotation.M;
import com.cuubez.visualizer.annotation.ParameterDetail;
import com.cuubez.visualizer.domain.HeaderVariableMetaData;
import com.cuubez.visualizer.domain.PathVariableMetaData;
import com.cuubez.visualizer.domain.QueryVariableMetaData;
import com.cuubez.visualizer.resource.InformationRepository;
import com.cuubez.visualizer.resource.RootResource;
import com.cuubez.visualizer.resource.SubResource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

public class ResourceVariableProcessor {

    private static Log log = LogFactory.getLog(ResourceVariableProcessor.class);

    public void process() {

            List<RootResource> rootResourceList = InformationRepository.getInstance().getRootResources();

            for (RootResource rootResource : rootResourceList) {

                for (SubResource subResource : rootResource.getSubResources()) {


                    Method selectedMethod = subResource.getReflectionMethod();
                    final Class[] paramTypes = selectedMethod.getParameterTypes();

                    final Annotation[][] paramAnnotations = selectedMethod.getParameterAnnotations();


                    for (int i = 0; i < paramAnnotations.length; i++) {

                        boolean pathParam = false;
                        boolean queryParam = false;
                        boolean headerParam = false;
                        boolean mandatory = false;
                        String name = null;
                        String parameterDetail = null;

                        for (Annotation annotation : paramAnnotations[i]) {

                            if (annotation instanceof PathParam) {
                                name = ((PathParam) annotation).value();
                                pathParam = true;

                            } else if (annotation instanceof QueryParam) {

                                name = ((QueryParam) annotation).value();
                                queryParam = true;

                            } else if (annotation instanceof HeaderParam) {

                                name = ((HeaderParam) annotation).value();
                                headerParam = true;

                            } else if (annotation instanceof M) {
                                mandatory = true;
                            } else if (annotation instanceof ParameterDetail) {
                                parameterDetail =  ((ParameterDetail) annotation).value();
                            }
                        }

                        if (!pathParam && !headerParam && !queryParam) {
                            subResource.setRequestBody(paramTypes[i]);
                        }

                        constructPathVariableContext(name, pathParam, parameterDetail, paramTypes[i], subResource);
                        constructQueryVariableContext(name, queryParam, parameterDetail, mandatory, paramTypes[i], subResource);
                        constructHeaderVariableContext(name, headerParam, parameterDetail, mandatory, paramTypes[i], subResource);

                    }

                }
            }


    }

    private void constructPathVariableContext(String name, boolean pathParam, String parameterDetail, Class type, SubResource subResource ) {

        if(pathParam) {

            PathVariableMetaData pathVariableMetaData = new PathVariableMetaData(name, true, type.getSimpleName(), parameterDetail);
            subResource.addPathVariableMetaData(pathVariableMetaData);
        }


    }


    private void constructQueryVariableContext(String name, boolean queryParam, String parameterDetail, boolean mandatory, Class type, SubResource subResource ) {

        if(queryParam) {

            QueryVariableMetaData queryVariableMetaData = new QueryVariableMetaData(name, mandatory, type.getSimpleName(), parameterDetail);
            subResource.addQueryVariableMetaData(queryVariableMetaData);
        }


    }

    private void constructHeaderVariableContext(String name, boolean headerParam, String parameterDetail, boolean mandatory, Class type, SubResource subResource ) {

        if(headerParam) {

            HeaderVariableMetaData headerVariableMetaData = new HeaderVariableMetaData(name, mandatory, type.getSimpleName(), parameterDetail);
            subResource.addHeaderVariableMetaData(headerVariableMetaData);
        }


    }


}
