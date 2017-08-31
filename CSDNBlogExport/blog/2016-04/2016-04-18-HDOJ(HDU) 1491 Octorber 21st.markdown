---
layout: post
title: "HDOJ(HDU) 1491 Octorber 21st"
date: 2016-04-18 12:47:12 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
HDU’s 50th birthday, on Octorber 21st, is coming. What an exciting day!! As a student of HDU, I always want to know how many days are there between today and Octorber 21st.So, writ 
---


Problem Description 
HDU’s 50th birthday, on Octorber 21st, is coming. What an exciting day!! As a student of HDU, I always want to know how many days are there between today and Octorber 21st.So, writ
<!-- more -->
----------

Problem Description
HDU's 50th birthday, on Octorber 21st, is coming. What an exciting day!! As a student of HDU, I always want to know how many days are there between today and Octorber 21st.So, write a problem and tell me the answer.Of course, the date I give you is always in 2006.

![](http://img.blog.csdn.net/20160418004158380)



Input
The input consists of T test cases. The number of T is given on the first line of the input file.Following T lines, which represent dates, one date per line. The format for a date is "month day" where month is a number between 1 (which indicates January) and 12 (which indicates December), day is a number between 1 and 31.All the date in the input are in 2006, you can assume that all the dates in the input are legal(合法).
 

Output
For each case, if the date is before Octorber 21st, you should print a number that between the date and Octorber 21st.If the day is beyond Octorber 21st, just print "What a pity, it has passed!".If the date is just Octorber 21st, print"It's today!!".

 

Sample Input
7
10 20
10 19
10  1
10 21
9   1
11 11
12 12
 

Sample Output
1
2
20
It's today!!
50
What a pity, it has passed!
What a pity, it has passed!



水题一个，弄清楚题意就知道了。
题目的意思是，今天是2006年10月21日。
(不是闰年，所以2月是28天)
输入的月 日  都是2006年的，也都是合法的。
如果输入的日期在10月21日之前，就输出那天到10月21日隔多少天。
如果输入10 21，就输出"It's today!!"
如果输入的日期在10月21日之后，就输出"What a pity, it has passed!"


```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		int time[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t-->0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			//用卫条件来防范
			//判断输入的是不是今天
			if(a==10&&b==21){
				System.out.println("It's today!!");
				continue;
			}
			
			//判断是不是输入10月21日之后的日期
			if(a>10||(a==10&&b>21)){
				System.out.println("What a pity, it has passed!");
				continue;
			}
			
			
			//判断是不是输入10月之后且10月21日之间的日期
			if(a==10){
				System.out.println(21-b);
				continue;
			}
			
			//剩下的就是10月之前的日期了。
			int tm=time[a]-b;
			for(int i=a+1;i<10;i++){
				tm+=time[i];
			}
			tm=tm+21;
			System.out.println(tm);
		}
	}

}

```



本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
