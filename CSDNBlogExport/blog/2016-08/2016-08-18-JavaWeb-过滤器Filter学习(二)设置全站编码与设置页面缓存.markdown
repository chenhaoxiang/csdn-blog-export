---
layout: post
title: "JavaWeb-过滤器Filter学习(二)设置全站编码与设置页面缓存"
date: 2016-08-18 12:18:58 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅
tags: [filter,servlet,编码,缓存,拦截器]
keyword: 陈浩翔, 谙忆
description: 以前我们设置servlet的request和response的编码需要在每个servlet都设置，如果Servlet很多，显得很麻烦，现在我们可以用过滤器很简单的实现这个功能。 
还有页面缓存，如果我们的网页是静态的，图片和内容基本上很少变化或者不变化的，我们就可以告诉客户端这个页面你缓存多久~以达到节省流量的目的。 
---


以前我们设置servlet的request和response的编码需要在每个servlet都设置，如果Servlet很多，显得很麻烦，现在我们可以用过滤器很简单的实现这个功能。 
还有页面缓存，如果我们的网页是静态的，图片和内容基本上很少变化或者不变化的，我们就可以告诉客户端这个页面你缓存多久~以达到节省流量的目的。
<!-- more -->
----------

以前我们设置servlet的request和response的编码需要在每个servlet都设置，如果Servlet很多，显得很麻烦，现在我们可以用过滤器很简单的实现这个功能。
还有页面缓存，如果我们的网页是静态的，图片和内容基本上很少变化或者不变化的，我们就可以告诉客户端这个页面你缓存多久~以达到节省流量的目的。

#设置全站编码：

先写好Filter：CharacterFilter.java：

```
package cn.hncu.pubs;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class CharacterFilter implements Filter{
	private String charset;//获取web.xml配置的编码参数值
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		charset = filterConfig.getInitParameter("charset");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		chain.doFilter(request, response);//放行
	}

	@Override
	public void destroy() {
	}
  
}

```


配置好web.xml文件:

如果你不知道filter应该写到哪个位置，在myEclipse可以通过鼠标点击web-app标签，然后按住F2，会显示出标签的书写位置的。

![](http://img.blog.csdn.net/20160818113003163)

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" 
	xmlns="http://java.sun.com/xml/ns/javaee" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
  <display-name></display-name>	
  <filter>
  	<filter-name>character</filter-name>
  	<filter-class>cn.hncu.pubs.CharacterFilter</filter-class>
  	<init-param>
  		<!-- 配置编码参数与值 -->
  		<param-name>charset</param-name>
  		<param-value>utf-8</param-value>
  	</init-param>
  </filter>
  <filter-mapping>
  	<filter-name>character</filter-name>
  	<url-pattern>/*</url-pattern>
  </filter-mapping>
  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
</web-app>
```

#设置页面缓存

也很简单，我们在过滤器中写几个响应头，再配置好需要缓存的web.xml中的url-pattern路径就好。

```
package cn.hncu.pubs;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class JspCacheFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		//设置缓存时间
		Date date = new Date();
		long time = date.getTime()+1000*60*60*24*5;//缓存5天
		resp.setHeader("expires", ""+time);
		resp.setHeader("pragma", ""+time);
		resp.setHeader("cache-control", ""+time);
		//设置3个，以兼容不同的浏览器
		
		//用修改过的resp往后台传
		chain.doFilter(request, resp);
	}

	@Override
	public void destroy() {
	}
	
}

```

设置不缓存:(这个可能会不起作用，因为大部分的浏览器都自带缓存的)
设置这3个的原因是，不同的浏览器，它的参数名不同！为了兼容大部分的浏览器，我们设置了这3个。
```
resp.setHeader("expires","-1");
resp.setHeader("pragma", "no-cache");
resp.setHeader("cache-control", "no-cache");
```

至于web.xml的配置文件，我就不写了，大家按照上面的写就可以了。


转载请附上原文博客链接： 

http://blog.csdn.net/qq_26525215

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
