---
layout: post
title: "HDOJ HDU 2087 剪花布条(indexOf()应用~~)"
date: 2016-06-02 02:03:35 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题,----- String
tags: [java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
一块花布条，里面有些图案，另有一块直接可用的小饰条，里面也有一些图案。对于给定的花布条和小饰条，计算一下能从花布条中尽可能剪出几块小饰条来呢？Input 
输入中含有一些数据，分别是成对出现的花布条和小饰条，其布条都是用可见ASCII字符表示的，可见的ASCII字符有多少个，布条的花纹也有多少种花样。花纹条和小饰条不会超过1000个字符长。如果遇见#字符，则 
---


Problem Description 
一块花布条，里面有些图案，另有一块直接可用的小饰条，里面也有一些图案。对于给定的花布条和小饰条，计算一下能从花布条中尽可能剪出几块小饰条来呢？Input 
输入中含有一些数据，分别是成对出现的花布条和小饰条，其布条都是用可见ASCII字符表示的，可见的ASCII字符有多少个，布条的花纹也有多少种花样。花纹条和小饰条不会超过1000个字符长。如果遇见#字符，则
<!-- more -->
----------

Problem Description
一块花布条，里面有些图案，另有一块直接可用的小饰条，里面也有一些图案。对于给定的花布条和小饰条，计算一下能从花布条中尽可能剪出几块小饰条来呢？

 

Input
输入中含有一些数据，分别是成对出现的花布条和小饰条，其布条都是用可见ASCII字符表示的，可见的ASCII字符有多少个，布条的花纹也有多少种花样。花纹条和小饰条不会超过1000个字符长。如果遇见#字符，则不再进行工作。

 

Output
输出能从花纹布中剪出的最多小饰条个数，如果一块都没有，那就老老实实输出0，每个结果之间应换行。

 

Sample Input
abcde a3
aaaaaa  aa
#
 

Sample Output
0
3


<font color="red">
大水题！ 
Java用indexOf()方法秒过~
</font>

```
import java.util.Scanner;

/**
 * @author 陈浩翔
 * @version 1.0  2016-6-2
 */
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str =sc.next();
			if(str.equals("#")){
				return;
			}
			String a = sc.next();
			int sum=0;
			int i=0;
			int t=0;
			while(true){
				if(t==0){
					i=str.indexOf(a, i);
					t=1;
				}else{
					i=str.indexOf(a, i+a.length());
				}
				if(i==-1){
					break;
				}
				sum++;
			}
			System.out.println(sum);
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
