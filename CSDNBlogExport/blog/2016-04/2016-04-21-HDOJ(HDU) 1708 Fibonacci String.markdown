---
layout: post
title: "HDOJ(HDU) 1708 Fibonacci String"
date: 2016-04-21 12:37:10 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [string]
keyword: 陈浩翔, 谙忆
description: Problem Description 
After little Jim learned Fibonacci Number in the class , he was very interest in it. 
Now he is thinking about a new thing – Fibonacci String .He defines : str[n] = str[n-1] + str[ 
---


Problem Description 
After little Jim learned Fibonacci Number in the class , he was very interest in it. 
Now he is thinking about a new thing – Fibonacci String .He defines : str[n] = str[n-1] + str[
<!-- more -->
----------

Problem Description
After little Jim learned Fibonacci Number in the class , he was very interest in it.
Now he is thinking about a new thing -- Fibonacci String .

He defines : str[n] = str[n-1] + str[n-2] ( n > 1 ) 

He is so crazying that if someone gives him two strings str[0] and str[1], he will calculate the str[2],str[3],str[4] , str[5].... 

For example :
If str[0] = "ab"; str[1] = "bc";
he will get the result , str[2]="abbc", str[3]="bcabbc" , str[4]="abbcbcabbc" …………;

As the string is too long ,Jim can't write down all the strings in paper. So he just want to know how many times each letter appears in Kth Fibonacci String . Can you help him ?

 

Input
The first line contains a integer N which indicates the number of test cases.
Then N cases follow.
In each case,there are two strings str[0], str[1] and a integer K (0 <= K < 50) which are separated by a blank.
The string in the input will only contains less than 30 low-case letters.

 

Output
For each case,you should count how many times each letter appears in the Kth Fibonacci String and print out them in the format "X:N". 
If you still have some questions, look the sample output carefully.
Please output a blank line after each test case.

To make the problem easier, you can assume the result will in the range of int. 

 

Sample Input
1
ab bc 3
 

Sample Output
a:1
b:3
c:2
d:0
e:0
f:0
g:0
h:0
i:0
j:0
k:0
l:0
m:0
n:0
o:0
p:0
q:0
r:0
s:0
t:0
u:0
v:0
w:0
x:0
y:0
z:0

格式：每个案例后面都有一个空行！！！

不能直接用字符串相加来做，因为可能到后面会超内存！累加到后面的字符串太长了！！！

所以换位思考，既然是统计字母的个数，为什么不直接来建立整型数组呢。
只要统计出str0和str1中各个字母的个数就可以了。
后面各个字母个数的按照公式来推就行。

```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		long num[][] = new long[56][26];
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			for(int i=0;i<num[0].length;i++){
				for(int j=0;j<num.length;j++){
					num[j][i]=0;
				}
			}
			String str0 = sc.next();
			for(int i=0;i<str0.length();i++){
				for(int j='a';j<='z';j++){
					if(str0.charAt(i)==(char)j){
						num[0][j-'a']++;
						break;
					}
				}
			}
			String str1 = sc.next();
			for(int i=0;i<str1.length();i++){
				for(int j='a';j<='z';j++){
					if(str1.charAt(i)==(char)j){
						num[1][j-'a']++;
						break;
					}
				}
			}
			int n = sc.nextInt();
			for(int i=2;i<=n;i++){
				for(int k='a';k<='z';k++){
					num[i][k-'a'] = num[i-1][k-'a']+num[i-2][k-'a'];
				}
			}
			
			for(int k='a';k<='z';k++){
				System.out.println((char)k+":"+num[n][k-'a']);
			}
			System.out.println();
			
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
