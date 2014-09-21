package com.cuubez.visualizer.domain;


import com.cuubez.visualizer.domain.configuration.Display;

import java.util.List;
import java.util.Map;

public class ApiMetaDataInformation {

    public Map<String, ApiGroupMetaData> apiMetaData;
    public Display display;


    public Map<String, ApiGroupMetaData> getApiMetaData() {
        return apiMetaData;
    }

    public void setApiMetaData(Map<String, ApiGroupMetaData> apiMetaData) {
        this.apiMetaData = apiMetaData;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }
}
