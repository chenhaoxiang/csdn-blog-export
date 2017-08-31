---
layout: post
title: "HDOJ(HDU) 1720 A+B Coming(进制)"
date: 2016-04-22 12:41:47 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 进制相关
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Many classmates said to me that A+B is must needs. 
If you can’t AC this problem, you would invite me for night meal. ^_^Input 
Input may contain multiple test cases. Each case con 
---


Problem Description 
Many classmates said to me that A+B is must needs. 
If you can’t AC this problem, you would invite me for night meal. ^_^Input 
Input may contain multiple test cases. Each case con
<!-- more -->
----------

Problem Description
Many classmates said to me that A+B is must needs.
If you can’t AC this problem, you would invite me for night meal. ^_^

 

Input
Input may contain multiple test cases. Each case contains A and B in one line.
A, B are hexadecimal number.
Input terminates by EOF.

 

Output
Output A+B in decimal number in one line.
 

Sample Input
1 9
A B
a b
 

Sample Output
10
21
21


超简单的题目，，，就是给2个16进制的数，将它们的和按10进制输出！
JAVA可以直接读取16进制的数！


```
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int a = sc.nextInt(16);
			int b = sc.nextInt(16);
			System.out.println(a+b);
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
