---
layout: post
title: "HDOJ(HDU) 2103 Family planning(需要注意范围)"
date: 2016-04-30 04:10:58 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
As far as we known,there are so many people in this world,expecially in china.But many people like LJ always insist on that more people more power.And he often says he will burn as 
---


Problem Description 
As far as we known,there are so many people in this world,expecially in china.But many people like LJ always insist on that more people more power.And he often says he will burn as
<!-- more -->
----------

Problem Description
As far as we known,there are so many people in this world,expecially in china.But many people like LJ always insist on that more people more power.And he often says he will burn as much babies as he could.Unfortunatly,the president XiaoHu already found LJ's extreme mind,so he have to publish a policy to control the population from keep on growing.According the fact that there are much more men than women,and some parents are rich and well educated,so the president XiaoHu made a family planning policy:
According to every parents conditions to establish a number M which means that parents can born M children at most.But once borned a boy them can't born other babies any more.If anyone break the policy will punished for 10000RMB for the first time ,and twice for the next time.For example,if LJ only allowed to born 3 babies at most,but his first baby is a boy ,but he keep on borning another 3 babies, so he will be punished for 70000RMB(10000+20000+40000) totaly. 
 

Input
The first line of the input contains an integer T(1 <= T <= 100) which means the number of test cases.In every case first input two integers M(0<=M<=30) and N(0<=N<=30),N represent the number of babies a couple borned,then in the follow line are N binary numbers,0 represent girl,and 1 represent boy.
 

Output
Foreach test case you should output the total money a couple have to pay for their babies. 
 

Sample Input
2
2 5
0 0 1 1 1

2 2
0 0
 

Sample Output
70000 RMB
0 RMB

题目大意：国家要实行计划生育，但是为了照顾到某些家庭希望能生个男孩的愿望，所以总统颁布了一条生育法令。给每个家庭一个生育孩子的限额M，就是表示一个家庭最多能生几个孩子，但是如果一旦生了男孩的话，就不能再生了，即使你还没有达到生育的限额。对于违规的家庭，第一次罚10000，第二次就罚20000，第三次就罚40000，以此类推，就是一个等比数列了，之后罚款都是之前的2倍。现在题目给你限额M和每个家庭实际生了几个孩子N，问你这个家庭一共要罚多少钱。

这个题目坑的地方就是数据的范围。。。。
注意要用long型的，也可以缩小10000倍，最后输出的时候加上“0000”四个0一起输出就可以了。

分成2部分处理，一种情况是m小于等于n的，
这种情况下只要判断生出男孩后，无论男女都要罚款。
另外一种就是m大于n的。
在第一种情况内，还有如果大于n个了，只要大于的都要罚款！！！


```
import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n  =sc.nextInt();
			int m  = sc.nextInt();
			int child[] = new int[m];
			for(int i=0;i<m;i++){
				child[i] = sc.nextInt();
			}
			long fine = 0;
			long excess = 1;
			//第一种情况,生下的孩子数量比规定最多的数量要少或者一样
			//则只有在生出男孩之后才能罚款；
			if(m<=n){
				boolean isGirl = true;
				for(int i=0;i<m;i++){
					if(child[i]==1&&isGirl){
						isGirl=false;
						continue;
					}
					if(!isGirl){
						fine+=excess;
						excess*=2;
					}
				}
			}else{
				boolean isGirl = true;
				for(int i=0;i<n;i++){
					if(child[i]==1&&isGirl){
						isGirl=false;
						continue;
					}
					if(!isGirl){
						fine+=excess;
						excess*=2;
						//System.out.println("!!!fine="+fine+",,"+"excess="+excess);
					}
				}
				for(int j=n;j<m;j++){
					fine+=excess;
					excess*=2;
					//System.out.println("fine="+fine+",,"+"excess="+excess);
				}
			}
			
			if(excess==1){
				System.out.println("0 RMB");
			}else{
				System.out.println(fine+"0000 RMB");
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
