---
layout: post
title: "HDOJ(HDU) 2106 decimal system(进制相互转换问题)"
date: 2016-05-01 04:18:39 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 进制相关
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
As we know , we always use the decimal system in our common life, even using the computer. If we want to calculate the value that 3 plus 9, we just import 3 and 9.after calculation 
---


Problem Description 
As we know , we always use the decimal system in our common life, even using the computer. If we want to calculate the value that 3 plus 9, we just import 3 and 9.after calculation
<!-- more -->
----------

Problem Description
As we know , we always use the decimal system in our common life, even using the computer. If we want to calculate the value that 3 plus 9, we just import 3 and 9.after calculation of computer, we will get the result of 12.
But after learning <<The Principle Of Computer>>,we know that the computer will do the calculation as the following steps:
1 computer change the 3 into binary formality like 11;
2 computer change the 9 into binary formality like 1001;
3 computer plus the two number and get the result 1100;
4 computer change the result into decimal formality like 12;
5 computer export the result;

In the computer system there are other formalities to deal with the number such as hexadecimal. Now I will give several number with a kind of change method, for example, if I give you 1011(2), it means 1011 is a number in the binary system, and 123(10) means 123 if a number in the decimal system. Now I will give you some numbers with any kind of system, you guys should tell me the sum of the number in the decimal system.
 

Input
There will be several cases. The first line of each case contains one integers N, and N means there will be N numbers to import, then there will be N numbers at the next N lines, each line contains a number with such form : X1….Xn.(Y), and 0<=Xi<Y, 1<Y<=10. I promise you that the sum will not exceed the 100000000, and there will be at most 100 cases and the 0<N<=1000.
 

Output
There is only one line output case for each input case, which is the sum of all the number. The sum must be expressed using the decimal system.
 

Sample Input
3
1(2)
2(3)
3(4)

4
11(10)
11(2)
11(3)
11(4)
 

Sample Output
6
23


利用java可谓是简单的就可以AC了。
题目意思是，输入的（）里面的是前面那个数的进制基数，求这些数的十进制之和是多少？
输出。



```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			long sum=0;
			int n =sc.nextInt();
			String str = null;
			for(int i=0;i<n;i++){
				str =sc.next();
				String strs[] = str.split("\\(");
				int num = Integer.parseInt( strs[0]);
				
				String strHex = "";
				for(int j=0;j<strs[1].length();j++){
					if(strs[1].charAt(j)!=')'){
						strHex = strHex+strs[1].charAt(j);
					}
				}
				
				int hex = Integer.parseInt(strHex);
				
				if(hex==10){
					sum+=num;
				}else{
					//hex为num这个数的进制基数。也就是说num为hex进制的数。
					//返回的是一个十进制的数。。
					num = Integer.parseInt(Integer.toString(num), hex);
					sum+=num;
				}
			}
			
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
