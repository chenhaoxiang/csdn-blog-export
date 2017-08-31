---
layout: post
title: "HDOJ 1018 Big Number（大数位数公式）"
date: 2016-03-20 05:06:27 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 大数问题,----- String
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
In many applications very large integers numbers are required. Some of these applications are using keys for secure transmission of data, encryption, etc. In this problem you are g 
---


Problem Description 
In many applications very large integers numbers are required. Some of these applications are using keys for secure transmission of data, encryption, etc. In this problem you are g
<!-- more -->
----------

Problem Description
In many applications very large integers numbers are required. Some of these applications are using keys for secure transmission of data, encryption, etc. In this problem you are given a number, you have to determine the number of digits in the factorial of the number.

 

Input
Input consists of several lines of integer numbers. The first line contains an integer n, which is the number of cases to be tested, followed by n lines, one integer 1 ≤ n ≤ 107 on each line.

 

Output
The output contains the number of digits in the factorial of the integers appearing in the input.

 

Sample Input
2
10
20
 

Sample Output
7
19

这题要求n的阶乘的位数，如果n较大时，n的阶乘必将是一个很大的数，题中说1<=n<10000000，当n=10000000时可以说n的阶乘将是一个非常巨大的数字，对于处理大数的问题，我们一般用字符串，这题当n取最大值时，就是一千万个数字相乘的积，太大了，就算保存在字符串中都有一点困难，而且一千万个数字相乘是会涉及到大数的乘法，大数的乘法是比较耗时的，就算计算出结果一般也会超时。这让我们不得不抛弃这种直接的方法。

再想一下，这题是要求n的阶乘的位数，而n的阶乘是n个数的乘积，那么要是我们能把这个问题分解就好了。

在这之前，我们必须要知道一个知识，任意一个正整数a的位数等于(int)log10(a)+ 1；为什么呢？下面给大家推导一下：

  对于任意一个给定的正整数a，
  假设10^(x-1)<=a<10^x，那么显然a的位数为x位，
  又因为
  log10(10^(x-1))<=log10(a)<(log10(10^x))
  即x-1<=log10(a) < x
  则(int)log10(a)=x-1,
  即(int)log10(a)+1=x
  即a的位数是(int)log10(a)+1

我们知道了一个正整数a的位数等于(int)log10(a) + 1，现在来求n的阶乘的位数：
假设A=n!=1*2*3*......*n，那么我们要求的就是(int)log10(A)+1，
而：
log10(A)=log10(1*2*3*......n)  
（根据log10(a*b) = log10(a) +log10(b)有） =log10(1)+log10(2)+log10(3)+......+log10(n)
现在我们终于找到方法，问题解决了，我们将求n的阶乘的位数分解成了求n个数对10取对数的和，并且对于其中任意一个数，都在正常的数字范围之类。
总结一下：n的阶乘的位数等于
		  (int)(log10(1)+log10(2)+log10(3)+......+log10(n)) + 1


开始我是打算用java大数做的，可是超时。
上面的思路是参考网络上其他人的。

```
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//超时
//		Scanner sc = new Scanner(System.in);
//		
//		int t = sc.nextInt();
//		while(t-->0){
//			int n = sc.nextInt();
//
//			BigDecimal a  = new BigDecimal(1);
//			
//			for(int i=n;i>0;i--){
//				a = a.multiply(new BigDecimal(i));
//			}
//			
//			String str = a.toPlainString();
//			System.out.println(str.length());
//			
//			
//		}
		
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			double sum = 0;
			for(int i = 1;i<=n;i++){
				sum = sum+Math.log10(i);
			}
			System.out.println((1+(int)(sum)));
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
