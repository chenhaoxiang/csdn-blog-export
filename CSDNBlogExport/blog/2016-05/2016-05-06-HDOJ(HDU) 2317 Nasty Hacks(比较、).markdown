---
layout: post
title: "HDOJ(HDU) 2317 Nasty Hacks(比较、)"
date: 2016-05-06 08:56:44 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
You are the CEO of Nasty Hacks Inc., a company that creates small pieces of malicious software which teenagers may use 
to fool their friends. The company has just finished their f 
---


Problem Description 
You are the CEO of Nasty Hacks Inc., a company that creates small pieces of malicious software which teenagers may use 
to fool their friends. The company has just finished their f
<!-- more -->
----------

Problem Description
You are the CEO of Nasty Hacks Inc., a company that creates small pieces of malicious software which teenagers may use
to fool their friends. The company has just finished their first product and it is time to sell it. You want to make as much money as possible and consider advertising in order to increase sales. You get an analyst to predict the expected revenue, both with and without advertising. You now want to make a decision as to whether you should advertise or not, given the expected revenues.


 

Input
The input consists of n cases, and the first line consists of one positive integer giving n. The next n lines each contain 3 integers, r, e and c. The first, r, is the expected revenue if you do not advertise, the second, e, is the expected revenue if you do advertise, and the third, c, is the cost of advertising. You can assume that the input will follow these restrictions: -106 ≤ r, e ≤ 106 and 0 ≤ c ≤ 106.
 

Output
Output one line for each test case: “advertise”, “do not advertise” or “does not matter”, presenting whether it is most profitable to advertise or not, or whether it does not make any difference.
 

Sample Input
3
0 100 70
100 130 30
-100 -70 40
 

Sample Output
advertise
does not matter
do not advertise


嗯。。水题。。

题意就是输入的：
第一个数a是：做研发能赚多少钱，负数代表亏多少钱。
第二个数b是：做广告能赚多少钱。
第三个数c是：做广告的成本。
也就是比较a和(b+c)谁大谁小，还是相等。
如果a大：输出：do not advertise
如果a小：输出：advertise
如果一样大：输出：does not matter


```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			int a =sc.nextInt();
			int b =sc.nextInt();
			int c =sc.nextInt();
			
			if(a==(b-c)){
				System.out.println("does not matter");
			}else if(a>(b-c)){
				System.out.println("do not advertise");
			}else{
				System.out.println("advertise");
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
