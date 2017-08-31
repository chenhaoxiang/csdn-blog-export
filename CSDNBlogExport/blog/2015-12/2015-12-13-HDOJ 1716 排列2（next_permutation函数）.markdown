---
layout: post
title: "HDOJ 1716 排列2（next_permutation函数）"
date: 2015-12-13 10:40:09 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❸ C/C++语言基础,----- C/C++函数应用
tags: [函数]
keyword: 陈浩翔, 谙忆
description: 先讲下用这个函数来求，后面有递归的方法。 
用了两种方法。这是一个求一个排序的下一个排列的函数，可以遍历全排列,要包含头文件
下面是以前的笔记    与之完全相反的函数还有prev_permutation
(1) int 类型的next_permutation
int main()
{
 int a[3];
a[0]=1;a[1]=2;a[2]=3;
 do
{
cout<<a[0]<<" "<<a 
---


先讲下用这个函数来求，后面有递归的方法。 
用了两种方法。这是一个求一个排序的下一个排列的函数，可以遍历全排列,要包含头文件
下面是以前的笔记    与之完全相反的函数还有prev_permutation
(1) int 类型的next_permutation
int main()
{
 int a[3];
a[0]=1;a[1]=2;a[2]=3;
 do
{
cout<<a[0]<<" "<<a
<!-- more -->
----------

先讲下用这个函数来求，后面有递归的方法。
用了两种方法。
```
这是一个求一个排序的下一个排列的函数，可以遍历全排列,要包含头文件
下面是以前的笔记    与之完全相反的函数还有prev_permutation
(1) int 类型的next_permutation
int main()
{
 int a[3];
a[0]=1;a[1]=2;a[2]=3;
 do
{
cout<<a[0]<<" "<<a[1]<<" "<<a[2]<<endl;//输入a[0],a[1],a[2];
} while (next_permutation(a,a+3)); //参数3指的是要进行排列的长度
//如果存在a之后的排列，就返回true。如果a是最后一个排列没有后继，返回false，每执行一次，a就变成它的后继
}
输出：
 1 2 3
 1 3 2
 2 1 3
 2 3 1
 3 1 2
 3 2 1
如果改成 while(next_permutation(a,a+2));
则输出：
 1 2 3
 2 1 
只对前两个元素进行字典排序
显然，如果改成 while(next_permutation(a,a+1)); 则只输出：1 2 3
若排列本来就是最大的了没有后继，则next_permutation执行后，会对排列进行字典升序排序,相当于循环
 int list[3]={3,2,1};
next_permutation(list,list+3);
cout<<list[0]<<" "<<list[1]<<" "<<list[2]<<endl;
//输出: 1 2 3 
```
例题：
Problem B
Time Limit : 1000/1000ms (Java/Other) Memory Limit : 32768/32768K (Java/Other)
Total Submission(s) : 27 Accepted Submission(s) : 10
Problem Description
Ray又对数字的列产生了兴趣：
现有四张卡片，用这四张卡片能排列出很多不同的4位数，要求按从小到大的顺序输出这些4位数。



Input
每组数据占一行，代表四张卡片上的数字（0<=数字<=9），如果四张卡片都是0，则输入结束。


Output
对每组卡片按从小到大的顺序输出所有能由这四张卡片组成的4位数，千位数字相同的在同一行，同一行中每个四位数间用空格分隔。每组输出数据间空一行，最后一组数据后面没有空行。


Sample Input
1 2 3 4
1 1 2 3
0 1 2 3
0 0 0 0


Sample Output
1234 1243 1324 1342 1423 1432
2134 2143 2314 2341 2413 2431
3124 3142 3214 3241 3412 3421
4123 4132 4213 4231 4312 4321
 
1123 1132 1213 1231 1312 1321
2113 2131 2311
3112 3121 3211
 
1023 1032 1203 1230 1302 1320
2013 2031 2103 2130 2301 2310
3012 3021 3102 3120 3201 3210


```

#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <string.h>
using namespace std;


int main()
{
    int a[5],i,j,k,m=0;
    while(~scanf("%d%d%d%d",&a[1],&a[2],&a[3],&a[4]))
    {
        if(a[1]==0&&a[2]==0&&a[3]==0&&a[4]==0)
            return 0;
        if(m)
            printf("\n");
        m=1;
        k=1;int h;
        do
        {
            if(a[1]==0)
                continue;
            if(k==1)
            {
                printf("%d%d%d%d",a[1],a[2],a[3],a[4]);
                k=0;
            }
            else
            {
            if(h==a[1])
                printf(" %d%d%d%d",a[1],a[2],a[3],a[4]);
            else
                printf("\n%d%d%d%d",a[1],a[2],a[3],a[4]);
            }
            h=a[1];
        }
        while(next_permutation(a+1,a+5));
        printf("\n");
    }
    return 0;
}



算法描述：

1、从尾部开始往前寻找两个相邻的元素

第1个元素i，第2个元素j（从前往后数的），且i

2、再从尾往前找第一个大于i的元素k。将i、k对调

3、[j,last)范围的元素置逆（颠倒排列）

 

这个题目用递归也可以做：

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int a[6],vis[5],t,sol[5],last;
void dfs(int c)
{
    if(c==5)
    {
        if(sol[1]==0)
            return;    //千位是0的不符合
        if(t!=0 && sol[1]==last)
            printf(" ");  //一行的最后一个数后面不能输出空格
        if(t!=0 && sol[1]!=last)
        {
            printf("\n");   //千位不同则换行
        }
        last=sol[1]; //记录上一个的千位
        int j=1;
        for(j;j<=4;j++)
        {
            printf("%d",sol[j]);
        }
        t++;
    }
    int i;
    for(i = 1 ;  i <= 4 ;  i++)
    {
        if(vis[i]==0)
        {
            vis[i]=1;
            sol[c]=a[i];
            dfs(c+1);
            vis[i]=0;
            while(a[i]==a[i+1])
              i++;
//关键: 去重复
//因为题目的输入是从小到大（否则先排序），所以如果在一轮排列结束后
        }
        //如果后一个将要被选的数与上一轮这个下标的数相同，则跳过
//比如1 1 1 2，第一轮1 1 1 2，返回上一次dfs后sol[3]=2,sol[4]=1
}
//返回到c=2，此时a[2]==a[3]=1,若再选1则为1 1 1 2，
///跳过则为1 2 1 1
}
int main()
{
    int i,T=0;
    while(scanf("%d%d%d%d",&a[1],&a[2],&a[3],&a[4]))
    {
        if(a[1]==0&&a[2]==0&&a[3]==0&&a[4]==0) break;
        if(T!=0) printf("\n");
        T=1;
        memset(vis,0,sizeof(vis));
        t=0;
        dfs(1);
        printf("\n");
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
