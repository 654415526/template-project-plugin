package com.pixel.templateprojectplugin.core

import com.intellij.ide.projectWizard.ProjectSettingsStep
import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.Disposable
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import com.pixel.templateprojectplugin.component.BaseInfoComponent
import com.pixel.templateprojectplugin.component.DependComponent
import com.pixel.templateprojectplugin.domain.service.impl.ProjectGeneratorImpl
import com.pixel.templateprojectplugin.infrastructure.DataSetting
import com.pixel.templateprojectplugin.domain.utils.IDEAUtils
import org.jetbrains.annotations.NonNls

/**
 * 功能描述:
 *
 * @author Li xin
 */
class PixelTemplateProjectModuleBuilder : ModuleBuilder() {

    companion object {
        val projectGenerator = ProjectGeneratorImpl()
        val state = DataSetting.getInstance().state
    }

    override fun getContentEntryPath(): String {
        return (state?.location + "/" + state?.name)
    }

    override fun getName(): String {
        return state?.name ?: "demo"
    }

    override fun createProject(name: String?, path: String?): Project? {
        return super.createProject(getName(), contentEntryPath)
    }

    @NonNls
    override fun getBuilderId(): String? {
        return javaClass.name
    }

    override fun getModuleType(): ModuleType<*> {
        return PixelTemplateProjectModuleType.instance
    }

    override fun getCustomOptionsStep(context: WizardContext, parentDisposable: Disposable): ModuleWizardStep {
        return PixelTemplateProjectModuleWizardStep()
    }

    override fun getIgnoredSteps(): List<Class<out ModuleWizardStep>> {
        return listOf(ProjectSettingsStep::class.java)
    }

    override fun createFinishingSteps(wizardContext: WizardContext, modulesProvider: ModulesProvider): Array<ModuleWizardStep> {
        return arrayOf(PixelTemplateProjectDependModuleWizardStep())
    }

    override fun setupRootModel(model: ModifiableRootModel) {

        if (state != null) {
            model.sdk = IDEAUtils.getJavaSDK(state.projectSDK)
        }

        doAddContentEntry(model)

        val project = model.project

        projectGenerator.doGenerator(project, contentEntryPath, state)

        state?.dependComponent = DependComponent()
        state?.baseInfoComponent = BaseInfoComponent()

        // TODO 后续解决maven问题

//        val pomFiles: MutableList<VirtualFile> = ArrayList()
//
//        val baseDir = project.basePath?.let { LocalFileSystem.getInstance().findFileByPath(it) }
//
//        if (baseDir != null) {
//            findPomFiles(baseDir, pomFiles)
//        }

//        ExternalSystemModulePropertyManager.getInstance(model.module).setExternalId(ProjectSystemId("Maven"))

//        val mavenProjectsManager = MavenProjectsManager.getInstance(model.project)
//        mavenProjectsManager.addManagedFiles(pomFiles)
//        mavenProjectsManager.importProjects()

    }

//    private fun findPomFiles(directory: VirtualFile, pomFiles: MutableList<VirtualFile>) {
//        for (file: VirtualFile in directory.children) {
//            if (file.isDirectory) {
//                findPomFiles(file, pomFiles)
//            } else if ("pom.xml" == file.name) {
//                pomFiles.add(file)
//            }
//        }
//    }

}
