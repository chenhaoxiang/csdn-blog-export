---
layout: post
title: "HDOJ(HDU) 1977 Consecutive sum II(推导、、)"
date: 2016-04-22 10:10:51 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 模拟/推导/打表
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Consecutive sum come again. Are you ready? Go ~~ 
1    = 0 + 1 
2+3+4    = 1 + 8 
5+6+7+8+9  = 8 + 27 
… 
You can see the consecutive sum can be representing like that. The nth lin 
---


Problem Description 
Consecutive sum come again. Are you ready? Go ~~ 
1    = 0 + 1 
2+3+4    = 1 + 8 
5+6+7+8+9  = 8 + 27 
… 
You can see the consecutive sum can be representing like that. The nth lin
<!-- more -->
----------

Problem Description
Consecutive sum come again. Are you ready? Go ~~
1    = 0 + 1
2+3+4    = 1 + 8
5+6+7+8+9  = 8 + 27
…
You can see the consecutive sum can be representing like that. The nth line will have 2*n+1 consecutive numbers on the left, the first number on the right equal with the second number in last line, and the sum of left numbers equal with two number’s sum on the right.
Your task is that tell me the right numbers in the nth line.

 

Input
The first integer is T, and T lines will follow.
Each line will contain an integer N (0 <= N <= 2100000).

 

Output
For each case, output the right numbers in the Nth line.
All answer in the range of signed 64-bits integer.

 

Sample Input
3
0
1
2
 

Sample Output
0 1
1 8
8 27


看到有很多人的这个题目是找规律做的，我开始没注意规律了，
就打表做了。。。。
现在给出2种能AC的方法：

第一种：打表：

```
import java.util.Scanner;

public class Main{
	static long[] db1 = new long[2100005];
	public static void main(String[] args) {
		dabiao();
		//System.out.println("aa");
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			System.out.println(db1[n]+" "+db1[n+1]);
		}
	}
	private static void dabiao() {
		db1[0] = 0;
		db1[1] = 1;
		db1[2] = 8;
		db1[3] = 27;
		long k=9;
		long num =7;
		Scanner sc = new Scanner(System.in);
		for(int i=4;i<=2100001;i++){
			db1[i] =(k+num/2+1)*num-db1[i-1];
//			System.out.println(k);
//			System.out.println(num/2+1);
//			
//			System.out.println(i);
//			System.out.println(db1[i]);
//			System.out.println((k+num/2+1)*num);
//			int m = sc.nextInt();
			k=k+num;
			num+=2;
			
		}
	}
}

```

第二种：找规律：

```
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t  =sc.nextInt();
		
		while(t-->0){
			long n =sc.nextLong();
			System.out.println(n*n*n+" "+(n+1)*(n+1)*(n+1));
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
