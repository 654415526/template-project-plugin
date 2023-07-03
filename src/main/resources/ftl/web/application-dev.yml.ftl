<#if dependMap['mysql']?? || dependMap['redisson']??>
spring:
  <#if dependMap['mysql']??>
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://${r'${MYSQL_HOST:rm-bp151iwg6e7zi1j5r2o.mysql.rds.aliyuncs.com}'}:${r'${MYSQL_PORT:3306}'}/${r'${MYSQL_DATABASE:test}'}?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&tcpKeepAlive=true&serverTimezone=CTT
    username: ${r'${MYSQL_USER_NAME:ops_test}'}
    password: ${r'${MYSQL_PASSWORD:iowerklqlqwd}'}
    hikari:
      connection-test-query: SELECT 1 FROM DUAL
      minimum-idle: ${r'${MIN_CONNECTION:5}'}
      maximum-pool-size: ${r'${MAX_CONNECTION:20}'}
      idle-timeout: ${r'${CONNECTION_TIMEOUT:600000}'}
  </#if>
  <#if dependMap['redisson']??>
  redis:
    host: ${r'${REDIS_HOST:r-bp1zxtrms07vqsq986pd.redis.rds.aliyuncs.com}'}
    password: ${r'${REDIS_PASSWORD:9VmgWYFCHpGA2MEQn}'}
  </#if>
</#if>

<#if dependMap['dubboProvider']?? || dependMap['dubboConsumer']??>
dubbo:
  application:
    name: ${removeUnderscore(name)}-service
    qosPort: 22222
  protocol:
    name: dubbo
    dubbo:
      payload: 104857600
  registry:
    id: ${removeUnderscore(name)}-service
    address: zookeeper://${r'${ZOOKEEPER_HOST:mse-483e4fd0-zk.mse.aliyuncs.com}'}:${r'${ZOOKEEPER_PORT:2181}'}
  <#if dependMap['dubboConsumer']??>
  provider:
    scan-packages: ${packageName}.api
    port: 20880
    version: 1.0.0
  </#if>
</#if>

<#if dependMap['idaas']??>
idaas:
  interceptor:
    login:
      enabled: true
    permission:
      enabled: true
  dubbo:
    enabled: true
  url: ${r'${IDAAS_URL:http://116.62.214.93:9528}'}
  platform: GOV
  appId: 20230203999999999999999999
</#if>