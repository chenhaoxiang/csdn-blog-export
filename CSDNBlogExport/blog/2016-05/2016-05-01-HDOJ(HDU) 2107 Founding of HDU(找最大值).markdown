---
layout: post
title: "HDOJ(HDU) 2107 Founding of HDU(找最大值)"
date: 2016-05-01 04:26:27 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
经过慎重的考虑，XHD,8600, LL，Linle以及RPG等ACM队员集体退役，甚至正在酝酿退学。 
为什么？要考研？那也不用退学呀… 
当然不是！真正的原因是他们想提前创业，想合伙成立一家公司，据说公司的名称都想好了，为了感谢多年的ACM集训队队长XHD，公司就叫海东集团(HaiDong Union),简称HDU.(对于这个公司名称,几个人私下里开玩笑 
---


Problem Description 
经过慎重的考虑，XHD,8600, LL，Linle以及RPG等ACM队员集体退役，甚至正在酝酿退学。 
为什么？要考研？那也不用退学呀… 
当然不是！真正的原因是他们想提前创业，想合伙成立一家公司，据说公司的名称都想好了，为了感谢多年的ACM集训队队长XHD，公司就叫海东集团(HaiDong Union),简称HDU.(对于这个公司名称,几个人私下里开玩笑
<!-- more -->
----------

Problem Description
经过慎重的考虑，XHD,8600, LL，Linle以及RPG等ACM队员集体退役，甚至正在酝酿退学。
为什么？要考研？那也不用退学呀…
当然不是！真正的原因是他们想提前创业，想合伙成立一家公司，据说公司的名称都想好了，为了感谢多年的ACM集训队队长XHD，公司就叫海东集团(HaiDong Union),简称HDU.(对于这个公司名称,几个人私下里开玩笑说,外面的人看到HDU,可别以为是”胡捣集团”,呵呵)
公司成立了，谁来做老大呢？这对于合伙的公司可是一个难题。好在几位同学经过几年的ACM训练，思维非常活跃，马上想到推选AC战斗力最强的一位来做老总。
现在的问题就是，假设每人的AC战斗力是一个已知的整数，请编程输出最后选出的老总的AC战斗力。

 

Input
输入包含多组测试数据，每组数据占2行，首先一行是一个整数n(n<100)，表示创立公司的人数，然后一行是n个32位整数，表示n个人的AC战斗力，n为0的时候结束输入。

 

Output
对于每个测试实例，请输出老总的AC战斗力，每个实例的输出占一行。

 

Sample Input
3
1 2 3
0
 

Sample Output
3



到了这个程度，看到这样的题目，这个就属于超级水题了。。。
就是找最大的值。

```

import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n =sc.nextInt();
			if(n==0){
				return ;
			}
			int a[] = new int[n];
			int max=sc.nextInt();
			for(int i=0;i<n-1;i++){
				a[i]=sc.nextInt();
				if(max<a[i]){
					max=a[i];
				}
			}
			System.out.println(max);
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
