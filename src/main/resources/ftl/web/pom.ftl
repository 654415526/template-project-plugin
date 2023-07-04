<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>${group}</groupId>
        <artifactId>${removeUnderscore(artifact)}</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </parent>

    <artifactId>${removeUnderscore(artifact)}-web</artifactId>

    <properties>
        <java.version>${java}</java.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>${group}</groupId>
            <artifactId>${removeUnderscore(artifact)}-server</artifactId>
        </dependency>

        <dependency>
            <groupId>${group}</groupId>
            <artifactId>${removeUnderscore(artifact)}-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <#if dependMap['undertow']??>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
            </#if>
        </dependency>

        <#if dependMap['undertow']??>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-undertow</artifactId>
        </dependency>

        <dependency>
            <groupId>io.undertow</groupId>
            <artifactId>undertow-core</artifactId>
        </dependency>

        <dependency>
            <groupId>io.undertow</groupId>
            <artifactId>undertow-servlet</artifactId>
        </dependency>
        </#if>

        <#if dependMap['idaas']??>
        <dependency>
            <groupId>com.pixel.idaas.starter</groupId>
            <artifactId>idaas-starter</artifactId>
        </dependency>
        </#if>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>${r'${spring.boot.version}'}</version>
                <configuration>
                    <includeSystemScope>true</includeSystemScope>
                    <mainClass>${packageName}.web.${upperFirsts(name)}Application</mainClass>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <executions>
                    <execution>
                        <id>default-compile</id>
                        <phase>none</phase>
                    </execution>
                    <execution>
                        <id>java-compile</id>
                        <phase>compile</phase>
                        <goals>
                            <goal>compile</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

</project>
