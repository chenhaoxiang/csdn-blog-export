---
layout: post
title: "【框架】[Hibernate]利用Hibernate进行一对多的级联操作-Web实例"
date: 2016-08-30 05:24:16 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Hibernate
tags: [hibernate,框架,存储,实例]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


准备两个表，学生表，和学院表，它们的关系是一对多，一个学生对应一个学院，一个学院可以对应多个学生。 
在此： 
1、演示利用一对多关系进行级联查询，也就是，只查询某个学院，同时将学院中的所有学生查询出来。 
2、演示利用一对多关系进行级联存储，也就是说，只存储学院，但是同时将学生 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


准备两个表，学生表，和学院表，它们的关系是一对多，一个学生对应一个学院，一个学院可以对应多个学生。 
在此： 
1、演示利用一对多关系进行级联查询，也就是，只查询某个学院，同时将学院中的所有学生查询出来。 
2、演示利用一对多关系进行级联存储，也就是说，只存储学院，但是同时将学生
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

准备两个表，学生表，和学院表，它们的关系是一对多，一个学生对应一个学院，一个学院可以对应多个学生。
在此：
1、演示利用一对多关系进行级联查询，也就是，只查询某个学院，同时将学院中的所有学生查询出来。
2、演示利用一对多关系进行级联存储，也就是说，只存储学院，但是同时将学生信息存储进学生表。

#准备的数据库数据:
```
create database hib charset=utf8;
use hib;
create table students(
    sId varchar(8) primary key,
    sName varchar(40),
    sAge int,
    deptId varchar(8)
);

create table depts(
  dId varchar(8) primary key,
  dName varchar(40)
);

alter table students add(constraint fk_stu_dept foreign key(deptId) references dept(dId));
//为students-deptId添加外键-dept(dId)

insert into depts(dId,dName) values('D001','信息科学与工程学院');
insert into depts(dId,dName) values('D002','土木工程学院');
insert into depts(dId,dName) values('D003','数学与计算机学院');
insert into depts(dId,dName) values('D004','通信学院');

insert into students(sId,sName,sAge,deptId) values('S001','Jack',23,'D001');
insert into students(sId,sName,sAge,deptId) values('S002','Tom',25,'D001');
insert into students(sId,sName,sAge,deptId) values('S003','张三',43,'D001');
insert into students(sId,sName,sAge,deptId) values('S004','李四',55,'D001');
insert into students(sId,sName,sAge,deptId) values('S005','Jack',23,'D002');
insert into students(sId,sName,sAge,deptId) values('S006','Tom',25,'D003');
insert into students(sId,sName,sAge,deptId) values('S007','张三',43,'D002');
insert into students(sId,sName,sAge,deptId) values('S008','李四',55,'D002');
```

这些数据是为了等会自己演示的时候方便。

students表数据如下:

![](http://img.blog.csdn.net/20160830164627202)

depts表数据如下:

![](http://img.blog.csdn.net/20160830164657811)

因为代码比较多，只演示部分代码，完整代码在后面会给出链接。
需要的JAR包，也全部在项目中，下载完整项目即可。


#index.jsp:

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Hibernate中表之间的一对多关系</title>
<style type="text/css">
table {
	border: 1px solid gray;
	border-collapse: collapse;
	width: 60%;
}

td {
	border: 1px solid gray;
	padding: 5px;
}
</style>
</head>

<body>
	<h3>通过学院id查询学院表，把该学院的学生信息也同时输出来</h3>
	<form action="<c:url value='/DemoServlet?cmd=queryDeptById'/>"
		method="post">
		<table>
			<tr>
				<td>学院编号<font color="red">*</font>
				</td>
				<td><input type="text" name="deptId"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="查询">
				</td>
			</tr>
		</table>
	</form>

	<c:if test="${!empty sessionScope.map }">
		<h3>查询结果</h3>
		  学院名称:${map.deptName}
		  <table>
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>学院编号</td>
			</tr>
			<c:forEach items="${map.qlist}" var="stud">
				<tr>
					<td>${stud.sId}</td>
					<td>${stud.sName}</td>
					<td>${stud.sAge}</td>
					<td>${stud.dept.dId}</td>
				</tr>
			</c:forEach>
		</table>
		<c:remove var="map"/>
	</c:if>
	
	<h3>添加学生/学院</h3>
	<form action="<c:url value='/DemoServlet?cmd=addDept'/>" method="post">
		<table>
			<tr>
				<td>学院编号<font color="red">*</font>
				</td>
				<td><input type="text" name="deptId"></td>
			</tr>
			<tr>
				<td>学院名称
				</td>
				<td><input type="text" name="deptName"></td>
			</tr>
			<tr>
				<td align="center">学生学号<font color="red">*</font>
				</td>
				<td align="center"><input type="text" name="studId"></td>
			</tr>
			<tr>
				<td align="center">学生姓名<font color="red">*</font>
				</td>
				<td align="center"><input type="text" name="studName"></td>
			</tr>
			<tr>
				<td align="center">学生年龄<font color="red">*</font>
				</td>
				<td align="center"><input type="text" name="studAge"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="存储"></td>
			</tr>
		</table>
	</form>

</body>
</html>

```


#DemoJdbcDao.java

数据层。

```
package cn.hncu.demo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.hncu.domain.Dept;
import cn.hncu.domain.Student;
import cn.hncu.hib.HibernateSessionFactory;

public class DemoJdbcDao {
	public Dept queryDeptById(Dept dept) {
		Session s = HibernateSessionFactory.getSession();
		String hql = "from Dept d where d.dId=?";
		//String hql = "from Dept";
		Query query = s.createQuery(hql);
		query.setParameter(0, dept.getdId());
		//根据部门ID去查的，只会有一个查询结果
		Dept resDept = (Dept) query.list().get(0);
		return resDept;
	}

	public void addDept(Dept dept) {
		Session s = HibernateSessionFactory.getSession();
		if(dept.getdName()==null){
			Query query = s.createQuery("from Dept d where d.dId=?");
			query.setParameter(0, dept.getdId());
			//对于学院存在的，如果没有填写学院名称，为其补上
			dept.setdName( ((Dept) query.list().get(0)).getdName() );
		}
		s.clear();//把之前的session信息清空，因为不允许一个session对象进行几个操作
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(dept);
		tx.commit();
	}
	
}

```

#DemoServlet

servlet层

```
package cn.hncu.demo;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hncu.demo.service.DemoServiceImpl;
import cn.hncu.domain.Dept;
import cn.hncu.domain.Student;
import cn.hncu.utils.BaseServlet;

public class DemoServlet extends BaseServlet {
	DemoServiceImpl service = new DemoServiceImpl();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
	}
	
	public void queryDeptById(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String deptId = req.getParameter("deptId");
		if(deptId==null||deptId.trim().length()==0){
			resp.sendRedirect(getServletContext().getContextPath());
			return;
		}
		Dept dept = new Dept();
		dept.setdId(deptId);
		dept = service.queryDeptById(dept);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("deptName", dept.getdName());
		map.put("qlist", dept.getStudents());
		
		req.getSession().setAttribute("map", map);
		resp.sendRedirect(getServletContext().getContextPath());
	}
	
	public void addDept(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String deptId = req.getParameter("deptId");
		String deptName = req.getParameter("deptName");
		if(deptName==null||deptName.trim().equals("")){
			deptName=null;
		}
		String studId = req.getParameter("studId");
		String studName = req.getParameter("studName");
		String studAge = req.getParameter("studAge");
		int age = Integer.parseInt(studAge);
		
		Dept dept = new Dept();
		dept.setdId(deptId);
		dept.setdName(deptName);
		
		Student s1 = new Student();
		s1.setsId(studId);
		s1.setsName(studName);
		s1.setsAge(age);
		s1.setDept(dept);//多方进行设置外键
		
		//把多方添加到一方的集合中
		dept.getStudents().add(s1);
		
		service.addDept(dept);
		
		resp.sendRedirect(getServletContext().getContextPath());
	}
	
}

```


#演示结果：

开始显示页面:

![](http://img.blog.csdn.net/20160830165721503)

查询D002学院:

![](http://img.blog.csdn.net/20160830165756394)

为D002学院添加学生:

![](http://img.blog.csdn.net/20160830170254542)

结果:
![](http://img.blog.csdn.net/20160830170313991)

添加D005学院-科技学院

![](http://img.blog.csdn.net/20160830170336746)

结果

![](http://img.blog.csdn.net/20160830170347992)


#完整的项目链接:

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'><a href='https://github.com/chenhaoxiang/Java/tree/master/Hibernate/myHibWeb2'><font color="red">--&gt;点击访问本系列源码以及JAR包</font></a><br>
</blockquote>

#小小的总结:

此项目，我写的时候比较急，因为马上要学Spring框架了，有些方面没考虑到，有兴趣的可以自己取完善一下。例如，在增加学院和学生的时候，增加一个按钮，添加学生。再比如，把service,DAO层完善一下，写好接口，最好再写个过滤器，全站压缩，编码啥的。哈哈，自己可以加功能的。

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
