---
layout: post
title: "Java---ThreadLocal的用法与理解实现"
date: 2016-08-14 02:23:23 +0800
comments: true
categories:❷ Java大学之行,----- ③、Java知识点及应用
tags: [线程,ThreadLoca,api,java]
keyword: 陈浩翔, 谙忆
description: java.lang 类 ThreadLocal<T> 
我们可以称ThreadLocal为：线程本地变量官方API是这样介绍的： 
该类提供了线程局部 (thread-local) 变量。这些变量不同于它们的普通对应物，因为访问某个变量（通过其 get 或 set 方法）的每个线程都有自己的局部变量，它独立于变量的初始化副本。ThreadLocal 实例通常是类中的 private static 字 
---


java.lang 类 ThreadLocal<T> 
我们可以称ThreadLocal为：线程本地变量官方API是这样介绍的： 
该类提供了线程局部 (thread-local) 变量。这些变量不同于它们的普通对应物，因为访问某个变量（通过其 get 或 set 方法）的每个线程都有自己的局部变量，它独立于变量的初始化副本。ThreadLocal 实例通常是类中的 private static 字
<!-- more -->
----------

java.lang 类 `ThreadLocal<T>`
我们可以称ThreadLocal为：线程本地变量

官方API是这样介绍的：
该类提供了线程局部 (thread-local) 变量。这些变量不同于它们的普通对应物，因为访问某个变量（通过其 get 或 set 方法）的每个线程都有自己的局部变量，它独立于变量的初始化副本。ThreadLocal 实例通常是类中的 private static 字段，它们希望将状态与某一个线程（例如，用户 ID 或事务 ID）相关联。 


我们直接new 就可以构造一个 ThreadLocal对象。
它只有4个方法：

```
 T get() 
          返回此线程局部变量的当前线程副本中的值。 
protected  T initialValue() 
          返回此线程局部变量的当前线程的“初始值”。 
 void remove() 
          移除此线程局部变量当前线程的值。 
 void set(T value) 
          将此线程局部变量的当前线程副本中的值设置为指定值。 
```

initialValue这个方法是一个延迟调用方法（可以理解成给初始值），在线程第1次调用get()或set(Object)时才执行，并且仅执行1次。ThreadLocal中的缺省实现直接返回一个null。
如果程序员希望线程局部变量具有 null 以外的值，则必须为 ThreadLocal 创建子类，并重写此方法。通常将使用匿名内部类完成此操作。 

```
通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
　　private static ThreadLocal t= new ThreadLocal(){
	　　public Integer initialValue() {
		　　return 0;
	　　}
　　};
```


ThreadLocal是这样做到为每一个线程维护变量的：
在ThreadLocal类中有一个`Map<Thread,Object>，`用于存储每一个线程与线程变量的值，Map中元素的键为线程对象，而值对应线程的变量值。
我们自己就可以写出一个简单的实现版本：

```
package cn.hncu;

import java.util.HashMap;
import java.util.Map;

public class MyThreadLocle {
	private Map<Thread, Object> map = new HashMap<Thread, Object>();
	
	public Object get(){
		Thread curThread = Thread.currentThread();
		Object value = map.get(curThread);
		return value;
	}
	
	public void set(Object obj){
		Thread curThread = Thread.currentThread();
		map.put(curThread, obj);
	}
}

```

现在我们用一个实例来加深对ThreadLocal的理解：

```
package cn.hncu;

import java.util.Random;

import org.junit.Test;

public class ThreadLocalDemo {
	
	private static ThreadLocal<Object> t1 = new ThreadLocal<Object>();
	
	public static Object getValue(){
		Object o = t1.get();
		//不用给key，因为t1内部会自动获取当前线程的thread对象，并以上作为key到它的池中去取obj
		if(o==null){
			System.out.println("空的");
			Random r = new Random();
			o = r.nextInt(1000);
			t1.set(o);
		}
		return o;
	}
	
	@Test
	public void test(){
		Object obj = getValue();
		Object obj2 = getValue();//第二次去拿，不是空的了
		System.out.println(obj+","+obj2);
		System.out.println(obj==obj2);//true
		
		A a = new A();
		Object obj3 = a.getValue();
		System.out.println(obj==obj3);//true
		
		B b = new B();
		final Object obj4 = b.getValue();
		System.out.println(obj3==obj4);//true
		//由上面的例子可以知道，只要是同一个线程，不管是哪个类，从ThreadLocal中get的对象都是同一个
		
		System.out.println("---====不同的线程====---");
		
		new Thread() {
			@Override
			public void run() {
				A a = new A();
				Object obj5 = a.getValue();
				System.out.println("obj5:"+obj5);
				
				B b = new B();
				Object obj6 = b.getValue();
				System.out.println("obj6:"+obj6);
				System.out.println("obj5=obj6:"+(obj5==obj6));
				System.out.println("obj4=obj5:"+(obj4==obj5));
				
			}
		}.start();
	}
}

class A{
	public Object getValue(){
		Object obj = ThreadLocalDemo.getValue();
		System.out.println("A:"+obj);
		return obj;
	}
}

class B{
	public Object getValue(){
		Object obj = ThreadLocalDemo.getValue();
		System.out.println("B:"+obj);
		return obj;
	}
}
```

通过上面那个实例我们可以知道：
各个线程中访问的是不同的对象。 

通过ThreadLocal.set()将这个新创建的对象的引用保存到各线程的自己的一个map中，每个线程都有这样一个map，执行ThreadLocal.get()时，各线程从自己的map中取出放进去的对象，因此取出来的是各自自己线程中的对象，ThreadLocal实例是作为map的key来使用的。 

看下jdk1.7的部分ThreadLocal类源码：
get()与set()方法：

```
/**
     * Returns the value in the current thread's copy of this
     * thread-local variable.  If the variable has no value for the
     * current thread, it is first initialized to the value returned
     * by an invocation of the {@link #initialValue} method.
     *
     * @return the current thread's value of this thread-local
     */
public T get() {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            ThreadLocalMap.Entry e = map.getEntry(this);
            if (e != null)
                return (T)e.value;
        }
        return setInitialValue();
    }

/**
     * Sets the current thread's copy of this thread-local variable
     * to the specified value.  Most subclasses will have no need to
     * override this method, relying solely on the {@link #initialValue}
     * method to set the values of thread-locals.
     *
     * @param value the value to be stored in the current thread's copy of
     *        this thread-local.
     */
    public void set(T value) {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null)
            map.set(this, value);
        else
            createMap(t, value);
    }
```

转载请附上原文链接：
http://blog.csdn.net/qq_26525215/article/details/52204097


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
