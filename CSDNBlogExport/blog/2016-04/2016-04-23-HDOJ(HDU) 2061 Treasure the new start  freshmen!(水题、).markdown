---
layout: post
title: "HDOJ(HDU) 2061 Treasure the new start  freshmen!(水题、)"
date: 2016-04-23 12:01:26 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
background: 
A new semester comes , and the HDU also meets its 50th birthday. No matter what’s your major, the only thing I want to tell you is:”Treasure the college life and seize 
---


Problem Description 
background: 
A new semester comes , and the HDU also meets its 50th birthday. No matter what’s your major, the only thing I want to tell you is:”Treasure the college life and seize
<!-- more -->
----------

Problem Description
background:
A new semester comes , and the HDU also meets its 50th birthday. No matter what's your major, the only thing I want to tell you is:"Treasure the college life and seize the time." Most people thought that the college life should be colorful, less presure.But in actual, the college life is also busy and rough. If you want to master the knowledge learned from the book, a great deal of leisure time should be spend on individual study and practise, especially on the latter one. I think the every one of you should take the learning attitude just as you have in senior school.
"No pain, No Gain", HDU also has scholarship, who can win it? That's mainly rely on the GPA(grade-point average) of the student had got. Now, I gonna tell you the rule, and your task is to program to caculate the GPA.
If there are K(K > 0) courses, the i-th course has the credit Ci, your score Si, then the result GPA is
GPA = (C1 * S1 + C2 * S2 +……+Ci * Si……) / (C1 + C2 + ……+ Ci……) (1 <= i <= K, Ci != 0)
If there is a 0 <= Si < 60, The GPA is always not existed. 
 

Input
The first number N indicate that there are N test cases(N <= 50). In each case, there is a number K (the total courses number), then K lines followed, each line would obey the format: Course-Name (Length <= 30) , Credits(<= 10), Score(<= 100).
Notice: There is no blank in the Course Name. All the Inputs are legal
 

Output
Output the GPA of each case as discribed above, if the GPA is not existed, ouput:"Sorry!", else just output the GPA value which is rounded to the 2 digits after the decimal point. There is a blank line between two test cases. 

 

Sample Input
2
3
Algorithm 3 97
DataStruct 3 90
softwareProject 4 85
2
Database 4 59
English 4 81
 

Sample Output
90.10

Sorry!


题意：
输入：name c s
只要有一个成绩s是小于60的，输出就是“Sorry!”。
如果大于等于60,就计算GPA，公式
GPA = (C1 * S1 + C2 * S2 +……+Ci * Si……) / (C1 + C2 + ……+ Ci……) (1 <= i <= K, Ci != 0)

注意格式：输出之间有一个空行。答案保留2位小数！
(%.2f)输出是按照四舍五入的形式的。题目也是这么要求的！

```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			
			int m = sc.nextInt();
			String str = "" ;
			int c =0;
			int s = 0;
			boolean isSorry = false;
			double num1=0;
			double num2=0;
			double a=0;
			double b=0;
			for(int i=0;i<m;i++){
				str = sc.next();
				a=sc.nextDouble();
				b=sc.nextDouble();
				if(b<60){
					isSorry = true;
				}else{
					num1 = num1+a*b;
					num2 = num2 +a;
				}
			}
			if(isSorry){
				System.out.println("Sorry!");
			}else{
				System.out.printf("%.2f",num1/num2);
				System.out.println();
			}
			if(t!=0){
				System.out.println();
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
