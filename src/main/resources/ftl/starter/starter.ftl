package ${packageName}.starter;

<#if dependMap['dubboConsumer']??>
import com.uhomed.dubbo.hight.consumer.ServiceSubscriber;

import javax.annotation.Resource;
</#if>

public class ${upperFirsts(name)}Starter {

    <#if dependMap['dubboConsumer']??>
    @Resource
    private ServiceSubscriber serviceSubscriber;
    </#if>

}