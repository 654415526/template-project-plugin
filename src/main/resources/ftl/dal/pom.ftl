<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>${group}</groupId>
        <artifactId>${removeUnderscore(artifact)}</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </parent>

    <artifactId>${removeUnderscore(artifact)}-dal</artifactId>

    <properties>
        <java.version>${java}</java.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>${group}</groupId>
            <artifactId>${removeUnderscore(artifact)}-model</artifactId>
        </dependency>

        <#if dependMap['mysql']??>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        </#if>
    </dependencies>

</project>
