---
layout: post
title: "HDOJ(HDU) 2401 Baskets of Gold Coins(数列、)"
date: 2016-05-08 05:17:50 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
You are given N baskets of gold coins. The baskets are numbered from 1 to N. In all except one of the baskets, each gold coin weighs w grams. In the one exceptional basket, each go 
---


Problem Description 
You are given N baskets of gold coins. The baskets are numbered from 1 to N. In all except one of the baskets, each gold coin weighs w grams. In the one exceptional basket, each go
<!-- more -->
----------

Problem Description
You are given N baskets of gold coins. The baskets are numbered from 1 to N. In all except one of the baskets, each gold coin weighs w grams. In the one exceptional basket, each gold coin weighs w-d grams. A wizard appears on the scene and takes 1 coin from Basket 1, 2 coins from Basket 2, and so on, up to and including N-1 coins from Basket N-1. He does not take any coins from Basket N. He weighs the selected coins and concludes which of the N baskets contains the lighter coins. Your mission is to emulate the wizard's computation. 


 

Input
The input file will consist of one or more lines; each line will contain data for one instance of the problem. More specifically, each line will contain four positive integers, separated by one blank space. The first three integers are, respectively, the numbers N, w, and d, as described above. The fourth integer is the result of weighing the selected coins. 

N will be at least 2 and not more than 8000. The value of w will be at most 30. The value of d will be less than w. 



 

Output
For each instance of the problem, your program will produce one line of output, consisting of one positive integer: the number of the basket that contains lighter coins than the other baskets. 


 

Sample Input
10 25 8 1109
10 25 8 1045
8000 30 12 959879400
 

Sample Output
2
10
50


英语真的是硬伤啊！！！

题意：
题意：有N个篮子，编号1—N，篮子中有很多金币，每个重w.但是有一个编号的篮子中，每个金币重d.现从第一个篮子中拿1个金币，第二个篮子中拿2个……第N-1中拿N-1个，第N中不拿，给出这些金币的总重量wei，问：是第几个篮子中的金币重量较轻？
分析：一道数学题，先求1—N篮子金币应有的总重量w*（1+n-1)(n-1)/2-wei 等差数列求和，再乘每个金币应有的重量，所求和减去wei得到金币重量的差值。若为0，则必为编号N；若不为0，除以d，得到较轻金币的个数，即为所求编号。


```
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		while(sc.hasNext()){
			int n =sc.nextInt();
			int w = sc.nextInt();
			int d = sc.nextInt();
			int p =sc.nextInt();
			
			int sum = ((n-1)*(n-1+1)/2)*w-p;
			if(sum==0){
				System.out.println(n);
			}else{
				System.out.println(sum/d);
			}
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
