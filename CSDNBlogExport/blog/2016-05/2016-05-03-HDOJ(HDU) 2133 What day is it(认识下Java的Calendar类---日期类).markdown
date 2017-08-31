---
layout: post
title: "HDOJ(HDU) 2133 What day is it(认识下Java的Calendar类---日期类)"
date: 2016-05-03 06:19:54 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Today is Saturday, 17th Nov,2007. Now, if i tell you a date, can you tell me what day it is ?Input 
There are multiply cases. 
One line is one case. 
There are three integers, year 
---


Problem Description 
Today is Saturday, 17th Nov,2007. Now, if i tell you a date, can you tell me what day it is ?Input 
There are multiply cases. 
One line is one case. 
There are three integers, year
<!-- more -->
----------

Problem Description
Today is Saturday, 17th Nov,2007. Now, if i tell you a date, can you tell me what day it is ?

 

Input
There are multiply cases.
One line is one case.
There are three integers, year(0< year<10000), month(0<=month<13), day(0<=day<32).

 

Output
Output one line.
if the date is illegal, you should output "illegal". Or, you should output what day it is.

 

Sample Input
2007 11 17
 

Sample Output
Saturday


这个题目的某个日期是星期几，和真正的日历是不一样的！！！
所以，用Java的日期类Calendar是过不了的。
只能自己写囖。。。题目意思是：1 1 1是星期一！
而事实上，1 1 1是星期六。不要问我为什么，我也不知道。。。


```
package cn.hncu.acm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class P2133 {
	
	
	public static void main(String[] args) throws ParseException {
		String[] week = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		int yuee[][]={{0,31,28,31,30,31,30,31,31,30,31,30,31},{0,31,29,31,30,31,30,31,31,30,31,30,31}};
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int y = sc.nextInt();
			int m = sc.nextInt();
			int d = sc.nextInt();
			 if((yunn(y)==0&&m==2&&d==29)||m>12||d>yuee[yunn(y)][m]||m==0||d==0||y==0)
	           {
	               System.out.println("illegal");
	               continue;
	           }
			 /*
			//题目是有问题的
			//1 1 1 应该是星期六，具体为什么看网上资料。
			//这个题目要求已知1 1 1是星期一
			String[] week = {"","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
			String strTime = y+"-"+m+"-"+d;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(format.parse(strTime));
			System.out.println(week[c.get(Calendar.DAY_OF_WEEK)]);
			
			*/
			 int s=0;
			 for(int i=1;i<y;i++){
				 if(yunn(i)==1){
					 s+=366;
				 }else{
					 s+=365;
				 }
			 }
			 
			 for(int i=1;i<m;i++){
				 s+=yuee[yunn(y)][i];
			 }
			 s+=d;
			 s=s%7;
			 System.out.println(week[s]);
		}
	}
	
	
	public static int yunn(int xx)
	{
	    if((xx%4==0&&xx%100!=0)||(xx%400==0))
	        return 1;//是闰年
	    return 0;//不是闰年
	}
}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
