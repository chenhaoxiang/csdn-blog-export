---
layout: post
title: "Web---演示servlet技术(servlet生命周期) 解决中文乱码问题"
date: 2016-07-19 02:43:45 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅
tags: [servlet,html,技术,解决中文乱码]
keyword: 陈浩翔, 谙忆
description: 本节讲解决中文乱码问题的4种方法。 
还有更好的方法，也就是用过滤器，这里就不演示了，博主目前也不会~呼♪(^∇^*)~过段时间才会学。servlet生命周期演示：index.jsp:<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4 
---


本节讲解决中文乱码问题的4种方法。 
还有更好的方法，也就是用过滤器，这里就不演示了，博主目前也不会~呼♪(^∇^*)~过段时间才会学。servlet生命周期演示：index.jsp:<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4
<!-- more -->
----------

本节讲解决中文乱码问题的4种方法。
还有更好的方法，也就是用过滤器，这里就不演示了，博主目前也不会~呼♪(^∇^*)~过段时间才会学。


servlet生命周期演示：
============

index.jsp:
----------

```
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>
			演示servlet技术
		</title>
	</head>
	<body>
		<h2>演示servlet技术</h2>
		<a href="/myServletDemo/first">访问FirstServlet</a>
		<hr/>
	</body>
</html>
```

FirstServlet.java:
------------------

```
package cn.hncu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet{
	
	
	//只有第一次访问才会被执行一次,最先执行一次！
	public FirstServlet() {
		System.out.println("1 构造方法被执行..."+this);
	}

	
	//关闭Tomcat服务器时会执行一次。如果是通过myeclipse关闭的，是不会执行的，因为是直接关闭了java虚拟机。
	//最后执行一次
	@Override
	public void destroy() {
		System.out.println("4 destroy..."+this);
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}
	
	//第一次被访问才执行，在构造方法之后执行一次！
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2 init..."+this);
		String name = config.getInitParameter("name");
		System.out.println("name:"+name);
	}
	
	//每次访问都执行，(第一次)init()后执行
	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		System.out.println("333 servlet"+this);
	}

}

```

web.xml:
--------

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" 
	xmlns="http://java.sun.com/xml/ns/javaee" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
  <display-name></display-name>	
  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
  
  <servlet>
  	<servlet-name>firstServlet</servlet-name>
  	<servlet-class>cn.hncu.servlet.FirstServlet</servlet-class>
  	<init-param>
  		<param-name>name</param-name>
  		<param-value>Jack</param-value>
  	</init-param>
  	
  </servlet>
  <servlet-mapping>
  	<servlet-name>firstServlet</servlet-name>
  	<url-pattern>/first</url-pattern>
  </servlet-mapping>
  
</web-app>

```

配置需要初始化的参数：
```
<init-param>
  	<param-name>name</param-name>
  	<param-value>Jack</param-value>
</init-param>
```
在servlet中：
用config.getInitParameter("name");去得到name参数的值。

演示结果：
-----

我们点击访问：访问FirstServlet
看后台的输出信息：

![](http://img.blog.csdn.net/20160719134613673)

不关闭服务器再去访问：

![](http://img.blog.csdn.net/20160719134622564)

用myeclipse关闭服务器-因为是直接关闭了java虚拟机，所以不会再运行destroy()方法。也就没有再输出。

![](http://img.blog.csdn.net/20160719135419782)

用Tomcat的shutdown.bat关闭服务器：

![](http://img.blog.csdn.net/20160719135812002)



解决中文乱码问题
========

index.jsp中增加：
------------

```
<h2>以下演示用户登录</h2>
		<!-- 要向服务器传中文，前提是用post方式，get方式是肯定不行的 -->
		<form action="/myServlet/login" method="post">
			姓名：<input type="text" name="name"><br/>
			密码：<input type="password" name="pwd"><br/>
			<input type="submit" value="登录">		
		</form>
```

web.xml增加的代码：
-------------

```
 <servlet>
  	<servlet-name>login</servlet-name>
	<servlet-class>cn.hncu.servlet.LoginServlet</servlet-class>  	
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>login</servlet-name>
	<url-pattern>/login</url-pattern>  	
  </servlet-mapping>
  
```

LoginServlet.java:
------------------

```
package cn.hncu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet implements Servlet{

	@Override
	public void destroy() {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}
	
	
	private String charset = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		//法四：
		charset = config.getInitParameter("character");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//解决中文乱码问题
		//前提：前台页面必须以post方式提交中文---因为post会设置http协议头"Content-Type = application/x-www-form-urlencoded"，
		//这样Tomcat才知道这是编码的字符数据
		//法一：在Tomcat的server.xml中的<Connect>中添加一个属性：URLEncoding="utf-8"
		//！！！法一是不可取的，因为Tomcat是公共平台，这个项目只是其中的一个项目，
		//不能把平台看成私有的即最好不要去修改，否则其他项目可能会出现问题
		
		
		//法二：把Tomcat解错的码还原回来
		//这个方法还行，但如果前台传输的很多参数都是中文，那么我们要对每个参数都要进行这样还原，显然比较麻烦。
		//还有，如果以后要改编码，就得改源代码，对客户来说比较麻烦。对程序员也一样
		//String name = req.getParameter("name");
		//byte bs[] = name.getBytes("iso8859-1");
		//name = new String(bs,"utf-8");
		//System.out.println(name);
		
		//法三:这种解决方式是比较好的，但有一个缺点：如果以后要改编码，就得改源代码，对客户来说比较麻烦。对程序员也一样
		//req.setCharacterEncoding("utf-8");
		//String name = req.getParameter("name");
		
		//法四：其实是在web.xml中把编码设置成参数，然后在这里读取出来，利用“法2”进行设置。以后如果要更改编码，只要更改web.xml中的相应参数设置就OK了
		req.setCharacterEncoding(charset);
		
		
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		//用name和pwd到后台去访问数据库，以验证该用户信息是否正确（登录是否成功）
		//本例不是讲解这个，所以省略。
		
		res.setContentType("text/html;charset=utf-8");//告诉浏览器，我下面发的内容是什么格式的东西，什么编码的
		String html = "<html><body><font color='red'>name:</font>"+name+
				"<br/><font color='red'>pwd:</font>"+pwd+
				"</body></html>";
		
		PrintWriter out = res.getWriter();
		out.write(html);
		
		
		//*******另外一个小知识点：
		//Tomcat项目运行时，加载jar包或类文件的顺序：TOMCAT_HOME\lib  --> webapps\项目名\WEB-INF\lib  --> webapps\项目名\WEB-INF\classes目录下面的类
		//后加载的会覆盖前面的---即后加载有效-和java相反(父类加载机制)
		
	}

}

```

有2个小知识点：
--------
1：
Tomcat项目运行时，加载jar包或类文件的顺序：TOMCAT_HOME\lib  --> webapps\项目名\WEB-INF\lib  --> webapps\项目名\WEB-INF\classes目录下面的类
后加载的会覆盖前面的---即后加载有效-和java相反(父类加载机制)


2：

```
<!-- 下面这句是用来在服务器启动的时候就new好servlet，也就是说，不用在等第一个客户访问的时候再new了。增加了访问速度。但同时增加了服务器的负荷 -->
  	<!--15 这个数字是自己随便给的，如果有多个servlet 数字小的先new，也就是那个数字是决定newservlet的相对顺序的 -->
  	 <!-- <load-on-startup>15</load-on-startup> -->
```
加这个的位置是web.xml中，
![](http://img.blog.csdn.net/20160719144307688)




演示结果：
-----

一开始未写解决中文乱码时的演示结果：
![](http://img.blog.csdn.net/20160719142946298)

![](http://img.blog.csdn.net/20160719142954548)

后台显示：

![](http://img.blog.csdn.net/20160719143028110)



用中文乱码解决时（不把每一种方法的结果都演示出来了）

![](http://img.blog.csdn.net/20160719143302658)

![](http://img.blog.csdn.net/20160719143315847)

![](http://img.blog.csdn.net/20160719143323550)



本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
