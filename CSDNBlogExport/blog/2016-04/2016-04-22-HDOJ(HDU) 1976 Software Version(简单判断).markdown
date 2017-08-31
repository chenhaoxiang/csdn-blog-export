---
layout: post
title: "HDOJ(HDU) 1976 Software Version(简单判断)"
date: 2016-04-22 09:19:42 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
相信大家一定有过在网上下载软件而碰到多个不同版本的情况。一般来说，软件的版本号由三个部分组成，主版本号（Major Version Number），子版本号（Minor Version Number)和修订号（Revision_Number）。当软件进行了重大的修改时，主版本号加一；当软件在原有基础上增加部分功能时，主版本号不变，子版本号加一；当软件仅仅修正 
---


Problem Description 
相信大家一定有过在网上下载软件而碰到多个不同版本的情况。一般来说，软件的版本号由三个部分组成，主版本号（Major Version Number），子版本号（Minor Version Number)和修订号（Revision_Number）。当软件进行了重大的修改时，主版本号加一；当软件在原有基础上增加部分功能时，主版本号不变，子版本号加一；当软件仅仅修正
<!-- more -->
----------

Problem Description
相信大家一定有过在网上下载软件而碰到多个不同版本的情况。

一般来说，软件的版本号由三个部分组成，主版本号（Major Version Number），子版本号（Minor Version Number)和修订号（Revision_Number）。当软件进行了重大的修改时，主版本号加一；当软件在原有基础上增加部分功能时，主版本号不变，子版本号加一；当软件仅仅修正了部分bug时，主版本号和子版本号都不变，修正号加一。
在我们比较软件的两个版本的新旧时，都是先比较主版本号，当主版本号相同时再比较子版本号，前两者都相同的情况下再比较修正号。版本号越大的软件越新。

现在，Lele 在载软件的时候碰到了两个版本，请你告诉他哪个版本更新一些。
 

Input
输入的第一行有一个整数T，代表有T组测试。接下来有T组测试。
每组测试分两行，第一行有三个整数代表第一个软件版本的主版本号，子版本号和修订号。第二行也有三个整数代表第二个软件版本的主版本号，子版本号和修订号。

数据中出现的整数都在[0,1000]范围之内。
 

Output
对于每组测试，如果第一个软件的版本新点，请输出"First"，如果第二个软件的版本新点，请输出"Second"，否则输出"Same"。 

 

Sample Input
3
1 1 0
1 1 1
1 1 1
1 1 0
1 1 1
1 1 1
 

Sample Output
Second
First
Same


就是简单的比较！从主版本开始比较。。。

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
			int a3 = sc.nextInt();
			int b1 = sc.nextInt();
			int b2 = sc.nextInt();
			int b3 = sc.nextInt();
			//卫条件！！！
			if(a1>b1){
				System.out.println("First");
				continue;
			}
			if(a1<b1){
				System.out.println("Second");
				continue;
			}
			if(a2>b2){
				System.out.println("First");
				continue;
			}
			if(a2<b2){
				System.out.println("Second");
				continue;
			}
			if(a3>b3){
				System.out.println("First");
				continue;
			}
			if(a3<b3){
				System.out.println("Second");
				continue;
			}
			//那么肯定是相等了。
			System.out.println("Same");
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
