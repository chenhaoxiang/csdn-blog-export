---
layout: post
title: "HDOJ 1334 Perfect Cubes(暴力)"
date: 2016-04-08 11:13:02 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
For hundreds of years Fermat’s Last Theorem, which stated simply that for n > 2 there exist no integers a, b, c > 1 such that a^n = b^n + c^n, has remained elusively unproven. (A r 
---


Problem Description 
For hundreds of years Fermat’s Last Theorem, which stated simply that for n > 2 there exist no integers a, b, c > 1 such that a^n = b^n + c^n, has remained elusively unproven. (A r
<!-- more -->
----------

Problem Description
For hundreds of years Fermat's Last Theorem, which stated simply that for n > 2 there exist no integers a, b, c > 1 such that a^n = b^n + c^n, has remained elusively unproven. (A recent proof is believed to be correct, though it is still undergoing scrutiny.) It is possible, however, to find integers greater than 1 that satisfy the ``perfect cube'' equation a^3 = b^3 + c^3 + d^3 (e.g. a quick calculation will show that the equation 12^3 = 6^3 + 8^3 + 10^3 is indeed true). This problem requires that you write a program to find all sets of numbers {a, b, c, d} which satisfy this equation for a <= 200. 

 

Output
The output should be listed as shown below, one perfect cube per line, in non-decreasing order of a (i.e. the lines should be sorted by their a values). The values of b, c, and d should also be listed in non-decreasing order on the line itself. There do exist several values of a which can be produced from multiple distinct sets of b, c, and d triples. In these cases, the triples with the smaller b values should be listed first. 

The first part of the output is shown here: 

Cube = 6, Triple = (3,4,5)
Cube = 12, Triple = (6,8,10)
Cube = 18, Triple = (2,12,16)
Cube = 18, Triple = (9,12,15)
Cube = 19, Triple = (3,10,18)
Cube = 20, Triple = (7,14,17)
Cube = 24, Triple = (12,16,20)

Note: The programmer will need to be concerned with an efficient implementation. The official time limit for this problem is 2 minutes, and it is indeed possible to write a solution to this problem which executes in under 2 minutes on a 33 MHz 80386 machine. Due to the distributed nature of the contest in this region, judges have been instructed to make the official time limit at their site the greater of 2 minutes or twice the time taken by the judge's solution on the machine being used to judge this problem.


题意：n在[2,200]的范围，都是整数
     找出所有的n*n*n=a*a*a+b*b*b+c*c*c;
     （<2a<=b<=c<200）
直接暴力做！
注意的只有格式：=号两边都有空格，第一个逗号后面有一个空格。


```
public class Main{
	public static void main(String[] args) {
		for(int m=6;m<=200;m++){
			
			int mt = m*m*m;
			int at;
			int bt;
			int ct;
			for(int a=2;a<m;a++){
				at=a*a*a;
				
				for(int b=a;b<m;b++){
					bt = b*b*b;
					//适当的防范一下，提高效率
					if(at+bt>mt){
						break;
					}
					
					for(int c=b;c<m;c++){
						ct=c*c*c;
						
						//适当的防范一下，提高效率
						if(at+bt+ct>mt){
							break;
						}
						
						if(mt==(at+bt+ct)){
							System.out.println("Cube = "+m+", Triple = ("+a+","+b+","+c+")");
						}


					}
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
