package com.pixel.templateprojectplugin.core

import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.openapi.util.text.StringUtil
import com.pixel.templateprojectplugin.component.BaseInfoComponent
import com.pixel.templateprojectplugin.domain.utils.PreconditionUtils
import com.pixel.templateprojectplugin.infrastructure.DataSetting
import org.jdesktop.swingx.JXComboBox
import javax.swing.JComponent
import javax.swing.JTextField

/**
 * 功能描述:
 *
 * @author Li xin
 */
class PixelTemplateProjectModuleWizardStep : ModuleWizardStep() {

    private val baseInfoComponent = state?.baseInfoComponent

    companion object {
        val state = DataSetting.getInstance().state
    }

    override fun getComponent(): JComponent {
        return baseInfoComponent?.gridPanel as JComponent
    }

    override fun updateDataModel() {
        val name = BaseInfoComponent.getComponentByName(baseInfoComponent?.gridPanel?.components, "name") as JTextField
        PreconditionUtils.checkArgument(StringUtil.isNotEmpty(name.text), "Please enter a name")
        val location = BaseInfoComponent.getComponentByName(baseInfoComponent?.gridPanel?.components, "location") as JTextField
        PreconditionUtils.checkArgument(StringUtil.isNotEmpty(location.text), "Please enter a location")
        val group = BaseInfoComponent.getComponentByName(baseInfoComponent?.gridPanel?.components, "group") as JTextField
        PreconditionUtils.checkArgument(StringUtil.isNotEmpty(group.text), "Please enter a group")
        val artifact = BaseInfoComponent.getComponentByName(baseInfoComponent?.gridPanel?.components, "artifact") as JTextField
        PreconditionUtils.checkArgument(StringUtil.isNotEmpty(artifact.text), "Please enter a artifact")
        val packageName = BaseInfoComponent.getComponentByName(baseInfoComponent?.gridPanel?.components, "packageName") as JTextField
        PreconditionUtils.checkArgument(StringUtil.isNotEmpty(packageName.text), "Please enter a package name")
        val projectSDK = BaseInfoComponent.getComponentByName(baseInfoComponent?.gridPanel?.components, "projectSDK") as JXComboBox
        PreconditionUtils.checkArgument(StringUtil.isNotEmpty(projectSDK.selectedItem as String), "Please enter a project SDK")
        val java = BaseInfoComponent.getComponentByName(baseInfoComponent?.gridPanel?.components, "java") as JXComboBox
        PreconditionUtils.checkArgument(StringUtil.isNotEmpty(java.selectedItem as String), "Please enter a java")
        if (state != null) {
            state.name = name.text
            state.location = location.text
            state.java = java.selectedItem as String
            state.group = group.text
            state.projectSDK = projectSDK.selectedItem as String
            state.packageName = packageName.text
            state.artifact = artifact.text
            state.type = "maven"
            state.language = "java"
            state.packaging = "jar"
        }
    }

}
