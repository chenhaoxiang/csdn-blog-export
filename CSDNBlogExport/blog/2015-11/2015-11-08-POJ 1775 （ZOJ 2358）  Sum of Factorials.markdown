---
layout: post
title: "POJ 1775 （ZOJ 2358）  Sum of Factorials"
date: 2015-11-08 11:02:12 +0800
comments: true
categories:❶ ACM,----- POJ-ACM,----- ZOJ-ACM
tags: [poj,zoj]
keyword: 陈浩翔, 谙忆
description: DescriptionJohn von Neumann, b. Dec. 28, 1903, d. Feb. 8, 1957, was a Hungarian-American mathematician who made important contributions to the foundations of mathematics, logic, quantum physics,meteoro 
---


DescriptionJohn von Neumann, b. Dec. 28, 1903, d. Feb. 8, 1957, was a Hungarian-American mathematician who made important contributions to the foundations of mathematics, logic, quantum physics,meteoro
<!-- more -->
----------

Description

John von Neumann, b. Dec. 28, 1903, d. Feb. 8, 1957, was a Hungarian-American mathematician who made important contributions to the foundations of mathematics, logic, quantum physics,meteorology, science, computers, and game theory. He was noted for a phenomenal memory and the speed with which he absorbed ideas and solved problems. In 1925 he received a B.S. diploma in chemical engineering from Zurich Institute and in 1926 a Ph.D. in mathematics from the University of Budapest. His Ph.D. dissertation on set theory was an important contribution to the subject. At the age of 20, von Neumann proposed a new definition of ordinal numbers that was universally adopted. While still in his twenties, he made many contributions in both pure and applied mathematics that established him as a mathematician of unusual depth. His Mathematical Foundations of Quantum Mechanics (1932) built a solid framework for the new scientific discipline. During this time he also proved the mini-max theorem of GAME THEORY. He gradually expanded his work in game theory, and with coauthor Oskar Morgenstern he wrote Theory of Games and Economic Behavior (1944). 
There are some numbers which can be expressed by the sum of factorials. For example 9,9=1!+2!+3! Dr. von Neumann was very interested in such numbers. So, he gives you a number n, and wants you to tell him whether or not the number can be expressed by the sum of some factorials. 
Well, it's just a piece of cake. For a given n, you'll check if there are some xi, and let n equal to Σ1<=i<=txi!. (t >=1 1, xi >= 0, xi = xj iff. i = j). If the answer is yes, say "YES"; otherwise, print out "NO".
Input

You will get several non-negative integer n (n <= 1,000,000) from input file. Each one is in a line by itself. 
The input is terminated by a line with a negative integer.
Output

For each n, you should print exactly one word ("YES" or "NO") in a single line. No extra spaces are allowed.
Sample Input

9
-1
Sample Output

YES


注意：0的阶乘是1；（输入0，输出NO）
不是输入-1结束，而是输入负数结束程序；
题目要求不是连续阶乘和；
例如：4=0！+1！+2！=1+1+2
          输出 YES；
          7=3！+1！；
          输出 YES；


我这里的思路是：
从不大于n的最大数开始减，如果能减到n为0，输出YES，否则
输出NO。

```
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int a[10];
void df(){
   for(int i=1;i<10;i++){
     a[i]=i*a[i-1];
   }
}
int main()
{
    a[0]=1;
    df();
//    for(int i=0;i<10;i++){
//        printf("%d\n",a[i]);
//    }
    int n;
    int sum;
    while(scanf("%d",&n)==1&&n>=0){
            sum=n;
            if(n==0){
                printf("NO\n");
                continue;
            }
            int flag=0;
        for(int i=9;i>=0;i--){
            if(a[i]<=sum){
                sum=sum-a[i];
               // printf("i=%d,%d\n",i,a[i]);
            }
        if(sum==0){
            printf("YES\n");
            flag=1;
            break;
        }
        }
        if(flag==0)
        printf("NO\n");
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
