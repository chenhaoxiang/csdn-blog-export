---
layout: post
title: "HDOJ(HDU) 2161 Primes(素数打表)"
date: 2016-05-05 07:24:14 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 素数相关
tags: [素数]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Write a program to read in a list of integers and determine whether or not each number is prime. A number, n, is prime if its only divisors are 1 and n. For this problem, the numbe 
---


Problem Description 
Write a program to read in a list of integers and determine whether or not each number is prime. A number, n, is prime if its only divisors are 1 and n. For this problem, the numbe
<!-- more -->
----------

Problem Description
Write a program to read in a list of integers and determine whether or not each number is prime. A number, n, is prime if its only divisors are 1 and n. For this problem, the numbers 1 and 2 are not considered primes. 

 

Input
Each input line contains a single integer. The list of integers is terminated with a number<= 0. You may assume that the input contains at most 250 numbers and each number is less than or equal to 16000.

 

Output
The output should consists of one line for every number, where each line first lists the problem number, followed by a colon and space, followed by "yes" or "no". 

 

Sample Input
1
2
3
4
5
17
0
 

Sample Output
1: no
2: no
3: yes
4: no
5: yes
6: yes


给你一个数，判断它是不是素数，是素数输出**: yes,不是就输出
**: no 
注意：1和2要输出no。
还有，判断结束的标志是n<=0.

```
import java.util.Arrays;
import java.util.Scanner;

public class Main{
	static boolean db[] = new boolean[16001];
	public static void main(String[] args) {
		prime();
		Scanner sc = new Scanner(System.in);
		int t=0;
		while(sc.hasNext()){
			int n =sc.nextInt();
			if(n<=0){
				break;
			}
			if(db[n]){
				System.out.println((++t)+": yes");
			}else{
				System.out.println((++t)+": no");
			}
		}
	}
	private static void prime() {
		Arrays.fill(db, true);
		db[1]=false;
		db[2]=false;
		for(int i=2;i<=Math.sqrt(db.length);i++){
			for(int j=i+i;j<db.length;j+=i){
				if(db[j]){
					db[j]=false;
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
