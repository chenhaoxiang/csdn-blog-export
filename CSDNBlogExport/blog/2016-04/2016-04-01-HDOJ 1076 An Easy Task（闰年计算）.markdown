---
layout: post
title: "HDOJ 1076 An Easy Task（闰年计算）"
date: 2016-04-01 04:35:09 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Ignatius was born in a leap year, so he want to know when he could hold his birthday party. Can you tell him?Given a positive integers Y which indicate the start year, and a positi 
---


Problem Description 
Ignatius was born in a leap year, so he want to know when he could hold his birthday party. Can you tell him?Given a positive integers Y which indicate the start year, and a positi
<!-- more -->
----------

Problem Description
Ignatius was born in a leap year, so he want to know when he could hold his birthday party. Can you tell him?

Given a positive integers Y which indicate the start year, and a positive integer N, your task is to tell the Nth leap year from year Y.

Note: if year Y is a leap year, then the 1st leap year is year Y.

 

Input
The input contains several test cases. The first line of the input is a single integer T which is the number of test cases. T test cases follow.
Each test case contains two positive integers Y and N(1<=N<=10000).

 

Output
For each test case, you should output the Nth leap year from year Y.

 

Sample Input
3
2005 25
1855 12
2004 10000
 

Sample Output
2108
1904
43236

Hint：
We call year Y a leap year only if (Y%4==0 && Y%100!=0) or Y%400==0.

题意就是：输入一个年份year和一个n，求这个year之后的第n个闰年，
如果year是闰年，则算第一个闰年。


直接暴力做，并没有超时。
```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int year = sc.nextInt();
			int n = sc.nextInt();
			int nyear = 0;
			if((year%4==0&&year%100!=0)|(year%400==0)){
				nyear=1;
			}//如果year是闰年，nyear就加一
			while(nyear<n){//当nyear小于n时，就循环
				year++;
				if((year%4==0&&year%100!=0)|(year%400==0)){
					nyear++;
				}//year是闰年，nyear就加加
			}
			System.out.println(year);
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
