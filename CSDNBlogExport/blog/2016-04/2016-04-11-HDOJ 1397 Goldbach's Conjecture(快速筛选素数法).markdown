---
layout: post
title: "HDOJ 1397 Goldbach's Conjecture(快速筛选素数法)"
date: 2016-04-11 03:11:11 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 素数相关
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Goldbach’s Conjecture: For any even number n greater than or equal to 4, there exists at least one pair of prime numbers p1 and p2 such that n = p1 + p2.  
This conjecture has not 
---


Problem Description 
Goldbach’s Conjecture: For any even number n greater than or equal to 4, there exists at least one pair of prime numbers p1 and p2 such that n = p1 + p2.  
This conjecture has not
<!-- more -->
----------

Problem Description
Goldbach's Conjecture: For any even number n greater than or equal to 4, there exists at least one pair of prime numbers p1 and p2 such that n = p1 + p2. 
This conjecture has not been proved nor refused yet. No one is sure whether this conjecture actually holds. However, one can find such a pair of prime numbers, if any, for a given even number. The problem here is to write a program that reports the number of all the pairs of prime numbers satisfying the condition in the conjecture for a given even number.

A sequence of even numbers is given as input. Corresponding to each number, the program should output the number of pairs mentioned above. Notice that we are interested in the number of essentially different pairs and therefore you should not count (p1, p2) and (p2, p1) separately as two different pairs.

 

Input
An integer is given in each input line. You may assume that each integer is even, and is greater than or equal to 4 and less than 2^15. The end of the input is indicated by a number 0.

 

Output
Each output line should contain an integer number. No other characters should appear in the output.

 

Sample Input
6
10
12
0
 

Sample Output
1
2
1


题意：
哥德巴赫猜想：任何偶数n大于或等于4，至少存在一对素数P1和P2，n＝p1+p2。p1+p2和p2+p1是一样的。
本题是统计有多少对不同的素数和等于n.

注意用到素数筛选，然后打表就可以得出答案了。

```
import java.util.Scanner;

public class Main{
	static int[] db = new int[65536];
	public static void main(String[] args) {
		dabiao();
		//System.out.println(Math.pow(2, 15));-32768
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			if(n==0){
				return ;
			}
			int tp = 0;
			for(int i=1;i<=n/2;i++){
				
				if(db[i]==1&&db[n-i]==1){
					tp++;
				}
			}
			System.out.println(tp);
			
		}
		
	}
	
	//快速筛选素数
	private static void dabiao() {
		for(int i=0;i<db.length;i++){
			db[i]=1;
		}
		db[0]=0;
		db[1]=0;
		for(int i=2;i<=Math.sqrt(db.length);i++){
			for(int j=i+i;j<db.length;j=j+i){
				if(db[i]==1){
					db[j]=0;
				}
			}
		}
		
//		for(int i=0;i<1000;i++){
//			if(db[i]==1){
//				System.out.println(i);
//			}
//		}
	}

}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
