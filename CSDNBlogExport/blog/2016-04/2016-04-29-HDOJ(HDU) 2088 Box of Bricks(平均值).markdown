---
layout: post
title: "HDOJ(HDU) 2088 Box of Bricks(平均值)"
date: 2016-04-29 09:41:41 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Little Bob likes playing with his box of bricks. He puts the bricks one upon another and builds stacks of different height. “Look, I’ve built a wall!”, he tells his older sister Al 
---


Problem Description 
Little Bob likes playing with his box of bricks. He puts the bricks one upon another and builds stacks of different height. “Look, I’ve built a wall!”, he tells his older sister Al
<!-- more -->
----------

Problem Description
Little Bob likes playing with his box of bricks. He puts the bricks one upon another and builds stacks of different height. “Look, I've built a wall!”, he tells his older sister Alice. “Nah, you should make all stacks the same height. Then you would have a real wall.”, she retorts. After a little consideration, Bob sees that she is right. So he sets out to rearrange the bricks, one by one, such that all stacks are the same height afterwards. But since Bob is lazy he wants to do this with the minimum number of bricks moved. Can you help?
![](http://img.blog.csdn.net/20160429214126537)

Input
The input consists of several data sets. Each set begins with a line containing the number n of stacks Bob has built. The next line contains n numbers, the heights hi of the n stacks. You may assume 1≤n≤50 and 1≤hi≤100.

The total number of bricks will be divisible by the number of stacks. Thus, it is always possible to rearrange the bricks such that all stacks have the same height.

The input is terminated by a set starting with n = 0. This set should not be processed.

 

Output
For each set, print the minimum number of bricks that have to be moved in order to make all the stacks the same height.
Output a blank line between each set.

 

Sample Input
6
5 2 4 1 7 5
0
 

Sample Output
5

就是输入一组数字（代表砖），让它全部只能有平均值那么高，问移动的最少次数。（保证平均数是整数）
一次只能移动一个。


```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=0;
		while(sc.hasNext()){
			int n =sc.nextInt();
			if(n==0){
				break;
			}
			if(t==0){
				t=1;
			}else{
				System.out.println();
			}
			int a[] = new int[n];
			long sum=0;
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
				sum+=a[i];
			}
			int avg = (int)sum/n;
			int num=0;
			for(int i=0;i<n;i++){
				if(a[i]>avg){
					num+=a[i]-avg;
				}
			}
			System.out.println(num);
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
