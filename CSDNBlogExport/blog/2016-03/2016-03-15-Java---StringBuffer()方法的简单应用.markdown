---
layout: post
title: "Java---StringBuffer()方法的简单应用"
date: 2016-03-15 09:14:39 +0800
comments: true
categories:❷ Java大学之行,----- ③、Java知识点及应用
tags: [java,string,stringbuffer]
keyword: 陈浩翔, 谙忆
description: 描述：在实际应用中，经常回遇到对字符串进行动态修改。这时候，String类的功能受到限制，而StringBuffer类可以完成字符串的动态添加、插入和替换等操作。１、构造函数。StringBuffer() ： 
构造一个没有任何字符的StringBuffer类。 
StringBuffer(int length) ： 
构造一个没有任何字符的StringBuffer类且其长度为length。 
St 
---


描述：在实际应用中，经常回遇到对字符串进行动态修改。这时候，String类的功能受到限制，而StringBuffer类可以完成字符串的动态添加、插入和替换等操作。１、构造函数。StringBuffer() ： 
构造一个没有任何字符的StringBuffer类。 
StringBuffer(int length) ： 
构造一个没有任何字符的StringBuffer类且其长度为length。 
St
<!-- more -->
----------

描述：在实际应用中，经常回遇到对字符串进行动态修改。这时候，String类的功能受到限制，而StringBuffer类可以完成字符串的动态添加、插入和替换等操作。

１、构造函数。StringBuffer() ：
构造一个没有任何字符的StringBuffer类。
StringBuffer(int length) ：
构造一个没有任何字符的StringBuffer类且其长度为length。
StringBuffer(String str) ：
以str为初始值构造一个StringBuffer类。


StringBuffer append(**** b);
向字符串缓冲区"追加"元素，但是，这个"元素"参数可以是布尔量、字符、字符数组、双精度数、浮点数、整型数、长整型数对象类型的字符串、字符串和StringBuffer类等。如果添加的字符超出了字符串缓冲区的长度，Java将自动进行扩充。

默认构造器是由系统自动分配容量，默认是16个字符。由于没有赋值，所以缓冲对象的长度就是0.

StringBuffer sbf=new StringBuffer(100);
设定容量大小的构造器
部分方法介绍：
charAt()方法可以返回字符中的单个字符
setCharAt(0,'x') 方法可以对字符中的单个字符进行替换
reverse() 方法可以倒置字符串内容。
int indexOf(String str) ：返回当前StringBuffer对象中，第一个满足str子串的位置。
int indexOf(String str, int fromIndex) ：从当前StringBuffer对象的fromIndex开始查找，返回第一个满足str子串的位置。

```
package cn.hncu.string;

public class StrBuffer {
	public static void main(String[] args) {
		String str = new String("Mylove");
		System.out.println(str);
		tm1(str);
		System.out.println(str);
		//String类型不是引用
		System.out.println("-----------");
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("Mylove");
		System.out.println(strBuffer.toString());
		tm2(strBuffer);
		System.out.println(strBuffer.toString());
		//引用
		
	}

	private static void tm2(StringBuffer strBuffer) {
		strBuffer.replace(0, 0, "aaa");
	}

	private static void tm1(String str) {
		str.replace('l', 'm');
	}

}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
