---
layout: post
title: "Web---session技术代码演示(request session servletContext)"
date: 2016-07-27 04:07:04 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅
tags: [session,cookie,技术,web应用,浏览器]
keyword: 陈浩翔, 谙忆
description: Session会话简介与基本知识点当浏览器第一次访问服务器时，无论先访问哪一个页面，服务器就会给用户分配一个唯一的会话标识，即jsessionid然后以cookie的形式返回给用户。会话是指在一段时间内，用户使用同一个浏览器进程与Web应用之间的交互过程。会话（Session）通常用来跟踪用户的状态，缓存用户在此浏览器进程中的信息。当用户关闭浏览器，上一个Session也就无法再次获得了(Cooki 
---


Session会话简介与基本知识点当浏览器第一次访问服务器时，无论先访问哪一个页面，服务器就会给用户分配一个唯一的会话标识，即jsessionid然后以cookie的形式返回给用户。会话是指在一段时间内，用户使用同一个浏览器进程与Web应用之间的交互过程。会话（Session）通常用来跟踪用户的状态，缓存用户在此浏览器进程中的信息。当用户关闭浏览器，上一个Session也就无法再次获得了(Cooki
<!-- more -->
----------

Session会话简介与基本知识点
===========

当浏览器第一次访问服务器时，无论先访问哪一个页面，服务器就会给用户分配一个唯一的会话标识，即jsessionid然后以cookie的形式返回给用户。

会话是指在一段时间内，用户使用同一个浏览器进程与Web应用之间的交互过程。

会话（Session）通常用来跟踪用户的状态，缓存用户在此浏览器进程中的信息。

当用户关闭浏览器，上一个Session也就无法再次获得了(Cookie的maxAge为-1的情况)。再次打开新的浏览器，将开始一个新的会话。
类javax.servlet.http.HttpSession。每一个HttpSession代表用户的一个会话。

每一个Session的过期时间默认为30分钟。

服务器给每个用户创建一个会话，即HttpSession对象，保存在服务器端。
那么，当用户再次访问服务器时，服务器是如何知道还是当前用户呢？
当浏览器再次访问服务器时，会携带包含了jsessionid的cookie访问服务器。服务器根据此id返回此用户的HttpSession对象，就保持了会话。

每一个Session都一个唯一标识，即ID。
当浏览器获取一个新的Session时，用户即可以通过session.geId()；打印出ID的值 。
再不关闭浏览器的情况下，在多个页面上跳转，使用的是同一个Session。

![](http://img.blog.csdn.net/20160727120100435)

画图演示:
![](http://img.blog.csdn.net/20160727142733233)


1、演示request,session,servletContext这3个容器:
========================================

index.jsp:
----------

```
<h1>演示session技术</h1>
  	<h2>演示request,session,servletContext这3个容器</h2>
  	<form action="SaveServlet" method="post">
  		name:<input type="text" name="name"/>&nbsp;&nbsp;
		<input type="submit" />  		
  	</form>
  	<br/>
  	<a href="GetServlet">读取这3个容器中的数据</a>
```

web.xml:
--------

```
<servlet>
    <servlet-name>SaveServlet</servlet-name>
    <servlet-class>cn.hncu.servlets.session.SaveServlet</servlet-class>
  </servlet>
  <servlet>
    <servlet-name>GetServlet</servlet-name>
    <servlet-class>cn.hncu.servlets.session.GetServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>SaveServlet</servlet-name>
    <url-pattern>/SaveServlet</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>GetServlet</servlet-name>
    <url-pattern>/GetServlet</url-pattern>
  </servlet-mapping>
  
```

SaveServlet.java:
-----------------

```
package cn.hncu.servlets.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("aaaaa");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");//如果接收的字符有中文，要设这一句
		String name = request.getParameter("name");
		request.setAttribute("name", "request---"+name);
		request.getSession().setAttribute("name", "session---"+name);
		this.getServletContext().setAttribute("name", "servletContext---"+name);
		
		
		//把cookie技术和session技术联合起来做应用的一个例子---
		//功能：让用户在关闭浏览器之后，如果5分钟之内再登陆本网站，还能访问到session
		//其实原理很简单，就是向客户端写一个key为"JSESSIONID"，value用sessionid的cookie
		//System.out.println(request.getSession().getId());
		//System.out.println(request.getSession().getAttribute("JSESSIONID"));//这个的值是null
		Cookie c = new Cookie("JSESSIONID", request.getSession().getId());
		c.setMaxAge(60*5);//5分钟后过期
		c.setPath(request.getContextPath());//权限给本站的所有网页/servlet
		//---根据客户端无论访问那个网站的哪个网页都会有JSESSIONID可以知道,这个的权限路径肯定是项目根目录下面
		response.addCookie(c);
		
		out.print("<h1>保存成功！</h1>");
		//System.out.println("bbbbbb");
		out.close();

	}

}

```

GetServlet.java:
----------------


```
package cn.hncu.servlets.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String reqName = (String) request.getAttribute("name");
		String sessName = (String) request.getSession().getAttribute("name");
		String contName = (String) request.getServletContext().getAttribute("name");
		
		out.print(reqName+"<br/>");
		out.print(sessName+"<br/>");
		out.print(contName+"<br/>");
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}

```

演示结果：
-----

![](http://img.blog.csdn.net/20160727112731127)

我再到另外一个浏览器打开：
![](http://img.blog.csdn.net/20160727112807966)

可以看到session的name值没有了。


为了防止误关浏览器导致session访问不到的解决办法：
============================

或者你把浏览器关了再打开，session的值也没有了！
这个时候，有的时候就会出现手误的情况，不小心把浏览器关了，着就很尴尬了，所以呢，有的网站为例预防这种情况，就可以这样来做！！！


在SaveServlet类中加上这样的代码就可以了!!

```
	//把cookie技术和session技术联合起来做应用的一个例子---
		//功能：让用户在关闭浏览器之后，如果5分钟之内再登陆本网站，还能访问到session
		//其实原理很简单，就是向客户端写一个key为"JSESSIONID"，value用sessionid的cookie
		System.out.println(request.getSession().getId());
		System.out.println(request.getSession().getAttribute("JSESSIONID"));
		Cookie c = new Cookie("JSESSIONID", request.getSession().getId());
		c.setMaxAge(60*5);//5分钟后过期
		c.setPath(request.getContextPath());//权限给本站的所有网页/servlet
		//---根据客户端无论访问那个网站的哪个网页都会有JSESSIONID可以知道,这个的权限路径肯定是项目根目录下面
		response.addCookie(c);
```

演示验证码-利用session传递值：
======

index.jsp:
-----------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function get(){
  			var nameElement = document.getElementById("inputName");
  			var pwdElement = document.getElementById("inputPwd");
  			var cs = document.cookie.split("; ");//按分号+空格拆分
  			//alert(document.cookie);
  			var name="";
  			var pwd="";
  			for(var x=0;x<cs.length;x++){
  				cs[x] = decodeURI(cs[x]);
  				//alert(cs[x]);
  				var strs = cs[x].split("=");
  				//alert(strs);
  				//alert("strs[0]="+strs[0]);
  				//alert("strs[1]="+strs[1]);
  				strName=strs[0];
  				if(strs[0]=="name1"){
  					name=strs[1];
  				}else if(strs[0]=="pwd1"){
  					pwd=strs[1];
  				}
  			}
  			nameElement.value =name;
  			pwdElement.value = pwd;
  			//alert(name);
  			//alert(pwd);
  		}
  		
	  	function leave(element,name){
	  		var date = new Date();
	  		date.setTime( date.getTime()+ 1000*60*60 );
	  		var key = name;
	  		var value = element.value;
	  		value = encodeURI(value);//中文编码X
	  		document.cookie=key+"="+value+";expires="+date.toGMTString()+";path=/";
	  	}
  	
  	</script>
  	
  	
  </head>
  
  <body onload="get()">
  	
  	<h2>演示验证码</h2>
	<form action="session/LoginServlet" method="post">
		Name:<input id="inputName" type="text" name="name" value="" onblur="leave(this,'name1');"/><br/>
		Pwd:<input id="inputPwd" type="password" name="pwd" value="" onblur="leave(this,'pwd1');"/><br/>
		<%	Date d = new Date();
			long str = d.getTime();
		%>
		<a href="index.jsp?time=<%=str %>"><img src="servlet/ImgServlet"/></a><input type="text" name="code"/>
		<input type="submit" value="登录" />
	</form>
  	
  	<br/><br/><br/><br/>
  	
  </body>
</html>
		
```

ImgServlet.java:
-----------------

```
package cn.hncu.servlets.session;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("image/jpg");//告诉浏览器，你发过去的数据是什么类型
		int width = 60;
		int height = 30;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics g = img.getGraphics();
		g.setFont(new Font("宋体", Font.BOLD, 18));
		Random r = new Random(new Date().getTime());
		String str="";
		for(int i=0;i<4;i++){
			int a = r.nextInt(10);
			str+=a;
			int x1=r.nextInt(width);
			int x2=r.nextInt(width);
			int y1=r.nextInt(height);
			int y2=r.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		//将生成的验证码放入session---真值
		request.getSession().setAttribute("realCode", str);
		g.drawString(str, 0, height);
		
		g.dispose();//把图刷到img当中去
		ImageIO.write(img, "jpg", response.getOutputStream());
	}
}

```

LoginServlet.java:
-------------------

```
package cn.hncu.servlets.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		//从客户端获取输入的name,pwd,code
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String code = request.getParameter("code");//这是用户输入的验证码
		
		String realCode = (String) request.getSession().getAttribute("realCode");//后台保存的真实验证码
		if(code==null || !code.equals(realCode)){
			out.print("<h1>验证码错误！！！</h1>");
		}else{
			
			//这里我们因为没做数据库，假定我们只判断name和pwd，如果name和pwd相同，我们就认为他登录成功
			if(name!=null&&name.trim().length()>0&&name.equals(pwd)){
				out.print("<h1>欢迎回来！"+name+".</h1>");
			}else{
				out.print("<h1>用户名或者密码不正确！</h1>");
			}
		}
		//这个必须要清！验证完之后清除原来旧的验证码
		request.getSession().removeAttribute("realCode");
		
	}
}

```


演示结果：
----------
嘿嘿，就不演示啦，就是一个简单session传递验证~
添加了验证码和保存上一个name和密码的功能。


重写URL,安全退出：
======

如果浏览器不支持Cookie或用户阻止了所有Cookie，可以把会话ID附加在HTML页面中所有的URL上，这些页面作为响应发送给客户。这样，当用户单击URL时，会话ID被自动作为请求行的一部分而不是作为头行发送回服务器。这种方法称为URL重写(URL rewriting)。

何为安全登录和安全退出：
当用户登录后，一般在Session中保存有用户的信息。
Session.setAttirubte(…)
用户退出时，应该当将自己的信息从Session中清除－即安全退出。
Session.invalidate();
Session.removeAttribute(…)



index.jsp:
-----------

```
<h2>演示重写url技术---破解用户禁用cookie之后，我们session无效的问题</h2>
  	<form action="<%= response.encodeURL("SaveServlet") %>" method="post">
  		Name:<input type="text" name="name"/><br/>
  		<input type="submit"/>
  	</form>
  	<a href="<%=response.encodeURL("GetServlet") %>">重写url-读取几个容器中的数据</a></br>
  	<a href="<%=response.encodeURL("LogoutServlet")%>"> 重写url-安全退出 </a>
  	<!-- 点击上面的安全退出后，这个浏览器原来的session就会失效！ -->
```


web.xml:
----------

```
<servlet>
    <servlet-name>LogoutServlet</servlet-name>
    <servlet-class>cn.hncu.servlets.session.LogoutServlet</servlet-class>
  </servlet>
<servlet-mapping>
    <servlet-name>LogoutServlet</servlet-name>
    <url-pattern>/LogoutServlet</url-pattern>
  </servlet-mapping>
```

LogoutServlet.java:
----------------------


```
package cn.hncu.servlets.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//安全退出，其实很简单的，只要让session对象无效就行了！-我们可以销毁服务器中的那个session对象
		request.getSession().invalidate();
		out.print("<h1>已经安全退出了！！！</h1>");
	}
}

```

安全退出，一般购物网站之类隐私较多的网站用的多！




本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
