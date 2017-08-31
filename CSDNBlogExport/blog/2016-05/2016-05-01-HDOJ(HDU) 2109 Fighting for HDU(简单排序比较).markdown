---
layout: post
title: "HDOJ(HDU) 2109 Fighting for HDU(简单排序比较)"
date: 2016-05-01 04:45:21 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 排序相关,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
在上一回，我们让你猜测海东集团用地的形状，你猜对了吗？不管结果如何，都没关系，下面我继续向大家讲解海东集团的发展情况： 
在最初的两年里，HDU发展非常迅速，综合各种ACM算法生成的老鼠药效果奇好，据说该药专对老鼠有效，如果被人误食了，没有任何副作用，甚至有传闻说还有健胃的效果，不过这倒没有得到临床验证。所以，公司的销量逐年递增，利润也是节节攀升，作为股东之 
---


Problem Description 
在上一回，我们让你猜测海东集团用地的形状，你猜对了吗？不管结果如何，都没关系，下面我继续向大家讲解海东集团的发展情况： 
在最初的两年里，HDU发展非常迅速，综合各种ACM算法生成的老鼠药效果奇好，据说该药专对老鼠有效，如果被人误食了，没有任何副作用，甚至有传闻说还有健胃的效果，不过这倒没有得到临床验证。所以，公司的销量逐年递增，利润也是节节攀升，作为股东之
<!-- more -->
----------

Problem Description
在上一回，我们让你猜测海东集团用地的形状，你猜对了吗？不管结果如何，都没关系，下面我继续向大家讲解海东集团的发展情况：
在最初的两年里，HDU发展非常迅速，综合各种ACM算法生成的老鼠药效果奇好，据说该药专对老鼠有效，如果被人误食了，没有任何副作用，甚至有传闻说还有健胃的效果，不过这倒没有得到临床验证。所以，公司的销量逐年递增，利润也是节节攀升，作为股东之一的公主负责财务，最近半年，她实在辛苦，多次因为点钞票造成双手抽筋而住院，现在在她面前你根本不要提到“钞票”二字，甚至“money”也不行，否则她立马双手抽筋，唉，可怜的公主…
海东集团的发展令国人大为振奋，不过也引起了邻国同行业“东洋小苟株式会社”的嫉妒，眼看海东集团逐渐把他们原来的市场一一占领，心中自是不甘，于是派了n个人前来挑衅，提出要来一场比试真功夫的中日擂台赛，输的一方要自动退出老鼠药市场！
他们提出的比赛规则是这样的：
1.  每方派出n个人参赛；
2.  出赛的顺序必须是从弱到强（主要担心中国人擅长的田忌赛马）；
3.  每赢一场，得两分，打平得一分，否则得0分。
东洋小苟果然够黑，不过他们万万没有想到，HDU可是卧虎藏龙，不仅有动若脱兔的Linle，还有力大如牛的伪**，更有下沙健美先生HeYing以及因为双手抽筋而练成鹰爪功的月亮公主，估计小苟他们也占不到什么便宜。
假设每个队员的能力用一个整数来表示，你能告诉我最终的结果吗？

 

Input
输入包含多组测试数据，每组数据占3行，首先一行是一个整数n(n<100)，表示每方上场队员的人数，接着的二行每行包含n个整数，分别依次表示中日两方人员的能力值，n为0的时候结束输入。

 

Output
对于每个测试实例，请输出比赛的结果，结果的格式如样例所示（数字和vs之间有且仅有一个空格），其中，HDU的比分在前。
每个实例的输出占一行。

 

Sample Input
3
5 2 6
1 3 4
0
 

Sample Output
6 vs 0



就是各自排好序来比较就可以了。
注意“vs”是小写的。
还有空格。

```
import java.util.Arrays;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			int n = sc.nextInt();
			if(n==0){
				return;
			}
			
			int hdu[] = new int[n];
			int jp[] = new int[n];
			for(int i=0;i<n;i++){
				hdu[i]=sc.nextInt();
			}
			for(int i=0;i<n;i++){
				jp[i] = sc.nextInt();
			}
			Arrays.sort(hdu);
			Arrays.sort(jp);
			int hduMark=0;
			int jpMark=0;
			for(int i=0;i<n;i++){
				if(hdu[i]>jp[i]){
					hduMark+=2;
					continue;
				}
				if(hdu[i]<jp[i]){
					jpMark+=2;
					continue;
				}
				hduMark++;
				jpMark++;
			}
			System.out.println(hduMark+" vs "+jpMark);
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
