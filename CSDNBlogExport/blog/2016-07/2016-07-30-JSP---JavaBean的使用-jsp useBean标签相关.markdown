---
layout: post
title: "JSP---JavaBean的使用-jsp useBean标签相关"
date: 2016-07-30 03:49:51 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- JSP/XML知识点
tags: [java,javabean]
keyword: 陈浩翔, 谙忆
description: JavaBean介绍：JavaBean其实就是一个遵循特定写法的java类，但是必须具有如下特点：    1.这个java类必须具有一个公开的无参构造函数    2.属性必须私有化，类必须公开    3.私有化的属性必须通过public类型的方法暴露给其他程序，并且方法的命名也必须遵守一定的命名规范---getXxx和setXxx方法。
定义： 把一个拥有对属性进行set和get方法的类，我们就可以 
---


JavaBean介绍：JavaBean其实就是一个遵循特定写法的java类，但是必须具有如下特点：    1.这个java类必须具有一个公开的无参构造函数    2.属性必须私有化，类必须公开    3.私有化的属性必须通过public类型的方法暴露给其他程序，并且方法的命名也必须遵守一定的命名规范---getXxx和setXxx方法。
定义： 把一个拥有对属性进行set和get方法的类，我们就可以
<!-- more -->
----------

JavaBean介绍：
===========

JavaBean其实就是一个遵循特定写法的java类，但是必须具有如下特点：


        1.这个java类必须具有一个公开的无参构造函数

        2.属性必须私有化，类必须公开

        3.私有化的属性必须通过public类型的方法暴露给其他程序，并且方法的命名也必须遵守一定的命名规范---getXxx和setXxx方法。

定义：
---

     把一个拥有对属性进行set和get方法的类，我们就可以称之为JavaBean。实际上JavaBean就是一个java类，在这个java类中就默认形成了一种规则——对属性进行设置和获得。而反之将说ava类就是一个JavaBean，这种说法是错误的，因为一个java类中不一定有对属性的设置和获得的方法（也就是不一定有set和get方法）。




在JSP中访问JavaBean的语法：
-------------------

```
1、声明JavaBean对像-必须使用完整类名：
<jsp:useBean id=“someBean” class=“package.SomeBean” scope=“page”/>
以上声明相当于：
SomeBean someBean = new SomeBean();
pageContext.setAttribute(“someBean”,someBean);
scope的可选值为：page|request|session|application
需要说明的是：一般情况下，我们保留<jsp:useBean/>的body部分为空，如果不为空，则只有初始化此Bean时执行，如：
<jsp:useBean id=“person” class=“cn.Person”>
        这是body部分，只会在初始化时执行一次
</jsp:userBean>
2、访问JavaBean的属性：
<jsp:setProperty name=“someBean” property=“name” value=“Tom”/>
<jsp:getProperty name=“someBean” property=“name”/>
也可以在页面上使用Java代码直接访问它的属性和其他方法。
```


`<jsp:useBean>`标记：

          <jsp:useBean id="name" class="classname" scope="page|request|session|application"/>

          id:代表jsp页面中的实例对象 通过这个对象引用类中的成员，如，id="wq", wq.成员（）;

          class: 代表JavaBean类，如： class="com.Test",引用com包中的Test类

          scope：指明了javabean的生存时间




JavaBean的范围：
------------

JavaBean的scope属性决定的Bean的范围，默认为page范围。
当声明了一个Bean并将它放到某个范畴之后，在同一个范围内再次使用`<jsp:useBean../>`将不再创建。而是直接给你返回已经创建过的Bean的实例。此过程可以通过查看容器翻译的源代码得知。


演示属性名是基本数据类型时的jsp:useBean用法：
==============


User.java:
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
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}

```

javaBean.jsp:
-------------

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
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}

```

doBeanForm.jsp:
---------------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <%
  		request.setCharacterEncoding("utf-8");
  	%>
  
  	<jsp:useBean id="user3" class="cn.hncu.regServletPojo.domain.User"></jsp:useBean>
  	<!-- 下面这句相当于user3.setName( request.getParameter("name") ); -->
  	<jsp:setProperty property="name" name="user3" param="name"/>
  	<jsp:setProperty property="age" name="user3" param="age"/>
  	${user3}
  	
  	<br/><br/>
  	<jsp:useBean id="user4" class="cn.hncu.regServletPojo.domain.User"></jsp:useBean>
  	<!-- 属性用“*”号，就是让系统自动根据提交上来的参数去找对应的属性赋值 -->
  	<jsp:setProperty property="*" name="user4"/>
  	${user4}
  	<br/><br/>
  </body>
</html>

```


演示属性名与setter-getter方法比较特殊时的jsp:useBean用法：
=========================================


Person.java:
------------

```
package cn.hncu.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈浩翔
 *
 * 2016-7-30
 */
public class Person {
	private String name;
	private Integer age;//最好用Integer对象，而不用int
	private Date birth;
	//特殊的属性(这个变量的类型不是基本数据类型时,<jsp:setProperty>标记无法直接使用！)
	//解决方案：不写它自己默认的setter-getter--setBirth(Date)
	//而是写一对替代该属性的setter-getter ---setBirthday(String)方法
	//另外，在页面使用<jsp:setProperty>时，属性名应该用替代setter-getter 方法反推出的属性名-这里要用---birthday
	
	
	//开始我想着用重载做，其实重载也是可以实现这个一样的功能，不过注意哦，返回类型不能重载的！所以get方法是肯定不行的，综合，还是上面那个方法好。
	
	
	public Person() {
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

	/*
	 //我们要做的就是改这个2个方法
	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}
	*/
	
	//注入日期格式
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public String getBirthday(){
		return sdf.format(birth);
	}
	
	public void setBirthday(String strDate){
		try {
			Date birth = sdf.parse(strDate);
			this.birth=birth;
		} catch (ParseException e) {
			throw new RuntimeException("日期格式错误", e);
		}
		
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", birth=" + birth
				+ "]";
	}
}

```


javaBean.jsp:增加代码
-----------------

```
<br/><br/>
  	<!-- 以下演示属性名与setter-getter方法比较特殊时的jsp:userBean用法 -->
  	<jsp:useBean id="person" class="cn.hncu.bean.Person"></jsp:useBean>
  	<jsp:setProperty property="name" name="person" value="Tom"/>
  	<jsp:setProperty property="age" name="person" value="35"/>
  	<!-- 注意下面这句的property的值是：birthday !!!-->
  	<jsp:setProperty property="birthday" name="person" value="2016-7-30"/>
  	
  	<jsp:getProperty property="name" name="person"/>
  	<jsp:getProperty property="age" name="person"/>
  	<jsp:getProperty property="birthday" name="person"/>
```


演示结果：
-----

![](http://img.blog.csdn.net/20160730154926974)

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
