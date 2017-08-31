---
layout: post
title: "【SpringBoot】SpringBoot基础-HelloWord实例"
date: 2017-01-22 05:41:55 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring Boot
tags: [SpringBoot,实例,优化,博客]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
这是我学习SpringBoot的入门系列哦，欢迎阅读。SpringBoot的简介我就不写一个篇章来介绍了，相信大家搜索一下，网上一大堆。首先，SpringBoot的推出不是用来替代Spirng的，而是精简Spring的配置的。也就是优化Spirng的。下面直接上实例吧。 
环境配置: 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
这是我学习SpringBoot的入门系列哦，欢迎阅读。SpringBoot的简介我就不写一个篇章来介绍了，相信大家搜索一下，网上一大堆。首先，SpringBoot的推出不是用来替代Spirng的，而是精简Spring的配置的。也就是优化Spirng的。下面直接上实例吧。 
环境配置:
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

这是我学习SpringBoot的入门系列哦，欢迎阅读。

SpringBoot的简介我就不写一个篇章来介绍了，相信大家搜索一下，网上一大堆。

首先，SpringBoot的推出不是用来替代Spirng的，而是精简Spring的配置的。也就是优化Spirng的。

下面直接上实例吧。
环境配置:
win7
Intellij IDEA 使用的是2016 1.2以后的版本
JDK1.8
Maven 3.3.9
Tomcat/8.5.6

#创建项目工程

使用IDEA新建一个SpringBoot项目。

##第一种创建方式 -使用Spring Initializr的方式

这种方式很简单。

![](http://img.blog.csdn.net/20170122170532702?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

注意这里的URL是: https://start.spring.io , 这个连接需要网络，用来查询Spring Boot的当前可用版本和组件列表！

然后选择下一步。

![](http://img.blog.csdn.net/20170122170846910?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

注意这些地方的选择！

然后点next。

![](http://img.blog.csdn.net/20170122170935193?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

在这里选择SpringBoot版本和SpringBoot组件！
例如我选择了Web项目组件。

点next

![](http://img.blog.csdn.net/20170122171039274?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

OK，这样就建出了SpringBoot的骨架了！
![](http://img.blog.csdn.net/20170122171201946?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

###SpringBootHelloApplication.java

```
package cn.hncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloApplication.class, args);
	}
}
```
###pom.xml
它自动生成的SpringBoot！注意，需要的包比较多，如果你以前没有那些包，可能下载需要一定时间，如果中途网络不好什么的，导致包下载不完全，那么解决办法就是把那个包删去，以及pom.xml中对应的语句也删去，然后再重新写到pom.xml中，重新下载对应的包！我就在这里被坑过一次！所以总是出现class找不到！
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>cn.hncu</groupId>
	<artifactId>springboothello</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>springBoot-Hello</name>
	<description>SpringBoot�HelloWord</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.BUILD-SNAPSHOT</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

	<repositories>
		<repository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
		<repository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>
	</repositories>
	<pluginRepositories>
		<pluginRepository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</pluginRepository>
		<pluginRepository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</pluginRepository>
	</pluginRepositories>

</project>
```

##第二种创建方式-使用创建Maven的方式

这种方式就是需要我们自己手动多写一些代码！

![](http://img.blog.csdn.net/20170122171714214?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

在这里我们选择Maven 的创建方式。在这里不做过多解释了。。。

![](http://img.blog.csdn.net/20170122171931878?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170122171942582?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

###现在的pom.xml是这样的

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>cn.hncu</groupId>
    <artifactId>springBootHelloM</artifactId>
    <version>1.0-SNAPSHOT</version>
    

</project>
```

###修改为

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>cn.hncu</groupId>
    <artifactId>springBootHelloM</artifactId>
    <version>1.0-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.2.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>1.4.2.RELEASE</version>
        </dependency>
    </dependencies>

</project>
```
![](http://img.blog.csdn.net/20170122172601153?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
这个不会帮你建好SpringBoot的骨架！所以要自己建

![](http://img.blog.csdn.net/20170122172944845?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

###SpringBootHelloApplication

```
package cn.hncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/1/22.
 * Time: 下午 5:25.
 * Explain:
 */
@SpringBootApplication
public class SpringBootHelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloApplication.class,args);
    }
}

```

使用注解@SpringBootApplication来标注它是一个SpringBoot应用，main方法使它成为了一个主程序。将在应用启动的时候执行！

这main方法里面的SpringBootHelloApplication这个类名，必须是使用了 @SpringBootApplication这个注解的类的类名哦。

###Hello

```
package cn.hncu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/1/22.
 * Time: 下午 5:27.
 * Explain:
 */
@RestController
public class Hello {
    @RequestMapping("/")
    String home(){
        return "你好，世界";
    }
}

```

这个就是springMvc的注解配置了。

等会就是直接访问:http://localhost:8080/ 然后看网页上的显示。

然后，我们直接运行那个main方法!

![](http://img.blog.csdn.net/20170122173510097?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170122173534932?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

```
2017-01-22 17:32:23.270  INFO 19888 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2017-01-22 17:32:23.322  INFO 19888 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
2017-01-22 17:32:23.334  INFO 19888 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.6
```

使用的Tomcat的访问端口和版本，都可以在输出的日志中看到！

然后我们访问网址:

http://localhost:8080/

![](http://img.blog.csdn.net/20170122173738676?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


我也是第一次使用SpringBoot，怎么说这个呢，现在给我的感觉就是简单很多了，以前部署Spring-Web项目是需要很多步骤的，现在变得特别简单，难怪现在SpringBoot越来越火了啊。确实感觉，小型项目架一个SpringBoot要省很多事。

我用的是Maven的方式创建的哦。
因为用Spring Initializr方式创建的话，就更简单！pom.xml和SpringBoot的入口程序都不用你写！

我会继续学下去，然后把自己的体验写出来，加油↖(^ω^)↗，谢谢大家支持.

本系列两个项目源码：
https://github.com/chenhaoxiang/SpringBoot/tree/master/day1
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
