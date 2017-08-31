---
layout: post
title: "JavaWeb-Servlet技术的监听器-解析与实例-网站在线用户信息与网页点击量"
date: 2016-08-20 04:27:48 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅
tags: [技术,实例,博客,web,监听器]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处： http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
在Web项目中，我们对下面这几个监听器必须熟练的使用，它们的作用真的很大。熟练的使用后，可以使我们少绕弯路，少写很多代码、事件源             监听对像的创建和销毁           监听对像上属性的添加和删除 
HttpSession       HttpSession 
---


转载请注明出处： http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
在Web项目中，我们对下面这几个监听器必须熟练的使用，它们的作用真的很大。熟练的使用后，可以使我们少绕弯路，少写很多代码、事件源             监听对像的创建和销毁           监听对像上属性的添加和删除 
HttpSession       HttpSession
<!-- more -->
----------

<blockquote>
<p background-color='#D3D3D3'>转载请注明出处： http://blog.csdn.net/qq_26525215<br>
本文源自<strong>【<a href="http://blog.csdn.net/qq_26525215" target="_blank">大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

在Web项目中，我们对下面这几个监听器必须熟练的使用，它们的作用真的很大。熟练的使用后，可以使我们少绕弯路，少写很多代码、

```
事件源             监听对像的创建和销毁           监听对像上属性的添加和删除 
HttpSession       HttpSessionListener        HttpSessionAttributeListener - HttpSessionEvent

ServletRequest    ServletRequestListenr          ServletRequestAttributeListener - ServletRequestEvent

ServletContext   ServletContextListener      ServletContextAttributeListener - ServletContextEvent
```


#监听ServletContext的创建和销毁：

开发步骤：
第一步：实现ServletContextListener接口。

```
implements ServletContextListener
```

第二步：实现两个方法。
contextInitialized
contextDestroyed

```
ServletContext对象(项目)创建:
public void contextInitialized(ServletContextEvent sce) 

ServletContext对象(项目)消亡:
public void contextDestroyed(ServletContextEvent sce) 
```

第三步：在web.xml中添加`<listener/>`节点。
为什么要配web.xml呢，因为我们的项目在启动的时候就需要监听，不可能由项目内部的类来完成，所以这个实现得依靠服务器了(在这里是Tomcat)

位置是在：filter- mapping标签之后 | listener | servlet标签之前

```
<listener>
    <listener-class>
	   完整类名
	</listener-class>
</listener>
```
这一点与swing中的添加监听有所区别。


第四步：测试
1、发布项目启动。
2、通过Tomcat管理控制台停止此项目。(注意，不要通过myEclipse直接停Java虚拟机了)


#监听ServletContext上的属性变化：

实现ServletContextAttributeListener接口：

```
implements ServletContextAttributeListener
```

实现三个方法：

```
	添加属性时自动调用
	public void attributeAdded(ServletContextAttributeEvent e) {	
	}

	删除属性时自动调用
	public void attributeRemoved(ServletContextAttributeEvent e) {	
	}

	修改属性时自动调用
	public void attributeReplaced(ServletContextAttributeEvent e) {	
	}
```

配置web.xml：

```
<listener>
    <listener class>
	    完整类名
    </listener-class>
</listener>
```

例如：在jsp页面中：

```
<%
     application.setAttribute("aa", "abc");//调用添加或修改属性时的方法
     application.removeAttribute("aa");//调用删除属性时的方法
%>

```

#实例-网站在线人信息与网页点击量

##分析：

###网页点击量：

```
记录一个网站的点击量。
当服务器关闭时，必须要保存到文件中或是数据库中去。
当服务器启动时，先从文件中读取并放到ServletContext。
在Filter中(用ServletRequestListenr也可以)记录访问量，每次访问都加1。

好处：信息不是太重要，没有必要每次用户访问都访问数据库或是操作文件。

在为不影响用户的速度感受，应该开始一个新的线程同去操作数据。
这样即使在后台使用同步技术，用户也不会感觉到速度很慢。
```

###在线人信息:

```
利用HttpSessionListener,监听HttpSession的创建和销毁。
sessionCreated
sessionDestroyed

Session的默认有效时间为30分。可以通过配置的方式修改它的值。
可以调用session.invalidate方法销毁当前Session.

主要作用是记录当前所有在线人数，无论是用户还是游客。

HttpSessionAttributeListener
主要作用是：记录当前在登录人数。注意，登录是指注册成为合法用户并成功登录的人。
```

##源码：

##index.jsp:

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>在线人的信息与网站点击量的实现</title>
  </head>
  
  <body>
    <h3>在线人的信息与网站点击量的实现</h3>
    <a href='<c:url value="servlet/ShowServlet"></c:url>'>查看在线人信息</a>
   	<hr/>
   	<form action='<c:url value="servlet/LoginServlet"></c:url>' method="post">
   		 姓名:<input type="text" name="name" />
         <input type="submit" value="登录">
   	</form>
   	
    <br/>点击量:${count}
  </body>
</html>

```


##MyServletRequestListenr

统计访问量：

```
package cn.hncu.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListenr implements ServletRequestListener{
	
	//有一个请求就会运行这里
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		ServletContext sct = sre.getServletContext();
		new MyThread(sct).start();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
	}
}

class MyThread extends Thread{
	private ServletContext sct = null;
	private static Object obj = new Object();
	public MyThread(ServletContext sct) {
		this.sct=sct;
	}

	@Override
	public void run() {
		synchronized (obj) {
			sct.setAttribute("count", (Integer) sct.getAttribute("count") + 1);
		}
	}
}
```

##MyServletContextListener

将访问量数据持久化：

```
package cn.hncu.listeners;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//从服务器硬盘把之前存储的点击量数据读取出来
		ServletContext sct = sce.getServletContext();
		String path = sct.getRealPath("/count.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			Integer count = Integer.valueOf(line);
			sct.setAttribute("count", count);
		} catch (Exception e) {
			//如果出异常了，我们认为文件还不存在，服务器第一次启动
			e.printStackTrace();
			sct.setAttribute("count",new Integer(0));
		}
		
	}
	
	//关闭服务器时
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//把当前servletContext容器中存储的点击量数据 永久化到  服务器硬盘
		ServletContext sct = sce.getServletContext();
		String path = sct.getRealPath("/count.txt");
		
		try {
			PrintWriter pw = new PrintWriter(path);
			pw.write(""+sct.getAttribute("count"));
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	
	}

}

```

##MyHttpSessionListener

统计在线人的信息

```
package cn.hncu.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	//有 游客/用户 来访问了
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		List<HttpSession> guests = (List<HttpSession>) se.getSession().getServletContext().getAttribute("guests");//在线人的集合
		if(guests==null){//第一个访问网站的人--沙发
			guests = new ArrayList<HttpSession>();
			se.getSession().getServletContext().setAttribute("guests", guests);//设置guests属性
		}
		guests.add(se.getSession());//将第一个用户的session添加到在线人集合
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		List<HttpSession> guests = (List<HttpSession>) se.getSession().getServletContext().getAttribute("fuses");
		if(guests.contains(se.getSession())){
			guests.remove(se.getSession());
		}
	}
}

```


##MyHttpSessionAttributeListener

统计在线用户的信息:

```
package cn.hncu.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener{
	
	//session添加属性了，就会调用下面的attributeAdded方法
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		if(se.getName().equals("name")){//代表添加了name属性
			System.out.println("用户"+se.getValue()+"登录了");
			List<HttpSession> logins = (List<HttpSession>) se.getSession().getServletContext().getAttribute("logins");
			
			if(logins==null){
				logins = new ArrayList<HttpSession>();
				se.getSession().getServletContext().setAttribute("logins", logins);
			}
			logins.add(se.getSession());
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
	}
	
}

```

##web.xml:

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" 
	xmlns="http://java.sun.com/xml/ns/javaee" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
  <display-name></display-name>
  
  <filter>
  	<filter-name>charset</filter-name>
  	<filter-class>cn.hncu.filter.CharsetFilter</filter-class>
  </filter>
  <filter-mapping>
  	<filter-name>charset</filter-name>
  	<url-pattern>/*</url-pattern>
  </filter-mapping>
  
  <listener>
  	<listener-class>cn.hncu.listeners.MyServletContextListener</listener-class>
  </listener>
  <listener>
  	<listener-class>cn.hncu.listeners.MyServletRequestListenr</listener-class>
  </listener>
  <listener>
  	<listener-class>cn.hncu.listeners.MyHttpSessionAttributeListener</listener-class>
  </listener>
  <listener>
  	<listener-class>cn.hncu.listeners.MyHttpSessionListener</listener-class>
  </listener>
  
  
  <servlet>
    <servlet-name>LoginServlet</servlet-name>
    <servlet-class>cn.hncu.servlets.LoginServlet</servlet-class>
  </servlet>
  <servlet>
    <servlet-name>ShowServlet</servlet-name>
    <servlet-class>cn.hncu.servlets.ShowServlet</servlet-class>
  </servlet>


  <servlet-mapping>
    <servlet-name>LoginServlet</servlet-name>
    <url-pattern>/servlet/LoginServlet</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>ShowServlet</servlet-name>
    <url-pattern>/servlet/ShowServlet</url-pattern>
  </servlet-mapping>
  
  
  
  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
</web-app>

```

#演示结果：

![](http://img.blog.csdn.net/20160820042304522)

#完整源码链接：

https://github.com/chenhaoxiang/Java/tree/master/myOnlinesWeb

myOnlinesWeb.zip文件。

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
