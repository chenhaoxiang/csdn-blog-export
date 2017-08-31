---
layout: post
title: "HDOJ 1094 A+B for Input-Output Practice (VI)"
date: 2015-10-22 04:05:43 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [lines]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Your task is to calculate the sum of some integers.Input 
Input contains multiple test cases, and one case one line. Each case starts with an integer N, and then N integers follow 
---


Problem Description 
Your task is to calculate the sum of some integers.Input 
Input contains multiple test cases, and one case one line. Each case starts with an integer N, and then N integers follow
<!-- more -->
----------

Problem Description
Your task is to calculate the sum of some integers.
 

Input
Input contains multiple test cases, and one case one line. Each case starts with an integer N, and then N integers follow in the same line. 
 

Output
For each test case you should output the sum of N integers in one line, and with one line of output for each line in input. 
 

Sample Input
4 1 2 3 4
5 1 2 3 4 5
 

Sample Output
10
15

```
import java.util.*;
class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m=sc.nextInt();
            int sum=0;
            for(int i=0;i<m;i++){
                int a= sc.nextInt();
                sum+=a;
            }
            System.out.println(sum);
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
