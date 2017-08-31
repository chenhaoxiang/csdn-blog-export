---
layout: post
title: "HDOJ HDU 1022 Train Problem I(模拟栈)"
date: 2016-06-14 06:10:59 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 递归搜索回溯
tags: [栈]
keyword: 陈浩翔, 谙忆
description: Problem Description 
As the new term comes, the Ignatius Train Station is very busy nowadays. A lot of student want to get back to school by train(because the trains in the Ignatius Train Station is th 
---


Problem Description 
As the new term comes, the Ignatius Train Station is very busy nowadays. A lot of student want to get back to school by train(because the trains in the Ignatius Train Station is th
<!-- more -->
----------

Problem Description
As the new term comes, the Ignatius Train Station is very busy nowadays. A lot of student want to get back to school by train(because the trains in the Ignatius Train Station is the fastest all over the world ^v^). But here comes a problem, there is only one railway where all the trains stop. So all the trains come in from one side and get out from the other side. For this problem, if train A gets into the railway first, and then train B gets into the railway before train A leaves, train A can't leave until train B leaves. The pictures below figure out the problem. Now the problem for you is, there are at most 9 trains in the station, all the trains has an ID(numbered from 1 to n), the trains get into the railway in an order O1, your task is to determine whether the trains can get out in an order O2.
![](http://img.blog.csdn.net/20160614180835223)
![](http://img.blog.csdn.net/20160614180804170)
![](http://img.blog.csdn.net/20160614180843703)
 

Input
The input contains several test cases. Each test case consists of an integer, the number of trains, and two strings, the order of the trains come in:O1, and the order of the trains leave:O2. The input is terminated by the end of file. More details in the Sample Input.

 

Output
The output contains a string "No." if you can't exchange O2 to O1, or you should output a line contains "Yes.", and then output your way in exchanging the order(you should output "in" for a train getting into the railway, and "out" for a train getting out of the railway). Print a line contains "FINISH" after each test case. More details in the Sample Output.

 

Sample Input
3 123 321
3 123 312
 

Sample Output
Yes.
in
in
in
out
out
out
FINISH
No.
FINISH

HintHint 
For the first Sample Input, we let train 1 get in, then train 2 and train 3.
So now train 3 is at the top of the railway, so train 3 can leave first, then train 2 and train 1.
In the second Sample input, we should let train 3 leave first, so we have to let train 1 get in, then train 2 and train 3.
Now we can let train 3 leave.
But after that we can't let train 1 leave before train 2, because train 2 is at the top of the railway at the moment.
So we output "No.".


<b><font color="red">
火车进站问题，输入首先包含一个整数N，表示要进站的火车数，然后是依次输入进站火车的序号，然后再输入出站火车的序号，看是否符合出站顺序。
当符合顺序的时候输出”Yes.”依次输入每趟车进站出站的状态进站表示”in”  出站表示”out”，
当不符合顺序的时候输出”No.”程序结束后输出”FINISH”
分析：
模拟栈的输入输出！
</font></b>


```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int t = sc.nextInt();
			String in = sc.next();
			String out = sc.next();
			int a=0;
			int b=0;
			boolean ok=true;
			int top=0;//表示栈里面还有元素
			char stack[] = new char[50];
			boolean flag[] = new boolean[50];
			int i=0;
			while(b<t){
				if(top!=0 && ( stack[top]==out.charAt(b) )){
					top--;
					b++;
					flag[i]=false;
					i++;
				}else if(a<t && in.charAt(a)==out.charAt(b)){
					a++;
					b++;
					flag[i]=true;
					i++;
					flag[i]=false;
					i++;
				}else if(a<t){
					top++;
					stack[top]=in.charAt(a);
					a++;
					flag[i]=true;
					i++;
				}else{
					ok=false;
					break;
				}
			}
			if(ok){
				System.out.println("Yes.");
				for(int k=0;k<i;k++){
					System.out.println( flag[k]?"in":"out" );
				}
			}else{
				System.out.println("No.");
			}
			
			
			System.out.println("FINISH");
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
