---
layout: post
title: "HDOJ HDU 1029 Ignatius and the Princess IV(简单DP，排序)"
date: 2016-06-18 10:27:46 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,----- HDOJ-JAVA,❺ 算法及基础题,----- 动态规划（DP）
tags: []
keyword: 陈浩翔, 谙忆
description: 此题无法用JavaAC，不相信的可以去HD1029题试下！Problem Description 
“OK, you are not too bad, em… But you can never pass the next test.” feng5166 says.“I will tell you an odd number N, and then N integers. There will be 
---


此题无法用JavaAC，不相信的可以去HD1029题试下！Problem Description 
“OK, you are not too bad, em… But you can never pass the next test.” feng5166 says.“I will tell you an odd number N, and then N integers. There will be
<!-- more -->
----------

**此题无法用JavaAC，不相信的可以去HD1029题试下！**

Problem Description
"OK, you are not too bad, em... But you can never pass the next test." feng5166 says.

"I will tell you an odd number N, and then N integers. There will be a special integer among them, you have to tell me which integer is the special one after I tell you all the integers." feng5166 says.

"But what is the characteristic of the special integer?" Ignatius asks.

"The integer will appear at least (N+1)/2 times. If you can't find the right integer, I will kill the Princess, and you will be my dinner, too. Hahahaha....." feng5166 says.

Can you find the special integer for Ignatius?

 

Input
The input contains several test cases. Each test case contains two lines. The first line consists of an odd integer N(1<=N<=999999) which indicate the number of the integers feng5166 will tell our hero. The second line contains the N integers. The input is terminated by the end of file.

 

Output
For each test case, you have to output only one line which contains the special number you have found.

 

Sample Input
5
1 3 2 3 3
11
1 1 1 1 1 5 5 5 5 5 5
7
1 1 1 1 1 1 1
 

Sample Output
3
5
1


<font color="red" size=4>
题意：就是在一行数中找出那个出现次数大于等于(n+1)/2的那个数，题目保证那个数只有一个！
此题有个坑，用Java无法AC，无论用桶排序，快排，还是DP都无法AC。会超时！
简单题，就不分析了。此处把Java代码也写上了。
</font>

AC的c语言代码：（后面有Java的（3种方法都用了））

```
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n;
    while(~scanf("%d",&n)){
        int i;
        int con=0;
        int m;
        int t;
        for(i=0;i<n;i++){
            scanf("%d",&t);
            if(con==0){
                m=t;
                con++;
            }else{
                if(t==m){
                    con++;
                }else{
                    con--;
                }

            }

        }
        printf("%d\n",m);

    }

    return 0;
}

```

Java的超时代码：3种方法！

```
package cn.hncu.acm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 陈浩翔
 * @version 1.0  2016-6-18
 */
//总结：此题无法用Java在2000ms内AC。   测试数据过多，输入流需要耗费太多时间。

public class P1029 {
	/*
	 //第一种方法  排序后判断
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n =sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Arrays.sort(a);
			System.out.println(a[(n+1)/2]);
		}
	}
	//超时
	*/
	
	/*
	 //第二种方法 DP
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			int con=0;
			int result=0;
			for(int i=0;i<n;i++){
				int m = sc.nextInt();
				if(con==0){
					result=m;
					con++;
				}else{
					if(m==result){
						con++;
					}else{
						con--;
					}
				}
			}
			System.out.println(result);
		}
	}
	超时
	*/
	
	/*
	 //桶排序
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			int a[] = new int[500000];
			int m=0;
			int t=0;
			for(int i=0;i<n;i++){
				t=sc.nextInt();
				a[t]++;
				if(a[t]>=(n+1)/2){
					m=t;
				}
			}
			System.out.println(m);
		}
	}
	超时
	*/
}

```



本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
