---
layout: post
title: "ZOJ(ZJU) 1002 Fire Net(深搜)"
date: 2016-04-23 05:40:20 +0800
comments: true
categories:❶ ACM,----- ZOJ-ACM,❺ 算法及基础题,----- 递归搜索回溯
tags: []
keyword: 陈浩翔, 谙忆
description: Suppose that we have a square city with straight streets. A map of a city is a square board with n rows and n columns, each representing a street or a piece of wall. A blockhouse is a small castle that 
---


Suppose that we have a square city with straight streets. A map of a city is a square board with n rows and n columns, each representing a street or a piece of wall. A blockhouse is a small castle that
<!-- more -->
----------

Suppose that we have a square city with straight streets. A map of a city is a square board with n rows and n columns, each representing a street or a piece of wall. 

A blockhouse is a small castle that has four openings through which to shoot. The four openings are facing North, East, South, and West, respectively. There will be one machine gun shooting through each opening. 

Here we assume that a bullet is so powerful that it can run across any distance and destroy a blockhouse on its way. On the other hand, a wall is so strongly built that can stop the bullets. 

The goal is to place as many blockhouses in a city as possible so that no two can destroy each other. A configuration of blockhouses is legal provided that no two blockhouses are on the same horizontal row or vertical column in a map unless there is at least one wall separating them. In this problem we will consider small square cities (at most 4x4) that contain walls through which bullets cannot run through. 

The following image shows five pictures of the same board. The first picture is the empty board, the second and third pictures show legal configurations, and the fourth and fifth pictures show illegal configurations. For this board, the maximum number of blockhouses in a legal configuration is 5; the second picture shows one way to do it, but there are several other ways. 
![](http://img.blog.csdn.net/20160423053113535)


Your task is to write a program that, given a description of a map, calculates the maximum number of blockhouses that can be placed in the city in a legal configuration. 

The input file contains one or more map descriptions, followed by a line containing the number 0 that signals the end of the file. Each map description begins with a line containing a positive integer n that is the size of the city; n will be at most 4. The next n lines each describe one row of the map, with a '.' indicating an open space and an uppercase 'X' indicating a wall. There are no spaces in the input file. 

For each test case, output one line containing the maximum number of blockhouses that can be placed in the city in a legal configuration. 

Sample input: 

4
.X..
....
XX..
....
2
XX
.X
3
.X.
X.X
.X.
3
...
.XX
.XX
4
....
....
....
....
0

Sample output: 

5
1
5
2
4


题目大意：
 假设我们有一个正方形的城市，其街道都是直的。在方形的地图上，有n行和n列，每个代表一条街道或一堵墙。每个碉堡有4个射击孔，分别正对东西南北方向。在每个射击孔配置一架高射机枪。
 我们假设，子弹是如此强大，它的射程可以任意远，并能摧毁它射中的碉堡。另外，墙也是很坚固的，可以挡住子弹！
 其目标是，在该城市布置尽可能多的碉堡，而碉堡之间又不好互相摧毁。合理布置碉堡的原则是：没有两个碉堡在一个水平方向或垂直方向，除非它们之间有墙相隔！
 在本题中，假设城市很小，（n最大为4） ，而且子弹不能贯穿墙壁。

输入n，代表n行n列。
n为0是输入结束。
'.'代表空地，'X'代表墙壁。


因为题目规模很小，直接采用深度优先算法就可以解决。

```
import java.util.Scanner;

public class Main{
	
	static int n;
	static int time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			n =sc.nextInt();
			if(n==0){
				return ;
			}
			char[][] map = new char[n][n];
			for(int i=0;i<n;i++){
				String str = sc.next();
				for(int j=0;j<n;j++){
					map[i][j] = str.charAt(j);
					//System.out.print("a"+map[i][j]);
				}
				//System.out.println();
			}
			time=0;
			dp(map,0,0);
			System.out.println(time);
		}
		
	}
	
	/**
	 * 利用深搜的方法，对每个单元格能否放置碉堡进行判断
	 * @param map
	 * @param k
	 * @param count
	 */
	private static void dp(char[][] map, int k, int count) {
		int x,y;
		if(k==n*n){//整个地图判断完毕
			if(count>time){//是否有更大的值
				time=count;
				return ;
			}
		}else{
			//将单元数转换为xy坐标
			x =k/n;
			y =k%n;
			
			//如果本单元格可以放置碉堡
			if(map[x][y]=='.'&&CanPut(map,x,y)){
				map[x][y]='O';//放置下一个碉堡
				//令count加一，并递归到下一个单元格
				dp(map,k+1,count+1);
				//递归完毕，恢复该单元格
				map[x][y]='.';
			}
			//本单元格不能放置碉堡
			dp(map,k+1,count);
		}
	}

	/**
	 * 判断行x和列y处能不能配置碉堡
	 * @param map
	 * @param x
	 * @param y
	 * @return
	 */
	private static boolean CanPut(char[][] map,int x, int y) {
		for(int i=x-1;i>=0;i--){//判断y列上的合法性
			if(map[i][y]=='O') return false;
			if(map[i][y]=='X') break;
		}
		
		for(int i=y-1;i>=0;i--){//判断x行上的合法性
			if(map[x][i]=='O') return false;
			if(map[x][i]=='X') break;
		}
		return true;
	}

}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
