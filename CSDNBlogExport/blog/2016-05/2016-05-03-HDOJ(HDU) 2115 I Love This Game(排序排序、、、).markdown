---
layout: post
title: "HDOJ(HDU) 2115 I Love This Game(排序排序、、、)"
date: 2016-05-03 05:00:13 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 排序相关
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Do you like playing basketball ? If you are , you may know the NBA Skills Challenge . It is the content of the basketball skills . It include several parts , such as passing , shoo 
---


Problem Description 
Do you like playing basketball ? If you are , you may know the NBA Skills Challenge . It is the content of the basketball skills . It include several parts , such as passing , shoo
<!-- more -->
----------

Problem Description
Do you like playing basketball ? If you are , you may know the NBA Skills Challenge . It is the content of the basketball skills . It include several parts , such as passing , shooting , and so on. After completion of the content , the player who takes the shortest time will be the winner . Now give you their names and the time of finishing the competition , your task is to give out the rank of them ; please output their name and the rank, if they have the same time , the rank of them will be the same ,but you should output their names in lexicographic order.You may assume the names of the players are unique.

Is it a very simple problem for you? Please accept it in ten minutes.

 

Input
This problem contains multiple test cases! Ease test case contain a n(1<=n<=10) shows the number of players,then n lines will be given. Each line will contain the name of player and the time(mm:ss) of their finish.The end of the input will be indicated by an integer value of zero.

 

Output
The output format is shown as sample below.
Please output the rank of all players, the output format is shown as sample below;
Output a blank line between two cases.
 

Sample Input
10
Iverson 17:19
Bryant 07:03
Nash 09:33
Wade 07:03
Davies 11:13
Carter 14:28
Jordan 29:34
James 20:48
Parker 24:49
Kidd 26:46
0
 

Sample Output
Case #1
Bryant 1
Wade 1
Nash 3
Davies 4
Carter 5
Iverson 6
James 7
Parker 8
Kidd 9
Jordan 10


题目大意就是按照后面的时间排名，所用时间小的排前面，如果时间相等，按照名字的字典序排序。不会出现相同的名字。

用sort方法给它们排序好，再输出就行，注意，这里的难点是输出的时候，
排名相同的人，他们的名次必须另外用一个数来标志。

还有，输出的时候，2个输出之间有空行。


```
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =0;
        while(sc.hasNext()){
            int n =sc.nextInt();
            if(n==0){
                break;
            }
            if(t!=0){
                System.out.println();
            }
            Stu stu[] = new Stu[n];
            for(int i=0;i<n;i++){
                stu[i] = new Stu();
                stu[i].name=sc.next();
                String str = sc.next();
                String strs[] = str.split(":");
                stu[i].h=Integer.parseInt(strs[0]);
                stu[i].m=Integer.parseInt(strs[1]);
                stu[i].d=i;//必须赋值不同的值
            }
            Arrays.sort(stu, new Comparator<Stu>() {
                @Override
                public int compare(Stu o1, Stu o2) {
                    if(o1.h>o2.h){
                        return 1;
                    }
                    if(o1.h<o2.h){
                        return -1;
                    }
                    if(o1.m>o2.m){
                        return 1;
                    }
                    if(o1.m<o2.m){
                        return -1;
                    }
                    //-1用来标识这个2个人的时间相等
                    o1.d=-1;
                    o2.d=-1;
                    return o1.name.toUpperCase().compareTo(o2.name.toUpperCase());
                }
            });
            
            System.out.println("Case #"+(++t));
            int h=1;//h是从1-n依次加一的数
            int k=1;//如果有重复排名时的排名
            int eq =1;//用来标识有几个重复的
            for(int i=0;i<n;i++){
            	k=h-eq;//重复的时间有几次，就用h减去它，就是排名
                if(i==0){
                    System.out.println(stu[i].name+" "+(h++));
                }else{
                    if(stu[i].d==stu[i-1].d){//这个2个人的时间相等
                    	eq++;
                        System.out.println(stu[i].name+" "+k);
                        h++;
                    }else{
                    	eq=1;
                        System.out.println(stu[i].name+" "+(h++));
                    }
                }
            }
        }
    }
}

class Stu{
    String name;
    int h;
    int m;
    int d;
}



```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
