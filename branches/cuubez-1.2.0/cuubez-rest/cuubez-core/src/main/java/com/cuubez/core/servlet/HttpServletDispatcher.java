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
package com.cuubez.core.servlet;

import com.cuubez.core.initiator.ServletContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;


public class HttpServletDispatcher extends ServletContainer {


    private static final long serialVersionUID = 5810807706716748267L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        super.process(req, resp, HttpMethod.POST);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        super.process(req, resp, HttpMethod.GET);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        super.process(req, resp, HttpMethod.PUT);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        super.process(req, resp, HttpMethod.DELETE);
    }

}
