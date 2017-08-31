---
layout: post
title: "HDOJ 1390 Binary Numbers(进制问题)"
date: 2016-04-09 03:05:30 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 进制相关
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Given a positive integer n, find the positions of all 1’s in its binary representation. The position of the least significant bit is 0.ExampleThe positions of 1’s in the binary rep 
---


Problem Description 
Given a positive integer n, find the positions of all 1’s in its binary representation. The position of the least significant bit is 0.ExampleThe positions of 1’s in the binary rep
<!-- more -->
----------

Problem Description
Given a positive integer n, find the positions of all 1's in its binary representation. The position of the least significant bit is 0.


Example

The positions of 1's in the binary representation of 13 are 0, 2, 3.


Task

Write a program which for each data set:

reads a positive integer n,

computes the positions of 1's in the binary representation of n,

writes the result.

 

Input
The first line of the input contains exactly one positive integer d equal to the number of data sets, 1 <= d <= 10. The data sets follow.

Each data set consists of exactly one line containing exactly one integer n, 1 <= n <= 10^6.

 

Output
The output should consists of exactly d lines, one line for each data set.

Line i, 1 <= i <= d, should contain increasing sequence of integers separated by single spaces - the positions of 1's in the binary representation of the i-th input number.

 

Sample Input
1
13
 

Sample Output
0 2 3

**思路：**
就是输入一个数n，n二进制假如为m。
就是输出二进制m这个数的1所在的位数。从小到大输出。
例如：输入13.
13的二进制数是1101；
所以输出为：0 2 3
注意，最后一个数字后面没有接空格。

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n =sc.nextInt();
			String nstr = Integer.toString(n, 2);
			//System.out.println(nstr);
			boolean isOne=true;
			for(int i=nstr.length()-1;i>=0;i--){
				if(nstr.charAt(i)=='1'){
					if(isOne){
						System.out.print(nstr.length()-1-i);
						isOne=false;
					}else{
						System.out.print(" "+(nstr.length()-1-i));
					}
				}
			}
			System.out.println();
			
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
