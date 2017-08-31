---
layout: post
title: "HDOJ 1061 Rightmost Digit（循环问题）"
date: 2016-03-31 06:29:22 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题,----- 判断循环-循环节
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Given a positive integer N, you should output the most right digit of N^N.Input 
The input contains several test cases. The first line of the input is a single integer T which is t 
---


Problem Description 
Given a positive integer N, you should output the most right digit of N^N.Input 
The input contains several test cases. The first line of the input is a single integer T which is t
<!-- more -->
----------

Problem Description
Given a positive integer N, you should output the most right digit of N^N.

 

Input
The input contains several test cases. The first line of the input is a single integer T which is the number of test cases. T test cases follow.
Each test case contains a single positive integer N(1<=N<=1,000,000,000).

 

Output
For each test case, you should output the rightmost digit of N^N.

 

Sample Input
2
3
4
 

Sample Output
7
6
![](http://img.blog.csdn.net/20160331182631674)

题意：很简单，就是输出n^n的最后一个数字时什么。

思路：前面有过一个0-9的n次方的题目，HDOJ1097题，那一题中我用代码推出了循环节，这个题目，我用的循环节全为4了.
HDOJ1097题博客链接：http://blog.csdn.net/qq_26525215/article/details/50949847


```
import java.util.Scanner;

public class Main{
	static long db[][] = new long[10][4];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dabiao();
//		System.out.println(db[4][0]);
//		System.out.println(db[4][3]);
//		
		long t = sc.nextLong();
		while(t-->0){
			int n = sc.nextInt();
			int f=n%10;
			int m=n%4;
			//System.out.println(m);
			m--;
			if(m<0){
				m=3;
			}
			System.out.println(db[f][m]);
			
		}
	}

	private static void dabiao() {
		for(int i=1;i<=9;i++){
			for(int j=0;j<4;j++){
				db[i][j]=dabiao(i,j);
				//System.out.print(db[i][j]+" ");
			}
			//System.out.println();
		}
	}

	private static long dabiao(long i, long j) {
		long m=i;//4,3
		for(int k=1;k<=j;k++){
			m=(m*i)%10;
		}
		m=m%10;
		return m;
	}

}

```



本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
