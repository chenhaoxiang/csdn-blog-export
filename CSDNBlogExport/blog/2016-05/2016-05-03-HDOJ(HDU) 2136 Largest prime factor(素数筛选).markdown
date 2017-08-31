---
layout: post
title: "HDOJ(HDU) 2136 Largest prime factor(素数筛选)"
date: 2016-05-03 08:30:42 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 素数相关
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Everybody knows any number can be combined by the prime number. 
Now, your task is telling me what position of the largest prime factor. 
The position of prime 2 is 1, prime 3 is 2 
---


Problem Description 
Everybody knows any number can be combined by the prime number. 
Now, your task is telling me what position of the largest prime factor. 
The position of prime 2 is 1, prime 3 is 2
<!-- more -->
----------

Problem Description
Everybody knows any number can be combined by the prime number.
Now, your task is telling me what position of the largest prime factor.
The position of prime 2 is 1, prime 3 is 2, and prime 5 is 3, etc.
Specially, LPF(1) = 0.

 

Input
Each line will contain one integer n(0 < n < 1000000).

 

Output
Output the LPF(n).

 

Sample Input
1
2
3
4
5
 

Sample Output
0
1
2
1
3


题目大意：每个素数在素数表中都有一个序号，设1的序号为0，则 2
的序号为1（4是2的倍数，所以4的序列也是1），3的序号为2，5的序号为3，以此类推。现在要求输出 所
给定的数n的最大质因子的序号，0 < n < 1000000。

思路：巧用素数打表法。用sum计算素数的序号，将素数连同他的倍数一起置为它的素数序号， 从小到大循环， 这样数组里存放的序号就是最大素数因子的序号了。
注意：初始化时令所有数为0。
再通过sum计算累加，改变之后primeNum[i]为 数 i的最大素数因子的序号。

```

import java.util.Arrays;
import java.util.Scanner;

public class Main{
	static int primeNum[] = new int[1000002];

	public static void main(String[] args) {
		dabiao();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			System.out.println(primeNum[n]);
		}
	}

	private static void dabiao() {
		int sum = 1;
		Arrays.fill(primeNum, 0);
		for (int i = 2; i < primeNum.length; i++) {
			if (primeNum[i] == 0) {
				for (int j = i; j < primeNum.length; j = j + i) {
					primeNum[j] = sum;
				}
				sum++;
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
