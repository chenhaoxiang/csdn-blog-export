---
layout: post
title: "HDOJ HDU 1242 Rescue(经典BFS深搜-优先队列)"
date: 2016-07-10 05:09:07 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❺ 算法及基础题,----- 递归搜索回溯
tags: [bfs,acm,深搜,优先队列]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Angel was caught by the MOLIGPY! He was put in prison by Moligpy. The prison is described as a N * M (N, M <= 200) matrix. There are WALLs, ROADs, and GUARDs in the prison.Angel’s 
---


Problem Description 
Angel was caught by the MOLIGPY! He was put in prison by Moligpy. The prison is described as a N * M (N, M <= 200) matrix. There are WALLs, ROADs, and GUARDs in the prison.Angel’s
<!-- more -->
----------

Problem Description
Angel was caught by the MOLIGPY! He was put in prison by Moligpy. The prison is described as a N * M (N, M <= 200) matrix. There are WALLs, ROADs, and GUARDs in the prison.

Angel's friends want to save Angel. Their task is: approach Angel. We assume that "approach Angel" is to get to the position where Angel stays. When there's a guard in the grid, we must kill him (or her?) to move into the grid. We assume that we moving up, down, right, left takes us 1 unit time, and killing a guard takes 1 unit time, too. And we are strong enough to kill all the guards.

You have to calculate the minimal time to approach Angel. (We can move only UP, DOWN, LEFT and RIGHT, to the neighbor grid within bound, of course.)
 

Input
First line contains two integers stand for N and M.

Then N lines follows, every line has M characters. "." stands for road, "a" stands for Angel, and "r" stands for each of Angel's friend.

Process to the end of the file.
 

Output
For each test case, your program should output a single integer, standing for the minimal time needed. If such a number does no exist, you should output a line containing "Poor ANGEL has to stay in the prison all his life."
 

Sample Input

7 8

```
#.#####.
#.a#..r.
#..#x...
..#..#.#
#...##..
.#......
........
```

 

Sample Output

13

又是一道经典的深搜题，做了1180题再来做这个，就是秒A啊。
说下题意：
<font color="green" size="4">
天使被关在了一个监狱里面，a代表天使，r代表天使的朋友，x是警卫，#是墙。r可以杀死所以的警卫，杀一个警卫需要1个单位时间，移动一步也需要一个单位时间。问，天使的朋友r最短需要多久才可以把天使a救出来。
如果不能救出天使，输出:Poor ANGEL has to stay in the prison all his life.</font>

```
#include <iostream>
#include <cstdio>
#include <cstring>
#include<queue>
using namespace std;
struct node{
    int x,y,t;
    friend bool operator<(node n1,node n2){
        return n2.t<n1.t;
    }
};
int n,m;
char map[210][210];
int d[210][210];
int ax,ay,rx,ry;
node ft;
int mx[]={1,0,-1,0};
int my[]={0,-1,0,1};

int judge(int x,int y){
    if(x<0||x>=n||y<0||y>=m){
        return 0;
    }
    if(map[x][y]=='#'){
        return 0;
    }
    if(d[x][y]){
        return 0;
    }
    return 1;
}

void bfs(){
    priority_queue<node> q;
    ft.x=rx;
    ft.y=ry;
    ft.t=0;
    q.push(ft);
    d[rx][ry]=1;
    while(!q.empty()){
        ft=q.top();
        q.pop();
        //printf("%d,%d,%d\n",ft.x,ft.y,ft.t);
        int x=ft.x;
        int y=ft.y;
        if(x==ax&&y==ay){
            printf("%d\n",ft.t);
            return;
        }
        for(int i=0;i<4;i++){
            x=ft.x+mx[i];
            y=ft.y+my[i];
            if(!judge(x,y)){
                continue;
            }
            node nt;
            if(map[x][y]=='.'||map[x][y]=='a'){
                nt.x=x;
                nt.y=y;
                nt.t=ft.t+1;
                d[x][y]=1;
                q.push(nt);
            }else if(map[x][y]=='x'){
                nt.x=x;
                nt.y=y;
                nt.t=ft.t+2;
                d[x][y]=1;
                q.push(nt);
            }
        }
    }
    printf("Poor ANGEL has to stay in the prison all his life.\n");
}


int main()
{
    while(~scanf("%d%d",&n,&m)){
        memset(d,0,sizeof(d));
        for(int i=0;i<n;i++){
            scanf("%s",map[i]);
            for(int j=0;j<m;j++){
                if(map[i][j]=='a'){
                    ax=i,ay=j;
                }
                if(map[i][j]=='r'){
                    rx=i,ry=j;
                }
            }
        }
        bfs();
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
