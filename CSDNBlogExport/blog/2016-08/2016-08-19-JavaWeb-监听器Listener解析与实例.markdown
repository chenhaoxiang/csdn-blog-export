---
layout: post
title: "JavaWeb-监听器Listener解析与实例"
date: 2016-08-19 06:05:40 +0800
comments: true
categories:❷ Java大学之行,----- ③、Java知识点及应用,----- ④、Web学习之旅,----- ②、Java设计模块
tags: [java,编程,实例,监听器,Listener]
keyword: 陈浩翔, 谙忆
description: 首先来介绍一下什么是监听器:监听器－就是一个实现待定接口的普通Java程序，此程序专门用于监听另外一个类的方法调用。 
这是使用观察者模式的。什么是观察者模式： 
定义对象间一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知自动更新。  
示例： 
GUI编程中的addXxxxListener都是观察者模式。 
比如为按钮点击添加监听事件，为键盘添加监听等等…观察者模式的三个 
---


首先来介绍一下什么是监听器:监听器－就是一个实现待定接口的普通Java程序，此程序专门用于监听另外一个类的方法调用。 
这是使用观察者模式的。什么是观察者模式： 
定义对象间一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知自动更新。  
示例： 
GUI编程中的addXxxxListener都是观察者模式。 
比如为按钮点击添加监听事件，为键盘添加监听等等…观察者模式的三个
<!-- more -->
----------

首先来介绍一下什么是监听器:

监听器－就是一个实现待定接口的普通Java程序，此程序专门用于监听另外一个类的方法调用。
这是使用观察者模式的。

什么是观察者模式：
定义对象间一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知自动更新。 
示例：
GUI编程中的addXxxxListener都是观察者模式。
比如为按钮点击添加监听事件，为键盘添加监听等等...


观察者模式的三个重要类：

![](http://img.blog.csdn.net/20160819164650198)

被监听的事件源，也就是我们在使用的对象。
注册的那个监听器，是专门用来监听当前使用的对象的。
事件对象Event也就是被监听的那个对象！


我们先来看一个简单版的，自己写的监听器。

#简单版:

有事件源，和监听器，测试类.
Event等下一个完整版实现.
开发步骤：
 第一步：实现一个需要被监听的类Person.
第二步：实现一个监听接口IPersonRunListener。
第三步：在Person类中，提供一个方法(或者多个，我在这里提供了2个方法)用于注册IPersonRunListener类，即addBefore和addAfter
第四步：必须要在Person类中维护IPersonRunListener类的实例。
第五步：在调用person.run方法时，判断IPersonRunListener是否为null,如果不为null则调用它的fighting方法。
第六步：在Demo类中，实例化Person，并注册一个监听。

##Person:
```
package cn.hncu.designPattern1;

public class Person {
	private String name;
	private IPersonRunListener listener1;
	private IPersonRunListener listener2;
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public void run(){
		if(listener1!=null){
			listener1.fighting();
		}
		System.out.println(name+"正在跑...");
		if(listener2!=null){
			listener2.fighting();
		}
	}
	
	public void addBefore(IPersonRunListener listener){
		this.listener1=listener;
	}
	
	public void addAfter(IPersonRunListener listener){
		this.listener2=listener;
	}
	
}

interface IPersonRunListener{
	public void fighting();
}

```
##Demo
```
package cn.hncu.designPattern1;

public class Demo {
	
	public static void main(String[] args) {
		Person person = new Person("张三");
		IPersonRunListener listener = new IPersonRunListener() {
			@Override
			public void fighting() {
				//这里可以做很多事，不是只能输出哦
				//不过由于还没写Event对象，所以拿不到是谁调用的
				System.out.println("先做好准备工作...");
			}
		};
		person.addBefore(listener);
		
		A a = new A();
		
		person.addAfter(a);
		
		person.run();
	}
}

class A implements IPersonRunListener{
	@Override
	public void fighting() {
		//这里可以做很多事，不是只能输出哦
		//不过由于还没写Event对象，所以拿不到是谁调用的
		System.out.println("跑完了，休息休息...");
	} 
}
```

##输出:
![](http://img.blog.csdn.net/20160819173240275)

#完整版--添加事件源：

在这里相对前面的增加了一个Event-事件对象.算是完整版的了。

开发步骤：
第一步：在前页的基础上继续添加一个PersonEvent类(注意我说是类不是接口)，代表事件对像。
第二步：给PersonEvent对像，添加一个Person属性，用以标识事件源对像。
第三步：修改PersonListener接口的fighting方法，让它接收一个PersonEvent参数。
第四步：在Person类run方法中，如果判断PersonListener属性不为空，则在调用fighting方法，实例化PersonEvent并传给fighting方法。
第五步：在main方法中，通过PersonEvent的getSource方法测试是否是同一个对像。


##Person.java

```
package cn.hncu.designPattern2;

public class Person {
	private String name;
	private IPersonRunListener listener;
	
	
	public Person(String name) {
		super();
		this.name = name;
	}

	public void run(){
		System.out.println(name+"开始跑了..");
		if(listener!=null){
			listener.fighting(new PersonEvent(this));
		}
	}
	
	public void addPersonListener(IPersonRunListener listener){
		this.listener=listener;
	}
	
	public String getName(){
		return name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", listener=" + listener + "]";
	}
	
	
	
}

interface IPersonRunListener {
	public void fighting(PersonEvent pe);
}

class PersonEvent{
	Person p = null;
	public PersonEvent(Person p) {
		this.p = p;
	}
	
	public String getName(){
		return p.getName();
	}
	
	public Object getSource(){
		return p;
	}
}

//我们还可以写一个帮我们实现了接口的基本类
//里面写我们通用的模板，如果我们继承这个类，我们就可以不写了。
//有功能不一样的地方，我们就自己写，覆盖这个类的方法
class DefaultCatListener implements IPersonRunListener {

	@Override
	public void fighting(PersonEvent pe) {
		System.out.println("默认的动作...");
	}
}



```


##Demo.java

```
package cn.hncu.designPattern2;

public class Demo {
	
	public static void main(String[] args) {
		Person p1 = new Person("张三");
		Person p2 = new Person("Jack");
		IPersonRunListener listener = new IPersonRunListener() {
			@Override
			public void fighting(PersonEvent pe) {
				System.out.println(pe.getSource()+"已经跑完了...");
				if(pe.getName().equals("张三")){
					System.out.println(pe.getName()+"跑到了第一名...");
				}
			}
		};
		p1.addPersonListener(listener);
		p2.addPersonListener(listener);
		p1.run();
		p2.run();
		
		
		Person p3 = new Person("李四");
		p3.addPersonListener(new DefaultCatListener());
		p3.run();
	}
}


```

##演示结果:

![](http://img.blog.csdn.net/20160819180252793)


基本上的原理就是这些了，里面事件的输出你换成你需要的动作就可以实现你想要的功能，添加一个监听，就可以在run方法之前或者之后调用自己想要调用的方法，做自己想做的动作！

转载请附上原文博客链接：

http://blog.csdn.net/qq_26525215

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
