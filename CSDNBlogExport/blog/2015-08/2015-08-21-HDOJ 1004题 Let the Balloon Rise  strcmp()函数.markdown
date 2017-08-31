---
layout: post
title: "HDOJ 1004题 Let the Balloon Rise  strcmp()函数"
date: 2015-08-21 02:38:46 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❸ C/C++语言基础,----- C/C++函数应用
tags: [c语言,HDOJ]
keyword: 陈浩翔, 谙忆
description: Problem Description
Contest time again! How excited it is to see balloons floating around. But to tell you a secret, the judges' favorite time is guessing the most popular problem. When the contest i 
---


Problem Description
Contest time again! How excited it is to see balloons floating around. But to tell you a secret, the judges' favorite time is guessing the most popular problem. When the contest i
<!-- more -->
----------


<div class="panel_title" align="left">Problem Description</div>
<div class="panel_content">Contest time again! How excited it is to see balloons floating around. But to tell you a secret, the judges' favorite time is guessing the most popular problem. When the contest is over, they will count the balloons of each color
 and find the result.<br>
<br>
This year, they decide to leave this lovely job to you. <br>
</div>
<div class="panel_bottom"></div>
<br>
<div class="panel_title" align="left">Input</div>
<div class="panel_content">Input contains multiple test cases. Each test case starts with a number N (0 &lt; N &lt;= 1000) -- the total number of balloons distributed. The next N lines contain one color each. The color of a balloon is a string of up to 15 lower-case
 letters.<br>
<br>
A test case with N = 0 terminates the input and this test case is not to be processed.<br>
</div>
<div class="panel_bottom"></div>
<br>
<div class="panel_title" align="left">Output</div>
<div class="panel_content">For each case, print the color of balloon for the most popular problem on a single line. It is guaranteed that there is a unique solution for each test case.<br>
</div>
<div class="panel_bottom"></div>
<br>
<div class="panel_title" align="left">Sample Input</div>
<div class="panel_content">
<pre><div style="font-family:Courier New,Courier,monospace">5
green
red
blue
red
red
3
pink
orange
pink
0</div></pre>
</div>
<div class="panel_bottom"></div>
<div class="panel_title" align="left">Sample Output</div>
<div class="panel_content">
<pre><div style="font-family:Courier New,Courier,monospace">red
pink</div></pre>
</div>
<div class="panel_bottom"></div>
<div class="panel_title" align="left">代码：</div>
<div class="panel_title" align="left"><pre name="code" class="cpp">#include &lt;iostream&gt;
#include&lt;stdio.h&gt;
#include&lt;stdlib.h&gt;
#include&lt;string.h&gt;
using namespace std;

int main()
{
    int n,i,j,s=1,b[1010],f[1010];
    char a[1010][20];
    while(~scanf(&quot;%d&quot;,&amp;n)&amp;&amp;n)
    {
        memset(b,0,sizeof(b));
        for(i=0; i&lt;n; i++)
        {
            scanf(&quot;%s&quot;,a[i]);
        }
        for(i=0; i&lt;n; i++)
        {
            f[i]=1;
            for(j=i+1; j&lt;n; j++)
            {
                if(b[j]==0)
                {

                    if(strcmp(a[i],a[j])==0)//这里我不知道为什么用a[i]==a[j]就不可以，求大神评论解释一下，谢谢了
                    {
                        b[j]=1;
                        f[i]=f[i]+1;
                    }
                }
            }
        }
        int s=0;
        for(i=0; i&lt;n; i++)
        {
            if(f[s]&lt;=f[i])
            {
                s=i;
            }
        }
        printf(&quot;%s\n&quot;,a[s]);
    }
    return 0;
}
</pre><br>
<br>
</div>
<div class="panel_content">
<pre><div style="font-family:Courier New,Courier,monospace"></div></pre>
</div>


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
