---
layout: post
title: "MySQL---数据库从入门走向大神系列(十六)-JavaWeb分页技术实例演示1"
date: 2016-08-16 05:22:08 +0800
comments: true
categories:❷ Java大学之行,----- ⑤、数据库,----- ①、Java/Web小项目
tags: [数据库,分页,技术,实例]
keyword: 陈浩翔, 谙忆
description: 分页,是一种将所有数据分段展示给用户的技术.用户每次看到的不 是全部数据,而是其中的一部分,如果在其中没有找到自己想要的内容,用户可以通过指定页码或是点上/下一页的方式进行翻页。本例演示静态分页，也就是先设置好每页显示10行，再根据总行数，来算出总页数，将所有页数的页号都显示出来。 
相关算法(技术):
总行数(num): select count(1) from stud;每页显示的行数(n): 
---


分页,是一种将所有数据分段展示给用户的技术.用户每次看到的不 是全部数据,而是其中的一部分,如果在其中没有找到自己想要的内容,用户可以通过指定页码或是点上/下一页的方式进行翻页。本例演示静态分页，也就是先设置好每页显示10行，再根据总行数，来算出总页数，将所有页数的页号都显示出来。 
相关算法(技术):
总行数(num): select count(1) from stud;每页显示的行数(n):
<!-- more -->
----------

分页,是一种将所有数据分段展示给用户的技术.用户每次看到的不 是全部数据,而是其中的一部分,如果在其中没有找到自己想要的内容,用户可以通过指定页码或是点上/下一页的方式进行翻页。

本例演示静态分页，也就是先设置好每页显示10行，再根据总行数，来算出总页数，将所有页数的页号都显示出来。
相关算法(技术):

```

总行数(num): select count(1) from stud;

每页显示的行数(n): 固定值---已知的一个常量

页数: pageSize= num/n +( (num%n==0)?0:1 )

当前页号: currentPage

当前要显示的页面数据的起始行号和终止行号
startN: (currentPage-1)*pageSize

如何显示从startN开始的pageSize条记录
select * from stud limit startN, pageSize;
```


像这样：
![](http://img.blog.csdn.net/20160816164228895)

点击哪一页就显示哪一页的内容。

#数据库数据：
数据库的表和数据在这一篇博客中已经准备好了：
http://blog.csdn.net/qq_26525215/article/details/52212571
```
create table person(
    id varchar(30) primary key,
    name varchar(30),
    address varchar(30),
    age int
);
```
![](http://img.blog.csdn.net/20160816170504138)



#DAO层：

##接口：
```
package cn.hncu.dao;

import java.sql.SQLException;
import java.util.Map;

public interface IPageDAO {
	public Map<String, Object> query(Integer pageNo) throws NumberFormatException, SQLException;
}

```

##实现类：

```
package cn.hncu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.hncu.pubs.C3p0Pool;

public class PageJdbc implements IPageDAO {
	
	//每页显示的行数
	private final int pageSize = 10;
	
	@Override
	public Map<String, Object> query(Integer pageNo) throws NumberFormatException, SQLException {
		Map<String, Object> result = new HashMap<String, Object>();
		
		//获取总页数 pageCount = rows/pageSize + ((rows%pageSize==0)?0:1)
		//总行数 rows
		String sql = "select count(1) from person";
		QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());
		
		int rows =Integer.parseInt(""+run.query(sql, new ScalarHandler())); 
		
		//总页数
		int pageCount = rows/pageSize +  ((rows%pageSize==0)?0:1);
		result.put("pageCount", pageCount);
		
		//分页后的当前页面内容datas
		//起始行号
		int startN = (pageNo-1)*pageSize;
		sql = "select * from person limit "+startN+" , "+pageSize;
		List<Map<String, Object>> datas = run.query(sql, new MapListHandler());
		result.put("datas", datas);//封装到result
		
		return result;
	}
	
	@Test
	public void test() {
		try {
			Map<String, Object> map = query(5);
			System.out.println(map);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

```

#C3p0配置文件c3p0-config.xml:

```
<c3p0-config>
	<!-- 默认配置，如果没有指定则使用这个配置 -->
	<default-config>
		<property name="driverClass">com.mysql.jdbc.Driver</property>
		<property name="jdbcUrl">
			<![CDATA[jdbc:mysql://127.0.0.1:3306/hncu?useUnicode=true&characterEncoding=UTF-8]]>
		</property>
		<property name="user">root</property>
		<property name="password">1234</property>
		<!-- 初始化池大小 -->
		<property name="initialPoolSize">2</property>
		<!-- 最大空闲时间 -->
		<property name="maxIdleTime">30</property>
		<!-- 最多有多少个连接 -->
		<property name="maxPoolSize">10</property>
		<!-- 最少几个连接 -->
		<property name="minPoolSize">2</property>
		<!-- 每次最多可以执行多少个批处理语句 -->
		<property name="maxStatements">50</property>
	</default-config> 
	<!-- 命名的配置 -->
	<named-config name="demo">
		<property name="driverClass">com.mysql.jdbc.Driver</property>
		<property name="jdbcUrl"><![CDATA[jdbc:mysql://127.0.0.1:3306/hncu?useUnicode=true&characterEncoding=UTF-8]]></property>
		<property name="user">root</property>
		<property name="password">1234</property>
		<property name="acquireIncrement">5</property><!-- 如果池中数据连接不够时一次增长多少个 -->
		<property name="initialPoolSize">100</property>
		<property name="minPoolSize">50</property>
		<property name="maxPoolSize">1000</property>
		<property name="maxStatements">0</property>
		<property name="maxStatementsPerConnection">5</property> <!-- he's important, but there's only one of him -->
	</named-config>
</c3p0-config> 

```

#C3p0数据库连接池：

```
package cn.hncu.pubs;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Pool {
	private static DataSource pool;
	private static ThreadLocal<Connection> t = new ThreadLocal<Connection>();
	static{
		pool = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		return pool;
	}
	
	public static Connection getConnection() throws SQLException{
		Connection con=t.get();
		if(con==null){
			con = pool.getConnection();
			t.set(con);
		}
		return con;
	}
	
}

```

#service层：

##接口：
```
package cn.hncu.service;

import java.sql.SQLException;
import java.util.Map;

public interface IPageService {
	public Map<String, Object> query(Integer pageNo) throws NumberFormatException, SQLException;
}


```

##实现类

```
package cn.hncu.service;

import java.sql.SQLException;
import java.util.Map;

import cn.hncu.dao.IPageDAO;
import cn.hncu.dao.PageJdbc;

public class PageServiceImpl implements IPageService{
	//注入dao
	IPageDAO dao = new PageJdbc();
	
	@Override
	public Map<String, Object> query(Integer pageNo) throws NumberFormatException, SQLException {
		return dao.query(pageNo);
	}
}

```

#index.jsp:

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<c:redirect url="/PageServlet"></c:redirect>
  </body>
</html>

```

#show.jsp:

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>演示数据分页显示</title>
  	<link rel="stylesheet" href="<c:url value='/css/table.css' />" />
  	
  	<script type="text/javascript">
  		function sub(obj){
  			window.location.href="<c:url value='/PageServlet?page=' />"+obj.value;
  		}
  	</script>
  	
  </head>
  	
  <body>
  	<h3>当前页的内容:</h3>
  	<table>
  		<tr><th>学号</th><th>姓名</th></tr>
  		<c:forEach items="${result.datas}" var="map">
  			<tr>
  				<td>${map.id}</td>
  				<td>${map.name}</td>
  			</tr>
  		</c:forEach>
  	</table>
  	
  	
  	<c:if test="${result.currentPage!=1}">
  		<span class="pc">
  			<a href='<c:url value="/PageServlet?page=${result.currentPage-1}"></c:url>'>上一页</a>
  		</span>
  	</c:if>
  	
  	&nbsp;&nbsp;
  	<c:forEach begin="1" end="${result.pageCount}" var="idx">
		<c:if test="${idx==result.currentPage}" var="isNow">
			<span class=now>${idx}</span>
		</c:if>  		
  		<c:if test="${!isNow }">
  			<span class="pc">
  				<a href='<c:url value="/PageServlet?page=${idx}"></c:url>'>${idx}</a>
  			</span>
  		</c:if>
  		&nbsp;&nbsp;
  	</c:forEach>
  	
  	<c:if test="${result.currentPage!=result.pageCount}">
  		<span class="pc">
  			<a href="<c:url value='/PageServlet?page=${result.currentPage+1}'></c:url>">下一页</a>
  		</span>
  	</c:if>
  	<br/><br/>
  	
  	<!-- 复选框 -->
  	<select onchange="sub(this)">
  		<c:forEach begin="1" end="${result.pageCount}" var="idx">
  			<option <c:if test="${idx==result.currentPage}">selected="selected"</c:if> value="${idx}" >
  				第${idx}页
  			</option>
  		</c:forEach>
  	</select>
  	
  </body>
</html>

```

#table.css:

```
body{
	text-align: center;
}
table{
	border: 1px solid blue;
	width: 500px;
	border-collapse: collapse;/*为表格设置合并边框模型：*/
	margin: auto;
}
td,th,tr{
	border:  1px solid blue;
}
.pc{
    width: 30px;
    height: 30px;
    border: 1px solid #e1e2e3;
    border-top-color: rgb(225, 226, 227);
    border-top-style: solid;
    border-top-width: 1px;
    border-right-color: rgb(225, 226, 227);
    border-right-style: solid;
    border-right-width: 1px;
    border-bottom-color: rgb(225, 226, 227);
    border-bottom-style: solid;
    border-bottom-width: 1px;
    border-left-color: rgb(225, 226, 227);
    border-left-style: solid;
    border-left-width: 1px;
}
.now {
    display: block;
}
```

#web.xml:

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" 
	xmlns="http://java.sun.com/xml/ns/javaee" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
  <display-name></display-name>
  <servlet>
    <servlet-name>PageServlet</servlet-name>
    <servlet-class>cn.hncu.servlet.PageServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>PageServlet</servlet-name>
    <url-pattern>/PageServlet</url-pattern>
    <!-- 这里的/代表项目根目录下 -->
  </servlet-mapping>	
  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
</web-app>

```

#PageServlet.java:

```
package cn.hncu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hncu.service.IPageService;
import cn.hncu.service.PageServiceImpl;

public class PageServlet extends HttpServlet {
	//注入service
		IPageService service = new PageServiceImpl();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			doPost(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
	String pageNo = request.getParameter("page");
			
			if(pageNo==null || pageNo.trim().length()<=0){
				pageNo="1";
			}
			
			Integer iPageNo=1;
			try {
				iPageNo = Integer.parseInt(pageNo);
			} catch (NumberFormatException e) {
				iPageNo=1;
			}
			
			try {
				Map<String, Object> result = service.query(iPageNo);
				
				//给结果集补一个数据:currentPage
				result.put("currentPage", iPageNo);
				
				//###注意，一定要把结果集放入容器中
				request.setAttribute("result", result);
				
				//转到结果页面
				request.getRequestDispatcher("/jsps/show.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}

```

#演示结果：

![](http://img.blog.csdn.net/20160816172339834)


#需要的第三方扩展包：

![](http://img.blog.csdn.net/20160816171705988)

链接：
https://github.com/chenhaoxiang/Java/tree/master/Database-support-package



#完整项目代码链接：

https://github.com/chenhaoxiang/Java/tree/master/myPagesDividedWeb


转载请附上原文博客链接： 
http://blog.csdn.net/qq_26525215

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
