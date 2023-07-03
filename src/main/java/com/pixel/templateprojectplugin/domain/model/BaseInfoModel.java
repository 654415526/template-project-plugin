package com.pixel.templateprojectplugin.domain.model;

import com.pixel.templateprojectplugin.enums.ComponentTypeEnum;
import com.pixel.templateprojectplugin.domain.utils.IDEAUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述:
 *
 * @author lixin
 */
public class BaseInfoModel {

    /**
     * 名称
     */
    private String name;
    /**
     * 唯一标识
     */
    private String key;
    /**
     * 组件类型
     */
    private ComponentTypeEnum componentTypeEnum;
    /**
     * 下拉值
     */
    private List<String> items;
    /**
     * 禁用列表
     */
    private List<String> forbidden;
    /**
     * 默认值
     */
    private String defaultValue;

    public BaseInfoModel(String name, String key, ComponentTypeEnum componentTypeEnum, List<String> items, List<String> forbidden, String defaultValue) {
        this.name = name;
        this.key = key;
        this.componentTypeEnum = componentTypeEnum;
        this.items = items;
        this.forbidden = forbidden;
        this.defaultValue = defaultValue;
    }

    public final static List<BaseInfoModel> initList = new ArrayList<BaseInfoModel>(10) {
        {
            add(new BaseInfoModel("Name", "name", ComponentTypeEnum.INPUT, null, null, "demo"));
            add(new BaseInfoModel("Location", "location", ComponentTypeEnum.FILE_INPUT, null, null, ""));
            add(new BaseInfoModel("Type", "type", ComponentTypeEnum.RADIO, Arrays.asList("Maven", "Gradle"), Collections.singletonList("Gradle"), "Maven"));
            add(new BaseInfoModel("Language", "language", ComponentTypeEnum.RADIO, Arrays.asList("Java", "Kotlin"), Collections.singletonList("Kotlin"), "Java"));
            add(new BaseInfoModel("Group", "group", ComponentTypeEnum.INPUT, null, null, "com.pixel"));
            add(new BaseInfoModel("Artifact", "artifact", ComponentTypeEnum.INPUT, null, null, null));
            add(new BaseInfoModel("Package Name", "packageName", ComponentTypeEnum.INPUT, null, null, "com.pixel."));
            add(new BaseInfoModel("Project SDK", "projectSDK", ComponentTypeEnum.COMBO_BOX, IDEAUtils.getJavaSDK(), null, null));
            add(new BaseInfoModel("Java", "java", ComponentTypeEnum.COMBO_BOX, Arrays.asList("17", "11", "9", "8"), null, "8"));
            add(new BaseInfoModel("Packaging", "packaging", ComponentTypeEnum.RADIO, Arrays.asList("Jar", "War"), Collections.singletonList("War"), "Jar"));
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ComponentTypeEnum getComponentTypeEnum() {
        return componentTypeEnum;
    }

    public void setComponentTypeEnum(ComponentTypeEnum componentTypeEnum) {
        this.componentTypeEnum = componentTypeEnum;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<String> getForbidden() {
        return forbidden;
    }

    public void setForbidden(List<String> forbidden) {
        this.forbidden = forbidden;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
