package com.cuubez.visualizer.domain.configuration;


import java.util.List;

public class Resource {

    private String path;
    private String name;
    private String httpMethod;
    private String detail;
    private List<HttpCode> httpCodes;
    private List<Variable> variables;
    private String requestBodyType;
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
