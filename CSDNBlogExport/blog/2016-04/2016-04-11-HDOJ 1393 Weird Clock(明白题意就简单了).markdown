---
layout: post
title: "HDOJ 1393 Weird Clock(明白题意就简单了)"
date: 2016-04-11 01:38:09 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
A weird clock marked from 0 to 59 has only a minute hand. It won’t move until a special coin is thrown into its box. There are different kinds of coins as your options. However onc 
---


Problem Description 
A weird clock marked from 0 to 59 has only a minute hand. It won’t move until a special coin is thrown into its box. There are different kinds of coins as your options. However onc
<!-- more -->
----------

Problem Description
A weird clock marked from 0 to 59 has only a minute hand. It won't move until a special coin is thrown into its box. There are different kinds of coins as your options. However once you make your choice, you cannot use any other kind. There are infinite number of coins of each kind, each marked with a number d ( 1 <= d <= 1000 ), meaning that this coin will make the minute hand move d times clockwise the current time. For example, if the current time is 45, and d = 2. Then the minute hand will move clockwise 90 minutes and will be pointing to 15.

Now you are given the initial time s ( 1 <= s <= 59 ) and the coin's type d. Write a program to find the minimum number of d-coins needed to turn the minute hand back to 0.

 

Input
There are several tests. Each test occupies a line containing two positive integers s and d.

The input is finished by a line containing 0 0.

 

Output
For each test print in a single line the minimum number of coins needed. If it is impossible to turn the hand back to 0, output "Impossible".

 

Sample Input
30 1
0 0
 

Sample Output
1


明白题意之后就简单了，
思路：一个钟面只有一根分针。对于一个数字d，把钟面上的分针指向的时间s往后拨s的d倍。问给定d，重复这样的操作多少次能回拨到0。若不能则输出Impossible。
注意：此处的s是不断更新的！！！！！！！！！！！
因为钟面只有60分钟，所以最多不会超过60次，直接暴力就可。

```

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			int s= sc.nextInt();
			int d = sc.nextInt();
			if(s==0&&d==0){
				return ;
			}
			int num=s;
			for(int i=1;i<65;i++){
				num = (num+(num*d))%60;
				if(num==0){
					System.out.println(i);
					break;
				}
				if(i>63){
					System.out.println("Impossible");
					break;
				}
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
