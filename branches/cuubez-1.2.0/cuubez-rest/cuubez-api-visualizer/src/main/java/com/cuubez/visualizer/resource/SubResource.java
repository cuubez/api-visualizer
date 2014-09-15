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
package com.cuubez.visualizer.resource;


import com.cuubez.visualizer.context.HeaderVariableMetaData;
import com.cuubez.visualizer.context.MethodMetaData;
import com.cuubez.visualizer.context.PathVariableMetaData;
import com.cuubez.visualizer.context.QueryVariableMetaData;

import java.util.ArrayList;
import java.util.List;

public class SubResource {

    private MethodMetaData methodMetaData = null;
    private List<PathVariableMetaData> pathVariableMetaDataList = null;
    private List<QueryVariableMetaData> queryVariableMetaDataList = null;
    private List<HeaderVariableMetaData> headerVariableMetaDataList = null;
    private Class<?> requestBody;

    public MethodMetaData getMethodMetaData() {
        return methodMetaData;
    }

    public void setMethodMetaData(MethodMetaData methodMetaData) {
        this.methodMetaData = methodMetaData;
    }

    public List<PathVariableMetaData> getPathVariableMetaDataList() {
        return pathVariableMetaDataList;
    }

    public void addPathVariableMetaData(PathVariableMetaData pathVariableMetaData) {

        if(this.pathVariableMetaDataList == null) {
            this.pathVariableMetaDataList = new ArrayList<PathVariableMetaData>();
        }

        this.pathVariableMetaDataList.add(pathVariableMetaData);
    }

    public List<QueryVariableMetaData> getQueryVariableMetaDataList() {
        return queryVariableMetaDataList;
    }

    public void addQueryVariableMetaData(QueryVariableMetaData queryVariableMetaData) {

        if(this.queryVariableMetaDataList == null) {
            this.queryVariableMetaDataList = new ArrayList<QueryVariableMetaData>();
        }

        this.queryVariableMetaDataList.add(queryVariableMetaData);
    }

    public List<HeaderVariableMetaData> getHeaderVariableMetaDataList() {
        return headerVariableMetaDataList;
    }

    public void addHeaderVariableMetaData(HeaderVariableMetaData headerVariableMetaData) {

        if(this.headerVariableMetaDataList == null) {
            this.headerVariableMetaDataList = new ArrayList<HeaderVariableMetaData>();
        }

        this.headerVariableMetaDataList.add(headerVariableMetaData);
    }

    public Class<?> getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(Class<?> requestBody) {
        this.requestBody = requestBody;
    }
}
