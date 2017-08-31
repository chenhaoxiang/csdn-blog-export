---
layout: post
title: "HDOJ HDU 1087 Super Jumping! Jumping! Jumping!(经典DP~)"
date: 2016-05-26 01:53:59 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 动态规划（DP）
tags: [dp,acm,java]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Nowadays, a kind of chess game called “Super Jumping! Jumping! Jumping!” is very popular in HDU. Maybe you are a good boy, and know little about this game, so I introduce it to you 
---


Problem Description 
Nowadays, a kind of chess game called “Super Jumping! Jumping! Jumping!” is very popular in HDU. Maybe you are a good boy, and know little about this game, so I introduce it to you
<!-- more -->
----------

Problem Description
Nowadays, a kind of chess game called “Super Jumping! Jumping! Jumping!” is very popular in HDU. Maybe you are a good boy, and know little about this game, so I introduce it to you now.

![](http://img.blog.csdn.net/20160526015110476)



The game can be played by two or more than two players. It consists of a chessboard（棋盘）and some chessmen（棋子）, and all chessmen are marked by a positive integer or “start” or “end”. The player starts from start-point and must jumps into end-point finally. In the course of jumping, the player will visit the chessmen in the path, but everyone must jumps from one chessman to another absolutely bigger (you can assume start-point is a minimum and end-point is a maximum.). And all players cannot go backwards. One jumping can go from a chessman to next, also can go across many chessmen, and even you can straightly get to end-point from start-point. Of course you get zero point in this situation. A player is a winner if and only if he can get a bigger score according to his jumping solution. Note that your score comes from the sum of value on the chessmen in you jumping path.
Your task is to output the maximum value according to the given chessmen list.

 

Input
Input contains multiple test cases. Each test case is described in a line as follow:
N value_1 value_2 …value_N 
It is guarantied that N is not more than 1000 and all value_i are in the range of 32-int.
A test case starting with 0 terminates the input and this test case is not to be processed.

 

Output
For each case, print the maximum according to rules, and one line one case.

 

Sample Input
3 1 3 2
4 1 2 3 4
4 3 3 2 1
0
 

Sample Output
4
10
3


就是找最大的递增子序列！！！

用动态规划做~

从前往后依次计算出当前递增子序列的值~dp[i]

最后找出最大的dp[i]就是答案~~


```
import java.util.Scanner;

/**
 * @author 陈浩翔
 *
 * 2016-5-26
 */
public class Main{

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			if(n==0){
				break;
			}
			int a[]=new int[n];
			int dp[]=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			dp[0]=a[0];
			for(int i=1;i<n;i++){
				int max=0;
				for(int j=0;j<i;j++){
					if(a[j]<a[i]&&dp[j]>max){
						max=dp[j];
					}
				}
				dp[i]=a[i]+max;
			}
			int max=dp[0];
			for(int i=1;i<n;i++){
				if(dp[i]>max){
					max=dp[i];
				}
			}
			System.out.println(max);
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
