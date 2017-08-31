---
layout: post
title: "HDOJ 1391 Number Steps(打表DP)"
date: 2016-04-09 04:02:55 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 动态规划（DP）
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Starting from point (0,0) on a plane, we have written all non-negative integers 0, 1, 2,… as shown in the figure. For example, 1, 2, and 3 has been written at points (1,1), (2,0), 
---


Problem Description 
Starting from point (0,0) on a plane, we have written all non-negative integers 0, 1, 2,… as shown in the figure. For example, 1, 2, and 3 has been written at points (1,1), (2,0),
<!-- more -->
----------

Problem Description
Starting from point (0,0) on a plane, we have written all non-negative integers 0, 1, 2,... as shown in the figure. For example, 1, 2, and 3 has been written at points (1,1), (2,0), and (3, 1) respectively and this pattern has continued.
![](http://img.blog.csdn.net/20160409155910173)




You are to write a program that reads the coordinates of a point (x, y), and writes the number (if any) that has been written at that point. (x, y) coordinates in the input are in the range 0...5000.

 

Input
The first line of the input is N, the number of test cases for this problem. In each of the N following lines, there is x, and y representing the coordinates (x, y) of a point.

 

Output
For each point in the input, write the number written at that point or write No Number if there is none.

 

Sample Input
3
4 2
6 6
3 4
 

Sample Output
6
12
No Number


不能直接开[5005][5005]的数组，这样内存不够。
因为大部分数据没用，没列只有2个有效数据，所以开[5005][2]就可以了。

```
import java.util.Scanner;

public class Main{
	static int[][] db = new int[5005][2];
	public static void main(String[] args) {
		dabiao();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(x==0&&y==0){
				System.out.println(0);
				continue;
			}
			
			if(x==1&&y!=1){
				System.out.println("No Number");
				continue;
			}
			
			if(x==1&&y==1){
				System.out.println(1);
				continue;
			}
			
			if(x==y||x==(y+2)){
				if(x==(y+2)){
					System.out.println(db[x][0]);
				}else{
					System.out.println(db[x][1]);
				}
			}else{
				System.out.println("No Number");
			}
		}
	}

	private static void dabiao() {
		int num=2;
		db[0][0]=0;
		boolean is = true;
		for(int i=2;i<=5003;i++){
			if(is){
				db[i][0]=num;
				num++;
				db[i+1][0]=num;
				num++;
				is=!is;
			}else if(!is){
				db[i-1][1]=num;
				num++;
				db[i][1]=num;
				num++;
				is=!is;
			}
		}
//		System.out.println(db[2][0]);
//		System.out.println(db[2][1]);
//		System.out.println(db[3][0]);
//		System.out.println(db[3][1]);
//		System.out.println(db[4][0]);
//		System.out.println(db[4][1]);
//		System.out.println(db[5][0]);
//		System.out.println(db[5][1]);
	}
}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
