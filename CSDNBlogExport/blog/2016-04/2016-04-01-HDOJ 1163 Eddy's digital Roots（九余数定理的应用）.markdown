---
layout: post
title: "HDOJ 1163 Eddy's digital Roots（九余数定理的应用）"
date: 2016-04-01 04:57:50 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题,----- 模拟/推导/打表
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resulting 
---


Problem Description 
The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resulting
<!-- more -->
----------

Problem Description
The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resulting value contains two or more digits, those digits are summed and the process is repeated. This is continued as long as necessary to obtain a single digit.

For example, consider the positive integer 24. Adding the 2 and the 4 yields a value of 6. Since 6 is a single digit, 6 is the digital root of 24. Now consider the positive integer 39. Adding the 3 and the 9 yields 12. Since 12 is not a single digit, the process must be repeated. Adding the 1 and the 2 yeilds 3, a single digit and also the digital root of 39.

The Eddy's easy problem is that : give you the n,want you to find the n^n's digital Roots.

 

Input
The input file will contain a list of positive integers n, one per line. The end of the input will be indicated by an integer value of zero. Notice:For each integer in the input n(n<10000).

 

Output
Output n^n's digital root on a separate line of the output.

 

Sample Input
2
4
0
 

Sample Output
4
4

题意：输入一个数n，求n的n次方的数根。
      数根：即某数字的每一位上的数字之和，如果和大于等于10，重复每一位上的数字之和，直到每一位上的数字之和是个位数。则这个个位数就是这个数字的数根。

九余数定理：
一个数对九取余，得到的数称之为九余数；
一个数的九余数  等于  它的各个数位上的数之和的九余数！
例：
5^5=3125
3+1+2+5=11
1+1=2（digital Roots）
3125%9=2；
一个数对9取余就等于它的个位数字之和对9取余就等于数根对9取余。
 

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			if(n==0){
				return ;
			}
			int m = 1;
			for(int i=0;i<n;i++){
				m=(m*n)%9;
			}
			if(m==0){
				System.out.println(9);
			}else{
				System.out.println(m);
			}
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
