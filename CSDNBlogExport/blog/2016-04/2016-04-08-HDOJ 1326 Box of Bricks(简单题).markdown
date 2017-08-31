---
layout: post
title: "HDOJ 1326 Box of Bricks(简单题)"
date: 2016-04-08 01:14:41 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Little Bob likes playing with his box of bricks. He puts the bricks one upon another and builds stacks of different height. Look, I've built a wall!'', he tells his older sister Al 
---


Problem Description 
Little Bob likes playing with his box of bricks. He puts the bricks one upon another and builds stacks of different height. Look, I've built a wall!'', he tells his older sister Al
<!-- more -->
----------

Problem Description
Little Bob likes playing with his box of bricks. He puts the bricks one upon another and builds stacks of different height. ``Look, I've built a wall!'', he tells his older sister Alice. ``Nah, you should make all stacks the same height. Then you would have a real wall.'', she retorts. After a little con- sideration, Bob sees that she is right. So he sets out to rearrange the bricks, one by one, such that all stacks are the same height afterwards. But since Bob is lazy he wants to do this with the minimum number of bricks moved. Can you help? 
![](http://img.blog.csdn.net/20160408011012123)




 

Input
The input consists of several data sets. Each set begins with a line containing the number n of stacks Bob has built. The next line contains n numbers, the heights hi of the n stacks. You may assume 1 <= n <= 50 and 1 <= hi <= 100.

The total number of bricks will be divisible by the number of stacks. Thus, it is always possible to rearrange the bricks such that all stacks have the same height. 

The input is terminated by a set starting with n = 0. This set should not be processed. 

 

Output
For each set, first print the number of the set, as shown in the sample output. Then print the line ``The minimum number of moves is k.'', where k is the minimum number of bricks that have to be moved in order to make all the stacks the same height. 

Output a blank line after each set.

 

Sample Input
6
5 2 4 1 7 5
0
 

Sample Output
Set #1
The minimum number of moves is 5.


题目很简单：就是先输入一个数n，然后再接n个数，
            如果n为0，就结束输入。
然后求n个数的平均数，再求出这n个数中（比平均数大的数一共比平均数大多少的和）比平均数小的数一共比平均数小多少的和。
这个和就是要求的。

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tp=1;
		while(sc.hasNext()){
			int n = sc.nextInt();
			if(n==0){
				return ;
			}
			int[] num = new int[n];
			int sum=0;
			for(int i=0;i<n;i++){
				num[i] = sc.nextInt();
				sum+=num[i];
			}
			
			int s = sum/n;
			
			int times = 0;
			for(int i=0;i<n;i++){
				if(num[i]<s){
					times+=s-num[i];
				}
			}
			System.out.println("Set #"+(tp++));
			System.out.println("The minimum number of moves is "+times+".");
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
