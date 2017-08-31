---
layout: post
title: "HDOJ(HDU) 1898 Sempr == The Best Problem Solver (水题、、、)"
date: 2016-04-22 09:06:47 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
As is known to all, Sempr(Liangjing Wang) had solved more than 1400 problems on POJ, but nobody know the days and nights he had spent on solving problems.  
Xiangsanzi(Chen Zhou) w 
---


Problem Description 
As is known to all, Sempr(Liangjing Wang) had solved more than 1400 problems on POJ, but nobody know the days and nights he had spent on solving problems.  
Xiangsanzi(Chen Zhou) w
<!-- more -->
----------

Problem Description
As is known to all, Sempr(Liangjing Wang) had solved more than 1400 problems on POJ, but nobody know the days and nights he had spent on solving problems. 
Xiangsanzi(Chen Zhou) was a perfect problem solver too. Now this is a story about them happened two years ago. 
On March 2006, Sempr & Xiangsanzi were new comers of hustacm team and both of them want to be "The Best New Comers of March", so they spent days and nights solving problems on POJ. 
Now the problem is below: Both of them are perfect problem solvers and they had the same speed, that is to say Sempr can solve the same amount of problems as Xiangsanzi, but Sempr enjoyed submitting all the problems at the end of every A hours but Xiangsanzi enjoyed submitting them at the end of every B hours. In these days, static(Xiaojun Wu) was the assistant coach of hustacm, and he would check the number of problems they solved at time T. Give you three integers A,B,and T, you should tell me who is "The Best New Comers of March". If they solved the same amount of problems, output "Both!". If Sempr or Xiangsanzi submitted at time T, static would wait them. 

 

Input
In the first line there is an integer N, which means the number of cases in the data file, followed by N lines. 
For each line, there are 3 integers: A, B, T. 
Be sure that A,B and N are no more than 10000 and T is no more than 100000000. 

 

Output
For each case of the input, you should output the answer for one line. If Sempr won, output "Sempr!". If Xiangsanzi won, output "Xiangsanzi!". And if both of them won, output "Both!". 

 

Sample Input
3
2 3 4
2 3 6
2 3 9
 

Sample Output
Sempr!
Both!
Xiangsanzi!


就是输入a b t。
Sempr在每过a个时间提交一次代码，
Xiangsanzi在每过b个时间提交一次代码，
问在t时间内，谁提交的代码量多。
注意，他们编程速度什么的都是一样的！每时每刻都在编程！是提交的代码量谁多一些！
也就是说，看他们最后一次提交代码，谁距离t时间最近，谁就提交的多。

实际上就是a%t,b%t的余数来比较大小，谁的余数小，就输出谁。


```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			int a = sc.nextInt();
			int b =sc.nextInt();
			int tm = sc.nextInt();
			if(tm%a==tm%b){
				System.out.println("Both!");
				continue;
			}
			if(tm%a<tm%b){
				System.out.println("Sempr!");
				continue;
			}
			System.out.println("Xiangsanzi!");
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
