---
layout: post
title: "Web---创建Servlet的3种方式、简单的用户注册功能"
date: 2016-07-20 04:08:36 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅
tags: [servlet,继承,开放,web]
keyword: 陈浩翔, 谙忆
description: 说明：创建Servlet的方式，在上篇博客中，已经用了方式1(实现Servlet接口)，接下来本节讲的是另外2种方式。 
上篇博客地址：http://blog.csdn.net/qq_26525215/article/details/51942252简单的用户注册功能(我们设置了所以权限都是开放的)，可以实现： 
1、用户注册。 
2、查询所有用户 
3、删除某个用户创建Servlet的方式二：继承 
---


说明：创建Servlet的方式，在上篇博客中，已经用了方式1(实现Servlet接口)，接下来本节讲的是另外2种方式。 
上篇博客地址：http://blog.csdn.net/qq_26525215/article/details/51942252简单的用户注册功能(我们设置了所以权限都是开放的)，可以实现： 
1、用户注册。 
2、查询所有用户 
3、删除某个用户创建Servlet的方式二：继承
<!-- more -->
----------

说明：
===

创建Servlet的方式，在上篇博客中，已经用了方式1(实现Servlet接口)，接下来本节讲的是另外2种方式。
上篇博客地址：http://blog.csdn.net/qq_26525215/article/details/51942252

简单的用户注册功能(我们设置了所以权限都是开放的)，可以实现：
1、用户注册。
2、查询所有用户
3、删除某个用户

创建Servlet的方式二：继承 GenericServlet
==============

SecondServlet.java:
-------------------

```
package cn.hncu.servlet.day2;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


//以继承GenericServlet 的方式 写 servlet
public class SecondServlet extends GenericServlet{
	
	//一个小知识点！！！
	//适配器模式的一个知识点：适配器中的init(ServletConfig config)中帮我们把它当中的config对象赋值 且调用一个空参的init()。
	//我们以后应该覆盖空参的init()。因为如果覆盖了这个带参数的，那么就无法实现为它的config对象赋值，由此导致其中使用config对象（this.）的方法会出错。
////其实这种方法（调用 一个空参的init()且 该参数方法中什么也没做 ）也程序员之间的一种交流方式，告诉我们要覆盖空参的方法，这样它在帮我们做完事情会调用我们的覆盖方法
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println(config);//这里不会出现问题,父类：init(ServletConfig config)中有这一句：this.config = config;
//		String charset = config.getInitParameter("charset");
//		System.out.println(charset);
//		System.out.println("init..."+this);
//	}
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("init...."+this);
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		//String charset = this.getInitParameter("charset");
		//如果本例写了init(ServletConfig config)方法，覆盖了父类的init(ServletConfig config)方法，这句会出异常
		//System.out.println(charset);
		
		String charset = this.getInitParameter("charset");
		System.out.println(charset);
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		System.out.println("name:"+name+",pwd:"+pwd);
	}
}

```

index.jsp:
----------

```
<hr/>
		<h1>下面是本章节博客的内容</h1>
		<h2>演示servlet技术---第二种创建Servlet的方式(继承GenericServlet)</h2>
		<form action="/myServletDemo/second" method="post">
			访问SecondServlet<br/>
			姓名：<input type="text" name="name"/> <br/>
			密码：<input type="password" name="pwd"/><br/>
			<input type="submit" value="提交" />			
		</form>
```

web.xml:
--------

```
<!-- 下面的是今天这节博客的 -->
  <servlet>
  	<servlet-name>SecondServlet</servlet-name>
  	<servlet-class>cn.hncu.servlet.day2.SecondServlet</servlet-class>
  	<init-param>
		<param-name>charset</param-name>
		<param-value>utf-8</param-value>  	
  	</init-param>
  </servlet>
  <servlet-mapping>
  	<servlet-name>SecondServlet</servlet-name>
  	<url-pattern>/second</url-pattern>
  </servlet-mapping>
```

演示结果：
-----
填写好姓名，密码后点击提交：

![](http://img.blog.csdn.net/20160720123805504)

再看后台：
![](http://img.blog.csdn.net/20160720123834238)



创建Servlet的方式三：继承HttpServlet
==============

index.jsp:
----------

```
	<h2>演示servlet技术---第三种Servlet的方式(继承HttpServlet)</h2>
		<form action="/myServletDemo/third" method="post">
			访问ThirdServlet<br/>
			姓名：<input type="text" name="name"><br/>
			密码：<input type="password" name="pwd"><br/>
			<input type="submit" value="提交" />
		</form>
```

web.xml:
--------

```
 <servlet>
  	<servlet-name>ThirdServlet</servlet-name>
  	<servlet-class>cn.hncu.servlet.day2.ThirdServlet</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>ThirdServlet</servlet-name>
	<url-pattern>/third</url-pattern>  	
  </servlet-mapping>
```



ThirdServlet.java:
------------------

```
package cn.hncu.servlet.day2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//注意：采用继承HttpServlet的方式写servlet，doGet和doPost这2个方法通常都要覆盖
//否则如果doGet方法没覆盖,有get请求时就会出现405错误，不覆盖doPost方法同理
public class ThirdServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("get...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("post");
	}
	
}

```

覆盖doGet和doPost这2个方法的说明：
-------------------------

注意：采用继承HttpServlet的方式写servlet，doGet和doPost这2个方法通常都要覆盖
否则如果doGet方法没覆盖,有get请求时就会出现405错误，不覆盖doPost方法同理.
产生这个的原因是：
我们来看底层代码：
这是一个常量：
public static final int SC_METHOD_NOT_ALLOWED = 405;
因为HttpServlet继承GenericServlet，GenericServlet implements Servlet。所以，当客户端访问的时候，最先找的是：父类的servlet
也就是：service(ServletRequest req, ServletResponse res)
这个方法继续调用：service(request, response);
再通过这个方法调用doGet()或doPost()或其他方法。
如果我们没覆盖doGet()或doPost()。
我们用的是http1.1协议，会调用resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, msg);于是出现了405错误！

![](http://img.blog.csdn.net/20160720133704209)

![](http://img.blog.csdn.net/20160720133713115)

![](http://img.blog.csdn.net/20160720133720616)

![](http://img.blog.csdn.net/20160720133730460)


演示结果：
-----

![](http://img.blog.csdn.net/20160720133813217)、

我们将表单提交的方式定义成post提交了的。默认是get


简单的用户注册功能:
=========
首先，我们需要一个xml，用来存储用户的注册信息；
我们在项目的src文件夹下建立了一个user.xml文件。
![](http://img.blog.csdn.net/20160720134707628)
user.xml:
我们只写了xml的头，和需要的一个根元素
```
<?xml version="1.0" encoding="UTF-8"?>
<users>
</users>
```

写一个公共类工厂：Dom4jFactory
大家共用访问同一个document~。
（单例）

Dom4jFactory.java
-----------------

```
package cn.hncu.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jFactory {
	private static Document dom = null;
	private static String path;
	//静态块！只会运行一次！特点是在类加载的时候就执行
	static{
		try{
			SAXReader sax = new SAXReader();
			// 学习一下服务器下的资源路径加载方式(因为我们的资源已经从MyEclipse中发布到Tomcat服务器中了，所以跟原来纯Java项目不一样了)
			// 利用当前类找到它的类加载器，然后通过该类加载器再去获得资源路径
			path = Dom4jFactory.class.getClassLoader().getResource("users.xml").getPath();
			//getClassLoader()返回：加载此对象所表示的类或接口的类加载器。 
			//public URL getResource(String name)返回：读取资源的 URL 对象；如果找不到该资源，或者调用者没有足够的权限获取该资源，则返回 null。
			//此方法首先搜索资源的父类加载器；如果父类加载器为 null，则搜索的路径就是虚拟机的内置类加载器的路径。
			//public String getPath()获取此 URL 的路径部分。 
			System.out.println(path);
			dom = sax.read(new FileInputStream(path));
		}catch (Exception e){
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * @return 获取用户的Document
	 */
	public static Document getDocument(){
		return dom;
	}
	
	/**
	 * 进行users.xml的保存，保存到本地
	 */
	public static void save(){
		try {
			XMLWriter w = new XMLWriter(new FileOutputStream(path));
			w.write(dom);
			w.close();
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * 测试用
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println( getDocument() );
	}
	
}

```

index.jsp:
----------

```
<hr/>
		<h2>以下演示一个小项目---用户注册</h2>
		<h3>用户注册</h3>
		<form action="/myServletDemo/reg" method="post">
			姓名：<input type="text" name="name" /><br/>
			密码：<input type="password" name="pwd"/><br/>
			<input type='submit' value="注册"/>
		</form>
		<br/>
     	 <a href="/servletDemo/reg">显示所有用户</a>
```

web.xml:
--------

```
<servlet>
  	<servlet-name>RegServlet</servlet-name>
  	<servlet-class>cn.hncu.servlet.day2.RegServlet</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>RegServlet</servlet-name>
	<url-pattern>/reg</url-pattern>  	
  </servlet-mapping>
  <servlet>
    <description>This is the description of my J2EE component</description>
    <display-name>This is the display name of my J2EE component</display-name>
    <servlet-name>DelServlet</servlet-name>
  </servlet>
   <servlet-mapping>
    <servlet-name>DelServlet</servlet-name>
    <url-pattern>/del</url-pattern>
  </servlet-mapping>
```


RegServlet.java:用户注册：
----------------------------

```
package cn.hncu.servlet.day2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import cn.hncu.factory.Dom4jFactory;

public class RegServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Document dom = Dom4jFactory.getDocument();
		//获得所有用户信息
		List<Element> users = dom.selectNodes("//user");
		out.print("<html><body>");
		for(Element e :users){
			String id = e.attributeValue("id");
			System.out.println(id);
			String del = "&nbsp;&nbsp;&nbsp;&nbsp;<a href='/myServletDemo/del?id="+id+"'>删除</a>";
			
			//System.out.println(e.attributeValue("name")+","+e.attributeValue("pwd"));
			out.print("用户名："+e.attributeValue("name")+",密码："+e.attributeValue("pwd")+del+"<br/>");
			
		}
		out.print("<a href='javascript:history.go(-1);'>返回</a>");
		out.print("</body></html>");
	}

	//处理用户注册的表单请求
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		Document dom = Dom4jFactory.getDocument();
		
		PrintWriter out = response.getWriter();
		
		//防护，如果用户已经存在，就给前端发送换一个用户名的信息。
		//xpath
		Node node = dom.selectSingleNode("//user[@name='"+name.trim()+"']");
		if(node!=null){//用户名已经存在，不能注册
			out.print("该用户名已经存在，请换一个!");
			//添加一个返回的链接
			out.print("&nbsp;&nbsp;<a href='javascript:history.go(-1);'>返回</a>");
		}else{//可以注册
			Element root = dom.getRootElement();
			Element elem = root.addElement("user");
			elem.addAttribute("id", UUID.randomUUID().toString().replaceAll("-", ""));
			//replaceAll(String regex, String replacement)  使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
			elem.addAttribute("name", name);
			elem.addAttribute("pwd", pwd);
			
			//存
			Dom4jFactory.save();
			
			//返回注册成功
			out.print("恭喜，注册成功。");
			//添加一个返回的链接
			out.print("&nbsp;&nbsp;<a href='javascript:history.go(-1);'>返回</a>");
		}
	}
}

```

DelServlet.java-实现删除功能:
----------------

```
package cn.hncu.servlet.day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Node;

import cn.hncu.factory.Dom4jFactory;

public class DelServlet extends HttpServlet {
	//只需要get方式就可以了。
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String delId = request.getParameter("id");
		Document dom = Dom4jFactory.getDocument();
		Node node = dom.selectSingleNode("//user[@id='"+delId+"']");
		if(node!=null){
			node.getParent().remove(node);
			Dom4jFactory.save();
		}
		//重定向-继续返回当前页面
		response.sendRedirect("/myServletDemo/reg");
	}
}

```


id的传递用get方式传递的，?号后面的就是id。

演示结果：
-----

注册一个name为张三的用户：
![](http://img.blog.csdn.net/20160720160047628)
![](http://img.blog.csdn.net/20160720160111482)

服务器中users.xml的绝对路径：

![](http://img.blog.csdn.net/20160720160150748)

可以看到，多了一个user标签：

![](http://img.blog.csdn.net/20160720160227858)

显示所有的用户：（多注册几个）

![](http://img.blog.csdn.net/20160720160259749)

如果出现重名的情况：

![](http://img.blog.csdn.net/20160720160416031)

删除链接：?号后跟着的是用户的id

![](http://img.blog.csdn.net/20160720160429812)

点击删除后：用户被删除。

![](http://img.blog.csdn.net/20160720160126363)


注意一点的是：
这个服务器中的users.xml文件和之前myeclipse中的users.xml已经不同了，你注册后，只会把服务器中的users.xml文件修改，而不会去改myeclipse中的users.xml文件，所以，如果你用myeclipse再重新发布，会把你服务器中的那个文件数据全部冲掉。。。。。注意哦。

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
