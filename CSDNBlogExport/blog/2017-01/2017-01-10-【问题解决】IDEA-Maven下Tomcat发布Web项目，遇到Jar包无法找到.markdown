---
layout: post
title: "【问题解决】IDEA-Maven下Tomcat发布Web项目，遇到Jar包无法找到"
date: 2017-01-10 02:39:22 +0800
comments: true
categories:❻ 其他,----- 上网技巧/问题解决
tags: [tomcat,idea,jar,web]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
 
这个错误坑了我半天！！！百度谷歌上的解决方案差不多全部尝试了。 
还是无法解决。后来是解决了。问题是这样的： 
集成工具是:IDEA 
Maven建了一个Web项目，通过Tomcat发布了.SpringMVC依赖了一个文件上传的Jar包。我用Maven添加进去的。 
但是没起作用 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
 
这个错误坑了我半天！！！百度谷歌上的解决方案差不多全部尝试了。 
还是无法解决。后来是解决了。问题是这样的： 
集成工具是:IDEA 
Maven建了一个Web项目，通过Tomcat发布了.SpringMVC依赖了一个文件上传的Jar包。我用Maven添加进去的。 
但是没起作用
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

这个错误坑了我半天！！！百度谷歌上的解决方案差不多全部尝试了。
还是无法解决。后来是解决了。

问题是这样的：
集成工具是:IDEA
Maven建了一个Web项目，通过Tomcat发布了.

SpringMVC依赖了一个文件上传的Jar包。我用Maven添加进去的。
但是没起作用，在项目用Tomcat发布之后(可以正常发布)，用到那个Jar包时会出现找不到类的错误。

```
exception:
javax.servlet.ServletException: Servlet.init() for servlet springMvc threw exception
	org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:472)
	org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:99)
	.........

root cause:
java.lang.NoClassDefFoundError: org/apache/commons/fileupload/FileItemFactory
	java.lang.Class.getDeclaredConstructors0(Native Method)
	java.lang.Class.privateGetDeclaredConstructors(Class.java:2404)

	.........


root cause:
java.lang.ClassNotFoundException: org.apache.commons.fileupload.FileItemFactory
	org.apache.catalina.loader.WebappClassLoader.loadClass(WebappClassLoader.java:1714)
	org.apache.catalina.loader.WebappClassLoader.loadClass(WebappClassLoader.java:1559)

	.........
```
意思是找不到org.apache.commons.fileupload.FileItemFactory这个路径下的jar
或者是jar不完全导致的
当时我用的版本是1.2.2.

pom.xml中添加的是这样的:
```
<!--文件上传依赖的Jar包-->
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>1.2.2</version>
        </dependency>
```

在项目中可以看到这个包的结构，也就是成功导入了。

可是还是会出现这个问题。

我的解决办法是这样的:

首先删除这个包的dependency
```
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>1.2.2</version>
        </dependency>
```
保存，
项目右键-->Maven-->Reimport .

然后再编辑pom.xml:
添加:

```
<dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>1.3.2</version>
        </dependency>
```

还有，我估摸着这个1.2.2的版本有问题，如果你其他的包出现了问题，不妨换个版本试试！！！

还有一件事要做：

![](http://img.blog.csdn.net/20170110143605370?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

你需要把这个包从项目中put到tomcat中这个项目的lib中去！这步很关键。

有的时候，也有可能是这步的问题哦。

我这个问题估计是由于在maven down依赖的时候出现中断，然后jar包里面的类不全导致的，或者是1.2.2这个版本的包有问题。

然后重新发布，OK。
其他的包出现无法找到的情况，可以参考本篇哦。

希望能解决你的问题。

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
