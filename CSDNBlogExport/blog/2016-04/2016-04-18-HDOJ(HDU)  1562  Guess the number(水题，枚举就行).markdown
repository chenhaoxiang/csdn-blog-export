---
layout: post
title: "HDOJ(HDU)  1562  Guess the number(水题，枚举就行)"
date: 2016-04-18 01:21:25 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Happy new year to everybody! 
Now, I want you to guess a minimum number x betwwn 1000 and 9999 to let  
(1) x % a = 0; 
(2) (x+1) % b = 0; 
(3) (x+2) % c = 0; 
and a, b, c are inte 
---


Problem Description 
Happy new year to everybody! 
Now, I want you to guess a minimum number x betwwn 1000 and 9999 to let  
(1) x % a = 0; 
(2) (x+1) % b = 0; 
(3) (x+2) % c = 0; 
and a, b, c are inte
<!-- more -->
----------

Problem Description
Happy new year to everybody!
Now, I want you to guess a minimum number x betwwn 1000 and 9999 to let 
(1) x % a = 0;
(2) (x+1) % b = 0;
(3) (x+2) % c = 0;
and a, b, c are integers between 1 and 100.
Given a,b,c, tell me what is the number of x ?

 

Input
The number of test cases c is in the first line of input, then c test cases followed.every test contains three integers a, b, c.
 

Output
For each test case your program should output one line with the minimal number x, you should remember that x is between 1000 and 9999. If there is no answer for x, output "Impossible".
 

Sample Input
2
44 38 49
25 56 3
 

Sample Output
Impossible
2575


枚举就可以了。。

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			boolean is = true;
			int tm=a;
			while(a<1000){
				a=a+tm;
			}
			
			//注意！答案的范围是[1000,9999]
			for (int i = a; i < 10000; i = i + tm) {
				//此处注意i是加tm，而不是再加a了，因为a可能变了。
				if ((i+1)%b==0&&(i+2)%c==0) {
					System.out.println(i);
					is = false;
					break;
				}
			}

			if (is) {
				System.out.println("Impossible");
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
