---
layout: post
title: "Web---监听用户名注册技术-myAJax-隐藏帧"
date: 2016-08-22 11:28:47 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- JSP/XML知识点
tags: [javascript,ajax,技术]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处： http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
本来本篇博客在上个月就已经发表的，但由于我的疏忽，导致文章被彻底编辑不见，特来补上。先用官方的语言解释一下AJAX： 
AJAX 是一种在无需重新加载整个网页的情况下，能够更新部分网页的技术。AJAX = 异步 JavaScript 和 XML。 
AJAX 是一种用于创建快速动态网 
---


转载请注明出处： http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
本来本篇博客在上个月就已经发表的，但由于我的疏忽，导致文章被彻底编辑不见，特来补上。先用官方的语言解释一下AJAX： 
AJAX 是一种在无需重新加载整个网页的情况下，能够更新部分网页的技术。AJAX = 异步 JavaScript 和 XML。 
AJAX 是一种用于创建快速动态网
<!-- more -->
----------

<blockquote>
<p background-color='#D3D3D3'>转载请注明出处： http://blog.csdn.net/qq_26525215<br><br>
本文源自<strong>【<a href="http://blog.csdn.net/qq_26525215" target="_blank">大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


本来本篇博客在上个月就已经发表的，但由于我的疏忽，导致文章被彻底编辑不见，特来补上。

先用官方的语言解释一下AJAX：
AJAX 是一种在无需重新加载整个网页的情况下，能够更新部分网页的技术。

AJAX = 异步 JavaScript 和 XML。
AJAX 是一种用于创建快速动态网页的技术。
通过在后台与服务器进行少量数据交换，AJAX 可以使网页实现异步更新。这意味着可以在不重新加载整个网页的情况下，对网页的某部分进行更新。
传统的网页（不使用 AJAX）如果需要更新内容，必需重载整个网页面。
有很多使用 AJAX 的应用程序案例：新浪微博、Google 地图、开心网等等。


现在自己写一个仿AJAX的功能注册，实现注册时(网页不刷新与提交)，提示用户名错误。

应用隐藏帧，监听事件，提交表单显示到iframe内联框架，调用父页面函数...。

##reg.jsp
```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>myAjax</title>
    
    <script type="text/javascript">
    	function val(obj){
    		var name = obj.value;//.value就是input中的name属性值
    		if(name!=null&&name!=""){
    			document.getElementById("regName").value=name;
    			document.forms[1].submit();//让第二个表单提交
    		}else{
    			msg.innerHTML="请输入用户名！";
    		}
    	}
    	
    	function ajaxBack(res){
    		if(res==1){
				parent.document.getElementById("msg").innerHTML="用户名已经存在，请更换用户名！";   			
   			}else{
				msg.innerHTML="恭喜，可以注册！";  
				//id也可以直接这样用 			
   			}
    	}
    
    </script>
    
  </head>
  
  <body>
  	<h2>演示myAjax---隐藏帧技术</h2>
  	<br/>
  	<h2>用户注册</h2>
  	<form action="<%= request.getContextPath() %>/RegServlet" method="post">
  		Name:<input type="text" name="name" onblur="val(this)"/>
  		<label id="msg" style="color:red;"></label><br/>
  		Password:<input type="password" name="pwd"/><br/>
  		Tel:<input type="text" name="tel"/><br/>
		<input type="submit" value="注册">  		
  	</form>
  	
  	<form target="dataFrame" action="<%= request.getContextPath() %>/ValServlet" method="post">
  		<input type="hidden" id="regName" name="name"/>
  		<!--  type="hidden" 表示这个input是隐藏的，网页不可见. target 属性规定在何处打开 action URL。  -->
  	</form>	
  	
  	<!-- iframe创建包含另外一个文档的内联框架（即行内框架）。 -->
  	<iframe style="display:none" name="dataFrame" ></iframe>
  </body>
</html>

```

##ValServlet
后台验证:

```
package cn.hncu.reg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValServlet extends HttpServlet {

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
		String pwd = request.getParameter("pwd");
		String tel = request.getParameter("tel");
		
		if(name!=null && name.trim().length()>0 && name.startsWith("hncu") ){//正式项目，需要去后台校验数据的
			request.setAttribute("error", 0);//这是可以注册的
		}else{
			request.setAttribute("error", 1);//不能注册，该用户名已经存在！
		}
		//转发
		request.getRequestDispatcher("/jsps/regResult.jsp").forward(request, response);
	}
}

```





##regResult.jsp

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  <h2>这是结果页面</h2>
    错误代码：${error }
   <script type="text/javascript">
   		var res ="<%=request.getAttribute("error")%>";
   		/*
   			在iframe框架中显示
   		*/
   		
   		/*
   		if(res==1){
			parent.document.getElementById("msg").innerHTML="用户名已经存在，请更换用户名！";   			
   		}else{
			parent.document.getElementById("msg").innerHTML="恭喜，可以注册！";   			
   		}
   		//parent.document--表示父页面的document对象
   		//这种方式可以用，但不是很好。我们最好用下面那一句调用父页面的方法解决
   		*/
   		
   		parent.ajaxBack(res);
   </script>
   
  </body>
</html>

```

##RegServlet

```
package cn.hncu.reg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String ped = request.getParameter("pwd");
		String tel = request.getParameter("tel");
		
		if(name.startsWith("hncu")){//如果是正式做，这里要去后台进行注册，这里简化了。
			out.print("注册成功！"+name);
		}else{
			out.print("注册失败：用户名必须以hncu开头");
		}

	
	}

}

```



<blockquote>
<p background-color='#D3D3D3'>转载请注明出处： http://blog.csdn.net/qq_26525215<br><br>
本文源自<strong>【<a href="http://blog.csdn.net/qq_26525215" target="_blank">大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
