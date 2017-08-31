---
layout: post
title: "HDOJ(HDU) 2192 MagicBuilding(用Java的Map做了下)"
date: 2016-05-05 09:07:46 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
As the increase of population, the living space for people is becoming smaller and smaller. In MagicStar the problem is much worse. Dr. Mathematica is trying to save land by cluste 
---


Problem Description 
As the increase of population, the living space for people is becoming smaller and smaller. In MagicStar the problem is much worse. Dr. Mathematica is trying to save land by cluste
<!-- more -->
----------

Problem Description
As the increase of population, the living space for people is becoming smaller and smaller. In MagicStar the problem is much worse. Dr. Mathematica is trying to save land by clustering buildings and then we call the set of buildings MagicBuilding. Now we can treat the buildings as a square of size d, and the height doesn't matter. Buildings of d1,d2,d3....dn can be clustered into one MagicBuilding if they satisfy di != dj(i != j). 
Given a series of buildings size , you need to calculate the minimal numbers of MagicBuildings that can be made. Note that one building can also be considered as a MagicBuilding.
Suppose there are five buildings : 1, 2, 2, 3, 3. We make three MagicBuildings (1,3), (2,3), (2) .And we can also make two MagicBuilding :(1,2,3), (2,3). There is at least two MagicBuildings obviously. 
 

Input
The first line of the input is a single number t, indicating the number of test cases.
Each test case starts by n (1≤n≤10^4) in a line indicating the number of buildings. Next n positive numbers (less than 2^31) will be the size of the buildings.
 

Output
For each test case , output a number perline, meaning the minimal number of the MagicBuilding that can be made.
 

Sample Input
2
1
2 
5
1 2 2 3 3
 

Sample Output
1
2


其实说了这么多，就是找出现次数最多的那个数。

练习了下Map的使用。也可以不用Map的。

```
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main{

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
			int n=sc.nextInt();
			int m[] = new int[n];
			for(int i=0;i<n;i++){
				m[i] = sc.nextInt();
				if(map.get(m[i])==null){
					map.put(m[i], 1);
				}else{
					map.put(m[i], map.get(m[i])+1);
				}
			}
			int max=0;
			for(int i=0;i<n;i++){
				if(map.get(m[i])>max){
					max=map.get(m[i]);
				}
			}
			System.out.println(max);
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
