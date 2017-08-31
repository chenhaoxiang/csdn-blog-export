---
layout: post
title: "SQL-GROUP BY语句在MySQL中的一个错误使用被兼容的情况"
date: 2016-08-06 11:24:40 +0800
comments: true
categories:❷ Java大学之行,----- ⑤、数据库
tags: [mysql,数据库,数据]
keyword: 陈浩翔, 谙忆
description: 首先创建数据库hncu，建立stud表格。 
添加数据:create table stud(
sno varchar(30) not null primary key,
sname varchar(30) not null,
age int,
saddress varchar(30)
);
INSERT INTO stud VALUES('1001','Tom',22,'湖南益阳');
INSERT 
---


首先创建数据库hncu，建立stud表格。 
添加数据:create table stud(
sno varchar(30) not null primary key,
sname varchar(30) not null,
age int,
saddress varchar(30)
);
INSERT INTO stud VALUES('1001','Tom',22,'湖南益阳');
INSERT
<!-- more -->
----------

首先创建数据库hncu，建立stud表格。
添加数据:

```
create table stud(
sno varchar(30) not null primary key,
sname varchar(30) not null,
age int,
saddress varchar(30)
);
INSERT INTO stud VALUES('1001','Tom',22,'湖南益阳');
INSERT INTO stud VALUES('1002','Jack',23,'益阳');
INSERT INTO stud VALUES('1003','李白',22,'益阳');
INSERT INTO stud VALUES('1004','王五',24,'中国北京');
INSERT INTO stud VALUES('1005','张三',22,'益阳');
INSERT INTO stud VALUES('1006','张四',23,'益阳');
INSERT INTO stud VALUES('1007','李四',22,'湖南益阳');
INSERT INTO stud VALUES('1008','刘备',24,'北京');
```

![](http://img.blog.csdn.net/20160806231437095)


执行语句如下：

```
SELECT * FROM stud GROUP BY saddress;
```

显示了如下错误:

```
ERROR 1055 (42000): Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'hncu.stud.sno' which is not functionally dependent
 on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
```
![](http://img.blog.csdn.net/20160806231825878)


再执行此句：

```
 SELECT saddress as 平均年龄 FROM stud GROUP BY saddress;
```
-没有问题
![](http://img.blog.csdn.net/20160806231640737)


然后我们用MySQL，再执行前面那句错误的代码：
也就是：

```
SELECT * FROM stud GROUP BY saddress;
```
我们看结果：
![](http://img.blog.csdn.net/20160806231933535)

顺利的通过了，但是，你发现没有，前面的smo,sname,age,这3列的数据不对啊，没错，MySQL强行显示第一次查找到的saddress不同的行了！！！其实这个结果是不对，但是MySQL应该是兼容了这个错误！
而DOS却是严格按照SQL的语法来的。


**SQL的grop by  语法为，**
select 选取分组中的列+聚合函数 from  表名称 group by 分组的列
从语法格式来看，是先有分组，再确定检索的列，检索的列只能在参加分组的列中选。

所以问题中的，group by 后的 a,b,c是先确定的。select后的a,b,c才是可以变的。即

以下语句都是正确的：

```
select a,b,c from table_name group by a,b,c,d;
select a,b from table_name group by a,b,c;
select a,max(a) from table_name group by a,b,c;
```

以下语句则是错误的：

```
select a,b,c from table_name group by a,b;
select a,b,c from table_name group by a;
```

而因为MySQL的强大，它兼容了这个错误！！！
但是在DOS是不能的。所以出现了DOS下报错，而在MySQL中能够查找的情况(其实这个查找的结果是不对的)。

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
