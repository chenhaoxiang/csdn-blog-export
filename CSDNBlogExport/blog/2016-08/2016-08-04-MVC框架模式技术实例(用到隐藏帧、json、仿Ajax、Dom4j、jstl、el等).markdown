---
layout: post
title: "MVC框架模式技术实例(用到隐藏帧、json、仿Ajax、Dom4j、jstl、el等)"
date: 2016-08-04 02:11:52 +0800
comments: true
categories:❷ Java大学之行,----- ①、Java/Web小项目,----- ⑥、框架/第三方工具
tags: [ajax,mvc,框架,实例,技术]
keyword: 陈浩翔, 谙忆
description: 前言：刚刚学完了MVC，根据自己的感悟和理解写了一个小项目。 
完全按照MVC模式，后面有一个MVC的理解示意图。用MVC模式重新完成了联系人的管理系统：用户需求：
多用户系统，提供用户注册、登录功能，对于没有登录的用户，不允许使用任何功能。
可以查询、增加和删除联系人信息。
详细设计：
数据结构设计。
功能模块设计。
工具类设计。
搭建初步的项目框架、其他功能：防止用户重复提交、注册和登录时使用验 
---


前言：刚刚学完了MVC，根据自己的感悟和理解写了一个小项目。 
完全按照MVC模式，后面有一个MVC的理解示意图。用MVC模式重新完成了联系人的管理系统：用户需求：
多用户系统，提供用户注册、登录功能，对于没有登录的用户，不允许使用任何功能。
可以查询、增加和删除联系人信息。
详细设计：
数据结构设计。
功能模块设计。
工具类设计。
搭建初步的项目框架、其他功能：防止用户重复提交、注册和登录时使用验
<!-- more -->
----------

前言：
===
刚刚学完了MVC，根据自己的感悟和理解写了一个小项目。
完全按照MVC模式，后面有一个MVC的理解示意图。

用MVC模式重新完成了联系人的管理系统：

```
用户需求：
多用户系统，提供用户注册、登录功能，对于没有登录的用户，不允许使用任何功能。
可以查询、增加和删除联系人信息。
详细设计：
数据结构设计。
功能模块设计。
工具类设计。
搭建初步的项目框架、其他功能：防止用户重复提交、注册和登录时使用验证码。
```

项目代码在后面、

演示效果：
-----

主页：

![](http://img.blog.csdn.net/20160804015344264)

注册页面：

![](http://img.blog.csdn.net/20160804015401983)


MVC介绍：
======

MVC全名是Model View Controller，是模型(model)－视图(view)－控制器(controller)的缩写，一种软件设计典范，用一种业务逻辑、数据、界面显示分离的方法组织代码，将业务逻辑聚集到一个部件里面，在改进和个性化定制界面及用户交互的同时，不需要重新编写业务逻辑。MVC被独特的发展起来用于映射传统的输入、处理和输出功能在一个逻辑的图形化用户界面的结构中。

Struts、ZF、.NET、Spring MVC、Tapestry、JSF等常用流行框架，都是MVC框架模式、


框架和设计模式的区别
==========

有很多程序员往往把框架模式和设计模式混淆，认为MVC是一种设计模式。实际上它们完全是不同的概念。[7] 
框架、设计模式这两个概念总容易被混淆，其实它们之间还是有区别的。框架通常是代码重用，而设计模式是设计重用，架构则介于两者之间，部分代码重用，部分设计重用，有时分析也可重用。在软件生产中有三种级别的重用：内部重用，即在同一应用中能公共使用的抽象块;代码重用，即将通用模块组合成库或工具集，以便在多个应用和领域都能使用；应用框架的重用，即为专用领域提供通用的或现成的基础结构，以获得最高级别的重用性。

框架与设计模式虽然相似，但却有着根本的不同。设计模式是对在某种环境中反复出现的问题以及解决该问题的方案的描述，它比框架更抽象；框架可以用代码表示，也能直接执行或复用，而对模式而言只有实例才能用代码表示;设计模式是比框架更小的元素，一个框架中往往含有一个或多个设计模式，框架总是针对某一特定应用领域，但同一模式却可适用于各种应用。可以说，框架是软件，而设计模式是软件的知识。

框架模式有哪些？
MVC、MTV、MVP、CBD、ORM等等；

Java语言的框架有哪些？
SSH 、SSI，等等

设计模式有哪些？
工厂模式、适配器模式、策略模式等等

简而言之：框架是大智慧，用来对软件设计进行分工；设计模式是小技巧，对具体问题提出解决方案，以提高代码复用率，降低耦合度。


图示介绍一下MVC
---------

前面的第一个部分就是MVC框架模式

![](http://img.blog.csdn.net/20160801225238178)


实例演示：
=====

因为代码量比较大，只写部分代码：

全部代码：
-----

所有的代码我已push至github，链接：

https://github.com/chenhaoxiang/Web/tree/master/myMvcWeb


可以看看我的构架：
前台jsp-->servlet-->service-->dao-->数据库(这里用xml简单当做数据库)

![](http://img.blog.csdn.net/20160804020001659)
![](http://img.blog.csdn.net/20160804020012159)

Dom4jDocument.java:
-------------------

```
package cn.hncu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.hncu.domain.Contact;
import cn.hncu.domain.User;

public class Dom4jDocument {
	
	private static Document dom=null;
	private static String path;
	//静态块！只会在类加载的时候运行一次
	static{
		
		try {
			SAXReader sax = new SAXReader();
			//因为我们的资源已经从myelipse中发布到tomcat服务器中了，所以跟原来的纯Java项目不一样了。
			//利用当前类找到它的类加载器，然后通过该类加载器再去获得资源路径
			path = Dom4jDocument.class.getClassLoader().getResource("users.xml").getPath();
			 //getClassLoader()返回：加载此对象所表示的类或接口的类加载器
			//public URL getResource(String name)返回：读取资源的 URL 对象；如果找不到该资源，或者调用者没有足够的权限获取该资源，则返回 null。
			//此方法首先搜索资源的父类加载器；如果父类加载器为 null，则搜索的路径就是虚拟机的内置类加载器的路径。
			//public String getPath()获取此 URL 的路径部分。 
			dom = sax.read(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 保存到服务器-本地
	 * @return 布尔型
	 */
	public static boolean save(){
		
		try {
			XMLWriter w = new XMLWriter(new FileOutputStream(path));
			w.write(dom);
			w.close();
		}catch (UnsupportedEncodingException e) {
			return false;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * @param uuid - 通过联系人的uuid-删除联系人
	 * @return
	 */
	public static boolean del(String uuid){
		Node node = dom.selectSingleNode("//contacts[@uuid=\""+uuid+"\"]");
		if(node==null){
			return false;
		}
		node.getParent().remove(node);
		save();
		return true;
	}
	
	
	/**
	 * 添加联系人
	 * @param uuid--通过user的uuid
	 * @return
	 */
	public static boolean addContact(String userUuid,Contact contacts){
		Element userNode = (Element)dom.selectSingleNode("//user[@uuid=\""+userUuid+"\"]");
		if(userNode==null){
			return false;
		}
		Element contactE =  userNode.addElement("contacts");
		contactE.addAttribute("uuid", contacts.getUuid());
		contactE.addAttribute("name", contacts.getName());
		contactE.addAttribute("age", ""+contacts.getAge());
		contactE.addAttribute("tel", contacts.getTel());
		
		save();
		return true;
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public static boolean addUser(User user){
		//先防范重复name的
		if(dom.selectSingleNode("//user[@name=\""+user.getName()+"\"]")!=null){
			return false;
		}
		
		try {
			Element root = dom.getRootElement();
			Element u = root.addElement("user");
			u.addAttribute("uuid", user.getUuid());
			u.addAttribute("name", user.getName());
			u.addAttribute("pwd", user.getPwd());
			save();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 用户登录时，返回封装的user或false
	 * @param user
	 * @return
	 */
	public static User login(User user){
		Element userE = (Element)dom.selectSingleNode("//user[@name=\""+user.getName()+"\"]");
		if(userE==null){
			return null;
		}
		user.setUuid(userE.attributeValue("uuid"));
		return user;
	}
	
	public static List<Contact> getUserContacts(String userUuid){
		List<Contact> contacts = new ArrayList<Contact>();
		
		Element user = (Element) dom.selectSingleNode("//user[@uuid=\""+userUuid+"\"]");
		
		List<Element> lists =  user.elements();
		for(Element list:lists){
			Contact c = new Contact();
			c.setName(list.attributeValue("name"));
			c.setAge(Integer.parseInt(list.attributeValue("age")));
			c.setTel(list.attributeValue("tel"));
			c.setUuid(list.attributeValue("uuid"));
			contacts.add(c);
		}
		return contacts;
	}
	
	
	public static List<Contact> getQueryContacts(Contact contact,String userUuid){
		List<Contact> contacts = new ArrayList<Contact>();
		
		Element user = (Element) dom.selectSingleNode("//user[@uuid=\""+userUuid+"\"]");
		if(user==null){
			return null;
		}
		
		String name = contact.getName().trim();
		Integer age = contact.getAge();
		String tel = contact.getTel().trim();
		
//		System.out.println("name="+name);
//		System.out.println("age="+age);
//		System.out.println("tel="+tel);
		
		List<Element> lists =  user.elements();
		for(Element c : lists){
			//System.out.println("c=="+c);
			if(name.equals("")||c.attributeValue("name").indexOf(name)!=-1){
				if(age==-1||c.attributeValue("age").indexOf(age+"")!=-1){
					if(tel.equals("")||c.attributeValue("tel").indexOf(tel)!=-1){
						Contact cc = new Contact();
						cc.setName(c.attributeValue("name"));
						cc.setAge(Integer.parseInt(c.attributeValue("age")));
						cc.setTel(c.attributeValue("tel"));
						cc.setUuid(c.attributeValue("uuid"));
						contacts.add(cc);
					}
				}
			}
		}
		return contacts;
	}
	
}

```

生成验证码：

ImgServlet.java:
----------------

```
package cn.hncu.servlets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 生成验证码！
 * ---4个随机数字，8条随机干扰线-数字，线的颜色随机
 * @author 陈浩翔
 * 2016-8-2
 */
public class ImgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("imag/jpg");
		
		int width = 80;
		int height= 30;
		int lines = 8;
		
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics g = img.getGraphics();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		
		g.setFont(new Font("黑体", Font.BOLD, 18));
		
		long time = new Date().getTime();
		
		String realCode="";
		
		Random r = new Random(time);
		for(int i=0;i<4;i++){
			Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
			g.setColor(c);
			
			int y=r.nextInt(10);
			
			int a = r.nextInt(10);
			g.drawString(a+"",5+i*18,y+12);
			realCode+=a;
		}
		
		Cookie cook = new Cookie("realCode", realCode);
		cook.setMaxAge(60*60);
		cook.setPath(request.getContextPath());
		response.addCookie(cook);
		
		//request.getServletContext().setAttribute("realCode",realCode);
		//System.out.println("imgServlet:"+realCode);
		
		for(int i=0;i<lines;i++){
			Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
			g.setColor(c);
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}
		
		//刷入img对象
		g.dispose();
		
		ImageIO.write(img, "jpg", response.getOutputStream());
		
		
	}

}

```

LoginServlet.java:
------------------

```
package cn.hncu.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hncu.domain.Contact;
import cn.hncu.domain.User;
import cn.hncu.service.UserIService;
import cn.hncu.service.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	
	
	//注入service
	UserIService service = new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//1、收集参数
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String code = request.getParameter("code");
		String realCode="";
		Cookie[] cs = request.getCookies();
		for(Cookie c:cs){
			if(c.getName().equals("realCode")){
				realCode=c.getValue();
				break;
			}
		}
		
		//System.out.println("rc="+realCode);
		//判断验证码
		if(!code.equals(realCode)){
			response.getWriter().print("<h1>验证码错误！</h1>");
			return;
		}
		
		//2组织参数
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		
		//3调用service层
		user = service.login(user);
		//System.out.println(user);
		//4根据service层的返回结果，导向不同的结果页面---直接到前台去防护了
		
		if(user==null){
			response.getWriter().print("<h1>用户名或密码错误！</h1>");
			return ;
			
		}
		
		//System.out.println(request.getLocalAddr());
		
		List<Contact> contacts = new ArrayList<Contact>();
		//通过user的uuid拿到所有的联系人
		contacts=service.getUserContacts(user.getUuid());
		
		request.getSession().setAttribute("contacts", contacts);
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("userUuid",user.getUuid());
		
		request.getRequestDispatcher("/jsps/contacts.jsp").forward(request, response);
	}
}

```

contacts.jsp
------------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<c:if test="${empty sessionScope.user}">
		<c:redirect url="/index.jsp"></c:redirect>
	</c:if>
	
	<link rel="stylesheet" href='<c:url value="/css/table.css"></c:url>'>
		
	<script type="text/javascript" src='<c:url value="/js/contact.js"></c:url>'>
	</script>
	
	<script type="text/javascript">
		var path = '<c:url value="/" />';
	</script>
  </head>
  
  <body>
  	<br/>
  	<div>
  		<button onclick="_add()">添加联系人</button> &nbsp;&nbsp;
  		<button onclick="_del()">删除联系人</button> &nbsp;&nbsp;
  		<button onclick="_query()">查询联系人</button>
  	</div>
  	<br/>
  	<div>
  	<table id="tb">
  		<tr>
			<th>选择<input type="checkbox" id="parentChk" onclick="chk(this)"/></th>
			<th>姓名</th>	
			<th>年龄</th>	
			<th>电话</th>
			<th>ID</th>
  		</tr>
  		<c:forEach items="${contacts}" var="contact">
			<tr>
			<td><input type="checkbox" name="childChk"  onclick="subchk(this)" /></td>
			<td>${contact.name}</td>	
			<td>${contact.age}</td>	
			<td>${contact.tel}</td>
			<td>${contact.uuid}</td>
  		</tr>
  		</c:forEach>
  	</table>
  	
  	<!-- 下面的form和iframe是用于做"_del()"功能的myAjax -->
  	<form name="form" target="df" action='<c:url value="/DelServlet" ></c:url>' method="post">
  		<input type="hidden" name="ids" id="ids" />
  	</form>
  	<iframe name="df" style="display: none;"></iframe>
  	</div>
  </body>
</html>

```

contact.js:
-----------

```
function _add(){
	var url = path+"jsps/input.jsp";
	var result = window.showModalDialog(url,"","dialogWidth:400px;dialogHeight:300px;");
	if(result==null){
		return;
	}
	realadd(result);
}

function realadd(obj){
	var oTable = document.getElementById("tb");
	var oTr = oTable.insertRow();
	
	var oTd = oTr.insertCell();
	oTd.innerHTML='<input type="checkbox" name="childChk"  onclick="subchk(this)" /> ';
	oTr.insertCell().innerHTML=obj.name;
	oTr.insertCell().innerHTML=obj.age;
	oTr.insertCell().innerHTML=obj.tel;
	oTr.insertCell().innerHTML=obj.id; 
}

function chk(obj){
	//监听全部选择的那个复选框
	var allChildChks = document.getElementsByName("childChk");
	for(var i=0;i<allChildChks.length;i++){
		allChildChks[i].checked=obj.checked;
	}
}

function subchk(obj){
	//复选框监听
	if(obj.checked==false){
		document.getElementById("parentChk").checked=false;
	}else{
		var boo = true;
		var allChildChks = document.getElementsByName("childChk");
		for(var i=0;i<allChildChks.length;i++){
			if(allChildChks[i].checked == false ){
				boo=false;
				break;
			}
		}
		if(boo){
			document.getElementById("parentChk").checked=true;
		}
	}
}

function _del(){
	var ids ="";
	var oTable = document.getElementById("tb");
	var allChildChks = document.getElementsByName("childChk");
	for(var i=0;i<allChildChks.length;i++){
		if(allChildChks[i].checked==true){
			var id = oTable.rows[i+1].cells[4].innerHTML;
			if(ids==""){
				ids=id;
			}else{
				ids+=","+id;
			}
		}
	}
	//alert(ids);
	if(ids==""){
		alert("请选择要删除的行!");
	}else{
		document.getElementById("ids").value=ids;
		document.forms["form"].submit();
	}
}

//这里因为每个用户只能操坐自己的联系人。因此，当前用户操作时，没有其他用户对这些联系人进行增删改操作。
//如果要想多用户能够同时对同一集合联系人进行增删改查，那么每个增删改查的动作必须
//实时利用ajax向后台查询(在后台把结果放入list中，然后在前台利用<forEach>显示)

function realdel(boo){
	if(!boo){
		alert("很遗憾,删除失败了！");
		return;
	}
	
	var oTable = document.getElementById("tb");
	var allChildChks = document.getElementsByName("childChk");
	//因为allChiledChks的长度是随着删除而变短的，所以要用后面先删除、当然，可以从前面删除，不过要防范一下
	for(var i=allChildChks.length-1;i>=0;i--){
		if(allChildChks[i].checked == true){
			var oTr = oTable.rows[i+1];
			oTr.parentNode.removeChild(oTr);
		}
	}
	
	//对全选框设置为不打勾
	document.getElementById("parentChk").checked=false;
}

function _query(){
	var url = path+"jsps/query.jsp";
	var result = window.showModalDialog(url,"","dialogWidth:650px;dialogHeight:400px;");
	if(result==null){
		return;
	}
	realadd(result);
} 

```


添加联系人和查询联系人页面：
--------------

![](http://img.blog.csdn.net/20160804015513281)

![](http://img.blog.csdn.net/20160804015522610)


总的来说，无论是设计模式，还是框架，其实都需要我们多去做做项目，自己多练习，只看书是远远不够的，需要自己动手才知道不足之处！
大家一起进步吧，O(∩_∩)O哈哈~

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
