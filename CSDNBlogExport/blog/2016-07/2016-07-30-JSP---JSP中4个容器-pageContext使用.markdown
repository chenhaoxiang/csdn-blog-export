---
layout: post
title: "JSP---JSP中4个容器-pageContext使用"
date: 2016-07-30 01:30:03 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- JSP/XML知识点
tags: [session,servlet,page,应用]
keyword: 陈浩翔, 谙忆
description: 这里重点只讲pageContext容器的用法哦。 
因为另外的3个容器（request，session，application）在前面的servlet中已经演示过很多遍了




  容器                 作用域
pageContex         仅仅是当前页面，无法传参
request            当前页面，可以传参
session            同一个JS 
---


这里重点只讲pageContext容器的用法哦。 
因为另外的3个容器（request，session，application）在前面的servlet中已经演示过很多遍了




  容器                 作用域
pageContex         仅仅是当前页面，无法传参
request            当前页面，可以传参
session            同一个JS
<!-- more -->
----------

这里重点只讲pageContext容器的用法哦。
因为另外的3个容器（request，session，application）在前面的servlet中已经演示过很多遍了

```

  容器                 作用域
pageContex         仅仅是当前页面，无法传参
request            当前页面，可以传参
session            同一个JSESSIONID共用一个
application       只要服务器还没重新启动，就一直存在
```

详细介绍：

pageContext – 它的作用范围仅为当前JSP页面。

request – 对于用户的一次请求有效，请求/响应结束即消失。
更多细节：
一个请求通过Servlet访问资源，在Servlet中将数据封装到request中，这在单位中是通常的做法。必须记住、必须记住、必须记住。
然后将请求转发到JSP页面，在从JSP页面上将封装到request中的信息取出。MVC
注意我上面说的是转发，而不是重定向。
对于用户的一次请求，并且请求完成后，数据将不再使用可使用request进行封装，以节省内存。

 session – 对于用户的一次会话有效，通常我们用此域来封装用户登录的信息。也必须记住。
 
application – 在整个Web项目的生命周期内有效，不建议使用或谨慎使用。实际项目中根本不用。
开发原则 – 能用小的域尽量使用小的域。



setAttribute()和getAttribute:
============================

第一种：
----

index.jsP;

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<h2>演示一下JSP中的4个容器---重点是pageContext，因为之前3个在servlet中学了</h2>
  	<%
  		//从小到大的4个容器
  		pageContext.setAttribute("name", "page-jack");
  		request.setAttribute("name", "request-jack");
  		session.setAttribute("name", "session-jack");
  		application.setAttribute("name", "application-jack");
  	%>
  	
  	OKOK-------<br/>
  	
  	<%
  		//读取4个容器中的name属性值
  		out.println(pageContext.getAttribute("name"));
  		out.println("<br/>");
  		out.println(request.getAttribute("name"));
  		out.println("<br/>");
  		out.println(session.getAttribute("name"));
  		out.println("<br/>");
  		out.println(application.getAttribute("name"));
  	%>

  </body>
</html>

```

演示结果：
-----

![](http://img.blog.csdn.net/20160729140640951)



演示用pageContext设置4个容器的属性：
========================

index.jsp:
----------

```
<%
		//从小到大的4个容器
		//这一段的功能等价于那4个容器设置属性，这里全部通过pageContext.setAttribute()实现
		pageContext.setAttribute("name", "PAGE-Jack",PageContext.PAGE_SCOPE);
		pageContext.setAttribute("name", "REQUEST-Jack",PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("name", "SESSION-Jack",PageContext.SESSION_SCOPE);
		pageContext.setAttribute("name", "APPLICATION-Jack",PageContext.APPLICATION_SCOPE);
	%>
	<br/>
	<%
	//这一段的功能等价于之前用4个容器分别读取属性值，这里全部通过pageContext.getAttribute()实现
		out.println( pageContext.getAttribute("name", PageContext.PAGE_SCOPE) );
		out.println("<br/>");
		out.println( pageContext.getAttribute("name", PageContext.REQUEST_SCOPE) );
		out.println("<br/>");
		out.println( pageContext.getAttribute("name", PageContext.SESSION_SCOPE) );
		out.println("<br/>");
		out.println( pageContext.getAttribute("name", PageContext.APPLICATION_SCOPE) );
	%>

```


演示结果：
-----

![](http://img.blog.csdn.net/20160730010458021)



演示pageContext.findAttribute():
==============================


pageContext.findAttribute()方法会依次从pageContext、request、session和application中(页面、请求、会话、app)查找对应的属性，找到一个，后面的就不会再去找了。如果没有就返回null.


```
	<%
		out.println( pageContext.findAttribute("name") );
	%>
```

演示结果：

![](http://img.blog.csdn.net/20160730011939605)


顺便提一下ContentType与pageEncoding的区别：
=================================


pageEncoding是jsp文件本身的编码 ,把jsp文件编译成java的时候给编译器用的 。
contentType的charset是指服务器发送给客户端时的内容编码 ，是浏览器解析网页的时候用的 
如果两个任意设置了其中一个，另一个即会与此保持一致。但，contentType除可以设置charset外，还可以设置MIME类型，如text/html



本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
