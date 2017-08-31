---
layout: post
title: "HDOJ 1202 The calculation of GPA"
date: 2016-04-03 01:24:51 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
每学期的期末，大家都会忙于计算自己的平均成绩，这个成绩对于评奖学金是直接有关的。国外大学都是计算GPA(grade point average) 又称GPR(grade point ratio)，即成绩点数与学分的加权平均值来代表一个学生的成绩的。那么如何来计算GPA呢？ 一般大学采用之计分法 A90 - 100 4 点  
B80 - 89 3 点  
C 
---


Problem Description 
每学期的期末，大家都会忙于计算自己的平均成绩，这个成绩对于评奖学金是直接有关的。国外大学都是计算GPA(grade point average) 又称GPR(grade point ratio)，即成绩点数与学分的加权平均值来代表一个学生的成绩的。那么如何来计算GPA呢？ 一般大学采用之计分法 A90 - 100 4 点  
B80 - 89 3 点  
C
<!-- more -->
----------

Problem Description
每学期的期末，大家都会忙于计算自己的平均成绩，这个成绩对于评奖学金是直接有关的。国外大学都是计算GPA(grade point average) 又称GPR(grade point ratio)，即成绩点数与学分的加权平均值来代表一个学生的成绩的。那么如何来计算GPA呢？ 

一般大学采用之计分法 

A90 - 100 4 点 
B80 - 89 3 点 
C70 - 79 2 点 
D60 - 69 1 点 
E0 - 59 0 点 

例如：某位学生修习三门课，其课目、学分及成绩分别为： 
英文：三学分、92 分；化学：五学分、80 分；数学：二学分、60分，则GPA的算法如下： 

科目 学分 分数 点数 分数×点数 
英文  3    92    4     12
化学  5    80    3     15
数学  2    60    1      2
合计  10   29 
29/10=2.9 
2.9即为某生的GPA 
下面有请你写一个用于计算GPA的程序。

 

Input
包含多组数据，每组数据的第一行有一个数N，接下来N行每行表示一门成绩。每行有两个实型的数 s,p，s表示这门课的学分,p表示该学生的成绩（百分制）。如果p=-1则说明该学生这门课缺考，是不应该计算在内的。

 

Output
对每组数据输出一行，表示该学生的GPA，保留两位小数。如果GPA不存在，输出-1。

 

Sample Input
3
3 92
5 80
2 60
 

Sample Output
2.90

注意：成绩和学分都可以是小数的！！！

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			double a[][] = new double[n+1][3];
			for(int i=0;i<n;i++){
				a[i][0]=sc.nextDouble();
				a[i][1]=sc.nextDouble();
			}
			a[n][0]=0;
			a[n][2]=0;
			for(int i=0;i<n;i++){
				if(a[i][1]>=0&&a[i][1]<60){
					a[i][2]=0;
					a[n][0]=a[i][0]+a[n][0];
					a[n][2]=(a[i][2]*a[i][0])+a[n][2];
					//System.out.println(a[n][2]);
				}else if(a[i][1]>=60&&a[i][1]<70){
					a[i][2]=1;
					a[n][0]=a[i][0]+a[n][0];
					a[n][2]=(a[i][2]*a[i][0])+a[n][2];
					//System.out.println(a[n][2]+"60-70");
				}else if(a[i][1]>=70&&a[i][1]<80){
					a[i][2]=2;
					a[n][0]=a[i][0]+a[n][0];
					a[n][2]=(a[i][2]*a[i][0])+a[n][2];
					//System.out.println(a[n][2]+"70-80");
				}else if(a[i][1]>=80&&a[i][1]<90){
					a[i][2]=3;
					a[n][0]=a[i][0]+a[n][0];
					a[n][2]=(a[i][2]*a[i][0])+a[n][2];
					//System.out.println(a[n][2]);
				}else if(a[i][1]>=90&&a[i][1]<=100){
					a[i][2]=4;
					a[n][0]=a[i][0]+a[n][0];
					a[n][2]=(a[i][2]*a[i][0])+a[n][2];
					//System.out.println(a[n][2]);
				}
			}
			
			//System.out.println(a[n][0]);
			//System.out.println(a[n][2]);
			if(a[n][0]==0){
				System.out.println(-1);
			}else{
				System.out.printf("%.2f",a[n][2]/a[n][0]);
				System.out.println();
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
