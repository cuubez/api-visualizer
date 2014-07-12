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
package com.cuubez.core.context;

import com.cuubez.core.resource.metaData.SelectedResourceMetaData;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HttpMethod;

public class RequestContext extends Context {

    private URLContext urlContext;
    private String httpMethod;
    private SelectedResourceMetaData selectedResource;

    public URLContext getUrlContext() {
        return urlContext;
    }

    public void setUrlContext(URLContext urlContext) {
        this.urlContext = urlContext;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public SelectedResourceMetaData getSelectedResource() {
        return selectedResource;
    }

    public void setSelectedResource(SelectedResourceMetaData selectedResource) {
        this.selectedResource = selectedResource;
    }

}
 