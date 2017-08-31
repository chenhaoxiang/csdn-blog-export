---
layout: post
title: "【SpringMVC】SpringMVC配置拦截器 mvc exclude-mapping 报错"
date: 2017-03-28 03:31:45 +0800
comments: true
categories:❻ 其他,----- 上网技巧/问题解决
tags: [spring mvc,mvc]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天写SpringMVC的拦截器的时候，遇到这样一个错误， 
 
Element mvc:exclude-mapping is not allowed here.    <!-- SpringMVC拦截器 -->
    <mvc:interceptors>
        <mvc: 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天写SpringMVC的拦截器的时候，遇到这样一个错误， 
 
Element mvc:exclude-mapping is not allowed here.    <!-- SpringMVC拦截器 -->
    <mvc:interceptors>
        <mvc:
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

今天写SpringMVC的拦截器的时候，遇到这样一个错误，
![](http://img.blog.csdn.net/20170328032724585?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
Element mvc:exclude-mapping is not allowed here.

```
    <!-- SpringMVC拦截器 -->
    <mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/user/*"/> <!-- 拦截范围 -->
            <mvc:exclude-mapping path="/user/login.*"/> <!--不被拦截范围（路径）-->
            <bean class="com.uifuture.interceptor.UserLoginInterceptor"></bean>
        </mvc:interceptor>
    </mvc:interceptors>


```

经过一番搜索，找到了原因。

SpringMVC在3.2版本之前是不支持mvc:exclude-mapping 标签的。

可以将把
http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd
改成
http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd

这样问题可以得到解决。

![](http://img.blog.csdn.net/20170328033103089?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
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
