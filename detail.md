---
layout: post
title: "RBAC权限管理系统"
categories: RBAC
tags: RBAC
author: 百味皆苦
music-id: 2602106546
---

* content
{:toc}
### 数据表

#### 部门表

![](https://raw.githubusercontent.com/BaiWeiJieKu/BaiWeiJieKu.github.io/master/images/rbac/bumen.png)

#### 角色表

![](https://raw.githubusercontent.com/BaiWeiJieKu/BaiWeiJieKu.github.io/master/images/rbac/juese.png)

#### 用户表

![](https://raw.githubusercontent.com/BaiWeiJieKu/BaiWeiJieKu.github.io/master/images/rbac/yonghu.png)

#### 权限模块表

![](https://raw.githubusercontent.com/BaiWeiJieKu/BaiWeiJieKu.github.io/master/images/rbac/quanxianmokuai.png)

#### 权限表

![](https://raw.githubusercontent.com/BaiWeiJieKu/BaiWeiJieKu.github.io/master/images/rbac/quanxian.png)

#### 角色权限表

![](https://raw.githubusercontent.com/BaiWeiJieKu/BaiWeiJieKu.github.io/master/images/rbac/juesequanxian.png)

#### 角色用户表

![](https://raw.githubusercontent.com/BaiWeiJieKu/BaiWeiJieKu.github.io/master/images/rbac/jueseyonghu.png)

#### 日志表

![](https://raw.githubusercontent.com/BaiWeiJieKu/BaiWeiJieKu.github.io/master/images/rbac/rizhi.png)

### 项目初始化

#### pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.qinfen</groupId>
	<artifactId>permission</artifactId>
	<packaging>war</packaging>
	<version>0.0.1-SNAPSHOT</version>
	<name>permission Maven Webapp</name>
	<url>http://maven.apache.org</url>

	<properties>
		<springframework.version>4.3.10.RELEASE</springframework.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>4.0.0-b07</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.springframework/spring-beans -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-beans</artifactId>
			<version>${springframework.version}</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.springframework/spring-beans -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${springframework.version}</version>
		</dependency>
		<!--springmvc+springweb -->

		<!-- https://mvnrepository.com/artifact/org.springframework/spring-beans -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-web</artifactId>
			<version>${springframework.version}</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-beans -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${springframework.version}</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-beans -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>${springframework.version}</version>
		</dependency>

		<!-- mybatis -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.4.0</version>
		</dependency>
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>1.3.0</version>
		</dependency>

		<!-- druid数据源 -->
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>druid</artifactId>
			<version>1.0.20</version>
		</dependency>

		<!-- mysql -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.30</version>
		</dependency>

		<!-- lombok -->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.16.12</version>
		</dependency>

		<!-- Jackson -->
		<dependency>
			<groupId>com.fasterxml.jackson.datatype</groupId>
			<artifactId>jackson-datatype-guava</artifactId>
			<version>2.5.3</version>
		</dependency>

		<!-- logback -->
		<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-core</artifactId>
			<version>1.1.8</version>
		</dependency>
		<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-classic</artifactId>
			<version>1.1.8</version>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
			<version>1.7.22</version>
		</dependency>

		<!-- jsp api -->
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>jsp-api</artifactId>
			<version>6.0.36</version>
		</dependency>

		<!-- validator -->
		<dependency>
			<groupId>javax.validation</groupId>
			<artifactId>validation-api</artifactId>
			<version>1.1.0.Final</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>5.2.4.Final</version>
		</dependency>

		<!-- tools -->
		<dependency>
			<groupId>commons-collections</groupId>
			<artifactId>commons-collections</artifactId>
			<version>3.2.2</version>
		</dependency>
		<dependency>
			<groupId>commons-codec</groupId>
			<artifactId>commons-codec</artifactId>
			<version>1.10</version>
		</dependency>

		<!-- jackson -->
		<dependency>
			<groupId>org.codehaus.jackson</groupId>
			<artifactId>jackson-core-asl</artifactId>
			<version>1.9.13</version>
		</dependency>
		<dependency>
			<groupId>org.codehaus.jackson</groupId>
			<artifactId>jackson-mapper-asl</artifactId>
			<version>1.9.13</version>
		</dependency>

		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
			<version>3.5</version>
		</dependency>

		<!-- email -->
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-email</artifactId>
			<version>1.4</version>
		</dependency>

		<!-- redis -->
		<dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
			<version>2.8.1</version>
			<type>jar</type>
		</dependency>
	</dependencies>
	<build>
		<finalName>permission</finalName>
	</build>
</project>

```

#### web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">

  <display-name>Archetype Created Web Application</display-name>
  <!--spring上下文监听器  -->
  <listener>
  	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  
  <!-- Spring beans 配置文件所在目录 -->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  
  <!-- spring mvc 配置 -->
  <servlet>
    <servlet-name>spring</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>spring</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
  
  <!-- Encoding编码过滤器 -->
  <filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
    <init-param>
    	<!--强制编码  -->
      <param-name>forceEncoding</param-name>
      <param-value>true</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern><!--拦截所有，包括*.js  -->
  </filter-mapping>
  
   <!-- druid -->
  <servlet>
    <servlet-name>DruidStatServlet</servlet-name>
    <servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
    <init-param>
      <param-name>loginUsername</param-name>
      <param-value>druid</param-value>
    </init-param>
    <init-param>
      <param-name>loginPassword</param-name>
      <param-value>druid</param-value>
    </init-param>
  </servlet>
  <servlet-mapping>
    <servlet-name>DruidStatServlet</servlet-name>
    <url-pattern>/sys/druid/*</url-pattern>
  </servlet-mapping>
  <filter>
    <filter-name>DruidWebStatFilter</filter-name>
    <filter-class>com.alibaba.druid.support.http.WebStatFilter</filter-class>
    <init-param>
      <param-name>exclusions</param-name>
      <param-value>*.js,*.css,*.jpg,*.png,*.ico,*.gif,/sys/druid/*</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>DruidWebStatFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
<!--登录过滤器  -->
  <filter>
    <filter-name>loginFilter</filter-name>
    <filter-class>com.mmall.filter.LoginFilter</filter-class>
  </filter>
  
  <filter-mapping>
    <filter-name>loginFilter</filter-name>
    <url-pattern>/sys/*</url-pattern>
    <url-pattern>/admin/*</url-pattern>
  </filter-mapping>
<!--权限过滤器，要写在登录过滤器之后，并且小于等于登录拦截的值  -->
  <filter>
    <filter-name>aclControlFilter</filter-name>
    <filter-class>com.mmall.filter.AclControlFilter</filter-class>
    <init-param>
      <param-name>targetFilterLifecycle</param-name>
      <param-value>true</param-value>
    </init-param>
    <init-param>
      <param-name>exclusionUrls</param-name><!--白名单  -->
      <param-value>/sys/user/noAuth.page,/login.page</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>aclControlFilter</filter-name>
    <url-pattern>/sys/*</url-pattern>
    <url-pattern>/admin/*</url-pattern>
  </filter-mapping>

  <welcome-file-list>
    <welcome-file>signin.jsp</welcome-file>
  </welcome-file-list>
  
</web-app>

```

#### applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.alibaba.com/schema/stat http://www.alibaba.com/schema/stat.xsd http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">
    <!--读取数据库文件  -->
    <bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="ignoreUnresolvablePlaceholders" value="true"/>
        <property name="locations">
            <list>
                <value>classpath:settings.properties</value>
            </list>
        </property>
    </bean>
	<!--配置Redis  -->
    <import resource="redis.xml" />
	<!--配置数据源  -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
        <property name="driverClassName" value="${db.driverClassName}" />
        <property name="url" value="${db.url}" />
        <property name="username" value="${db.username}" />
        <property name="password" value="${db.password}" />
        <property name="initialSize" value="3" />
        <property name="minIdle" value="3" />
        <property name="maxActive" value="20" />
        <property name="maxWait" value="60000" />
        <property name="filters" value="stat,wall" />
    </bean>
	<!--mybatis会话工厂  -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="configLocation" value="classpath:mybatis-config.xml" />
        <property name="dataSource" ref="dataSource" />
        <property name="mapperLocations" value="classpath:mapper/*.xml" />
    </bean>
	<!--mybatis接口配置  -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.mmall.dao" />
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory" />
    </bean>

    <!-- tx事务管理 -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource" />
    </bean>

    <tx:annotation-driven transaction-manager="transactionManager" />

    <!-- druid，对应数据源配置的filters -->
    <bean id="stat-filter" class="com.alibaba.druid.filter.stat.StatFilter">
        <property name="slowSqlMillis" value="3000" />
        <property name="logSlowSql" value="true" />
        <property name="mergeSql" value="true" />
    </bean>
    <bean id="wall-filter" class="com.alibaba.druid.wall.WallFilter">
        <property name="dbType" value="mysql" />
    </bean>

</beans>
```

#### spring-servlet.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">

	<!--spring管理注解 -->
	<context:annotation-config />

	<!-- 启动注解驱动的spring mvc 功能 -->
	<mvc:annotation-driven />
	<!--Http请求前后监听工具被spring管理 -->
	<mvc:interceptors>
		<bean class="com.mmall.common.HttpInterceptor" />
	</mvc:interceptors>
	<!-- 启动包扫描功能 -->
	<context:component-scan
		base-package="com.mmall.controller" />
	<context:component-scan
		base-package="com.mmall.service" />
	<!--允许访问静态资源  -->
	<mvc:resources location="/js/" mapping="/js/**" />
	<mvc:resources location="/css/" mapping="/css/**" />
	<mvc:resources location="/bootstrap3.3.5/"
		mapping="/bootstrap3.3.5/**" />
	<mvc:resources location="/assets/" mapping="/assets/**" />
	<mvc:resources location="/ztree/" mapping="/ztree/**" />
	<!--获取spring上下文工具被spring管理，不使用懒加载，项目启动就运行 -->
	<bean class="com.mmall.common.ApplicationContextHelper"
		lazy-init="false" />

	<!--<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping" 
		/> -->
	<!--在spring中注册全局异常处理类 -->
	<bean class="com.mmall.common.SpringExceptionResolver" />
	<!--信息返回形式，如json -->
	<bean
		class="org.springframework.web.servlet.view.BeanNameViewResolver" />
	<!--json处理类，在全局异常处理返回结果的时候用到 -->
	<bean id="jsonView"
		class="org.springframework.web.servlet.view.json.MappingJackson2JsonView" />

	<bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/views/" />
		<property name="suffix" value=".jsp" />
	</bean>
</beans>       
```

#### mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <settings>
        <setting name="safeRowBoundsEnabled" value="true"/>
        <setting name="cacheEnabled" value="false" />
        <setting name="useGeneratedKeys" value="true" /><!--自动生成主键id  -->
    </settings>

    <!--<typeAliases>-->
        <!---->
    <!--</typeAliases>-->

    <!--<plugins>-->
        <!--<plugin interceptor=""></plugin>-->
    <!--</plugins>-->

    <!--<typeHandlers>-->
        <!---->
    <!--</typeHandlers>-->

</configuration>
```

#### logback.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration scan="true" scanPeriod="60 seconds">

    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger - %msg%n</pattern>
        </encoder>
    </appender>

    <!--<appender name="permission" class="ch.qos.logback.core.rolling.RollingFileAppender">-->
        <!--<file>${catalina.home}/logs/permission.log</file>-->
        <!--<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">-->
            <!--<FileNamePattern>${catalina.home}/logs/permission.%d{yyyy-MM-dd}.log.gz</FileNamePattern>-->
        <!--</rollingPolicy>-->
        <!--<layout class="ch.qos.logback.classic.PatternLayout">-->
            <!--<pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger - %msg%n</pattern>-->
        <!--</layout>-->
    <!--</appender>-->
    <!---->
    <!--<logger name="xxx" level="INFO">-->
        <!--<appender-ref ref="permission"/>-->
    <!--</logger>-->

    <!-- TRACE < DEBUG < INFO < WARN < ERROR -->
    <root level="INFO">
        <appender-ref ref="STDOUT" />
    </root>

</configuration>
```

#### settings.properties

```properties
db.driverClassName=com.mysql.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8
db.username=root
db.password=123456
```

### 辅助工具类开发

#### 返回通用json对象

```java
package com.mmall.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
/**
 * json数据返回
 * @author Administrator
 *
 */
@Getter
@Setter
public class JsonData {

    private boolean ret;//结果

    private String msg;//消息

    private Object data;//数据

    public JsonData(boolean ret) {
        this.ret = ret;
    }

    public static JsonData success(Object object, String msg) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData success(Object object) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        return jsonData;
    }

    public static JsonData success() {
        return new JsonData(true);
    }

    public static JsonData fail(String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("ret", ret);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }
}

```

#### 全局异常类处理

- 定义一个全局异常处理类，并在spring-servlet.xml中注册他

```java
package com.mmall.common;

import com.mmall.exception.ParamException;
import com.mmall.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 全局异常处理类
 * @author Administrator
 *
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //请求的URL
    	String url = request.getRequestURL().toString();
        //处理完成后返回一个视图
    	ModelAndView mv;
    	//全局默认异常
        String defaultMsg = "System error";

        // 这里我们要求项目中所有请求json数据，都使用.json结尾,接收前台数据先校验是否符合实体类要求
        if (url.endsWith(".json")) {
            //如果这个异常时我们自定义的权限异常或者参数异常
            if (ex instanceof PermissionException || ex instanceof ParamException) {
                JsonData result = JsonData.fail(ex.getMessage());
                //结合spring-servlet.xml中的配置的bean向前台返回一个json格式的数据
                mv = new ModelAndView("jsonView", result.toMap());
            } else {
                //否则按照全局默认异常处理
                log.error("unknown json exception, url:" + url, ex);
                JsonData result = JsonData.fail(defaultMsg);
                mv = new ModelAndView("jsonView", result.toMap());
            }
        } else if (url.endsWith(".page")){ // 这里我们要求项目中所有请求page页面，都使用.page结尾
            log.error("unknown page exception, url:" + url, ex);
            JsonData result = JsonData.fail(defaultMsg);
            //这里返回的是一个视图，会去找exception.jsp
            mv = new ModelAndView("exception", result.toMap());
        } else {
            log.error("unknow exception, url:" + url, ex);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("jsonView", result.toMap());
        }

        return mv;
    }
}

```

- 自定义权限异常类

```java
package com.mmall.exception;
/**
 * 自定义异常类
 * @author Administrator
 *
 */
public class PermissionException extends RuntimeException {

    public PermissionException() {
        super();
    }

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionException(Throwable cause) {
        super(cause);
    }

    protected PermissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

```

- 自定义参数异常类

```java
package com.mmall.exception;
/**
 * 参数异常类
 * @author Administrator
 *
 */
public class ParamException extends RuntimeException {
    public ParamException() {
        super();
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamException(Throwable cause) {
        super(cause);
    }

    protected ParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

```

#### 参数校验工具-validator

- 定义数据校验类

```java
package com.mmall.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mmall.exception.ParamException;
import org.apache.commons.collections.MapUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/**
 * 数据校验（实体类，基于注解）
 * @author Administrator
 *
 */
public class BeanValidator {
	//全局校验工厂
    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    
    //校验方法，单个类
    public static <T> Map<String, String> validate(T t, Class... groups) {
        Validator validator = validatorFactory.getValidator();
        //获取校验结果
        Set validateResult = validator.validate(t, groups);
        if (validateResult.isEmpty()) {
            return Collections.emptyMap();//没有错误信息返回空map
        } else {
            //如果出现了异常，封装异常信息
            LinkedHashMap errors = Maps.newLinkedHashMap();
            Iterator iterator = validateResult.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation violation = (ConstraintViolation)iterator.next();
                //封装有问题的字段和错误信息
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
            return errors;
        }
    }
    
    //校验集合
    public static Map<String, String> validateList(Collection<?> collection) {
    	//判断集合是否为空
        Preconditions.checkNotNull(collection);
        //迭代器
        Iterator iterator = collection.iterator();
        Map errors;

        do {
            if (!iterator.hasNext()) {
                return Collections.emptyMap();//没有值，返回空集合
            }
            Object object = iterator.next();//否则获取当前数据
            errors = validate(object, new Class[0]);//调用校验单个方法
        } while (errors.isEmpty());

        return errors;
    }
    
    //校验任何对象
    public static Map<String, String> validateObject(Object first, Object... objects) {
        if (objects != null && objects.length > 0) {
            return validateList(Lists.asList(first, objects));
        } else {
            return validate(first, new Class[0]);
        }
    }
    
    /**
     * 只判断是否有异常
     * @param param
     * @throws ParamException，抛出自定义的参数异常com.mmall.exception.ParamException
     */
    public static void check(Object param) throws ParamException {
        Map<String, String> map = BeanValidator.validateObject(param);
        if (MapUtils.isNotEmpty(map)) {
            throw new ParamException(map.toString());
        }
    }
}

```

- 创建一个测试接收数据的实体类，并添加校验注解

```java
package com.mmall.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
/**
 * 测试校验类
 * @author Administrator
 *
 */
@Getter
@Setter
public class TestVo {

    @NotBlank
    private String msg;//不允许为空值

    @NotNull(message = "id不可以为空")
    @Max(value = 10, message = "id 不能大于10")
    @Min(value = 0, message = "id 至少大于等于0")
    private Integer id;

    private List<String> str;
}

```

- 测试参数校验

```java
@RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) throws ParamException {
        log.info("validate");
        //使用自定义参数校验类去校验接收的参数是否符合要求
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
```

#### 对象与json互转工具

```java
package com.mmall.util;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;
/**
 * json转换工具，类和json的转换
 * @author Administrator
 *
 */
@Slf4j
public class JsonMapper {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // config
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
    }
    /**
     * 对象转字符串
     * @param src
     * @return
     */
    public static <T> String obj2String(T src) {
        if (src == null) {
            return null;
        }
        try {
        	//如果是字符串，直接输出，否则转换为字符串
            return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
        } catch (Exception e) {
            log.warn("parse object to String exception, error:{}", e);
            return null;
        }
    }
    /**
     * 字符串转换为对象
     * @param src
     * @param typeReference
     * @return
     */
    public static <T> T string2Obj(String src, TypeReference<T> typeReference) {
        if (src == null || typeReference == null) {
            return null;
        }
        try {
            return (T) (typeReference.getType().equals(String.class) ? src : objectMapper.readValue(src, typeReference));
        } catch (Exception e) {
            log.warn("parse String to Object exception, String:{}, TypeReference<T>:{}, error:{}", src, typeReference.getType(), e);
            return null;
        }
    }
}

```

#### spring上下文获取工具

- 需要在spring-servlet.xml中进行注册，并且加@Component注解让spring去管理

```java
package com.mmall.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * 获取spring上下文工具类
 * @author Administrator
 *
 */
@Component("applicationContextHelper")//被spring管理
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }
    /**
     * 从applicationContext中取spring上下文的bean
     * @param clazz
     * @return
     */
    public static <T> T popBean(Class<T> clazz) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(clazz);
    }

    public static <T> T popBean(String name, Class<T> clazz) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(name, clazz);
    }
}

```

- 测试

```java
public JsonData validate(TestVo vo) throws ParamException {
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.calss);
    	SysAclModule module = moduleMapper.selectByPrimaryKey(1);
    	log.info(JsonMapper.obj2String(module));
    }
```

#### HTTP请求前后监听工具

- 需要在spring-servlet.xml中进行注册

```java
package com.mmall.common;

import com.mmall.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
/**
 * Http请求前后监听工具
 * @author Administrator
 *
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    private static final String START_TIME = "requestStartTime";
    /**
     * 请求处理之前调用执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取当前请求路径
    	String url = request.getRequestURI().toString();
        //获取请求参数
    	Map parameterMap = request.getParameterMap();
        log.info("request start. url:{}, params:{}", url, JsonMapper.obj2String(parameterMap));
        //记录请求相应时间，开始
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
        return true;
    }
    /**
     * 请求处理完之后执行，只执行正常请求
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        String url = request.getRequestURI().toString();
//        long start = (Long) request.getAttribute(START_TIME);
//        long end = System.currentTimeMillis();
//        log.info("request finished. url:{}, cost:{}", url, end - start);
        removeThreadLocalInfo();
    }
    /**
     * 请求处理完之后执行，任何请求，包括出现异常后也执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURI().toString();
        long start = (Long) request.getAttribute(START_TIME);
        long end = System.currentTimeMillis();
        log.info("request completed. url:{}, cost:{}毫秒", url, end - start);

        removeThreadLocalInfo();
    }
    /**
     * 移除当前线程的信息
     */
    public void removeThreadLocalInfo() {
        RequestHolder.remove();;
    }
}

```

#### 用户和请求线程工具类

```java
package com.mmall.common;

import com.mmall.model.SysUser;

import javax.servlet.http.HttpServletRequest;
/**
 * 请求holder，解决高并发，登录成功后把当前用户和请求存入，可在任意地方取出使用
 * @author Administrator
 *
 */
public class RequestHolder {

    private static final ThreadLocal<SysUser> userHolder = new ThreadLocal<SysUser>();

    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    public static void add(SysUser sysUser) {
        userHolder.set(sysUser);
    }

    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static SysUser getCurrentUser() {
        return userHolder.get();
    }

    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }

    public static void remove() {
        userHolder.remove();
        requestHolder.remove();
    }
}

```

#### 登录拦截器

- 在web.xml中配置

```java
package com.mmall.filter;

import com.mmall.common.RequestHolder;
import com.mmall.model.SysUser;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 登录过滤器
 * @author Administrator
 *
 */
@Slf4j
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        SysUser sysUser = (SysUser)req.getSession().getAttribute("user");
        if (sysUser == null) {
            String path = "/signin.jsp";
            resp.sendRedirect(path);
            return;
        }
        //如果登陆成功把用户信息放到RequestHolder中，使用的时候再取出来
        RequestHolder.add(sysUser);
        RequestHolder.add(req);
        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }

    public void destroy() {

    }
}

```

#### IP获取工具类

```java
package com.mmall.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * IP获取工具类，不同服务器有差别
 * @author Administrator
 *
 */
@Slf4j
public class IpUtil {

    public final static String ERROR_IP = "127.0.0.1";

    public final static Pattern pattern = Pattern.
            compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})");

    /**
     * 取外网IP
     *
     * @param request
     * @return
     */
    public static String getRemoteIp(HttpServletRequest request) {
        String ip = request.getHeader("x-real-ip");
        if (ip == null) {
            ip = request.getRemoteAddr();
        }

        //过滤反向代理的ip
        String[] stemps = ip.split(",");
        if (stemps != null && stemps.length >= 1) {
            //得到第一个IP，即客户端真实IP
            ip = stemps[0];
        }

        ip = ip.trim();
        if (ip.length() > 23) {
            ip = ip.substring(0, 23);
        }

        return ip;
    }

    /**
     * 获取用户的真实ip
     *
     * @param request
     * @return
     */
    public static String getUserIP(HttpServletRequest request) {

        // 优先取X-Real-IP
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if ("0:0:0:0:0:0:0:1".equals(ip)) {
                ip = ERROR_IP;
            }
        }

        if ("unknown".equalsIgnoreCase(ip)) {
            ip = ERROR_IP;
            return ip;
        }

        int pos = ip.indexOf(',');
        if (pos >= 0) {
            ip = ip.substring(0, pos);
        }

        return ip;
    }

    public static String getLastIpSegment(HttpServletRequest request) {
        String ip = getUserIP(request);
        if (ip != null) {
            ip = ip.substring(ip.lastIndexOf('.') + 1);
        } else {
            ip = "0";
        }
        return ip;
    }

    public static boolean isValidIP(HttpServletRequest request) {
        String ip = getUserIP(request);
        return isValidIP(ip);
    }

    /**
     * 判断我们获取的ip是否是一个符合规则ip
     *
     * @param ip
     * @return
     */
    public static boolean isValidIP(String ip) {
        if (StringUtils.isEmpty(ip)) {
            log.debug("ip is null. valid result is false");
            return false;
        }

        Matcher matcher = pattern.matcher(ip);
        boolean isValid = matcher.matches();
        log.debug("valid ip:" + ip + " result is: " + isValid);
        return isValid;
    }

    public static String getLastServerIpSegment() {
        String ip = getServerIP();
        if (ip != null) {
            ip = ip.substring(ip.lastIndexOf('.') + 1);
        } else {
            ip = "0";
        }
        return ip;
    }

    public static String getServerIP() {
        InetAddress inet;
        try {
            inet = InetAddress.getLocalHost();
            String hostAddress = inet.getHostAddress();
            return hostAddress;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "127.0.0.1";
    }
}
```

#### 邮件发送工具类

```java
package com.mmall.util;

import com.mmall.beans.Mail;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
/**
 * 发送邮件工具类
 * @author Administrator
 *
 */
@Slf4j
public class MailUtil {

    public static boolean send(Mail mail) {

        // TODO
        String from = "";
        int port = 25;
        String host = "";
        String pass = "";
        String nickname = "";

        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName(host);
            email.setCharset("UTF-8");
            for (String str : mail.getReceivers()) {
                email.addTo(str);
            }
            email.setFrom(from, nickname);
            email.setSmtpPort(port);
            email.setAuthentication(from, pass);
            email.setSubject(mail.getSubject());
            email.setMsg(mail.getMessage());
            email.send();
            log.info("{} 发送邮件到 {}", from, StringUtils.join(mail.getReceivers(), ","));
            return true;
        } catch (EmailException e) {
            log.error(from + "发送邮件到" + StringUtils.join(mail.getReceivers(), ",") + "失败", e);
            return false;
        }
    }

}


```

```java
package com.mmall.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
/**
 * 需要发送的邮件信息
 * @author Administrator
 *
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

	/**
	 * 主题
	 */
    private String subject;
    
    /**
     * 内容
     */
    private String message;

    /**
     * 接收者
     */
    private Set<String> receivers;
}

```

#### MD5密码加密工具

```java
package com.mmall.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
/**
 * MD5密码加密工具
 * @author Administrator
 *
 */
@Slf4j
public class MD5Util {
	public static void main(String[] args) {
		System.out.println(MD5Util.encrypt("admin"));
	}

    public final static String encrypt(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            log.error("generate md5 error, {}", s, e);
            return null;
        }
    }
}

```

#### 随机生成密码工具类

```java
package com.mmall.util;

import com.mmall.model.SysUser;

import java.util.Date;
import java.util.Random;
/**
 * 密码处理工具类
 * @author Administrator
 *
 */
public class PasswordUtil {

    public final static String[] word = {
            "a", "b", "c", "d", "e", "f", "g",
            "h", "j", "k", "m", "n",
            "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G",
            "H", "J", "K", "M", "N",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"
    };

    public final static String[] num = {
            "2", "3", "4", "5", "6", "7", "8", "9"
    };
    /**
     * 随机生成密码
     * @return
     */
    public static String randomPassword() {
        StringBuffer stringBuffer = new StringBuffer();
        //根据时间戳生成随机规则
        Random random = new Random(new Date().getTime());
        boolean flag = false;
        int length = random.nextInt(3) + 8;//密码长度在8到10字符之间
        for (int i = 0; i < length; i++) {
            if (flag) {
                stringBuffer.append(num[random.nextInt(num.length)]);
            } else {
                stringBuffer.append(word[random.nextInt(word.length)]);
            }
            flag = !flag;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(randomPassword());
        Thread.sleep(100);
        System.out.println(randomPassword());
        Thread.sleep(100);
        System.out.println(randomPassword());
    }
}

```

#### 权限拦截器

```java
package com.mmall.filter;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import com.mmall.common.ApplicationContextHelper;
import com.mmall.common.JsonData;
import com.mmall.common.RequestHolder;
import com.mmall.model.SysUser;
import com.mmall.service.SysCoreService;
import com.mmall.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 权限拦截
 * @author Administrator
 *
 */
@Slf4j
public class AclControlFilter implements Filter {
	//排除URL
    private static Set<String> exclusionUrlSet = Sets.newConcurrentHashSet();
    //无权限访问时需要跳转到的页面URL
    private final static String noAuthUrl = "/sys/user/noAuth.page";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	//定义白名单
        String exclusionUrls = filterConfig.getInitParameter("exclusionUrls");
        //如果有多个拦截路径，就把他切割开，组装成list
        List<String> exclusionUrlList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(exclusionUrls);
        exclusionUrlSet = Sets.newConcurrentHashSet(exclusionUrlList);
        exclusionUrlSet.add(noAuthUrl);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取请求路径
        String servletPath = request.getServletPath();
        //获取请求参数列表
        Map requestMap = request.getParameterMap();
        //请求在白名单内则不拦截，放行
        if (exclusionUrlSet.contains(servletPath)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //取出当前登录用户
        SysUser sysUser = RequestHolder.getCurrentUser();
        //如果没有登录就访问权限，执行无权限方法
        if (sysUser == null) {
            log.info("someone visit {}, but no login, parameter:{}", servletPath, JsonMapper.obj2String(requestMap));
            noAuth(request, response);
            return;
        }
        //从工具类中获取权限service，进行逻辑处理
        SysCoreService sysCoreService = ApplicationContextHelper.popBean(SysCoreService.class);
        //是否有权限访问URL
        if (!sysCoreService.hasUrlAcl(servletPath)) {
            log.info("{} visit {}, but no login, parameter:{}", JsonMapper.obj2String(sysUser), servletPath, JsonMapper.obj2String(requestMap));
            noAuth(request, response);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }
    /**
     * 无权限访问方法
     * @param request
     * @param response
     * @throws IOException
     */
    private void noAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String servletPath = request.getServletPath();
        if (servletPath.endsWith(".json")) {
            JsonData jsonData = JsonData.fail("没有访问权限，如需要访问，请联系管理员");
            response.setHeader("Content-Type", "application/json");
            response.getWriter().print(JsonMapper.obj2String(jsonData));
            return;
        } else {
            clientRedirect(noAuthUrl, response);
            return;
        }
    }
    /**
     * 无权限，跳转无权限页面
     * @param url
     * @param response
     * @throws IOException
     */
    private void clientRedirect(String url, HttpServletResponse response) throws IOException{
        response.setHeader("Content-Type", "text/html");
        response.getWriter().print("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" + "<head>\n" + "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\"/>\n"
                + "<title>跳转中...</title>\n" + "</head>\n" + "<body>\n" + "跳转中，请稍候...\n" + "<script type=\"text/javascript\">//<![CDATA[\n"
                + "window.location.href='" + url + "?ret='+encodeURIComponent(window.location.href);\n" + "//]]></script>\n" + "</body>\n" + "</html>\n");
    }

    @Override
    public void destroy() {

    }
}

```

#### Redis缓存

- redis.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
	<!--读取Redis配置文件内容  -->
    <context:property-placeholder location="classpath:redis.properties" />
	<!--与spring关联的连接池  -->
    <bean id="jedisPoolConfig" class="redis.clients.jedis.JedisPoolConfig" />
	<!--核心配置  -->
    <bean id="shardedJedisPool" class="redis.clients.jedis.ShardedJedisPool" scope="singleton" >
        <constructor-arg index="0" ref="jedisPoolConfig" />
        <constructor-arg index="1">
            <list>
                <bean class="redis.clients.jedis.JedisShardInfo">
                    <constructor-arg name="host" value="${redis.host}"/>
                    <constructor-arg name="port" value="${redis.port}"/>
                    <constructor-arg name="timeout" value="${redis.timeout}"/>
                </bean>
            </list>
        </constructor-arg>
    </bean>

</beans>
```

- redis.properties

```properties
redis.host=127.0.0.1
redis.port=6379
redis.timeout=3000
```

- redis客户端配置

```java
package com.mmall.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;
/**
 * redis配置客户端
 * @author Administrator
 *
 */
@Service("redisPool")
@Slf4j
public class RedisPool {

    @Resource(name = "shardedJedisPool")
    private ShardedJedisPool shardedJedisPool;

    /**
     * 实例化
     * @return
     */
    public ShardedJedis instance() {
        return shardedJedisPool.getResource();
    }
    /**
     * 安全关闭
     * @param shardedJedis
     */
    public void safeClose(ShardedJedis shardedJedis) {
        try {
           if (shardedJedis != null) {
               shardedJedis.close();
           }
        } catch (Exception e) {
            log.error("return redis resource exception", e);
        }
    }
}

```

- Redis缓存的存储于获取

```java
package com.mmall.service;

import com.google.common.base.Joiner;
import com.mmall.beans.CacheKeyConstants;
import com.mmall.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;

import javax.annotation.Resource;
/**
 * 处理缓存cache
 * @author Administrator
 *
 */
@Service
@Slf4j
public class SysCacheService {

    @Resource(name = "redisPool")
    private RedisPool redisPool;
    /**
     * 保存cache
     * @param toSavedValue
     * @param timeoutSeconds
     * @param prefix
     */
    public void saveCache(String toSavedValue, int timeoutSeconds, CacheKeyConstants prefix) {
        saveCache(toSavedValue, timeoutSeconds, prefix, null);
    }

    public void saveCache(String toSavedValue, int timeoutSeconds, CacheKeyConstants prefix, String... keys) {
        //需要缓存的值为空，返回
    	if (toSavedValue == null) {
            return;
        }
        //获取连接
        ShardedJedis shardedJedis = null;
        try {
        	//生成缓存的key
            String cacheKey = generateCacheKey(prefix, keys);
            //创建Redis实例
            shardedJedis = redisPool.instance();
            //执行缓存操作
            shardedJedis.setex(cacheKey, timeoutSeconds, toSavedValue);
        } catch (Exception e) {
            log.error("save cache exception, prefix:{}, keys:{}", prefix.name(), JsonMapper.obj2String(keys), e);
        } finally {
            redisPool.safeClose(shardedJedis);
        }
    }
    /**
     * 获取cache
     * @param prefix
     * @param keys
     * @return
     */
    public String getFromCache(CacheKeyConstants prefix, String... keys) {
        ShardedJedis shardedJedis = null;
        String cacheKey = generateCacheKey(prefix, keys);
        try {
            shardedJedis = redisPool.instance();
            //根据key获取缓存数据
            String value = shardedJedis.get(cacheKey);
            return value;
        } catch (Exception e) {
            log.error("get from cache exception, prefix:{}, keys:{}", prefix.name(), JsonMapper.obj2String(keys), e);
            return null;
        } finally {
            redisPool.safeClose(shardedJedis);
        }
    }
    /**
     * 自动生成缓存的key
     * @param prefix
     * @param keys
     * @return
     */
    private String generateCacheKey(CacheKeyConstants prefix, String... keys) {
        //从枚举中获取前缀
    	String key = prefix.name();
    	//进行key的拼接
        if (keys != null && keys.length > 0) {
            key += "_" + Joiner.on("_").join(keys);
        }
        return key;
    }
}

```

- 缓存前缀枚举

```java
package com.mmall.beans;

import lombok.Getter;
/**
 * cache前缀
 * @author Administrator
 *
 */
@Getter
public enum CacheKeyConstants {

    SYSTEM_ACLS,

    USER_ACLS;

}

```

- 在applicationContext.xml中引入redis.xml
- 测试

```java
    /**
     * 从cache中获取当前用户的权限集合
     * @return
     */
    public List<SysAcl> getCurrentUserAclListFromCache() {
    	//获取当前用户的id
        int userId = RequestHolder.getCurrentUser().getId();
        //先从Redis缓存中获取数据
        String cacheValue = sysCacheService.getFromCache(CacheKeyConstants.USER_ACLS, String.valueOf(userId));
        //如果缓存中没有数据，就去数据库中查询数据，然后放入Redis缓存中
        if (StringUtils.isBlank(cacheValue)) {
            List<SysAcl> aclList = getCurrentUserAclList();
            if (CollectionUtils.isNotEmpty(aclList)) {
                sysCacheService.saveCache(JsonMapper.obj2String(aclList), 600, CacheKeyConstants.USER_ACLS, String.valueOf(userId));
            }
            return aclList;
        }
        return JsonMapper.string2Obj(cacheValue, new TypeReference<List<SysAcl>>() {
        });
    }
```



### 功能模块

#### 部门

- 添加部门信息：检查参数---部门查重---执行插入
- 获取部门树
- 更新部门信息：检查参数---查重---更新
- 删除部门：检查是否有该部门---部门下有子部门不允许删除---当前部门下有用户不允许删除

#### 用户

- 添加用户
- 更新用户
- 获取部门下的用户列表
- 获取用户权限数据
- 用户登录，注销

#### 权限模块

- 新增权限模块
- 更新权限模块和子模块
- 权限模块树
- 删除权限模块

#### 权限点（挂在权限模块下）

- 添加权限点
- 编辑权限点
- 根据权限模块获取权限点列表
- 获取权限点分配的用户和角色数据

#### 角色

- 新增角色
- 更新角色

#### 角色权限（RBAC核心）

- 获取角色权限树
- 使用zTree渲染页面

#### 角色用户

- 修改用户角色

#### 权限拦截

#### 权限缓存

### 源码

[源码](https://github.com/BaiWeiJieKu/permission)