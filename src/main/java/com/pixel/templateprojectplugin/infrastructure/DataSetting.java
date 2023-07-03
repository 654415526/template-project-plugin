package com.pixel.templateprojectplugin.infrastructure;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.*;
import com.pixel.templateprojectplugin.domain.model.ProjectConfigModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 功能描述:
 *
 * @author lixin
 */
@State(name = "DataSetting",storages = @Storage("plugin.xml"))
public class DataSetting implements PersistentStateComponent<ProjectConfigModel> {

    private ProjectConfigModel state = new ProjectConfigModel();

    public static DataSetting getInstance() {
        return ApplicationManager.getApplication().getService(DataSetting.class);
    }

    @Override
    public @Nullable ProjectConfigModel getState() {
        return this.state;
    }

    @Override
    public void loadState(@NotNull ProjectConfigModel state) {
        this.state = state;
    }

}
