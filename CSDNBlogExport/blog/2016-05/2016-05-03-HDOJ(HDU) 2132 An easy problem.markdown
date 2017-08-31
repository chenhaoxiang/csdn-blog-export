---
layout: post
title: "HDOJ(HDU) 2132 An easy problem"
date: 2016-05-03 05:32:10 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
We once did a lot of recursional problem . I think some of them is easy for you and some if hard for you. 
Now there is a very easy problem . I think you can AC it. 
  We can defin 
---


Problem Description 
We once did a lot of recursional problem . I think some of them is easy for you and some if hard for you. 
Now there is a very easy problem . I think you can AC it. 
  We can defin
<!-- more -->
----------

Problem Description
We once did a lot of recursional problem . I think some of them is easy for you and some if hard for you.
Now there is a very easy problem . I think you can AC it.
  We can define sum(n) as follow:
  if i can be divided exactly by 3 sum(i) = sum(i-1) + i*i*i;else sum(i) = sum(i-1) + i;
  Is it very easy ? Please begin to program to AC it..-_-
 

Input
  The input file contains multilple cases.
  Every cases contain only ont line, every line contains a integer n (n<=100000).
  when n is a negative indicate the end of file.
 

Output
  output the result sum(n).

 

Sample Input
1
2
3
-1

 

Sample Output
1
3
30

水题。。注意范围。！！！java用long型可以AC，只是注意中间计算结果也有可能溢出int型范围，也要转换为long才行。
还有，注意判断条件退出不是输入-1，而是输入小于0的数就是退出了。

```
import java.util.Scanner;

public class Main{
	static long db[] = new long[100001];
	public static void main(String[] args) {
		dabiao();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n =sc.nextInt();
			if(n<0){
				return;
			}
			System.out.println(db[n]);
		}
	}
	private static void dabiao() {
		db[1]=1;
		db[2]=3;
		for(int i=3;i<db.length;i++){
			if(i%3==0){
				db[i]=db[i-1]+i*(long)i*i;
				//这里的i*i要强转成long，long*int还是long，否则i*i*i会超int范围
			}else{
				db[i]=db[i-1]+i;
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
