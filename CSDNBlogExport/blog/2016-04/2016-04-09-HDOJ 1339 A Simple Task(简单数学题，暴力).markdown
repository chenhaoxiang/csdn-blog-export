---
layout: post
title: "HDOJ 1339 A Simple Task(简单数学题，暴力)"
date: 2016-04-09 02:30:30 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Given a positive integer n and the odd integer o and the nonnegative integer p such that n = o2^p.ExampleFor n = 24, o = 3 and p = 3.TaskWrite a program which for each data set:rea 
---


Problem Description 
Given a positive integer n and the odd integer o and the nonnegative integer p such that n = o2^p.ExampleFor n = 24, o = 3 and p = 3.TaskWrite a program which for each data set:rea
<!-- more -->
----------

Problem Description
Given a positive integer n and the odd integer o and the nonnegative integer p such that n = o2^p.


Example

For n = 24, o = 3 and p = 3.


Task

Write a program which for each data set:

reads a positive integer n,

computes the odd integer o and the nonnegative integer p such that n = o2^p,

writes the result.

 

Input
The first line of the input contains exactly one positive integer d equal to the number of data sets, 1 <= d <= 10. The data sets follow.

Each data set consists of exactly one line containing exactly one integer n, 1 <= n <= 10^6.

 

Output
The output should consists of exactly d lines, one line for each data set.

Line i, 1 <= i <= d, corresponds to the i-th input and should contain two integers o and p separated by a single space such that n = o2^p.

 

Sample Input
1
24
 

Sample Output
3 3

思路：
就是一个公式： n = o*2^p.
n是输入的，o和p是我们需要求的。
 需要注意的是o必须是奇数！
0<=p的。

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int a=0;
			int o=0;
			for(int p=0;p<n;p++){
				a=(int)Math.pow(2, p);
				if(a>n){
					break;
				}
				if(n%a==0){
					o=n/a;
					if(o%2==0){
						continue;
					}
					a=p;
					break;
				}
			}
			System.out.println(o+" "+a);
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
