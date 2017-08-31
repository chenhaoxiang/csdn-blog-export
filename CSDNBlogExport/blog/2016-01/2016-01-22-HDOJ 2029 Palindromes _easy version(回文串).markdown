---
layout: post
title: "HDOJ 2029 Palindromes _easy version(回文串)"
date: 2016-01-22 03:15:53 +0800
comments: true
categories:----- HDOJ-JAVA,❶ ACM,----- 逆序数和回文串,❺ 算法及基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。请写一个程序判断读入的字符串是否是“回文”。Input 
输入包含多个测试实例，输入数据的第一行是一个正整数n,表示测试实例的个数，后面紧跟着是n个字符串。Output 
如果一个字符串是回文串，则输出”yes”,否则输出”no”.Sample Input 
4 
l 
---


Problem Description 
“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。请写一个程序判断读入的字符串是否是“回文”。Input 
输入包含多个测试实例，输入数据的第一行是一个正整数n,表示测试实例的个数，后面紧跟着是n个字符串。Output 
如果一个字符串是回文串，则输出”yes”,否则输出”no”.Sample Input 
4 
l
<!-- more -->
----------

Problem Description
“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。请写一个程序判断读入的字符串是否是“回文”。
 

Input
输入包含多个测试实例，输入数据的第一行是一个正整数n,表示测试实例的个数，后面紧跟着是n个字符串。

 

Output
如果一个字符串是回文串，则输出"yes",否则输出"no".

 

Sample Input
4
level
abcde
noon
haha
 

Sample Output
yes
no
yes
no


水过，水过~~

```
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.next();
        while(n-->0){
            boolean isNo = false;
            String strs = sc.nextLine();
            
            for(int i=0;i<strs.length()/2;i++){
                if(strs.charAt(i) != strs.charAt(strs.length()-i-1)){
                    System.out.println("no");
                    isNo = true;
                    break;
                }
            }
            if(!isNo)
            System.out.println("yes");
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
