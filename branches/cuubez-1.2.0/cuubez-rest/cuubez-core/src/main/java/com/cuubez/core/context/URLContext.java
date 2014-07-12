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

import com.cuubez.core.resource.metaData.HeaderVariableMetaData;
import com.cuubez.core.resource.metaData.PathVariableMetaData;
import com.cuubez.core.resource.metaData.QueryVariableMetaData;

import java.util.ArrayList;
import java.util.List;

public class URLContext {

    private String servletPath;
    private String pathInfo;
    private StringBuffer requestURL;
    private String requestURI;
    private String serviceLocation;
    private String mediaType;
    private List<QueryVariableMetaData> queryVariableMetaDataList;
    private List<PathVariableMetaData> pathVariableMetaDataList;
    private List<HeaderVariableMetaData> headerVariableMetaDataList;


    public String getServiceLocation() {
        return serviceLocation;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getPathInfo() {
        return pathInfo;
    }

    public void setPathInfo(String pathInfo) {
        this.pathInfo = pathInfo;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public StringBuffer getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(StringBuffer requestURL) {
        this.requestURL = requestURL;
    }

    public String getServletPath() {
        return servletPath;
    }

    public void setServletPath(String servletPath) {
        this.servletPath = servletPath;
    }

    public List<QueryVariableMetaData> getQueryVariableMetaDataList() {
        return queryVariableMetaDataList;
    }

    public void addQueryVariableMetaData(String name, String value) {

        if(this.queryVariableMetaDataList == null) {
            this.queryVariableMetaDataList = new ArrayList<QueryVariableMetaData>();
        }

        QueryVariableMetaData queryVariableMetaData = new QueryVariableMetaData(name, value);

        this.queryVariableMetaDataList.add(queryVariableMetaData);
    }

    public void setQueryVariableMetaDataList(List<QueryVariableMetaData> queryVariableMetaDataList) {
         this.queryVariableMetaDataList = queryVariableMetaDataList;
    }

    public List<HeaderVariableMetaData> getHeaderVariableMetaDataList() {
        return headerVariableMetaDataList;
    }

    public void addHeaderVariableMetaData(String name, String value) {

        if(this.headerVariableMetaDataList == null) {
          this.headerVariableMetaDataList = new ArrayList<HeaderVariableMetaData>();
        }

        HeaderVariableMetaData headerVariableMetaData = new HeaderVariableMetaData(name, value);

        this.headerVariableMetaDataList.add(headerVariableMetaData);
    }

    public List<PathVariableMetaData> getPathVariableMetaDataList() {
        return pathVariableMetaDataList;
    }

    public void setPathVariableMetaDataList(List<PathVariableMetaData> pathVariableMetaDataList) {
        this.pathVariableMetaDataList = pathVariableMetaDataList;
    }


}
