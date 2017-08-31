---
layout: post
title: "POJ 1306  Combinations"
date: 2015-10-26 06:24:47 +0800
comments: true
categories:----- POJ-ACM
tags: [poj]
keyword: 陈浩翔, 谙忆
description: DescriptionComputing the exact number of ways that N things can be taken M at a time can be a great challenge when N and/or M become very large. Challenges are the stuff of contests. Therefore, you are 
---


DescriptionComputing the exact number of ways that N things can be taken M at a time can be a great challenge when N and/or M become very large. Challenges are the stuff of contests. Therefore, you are
<!-- more -->
----------

Description

Computing the exact number of ways that N things can be taken M at a time can be a great challenge when N and/or M become very large. Challenges are the stuff of contests. Therefore, you are to make just such a computation given the following: 
GIVEN: 5 <= N <= 100; 5 <= M <= 100; M <= N 
Compute the EXACT value of: C = N! / (N-M)!M! 
You may assume that the final value of C will fit in a 32-bit Pascal LongInt or a C long. For the record, the exact value of 100! is: 
93,326,215,443,944,152,681,699,238,856,266,700,490,715,968,264,381,621, 468,592,963,895,217,599,993,229,915,608,941,463,976,156,518,286,253, 697,920,827,223,758,251,185,210,916,864,000,000,000,000,000,000,000,000 
Input

The input to this program will be one or more lines each containing zero or more leading spaces, a value for N, one or more spaces, and a value for M. The last line of the input file will contain a dummy N, M pair with both values equal to zero. Your program should terminate when this line is read.
Output

The output from this program should be in the form: 
N things taken M at a time is C exactly. 
Sample Input

100  6
20  5
18  6
0  0
Sample Output

100 things taken 6 at a time is 1192052400 exactly.
20 things taken 5 at a time is 15504 exactly.
18 things taken 6 at a time is 18564 exactly.


```
#include <iostream>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
using namespace std;

int main()
{
    int n,m;
    while(~scanf("%d%d",&n,&m)&&(n||m)){
        int s[200];
        bool vis[200];
        memset(vis,0,sizeof(vis));
        int x,y;
        if(n-m<m){
            x=n-m;/**x为小的那个数**/
            y=m;
        }
        else{
            x=m;
            y=n-m;
        }
        int sum=1;
        for(int i=y+1;i<=n;i++){
            sum*=i;
            for(int j=1;j<=x;j++){
                if(sum%j==0&&vis[j]==0){
                    vis[j]=1;
                    sum=sum/j;
                }
            }
        }
        printf("%d things taken %d at a time is %d exactly.\n",n,m,sum);
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
