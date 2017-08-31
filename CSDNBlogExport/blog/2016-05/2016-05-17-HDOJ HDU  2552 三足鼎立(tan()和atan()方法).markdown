---
layout: post
title: "HDOJ HDU  2552 三足鼎立(tan()和atan()方法)"
date: 2016-05-17 03:26:53 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
MCA山中人才辈出，洞悉外界战火纷纷，山中各路豪杰决定出山拯救百姓于水火，曾以题数扫全场的威士忌，曾经高数九十九的天外来客，曾以一剑铸十年的亦纷菲，歃血为盟，盘踞全国各个要塞（简称全国赛）遇敌杀敌，遇佛杀佛，终于击退辽军，暂时平定外患，三人位置也处于稳态。可惜辽誓不甘心，辽国征南大将军<耶律javac++>欲找出三人所在逐个击破，现在他发现威士忌的位置s,天 
---


Problem Description 
MCA山中人才辈出，洞悉外界战火纷纷，山中各路豪杰决定出山拯救百姓于水火，曾以题数扫全场的威士忌，曾经高数九十九的天外来客，曾以一剑铸十年的亦纷菲，歃血为盟，盘踞全国各个要塞（简称全国赛）遇敌杀敌，遇佛杀佛，终于击退辽军，暂时平定外患，三人位置也处于稳态。可惜辽誓不甘心，辽国征南大将军<耶律javac++>欲找出三人所在逐个击破，现在他发现威士忌的位置s,天
<!-- more -->
----------

Problem Description
MCA山中人才辈出，洞悉外界战火纷纷，山中各路豪杰决定出山拯救百姓于水火，曾以题数扫全场的威士忌，曾经高数九十九的天外来客，曾以一剑铸十年的亦纷菲，歃血为盟，盘踞全国各个要塞（简称全国赛）遇敌杀敌，遇佛杀佛，终于击退辽军，暂时平定外患，三人位置也处于稳态。

可惜辽誓不甘心，辽国征南大将军<耶律javac++>欲找出三人所在逐个击破，现在他发现威士忌的位置s,天外来客的位置u，不过很难探查到亦纷菲v所在何处，只能知道三人满足关系：

arctan(1/s) = arctan(1/u)+arctan(1/v)

注：![这里写图片描述](http://img.blog.csdn.net/20160517152424565)(其中0 <= x <= 1)
定义 f(s, u, v) = v*u-s*u-s*v 的值 为<三足鼎立>

<耶律javac++>想计算<三足鼎立>的值

 

Input
首先输入一个t,表示有t组数据，跟着t行：
输入s, u (s <= 12^3, u <= 2^20 且 s, u, v > 0)
且s,u,v均为实数

 

Output
输出 v*u-s*u-s*v 的值，为了简单起见，如果是小数，直接取整

比如：答案是1.7 则输出 1


 

Sample Input
1
1 2
 

Sample Output
1



就是调用java.lang.Math中的tan()和atan()方法~
题目给的那个公式没用上~


至于题目说的取整~~坑了我2次WA。。
System.out.println((int)(v*u-s*u-s*v));是错的~！


```
import java.util.Scanner;

/**
 * @author 陈浩翔
 *
 * 2016-5-17
 */
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			double s = sc.nextDouble();
			double u = sc.nextDouble();
			double v = 1.0/Math.tan( (Math.atan(1.0/s)-Math.atan(1.0/u)) );
			System.out.printf("%.0f",(v*u-s*u-s*v));
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
