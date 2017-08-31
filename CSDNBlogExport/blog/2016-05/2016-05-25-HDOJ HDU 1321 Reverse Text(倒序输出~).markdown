---
layout: post
title: "HDOJ HDU 1321 Reverse Text(倒序输出~)"
date: 2016-05-25 05:00:58 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- String
tags: [java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
In most languages, text is written from left to right. However, there are other languages where text is read and written from right to left. As a first step towards a program that 
---


Problem Description 
In most languages, text is written from left to right. However, there are other languages where text is read and written from right to left. As a first step towards a program that
<!-- more -->
----------

Problem Description
In most languages, text is written from left to right. However, there are other languages where text is read and written from right to left. As a first step towards a program that automatically translates from a left-to-right language into a right-to-left language and back, you are to write a program that changes the direction of a given text. 

 

Input
The input contains several test cases. The first line contains an integer specifying the number of test cases. Each test case consists of a single line of text which contains at most 70 characters. However, the newline character at the end of each line is not considered to be part of the line.

 

Output
For each test case, print a line containing the characters of the input line in reverse order.

 

Sample Input
3
Frankly, I don't think we'll make much
money out of this scheme.
madam I'm adam
 

Sample Output
hcum ekam ll'ew kniht t'nod I ,ylknarF
.emehcs siht fo tuo yenom
mada m'I madam



就是输入一行字符串，然后倒序输出就可以了~



```
import java.util.Scanner;

/**
 * @author 陈浩翔
 * 2016-5-25
 */
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		sc.nextLine();//读取数字后的回车
		while(t-->0){
			String str =sc.nextLine();
			for(int i=str.length()-1;i>=0;i--){
				System.out.print(str.charAt(i));
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
