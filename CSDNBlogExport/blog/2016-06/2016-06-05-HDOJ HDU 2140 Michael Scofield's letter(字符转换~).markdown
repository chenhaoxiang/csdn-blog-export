---
layout: post
title: "HDOJ HDU 2140 Michael Scofield's letter(字符转换~)"
date: 2016-06-05 12:21:30 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- String,----- 基础题
tags: [java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
I believe many people are the fans of prison break. How clever Michael is!! In order that the message won’t be found by FBI easily, he usually send code letters to Sara by a paper 
---


Problem Description 
I believe many people are the fans of prison break. How clever Michael is!! In order that the message won’t be found by FBI easily, he usually send code letters to Sara by a paper
<!-- more -->
----------

Problem Description
I believe many people are the fans of prison break. How clever Michael is!! In order that the message won't be found by FBI easily, he usually send code letters to Sara by a paper crane. Hence, the paper crane is Michael in the heart of Sara. Now can you write a program to help Sara encode the letter from Michael easily?
The letter from Michael every time is a string of lowercase letters. You should encode letters as the rules below:
b is ' ', q is ',', t is '!', m is l, i is e, c is a, a is c, e is i, l is m. It is interesting. Are you found that it is just change michael to leahcim?
 

Input
The input will consist of several cases, one per line.
Each case is a letter from Michael, the letteres won't exceed 10000.

 

Output
For each case, output the encode letter one line.

 

Sample Input
pmicsibforgevibliqbscrct
ebmovibyout
 

Sample Output
please forgive me, sara!
i love you!


<font color="red" size="4">
就是输入一行字符串，然后根据b is '空格', q is ',', t is '!', m is l, i is e, c is a, a is c, e is i, l is m.来转换，输出转换之后的字符串！
在这里，我用Map来存储需要转换的字符，然后查找输出。
</font>

```
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('b', ' ');
		map.put('q', ',');
		map.put('t', '!');
		map.put('m', 'l');
		map.put('i', 'e');
		map.put('c', 'a');
		map.put('a', 'c');
		map.put('e', 'i');
		map.put('l', 'm');
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str=sc.next();
			for(int i=0;i<str.length();i++){
				if(map.get(str.charAt(i))!=null){
					System.out.print(map.get(str.charAt(i)));
				}else{
					System.out.print(str.charAt(i));
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
