---
layout: post
title: "HDOJ(HDU) 2138 How many prime numbers(素数-快速筛选没用上、)"
date: 2016-05-05 01:30:23 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 素数相关
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
  Give you a lot of positive integers, just to find out how many prime numbers there are.Input 
  There are a lot of cases. In each case, there is an integer N representing the num 
---


Problem Description 
  Give you a lot of positive integers, just to find out how many prime numbers there are.Input 
  There are a lot of cases. In each case, there is an integer N representing the num
<!-- more -->
----------

Problem Description
  Give you a lot of positive integers, just to find out how many prime numbers there are.
 

Input
  There are a lot of cases. In each case, there is an integer N representing the number of integers to find. Each integer won’t exceed 32-bit signed integer, and each of them won’t be less than 2.
 

Output
  For each case, print the number of prime numbers you have found out.
 

Sample Input
3
2 3 4
 

Sample Output
2
 

这个题目就是让你求一组的素数有多少个。
这个素数范围的数字有点大，所以不能用打表。
测试数据很水。。。直接判断就能过了。
不过判断的时候，有一个地方需要注意的，我在那个判断素数的方法注释了。



```
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//boolean db[] = new boolean[2147483647];
		//数组太大，不能打表！
		//dabiao(db);
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			long sum = 0;
			int m;
			for(int i=0;i<n;i++){
				m=sc.nextInt();
				if(prime(m)){
					sum++;
				}
			}
			System.out.println(sum);
		}
	}
	
	//直接判断能过，说明数据比较水。
	private static boolean prime(int m) {
		for(int i=2;i<=Math.sqrt(m);i++){
		 //***** 注意：i*i<=m  是会超时的，因为i*i每次都要计算
			if(m%i==0){
				return false;
			}
		}
		return true;
	}
	
	//素数筛选打表应该会超时
	private static void dabiao(boolean[] db) {
		Arrays.fill(db, true);
		for(int i=2;i<=Math.sqrt(db.length);i++){
			for(int j=i+i;j<db.length;j+=i){
				if(db[j]){
					db[j]=!db[j];
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
