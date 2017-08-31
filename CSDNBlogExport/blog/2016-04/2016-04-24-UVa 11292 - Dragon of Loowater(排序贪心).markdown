---
layout: post
title: "UVa 11292 - Dragon of Loowater(排序贪心)"
date: 2016-04-24 11:41:46 +0800
comments: true
categories:❶ ACM,----- UVa-ACM,❺ 算法及基础题,----- 贪心算法和背包问题
tags: [uva]
keyword: 陈浩翔, 谙忆
description: Once upon a time, in the Kingdom of Loowater, a minor nuisance turned into a major problem.The shores of Rellau Creek in central Loowater had always been a prime breeding ground for geese.Due to the la 
---


Once upon a time, in the Kingdom of Loowater, a minor nuisance turned into a major problem.The shores of Rellau Creek in central Loowater had always been a prime breeding ground for geese.Due to the la
<!-- more -->
----------

Once upon a time, in the Kingdom of Loowater, a minor nuisance turned into a major problem.The shores of Rellau Creek in central Loowater had always been a prime breeding ground for geese.Due to the lack of predators,the geese population was out of control. The people of Loowater mostly kept clear of the geese. Occasionally,
a goose would attack one of the people, and perhaps bite off a finger or two, but in general, the people tolerated the geese as a minor nuisance. One day, a freak mutation occurred, and one of the geese spawned a multi-headed fire-breathing dragon. When the dragon grew up, he threatened to burn the Kingdom of Loowater to a crisp.
Loowater had a major problem. The king was alarmed, and called on his knights to slay the dragon and save the kingdom. The knights explained: “To slay the dragon, we must chop off all its heads. Each knight can chop off one of the dragon’s heads. The heads of the dragon are of different sizes. In order to chop off a head, a knight must be at least as tall as the diameter of the head. The knights’ union demands that for chopping off a head, a knight must be paid a wage equal to one gold coin for each centimetre of the
knight’s height.”
Would there be enough knights to defeat the dragon? The king called on his advisors to help him
decide how many and which knights to hire. After having lost a lot of money building Mir Park, the
king wanted to minimize the expense of slaying the dragon. As one of the advisors, your job was to
help the king. You took it very seriously: if you failed, you and the whole kingdom would be burnt to
a crisp!

Input
The input contains several test cases. The first line of each test case contains two integers between 1 and
20000 inclusive, indicating the number n of heads that the dragon has, and the number m of knights in
the kingdom. The next n lines each contain an integer, and give the diameters of the dragon’s heads,
in centimetres. The following m lines each contain an integer, and specify the heights of the knights of
Loowater, also in centimetres.
The last test case is followed by a line containing ‘0 0’.

Output
For each test case, output a line containing the minimum number of gold coins that the king needs to
pay to slay the dragon. If it is not possible for the knights of Loowater to slay the dragon, output the
line ‘Loowater is doomed!’.

Sample Input
2 3
5
4
7
8
4
2 1
5
5
10
0 0


Sample Output
11
Loowater is doomed!


题意：
有n个头的恶龙，你雇佣一些骑士把所有的头砍掉，一共有m个骑士可以雇佣，
一个能力为x的骑士只能砍下恶龙一个直径不超过x的头，而且要支付x个金币。
问：如何雇佣骑士才能砍掉所有恶龙的头，而且要使付出的金币最少。

注意：一个骑士只能砍掉一个头，而且只能被雇用一次！

输入为：
n m
接下来n行为恶龙的头的直径。
再接下来是m行骑士的能力。

如果不能看下所有恶龙的头，输出：
“Loowater is doomed!”
否则输出最少花费、

题目分析：
能力强的骑士尽量不要去派他砍直径小的头，所以， 可以把雇佣来的骑士按照能力大小从小到大排序，
所有的头按照直径也从小到大排序，一个一个砍掉就可以了。如果最小的骑士的能力不能砍掉最小直径
的头，就跳过这个骑士。
代码如下：

```
#include <stdio.h>
#include <algorithm>
//因为用到了sort
using namespace std;

int x[20005];//恶龙的头数
int y[20005];//骑士的能力
int main()
{
    int n;
    int m;
    while(~scanf("%d %d",&n,&m)&&(n||m)){


        for(int i=0;i<n;i++){
            scanf("%d",&x[i]);
        }

        for(int i=0;i<m;i++){
            scanf("%d",&y[i]);
        }
        sort(x,x+n);
        sort(y,y+m);

        int k=0;//当前需要砍掉的头的编号
        int num=0;//当前总费用
        for(int i=0;i<m;i++){
            if(x[k]<=y[i]){
                num+=y[i];//雇佣该骑士
                k++;
                if(k==n){//头已经砍完，退出循环
                    break;
                }
            }
        }
        if(k<n){
            //还有头没砍完
            printf("Loowater is doomed!\n");
        }else{
            printf("%d\n",num);
        }
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
