package com.pixel.templateprojectplugin;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 功能描述:
 *
 * @author lixin
 */
public class Test {

    private void test() throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.getVersion());
        String path = Objects.requireNonNull(this.getClass().getResource("/ftl/web")).getPath();
        configuration.setDirectoryForTemplateLoading(new File(path));
        configuration.setDefaultEncoding("utf-8");
        Template template = configuration.getTemplate("/logback.xml.ftl");
        Map<String, String> map = new HashMap<>();
        map.put("javaVersion", "8");
        map.put("projectName", "demo");
        template.process(map, new FileWriter(path + "/logback.xml"));
        // template.process(map, new FileWriter(path + "/" + StrUtil.upperFirst("demo") + "Application.java"));
    }

//    public static void main(String[] args) throws IOException, TemplateException {
//        new Test().test();
//        File file = new File("/Users/lixin/home/test/test1");
//        file.mkdirs();
//        System.out.println("success!");
//    }

    public static void main(String[] args) {
        String str ="Demo-xx_may";

        Arrays.stream(str.split("[_,-]")).forEach(System.out::println);
        System.out.println(" Demo-xx_may");
    }

}
