---
layout: post
title: "HDOJ 2056 Rectangles"
date: 2016-01-28 08:20:33 +0800
comments: true
categories:----- HDOJ-JAVA,❶ ACM
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Given two rectangles and the coordinates of two points on the diagonals of each rectangle,you have to calculate the area of the intersected part of two rectangles. its sides are pa 
---


Problem Description 
Given two rectangles and the coordinates of two points on the diagonals of each rectangle,you have to calculate the area of the intersected part of two rectangles. its sides are pa
<!-- more -->
----------

Problem Description
Given two rectangles and the coordinates of two points on the diagonals of each rectangle,you have to calculate the area of the intersected part of two rectangles. its sides are parallel to OX and OY .
 

Input
Input The first line of input is 8 positive numbers which indicate the coordinates of four points that must be on each diagonal.The 8 numbers are x1,y1,x2,y2,x3,y3,x4,y4.That means the two points on the first rectangle are(x1,y1),(x2,y2);the other two points on the second rectangle are (x3,y3),(x4,y4).
 

Output
Output For each case output the area of their intersected part in a single line.accurate up to 2 decimal places.
 

Sample Input
1.00 1.00 3.00 3.00 2.00 2.00 4.00 4.00
5.00 5.00 13.00 13.00 4.00 4.00 12.50 12.50
 

Sample Output
1.00
56.25


题目大意：求两个矩形相交的面积，矩形的边均平行于坐标轴。

```

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			double[] x = new double[4];
			double[] y = new double[4];
			
			for(int i=0;i<x.length;i++){
				x[i] = sc.nextDouble();
				y[i] = sc.nextDouble();
			}
			
			if(x[1]<x[0]){
				double temp=x[0];
				x[0]=x[1];
				x[1]=temp;
			}
			if(y[1]<y[0]){
				double temp=y[0];
				y[0]=y[1];
				y[1]=temp;
			}
			
			if(x[3]<x[2]){
				double temp=x[3];
				x[3]=x[2];
				x[2]=temp;
			}
			
			if(y[3]<y[2]){
				double temp=y[3];
				y[3]=y[2];
				y[2]=temp;
			}
			
			
			double x1 = max(x[0],x[2]);
			double y1 = max(y[0],y[2]);
			double x2 = min(x[1],x[3]);
			double y2 = min(y[1],y[3]);
			
			if(x1>x2||y1>y2){
				System.out.println("0.00");
				continue;
			}else{
				System.out.printf("%.2f",(x2-x1)*(y2-y1));
				System.out.println();
			}
			
			
		}
		
		
	}

	private static double min(double d, double e) {
		if(d<e){
			return d;
		}
		return e;
	}

	private static double max(double d, double e) {
		if(d>e){
			return d;
		}
		return e;
	}

}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
