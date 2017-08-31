---
layout: post
title: "HDOJ 3466 Proud Merchants"
date: 2016-02-28 10:11:02 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 贪心算法和背包问题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Recently, iSea went to an ancient country. For such a long time, it was the most wealthy and powerful kingdom in the world. As a result, the people in this country are still very p 
---


Problem Description 
Recently, iSea went to an ancient country. For such a long time, it was the most wealthy and powerful kingdom in the world. As a result, the people in this country are still very p
<!-- more -->
----------

Problem Description
Recently, iSea went to an ancient country. For such a long time, it was the most wealthy and powerful kingdom in the world. As a result, the people in this country are still very proud even if their nation hasn’t been so wealthy any more.
The merchants were the most typical, each of them only sold exactly one item, the price was Pi, but they would refuse to make a trade with you if your money were less than Qi, and iSea evaluated every item a value Vi.
If he had M units of money, what’s the maximum value iSea could get?


 

Input
There are several test cases in the input.

Each test case begin with two integers N, M (1 ≤ N ≤ 500, 1 ≤ M ≤ 5000), indicating the items’ number and the initial money.
Then N lines follow, each line contains three numbers Pi, Qi and Vi (1 ≤ Pi ≤ Qi ≤ 100, 1 ≤ Vi ≤ 1000), their meaning is in the description.

The input terminates by end of file marker.


 

Output
For each test case, output one integer, indicating maximum value iSea could get.


 

Sample Input
2 10
10 15 10
5 10 5
3 10
5 10 5
3 5 6
2 7 3
 

Sample Output
5
11

 这道题目大意是，有n件商品，每件商品的价格是pi，每件商品只有在你的钱大于等于qi时才可以买入，每件商品在你心目中都有价值vi。现在你有m元钱，如何实现使买到的商品价值最大。下面我举题目中给出的例子进行分析，逐个击破。

3 10    ----分别是商品件数和Money
5 10 5  ----A商品的价格，最低入手价，价值
3 5 6   ----B商品
2 7 3   ----C商品

     答案是11。正确的解法是先买A，再买B。这样就可以买到的价值是11，5+6=11。你会发现其实这个买的顺序有关系，因为你不可以先买B再
     买A，我们先假设qi=pi，先把这个简单的问题解决。题目如下，其实就是把q省去了。

3 10
5 5 ----A商品
3 6   ----B商品
2 3   ----C商品
     这时，很多人想着把所有的情况都罗列出来，再一一比较，这是最容易想到，也是最耗时的方法，我们必须得优化。那么，有一种思路是这样的，对每件商品而言，你要么买，要么不买，这里必须得引入一个式子来说明问题。

  f(n，m)：花m元买n样东西实现的最大价值。对于任意的f(n，m)，都有下面这两种情况：

      情况一，你买了第n件商品，f(n, m)=f(n-1, m-pn)+vn，因为买了第n件商品，所以花费了pn元，也因此
      得到了vn的价值。f(n, m)就等于第n件商品的价值+用m-pn的钱去买n-1件商品的价值。这样问题就规模就变小了。
      情况二，你不买第n件商品，f(n, m)=f(n-1, m)，也就是说f(n, m)等于你用m元钱去买n-1件商品实现的最大价值。

这两种情况，哪个价值大，就取哪一种，所以f(n, m) = max(f(n-1, m-pn)+vn, f(n-1, m))。这便是这第一步的核心。

 根据这个式子，解题的表格设计如下
![](http://img.blog.csdn.net/20160228221043079)
                

      f(n,m)中n表示商品的件数，m表示钱，而f(0,3)表示没有商品，你有3块钱的情况下，你可以买到的价值，那当然是0咯；
      在举个例子f(2,6)，表示有2件商品，你有6块钱，那你比较来判断你要不要买第二件商品，如果你买了第二件商品，那么
      就是f(1, 6-3)+6=0+6=6；如果你不买第二件商品，那么就是f(1,6)=5。两种情况取大的，所以，你取6。其
      实，以上表格就是根据f(n, m) = max(f(n-1, m-pn)+vn, f(n-1, m))来得到的，多设计几组数据练几下就融会贯通了。这
      样第一步就算完成了，其实这就是0/1背包。

 

接下来针对有q的情况，这无疑是跟购买的顺序有关。我们不妨把大顺序确定下来。也就是说，比方说A、B、C三样商品，我们不管他买不买，我们只要确定下来如果他买，那肯定先买A再买C，那接下来是不是就不需要考虑顺序，只需要使用以上的0/1背包算法直接来。这就是我们的思路，先把顺序给考虑了，在套用以上0/1背包算法。我们还是举上面这个例子，我们稍微改一下，得到

3 10
5 5 5 ----A商品
3 3 6   ----B商品
2 3 3   ----C商品
     其实，就是让C商品的q不等于p，其他都相同，这时，你就会发现如果要买C商品的话，肯定得先买C商品，因为买C商品的代价最大。所以，我们可以按照qi-pi的顺序来确定大顺序。这里我们还可以用更严谨的方式来证明一下，比如A:p1 q1, B:p2 q2，然后，假设单独买A或者B的话，都是可以买到的。这时，若先买A，则你至少需要p1+q2的钱；若先买B，则至少需要p2+q1的钱。那肯定是花最少的钱咯，所以如果先买A再买B，那么p1+q2 < p2+q1，转换一下，就是q1-p1>q2-p2，也就是说qi-pi大的先买。这里还得注意一点就是，排序的时候，得按照qi-pi从小到大排序，因为你买第n件商品的时候，是在比较你是否要先买第n件商品。打个比方让大家更好地理解，比如说f(3, 10)，是不是max(f(2, 10-p3)+v3, f(2, 10))，你会发现这个第一种情况f(2,10-p3)+v3中，是先买了第三件商品，也就是说排在后面的商品会先买。好的，排好序之后，就把问题就转换为不需要考虑顺序的问题了，那就是上面我们已经解决0/1背包问题了。这样，问题圆满解决了。
解析参考链接：http://blog.csdn.net/xia842655187/article/details/47277761
```
import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main{

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        chx[] a = new chx[505];
        chx temp ;
        while(sc.hasNext()){
            int b[] = new int [5050];
            int n = sc.nextInt();
            int m = sc.nextInt();
            //System.out.println(n+" "+ m);
            for(int i=1;i<=n;i++){
                a[i] = new chx();
                
                a[i].p = sc.nextInt();
                a[i].q = sc.nextInt();
                a[i].v = sc.nextInt();
                a[i].qp = a[i].q-a[i].p;
            }
            
            for(int i=1;i<n;i++){
                for(int j=i+1;j<=n;j++){
                    if(a[i].qp>a[j].qp){
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
            
            for(int i=1;i<=n;i++){
                for(int j=m;j>=a[i].q;j--){
                    b[j] = Math.max(b[j],b[j-a[i].p]+a[i].v);
                }
            }
            
            System.out.println(b[m]);

        }
    }

}

class chx {
    int p;
    int q;
    int v;
    int qp;
    public chx(){
        p =0;
        q =0;
        v =0;
        qp =0;
    }
    
    }

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
