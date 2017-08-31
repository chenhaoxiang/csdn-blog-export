---
layout: post
title: "HDOJ(HDU) 2123 An easy problem(简单题...)"
date: 2016-05-03 05:16:29 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
In this problem you need to make a multiply table of N * N ,just like the sample out. The element in the ith row and jth column should be the product(乘积) of i and j.Input 
The firs 
---


Problem Description 
In this problem you need to make a multiply table of N * N ,just like the sample out. The element in the ith row and jth column should be the product(乘积) of i and j.Input 
The firs
<!-- more -->
----------

Problem Description
In this problem you need to make a multiply table of N * N ,just like the sample out. The element in the ith row and jth column should be the product(乘积) of i and j.
 

Input
The first line of input is an integer C which indicate the number of test cases.

Then C test cases follow.Each test case contains an integer N (1<=N<=9) in a line which mentioned above.

 

Output
For each test case, print out the multiply table.

 

Sample Input
2
1
4
 

Sample Output
1
1 2 3 4
2 4 6 8
3 6 9 12
4 8 12 16



就是输入t个数，对于每个数n，输出n*n个数。
i为1-n，j为1-n，输出i*j。
每一行最后一个输出后面没有空格啊！！！

```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			int n =sc.nextInt();
			for(int i=1;i<=n;i++){
				for(int j=1;j<=n;j++){
					if(j==1){
						System.out.print(i*j);
					}else{
						System.out.print(" "+i*j);
					}
				}
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
