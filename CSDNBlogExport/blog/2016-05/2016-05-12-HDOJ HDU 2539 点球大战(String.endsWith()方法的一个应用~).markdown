---
layout: post
title: "HDOJ HDU 2539 点球大战(String.endsWith()方法的一个应用~)"
date: 2016-05-12 06:30:30 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- String
tags: [应用,ACM,JAVA]
keyword: 陈浩翔, 谙忆
description: Problem Description 
在足球比赛中，有不少赛事，例如世界杯淘汰赛和欧洲冠军联赛淘汰赛中，当比赛双方经过正规比赛和加时赛之后仍然不分胜负时，需要进行点球大战来决定谁能够获得最终的胜利。点球大战的规则非常简单，两方轮流派出球员罚点球，每方各罚5个。当5轮点球结束以后如果仍然不分胜负，则进入一轮定胜负的阶段。两方各派一名球员罚点球，直到有一方罚进而另一方没有进为止。 
在北美职业冰球联 
---


Problem Description 
在足球比赛中，有不少赛事，例如世界杯淘汰赛和欧洲冠军联赛淘汰赛中，当比赛双方经过正规比赛和加时赛之后仍然不分胜负时，需要进行点球大战来决定谁能够获得最终的胜利。点球大战的规则非常简单，两方轮流派出球员罚点球，每方各罚5个。当5轮点球结束以后如果仍然不分胜负，则进入一轮定胜负的阶段。两方各派一名球员罚点球，直到有一方罚进而另一方没有进为止。 
在北美职业冰球联
<!-- more -->
----------

Problem Description
在足球比赛中，有不少赛事，例如世界杯淘汰赛和欧洲冠军联赛淘汰赛中，当比赛双方经过正规比赛和加时赛之后仍然不分胜负时，需要进行点球大战来决定谁能够获得最终的胜利。点球大战的规则非常简单，两方轮流派出球员罚点球，每方各罚5个。当5轮点球结束以后如果仍然不分胜负，则进入一轮定胜负的阶段。两方各派一名球员罚点球，直到有一方罚进而另一方没有进为止。
在北美职业冰球联赛中，也有点球大战。与足球的规则不同的是，它只先罚3轮点球，随后就进入一轮定胜负的阶段，而其他的规则完全一样。
在本题中，输入将给出每次点球是否罚进，而你的任务则是输出一个“比分板”。

![](http://img.blog.csdn.net/20160512182823730)


 

Input
输入包含多组数据。每组数据的第一行包含一个整数N(1<=N<=18)，表示双方总共罚了多少个点球，N=0表示输入结束。随后有N行，每行是一个如下形式的字符串：
XXXX good：表示这个点球罚进
或者XXXX no good：表示这个点球没有罚进
其中XXXX表示球员名字（全部由字母和空格组成，保证不会出现歧义）
每一行保证不超过100个字符。
XXXX和good以及XXXX和no、no和good之间保证有且只有1个空格。
good、no good都是小写。本题是大小写相关的。
数据不保证点球大战一定结束，也不保证在结束以后立即结束这组数据（即：不用判断点球大战是否结束，只用把罚进的点球往比分上加即可）。

 

Output
对每组数据，输出一个比分板。一个点球如果罚进，则在对应的地方标上’O’，如果没有进则标上’X’。先罚球的队伍的信息在上面，后罚的在下面。最右边标上两队的比分。具体格式参考样例输出。注意如果一轮点球只罚了一个，则后面那个点球对应的地方写上’-’。
 

Sample Input
6
Riise good
Ballack good
Gerrard no good
Lampard no good
Fernando Torres good
Malouda good
9
Christiano Ronaldo no good
Messi no good
Giggs good
Abidal no good
Carrick good
Ronaldinho good
Rooney good
Henry no good
Tevez good
0
 

Sample Output
1 2 3 Score
O X O 2
O X O 2
1 2 3 4 5 Score
X O O O O 4
X X O X - 1

提示：
空格数要和样例输出一样，否则很可能会被判为“格式错误”(Presentation Error)。



此题注意：名字中也有可能有一个no哦。
所以判断的时候，需要判断最后是不是“ no good”结尾的！no前面有一个空格！
Java很强大~直接用endsWith(" no good");判断就可以了！


```
import java.util.Scanner;

/**
 * @author 陈浩翔
 *
 * @version 1.0  2016-5-11
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n =sc.nextInt();
			sc.nextLine();
			if(n==0){
				return ;
			}
			String str=null;
			char a[] = new char[(n+1)/2];
			char b[] = new char[(n+1)/2];
			int ap=0;
			int bp=0;
			int aNum=0;
			int bNum=0;
			for(int i=0;i<n;i++){
				str = sc.nextLine();
				boolean isNo = false;
				if(str.endsWith(" no good")){
					isNo=true;
				}
				
				if(isNo){
					if(i%2==0){
						a[ap++]='X';
					}else{
						b[bp++]='X';
					}
				}else{
					if(i%2==0){
						a[ap++]='O';
						aNum++;
					}else{
						b[bp++]='O';
						bNum++;
					}
				}
			}
			
			for(int i=1;i<=(n+1)/2;i++){
				System.out.print(i+" ");
			}
			System.out.println("Score");
			
			if(n%2!=0){
				b[(n+1)/2-1]='-';
			}
			for(int i=0;i<(n+1)/2;i++){
				System.out.print(a[i]+" ");
			}
			System.out.println(aNum);
			for(int i=0;i<(n+1)/2;i++){
				System.out.print(b[i]+" ");
			}
			System.out.println(bNum);
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
