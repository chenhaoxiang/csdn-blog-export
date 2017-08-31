---
layout: post
title: "HDOJ HDU 2163 Palindromes(判断回文串~)"
date: 2016-06-05 12:50:02 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 逆序数和回文串,----- 基础题
tags: [java,acm,回文串]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Write a program to determine whether a word is a palindrome. A palindrome is a sequence of characters that is identical to the string when the characters are placed in reverse orde 
---


Problem Description 
Write a program to determine whether a word is a palindrome. A palindrome is a sequence of characters that is identical to the string when the characters are placed in reverse orde
<!-- more -->
----------

**Problem Description**
Write a program to determine whether a word is a palindrome. A palindrome is a sequence of characters that is identical to the string when the characters are placed in reverse order. For example, the following strings are palindromes: “ABCCBA”, “A”, and “AMA”. The following strings are not palindromes: “HELLO”, “ABAB” and “PPA”. 

 

**Input**
The input file will consist of up to 100 lines, where each line contains at least 1 and at most 52 characters. Your program should stop processing the input when the input string equals “STOP”. You may assume that input file consists of exclusively uppercase letters; no lowercase letters, punctuation marks, digits, or whitespace will be included within each word. 

 

**Output**
A single line of output should be generated for each string. The line should include “#”, followed by the problem number, followed by a colon and a space, followed by the string “YES” or “NO”. 

 

**Sample Input**
ABCCBA
A
HELLO
ABAB
AMA
ABAB
PPA
STOP
 

Sample Output

```
#1: YES
#2: YES
#3: NO
#4: NO
#5: YES
#6: NO
#7: NO
```

<font color="red" size="4">
就是简单的判断回文串的问题，遇到STOP结束程序。
</font>


```
import java.util.Scanner;

/**
 * @author 陈浩翔
 * 2016-6-5
 */
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =1;
		while(sc.hasNext()){
			String str =sc.next();
			if("STOP".equals(str)){
				return;
			}
			System.out.print("#"+(t++)+": ");
			boolean isProgram = true;
			for(int i=0,j=str.length()-1;i<j;i++,j--){
				if(str.charAt(i)!=str.charAt(j)){
					isProgram=false;
					break;
				}
			}
			if(isProgram){
				System.out.println("YES");
			}else{
				System.out.println("NO");
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
