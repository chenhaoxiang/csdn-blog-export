---
layout: post
title: "HDOJ HDU 1133 Buy the Ticket(数论~卡特兰数~大数~)"
date: 2016-05-21 07:03:26 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 数论相关/树,----- 大数问题
tags: [java,acm,卡特兰数]
keyword: 陈浩翔, 谙忆
description: Problem Description 
The “Harry Potter and the Goblet of Fire” will be on show in the next few days. As a crazy fan of Harry Potter, you will go to the cinema and have the first sight, won’t you?Suppos 
---


Problem Description 
The “Harry Potter and the Goblet of Fire” will be on show in the next few days. As a crazy fan of Harry Potter, you will go to the cinema and have the first sight, won’t you?Suppos
<!-- more -->
----------

Problem Description
The "Harry Potter and the Goblet of Fire" will be on show in the next few days. As a crazy fan of Harry Potter, you will go to the cinema and have the first sight, won’t you?

Suppose the cinema only has one ticket-office and the price for per-ticket is 50 dollars. The queue for buying the tickets is consisted of m + n persons (m persons each only has the 50-dollar bill and n persons each only has the 100-dollar bill).

Now the problem for you is to calculate the number of different ways of the queue that the buying process won't be stopped from the first person till the last person. 
Note: initially the ticket-office has no money. 

The buying process will be stopped on the occasion that the ticket-office has no 50-dollar bill but the first person of the queue only has the 100-dollar bill.

 

Input
The input file contains several test cases. Each test case is made up of two integer numbers: m and n. It is terminated by m = n = 0. Otherwise, m, n <=100.

 

Output
For each test case, first print the test number (counting from 1) in one line, then output the number of different ways in another line.

 

Sample Input
3 0
3 1
3 3
0 0
 

Sample Output
Test #1:
6
Test #2:
18
Test #3:
180


题意：

就是m+n个人去买票，票价50元，m个人只带了50元一张的纸币，n个人只带了100元一张的纸币，售票员一开始手里没有钱。
问，如何让售票员在可以全部都找零的情况下，安排这些人买票的顺序~

也就是说：到100元的人买票之前，售票员手里必须要有一张50元的。

推导过程如下：
m个人拿50，n个人拿1001、
如果n > m，那么排序方法数为0，这一点很容易想清楚
2、现在我们假设拿50的人用‘0’表示，拿100的人用‘1’表示。 如果有这么一个序列0101101001001111。
 当第K个位置出现1的个数多于0的个数时就是一个不合法的序列了 假设m=4,n=3的一个序列是：0110100 。
也就是说任意一个不合法序列（m个0，n个1），都可以由另外一个序列（n-1个0和m+1个1）得到。 
另外我们知道，一个序列要么是合法的，要么是不合法的 。
所以，合法序列数量 = 序列总数量 - 不合法序列的总量。 
序列总数可以这样计算 ，m+n个位置中，选择n个位置出来填上1，所以是C(m+n,n). 
不合法序列的数量就是： m+n个位置中，选择m+1个位置出来填上1，所以是C(m+n,m+1). 然后每个人都是不一样的，所以需要全排列m! * n!. 

所以最后的公式为：( C(m+n,n) - C(m+n,m+1) ) * m! * n! 化简即为：(m+n)!*(m-n+1)/(m+1)

如果没看懂：可以参考我的前面一篇卡特兰数的分析：
http://blog.csdn.net/qq_26525215/article/details/51453493

```
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author 陈浩翔
 *
 * 2016-5-19
 */
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=0;
		while(sc.hasNext()){
			int m =sc.nextInt();
			int n =sc.nextInt();
			if(n==0&&m==0){
				return;
			}
			System.out.println("Test #"+(++t)+":");
			
			if(n>m){
				System.out.println(0);
				continue;
			}
			
			BigInteger a = new BigInteger("1");
			
			for(int i=2;i<=m+n;i++){
				a=a.multiply(new BigInteger(""+i));
			}
			a=a.multiply(new BigInteger(""+(m-n+1)));
			a=a.divide(new BigInteger(""+(m+1)));
			System.out.println(a);
		}
	}
}

```



本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
