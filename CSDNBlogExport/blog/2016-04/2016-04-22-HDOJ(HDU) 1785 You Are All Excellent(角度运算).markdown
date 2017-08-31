---
layout: post
title: "HDOJ(HDU) 1785 You Are All Excellent(角度运算)"
date: 2016-04-22 01:25:20 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
本次集训队共有30多人参加，毫无疑问，你们都是很优秀的，但是由于参赛名额有限，只能选拔部分队员参加省赛。从学校的角度，总是希望选拔出最优秀的18人组成6支队伍来代表学校。但是，大家也知道，要想做到完全客观，是一件很难的事情。因为选拔的标准本身就很难统一。 
为了解决这个难题，我现在把问题作了简化，现在假设每个队员都是二维平面中的一个点，用(xi,yi)坐标来 
---


Problem Description 
本次集训队共有30多人参加，毫无疑问，你们都是很优秀的，但是由于参赛名额有限，只能选拔部分队员参加省赛。从学校的角度，总是希望选拔出最优秀的18人组成6支队伍来代表学校。但是，大家也知道，要想做到完全客观，是一件很难的事情。因为选拔的标准本身就很难统一。 
为了解决这个难题，我现在把问题作了简化，现在假设每个队员都是二维平面中的一个点，用(xi,yi)坐标来
<!-- more -->
----------

Problem Description
本次集训队共有30多人参加，毫无疑问，你们都是很优秀的，但是由于参赛名额有限，只能选拔部分队员参加省赛。从学校的角度，总是希望选拔出最优秀的18人组成6支队伍来代表学校。但是，大家也知道，要想做到完全客观，是一件很难的事情。因为选拔的标准本身就很难统一。
为了解决这个难题，我现在把问题作了简化，现在假设每个队员都是二维平面中的一个点，用(xi,yi)坐标来表示，一个队员的能力可以用他到原点的欧几里德距离来表示。由于这种排名标准太~客观了，新队员很难有出头的机会，很多人很是郁闷。特别是一个废话不是很多、不是特别暴躁、号称盖帽高手的伪**就很有意见，他现在要求改革排名规则，并且自己提出了一套号称绝对公正的方案：
现在不是用一个点来表示一个队员了，而是用原点到该队员所在的点所构成的向量来表示一个队员。如果该向量和X正轴夹角比较小的话，就说他的能力比较高，排名就应该靠前。
这就是著名的“伪氏规则”（说实话，这规则我有点怀疑其客观性，因为我知道他的坐标是(3.1,0.1)...）

 

Input
输入数据包含多组测试实例，每个实例的第一行是一个整数n（n<=100）,表示集训队员的人数，紧接着的一行是2*n个数，表示n个队员的坐标值（x1,y1,x2,y2...xn,yn），n为负数的时候表示输入数据的结束。
特别说明，所有的y坐标均为正数，并且所有的坐标值都是有一位小数的浮点数。

 

Output
对于每个测试实例，请在一行内输出排名后的坐标，坐标之间用一个空格隔开。特别地，你可以假设根据“伪氏排名规则”结果唯一。

 

Sample Input
3
5.0 4.0 3.1 0.1 2.0 2.0
-1
 

Sample Output
3.1 0.1 5.0 4.0 2.0 2.0



直接用java中的Math.atan(x/y)方法来求反正切。
Math.atan(x/y)的值越小，角度越大！


```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			int n =sc.nextInt();
			if(n<0){
				return ;
			}
			if(n==0){
				continue;
			}
			double[] x = new double[n];
			double[] y = new double[n];
			double[] m = new double[n];
			for(int i=0;i<n;i++){
				x[i] = sc.nextDouble();
				y[i] = sc.nextDouble();
				m[i] =Math.atan(x[i]/y[i]);
				//System.out.println(m[i]);
			}
			double temp=0;
			for(int i=0;i<n-1;i++){
				for(int j=i+1;j<n;j++){
					if(m[i]-m[j]<0){
						temp = m[i];
						m[i]=m[j];
						m[j]=temp;
						
						temp = x[i];
						x[i]=x[j];
						x[j]=temp;
						
						temp = y[i];
						y[i] = y[j];
						y[j] = temp;
					}
				}
			}
			
			System.out.printf("%.1f %.1f",x[0],y[0]);
			for(int i=1;i<n;i++){
				System.out.printf(" %.1f %.1f",x[i],y[i]);
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
