---
layout: post
title: "Web---文件上传-用apache的工具处理、打散目录、简单文件上传进度"
date: 2016-07-23 01:23:43 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ⑥、框架/第三方工具
tags: [apache,文件上传,web,javaEE]
keyword: 陈浩翔, 谙忆
description: 我们需要先准备好2个apache的类： 
上一个博客文章只讲了最简单的入门，现在来开始慢慢加深。先过渡一下：只上传一个file项index.jsp:<h2>用apache的工具处理文件上传</h2>
    <!-- 先过渡一下：只上传一个file项 -->
    <form action="<%= request.getContextPath() %>/upload" method="post" 
---


我们需要先准备好2个apache的类： 
上一个博客文章只讲了最简单的入门，现在来开始慢慢加深。先过渡一下：只上传一个file项index.jsp:<h2>用apache的工具处理文件上传</h2>
    <!-- 先过渡一下：只上传一个file项 -->
    <form action="<%= request.getContextPath() %>/upload" method="post"
<!-- more -->
----------

我们需要先准备好2个apache的类：
![](http://img.blog.csdn.net/20160722164144499)

上一个博客文章只讲了最简单的入门，现在来开始慢慢加深。



先过渡一下：只上传一个file项
================


index.jsp:
----------

```
<h2>用apache的工具处理文件上传</h2>
  	<!-- 先过渡一下：只上传一个file项 -->
  	<form action="<%= request.getContextPath() %>/upload" method="post" enctype="multipart/form-data">
  		文件:<input type="file" name="file"/><br/>
  		<input type="submit" value="提交"/>
  	</form>
```

web.xml:
--------

```
<servlet>
    <servlet-name>UploadServlet</servlet-name>
    <servlet-class>cn.hncu.servlets.upload.UploadServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>UploadServlet</servlet-name>
    <url-pattern>/upload</url-pattern>
  </servlet-mapping>
```

UploadServlet.java:
-------------------

```
package cn.hncu.servlets.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

public class UploadServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//下面这句解决上传文件名的中文乱码
		//注意。下面这句设置中文，如果是“multipart/form-data”表单，可以设置其中file组件的文件名，但对其中的普通表单组件无效
		//如果是"application/x-www-form-urlencoded"表单，可以设置其中的普通表单组件
		request.setCharacterEncoding("utf-8");
		
		//先获取所接收文件要保存的路径
		String path = getServletContext().getRealPath("/imgs");
		
		//文件上传需要临时目录(如果不指定，那么该目录就是tomcat/temp)
		File tempDiv = new File("E:/a");
		if(!tempDiv.exists()){
			tempDiv.mkdir();
		}
		
		DiskFileItemFactory fileFactory = new DiskFileItemFactory(1024*8, tempDiv);
		//创建用于解析文件的工厂类，同时设置缓存区的大小和位置
		
		//####思路的入口：
		ServletFileUpload upload = new ServletFileUpload(fileFactory);
		upload.setFileSizeMax(1024*1024*5);//设置单个文件上传最大为5M
		upload.setSizeMax(1024*1024*8);//所有上传文件大小之和的最大值，此处设最多能上传8M
		//setSizeMax方法用于设置请求消息实体内容的最大允许大小，以防止客户端故意通过上传特大的文件来塞满服务器端的存储空间，单位为字节。
		
		//以下开始解析：
		//parseRequest是从查询字符串和请求体中获取参数赋值到paramMap，然后格式化uri，填充Request对象实例
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem fi:list){
				// isFormField()。isFormField方法用来判断FileItem对象里面封装的数据是一个普通文本表单字段，还是一个文件表单字段。
				//如果是普通文本表单字段，返回一个true否则返回一个false。
				//因此可以用该方法判断是否是普通表单域还是文件上传表单域。
				if(fi.isFormField()){
					//普通表单组件，如：<input type="text" name="name"/>
					String str = fi.getString("utf-8");//以指定编码的方式获取，来解决普通表单组件的中文乱码问题
					//将FileItem对象中保存的数据流内容以一个字符串返回。
					System.out.println("普通表单组件："+str);
				}else{//文件组件					
					String fileName = fi.getName();//获得上传文件的文件名
					System.out.println("fileName:"+fileName);
					//由于上传的文件“名字”可能会有中文，而服务器目录当中的资源名称不能够用中文(带中文的文件在浏览器中无法访问的)，因此要把它转换成非中文的文件名(要考虑文件名不能重复)
					//于是，我们用java自带的UUID类，自动生成
					String uuid = UUID.randomUUID().toString().replace("-", "");//去掉uuid中的'-'
					String ext = fileName.substring(fileName.lastIndexOf("."));//截取文件的扩展名： .*
					//System.out.println("ext:"+ext);
					String newFileName = uuid+ext;//本地服务器存储的文件名
					//System.out.println("newFileName:"+newFileName);
					//真正的文件内容在fi.getInputStream() 当中
					FileUtils.copyInputStreamToFile(fi.getInputStream(), new File(path+"/"+newFileName));//拷贝的字节从InputStream源文件到目的地(file)。
				}
			}
		} catch (FileUploadException e) {
			throw new RuntimeException(e);
		}
		
	}

}

```

演示结果：
-----
![](http://img.blog.csdn.net/20160722172202537)

![](http://img.blog.csdn.net/20160722172213465)

![](http://img.blog.csdn.net/20160722172221209)

在这个上传中，我们并没有把uuid和文件名联系起来，这样是不好的，必须用数据库把uuid和其对应的文件名存起来。以后下载的时候还给客户端一样的名字，而不是给他uuid的名字。



上传二个file项
=========

index.jsp:
----------

```

  	<!-- 下面那个=号，代表整个输出request.getContextPath()的值   -->
  	<form action="<%= request.getContextPath() %>/upload" method="post" enctype="multipart/form-data">
  		文件1：<input type="file" name="file"/><br/>
  		文件1的说明：<input type="text" name="desc1"/><br/> 
  		文件2：<input type="file" name="file2"/><br/>
  		文件2的说明：<input type="text" name="desc2"/><br/>
  		<input type="submit" value="提交"/>
  	</form>
```

其他的相对前面的都没改动~

演示结果：
-----
![](http://img.blog.csdn.net/20160722173848754)

![](http://img.blog.csdn.net/20160722173855035)

![](http://img.blog.csdn.net/20160722173902645)



上传文件最终版：
========

index.jsp:
----------

```
<h2>进一步演示文件上传用法</h2>
	<form action="<%= request.getContextPath() %>/upload2" method="post" enctype="multipart/form-data">
		文件1：<input type="file" name="file"/><br/>
		文件1的说明：<input type="text" name="desc1"/><br/>
		文件2：<input type="file" name="file2"/><br/>
		文件2的说明：<input type="text" name="desc2"/><br/>
		<input type="submit" value="提交"/>
	</form>
```

web.xml:
--------

```
 <servlet>
    <servlet-name>UploadServlet2</servlet-name>
    <servlet-class>cn.hncu.servlets.upload.UploadServlet2</servlet-class>
  </servlet>
<servlet-mapping>
    <servlet-name>UploadServlet2</servlet-name>
    <url-pattern>/upload2</url-pattern>
  </servlet-mapping>	
```

UploadServlet2.java:
--------------------

```
package cn.hncu.servlets.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet2 extends HttpServlet {
	
	//防黑1---在地址栏直接提交的-我们要防住
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("不支持GET方式上传！！！");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		final PrintWriter out = response.getWriter();//等会内部类需要用到这个变量，所以定义成final
		
		//防黑2--非multipart表单提交
		//手动方式
		String type = request.getContentType();
		if(!type.contains("multipart/form-data")){//如果此字符串包含 s，则返回 true，否则返回 false 
			out.print("不支持普通表单提交");
			return;
		}
		
		DiskFileItemFactory fiFactory = new DiskFileItemFactory();
		fiFactory.setSizeThreshold(1024*8);//8k,缓存区大小
		File file = new File("d:/a");
		if(!file.exists()){
			file.mkdir();
		}
		fiFactory.setRepository(file);//设置缓存区
		/*
		 ServletFileUpload类是Apache文件上传组件处理文件上传的核心高级类（所谓高级就是不需要管底层实现，暴露给用户的简单易用的接口）。
		 使用其 parseRequest(HttpServletRequest) 方法可以将通过表单中每一个HTML标签提交的数据封装成一个FileItem对象，然后以List列表的形式返回。
		 */
		ServletFileUpload upload = new ServletFileUpload(fiFactory);
		upload.setHeaderEncoding("utf-8");//用于设置文件名的编码，相当于：request.setCharacterEncoding("utf-8");
		String path = getServletContext().getRealPath("/imgs");
		
		//文件上传进度功能---设置监听器
		
		upload.setProgressListener(new ProgressListener() {
			private int pre=0;
			
			//参数解析---pBytesRead:已上传字节数 pContentLength:上传的总字节数 pItems:文件序号(从1开始的)
			@Override
			public void update(long pBytesRead, long pContentLength, int pItems) {
				double d = pBytesRead*100.0/pContentLength;//计算百分比
				int dd = (int)d;
				if(pre!=dd){//防范输出一样的百分比
					out.print(dd+"%<br/>");
					pre=dd;
				}
			}
		});
		
		
			
		FileItem fi=null;
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem fi2:list){
				fi=fi2;//相当于传指针，同一个对象
				if(fi.isFormField()){//普通表单组件
					String str = fi.getString("utf-8");
					System.out.println("普通表单组件提交的内容："+str);
				}else{//表单中的：file组件
					
					//防黑3--在file组件中不选择文件
					if(fi.getSize()==0){
						continue;
					}
					
					//文件名
					String fileName = fi.getName();
					fileName = fileName.substring( fileName.lastIndexOf("\\")+1 );//这里就是文件名（后缀名也在的）
					String ext = fileName.substring( fileName.lastIndexOf(".") );// .*  后缀名
					
					//文件名不能用中文，必须转换成ascii码的格式，而且文件名不能重复(必须保证唯一)，因此采用UUID来实现
					String newFileName = UUID.randomUUID().toString().replace("-", "");//去掉'-'
					newFileName = newFileName+ext;
					
					
					//打散目录（因为对于普通的机器，一个文件夹如果存储的文件个数超过1000个，性能就会急剧下降！！！）、
					String dir1 = Integer.toHexString( fileName.hashCode() & 0xf );
					String dir2 = Integer.toHexString( (fileName.hashCode() & 0xf0)>>4 );//右移四位
					String dir3 = Integer.toHexString( ( fileName.hashCode() & 0xf00 )>>8);
					File dir = new File(path+"/"+dir1+"/"+dir2+"/"+dir3);//16*16*16个文件夹
					if(!dir.exists()){
						dir.mkdirs();
					}
					File f = new File(dir+"/"+newFileName);
					fi.write(f);
				}
			}
		}catch (FileUploadException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally{
			if(fi!=null){
				fi.delete();//清临时文件
			}
		}
	}
}

```


演示结果：
-----

进行了一个文字型的文件上传进度，没办法啊，现在还没学AJax,做不了同步~~理解理解，后面会学到的。

![](http://img.blog.csdn.net/20160723004418957)

![](http://img.blog.csdn.net/20160723004409441)

注意看文件的保存目录！！！！（0-f）16进制的文件名~
我做了三层~

![](http://img.blog.csdn.net/20160723004429582)

![](http://img.blog.csdn.net/20160723004438089)


演示下中文路径的文件不能显示的实例：
------------------


```
<img alt="中文路径不行" src="/myServletDemo3/imgs/图书1.jpg"/>
```
先移动这个图片到这个目录：
![](http://img.blog.csdn.net/20160723004941080)

再看浏览器的访问结果：

![](http://img.blog.csdn.net/20160723005033565)
无法访问到这个文件！！！！！！



进度条前台技术演示：
==========

最后，我们自己来做个假的进度条看看：
其实只是少了aJax技术而已。


index.jsp:
----------

```
 <a href="progress.jsp">进度条前台技术演示</a>
```

propress.jsp:
-------------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		var tm=0;
  		function start(){
  			a=0;
  			if(tm!=0)
  				window.clearInterval(tm);//也要防范一下，否则一直点启动。会出现很多的定时器。a+的速度会越来越快
  			tm = window.setInterval(run, 100);
  		}
  		//真正开发的时候，应该是在run()方法中利用aJax到后台读取当前的进度值，
  		//用该进度值对页面的进度条进行相应刷新，由于Ajax技术还没学，这里就我们自己模拟吧....
  		var a=0;
  		function run(){
  			a+=1;
  			if(a>100){
  				window.clearInterval(tm);
  				return;
  			}
  			var div=document.getElementById("dataDiv");
  			div.style.width = a+"%";//把里面的div 对应的宽变长百分之一（背景色为红）
  		}
  		function stop(){
  			window.clearInterval(tm);
  		}
  		function resume(){
  			window.clearInterval(tm);//必须先把前面那个给清了。否则会出现前面那个对象无法访问到的情况
  			tm = window.setInterval(run, 100);
  		}
  	</script>
  
  </head>
  
  <body>
  	<h1>进度条前台技术演示</h1>
  	<div style="border:1px solid red;width:400px;height:30px;">
  		<div id="dataDiv" style="background:red;width:0%;height:100%;"></div>
  	</div>
	<button onclick="start()">启动</button>
	<button onclick="stop()">停止</button>
	<button onclick="resume()">重新启动</button>
  </body>
</html>

```

演示结果：
-----

点启动按钮，就是从0%启动，运行到全部填充完毕（100%）就停止。
点停止按钮，就停止在当前进度，点重新启动，就是恢复启动~从暂停的地方继续~~

![](http://img.blog.csdn.net/20160723012040134)

![](http://img.blog.csdn.net/20160723012052322)

![](http://img.blog.csdn.net/20160723012059525)




本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
