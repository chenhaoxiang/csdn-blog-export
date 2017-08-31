---
layout: post
title: "HDOJ 1058 Humble Numbers(打表过)"
date: 2016-03-31 01:08:55 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题,----- 动态规划（DP）
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
A number whose only prime factors are 2,3,5 or 7 is called a humble number. The sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 24, 25, 27, … shows the first 20 
---


Problem Description 
A number whose only prime factors are 2,3,5 or 7 is called a humble number. The sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 24, 25, 27, … shows the first 20
<!-- more -->
----------

Problem Description
A number whose only prime factors are 2,3,5 or 7 is called a humble number. The sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 24, 25, 27, ... shows the first 20 humble numbers. 

Write a program to find and print the nth element in this sequence

 

Input
The input consists of one or more test cases. Each test case consists of one integer n with 1 <= n <= 5842. Input is terminated by a value of zero (0) for n.

 

Output
For each test case, print one line saying "The nth humble number is number.". Depending on the value of n, the correct suffix "st", "nd", "rd", or "th" for the ordinal number nth has to be used like it is shown in the sample output.

 

Sample Input
1
2
3
4
11
12
13
21
22
23
100
1000
5842
0
 

Sample Output
The 1st humble number is 1.
The 2nd humble number is 2.
The 3rd humble number is 3.
The 4th humble number is 4.
The 11th humble number is 12.
The 12th humble number is 14.
The 13th humble number is 15.
The 21st humble number is 28.
The 22nd humble number is 30.
The 23rd humble number is 32.
The 100th humble number is 450.
The 1000th humble number is 385875.
The 5842nd humble number is 2000000000.

打表做的。
题意输出的格式挺难懂的。。。
解释一下格式：
如果输入的数：
对10取余，余数等于1且对100取余，余数不为11.则输出的是"st";
对10取余，余数等于2且对100取余，余数不为12.则输出的是"nd";
对10取余，余数等于3且对100取余，余数不为13.则输出的是"rd";
其他的全部为“th”。


```
import java.util.Scanner;

public class Main{
	static int db[] = new int[5845];
	public static void main(String[] args) {
		dabiao();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n  = sc.nextInt();
			if(n==0){
				return;
			}
			System.out.printf("The %d", n);
			if(n%10 == 1 && n%100 != 11){
				System.out.printf("st");
			}
			else if(n%10 == 2 && n%100 != 12){
				System.out.printf("nd");
			}
			else if(n%10 == 3 && n%100 != 13){
				System.out.printf("rd");
			}
			else System.out.printf("th");
			
			System.out.printf(" humble number is %d.",db[n]);
			System.out.println();
			
		}
	}
	private static void dabiao() {
		db[1]=1;
		int a1=1,a2=1,a3=1,a4=1;
		for(int i=2;i<=5842;i++){
			db[i]=min4(db[a1]*2,db[a2]*3,db[a3]*5,db[a4]*7);
			
			if(db[i]==db[a1]*2){
				a1++;
			}
			if(db[i]==db[a2]*3){
				a2++;
			}
			if(db[i]==db[a3]*5){
				a3++;
			}
			if(db[i]==db[a4]*7){
				a4++;
			}
			//没有这个防护一样能过
//			if(db[i]==db[i-1]){
//				i--;
//			}
		}
	}
	
	private static int min4(int i, int j, int k, int l) {
		return min(i,min(j,min(k,l)));
	}
	private static int min(int k, int l) {
		if(k<l){
			return k;
		}else{
			return l;
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
