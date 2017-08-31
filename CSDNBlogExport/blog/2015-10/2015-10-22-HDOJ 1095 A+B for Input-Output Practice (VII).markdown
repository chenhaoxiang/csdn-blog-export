---
layout: post
title: "HDOJ 1095 A+B for Input-Output Practice (VII)"
date: 2015-10-22 04:06:42 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Your task is to Calculate a + b.Input 
The input will consist of a series of pairs of integers a and b, separated by a space, one pair of integers per line. Output 
For each pair o 
---


Problem Description 
Your task is to Calculate a + b.Input 
The input will consist of a series of pairs of integers a and b, separated by a space, one pair of integers per line. Output 
For each pair o
<!-- more -->
----------

Problem Description
Your task is to Calculate a + b.
 

Input
The input will consist of a series of pairs of integers a and b, separated by a space, one pair of integers per line. 
 

Output
For each pair of input integers a and b you should output the sum of a and b, and followed by a blank line. 
 

Sample Input
1 5
10 20
 

Sample Output
6

30
 

```
import java.util.*;
class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m=sc.nextInt();
            int a= sc.nextInt();
            System.out.println(m+a);
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
