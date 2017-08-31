---
layout: post
title: "【7】JAVA---地址App小软件（AddrBusiness.class）（逻辑层）"
date: 2016-03-31 12:26:11 +0800
comments: true
categories:❷ Java大学之行,----- ②、Java设计模块,----- ----- Java地址App
tags: []
keyword: 陈浩翔, 谙忆
description: 这个。。。没多少好解释的。。。package cn.hncu.addr.business;import javax.swing.JOptionPane;import cn.hncu.addr.dao.AddrDaoFile;
import sun.security.util.Length;public class AddrBusiness {
    //静态方法。访问的是同一个对象--也就是说就算 
---


这个。。。没多少好解释的。。。package cn.hncu.addr.business;import javax.swing.JOptionPane;import cn.hncu.addr.dao.AddrDaoFile;
import sun.security.util.Length;public class AddrBusiness {
    //静态方法。访问的是同一个对象--也就是说就算
<!-- more -->
----------

这个。。。没多少好解释的。。。
表现层的增删改查的具体实现类。
```
package cn.hncu.addr.business;

import javax.swing.JOptionPane;

import cn.hncu.addr.dao.AddrDaoFile;
import sun.security.util.Length;

public class AddrBusiness {
	//静态方法。访问的是同一个对象--也就是说就算是new这个对象，也只是引用之前的那个静态对象
	private static Object[] objs = new Object[0];
	
	private boolean save() {
		boolean result = AddrDaoFile.write(objs);
		if(!result){
			JOptionPane.showMessageDialog(null, "数据存储失败!");
			return false;
		}
		
		return true;
	}

	
	//判断集合是不是已经有了那个元素
	public boolean contains(Object obj){
		for(Object temp:objs){
			if(temp.equals(obj)){
				return true;
			}
		}
		return false;
	}
	
	//添加元素，不能添加重复的元素
	public boolean add(Object obj){
		if(contains(obj)){
			return false;
		}
		Object[] temp = new Object[objs.length+1];
		System.arraycopy(objs, 0, temp, 0, objs.length);
		temp[objs.length]=obj;
		objs = temp;
		boolean result = save();
		return result;
	}
	
	
	//返回集合的所有元素
	public Object[] getAll(){
		objs = AddrDaoFile.read();
		return objs;
	}
	
	//返回集合的元素长度
	public int size(){
		return objs.length;
	}

	public boolean update(String oldStrAdd, String newStrAdd) {
		for(int i=0;i<objs.length;i++){
			if(((String)objs[i]).equals(oldStrAdd)){
				objs[i] = (Object)newStrAdd;
				boolean result = save();
				return result;
			}
		}
		return false;
	}

	public boolean delete(String oldStrAdd) {
		Object[] tempObj = new Object[objs.length-1];
		int k=0;
		for(int i=0;i<objs.length;i++){
			if(!(((String)objs[i]).equals(oldStrAdd))){
				tempObj[k++]=objs[i];
			}
		}
		objs = tempObj;
		boolean result = save();
		return result;
	}

	public Object[] query(String[] strsQu) {
		Object[] tempObjs = new Object[objs.length];
		int k=0;
		for(int i=0;i<objs.length;i++){
			String strObj = (String)objs[i];
			String strs[] = strObj.split(",");
			
			//卫条件
			if(strsQu[0]!=null&&strsQu[0].trim().length()>0){
				if(!strs[0].contains(strsQu[0])){//模糊匹配姓名
					continue;
				}
			}
			
			if(strsQu[1]!=null&&strsQu[1].trim().length()>0){
				if(!strs[1].contains(strsQu[1])){//模糊匹配性别
					continue;
				}
			}
			
			//年龄大于第一段的
			if(strsQu[2]!=null){
				if(strsQu[2].trim().length()>0){
					if(Integer.parseInt(strs[2])<Integer.parseInt(strsQu[2])){
						continue;
					}
				}
			}
			
			//年龄小于第二段的
			if(strsQu[5]!=null){
				if(strsQu[5].trim().length()>0){
					if(Integer.parseInt(strs[2])>Integer.parseInt(strsQu[5])){
						continue;
					}
				}
			}
			
			//电话
			if(strsQu[3]!=null&&strsQu[3].trim().length()>0){
				if(!strs[3].contains(strsQu[3])){//模糊匹配
					continue;
				}
			}
			
			//地址
			if(strsQu[4]!=null&&strsQu[4].trim().length()>0){
				if(!strs[4].contains(strsQu[4])){//模糊匹配
					continue;
				}
			}
			tempObjs[k++]=objs[i];
		}
		
		Object[] tempObjs2 = new Object[k];
		for(int i=0;i<k;i++){
			tempObjs2[i]=tempObjs[i];
		}
		return tempObjs2;
	}
	
}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
