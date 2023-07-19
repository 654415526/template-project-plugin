# template-project-plugin
<a name="nEmxL"></a>
# 插件说明
支持IDEA版本201.*-232.*
<a name="qSdU2"></a>
# 插件安装
1.下载插件<br />[template-project-plugin-1.0.0-RELEASE.zip](https://yb1k37.yuque.com/attachments/yuque/0/2023/zip/28882781/1688448272180-8bc20b5d-113c-4473-b3ca-a99e2d454808.zip)<br />2.安装插件<br />plugins->setting->Install Plugin from Disk...<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688355251654-faf43751-06ca-4178-9785-79e15a137578.png#averageHue=%23393c41&clientId=u6a1272bd-84de-4&from=paste&height=707&id=u37d9a732&originHeight=1414&originWidth=1956&originalType=binary&ratio=2&rotation=0&showTitle=false&size=396438&status=done&style=none&taskId=uc96332b0-5ea3-491b-be92-3451080265b&title=&width=978)<br />选中刚下载的文件<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688355309984-98779bd6-dffb-4df4-b5af-97d2e396fb9e.png#averageHue=%232b2b29&clientId=u6a1272bd-84de-4&from=paste&height=442&id=u9e617781&originHeight=884&originWidth=1586&originalType=binary&ratio=2&rotation=0&showTitle=false&size=248927&status=done&style=none&taskId=u7465c773-dc37-4919-bf05-1ca362a3dda&title=&width=793)<br />apply之后重启IDEA<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688355381156-ca70f392-2db0-4138-82a2-0cefeb808251.png#averageHue=%23393c40&clientId=u6a1272bd-84de-4&from=paste&height=709&id=ued0d2a71&originHeight=1418&originWidth=1954&originalType=binary&ratio=2&rotation=0&showTitle=false&size=326833&status=done&style=none&taskId=uaf66142a-7b7f-44ff-94e6-9955d93a3c0&title=&width=977)<br />重启之后在New Project中出现Pixel Project即安装成功<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688355658988-c3beac99-5895-438f-ab7c-196972fbd7d3.png#averageHue=%233f4144&clientId=u6a1272bd-84de-4&from=paste&height=661&id=uf179f97c&originHeight=1322&originWidth=1604&originalType=binary&ratio=2&rotation=0&showTitle=false&size=206796&status=done&style=none&taskId=udced167d-99c4-4ed2-b7d1-ee801857e96&title=&width=802)

<a name="gvaQ5"></a>
# 插件使用
1.设置项目基本信息<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688356120244-b9de3e27-2f62-4128-923b-34cd01d40ea2.png#averageHue=%233f4144&clientId=u6a1272bd-84de-4&from=paste&height=662&id=ude833970&originHeight=1324&originWidth=1600&originalType=binary&ratio=2&rotation=0&showTitle=false&size=251319&status=done&style=none&taskId=u5c0457c9-1764-42c7-8d01-bb796ae9d90&title=&width=800)<br />2.添加项目需要的依赖<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688356199178-1a678f65-b612-402e-8739-66ef48718c0e.png#averageHue=%233d4042&clientId=u6a1272bd-84de-4&from=paste&height=662&id=ued790c93&originHeight=1324&originWidth=1596&originalType=binary&ratio=2&rotation=0&showTitle=false&size=169640&status=done&style=none&taskId=u58a28fa3-4ca6-407a-9116-481cc360f28&title=&width=798)<br />3.找到主pom.xml ,使用Add as Maven Project添加为maven项目<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688360226272-82886764-3484-49b3-9204-b0dbf5ae2f39.png#averageHue=%234f4c43&clientId=ucacde560-b86a-4&from=paste&height=739&id=ub5703cb4&originHeight=1478&originWidth=2046&originalType=binary&ratio=2&rotation=0&showTitle=false&size=410628&status=done&style=none&taskId=u9650a235-6155-4e19-bb64-fcd6048f0ff&title=&width=1023)<br />4.多个sdk则在项目中设置一致即可<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688360553270-78abbb10-875d-472f-b897-e165e624cbb0.png#averageHue=%2342444a&clientId=u2667a670-661f-4&from=paste&height=504&id=u6f345c33&originHeight=1008&originWidth=2504&originalType=binary&ratio=2&rotation=0&showTitle=false&size=322945&status=done&style=none&taskId=u13b08d17-26f3-49bf-8050-49cd906396c&title=&width=1252)<br />5.设置maven<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688360711127-89374b20-891a-4681-8ce3-fef15001fba3.png#averageHue=%233f4246&clientId=u2667a670-661f-4&from=paste&height=706&id=ufdc2e739&originHeight=1412&originWidth=1964&originalType=binary&ratio=2&rotation=0&showTitle=false&size=304114&status=done&style=none&taskId=u114a332f-dada-496c-a5f4-230dc90d4bf&title=&width=982)<br />5.启动工程，出现Undertow started on port(s) 8080 (http) with context path ''即成功<br /> DUBBO service start failed, cause:java.lang.RuntimeException: no DUBBOServicePublisher.java service to exported错误原因是在starter的pom.xml中添加了uhomed-dubbo-consumer 依赖，你需在api模块中建立service接口，错误即解决<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688361186791-ccc31a0c-489a-4623-870e-88088453ae80.png#averageHue=%235c6145&clientId=u2667a670-661f-4&from=paste&height=724&id=u43baa1f1&originHeight=1448&originWidth=2698&originalType=binary&ratio=2&rotation=0&showTitle=false&size=539551&status=done&style=none&taskId=u633e78a9-6efb-4d7e-a393-17284e02049&title=&width=1349)

<a name="WYxnQ"></a>
# 生成依赖配置说明
说明：下面将示例每一个选中依赖生成的相应配置
<a name="sB0H5"></a>
## 勾选idaas
```yaml
idaas:
  interceptor:
    login:
      enabled: true
    permission:
      enabled: true
  dubbo:
    enabled: true
  url: ${IDAAS_URL:http://116.62.214.93:9528}
  platform: GOV
  appId: 20230203999999999999999999
```
```xml
<idaas.version>1.0.4-SNAPSHOT</idaas.version>

<dependency>
  <groupId>com.pixel.idaas.starter</groupId>
  <artifactId>idaas-starter</artifactId>
  <version>${idaas.version}</version>
</dependency>
```
```xml
<dependency>
  <groupId>com.pixel.idaas.starter</groupId>
  <artifactId>idaas-starter</artifactId>
</dependency>
```
<a name="IA6tP"></a>
## 勾选mybiats
```yaml
mybatis:
  mapper-locations: classpath*:mapper/*Mapper.xml
```
```yaml
生成如下资源文件夹
dal/src/main/resources/mapper
```
<a name="rEaVd"></a>
## 勾选mysql
```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://${MYSQL_HOST:rm-bp151iwg6e7zi1j5r2o.mysql.rds.aliyuncs.com}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:test}?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&tcpKeepAlive=true&serverTimezone=CTT
    username: ${MYSQL_USER_NAME:ops_test}
    password: ${MYSQL_PASSWORD:iowerklqlqwd}
    hikari:
      connection-test-query: SELECT 1 FROM DUAL
      minimum-idle: ${MIN_CONNECTION:5}
      maximum-pool-size: ${MAX_CONNECTION:20}
      idle-timeout: ${CONNECTION_TIMEOUT:600000}
```
```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
</dependency>
```
<a name="JqdPO"></a>
## 勾选undertow
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <exclusions>
    <exclusion>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-tomcat</artifactId>
    </exclusion>
  </exclusions>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-undertow</artifactId>
</dependency>

<dependency>
  <groupId>io.undertow</groupId>
  <artifactId>undertow-core</artifactId>
</dependency>

<dependency>
  <groupId>io.undertow</groupId>
  <artifactId>undertow-servlet</artifactId>
</dependency>
```
<a name="agIFe"></a>
## 勾选redisson
```yaml
srping:  
  redis:
    host: ${REDIS_HOST:r-bp1zxtrms07vqsq986pd.redis.rds.aliyuncs.com}
    password: ${REDIS_PASSWORD:9VmgWYFCHpGA2MEQn}
```
```xml
<dependency>
  <groupId>org.redisson</groupId>
  <artifactId>redisson</artifactId>
</dependency>
```
```java
package com.pixel.mydemo.server.configuration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedissonAutoConfiguration {

    @Resource
    private RedisProperties redisProperties;

    @Bean
    public RedissonClient redissonClient() {

        Config config = new Config();
        String prefix = "redis://";
        Method method = ReflectionUtils.findMethod(RedisProperties.class, "isSsl");

        if (method != null && ((Boolean) ReflectionUtils.invokeMethod(method, redisProperties))) {
            prefix = "rediss://";
        }
        config.useSingleServer().setAddress(prefix + redisProperties.getHost() + ":" + redisProperties.getPort())
        .setConnectTimeout(3000).setDatabase(redisProperties.getDatabase())
        .setPassword(redisProperties.getPassword());
        config.setCodec(new JsonJacksonCodec());
        return Redisson.create(config);
    }

}

```
<a name="Dkyvt"></a>
## 勾选springfoxSwaager
```xml
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger-ui</artifactId>
</dependency>

<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger2</artifactId>
</dependency>

<dependency>
  <groupId>io.swagger</groupId>
  <artifactId>swagger-annotations</artifactId>
</dependency>

<dependency>
  <groupId>com.github.xiaoymin</groupId>
  <artifactId>knife4j-spring-boot-starter</artifactId>
  <version>2.0.9</version>
</dependency>
```
```java
package com.pixel.mydemo.server.configuration;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
@Profile({"local","dev","test"})
public class Knife4jConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false)
        .apiInfo(apiInfo())
        .groupName("my-demo")
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.pixel.mydemo.web.controller"))
        .paths(PathSelectors.any())
        .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        .description("my-demo在线API接口文档")
        .termsOfServiceUrl("localhost:8085")
        .version("v1.0.0")
        .title("my-demo在线API接口文档")
        .build();
    }

}
```
<a name="oyiTg"></a>
##  勾选dubboProvider
```yaml
dubbo:
  application:
    name: my-demo-service
    qosPort: 22222
  protocol:
    name: dubbo
    dubbo:
      payload: 104857600
  registry:
    id: my-demo-service
    address: zookeeper://${ZOOKEEPER_HOST:mse-483e4fd0-zk.mse.aliyuncs.com}:${ZOOKEEPER_PORT:2181}
```
```xml
<dependency>
  <artifactId>uhomed-dubbo-provider</artifactId>
  <groupId>com.uhomed.dubbo-hight</groupId>
</dependency>

<dependency>
  <groupId>org.apache.curator</groupId>
  <artifactId>curator-framework</artifactId>
  <exclusions>
    <exclusion>
      <artifactId>log4j</artifactId>
      <groupId>log4j</groupId>
    </exclusion>
  </exclusions>
</dependency>
```
<a name="u8TWc"></a>
##  勾选dubboConsumer
```yaml
dubbo:
  application:
    name: my-demo-service
    qosPort: 22222
  protocol:
    name: dubbo
    dubbo:
      payload: 104857600
  registry:
    id: my-demo-service
    address: zookeeper://${ZOOKEEPER_HOST:mse-483e4fd0-zk.mse.aliyuncs.com}:${ZOOKEEPER_PORT:2181}
  provider:
    scan-packages: com.pixel.mydemo.api
    port: 20880
    version: 1.0.0
```
```xml
<dependency>
  <artifactId>uhomed-dubbo-consumer</artifactId>
  <groupId>com.uhomed.dubbo-hight</groupId>
</dependency>
```
```java
// 在MyDemoStarter中生成 private ServiceSubscriber serviceSubscriber;

public class MyDemoStarter {

    @Resource
    private ServiceSubscriber serviceSubscriber;

}
```
<a name="hjm7J"></a>
##  勾选fastjson
```xml
<dependency>
  <groupId>com.alibaba</groupId>
  <artifactId>fastjson</artifactId>
</dependency>
```
<a name="aLJ6m"></a>
##  勾选huttol
```xml
<dependency>
  <groupId>cn.hutool</groupId>
  <artifactId>hutool-all</artifactId>
</dependency>
```
<a name="RszuL"></a>
##  勾选lombok
```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
</dependency>
```
<a name="q1G1k"></a>
##  勾选guava
```xml
<dependency>
  <groupId>com.google.guava</groupId>
  <artifactId>guava</artifactId>
</dependency>
```
<a name="bh4IQ"></a>
##  勾选pdfbox
```xml
<dependency>
  <groupId>org.apache.pdfbox</groupId>
  <artifactId>pdfbox</artifactId>
</dependency>
```
<a name="lp602"></a>
##  勾选aliyunOss
```xml
<dependency>
  <groupId>com.aliyun.oss</groupId>
  <artifactId>aliyun-sdk-oss</artifactId>
</dependency>
```
 <br /> <br /> 
