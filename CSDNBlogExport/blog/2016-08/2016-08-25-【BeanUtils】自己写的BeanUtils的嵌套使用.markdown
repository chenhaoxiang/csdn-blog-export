---
layout: post
title: "【BeanUtils】自己写的BeanUtils的嵌套使用"
date: 2016-08-25 11:29:32 +0800
comments: true
categories:❷ Java大学之行,----- ----- Java类反射,----- ③、Java知识点及应用
tags: [对象,bean,class,BeanUtils]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
其实不打算写的，因为和前面的是一样的，不过既然有人问起，我就写一下吧。MyBeanUtils这是核心的类：通过这个类来返回一个bean对象的。 
你给的参数是bean的class和封装的Map对象。package cn.hncu.beanUtils;import java.lang.r 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
其实不打算写的，因为和前面的是一样的，不过既然有人问起，我就写一下吧。MyBeanUtils这是核心的类：通过这个类来返回一个bean对象的。 
你给的参数是bean的class和封装的Map对象。package cn.hncu.beanUtils;import java.lang.r
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

其实不打算写的，因为和前面的是一样的，不过既然有人问起，我就写一下吧。

#MyBeanUtils

这是核心的类：

通过这个类来返回一个bean对象的。
你给的参数是bean的class和封装的Map对象。

```
package cn.hncu.beanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author 陈浩翔
 *
 * 2016-8-25
 */
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

#Address

```
package cn.hncu.domain;

/**
 * @author 陈浩翔
 *
 * 2016-8-25
 */
public class Address {
	private String province;//省份
	private String city;//城市
	public Address() {
	}
	public Address(String province, String city) {
		this.province = province;
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [province=" + province + ", city=" + city + "]";
	}
}

```

#Person

```
package cn.hncu.domain;

import java.util.List;
import java.util.Map;

/**
 * @author 陈浩翔
 *
 * 2016-8-25
 */
public class Person {
	private String name;
	private int age;
	private Address address;
	private List lists;
	private Map map;
	public Person() {
		super();
	}
	public Person(String name, int age, Address address, List lists, Map map) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.lists = lists;
		this.map = map;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List getLists() {
		return lists;
	}
	public void setLists(List lists) {
		this.lists = lists;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address
				+ ", lists=" + lists + ", map=" + map + "]";
	}
	
}

```

#测试方法:

```
@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void test2() {
		Map<String, Object> p = new HashMap();
		p.put("name", "Jack");
		p.put("age", 100);
		p.put("address", new Address("湖南", "长沙"));
		
		List lists = new ArrayList();
		lists.add(new Book("B001", "红楼梦", 25.00, 53.23, 500));
		lists.add(new User("U001", "李四", 25));
		lists.add("嵌套使用");
		p.put("lists", lists);
		
		Map map = new HashMap();
		map.put("user", new User("MU002", "MapUser", 30));
		map.put("string", "map中的字符串");
		p.put("map", map);
		
		try {
			Person person = MyBeanUtils.populate(Person.class, p);
			
			System.out.println(person);
			
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}
```

里面的Book和User类也就是一个bean对象而已。
其实全部可以写空参构造的，我为了方便，就多写了有值的构造方法了。


#输出结果:

Person [name=Jack, age=100, address=Address [province=湖南, city=长沙], lists=[Book [uuid=B001, name=红楼梦, inPrice=25.0, outPrice=53.23, num=500], User [uuid=U001, name=李四, age=25], 嵌套使用], map={string=map中的字符串, user=User [uuid=MU002, name=MapUser, age=30]}]


其实和普通的使用没有什么不同的。
无非是外面再嵌套一层罢了~

#完整源码链接:
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'><a href='https://github.com/chenhaoxiang/Java/tree/master/myBeanUtils'><font color="red">--&gt;点击访问本系列源码--</font></a><br>
</blockquote>

<hr/>


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
