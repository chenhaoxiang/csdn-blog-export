---
layout: post
title: "HDOJ HDU 1113 Word Amalgamation(字典顺序~Map)"
date: 2016-05-27 03:12:14 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- String
tags: [对象,游戏,java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
In millions of newspapers across the United States there is a word game called Jumble. The object of this game is to solve a riddle, but in order to find the letters that appear in 
---


Problem Description 
In millions of newspapers across the United States there is a word game called Jumble. The object of this game is to solve a riddle, but in order to find the letters that appear in
<!-- more -->
----------

Problem Description
In millions of newspapers across the United States there is a word game called Jumble. The object of this game is to solve a riddle, but in order to find the letters that appear in the answer it is necessary to unscramble four words. Your task is to write a program that can unscramble words. 

 

Input
The input contains four parts: 

1. a dictionary, which consists of at least one and at most 100 words, one per line; 
2. a line containing XXXXXX, which signals the end of the dictionary; 
3. one or more scrambled `words' that you must unscramble, each on a line by itself; and 
4. another line containing XXXXXX, which signals the end of the file.

All words, including both dictionary words and scrambled words, consist only of lowercase English letters and will be at least one and at most six characters long. (Note that the sentinel XXXXXX contains uppercase X's.) The dictionary is not necessarily in sorted order, but each word in the dictionary is unique. 

 

Output
For each scrambled word in the input, output an alphabetical list of all dictionary words that can be formed by rearranging the letters in the scrambled word. Each word in this list must appear on a line by itself. If the list is empty (because no dictionary words can be formed), output the line ``NOT A VALID WORD" instead. In either case, output a line containing six asterisks to signal the end of the list.

 

Sample Input
tarp
given
score
refund
only
trap
work
earn
course
pepper
part
XXXXXX
resco
nfudre
aptr
sett
oresuc
XXXXXX
 

Sample Output

```
score
******
refund
******
part
tarp
trap
******
NOT A VALID WORD
******
course
******

```


题意：
输入字典  XXXXXX结束字典的输入  然后输入字符串  如果字符串能够组成字典中的串就输出该串 否则输出NOT A VALID WORD
就是找到字典中与其相同字母构成的字符串。
（找到的字符串如果有很多，要按照字典顺序输出！）


```
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 陈浩翔
 * 2016-5-27
 */
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str="";
			String chStr="";
			Map<String , List<String>> map = new HashMap<String, List<String>>();
			while(true){
				List<String> list = new ArrayList<String>();
				str=sc.next();
				if("XXXXXX".equals(str)){
					break;
				}
				char ch[] = str.toCharArray();
				Arrays.sort(ch);
				chStr=new String(ch);
				
				if(map.get(chStr)==null){
					list.add(str);
					map.put(chStr, list);
				}else{
					list = map.get(chStr);
					list.add(str);
					map.put(chStr, list);
				}
			}
			
			while(true){
				str=sc.next();
				if("XXXXXX".equals(str)){
					break;
				}
				char ch[] = str.toCharArray();
				Arrays.sort(ch);
				chStr=new String(ch);
				List<String> list = map.get(chStr);
				if(list==null){
					System.out.println("NOT A VALID WORD");
				}else{
					String strs[] = new String[list.size()];
					for(int i=0;i<list.size();i++){
						strs[i]=list.get(i);
					}
					Arrays.sort(strs, new Comparator<String>() {
						@Override
						public int compare(String o1, String o2) {
							return o1.compareTo(o2);
						}
					});
					for(int i=0;i<strs.length;i++){
						System.out.println(strs[i]);
					}
				}
				System.out.println("******");
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
