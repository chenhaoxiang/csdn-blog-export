---
layout: post
title: "HDOJ HDU 2352 Verdis Quo(罗马数字与10进制数的转换)"
date: 2016-06-05 01:29:02 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 进制相关
tags: [java,acm,罗马数字]
keyword: 陈浩翔, 谙忆
description: Problem Description 
The Romans used letters from their Latin alphabet to represent each of the seven numerals in their number system. The list below shows which 
letters they used and what numeric val 
---


Problem Description 
The Romans used letters from their Latin alphabet to represent each of the seven numerals in their number system. The list below shows which 
letters they used and what numeric val
<!-- more -->
----------

Problem Description
The Romans used letters from their Latin alphabet to represent each of the seven numerals in their number system. The list below shows which
letters they used and what numeric value each of those letters represents:

I = 1
V = 5
X = 10
L = 50
C = 100
D = 500
M = 1000

Using these seven numerals, any desired number can be formed by following the two basic additive and subtractive rules. To form a number using
the additive rule the Roman numerals are simply written from left to right in descending order, and the value of each roman numeral is added
together. For example, the number MMCLVII has the value 1000 + 1000 + 100 + 50 + 5 + 1 + 1 = 2157. Using the addition rule alone could lead to
very long strings of letters, so the subtraction rule was invented as a result. Using this rule, a smaller Roman numeral to the left of a larger one is
subtracted from the total. In other words, the number MCMXIV is interpreted as 1000 - 100 + 1000 + 10 - 1 + 5 = 1914.

Over time the Roman number writing system became more standardized and several additional rules were developed. The additional rules used today
are:

1. The I, X, or C Roman numerals may only be repeated up to three times in succession. In other words, the number 4 must be represented as IV
and not as IIII.
2. The V, L, or D numerals may never be repeated in succession, and the M numeral may be repeated as many 2. times as necessary.
3. Only one smaller numeral can be placed to the left of another. For example, the number 18 is represented as XVIII but not as XIIX.
4. Only the I, X, or C can be used as subtractive numerals.
5. A subtractive I can only be used to the left of a V or X. Likewise a X can only appear to the left of a L or C, and a C can only be used to the
left of a D or M. For example, 49 must be written as XLIX and not as IL.

Your goal is to write a program which converts Roman numbers to base 10 integers.
 

Input
The input to this problem will consist of the following:

A line with a single integer "N" (1 ≤ N ≤ 1000), where N indicates how many Roman numbers are to be converted.
A series of N lines of input with each line containing one Roman number. Each Roman number will be in the range of 1 to 10,000 (inclusive)
and will obey all of the rules laid out in the problem's introduction.
 

Output
For each of the N Roman numbers, print the equivalent base 10 integer, one per line.
 

Sample Input
3
IX
MMDCII
DXII
 

Sample Output
9
2602
512

<font color="red" size="4">
罗马数字共有7个，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）。
1、重复数次：一个罗马数字重复几次，就表示这个数的几倍。
2、右加左减：
2.1 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
2.2 在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
2.3 左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
2.4 但是，左减时不可跨越一个位数。比如，99不可以用IC（100 - 1）表示，而是用XCIX（[100 - 10] + [10 - 1]）表示。（等同于阿拉伯数字每位数字分别表示。）
2.5 左减数字必须为一位，比如8写成VIII，而非IIX。
</font>
<font color="red" size="4">
注意的就是：I只能在V，X的左边。X只能在L，C的左边。C只能在D，M的左边。
知道这些就可以AC了。
</font>

```
import java.util.Scanner;

/**
 * @author 陈浩翔
 * 2016-6-5
 */
public class Main{
	static char[] chS={'I','V','X','L','C','D','M'};
	static int[] chN={1,5,10,50,100,500,1000};
	static String[] strS={"IV","IX","XL","XC","CD","CM"};
	static int[] strN={2,2,20,20,200,200};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String str=sc.next();
			int num=0;
			for(int i=0;i<str.length();i++){
				for(int j=0;j<chS.length;j++){
					if(str.charAt(i)==chS[j]){
						num+=chN[j];
						break;
					}
				}
			}
			String s="";
			for(int i=1;i<str.length();i++){
				s=""+str.charAt(i-1)+str.charAt(i);
				for(int j=0;j<strS.length;j++){
					if(s.equals(strS[j])){
						num-=strN[j];
						break;
					}
				}
			}
			System.out.println(num);
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
