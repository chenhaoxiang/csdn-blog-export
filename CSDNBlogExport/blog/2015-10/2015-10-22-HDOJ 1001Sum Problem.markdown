---
layout: post
title: "HDOJ 1001Sum Problem"
date: 2015-10-22 03:56:06 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [hdoj]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Hey, welcome to HDOJ(Hangzhou Dianzi University Online Judge).In this problem, your task is to calculate SUM(n) = 1 + 2 + 3 + … + n.Input 
The input will consist of a series of int 
---


Problem Description 
Hey, welcome to HDOJ(Hangzhou Dianzi University Online Judge).In this problem, your task is to calculate SUM(n) = 1 + 2 + 3 + … + n.Input 
The input will consist of a series of int
<!-- more -->
----------

Problem Description
Hey, welcome to HDOJ(Hangzhou Dianzi University Online Judge).

In this problem, your task is to calculate SUM(n) = 1 + 2 + 3 + ... + n.
 

Input
The input will consist of a series of integers n, one integer per line.
 

Output
For each case, output SUM(n) in one line, followed by a blank line. You may assume the result will be in the range of 32-bit signed integer.
 

Sample Input
1
100
 

Sample Output
1

5050


```
import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      int n = sc.nextInt();
      int sum=0;
      for(int i=1;i<=n;i++)
        sum+=i;
      System.out.println(sum);
      System.out.println();
  }
  }

}
```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
