---
layout: post
title: "HDOJ(HDU)  1555  How many days (水题)"
date: 2016-04-18 12:54:24 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
8600的手机每天消费1元，每消费K元就可以获赠1元，一开始8600有M元，问最多可以用多少天？Input 
输入包括多个测试实例.每个测试实例包括2个整数M, k，（2 <= k <= M <= 1000).M = 0, k = 0代表输入结束.Output 
对于每个测试实例输出一个整数，表示M元可以用的天数。Sample Input 
2 2 
4 3 
---


Problem Description 
8600的手机每天消费1元，每消费K元就可以获赠1元，一开始8600有M元，问最多可以用多少天？Input 
输入包括多个测试实例.每个测试实例包括2个整数M, k，（2 <= k <= M <= 1000).M = 0, k = 0代表输入结束.Output 
对于每个测试实例输出一个整数，表示M元可以用的天数。Sample Input 
2 2 
4 3
<!-- more -->
----------

Problem Description
8600的手机每天消费1元，每消费K元就可以获赠1元，一开始8600有M元，问最多可以用多少天？

 

Input
输入包括多个测试实例.每个测试实例包括2个整数M, k，（2 <= k <= M <= 1000).M = 0, k = 0代表输入结束.
 

Output
对于每个测试实例输出一个整数，表示M元可以用的天数。

 

Sample Input
2 2
4 3
0 0
 

Sample Output
3
5


水题。。。。

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int m = sc.nextInt();
			int k = sc.nextInt();
			if(m==0&&k==0){
				return ;
			}
			int day=0;
			int kt=0;
			
			while(m>0){
				m--;
				day++;
				kt++;
				if(kt==k){
					kt=0;
					m++;
				}
			}
			System.out.println(day);
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
