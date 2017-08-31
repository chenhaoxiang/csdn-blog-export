---
layout: post
title: "HDOJ(HDU) 2137 circumgyrate the string(此题用Java-AC不过！坑)"
date: 2016-05-05 12:47:12 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,----- HDOJ-C++
tags: []
keyword: 陈浩翔, 谙忆
description: 此题如果有用JavaACDSee，请评论，谢谢了。Problem Description 
  Give you a string, just circumgyrate. The number N means you just   circumgyrate the string N times, and each time you circumgyrate the string for 45 deg 
---


此题如果有用JavaACDSee，请评论，谢谢了。Problem Description 
  Give you a string, just circumgyrate. The number N means you just   circumgyrate the string N times, and each time you circumgyrate the string for 45 deg
<!-- more -->
----------

**此题如果有用JavaACDSee，请评论，谢谢了。**


Problem Description
  Give you a string, just circumgyrate. The number N means you just   circumgyrate the string N times, and each time you circumgyrate the string for 45 degree anticlockwise.

 

Input
  In each case there is string and a integer N. And the length of the string is always odd, so the center of the string will not be changed, and the string is always horizontal at the beginning. The length of the string will not exceed 80, so we can see the complete result on the screen.

 

Output
  For each case, print the circumgrated string.

 

Sample Input
asdfass 7
 

```
Sample Output
a
 s
  d
   f
    a
     s
      s
```

题目意思很简单：
输入一个字符串和一个整数n，n表示把字符串逆时针旋转n个45°，输出旋转后的图形。

注意，n可以是负数，如果是负数，就是按照顺时针旋转就可以了。


和HDU2135题类似。那个是矩阵旋转，这个是字符串旋转。
两题做法都一样，找出循环节分别输出。
此题的字符串旋转8次，可以回到原来的位置，所以对8取余，对8种情况分别输出就可以了。

此题有一个问题，我不知道其他人遇到没有，这个题目用JavaAC不了。。。
下面给出WA的Java代码，和AC的C语言代码。---大家可以对比一下。
Java这个代码完全没问题的，至少我还没找到错哪了，如果有找到的，求告知，谢谢。


WA的Java代码：

```
package cn.hncu.acm;

import java.util.Scanner;

public class P2137 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.next();
			int n = sc.nextInt();
			n %= 8;
			if (n < 0)
				n += 8;
			int t = str.length();
			if (n == 0)
				System.out.println(str);
			else if (n == 4) {
				for (int i = t - 1; i >= 0; i--)
					System.out.print(str.charAt(i));
				System.out.println();
			} else if (n == 1) {
				for (int i = t - 1; i >= 0; i--) {
					for (int j = i; j > 0; j--)
						System.out.print(" ");
					System.out.println(str.charAt(i));
				}
			} else if (n == 2) {
				for (int i = t - 1; i >= 0; i--) {
					for (int j = 0; j < (t / 2); j++)
						System.out.print(" ");
					System.out.println(str.charAt(i));
				}
			} else if (n == 3) {
				for (int i = t - 1; i >= 0; i--) {
					for (int j = t - 1; j > i; j--)
						System.out.print(" ");
					System.out.println(str.charAt(i));
				}
			} else if (n == 5) {
				for (int i = 0; i < t; i++) {
					for (int j = i + 1; j < t; j++)
						System.out.print(" ");
					System.out.println(str.charAt(i));
				}
			} else if (n == 6) {
				for (int i = 0; i < t; i++) {
					for (int j = 0; j < t / 2; j++)
						System.out.print(" ");
					System.out.println(str.charAt(i));
				}
			} else if (n == 7) {
				for (int i = 0; i < t; i++) {
					for (int j = 0; j < i; j++)
						System.out.print(" ");
					System.out.println(str.charAt(i));
				}
			}
		}
	}
}

```


AC的C语言代码：

```
#include <stdio.h>  
#include <stdlib.h>  
#include <string.h>  
  
char name[100];  
int n;  
  
int main()  
{  
    while( scanf("%s",name) !=EOF ){  
           int t = strlen(name);  
           scanf("%d",&n);  
           n %= 8;  
           if( n < 0 )  
               n += 8;  
           if( n == 0 )  
               printf("%s\n",name);  
           else if( n==4 ){  
                for( int i=t-1 ; i>=0 ; i-- )  
                     printf("%c",name[i]);  
                printf("\n");       
           }  
           else if( n == 1 ){  
                for( int i=t-1; i>=0 ; i-- ){  
                     for( int j=i ; j>0 ; j-- )  
                          printf(" ");  
                     printf("%c\n",name[i]);  
                }  
           }  
           else if( n == 2 ){  
                for( int i=t-1 ; i>=0 ; i-- ){  
                     for( int j=0 ; j<(t/2) ; j++ )  
                          printf(" ");  
                printf("%c\n",name[i]);       
                }  
           }  
           else if( n == 3 ){  
                for( int i=t-1 ; i>=0 ; i-- ){  
                     for( int j=t-1 ; j>i ; j-- )  
                          printf(" ");  
                     printf("%c",name[i]);  
                     printf("\n");  
                }  
           }  
           else if( n == 5 ){  
                for( int i=0 ; i<t ; i++ ){  
                     for( int j=i+1 ; j<t ; j++ )  
                          printf(" ");  
                     printf("%c\n",name[i]);  
                }  
           }  
           else if( n == 6 ){  
                for( int i=0 ; i<t ; i++ ){  
                     for( int j=0 ; j<t/2 ; j++ )  
                          printf(" ");  
                printf("%c\n",name[i]);      
                }   
           }  
           else if( n == 7 ){  
                for( int i=0 ; i<t ; i++ ){  
                     for( int j=0 ; j<i ; j++ )  
                          printf(" ");  
                     printf("%c\n",name[i]);        
                }       
           }  
    }      
    return 0;  
}  
```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
