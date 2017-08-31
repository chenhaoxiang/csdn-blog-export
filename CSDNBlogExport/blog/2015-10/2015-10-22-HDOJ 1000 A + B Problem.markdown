---
layout: post
title: "HDOJ 1000 A + B Problem"
date: 2015-10-22 03:54:39 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [hdoj]
keyword: 陈浩翔, 谙忆
description: Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others) 
Total Submission(s): 513689    Accepted Submission(s): 162876Problem Description 
Calculate A + B.Input 
Each line w 
---


Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others) 
Total Submission(s): 513689    Accepted Submission(s): 162876Problem Description 
Calculate A + B.Input 
Each line w
<!-- more -->
----------

Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
Total Submission(s): 513689    Accepted Submission(s): 162876


Problem Description
Calculate A + B.
 

Input
Each line will contain two integers A and B. Process to end of file.
 

Output
For each case, output A + B in one line.
 

Sample Input
1 1
 

Sample Output
2

```
import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      int A = sc.nextInt();
      int B = sc.nextInt();
      System.out.println(A+B);
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
