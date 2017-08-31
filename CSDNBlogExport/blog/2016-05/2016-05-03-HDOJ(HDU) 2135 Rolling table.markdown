---
layout: post
title: "HDOJ(HDU) 2135 Rolling table"
date: 2016-05-03 07:56:05 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
After the 32nd ACM/ICPC regional contest, Wiskey is beginning to prepare for CET-6. He has an English words table and read it every morning. 
One day, Wiskey’s chum wants to play a 
---


Problem Description 
After the 32nd ACM/ICPC regional contest, Wiskey is beginning to prepare for CET-6. He has an English words table and read it every morning. 
One day, Wiskey’s chum wants to play a
<!-- more -->
----------

Problem Description
After the 32nd ACM/ICPC regional contest, Wiskey is beginning to prepare for CET-6. He has an English words table and read it every morning.
One day, Wiskey's chum wants to play a joke on him. He rolling the table, and tell Wiskey how many time he rotated. Rotate 90 degrees clockwise or count-clockwise each time.
The table has n*n grids. Your task is tell Wiskey the final status of the table.

 

Input
Each line will contain two number.
The first is postive integer n (0 < n <= 10).
The seconed is signed 32-bit integer m.
if m is postive, it represent rotate clockwise m times, else it represent rotate count-clockwise -m times.
Following n lines. Every line contain n characters.

 

Output
Output the n*n grids of the final status.

 

Sample Input
3 2
123
456
789
3 -1
123
456
789
 

Sample Output
987
654
321
369
258
147

(注意是字符啊！字符！我开始以为是n*n个1-n*n的数字。。。WA了几次)
输入n*n个字符，每次旋转以90°为单位，m>0表示顺时针旋转
m<0逆时针旋转。
矩阵旋转后存在四种状态。所以将m取余4，然后判断是哪种状态，然后旋转即可。


```
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			String strs[]=new String[n];
			for(int i=0;i<n;i++){
				strs[i]=sc.next();
			}
			if(m%4==0){
				for(int i=0;i<n;i++){
					System.out.println(strs[i]);
				}
				continue;
			}
			if(m>0){
				m=m%4;
				if(m==1){
					for(int i=0;i<n;i++){
						for(int j=n-1;j>=0;j--){
							System.out.print(strs[j].charAt(i));
						}
						System.out.println();
					}
					continue;
				}
				if(m==2){
					for(int i=n-1;i>=0;i--){
						for(int j=n-1;j>=0;j--){
							System.out.print(strs[i].charAt(j));
						}
						System.out.println();
					}
					continue;
				}
				if(m==3){
					for(int i=n-1;i>=0;i--){
						for(int j=0;j<n;j++){
							System.out.print(strs[j].charAt(i));
						}
						System.out.println();
					}
					continue;
				}
			}
			if(m<0){
				m=m*(-1);
				m=m%4;
				if(m==3){
					for(int i=0;i<n;i++){
						for(int j=n-1;j>=0;j--){
							System.out.print(strs[j].charAt(i));
						}
						System.out.println();
					}
					continue;
				}
				if(m==2){
					for(int i=n-1;i>=0;i--){
						for(int j=n-1;j>=0;j--){
							System.out.print(strs[i].charAt(j));
						}
						System.out.println();
					}
					continue;
				}
				if(m==1){
					for(int i=n-1;i>=0;i--){
						for(int j=0;j<n;j++){
							System.out.print(strs[j].charAt(i));
						}
						System.out.println();
					}
				}
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
