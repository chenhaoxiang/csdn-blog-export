---
layout: post
title: "【8】JAVA---地址App小软件（AddrDaoFile .class）（数据层）"
date: 2016-03-31 12:30:07 +0800
comments: true
categories:❷ Java大学之行,----- ②、Java设计模块,----- ----- Java地址App
tags: []
keyword: 陈浩翔, 谙忆
description: 实现数据进行文件的存储和读写。package cn.hncu.addr.dao;import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStre 
---


实现数据进行文件的存储和读写。package cn.hncu.addr.dao;import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStre
<!-- more -->
----------

实现数据进行文件的存储和读写。
本软件也就到此结束了。
没多少可以讲的。
因为这个小软件也就8个类，主要学习的也就是一个分层思想的简单应用。
```
package cn.hncu.addr.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AddrDaoFile {
	static final String FILE_NAME = "chx.data";
	
	public static Object[] read() {
		ArrayList<Object> list = new ArrayList<Object>();
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(FILE_NAME));
			
			Object obj;
			//**对象流的读不能用available()<=0来判断读完数据，而应该用异常来确定是否读到结束
			while(true){
				obj = in.readObject();
				list.add(obj);
			}
		} catch (Exception e) {
			//读到文件末尾，就是出异常，通过这来判断是否读到结束
			//因此，本程序中，这里是正常的文件读取结束，不是我们之前认为的出异常--所以不输出异常信息
			//e.printStackTrace();
		}finally{
			try {
				if(in!=null){
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Object objs[] =list.toArray();
		if(objs==null){
			objs = new Object[0];
		}
		return objs;
	}

	public static boolean write(Object[] objs) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			for(Object obj:objs){
				out.writeObject(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		return true;
	}

}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
