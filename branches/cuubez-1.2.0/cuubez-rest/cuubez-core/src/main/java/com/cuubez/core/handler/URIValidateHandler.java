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


import com.cuubez.core.context.ApplicationConfigurationContext;
import com.cuubez.core.context.MessageContext;
import com.cuubez.core.exception.CuubezException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;

public class URIValidateHandler implements RequestHandler {

    private static Log log = LogFactory.getLog(URIValidateHandler.class);

    private static String PARAMETER_SEPARATOR = "&";
    private static String PATH_SEPARATOR = "/";


    public void handleRequest(MessageContext messageContext) throws CuubezException {

        log.trace("URI validation process started");
        String applicationName = ApplicationConfigurationContext.getInstance().getApplicationName();
        HttpServletRequest request = messageContext.getRequestConfigurationContext().getRequest();

        String uri = request.getRequestURI();

        if (uri.endsWith(PATH_SEPARATOR)) {
            uri = uri.substring(0, uri.length() - 1);
        }

        int startIndexOf = uri.indexOf(applicationName);

        if(startIndexOf == -1) {
            log.error("Invalid request URI");
            throw new CuubezException(CuubezException.INVALID_URI);
        }

        String resourceURI = uri.substring(startIndexOf+applicationName.length());

        if (resourceURI.startsWith(PARAMETER_SEPARATOR) || resourceURI.isEmpty()) {
            log.error("Invalid request URI");
            throw new CuubezException(CuubezException.INVALID_URI);
        }
    }

}
