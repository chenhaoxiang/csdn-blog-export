---
layout: post
title: "HDOJ HDU 1062 Text Reverse(字符串翻转~)"
date: 2016-05-25 04:53:21 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- String
tags: [java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Ignatius likes to write words in reverse way. Given a single line of text which is written by Ignatius, you should reverse all the words and then output them.Input 
The input conta 
---


Problem Description 
Ignatius likes to write words in reverse way. Given a single line of text which is written by Ignatius, you should reverse all the words and then output them.Input 
The input conta
<!-- more -->
----------

Problem Description
Ignatius likes to write words in reverse way. Given a single line of text which is written by Ignatius, you should reverse all the words and then output them.

 

Input
The input contains several test cases. The first line of the input is a single integer T which is the number of test cases. T test cases follow.
Each test case contains a single line with several words. There will be at most 1000 characters in a line.

 

Output
For each test case, you should output the text which is processed.

 

Sample Input
3
olleh !dlrow
m'I morf .udh
I ekil .mca
 

Sample Output
hello world!
I'm from hdu.
I like acm.

Hint
Remember to use getchar() to read '\n' after the interger T, then you may use gets() to read a line and process it.



题意：
输入一行字符串，将每一个单词(只有空格隔开)倒序输出！

注意：
开始和结尾可能有多个空格，单词之间可能有多个空格！

PE的请注意：空格必须照原样输出！有几个输出几个，不能多输出也不能少输出！


```
import java.util.Scanner;

/**
 * @author 陈浩翔
 * 2016-5-25
 */
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		sc.nextLine();//读取输入t之后的回车
		while(t-->0){
			String str=sc.nextLine();
			String s[] = str.split(" ");
			String str2="";
			for(int i=0;i<s.length;i++){
				for(int k=s[i].length()-1;k>=0;k--){
					System.out.print(s[i].charAt(k));
					str2+=s[i].charAt(k);
				}
				if(i!=s.length-1){
					System.out.print(" ");
					str2+=" ";
				}
			}
			for(int i=str2.length();i<str.length();i++){
				System.out.print(" ");
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
