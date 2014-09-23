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
package com.cuubez.visualizer.processor;


import com.cuubez.visualizer.annotation.*;
import com.cuubez.visualizer.domain.*;
import com.cuubez.visualizer.domain.configuration.*;
import com.cuubez.visualizer.domain.configuration.Group;
import com.cuubez.visualizer.domain.configuration.HttpCode;
import com.cuubez.visualizer.resource.InformationRepository;
import com.cuubez.visualizer.resource.RootResource;
import com.cuubez.visualizer.resource.SubResource;
import com.cuubez.visualizer.util.CuubezUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiMetaDataProcessor {

    private static Log log = LogFactory.getLog(ApiMetaDataProcessor.class);
    private static final String DEFAULT_HEADER = "API Documentation";
    private static final String DEFAULT_TITTLE = "API Documentation";

    Map<String, ApiGroupMetaData> apiMetaDataMap = new HashMap<String, ApiGroupMetaData>();

    public void process() {

        ConfigurationType configurationType = InformationRepository.getInstance().getApplicationConfigurationContext().getConfigurationType();

        if(configurationType.equals(ConfigurationType.XML)) {
            xmlConfigurationProcess();
        } else {
            annotationProcess();
        }

    }

    private void annotationProcess() {


        List<RootResource> rootResourceList = InformationRepository.getInstance().getRootResources();

        for (RootResource rootResource : rootResourceList) {

            for (SubResource subResource : rootResource.getSubResources()) {

                String path = CuubezUtil.constructApiPath(rootResource.getPath(), subResource.getPath());

                ApiMetaData apiMetaData = new ApiMetaData(CuubezUtil.generateRandomString(), subResource.getHttpMethod(), path);
                apiMetaData.setName(CuubezUtil.getName(rootResource.getName(), subResource.getName()));
                apiMetaData.setDetail(CuubezUtil.getDetail(rootResource.getDetail(), subResource.getDetail()));
                apiMetaData.setPathVariableMetaDataList(subResource.getPathVariableMetaDataList());
                apiMetaData.setQueryVariableMetaDataList(subResource.getQueryVariableMetaDataList());
                apiMetaData.setHeaderVariableMetaDataList(subResource.getHeaderVariableMetaDataList());
                if(subResource.getRequestBody() != null) {
                    apiMetaData.setRequestBody(CuubezUtil.generateJsonSchema(subResource.getRequestBody()));
                }
                apiMetaData.setHttpCodeMetaDataList(CuubezUtil.getHttpCodes(rootResource.getHttpCodeMetaDataList(), subResource.getHttpCodeMetaDataList()));

                if(subResource.getReturnType() != null) {
                    apiMetaData.setResponseBody(CuubezUtil.generateJsonSchema(subResource.getReturnType()));
                }

                if(!CuubezUtil.isNullOrEmpty(rootResource.getGroupName())) {
                    finalizeApiMetaData(apiMetaData);
                    addSubResource(rootResource.getGroupName(), rootResource.getGroupTittle(), apiMetaData);
                }
            }


        }

        ApiMetaDataInformation apiMetaDataInformation = new ApiMetaDataInformation();
        apiMetaDataInformation.setApiMetaData(apiMetaDataMap);
        populateDisplayConfiguration(apiMetaDataInformation);
        InformationRepository.getInstance().setApiMetaData(apiMetaDataInformation);


    }


    private void xmlConfigurationProcess() {

       Configuration configuration = InformationRepository.getInstance().getConfiguration();

        if (configuration != null) {

           List<Group> groups = configuration.getGroups();

            if(groups != null) {

                for (Group group : groups) {

                    List<Resource> resources = group.getResources();

                    if (resources != null) {

                        for (Resource resource : resources)  {

                            ApiMetaData apiMetaData = new ApiMetaData(CuubezUtil.generateRandomString(), resource.getHttpMethod(), resource.getPath());

                            apiMetaData.setName(resource.getName());
                            apiMetaData.setDetail(resource.getDetail());
                            apiMetaData.setPathVariableMetaDataList(getPathVariableMetaDataList(resource.getVariables()));
                            apiMetaData.setQueryVariableMetaDataList(getQueryVariableMetaDataList(resource.getVariables()));
                            apiMetaData.setHeaderVariableMetaDataList(getHeaderVariableMetaDataList(resource.getVariables()));
                            if(resource.getRequestBodyType() != null) {
                                try {
                                    Class requestType = Class.forName(resource.getRequestBodyType());
                                    apiMetaData.setRequestBody(CuubezUtil.generateJsonSchema(requestType));
                                } catch (ClassNotFoundException e) {
                                    log.error("Request body type class ["+resource.getRequestBodyType()+"] not found", e);
                                }

                            }

                            if(resource.getResponseBodyType() != null) {
                                try {
                                    Class responseType = Class.forName(resource.getResponseBodyType());
                                    apiMetaData.setResponseBody(CuubezUtil.generateJsonSchema(responseType));
                                } catch (ClassNotFoundException e) {
                                    log.error("Response body type class ["+resource.getRequestBodyType()+"] not found", e);
                                }
                            }


                            apiMetaData.setHttpCodeMetaDataList(CuubezUtil.getHttpCodes(getHttpCodeMetaDataList(group.getHttpCodes()), getHttpCodeMetaDataList(resource.getHttpCodes())));
                            finalizeApiMetaData(apiMetaData);
                            addSubResource(group.getName(), group.getTitle(), apiMetaData);
                            ApiMetaDataInformation apiMetaDataInformation = new ApiMetaDataInformation();
                            apiMetaDataInformation.setApiMetaData(apiMetaDataMap);
                            populateDisplayConfiguration(apiMetaDataInformation);
                            InformationRepository.getInstance().setApiMetaData(apiMetaDataInformation);

                        }
                    }

                }

            }

        }

    }

    private void finalizeApiMetaData(ApiMetaData apiMetaData) {
        List<PathVariableMetaData> pathVariableMetaDataList = apiMetaData.getPathVariableMetaDataList();
        List<QueryVariableMetaData> queryVariableMetaDataList = apiMetaData.getQueryVariableMetaDataList();
        List<HeaderVariableMetaData> headerVariableMetaDataList = apiMetaData.getHeaderVariableMetaDataList();
        String requestBody = apiMetaData.getRequestBody();
        String responseBody = apiMetaData.getResponseBody();

        if((pathVariableMetaDataList == null || pathVariableMetaDataList.isEmpty()) && (queryVariableMetaDataList == null || queryVariableMetaDataList.isEmpty())
                && (headerVariableMetaDataList == null || headerVariableMetaDataList.isEmpty()) && CuubezUtil.isNullOrEmpty(requestBody)) {
            apiMetaData.setRequestContain(false);
        }

        if(CuubezUtil.isNullOrEmpty(responseBody)) {
            apiMetaData.setResponseContain(false);
        }
    }

    private List<PathVariableMetaData> getPathVariableMetaDataList(List<Variable> variables) {

        if (variables == null) {
            return null;
        }

        List<PathVariableMetaData> pathVariableMetaDataList = new ArrayList<PathVariableMetaData>();

        for (Variable variable : variables) {
            if("path".equalsIgnoreCase(variable.getParameterType())) {
                PathVariableMetaData pathVariableMetaData = new PathVariableMetaData(variable.getName(), variable.isMandatory(), variable.getVariableType(),variable.getDescription());
                pathVariableMetaDataList.add(pathVariableMetaData);
            }
        }

        return pathVariableMetaDataList;
    }

    private List<QueryVariableMetaData> getQueryVariableMetaDataList(List<Variable> variables) {

        if (variables == null) {
            return null;
        }

        List<QueryVariableMetaData> queryVariableMetaDataList = new ArrayList<QueryVariableMetaData>();

        for (Variable variable : variables) {
            if("query".equalsIgnoreCase(variable.getParameterType())) {
                QueryVariableMetaData queryVariableMetaData = new QueryVariableMetaData(variable.getName(), variable.isMandatory(), variable.getVariableType(),variable.getDescription());
                queryVariableMetaDataList.add(queryVariableMetaData);
            }
        }

        return queryVariableMetaDataList;
    }

    private List<HeaderVariableMetaData> getHeaderVariableMetaDataList(List<Variable> variables) {

        if (variables == null) {
            return null;
        }

        List<HeaderVariableMetaData> headerVariableMetaDataList = new ArrayList<HeaderVariableMetaData>();

        for (Variable variable : variables) {
            if("header".equalsIgnoreCase(variable.getParameterType())) {
                HeaderVariableMetaData headerVariableMetaData = new HeaderVariableMetaData(variable.getName(), variable.isMandatory(), variable.getVariableType(),variable.getDescription());
                headerVariableMetaDataList.add(headerVariableMetaData);
            }
        }

        return headerVariableMetaDataList;
    }

    private List<HttpCodeMetaData> getHttpCodeMetaDataList(List<HttpCode> httpCodes) {

        if(httpCodes == null) {
            return null;
        }

        List<HttpCodeMetaData> httpCodeMetaDataList = new ArrayList<HttpCodeMetaData>();

        for (HttpCode httpCode : httpCodes) {

            HttpCodeMetaData httpCodeMetaData = new HttpCodeMetaData(String.valueOf(httpCode.getCode()), httpCode.getReason());
            httpCodeMetaDataList.add(httpCodeMetaData);
        }

      return httpCodeMetaDataList;
    }

    private void addSubResource(String groupName, String groupTittle, ApiMetaData apiMetaData) {

        if(apiMetaDataMap.get(groupName) == null) {
            ApiGroupMetaData groupMetaData = new ApiGroupMetaData();
            groupMetaData.setGroupName(groupName);
            groupMetaData.setGroupTittle(groupTittle);
            groupMetaData.setApiMetaDataList(new ArrayList<ApiMetaData>());
            apiMetaDataMap.put(groupName, groupMetaData);
        }

        apiMetaDataMap.get(groupName).addApiMetaData(apiMetaData);

    }

    private void populateDisplayConfiguration(ApiMetaDataInformation apiMetaDataInformation) {

        Configuration configuration = InformationRepository.getInstance().getConfiguration();
        Display display;
        if (configuration != null && configuration.getDisplay() != null) {
            display = configuration.getDisplay();

            if(CuubezUtil.isNullOrEmpty(display.getHeader())) {
                display.setHeader(DEFAULT_HEADER);
            }
            if(CuubezUtil.isNullOrEmpty(display.getTittle())) {
                display.setHeader(DEFAULT_TITTLE);
            }

        } else {
            display = getDefaultDisplayConfiguration();
        }

        apiMetaDataInformation.setDisplay(display);
    }

    private Display getDefaultDisplayConfiguration() {
        Display display = new Display();
        display.setHeader(DEFAULT_HEADER);
        display.setTittle(DEFAULT_TITTLE);

        return display;

    }

}
