---
layout: post
title: "【框架整合】Maven-SpringMVC3.X+Spring3.X+MyBatis3-日志、JSON解析、表关联查询等均已配置好"
date: 2017-01-11 12:19:23 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具
tags: [spring,mybatis,json,框架,博客]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
用来2天的时间，将框架整合了一下，中间遇到了很多小问题，也就不一一道来了。搭建这个框架我用了一个小工具，叫generator。 
这个工具是配合MyBatis用的，确实很不错，能帮你自动生成很多代码，极大的减少了你的工作量。generator在后面的链接中有下载的。使用方法很简单，生成 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
用来2天的时间，将框架整合了一下，中间遇到了很多小问题，也就不一一道来了。搭建这个框架我用了一个小工具，叫generator。 
这个工具是配合MyBatis用的，确实很不错，能帮你自动生成很多代码，极大的减少了你的工作量。generator在后面的链接中有下载的。使用方法很简单，生成
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

用来2天的时间，将框架整合了一下，中间遇到了很多小问题，也就不一一道来了。

搭建这个框架我用了一个小工具，叫generator。
这个工具是配合MyBatis用的，确实很不错，能帮你自动生成很多代码，极大的减少了你的工作量。

generator在后面的链接中有下载的。

使用方法很简单，生成的语句也在那里一个文件有。
修改那个generator.xml，里面有详细的解释哦、
然后运行那个生成语句就可以了。

在这里就不介绍啦。

在这个项目中，我主要就是整合一个框架出来，方便以后建立项目的时候使用。

sql语句在项目/src/main/目录下---使用的是MySQL.

运行generator自动生成代码前，需要先把数据库建好。

框架已经过了查询，插入测试，SpringMVC也经过了测试，都没有问题。

查询的话，里面写了关联查询。
你可以参照里面的来，都有详细的解释！
里面的SpringMVC，Spring，MyBatis，log4j的配置文件都有详细的注解！

这个项目写了2个版本，第一个是方便学习的，里面的关联查询用了3中方式写。

第二个版本方便你拿去修改，关联查询只留下了一个版本。

项目链接:
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'><a href='https://github.com/chenhaoxiang/S3S3M3'><font color="red">--&gt;点击访问本系列源码--</font></a><br>
</blockquote>




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
