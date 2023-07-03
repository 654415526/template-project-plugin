package com.pixel.templateprojectplugin.domain.service;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.pixel.templateprojectplugin.domain.config.FreemarkerConfiguration;
import com.pixel.templateprojectplugin.domain.model.ProjectConfigModel;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/**
 * 功能描述:
 *
 * @author lixin
 */
public abstract class AbstractProjectGenerator extends FreemarkerConfiguration implements IProjectGenerator {

    @Override
    public void doGenerator(Project project, String entryPath, ProjectConfigModel projectConfigModel) {
        generateProjectWeb(project, entryPath, projectConfigModel);
        generateProjectApi(project, entryPath, projectConfigModel);
        generateProjectDal(project, entryPath, projectConfigModel);
        generateProjectModel(project, entryPath, projectConfigModel);
        generateProjectServer(project, entryPath, projectConfigModel);
        generateProjectStarter(project, entryPath, projectConfigModel);
        generateProjectPom(project, entryPath, projectConfigModel, "/", "");
    }

    protected abstract void generateProjectWeb(Project project, String entryPath, ProjectConfigModel projectConfigModel);

    protected abstract void generateProjectApi(Project project, String entryPath, ProjectConfigModel projectConfigModel);

    protected abstract void generateProjectModel(Project project, String entryPath, ProjectConfigModel projectConfigModel);

    protected abstract void generateProjectDal(Project project, String entryPath, ProjectConfigModel projectConfigModel);

    protected abstract void generateProjectServer(Project project, String entryPath, ProjectConfigModel projectConfigModel);

    protected abstract void generateProjectStarter(Project project, String entryPath, ProjectConfigModel projectConfigModel);

    protected abstract void generateProjectPom(Project project, String entryPath, ProjectConfigModel projectConfigModel, String packageName, String prefixPath);

    protected abstract void generateProjectPackageInfo(Project project, String entryPath, ProjectConfigModel projectConfigModel, String packageName, String prefixPath);

    protected abstract void generateApplication(Project project, String entryPath, ProjectConfigModel projectConfigModel, String packageName);

    protected abstract void generateApplicationYml(Project project, String entryPath, ProjectConfigModel projectConfigModel);

    protected abstract void generateRedissonAutoConfiguration(Project project, String entryPath, ProjectConfigModel projectConfigModel, String packageName);

    protected abstract void generateLogback(Project project, String entryPath, ProjectConfigModel projectConfigModel);

    protected abstract void generateKnife4jConfiguration(Project project, String entryPath, ProjectConfigModel projectConfigModel, String packageName);

    protected abstract void generateBootStarter(Project project, String entryPath, ProjectConfigModel projectConfigModel, String packageName);

    protected abstract void generateSpringFactories(Project project, String entryPath, ProjectConfigModel projectConfigModel);

    public void writeFile(Project project, String packageName, String entryPath, String name, String ftl, Object dataModel) {
        VirtualFile virtualFile;
        try {
            virtualFile = createPackageDir(packageName, entryPath).createChildData(project, name);
            StringWriter stringWriter = new StringWriter();
            Template template = super.getTemplate(ftl);
            template.process(dataModel, stringWriter);
            virtualFile.setBinaryContent(stringWriter.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private static VirtualFile createPackageDir(String packageName, String entryPath) {
        String path = FileUtil.toSystemIndependentName(entryPath + "/" + StringUtil.replace(packageName, ".", "/"));
        File file = new File(path);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (!mkdirs) {
                throw new IllegalArgumentException("创建异常....");
            }
        }
        return LocalFileSystem.getInstance().refreshAndFindFileByPath(path);
    }

}
