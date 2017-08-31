---
layout: post
title: "HDOJ(HDU) 2060 Snooker(英语很重要。。。)"
date: 2016-04-22 11:38:15 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
background: 
Philip likes to play the QQ game of Snooker when he wants a relax, though he was just a little vegetable-bird. Maybe you hadn’t played that game yet, no matter, I’ll i 
---


Problem Description 
background: 
Philip likes to play the QQ game of Snooker when he wants a relax, though he was just a little vegetable-bird. Maybe you hadn’t played that game yet, no matter, I’ll i
<!-- more -->
----------

Problem Description
background:
Philip likes to play the QQ game of Snooker when he wants a relax, though he was just a little vegetable-bird. Maybe you hadn't played that game yet, no matter, I'll introduce the rule for you first.
There are 21 object balls on board, including 15 red balls and 6 color balls: yellow, green, brown, blue, pink, black.
The player should use a white main ball to make the object balls roll into the hole, the sum of the ball's fixed value he made in the hole is the player's score. The player should firstly made a red ball into the hole, after that he gains red-ball's value(1 points), then he gets the chance to make a color ball, then alternately. The color ball should be took out until all the red-ball are in the hole. In other word, if there are only color balls left on board, the player should hit the object balls in this order: yellow(2 point), green(3 point), brown(4 point), blue(5 point), pink(6 point), black(7 point), after the ball being hit into the hole, they are not get out of the hole, after no ball left on board, the game ends, the player who has
the higher score wins the game. PS: red object balls never get out of the hole.
I just illustrate the rules that maybe used, if you want to contact more details, visit http://sports.tom.com/snooker/ after
the contest.

for example, if there are 12 red balls on board(if there are still red ball left on board, it can be sure that all the color
balls must be on board either). So suppose Philp can continuesly hit the ball into the hole, he can get the maximun score is
12 * 1 (12 red-ball in one shoot) + 7 * 12(after hit a red ball, a black ball which was the most valuable ball should be the target) + 2 + 3 + 4 + 5 + 6 + 7(when no red ball left, make all the color ball in hole).
Now, your task is to judge whether Philip should make the decision to give up when telling you the condition on board(How many object balls still left not in the hole and the other player's score). If Philp still gets the chance to win, just print "Yes", otherwise print "No". (PS: if the max score he could get on board add his current score is equal to the opponent's current score, still output "Yes")

 

Input
The first line contains a numble N indicating the total conditions. Then followed by N lines, each line is made of three integers:
Ball_Left P_Score O_Score represeting the ball number left on board, Philp's current score, and the opponent's current score.
All the input value are in 32 bit integer value range.
 

Output
You should caculate the max score left Philp can gain, and judge whether he has the possiblity to win.
 

Sample Input
2
12 1 1
1 30 39
 

Sample Output
Yes
No


题目意思我开始没看懂，参考了其他大牛的题意分析。

题意：

桌上有n个球，一人得分为a，另一人为b，问如果第一个人将n个球都打进洞后，得分能否超过（或等于）第二个人。
总共有15个红球，和6个有颜色的球，每个红球的得分为1 ，6
个有颜色的球分别为2 ， 3， 4 ，5， 6， 7 ；

分析：

1。如果n>6 , 
那么桌上有6个彩球和n-6个红球，但是由于有色球全部打进洞后，每个球需要额外增加黑球（最高得分）的得分；所以打进n个球的得分为：
（n-6）*1+（n-6）*7+2+3+4+5+6+7

2.当 m <= 6 时， 
应该由价值最高的黑球（ 7 分） 向前依
次增加求和，又因为有色球满足等差数列 ，由前6项减去前 6 - m项和，所以
求得为（ 7 - m  + 1 + 7  ) * m / 2 ( 这里直接通过得分来计算的）。因
此，第二种情况的得分为（ 15 - m ) *m/ 2 ;


```
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		int[] db = {0,7,13,18,22,25,27};
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n =sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if(n<=6){
				if(b+db[n]>=c){
					System.out.println("Yes");
				}else{
					System.out.println("No");
				}
			}else{
				if(b+(1*(n-6)+7*(n-6)+db[6])>=c){
					System.out.println("Yes");
				}else{
					System.out.println("No");
				}
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
