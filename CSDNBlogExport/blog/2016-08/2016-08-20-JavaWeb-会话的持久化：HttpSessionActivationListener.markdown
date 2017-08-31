---
layout: post
title: "JavaWeb-会话的持久化：HttpSessionActivationListener"
date: 2016-08-20 11:56:20 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅
tags: [session,会话的持久性,钝化,活化]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处： http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
要实现会话的持久化，也就是实现HttpSessionActivationListener接口。实现此接口的JavaBean,可以感知自己被活化(从硬盘到内存)和钝化(从内存到硬盘)的过程。如果需要同时保存Session中的JavaBean。 
则JavaBean也要实现Seriali 
---


转载请注明出处： http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
要实现会话的持久化，也就是实现HttpSessionActivationListener接口。实现此接口的JavaBean,可以感知自己被活化(从硬盘到内存)和钝化(从内存到硬盘)的过程。如果需要同时保存Session中的JavaBean。 
则JavaBean也要实现Seriali
<!-- more -->
----------

<blockquote>
<p background-color='#D3D3D3'>转载请注明出处： http://blog.csdn.net/qq_26525215<br>
本文源自<strong>【<a href="http://blog.csdn.net/qq_26525215" target="_blank">大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

要实现会话的持久化，也就是实现HttpSessionActivationListener接口。

实现此接口的JavaBean,可以感知自己被活化(从硬盘到内存)和钝化(从内存到硬盘)的过程。

如果需要同时保存Session中的JavaBean。
则JavaBean也要实现Serializable序列化接口。

实现此接口的JavaBean与HttpSessionBindingListener一样，不必配置到web.xml中。必须配置到Tomcat服务器中！

其实就是在用户访问的时候，假如服务器突然关闭了，这个时候，用户的session就不存在了，假如是购物网站，也就相当于，用户好不容易选好的物品，刚刚添加到购物车，结果，因为服务器的突然关闭一下，什么都没了，这样很不好，于是我们就需要实现会话的持久化。

可以让我们在重新启动服务器之后用户的session还在服务器中存在！
即用户session的东西还全部在。
因为我们服务器在关闭的时候把用户的session存储到硬盘了(钝化)，在重新启动服务器之后，我们又从硬盘中恢复到内存中！（注意，只要用户还没关闭浏览器，那个session会一直存在用户的客户端的）
然后启动后，用户的信息就不会丢失！

要实现此功能，必须要先配置以下信息：

##第一步：书写一个JavaBean,并实现HttpSessionActivationListener接口如下：

```
package cn.hncu.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Person implements Serializable, HttpSessionActivationListener {
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println(this + "保存到硬盘了...");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println(this + "从硬盘读取并活化了...");
	}

	@Override
	public String toString() {
		return "Perosn [name=" + name + "]---"+super.toString();
	}

}

```


##第二步：JSP页面，判断是否存在Person，如果没有将Person放到Session中：(这一步只是为了演示出效果而加的，实际中不用)

```
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*, cn.hncu.domain.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <h2>演示session钝化与活化技术</h2>
    
    <%
       if(session.getAttribute("p")==null){
    	   Person p = new Person(""+ (new Random()).nextInt(100) );
    	   session.setAttribute("p", p);
       }
       System.out.println(session.getId()+"---"+ session.getAttribute("p") );
       Date d = new Date( session.getCreationTime() );
       System.out.println( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d) );
    %>
  </body>
</html>

```

##第三步：配置Tomcat的Server.xml文件或是将配置好的xml发布文件放到CATALIINA_HOME\conf\Catalina\localhost目录下：

一个小知识点:
此xml名字可以随便取,访问的时候是通过该xml的名字去访问的，不要用项目名了。
例如取名为aa.xml，则访问地址为:`http://localhost:8080/aa/`


![](http://img.blog.csdn.net/20160820175617272)


假如取名为aa.xml然后用项目名`http://localhost:8080/sessionActivationWeb/`去访问了，会出现session钝化的时候，无法在e:/a目录下找到。但是活化没有受影响！！！

通过`http://localhost:8080/aa/` 去访问就可以在e:/a目录下找到

**建议**，将xml名字取为:x项目名.xml,这样就可以直接通过`http://localhost:8080/项目名`  访问，这样session也可以存储到指定路径了！

![](http://img.blog.csdn.net/20160820224015038)

```
<Context path="/sessionActivationWeb"    docBase="E:/MyEclipse10_workspace/sessionActivationWeb/WebRoot">
<Manager className="org.apache.catalina.session.PersistentManager"
  saveOnRestart="true">
  <Store className="org.apache.catalina.session.FileStore"
         directory="e:/a"> </Store>
</Manager>
</Context>
```

directory="e:/a"
配置的是在服务器关闭后，内存中session存储的路径。
指Session文件保存的目录。

Context path="/sessionActivationWeb"    
sessionActivationWeb是项目名称！

docBase="E:/MyEclipse10_workspace/sessionActivationWeb/WebRoot"

E:/MyEclipse10_workspace/sessionActivationWeb/WebRoot
为项目下的WebRoot路径



##第四步：测试

1：多次开启新的浏览器窗口，并记录SESSIONID。
2：使用shutdown.bat关闭tomcat应用。
3：观察指定的目录下是否存在*.session文件。
4：再次重新启动tomcat，并使用http://localhost:8080/project;jsessionid=xxxxx指定sessionid的方式访问服务器。
(不关闭浏览器也行，再次访问就不要加jsessionid了)
5：观察是否为关闭tomcat之前的同一个Session。
6：一般情况下，PersistentManager持久化Session与Cookie共同使用。
7：HttpSessionActivationListener只做为监听类，监听自己是否钝化或是活化。

![](http://img.blog.csdn.net/20160820225027885)

###使用shutdown.bat关闭tomcat应用:

![](http://img.blog.csdn.net/20160820225044073)

<blockquote>
<p background-color='#D3D3D3'>转载请注明出处： http://blog.csdn.net/qq_26525215<br>
本文源自<strong>【<a href="http://blog.csdn.net/qq_26525215" target="_blank">大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>



本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
