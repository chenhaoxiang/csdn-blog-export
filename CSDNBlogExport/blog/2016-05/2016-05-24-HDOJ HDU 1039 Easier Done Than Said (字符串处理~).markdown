---
layout: post
title: "HDOJ HDU 1039 Easier Done Than Said (字符串处理~)"
date: 2016-05-24 04:53:54 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- String
tags: [java,acm,字符串]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Password security is a tricky thing. Users prefer simple passwords that are easy to remember (like buddy), but such passwords are often insecure. Some sites use random computer-gen 
---


Problem Description 
Password security is a tricky thing. Users prefer simple passwords that are easy to remember (like buddy), but such passwords are often insecure. Some sites use random computer-gen
<!-- more -->
----------

Problem Description
Password security is a tricky thing. Users prefer simple passwords that are easy to remember (like buddy), but such passwords are often insecure. Some sites use random computer-generated passwords (like xvtpzyo), but users have a hard time remembering them and sometimes leave them written on notes stuck to their computer. One potential solution is to generate "pronounceable" passwords that are relatively secure but still easy to remember.

FnordCom is developing such a password generator. You work in the quality control department, and it's your job to test the generator and make sure that the passwords are acceptable. To be acceptable, a password must satisfy these three rules:

It must contain at least one vowel.

It cannot contain three consecutive vowels or three consecutive consonants.

It cannot contain two consecutive occurrences of the same letter, except for 'ee' or 'oo'.

(For the purposes of this problem, the vowels are 'a', 'e', 'i', 'o', and 'u'; all other letters are consonants.) Note that these rules are not perfect; there are many common/pronounceable words that are not acceptable.

 

Input
The input consists of one or more potential passwords, one per line, followed by a line containing only the word 'end' that signals the end of the file. Each password is at least one and at most twenty letters long and consists only of lowercase letters.

 

Output
For each password, output whether or not it is acceptable, using the precise format shown in the example.

 

Sample Input
a
tv
ptoui
bontres
zoggax
wiinq
eep
houctuh
end
 

Sample Output
```
<a> is acceptable.
<tv> is not acceptable.
<ptoui> is not acceptable.
<bontres> is not acceptable.
<zoggax> is not acceptable.
<wiinq> is not acceptable.
<eep> is acceptable.
<houctuh> is acceptable.
```

题意：
密码必须满足这三个规则：
它必须包含至少一个元音。
它不能包含三个连续的元音或三个辅音。
它不能包含两个连续的相同的字母，除了“EE”或“oo”。
（为了这个问题，元音“A”、“E”、“我”、“O”、和“U”；其他所有的字母都是辅音字母。）注意，这些规则是不完善的；有很多常用的发音的话，是不可接受的。

输入end结束输入~不需要输出。

满足的输出：** is acceptable.
否则输出：** is not acceptable.


```
import java.util.Scanner;

public class Main{
	static String[] vowel = {"a","e","i","o","u"};
	static String[] eq = {"aa","bb","cc","dd","ff","gg","hh","ii","jj","kk","ll","mm",
		"nn","pp","qq","rr","ss","tt","uu","vv","ww","xx","yy","zz"};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str=sc.next();
			if("end".equals(str)){
				return;
			}
			boolean isAcceptable=true;
			int num=-1;
			for(int i=0;i<vowel.length;i++){
				if(num==-1){
					num=str.indexOf(vowel[i]);
				}
			}
			if(num==-1){
				System.out.println("<"+str+">"+" is not acceptable.");
				continue;
			}
			
			for(int i=0;i<eq.length;i++){
				if(str.indexOf(eq[i])!=-1){
					isAcceptable=false;
					break;
				}
			}
			
			if(!isAcceptable){
				System.out.println("<"+str+">"+" is not acceptable.");
				continue;
			}
			
			for(int i=0;i<str.length()-2;i++){
				int Vowel1=0;
				int Vowel2=0;
				int Vowel3=0;
				for(int k=0;k<vowel.length;k++){
					if(str.charAt(i)==vowel[k].charAt(0)){
						Vowel1=1;
					}
				}
				for(int k=0;k<vowel.length;k++){
					if(str.charAt(i+1)==vowel[k].charAt(0)){
						Vowel2=1;
					}
				}
				for(int k=0;k<vowel.length;k++){
					if(str.charAt(i+2)==vowel[k].charAt(0)){
						Vowel3=1;
					}
				}
				if(Vowel1==Vowel2&&Vowel1==Vowel3){
					isAcceptable=false;
					break;
				}
			}
			
			if(!isAcceptable){
				System.out.println("<"+str+">"+" is not acceptable.");
				continue;
			}
			
			System.out.println("<"+str+">"+" is acceptable.");
			
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
