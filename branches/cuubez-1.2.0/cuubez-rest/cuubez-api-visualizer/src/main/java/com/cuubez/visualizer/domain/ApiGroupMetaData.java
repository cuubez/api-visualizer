package com.cuubez.visualizer.domain;


import java.util.List;

public class ApiGroupMetaData {

    public String groupName;
    public String groupTittle;
    public List<ApiMetaData> apiMetaDataList;

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
