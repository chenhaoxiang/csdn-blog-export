---
layout: post
title: "HDOJ HDU 1200 To and Fro(加密解密字符串)"
date: 2016-05-27 04:23:24 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 加密解密,----- String
tags: [解密,加密,acm,java]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Mo and Larry have devised a way of encrypting messages. They first decide secretly on the number of columns and write the message (letters only) down the columns, padding with extr 
---


Problem Description 
Mo and Larry have devised a way of encrypting messages. They first decide secretly on the number of columns and write the message (letters only) down the columns, padding with extr
<!-- more -->
----------

Problem Description
Mo and Larry have devised a way of encrypting messages. They first decide secretly on the number of columns and write the message (letters only) down the columns, padding with extra random letters so as to make a rectangular array of letters. For example, if the message is “There’s no place like home on a snowy night” and there are five columns, Mo would write down

t o i o y
h p k n n
e l e a i
r a h s g
e c o n h
s e m o t
n l e w x


Note that Mo includes only letters and writes them all in lower case. In this example, Mo used the character ‘x’ to pad the message out to make a rectangle, although he could have used any letter.

Mo then sends the message to Larry by writing the letters in each row, alternating left-to-right and right-to-left. So, the above would be encrypted as

toioynnkpheleaigshareconhtomesnlewx

Your job is to recover for Larry the original message (along with any extra padding letters) from the encrypted one.

 

Input
There will be multiple input sets. Input for each set will consist of two lines. The first line will contain an integer in the range 2. . . 20 indicating the number of columns used. The next line is a string of up to 200 lower case letters. The last input set is followed by a line containing a single 0, indicating end of input.

 

Output
Each input set should generate one line of output, giving the original plaintext message, with no spaces.

 

Sample Input
5
toioynnkpheleaigshareconhtomesnlewx
3
ttyohhieneesiaabss
0
 

Sample Output
theresnoplacelikehomeonasnowynightx
thisistheeasyoneab


水题。
译码还原问题

题目保证输入的数据一定是一个矩形的。

```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			if(n==0){
				return;
			}
			String str=sc.next();
			String s[] = new String[str.length()/n];
			for(int i=0;i<str.length()/n;i++){
				s[i]="";//不要忘记初始化
				if(i%2==0){
					for(int k=i*n;k<n+n*i;k++){
						s[i]=s[i]+str.charAt(k);
					}
				}else{
					for(int k=i*n;k<n+n*i;k++){
						s[i]=str.charAt(k)+s[i];
					}
				}
				//System.out.println(s[i]);
			}
			
			for(int i=0;i<n;i++){
				for(int k=0;k<s.length;k++){
					System.out.print(s[k].charAt(i));
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
