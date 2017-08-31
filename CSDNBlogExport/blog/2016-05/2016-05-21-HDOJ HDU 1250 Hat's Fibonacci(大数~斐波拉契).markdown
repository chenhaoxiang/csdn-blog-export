---
layout: post
title: "HDOJ HDU 1250 Hat's Fibonacci(大数~斐波拉契)"
date: 2016-05-21 08:22:20 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 大数问题
tags: [java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
A Fibonacci sequence is calculated by adding the previous two members the sequence, with the first two members being both 1. 
F(1) = 1, F(2) = 1, F(3) = 1,F(4) = 1, F(n>4) = F(n - 
---


Problem Description 
A Fibonacci sequence is calculated by adding the previous two members the sequence, with the first two members being both 1. 
F(1) = 1, F(2) = 1, F(3) = 1,F(4) = 1, F(n>4) = F(n -
<!-- more -->
----------

Problem Description
A Fibonacci sequence is calculated by adding the previous two members the sequence, with the first two members being both 1.
F(1) = 1, F(2) = 1, F(3) = 1,F(4) = 1, F(n>4) = F(n - 1) + F(n-2) + F(n-3) + F(n-4)
Your task is to take a number as input, and print that Fibonacci number.

 

Input
Each line will contain an integers. Process to end of file.

 

Output
For each case, output the result in a line.
 

Sample Input
100
 

Sample Output
4203968145672990846840663646



Note:
No generated Fibonacci number in excess of 2005 digits will be in the test data, ie. F(20) = 66526 has 5 digits.


就是根据这个公式：
F(1) = 1, F(2) = 1, F(3) = 1,F(4) = 1, F(n>4) = F(n - 1) + F(n-2) + F(n-3) + F(n-4)

输入一个n，输出f(n)的值。

注意，这是大数~答案的位数高达2005位~~~

再一次体会Java大数的强大吧~


```
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static BigInteger f[] = new BigInteger[7045];
	public static void main(String[] args) {
		dabiao();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n =sc.nextInt();
			System.out.println(f[n]);
			//System.out.println("---------");
			//System.out.println(f[n].toString().length());
			//开数组~看开到多少位的时候，位数大于2005
		}
	}
	private static void dabiao() {
		f[1]=new BigInteger("1");
		f[2]=new BigInteger("1");
		f[3]=new BigInteger("1");
		f[4]=new BigInteger("1");
		for(int i=5;i<f.length;i++){
			f[i]=f[i-1].add(f[i-2]).add(f[i-3]).add(f[i-4]);
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
