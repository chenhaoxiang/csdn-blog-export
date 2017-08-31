---
layout: post
title: "HDOJ 2101 A + B Problem Too"
date: 2016-02-10 04:10:41 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
This problem is also a A + B problem,but it has a little difference,you should determine does (a+b) could be divided with 86.For example ,if (A+B)=98,you should output no for resul 
---


Problem Description 
This problem is also a A + B problem,but it has a little difference,you should determine does (a+b) could be divided with 86.For example ,if (A+B)=98,you should output no for resul
<!-- more -->
----------

Problem Description
This problem is also a A + B problem,but it has a little difference,you should determine does (a+b) could be divided with 86.For example ,if (A+B)=98,you should output no for result.
 

Input
Each line will contain two integers A and B. Process to end of file.
 

Output
For each case, if(A+B)%86=0,output yes in one line,else output no in one line.
 

Sample Input
1 1
8600 8600
 

Sample Output
no
yes


水题水题！！

```
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            if((a+b)%86==0){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
            
            
            
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
