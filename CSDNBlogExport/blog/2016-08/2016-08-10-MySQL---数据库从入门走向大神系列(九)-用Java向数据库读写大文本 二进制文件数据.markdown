---
layout: post
title: "MySQL---数据库从入门走向大神系列(九)-用Java向数据库读写大文本 二进制文件数据"
date: 2016-08-10 04:05:41 +0800
comments: true
categories:❷ Java大学之行,----- ⑤、数据库
tags: [数据库,java,mysql,二进制,数据]
keyword: 陈浩翔, 谙忆
description: 介绍MySQL的文本和图形数据类型：Text 类型：数据类型:描述
------------------------------------------------------
char(size):保存固定长度的字符串（可包含字母、数字以及特殊字符）。在括号中指定字符串的长度。最多 255 个字符。varchar(size):保存可变长度的字符串（可包含字母、数字以及特殊字符）。在括号中指定字符串 
---


介绍MySQL的文本和图形数据类型：Text 类型：数据类型:描述
------------------------------------------------------
char(size):保存固定长度的字符串（可包含字母、数字以及特殊字符）。在括号中指定字符串的长度。最多 255 个字符。varchar(size):保存可变长度的字符串（可包含字母、数字以及特殊字符）。在括号中指定字符串
<!-- more -->
----------

介绍MySQL的文本和图形数据类型：
=====================

Text 类型：
-----------
```
数据类型:描述
------------------------------------------------------
char(size):保存固定长度的字符串（可包含字母、数字以及特殊字符）。在括号中指定字符串的长度。最多 255 个字符。

varchar(size):保存可变长度的字符串（可包含字母、数字以及特殊字符）。在括号中指定字符串的最大长度。最多 255 个字符。
注释：如果值的长度大于 255，则被转换为 text类型。

tinytext:存放最大长度为 255 个字符的字符串。

text:存放最大长度为 65,535 个字符的字符串。大约65KB

blob:用于 BLOBs (Binary Large OBjects)。
存放最多 65,535 字节的数据。大约65KB

mediumtext:	存放最大长度为 16,777,215 个字符的字符串。-大约16M

mediumblob:用于 BLOBs (Binary Large OBjects)。
存放最多 16,777,215 字节的数据。

longtext:存放最大长度为 4,294,967,295 个字符的字符串。大约4GB

longblob:用于 BLOBs (Binary Large OBjects)。
存放最多 4,294,967,295 字节的数据。

enum(x,y,z,etc.)
允许你输入可能值的列表。(枚举)
可以在 enum 列表中列出最大 65535 个值。如果列表中不存在插入的值，则插入空值。
注释：这些值是按照你输入的顺序存储的。
可以按照此格式输入可能的值：enum('X','Y','Z')

set 与 enum 类似，set最多只能包含 64 个列表项，不过 set 可存储一个以上的值。
```


用Java向数据写入读取大文本数据：
=====================


准备：
-------
```
 create table node(
 id int primary key,
 tx text
 );
```

查询表结构：

desc table_name;

![](http://img.blog.csdn.net/20160810115412300)


配置文件在前面这篇博客说明：
http://blog.csdn.net/qq_26525215/article/details/52153452

util工具类Connection ：
----------
```
package cn.hncu.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	
	private static Connection con = null;
	
	//静态块
	static{
		
		try {
			//读取配置文件
			Properties p = new Properties();
			p.load(ConnFactory.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			
			String drive = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("username");
			String password = p.getProperty("password");
			
			Class.forName(drive);
			
			con = DriverManager.getConnection(url, user, password);
			
			
			
		} catch (IOException e) {
			throw new RuntimeException("配置文件出现异常", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Drive.Class文件出现异常", e);
		} catch (SQLException e) {
			throw new RuntimeException("数据库访问出现异常", e);
		}
	}
	
	public static Connection getConnection(){
		return con;
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
}

```
写入文本数据：
--------------
```
//写入大文本数据
	@Test
	public void writeText() throws Exception{
		Connection con = ConnFactory.getConnection();
		String sql = "insert into node values(?,?)";
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, 1);
		
		//this.getClass().getClassLoader().getResource("").getPath()拿到的是本项目.class的根目录的绝对路径(bin/)
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("cn/hncu/demo/JdbcDemo.java");
		System.out.println( this.getClass().getClassLoader().getResource("").getPath());
		//一个小知识点，因为我们是拿到的bin目录下的文件，src目录下的.java文件会被myeclipse编译成.class文件放入对应的bin目录下。
		//我们直接在src文件下建立的.java文件是无法被myeclipse原样拷贝到bin目录下的。如果需要读入.java文件，就需要直接去把.java文件放入对应的bin目录下。
		pst.setAsciiStream(2, in);
		
		pst.executeUpdate();
		con.close();
		
	}
```
![](http://img.blog.csdn.net/20160810123959930)

![](http://img.blog.csdn.net/20160810124410852)


读取文本数据：
---------------

```
// 读取大文本数据
	@Test
	public void readText() throws Exception {
		Connection con = ConnFactory.getConnection();
		String sql = "select * from node where id=1";
		
		PreparedStatement pst = con.prepareCall(sql);
		
		ResultSet rs = pst.executeQuery();
		//因为我们只读取一个，没必要去遍历了。
		if(rs.next()){
			//读取大文本字段
			InputStream in= rs.getAsciiStream(2);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			//这里就是IO的知识了
			String line="";
			while( (line=br.readLine())!=null ){
				System.out.println(line);
				//我这里就直接输出了，你可以输出到另外的文件中的,本质上就是流嘛。
			}
		}
	}
```

![](http://img.blog.csdn.net/20160810125728797)



用Java向数据写入读取二进制(图片)数据：
====================

准备：

```
 create table img(
 id int primary key,
 img blob
 );
```
![](http://img.blog.csdn.net/20160810154342324)


写入图片：
----------

```
//写入图片
	@Test
	public void writeImg() throws SQLException{
		Connection con = ConnFactory.getConnection();
		String sql = "insert into img values(?,?)";
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, 1);
		InputStream in = LobDemoImg.class.getClassLoader().getResourceAsStream("a.jpg");
		pst.setBinaryStream(2, in);
		pst.executeUpdate();
		con.close();
	}
```

![](http://img.blog.csdn.net/20160810155157952)



读取图片并写入到文件：
-----------------------

```
//读取图片
	@Test
	public void redaImg() throws SQLException, IOException{
		Connection con = ConnFactory.getConnection();
		
		String sql = "select * from img where id=1";
		
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			
			InputStream in = rs.getAsciiStream(2);
			FileOutputStream out = new FileOutputStream(new File("e:/a/a.jpg"));
			
			byte[] buf = new byte[1024];
			int len=0;
			while( (len=in.read(buf))!=-1 ){
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		}
		con.close();
	}
```

演示结果：

![](http://img.blog.csdn.net/20160810160358691)

虽然说可以存储大数据，但一般不会这样去存储大数据的，因为效率太低了，除非是要求数据有很强的保密性，才会这样去存储！
一般式存储那个文件的绝对路径就可以了。

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
