---
layout: post
title: "HDOJ HDU 1161 Eddy's mistakes(大写字母转换成小写字母)"
date: 2016-05-27 03:21:12 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- String,----- 基础题
tags: [字母,acm,java]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Eddy usually writes articles ,but he likes mixing the English letter uses, for example “computer science” is written frequently “coMpUtEr scIeNce” by him, this mistakes lets Eddy’s 
---


Problem Description 
Eddy usually writes articles ,but he likes mixing the English letter uses, for example “computer science” is written frequently “coMpUtEr scIeNce” by him, this mistakes lets Eddy’s
<!-- more -->
----------

Problem Description
Eddy usually writes articles ,but he likes mixing the English letter uses, for example "computer science" is written frequently "coMpUtEr scIeNce" by him, this mistakes lets Eddy's English teacher be extremely discontentment.Now please you to write a procedure to be able in the Bob article English letter to turn completely the small letter. 

 

Input
The input contains several test cases.each line consists a test case，Expressed Eddy writes in an article , by letter, blank space,numeral as well as each kind of punctuation
composition, the writing length does not surpass 1000 characters.

 

Output
For each test case, you should output an only line, after namely the result of transforms the lowercase letter.

 

Sample Input
weLcOmE tO HDOj Acm 2005!
 

Sample Output
welcome to hdoj acm 2005!


恩。。大水题~如题，就是把大写字母转换成小写字母。


```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(sc.hasNext()){
			String str =sc.nextLine();
			System.out.println(str.toLowerCase());
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
