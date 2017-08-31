---
layout: post
title: "HDOJ(HDU) 1985 Conversions(汇率转换)"
date: 2016-04-22 10:47:31 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Conversion between the metric and English measurement systems is relatively simple. Often, it involves either multiplying or dividing by a constant. You must write a program that c 
---


Problem Description 
Conversion between the metric and English measurement systems is relatively simple. Often, it involves either multiplying or dividing by a constant. You must write a program that c
<!-- more -->
----------

Problem Description
Conversion between the metric and English measurement systems is relatively simple. Often, it involves either multiplying or dividing by a constant. You must write a program that converts between the following units:
![](http://img.blog.csdn.net/20160422224635703)


 

Input
The first line of input contains a single integer N, (1 ≤ N ≤ 1000) which is the number of datasets that follow.
Each dataset consists of a single line of input containing a floating point (double precision) number, a space and the unit specification for the measurement to be converted. The unit specification is one of kg, lb, l, or g referring to kilograms, pounds, liters and gallons respectively.

 

Output
For each dataset, you should generate one line of output with the following values: The dataset number as a decimal integer (start counting at one), a space, and the appropriately converted value rounded to 4 decimal places, a space and the unit specification for the converted value.


 

Sample Input
5
1 kg
2 l
7 lb
3.5 g
0 l
 

Sample Output
1 2.2046 lb
2 0.5284 g
3 3.1752 kg
4 13.2489 l
5 0.0000 g


题目很简单，就是给出了汇率，让你转换！！！
水题！

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str1 = {"kg","l","lb","g"};
		String[] str2 = {"lb","g","kg","l"};
		double[]  d = {2.2046,0.2642,0.4536,3.7854};
		int time = 1;
		int t = sc.nextInt();
		while(t-->0){
			int k=0;
			double n = sc.nextDouble();
			String s = sc.next();
			for(int i=0;i<str1.length;i++){
				if(s.equals(str1[i])){
					k=i;
					n = n*d[i];
					break;
				}
			}
			System.out.printf("%d %.4f %s",time,n,str2[k] );
			System.out.println();
			time++;
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
