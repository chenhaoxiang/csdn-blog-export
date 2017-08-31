---
layout: post
title: "HDOJ 2058 The sum problem"
date: 2016-01-31 09:48:37 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Given a sequence 1,2,3,……N, your job is to calculate all the possible sub-sequences that the sum of the sub-sequence is M.Input 
Input contains multiple test cases. each case conta 
---


Problem Description 
Given a sequence 1,2,3,……N, your job is to calculate all the possible sub-sequences that the sum of the sub-sequence is M.Input 
Input contains multiple test cases. each case conta
<!-- more -->
----------

Problem Description
Given a sequence 1,2,3,......N, your job is to calculate all the possible sub-sequences that the sum of the sub-sequence is M.
 

Input
Input contains multiple test cases. each case contains two integers N, M( 1 <= N, M <= 1000000000).input ends with N = M = 0.

 

Output
For each test case, print all the possible sub-sequence that its sum is M.The format is show in the sample below.print a blank line after each test case.

 

Sample Input
20 10
50 30
0 0
 

Sample Output
[1,4]
[10,10]

[4,8]
[6,9]
[9,11]
[30,30]


**题目的意思：输入两个整数N，M。 N, M( 1 <= N, M <= 1000000000)，如果在范围[1,M]内连续整数的和为N，按从小到大次序输出所有这样的连续段，当输入的M，N都为0时结束。**
计算的思路：
不考虑子列的终点，而是考虑子列的起点和子列元素的个数，分别记为i，j。由等差数列求和公式，得(i+(i+j-1))*j/2==M ，即（2*i+j-1）*j/2==M（2式），故得i=（2*M/j-j+1）/2，将i，j代回2式，成立则[i,i+j-1]满足条件。注意j最小为1，而由2式，得（j+2*i）*j=2*M，而i>=1，故j*j<=(int)sqrt(2*M).


```
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(m==0&&n==0){
                return ;
            }
            
            int j =(int)Math.pow(2.0*m, 0.5);
            for(j=j;j>0;j--){
                int i;
                i = (2*m/j-j+1)/2;
                if(j*(j+2*i-1)/2==m){
                    System.out.println("["+i+","+(i+j-1)+"]");
                }
            }
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
