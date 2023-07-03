package com.pixel.templateprojectplugin.domain.service.impl;

import cn.hutool.core.util.StrUtil;
import com.intellij.openapi.project.Project;
import com.pixel.templateprojectplugin.domain.model.ProjectConfigModel;
import com.pixel.templateprojectplugin.domain.service.AbstractProjectGenerator;
import com.pixel.templateprojectplugin.domain.utils.ConvertUtils;


/**
 * 功能描述:
 *
 * @author lixin
 */
public class ProjectGeneratorImpl extends AbstractProjectGenerator {

    @Override
    protected void generateProjectWeb(Project project, String entryPath, ProjectConfigModel projectConfigModel) {
        generateApplication(project, entryPath, projectConfigModel, "/web/src/main/java/" + projectConfigModel.getPackageName() + ".web");
        generateLogback(project, entryPath, projectConfigModel);
        generateApplicationYml(project, entryPath, projectConfigModel);
        generateProjectPom(project, entryPath, projectConfigModel, "/web", "web");
    }

    @Override
    protected void generateProjectApi(Project project, String entryPath, ProjectConfigModel projectConfigModel) {
        generateProjectPackageInfo(project, entryPath, projectConfigModel, "/api/src/main/java/" + projectConfigModel.getPackageName() + ".api", "api");
        generateProjectPom(project, entryPath, projectConfigModel, "/api", "api");
    }

    @Override
    protected void generateProjectModel(Project project, String entryPath, ProjectConfigModel projectConfigModel) {
        generateProjectPackageInfo(project, entryPath, projectConfigModel, "/model/src/main/java/" + projectConfigModel.getPackageName() + ".model", "model");
        generateProjectPom(project, entryPath, projectConfigModel, "/model", "model");
    }

    @Override
    protected void generateProjectDal(Project project, String entryPath, ProjectConfigModel projectConfigModel) {
        generateProjectPackageInfo(project, entryPath, projectConfigModel, "/dal/src/main/java/" + projectConfigModel.getPackageName() + ".dal", "dal");
        if (projectConfigModel.getDependMap().containsKey("mybatis")) {
            generateProjectPackageInfo(project, entryPath, projectConfigModel, "/dal/src/main/resources/mapper", "dal");
        }
        generateProjectPom(project, entryPath, projectConfigModel, "/dal", "dal");
    }

    @Override
    protected void generateProjectServer(Project project, String entryPath, ProjectConfigModel projectConfigModel) {
        generateProjectPackageInfo(project, entryPath, projectConfigModel, "/server/src/main/java/" + projectConfigModel.getPackageName() + ".server", "server");
        generateProjectPom(project, entryPath, projectConfigModel, "/server", "server");
        generateRedissonAutoConfiguration(project, entryPath, projectConfigModel, "/server/src/main/java/" + projectConfigModel.getPackageName() + ".server.configuration");
        generateKnife4jConfiguration(project, entryPath, projectConfigModel, "/server/src/main/java/" + projectConfigModel.getPackageName() + ".server.configuration");
    }

    @Override
    protected void generateProjectStarter(Project project, String entryPath, ProjectConfigModel projectConfigModel) {
        generateBootStarter(project, entryPath, projectConfigModel, "/starter/src/main/java/" + projectConfigModel.getPackageName() + ".starter");
        generateSpringFactories(project, entryPath, projectConfigModel);
        generateProjectPom(project, entryPath, projectConfigModel, "/starter", "starter");
    }

    @Override
    protected void generateProjectPom(Project project, String entryPath, ProjectConfigModel projectConfigModel, String packageName, String prefixPath) {
        writeFile(project, packageName, entryPath, "pom.xml", StrUtil.isBlank(prefixPath) ? "pom.ftl" : String.format("%s/pom.ftl", prefixPath), projectConfigModel);
    }

    @Override
    protected void generateProjectPackageInfo(Project project, String entryPath, ProjectConfigModel projectConfigModel, String packageName, String prefixPath) {
        writeFile(project, packageName, entryPath, "package-info.java", String.format("%s/package-info.ftl", prefixPath), projectConfigModel);
    }

    @Override
    protected void generateApplication(Project project, String entryPath, ProjectConfigModel projectConfigModel, String packageName) {
        writeFile(project, packageName, entryPath, String.format("%sApplication.java", ConvertUtils.toCamelCase(projectConfigModel.getName())), "web/application.ftl", projectConfigModel);
    }

    @Override
    protected void generateApplicationYml(Project project, String entryPath, ProjectConfigModel projectConfigModel) {
        writeFile(project, "/web/src/main/resources", entryPath, "application.yml", "web/application.yml.ftl", projectConfigModel);
        writeFile(project, "/web/src/main/resources", entryPath, "application-dev.yml", "web/application-dev.yml.ftl", projectConfigModel);
        writeFile(project, "/web/src/main/resources", entryPath, "application-prod.yml", "web/application-prod.yml.ftl", projectConfigModel);
        writeFile(project, "/web/src/main/resources", entryPath, "application-test.yml", "web/application-test.yml.ftl", projectConfigModel);
    }

    @Override
    protected void generateRedissonAutoConfiguration(Project project, String entryPath, ProjectConfigModel projectConfigModel, String packageName) {
        if (projectConfigModel.getDependMap().containsKey("redisson")) {
            writeFile(project, packageName, entryPath, "RedissonAutoConfiguration.java", "server/RedissonAutoConfiguration.ftl", projectConfigModel);
        }
    }

    @Override
    protected void generateLogback(Project project, String entryPath, ProjectConfigModel projectConfigModel) {
        writeFile(project, "/web/src/main/resources", entryPath, "logback.xml", "web/logback.xml.ftl", projectConfigModel);
    }

    @Override
    protected void generateKnife4jConfiguration(Project project, String entryPath, ProjectConfigModel projectConfigModel, String packageName) {
        if (projectConfigModel.getDependMap().containsKey("springfoxSwaager")) {
            writeFile(project, packageName, entryPath, "Knife4jConfiguration.java", "server/Knife4jConfiguration.ftl", projectConfigModel);
        }
    }

    @Override
    protected void generateBootStarter(Project project, String entryPath, ProjectConfigModel projectConfigModel, String packageName) {
        writeFile(project, packageName, entryPath, String.format("%sStarter.java", ConvertUtils.toCamelCase(projectConfigModel.getName())), "starter/starter.ftl", projectConfigModel);
    }

    @Override
    protected void generateSpringFactories(Project project, String entryPath, ProjectConfigModel projectConfigModel) {
        writeFile(project, "starter/src/main/resources/META-INF", entryPath, "spring.factories", "starter/spring.factories.ftl", projectConfigModel);
    }

}
