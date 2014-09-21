package com.cuubez.visualizer.domain.configuration;


import java.util.List;

public class Configuration {

    private List<Group> groups;
    private Display display;


    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }
}
