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
package com.cuubez.core.initiator;


import com.cuubez.core.context.MessageContext;
import com.cuubez.core.context.RequestConfigurationContext;
import com.cuubez.core.context.RequestContext;
import com.cuubez.core.context.ResponseContext;
import com.cuubez.core.exception.CuubezException;
import com.cuubez.core.handler.RequestHandlerChain;
import com.cuubez.core.handler.ResponseHandlerChain;
import com.cuubez.core.util.ResponseCodeTransformUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;

public class ServiceProcessInitiator {

    private static Log log = LogFactory.getLog(ServiceProcessInitiator.class);

    public ResponseContext process(HttpServletRequest request, String httpMethod) {

        log.trace("service processing started");

        RequestConfigurationContext requestConfigurationContext = new RequestConfigurationContext(httpMethod, request);
        MessageContext messageContext = new MessageContext();
        messageContext.setRequestContext(new RequestContext());
        messageContext.setResponseContext(new ResponseContext());
        messageContext.setRequestConfigurationContext(requestConfigurationContext);

        RequestHandlerChain requestHandlerChain = new RequestHandlerChain();
        ResponseHandlerChain responseHandlerChain = new ResponseHandlerChain();


        try {

            requestHandlerChain.doChain(messageContext);
            responseHandlerChain.doChain(messageContext);


        } catch (CuubezException e) {
            ResponseCodeTransformUtil.transform(messageContext, e);
        }


        return messageContext.getResponseContext();
    }


}
