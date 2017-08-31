---
layout: post
title: "HDOJ(HDU) 2309 ICPC Score Totalizer Software(求平均值)"
date: 2016-05-06 08:43:06 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
The International Clown and Pierrot Competition (ICPC), is one of the most distinguished and also the most popular events on earth in the show business.  
One of the unique feature 
---


Problem Description 
The International Clown and Pierrot Competition (ICPC), is one of the most distinguished and also the most popular events on earth in the show business.  
One of the unique feature
<!-- more -->
----------

Problem Description
The International Clown and Pierrot Competition (ICPC), is one of the most distinguished and also the most popular events on earth in the show business. 
One of the unique features of this contest is the great number of judges that sometimes counts up to one hundred. The number of judges may differ from one contestant to another, because judges with any relationship whatsoever with a specific contestant are temporarily excluded for scoring his/her performance. 

Basically, scores given to a contestant's performance by the judges are averaged to decide his/her score. To avoid letting judges with eccentric viewpoints too much influence the score, the highest and the lowest scores are set aside in this calculation. If the same highest score is marked by two or more judges, only one of them is ignored. The same is with the lowest score. The average, which may contain fractions, are truncated down to obtain final score as an integer. 

You are asked to write a program that computes the scores of performances, given the scores of all the judges, to speed up the event to be suited for a TV program. 


 

Input
The input consists of a number of datasets, each corresponding to a contestant's performance. There are no more than 20 datasets in the input. 

A dataset begins with a line with an integer n, the number of judges participated in scoring the performance (3 ≤ n ≤ 100). Each of the n lines following it has an integral score s (0 ≤ s ≤ 1000) marked by a judge. No other characters except for digits to express these numbers are in the input. Judges' names are kept secret. 

The end of the input is indicated by a line with a single zero in it. 


 

Output
For each dataset, a line containing a single decimal integer indicating the score for the corresponding performance should be output. No other characters should be on the output line. 


 

Sample Input
3
1000
342
0
5
2
2
9
11
932
5
300
1000
0
200
400
8
353
242
402
274
283
132
402
523
0
 

Sample Output
342
7
300
326


分数都是整数！平均分也要是整数！
评委打分，去掉一个最高分，去掉一个最低分，求剩下的平均分！
不用四舍五入。直接舍去小数位就可以。


```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			if(n<=0){
				return ;
			}
			int sum =0;
			int min = sc.nextInt();
			int max=min;
			sum=max;
			int b;
			for(int i=1;i<n;i++){
				b = sc.nextInt();
				if(b>max){
					max=b;
				}
				if(b<min){
					min=b;
				}
				sum+=b;
			}
			sum=sum-min-max;
			System.out.println((int)(sum/(n-2)));
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
