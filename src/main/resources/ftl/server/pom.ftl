<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>${group}</groupId>
        <artifactId>${removeUnderscore(artifact)}</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </parent>

    <artifactId>${removeUnderscore(artifact)}-server</artifactId>

    <properties>
        <java.version>${java}</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>${group}</groupId>
            <artifactId>${removeUnderscore(artifact)}-api</artifactId>
        </dependency>

        <dependency>
            <groupId>${group}</groupId>
            <artifactId>${removeUnderscore(artifact)}-dal</artifactId>
        </dependency>

        <dependency>
            <groupId>${group}</groupId>
            <artifactId>${removeUnderscore(artifact)}-model</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <#if dependMap['redisson']??>
        <dependency>
           <groupId>org.redisson</groupId>
           <artifactId>redisson</artifactId>
        </dependency>
        </#if>

        <#if dependMap['guava']??>
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
        </dependency>
        </#if>

        <#if dependMap['fastjson']??>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
        </dependency>
        </#if>

        <#if dependMap['hutool']??>
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
        </dependency>
        </#if>

        <#if dependMap['aliyunOss']??>
        <dependency>
            <groupId>com.aliyun.oss</groupId>
            <artifactId>aliyun-sdk-oss</artifactId>
        </dependency>
        </#if>

        <#if dependMap['pdfbox']??>
        <dependency>
            <groupId>org.apache.pdfbox</groupId>
            <artifactId>pdfbox</artifactId>
        </dependency>
        </#if>

        <#if dependMap['dubboProvider']??>
        <dependency>
            <artifactId>uhomed-dubbo-provider</artifactId>
            <groupId>com.uhomed.dubbo-hight</groupId>
        </dependency>

        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-framework</artifactId>
            <exclusions>
                <exclusion>
                    <artifactId>log4j</artifactId>
                    <groupId>log4j</groupId>
                </exclusion>
            </exclusions>
        </dependency>
        </#if>

    </dependencies>

</project>
