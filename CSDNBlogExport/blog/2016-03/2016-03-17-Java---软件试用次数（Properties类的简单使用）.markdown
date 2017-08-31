---
layout: post
title: "Java---软件试用次数（Properties类的简单使用）"
date: 2016-03-17 10:19:45 +0800
comments: true
categories:❷ Java大学之行,----- ①、Java/Web小项目
tags: [java,class,软件,数据]
keyword: 陈浩翔, 谙忆
description: 编程练习（软件试用次数） 
实现一个如下的软件小功能： 
记录软件运行的次数并在每次运行时提示已经运行的次数。如果运行次数大于5次，软件不再运行并给出提示：试用次数已到，请注册！本代码只简单的介绍了软件的使用次数如何限定，很容易让人破解。 
如果想让人难以破解，则自己加入算法，或者分开存储关键数据， 
在运行时比对数据等等、、、package cn.hncu.property;import java 
---


编程练习（软件试用次数） 
实现一个如下的软件小功能： 
记录软件运行的次数并在每次运行时提示已经运行的次数。如果运行次数大于5次，软件不再运行并给出提示：试用次数已到，请注册！本代码只简单的介绍了软件的使用次数如何限定，很容易让人破解。 
如果想让人难以破解，则自己加入算法，或者分开存储关键数据， 
在运行时比对数据等等、、、package cn.hncu.property;import java
<!-- more -->
----------

编程练习（软件试用次数）
实现一个如下的软件小功能：
记录软件运行的次数并在每次运行时提示已经运行的次数。如果运行次数大于5次，软件不再运行并给出提示：试用次数已到，请注册！

本代码只简单的介绍了软件的使用次数如何限定，很容易让人破解。
如果想让人难以破解，则自己加入算法，或者分开存储关键数据，
在运行时比对数据等等、、、

```
package cn.hncu.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TimesTried {
	public static void main(String[] args) throws IOException {
		if(countDemo()){
			//进入软件的相应模块
			
		}else{
			
			System.out.println("试用次数已到，请进行注册！");
		}
		
	}

	private static boolean countDemo() throws IOException {
		Properties p = new Properties();
		
		int count =0;
		//配置文件
		
		File configFile = new File("config.chx");
		
		if(!configFile.exists()){
			configFile.createNewFile();
		}
		
		FileInputStream fin = new FileInputStream(configFile);
		//下面的一句为错误的演示，已注释
		//FileOutputStream fout = new FileOutputStream(configFile);
		//FileOutputStream对象一new出来就会创建一个新文件，自然就覆盖旧的文件数据了。
		//因此程序每次运行到这里都会产生新文件
		
		//把配置文件中的信息读入p对象当中
		p.load(fin);
		
		//从p对象当中读取数据---软件试用次数
		String value = p.getProperty("count");
		
		if(value!=null){
			count = Integer.parseInt(value);
			if(count>=5){
				return false;
			}
			
		}
		
		
		count++;
		System.out.println("运行"+count+"次");
		
		//把当前使用的次数存储到配置文件当中
		p.setProperty("count", ""+count);
		//也可以使用这句
		//p.setProperty("count",String.valueOf(count));
		
		FileOutputStream fout = new FileOutputStream(configFile);
		
		p.store(fout, null);
		
		fin.close();
		fout.close();
		
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
