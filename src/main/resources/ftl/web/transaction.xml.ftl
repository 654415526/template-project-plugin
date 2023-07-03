<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd">

    <bean id="txManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource" />
    </bean>
    <tx:advice id="txAdvice" transaction-manager="txManager">
        <tx:attributes>
            <tx:method name="query*" read-only="true" />
            <tx:method name="get*" read-only="true" />
            <tx:method name="select*" read-only="true" />
            <tx:method name="create*" />
            <tx:method name="delete*" />
            <tx:method name="del*" />
            <tx:method name="update*" />
            <tx:method name="batch*" />
            <tx:method name="set*" />
            <tx:method name="add*" />
            <tx:method name="register*" />
        </tx:attributes>
    </tx:advice>
    <aop:config>
        <aop:pointcut id="pointcut" expression="execution(* ${packageName}.server.service.impl.*.*(..))" />
        <aop:advisor advice-ref="txAdvice" pointcut-ref="pointcut" order="0" />
    </aop:config>

</beans>