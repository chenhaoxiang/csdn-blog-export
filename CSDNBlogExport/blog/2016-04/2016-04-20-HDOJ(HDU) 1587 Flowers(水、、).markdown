---
layout: post
title: "HDOJ(HDU) 1587 Flowers(水、、)"
date: 2016-04-20 01:00:24 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
As you know, Gardon trid hard for his love-letter, and now he’s spending too much time on choosing flowers for Angel. 
When Gardon entered the flower shop, he was frightened and da 
---


Problem Description 
As you know, Gardon trid hard for his love-letter, and now he’s spending too much time on choosing flowers for Angel. 
When Gardon entered the flower shop, he was frightened and da
<!-- more -->
----------

Problem Description
As you know, Gardon trid hard for his love-letter, and now he's spending too much time on choosing flowers for Angel.
When Gardon entered the flower shop, he was frightened and dazed by thousands kinds of flowers. 
"How can I choose!" Gardon shouted out.
Finally, Gardon-- a no-EQ man decided to buy flowers as many as possible.
Can you compute how many flowers Gardon can buy at most?
 

Input
Input have serveral test cases. Each case has two lines.
The first line contains two integers: N and M. M means how much money Gardon have.
N integers following, means the prices of differnt flowers.
 

Output
For each case, print how many flowers Gardon can buy at most.
You may firmly assume the number of each kind of flower is enough.
 

Sample Input
2 5
2 3
 

Sample Output
2

HintHint 
Gardon can buy 5=2+3,at most 2 flower, but he cannot buy 3 flower with 5 yuan.

大概题意：
输入m n
再输入m种花的价格
就是你有n元钱，需要买最多的花，问最多能买多少朵花！
一种花你可以买很多朵！！！
所以，只要找到最低价格的花就可以了。

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int min = sc.nextInt();
			a--;
			int t;
			while(a-->0){
				t = sc.nextInt();
				if(t<min){
					min=t;
				}
			}
			System.out.println(b/min);
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
