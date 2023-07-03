package com.pixel.templateprojectplugin.core

import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.pixel.templateprojectplugin.infrastructure.DataSetting
import javax.swing.JComponent

/**
 * 功能描述:
 *
 * @author Li xin
 */
class PixelTemplateProjectDependModuleWizardStep : ModuleWizardStep() {

    private val dependComponent = state?.dependComponent

    companion object {
        val state = DataSetting.getInstance().state
    }

    override fun getComponent(): JComponent {
        return dependComponent?.mainPanel as JComponent
    }

    override fun updateDataModel() {
        if (state != null) {
            state.baseParentVersion = dependComponent?.jxComboBox?.selectedItem as String + "-SNAPSHOT"
            state.dependMap = dependComponent.dependMap
        }
    }

}
