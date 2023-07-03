package com.pixel.templateprojectplugin.domain.config;

import com.pixel.templateprojectplugin.domain.utils.ConvertUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.io.IOException;
import java.util.List;

/**
 * 功能描述:
 *
 * @author lixin
 */
public class FreemarkerConfiguration extends Configuration {

    public FreemarkerConfiguration() {
        this("/ftl");
    }

    private FreemarkerConfiguration(String basePackagePath) {
        super(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        setDefaultEncoding("UTF-8");
        setClassForTemplateLoading(getClass(), basePackagePath);
        setSharedVariable("removeUnderscore", new RemoveUnderscore());
        setSharedVariable("upperFirsts", new UpperFirsts());
    }

    public Template getTemplate(String ftl) throws IOException {
        return this.getTemplate(ftl, "UTF-8");
    }

    static class RemoveUnderscore implements TemplateMethodModelEx {

        @Override
        public Object exec(List arguments) throws TemplateModelException {
            if (arguments.size() != 1) {
                throw new TemplateModelException("Invalid number of arguments. Expected 1.");
            }
            String str = arguments.get(0).toString();
            return str.replace("_", "");
        }

    }

    static class UpperFirsts implements TemplateMethodModelEx {

        @Override
        public Object exec(List arguments) throws TemplateModelException {
            if (arguments.size() != 1) {
                throw new TemplateModelException("Invalid number of arguments. Expected 1.");
            }
            return ConvertUtils.toCamelCase(arguments.get(0).toString());
        }

    }

}
