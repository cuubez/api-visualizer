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

import java.lang.reflect.InvocationTargetException;

import com.cuubez.core.context.MessageContext;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.cuubez.core.exception.CuubezExceptionConstance;
import com.cuubez.core.resource.metaData.SelectedResourceMetaData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cuubez.core.exception.CuubezException;



public class ResourceInvokeHandler implements RequestHandler {

    private static Log log = LogFactory.getLog(ResourceInvokeHandler.class);


    public void handleRequest(MessageContext messageContext) throws CuubezException {

        SelectedResourceMetaData selectedResourceMetaData = messageContext.getRequestContext().getSelectedResource();

        log.trace("resource invocation process started");
        try {

            Object[] arguments = getResourceArguments(selectedResourceMetaData);
            Class<?> cls = selectedResourceMetaData.getSelectedMethodMetaData().getClazz();
            Object obj = cls.newInstance();
            java.lang.reflect.Method selectedMethod = selectedResourceMetaData.getSelectedMethodMetaData().getReflectionMethod();
            validateArguments(selectedMethod, arguments);
            Object returnObject = selectedMethod.invoke(obj, arguments);

            if (selectedMethod.getReturnType().equals(Void.TYPE)) {

                messageContext.getResponseContext().setResponseCode(HttpServletResponse.SC_NO_CONTENT);

            } else if (returnObject != null) {
                messageContext.getResponseContext().setReturnObject(returnObject);
                messageContext.getResponseContext().setMediaType(populateResponseMediaType(selectedResourceMetaData.getSelectedMethodMetaData().getProduce(), messageContext.getRequestContext().getUrlContext().getMediaType()));
            }


        } catch (InvocationTargetException e) {
            log.error(e);
            throw new CuubezException(CuubezExceptionConstance.INVOCATION_EXCEPTION);
        } catch (InstantiationException e) {
            log.error(e);
            throw new CuubezException(CuubezExceptionConstance.INVOCATION_EXCEPTION);
        } catch (IllegalAccessException e) {
            log.error(e);
            throw new CuubezException(CuubezExceptionConstance.INVOCATION_EXCEPTION);
        } catch (SecurityException e) {
            log.error(e);
            throw new CuubezException(CuubezExceptionConstance.INVOCATION_EXCEPTION);
        } catch (IllegalArgumentException e) {
            log.error(e);
            throw new CuubezException(CuubezExceptionConstance.ILLEGAL_ARGUMENT_EXCEPTION);
        }

    }

    private boolean validateArguments(java.lang.reflect.Method selectedMethod, Object[] arguments) {

        return true; //TODO need to implement
    }

    private Object[] getResourceArguments(SelectedResourceMetaData selectedResourceMetaData) {
        return selectedResourceMetaData.getSelectedMethodMetaData().getParameters();
    }

    private String populateResponseMediaType(String[] produceMediaTypes, String requestMediaType) throws CuubezException {

        if (requestMediaType == null && isNotSpecifyMediaType(produceMediaTypes)) {

            return MediaType.APPLICATION_XML;

        } else if (requestMediaType == null && !isNotSpecifyMediaType(produceMediaTypes)) {

            return produceMediaTypes[0];

        } else if (requestMediaType != null && !isNotSpecifyMediaType(produceMediaTypes)) {

            for (String produceMediaType : produceMediaTypes) {

                if (requestMediaType.equals(produceMediaType)) {
                    return requestMediaType;
                }
            }

        } else {
            log.error("unsupported response media type");
            throw new CuubezException(CuubezExceptionConstance.UNSUPPORTED_MEDIA_TYPE);
        }

        log.error("unsupported response media type");
        throw new CuubezException(CuubezExceptionConstance.UNSUPPORTED_MEDIA_TYPE);
    }


    private boolean isNotSpecifyMediaType(String[] produce) {

        if (produce == null || produce.length == 0 || (produce.length == 1 && produce[0] == "*/*")) {

            return true;

        }

        return false;

    }


}
