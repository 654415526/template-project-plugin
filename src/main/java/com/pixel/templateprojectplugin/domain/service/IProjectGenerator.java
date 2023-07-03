package com.pixel.templateprojectplugin.domain.service;

import com.intellij.openapi.project.Project;
import com.pixel.templateprojectplugin.domain.model.ProjectConfigModel;

public interface IProjectGenerator {

    void doGenerator(Project project, String entryPath, ProjectConfigModel projectConfigModel);

}
