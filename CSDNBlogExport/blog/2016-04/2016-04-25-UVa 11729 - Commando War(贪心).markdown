---
layout: post
title: "UVa 11729 - Commando War(贪心)"
date: 2016-04-25 05:34:16 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 贪心算法和背包问题
tags: []
keyword: 陈浩翔, 谙忆
description: “Waiting for orders we held in the wood, word from the front never came 
By evening the sound of the gunfire was miles away 
Ah softly we moved through the shadows, slip away through the trees 
Crossin 
---


“Waiting for orders we held in the wood, word from the front never came 
By evening the sound of the gunfire was miles away 
Ah softly we moved through the shadows, slip away through the trees 
Crossin
<!-- more -->
----------

“Waiting for orders we held in the wood, word from the front never came
By evening the sound of the gunfire was miles away
Ah softly we moved through the shadows, slip away through the trees
Crossing their lines in the mists in the fields on our hands and our knees
And all that I ever, was able to see
The fire in the air, glowing red, silhouetting the smoke on the breeze”
There is a war and it doesn’t look very promising for your country. Now it’s time to act. You
have a commando squad at your disposal and planning an ambush on an important enemy camp
located nearby. You have N soldiers in your squad. In your master-plan, every single soldier has a
unique responsibility and you don’t want any of your soldier to know the plan for other soldiers so that
everyone can focus on his task only. In order to enforce this, you brief every individual soldier about
his tasks separately and just before sending him to the battlefield. You know that every single soldier
needs a certain amount of time to execute his job. You also know very clearly how much time you
need to brief every single soldier. Being anxious to finish the total operation as soon as possible, you
need to find an order of briefing your soldiers that will minimize the time necessary for all the soldiers
to complete their tasks. You may assume that, no soldier has a plan that depends on the tasks of his
fellows. In other words, once a soldier begins a task, he can finish it without the necessity of pausing
in between.

Input

There will be multiple test cases in the input file. Every test case starts with an integer N (1 ≤
N ≤ 1000), denoting the number of soldiers. Each of the following N lines describe a soldier with two
integers B (1 ≤ B ≤ 10000) & J (1 ≤ J ≤ 10000). B seconds are needed to brief the soldier while
completing his job needs J seconds. The end of input will be denoted by a case with N = 0. This case
should not be processed.

Output

For each test case, print a line in the format, ‘Case X: Y ’, where X is the case number & Y is the
total number of seconds counted from the start of your first briefing till the completion of all jobs.

Sample Input
3
2 5
3 2
2 1
3
3 3
4 4
5 5
0

Sample Output
Case 1: 8
Case 2: 15

题意：
你有n个部下，每个部下需要完成一项任务。第i个部下需要你花B(i)分钟交代任务，
然后他就会立刻独立的、无间断的执行J(i)分钟后完成任务。
你需要选择交代任务的顺序，使得所有任务尽早执行完毕(即最后一个执行完的任务应尽早结束)。
注意：不能同时给2个或以上的部下交代任务，但部下们可以同时执行他们各自的任务。

输入第一行为n，n为部下的个数。
接下来的n行为B和J。
当n为0时，输入结束。

分析：
执行时间较长的任务需要先交代，
于是，我们可以想到这样一个贪心算法：
按照J从小到大的顺序给各个任务排序，然后依次交代。


```
package cn.hncu.UVa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * @author 陈浩翔
 *
 * 2016-4-25
 */
public class P11729 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k=0;
		while(sc.hasNext()){
			k++;
			int n =sc.nextInt();
			if(n==0){
				break;
			}
			Bj bj[] = new Bj[n];
			for(int i=0;i<n;i++){
				bj[i]=new Bj();
				bj[i].b = sc.nextInt();
				bj[i].j = sc.nextInt();
			}
			sort(bj);
			int s=0;
			int ans =0;
			for(int i=0;i<n;i++){
				s = s+bj[i].b;//当前任务的开始执行时间，也就是吩咐完后的时间
				ans = Math.max(ans, s+bj[i].j);//更新用户任务执行完毕时的最晚时间
			}
			System.out.println("Case "+k+": "+ans);
		}
	}

	private static void sort(Bj[] bj) {
		Arrays.sort(bj, new Comparator<Bj>() {
			@Override
			public int compare(Bj o1, Bj o2) {
				if(o1.j<o2.j){
					return 1;
				}
				return -1;
			}
		});
	}
}

class Bj{
	public int b;
	public int j;
}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
