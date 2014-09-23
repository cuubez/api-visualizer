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
package com.cuubez.visualizer.domain;


import java.util.List;

public class ApiMetaData {

    public String id;
    public String httpMethod;
    public String path;
    public String name;
    public String detail;
    public String requestBody;
    public String responseBody;
    public List<PathVariableMetaData> pathVariableMetaDataList;
    public List<QueryVariableMetaData> queryVariableMetaDataList;
    public List<HeaderVariableMetaData> headerVariableMetaDataList;
    public List<HttpCodeMetaData> httpCodeMetaDataList;
    public boolean requestContain = true;
    public boolean responseContain = true;

    public ApiMetaData(String id, String httpMethod, String path) {
        this.id = id;
        this.httpMethod = httpMethod;
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<PathVariableMetaData> getPathVariableMetaDataList() {
        return pathVariableMetaDataList;
    }

    public void setPathVariableMetaDataList(List<PathVariableMetaData> pathVariableMetaDataList) {
        this.pathVariableMetaDataList = pathVariableMetaDataList;
    }

    public List<HeaderVariableMetaData> getHeaderVariableMetaDataList() {
        return headerVariableMetaDataList;
    }

    public void setHeaderVariableMetaDataList(List<HeaderVariableMetaData> headerVariableMetaDataList) {
        this.headerVariableMetaDataList = headerVariableMetaDataList;
    }

    public List<QueryVariableMetaData> getQueryVariableMetaDataList() {
        return queryVariableMetaDataList;
    }

    public void setQueryVariableMetaDataList(List<QueryVariableMetaData> queryVariableMetaDataList) {
        this.queryVariableMetaDataList = queryVariableMetaDataList;
    }

    public boolean isRequestContentAvailable() {

        if((pathVariableMetaDataList != null && pathVariableMetaDataList.size() > 0) || (queryVariableMetaDataList != null && queryVariableMetaDataList.size() > 0) || (headerVariableMetaDataList != null && headerVariableMetaDataList.size() > 0)) {
            return true;
        }

        return false;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public List<HttpCodeMetaData> getHttpCodeMetaDataList() {
        return httpCodeMetaDataList;
    }

    public void setHttpCodeMetaDataList(List<HttpCodeMetaData> httpCodeMetaDataList) {
        this.httpCodeMetaDataList = httpCodeMetaDataList;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public boolean isRequestContain() {
        return requestContain;
    }

    public void setRequestContain(boolean requestContain) {
        this.requestContain = requestContain;
    }

    public boolean isResponseContain() {
        return responseContain;
    }

    public void setResponseContain(boolean responseContain) {
        this.responseContain = responseContain;
    }
}
