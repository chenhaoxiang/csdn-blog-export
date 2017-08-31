---
layout: post
title: "HDOJ HDU 1982 Kaitou Kid - The Phantom Thief (1)(字符串处理)"
date: 2016-06-02 01:29:06 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- String,----- 基础题
tags: [java,acm,String]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Do you know Kaitou Kid? In the legend, Kaitou Kid is a master of disguise, and can take on the voice and form of anyone. He is not an evil person, but he is on the wrong side of th 
---


Problem Description 
Do you know Kaitou Kid? In the legend, Kaitou Kid is a master of disguise, and can take on the voice and form of anyone. He is not an evil person, but he is on the wrong side of th
<!-- more -->
----------

Problem Description
Do you know Kaitou Kid? In the legend, Kaitou Kid is a master of disguise, and can take on the voice and form of anyone. He is not an evil person, but he is on the wrong side of the law. He's the very elusive phantom thief who never miss his prey although he always uses word puzzles to announce his targets before action.


![](http://img.blog.csdn.net/20160602132407751)


You are the leader of a museum. Recently, you get several priceless jewels and plan to hold an exhibition. But at the moment, you receive Kid's word puzzle... Fortunately, It seems Kid doesn’t want to trouble you, and his puzzle is very easy. Just a few minutes, You have found the way to solve the puzzle:

(1) change 1 to 'A', 2 TO 'B',..,26 TO 'Z'
(2) change '#' to a blank
(3) ignore the '-' symbol, it just used to separate the numbers in the puzzle

 

Input
The first line of the input contains an integer C which means the number of test cases. Then C lines follow. Each line is a sentence of Kid’s word puzzle which is consisted of '0' ~ '9' , '-' and '#'. The length of each sentence is no longer than 10000.
 

Output
For each case, output the translated text.
 

Sample Input
4
9#23-9-12-12#19-20-5-1-12#1-20#12-5-1-19-20#15-14-5#10-5-23-5-12
1-14-4#12-5-1-22-5#20-8-5#13-21-19-5-21-13#9-14#20#13-9-14-21-20-5-19
1-6-20-5-18#20-8-5#15-16-5-14-9-14-7#15-6#20-8-5#5-24-8-9-2-9-20-9-15-14
7-15-15-4#12-21-3-11
 

Sample Output
I WILL STEAL AT LEAST ONE JEWEL
AND LEAVE THE MUSEUM IN T MINUTES
AFTER THE OPENING OF THE EXHIBITION
GOOD LUCK


<font color="red" size='4'>
题意：
就是输入数字#和-，数字1-26分别对应A-Z.
 #对应空格 -没有含义，就是把数字隔开
</font><font color="red" size='4'>
注意这一种输入：
1
<dar>###---##</dar>
</font>


两种方法：
一,常规方法：

```
import java.util.Scanner;

public class Main{
	
	static char[] STR={'a','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			String str=sc.next();
			String s[] = str.split("-");
			for(int i=0;i<s.length;i++){
				
				String strN = "";
				for(int j=0;j<s[i].length();j++){
					if(s[i].charAt(j)!='#'){
						strN+=s[i].charAt(j);
					}else{
						if(!strN.equals(""))
							System.out.print(STR[Integer.parseInt(strN)]);
						System.out.print(" ");
						strN="";
					}
				}
				if(!strN.equals(""))
					System.out.print(STR[Integer.parseInt(strN)]);
			}
			System.out.println();
		}
	}
}

```

二：利用Java中的replaceAll()方法：



```

import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			String str=sc.next();
			str=str.replaceAll("#", " ");
			for(int i=26;i>=1;i--){
				String a=""+(char)('A'+i-1);
				String b=""+i;
				str=str.replaceAll(b, a);
			}
			str=str.replaceAll("-", "");
			System.out.println(str);
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
