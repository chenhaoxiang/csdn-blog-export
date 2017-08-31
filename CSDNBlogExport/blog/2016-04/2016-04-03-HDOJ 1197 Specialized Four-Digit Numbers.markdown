---
layout: post
title: "HDOJ 1197 Specialized Four-Digit Numbers"
date: 2016-04-03 12:42:40 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题,----- String
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Find and list all four-digit numbers in decimal notation that have the property that the sum of its four digits equals the sum of its digits when represented in hexadecimal (base 1 
---


Problem Description 
Find and list all four-digit numbers in decimal notation that have the property that the sum of its four digits equals the sum of its digits when represented in hexadecimal (base 1
<!-- more -->
----------

Problem Description
Find and list all four-digit numbers in decimal notation that have the property that the sum of its four digits equals the sum of its digits when represented in hexadecimal (base 16) notation and also equals the sum of its digits when represented in duodecimal (base 12) notation.

For example, the number 2991 has the sum of (decimal) digits 2+9+9+1 = 21. Since 2991 = 1*1728 + 8*144 + 9*12 + 3, its duodecimal representation is 1893(12), and these digits also sum up to 21. But in hexadecimal 2991 is BAF16, and 11+10+15 = 36, so 2991 should be rejected by your program.

The next number (2992), however, has digits that sum to 22 in all three representations (including BB016), so 2992 should be on the listed output. (We don't want decimal numbers with fewer than four digits - excluding leading zeroes - so that 2992 is the first correct answer.)

 

Input
There is no input for this problem.

 

Output
Your output is to be 2992 and all larger four-digit numbers that satisfy the requirements (in strictly increasing order), each on a separate line with no leading or trailing blanks, ending with a new-line character. There are to be no blank lines in the output. The first few lines of the output are shown below.

 

Sample Input
There is no input for this problem.
 

Sample Output
2992
2993
2994
2995
2996
2997
2998
2999


题意：输入一个十进制数，看这个十进制的数的各个位数上的和，和它的12进制和16进制上的各个位数上的和是不是相等，相等就输出。
（十进制的数范围[2992-9999]）

```
public class Main{
	public static void main(String[] args) {
		for(int i=2992;i<=9999;i++){
			int a = i/1000+(i/100)%10+(i/10)%10+i%10;
			String str = Integer.toString(i, 12);
			//System.out.println(str);
			int b = 0;
			for(int j=0;j<str.length();j++){
				switch(str.charAt(j)){
				case 'a':b=b+10;break;
				case 'b':b=b+11;break;
				default:b=b+(new Integer(str.charAt(j)+""));
				}
			}
			if(a!=b){
				continue;
			}
			int c=0;
			str = Integer.toString(i, 16);
			//System.out.println(str);
			for(int j=0;j<str.length();j++){
				switch(str.charAt(j)){
				case 'a':c=c+10;break;
				case 'b':c=c+11;break;
				case 'c':c=c+12;break;
				case 'd':c=c+13;break;
				case 'e':c=c+14;break;
				case 'f':c=c+15;break;
				default:c=c+(new Integer(str.charAt(j)+""));
				}
			}
			if(a!=c){
				continue;
			}
			System.out.println(i);
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
