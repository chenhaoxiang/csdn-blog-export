---
layout: post
title: "POJ 2262  Goldbach's Conjecture"
date: 2015-10-23 03:31:21 +0800
comments: true
categories:❶ ACM,----- POJ-ACM
tags: [poj]
keyword: 陈浩翔, 谙忆
description: Problem Description 
In 1742, Christian Goldbach, a German amateur mathematician, sent a letter to Leonhard Euler in which he made the following conjecture:  
Every even number greater than 4 can be 
---


Problem Description 
In 1742, Christian Goldbach, a German amateur mathematician, sent a letter to Leonhard Euler in which he made the following conjecture:  
Every even number greater than 4 can be
<!-- more -->
----------

Problem Description
In 1742, Christian Goldbach, a German amateur mathematician, sent a letter to Leonhard Euler in which he made the following conjecture: 
Every even number greater than 4 can be 
written as the sum of two odd prime numbers.

For example: 
8 = 3 + 5. Both 3 and 5 are odd prime numbers. 
20 = 3 + 17 = 7 + 13. 
42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23.

Today it is still unproven whether the conjecture is right. (Oh wait, I have the proof of course, but it is too long to write it on the margin of this page.) 
Anyway, your task is now to verify Goldbach's conjecture for all even numbers less than a million. 
 

Input
The input will contain one or more test cases. 
Each test case consists of one even integer n with 6 <= n < 1000000. 
Input will be terminated by a value of 0 for n.
 

Output
For each test case, print one line of the form n = a + b, where a and b are odd primes. Numbers and operators should be separated by exactly one blank like in the sample output below. If there is more than one pair of odd primes adding up to n, choose the pair where the difference b - a is maximized. If there is no such pair, print a line saying "Goldbach's conjecture is wrong."
 

Sample Input
8
20
42
0
 

Sample Output
8 = 3 + 5
20 = 3 + 17
42 = 5 + 37
 
 用打表法
 

```
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int sum(int x){
    int i;
     int t = sqrt ( x + 0.5 ) ;
    for(i=2;i<=t;i++){
        if(x%i==0)
            return 0;
    }
    return 1;
}
int arr[500005],j=0;
void a(){
       int i;
    for(i=3;i<500000;i++){
        if(sum(i))
            arr[j++]=i;
    }
}
int main(){

    int m,i;
    a();
    /**for(i=0;i<10;i++)
    {
        printf("%6d",arr[i]);
    }**/
    while(1){
        int m;
        scanf("%d",&m);
    if(m==0){
        return 0;
    }
    if(m==6){
        printf("6 = 3 + 3\n");
    }
    else{
        int flag=0;
        for(i=0;i<m/2&&m/2>arr[i];i++)
        if(sum(m-arr[i])==1){
                flag=1;
                //printf("i=%d\n",i);
            break;
        }
       if(flag){
            //printf("##i=%d\n",i);
           printf("%d = %d + %d\n",m,arr[i],m-arr[i]);
       }
       else
          printf("Goldbach's conjecture is wrong.\n");
    }
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
