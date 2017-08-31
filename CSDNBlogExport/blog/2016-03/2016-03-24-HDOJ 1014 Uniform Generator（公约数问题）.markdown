---
layout: post
title: "HDOJ 1014 Uniform Generator（公约数问题）"
date: 2016-03-24 08:37:21 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 公约数公倍数
tags: [acm,java]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Computer simulations often require random numbers. One way to generate pseudo-random numbers is via a function of the formseed(x+1) = [seed(x) + STEP] % MODwhere ‘%’ is the modulus 
---


Problem Description 
Computer simulations often require random numbers. One way to generate pseudo-random numbers is via a function of the formseed(x+1) = [seed(x) + STEP] % MODwhere ‘%’ is the modulus
<!-- more -->
----------

**Problem Description**
Computer simulations often require random numbers. One way to generate pseudo-random numbers is via a function of the form

seed(x+1) = [seed(x) + STEP] % MOD

where '%' is the modulus operator. 

Such a function will generate pseudo-random numbers (seed) between 0 and MOD-1. One problem with functions of this form is that they will always generate the same pattern over and over. In order to minimize this effect, selecting the STEP and MOD values carefully can result in a uniform distribution of all values between (and including) 0 and MOD-1. 

For example, if STEP = 3 and MOD = 5, the function will generate the series of pseudo-random numbers 0, 3, 1, 4, 2 in a repeating cycle. In this example, all of the numbers between and including 0 and MOD-1 will be generated every MOD iterations of the function. Note that by the nature of the function to generate the same seed(x+1) every time seed(x) occurs means that if a function will generate all the numbers between 0 and MOD-1, it will generate pseudo-random numbers uniformly with every MOD iterations. 

If STEP = 15 and MOD = 20, the function generates the series 0, 15, 10, 5 (or any other repeating series if the initial seed is other than 0). This is a poor selection of STEP and MOD because no initial seed will generate all of the numbers from 0 and MOD-1. 

Your program will determine if choices of STEP and MOD will generate a uniform distribution of pseudo-random numbers. 

 

**Input**
Each line of input will contain a pair of integers for STEP and MOD in that order (1 <= STEP, MOD <= 100000).

 

**Output**
For each line of input, your program should print the STEP value right- justified in columns 1 through 10, the MOD value right-justified in columns 11 through 20 and either "Good Choice" or "Bad Choice" left-justified starting in column 25. The "Good Choice" message should be printed when the selection of STEP and MOD will generate all the numbers between and including 0 and MOD-1 when MOD numbers are generated. Otherwise, your program should print the message "Bad Choice". After each output test set, your program should print exactly one blank line.

 

**Sample Input**
3 5
15 20
63923 99999
 

**Sample Output**

         3         5    Good Choice

        15        20    Bad Choice

     63923     99999    Good Choice


题目这么长，其实意思就是判断输入的2个数的最大公约数是不是1.
如果是输出：Good Choice
否则输出：Bad Choice
还有注意的是：输出后面跟一个空行。其实我也不知道是输出之间还是输出之后（英语水平有限）。我是输出之后跟一个空行，AC了。

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(gcd(a,b)==1){
				System.out.printf("%10d%10d",a,b);
				System.out.println("    Good Choice");
			}else{
				System.out.printf("%10d%10d",a,b);
				System.out.println("    Bad Choice");
			}
			System.out.println();
		}
	}
	
	//递归求最大公约数
	private static int gcd(int a, int b) {
		return b==0?a:gcd(b,a%b);
	}

}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
