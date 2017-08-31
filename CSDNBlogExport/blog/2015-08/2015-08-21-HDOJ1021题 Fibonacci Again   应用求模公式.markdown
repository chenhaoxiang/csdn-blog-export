---
layout: post
title: "HDOJ1021题 Fibonacci Again   应用求模公式"
date: 2015-08-21 05:53:13 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❺ 算法及基础题,----- 模拟/推导/打表
tags: [求模公式-HDOJ,1021]
keyword: 陈浩翔, 谙忆
description: Problem Description 
There are another kind of Fibonacci numbers: F(0) = 7, F(1) = 11, F(n) = F(n-1) + F(n-2) (n>=2).Input 
Input consists of a sequence of lines, each containing an integer n. (n < 1,0
求模公式 
---


Problem Description 
There are another kind of Fibonacci numbers: F(0) = 7, F(1) = 11, F(n) = F(n-1) + F(n-2) (n>=2).Input 
Input consists of a sequence of lines, each containing an integer n. (n < 1,0
求模公式
<!-- more -->
----------

Problem Description
There are another kind of Fibonacci numbers: F(0) = 7, F(1) = 11, F(n) = F(n-1) + F(n-2) (n>=2).

 

Input
Input consists of a sequence of lines, each containing an integer n. (n < 1,000,000).

 

Output
Print the word "yes" if 3 divide evenly into F(n).

Print the word "no" if not.

 

Sample Input
0
1
2
3
4
5
 

Sample Output
no
no
yes
no
no
no

应用求模公式
        （1） (a + b) % p = (a % p + b % p) % p 
        （2） (a - b) % p = (a % p - b % p) % p 
        （3） (a * b) % p = (a % p * b % p) % p 
        （4）  a ^ b % p = ((a % p)^b) % p 
        如果不用的话会溢出。
代码：

```
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include<string.h>
using namespace std;

int main()
{
    int a[1000001],i,j,s;
    a[0]=7;a[1]=11;
    for(i=2;i<1000001;i++)
    {
        a[i]=(a[i-1]%3+a[i-2]%3)%3;//只写最后那个%3也可以
    }
    while(~scanf("%d",&s))
    {
        if(a[s]%3==0)
            printf("yes\n");
        else
            printf("no\n");
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
