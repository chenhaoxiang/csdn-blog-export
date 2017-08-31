---
layout: post
title: "HDOJ 1048 The Hardest Problem Ever(加密解密类)"
date: 2016-03-28 04:43:19 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题,----- 加密解密
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Julius Caesar lived in a time of danger and intrigue. The hardest situation Caesar ever faced was keeping himself alive. In order for him to survive, he decided to create one of th 
---


Problem Description 
Julius Caesar lived in a time of danger and intrigue. The hardest situation Caesar ever faced was keeping himself alive. In order for him to survive, he decided to create one of th
<!-- more -->
----------

Problem Description
Julius Caesar lived in a time of danger and intrigue. The hardest situation Caesar ever faced was keeping himself alive. In order for him to survive, he decided to create one of the first ciphers. This cipher was so incredibly sound, that no one could figure it out without knowing how it worked. 
You are a sub captain of Caesar's army. It is your job to decipher the messages sent by Caesar and provide to your general. The code is simple. For each letter in a plaintext message, you shift it five places to the right to create the secure message (i.e., if the letter is 'A', the cipher text would be 'F'). Since you are creating plain text out of Caesar's messages, you will do the opposite: 

Cipher text
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

Plain text
V W X Y Z A B C D E F G H I J K L M N O P Q R S T U 

Only letters are shifted in this cipher. Any non-alphabetical character should remain the same, and all alphabetical characters will be upper case.

 

Input
Input to this problem will consist of a (non-empty) series of up to 100 data sets. Each data set will be formatted according to the following description, and there will be no blank lines separating data sets. All characters will be uppercase. 

A single data set has 3 components: 

Start line - A single line, "START" 

Cipher message - A single line containing from one to two hundred characters, inclusive, comprising a single message from Caesar 

End line - A single line, "END" 

Following the final data set will be a single line, "ENDOFINPUT".

 

Output
For each data set, there will be exactly one line of output. This is the original message by Caesar.

 

Sample Input
START
NS BFW, JAJSYX TK NRUTWYFSHJ FWJ YMJ WJXZQY TK YWNANFQ HFZXJX
END
START
N BTZQI WFYMJW GJ KNWXY NS F QNYYQJ NGJWNFS ANQQFLJ YMFS XJHTSI NS WTRJ
END
START
IFSLJW PSTBX KZQQ BJQQ YMFY HFJXFW NX RTWJ IFSLJWTZX YMFS MJ
END
ENDOFINPUT
 

Sample Output
IN WAR, EVENTS OF IMPORTANCE ARE THE RESULT OF TRIVIAL CAUSES
I WOULD RATHER BE FIRST IN A LITTLE IBERIAN VILLAGE THAN SECOND IN ROME
DANGER KNOWS FULL WELL THAT CAESAR IS MORE DANGEROUS THAN HE

就是一个加密解密的过程；

```
import java.util.Scanner;

public class Main{
	static char[] ctext =new char[26];
	static char[] ptext =new char[26];
	public static void main(String[] args) {
		ctet();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			if(str.equals("ENDOFINPUT")){
				break;
			}
			//System.out.println("str="+str);
				String strs = sc.nextLine();
			//	System.out.println("strs="+strs);
				for(int i=0;i<strs.length();i++){
					if(strs.charAt(i)>='A'&&strs.charAt(i)<='Z'){
						for(int j=0;j<ctext.length;j++){
							if(strs.charAt(i)==ctext[j]){
								System.out.print(ptext[j]);
								break;
							}
						}
						
					}else{
						System.out.print(strs.charAt(i));
					}
					
				}
				System.out.println();
//				String a = sc.nextLine();
//				System.out.println("a = "+a);
			String s = sc.nextLine();
			//System.out.println("s = "+s);
			
			
		}
		
	}
	private static void ctet() {
		int k=0;
		for(int i='A';i<='Z';i++){
			ctext[k++]=(char)i;
		}
		String str = "V W X Y Z A B C D E F G H I J K L M N O P Q R S T U";
		String strs[] = str.split(" +");
		k=0;
		for(int i='A';i<='Z';i++){
			ptext[k] =strs[k].charAt(0);
			k++;
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
