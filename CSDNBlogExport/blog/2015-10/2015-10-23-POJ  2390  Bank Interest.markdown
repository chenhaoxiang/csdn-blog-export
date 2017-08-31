---
layout: post
title: "POJ  2390  Bank Interest"
date: 2015-10-23 06:20:54 +0800
comments: true
categories:❶ ACM,----- POJ-ACM
tags: [poj]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Farmer John made a profit last year! He would like to invest it well but wonders how much money he will make. He knows the interest rate R (an integer between 0 and 20) that is com 
---


Problem Description 
Farmer John made a profit last year! He would like to invest it well but wonders how much money he will make. He knows the interest rate R (an integer between 0 and 20) that is com
<!-- more -->
----------

Problem Description
Farmer John made a profit last year! He would like to invest it well but wonders how much money he will make. He knows the interest rate R (an integer between 0 and 20) that is compounded annually at his bank. He has an integer amount of money M in the range 100..1,000,000. He knows how many years Y (range: 0..400) he intends to invest the money in the bank. Help him learn how much money he will have in the future by compounding the interest for each year he saves. Print an integer answer without rounding. Answers for the test data are guaranteed to fit into a signed 32 bit integer.
 

Input
* Line 1: Three space-separated integers: R, M, and Y
 

Output
* Line 1: A single integer that is the number of dollars FJ will have after Y years.
 

Sample Input
5 5000 4
 

Sample Output
6077
 

```
#include <stdio.h>
#include <stdlib.h>

int main(){
    int y;
    double r,m;
    scanf("%lf%lf%d",&r,&m,&y);
    int i;
    for(i=0;i<y;i++){
        m+=m*(r/100.0);
    }
    int a=(int)m;
    printf("%d\n",a);
    return 0;
}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
