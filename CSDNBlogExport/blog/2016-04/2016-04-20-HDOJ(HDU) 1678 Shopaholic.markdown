---
layout: post
title: "HDOJ(HDU) 1678 Shopaholic"
date: 2016-04-20 01:43:21 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Lindsay is a shopaholic. Whenever there is a discount of the kind where you can buy three items and only pay for two, she goes completely mad and feels a need to buy all items in t 
---


Problem Description 
Lindsay is a shopaholic. Whenever there is a discount of the kind where you can buy three items and only pay for two, she goes completely mad and feels a need to buy all items in t
<!-- more -->
----------

Problem Description
Lindsay is a shopaholic. Whenever there is a discount of the kind where you can buy three items and only pay for two, she goes completely mad and feels a need to buy all items in the store. You have given up on curing her for this disease, but try to limit its effect on her wallet. 
You have realized that the stores coming with these offers are quite elective when it comes to which items you get for free; it is always the cheapest ones. As an example, when your friend comes to the counter with seven items, costing 400, 350, 300, 250, 200, 150, and 100 dollars, she will have to pay 1500 dollars. In this case she got a discount of 250 dollars. You realize that if she goes to the counter three times, she might get a bigger discount. E.g. if she goes with the items that costs 400, 300 and 250, she will get a discount of 250 the first round. The next round she brings the item that costs 150 giving no extra discount, but the third round she takes the last items that costs 350, 200 and 100 giving a discount of an additional 100 dollars, adding up to a total discount of 350.
Your job is to find the maximum discount Lindsay can get.
 

Input
The first line of input gives the number of test scenarios, 1 <= t <= 20. Each scenario consists of two lines of input. The first gives the number of items Lindsay is buying, 1 <= n <= 20000. The next line gives the prices of these items, 1 <= pi <= 20000.

 

Output
For each scenario, output one line giving the maximum discount Lindsay can get by selectively choosing which items she brings to the counter at the same time.

 

Sample Input
1
6
400 100 200 350 300 250
 

Sample Output
400


题目很简单，只是要先看懂题目。。。。。。
其实就是说，一个人去买东西，只要买3件东西，最便宜的那件东西可以不用付钱，问，最多能省多少钱？、、
我们给商品按价格排序，再每次取从大到小的第三件的价格就可以了。再累加。
注意商品可能不是3的倍数哦。。。

```
import java.util.Arrays;
import java.util.Scanner;

public class Main{



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<a.length;i++){
				a[i]=sc.nextInt();
			}
			
			Arrays.sort(a);
			
			
			int num=0;
			
			for(int i=a.length-1-2;i>=n%3;i=i-3){
				num=num+a[i];
			}
			System.out.println(num);
			
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
