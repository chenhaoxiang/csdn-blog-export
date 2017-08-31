---
layout: post
title: "HDOJ 1266 Reverse Number（数字反向输出题）"
date: 2016-04-06 03:47:54 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Welcome to 2006’4 computer college programming contest!Specially, I give my best regards to all freshmen! You are the future of HDU ACM! And now, I must tell you that ACM problems 
---


Problem Description 
Welcome to 2006’4 computer college programming contest!Specially, I give my best regards to all freshmen! You are the future of HDU ACM! And now, I must tell you that ACM problems
<!-- more -->
----------

Problem Description
Welcome to 2006'4 computer college programming contest!

Specially, I give my best regards to all freshmen! You are the future of HDU ACM! And now, I must tell you that ACM problems are always not so easy, but, except this one... Ha-Ha!

Give you an integer; your task is to output its reverse number. Here, reverse number is defined as follows:
1. The reverse number of a positive integer ending without 0 is general reverse, for example, reverse (12) = 21;
2. The reverse number of a negative integer is negative, for example, reverse (-12) = -21;
3. The reverse number of an integer ending with 0 is described as example, reverse (1200) = 2100.

 

Input
Input file contains multiple test cases. There is a positive integer n (n<100) in the first line, which means the number of test cases, and then n 32-bit integers follow.

 

Output
For each test case, you should output its reverse number, one case per line.

 

Sample Input
3
12
-12
1200
 

Sample Output
21
-21
2100


注意：前导0的情况！
例：
输入：
3
-0012560020
00000
00205
输出为：
-2006521
0
502

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String str = sc.next();
			int instr = Integer.parseInt(str);
			//System.out.println(instr);
			str = Integer.toString(instr);
			
			//System.out.println(str);
			if (str.charAt(0) == '-') {
				System.out.print("-");
				int k = 0;
				boolean isOne=false;
				
				//System.out.println(str.length()+"aaa");
				
				for (int i = str.length() - 1; i >= 1; i--) {
					//System.out.println("a:  "+str.charAt(i));
					if(str.charAt(i)!='0'&&!isOne){
						//System.out.println("++ "+str.charAt(i));
						isOne=true;
					}
					
					if (isOne) {
						System.out.print(str.charAt(i));
						k++;
					}
				}
				for (int i = 1; i < str.length() - k; i++) {
					System.out.print(0);
				}
				System.out.println();
			} else {
				int k = 0;
				boolean isOne=false;
				for (int i = str.length() - 1; i >= 0; i--) {
					if(str.charAt(i)!='0'&&!isOne){
						isOne=true;
					}
					
					if (isOne) {
						System.out.print(str.charAt(i));
						k++;
						
					}
				}

				for (int i = 0; i < str.length() - k; i++) {
					System.out.print(0);
				}
				System.out.println();

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
