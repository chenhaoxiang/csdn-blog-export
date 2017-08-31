---
layout: post
title: "HDOJ HDU Tempter of the Bone(深搜+奇偶性剪枝)"
date: 2016-07-04 02:21:25 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❺ 算法及基础题,----- 递归搜索回溯
tags: [深搜,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
The doggie found a bone in an ancient maze, which fascinated him a lot. However, when he picked it up, the maze began to shake, and the doggie could feel the ground sinking. He rea 
---


Problem Description 
The doggie found a bone in an ancient maze, which fascinated him a lot. However, when he picked it up, the maze began to shake, and the doggie could feel the ground sinking. He rea
<!-- more -->
----------

Problem Description
The doggie found a bone in an ancient maze, which fascinated him a lot. However, when he picked it up, the maze began to shake, and the doggie could feel the ground sinking. He realized that the bone was a trap, and he tried desperately to get out of this maze.

The maze was a rectangle with sizes N by M. There was a door in the maze. At the beginning, the door was closed and it would open at the T-th second for a short period of time (less than 1 second). Therefore the doggie had to arrive at the door on exactly the T-th second. In every second, he could move one block to one of the upper, lower, left and right neighboring blocks. Once he entered a block, the ground of this block would start to sink and disappear in the next second. He could not stay at one block for more than one second, nor could he move into a visited block. Can the poor doggie survive? Please help him.

 

Input
The input consists of multiple test cases. The first line of each test case contains three integers N, M, and T (1 < N, M < 7; 0 < T < 50), which denote the sizes of the maze and the time at which the door will open, respectively. The next N lines give the maze layout, with each line containing M characters. A character is one of the following:

'X': a block of wall, which the doggie cannot enter; 
'S': the start point of the doggie; 
'D': the Door; or
'.': an empty block.

The input is terminated with three 0's. This test case is not to be processed.

 

Output
For each test case, print in one line "YES" if the doggie can survive, or "NO" otherwise.

 

Sample Input
4 4 5
S.X.
..X.
..XD
....
3 4 5
S.X.
..X.
...D
0 0 0
 

Sample Output
NO
YES

题意：
老鼠需要跑出迷宫，在每个位置停留1s，入口是S（老鼠一开始在这里），需要在T时刻正好跑到D位置（出口）。求老鼠能不能成功逃脱。

<b><font color="red" size="4">
一开始我没有用剪枝，果断超时。
还有，好久没用c语言A题了，char输入时~回车绞了我半小时的思维。。
奇偶性剪枝有关内容大家可以百度搜下，我就不写了，我是自己推出来的，和有些版本不一样。
</fong></b>
```
#include <stdio.h>
#include <string.h>
char map[10][10];
int df[10][10];
int sx,sy,dx,dy;
int ans,flag,t,x,y;
void dfs(int xd,int yd,int c){
    //printf("%d %d %d %d\n",xd,yd,c,flag);
    if(xd<0||yd<0){
        return;
    }
    int b=t-c;
    if((xd%2==0&&yd%2!=0)||(xd%2!=0&&yd%2==0)){
        if(b%2!=0){
            if(!((dx%2==0&&dy%2==0)||(dx%2!=0&&dy%2!=0))){
                return;
            }
        }else{
            if(!((dx%2!=0&&dy%2==0)||(dx%2==0&&dy%2!=0))){
                return;
            }
        }
    }else{
        if(b%2==0){
            if(!((dx%2==0&&dy%2==0)||(dx%2!=0&&dy%2!=0))){
                return;
            }
        }else{
            if(!((dx%2!=0&&dy%2==0)||(dx%2==0&&dy%2!=0))){
                return;
            }
        }
    }
    if(map[xd][yd]=='X'||df[xd][yd]||flag){
        return;
    }
    if(c>t){
        return;
    }

    if(c==t&&dx==xd&&dy==yd){
        flag=1;
        return;
    }

    df[xd][yd]=1;
    dfs(xd-1,yd,c+1);
    dfs(xd,yd-1,c+1);
    dfs(xd+1,yd,c+1);
    dfs(xd,yd+1,c+1);
    df[xd][yd]=0;
}

int main(){
    while(scanf("%d%d%d",&x,&y,&t),x||y||t){
        memset(df,0,sizeof(df));
        int i,j;
        ans=0;
        flag=0;
        for(i=0;i<10;i++){
            for(j=0;j<10;j++){
                map[i][j]='X';
            }
        }
        getchar();
        for(i=0;i<x;i++){
            for(j=0;j<y;j++){
                scanf("%c",&map[i][j]);
                if(map[i][j]=='S'){
                    sx=i;sy=j;
                }else if(map[i][j]=='D'){
                    dx=i;dy=j;ans++;
                }else if(map[i][j]=='.'){
                    ans++;
                }
            }
            getchar();
        }
       // printf("%d %d\n",ans,t);
        if(ans<t){
            printf("NO\n");
            continue;
        }
        dfs(sx,sy,0);
        if(flag){
            printf("YES\n");
        }else{
            printf("NO\n");
        }
       // printf("%d",flag);
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
