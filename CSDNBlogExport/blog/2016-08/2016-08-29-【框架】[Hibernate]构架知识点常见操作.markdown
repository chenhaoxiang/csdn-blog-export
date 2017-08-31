---
layout: post
title: "【框架】[Hibernate]构架知识点常见操作"
date: 2016-08-29 01:23:16 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Hibernate
tags: [hibernate,数据库,框架,javabean]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
配置文件、JavaBean、HibernateSessionFactory等代码，请看上一篇: 
【框架】[Hibernate]构架知识点详解入门与测试实例 Hibernate常见操作如果利用Hibernate修改数据库时，需要使用事务处理，一个事务提交时才真正将修改过的记录更新到数据 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
配置文件、JavaBean、HibernateSessionFactory等代码，请看上一篇: 
【框架】[Hibernate]构架知识点详解入门与测试实例 Hibernate常见操作如果利用Hibernate修改数据库时，需要使用事务处理，一个事务提交时才真正将修改过的记录更新到数据
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

配置文件、JavaBean、HibernateSessionFactory等代码，请看上一篇:
<a href="http://blog.csdn.net/qq_26525215/article/details/52337326">【框架】[Hibernate]构架知识点详解入门与测试实例 </a>


#Hibernate常见操作

如果利用Hibernate修改数据库时，需要使用事务处理，一个事务提交时才真正将修改过的记录更新到数据库中。

##1、增加记录
```
@Test
	public void addStudent(){
		Session session = HibernateSessionFactory.getSession();
		/*需要增加的记录的对象*/
		Student student = new Student();
		student.setsId("S100");
		student.setsName("王五");
		student.setsAge(26);
		/*定义事务开始*/
		Transaction tran = session.beginTransaction();
		session.save(student);
		/*提交事务，真正保存到数据库中*/
		tran.commit();
	}
```
根据映射文件，Hibernate会把我们的增加对象的语句转换为对应的SQL语句。
```
Hibernate: insert into hib.students (sName, sAge, sId) values (?, ?, ?)
```

##2、 删除记录

```
@Test
	public void delStudent(){
		Session session = HibernateSessionFactory.getSession();
		/*首先查找待删除的记录--这里通过ID*/
		Student student = new Student();
		student.setsId("S100");
		
		/*定义事务开始*/
		Transaction tran = session.beginTransaction();
		session.delete(student);
		/*提交事务，真正保存到数据库中*/
		tran.commit();
	}
```
根据映射文件，Hibernate会把我们的删除对象的语句转换为对应的SQL语句。
```
delete from hib.students where sId=?
```

##3、修改/增加记录

只修改还可以用:Update

```
@Test
	public void addOrUpdata(){
		Session session = HibernateSessionFactory.getSession();
		/*首先查找待修改的记录--通过ID*/
		//Student s = session.get(Student.class, "S100");//用这种查找出来的只能修改
		Student s = new Student();
		s.setsId("S101");
		s.setsName("Babo");
		s.setsAge(15);
		/*定义事务开始*/
		Transaction tran = session.beginTransaction();
		session.saveOrUpdate(s);
		/*提交事务，真正保存到数据库中*/
		tran.commit();
	}
```

hibernate提供了saveOrUpdate的方法来进行数据库的操作。
hibernate会根据对象的状态决定是insert还是update，
其根本是通过xml文件中unsaved-value来确定的。
如果设置null，系统会根据传入的对象的id的值判断，
如果是null，则表示对象不存在，那么insert;
如果不是null，则表示已经存在，那么update.

#Hibernate主键ID生成方式

数据库中表有主键、主键的唯一性决定了数据库表中记录唯一。缓存在Session中的数据即实例都有一个唯一的ID,ID映射了数据库中主键。

##1、assigned: 
主键由外部程序负责生成，无需Hibernate参与。即当增加一个实体时，由程序设定它的ID值(手工分配值)

```
<hibernate-mapping package="cn.hncu.domain">
	<class name="Student" table="students" catalog="hib">
		<id name="sId" type="java.lang.String">
			<column name="sId" length="8"></column>
			<generator class="assigned"></generator>			
		</id>
		...
	</class>
</hibernate-mapping>
```

##2、identity: 
在DB2、SQL Server、MySQL等数据库产品中表中主键列可以设定是自动增长列，则增加一条记录时主键的值可以不赋值。用数据库提供的主键生成机制。

###(1) 表结构：
```
create table students(sId int not null  primary key auto_increment,name char(40));
```

###(2) 映射文件

```
<hibernate-mapping package="cn.hncu.domain">
	<class name="Student" table="students" catalog="hib">
		<id name="sId" type="java.lang.String">
			<column name="sId" length="8"></column>
			<generator class="identity"></generator>			
		</id>
		...
	</class>
</hibernate-mapping>
```


##3、increment:
主键按数值顺序递增。
此方式的实现机制为在当前应用实例中维持一个变量，以保存着当前的最大值，之后每次需要生成主键的时候将此值加1作为主键。
这种方式可能产生的问题是：如果当前有多个实例访问同一个数据库，那么由于各个实例各自维护主键状态，不同实例可能生成同样的主键，从而造成主键重复异常。
因此，如果同一数据库有多个实例访问，此方式必须避免使用。
```
<hibernate-mapping package="cn.hncu.domain">
	<class name="Student" table="students" catalog="hib">
		<id name="sId" type="java.lang.String">
			<column name="sId" length="8"></column>
			<generator class="increment"></generator>			
		</id>
		...
	</class>
</hibernate-mapping>
```

##4、sequence:

 采用数据库提供的sequence 机制生成主键。  
     如Oralce 中的Sequence，在Oracle中创建序列：
           create sequence hibernate_sequence;
     当需要保存实例时，Hibernate自动查询Oracle中序列"hibernate_sequence"的下一个值;该值作为主键值。可以改变默认的序列名称。
```
<id name="sId" type="java.lang.String">
	<column name="sId" length="8"></column>
	<generator class="sequence"></generator>			
</id>
```

##5、native：
由Hibernate根据底层数据库自行判断采用identity、hilo、sequence其中一种作为主键生成方式。
```
<id name="sId" type="java.lang.String">
	<column name="sId" length="8"></column>
	<generator class="native"></generator>			
</id>
```

##6、uuid.hex：

由Hibernate为ID列赋值，依据当前客户端机器的IP、JVM启动时间、当前时间、一个计数器生成串，以该串为ID值。
```
<id name="sId" type="java.lang.String">
	<column name="sId" length="8"></column>
	<generator class="uuid.hex"></generator>			
</id>
```

#Hibernate 查询方式

Hibernate配备了一种非常强大的查询语言，这种语言看上去很像SQL。但是不要被语法结构上的相似所迷惑，HQL(Hibernate query lauguage) 被设计为完全面向对象的查询。    

     HQL对关键字的大写小并不区分，但是对查询的对象就要区分大小写，因为它是面向对象的查询，所以查询的是一个对象，而不是数据库的表，在sql中如果要加条件的话就是列，而在HQL里面条件就是对象的属性，而且还要给对象起别名。

##1、Hibernate查询 HQL语句

###限制查询结果记录数与起始记录

```
@Test
	public void query1(){
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Student");
		query.setFirstResult(10); //设置查询记录开始位置，索引从0开始。
		query.setMaxResults(10);//设置查询返回的最大记录个数。
		List<Student> lists = query.list();
		for(Student s:lists){
			System.out.println(s);
		}
	}
```
###条件查询
查询名字中带有'1'的所有Student
```
@Test
	public void query2(){
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Student s where s.sName like '%1%'");
		List<Student> lists = query.list();
		for(Student s:lists){
			System.out.println(s);
		}
	}
```

## 2、取表中部分列时

###(1) 单一属性查询。
还是返回一个集合，只不过集合中存储的不是表的实例而是对象。

```
@Test
	public void query3(){
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("select sName from Student s");
		List<String> lists = query.list();
		for(String s:lists){
			System.out.println(s);
		}
	}
```

###(2) 多个属性的查询,使用对象数组。

查询多个属性，其集合元素是对象数组
数组元素的类型，跟实体类的属性的类型相关

```
@Test
	public void query4(){
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("select sName,sAge from Student s");
		List<Object[]> lists = query.list();
		for(Object[] s:lists){
			System.out.println(s[0]+","+s[1]);
		}
	}
```

### (3) 多个属性的查询,使用List集合装部分列

```
@Test
	public void query5(){
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("select new list(s.sId,s.sName,s.sAge) from Student s");
		List<List> lists = query.list();
		for(List s:lists){
			System.out.println(s.get(0)+" "+s.get(1)+" "+s.get(2));//0,1,2是索引

		}
	}
```


### (4) 使用Map集合装部分列

```
@Test
	public void query6(){
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("select new Map(s.sId,s.sName,s.sAge) from Student s");
		List<Map> lists = query.list();
		for(Map s:lists){
			System.out.println(s.get("0")+" "+s.get("1")+" "+s.get("2"));//"0","1","2"是key

		}
	}
```

##3、内连接

```
	
Query query=session.createQuery("select c.name, s.name from Student s join s.classes c ").list();
for (Iterator iter = students.iterator();iter.hasNext();) {
	Object[] obj = (Object[])iter.next();
	System.out.println(obj[0] + ", " + obj[1]);
}
```

##4、外连接

```
select c.name, s.name from Classes c left join c.students s 
select c.name, s.name from Classes c right join c.students s 
```

##5、带参数的查询
###(1)  ?作为参数 
如" from Customer cus where cus.name=?";

```
   Session session = HibernateSessionFactory.getSession();
    Query query = session.createQuery("from Customer cus where cus.name=?");
     query.setParameter(0, "zhou");
     List list = query.list();
```

###(2)  参数名称  :name   

如" from Customer cus where cus.name=:name";

```
Session session = HibernateSessionFactory.getSession();
	   Query query = session.createQuery("from Customer cus where cus.name=:name ");
	   query.setParameter("name", "zhou");
	   List list = query.list();
```


###(3)  条件查询，使用 ？的方式传递参数

```
 Query query = session.createQuery("SELECT s.id, s.name FROM Student s WHERE s.name LIKE ?");
 
Query query = session.createQuery("SELECT s.id, s.name FROM Student s WHERE s.name LIKE :myname");

query.setParameter("myname", "张三");//传递参数因为setParameter方法返回Query接口，所以可用省略方式来查询

List students = session.createQuery("SELECT s.id, s.name FROM Student s WHERE s.name LIKE :myname and s.id = :myid").
setParameter("myname", "%周%").setParameter("myid", 15).list();
```


##6、嵌入原生sql测试

```

 SQLQuery sqlQuery = session.createSQLQuery("select * from t_student");
	List students = sqlQuery.list();
	for (Iterator iter = students.iterator();iter.hasNext();) {
		Object[] obj = (Object[])iter.next();
		System.out.println(obj[0] + ", " + obj[1]);
	}

```

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
