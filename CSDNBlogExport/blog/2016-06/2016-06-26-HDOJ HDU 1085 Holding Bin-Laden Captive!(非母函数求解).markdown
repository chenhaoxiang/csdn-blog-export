---
layout: post
title: "HDOJ HDU 1085 Holding Bin-Laden Captive!(非母函数求解)"
date: 2016-06-26 05:06:34 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 模拟/推导/打表
tags: [acm,java]
keyword: 陈浩翔, 谙忆
description: Problem Description 
We all know that Bin-Laden is a notorious terrorist, and he has disappeared for a long time. But recently, it is reported that he hides in Hang Zhou of China!  
“Oh, God! How terri 
---


Problem Description 
We all know that Bin-Laden is a notorious terrorist, and he has disappeared for a long time. But recently, it is reported that he hides in Hang Zhou of China!  
“Oh, God! How terri
<!-- more -->
----------

Problem Description
We all know that Bin-Laden is a notorious terrorist, and he has disappeared for a long time. But recently, it is reported that he hides in Hang Zhou of China! 
“Oh, God! How terrible! ”

![](http://img.blog.csdn.net/20160626170049649)

Don’t be so afraid, guys. Although he hides in a cave of Hang Zhou, he dares not to go out. Laden is so bored recent years that he fling himself into some math problems, and he said that if anyone can solve his problem, he will give himself up! 
Ha-ha! Obviously, Laden is too proud of his intelligence! But, what is his problem?
“Given some Chinese Coins (硬币) (three kinds-- 1, 2, 5), and their number is num_1, num_2 and num_5 respectively, please output the minimum value that you cannot pay with given coins.”
You, super ACMer, should solve the problem easily, and don’t forget to take $25000000 from Bush!

Input
Input contains multiple test cases. Each test case contains 3 positive integers num_1, num_2 and num_5 (0<=num_i<=1000). A test case containing 0 0 0 terminates the input and this test case is not to be processed.

Output
Output the minimum positive value that one cannot pay with given coins, one line for one case.

Sample Input
1 1 3
0 0 0
 
Sample Output
4


<font color="red" size="4">
题目大意：
给你1，2，5元的硬币数量，求没办法组成的最小的数。
</font>
分析：
因为还没学母函数，用了一般的知识求解。
1、当没有一元的硬币时，肯定就是1了。
2、当一元硬币和二元硬币无法组成1-4之间的所有数字时，那么不用考虑五元的硬币，这个时候最小的数字为a+2*b+1。
3、当前面2种情况都满足时，最大的数a+2*b+5*c以内的所有数字肯定都能取到，所以最小数为：a+2*b+5*c+1。


AC代码：

```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int a =sc.nextInt();
			int b=sc.nextInt();
			int c =sc.nextInt();
			if(a==0&&b==0&&c==0){
				break;
			}
			if(a==0){
				System.out.println(1);
			}else if( a+2*b<4 ){
				System.out.println(a+2*b+1);
			}else{
				System.out.println(a+b*2+5*c+1);
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
