---
layout: post
title: "HDOJ(HDU)  4847 Wow! Such Doge!(doge字符统计)"
date: 2016-05-09 02:09:02 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem DescriptionChen, Adrian (November 7, 2013). “Doge Is An Ac- tually Good Internet Meme. Wow.”. Gawker. Retrieved November 22, 2013.Doge is an Internet meme that became popular in 2013. The meme 
---


Problem DescriptionChen, Adrian (November 7, 2013). “Doge Is An Ac- tually Good Internet Meme. Wow.”. Gawker. Retrieved November 22, 2013.Doge is an Internet meme that became popular in 2013. The meme
<!-- more -->
----------

Problem Description

![](http://img.blog.csdn.net/20160509140747798)

Chen, Adrian (November 7, 2013). “Doge Is An Ac- tually Good Internet Meme. Wow.”. Gawker. Retrieved November 22, 2013.

Doge is an Internet meme that became popular in 2013. The meme typically con- sists of a picture of a Shiba Inu dog ac- companied by multicolored text in Comic Sans MS font in the foreground. The text, representing a kind of internal monologue, is deliberately written in broken English, and usually contains the word “wow” and the phrases “such x”, “much x”, “many x”, “very x” and “so x”.
Kabosu, the Shiba Inu featured in the original meme, was first pictured in a 2010 blog post by Atsuko Sato, a Japanese kindergarten teacher. Afterwards, varia- tions of the pictures using overlaid Comic Sans text were posted from a Tumblr blog, Shiba Confessions. However, the use of the intentionally misspelled “doge” dates back to June 2005, when it was mentioned in an episode of Homestar Runners puppet series.
In August 2013, images of the meme were spammed on Reddit’s r/MURICA subreddit by 4chan’s random imageboard, /b/. A search of the term doge on Google Trends shows an explosion of popularity occurring in October 2013, and more so in the following month. By November 2013, the meme had become widespread on the Internet. Google later created a Doge Easter egg: when doge meme was entered into the YouTube search bar, all of the site’s text would be displayed in colorful Comic Sans, similar to the kind used by the meme.
The meme was ranked #12 on MTV’s list of “50 Things Pop Culture Had Us Giving Thanks For” in 2013. Io9 compared the internal dialog of the Shiba Inu dogs to lolcat-speak. The image most commonly associated with the meme is of a female Shiba Inu named Kabosu, taken from a Japanese blog documenting the dog’s daily activities. The spelling of doge has several variants, leading to debate on its actual pronunciation. On December 13, Doge was named the “top meme” of 2013 by Know Your Meme.
In December 2013, the Dogecoin was introduced as a new cryptocurrency, making it the first cryptocurrency to be based on an Internet meme; the viral phenomenon, along with usage of the Comic Sans MS typeface, gave it “the Internet density of a large star” according to Medium writer Quinn Norton.
In late December 2013, members of the U.S. Congress produced material in the meme’s style. Huffington Post commented that Doge was “killed” because of the Congress members’ usage of the meme.
By early 2014, Doge’s popularity was sustained by internet communities on social media, accompanied by the rapid growth and acceptance of Dogecoin. In April 2014, Doge experienced a second major media resurgence due to revelations of the Dogecoin community’s intent to sponsor Josh Wise in NASCAR and place a picture of the Shiba Inu on his vehicle.

—— Doge (meme). (2014, May 18).
In Wikipedia, The Free Encyclopedia. Retrieved 02:00, May 22, 2014, from
http://en.wikipedia.org/w/index.php?title=Doge_(meme)&oldid=609040691

Now, Doge wants to know how many words “doge” are there in a given article. Would you like to help Doge solve this problem?
 

Input
An article that Doge wants to know.
The size of the article does not exceed 64KB. The article contains only ASCII characters.
 

Output
Please output the number of word “doge” (case-insensitive). Refer to the samples for more details.
 

Sample Input
adoge
cutedo 
yourge 
blownDoge
lovelyDooge
Wow!	Such Dooooooooooooooge!!!
D0ge
dOge DOGE 
dogedoge
 

Sample Output
6


题目的输出没有结束标志，就是让你在文件结束输出doge这个单词出现的次数，不区分大小写！


```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sum=0;
		while(sc.hasNext()){
			String str =sc.next();
			for(int i=0;i<str.length()-3;i++){
				if(str.charAt(i)=='d'||str.charAt(i)=='D'){
					if(str.charAt(i+1)=='o'||str.charAt(i+1)=='O'){
						if(str.charAt(i+2)=='g'||str.charAt(i+2)=='G'){
							if(str.charAt(i+3)=='e'||str.charAt(i+3)=='E'){
								sum++;
								i=i+3;
							}
						}
					}
				}
			}
		}
		System.out.println(sum);
		
	}

}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
