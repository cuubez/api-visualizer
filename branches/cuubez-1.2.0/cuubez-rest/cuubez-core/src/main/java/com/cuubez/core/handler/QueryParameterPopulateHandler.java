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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;


public class QueryParameterPopulateHandler implements RequestHandler {

    private static Log log = LogFactory.getLog(QueryParameterPopulateHandler.class);


    private static String PARAMETER_SEPARATOR = "&";
    private static String NAME_VALUE_SEPARATOR = "=";


    public void handleRequest(MessageContext messageContext) throws CuubezException {

        HttpServletRequest httpServletRequest = messageContext.getRequestConfigurationContext().getRequest();
        String queryString = httpServletRequest.getQueryString();

        log.trace("query parameter populate process started");

        if (queryString != null) {

            if (queryString.contains(PARAMETER_SEPARATOR)) {

                String[] queryParameters = queryString.split(PARAMETER_SEPARATOR);

                for (String queryParameter : queryParameters) {

                    String[] queryParam = queryParameter.split(NAME_VALUE_SEPARATOR);
                    messageContext.getRequestContext().getUrlContext().addQueryVariableMetaData(queryParam[0], queryParam[1]);


                }


            } else {

                String[] queryParam = queryString.split(NAME_VALUE_SEPARATOR);
                if(queryParam.length == 2) {
                    messageContext.getRequestContext().getUrlContext().addQueryVariableMetaData(queryParam[0], queryParam[1]);
                }

            }


        }
    }
}
