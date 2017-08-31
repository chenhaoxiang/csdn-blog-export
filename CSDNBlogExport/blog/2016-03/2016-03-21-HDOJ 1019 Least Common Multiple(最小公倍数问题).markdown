---
layout: post
title: "HDOJ 1019 Least Common Multiple(最小公倍数问题)"
date: 2016-03-21 02:44:40 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 公约数公倍数
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
The least common multiple (LCM) of a set of positive integers is the smallest positive integer which is divisible by all the numbers in the set. For example, the LCM of 5, 7 and 15 
---


Problem Description 
The least common multiple (LCM) of a set of positive integers is the smallest positive integer which is divisible by all the numbers in the set. For example, the LCM of 5, 7 and 15
<!-- more -->
----------

Problem Description
The least common multiple (LCM) of a set of positive integers is the smallest positive integer which is divisible by all the numbers in the set. For example, the LCM of 5, 7 and 15 is 105.


 

Input
Input will consist of multiple problem instances. The first line of the input will contain a single integer indicating the number of problem instances. Each instance will consist of a single line of the form m n1 n2 n3 ... nm where m is the number of integers in the set and n1 ... nm are the integers. All integers will be positive and lie within the range of a 32-bit integer.

 

Output
For each problem instance, output a single line containing the corresponding LCM. All results will lie in the range of a 32-bit integer.

 

Sample Input
2
3 5 7 15
6 4 10296 936 1287 792 1
 

Sample Output
105
10296

```
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
			}
			int k = a[0];
			for(int i=1;i<n;i++){
				int b = a[i];
				if(k>b){
					b=b^k;
					k=b^k;
					b=b^k;
				}
				k=su(b,k,mod(b,k));
			}
			
			System.out.println(k);
			
		}
	}
	
	//最小公倍数。
	private static int su(int b, int k, int mod) {
		return k*(b/mod);
	}
	
	//求最大公约数，辗转相除法。b>k
	private static int mod(int b, int k) {
		while(k>0){
			int m = b%k;
			b=k;
			k=m;
		}
		return b;
	}
}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
