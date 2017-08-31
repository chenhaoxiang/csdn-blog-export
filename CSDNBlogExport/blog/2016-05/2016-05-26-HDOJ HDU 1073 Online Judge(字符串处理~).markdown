---
layout: post
title: "HDOJ HDU 1073 Online Judge(字符串处理~)"
date: 2016-05-26 01:19:02 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- String
tags: [java,acm,字符串]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Ignatius is building an Online Judge, now he has worked out all the problems except the Judge System. The system has to read data from correct output file and user’s result file, t 
---


Problem Description 
Ignatius is building an Online Judge, now he has worked out all the problems except the Judge System. The system has to read data from correct output file and user’s result file, t
<!-- more -->
----------

Problem Description
Ignatius is building an Online Judge, now he has worked out all the problems except the Judge System. The system has to read data from correct output file and user's result file, then the system compare the two files. If the two files are absolutly same, then the Judge System return "Accepted", else if the only differences between the two files are spaces(' '), tabs('\t'), or enters('\n'), the Judge System should return "Presentation Error", else the system will return "Wrong Answer".

Given the data of correct output file and the data of user's result file, your task is to determine which result the Judge System will return.

 

Input
The input contains several test cases. The first line of the input is a single integer T which is the number of test cases. T test cases follow.
Each test case has two parts, the data of correct output file and the data of the user's result file. Both of them are starts with a single line contains a string "START" and end with a single line contains a string "END", these two strings are not the data. In other words, the data is between the two strings. The data will at most 5000 characters.

 

Output
For each test cases, you should output the the result Judge System should return.

 

Sample Input
4
START
1 + 2 = 3
END
START
1+2=3
END
START
1 + 2 = 3
END
START
1 + 2 = 3

END
START
1 + 2 = 3
END
START
1 + 2 = 4
END
START
1 + 2 = 3
END
START
1	+	2	=	3
END
 

Sample Output
Presentation Error
Presentation Error
Wrong Answer
Presentation Error


就是输入输出，简单的判断PE，WA，AC这几种情况。

START是开始输入了，
END是结束输入了。数据在这个之间！
每一组有2个 START和END。
就是判断这2个之间的数据是PE，WA还是AC。


分析：
用2字符串分别存储这2个需要比较的数据，遇到换行需要在字符串中加入'\n'。
先看这2个字符串是不是相等，如果相等，就是AC。
不相等，再来判断是PE还是WA。


```
import java.util.Scanner;
/**
 * @author 陈浩翔
 *
 * 2016-5-26
 */
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while (t-- > 0) {
			String a = "";
			String b = "";
			while (true) {
				String str = sc.nextLine();
				if ("END".equals(str)) {
					break;
				}
				if ("START".equals(str)) {
					continue;
				}
				a=a+str;
				a=a+"\n";
			}

			while (true) {
				String str = sc.nextLine();
				if ("END".equals(str)) {
					break;
				}
				if ("START".equals(str)) {
					continue;
				}
				b=b+str;
				b=b+"\n";
			}
			int con = 0;// -1--PE,0--WA,1--AC
			
//			System.out.println(a);
//			System.out.println(a.length());
//			System.out.println(b);
//			System.out.println(b.length());
			
			if(a.equals(b)){
				con=1;
			}else{
				con=-1;
				String stra="";
				for(int i=0;i<a.length();i++){
					if(a.charAt(i)==' '||a.charAt(i)=='\t'||a.charAt(i)=='\n'){
						continue;
					}
					stra=stra+a.charAt(i);
				}
				String strb="";
				for(int i=0;i<b.length();i++){
					if(b.charAt(i)==' '||b.charAt(i)=='\t'||b.charAt(i)=='\n'){
						continue;
					}
					strb=strb+b.charAt(i);
				}
//				System.out.println(stra);
//				System.out.println("-------------");
//				System.out.println(strb);
				if(stra.equals(strb)){
					con=-1;
				}else{
					con=0;
				}
			}
			
			
			if(con==0){
				System.out.println("Wrong Answer");
			}else if(con==-1){
				System.out.println("Presentation Error");
			}else{
				System.out.println("Accepted");
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
