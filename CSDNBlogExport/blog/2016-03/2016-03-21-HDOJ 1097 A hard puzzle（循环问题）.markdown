---
layout: post
title: "HDOJ 1097 A hard puzzle（循环问题）"
date: 2016-03-21 08:17:08 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 判断循环-循环节
tags: [acm,java]
keyword: 陈浩翔, 谙忆
description: Problem Description 
lcy gives a hard puzzle to feng5166,lwg,JGShining and Ignatius: gave a and b,how to know the a^b.everybody objects to this BT problem,so lcy makes the problem easier than begin. 
t 
---


Problem Description 
lcy gives a hard puzzle to feng5166,lwg,JGShining and Ignatius: gave a and b,how to know the a^b.everybody objects to this BT problem,so lcy makes the problem easier than begin. 
t
<!-- more -->
----------

Problem Description
lcy gives a hard puzzle to feng5166,lwg,JGShining and Ignatius: gave a and b,how to know the a^b.everybody objects to this BT problem,so lcy makes the problem easier than begin.
this puzzle describes that: gave a and b,how to know the a^b's the last digit number.But everybody is too lazy to slove this problem,so they remit to you who is wise.

 

Input
There are mutiple test cases. Each test cases consists of two numbers a and b(0< a,b<=2^30)

 

Output
For each test case, you should output the a^b's last digit number.

 

Sample Input
7 66
8 800
 

Sample Output
9
6


本题重要的是循环节的判断，java的大数会超时的。
下面代码实现了循环节的寻找。
```
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
	static int da[] = new int[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dabiao();//打表
		while(sc.hasNext()){
			//超时
//			BigDecimal a = sc.nextBigDecimal();
//			int b = sc.nextInt();
//			a = a.pow(b);
//			String str = a.toString();
//			System.out.println(str.charAt(str.length()-1));
			
			//找规律
			int a = sc.nextInt();
			int b = sc.nextInt();
			a = a%10;
			switch(a){
			case 0:System.out.println(da[0]);break;
			case 1:System.out.println(da[1]);break;
			case 2:System.out.println(shuchu(b,da[2],2));break;
			case 3:System.out.println(shuchu(b,da[3],3));break;
			case 4:System.out.println(shuchu(b,da[4],4));break;
			case 5:System.out.println(shuchu(b,da[5],5));break;
			case 6:System.out.println(shuchu(b,da[6],6));break;
			case 7:System.out.println(shuchu(b,da[7],7));break;
			case 8:System.out.println(shuchu(b,da[8],8));break;
			case 9:System.out.println(shuchu(b,da[9],9));break;
			}
			
		}
		
	}

	private static int shuchu(int b, int i, int j) {
		b=b%i;
		int sum=j;
		if(b==0){
			b=i;
		}
		for(int k=1;k<b;k++){
			sum=sum*j;
		}
		return sum%10;
	}



	private static void dabiao() {
		da[0]=0;
		da[1]=1;
	
		int h=0;
		for(int i=2;i<10;i++){
			h=0;
			for(int k=2;k<10;k++){
				if(i==hm(k,i)){
					h=k-1;
					break;
				}
			}
			da[i]=h;
		}
		
		//0-9的循环节输出
//		for(int i=0;i<10;i++){
//			System.out.println(da[i]);
//		}
		
		
	}

	private static int hm(int k,int i) {
		int sum=1;
		for(int j=0;j<k;j++){
			sum=sum*i;
		}
		return sum%10;
	}


}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
