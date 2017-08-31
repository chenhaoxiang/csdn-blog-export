---
layout: post
title: "JavaWeb-过滤器Filter学习(四)敏感词过滤实例"
date: 2016-08-18 05:29:18 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅
tags: [filter,实例,敏感词过滤]
keyword: 陈浩翔, 谙忆
description: 通过Filter来实现留言板的敏感词过滤…思路很简单，我们这里的敏感词是直接先放进去的，实际项目中，肯定是存在数据库中。在Filter 过滤器中，我们先拿到用户提交的留言，如果出现了敏感词，我们就用*号来替换。代码演示:index.jsp:<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib ur 
---


通过Filter来实现留言板的敏感词过滤…思路很简单，我们这里的敏感词是直接先放进去的，实际项目中，肯定是存在数据库中。在Filter 过滤器中，我们先拿到用户提交的留言，如果出现了敏感词，我们就用*号来替换。代码演示:index.jsp:<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib ur
<!-- more -->
----------

通过Filter来实现留言板的敏感词过滤...

思路很简单，我们这里的敏感词是直接先放进去的，实际项目中，肯定是存在数据库中。在Filter 过滤器中，我们先拿到用户提交的留言，如果出现了敏感词，我们就用*号来替换。

#代码演示:

##index.jsp:

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	 <title>过滤器应用示例---敏感词过滤</title>
  </head>
  
  <body>
     <h2>过滤器应用示例---敏感词过滤</h2>
     <form action="<c:url value='/NoteServlet'/>" method="post">
     	用户名:<input type="text" name="name" /><br/><br/>
		<fieldset>
			<legend>留言板</legend>
			<textarea name="note" rows="10" cols="20"></textarea>
		</fieldset>
		<input type="submit" value="留言" />     
     </form>
  </body>
</html>

```

##WordsUtil.java:敏感词集合:

```
package cn.hncu.pubs;

import java.util.ArrayList;
import java.util.List;

public class WordsUtil {
	private static List<String> list = new ArrayList<String>();
	static{
		//这里应该从数据库中导入敏感词的，我在这里就直接用词来模拟了
		list.add("骂人");
		list.add("sb");
	}
	public static List<String> getWords(){
		return list;
	}
	public static void reBuild(){
	   //把list中的内容存储到数据库---每一段时间存储一次
	}
}

```
##NoteServlet.java

```
package cn.hncu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("不支持GET方式留言");
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String name = request.getParameter("name");
		if(name==null || name.trim().length()<=0){
			out.println("名字不能为空!!!");
		}else{
			String words = request.getParameter("note");
			out.println("<br/>"+name+"的留言是:<br/>"+ words);
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}

```

##WordFilter.java:敏感词过滤

```
package cn.hncu.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import cn.hncu.pubs.WordsUtil;

public class WordFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		//在过滤器中用装饰模式把 原装request的功能增强了
		//---拦截后台调用的getParamter()方法
		MyRequest req = new MyRequest((HttpServletRequest)request);
		
		chain.doFilter(req, response);//放行
	}

	@Override
	public void destroy() {
	}
}

class MyRequest extends HttpServletRequestWrapper{
	public MyRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String str = super.getParameter(name);
		List<String> list = WordsUtil.getWords();
		for(String word : list){
			str = str.replaceAll(word, "*");
		}
		return str;
	}
	
	
	
}

```

##配置web.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" 
	xmlns="http://java.sun.com/xml/ns/javaee" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
  <display-name></display-name>
  <filter>
  	<filter-name>wordFilter</filter-name>
  	<filter-class>cn.hncu.filter.WordFilter</filter-class>
  </filter>
  <filter-mapping>
  	<filter-name>wordFilter</filter-name>
  	<url-pattern>/*</url-pattern>
  </filter-mapping>
  
  
  <servlet>
    <servlet-name>NoteServlet</servlet-name>
    <servlet-class>cn.hncu.servlet.NoteServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>NoteServlet</servlet-name>
    <url-pattern>/NoteServlet</url-pattern>
  </servlet-mapping>	
  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
</web-app>

```



#演示结果:

![](http://img.blog.csdn.net/20160818171941959)

##过滤后的效果:

![](http://img.blog.csdn.net/20160818171948787)


#完整项目链接:

https://github.com/chenhaoxiang/Java/tree/master/myWordsFilterWeb
myWordsFilterWeb.zip


转载请附上原文博客链接：

http://blog.csdn.net/qq_26525215


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
