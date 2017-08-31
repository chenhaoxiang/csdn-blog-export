---
layout: post
title: "HDOJ 2114 Calculate S(n)（找周期）"
date: 2016-03-25 03:53:41 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 判断循环-循环节
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Calculate S(n).S(n)=1^3+2^3 +3^3 +……+n^3 .Input 
Each line will contain one integer N(1 < n < 1000000000). Process to end of file.Output 
For each case, output the last four dights 
---


Problem Description 
Calculate S(n).S(n)=1^3+2^3 +3^3 +……+n^3 .Input 
Each line will contain one integer N(1 < n < 1000000000). Process to end of file.Output 
For each case, output the last four dights
<!-- more -->
----------

Problem Description
Calculate S(n).

S(n)=1^3+2^3 +3^3 +......+n^3 .
 

Input
Each line will contain one integer N(1 < n < 1000000000). Process to end of file.
 

Output
For each case, output the last four dights of S(N) in one line.

 

Sample Input
1
2
 

Sample Output
0001
0009
 
题意是：给一个数n，求S(n)=1^3+2^3 +3^3 +......+n^3 .输出最后4位数字，不足4位的补零输出。

如果没找出周期会超时的。
我找到的是以10000为周期。

```
import java.util.Scanner;
//10000为周期
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int sum =0;
			int t;
			n = n%10000;
			for(int i=1;i<=n;i++){
				sum = ((sum)%10000+(((i)%10000)*((i)%10000))%10000*((i)%10000))%10000;
			}
			if(sum<10){
				System.out.println("000"+sum);
			}else if(sum<100){
				System.out.println("00"+sum);
			}else if(sum<1000){
				System.out.println("0"+sum);
			}else{
				System.out.println(sum);
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
