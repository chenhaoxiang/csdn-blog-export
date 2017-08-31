---
layout: post
title: "Java---JUnita、注解与类加载器详解以及实例"
date: 2016-05-04 05:13:25 +0800
comments: true
categories:❷ Java大学之行,----- ③、Java知识点及应用,----- ----- Java类反射
tags: [实例,junit,类加载器,注解,测试]
keyword: 陈浩翔, 谙忆
description: JUnit软件测试技术(工具)在项目中建立专门用户测试的包结构。 
在Junit中，通过@Test注解，可以运行一个方法。★ Junit注解说明使用了@Test注解应该满足以下条件： 
    1) 必须是无参数的非静态方法。 
    2) 添加@Test注解的类，必须拥有一个无参数的公开构造★ JUnit测试示例演示1、运行完成后，可以在Junit的窗口上看到运行所用的时间和结果信息。 
2、被 
---


JUnit软件测试技术(工具)在项目中建立专门用户测试的包结构。 
在Junit中，通过@Test注解，可以运行一个方法。★ Junit注解说明使用了@Test注解应该满足以下条件： 
    1) 必须是无参数的非静态方法。 
    2) 添加@Test注解的类，必须拥有一个无参数的公开构造★ JUnit测试示例演示1、运行完成后，可以在Junit的窗口上看到运行所用的时间和结果信息。 
2、被
<!-- more -->
----------



JUnit软件测试技术(工具)
===============

在项目中建立专门用户测试的包结构。
在Junit中，通过@Test注解，可以运行一个方法。

★ Junit注解说明
-----------

使用了@Test注解应该满足以下条件：
    1) 必须是无参数的非静态方法。
    2) 添加@Test注解的类，必须拥有一个无参数的公开构造


★ JUnit测试示例演示
-------------


1、运行完成后，可以在Junit的窗口上看到运行所用的时间和结果信息。
2、被测试程序的运行结果出现在控制台（Console）上。 


"项目"代码：

```
package cn.hncu.user.dao.dao;
/**
 * @author 陈浩翔
 * @version 1.0  2016-5-4
 */
public interface UserDao {
	public abstract void fun1()throws Exception;
	public abstract void fun2();
	public abstract void fun3();
}

```

```
package cn.hncu.user.dao.impl;

import cn.hncu.user.dao.dao.UserDao;

/**
 * @author 陈浩翔
 * @version 1.0  2016-5-4
 */
public class UserDaoImpl implements UserDao{
	@Override
	public void fun1() throws Exception {
		System.out.println("fun1....");
	}
	@Override
	public void fun2() {
		System.out.println("fun2....");
	}
	@Override
	public void fun3() {
		System.out.println("fun3....");
	}
}

```

```
package cn.hncu.user.dao.factory;

import cn.hncu.user.dao.dao.UserDao;
import cn.hncu.user.dao.impl.UserDaoImpl;

/**
 * @author 陈浩翔
 * @version 1.0  2016-5-4
 */
public class UserDaoFactory {
	public static UserDao getUserDao(){
		return new UserDaoImpl();
	}
}

```
随便写了几个输出。。。


下面的是测试代码：

```
package cn.hncu.test;

import org.junit.Test;

import cn.hncu.user.dao.dao.UserDao;
import cn.hncu.user.dao.factory.UserDaoFactory;
import cn.hncu.user.dao.impl.UserDaoImpl;

/**
 * @author 陈浩翔
 * @version 1.0  2016-5-4
 */
//使用@Test的条件2：该类必须具有一个无参构造方法
public class TestUserDaoImpl {
	UserDao dao = UserDaoFactory.getUserDao();

	/**
	 * 测试fun1()方法
	 */
	//使用@Test的条件1：测试方法必须是非静态、无参
	@Test
	public void testFun1(){
		try {
			dao.fun1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testFun2() {
		dao.fun2();
	}

	@Test
	public void testFun3() {
		dao.fun3();
	}
	
}

```
正确的演示结果：
![](http://img.blog.csdn.net/20160504152411931)


错误的演示结果：（没有无参构造方法）

![](http://img.blog.csdn.net/20160504152441378)



★ JUnit中的其它注解
-------------

@BeforeClass、@AfterClass、@Before、@After

```
package cn.hncu.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.hncu.user.dao.dao.UserDao;
import cn.hncu.user.dao.factory.UserDaoFactory;
import cn.hncu.user.dao.impl.UserDaoImpl;

/**
 * @author 陈浩翔
 * @version 1.0  2016-5-4
 */

public class TestUserDaoImpl2 {
	UserDao dao = UserDaoFactory.getUserDao();
	
	//注意要加static
	@BeforeClass
	public static void initFirst(){
		System.out.println("finishEnd...");
	}
	
	//在每次运行@Test方法之前，都会先运行这个@Before的方法
	@Before
	public void init(){
		System.out.println("init...");
	}
	
	@Test
	public void testFun1(){
		try {
			dao.fun1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		/*运行结果
	finishEnd...
	init...
	fun1....
	finish...
	finishEnd...
	*/
	
	@Test
	public void testFun2() {
		dao.fun2();
	}
	/*运行结果
	finishEnd...
	init...
	fun2....
	finish...
	finishEnd...
	*/

	@Test
	public void testFun3() {
		dao.fun3();
	}
	/*运行结果
	finishEnd...
	init...
	fun3....
	finish...
	finishEnd...
	*/
	
	//在每次运行@Test方法之后，都会最后运行这个@After的方法
	@After
	public void finish(){
		System.out.println("finish...");
	}
	
	//注意要加static
	@AfterClass
	public static void finishEnd(){
		System.out.println("finishEnd...");
	}
	
}


```

注解 ( Annotation )
=================


★ 元数据

        所谓元数据就是数据的数据。也就是说，元数据是描述数据的。就象数据表中的字段一样，每个字段描述了这个字段下的数据的含义。
       元数据可以用于创建文档，跟踪代码中的依赖性，甚至执行基本编译时检查。许多元数据工具，如XDoclet，将这些功能添加到核心Java语言中，暂时成为Java编程功能的一部分。
        一般来说，元数据的好处分为三类：文档编制、编译器检查和代码分析。代码级文档最常被引用。元数据提供了一种有用的方法来指明方法是否取决于其他方法，它们是否完整，特定类是否必须引用其他类，等等。 


★ 什么是注解 
       Java中的注解就是Java源代码的元数据，也就是说注解是用来描述Java源代码的。  基本语法就是：@后面跟注解的名称。 

像前面演示的那几个都是注解。

★ Java中预定义注解 

①Override：标识某一个方法是否正确覆盖了它的父类的方法。
(如果用了这个注解，但是父类中没有这个方法，就会报错)
![](http://img.blog.csdn.net/20160504154855901)
![](http://img.blog.csdn.net/20160504154902699)



②Deprecated：表示已经不建议使用这个类成员了。  它是一个标记注解。
(用了这个注解的，表示在下一个升级版本中，可能不会有这个方法了，但是会有类似功能的方法代替，会在注释中提出)
![](http://img.blog.csdn.net/20160504154635836)

③SuppressWarnings：用来抑制警告信息。
(例如：压泛型的警告)
![](http://img.blog.csdn.net/20160504154701696)
(这个是可以传参进去的，可以实现不同的功能)



自定义注解1
======

自定义注解的语法很简单，跟定义接口类似，只是在名称前面加上@符号。 
★ 最简单的自定义注解 


```
public @interface MyAnno {
}
```

★ 使用这个注解
和使用其他注解是一样的

```
@MyAnno
public class UserModel{
} 
```

★ 为注解添加成员 

```
//定义
public @interface MyAnno {
  public String schoolName();
}
```

```
//使用
@MyAnno(schoolName="湖南城市学院")
public class UserModel{
} 

```
★ 设置默认值 

```
//定义
public @interface MyAnno {
  public String schoolName() default "湖南城市学院";
}
```

```
//使用1
@MyAnno
public class UserModel{
}
```

```
//使用2
@MyAnno(schoolName="城院Java高手训练营")
public class UserModel{
}
```


对注解的注解

```
package cn.hncu.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface MyAnno {
}

```


☆指定目标 Target
在了解如何使用Target 之前，需要认识另一个类，该类被称为ElementType (通过API详细学习) ，它实际上是一个枚举。这个枚举定义了注释类型可应用的不同程序元素。 
//如果都不写，就是随便在哪里都可以用

```
@Target({ ElementType.TYPE, ElementType.METHOD}) 
```

//这个注解可以在哪里用，TYPE-可以在类上面用，METHOD-可以在方法上用


☆设置保持性 Retention
 RetentionPolicy (通过API详细学习)枚举类中定义了3种注解保持性，分别决定了Java 编译器以何种方式处理注解。  

```
@Retention(RetentionPolicy.RUNTIME)
```
//运行时VM虚拟机也能识别这个注解，这个注解一直存在

```
@Retention(RetentionPolicy.SOURCE) 
```
//class文件中有这个注解，但是VM虚拟机运行时，忽略这个注解了。
（这是默认的）




☆添加公共文档 Documented
在默认的情况下在使用javadoc自动生成文档时，注解将被忽略掉。如果想在文档中也包含注解，必须使用Documented为文档注解。

☆设置继承 Inherited 
在默认的情况下，父类的注解并不会被子类继承。如果要继承，就必须加上Inherited注解。 


如何读取注解
------

要读取注解的内容，就需要使用反射的技术。  
 注意：要想使用反射得到注释信息，必须用@Retention(RetentionPolicy.RUNTIME)进行注解。 



```
	/**
	 * 分别读取类上的@MyAnno注解 和  方法上的@MyAnno注解
	 */
	@Test
	public void readAnno(){
		//※※注意：MyAnno注解定义时，必须指定它的保持性为 RUNTIME，否则下面是读取不出注解的
		
		//以下方式是读取“声明在类上的”MyAnno注解
		Class c = UserModel.class;
		//boolean boo = c.isAnnotationPresent(cn.hncu.anno.MyAnno.class);
		//boolean boo = c.isAnnotationPresent(MyAnno.class);
		boolean boo = (c.getAnnotation(MyAnno.class)!=null);
		System.out.println(boo);
		
		//以下方式是读取“声明在方法上的”MyAnno注解
		Method ms[] = c.getDeclaredMethods();
		for(Method m:ms){
			if(m.isAnnotationPresent(MyAnno.class)){
				System.out.println(m.getName()+"方法上有@MyAnno注解");
			}
		}
	}
```
结果：

```
true
getAge方法上有@MyAnno注解
getId方法上有@MyAnno注解

```


类加载器
====


Java虚拟机中可以安装多个类加载器，系统默认三个主要类加载器，每个类负责加载特定位置的类：
BootStrap,  ExtClassLoader,  AppClassLoader

```
	@Test
	public void systemLoaderDemo(){
		ClassLoader loader = Person.class.getClassLoader();
		System.out.println(loader);//AppClassLoader
		loader = loader.getParent();
		System.out.println(loader);//ExtClassLoader
		loader = loader.getParent();
		System.out.println(loader);//null
	}
```
![](http://img.blog.csdn.net/20160504163703309)

因为BootStrap是最底层，用C写的，我们不能访问到，我们没有权限，所以输出就是null了。



类加载器也是Java类，因为其他是java类的类加载器本身也要被类加载器加载，显然必须有第一个类加载器不是java类，这正是BootStrap。


Java虚拟机中的所有类装载器采用具有父子关系的树形结构进行组织，在实例化每个类装载器对象时，需要为其指定一个父级类装载器对象或者默认采用系统类装载器为其父级类加载。 


![](http://img.blog.csdn.net/20160504161744570)


☆类加载器的委托机制
----------

通过API认识ClassLoader类


当Java虚拟机要加载一个类时，到底派出哪个类加载器去加载呢？

首先当前线程的类加载器去加载线程中的第一个类。如果类A中引用了类B，Java虚拟机将使用加载类A的类装载器来加载类B。

还可以直接调用ClassLoader.loadClass()方法来指定某个类加载器去加载某个类。

每个类加载器加载类时，又先委托给其上级类加载器。当所有祖宗类加载器没有加载到类，回到发起者类加载器，还加载不了，则抛ClassNotFoundException，不是再去找发起者类加载器的儿子，因为没有getChild方法，即使有，那有多个儿子，找哪一个呢？
对着类加载器的层次结构图和委托加载原理，解释先前将ClassLoaderTest输出成jre/lib/ext目录下的aa.jar包中后，运行结果为ExtClassLoader的原因。


演示不是classpath下的类，系统类加载器是无法加载的
Person类：

```
package cn.hncu;
/**
 * 
 * @author 陈浩翔
 *
 * @version 1.0  2016-5-4
 */
public class Person {
	private String name;
	private int age;
	
	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

```

```
	@Test
	public void loaderLocalClassDemo() throws ReflectiveOperationException{
		Class c = Class.forName("cn.hncu.Person");
		System.out.println(c);
		Object obj = c.newInstance();
		System.out.println(obj);
	}
	
```
运行结果：

```
class cn.hncu.Person
Person [name=null, age=0]

```


再看：
我把Person.class移到d:\\cn\\hncu

```
//不是classpath下的类，系统类加载器是无法加载的---如果要加载，得自己写类加载器
@Test
	public void loaderRemoteClassDemo() throws ReflectiveOperationException{
		Class c = Class.forName("d:\\cn\\hncu\\Person.class");
		System.out.println(c);
		Object obj = c.newInstance();
		System.out.println(obj);
	}
	
```

结果：
![](http://img.blog.csdn.net/20160504162953904)

挂了，不能运行了。

因为没有配置classpath。


对着类加载器的层次结构图和委托加载原理，解释先前将ClassLoaderTest输出成jre/lib/ext目录下的aa.jar包中后，运行结果为ExtClassLoader

![](http://img.blog.csdn.net/20160504164103721)

必须是压.class文件，不要压缩.java文件。！！！！

```
package cn.hncu;

/**
 * 
 * @author 陈浩翔
 *
 * @version 1.0  2016-5-4
 */
public class LoaderDemo {
	public static void main(String[] args) {
		LoaderDemo a = new LoaderDemo();
		System.out.println(a);
	}

	@Override
	public String toString() {
		return "随便演示。。。chx";
	}
}

```

先按照这个命令打包这个.java

![](http://img.blog.csdn.net/20160504170511643)

![](http://img.blog.csdn.net/20160504164942130)

![](http://img.blog.csdn.net/20160504170524581)


```
package cn.hncu;

/**
 * 
 * @author 陈浩翔
 *
 * @version 1.0  2016-5-4
 */
public class LoaderDemo {
	public static void main(String[] args) {
		LoaderDemo a = new LoaderDemo();
		System.out.println(a);
	}

	@Override
	public String toString() {
		return "湖南城院。。。随便演示...chx";
	}
	//改了没用。已经不会运行这里的代码了。
}

```


大家看输出结果：

![](http://img.blog.csdn.net/20160504170714037)


![](http://img.blog.csdn.net/20160504170956994)


对着类加载器的层次结构图和委托加载原理，解释先前将ClassLoaderTest输出成jre/lib/ext目录下的aa.jar包中后，运行结果还是为ExtClassLoader。

也就是那三层从上到下，如果上面已经有那个类了，就不会运行下面的那个类：
BootStrap--->ExtClassLoader--->AppClassLoader(System classLoader)

大家再看看这个图，是不是感觉容易理解一些了：

![](http://img.blog.csdn.net/20160504171237794)


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
