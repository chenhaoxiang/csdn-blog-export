---
layout: post
title: "Java---注解、类加载器-加强-实现运行任意目录下class中加了@MyTest的空参方法"
date: 2016-05-06 05:38:42 +0800
comments: true
categories:❷ Java大学之行,----- ③、Java知识点及应用,----- ----- Java类反射
tags: [java,class,类加载器,Junit]
keyword: 陈浩翔, 谙忆
description: 做自己的类加载器 虚拟机的核心是通过类加载器来加载.class文件，然后进行相应的解析执行。那么我们可以自己做类加载器，手动加载需要的.class以进行解析执行，从而扩展虚拟机的功能。 以下内容摘自API文档：应用程序需要实现 ClassLoader 的子类，以扩展 Java 虚拟机动态加载类的方式。网络类加载器子类必须定义方法 findClass 和 loadClassData，以实现从网络加载类 
---


做自己的类加载器 虚拟机的核心是通过类加载器来加载.class文件，然后进行相应的解析执行。那么我们可以自己做类加载器，手动加载需要的.class以进行解析执行，从而扩展虚拟机的功能。 以下内容摘自API文档：应用程序需要实现 ClassLoader 的子类，以扩展 Java 虚拟机动态加载类的方式。网络类加载器子类必须定义方法 findClass 和 loadClassData，以实现从网络加载类
<!-- more -->
----------


**做自己的类加载器** 

虚拟机的核心是通过类加载器来加载.class文件，然后进行相应的解析执行。那么我们可以自己做类加载器，手动加载需要的.class以进行解析执行，从而扩展虚拟机的功能。 

以下内容摘自API文档：

应用程序需要实现 ClassLoader 的子类，以扩展 Java 虚拟机动态加载类的方式。

网络类加载器子类必须定义方法 findClass 和 loadClassData，以实现从网络加载类。下载组成该类的字节后，它应该使用方法 defineClass 来创建类实例。 

代码示例：
自己的类加载器 MyClassLoader

```
package cn.hncu;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class MyClassLoader extends ClassLoader{
	public Class<?> findClass(String name){
		//name = "e:\\cn\\hncu\\Person.class"
		Class c = null;
		FileInputStream in;
		byte[] b=null;
		
		//通过IO或网络把字节码数据读取到buf[]当中。进一步地，
		//如果我们自己熟悉字节码的生成格式，那么也可自己用程序生成。
		//本例，我们是把硬盘中的一个外部字节码文件的数据读取到buf[]当中
		//1
		try {
			in = new FileInputStream(name);
			byte[] buf = new byte[1024]; 
			ByteArrayOutputStream baos = new ByteArrayOutputStream();//字节流
			int len=0;
			while((len=in.read(buf))!=-1){
				baos.write(buf, 0, len);
			}
			in.close();
			baos.close();
			b = baos.toByteArray();
		//2 ---1-2这里可以抽取出来写一个loadClassData方法
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		c = defineClass("cn.hncu.Person", b, 0, b.length);
		return c;
	}
	
	@Test
	public void testClassData() throws ReflectiveOperationException{
		String className="cn.hncu.Person";
		//用Java的类加载器加载一个
		Class c = Class.forName(className);
		Object obj = c.newInstance();
		System.out.println(obj);
		System.out.println((Person)obj);
		
		System.out.println("-------------------");
		className = "e:\\cn\\hncu\\Person.class";
		Class c2 = findClass(className);
		Object obj2 = c2.newInstance();
		System.out.println(obj2);
		
		System.out.println((Person)obj2);//这句是有问题的
		//※不同类加载器加载的对象是无法强转---可以理解是不同的生存空间
		//Person p2 = (Person) obj2;//会挂的。
		//因为obj2的生存空间是MyClassLoader,而Person的生成空间是AppClassLoader
		//System.out.println(p2);
		
		
	}
	
	
}

```

测试结果：

![](http://img.blog.csdn.net/20160506141449451)

看，最后那句不能输出吧。
因为不是一个类加载器的。




**作自己的测试工具MyJUnit** 
（注解与反射共同使用的案例 ）

相关说明：

1）JUnit用的是@Test注解，我们用@MyTest注解。

2）JUnit已经嵌入到MyEclipse当中，我们自己的MyJUnit只要能独立运行就可以(不嵌入)，同时这样我们也不方便在MyJUnit中以参数方式接收到被测试类的类名与方法名，只能以键盘输入的方式接收。

3）JUnit能实现指定单个方法来调用执行，由于不能利用MyEclipse传参，因此我们在MyJUnit程序中遍历所有的方法并通过判断是否声明@MyTest注解来决定是否调用执行该方法。


下面实现了运行任意目录下的实现了@MyTest注解的方法：
需要输入绝对路径名和类的完整名字。

注解：@MyTest 

```
package cn.hncu.myJunit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//运行时也存在，必须要加这个
@Target (ElementType.METHOD)//限制注解只能加在方法上
public @interface MyTest {
	
}

```


测试类：TestPerson 
```
package cn.hncu.myJunit;
/**
 * 测试用的
 * @author 陈浩翔
 *
 * @version 1.0  2016-5-6
 */
public class TestPerson {
	
	public void run1(){
		System.out.println("run1...");
	}
	
	@MyTest
	public void run2(){
		System.out.println("run2...");
	}
	
	public void run3(){
		System.out.println("run3...");
	}
	
	@MyTest
	public void run4(){
		System.out.println("run4...");
	}
	
	public void run5(){
		System.out.println("run5...");
	}
	
}

```

MyClassLoader类：自己写的类加载器

```
package cn.hncu.myJunit;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 自己写的类加载器
 * @author 陈浩翔
 *
 * @version 1.0  2016-5-6
 */
public class MyClassLoader extends ClassLoader{

//我把它分成2个方法写了。
	public  Class<?> findClass(String name, String className) {
		try {
			byte b[] = loadClassData(name);
			Class c = defineClass(className, b, 0, b.length);
			return c;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static byte[] loadClassData(String name) throws IOException {
		byte buf[] = new byte[1024];
		FileInputStream in = new FileInputStream(name);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int len=0;
		while((len=in.read(buf))!=-1){
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
		byte b[] = out.toByteArray();
		return b;
	}
}

```



main方法类：

```
package cn.hncu.myJunit;

import java.lang.reflect.Method;
import java.util.Scanner;

import cn.hncu.myJunit.MyClassLoader;

/**
 * @author 陈浩翔
 * @version 1.0  2016-5-6
 */
public class MyJunit {

	public static void main(String[] args) throws ReflectiveOperationException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入需要运行的类的绝对路径(路径中不能有空格,需要类的.class文件)：");
		String name = sc.next();
		System.out.println("请输入类的名称(包含包名)：");
		String className = sc.next();
		Class c = (new MyClassLoader()).findClass(name, className);
		//获得那个类了。
		
		//那个类必须要有空参构造方法
		Object obj = c.newInstance();
		
		//获得这个类所有声明的方法，包括私有的
		Method ms[] = c.getDeclaredMethods();
		for(Method m:ms){
			if(m.isAnnotationPresent(MyTest.class)){
				m.invoke(obj, null);
			}
		}
	}
}

```

运行测试结果：

![](http://img.blog.csdn.net/20160506173646937)

现在我把class文件移动到D盘了。
![](http://img.blog.csdn.net/20160506173657082)

再看运行结果：
![](http://img.blog.csdn.net/20160506173722019)


这个可以有很多改进的地方，就比如每次输入路径都很麻烦，
我们可以做一个图形界面，让我们自己选择。
这样就方便多了。

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
