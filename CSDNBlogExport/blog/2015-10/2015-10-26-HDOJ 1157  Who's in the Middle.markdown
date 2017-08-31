---
layout: post
title: "HDOJ 1157  Who's in the Middle"
date: 2015-10-26 07:32:46 +0800
comments: true
categories:----- HDOJ-C++
tags: [hdoj]
keyword: 陈浩翔, 谙忆
description: Problem Description 
FJ is surveying his herd to find the most average cow. He wants to know how much milk this ‘median’ cow gives: half of the cows give as much or more than the median; half give as m 
---


Problem Description 
FJ is surveying his herd to find the most average cow. He wants to know how much milk this ‘median’ cow gives: half of the cows give as much or more than the median; half give as m
<!-- more -->
----------

Problem Description
FJ is surveying his herd to find the most average cow. He wants to know how much milk this 'median' cow gives: half of the cows give as much or more than the median; half give as much or less. 

Given an odd number of cows N (1 <= N < 10,000) and their milk output (1..1,000,000), find the median amount of milk given such that at least half the cows give the same amount of milk or more and at least half give the same or less.
 

Input
* Line 1: A single integer N 

* Lines 2..N+1: Each line contains a single integer that is the milk output of one cow.
 

Output
* Line 1: A single integer that is the median milk output.
 

Sample Input
5
2
4
1
3
5
 

Sample Output
3

Hint
 
INPUT DETAILS: 

Five cows with milk outputs of 1..5 

OUTPUT DETAILS: 

1 and 2 are below 3; 4 and 5 are above 3.
 
一道求中位数的简单题

```
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include<iostream>

#include<algorithm>

using namespace std;
bool cmp(int a,int b){
    return a>b;
}//从大到小排序；

int main(){
    int n;
    while(scanf("%d",&n)==1){
    int i,j,arr[10005];
    for(i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
         sort(arr,arr+n,cmp);
    printf("%d\n",arr[(n-1)/2]);
    }
    return 0;
}


```

下面用快排做：

```
/**#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include<iostream>

#include<algorithm>

using namespace std;
bool cmp(int a,int b){
    return a>b;
}//从大到小排序；

int main(){
    int n;
    while(scanf("%d",&n)==1){
    int i,j,arr[10005];
    for(i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
         sort(arr,arr+n,cmp);
    printf("%d\n",arr[(n-1)/2]);
    }
    return 0;
}
**/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include<iostream>

#include<algorithm>

using namespace std;
int cmp(const void *x,const void *y){
    return (*(int *)x-*(int *)y);//从小到大
   /** return (*(int *)y-*(int *)x);//从大到小**/
}

int main(){
    int n;
    while(scanf("%d",&n)==1){
    int i,j,arr[10005];
    for(i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
         qsort(arr,n,sizeof(int),cmp);
       /**  for(int i=0;i<n;i++){
            printf("%d\n",arr[i]);
         }**/
    printf("%d\n",arr[(n-1)/2]);
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
