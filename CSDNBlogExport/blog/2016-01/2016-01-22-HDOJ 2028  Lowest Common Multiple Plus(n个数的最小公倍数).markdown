---
layout: post
title: "HDOJ 2028  Lowest Common Multiple Plus(n个数的最小公倍数)"
date: 2016-01-22 02:50:20 +0800
comments: true
categories:----- HDOJ-JAVA,❶ ACM,❺ 算法及基础题,----- 公约数公倍数
tags: [JAVA]
keyword: 陈浩翔, 谙忆
description: Problem Description 
求n个数的最小公倍数。Input 
输入包含多个测试实例，每个测试实例的开始是一个正整数n，然后是n个正整数。Output 
为每组测试数据输出它们的最小公倍数，每个测试实例的输出占一行。你可以假设最后的输出是一个32位的整数。Sample Input 
2 4 6 
3 2 5 7Sample Output 
12 
70这个题主要注意的就是怎么去求2个数 
---


Problem Description 
求n个数的最小公倍数。Input 
输入包含多个测试实例，每个测试实例的开始是一个正整数n，然后是n个正整数。Output 
为每组测试数据输出它们的最小公倍数，每个测试实例的输出占一行。你可以假设最后的输出是一个32位的整数。Sample Input 
2 4 6 
3 2 5 7Sample Output 
12 
70这个题主要注意的就是怎么去求2个数
<!-- more -->
----------

Problem Description
求n个数的最小公倍数。
 

Input
输入包含多个测试实例，每个测试实例的开始是一个正整数n，然后是n个正整数。
 

Output
为每组测试数据输出它们的最小公倍数，每个测试实例的输出占一行。你可以假设最后的输出是一个32位的整数。
 

Sample Input
2 4 6
3 2 5 7
 

Sample Output
12
70

这个题主要注意的就是怎么去求2个数的最小公倍数。
每次求2个数的最小公倍数，再用这个最小公倍数和下一个数求最小公倍数，以此类推。。。

```
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){
            int n = sc.nextInt();
            int res = sc.nextInt();
            while(n-->1){
                int a = sc.nextInt();
                res = Lcmm(res,a);
            }
            System.out.println(res);
        }
        
        
    }

    private static int Lcmm(int res, int a) {
        int m = res/gcd(res,a) *a;
        //System.out.println("m= "+m);
        return m;
    }

    private static int gcd(int res, int a) {
        int c = res%a;
        while(c!=0){
            res =a;
            a=c;
            c=res%a;
            //System.out.println("a");
        }
        return a;
    }
}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
