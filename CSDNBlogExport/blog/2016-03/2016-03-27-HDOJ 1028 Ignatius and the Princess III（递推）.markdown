---
layout: post
title: "HDOJ 1028 Ignatius and the Princess III（递推）"
date: 2016-03-27 12:30:22 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题,----- 动态规划（DP）
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
“Well, it seems the first problem is too easy. I will let you know how foolish you are later.” feng5166 says.“The second problem is, given an positive integer N, we define an equat 
---


Problem Description 
“Well, it seems the first problem is too easy. I will let you know how foolish you are later.” feng5166 says.“The second problem is, given an positive integer N, we define an equat
<!-- more -->
----------

**Problem Description**
"Well, it seems the first problem is too easy. I will let you know how foolish you are later." feng5166 says.

"The second problem is, given an positive integer N, we define an equation like this:
  N=a[1]+a[2]+a[3]+...+a[m];
  a[i]>0,1<=m<=N;
My question is how many different equations you can find for a given N.
For example, assume N is 4, we can find:
  4 = 4;
  4 = 3 + 1;
  4 = 2 + 2;
  4 = 2 + 1 + 1;
  4 = 1 + 1 + 1 + 1;
so the result is 5 when N is 4. Note that "4 = 3 + 1" and "4 = 1 + 3" is the same in this problem. Now, you do it!"

 

**Input**
The input contains several test cases. Each test case contains a positive integer N(1<=N<=120) which is mentioned above. The input is terminated by the end of file.

 

**Output**
For each test case, you have to output a line contains an integer P which indicate the different equations you have found.

 

**Sample Input**
4
10
20
 

**Sample Output**
5
42
627

----------
思路：
（i，j）（i>=j）代表的含义是i为n，j为划分的最大的数字。
边界：a(i,0) = a(i, 1) = a(0, i) = a(1, i) = 1;
i|j==0时，无论如何划分，结果为1；

当（i>=j）时，
划分为{j,{x1,x2...xi}},{x1,x2,...xi}的和为i-j,
{x1,x2,...xi}可能再次出现j，所以是(i-j)的j划分，所以划分个数为a(i-j,j);
划分个数还需要加上a(i,j-1)（累加前面的）;

当（i < j）时，
a[i][j]就等于a[i][i]；

```
import java.util.Scanner;

public class Main{
	static int a[][] = new int[125][125];
	public static void main(String[] args) {
		dabiao();
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(a[n][n]);
		}
	}
	
	private static void dabiao() {
		for(int i=0;i<121;i++){
			a[i][0]=1;
			a[i][1]=1;
			a[0][i]=1;
			a[1][i]=1;
		}
		for(int i=2;i<121;i++){
			for(int j=2;j<121;j++){
				if(j<=i){
					a[i][j]=a[i][j-1]+a[i-j][j];
				}else{
					a[i][j]=a[i][i];
				}
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
