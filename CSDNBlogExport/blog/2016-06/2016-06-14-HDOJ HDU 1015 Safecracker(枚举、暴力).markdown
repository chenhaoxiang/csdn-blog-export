---
layout: post
title: "HDOJ HDU 1015 Safecracker(枚举、暴力)"
date: 2016-06-14 04:43:57 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 递归搜索回溯
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
=== Op tech briefing, 2002/11/02 06:42 CST ===  
“The item is locked in a Klein safe behind a painting in the second-floor library. Klein safes are extremely rare; most of them, al 
---


Problem Description 
=== Op tech briefing, 2002/11/02 06:42 CST ===  
“The item is locked in a Klein safe behind a painting in the second-floor library. Klein safes are extremely rare; most of them, al
<!-- more -->
----------

Problem Description
=== Op tech briefing, 2002/11/02 06:42 CST === 
"The item is locked in a Klein safe behind a painting in the second-floor library. Klein safes are extremely rare; most of them, along with Klein and his factory, were destroyed in World War II. Fortunately old Brumbaugh from research knew Klein's secrets and wrote them down before he died. A Klein safe has two distinguishing features: a combination lock that uses letters instead of numbers, and an engraved quotation on the door. A Klein quotation always contains between five and twelve distinct uppercase letters, usually at the beginning of sentences, and mentions one or more numbers. Five of the uppercase letters form the combination that opens the safe. By combining the digits from all the numbers in the appropriate way you get a numeric target. (The details of constructing the target number are classified.) To find the combination you must select five letters v, w, x, y, and z that satisfy the following equation, where each letter is replaced by its ordinal position in the alphabet (A=1, B=2, ..., Z=26). The combination is then vwxyz. If there is more than one solution then the combination is the one that is lexicographically greatest, i.e., the one that would appear last in a dictionary." 

v - w^2 + x^3 - y^4 + z^5 = target 

"For example, given target 1 and letter set ABCDEFGHIJKL, one possible solution is FIECB, since 6 - 9^2 + 5^3 - 3^4 + 2^5 = 1. There are actually several solutions in this case, and the combination turns out to be LKEBA. Klein thought it was safe to encode the combination within the engraving, because it could take months of effort to try all the possibilities even if you knew the secret. But of course computers didn't exist then." 

=== Op tech directive, computer division, 2002/11/02 12:30 CST === 

"Develop a program to find Klein combinations in preparation for field deployment. Use standard test methodology as per departmental regulations. Input consists of one or more lines containing a positive integer target less than twelve million, a space, then at least five and at most twelve distinct uppercase letters. The last line will contain a target of zero and the letters END; this signals the end of the input. For each line output the Klein combination, break ties with lexicographic order, or 'no solution' if there is no correct combination. Use the exact format shown below."

 

Sample Input
1 ABCDEFGHIJKL
11700519 ZAYEXIWOVU
3072997 SOUGHT
1234567 THEQUICKFROG
0 END
 

Sample Output
LKEBA
YOXUZ
GHOST
no solution


<font color="red">题意：输入一个数target 和一个字符串 s，在字符串 s 找出一个由5个字符组成的最大字符串使得v - w^2 + x^3 - y^4 + z^5 = target ；
 分析：枚举所有的5个元素组成的集合，依次去判断
 5层循环
</font>

```
import java.util.Arrays;
import java.util.Scanner;

public class Main{
	static char at[]={' ','A','B','C','D','E','F','G','H','I','J'
			,'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//for(int i='A';i<='Z';i++){
			//char c = (char)i;
			//System.out.print("'"+c+"',");
		//}
		while(sc.hasNext()){
			int target = sc.nextInt();
			String str = sc.next();
			if(target==0&&str.equals("END")){
				return;
			}
			char chs[] = str.toCharArray();
			Arrays.sort(chs);
			for(int i=0,j=chs.length-1;i<chs.length/2;i++,j--){
				char c=chs[i];
				chs[i]=chs[j];
				chs[j]=c;
			}
			boolean haveAnswer = false;
			
			con: for(int a=0;a<chs.length;a++){
				
				for(int b=0;b<chs.length;b++){
					if(a==b){
						continue;
					}
					for(int c=0;c<chs.length;c++){
						if(a==c||b==c){
							continue;
						}
						for(int d=0;d<chs.length;d++){
							if(d==a||d==b||d==c){
								continue;
							}
							for(int e=0;e<chs.length;e++){
								if(e==a||e==b||e==c||e==d){
									continue;
								}
								int ap[] = new int[5];
								for(int j=0;j<ap.length;j++){
									for(int i=1;i<at.length;i++){
										if(j==0){
											if(chs[a]==at[i]){
												ap[0]=i;
												break;
											}
										}else
										if(j==1){
											if(chs[b]==at[i]){
												ap[1]=i;
												break;
											}
										}else
										if(j==2){
											if(chs[c]==at[i]){
												ap[2]=i;
												break;
											}
										}else
										if(j==3){
											if(chs[d]==at[i]){
												ap[3]=i;
												break;
											}
										}else
										if(j==4){
											if(chs[e]==at[i]){
												ap[4]=i;
												break;
											}
										}
									}
								}
								
								int sum=0;
								for(int i=0;i<ap.length;i++){
									if(i%2==0){
										sum+=Math.pow(ap[i], i+1);
									}else{
										sum-=Math.pow(ap[i], i+1);
									}
								}
								if(sum==target){
									String s="";
									s+=chs[a];
									s+=chs[b];
									s+=chs[c];
									s+=chs[d];
									s+=chs[e];
									System.out.println(s);
									haveAnswer=true;
									break con;
								}
							}
						}
					}
				}
			}
			if(!haveAnswer){
				System.out.println("no solution");
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
