---
layout: post
title: "HDOJ(HDU) 1563 Find your present!(异或)"
date: 2016-04-19 04:36:31 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 异或^
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
In the new year party, everybody will get a “special present”.Now it’s your turn to get your special present, a lot of presents now putting on the desk, and only one of them will b 
---


Problem Description 
In the new year party, everybody will get a “special present”.Now it’s your turn to get your special present, a lot of presents now putting on the desk, and only one of them will b
<!-- more -->
----------

Problem Description
In the new year party, everybody will get a "special present".Now it's your turn to get your special present, a lot of presents now putting on the desk, and only one of them will be yours.Each present has a card number on it, and your present's card number will be the one that different from all the others.For example, there are 5 present, and their card numbers are 1, 2, 3, 2, 1.so your present will be the one with the card number of 3, because 3 is the number that different from all the others.
 

Input
The input file will consist of several cases. 
Each case will be presented by an integer n (1<=n<=200, and n is odd) at first. Following that, n positive integers will be given in a line. These numbers indicate the card numbers of the presents.n = 0 ends the input.
 

Output
For each case, output an integer in a line, which is the card number of your present.
 

Sample Input
5
1 1 3 2 2
3
1 2 1
0
 

Sample Output
3
2

题意：找出一行数中独立的数！

按位异或的3个特点: 
(1) 0^0=0,0^1=1 0异或任何数＝任何数 
(2) 1^0=1,1^1=0 1异或任何数－任何数取反 
(3) 任何数异或自己＝把自己置0 


先说一下异或运算的运算法则：
  1.  a ^ b = b ^ a
2. a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c
3. d = a ^ b ^ c 可以推出 a = d ^ b ^ c
 4. a ^ b ^ a = b
 
  对于性质1，显而易见。
  对于性质2和4，就是可以查找出一组数列中具有奇数个数的数。比如：
   题目：有2n+1个数，其中有n个数出现过两次，只有一个数字出现过一次。要求是找出这个数字。


```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			int n =sc.nextInt();
			if(n==0){
				return ;
			}
			int m =0;
			int s;
			while(n-->0){
				s = sc.nextInt();
				m = m^s;
			}
			System.out.println(m);
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
