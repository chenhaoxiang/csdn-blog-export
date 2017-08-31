---
layout: post
title: "【Spring】Maven的安装"
date: 2016-11-02 05:09:07 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring
tags: [apache,maven,项目管理,对象]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
首先，先介绍下Maven是啥吧。Apache Maven 是一个软件项目管理工具，基于项目对象模型(Project Object Model,POM)的概念，Maven可用来管理项目的依赖、编译、文档等信息。例如: 
以前我们需要依赖第三方jar包时，需要下载那个包，然后导入项目。 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
首先，先介绍下Maven是啥吧。Apache Maven 是一个软件项目管理工具，基于项目对象模型(Project Object Model,POM)的概念，Maven可用来管理项目的依赖、编译、文档等信息。例如: 
以前我们需要依赖第三方jar包时，需要下载那个包，然后导入项目。
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

首先，先介绍下Maven是啥吧。

Apache Maven 是一个软件项目管理工具，基于项目对象模型(Project Object Model,POM)的概念，Maven可用来管理项目的依赖、编译、文档等信息。

例如:
以前我们需要依赖第三方jar包时，需要下载那个包，然后导入项目。
现在有了Maven，就不一样了。
使用Maven管理项目时，项目依赖的jar包将不再包含在项目内，而是集中放置在用户的.m2文件夹中。

下载Maven:
Maven下载地址:
https://maven.apache.org/download.cgi

![](http://img.blog.csdn.net/20161102165651442)

点一个下载就好。

![](http://img.blog.csdn.net/20161102170043222)


下载完之后解压。

![](http://img.blog.csdn.net/20161102170115144)

配置系统环境变量。

![](http://img.blog.csdn.net/20161102170249571)
例如:
MAVEN_HOME
D:\apache-maven-3.3.9

添加到Path：

![](http://img.blog.csdn.net/20161102170356351)
Path
%MAVEN_HOME%\bin;

最后，就是测试一下Maven是否安装成功。
在控制台输入"mvn -v"。
以下信息表示安装成功。
![](http://img.blog.csdn.net/20161102170727027)


本文章由<a href="https://chenhaoxiang.github.io/">[谙忆]</a>编写， 所有权利保留。 
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
