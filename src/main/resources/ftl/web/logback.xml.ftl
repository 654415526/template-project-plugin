<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <property name="LOG.FORMAT" value="%d{yyyy-MM-dd HH:mm:ss.SSS} [%X{requestId}] %-5level %logger{50} [%L] %.-1024msg%n"/>
    <property name="LOG.PATH" value="${r'${LOG_PATH:-/var/log/'+ name +'}'}"/>
    <property name="LOG.LEVEL" value="${r'${LOG_SQL_LEVEL:-info}'}"/>

    <!--引入默认的一些设置-->
    <include resource="org/springframework/boot/logging/logback/defaults.xml"/>
    <!--web信息-->
    <logger name="org.springframework" level="info"/>
    <logger name="${packageName}" level="info"/>
    <logger name="com.pixel.base" level="info"/>
    <logger name="org.springframework.scheduling" level="info"/>

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <pattern>${r'${LOG.FORMAT}'}</pattern>
        </encoder>
    </appender>

    <!-- 异常日志 -->
    <appender name="EXCEPTION_APPENDER" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${r'${LOG.PATH}'}/exception.log</file>
        <append>true</append>
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>ERROR</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <!--<receiver>balancebug@163.com</receiver>-->
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>${r'${LOG.PATH}'}/exception.log.%d{yyyy-MM-dd}_%i</fileNamePattern>
            <maxFileSize>500MB</maxFileSize>
            <maxHistory>7</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>${r'${LOG.FORMAT}'} %caller{0}</pattern>
        </encoder>
    </appender>

    <!-- 服务执行日志 -->
    <appender name="ROOT_APPENDER" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${r'${LOG.PATH}'}/root.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${r'${LOG.PATH}'}/root.log.%d{yyyy-MM-dd}</fileNamePattern>
            <maxHistory>1</maxHistory>
        </rollingPolicy>
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <pattern>${r'${LOG.FORMAT}'}</pattern>
        </encoder>
    </appender>

    <!--开发环境:打印控制台-->
    <root level="info">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="ROOT_APPENDER"/>
    </root>
    <root level="error">
        <appender-ref ref="EXCEPTION_APPENDER"/>
    </root>

</configuration>
