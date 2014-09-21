package com.cuubez.visualizer.domain.configuration;


import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.ws.rs.core.Response;
import java.util.List;

public class Group {

    private String name;
    private String title;
    private List<Resource> resources;
    private List<HttpCode> httpCodes;

    public Group(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<HttpCode> getHttpCodes() {
        return httpCodes;
    }

    public void setHttpCodes(List<HttpCode> httpCodes) {
        this.httpCodes = httpCodes;
    }
}
