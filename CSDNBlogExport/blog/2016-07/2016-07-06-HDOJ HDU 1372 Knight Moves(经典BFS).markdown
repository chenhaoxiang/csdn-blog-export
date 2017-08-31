---
layout: post
title: "HDOJ HDU 1372 Knight Moves(经典BFS)"
date: 2016-07-06 10:13:08 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❺ 算法及基础题,----- 递归搜索回溯
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
A friend of you is doing research on the Traveling Knight Problem (TKP) where you are to find the shortest closed tour of knight moves that visits each square of a given set of n s 
---


Problem Description 
A friend of you is doing research on the Traveling Knight Problem (TKP) where you are to find the shortest closed tour of knight moves that visits each square of a given set of n s
<!-- more -->
----------

Problem Description
A friend of you is doing research on the Traveling Knight Problem (TKP) where you are to find the shortest closed tour of knight moves that visits each square of a given set of n squares on a chessboard exactly once. He thinks that the most difficult part of the problem is determining the smallest number of knight moves between two given squares and that, once you have accomplished this, finding the tour would be easy.
Of course you know that it is vice versa. So you offer him to write a program that solves the "difficult" part. 

Your job is to write a program that takes two squares a and b as input and then determines the number of knight moves on a shortest route from a to b. 

 

Input
The input file will contain one or more test cases. Each test case consists of one line containing two squares separated by one space. A square is a string consisting of a letter (a-h) representing the column and a digit (1-8) representing the row on the chessboard. 

 

Output
For each test case, print one line saying "To get from xx to yy takes n knight moves.". 

 

Sample Input
e2 e4
a1 b2
b2 c3
a1 h8
a1 h7
h8 a1
b1 c3
f6 f6
 

Sample Output
To get from e2 to e4 takes 2 knight moves.
To get from a1 to b2 takes 4 knight moves.
To get from b2 to c3 takes 2 knight moves.
To get from a1 to h8 takes 6 knight moves.
To get from a1 to h7 takes 5 knight moves.
To get from h8 to a1 takes 6 knight moves.
To get from b1 to c3 takes 1 knight moves.
To get from f6 to f6 takes 0 knight moves.


题意：国际象棋的骑士~可以理解成象棋中的马，走日字。
行号从：1-8
列号从：a-h
问：从起点到终点的最短路径是几步。


遇到最短路径的题。最好用广搜，虽然深搜也可以AC。
<font color="red" size="4">
结构体变量名不要取next，否则会出现CE！！！
这个next搞了我个把小时，后来改成nextb，就AC了。
</font>

```
#include <iostream>
#include <stdio.h>
#include <string.h>
#include <queue>
using namespace std;
int xa,ya,xb,yb;
char a[3],b[3];
struct node{
    int x;
    int y;
    int t;
}first,nextb;
int map[10][10];
int dir[8][2]={-2,1,-2,-1,-1,2,-1,-2,1,2,1,-2,2,-1,2,1};

void bfs(){
    int i;
    queue<node> q;
    first.x=xa;
    first.y=ya;
    first.t=0;
    q.push(first);
    map[first.x][first.y]=1;
    while(!q.empty()){
        first = q.front();
        //printf("---%d---%d\n",first.x,first.y);
        q.pop();
        if(first.x==xb&&first.y==yb){
            printf("To get from %s to %s takes %d knight moves.\n",a,b,first.t);
            return;
        }
        for(i=0;i<8;i++){
            nextb.x=first.x+dir[i][0];
            nextb.y=first.y+dir[i][1];

            if(nextb.x<0||nextb.x>=8||nextb.y<0||nextb.y>=8){
                //printf("1\n");
                continue;
            }
            if(map[nextb.x][nextb.y]==1){
                //printf("2\n");
                continue;
            }

            map[nextb.x][nextb.y]=1;
            nextb.t=first.t+1;
            q.push(nextb);
        }
    }
}


int main()
{

    while(~scanf("%s%s",&a,&b)){
        xa=a[0]-'a';
        ya=a[1]-'1';
        xb=b[0]-'a';
        yb=b[1]-'1';

        memset(map,0,sizeof(map));
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                map[i][j]=0;
            }
        }
        //printf("a=%s\n",a);
        //printf("b=%s\n",b);
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
