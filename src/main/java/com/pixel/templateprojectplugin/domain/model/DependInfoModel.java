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

    public DependInfoModel(String key, String name, String groupId) {
        this.key = key;
        this.name = name;
        this.groupId = groupId;
    }

    public static final List<DependInfoModel> initList = new ArrayList<DependInfoModel>() {
        {
            add(new DependInfoModel("springBoot", "spring boot", null));
            add(new DependInfoModel("idaas", "idaas", null));
            add(new DependInfoModel("lombok", "lombok", null));
            add(new DependInfoModel("aliyunOss", "aliyun oss", null));
            add(new DependInfoModel("dubboProvider", "dubbo provider", null));
            add(new DependInfoModel("dubboConsumer", "dubbo consumer", null));
            add(new DependInfoModel("fastjson", "fastjson", null));
            add(new DependInfoModel("hutool", "hutool", null));
            add(new DependInfoModel("redisson", "redisson", null));
            add(new DependInfoModel("undertow", "undertow", null));
            add(new DependInfoModel("springfoxSwaager", "springfox swaager", null));
            add(new DependInfoModel("guava", "guava", null));
            add(new DependInfoModel("elasticsearch", "elasticsearch", null));
            add(new DependInfoModel("netty", "netty", null));
            add(new DependInfoModel("pdfbox", "pdfbox", null));
            add(new DependInfoModel("mysql", "mysql", null));
            add(new DependInfoModel("mybatis", "mybatis", null));
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
}
