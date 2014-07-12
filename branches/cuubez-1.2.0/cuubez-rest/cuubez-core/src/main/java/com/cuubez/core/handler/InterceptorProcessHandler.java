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


import com.cuubez.core.context.InterceptorRequestContext;
import com.cuubez.core.context.InterceptorResponseContext;
import com.cuubez.core.context.MessageContext;
import com.cuubez.core.exception.CuubezException;
import com.cuubez.core.exception.CuubezExceptionConstance;
import com.cuubez.core.resource.InterceptorProvider;
import com.cuubez.core.resource.ResourceRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class InterceptorProcessHandler implements RequestHandler {

    private static Log log = LogFactory.getLog(InterceptorProcessHandler.class);

    public void handleRequest(MessageContext messageContext) throws CuubezException {

        final String INTERCEPTOR_METHOD_NAME = "process";

        List<InterceptorProvider> interceptorProviders = ResourceRepository.getInstance().getInterceptorProviders();
        InterceptorRequestContext interceptorRequestContext = populateRequest(messageContext);

        for (InterceptorProvider interceptorProvider : interceptorProviders) {

            Class<?> clazz = interceptorProvider.getClazz();
            Object returnObject = null;

            try {

                Object obj = clazz.newInstance();
                Method selectedMethod = clazz.getDeclaredMethod(INTERCEPTOR_METHOD_NAME, InterceptorRequestContext.class);
                returnObject = selectedMethod.invoke(obj, interceptorRequestContext);

                if (returnObject != null) {
                    InterceptorResponseContext interceptorResponseContext = (InterceptorResponseContext) returnObject;
                    log.error(interceptorResponseContext.getMessage());
                    throw new CuubezException(interceptorResponseContext.getMessage(), interceptorResponseContext.getCode());
                }

            } catch (IllegalAccessException e) {
                log.error(e);
                throw new CuubezException(CuubezExceptionConstance.INVOCATION_EXCEPTION);
            } catch (InvocationTargetException e) {
                log.error("Exception occurred while try to invoke interceptor ", e);
                throw new CuubezException(CuubezExceptionConstance.INVOCATION_EXCEPTION);
            } catch (NoSuchMethodException e) {
                log.error(e);
                throw new CuubezException(CuubezExceptionConstance.INVOCATION_EXCEPTION);
            } catch (InstantiationException e) {
                log.error(e);
                throw new CuubezException(CuubezExceptionConstance.INVOCATION_EXCEPTION);
            }

        }

    }

    private InterceptorRequestContext populateRequest(MessageContext messageContext) {

        String httpMethod = messageContext.getRequestConfigurationContext().getHttpMethod();
        HttpServletRequest request = messageContext.getRequestConfigurationContext().getRequest();
        Class<?> clazz = messageContext.getRequestContext().getSelectedResource().getSelectedMethodMetaData().getClazz();
        Method method = messageContext.getRequestContext().getSelectedResource().getSelectedMethodMetaData().getReflectionMethod();

        InterceptorRequestContext interceptorRequestContext = new InterceptorRequestContext(request, httpMethod, clazz, method);

        return interceptorRequestContext;
    }

}
