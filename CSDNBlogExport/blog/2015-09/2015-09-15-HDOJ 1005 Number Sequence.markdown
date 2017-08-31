---
layout: post
title: "HDOJ 1005 Number Sequence"
date: 2015-09-15 08:09:37 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❺ 算法及基础题,----- 判断循环-循环节
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
A number sequence is defined as follows:f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.Given A, B, and n, you are to calculate the value of f(n).Input 
The input co 
---


Problem Description 
A number sequence is defined as follows:f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.Given A, B, and n, you are to calculate the value of f(n).Input 
The input co
<!-- more -->
----------

Problem Description
A number sequence is defined as follows:

f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.

Given A, B, and n, you are to calculate the value of f(n).

 

Input
The input consists of multiple test cases. Each test case contains 3 integers A, B and n on a single line (1 <= A, B <= 1000, 1 <= n <= 100,000,000). Three zeros signal the end of input and this test case is not to be processed.

 

Output
For each test case, print the value of f(n) on a single line.

 

Sample Input
1 1 3
1 2 10
0 0 0
 

Sample Output
2
5
 发现很多同学都是以1,1为重复头，按照最多循环次数48来做的
我也参考了一些答案，发现：
1，不能以1,1 作为重复头；
2，自己先找周期。

```
#include<iostream>
#include<stdio.h>
using namespace std;
int f[100000005];
int main()
{
    int a,b,n,i,j;

    f[1]=1;f[2]=1;
    while(scanf("%d%d%d",&a,&b,&n))
    {
        int s=0;//记录周期
        if(a==0&&b==0&&n==0) break;
        for(i=3;i<=n;i++)
        {
            f[i]=(a*f[i-1]+b*f[i-2])%7;
            for(j=2;j<i;j++)
            if(f[i-1]==f[j-1]&&f[i]==f[j])
            //此题可以这样做的原因就是 2个确定后就可以决定后面的
            {
                s=i-j;
                //cout<<j<<" "<<s<<" >>"<<i<<endl;
                break;
            }
            if(s>0) break;
        }
        if(s>0){

                 f[n]=f[(n-j)%s+j];
     //cout<<"f["<<n<<"]:="<<"f["<<(n-j)%s+j<<"] "<<endl;
               }
        cout<<f[n]<<endl;

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
