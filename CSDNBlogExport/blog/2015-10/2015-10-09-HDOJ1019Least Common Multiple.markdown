---
layout: post
title: "HDOJ1019Least Common Multiple"
date: 2015-10-09 08:05:20 +0800
comments: true
categories:----- HDOJ-C++
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
The least common multiple (LCM) of a set of positive integers is the smallest positive integer which is divisible by all the numbers in the set. For example, the LCM of 5, 7 and 15 
---


Problem Description 
The least common multiple (LCM) of a set of positive integers is the smallest positive integer which is divisible by all the numbers in the set. For example, the LCM of 5, 7 and 15
<!-- more -->
----------

Problem Description
The least common multiple (LCM) of a set of positive integers is the smallest positive integer which is divisible by all the numbers in the set. For example, the LCM of 5, 7 and 15 is 105.


 

Input
Input will consist of multiple problem instances. The first line of the input will contain a single integer indicating the number of problem instances. Each instance will consist of a single line of the form m n1 n2 n3 ... nm where m is the number of integers in the set and n1 ... nm are the integers. All integers will be positive and lie within the range of a 32-bit integer.

 

Output
For each problem instance, output a single line containing the corresponding LCM. All results will lie in the range of a 32-bit integer.

 

Sample Input
2
3 5 7 15
6 4 10296 936 1287 792 1
 

Sample Output
105
10296


也就是求最小公倍数

```
/**题意：
求输入的所有数最小公倍数。

思路：
先用 欧几里德定理
求两个数的最小公倍数，所得的公倍数再与下一个数求最小公倍数。
**/
#include <stdio.h>
#include <stdlib.h>

int gcd(int a,int b)//欧几里德求最大公约数
{
    if(b==0) return a;
    return gcd(b,a%b);
}
int main()
{
    int t,n,m,i,a,b;
    scanf("%d",&t);
    while(t--)
    {
        scanf("%d%d",&n,&m);
        a=m;
        for(i=1;i<n;i++)
        {
            scanf("%d",&m);
            if(a<m)
            {
                b=a;a=m;m=b;
            }
            a=a/gcd(a,m)*m;//最小公倍数=两数之积/最大公约数
        }
        printf("%d\n",a);
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
