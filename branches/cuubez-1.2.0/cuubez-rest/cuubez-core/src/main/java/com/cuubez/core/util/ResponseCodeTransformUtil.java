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
package com.cuubez.core.util;

import com.cuubez.core.context.MessageContext;
import com.cuubez.core.exception.CuubezException;
import com.cuubez.core.exception.CuubezExceptionConstance;

import javax.servlet.http.HttpServletResponse;

public class ResponseCodeTransformUtil {

    public static void transform(MessageContext messageContext, CuubezException e) {

        int responseCode;
        String responseMessage;

        if(e.getResponseCode() != 0) {
            responseCode = e.getResponseCode();
            responseMessage = e.getMessage();

        } else if(e.getMessage().equals(CuubezExceptionConstance.RESOURCE_NOT_FOUND)) {
            responseCode = HttpServletResponse.SC_NOT_FOUND;
            responseMessage = e.getMessage();
        } else if(e.getMessage().equals(CuubezExceptionConstance.INVALID_URI) ||  e.getMessage().equals(CuubezExceptionConstance.ILLEGAL_ARGUMENT_EXCEPTION)){
            responseCode = HttpServletResponse.SC_BAD_REQUEST;
            responseMessage = e.getMessage();
        } else if(e.getMessage().equals(CuubezExceptionConstance.UNSUPPORTED_MEDIA_TYPE)) {
            responseCode = HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE;
            responseMessage = e.getMessage();
        } else {
            responseCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
            responseMessage = e.getMessage();
        }

        messageContext.getResponseContext().setResponseCode(responseCode);
        messageContext.getResponseContext().setResponseMessage(responseMessage);

    }
}
