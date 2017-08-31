---
layout: post
title: "POJ 1159  Palindrome   最长公共子序列的问题"
date: 2015-10-29 02:03:48 +0800
comments: true
categories:❶ ACM,----- POJ-ACM,❺ 算法及基础题,----- 动态规划（DP）
tags: [poj]
keyword: 陈浩翔, 谙忆
description: Description 
A palindrome is a symmetrical string, that is, a string read identically from left to right as well as from right to left. You are to write a program which, given a string, determines the 
---


Description 
A palindrome is a symmetrical string, that is, a string read identically from left to right as well as from right to left. You are to write a program which, given a string, determines the
<!-- more -->
----------

Description
A palindrome is a symmetrical string, that is, a string read identically from left to right as well as from right to left. You are to write a program which, given a string, determines the minimal number of characters to be inserted into the string in order to obtain a palindrome. 

As an example, by inserting 2 characters, the string "Ab3bd" can be transformed into a palindrome ("dAb3bAd" or "Adb3bdA"). However, inserting fewer than 2 characters does not produce a palindrome. 
Input

Your program is to read from standard input. The first line contains one integer: the length of the input string N, 3 <= N <= 5000. The second line contains one string with length N. The string is formed from uppercase letters from 'A' to 'Z', lowercase letters from 'a' to 'z' and digits from '0' to '9'. Uppercase and lowercase letters are to be considered distinct.
Output

Your program is to write to standard output. The first line contains one integer, which is the desired minimal number.
Sample Input

5
Ab3bd
Sample Output

2

设原序列S的逆序列为S' ，这道题目的关键在于，
最少需要补充的字母数 = 原序列S的长度 —  S和S'的最长公共子串长度

题意：
给你一串字符串，让你求最少加入几个字符，才能使得这个字符串是个回文串。
做法：
设a[i]是这个字符串,b[i]是这个字符串的逆序串。
那么a[i],b[i]的最长公共子序列就是所求的字符串里拥有的最大的回文串。（我不知道这个结论是怎么来的，求大牛评论）
然后用总串长减去最大的回文串长度即为所求。
求最长公共子序列的公式为：
dp[i][j]=max(dp[i-1] [j],dp[i][j-1])
if(a[i]==b[i])
dp[i][j]=max(dp[i][j],dp[i-1][j-1]+1);

分析：简单做法是直接对它和它的逆序串求最长公共子序列长度len。n-len即为所求。(n为原串长度)

这样做的原因如下：

要求最少添加几个字符，我们可以先从原串中找到一个最长回文串，然后对于原串中不属于这个回文串的字符，在它关于回文串中心的对称位置添加一个相同字符即可。那么需要添加的字符数量即为n-最长回文串长度。

最长回文串可以看作是原串中前面和后面字符的一种匹配（每个后面的字符在前面找到一个符合位置要求的与它相同的字符）。这种的回文匹配和原串与逆序串的公共子序列是一一对应的（一个回文匹配对应一个公共子序列，反之亦然），而且两者所涉及到的原串中的字符数量是相等的，也就是最长公共子序列对应最长回文串。原因陈述完毕。

 

还有另一个动态规划的方法。

f[i][j]表示从i到j这段子串若变为回文串最少添加的字符数。

if (st[i] == st[j])
                f[i][j] = f[i + 1][j - 1];
else
                f[i][j] = min(f[i + 1][j], f[i][j - 1]) + 1;


本来是想用滚动数组做的，可是发现自己并不懂原理，就先没用了，看网上说数组开成short int 可以过。。。
```
#include <iostream>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define max(a,b)  (a>b?a:b)
using namespace std;
short int s[5001][5001];
int main(){
    int a[5001];
    int b[5001];
    char str;
    int n;
    cin>>n;
    getchar();
        for(int i=1,j=n;i<=n;i++,j--){
            scanf("%c",&str);
            a[i]=str;
            b[j]=str;
        }
        for(int i=0;i<=n;i++){
            s[0][i]=0;
            s[i][0]=0;
        }
//        memset(s,0,sizeof(s));
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                s[i][j]=max(s[i][j-1],s[i-1][j]);
                if(a[i]==b[j])
                    s[i][j]=max(s[i][j],s[i-1][j-1]+1);
            }
        }
    int len;
    len = s[n][n];
    printf("%d\n",n-len);
    return 0;
}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
