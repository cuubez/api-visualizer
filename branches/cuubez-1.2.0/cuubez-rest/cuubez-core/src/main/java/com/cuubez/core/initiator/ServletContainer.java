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

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cuubez.core.context.ResponseContext;
import com.cuubez.core.exception.CuubezExceptionConstance;
import com.cuubez.core.io.Connection;
import com.cuubez.core.io.HttpConnection;

import java.util.Map;


public class ServletContainer extends HttpServlet {

    private static final long serialVersionUID = 5466841407373731970L;

    protected void process(HttpServletRequest request, HttpServletResponse response, String httpMethod) {

        ResponseContext responseContext = new ServiceProcessInitiator().process(request, httpMethod);

        populateHeaderValues(response, responseContext);

        if (responseContext != null && responseContext.getContent() != null && responseContext.getResponseCode() == HttpServletResponse.SC_OK) {
            writeResponse(request, response, responseContext);
        } else {
            response.setStatus(responseContext.getResponseCode());
        }
    }


    public void writeResponse(HttpServletRequest request, HttpServletResponse response, ResponseContext responseContext) {

        Connection connection = new HttpConnection();
        connection.write(request, response, responseContext);
    }


    private void populateHeaderValues(HttpServletResponse response, ResponseContext responseContext) {

        Map<String, String> headerValues = responseContext.getHeaderValues();

        if (headerValues != null) {

            for (String name : headerValues.keySet()) {

                response.addHeader(name, headerValues.get(name));
            }


        }

    }


}
