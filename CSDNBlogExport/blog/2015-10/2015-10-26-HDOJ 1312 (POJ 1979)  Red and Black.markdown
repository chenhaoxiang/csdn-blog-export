---
layout: post
title: "HDOJ 1312 (POJ 1979)  Red and Black"
date: 2015-10-26 06:51:33 +0800
comments: true
categories:----- HDOJ-C++,----- POJ-ACM
tags: [poj,hdoj]
keyword: 陈浩翔, 谙忆
description: Problem Description 
There is a rectangular room, covered with square tiles. Each tile is colored either red or black. A man is standing on a black tile. From a tile, he can move to one of four adjacen 
---


Problem Description 
There is a rectangular room, covered with square tiles. Each tile is colored either red or black. A man is standing on a black tile. From a tile, he can move to one of four adjacen
<!-- more -->
----------

Problem Description
There is a rectangular room, covered with square tiles. Each tile is colored either red or black. A man is standing on a black tile. From a tile, he can move to one of four adjacent tiles. But he can't move on red tiles, he can move only on black tiles. 

Write a program to count the number of black tiles which he can reach by repeating the moves described above. 
 

Input
The input consists of multiple data sets. A data set starts with a line containing two positive integers W and H; W and H are the numbers of tiles in the x- and y- directions, respectively. W and H are not more than 20. 

There are H more lines in the data set, each of which includes W characters. Each character represents the color of a tile as follows. 

'.' - a black tile 
'#' - a red tile 
'@' - a man on a black tile(appears exactly once in a data set) 
The end of the input is indicated by a line consisting of two zeros. 
 

Output
For each data set, your program should output a line which contains the number of tiles he can reach from the initial tile (including itself).
 

```
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
```

 

```
#include <iostream>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
char d[30][30];
bool vis[30][30];
int str[4][2]={{0,1},{1,0},{0,-1},{-1,0}};
int n,m,s;
using namespace std;

void dfs(int x,int y){
    for(int i=0;i<4;i++){
        int xx=x+str[i][0];
        int yy=y+str[i][1];
        if(xx>=0&&yy>=0&&xx<m&&yy<n&&d[xx][yy]=='.'&&vis[xx][yy]==0){
            s++;
           // printf("%d\n",s);
            vis[xx][yy]=1;
            dfs(xx,yy);
        }
        if(i==3)
            return ;
    }

}
int main()
{
    int a,b;
    while(~scanf("%d%d",&n,&m)&&(n||m)){
        for(int i=0;i<m;i++){
                scanf("%s",&d[i]);
            for(int j=0;j<n;j++){
                if(d[i][j]=='@'){
                    a=i;
                    b=j;
                }
            }
        }
        memset(vis,0,sizeof(vis));
        s=1;
        d[a][b]='#';
        dfs(a,b);
        printf("%d\n",s);
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
