---
layout: post
title: "JavaWeb-过滤器Filter学习(一)Filter知识点"
date: 2016-08-18 11:12:08 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅
tags: [filter,html,servlet,过滤器]
keyword: 陈浩翔, 谙忆
description: Filter简介　Filter也称之为过滤器，它是Servlet技术中最激动人心的技术，WEB开发人员通过Filter技术，对web服务器管理的所有web资源：例如Jsp, Servlet, 静态图片文件或静态 html 文件等进行拦截，从而实现一些特殊的功能。例如实现URL级别的权限访问控制、过滤敏感词汇、压缩响应信息、自动登录等一些高级功能。 
　　Servlet API中提供了一个Filter 
---


Filter简介　Filter也称之为过滤器，它是Servlet技术中最激动人心的技术，WEB开发人员通过Filter技术，对web服务器管理的所有web资源：例如Jsp, Servlet, 静态图片文件或静态 html 文件等进行拦截，从而实现一些特殊的功能。例如实现URL级别的权限访问控制、过滤敏感词汇、压缩响应信息、自动登录等一些高级功能。 
　　Servlet API中提供了一个Filter
<!-- more -->
----------

#Filter简介
　Filter也称之为过滤器，它是Servlet技术中最激动人心的技术，WEB开发人员通过Filter技术，对web服务器管理的所有web资源：例如Jsp, Servlet, 静态图片文件或静态 html 文件等进行拦截，从而实现一些特殊的功能。例如实现URL级别的权限访问控制、过滤敏感词汇、压缩响应信息、自动登录等一些高级功能。
　　Servlet API中提供了一个Filter接口，开发web应用时，如果编写的Java类实现了这个接口，则把这个java类称之为过滤器Filter。通过Filter技术，开发人员可以实现用户在访问某个目标资源之前，对访问的请求和响应进行拦截和增加功能.

如下所示：



#Filter是如何实现拦截的

Filter接口中有一个doFilter方法，当我们编写好Filter，并配置对哪个web资源进行拦截后，WEB服务器每次在调用web资源的service方法之前，都会先调用一下filter的doFilter方法，因此，在该方法内编写代码可达到如下目的：

```
调用目标资源之前，让一段代码执行。
是否调用目标资源（即是否让用户访问web资源）。
调用目标资源之后，让一段代码执行。
```

　　web服务器在调用doFilter方法时，会传递一个filterChain对象进来，filterChain对象是filter接口中最重要的一个对 象，它也提供了一个doFilter方法，开发人员可以根据需求决定是否调用此方法，调用该方法，则web服务器就会调用web资源的service方法，即web资源就会被访问，否则web资源不会被访问，也就是限制访问。


#Filter的实现分为2步:

```
1、编写java类实现Filter接口，并实现其doFilter方法。

2、在 web.xml 文件中使用<filter>和<filter-mapping>元素对编写的filter类进行注册，并设置它所能拦截的资源。

例：
<filter>
    <filter-name>jspCache</filter-name>
    <filter-class>cn.hncu.pubs.CharacterFilter</filter-class> 
    <!--配置FilterDemo02过滤器的初始化参数-->
    <init-param>
	   <description>配置jspCache过滤器的初始化参数</description>
	   <param-name>参数名</param-name>
	   <param-value>参数值</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>jspCache</filter-name>
    <url-pattern>*.jsp</url-pattern>
    <url-pattern>/servlet/*</url-pattern>
    <dispatcher>REQUEST</dispatcher>
    <dispatcher>FORWARD</dispatcher>
</filter-mapping>

 <url-pattern>可以写多个，同时过滤多个！！！

如果配置了多个过滤器，它们的先后位置(从前端到后台方向的先后顺序)是以“filter-mapping” 的书写顺序来定的  

<dispatcher>指定过滤器所拦截的资源被 Servlet 容器调用的方式，可以是REQUEST,INCLUDE,FORWARD和ERROR之一，默认REQUEST。
用户可以设置多个<dispatcher> 子元素用来指定 Filter 对资源的多种调用方式进行拦截。
```

##`<dispatcher>` 子元素可以设置的值及其意义：

REQUEST：当用户直接访问页面时，Web容器将会调用过滤器。如果目标资源是通过RequestDispatcher的include()或forward()方法访问时，那么该过滤器就不会被调用。

INCLUDE：如果目标资源是通过RequestDispatcher的include()方法访问时，那么该过滤器将被调用。除此之外，该过滤器不会被调用。

FORWARD：如果目标资源是通过RequestDispatcher的forward()方法访问时，那么该过滤器将被调用，除此之外，该过滤器不会被调用。

ERROR：如果目标资源是通过声明式异常处理机制调用时，那么该过滤器将被调用。除此之外，过滤器不会被调用。

#路径过滤解析：

```
也就是<url-pattern>中配的路径的说明：

---------例---------------说明--------------
      /*         过滤项目下所有资源
      *.jsp      过滤项目下所有jsp页面
      /jsp/*     过滤jsp 路径/目录 下的所有资源
	  /servlet/*     过滤servlet路径/目录 下的所有资源
	  /LoginServlet   只过滤该Servlet
	  login         只过滤名为“login”的servlet
```
注意:
/jsps/*.jsp  这个路径是错误的！
因为过滤器要求类似"*.jsp"这样的格式只能放在开头！


#Filter的三个必须覆盖的方法:

所有的过滤器都必须实现Filter接口。
该接口定义了init,doFilter0，destory()三个方法：

```
1、public void init (FilterConfig filterConfig) 
当开始使用servlet过滤器服务时(也就是服务器启动的时候)，Web容器调用此方法一次，为服务准备过滤器；
然后在需要使用过滤器的时候调用doFilter()，传送给此方法的FilterConfig对象，包含servlet过滤器的初始化参数。

2、public void doFilter(ServletRequest request，ServletResponse response，FilterChain chain)    
每个过滤器都接受当前的请求和响应，且FilterChain过滤器链中的过滤器（应该都是符合条件的）都会被执行。

doFilter方法中，过滤器可以对请求和响应做它想做的一切，通过调用他们的方法收集数据，或者给对象添加新的行为。

过滤器通过传送至 此方法的FilterChain参数，调用chain．doFilter()将控制权传送给下一个过滤器。当这个调用返回后，
过滤器可以在它的 Filter方法的最后对响应做些其他的工作。 

如果过滤器想要终止请求的处理或得到对响应的完全控制，则可以不调用下一个过滤 器，而将其重定向至其它一些页面。
当链中的最后一个过滤器调用chain．doFilter()方法时，将运行最初请求的Servlet。  
         
在调用完chain．doFilter()后，也就是运行了请求的Servlet 我们还可以继续做事！
         
3、public void destroy()
一旦doFilterO方法里的所有线程退出或已超时，容器调用此方法。
服务器调用destoryO以指出过滤器已结束服务，用于释放过滤器占用的资源。

(如果直接关闭JVM(Java虚拟机)则这个方法不好被运行)
```


转载请附上原文博客链接： 
http://blog.csdn.net/qq_26525215

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
