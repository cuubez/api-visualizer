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
package com.cuubez.visualizer.domain.configuration;


import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

public class Resource {

    private String path;
    private String name;
    @XStreamAlias("http-method")
    private String httpMethod;
    private String detail;
    @XStreamAlias("http-codes")
    private List<HttpCode> httpCodes;
    private List<Variable> variables;
    @XStreamAlias("request-body-type")
    private String requestBodyType;
    @XStreamAlias("response-body-type")
    private String responseBodyType;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<HttpCode> getHttpCodes() {
        return httpCodes;
    }

    public void setHttpCodes(List<HttpCode> httpCodes) {
        this.httpCodes = httpCodes;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    public String getRequestBodyType() {
        return requestBodyType;
    }

    public void setRequestBodyType(String requestBodyType) {
        this.requestBodyType = requestBodyType;
    }

    public String getResponseBodyType() {
        return responseBodyType;
    }

    public void setResponseBodyType(String responseBodyType) {
        this.responseBodyType = responseBodyType;
    }
}
