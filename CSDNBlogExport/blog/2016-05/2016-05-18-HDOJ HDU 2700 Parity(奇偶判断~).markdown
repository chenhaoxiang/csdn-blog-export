---
layout: post
title: "HDOJ HDU 2700 Parity(奇偶判断~)"
date: 2016-05-18 11:53:04 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题,----- String
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
A bit string has odd parity if the number of 1’s is odd. A bit string has even parity if the number of 1’s is even.Zero is considered to be an even number, so a bit string with no 
---


Problem Description 
A bit string has odd parity if the number of 1’s is odd. A bit string has even parity if the number of 1’s is even.Zero is considered to be an even number, so a bit string with no
<!-- more -->
----------

Problem Description
A bit string has odd parity if the number of 1's is odd. A bit string has even parity if the number of 1's is even.Zero is considered to be an even number, so a bit string with no 1's has even parity. Note that the number of
0's does not affect the parity of a bit string.
 

Input
The input consists of one or more strings, each on a line by itself, followed by a line containing only "#" that signals the end of the input. Each string contains 1–31 bits followed by either a lowercase letter 'e' or a lowercase letter 'o'.

 

Output
Each line of output must look just like the corresponding line of input, except that the letter at the end is replaced by the correct bit so that the entire bit string has even parity (if the letter was 'e') or odd parity (if the letter was 'o').
 

Sample Input
101e
010010o
1e
000e
110100101o
#
 

Sample Output
1010
0100101
11
0000
1101001010


英文题~看懂题意就ok了。
e代表的是偶数奇偶性校验。
o代表的是奇数奇偶性校验。
0代表是。1代表否~
其实就是判断1的个数~


```
import java.util.Scanner;

/**
 * @author 陈浩翔
 */
public class Main{

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.next();
			if(str.equals("#")){
				return ;
			}
			int num=0;
			for(int i=0;i<str.length()-1;i++){
				if(str.charAt(i)=='1'){
					num++;
				}
			}
			if(num%2==0){//1出现的次数为偶数
				if(str.charAt(str.length()-1)=='e'){//偶数奇偶校验
					//0代表判断正确
					System.out.println(str.substring(0, str.length()-1)+'0');
				}else{
					System.out.println(str.substring(0, str.length()-1)+'1');
				}
			}else{
				if(str.charAt(str.length()-1)=='o'){//奇数奇偶校验
					//0代表判断正确
					System.out.println(str.substring(0, str.length()-1)+'0');
				}else{
					System.out.println(str.substring(0, str.length()-1)+'1');
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
