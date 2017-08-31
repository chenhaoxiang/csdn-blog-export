---
layout: post
title: "HDOJ(HDU) 2093 考试排名(Arrays.sort排序、类的应用)"
date: 2016-04-30 02:57:01 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
C++编程考试使用的实时提交系统，具有即时获得成绩排名的特点。它的功能是怎么实现的呢？ 
我们做好了题目的解答，提交之后，要么“AC”，要么错误，不管怎样错法，总是给你记上一笔，表明你曾经有过一次错误提交，因而当你一旦提交该题“AC”后，就要与你算一算帐了，总共该题错误提交了几回。虽然你在题数上，大步地跃上了一个台阶，但是在耗时上要摊上你共花去的时间。特别是 
---


Problem Description 
C++编程考试使用的实时提交系统，具有即时获得成绩排名的特点。它的功能是怎么实现的呢？ 
我们做好了题目的解答，提交之后，要么“AC”，要么错误，不管怎样错法，总是给你记上一笔，表明你曾经有过一次错误提交，因而当你一旦提交该题“AC”后，就要与你算一算帐了，总共该题错误提交了几回。虽然你在题数上，大步地跃上了一个台阶，但是在耗时上要摊上你共花去的时间。特别是
<!-- more -->
----------

Problem Description
C++编程考试使用的实时提交系统，具有即时获得成绩排名的特点。它的功能是怎么实现的呢？
我们做好了题目的解答，提交之后，要么“AC”，要么错误，不管怎样错法，总是给你记上一笔，表明你曾经有过一次错误提交，因而当你一旦提交该题“AC”后，就要与你算一算帐了，总共该题错误提交了几回。虽然你在题数上，大步地跃上了一个台阶，但是在耗时上要摊上你共花去的时间。特别是，曾经有过的错误提交，每次都要摊上一定的单位时间分。这样一来，你在做出的题数上，可能领先别人很多，但是，在做出同样题数的人群中，你可能会在耗时上处于排名的劣势。
例如：某次考试一共8题（A，B，C，D，E，F，G，H），每个人做的题都在对应的题号下有个数量标记，负数表示该学生在该题上有过的错误提交次数，但到现在还没有AC，正数表示AC所耗的时间，如果正数a跟上一对括号，里面有个整数b，那就表示该学生提交该题AC了，耗去了时间a，同时，曾经错误提交了b次，因此对于下述输入数据：

![](http://img.blog.csdn.net/20160430145040937)

若每次错误提交的罚分为20分，则其排名从高到低应该是这样的：
Josephus 5 376
John 4 284
Alice 4 352
Smith 3 167
Bob 2 325
Bush 0 0

 

Input
输入数据的第一行是考试题数n（1≤n≤12）以及单位罚分数m（10≤m≤20），每行数据描述一个学生的用户名（不多于10个字符的字串）以及对所有n道题的答题现状，其描述采用问题描述中的数量标记的格式，见上面的表格，提交次数总是小于100，AC所耗时间总是小于1000。


 

Output
将这些学生的考试现状，输出一个实时排名。实时排名显然先按AC题数的多少排，多的在前，再按时间分的多少排，少的在前，如果凑巧前两者都相等，则按名字的字典序排，小的在前。每个学生占一行，输出名字（10个字符宽），做出的题数（2个字符宽，右对齐）和时间分（4个字符宽，右对齐）。名字、题数和时间分相互之间有一个空格。

 

```
Sample Input
8 20
Smith	  -1	-16	8	0	0	120	39	0
John	  116	-2	11	0	0	82	55(1)	0
Josephus  72(3)	126	10	-3	0	47	21(2)	-2
Bush	  0	-1	-8	0	0	0	0	0
Alice	  -2	67(2)	13	-1	0	133	79(1)	-1
Bob	  0	0	57(5)	0	0	168	-7	0
 

Sample Output
Josephus    5  376
John        4  284
Alice       4  352
Smith       3  167
Bob         2  325
Bush        0    0
```


我用了2个内部类来做，一个是输入的类，一个是输出的类。

解析在代码中有。

注意格式！名字除了要占10个字符还要和AC的题目数之间空一格。
题目数和时间也是一样的，之间需要空一格。

```
package cn.hncu.acm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P2093 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		answer asr[] = new answer[200];
		while(sc.hasNext()){
			int n = sc.nextInt();
			int t = sc.nextInt();
			int a = 0;
			int num;//提交正确的题目数
			int time;//提交的时间
			while(sc.hasNext()){
				asr[a] = new answer();
				student1 s = new student1();
				s.name = sc.next();
//				if(s.name.equals("#")){
//					break;
//				}//自己测试的时候需要有一个结束的，不然自己看不到结果
				asr[a].name=s.name;
				num =n;
				time=0;
				s.strMark= new String[n];//必须要new 不然会空指针异常
				for(int i=0;i<n;i++){
					s.strMark[i] = sc.next();
					if(s.strMark[i].charAt(0)=='-'||s.strMark[i].equals("0")){
						num--;//如果提交次数为0，或者没有提交通过，则num减一
					}else{
						//提交通过的
						String s1="";//s1是提交的时间
						String s2="";//s2是提交错误的次数
						boolean isS1 = true;
						for(int k=0;k<s.strMark[i].length();k++){
							if(isS1){
								if(s.strMark[i].charAt(k)=='('){
									isS1=false;
									continue;
								}
								s1 = s1+s.strMark[i].charAt(k);
							}else{
								if(s.strMark[i].charAt(k)==')'){
									break;
								}
								s2 = s2+s.strMark[i].charAt(k);
							}
						}
						//System.out.println("s1="+Integer.parseInt(s1));
						//System.out.println("s2="+Integer.parseInt(s2));
						if(s2.equals("")){
							//如果提交错误次数为0
							time+= Integer.parseInt(s1);
						}else{
							//有提交次数错误的
							time += Integer.parseInt(s1)+(Integer.parseInt(s2)*t);
						}
					}
				}
				asr[a].time=time;
				asr[a].num=num;
				a++;
			}
			Arrays.sort(asr,0,a, new Comparator<answer>() {
				@Override
				public int compare(answer o1, answer o2) {
					//提交正确的题目多的排前面。
					
					if(o1.num>o2.num){
						return -1;
					}
					if(o1.num<o2.num){
						return 1;
					}
					
					//如果提交的正确题目数量是一样的，则time小的排前面。
					return o1.time-o2.time;
				}
			});
			for(int i=0;i<a;i++){
				System.out.printf("%-10s %2d %4d",asr[i].name,asr[i].num,asr[i].time);
				System.out.println();
			}
		}
	}
}

class student1 {
	//输入的
	String name;
	String strMark[];
}

class answer {
	//输出的
	String name;
	int num;
	int time;
}
```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
