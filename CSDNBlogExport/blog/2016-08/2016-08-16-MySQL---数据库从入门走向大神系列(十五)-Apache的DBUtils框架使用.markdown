---
layout: post
title: "MySQL---数据库从入门走向大神系列(十五)-Apache的DBUtils框架使用"
date: 2016-08-16 03:41:52 +0800
comments: true
categories:❷ Java大学之行,----- ⑤、数据库,----- ⑥、框架/第三方工具
tags: [数据库,apache,框架,DBUtils]
keyword: 陈浩翔, 谙忆
description: DBUtils简介：

commons-dbutils 是 Apache 组织提供的一个开源 JDBC工具类库，它是对JDBC的简单封装，学习成本极低，并且使用dbutils能极大简化jdbc编码的工作量，同时也不会影响程序的性能。因此dbutils成为很多不喜欢hibernate的公司的首选(嗯~商业竞争…..)。

commons-dbutilsAPI介绍：



org.apache.com 
---


DBUtils简介：

commons-dbutils 是 Apache 组织提供的一个开源 JDBC工具类库，它是对JDBC的简单封装，学习成本极低，并且使用dbutils能极大简化jdbc编码的工作量，同时也不会影响程序的性能。因此dbutils成为很多不喜欢hibernate的公司的首选(嗯~商业竞争…..)。

commons-dbutilsAPI介绍：



org.apache.com
<!-- more -->
----------

#DBUtils简介：

commons-dbutils 是 Apache 组织提供的一个开源 JDBC工具类库，它是对JDBC的简单封装，学习成本极低，并且使用dbutils能极大简化jdbc编码的工作量，同时也不会影响程序的性能。因此dbutils成为很多不喜欢hibernate的公司的首选(嗯~商业竞争.....)。

commons-dbutilsAPI介绍：
```
org.apache.commons.dbutils.QueryRunner
org.apache.commons.dbutils.ResultSetHandler
　　工具类
org.apache.commons.dbutils.DbUtils
```

#QueryRunner类讲解
该类简单化了SQL查询，它与ResultSetHandler组合在一起使用可以完成大部分的数据库操作，能够大大减少编码量。
QueryRunner类提供了两个构造方法：
1、默认的构造方法
2、需要一个 javax.sql.DataSource 来作参数的构造方法。


##QueryRunner类的主要方法


public Object query(Connection conn, String sql, Object[] params, ResultSetHandler rsh) throws SQLException：
执行一个查询操作，在这个查询中，对象数组中的每个元素值被用来作为查询语句的置换参数。该方法会自行处理 PreparedStatement 和 ResultSet 的创建和关闭。

public Object query(String sql, Object[] params, ResultSetHandler rsh) throws SQLException:　
几乎与第一种方法一样；唯一的不同在于它不将数据库连接提供给方法，并且它是从提供给构造方法的数据源(DataSource) 或使用的setDataSource 方法中重新获得 Connection。

　　public Object query(Connection conn, String sql, ResultSetHandler rsh) throws SQLException : 执行一个不需要置换参数的查询操作。
　　
　　public int update(Connection conn, String sql, Object[] params) throws SQLException
　　用来执行一个更新（插入、更新或删除）操作。  
　　
　　public int update(Connection conn, String sql) throws SQLException： 
　　用来执行一个不需要置换参数的更新操作。


#JAR包准备：
commons-dbutils-1.6.jar(基本包)：
http://commons.apache.org/proper/commons-dbutils/download_dbutils.cgi

commons-dbutils-ext.jar(扩展包):
https://github.com/chenhaoxiang/Java/tree/master/Database-support-package


#代码演示：

##首先准备数据库：
```
create database hncu character set utf8;

use hncu;

create table person(
	id varchar(30) primary key,
	name varchar(30),
	address varchar(30),
	age int
);

insert into  person(id,name,address,age) values('P001','张三','湖南长沙',20);
insert into  person(id,name,address,age) values('P002','李四','中国北京',25);
insert into  person(id,name,address,age) values('P003','李白','武汉',56);
insert into  person(id,name,address,age) values('P004','张三丰','武当三',78);
insert into  person(id,name,address,age) values('P005','Tom','美国纽约',34);
insert into  person(id,name,address,age) values('P006','Jack','美国旧金山',28);
```

Connection池是用的c3p0Pool类的：
http://blog.csdn.net/qq_26525215/article/details/52212260


##不使用dbUtils工具的数据库查询代码实现
```
@Test//原来不使用dbUtils工具的数据库查询代码实现
	public void jdbcQuery() throws SQLException{
		List<Person> persons = new ArrayList<Person>();
		Connection con = C3p0Pool.getConnection();
		String sql = "select * from person";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			Person p = new Person();
			p.setId(rs.getString("id"));
			p.setName(rs.getString("name"));
			p.setAddr(rs.getString("address"));
			p.setAge(Integer.parseInt(rs.getString("age")));
			persons.add(p);
		}
		for(Person p:persons){
			System.out.println(p);
		}
	}
```
结果：
![](http://img.blog.csdn.net/20160815172940842)



##使用dbUtils工具的数据库查询代码实现

###BeanListHandler返回类型为`List<>`
```
@Test
	public void dbUtilsQuery() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());
		String sql = "select * from person";
		List<Person> persons = run.query(sql,new BeanListHandler<Person>(Person.class));
		for(Person p:persons){
			System.out.println(p);
		}
	}
```

```
数据库的字段名为：address、
public String addr;
	//这里的名字如果和数据库的字段名不同。会出现读取值为null的情况
	//如果要解决，把get和set函数的set/get***写成和数据的字段名一样就可以了。setAddress()/getAddress()
	//或者在查询的时候取别名如：select id,name,address as addr ,age  from person
	//但是最好还是和数据库的字段名一样比较好
```

###MapListHandler返回类型为`List<Map<String,Object>>`

而且注意，这个与前面的依赖person类的不同，这个不依赖person类，
也就是person的成员变量名可以和数据库的字段名取不同。

```
	@Test
	public void dbUtilsQuery2() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());
		String sql = "select * from person ";
		List<Map<String, Object>> persons = run.query(sql,new MapListHandler());
		for(Map<String, Object> p:persons){
			System.out.println(p);
		}
	}
```


##DbUtils工具的使用演示: 增删改--用update()

###只演示 增，删和改类似：

```
@Test
	public void save() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());
		//statement方式
		//run.update("insert into person(id,name,address,age) values('P007','Rose','湖南长沙',22) ");
		//prepareStatement方式
		run.update("insert into person(id,name,address,age) values(?,?,?,?)", "P008","Marry","中国西安",34);
	}
```
如果使用prepareStatement方式，注意参数个数或类型 与 “?”号必须匹配，否则会出异常 。

###为 增添加事务处理：

```
@Test
	public void saveTx() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());
		Connection con = C3p0Pool.getConnection();
		try {
			con.setAutoCommit(false);
			run.update(con, "insert into person(id,name,address,age) values(?,?,?,?)","P011","Tom","浙江杭州",24);
			run.update(con, "insert into person(id,name,address,age) values(?,?,?,?)","P012","Gimo","江苏苏州",45);
			con.commit();
		} catch (Exception e) {
			if(con!=null){
				con.rollback();
				System.out.println("事务回滚了...");
			}
		}finally{
			if(con!=null){
				con.setAutoCommit(true);
				con.close();
			}
		}
	}
```
注意，实现事务功能时，要传入con对象，且多条语句共处一个事务时，要传入同一个con对象。但如果不实现事务功能，可以不传入con对象。



##查询的结果集封装
###封装成BeanList

```
@Test
	public void query2() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());
		//封装成BeanList: 如果值对象中的属性名和表中的字段名不一致，那么该属性的值返回的是null
		//解决方法是采用别名，或者修改set**/get**名
		List<Person> persons = run.query("select id,name,address addr,age from person ",new BeanListHandler<Person>(Person.class) );//用属性名 当 字段别名
		for(Person p:persons){
			System.out.println(p);
		}
	}
```

###封装成MapList

```
@Test
	public void query3() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());
		String sql = "select * from person";
		List<Map<String, Object>> persons = run.query(sql, new MapListHandler());
		for(Map<String, Object> p:persons){
			System.out.println(p);
		}
	}
```

###封装成BeanList---查询带参数

```
@Test
	public void query4() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());
		String sql = "select id,name,address,age from person where name like ? and age > ?";
		List<Person> persons = run.query(sql, new BeanListHandler<Person>(Person.class),"%o%",34);
		for(Person p:persons){
			System.out.println(p);
		}
	}
```



##演示批处理功能

```
@Test
	public void batch() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());
		for(int i=1;i<=100;i++){
			String sql = "insert into person values(?,?,?,?)";
			String str = "000"+i;
			str=str.substring(str.length()-3, str.length());
			
			String id1="A"+str;
			String id2="B"+str;
			String params[][]={{id1,"Alice"+i,"中国",i+""},{id2,"Bob"+i,"湖南",i+""}};
			run.batch(sql, params);
		}
	}
```


#演示扩展包commons-dbutilss-ext.jar的功能


##封装成BeanList---直接通过JavaBean的字节码查询所有

注意，下面的用法要生效，必须给值对象添加注解@Table(value = "person")

```
@Test 
	public void query5(){
		ExtQueryRunner run = new ExtQueryRunner(C3p0Pool.getDataSource());
		List<Person> persons = run.query(Person.class);//不用sql语句，，直接查询Bean-List
		for(Person p:persons){
			System.out.println(p);
		}
	}
```


##封装成JavaBean---直接通过JavaBean对象存储进数据库

```
	@Test
	public void save3(){
		ExtQueryRunner run = new ExtQueryRunner(C3p0Pool.getDataSource());
		Person p = new Person();
		p.setId("A000");
		p.setName("梨子");
		p.setAddress("中国");
		p.setAge(20);
		run.save(p);//不用sql语句，直接存对象
		System.out.println(p);
	}
	
```
注意：使用此功能时，需要在JavaBean对象中的每个成员变量上都加上@Column注解！！！

还有注意这里的JavaBean中的addr与数据库的字段名address是不同的，所以需要在JavaBean对象的addr属性上加上一句注解：
@Column(value="address")


#Person.java

```
package cn.hncu.dbutils;

import org.apache.commons.dbutils.ext.Column;
import org.apache.commons.dbutils.ext.Table;


/**
 * @author 陈浩翔
 *
 * 2016-8-15
 */
@Table(value = "person")
public class Person {
	@Column
	private String id;
	@Column
	private String name;
	
	@Column(value="address")
	public String addr;
	//这里的名字如果和数据库的字段名不同。会出现读取值为null的情况
	//如果要解决，把get和set函数的set/get***写成和数据的字段名一样就可以了。
	//或者在查询的时候取别名如：select id,name,address as addr ,age  from person
	//但是最好还是和数据库的字段名一样比较好
	@Column
	private Integer age;
	public Person() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return addr;
	}
	public void setAddress(String addr) {
		this.addr = addr;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", addr=" + addr
				+ ", age=" + age + "]";
	}
	
}

```




转载请附上原文博客链接： 
http://blog.csdn.net/qq_26525215

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
