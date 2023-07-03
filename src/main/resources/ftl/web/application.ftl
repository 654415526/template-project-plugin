<#function convert str>
    <#local words = str?split('\\_|\\-')>
    <#local result = ''>
    <#list words as word>
<#--        <#local firstLetter = word?substring(0, 1)?upper_case>-->
<#--        <#local restOfWord = word?substring(1)>-->
<#--        <#local camelCaseWord = firstLetter + restOfWord>-->
        <#local result = result + word?cap_first>
    </#list>
    <#return result>
</#function>
package ${packageName}.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"${packageName}"})
public class ${upperFirsts(name)}Application {

    public static void main(String[] args) {
        SpringApplication.run(${upperFirsts(name)}Application.class, args);
    }

}
