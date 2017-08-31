---
layout: post
title: "HDOJ(HDU) 2139 Calculate the formula(水题，又一个用JavaAC不了的题目)"
date: 2016-05-05 01:57:40 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,----- HDOJ-JAVA
tags: []
keyword: 陈浩翔, 谙忆
description: Time Limit: 1000/1000 MS (Java/Others)    Memory Limit: 32768/32768 K (Java/Others) 
看到这个时间，我懵逼了。。。 
果然，Java就是打表，都不能AC，因为Java的输入是流，需要的时间比C真的长好多。。。。Problem Description 
You just need to calculate the su 
---


Time Limit: 1000/1000 MS (Java/Others)    Memory Limit: 32768/32768 K (Java/Others) 
看到这个时间，我懵逼了。。。 
果然，Java就是打表，都不能AC，因为Java的输入是流，需要的时间比C真的长好多。。。。Problem Description 
You just need to calculate the su
<!-- more -->
----------

Time Limit: 1000/1000 MS (Java/Others)    Memory Limit: 32768/32768 K (Java/Others)
看到这个时间，我懵逼了。。。
果然，Java就是打表，都不能AC，因为Java的输入是流，需要的时间比C真的长好多。。。。

Problem Description
You just need to calculate the sum of the formula: 1^2+3^2+5^2+……+ n ^2.
 

Input
In each case, there is an odd positive integer n.
 

Output
Print the sum. Make sure the sum will not exceed 2^31-1
 

Sample Input
3
 

Sample Output
10


简单题，就不翻译了。
附上AC的C语言代码：

```
#include<iostream>
const int MAX=2345;
//计算2345正好大于2^31-1，输入输出用scanf和printf不能cin和cout不然超时
__int64 db[MAX];
using namespace std;
int main()
{
    int n,m,i;
    db[1]=1;
    //打表法 
    for(i=3;i<=MAX;i+=2)
    {
        db[i]=db[i-2]+i*i;
    }
    while(scanf("%d",&n)!=EOF)
    {
        printf("%I64d\n",db[n]);
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
