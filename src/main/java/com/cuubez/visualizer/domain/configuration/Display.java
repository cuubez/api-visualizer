package com.cuubez.visualizer.domain.configuration;


public class Display {

    String header;
    String tittle;
    String logoUrl;
    boolean logoInclude;
    Description description;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public boolean isLogoInclude() {
        return logoInclude;
    }

    public void setLogoInclude(boolean isLogoInclude) {
        this.logoInclude = isLogoInclude;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}
