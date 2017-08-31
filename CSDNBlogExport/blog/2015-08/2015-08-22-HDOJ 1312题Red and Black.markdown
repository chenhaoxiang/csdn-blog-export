---
layout: post
title: "HDOJ 1312题Red and Black"
date: 2015-08-22 10:59:23 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❺ 算法及基础题,----- 递归搜索回溯
tags: []
keyword: 陈浩翔, 谙忆
description: Red and Black 
Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others) 
Total Submission(s): 13508    Accepted Submission(s): 8375Problem Description 
There is a rectangular 
---


Red and Black 
Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others) 
Total Submission(s): 13508    Accepted Submission(s): 8375Problem Description 
There is a rectangular
<!-- more -->
----------

Red and Black
Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
Total Submission(s): 13508    Accepted Submission(s): 8375


Problem Description
There is a rectangular room, covered with square tiles. Each tile is colored either red or black. A man is standing on a black tile. From a tile, he can move to one of four adjacent tiles. But he can't move on red tiles, he can move only on black tiles.

Write a program to count the number of black tiles which he can reach by repeating the moves described above. 

 

Input
The input consists of multiple data sets. A data set starts with a line containing two positive integers W and H; W and H are the numbers of tiles in the x- and y- directions, respectively. W and H are not more than 20.

There are H more lines in the data set, each of which includes W characters. Each character represents the color of a tile as follows.

'.' - a black tile 
'#' - a red tile 
'@' - a man on a black tile(appears exactly once in a data set) 

 

Output
For each data set, your program should output a line which contains the number of tiles he can reach from the initial tile (including itself). 

 

Sample Input
6 9
....#.
.....#
......
......
......
......
......
#@...#
.#..#.
11 9
.#.........
.#.#######.
.#.#.....#.
.#.#.###.#.
.#.#..@#.#.
.#.#####.#.
.#.......#.
.#########.
...........
11 6
..#..#..#..
..#..#..#..
..#..#..###
..#..#..#@.
..#..#..#..
..#..#..#..
7 7
..#.#..
..#.#..
###.###
...@...
###.###
..#.#..
..#.#..
0 0
 

Sample Output
45
59
6
13

题意：
   n*m的方阵有红格或是黑格，只能走黑格
    每次只能走上下左右四个紧邻方向的格子，求
    这个人最后能走多少个黑格子。
 
分析：
   dfs水题。从第一个黑格子开始递归的搜索，
    每次搜索一个黑格子后为了以后不再重复走
    这个黑格子，就把当前搜索的这个黑格子换
    成红格子，然后继续dfs。。。
    
题目链接：http://acm.hdu.edu.cn/showproblem.php?pid=1312；
题目大意：一个长方形空间，上面铺红色和黑色瓦片，一个人起初站在黑色瓦片上，每次可以走到相邻的4个黑色瓦片上，输入数据，求其能走过多少瓦片
题意：某人在@处为起点（也包括@点）#为墙，点（.）为通路，问最多能走多远统计能走几个点（加上@这个点）
思路：用dfs；
代码：

```
#include <stdio.h>
#include <stdlib.h>
#include<string.h>
char a[30][30];
int ss,n,m;//这3个值需要用全局变量
int b[4][2]= {{0,-1},{0,1},{1,0},{-1,0}};
int dfs(int x,int y)
{
    int xx,yy;
    if(x<0||y<0||x>=m||y>=n)
        return 0;
    int i;
    for(i=0; i<4; i++)
    {
        xx=x+b[i][0];
        yy=y+b[i][1];
        if(xx<0||yy<0||xx>=m||yy>=n||a[xx][yy]=='#')
        //检查该点上下左右的点是否符合题目要求。   
            continue;
        ss++;
        a[xx][yy]='#';
        //如果该点已经检查过，就把它变成'#',防止再次被检查。   
        dfs(xx,yy);
    }
}
int main()
{

    while(~scanf("%d%d",&n,&m)&&(n||m))//n,m不能同时为0
    {
        int i,j;
        int pi,pj;
        getchar();//吸收换行符。  
        for(i=0; i<m; i++)
        {
            for(j=0; j<n; j++)
            {
                scanf("%c",&a[i][j]);
                if(a[i][j]=='@')
                {
                    pi=i;
                    pj=j;
                }
            }
            getchar();//吸收换行符。   
        }
        a[pi][pj]='#';
        ss=1;
        dfs(pi,pj);
        printf("%d\n",ss);
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
