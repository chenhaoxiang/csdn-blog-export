---
layout: post
title: "【框架】[Spring] 基于Spring框架的Web应用演示(附带cglib工具进行动态代理)"
date: 2016-09-04 03:33:24 +0800
comments: true
categories:❷ Java大学之行,----- ①、Java/Web小项目,----- ⑥、框架/第三方工具,----- ----- Spring
tags: [spring,数据库,web应用,框架,事务]
keyword: 陈浩翔, 谙忆
description: 前言：Spring也差不多学了Ioc控制反转和实现AOP技术的两种方式了，分享一个学习Spring，用来入门挺好的例子。如果你是刚刚学习Spring，那么此实例应该可以很好的帮助你应用Spring到Web项目中。里面的DAO层-提交数据库的事务我并没有使用Spring 的注解功能，而是 
---


前言：Spring也差不多学了Ioc控制反转和实现AOP技术的两种方式了，分享一个学习Spring，用来入门挺好的例子。如果你是刚刚学习Spring，那么此实例应该可以很好的帮助你应用Spring到Web项目中。里面的DAO层-提交数据库的事务我并没有使用Spring 的注解功能，而是
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

#前言：

Spring也差不多学了Ioc控制反转和实现AOP技术的两种方式了，分享一个学习Spring，用来入门挺好的例子。

如果你是刚刚学习Spring，那么此实例应该可以很好的帮助你应用Spring到Web项目中。

里面的DAO层-提交数据库的事务我并没有使用Spring 的注解功能，而是用spring的AOP来实现的。这样更灵活，其实，框架为我们做的事越多，我们就越受框架的约束。想把功能做灵活，就越难实现。

只要我们把底层学好，框架的功能我们都能自己写出来的，而且自己写出来的东西，肯定会更熟悉。
**框架是为了降低程序之间的依赖性和耦合性，使重用性达到最高。**

学习框架，**我更多的希望自己能学会框架的思想**，理解为什么！

#首先准备数据库:
```
create database mydb charset=utf8;

create table stud(
  s_id varchar(32) primary key,
  s_name varchar(40)
);

create table book(
  b_id int primary key  auto_increment,
  b_name varchar(40)
);
```
准备好这2个表：

![](http://img.blog.csdn.net/20160904101443352)

#Jar包少不了:

![](http://img.blog.csdn.net/20160904104418017)

相信学到这一步的朋友应该有了自己的一个配套包了吧，在这里我就不去一 一将包链接写出了。
如果需要这些包的，在本博客最后我会给出整个项目的链接，请到里面的WEB-INF/lib目录下去下载。


#配好web.xml:

配置web.xml-以使用Spring。
```
  <context-param>
  		<!-- param的name必须为contextConfigLocation,Spring内部会解析的 -->
		<param-name>contextConfigLocation</param-name>
		<!-- contextConfigLocation参数的值，课配置多个，用英文逗号隔开 -->
		<param-value>
		    classpath:beans.xml,
			/WEB-INF/conf/applicationContext.xml
        </param-value>
  </context-param>
  <listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
```
org.springframework.web.context.ContextLoaderListener监听器的作用就是启动Web容器时，自动装配ApplicationContext的配置信息。因为它实现了ServletContextListener这个接口，在web.xml配置这个监听器，启动容器时，就会默认执行Spring实现的方法。

小知识点:
容器对于web.xml的加载过程是context-param >> listener  >> fileter  >> servlet.

接下来就是写：
classpath:beans.xml和/WEB-INF/conf/applicationContext.xml这2个xml。
classpath:代表beans.xml的位置在src(bin)目录下。

既然需要连接数据库，我们还需要一个配置文件jdbc.properties，声明一些数据库的协议(其实可以在applicationContext.xml中直接配置的，可以不用这个文件)
#jdbc.properties:

![](http://img.blog.csdn.net/20160904105200885)

```
#如果是utf-8编码，第一行必须空一行.因为utf-8的文件开头有一个符号
#在本例中，我用这个配置文件会出现账号密码错误，无法连接数据库，原因未知
#所以，我在本例是直接配置dataSource的，未用到本文件
#数据库驱动包
driver=com.mysql.jdbc.Driver
#连接数据库的协议--三个"/"代表通过数据库默认端口连接本机的数据库，也可以写成//localhost:3306/
url=jdbc:mysql:///mydb?characterEncoding=utf-8
username=root
pwd=1234
#其实前面的4个变量名都是自己随便可以取的，因为真正的读取不是在这里
#真正的读取在applicationContext.xml中
```
在applicationContext.xml配置如下就可以拿到数据库连接了。

```
	<!-- 使用jdbc.properties配置文件,就要写下面这句 -->
<!-- 	<context:property-placeholder location="WEB-INF/conf/jdbc.properties"/> -->
	<bean id="dataSource" class="org.springframework.jdbc.datasource.SimpleDriverDataSource">
		<!-- 使用jdbc.properties配置文件,类似如下配置 -->
<!-- 		<property name="driverClass" value="${driver}"></property> -->
		<property name="driverClass" value="com.mysql.jdbc.Driver"></property> 
		<property name="url" value="jdbc:mysql:///mydb?characterEncoding=UTF-8"></property> 
		<property name="username" value="root"></property> 
		<property name="password" value="1234"></property> 
	</bean>
```

#beans.xml

写好DAO,service,servlet层的架构-方法和变量:
在beans.xml中配置好DAO,service的初始化bean,初始化属性。
而由于我们在web.xml配置了servlet，是Tomcat帮我们new-servlet的，所以，但是我们需要在servlet中需要访问service的对象,这个时候，我们就可以利用servlet的生命周期，在init方法中，给service对象赋值.

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:context="http://www.springframework.org/schema/context"
		xmlns:tx="http://www.springframework.org/schema/tx"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
				http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
				http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">
	<bean id="studDao" class="cn.hncu.stud.dao.StudDaoJdbc">
	   <!--ref="dataSource",引用applicationContext.xml中的dataSource  -->
	   <property name="dataSource" ref="dataSource"></property>
	</bean>
	<bean id="bookDao" class="cn.hncu.stud.dao.BookDaoJdbc">
	   <!--ref="dataSource",引用applicationContext.xml中的dataSource  -->
	   <property name="dataSource" ref="dataSource"></property>
	</bean>
	
	<bean id="saveService" class="cn.hncu.stud.service.StudServiceImpl">
		<property name="studDao" ref="studDao"></property>
		<property name="bookDao" ref="bookDao"></property>
	</bean>
</beans>

```
##servlet中加入此方法，实现service的初始化:

```
@Override
	public void init() throws ServletException {
		//在这里，我们可以直接获取Web中的Spring容器-不能重新去new，因为那样就不是同一个容器的了
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		service=ctx.getBean(ISaveService.class);
	}
```

#TxAdvice-AOP通知

```
package cn.hncu.utils;

import java.sql.Connection;

import javax.sql.DataSource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//另外一种方法获取Web中的spring容器--实现ApplicationContextAware接口
public class TxAdvice implements MethodInterceptor,ApplicationContextAware{
	private ApplicationContext ctx =null;
	
	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx=ctx;
	}
	
	//通知---这个里面需要拿到dataSource，所以需要先拿到Spring的容器
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		DataSource dataSource = ctx.getBean(DataSource.class);
		
		Connection con = dataSource.getConnection();
		Object res =null;
		try {
			con.setAutoCommit(false);
			//开启一个事务
			res = invocation.proceed();//放行
			con.commit();//提交
			System.out.println("提交一个事务...");
		} catch (Exception e) {
			con.rollback();
			System.out.println("事务回滚...");
		}finally{
			con.setAutoCommit(true);//关闭事务
			con.close();
		}
		return res;
	}
	
	
}

```

##事务
如果只代理到上面这里，写con.close方法其实会出问题的。
当然，本例很简单，servlet只请求了一个service中的一个方法，这样写没什么问题，
但是，假如我有多个service和一个service有多个方法，需要被一个用户请求servlet时同时调用时，这个连接就不能被关闭了。
因为Spring容器的事务机制的实质是对传统JDBC的封装，也即是Spring事务管理无论是对单数据库实例还是分布式数据库实例，要实现事务管理，那么必须保证在一个事务过程获得Connetion对象是同一个。

假如是servlet调用多个service或service中多个方法，需要实现的是同一个事务，我们可以：在service中写一个综合方法，在其中调用其它方法，然后给综合方法设置代理，因为这个综合方法在这里就是一个业务
，多个service，原理一样。

#AOP拦截getConnection()方法，cglib工具进行动态代理Connection

然后再拦截Connection的close方法！

```
package cn.hncu.utils;

import java.lang.reflect.Method;
import java.sql.Connection;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodProxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CloseAdvice implements MethodInterceptor{
	private ThreadLocal<Object> t = new ThreadLocal<Object>();

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object obj = t.get();
		if(obj==null){
			
			final Object con = invocation.proceed();//返回原型对象Connection
			
			//通过cglib工具进行动态代理
			Callback callback = new net.sf.cglib.proxy.MethodInterceptor() {
				
				@Override
				public Object intercept(Object proxiedObj, Method method,
						Object[] args, MethodProxy proxy) throws Throwable {
					if(method.getName().equals("close")){
						return null;
					}
					//con为原型Connection对象
					return method.invoke(con, args);
				}
			};
			
			//obj为cglib工具代理后的Connection对象
			obj=Enhancer.create(Connection.class, callback);
			t.set(obj);
		}
		return obj;
	}

	
	
	
	
}

```
##在applicationContext.xml中配置拦截getConnection()

```
<bean id="conClose" class="org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor">
	   <property name="expression" value="execution( * *..*.*.getConnection() )"></property>
	   <property name="advice">
			<bean id="advice" class="cn.hncu.utils.CloseAdvice"></bean>
	   </property>
	</bean>
```









接下来就是要用到AOP了，拦截事务。
拦截service层的。

#拦截事务的切面配置:

```
<!-- 自动代理 -->
	<bean class="org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator"></bean>
	<!-- 事务  切面=切点+通知 -->
	<bean id="tx" class="org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor">
		<!-- 拦截cn.hncu包下的，方法名最后为Service的任意返回值任意参数的方法 -->
		<property name="expression" value="execution (* cn.hncu..*Service.*(..) )">
		</property>
		<property name="advice">
			<bean class="cn.hncu.utils.TxAdvice"></bean>
		</property>
	</bean>
```

#DAO层的实现类代码:
##stud的实现类:

```
package cn.hncu.stud.dao;

import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import cn.hncu.stud.domain.Book;
import cn.hncu.stud.domain.Stud;

public class StudDaoJdbc implements StudDAO{
	private DataSource dataSource = null;//依赖注入
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void saveStud(Stud stud) throws SQLException {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		stud.setS_id(uuid);
		QueryRunner run = new QueryRunner(dataSource);
		run.update("insert into stud(s_id,s_name) values(?,?)", stud.getS_id(),stud.getS_name());
	}
}

```

##book的实现类

```
package cn.hncu.stud.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import cn.hncu.stud.domain.Book;

public class BookDaoJdbc implements BookDAO{
	private DataSource dataSource = null;//依赖注入

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void saveBook(Book book) throws SQLException {
		QueryRunner run = new QueryRunner(dataSource);
		run.update("insert into book(b_name) values(?)", book.getB_name());
	}

}

```

#测试:

打开页面输入：

![](http://img.blog.csdn.net/20160904150255842)

点按钮提交:

![](http://img.blog.csdn.net/20160904150329608)
service:cn.hncu.stud.service.SaveServiceImpl@4adeee3d这个输出是我在servlet中测试一个错误的时候的输出。

再看数据库的数据:

![](http://img.blog.csdn.net/20160904152205939)

![](http://img.blog.csdn.net/20160904152213490)


然后，我们来测试下，事务回滚情况：

因为service层是:

```
@Override
	public void saveStudAndBook(Stud stud, Book book) throws SQLException {
		studDao.saveStud(stud);
		bookDao.saveBook(book);
	}
```
后调用bookDao的，所以，我们让saveBook挂了，改一下saveBook的方法中sql语句为:
![](http://img.blog.csdn.net/20160904152553679)

这样，后面Book的存储肯定是出问题的。

再来测试:
![](http://img.blog.csdn.net/20160904152717227)

点添加。

![](http://img.blog.csdn.net/20160904152752242)

可以看到事务回滚了，但是看这里没用，我们去看下stud和book表有没有存储。当然book表肯定是不会被存储的，去看stud表就可以了：

![](http://img.blog.csdn.net/20160904153127234)

可以看到，李四这个用户并没有被保存，证明事务起作用了。


##完整项目源码链接:

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'><a href="https://github.com/chenhaoxiang/Java/tree/master/Spring/mySpringWebDemo"><font color="red">--&gt;点击访问本系列源码--</font></a><br>
</blockquote>



本文章由<a href="https://chenhaoxiang.github.io/">[谙忆]</a>编写， 所有权利保留。 
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
