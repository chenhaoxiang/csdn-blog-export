---
layout: post
title: "【错误解决】[Maven]使用Maven配置Jstl出现异常：The absolute uri  http   java.sun.com jsp jstl core cannot..."
date: 2016-09-19 09:35:25 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,❻ 其他,----- 上网技巧/问题解决
tags: [servlet,异常,uri,maven,jstl]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
也就是出现如下错误:严重: Servlet.service() for servlet jsp threw exception 
org.apache.jasper.JasperException: The absolute uri: http://java.sun.com/jsp/j 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
也就是出现如下错误:严重: Servlet.service() for servlet jsp threw exception 
org.apache.jasper.JasperException: The absolute uri: http://java.sun.com/jsp/j
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


也就是出现如下错误:

严重: Servlet.service() for servlet jsp threw exception
org.apache.jasper.JasperException: The absolute uri: http://java.sun.com/jsp/jstl/core cannot be resolved in either web.xml or the jar files deployed with this application
	at org.apache.jasper.compiler.DefaultErrorHandler.jspError(DefaultErrorHandler.java:56)
	at org.apache.jasper.compiler.ErrorDispatcher.dispatch(ErrorDispatcher.java:410)...

![](http://img.blog.csdn.net/20160919212430998)

我的JSP页面是这样导入的:

![](http://img.blog.csdn.net/20160919212507404)

我的maven是这样配置的:

![](http://img.blog.csdn.net/20160919212551170)

访问页面出现500错误。

解决方案:

一:
web项目出现如上问题，据查是版本问题：
    JSTL 1.0 的声明是：
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core " %>
    JSTL1.1以后 的声明是：
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

二：
一方案没问题后，可能是你的Tomcat缺少JSTL包，所以，你只需要在项目的lib下导入JSTL对应版本的包就可以解决该异常了。或者在Tomcat的lib下导入JSTL对应版本的包就可以了。




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
