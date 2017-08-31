---
layout: post
title: "HDOJ HDU 2560 Buildings(嗯~水题)"
date: 2016-05-17 08:34:48 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
We divide the HZNU Campus into N*M grids. As you can see from the picture below, the green grids represent the buidings. Given the size of the HZNU Campus, and the color of each gr 
---


Problem Description 
We divide the HZNU Campus into N*M grids. As you can see from the picture below, the green grids represent the buidings. Given the size of the HZNU Campus, and the color of each gr
<!-- more -->
----------

Problem Description
We divide the HZNU Campus into N*M grids. As you can see from the picture below, the green grids represent the buidings. Given the size of the HZNU Campus, and the color of each grid, you should count how many green grids in the N*M grids.

![](http://img.blog.csdn.net/20160517203322300)

 

Input
Standard input will contain multiple test cases. The first line of the input is a single integer T which is the number of test cases. T test cases follow. 
The first line of each test case contains two integers n and m(1<=n,m<=100), the size of the campus. Then follow n lines, each line containing m integers. The j-th integer in the i-th line is the color of that grid, 0 stands for white color, while 1 stands for green.


 

Output
Results should be directed to standard output. For each case, output an integers T, the total green grids in the N*M size campus.
 

Sample Input
2
2 2
1 1
0 0
3 3
1 0 1
0 0 1
1 1 0
 

Sample Output
2
5


水题一个~~
就是一个学校n*m的面积，然后有建筑~
1代表建筑，统计建筑的总数~


```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			int n =sc.nextInt();
			int m =sc.nextInt();
			int sum=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					int a =sc.nextInt();
					if(a==1){
						sum++;
					}
				}
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
