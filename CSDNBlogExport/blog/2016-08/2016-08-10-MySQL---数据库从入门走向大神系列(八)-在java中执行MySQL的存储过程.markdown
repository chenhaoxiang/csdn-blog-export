---
layout: post
title: "MySQL---数据库从入门走向大神系列(八)-在java中执行MySQL的存储过程"
date: 2016-08-10 02:28:45 +0800
comments: true
categories:❷ Java大学之行,----- ⑤、数据库
tags: [数据库,mysql,java,存储]
keyword: 陈浩翔, 谙忆
description: http://blog.csdn.net/qq_26525215/article/details/52143733在上面链接的博客中，写了如何用MySQL语句定义和执行存储过程Java执行存储过程：准备表stud：列类型分别为： 
varchar,varchar,int定义的存储过程分别为：p1:-无参delimiter &&
create procedure p1()
begin
    inse 
---


http://blog.csdn.net/qq_26525215/article/details/52143733在上面链接的博客中，写了如何用MySQL语句定义和执行存储过程Java执行存储过程：准备表stud：列类型分别为： 
varchar,varchar,int定义的存储过程分别为：p1:-无参delimiter &&
create procedure p1()
begin
    inse
<!-- more -->
----------



http://blog.csdn.net/qq_26525215/article/details/52143733

在上面链接的博客中，写了如何用MySQL语句定义和执行存储过程

Java执行存储过程：
================
准备表stud：

列类型分别为：
varchar,varchar,int

![](http://img.blog.csdn.net/20160809232759205)

定义的存储过程分别为：
---------------------
p1:-无参
```
delimiter &&
create procedure p1()
begin
    insert into stud values('P100','小李',43);
    select * from stud;
end&&
delimiter ;
```
p2:-输入参数

```
delimiter &&
create procedure p2(in id varchar(32),in sname varchar(32),in age int)
begin
    insert into stud values(id,sname,age);
    select * from stud;
end &&
delimiter ;
```
p3:-输入输出参数：

```
delimiter &&
create procedure p3(in id varchar(32) ,in sname varchar(32),in age int ,out num int)
begin
    insert into stud values(id,sname,age);
    select * from stud;
    select count(*) into num from stud;
end&&
delimiter ;
```

Java演示执行不带参数的存储过程：
-----------------------------------

```
@Test
	public void callProcedureDemo() throws Exception{
		Connection con = ConnFactory.getConnection();
		
		String sql = "call p1()";
		CallableStatement cst = con.prepareCall(sql);
		
		ResultSet rs = cst.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getInt(3));
		}
	}
```

演示结果：

![](http://img.blog.csdn.net/20160810012502711)


Java演示执行带输入参数的存储过程：
-----------------------------------

构造 call 转义序列时，请使用 ?（问号）字符来指定 IN 参数。此字符充当要传递给该存储过程的参数值的占位符。

可以使用 SQLServerPreparedStatement 类的 setter 方法之一为参数指定值。可使用的 setter 方法由 IN 参数的数据类型决定。

向 setter 方法传递值时，不仅需要指定要在参数中使用的实际值，还必须指定参数在存储过程中的序数位置。例如，如果存储过程包含单个 IN 参数，则其序数值为 1。如果存储过程包含两个参数，则第一个序数值为 1，第二个序数值为 2。

```
@Test//带输入参数
	public void callProcedureDemo2() throws Exception{
		Connection con = ConnFactory.getConnection();
		
		String sql="call p2(?,?,?)";
		
		CallableStatement cst = con.prepareCall(sql);
		
		cst.setString(1, "P110");
		cst.setString(2, "段誉");
		cst.setInt(3, 43);
		
		ResultSet rs = cst.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getInt(3));
		}
	}
```

演示结果：

![](http://img.blog.csdn.net/20160810020514983)

Java演示执行带输入输出参数的存储过程：
-----------------------------------------

构造 call 转义序列时，请使用 ?(问号)字符来指定 OUT 参数。
此字符充当要从该存储过程返回的参数值的占位符。
要为 OUT 参数指定值，必须在运行存储过程前使用 SQLServerCallableStatement 类的 registerOutParameter 方法指定各参数的数据类型。

使用 registerOutParameter 方法为 OUT 参数指定的值必须是 java.sql.Types 所包含的 JDBC 数据类型之一，而它又被映射成本地 SQL Server 数据类型之一。有关 JDBC 和 SQL Server 数据类型的详细信息，请参阅了解 JDBC 驱动程序数据类型。

当您对于 OUT 参数向 registerOutParameter 方法传递一个值时，不仅必须指定要用于此参数的数据类型，而且必须在存储过程中指定此参数的序号位置或此参数的名称。例如，如果存储过程包含单个 OUT 参数，则其序数值为 1;如果存储过程包含两个参数，则第一个序数值为 1，第二个序数值为 2。



```
@Test//带输入输出参数-----第4个参数 是 输出参数
	public void callProcedureDemo3() throws Exception{
		Connection con = ConnFactory.getConnection();
		
		String sql = "call p3(?,?,?,?)";
		
		CallableStatement cst =con.prepareCall(sql);
		
		cst.setString(1, "P102");
		cst.setString(2, "小凯");
		cst.setInt(3, 23);
		
		//将指定序号位置的 OUT 参数注册为给定的JDBC 类型。
		cst.registerOutParameter(4, Types.INTEGER);
		
		cst.execute();
		
		//获取输出的参数
		int count = cst.getInt(4);
		System.out.println(count);
	}
	
```

![](http://img.blog.csdn.net/20160810022202084)




本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
