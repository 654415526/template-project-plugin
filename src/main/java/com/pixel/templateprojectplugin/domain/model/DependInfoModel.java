package com.pixel.templateprojectplugin.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author lixin
 */
public class DependInfoModel {

    /**
     * 依赖名称
     */
    private String key;
    /**
     * 依赖唯一标识
     */
    private String name;
    /**
     * 依赖分组
     */
    private String groupId;
    /**
     * 是否选中
     */
    private Boolean selected;

    public DependInfoModel(String key, String name, String groupId, Boolean selected) {
        this.key = key;
        this.name = name;
        this.groupId = groupId;
        this.selected = selected;
    }

    public static final List<DependInfoModel> initList = new ArrayList<DependInfoModel>() {
        {
            add(new DependInfoModel("idaas", "idaas", null, Boolean.FALSE));
            add(new DependInfoModel("lombok", "lombok", null, Boolean.TRUE));
            add(new DependInfoModel("aliyunOss", "aliyun oss", null, Boolean.FALSE));
            add(new DependInfoModel("dubboProvider", "dubbo provider", null, Boolean.TRUE));
            add(new DependInfoModel("dubboConsumer", "dubbo consumer", null, Boolean.TRUE));
            add(new DependInfoModel("fastjson", "fastjson", null, Boolean.TRUE));
            add(new DependInfoModel("hutool", "hutool", null, Boolean.TRUE));
            add(new DependInfoModel("redisson", "redisson", null, Boolean.FALSE));
            add(new DependInfoModel("undertow", "undertow", null, Boolean.TRUE));
            add(new DependInfoModel("springfoxSwaager", "springfox swaager", null, Boolean.TRUE));
            add(new DependInfoModel("guava", "guava", null, Boolean.TRUE));
            add(new DependInfoModel("elasticsearch", "elasticsearch", null, Boolean.FALSE));
            add(new DependInfoModel("netty", "netty", null, Boolean.FALSE));
            add(new DependInfoModel("pdfbox", "pdfbox", null, Boolean.FALSE));
            add(new DependInfoModel("mysql", "mysql", null, Boolean.TRUE));
            add(new DependInfoModel("mybatis", "mybatis", null, Boolean.TRUE));
        }
    };

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
