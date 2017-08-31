---
layout: post
title: "HDOJ HDU 1556 Color the ball(树状数组)"
date: 2016-05-26 10:11:02 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 数据结构,----- 数论相关/树
tags: [树状数组,java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
N个气球排成一排，从左到右依次编号为1,2,3….N.每次给定2个整数a b(a <= b),lele便为骑上他的“小飞鸽”牌电动车从气球a开始到气球b依次给每个气球涂一次颜色。但是N次以后lele已经忘记了第I个气球已经涂过几次颜色了，你能帮他算出每个气球被涂过几次颜色吗？Input 
每个测试实例第一行为一个整数N,(N <= 100000).接下来的N 
---


Problem Description 
N个气球排成一排，从左到右依次编号为1,2,3….N.每次给定2个整数a b(a <= b),lele便为骑上他的“小飞鸽”牌电动车从气球a开始到气球b依次给每个气球涂一次颜色。但是N次以后lele已经忘记了第I个气球已经涂过几次颜色了，你能帮他算出每个气球被涂过几次颜色吗？Input 
每个测试实例第一行为一个整数N,(N <= 100000).接下来的N
<!-- more -->
----------

Problem Description
N个气球排成一排，从左到右依次编号为1,2,3....N.每次给定2个整数a b(a <= b),lele便为骑上他的“小飞鸽"牌电动车从气球a开始到气球b依次给每个气球涂一次颜色。但是N次以后lele已经忘记了第I个气球已经涂过几次颜色了，你能帮他算出每个气球被涂过几次颜色吗？
 

Input
每个测试实例第一行为一个整数N,(N <= 100000).接下来的N行，每行包括2个整数a b(1 <= a <= b <= N)。
当N = 0，输入结束。
 

Output
每个测试实例输出一行，包括N个整数，第I个数代表第I个气球总共被涂色的次数。
 

Sample Input
3
1 1
2 2
3 3
3
1 1
1 2
1 3
0
 

Sample Output
1 1 1
3 2 1


看到好多人做这个题都是用的线段树~~经过长时间尝试~发现完全可以不用线段树~
直接来一个数组离散化~树状数组

和插段求点相比有点变化
但是其实是差不多的。
插线段的话就在线段左端点加1，在右端点后面减一。
这样求和得到的就是这个点的染色次数了。


```
import java.util.Scanner;

/**
 * @author 陈浩翔
 * 2016-5-26
 */
public class Main{

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(sc.hasNext()){
			int n =sc.nextInt();
			if(n==0){
				return;
			}
			int num[] = new int[n+5];
			for(int i=0;i<n;i++){
				int a=sc.nextInt();
				int b=sc.nextInt();
				
				num[a]++;
				num[b+1]--;
			}
			int m=num[1];
			System.out.print(m);
			for(int i=2;i<=n;i++){
				m+=num[i];
				System.out.print(" "+m);
			}
			System.out.println();
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
