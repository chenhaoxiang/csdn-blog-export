---
layout: post
title: "HDOJ 1098 Ignatius's puzzle"
date: 2016-03-22 11:20:33 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Ignatius is poor at math,he falls across a puzzle problem,so he has no choice but to appeal to Eddy. this problem describes that:f(x)=5*x^13+13*x^5+k*a*x,input a nonegative integer 
---


Problem Description 
Ignatius is poor at math,he falls across a puzzle problem,so he has no choice but to appeal to Eddy. this problem describes that:f(x)=5*x^13+13*x^5+k*a*x,input a nonegative integer
<!-- more -->
----------

Problem Description
Ignatius is poor at math,he falls across a puzzle problem,so he has no choice but to appeal to Eddy. this problem describes that:f(x)=5*x^13+13*x^5+k*a*x,input a nonegative integer k(k<10000),to find the minimal nonegative integer a,make the arbitrary integer x ,65|f(x)if
no exists that a,then print "no".


 

Input
The input contains several test cases. Each test case consists of a nonegative integer k, More details in the Sample Input.

 

Output
The output contains a string "no",if you can't find a,or you should output a line contains the a.More details in the Sample Output.

 

Sample Input
11
100
9999
 

Sample Output
22
no
43


题目大意：方程f(x)=5*x^13+13*x^5+k*a*x；输入任意一个数k，是否存在一个数a，对任意x都能使得f(x)能被65整除。
现假设存在这个数a ,因为对于任意x方程都成立
所以，当x=1时f(x)=18+ka
又因为f(x)能被65整出，故设n为整数
可得，f(x)=n*65;
即：18+ka=n*65;
因为n为整数，若要方程成立
则问题转化为，
对于给定范围的a只需要验证，
是否存在一个a使得(18+k*a)%65==0
所以容易解得
注意，这里有童鞋不理解为什么a只需到65即可
因为，当a==66时
也就相当于已经找了一个周期了，所以再找下去也找不到适当的a了

```
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int k= sc.nextInt();
			boolean flag=false;
			for(int a=0;a<=65;a++){
				if((18+k*a)%65==0){
					System.out.println(a);
					flag = true;
					break;
				}
			}
			
			if(!flag){
				System.out.println("no");
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
