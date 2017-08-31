---
layout: post
title: "HDOJ HDU 5686 Problem B(斐波拉契+大数~)"
date: 2016-05-26 10:20:08 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 大数问题
tags: [数据,大数,acm,java]
keyword: 陈浩翔, 谙忆
description: Problem Description 
  度熊面前有一个全是由1构成的字符串，被称为全1序列。你可以合并任意相邻的两个1，从而形成一个新的序列。对于给定的一个全1序列，请计算根据以上方法，可以构成多少种不同的序列。Input 
这里包括多组测试数据，每组测试数据包含一个正整数N，代表全1序列的长度。1≤N≤200 Output 
对于每组测试数据，输出一个整数，代表由题目中所给定的全1序列所能形 
---


Problem Description 
  度熊面前有一个全是由1构成的字符串，被称为全1序列。你可以合并任意相邻的两个1，从而形成一个新的序列。对于给定的一个全1序列，请计算根据以上方法，可以构成多少种不同的序列。Input 
这里包括多组测试数据，每组测试数据包含一个正整数N，代表全1序列的长度。1≤N≤200 Output 
对于每组测试数据，输出一个整数，代表由题目中所给定的全1序列所能形
<!-- more -->
----------

Problem Description
  度熊面前有一个全是由1构成的字符串，被称为全1序列。你可以合并任意相邻的两个1，从而形成一个新的序列。对于给定的一个全1序列，请计算根据以上方法，可以构成多少种不同的序列。
 

Input
这里包括多组测试数据，每组测试数据包含一个正整数N，代表全1序列的长度。

1≤N≤200 

Output
对于每组测试数据，输出一个整数，代表由题目中所给定的全1序列所能形成的新序列的数量。
 

Sample Input
1
3
5
 

Sample Output
1
3
8

Hint
如果序列是：(111)。可以构造出如下三个新序列：(111), (21), (12)。



貌似和前面这个题有点类似：
http://blog.csdn.net/qq_26525215/article/details/51491233


分析：递推加大数~

递推公式为db[i] = db[i-1] + db[i-2]，斐波那契数列。 
怎么推导出来的呢~~~我能说我是看出来的麽~

设有n个1，可以构成f(n)种。则加一个1的时候，前面n种仍然成立 f(n+1)=f(n)+*; 
第n+1个1和第n个1相加构成2，前面n-1个1可以组合的个数。 f(n+1)=f(n)+f(n-1);

大数~用Java很好过的~c的话，只能用数组模拟了。


```
import java.math.BigInteger;
import java.util.Scanner;

public class Main{
	
	static BigInteger db[] = new BigInteger[205];
	public static void main(String[] args) {
		dabiao();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n =sc.nextInt();
			System.out.println(db[n]);
		}
		
	}
	private static void dabiao() {
		db[1]=new BigInteger("1");
		db[2]=new BigInteger("2");
		for(int i=3;i<db.length;i++){
			db[i]=db[i-1].add(db[i-2]);
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
