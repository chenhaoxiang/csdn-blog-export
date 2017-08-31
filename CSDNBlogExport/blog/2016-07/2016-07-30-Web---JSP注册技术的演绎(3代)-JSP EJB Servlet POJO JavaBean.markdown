---
layout: post
title: "Web---JSP注册技术的演绎(3代)-JSP EJB Servlet POJO JavaBean"
date: 2016-07-30 07:20:03 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- JSP/XML知识点
tags: [servlet,java,javabean,技术,ejb]
keyword: 陈浩翔, 谙忆
description: 我们可以这么理解JSP注册技术的发展过程： 
第一代JSP技术：纯JSP开发。 
第二代JSP技术：JSP+EJB开发。 
(EJB简单来说就是把已经编写好的程序（即：类）打包放在服务器上执行。) 
第三代JSP技术：JSP+Servlet+POJO开发。(**MVC框架) 
(POJO其实就是简单的JAVA类，也是简单的JavaBean(特殊的值对象封装))其实EJB—可理解成企业级的JavaBe 
---


我们可以这么理解JSP注册技术的发展过程： 
第一代JSP技术：纯JSP开发。 
第二代JSP技术：JSP+EJB开发。 
(EJB简单来说就是把已经编写好的程序（即：类）打包放在服务器上执行。) 
第三代JSP技术：JSP+Servlet+POJO开发。(**MVC框架) 
(POJO其实就是简单的JAVA类，也是简单的JavaBean(特殊的值对象封装))其实EJB—可理解成企业级的JavaBe
<!-- more -->
----------

我们可以这么理解JSP注册技术的发展过程：
第一代JSP技术：纯JSP开发。
第二代JSP技术：JSP+EJB开发。
(EJB简单来说就是把已经编写好的程序（即：类）打包放在服务器上执行。)
第三代JSP技术：JSP+Servlet+POJO开发。(**MVC框架)
(POJO其实就是简单的JAVA类，也是简单的JavaBean(特殊的值对象封装))

其实EJB---可理解成企业级的JavaBean(相对于简单的JavaBean增加了一些业务处理方法)

现在还有更新的技术，目前还没学到，学到后会第一时间写博客的。


演示纯JSP开发技术：
===========

regPurJsp.jsp:
--------------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  <h2>纯JSP开发的注册</h2>
  	<form action="doReg.jsp" method="post">
  		Name:<input type="text" name="name" /><br/>
  		Password:<input type="password" name="pwd"/><br/>
  		<input type="submit" value="注册"/>
  	</form>
  </body>
</html>

```

doReg.jsp:
----------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<%
  		request.setCharacterEncoding("utf-8");
  		String name = request.getParameter("name");
  		if(name!=null && name.trim().length()>0 && name.startsWith("hncu") ){
  			//访问后台
  			session.setAttribute("user", name);
  			out.println("success..."+name);
  			//其实还可以跳转到其他登录成功的jsp页面的，这里就省略了；
  			//request.getRequestDispatcher("success.jsp").forward(request, response);
  		}else{
  			out.println("failuer..."+name);
  			//可以跳转到其他登录失败的jsp页面的，这里就省略了；
  			//request.getRequestDispatcher("failure.jsp").forward(request, response);
  		}
  	%>
  </body>
</html>

```

演示结果就不演示了，相信大家一眼就能看出运行结果，不过是2个jsp页面跳转而已(后台数据库没写)，中间有一些java代码罢了。


JSP+EJB开发
=========

regEjbJsp.jsp:
----------------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<form action="doRegEjb.jsp" method="post">
  		Name:<input type="text" name="name"/><br/>
  		Age:<input type="text" name="age"/> <br/>
  		<input type="submit" value="注册"/>
  	</form>
  </body>
</html>

```

User.java:
----------

```
package cn.hncu.jspEjb.ejb;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private Integer age;
	public User() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	//在POJO(JavaBean)的基础上增加一些业务处理方法，就变成企业级JavaBean---EJB
	public boolean reg(){
		//可以再去调用DAO层。我这里简化了
		//UserDAO dao = UserDaoFactory.getUserDAO();
		//dao.reg(this.name,this.age);
		if(name.startsWith("hncu") && age>20){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @return 功能，返回所有的User
	 */
	public List<User> getAll(){
		return null;
	}
}

```



doRegEjb.jsp:
-------------

```
<%@page import="cn.hncu.jspEjb.ejb.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<%
  		request.setCharacterEncoding("utf-8");
  		String name = request.getParameter("name");
  		String strAge = request.getParameter("age");
  		//下面这一句强转需要再防范一下！！
  		int age = Integer.parseInt(strAge);
  		User user = new User();
  		user.setName(name);
  		user.setAge(age);
  		boolean boo = user.reg();
  		
  		if(boo){
  			//访问后台。。。
  			session.setAttribute("user",name);
  			out.print("success..."+name);
  			//也可以再写一个登录成功页面
  			//request.getRequestDispatcher("success.jsp").forward(request, response);
  		}else{
  			out.print("failure..."+name);
  			//也可以再写一个登录失败页面
  			//request.getRequestDispatcher("failure.jsp").forward(request, response);
  		}
  		
  		
  	
  	%>
  
  </body>
</html>

```


JSP(V)+Servlet(C)+POJO(M)开发的注册---MVC
====================================

这里把业务逻辑层从JavaBean分离开了！

user.java:
----------

```
package cn.hncu.regServletPojo.domain;

public class User {
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}

```

RegServlet.java:
----------------

```
package cn.hncu.regServletPojo.servlets;

import java.util.List;

import cn.hncu.regServletPojo.domain.User;

public class RegServlet {
	
	public boolean reg(User user){
		//再分一个DAO
		//UserDAO dao = UserDaoFactory.getUserDAO();
		//dao.reg(user);
		//要去数据库校验数据！！！！
		if(user.getName().startsWith("hncu") && user.getAge()>20 ){
			return true;
		}else{
			return false;
		}
	}
	
	//查询所有的User
	public List<User> getAll(){
		return null;
	}
}

```


regServletJsp.jsp:
------------------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<h2>JSP(V)+Servlet(C)+POJO(M)开发的注册---MVC</h2>
  	<form action="/myJspDemo2/RegServletPOJO" method="post">
  		Name:<input type="text" name="name"/><br/>
  		age:<input type="text" name="age"/><br/>
  		<input type="submit" value="注册"/>
  	</form>
  </body>
</html>

```

web.xml:
--------

```
<servlet>
    <servlet-name>RegServletPOJO</servlet-name>
    <servlet-class>cn.hncu.reg.servlet.RegServletPOJO</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>RegServletPOJO</servlet-name>
    <url-pattern>/RegServletPOJO</url-pattern>
  </servlet-mapping>	
```

RegServletPOJO.java:
--------------------

```
package cn.hncu.reg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hncu.regServletPojo.domain.User;
import cn.hncu.regServletPojo.servlets.RegServlet;

public class RegServletPOJO extends HttpServlet {
	
	//注入servlet
	RegServlet service = new RegServlet();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		
		//下面的解析需要防范
		int age = Integer.parseInt(strAge);
		
		User user = new User();
		user.setName(name);
		user.setAge(age);
		
		boolean boo = service.reg(user);
		
		if(boo){
			//访问后台。。
			request.getSession().setAttribute("user", name);
			out.print("success..."+name);
			//可以转发到另外的成功页面
			//request.getRequestDispatcher("sussess.jsp").forward(request, response);
		}else{
			out.print("failure..."+name);
			//可以转发到另外的失败页面
			//request.getRequestDispatcher("failure.jsp").forward(request, response);
		}
		
	}

}

```

JavaBean简介：
===========

JavaBean是一种可重用的软件组件。
一个JavaBean具有以下标准：
1、必须是一个公共的类。
2、必须有一个公开的无参的构造。
3、必须有getXxx和setXxx方法。


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
