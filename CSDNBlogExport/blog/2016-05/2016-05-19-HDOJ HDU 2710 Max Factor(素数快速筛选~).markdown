---
layout: post
title: "HDOJ HDU 2710 Max Factor(素数快速筛选~)"
date: 2016-05-19 12:39:05 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 素数相关
tags: [素数,java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
To improve the organization of his farm, Farmer John labels each of his N (1 <= N <= 5,000) cows with a distinct serial number in the range 1..20,000. Unfortunately, he is unaware 
---


Problem Description 
To improve the organization of his farm, Farmer John labels each of his N (1 <= N <= 5,000) cows with a distinct serial number in the range 1..20,000. Unfortunately, he is unaware
<!-- more -->
----------

Problem Description
To improve the organization of his farm, Farmer John labels each of his N (1 <= N <= 5,000) cows with a distinct serial number in the range 1..20,000. Unfortunately, he is unaware that the cows interpret some serial numbers as better than others. In particular, a cow whose serial number has the highest prime factor enjoys the highest social standing among all the other cows.

(Recall that a prime number is just a number that has no divisors except for 1 and itself. The number 7 is prime while the number 6, being divisible by 2 and 3, is not).

Given a set of N (1 <= N <= 5,000) serial numbers in the range 1..20,000, determine the one that has the largest prime factor.

 

Input
* Line 1: A single integer, N

* Lines 2..N+1: The serial numbers to be tested, one per line
 

Output
* Line 1: The integer with the largest prime factor. If there are more than one, output the one that appears earliest in the input file.
 

Sample Input
4
36
38
40
42
 

Sample Output
38


哎~又一个英文题~

题意：
输入一个正整数n，然后输入n个正整数（1<=a[i]<=20000），要你求这n个数里哪个数的最大素因数（即能被该数整除(包括这个数本身！)的最大素数）最大，然后输出这个数。若有两个数的最大素因数相同，则输出前面那个。

用到了素数快速筛选~不然会超时的~


```
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 陈浩翔
 */
public class Main{
	static boolean db[] = new boolean[20005];
	public static void main(String[] args) {
		dabiao();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int a[] = new int[n];
			int prime[] = new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
				for(int k=1;k<=a[i];k++){
					if(db[k]&&a[i]%k==0){
						prime[i]=k;
					}
				}
			}
			int max=prime[0];
			int con=0;
			for(int i=1;i<n;i++){
				if(prime[i]>max){
					max=prime[i];
					con=i;
				}
			}
			System.out.println(a[con]);
		}
	}
	private static void dabiao() {
		Arrays.fill(db, true);
		for(int i=2;i<=Math.sqrt( db.length);i++){
			for(int j=i+i;j<db.length;j+=i){
				if(db[j]==true){
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
