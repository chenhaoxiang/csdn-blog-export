---
layout: post
title: "HDOJ(HDU) 2113 Secret Number(遍历数字位数的每个数字)"
date: 2016-05-02 04:39:47 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [遍历]
keyword: 陈浩翔, 谙忆
description: Problem Description 
有一天, KIKI 收到一张奇怪的信, 信上要KIKI 计算出给定数各个位上数字为偶数的和. 
eg. 5548 
结果为12 , 等于 4 + 8KIKI 很苦恼. 想请你帮忙解决这个问题.Input 
输入数据有多组,每组占一行,只有一个数字,保证数字在INT范围内.Output 
对于每组输入数据,输出一行,每两组数据之间有一个空行.Sample In 
---


Problem Description 
有一天, KIKI 收到一张奇怪的信, 信上要KIKI 计算出给定数各个位上数字为偶数的和. 
eg. 5548 
结果为12 , 等于 4 + 8KIKI 很苦恼. 想请你帮忙解决这个问题.Input 
输入数据有多组,每组占一行,只有一个数字,保证数字在INT范围内.Output 
对于每组输入数据,输出一行,每两组数据之间有一个空行.Sample In
<!-- more -->
----------

Problem Description
有一天, KIKI 收到一张奇怪的信, 信上要KIKI 计算出给定数各个位上数字为偶数的和.
eg. 5548
结果为12 , 等于 4 + 8

KIKI 很苦恼. 想请你帮忙解决这个问题.


 

Input
输入数据有多组,每组占一行,只有一个数字,保证数字在INT范围内.
 

Output
对于每组输入数据,输出一行,每两组数据之间有一个空行.

 

Sample Input
415326
3262
 

Sample Output
12

10


简单题。
注意输出格式就行！输出之间才有空行。

```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isFirst = true;
		while(sc.hasNext()){
			long n = sc.nextLong();
			
			if(isFirst){
				isFirst=false;
			}else{
				System.out.println();
			}
			
			long sum =0;
			long k=0;
			while(n>0){
				k=n%10;
				if(k%2==0){
					sum+=k;
				}
				n=n/10;
			}
			System.out.println(sum);
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
