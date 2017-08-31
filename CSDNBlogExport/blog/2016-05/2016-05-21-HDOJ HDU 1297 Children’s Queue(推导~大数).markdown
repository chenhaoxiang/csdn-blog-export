---
layout: post
title: "HDOJ HDU 1297 Children’s Queue(推导~大数)"
date: 2016-05-21 09:38:16 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 模拟/推导/打表,----- 大数问题
tags: [java,acm,大数]
keyword: 陈浩翔, 谙忆
description: Problem Description 
There are many students in PHT School. One day, the headmaster whose name is PigHeader wanted all students stand in a line. He prescribed that girl can not be in single. In other w 
---


Problem Description 
There are many students in PHT School. One day, the headmaster whose name is PigHeader wanted all students stand in a line. He prescribed that girl can not be in single. In other w
<!-- more -->
----------

Problem Description
There are many students in PHT School. One day, the headmaster whose name is PigHeader wanted all students stand in a line. He prescribed that girl can not be in single. In other words, either no girl in the queue or more than one girl stands side by side. The case n=4 (n is the number of children) is like
FFFF, FFFM, MFFF, FFMM, MFFM, MMFF, MMMM
Here F stands for a girl and M stands for a boy. The total number of queue satisfied the headmaster’s needs is 7. Can you make a program to find the total number of queue with n children?

 

Input
There are multiple cases in this problem and ended by the EOF. In each case, there is only one integer n means the number of children (1<=n<=1000) 
 

Output
For each test case, there is only one integer means the number of queue satisfied the headmaster’s needs.
 

Sample Input
1
2
3
 

Sample Output
1
2
4


题意：
就是n个人，站成一排。
有一个要求，(F)女生不能单独一个人站在男生之间。
可以没有女生。

输出有多少种站法；
(不考虑人与人的不同，只考虑位置和男女区别)
（如果一排以MF结尾是不合法的）

分析：
假如n个人的站法为db[n];
由前面的推导出db[n]。
db[n-1]结尾添加一个M，是一定可以的。
db[n-2]结尾添加FF，也是一定可以的。
添加MF不可以，添加MM也是可以的（但是这个情况和db[n-1]中重复了），添加FM也是和db[n-1]+M重复了。

在不可以序列后面加上FF(MF不可以,加上FF),成为合法,
所以db[n-4]后面+MFFF可以, 其实加一个F也能构成合法，但是这种情况包含在db[n-2]（相当与+FF）里面；

所以递推方程式db[n] =db[n-1] + db[n-2] + db[n-4];

db[i] 中保存的都是合法序列数。

Java大数秒A~~~


```
import java.math.BigInteger;
import java.util.Scanner;

public class Main{
	static BigInteger db[] = new BigInteger[1001];
	public static void main(String[] args) {
		dabiao();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n =sc.nextInt();
			System.out.println(db[n]);
		}
	}
	private static void dabiao() {
		db[0]=new BigInteger("1");
		db[1]=new BigInteger("1");
		db[2]=new BigInteger("2");
		db[3]=new BigInteger("4");
		db[4]=new BigInteger("7");
		for(int i=5;i<db.length;i++){
			db[i]=db[i-1].add(db[i-2]).add(db[i-4]);
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
