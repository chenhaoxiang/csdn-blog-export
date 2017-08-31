---
layout: post
title: "HDOJ HDU 1241 Oil Deposits(经典DFS)"
date: 2016-07-05 05:01:29 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❺ 算法及基础题,----- 递归搜索回溯
tags: [dfs,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
The GeoSurvComp geologic survey company is responsible for detecting underground oil deposits. GeoSurvComp works with one large rectangular region of land at a time, and creates a 
---


Problem Description 
The GeoSurvComp geologic survey company is responsible for detecting underground oil deposits. GeoSurvComp works with one large rectangular region of land at a time, and creates a
<!-- more -->
----------

Problem Description
The GeoSurvComp geologic survey company is responsible for detecting underground oil deposits. GeoSurvComp works with one large rectangular region of land at a time, and creates a grid that divides the land into numerous square plots. It then analyzes each plot separately, using sensing equipment to determine whether or not the plot contains oil. A plot containing oil is called a pocket. If two pockets are adjacent, then they are part of the same oil deposit. Oil deposits can be quite large and may contain numerous pockets. Your job is to determine how many different oil deposits are contained in a grid. 

 

Input
The input file contains one or more grids. Each grid begins with a line containing m and n, the number of rows and columns in the grid, separated by a single space. If m = 0 it signals the end of the input; otherwise 1 <= m <= 100 and 1 <= n <= 100. Following this are m lines of n characters each (not counting the end-of-line characters). Each character corresponds to one plot, and is either `*', representing the absence of oil, or `@', representing an oil pocket.

 

Output
For each grid, output the number of distinct oil deposits. Two different pockets are part of the same oil deposit if they are adjacent horizontally, vertically, or diagonally. An oil deposit will not contain more than 100 pockets.

 

Sample Input

```
1 1
*
3 5
*@*@*
**@**
*@*@*
1 8
@@****@*
5 5 
****@
*@@*@
*@**@
@@@*@
@@**@
0 0 
```

 

Sample Output
0
1
2
2


题意：
*代表荒地，@代表油田。@的上下左右，还有对角的4个如果还有@，就表示它们是一个油田，问-给出的图中，一共有多少油田。

分析：
本题用DFS（深搜）可以很好的解决问题！

```
#include <iostream>
#include <stdio.h>
#include <string.h>
using namespace std;
char map[210][210];
int df[210][210];
int con,n,m;
void dfs(int x,int y,int t){

    if(df[x][y]==1||x<0||y<0||x>=n||y>=m){
        return;
    }
    if(map[x][y]=='*'){
        return;
    }
    if(t==1&&map[x][y]=='@'){
        con++;
        //printf("con=%d\n",con);
    }

    //printf("%d %d\n",x,y);
    if(map[x][y]=='@'){
        map[x][y]='*';
        df[x][y]=1;
        dfs(x+1,y+1,0);
        dfs(x-1,y-1,0);
        dfs(x+1,y,0);
        dfs(x,y+1,0);
        dfs(x-1,y,0);
        dfs(x,y-1,0);
        dfs(x+1,y-1,0);
        dfs(x-1,y+1,0);
        df[x][y]=0;
    }

}

int main()
{
    while(~scanf("%d%d",&n,&m),(n||m)){
        memset(df,0,sizeof(df));
        con=0;
        getchar();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                scanf("%c",&map[i][j]);
            }
            getchar();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(i,j,1);
            }
        }
        printf("%d\n",con);
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
