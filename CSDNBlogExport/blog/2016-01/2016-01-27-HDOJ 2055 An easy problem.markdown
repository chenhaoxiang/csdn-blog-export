---
layout: post
title: "HDOJ 2055 An easy problem"
date: 2016-01-27 05:22:04 +0800
comments: true
categories:----- HDOJ-JAVA,❶ ACM
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
we define f(A) = 1, f(a) = -1, f(B) = 2, f(b) = -2, … f(Z) = 26, f(z) = -26; 
Give you a letter x and a number y , you should output the result of y+f(x).Input 
On the first line, 
---


Problem Description 
we define f(A) = 1, f(a) = -1, f(B) = 2, f(b) = -2, … f(Z) = 26, f(z) = -26; 
Give you a letter x and a number y , you should output the result of y+f(x).Input 
On the first line,
<!-- more -->
----------

Problem Description
we define f(A) = 1, f(a) = -1, f(B) = 2, f(b) = -2, ... f(Z) = 26, f(z) = -26;
Give you a letter x and a number y , you should output the result of y+f(x).
 

Input
On the first line, contains a number T.then T lines follow, each line is a case.each case contains a letter and a number.
 

Output
for each case, you should the result of y+f(x) on a line.
 

Sample Input
6
R 1
P 2
G 3
r 1
p 2
g 3
 

Sample Output
19
18
10
-17
-14
-4


题意：we define f(A) = 1, f(a) = -1, f(B) = 2, f(b) = -2, … f(Z) = 26, f(z) = -26;Give you a letter x and a number y , you should output the result of y+f(x)..



```
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String lowerCase = "0abcdefghijklmnopqrstuvwxyz";
		String capital = "1ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int n =sc.nextInt();
		//sc.next();
		while(n-->0){
			String strs = sc.next();
			//System.out.println(strs);
			int y = sc.nextInt();
			char x = strs.charAt(0);
			//strs = strs.substring(2);
			//int y = Integer.parseInt(strs,10);
			
			//System.out.println(x);
			//System.out.println(y);
			int g=0,h=0;
			for(int i=1;i<lowerCase.length();i++){
				if(x==lowerCase.charAt(i)){
					g=-i;
					break;
				}
			}
			for(int i=1;i<capital.length();i++){
				if(x==capital.charAt(i)){
					h=i;
					break;
				}
			}
			System.out.println(y+g+h);
			
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
