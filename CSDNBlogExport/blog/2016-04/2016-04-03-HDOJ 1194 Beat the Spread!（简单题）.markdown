---
layout: post
title: "HDOJ 1194 Beat the Spread!（简单题）"
date: 2016-04-03 11:43:32 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Superbowl Sunday is nearly here. In order to pass the time waiting for the half-time commercials and wardrobe malfunctions, the local hackers have organized a betting pool on the g 
---


Problem Description 
Superbowl Sunday is nearly here. In order to pass the time waiting for the half-time commercials and wardrobe malfunctions, the local hackers have organized a betting pool on the g
<!-- more -->
----------

Problem Description
Superbowl Sunday is nearly here. In order to pass the time waiting for the half-time commercials and wardrobe malfunctions, the local hackers have organized a betting pool on the game. Members place their bets on the sum of the two final scores, or on the absolute difference between the two scores.

Given the winning numbers for each type of bet, can you deduce the final scores?

 

Input
The first line of input contains n, the number of test cases. n lines follow, each representing a test case. Each test case gives s and d, non-negative integers representing the sum and (absolute) difference between the two final scores.

 

Output
For each test case, output a line giving the two final scores, largest first. If there are no such scores, output a line containing "impossible". Recall that football scores are always non-negative integers.

 

Sample Input
2
40 20
20 40
 

Sample Output
30 10
impossible

题意：输入2个数 a，b。
     a是x,y的和，b是x,y的差。(x,y只能为正整数或者0)
     如果x,y中出现了负数就输出impossible。
     要注意的是x=(a+b)/2;y=(a-b)/2;
     因为x,y是正整数，所以(a+b)%2==0且(a-b)%2==0;

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int x=(a+b)/2;
			int y=(a-b)/2;
			if(x<0||y<0||(a+b)%2!=0||(a-b)%2!=0){
				System.out.println("impossible");
			}else{
				System.out.println(x+" "+y);
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
