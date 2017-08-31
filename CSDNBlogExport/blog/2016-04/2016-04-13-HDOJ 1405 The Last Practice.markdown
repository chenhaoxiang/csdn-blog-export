---
layout: post
title: "HDOJ 1405 The Last Practice"
date: 2016-04-13 10:25:12 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Tomorrow is contest day, Are you all ready? 
We have been training for 45 days, and all guys must be tired.But , you are so lucky comparing with many excellent boys who have no cha 
---


Problem Description 
Tomorrow is contest day, Are you all ready? 
We have been training for 45 days, and all guys must be tired.But , you are so lucky comparing with many excellent boys who have no cha
<!-- more -->
----------

Problem Description
Tomorrow is contest day, Are you all ready?
We have been training for 45 days, and all guys must be tired.But , you are so lucky comparing with many excellent boys who have no chance to attend the Province-Final.

Now, your task is relaxing yourself and making the last practice. I guess that at least there are 2 problems which are easier than this problem.
what does this problem describe?
Give you a positive integer, please split it to some prime numbers, and you can got it through sample input and sample output.

 

Input
Input file contains multiple test case, each case consists of a positive integer n(1< n<65536), one per line. a negative terminates the input, and it should not to be processed.
 

Output
For each test case you should output its factor as sample output (prime factor must come forth ascending ), there is a blank line between outputs. 
 

Sample Input
60
12
-1
 

Sample Output
Case 1.
2 2 3 1 5 1

Case 2.
2 2 3 1

Hint
60=2^2*3^1*5^1

它说的是一些素数！不是全部是素数！既然是从小到大，所以从2开始遍历到根号(n)就可以了。如果最后n还是大于1的，说明n没除完，还剩余一个n^1.

格式！！！
每行的最后一定有一个空格。
各行之间有一个空行！
Case n.！！！数字后面有一个‘.’点。。。


```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tm = 0;
		while(sc.hasNext()){
			int n = sc.nextInt();
			if(n<0){
				return ;
			}
			if(tm>0){
				System.out.println();
			}
			
			System.out.println("Case "+(++tm)+".");
			for(int i=2;i<=Math.sqrt(n);i++){
				int num = 0;
				while(n%i==0){
					n=n/i;
					num++;
				}
				if(num!=0){
					System.out.print(i+" "+num+" ");
				}
			}
			if(n>1){
				System.out.print(n+" 1 ");
			}
			System.out.println();
			
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
