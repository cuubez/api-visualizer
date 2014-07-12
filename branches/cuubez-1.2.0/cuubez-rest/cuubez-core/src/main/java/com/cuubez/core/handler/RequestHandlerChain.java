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

public class RequestHandlerChain {

    public void doChain(MessageContext messageContext)throws CuubezException{

        RequestHandler requestHandlerContextInitiate = new RequestContextInitiateHandler();
        requestHandlerContextInitiate.handleRequest(messageContext);

        RequestHandler uriValidateHandler = new URIValidateHandler();
        uriValidateHandler.handleRequest(messageContext);

        RequestHandler uriNormalizeHandler = new URINormalizeHandler();
        uriNormalizeHandler.handleRequest(messageContext);

        RequestContextInitiateHandler requestContextInitiateHandler = new RequestContextInitiateHandler();
        requestContextInitiateHandler.handleRequest(messageContext);

        HeaderParameterPopulateHandler headerParameterHandler = new HeaderParameterPopulateHandler();
        headerParameterHandler.handleRequest(messageContext);

        QueryParameterPopulateHandler queryParameterHandler = new QueryParameterPopulateHandler();
        queryParameterHandler.handleRequest(messageContext);

        ResourceSearchHandler resourceSearchHandler = new ResourceSearchHandler();
        resourceSearchHandler.handleRequest(messageContext);

        InterceptorProcessHandler interceptorProcessHandler = new InterceptorProcessHandler();
        interceptorProcessHandler.handleRequest(messageContext);

        InvocationParametersHandler invocationParametersHandler = new InvocationParametersHandler();
        invocationParametersHandler.handleRequest(messageContext);

        RequestTransformHandler requestTransformHandler = new RequestTransformHandler();
        requestTransformHandler.handleRequest(messageContext);

        ResourceInvokeHandler resourceInvokeHandler = new ResourceInvokeHandler();
        resourceInvokeHandler.handleRequest(messageContext);

    }
}
