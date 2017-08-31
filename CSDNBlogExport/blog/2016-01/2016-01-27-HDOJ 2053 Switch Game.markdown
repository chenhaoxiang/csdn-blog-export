---
layout: post
title: "HDOJ 2053 Switch Game"
date: 2016-01-27 04:33:26 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 公约数公倍数
tags: [switch,java]
keyword: 陈浩翔, 谙忆
description: Problem Description 
There are many lamps in a line. All of them are off at first. A series of operations are carried out on these lamps. On the i-th operation, the lamps whose numbers are the multiple 
---


Problem Description 
There are many lamps in a line. All of them are off at first. A series of operations are carried out on these lamps. On the i-th operation, the lamps whose numbers are the multiple
<!-- more -->
----------

Problem Description
There are many lamps in a line. All of them are off at first. A series of operations are carried out on these lamps. On the i-th operation, the lamps whose numbers are the multiple of i change the condition ( on to off and off to on ).
 

Input
Each test case contains only a number n ( 0<  n < = 10^5) in a line.

 

Output
Output the condition of the n-th lamp after infinity operations ( 0 - off, 1 - on ).
 

Sample Input
1
5
 

Sample Output
1
0

Hinthint 

Consider the second test case:

The initial condition	   : 0 0 0 0 0 …
After the first operation  : 1 1 1 1 1 …
After the second operation : 1 0 1 0 1 …
After the third operation  : 1 0 0 0 1 …
After the fourth operation : 1 0 0 1 1 …
After the fifth operation  : 1 0 0 1 0 …

The later operations cannot change the condition of the fifth lamp any more. So the answer is 0.




思路：
说下题目大意吧，
先把这些灯标上号，1 2 3 4 5 6 7 8 ……无穷
首先全是关的，也就是全是0
第一次操作 ，标号是1的倍数，全都变成相反的状态，也就是全变成1.。
第二次操作 ，标号是2的倍数，全都变成相反的状态，你可以看下，2 4 6……变成了0.。。
第三次操作 ，标号是3的倍数，全都变成相反的状态，你可以看下，3 6 9……

他问你 N 号台灯最后 变成了 什么状态，
例如 1号灯，最后变成了1，不管多少次操作都是1.。
例如 5号灯 最后变成了0，不管多少次操作都是0.。

当操作次数大于N的时候 N的状态就不会改变了，因为N不会是M（M>N）的倍数。。


本题思路很简单就是求n有几个约数（包括1和自身）如果有奇数个约数，变奇数次，结果也就是1；否则为0



```
import java.util.Scanner;

public class Main {
//	static boolean[] islight = new boolean[100002];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			
//			for(int i=1;i<=n;i++){
//				islight[i] = false;
//			}
//			
//			for (int i = 1; i <= n; i++) {
//				for (int j = 1; j <= n; j++) {
//					if(j%i==0){
//						islight[j] = !islight[j];
//					}
//				}
//			}
//			
//			if(islight[n]){
//				System.out.println("1");
//			}else{
//				System.out.println("0");
//			}
//			超时
			
			int k =0;
			for(int i=1;i<=n;i++){
				if(n%i==0){
					k++;
				}
			}
			
			if(k%2==0){
				System.out.println("0");
			}else{
				System.out.println("1");
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
