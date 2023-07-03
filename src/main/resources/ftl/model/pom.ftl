<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>${group}</groupId>
        <artifactId>${removeUnderscore(artifact)}</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </parent>

    <artifactId>${removeUnderscore(artifact)}-model</artifactId>

    <properties>
        <java.version>${java}</java.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>com.uhomed.basic</groupId>
            <artifactId>uhomed-basic-core</artifactId>
        </dependency>

        <#if dependMap['lombok']??>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        </#if>

        <#if dependMap['springfoxSwaager']??>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
        </dependency>

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
        </dependency>

        <dependency>
            <groupId>io.swagger</groupId>
            <artifactId>swagger-annotations</artifactId>
        </dependency>

        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
            <version>2.0.9</version>
        </dependency>
        </#if>
    </dependencies>

</project>
