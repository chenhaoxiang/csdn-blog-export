---
layout: post
title: "【BeanUtils】自己写的一个BeanUtils-代码方法详解"
date: 2016-08-25 03:12:18 +0800
comments: true
categories:❷ Java大学之行,----- ③、Java知识点及应用,----- ----- Java类反射
tags: [apache,对象,类反射,BeanUtils]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


BeanUtils工具包是由Apache公司所开发，主要是方便程序员对Bean类能够进行简便的操作。

在这里，不讲解如何使用apache的BeanUtils工具，而是我们自己写底层，自己利用类反射来实现BeanUtils的功能。 
需要先学习类反射！

通过给定bean对象的类 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


BeanUtils工具包是由Apache公司所开发，主要是方便程序员对Bean类能够进行简便的操作。

在这里，不讲解如何使用apache的BeanUtils工具，而是我们自己写底层，自己利用类反射来实现BeanUtils的功能。 
需要先学习类反射！

通过给定bean对象的类
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

BeanUtils工具包是由Apache公司所开发，主要是方便程序员对Bean类能够进行简便的操作。

在这里，不讲解如何使用apache的BeanUtils工具，而是我们自己写底层，自己利用类反射来实现BeanUtils的功能。
需要先学习类反射！

通过给定bean对象的类，和封装的Map对象，返回出一个bean对象。

#准备bean对象:

这里准备了User类和Book类:
##User

```
package cn.hncu.domain;

/**
 * @author 陈浩翔
 *
 * 2016-8-25
 */
public class User {
	private String uuid;
	private String name;
	private int age;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
		User other = (User) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [uuid=" + uuid + ", name=" + name + ", age=" + age + "]";
	}
	
}

```

##Book

```
package cn.hncu.domain;

/**
 * @author 陈浩翔
 *
 * 2016-8-25
 */
public class Book {
	private String uuid;
	private String name;
	private double inPrice;
	private double outPrice;
	private int num;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getInPrice() {
		return inPrice;
	}
	public void setInPrice(double inPrice) {
		this.inPrice = inPrice;
	}
	public double getOutPrice() {
		return outPrice;
	}
	public void setOutPrice(double outPrice) {
		this.outPrice = outPrice;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
		Book other = (Book) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [uuid=" + uuid + ", name=" + name + ", inPrice=" + inPrice
				+ ", outPrice=" + outPrice + ", num=" + num + "]";
	}
}

```



#过度版的：

先看过度版的:接参后需要强转成对应的bean，因为返回类型是Object。

##MyBeanUtils1

```
package cn.hncu.beanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class MyBeanUtils1 {
	
	public static Object populate(Class cls ,Map map) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Object obj = null;
		
		//1、用类反射new出对象
		obj = cls.newInstance();
		
		//2 再用类反射对新new的对象设置属性值(必须遵守Java设置规范)--即通过setter方法设置
		//2.1遍历出所有该类声明的属性
		Field flds[] = cls.getDeclaredFields();//getDeclaredFields()返回Class中所有的字段，包括私有字段；
		for(Field fld:flds){
			//获取该fld对象所代表的属性名
			String fldName = fld.getName();
			//根据属性名，到map中去读取数据，只有数据非空才需要给该属性设置值 
			Object value = map.get(fldName);
			if(value==null){//如果map中不存在对应的属性数据，我们在这里给出提示信息
				System.out.println(fldName+"的数据为空");
			}else{
				//如果map中存在对应的属性数据，则由属性名得出它的setter方法的名字
				String mothodName = "set"+fldName.substring(0, 1).toUpperCase()+fldName.substring(1);
				
				 //根据方法名和参数的数据类型(其实就是属性的类型)，获得Method对象
				Class paramTypes[] = new Class[1];
				paramTypes[0] = fld.getType();
				Method method = cls.getDeclaredMethod(mothodName, paramTypes);
				
				//调用该method对象所代表的方法
				Object args[] = new Object[1];
				args[0]=value;
				method.invoke(obj, args);
			}
		}
		return obj;
	}
	
}
```


##测试

```
@Test
	public void test1() {
		Map map = new HashMap();
		map.put("uuid", "001");
		map.put("name", "Jack");
		map.put("age", 20);
		
		Map map2 = new HashMap();
		map2.put("uuid", "001");
		map2.put("name", "红楼梦");
		map2.put("inPrice", 20.5);
		//数据可能不全
		map2.put("num", 123);
		try {
			User user =  (User) MyBeanUtils1.populate(User.class, map);
			System.out.println(user);
			Book book =  (Book) MyBeanUtils1.populate(Book.class, map2);
			System.out.println(book);
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}
```

##测试结果:

![](http://img.blog.csdn.net/20160825145259043)

这个还不是很完善，为什么呢，因为返回类型是Object，每次都要强转，比较麻烦，而且我们传了bean的class对象过去了，完全可以实现不用强转的，这个时候我们就需要用到泛型了。
而且Map的泛型我们可以确定了，肯定是`Map<String,Object>`这样的

好了，学习一下最终版的、

#最终版:

##MyBeanUtils

```
package cn.hncu.beanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class MyBeanUtils {
	
	public static<T> T populate(Class<T> cls ,Map<String, Object> map) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		T obj = null;
		
		//1、用类反射new出对象
		obj = cls.newInstance();
		
		//2 再用类反射对新new的对象设置属性值(必须遵守Java设置规范)--即通过setter方法设置
		//2.1遍历出所有该类声明的属性
		Field flds[] = cls.getDeclaredFields();//getDeclaredFields()返回Class中所有的字段，包括私有字段；
		for(Field fld:flds){
			//获取该fld对象所代表的属性名
			String fldName = fld.getName();
			//根据属性名，到map中去读取数据，只有数据非空才需要给该属性设置值 
			Object value = map.get(fldName);
			if(value==null){//如果map中不存在对应的属性数据，我们在这里给出提示信息
				System.out.println(fldName+"的数据为空");
			}else{
				//如果map中存在对应的属性数据，则由属性名得出它的setter方法的名字
				String mothodName = "set"+fldName.substring(0, 1).toUpperCase()+fldName.substring(1);
				
				 //根据方法名和参数的数据类型(其实就是属性的类型)，获得Method对象
				Class<?> paramTypes[] = new Class[1];
				paramTypes[0] = fld.getType();
				Method method = cls.getDeclaredMethod(mothodName, paramTypes);
				
				//调用该method对象所代表的方法
				Object args[] = new Object[1];
				args[0]=value;
				method.invoke(obj, args);
			}
		}
		return obj;
	}
	
}

```

##测试方法:

```
@Test
	@SuppressWarnings("unchecked")
	public void test() {
		Map<String, Object> map = new HashMap();
		map.put("uuid", "001");
		map.put("name", "Jack");
		map.put("age", 20);
		
		Map<String, Object> map2 = new HashMap();
		map2.put("uuid", "001");
		map2.put("name", "红楼梦");
		map2.put("inPrice", 20.5);
		//数据可能不全
		map2.put("num", 123);
		try {
			User user = MyBeanUtils.populate(User.class, map);
			System.out.println(user);
			Book book = MyBeanUtils.populate(Book.class, map2);
			System.out.println(book);
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}
```

##测试结果:

![](http://img.blog.csdn.net/20160825150202112)


#完整项目源码链接:


<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'><a href='https://github.com/chenhaoxiang/Java/tree/master/myBeanUtils'><font color="red">--&gt;点击访问本系列源码--</font></a><br>
</blockquote>



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
