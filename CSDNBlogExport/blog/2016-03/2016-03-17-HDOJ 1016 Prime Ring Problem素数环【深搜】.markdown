---
layout: post
title: "HDOJ 1016 Prime Ring Problem素数环【深搜】"
date: 2016-03-17 07:35:15 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 递归搜索回溯,----- HDOJ-C++
tags: [java,ACM]
keyword: 陈浩翔, 谙忆
description: Problem Description 
A ring is compose of n circles as shown in diagram. Put natural number 1, 2, …, n into each circle separately, and the sum of numbers in two adjacent circles should be a prime.Note 
---


Problem Description 
A ring is compose of n circles as shown in diagram. Put natural number 1, 2, …, n into each circle separately, and the sum of numbers in two adjacent circles should be a prime.Note
<!-- more -->
----------

Problem Description
A ring is compose of n circles as shown in diagram. Put natural number 1, 2, ..., n into each circle separately, and the sum of numbers in two adjacent circles should be a prime.

Note: the number of first circle should always be 1.
![](http://img.blog.csdn.net/20160317193155200)

 

Input
n (0 < n < 20).

 

Output
The output format is shown as sample below. Each row represents a series of circle numbers in the ring beginning from 1 clockwisely and anticlockwisely. The order of numbers must satisfy the above requirements. Print solutions in lexicographical order.

You are to write a program that completes above process.

Print a blank line after each case.

 

Sample Input
6
8
 

Sample Output
Case 1:
1 4 3 2 5 6
1 6 5 2 3 4

Case 2:
1 2 3 8 5 6 7 4
1 2 5 8 3 4 7 6
1 4 7 6 5 8 3 2
1 6 7 4 3 8 5 2
 

```
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int Case = 0;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int a[] = new int[n];
			//初始数组1-n
			int color[] = new int[n];
			//判断数字是否已经存在
			int prant[] = new int[n];
			//输出数据排序
			int count =0;//计数器
			for(int i=0;i<n;i++){
				a[i]=i+1;
				color[i] = -1;
			}//初始化数据
			
			Case++;
			System.out.println("Case "+(Case)+":");
			
			dfs(a,color,prant,count,0);
			System.out.println();
			
			
			
		}
	}

	private static void dfs(int[] a, int[] color, int[] prant, int count,int m) {
		//System.out.println(count);
		count++;//计数器加1
		if(count == a.length&&p(prant[0],a[m])){
		//注意第一个数和最后一个数相加的和也必须为素数
			prant[count-1]=a[m];
			for(int i=0;i<a.length-1;i++){
				System.out.print(prant[i]+" ");
			}
			System.out.println(prant[a.length-1]);
			
			//return ;
		}
		
		for(int i=0;i<a.length;i++){
			color[m] =1;
			if(p(a[m],a[i])&&color[i]==-1){
				color[i]=1;
				prant[count-1]=a[m];

				dfs(a,color,prant,count,i);

				color[i]=-1;
				
				
			}
			
			
		}
		
		
	}

//判断是不是素数
	private static boolean p(int i, int j) {
		int sum = i+j;
		for(int a=2;a*a<=sum;a++){
			if(sum%a==0){
				return false;
			}
		}
		return true;
	}

	
}

```
C语言：
```
#include <iostream>
#include <stdio.h>
#include <string.h>
using namespace std;

int n;
int df[21];
int t=1;
int m[21];
int mi;
bool pn(int x,int y){//判断素数
    for(int i=2;i*i<=x+y;i++){
        if((x+y)%i==0){
            return false;
        }
    }
    return true;
}

void dfs(int x){
    if(mi==n&&pn(m[1],m[n])){
        for(int i=1;i<n;i++){
            printf("%d ",m[i]);
        }
        printf("%d\n",m[n]);
        return;
    }


    for(int i=2;i<=n;i++){
        if(df[i]==0&&pn(x,i)){
            df[x]=1;
            mi++;//当前小球数
            m[mi]=i;
            dfs(i);
            df[x]=0;
            mi--;//必须减一
        }
    }


}

int main()
{
    while(~scanf("%d",&n)){
        printf("Case %d:\n",t);
        t++;
        memset(df,0,sizeof(df));
        mi=1;
        m[mi]=1;
        dfs(1);
        printf("\n");
    }
    return 0;
}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
