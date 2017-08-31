---
layout: post
title: "【框架】[Hibernate]多表操作与缓存技术"
date: 2016-08-29 02:24:56 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Hibernate
tags: [hibernate,数据库,框架,缓存]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
多表操作   关系型数据库具有三种常用关系：一对一关系、一对多关系和多对多关系。 
   建立了一对多关系的表之间，一方中的表叫“主表”，多方中的表叫“子表”；两表中相关联的字段，在主表中叫“主键”，在子表中称“外键”。
一对多关系操作我们以院系表与学生表为例。 
在Hibernate 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
多表操作   关系型数据库具有三种常用关系：一对一关系、一对多关系和多对多关系。 
   建立了一对多关系的表之间，一方中的表叫“主表”，多方中的表叫“子表”；两表中相关联的字段，在主表中叫“主键”，在子表中称“外键”。
一对多关系操作我们以院系表与学生表为例。 
在Hibernate
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

#多表操作
       关系型数据库具有三种常用关系：一对一关系、一对多关系和多对多关系。 
       建立了一对多关系的表之间，一方中的表叫“主表”，多方中的表叫“子表”；两表中相关联的字段，在主表中叫“主键”，在子表中称“外键”。


##一对多关系操作

我们以院系表与学生表为例。
在Hibernate映射中，在院系表中添加一个集合属性，集合属性存放该院系下的学生。
学生表中将院系编号字段映射成一个院系类对象。
这样通过院系类对象的属性集合找到该院系下的所有学生。
通过学生对象的院系属性也很快定位到院系的其它信息不仅仅是院系编号。

在POJO类中:
我们需要在学生对象中建立院系对象。
在院系对象中建立学生对象的集合。

学生表的映射文件:
```
<hibernate-mapping>
    <class name="bean.Student" table="student" catalog="support">
        <id name="sno" type="java.lang.String">
            <column name="sno" length="4" />
            <generator class="assigned"></generator>
        </id>
<!--name设定待映射的持久化类的属性名-->
<!--column设定和持久化类的属性对应的表的外键--> 
<!--class设定持久化类的属性的类型-->
        <many-to-one name="dept" class="bean.Dept" fetch="select">
<!-- fetch ,可以设置fetch = "select" 和 fetch = "join"
用一对多来举例：
fetch = "select"是在查询的时候先查询出一端的实体，然后在根据一端的查询出多端的实体，会产生1+n条sql语句;
fetch = "join"是在查询的时候使用外连接进行查询，不会差生1+n的现象。 -->
            <column name="deptid" length="4" />
        </many-to-one>
        <property name="sname" type="java.lang.String">
            <column name="sname" length="20" />
        </property>
    </class>
</hibernate-mapping>

```

院系的表映射文件:

```
Dept.hbm.xml
<hibernate-mapping>
    <class name="bean.Dept" table="dept" catalog="support">
        <id name="deptid" type="java.lang.String">
            <column name="deptid" length="4" />
            <generator class="assigned"></generator>
        </id>
        <property name="deptname" type="java.lang.String">
            <column name="deptname" length="30" />
        </property>
<!-- name设定待映射的持久化类的属性名-->
        <set name="students" inverse="true">
<!--所关联的持久类对应的表的外键-->
            <key>
                <column name="deptid" length="4" />
            </key>
<!--设定持久化所关联的类-->
            <one-to-many class="bean.Student" />
        </set>
    </class>
</hibernate-mapping>

```
##测试一对多关系操作

```
Session s=HibernateSessionFactory.getSession();
       Query q=s.createQuery("from Dept");
       List l=q.list();
       for(int i=0;i<l.size();i++){
    	     Dept dept=(Dept)l.get(i);
    	     System.out.println(dept.getDeptid());
    	     Set stu= dept.getStudents();//通过院系实例可以查询该院学生
    	     Iterator it=stu.iterator();
    	     while(it.hasNext()){
    	    	  Student st=(Student)it.next();
    	    	  System.out.print(st.getSno()+"  ");
    	     }
       }

```


通过上面的，我们无论查询哪一方，我们总是可以知道另一方。
例如:
查询学生，我们可以通过学生对象拿到他的院系。

#级联操作与延迟加载

##1、cascade级联操作

 所谓cascade，如果有两个表，在更新一方的时候，可以根据对象之间的关联关系，对被关联方进行相应的更新。比如说院系表和学生表之间是一对多关系，使用cascade, 如删除院系表中的一条院系记录时，该院系下的所有学生记录也自动删除。这种现象称为级联删除。当创建一个新的院系实例，该院系实例集合属性中保存有学生。当该院系实例持久化时，自动将集合学生也自动添加到数据库的学生表中去。这称为级联增加。

```
all : 所有情况下均进行关联操作。
none：所有情况下均不进行关联操作。这是默认值。
save-update:执行save/update/saveOrUpdate时进行关联操作
delete：在执行delete时进行关联操作。

```

###级联示例
 删除院系表dept同时将该院系下所有学生student删除。可以在院系类映射文件中如下定义。

```
<!--表示级联删除-->
<set name="students" inverse="false" cascade="delete">
       <key>
           <column name="deptid" length="4" />
       </key>
        <one-to-many class="bean.Student" />
</set>
还可以定义级联增加、修改等
<set name="students" inverse="false" cascade= 
                                   "none|all|delete| save-update">
        <key>
             <column name="deptid" length="4" />
         </key>
         <one-to-many class="bean.Student" />
</set>
```


##2、inverse属性
这个属性不好理解，打个比方来说这个属性。
       一个学校有个校长，学校里有很多学生。学生表中假设有一个字段是校长编号（多方）,如果我们增加一个学生，学生记录中校长编号字段如何填呢？显然学生自己填（即由学生方维护）要容易些，学生记住校长现实点。如果你要让校长填写学生的校长编号这个字段（即由校长方维护）则比较难，因为校长如何记住那么多学生呢？

inverse属性示例. (没有采用inverse)
 Team.hbm.xml代码如下(省略部分)：
```
   <class name="bean.Team" table="TEAM" >
        <set name="students" cascade="all">
         <key>
          <column name="TEAM_ID" length="20" />
         </key>
         <one-to-many class="bean.Student" />
        </set>
   </class>
```
Student.hbm.xml代码如下(省略部分)：
```
    <class name=" bean.Student" table="STUDENT" >
            <many-to-one name="team" class="bean.Team" fetch="select">
            <column name="TEAM_ID" length="20" />
          </many-to-one>
       </class>
```
 从上面的代码中没有出现一个inverse关键字，证明维护关系由班级表和学生表一起来维护。比如：现在有新的学生要进入某一个班级（班级号t001），可以编写如下的代码来完成该功能。

```
Session session = HibernateSessionFactory.getSession();
  Transaction tran = session.beginTransaction();
  Query query = session.createQuery("from Student");
  List list = query.list();
  Team team = (Team) session.get(Team.class, "t001");
  for (int i = 0; i < list.size(); i++) {
      Student stu = (Student) list.get(i);
      if (stu.getTeam() == null) {
         team.getStudents().add(stu);
       }
  }
  tran.commit();

```
这段代码通过班级来添加学生信息的，也就是说添加学生信息可以由班级来维护。


现在只给出Team.hbm.xml配置文件，其中添加了inverse关键，学生映射文件未变。     (采用inverse)

```
<class name="bean.Team" table="TEAM" >
        <set name="students" inverse="true" cascade="all">
         <key>
          <column name="TEAM_ID" length="20" />
         </key>
         <one-to-many class="bean.Student" />
        </set>
    </class>

```
按照上面的配置信息，如果还是想完成新的学生要进入某一个班级（如班级号为t001的班级）这个功能，代码编写如下：

```
Session session = HibernateSessionFactory.getSession();
  Transaction tran = session.beginTransaction();
  Query query = session.createQuery("from Student");
  List list = query.list();
  Team team = (Team) session.get(Team.class, "t001");
  for (int i = 0; i < list.size(); i++) {
     Student stu = (Student) list.get(i);
     if(stu.getTeam() == null) {
         stu.setTeam(team);//学生自己维护班级
     }
  }
  tran.commit();

```
  这段代码通过学生来添加班级信息的，也就是说添加学生信息可以由学生自己来维护。


##3、延迟加载
(1) 属性的延迟加载
       如Person表有一个人员图片字段（对应java.sql.Clob类型）属于大数据对象，当我们加载该对象时，我们不得不每一次都要加载这个字段，而不论我们是否真的需要它，而且这种大数据对象的读取本身会带来很大的性能开销。我们可以如下配置我们的实体类的映射文件：
```
 <hibernate-mapping>
　<class name="bean.Person" table="person">
　　　　　　……
　　<property name="pimage" type="java.sql.Clob" 
                         column="pimage" lazy="true"/>
　</class>
 </hibernate-mapping>

```


##多对多关系操作

以学生与教师为例，一个教师可以教对个学生，一个学生也可以接受多个老师的教育。所以他们之间是多对多的关系。我们一般建立3个表：学生表、教师表以及学生教师表。

###学生类映射文件

```
 <class name="Student">          
         ......
        <!-- name="teachers" 表示:Student类中有一个属性叫teachers (是Set集合)-->  
        <!-- table="teacher_student" 表示:中间关联表。表名叫teacher_student -->           
        <set name="teachers" table="teacher_student">  
      <!-- column="student_id" 表示:中间表teacher_student的字段-->  
      <!-- Student类的id与中间表teacher_student的字段student_id对应-->  
            <key column="student_id"/>              
            <!-- column="teacher_id" 表示:中间表teacher_student的字段-->  
            <!-- class="Teacher" 表示:中间表teacher_student的字段teacher_id与 Teacher类的id对应-->  
          <many-to-many class="Teacher”
                                           column="teacher_id"/>  
       </set>  
   </class>

```


###教师类映射文件

```
  <class name="Teacher">          
        ......
       <set name="students" table="teacher_student">  
            <key column="teacher_id"/>              
            <many-to-many class="Student" 
                                                 column="student_id"/>  
        </set>  
    </class> 

```
(也可以分解成两个一对多关系)
把多对多关联分解为两个一对多关联，具有更好的可扩展性和操作性。


#Hibernate缓存技术
  缓存是介于物理数据源与应用程序之间，缓存被广泛用于数据库应用领域。缓存的设计就是为了通过存储已经从数据库读取的数据来减少应用程序和数据库之间的数据流量，而数据库的访问只在检索的数据不在当前缓存的时候才需要。


##1、Hibernate缓存范围以及分类   (缓存的范围分为三类) 

###(1) 事务范围：
缓存只能被当前事务访问。缓存的生命周期依赖于事务的生命周期，当事务结束时，缓存也就结束生命周期。在此范围下，缓存的介质是内存。事务可以是数据库事务或者应用事务，每个事务都有独自的缓存。 

###(2) 应用范围：
缓存被应用范围内的所有事务共享的。这些事务有可能是并发访问缓存，因此必须对缓存采取必要的事务隔离机制。缓存的生命周期依赖于应用的生命周期，应用结束时，缓存也就结束了生命周期，二级缓存存在于应用范围。 

###(3) 集群范围：
在集群环境中，缓存被一个机器或者多个机器的进程共享。缓存中的数据被复制到集群环境中的每个进程节点，进程间通过远程通信来保证缓存中的数据的一致性，缓存中的数据通常采用对象的松散数据形式，二级缓存也存在与应用范围。


##Hibernate 中提供了两级Cache。

第1级别的缓存是Session级别的缓存，即上述事务范围以及应用范围的缓存。这一级别的缓存由Hibernate管理的，一般无需进行干预；缓存的物理介质为内存，由于内存容量有限，必须通过恰当的检索策略和检索方式来限制加载对象的数目。
 
第2级别的缓存是SessionFactory级别的缓存，属于进程范围或群集范围的缓存。这一级别的缓存可以进行配置和更改，并且可以动态加载和卸载。 第2级缓存的物理介质可以是内存和硬盘，因此第2级缓存可以存放大量的数据，数据过期策略的maxElementsInMemory属性值可以控制内存中的对象数目。

Hibernate本身并不提供2级缓存的产品化实现，而是为众多支持Hibernate的第三方缓存组件提供整合接口。

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
