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

public class ApiGroupMetaData {

    public String id;
    public String groupName;
    public String groupTittle;
    public List<ApiMetaData> apiMetaDataList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupTittle() {
        return groupTittle;
    }

    public void setGroupTittle(String groupTittle) {
        this.groupTittle = groupTittle;
    }

    public List<ApiMetaData> getApiMetaDataList() {
        return apiMetaDataList;
    }

    public void setApiMetaDataList(List<ApiMetaData> apiMetaDataList) {
        this.apiMetaDataList = apiMetaDataList;
    }

    public void addApiMetaData(ApiMetaData apiMetaData) {
        this.apiMetaDataList.add(apiMetaData);
    }
}
