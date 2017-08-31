---
layout: post
title: "HDOJ 1013 Digital Roots"
date: 2016-02-16 02:41:16 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 大数问题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resulting 
---


Problem Description 
The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resulting
<!-- more -->
----------

Problem Description
The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resulting value contains two or more digits, those digits are summed and the process is repeated. This is continued as long as necessary to obtain a single digit.

For example, consider the positive integer 24. Adding the 2 and the 4 yields a value of 6. Since 6 is a single digit, 6 is the digital root of 24. Now consider the positive integer 39. Adding the 3 and the 9 yields 12. Since 12 is not a single digit, the process must be repeated. Adding the 1 and the 2 yeilds 3, a single digit and also the digital root of 39.

 

Input
The input file will contain a list of positive integers, one per line. The end of the input will be indicated by an integer value of zero.

 

Output
For each integer in the input, output its digital root on a separate line of the output.

 

Sample Input
24
39
0
 

Sample Output
6
3

解释一下题目: 就是给你一个数让你求数的数根！什么叫数根？ 比如24这个数的数根，就是把24各个位的数加起来！2+4=6 而且6是个位数，于是它就是24的数根。 然后39这个数一样的方法，3+9=12 此时我们发现12不是个位数，所以它不是数根，继续让它各个 位数相加，1+2=3,3是个位数所以3是39的数根。
数根公式： a的数根b = ( a - 1) % 9 + 1 还不明白可以百度百科一下数根，很简单的数学定义,简称自然数的一种定义.


```
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String n = sc.next();
			if(n.equals("0")){
				break;
			}
			BigInteger m = new BigInteger(n);
			
			m = m.add(new BigInteger("-1"));
			m= m.mod(new BigInteger("9"));
			m = m.add(BigInteger.ONE);
			System.out.println(m);
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
