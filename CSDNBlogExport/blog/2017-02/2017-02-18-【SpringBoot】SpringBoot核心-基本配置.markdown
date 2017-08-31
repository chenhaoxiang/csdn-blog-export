---
layout: post
title: "【SpringBoot】SpringBoot核心-基本配置"
date: 2017-02-18 03:49:17 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring Boot
tags: [java,springBoot]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


怎么建立springboot项目就不再累赘介绍啦

入口类和@SpringBootApplication

SpringBoot 通常有一个名为*Application的入口类，入口类里有一个main方法，这个main方法其实就是一个标准的Java应用的入口方法。

在main方 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


怎么建立springboot项目就不再累赘介绍啦

入口类和@SpringBootApplication

SpringBoot 通常有一个名为*Application的入口类，入口类里有一个main方法，这个main方法其实就是一个标准的Java应用的入口方法。

在main方
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

怎么建立springboot项目就不再累赘介绍啦

#入口类和@SpringBootApplication

SpringBoot 通常有一个名为*Application的入口类，入口类里有一个main方法，这个main方法其实就是一个标准的Java应用的入口方法。

在main方法中使用SpringApplication.run(SpringBoot21Application.class, args),启动Spring Boot 应用项目。

@SpringBootApplication是Spring Boot的核心注解，它是一个组合注解，其源码如下：

```
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.springframework.boot.autoconfigure;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.annotation.AliasFor;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {        @Filter(
            type = FilterType.CUSTOM,
            classes = {TypeExcludeFilter.class}
        ),         @Filter(
            type = FilterType.CUSTOM,
            classes = {AutoConfigurationExcludeFilter.class}
        )}
)
public @interface SpringBootApplication {
    @AliasFor(
        annotation = EnableAutoConfiguration.class,
        attribute = "exclude"
    )
    Class<?>[] exclude() default {};

    @AliasFor(
        annotation = EnableAutoConfiguration.class,
        attribute = "excludeName"
    )
    String[] excludeName() default {};

    @AliasFor(
        annotation = ComponentScan.class,
        attribute = "basePackages"
    )
    String[] scanBasePackages() default {};

    @AliasFor(
        annotation = ComponentScan.class,
        attribute = "basePackageClasses"
    )
    Class<?>[] scanBasePackageClasses() default {};
}

```

我们看简化后的：

```
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public @interface SpringBootApplication {
    Class<?>[] exclude() default {};
    String[] excludeName() default {};
}

```
@SpringBootApplication注解主要组合了@SpringBootConfiguration
，@EnableAutoConfiguration，@ComponentScan；

@SpringBootConfiguration也是一个组合注解，源码如下：
```
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
public @interface SpringBootConfiguration {
}
```
其主要注解是Configuration注解。

如果不使用@SpringBootApplication注解，则可以在入口类上直接使用@Configuration、@EnableAutoConfiguration、@ComponentScan。

其中，@EnableAutoConfiguration让Spring Boot根据类路径中的jar包依赖为当前项目进行自动配置。

例如：
添加了spring-boot-starter-web依赖，会自动添加Tomcat和spring MVC的依赖，那么Spring Boot会对Tomcat和SpringMVC进行自动配置。

又如：
添加了spring-boot-starter-data-jpa依赖，SpringBoot会自动进行JPA相关的配置。

Spring Boot会自动扫描@SpringBootApplication所在类的同级包以及下级包中的Bean（若为JPA项目还可以扫描标注@Entity的实体类）。

建议入口类放置的位置在groupId+arctifactId组合的包名下。

#关闭特定的自动配置

通过上面的@SpringBootApplication的源码我们可以看出，关闭特定的自动配置应该使用@SpringBootApplication注解的exclude参数，例如：
```
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
```

#定制Banner

##修改Banner

在Spring Boot启动的时候会有一个默认启动图案，如下图：

![](http://img.blog.csdn.net/20170217172504083?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

我们可以在项目的src/main/resources下新建一个banner.txt。

接下来，我们可以通过
http://patorjk.com/software/taag 
http://asciiset.com/figletserver.html
http://www.askapache.com/online-tools/figlet-ascii/
网站生成字符，比如敲入的为"CHX"，然后将网站生成的字符复制到banner.txt中。
http://picascii.com/   图片转换为 ASCII 

你自己进网站看了就晓得了。


![](http://img.blog.csdn.net/20170217173359920?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这时再启动程序，图案已经变了，如下图：
![](http://img.blog.csdn.net/20170217173506822?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这个文件还可以引用外部变量。有四个变量可以用到：

```
${application.version}  MANIFEST.MF文件中的版本号  
${application.formatted-version} 上面的版本号前面加v后上括号  
${spring-boot.version}    springboot的版本号  
${spring-boot.formatted-version} springboot的版本号   
```
比如我在banner.txt中写了一行
```
::CHX::  (${spring-boot.version})
```
启动后显示就是
```
::CHX::  (1.5.1.RELEASE)
```


##关闭banner

原main方法：

```
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot21Application.class, args);
	}
```

1、main里的内容修改为：

```
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringBoot21Application.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
```
Banner.Mode 有三个值 CONSOLE, LOG, OFF, 默认为 CONSOLE, 可以用 OFF 关闭 Banner 显示, 或是 LOG 让 Banner 在应用 log 中显示. 可支持用属性 spring.main.banner-mode=off 来控制. 

2、使用 Fluent builder API

```
	public static void main(String[] args) {
SpringApplicationBuilder(SpringBoot21Application.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}
```

#Spring Boot的配置文件

Spring Boot 使用一个全局的配置文件 application.properties或application.yml，放置在src/main/resoures目录或者类路径的/config下。

Spring Boot不仅支持常规的properties配置文件，还支持yaml语言的配置文件。
yaml是以数据为中心的语言，在配置数据的时候具有面向对象的特征。

Spring Boot 的全局配置文件的作用是对一些默认的配置值进行修改。

##简单示例

我们可以将Tomcat的默认端口8080修改为10090，并将默认的访问路径"/"修改为"/helloboot".

可以在application.properties中添加：

```
server.port=10090
server.context-path=/helloboot
```

如果是application.yml 则添加的是：

```
server:
	port: 10090
	contextpath: /helloboot
```

#starter pom

Spring Boot 为我们提供了简化企业级开发绝大多数场景的starter pom，只要使用了应用场景所需要的starter pom，相关的技术配置将会消除，就可以得到Spring Boot为我们提供的自动配置的Bean。

##Spring Boot 推荐的基础 POM 文件 

| 名称 | 描述|
| ------------- |:-------------:| 
| spring-boot-starter  | 核心 POM，包含自动配置支持、日志库和对 YAML 配置文件的支持。 | 
| spring-boot-starter-amqp | 通过 spring-rabbit 支持 AMQP。 | 
| spring-boot-starter-aop  | 包含 spring-aop 和 AspectJ 来支持面向切面编程（AOP）。  | 
| spring-boot-starter-batch  | 支持 Spring Batch，包含 HSQLDB。  | 
| spring-boot-starter-data-jpa  | 包含 spring-data-jpa、spring-orm 和 Hibernate 来支持 JPA。  | 
|  spring-boot-starter-data-mongodb | 包含 spring-data-mongodb 来支持 MongoDB。  | 
| spring-boot-starter-data-rest  |  通过 spring-data-rest-webmvc 支持以 REST 方式暴露 Spring Data 仓库。 | 
| spring-boot-starter-jdbc  |  支持使用 JDBC 访问数据库。 | 
| spring-boot-starter-security  | 包含 spring-security。  | 
| spring-boot-starter-test  |  包含常用的测试所需的依赖，如 JUnit、Hamcrest、Mockito 和 spring-test 等。 | 
| spring-boot-starter-velocity  |  支持使用 Velocity 作为模板引擎。 | 
|  spring-boot-starter-web |  支持 Web 应用开发，包含 Tomcat 和 spring-mvc。 | 
|  spring-boot-starter-websocket |  支持使用 Tomcat 开发 WebSocket 应用。 | 
| spring-boot-starter-ws  | 支持 Spring Web Services。  | 
|  spring-boot-starter-actuator | 添加适用于生产环境的功能，如性能指标和监测等功能。  | 
|  spring-boot-starter-remote-shell  | 添加远程 SSH 支持。  | 
|  spring-boot-starter-jetty  | 使用 Jetty 而不是默认的 Tomcat 作为应用服务器。  | 
| spring-boot-starter-log4j  | 添加 Log4j 的支持。  | 
|  spring-boot-starter-logging  | 使用 Spring Boot 默认的日志框架 Logback。  | 
|  spring-boot-starter-tomcat  | 使用 Spring Boot 默认的 Tomcat 作为应用服务器。  | 

还有一些第三方的starter pom，就不一一介绍了，有兴趣的可以自行搜索一下。

#使用xml配置

Spring Boot提倡零配置，即无xml配置，但是在实际项目中，可能有一些特殊要求你必须使用xml配置，这时我们可以通过Spring 提供的@ImportResource来加载xml配置，例如：

```
@ImportResource({"classpath:some-context.xml","classpath:another-context.xml"})
```

本篇博客涉及到的源码链接：
<blockquote cite='陈浩翔'>
<strong>【<a href='https://github.com/chenhaoxiang/SpringBoot/tree/master/springBoot2_1' target='_blank'>-&gt;点击访问源码-&copy;CHX</a>】</strong>
</blockquote>



本文章由<a href="https://chenhaoxiang.github.io/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
