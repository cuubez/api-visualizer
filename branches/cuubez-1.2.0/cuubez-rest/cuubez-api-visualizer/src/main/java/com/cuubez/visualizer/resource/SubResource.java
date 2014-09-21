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


import com.cuubez.visualizer.domain.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SubResource {

    private String path;
    private String name;
    private String detail;
    private String[] consume;
    private String[] produce;
    private Class<?> clazz;
    private String httpMethod;
    private Class<?> returnType = null;
    private Class<?> inputObjectType;
    private int inputObjectIndex;
    private Object[] parameters;
    private Class<?> requestBody;
    private List<HttpCodeMetaData> httpCodeMetaDataList;
    private List<PathVariableMetaData> pathVariableMetaDataList = null;
    private List<QueryVariableMetaData> queryVariableMetaDataList = null;
    private List<HeaderVariableMetaData> headerVariableMetaDataList = null;
    private Method reflectionMethod;



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

    public Method getReflectionMethod() {
        return reflectionMethod;
    }
    public void setReflectionMethod(Method reflectionMethod) {
        this.reflectionMethod = reflectionMethod;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String[] getConsume() {
        return consume;
    }

    public void setConsume(String[] consume) {
        this.consume = consume;
    }

    public String[] getProduce() {
        return produce;
    }

    public void setProduce(String[] produce) {
        this.produce = produce;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public void setReturnType(Class<?> returnType) {
        this.returnType = returnType;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public int getInputObjectIndex() {
        return inputObjectIndex;
    }

    public void setInputObjectIndex(int inputObjectIndex) {
        this.inputObjectIndex = inputObjectIndex;
    }

    public Class<?> getInputObjectType() {
        return inputObjectType;
    }

    public void setInputObjectType(Class<?> inputObjectType) {
        this.inputObjectType = inputObjectType;
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

    public List<HttpCodeMetaData> getHttpCodeMetaDataList() {
        return httpCodeMetaDataList;
    }

    public void setHttpCodeMetaDataList(List<HttpCodeMetaData> httpCodeMetaDataList) {
        this.httpCodeMetaDataList = httpCodeMetaDataList;
    }
}
