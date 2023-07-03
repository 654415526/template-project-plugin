<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <artifactId>pixel-base-parent</artifactId>
        <groupId>com.pixel.base</groupId>
        <version>${baseParentVersion}</version>
    </parent>

    <groupId>${group}</groupId>
    <artifactId>${removeUnderscore(artifact)}</artifactId>
    <packaging>pom</packaging>
    <version>1.0.0-SNAPSHOT</version>

    <modules>
        <module>api</module>
        <module>server</module>
        <module>model</module>
        <module>web</module>
        <module>starter</module>
        <module>dal</module>
    </modules>

    <properties>
        <pixel.base.version>${baseParentVersion}</pixel.base.version>
        <#if dependMap['idaas']??>
        <idaas.version>1.0.4-SNAPSHOT</idaas.version>
        </#if>
    </properties>

    <distributionManagement>
        <repository>
            <id>rdc-releases</id>
            <url>https://packages.aliyun.com/maven/repository/2177191-release-ctbQ2L/</url>
        </repository>
        <snapshotRepository>
            <id>rdc-snapshots</id>
            <url>https://packages.aliyun.com/maven/repository/2177191-snapshot-cHYeBv/</url>
        </snapshotRepository>
    </distributionManagement>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>${group}</groupId>
                <artifactId>${removeUnderscore(artifact)}-api</artifactId>
                <version>${r'${project.version}'}</version>
            </dependency>

            <dependency>
                <groupId>${group}</groupId>
                <artifactId>${removeUnderscore(artifact)}-dal</artifactId>
                <version>${r'${project.version}'}</version>
            </dependency>

            <dependency>
                <groupId>${group}</groupId>
                <artifactId>${removeUnderscore(artifact)}-model</artifactId>
                <version>${r'${project.version}'}</version>
            </dependency>

            <dependency>
                <groupId>${group}</groupId>
                <artifactId>${removeUnderscore(artifact)}-server</artifactId>
                <version>${r'${project.version}'}</version>
            </dependency>

            <dependency>
                <groupId>${group}</groupId>
                <artifactId>${removeUnderscore(artifact)}-starter</artifactId>
                <version>${r'${project.version}'}</version>
            </dependency>

            <#if dependMap['idaas']??>
            <dependency>
                <groupId>com.pixel.idaas.starter</groupId>
                <artifactId>idaas-starter</artifactId>
                <version>${r'${idaas.version}'}</version>
            </dependency>
            </#if>
        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.18.1</version>
                <configuration>
                    <skipTests>true</skipTests>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-source-plugin</artifactId>
                <version>3.1.0</version>
                <executions>
                    <execution>
                        <id>attach-sources</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>jar-no-fork</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

</project>
