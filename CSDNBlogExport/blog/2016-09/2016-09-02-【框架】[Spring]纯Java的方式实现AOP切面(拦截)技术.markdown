---
layout: post
title: "【框架】[Spring]纯Java的方式实现AOP切面(拦截)技术"
date: 2016-09-02 09:48:17 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring
tags: [spring,java,框架,aop]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
AOP理论知识介绍:面向切面编程英文名为：Aspect Oriented Programming。 
是可以通过预编译方式和运行期动态代理实现在不修改源代码的情况下给程序动态统一添加功能的一种技术。其实我们把它理解成动态代理就好理解了！！！下面是一些理论知识：AOP可以说是OOP（面向 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
AOP理论知识介绍:面向切面编程英文名为：Aspect Oriented Programming。 
是可以通过预编译方式和运行期动态代理实现在不修改源代码的情况下给程序动态统一添加功能的一种技术。其实我们把它理解成动态代理就好理解了！！！下面是一些理论知识：AOP可以说是OOP（面向
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

#AOP理论知识介绍:

**面向切面编程英文名为：Aspect Oriented Programming。**
是可以通过预编译方式和运行期动态代理实现在不修改源代码的情况下给程序动态统一添加功能的一种技术。

其实我们把它理解成动态代理就好理解了！！！

下面是一些理论知识：

 **AOP可以说是OOP（面向对象编程）的补充和完善。**
在OOP设计中有可能导致代码的重复不利于模块的重用性，例如日志功能。
日志代码往往水平地散布在所有对象层次中，而与它所散布到的对象的核心功能关系不大。
但是在OOP中这些业务要和核心业务代码在代码这一级集成。
还有些如安全性、事务等也是如此。
能不能把这些与核心业务无关但系统中需要使用的业务（称为切面）单独编写成一个模块，在主要核心业务代码中不调用，而是在配置文件中做些配置，配置核心业务需要使用到得切面部分，在系统编译时才织入到业务模块中。

**切面（Aspect）：**
简单的理解就是把那些与核心业务无关的代码提取出来，进行封装成一个或几个模块用来处理那些附加的功能代码。
（如日志，事务，安全验证）我们把这个模块的作用理解为一个切面。
其实切面就是我们写一个类，这个类中的代码原来是在业务模块中完成的，现在单独成一个或几个类。在业务模块需要的时候才织入。

**织入（Weaving）：**
把切面（aspect）连接到其它的应用程序类型或者对象上，并创建一个被通知（advised）的对象。 这些可以在编译时，类加载时和运行时完成。Spring和其它纯Java AOP框架一样，在运行时完成织入。 

 **切入点（Pointcut）：**
也就是切点。
本质上是一个捕获连接点的结构。在AOP中，可以定义一个pointcut，来捕获相关方法的调用


**通知（Advice）：**
在切面的某个特定的连接点（Joinpoint）上执行的动作。通知有各种类型，其中包括“around”、“before”和“after”等通知。 通知的类型将在后面部分进行讨论。许多AOP框架，包括Spring，都是以拦截器做通知模型，并维护一个以连接点为中心的拦截器链。

#我的理解:

在本篇博客，不直接讲解用Spring的xml文件配置实现AOP，而是用纯Java的方式来实现AOP切面拦截。

既然AOP技术其实是动态代理的加强，你会发现这个功能很强大的。

通过用纯Java的方式写出实现AOP之后，你会发现后面用xml配置实现AOP，其实只是换了一种方式而已，本质上是一样的。

#实例:

##准备必要的Jar包：

首先还是，准备好包：
下载链接:
http://repo.springsource.org/libs-release-local/org/springframework/spring/

![](http://img.blog.csdn.net/20160901172315366)

还需要准备一个  org/apache/commons/logging  包-Spring依赖的记录日志的包。
下载链接：
http://commons.apache.org/proper/commons-logging/download_logging.cgi


既然是用纯Java实现AOP，所以不需要用到XMl，所以也不要配置文件了。

##Person.java

```
package cn.hncu.javaImpl;

public class Person {
	public void run(){
		System.out.println("我在run...");
	}
	
	public void run(int i){
		System.out.println("我在run"+i+"...");
	}
	
	public void say(){
		System.out.println("我在say...");
	}
	
}

```

##AopJavaImplDemo

```
package cn.hncu.javaImpl;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

/**
 * 纯Java的方式实现切面(拦截)技术
 * @author 陈浩翔
 * 2016-9-1
 */
public class AopJavaImplDemo {
	
	//如果你对动态代理有过了解了，对下面的代码会很好理解的
	@Test
	public void demo1(){
		//准备好需要被代理的原型对象
		Person p = new Person();
		ProxyFactory factory = new ProxyFactory();//ProxyFactoryBean的功能比ProxyFactory强
		factory.setTarget(p);//给代理工厂一个原型对象
		
		//构造切面
		//切面=切点 + 通知
		
		//切点
		JdkRegexpMethodPointcut cut = new JdkRegexpMethodPointcut();
		//cut.setPattern("cn.hncu.javaImpl.Person.run");//可以直接给方法全名
		//或者给正则表达式
		cut.setPattern(".*run.*");//.号匹配除"\r\n"之外的任何单个字符。*号代表零次或多次匹配前面的字符或子表达式
		
		//通知
		Advice advice = new MethodInterceptor() {
			//哈哈，看到这个是不是和动态代理中的那个方法很像
			@Override
			public Object invoke(MethodInvocation methodInv) throws Throwable {
				System.out.println("前面拦拦...");
				Object resObj = methodInv.proceed();//放行
				System.out.println("后面拦拦...");
				return resObj;
			}
		};
		//切面 = 切点 + 通知
		Advisor advisor = new DefaultPointcutAdvisor(cut, advice);
		
		factory.addAdvisor(advisor);//给代理工厂一个切面
		Person p2 = (Person) factory.getProxy();//从代理工厂中获取一个代理后的对象
		
		p2.run();
		p2.say();//不会拦
		p2.run(3333);
	}
	
	
}

```

##演示结果:

![](http://img.blog.csdn.net/20160901172513083)



#Spring AOP 中 advice 的类型演示

通知的类型： 

前置通知（Before advice）：
在某连接点（join point）之前执行的通知，但这个通知不能阻止连接点前的执行（除非它抛出一个异常）。 
    
返回后通知（After returning advice）：
在某连接点（join point）正常完成后执行的通知：例如，一个方法没有抛出任何异常，正常返回。 

环绕通知（Around Advice）：
包围一个连接点（join point）的通知，如方法调用。这是最强大的一种通知类型。 环绕通知可以在方法调用前后完成自定义的行为。它也会选择是否继续执行连接点或直接返回它们自己的返回值或抛出异常来结束执行。


在这里，只演示这3中通知。


```
	@Test
	public void demo2(){
		ProxyFactoryBean factory = new ProxyFactoryBean();
		factory.setTarget(new Person());//给代理工厂一个原型对象
		
		//切面 = 切点 + 通知
		//切点
		JdkRegexpMethodPointcut cut = new JdkRegexpMethodPointcut();
		cut.setPatterns(new String[]{".*run.*",".*say.*"});//可以配置多个正则表达式
		
		//通知 前切面---不需要放行，原方法也能执行
		Advice before = new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object obj)
					throws Throwable {
				System.out.println("before...拦截");
			}
		};
		
		Advice after = new AfterReturningAdvice() {
			
			@Override
			public void afterReturning(Object returnValue, Method method,
					Object[] args, Object target) throws Throwable {
				System.out.println("afterReturning...拦截");
			}
		};
		
//		Advice throwsAdvice = new A();
//		Advice afterAdvice = new AfterAdvice() {
//		}; 
		
		
		Advice around = new MethodInterceptor() {
			
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("MethodInterceptor...前面拦截");
				Object returnValue = invocation.proceed();//放行
				System.out.println("MethodInterceptor...后面拦截");
				return returnValue;
			}
		};
		
		//切面 = 切点 + 通知
		Advisor beforeAdvisor = new DefaultPointcutAdvisor(cut, before);
		Advisor afterAdvisor = new DefaultPointcutAdvisor(cut,after);
		Advisor aroundAdvisor = new DefaultPointcutAdvisor(cut, around);
//		Advisor throwsAdviceAdvisor = new DefaultPointcutAdvisor(cut, throwsAdvice);
		
		// 给代理工厂一个切面 ---注意,添加的顺序的拦截动作执行的顺序是有关系的!!!
		factory.addAdvisors(beforeAdvisor,afterAdvisor,aroundAdvisor);
		
		Person p2 = (Person) factory.getObject();//从代理工厂中获取一个代理后的对象
		
		p2.run(2222);
	}
```

演示结果:
给代理工厂切面的顺序
使用factory.addAdvisors(beforeAdvisor,afterAdvisor,aroundAdvisor);

![](http://img.blog.csdn.net/20160902093911360)

使用factory.addAdvisors(beforeAdvisor,aroundAdvisor,afterAdvisor);

![](http://img.blog.csdn.net/20160902094103860)

使用factory.addAdvisors(aroundAdvisor,beforeAdvisor,afterAdvisor);

![](http://img.blog.csdn.net/20160902094353533)

其实写了这么多，都还没有用到Spring真正的AOP使用方法，这个只是让我们接下来学习更加简单！用配置文件new的对象，只是换种方法罢了。

记住3步：
1、需要一个代理工厂！
2、切面=切点(即我们需要拦截哪里)+通知(拦截后怎么做)
3、把切面加入代理工厂
就OK！


在下一篇博客，我会继续写AOP切面技术的。（用Spring配置xml的方法）



本文章由<a href="http://blog.csdn.net/qq_26525215">[谙忆]</a>编写， 所有权利保留。 
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
