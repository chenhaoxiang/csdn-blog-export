---
layout: post
title: "HDOJ(HDU) 1673 Optimal Parking"
date: 2016-04-20 01:17:13 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
When shopping on Long Street, Michael usually parks his car at some random location, and then walks to the stores he needs. 
Can you help Michael choose a place to park which minim 
---


Problem Description 
When shopping on Long Street, Michael usually parks his car at some random location, and then walks to the stores he needs. 
Can you help Michael choose a place to park which minim
<!-- more -->
----------

Problem Description
When shopping on Long Street, Michael usually parks his car at some random location, and then walks to the stores he needs.
Can you help Michael choose a place to park which minimises the distance he needs to walk on his shopping round?
Long Street is a straight line, where all positions are integer.
You pay for parking in a specific slot, which is an integer position on Long Street. Michael does not want to pay for more than one parking though. He is very strong, and does not mind carrying all the bags around.

 

Input
The first line of input gives the number of test cases, 1 <= t <= 100. There are two lines for each test case. The first gives the number of stores Michael wants to visit, 1 <= n <= 20, and the second gives their n integer positions on Long Street, 0 <= xi <= 99.

 

Output
Output for each test case a line with the minimal distance Michael must walk given optimal parking.
 

Sample Input
2
4
24 13 89 37
6
7 30 41 14 39 42
 

Sample Output
152
70


真心的题意难懂啊。。懂了之后就是大水题，大水题、、、

题意：一条路上有n家商店，给出坐标。某人停车在某点后，要逛完所有商店回到车出。停车地点自选，求最少需要步行多远。

无论停在那个商店，总要回来的，也就是说一定会是从最小坐标到最大坐标的距离的两倍！！！

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int min=sc.nextInt();
			int max = min;
			int m;
			while(n-->1){
				m = sc.nextInt();
				if(m>max){
					max=m;
				}
				if(m<min){
					min=m;
				}
			}
			
			System.out.println(2*(max-min));
			
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
