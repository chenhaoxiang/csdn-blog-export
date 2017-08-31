---
layout: post
title: "HDOJ 1017 A Mathematical Curiosity"
date: 2016-03-24 09:21:37 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [acm,java]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Given two integers n and m, count the number of pairs of integers (a,b) such that 0 < a < b < n and (a^2+b^2 +m)/(ab) is an integer.This problem contains multiple test cases!The fi 
---


Problem Description 
Given two integers n and m, count the number of pairs of integers (a,b) such that 0 < a < b < n and (a^2+b^2 +m)/(ab) is an integer.This problem contains multiple test cases!The fi
<!-- more -->
----------

Problem Description
Given two integers n and m, count the number of pairs of integers (a,b) such that 0 < a < b < n and (a^2+b^2 +m)/(ab) is an integer.

This problem contains multiple test cases!

The first line of a multiple input is an integer N, then a blank line followed by N input blocks. Each input block is in the format indicated in the problem description. There is a blank line between input blocks.

The output format consists of N output blocks. There is a blank line between output blocks.

 

Input
You will be given a number of cases in the input. Each case is specified by a line containing the integers n and m. The end of input is indicated by a case in which n = m = 0. You may assume that 0 < n <= 100.

 

Output
For each case, print the case number as well as the number of pairs (a,b) satisfying the given property. Print the output for each case on one line in the format as shown below.

 

Sample Input
1

10 1
20 3
30 4
0 0
 

Sample Output
Case 1: 2
Case 2: 4
Case 3: 5

```
/*对于英语如我这样的人来说，，，，题目是天书啊。看了别人的翻译才知道什么意思的。。。

大概意思是：（0 < a < b < n ） (a^2+b^2 +m)/(ab) 的结果是一个整数，
所以满足需要(a^2+b^2 +m)%(ab)等于0。
输出：求这样的（a,b）有多少对。
懂了意思就是个水题。
还有注意输出格式：
第一个输入t为有t组数据。
每组数据有n，m2个数。
当n==0&&m==0时，这一组的输入结束，进行下一组。
每2组之间的输出有一个空行。
*/

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int p = 0;
			while(sc.hasNext()){
				int n = sc.nextInt();
				int m = sc.nextInt();
				int num=0;
				if(n==0&&m==0){
					break;
				}
				for(int a=1;a<n-1;a++){
					for(int b=a+1;b<n;b++){
						if((a*a+b*b+m)%(a*b)==0){
							num++;
						}
					}
				}
				System.out.println("Case "+(++p)+": "+num);
			}
			if(t!=0)
				System.out.println();
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
