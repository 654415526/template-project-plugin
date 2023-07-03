spring:
  application:
    name: ${removeUnderscore(name)}
  profiles:
    active: dev

server:
  port: 8080

<#if dependMap['mybatis']??>
mybatis:
  mapper-locations: classpath*:mapper/*Mapper.xml
</#if>