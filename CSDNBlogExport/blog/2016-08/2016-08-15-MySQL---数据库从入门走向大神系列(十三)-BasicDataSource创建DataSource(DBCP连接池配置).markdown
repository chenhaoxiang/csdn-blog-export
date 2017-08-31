---
layout: post
title: "MySQL---数据库从入门走向大神系列(十三)-BasicDataSource创建DataSource(DBCP连接池配置)"
date: 2016-08-15 03:55:08 +0800
comments: true
categories:❷ Java大学之行,----- ⑤、数据库
tags: [数据库,DBCP,Connection,DataSource]
keyword: 陈浩翔, 谙忆
description: 首先，下载必须的jar包dbcp包，目前版本是2.1.1 ： 
http://commons.apache.org/proper/commons-dbcp/download_dbcp.cgipool包，目前版本是2.4.2： 
http://commons.apache.org/proper/commons-pool/download_pool.cgiApache Commons Logging 包 
---


首先，下载必须的jar包dbcp包，目前版本是2.1.1 ： 
http://commons.apache.org/proper/commons-dbcp/download_dbcp.cgipool包，目前版本是2.4.2： 
http://commons.apache.org/proper/commons-pool/download_pool.cgiApache Commons Logging 包
<!-- more -->
----------

DBCP(DataBase connection pool),数据库连接池。是 apache 上的一个 java 连接池项目，也是 tomcat 使用的连接池组件。单独使用dbcp需要2个包：commons-dbcp.jar,commons-pool.jar由于建立数据库连接是一个非常耗时耗资源的行为，所以通过连接池预先同数据库建立一些连接，放在内存中，应用程序需要建立数据库连接时直接到连接池中申请一个就行，用完后再放回去。

首先，下载必须的jar包

dbcp包，目前版本是2.1.1 ：
http://commons.apache.org/proper/commons-dbcp/download_dbcp.cgi

pool包，目前版本是2.4.2：
http://commons.apache.org/proper/commons-pool/download_pool.cgi

Apache Commons Logging 包 目前版本为1.2：
http://commons.apache.org/proper/commons-logging/download_logging.cgi

MySQL的jar包mysql-connector-java-5.1.39-bin目前是5.1.39版本：
http://dev.mysql.com/downloads/connector/j/


#演示代码：

```
package cn.hncu.dbcp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

public class DbcpPoolDemo {

	// 纯Java方式设置参数，使用dbcp池
	@Test
	public void testDbcp() {
		BasicDataSource pool = new BasicDataSource();// 连接池
		pool.setUsername("root");
		pool.setPassword("1234");
		pool.setDriverClassName("com.mysql.jdbc.Driver");
		pool.setUrl("jdbc:mysql://127.0.0.1:3306/hncu?useUnicode=true&characterEncoding=utf-8");

		System.out.println(pool.getMaxIdle());// 最大空闲时间。如果一个用户获取一个连接，不用，多长时间会被强行收回
		System.out.println(pool.getMaxWaitMillis());// 在抛出异常之前,池等待连接被回收的最长时间（当没有可用连接时）。设置为-1表示无限等待。
		System.out.println(pool.getInitialSize());// 初始化时有几个Connection
		System.out.println(pool.getMaxTotal());// 最多能有多少个Connection
		
		System.out.println("----------------");
		// pool.setMaxTotal(20);//可以我们自己设置池的相关参数，如最大连接数

		// 从它的池中获取连接
		for (int i = 0; i < 20; i++) {
			Connection con = null;
			try {
				con = pool.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(i + ":" + con.hashCode());
		}
	}

	// 通过配置文件方式设置参数，使用dbcp池
	@Test
	public void testPropertyFile() throws Exception {
		Properties p = new Properties();
		p.load(DbcpPoolDemo.class.getResourceAsStream("dbcp.properties"));// 配置文件和当前类的class放在一起
		// p.load(DbcpPoolDemo.class.getClassLoader().getResourceAsStream("dbcp.properties"));//配置文件要放在src(bin)的根目录---classpath的根
		DataSource pool = BasicDataSourceFactory.createDataSource(p);
		// 从它的池中获取连接
		for (int i = 0; i < 20; i++) {
			Connection con = pool.getConnection();
			System.out.println(con.hashCode());
			if (i % 2 == 0) {
				con.close();
			}
		}
	}

}

```

一开始，默认的可以new的Connection对象为8个！
而且就算你是刚把原来的connection对象.close()也不会拿到重复Connection对象，以前的版本是会拿到原来还回去的Connectin对象的。

##Connection池-本地线程管理对象
```
package cn.hncu.dbcp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DbcpUtil {
	private static DataSource pool;
	private static ThreadLocal<Connection> t = new ThreadLocal<Connection>();
	static{
		
		try {
			//读取配置文件
			Properties p = new Properties();
			p.load(DbcpUtil.class.getResourceAsStream("dbcp.properties"));// 配置文件和当前类的class放在一起
			pool = BasicDataSourceFactory.createDataSource(p);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//返回DataSource--池
	public static DataSource getDataSource(){
		return pool;
	}
	
	public static Connection getConnection() throws SQLException{
		//从本地线程管理对象t中拿
		Connection con = t.get();
		if(con==null){
			con=pool.getConnection();
			//放入t中
			t.set(con);
		}
		return con;
	}
	
}

```

相对于自己写Connection池，用第三方的扩展包显然方便多。

转载请附上原文博客链接： 
http://blog.csdn.net/qq_26525215

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
