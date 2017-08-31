---
layout: post
title: "HDOJ 1420 Prepared for New Acmer(DP)"
date: 2016-04-16 06:23:23 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 动态规划（DP）
tags: [dp]
keyword: 陈浩翔, 谙忆
description: Problem Description 
集训进行了将近2个礼拜，这段时间以恢复性训练为主，我一直在密切关注大家的训练情况，目前为止，对大家的表现相当满意，首先是绝大部分队员的训练积极性很高，其次，都很遵守集训纪律，最后，老队员也起到了很好的带头作用，这里特别感谢为这次DP专题练习赛提供题目和测试数据的集训队队长xhd同学.特别高兴的是，跟随集训队训练的一批新队员表现非常好，进步也比较显著，特别是训 
---


Problem Description 
集训进行了将近2个礼拜，这段时间以恢复性训练为主，我一直在密切关注大家的训练情况，目前为止，对大家的表现相当满意，首先是绝大部分队员的训练积极性很高，其次，都很遵守集训纪律，最后，老队员也起到了很好的带头作用，这里特别感谢为这次DP专题练习赛提供题目和测试数据的集训队队长xhd同学.特别高兴的是，跟随集训队训练的一批新队员表现非常好，进步也比较显著，特别是训
<!-- more -->
----------

Problem Description
集训进行了将近2个礼拜，这段时间以恢复性训练为主，我一直在密切关注大家的训练情况，目前为止，对大家的表现相当满意，首先是绝大部分队员的训练积极性很高，其次，都很遵守集训纪律，最后，老队员也起到了很好的带头作用，这里特别感谢为这次DP专题练习赛提供题目和测试数据的集训队队长xhd同学.

特别高兴的是，跟随集训队训练的一批新队员表现非常好，进步也比较显著，特别是训练态度大大超出我的预期，我敢说，如果各位能如此坚持下去，绝对前途无量！

考虑到新队员还没有经过系统训练，我这里特别添加一道简单题：
给定三个正整数A，B和C（A,B,C<=1000000），求A^B mod C的结果.

希望各位都能体会到比赛中AC的快乐，绝对的量身定制，很高的待遇哟，呵呵...

 

Input
输入数据首先包含一个正整数N,表示测试实例的个数，然后是N行数据，每行包括三个正整数A,B,C。

 

Output
对每个测试实例请输出计算后的结果，每个实例的输出占一行。

 

Sample Input
3
2 3 4
3 3 5
4 4 6
 

Sample Output
0
2
4


开始想直接用java大数A过的，单发现取余不会超范围。
事实证明取余循环是可以AC的。
至于用java的大数过，就你们自己去试下吧，我觉得应该是可以过的。


```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			long num = a;
			for(int i=1;i<b;i++){
				a=a%c;
				//System.out.println("1  "+a);
				a=a*num;
				//System.out.println("2  "+a);
			}
			System.out.println(a%c);
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
