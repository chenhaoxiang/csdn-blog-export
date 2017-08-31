---
layout: post
title: "HDOJ HDU 1804 Deli Deli(英语单词复数形式~)"
date: 2016-06-02 11:40:23 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- String,----- 基础题
tags: [java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Mrs. Deli is running the delicatessen store “Deli Deli”. Last year Mrs. Deli has decided to expand her business and build up an online store. She has hired a programmer who has imp 
---


Problem Description 
Mrs. Deli is running the delicatessen store “Deli Deli”. Last year Mrs. Deli has decided to expand her business and build up an online store. She has hired a programmer who has imp
<!-- more -->
----------

Problem Description
Mrs. Deli is running the delicatessen store "Deli Deli". Last year Mrs. Deli has decided to expand her business and build up an online store. She has hired a programmer who has implemented the online store. 

Recently some of her new online customers complained about the electronic bills. The programmer had forgotten to use the plural form in case that an item is purchased multiple times. Unfortunaly the programmer of Mrs. Deli is on holiday and now it is your task to implement this feature for Mrs. Deli. Here is a description how to make the plural form: 

1. If the word is in the list of irregular words replace it with the given plural. 
2. Else if the word ends in a consonant followed by "y", replace "y" with "ies". 
3. Else if the word ends in "o", "s", "ch", "sh" or "x", append "es" to the word. 
4. Else append "s" to the word. 

 

Input
The first line of the input file consists of two integers L and N (0 ≤ L ≤ 20, 1 ≤ N ≤ 100). The following L lines contain the description of the irregular words and their plural form. Each line consists of two words separated by a space character, where the first word is the singular, the second word the plural form of some irregular word. After the list of irregular words, the following N lines contain one word each, which you have to make plural. You may assume that each word consists of at most 20 lowercase letters from the english alphabet ('a' to 'z'). 


 

Output
Print N lines of output, where the ith line is the plural form of the ith input word. 


 

Sample Input
3 7
rice rice
spaghetti spaghetti
octopus octopi
rice
lobster
spaghetti
strawberry
octopus
peach
turkey
 

Sample Output
rice
lobsters
spaghetti
strawberries
octopi
peaches
turkeys


<font color='red' size='4'>
题意：
输出单词的复数形式。
有些是特殊变化的，事先给你。
如果是以辅音字母加y结尾的，改y为i再加es。
如果是以"o", "s", "ch", "sh" or "x",结尾的，直接加es。
其他的直接加s。
</font>
<font color='red' size='4'>用Map存储特殊的变化单词。再模拟处理就OK。
</font>

```

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Main{


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n =sc.nextInt();
			int m =sc.nextInt();
			Map<String, String> map = new HashMap<String, String>();
			for(int i=0;i<n;i++){
				String a = sc.next();
				String b = sc.next();
				map.put(a, b);
			}
			for(int i=0;i<m;i++){
				String str=sc.next();
				if(map.get(str)!=null){
					System.out.println(map.get(str));
				}else{
					char a = str.charAt(str.length()-2);
					char b= str.charAt(str.length()-1);
					if(a!='a'&&a!='e'&&a!='i'&&a!='o'&&a!='u'&&str.charAt(str.length()-1)=='y'){
						for(int k=0;k<str.length()-1;k++){
							System.out.print(str.charAt(k));
						}
						System.out.println("ies");
					}else if((a=='c'&&b=='h')||(a=='s'&&b=='h')||b=='o'||b=='s'||b=='x'){
						for(int k=0;k<str.length();k++){
							System.out.print(str.charAt(k));
						}
						System.out.println("es");
					}else{
						for(int k=0;k<str.length();k++){
							System.out.print(str.charAt(k));
						}
						System.out.println("s");
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
