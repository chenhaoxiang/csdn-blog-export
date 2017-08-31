---
layout: post
title: "HDOJ(HDU) 2304 Electrical Outlets(求和、、)"
date: 2016-05-06 08:30:22 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Roy has just moved into a new apartment. Well, actually the apartment itself is not very new, even dating back to the days before people had electricity in their houses. Because of 
---


Problem Description 
Roy has just moved into a new apartment. Well, actually the apartment itself is not very new, even dating back to the days before people had electricity in their houses. Because of
<!-- more -->
----------

Problem Description
Roy has just moved into a new apartment. Well, actually the apartment itself is not very new, even dating back to the days before people had electricity in their houses. Because of this, Roy's apartment has only one single wall outlet, so Roy can only power one of his electrical appliances at a time. 
Roy likes to watch TV as he works on his computer, and to listen to his HiFi system (on high volume) while he vacuums, so using just the single outlet is not an option. Actually, he wants to have all his appliances connected to a powered outlet, all the time. The answer, of course, is power strips, and Roy has some old ones that he used in his old apartment. However, that apartment had many more wall outlets, so he is not sure whether his power strips will provide him with enough outlets now. 
Your task is to help Roy compute how many appliances he can provide with electricity, given a set of power strips. Note that without any power strips, Roy can power one single appliance through the wall outlet. Also, remember that a power strip has to be powered itself to be of any use.
 

Input
Input will start with a single integer 1 <= N <= 20, indicating the number of test cases to follow. Then follow N lines, each describing a test case. Each test case starts with an integer 1 <= K <= 10, indicating the number of power strips in the test case. Then follow, on the same line, K integers separated by single spaces, O1 O2 . . . OK, where 2 <= Oi <= 10, indicating the number of outlets in each power strip.
 

Output
Output one line per test case, with the maximum number of appliances that can be powered.
 

Sample Input
3
3 2 3 4
10 4 4 4 4 4 4 4 4 4 4
4 10 10 10 10
 

Sample Output
7
31
37


这个是关于排插的问题，就是给你m个排插，每个排插上有x个孔，最开始只有一个墙壁能插一个排插，问能插多少个电器，一个电器要占一个孔。

也就是把这些排插给串起来，串起来的排插也需要占一个孔，然后因为最后一个排插不用被排插占一个孔，所以不用减一，
所以答案就是：m个排插的孔全部加起来，再减去（m-1）;

```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			int n =sc.nextInt();
			int sum=0;
			int a;
			for(int i=0;i<n;i++){
				a=sc.nextInt();
				sum+=a;
			}
			sum=sum-n+1;
			System.out.println(sum);
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
