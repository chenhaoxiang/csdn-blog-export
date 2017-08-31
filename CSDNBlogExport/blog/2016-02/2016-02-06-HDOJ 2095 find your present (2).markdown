---
layout: post
title: "HDOJ 2095 find your present (2)"
date: 2016-02-06 02:55:12 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,----- HDOJ-JAVA,❺ 算法及基础题,----- 异或^
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
In the new year party, everybody will get a “special present”.Now it’s your turn to get your special present, a lot of presents now putting on the desk, and only one of them will b 
---


Problem Description 
In the new year party, everybody will get a “special present”.Now it’s your turn to get your special present, a lot of presents now putting on the desk, and only one of them will b
<!-- more -->
----------

Problem Description
In the new year party, everybody will get a "special present".Now it's your turn to get your special present, a lot of presents now putting on the desk, and only one of them will be yours.Each present has a card number on it, and your present's card number will be the one that different from all the others, and you can assume that only one number appear odd times.For example, there are 5 present, and their card numbers are 1, 2, 3, 2, 1.so your present will be the one with the card number of 3, because 3 is the number that different from all the others.
 

Input
The input file will consist of several cases. 
Each case will be presented by an integer n (1<=n<1000000, and n is odd) at first. Following that, n positive integers will be given in a line, all integers will smaller than 2^31. These numbers indicate the card numbers of the presents.n = 0 ends the input.
 

Output
For each case, output an integer in a line, which is the card number of your present.
 

Sample Input
5
1 1 3 2 2
3
1 2 1
0
 

Sample Output
3
2

题目意思是：有唯一一个出现奇数次的数，请找出它！


————位异或。
我们先了解一下位异或的运算法则吧：
1、a^b = b^a。
2、(a^b)^c = a^(b^c)。
3、a^b^a = b。
对于一个任意一个数n，它有几个特殊的性质：
1、0^n = n。
2、n^n = 0。
所以可以通过每次异或运算，最后剩下的值就是出现奇数次的那个数字。


这个题目用java过不了！
下面附上c代码和java的超时代码：
![](http://img.blog.csdn.net/20160206145459742)

```
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            if(m==0){
                return ;
            }
            int x=0;
            for(int i=0;i<m;i++){
                int n =sc.nextInt();
                x=x^n;
            }
            System.out.println(x);
        }
    }
}

```

下面为c的：

```
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int m;
    while(scanf("%d",&m)&&m!=0){
        int x=0;
        int i;
        for(i=0;i<m;i++){
            int n;
            scanf("%d",&n);
            x^=n;

        }
        printf("%d\n",x);
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
