---
layout: post
title: "POJ 2533   Longest Ordered Subsequence"
date: 2015-10-26 09:13:36 +0800
comments: true
categories:❶ ACM,----- POJ-ACM,❺ 算法及基础题,----- 动态规划（DP）
tags: [poj]
keyword: 陈浩翔, 谙忆
description: DescriptionA numeric sequence of ai is ordered if a1 < a2 < … < aN. Let the subsequence of the given numeric sequence (a1, a2, …, aN) be any sequence (ai1, ai2, …, aiK), where 1 <= i1 < i2 < … < iK <= 
---


DescriptionA numeric sequence of ai is ordered if a1 < a2 < … < aN. Let the subsequence of the given numeric sequence (a1, a2, …, aN) be any sequence (ai1, ai2, …, aiK), where 1 <= i1 < i2 < … < iK <=
<!-- more -->
----------

Description

A numeric sequence of ai is ordered if a1 < a2 < ... < aN. Let the subsequence of the given numeric sequence (a1, a2, ..., aN) be any sequence (ai1, ai2, ..., aiK), where 1 <= i1 < i2 < ... < iK <= N. For example, sequence (1, 7, 3, 5, 9, 4, 8) has ordered subsequences, e. g., (1, 7), (3, 4, 8) and many others. All longest ordered subsequences are of length 4, e. g., (1, 3, 5, 8).

Your program, when given the numeric sequence, must find the length of its longest ordered subsequence.
Input

The first line of input file contains the length of sequence N. The second line contains the elements of sequence - N integers in the range from 0 to 10000 each, separated by spaces. 1 <= N <= 1000
Output

Output file must contain a single integer - the length of the longest ordered subsequence of the given sequence.
Sample Input

7
1 7 3 5 9 4 8
Sample Output

4


用动态规划做，每次从后面对前面判断
用dd[k]表示以df[k]作为终点的最大上升子序列
则：
dd[1] = 1;
dd[k] = Max (dd[i]:1 <= i < k 且 df[i ]< df[k] 且 k != 1) + 1.
也就是第k+1前面一个不大于df[k]的数的dd[ ]的值；
n：7
i    ：0 1 2 3 4 5 6 
df ：1 7 3 5 9 4 8
dd[0]:1;
dd[1]:dd[0]+1=2;
dd[2]:dd[0]+1=2;
dd[3]:dd[2]+1=3;
dd[4]:因为df[0],df[1],df[2],df[3]都小于df[4]，但是dd[3]最大，
          所以，dd[4]=dd[3]+1=4;
dd[5]:dd[2]+1=3;
dd[6]:dd[5]+1=4;
..................................................................
```
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define Maxn 1020
int df[Maxn],dd[Maxn];

int cmp(const void *x,const void *y){
    return (*(int *)y-*(int *)x);
    /*快速排序，从大到小排序*/
}
int main(){
    int n;
    while(scanf("%d",&n)==1){
        for(int i=0;i<n;i++){
            scanf("%d",&df[i]);
        }
        dd[0]=1;
        for(int i=1;i<n;i++){
                int t=0;
            for(int j=0;j<i;j++){
                if(df[i]>df[j]){
                    if(t<dd[j]){
                        t=dd[j];
                    }
                }
            }
            dd[i]=t+1;
            //此时的t是dd[i]之前的最大增子序列的个数
        }
        qsort(dd,n,sizeof(int),cmp);
        printf("%d\n",dd[0]);
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
