---
layout: post
title: "HDOJ HDU 1328 IBM Minus One(水题一个，试试手)"
date: 2016-06-01 04:32:24 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题,----- String
tags: [java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
You may have heard of the book ‘2001 - A Space Odyssey’ by Arthur C. Clarke, or the film of the same name by Stanley Kubrick. In it a spaceship is sent from Earth to Saturn. The cr 
---


Problem Description 
You may have heard of the book ‘2001 - A Space Odyssey’ by Arthur C. Clarke, or the film of the same name by Stanley Kubrick. In it a spaceship is sent from Earth to Saturn. The cr
<!-- more -->
----------

Problem Description
You may have heard of the book '2001 - A Space Odyssey' by Arthur C. Clarke, or the film of the same name by Stanley Kubrick. In it a spaceship is sent from Earth to Saturn. The crew is put into stasis for the long flight, only two men are awake, and the ship is controlled by the intelligent computer HAL. But during the flight HAL is acting more and more strangely, and even starts to kill the crew on board. We don't tell you how the story ends, in case you want to read the book for yourself :-)

After the movie was released and became very popular, there was some discussion as to what the name 'HAL' actually meant. Some thought that it might be an abbreviation for 'Heuristic ALgorithm'. But the most popular explanation is the following: if you replace every letter in the word HAL by its successor in the alphabet, you get ... IBM.

Perhaps there are even more acronyms related in this strange way! You are to write a program that may help to find this out.

 

Input
The input starts with the integer n on a line by itself - this is the number of strings to follow. The following n lines each contain one string of at most 50 upper-case letters.

 

Output
For each string in the input, first output the number of the string, as shown in the sample output. The print the string start is derived from the input string by replacing every time by the following letter in the alphabet, and replacing 'Z' by 'A'.

Print a blank line after each test case.

 

Sample Input
2
HAL
SWERC
 

Sample Output
String #1
IBM

String #2
TXFSD


题意就是：输入一个大写的字符串，输出每一个大写字母后的一个大写字母。
如果遇到Z就输出A。
注意每一个测试后都有一个空行。

水题一个！


```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		int ti=0;
		while(t-->0){
			String str = sc.next();
			System.out.println("String #"+(++ti));
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)=='Z'){
					System.out.print("A");
				}else{
					System.out.print((char)(str.charAt(i)+1));
				}
			}
			System.out.println();
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
