---
layout: post
title: "scanf从文件中读入，printf写入到文件"
date: 2015-09-10 09:22:35 +0800
comments: true
categories:❸ C/C++语言基础
tags: [printf]
keyword: 陈浩翔, 谙忆
description: #include <iostream>
#include <stdio.h>
#define LOCAL
using namespace std;int main()
{
    #ifdef LOCAL
    freopen("input.txt","r",stdin);
    //使得scanf从文件input.txt读入
    //r只读，如果文件不存在，出错
    freopen(" 
---


#include <iostream>
#include <stdio.h>
#define LOCAL
using namespace std;int main()
{
    #ifdef LOCAL
    freopen("input.txt","r",stdin);
    //使得scanf从文件input.txt读入
    //r只读，如果文件不存在，出错
    freopen("
<!-- more -->
----------

重定向方式读写文件
```
#include <stdio.h>
#define LOCAL
int main()
{
    #ifdef LOCAL
    freopen("input.txt","r",stdin);
    //使得scanf从文件input.txt读入
    //r只读，如果文件不存在，出错
    freopen("output.txt","w",stdout);
    //使得printf写入文件output.txt
    //w只写，如果文件不存在，建立新文件
    #endif
    //只有定义了符号LOCAL，才编译2条freopen语句。
    int j;
    scanf("%d",&j);
    for(int i=0;i<5;i++)
        printf("%d\n",i);
    printf("%d\n",j);
    return 0;
}

```
非重定向方式读写文件

```
int main()
{
    FILE *fin,*fout;
    fin=fopen("data.in.txt","r");
    fout=fopen("data.out.txt","w");
    int j;
    fscanf(fin,"%d",&j);
    for(int i=0;i<5;i++)
        fprintf(fout,"%d\n",i);
    fprintf(fout,"%d\n",j);
    fclose(fin);
    fclose(fout);
    return 0;
}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
