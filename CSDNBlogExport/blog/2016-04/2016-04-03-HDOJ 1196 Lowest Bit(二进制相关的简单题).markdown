---
layout: post
title: "HDOJ 1196 Lowest Bit(二进制相关的简单题)"
date: 2016-04-03 12:07:49 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题,----- String,----- 进制相关
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Given an positive integer A (1 <= A <= 100), output the lowest bit of A.For example, given A = 26, we can write A in binary form as 11010, so the lowest bit of A is 10, so the outp 
---


Problem Description 
Given an positive integer A (1 <= A <= 100), output the lowest bit of A.For example, given A = 26, we can write A in binary form as 11010, so the lowest bit of A is 10, so the outp
<!-- more -->
----------

Problem Description
Given an positive integer A (1 <= A <= 100), output the lowest bit of A.

For example, given A = 26, we can write A in binary form as 11010, so the lowest bit of A is 10, so the output should be 2.

Another example goes like this: given A = 88, we can write A in binary form as 1011000, so the lowest bit of A is 1000, so the output should be 8.

 

Input
Each line of input contains only an integer A (1 <= A <= 100). A line containing "0" indicates the end of input, and this line is not a part of the input data.

 

Output
For each A in the input, output a line containing only its lowest bit.

 

Sample Input
26
88
0
 

Sample Output
2
8

输入一个十进制的数：然后转换为二进制，输出二进制的位数从后面到前面数的第一个1的时候的数的十进制。
例如：26二进制是11010，所以从后面对前面数，第二位为1，所以取值为10，再转换成十进制，输出为2；

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n =sc.nextInt();
			if(n==0){
				return ;
			}
			String str = Integer.toString(n, 2);
			//System.out.println(str);
			for(int i=str.length()-1;i>=0;i--){
				if(str.charAt(i)=='1'){
					System.out.println((int)Math.pow(2, str.length()-1-i));
					break;
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
