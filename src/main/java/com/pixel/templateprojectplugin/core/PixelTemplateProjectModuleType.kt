package com.pixel.templateprojectplugin.core

import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.module.ModuleTypeManager
import com.pixel.templateprojectplugin.infrastructure.ICONS
import org.jetbrains.annotations.Nls
import javax.swing.Icon

/**
 * 功能描述:
 *
 * @author Li xin
 */
class PixelTemplateProjectModuleType : ModuleType<PixelTemplateProjectModuleBuilder>(ID) {

    companion object {
        private const val ID = "PIXEL_TEMPLATE_PROJECT_MODULE_TYPE"
        private const val PIXEL_PROJECT = "Pixel Project"
        private const val DESC = "Create a new pixel project!"
        val instance: PixelTemplateProjectModuleType
            get() = ModuleTypeManager.getInstance().findByID(ID) as PixelTemplateProjectModuleType
    }

    override fun createModuleBuilder(): PixelTemplateProjectModuleBuilder {
        return PixelTemplateProjectModuleBuilder()
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    override fun getName(): String {
        return PIXEL_PROJECT
    }

    @Nls(capitalization = Nls.Capitalization.Sentence)
    override fun getDescription(): String {
        return DESC
    }

    override fun getNodeIcon(isOpened: Boolean): Icon {
        return ICONS.PIXEL
    }

}
