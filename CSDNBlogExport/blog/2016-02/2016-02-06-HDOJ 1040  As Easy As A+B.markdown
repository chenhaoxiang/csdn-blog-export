---
layout: post
title: "HDOJ 1040  As Easy As A+B"
date: 2016-02-06 01:56:50 +0800
comments: true
categories:----- HDOJ-JAVA,❶ ACM,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
These days, I am thinking about a question, how can I get a problem as easy as A+B? It is fairly difficulty to do such a thing. Of course, I got it after many waking nights. 
Give 
---


Problem Description 
These days, I am thinking about a question, how can I get a problem as easy as A+B? It is fairly difficulty to do such a thing. Of course, I got it after many waking nights. 
Give
<!-- more -->
----------


Problem Description
These days, I am thinking about a question, how can I get a problem as easy as A+B? It is fairly difficulty to do such a thing. Of course, I got it after many waking nights.
Give you some integers, your task is to sort these number ascending (升序).
You should know how easy the problem is now!
Good luck!

 

Input
Input contains multiple test cases. The first line of the input is a single integer T which is the number of test cases. T test cases follow. Each test case contains an integer N (1<=N<=1000 the number of integers to be sorted) and then N integers follow in the same line. 
It is guarantied that all integers are in the range of 32-int.

 

Output
For each case, print the sorting result, and one line one case.

 

Sample Input
2
3 2 1 3
9 1 4 7 2 5 8 3 6 9
 

Sample Output
1 2 3
1 2 3 4 5 6 7 8 9


就是排序！按照升序排


```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int m = sc.nextInt();
			int[] a = new int[m];
			for(int i=0;i<m;i++){
				a[i]=sc.nextInt();
			}
			
			for(int i=0;i<m-1;i++){
				for(int j=i+1;j<m;j++){
					if(a[j]<a[i]){
						int temp=a[j];
						a[j]=a[i];
						a[i]=temp;
					}
				}
			}
			
			System.out.print(a[0]);
			for(int i=1;i<m;i++){
				System.out.print(" "+a[i]);
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
