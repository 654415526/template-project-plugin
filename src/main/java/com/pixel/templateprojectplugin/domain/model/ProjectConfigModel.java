package com.pixel.templateprojectplugin.domain.model;


import com.pixel.templateprojectplugin.component.BaseInfoComponent;
import com.pixel.templateprojectplugin.component.DependComponent;

import java.util.Map;

/**
 * 功能描述:
 *
 * @author lixin
 */
public class ProjectConfigModel {

    private String name;
    private String location;
    private String type;
    private String language;
    private String group;
    private String artifact;
    private String packageName;
    private String projectSDK;
    private String java;
    private String packaging;
    private String baseParentVersion;
    private Map<String, String> dependMap;

    private DependComponent dependComponent = new DependComponent();

    private BaseInfoComponent baseInfoComponent = new BaseInfoComponent();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getArtifact() {
        return artifact;
    }

    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getProjectSDK() {
        return projectSDK;
    }

    public void setProjectSDK(String projectSDK) {
        this.projectSDK = projectSDK;
    }

    public String getJava() {
        return java;
    }

    public void setJava(String java) {
        this.java = java;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getBaseParentVersion() {
        return baseParentVersion;
    }

    public void setBaseParentVersion(String baseParentVersion) {
        this.baseParentVersion = baseParentVersion;
    }

    public Map<String, String> getDependMap() {
        return dependMap;
    }

    public void setDependMap(Map<String, String> dependMap) {
        this.dependMap = dependMap;
    }

    public DependComponent getDependComponent() {
        return dependComponent;
    }

    public void setDependComponent(DependComponent dependComponent) {
        this.dependComponent = dependComponent;
    }

    public BaseInfoComponent getBaseInfoComponent() {
        return baseInfoComponent;
    }

    public void setBaseInfoComponent(BaseInfoComponent baseInfoComponent) {
        this.baseInfoComponent = baseInfoComponent;
    }
}
