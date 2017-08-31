---
layout: post
title: "Web---Cookie技术(显示用户上次登录的时间、显示用户最近浏览的若干个图片(按比例缩放))"
date: 2016-07-26 12:59:34 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅
tags: [图片,Cookie技术]
keyword: 陈浩翔, 谙忆
description: 本章博客讲解： 
1、Cookie基本用法演示 
2、演示Cookie的访问权限 
3、演示Cookie的删除 
4、利用Cookie显示用户上次登录的时间 
5、利用Cookie技术显示用户最近浏览的若干个图片 
6、测试火狐浏览器到底支持多少个Cookie和一个Cookie最大为多大1、Cookie基本用法演示index.jsp:<%@ page language="java" import=" 
---


本章博客讲解： 
1、Cookie基本用法演示 
2、演示Cookie的访问权限 
3、演示Cookie的删除 
4、利用Cookie显示用户上次登录的时间 
5、利用Cookie技术显示用户最近浏览的若干个图片 
6、测试火狐浏览器到底支持多少个Cookie和一个Cookie最大为多大1、Cookie基本用法演示index.jsp:<%@ page language="java" import="
<!-- more -->
----------

本章博客讲解：
1、Cookie基本用法演示
2、演示Cookie的访问权限
3、演示Cookie的删除
4、利用Cookie显示用户上次登录的时间
5、利用Cookie技术显示用户最近浏览的若干个图片
6、测试火狐浏览器到底支持多少个Cookie和一个Cookie最大为多大


1、Cookie基本用法演示
==============

index.jsp:
----------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<h1>演示Cookie技术</h1>
  	<a href="CookieDemo">Cookie基本用法演示</a><br/>
  	
  </body>
</html>

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
  <servlet>
    <servlet-name>CookieDemo</servlet-name>
    <servlet-class>cn.hncu.servlets.CookieDemo</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>CookieDemo</servlet-name>
    <url-pattern>/CookieDemo</url-pattern>
  </servlet-mapping>	
  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
</web-app>

```

CookieDemo.java:
----------------

```
package cn.hncu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//向客户端写cookie
		Random r = new Random();
		int n =r.nextInt(100);
		String name = "jack";//cookie的格式：key=value
		Cookie c = new Cookie("name", name+n);
		c.setMaxAge(60*60);//设置过期时间，以秒为单位
		c.setPath( request.getContextPath() );//该路径是:  /项目名
		//Cookie机制中，是通过path来控制权限的。只有<url-pattern>和该path相同或是它的子路径的servlet才能够访问该cookie
		//如果把一个cookie的path设为项目根目录，那么该项目下的所有servlet都能够访问它
		response.addCookie(c);
		
		//这一段演示cookie带中文
		String str = "我带中文";
		str  = URLEncoder.encode(str, "utf-8");//中文设置编码！！！urlencode编码
		Cookie cStr = new Cookie("str", str);
		//如果不设置setMaxAge，则浏览器一关闭就过期
		cStr.setPath("/");
		response.addCookie(cStr);
		
		//读取客户端发过来的cookie
		Cookie cs[] = request.getCookies();//读取cookie
		if(cs!=null){//防范一下
			for(Cookie cc:cs){
				String name2 = cc.getName();
				String val = cc.getValue();
				val = URLDecoder.decode(val, "utf-8");//原来是怎么编码的，就怎么解码！ 中文解码，ascii是原样的！
				out.print(name2+"="+val+"<br/>");
			}
		}
		
		out.print("Cook保存成功！");
	}

}

```

演示结果：
-----
![](http://img.blog.csdn.net/20160726085944979)

第一次点击时！session下次讲！tomcat自动生成发给客户端的！
![](http://img.blog.csdn.net/20160726085954416)

再次进入时！
name+n--因为后面的n一直在随机生成，这个点击总是显示的是前一个的信息！
![](http://img.blog.csdn.net/20160726090010151)


![](http://img.blog.csdn.net/20160726090022128)



2、演示Cookie的访问权限
===============

index.jsp:
----------

```
<a href="servlet/CookieDemo2">演示Cookie的访问权限</a><br/>
```

web.xml:
--------

```
<servlet>
    <servlet-name>CookieDemo2</servlet-name>
    <servlet-class>cn.hncu.servlets.CookieDemo2</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>CookieDemo2</servlet-name>
    <url-pattern>/servlet/CookieDemo2</url-pattern>
  </servlet-mapping>	
```

CookieDemo2.java:
-----------------

```
package cn.hncu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo2 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//向客户端写Cookie
		Random r = new Random();
		int n =r.nextInt(100);
		Cookie c = new Cookie("age", ""+n);
		c.setMaxAge(60*60);//过期时间
		c.setPath( request.getContextPath()+"/servlet/CookieDemo2" );//Cookie机制中,是通过path来控制权限的
		//由于CookieDemo的url-pattern是项目根目录/CookieDemo，不是当前cookie所设路径的子目录，因此无法访问到该cookie
		
		//注意！！！path不一样，那么cookie是不同的对象，也就是不会覆那个名字相同的cookie！
		response.addCookie(c);
		
		//读取从客户端发来的cookie
		Cookie cs[] = request.getCookies();
		if(cs!=null){
			for(Cookie cc:cs){
				String name = cc.getName();
				String val = cc.getValue();
				out.print("22222--"+name+"="+val+"<br/>");
			}
		}
		out.print("Cookie保存成功！");
		
	}
}

```


演示结果：
-----

先进入CookieDemo2的页面，能访问到CookieDemo的name-cookie

![](http://img.blog.csdn.net/20160726092113251)


再进入CookieDemo的页面，不能访问到CookieDemo2的age-cookie

![](http://img.blog.csdn.net/20160726092155533)




3、演示Cookie的删除
=============

index.jsp:
----------

```
	<a href="servlet/DelCookieDemo"> 演示Cookie的删除 </a><br/>
```

web.xml:
--------

```
<servlet>
    <servlet-name>DelCookieDemo</servlet-name>
    <servlet-class>cn.hncu.servlets.DelCookieDemo</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>DelCookieDemo</servlet-name>
    <url-pattern>/servlet/DelCookieDemo</url-pattern>
  </servlet-mapping>
```

DelCookieDemo.java:
-------------------

```
package cn.hncu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelCookieDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie cs[] = request.getCookies();
		if(cs!=null){
			for(Cookie c:cs){
		//要想遍历到"name"这个cookie，当前servlet必须要有读的权限，即servlet的url-pattern必须是该cookie所设路径或者是其所设路径的子路径
				//删除name这个cookie
				if("name".equals(c.getName())){
					c.setPath( request.getContextPath() );//删除时是通过这一句来判断权限的！这里必须和原来所设的路径完全一样才能删除，否则不能删除！
					//对于上句，我的个人理解是：因为如果你这个路径设置不同了，其实只是相当与新开了一个cookie，这个新cookie的到期时间是0，name是"name"
					
					c.setMaxAge(0);//到期时见设为0，即是删除---此处只是设置删除标识
					response.addCookie(c);
				}
			}
		}
	}
}

```

演示结果：
-----
这个时候，name还存在的。
![](http://img.blog.csdn.net/20160726094215778)

我们访问DelCookieDemo.

![](http://img.blog.csdn.net/20160726094236325)


再去第一个链接看：

![](http://img.blog.csdn.net/20160726094313107)

name已经没有了！

火狐会自动删除过期的cookie：

![](http://img.blog.csdn.net/20160726094442795)


4、利用Cookie显示用户上次登录的时间
=====================

index.jsp:
----------

```
<a href="LoginServlet">利用Cookie显示用户上次登录的时间</a>
```


web.xml:
--------

```
 <servlet>
    <servlet-name>LoginServlet</servlet-name>
    <servlet-class>cn.hncu.servlets.LoginServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>LoginServlet</servlet-name>
    <url-pattern>/LoginServlet</url-pattern>
  </servlet-mapping>
```

LoginServlet.java:
------------------

```
package cn.hncu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>演示利用Cookie显示用户上次登录的时间</TITLE></HEAD>");
		out.println("  <BODY>");
		
		//读取客户端的cookie
		Cookie cs[] = request.getCookies();
		boolean boo = false;
		if(cs!=null){
			for(Cookie c:cs){
				//遍历
				if("loginTime".equals(c.getName())){
					String val =c.getValue();
					long dt = Long.parseLong(val);
					Date d = new Date(dt);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
					out.print("您上次登录时间是："+sdf.format(d));
					boo=true;
					break;
				}
			}
		}
		if(boo==false){//表示之前1年没有访问记录！因为下面我们保存的过期时间是一年
			out.print("您最近一年是第一次访问。。。");
		}
		
		//无论是新旧用户，都会以最近的时间俩创建一个Cookie，写到客户端。原来有了的，就是更新时间
		Date d = new Date();
		Cookie c = new Cookie("loginTime", ""+d.getTime() );
		c.setPath(request.getContextPath());
		c.setMaxAge(60*60*24*30*12);
		response.addCookie(c);
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}

```

演示结果：
-----

第一次访问;
![](http://img.blog.csdn.net/20160726101133212)

再次访问：

![](http://img.blog.csdn.net/20160726101143463)







5、利用Cookie技术显示用户最近浏览的若干个图片
==========================

index.jsp:
----------

```
<a href="jsps/show.jsp">看美女--利用Cookie技术显示用户最近浏览的若干个图片</a>
```


web.xml:
--------

```
 <servlet>
    <servlet-name>ShowServlet</servlet-name>
    <servlet-class>cn.hncu.servlets.ShowServlet</servlet-class>
  </servlet>
<servlet-mapping>
    <servlet-name>ShowServlet</servlet-name>
    <url-pattern>/showImg</url-pattern>
  </servlet-mapping>
```

show.jsp:
---------

```
<%@page import="java.io.File"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<style type="text/css">
  		.span{
  			border:0px solid #000;
  			width:100px; 
  			height:100px;
  			overflow:hidden;
  		}
  		.span img{
  			max-width:100px;
  			_width:expression(this.width > 100 ? "100px" : this.width);
  		}
  		.spans{
  			border:0px solid #000;
  			width:50px; 
  			height:50px;
  			overflow:hidden;
  		}
  		.spans img{
  			max-width:50px;
  			_width:expression(this.width > 50 ? "50px" : this.width);
  		}
  		
  	</style>
  
  </head>
  
  <body>
  	<h1>看美女--利用Cookie技术显示用户最近浏览的若干个图片</h1>
  	
  	<a href="/myCookieWeb/jsps/show.jsp">看美女--利用Cookie技术显示用户最近浏览的若干个图片</a>
  	<h3>最近浏览的图片：</h3>
  	
  	<!-- 添加最近3次浏览的图片 -->
  	<%
  		String str =null;
  		Cookie cs[] = request.getCookies();
  		if(cs!=null){
  			for(Cookie c:cs){
  				if("images".equals(c.getName())){
  					str=c.getValue();// ***.jpg
  					break;
  				}
  			}
  		}
  		if(str!=null){
  			String strs[] = str.split(",");
  			for(String s:strs){
  				%>
					<span class="spans">
  						<img src="<%=request.getContextPath()%>/imgs/<%=s%>" />
  					</span>		
  				<%
  			}
  		}
  	 %>
  	
  	<br/><hr/><br/>
  	
  	<% 
  	//利用file遍历所有的图片，显示出来。
  	String path = getServletContext().getRealPath("/imgs");
  	//System.out.printf(path);//D:\apache-tomcat-7.0.30\webapps\myCookieWeb\jsps
  	File file = new java.io.File(path);
  	File[] files = file.listFiles();
  	if(files!=null){
  	%>
  	
  	<%
  		for(File f:files){
  			String imgName = f.getName();
  			%>
  				<span class="span">
  					<a href="<%=request.getContextPath() %>/showImg?img=<%=imgName %>">
  						<img src="<%=request.getContextPath()%>/imgs/<%=imgName%>" />
  					</a>
  				</span>
  			<%
  		}
  	%>
  	
  	<%
  		
  	}
  	%>
  	
  </body>
</html>

```


ShowServlet.java:
-----------------

```
package cn.hncu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String img = request.getParameter("img");
		String imgStr = "<img src='"+request.getContextPath()+"/imgs/"+img+"'/>";
		out.print(imgStr);
		
		//用Cookie记录用户访问过的图片信息
		Cookie cs[] = request.getCookies();
		boolean boo = false;
		if(cs!=null){
			for(Cookie c:cs){
				if("images".equals(c.getName())){//已经有了images这个cookie
					String imgs = c.getValue();
					String imgStrs[] = imgs.split(",");
					boolean booStr = false;
					//防范点击重复的图片
					for(int i=0;i<imgStrs.length;i++){
						if(imgStrs[i].equals(img)){
							if(i==1&&imgStrs.length==2){
								imgs=imgStrs[i]+","+imgStrs[0];
							}else if(i==2&&imgStrs.length==3){
								imgs=imgStrs[i]+","+imgStrs[0]+","+imgStrs[1];
							}else if(i==2&&imgStrs.length==3){
								imgs=imgStrs[i]+","+imgStrs[0]+","+imgStrs[1];
							}
							booStr=true;
							break;
						}
					}
					if(!booStr){
						
						imgs = img+","+imgs;//采用如下方式会麻烦一点：imgs+","+img
						if(imgs.split(",").length>3){//如果访问的图片超过3次了
							imgs = imgs.substring(0, imgs.lastIndexOf(","));//左包含，右不包含
						}
						
						/*//如果这样写了，最好把上面的防范重复的图片，那个添加顺序倒过来
						//imgs+","+img  方式：
						imgs = imgs+","+img;
						if(imgs.split(",").length>3){//如果访问的图片超过3次了
							imgs = imgs.substring(imgs.indexOf(",")+1, imgs.length());
						}
						*/
					}
					c.setValue(imgs);//更新
					c.setMaxAge(60*60*24*30);
					c.setPath("/");//相当于把访问权限完全放开，即所有的项目都能访问
					response.addCookie(c);
					boo=true;
					break;
				}
			}
		}
		if(boo==false){//表示首次访问，即浏览器中没有图片浏览的cookie
			Cookie c = new Cookie("images", img);
			c.setMaxAge(60*60*24*30);
			c.setPath("/");
			response.addCookie(c);
		}
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}

```

演示结果：
-----

![](http://img.blog.csdn.net/20160726122928118)




6、测试火狐浏览器到底支持多少个Cookie和一个Cookie最大为多大
====================================
index.jsp:
----------

```
<a href="servlet/HowManyCookieServlet">测试火狐浏览器到底支持多少个Cookie和一个Cookie最大为多大 </a><br/>
```


web.xml:
--------

```
 <servlet>
    <servlet-name>HowManyCookie</servlet-name>
    <servlet-class>cn.hncu.servlets.HowManyCookie</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>HowManyCookie</servlet-name>
    <url-pattern>/servlet/HowManyCookieServlet</url-pattern>
  </servlet-mapping>
```

HowManyCookie.java:
-------------------

```
package cn.hncu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HowManyCookie extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		/*
		//测试个数--火狐47.0.1 最大支持110个
		for(int i=1;i<=110;i++){
			Cookie c = new Cookie("textNum"+i, ""+i);
			c.setMaxAge(60*15);
			c.setPath("/");
			response.addCookie(c);
		}
		*/
		
		//测试大小  ---4092字节为最大支持的单个cookie存储
		String s ="";
		for(int i=0;i<4092;i++){
			s+="1";
		}
		Cookie c = new Cookie("test", s);
		c.setMaxAge(60*15);
		c.setPath("/");
		response.addCookie(c);
		
		Cookie cs[] = request.getCookies();//读取cookie
		if(cs!=null){//防范一下
			for(Cookie cc:cs){
				String key = cc.getName();
				String val = cc.getValue();
				out.print(key+"="+val+" ");
			}
		}
		
	}

}

```



本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
