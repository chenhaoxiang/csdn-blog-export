---
layout: post
title: "HDOJ 1013题Digital Roots  大数，9余数定理"
date: 2015-08-21 05:00:24 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❺ 算法及基础题,----- 大数问题
tags: [c语言,HDOJ,大数]
keyword: 陈浩翔, 谙忆
description: Problem Description
The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resultin 
---


Problem Description
The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resultin
<!-- more -->
----------


<div class="panel_title" align="left">Problem Description</div>
<div class="panel_content">The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resulting value contains two or more digits, those digits are
 summed and the process is repeated. This is continued as long as necessary to obtain a single digit.<br>
<br>
For example, consider the positive integer 24. Adding the 2 and the 4 yields a value of 6. Since 6 is a single digit, 6 is the digital root of 24. Now consider the positive integer 39. Adding the 3 and the 9 yields 12. Since 12 is not a single digit, the process
 must be repeated. Adding the 1 and the 2 yeilds 3, a single digit and also the digital root of 39.<br>
</div>
<div class="panel_bottom"></div>
<br>
<div class="panel_title" align="left">Input</div>
<div class="panel_content">The input file will contain a list of positive integers, one per line. The end of the input will be indicated by an integer value of zero.<br>
</div>
<div class="panel_bottom"></div>
<br>
<div class="panel_title" align="left">Output</div>
<div class="panel_content">For each integer in the input, output its digital root on a separate line of the output.<br>
</div>
<div class="panel_bottom"></div>
<br>
<div class="panel_title" align="left">Sample Input</div>
<div class="panel_content">
<pre><div style="font-family:Courier New,Courier,monospace">24
39
0</div></pre>
</div>
<div class="panel_bottom"></div>
<p></p>
<div class="panel_title" align="left">Sample Output</div>
<div class="panel_content">
<pre><div style="font-family:'Courier New',Courier,monospace">6
3</div></pre>
</div>
<p></p>
<p><br>
</p>
<div style="color:rgb(50,62,50); font-size:14px; line-height:21px; background-color:rgb(156,174,193); font-family:'Courier new',Courier,monospace">
<strong></strong></div>
<p></p>
<div style="color:rgb(50,62,50); font-size:14px; line-height:21px; background-color:rgb(156,174,193); font-family:'Courier new',Courier,monospace">
一个数对九取余，得到的数称之为九余数；</div>
<div style="color:rgb(50,62,50); font-size:14px; line-height:21px; background-color:rgb(156,174,193); font-family:'Courier new',Courier,monospace">
一个数的九余数等于它的各个数位上的数之和的九余数！</div>
<br>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px">
题目大意：</p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px">
</p>
<div>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px">
&nbsp;给定一个正整数，根据一定的规则求出该数的<span style="font-family:'Times New Roman'">“</span><span style="font-family:宋体">数根</span><span style="font-family:'Times New Roman'">”</span><span style="font-family:宋体">，其规则如下：</span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;例如给定&nbsp;数字&nbsp;<span style="font-family:'Times New Roman'">24</span><span style="font-family:宋体">，将</span><span style="font-family:'Times New Roman'">24</span><span style="font-family:宋体">的各个位上的数字</span><span style="font-family:'Times New Roman'">“</span><span style="font-family:宋体">分离</span><span style="font-family:'Times New Roman'">”</span><span style="font-family:宋体">，分别得到数字&nbsp;</span><span style="font-family:'Times New Roman'">2&nbsp;</span><span style="font-family:宋体">和&nbsp;</span><span style="font-family:'Times New Roman'">4</span><span style="font-family:宋体">，而</span><span style="font-family:'Times New Roman'">2&#43;4=6</span><span style="font-family:宋体">；</span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;因为&nbsp;<span style="font-family:'Times New Roman'">6&nbsp;&lt;&nbsp;10</span><span style="font-family:宋体">，所以就认为</span><span style="font-family:'Times New Roman'">6</span><span style="font-family:宋体">是数字</span><span style="font-family:'Times New Roman'">24</span><span style="font-family:宋体">的</span><span style="font-family:'Times New Roman'">“</span><span style="font-family:宋体">数根</span><span style="font-family:'Times New Roman'">”</span><span style="font-family:宋体">；</span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;而对于数字&nbsp;<span style="font-family:'Times New Roman'">39&nbsp;</span><span style="font-family:宋体">，</span>&nbsp;将<span style="font-family:'Times New Roman'">39</span><span style="font-family:宋体">的各个位上的数字</span><span style="font-family:'Times New Roman'">“</span><span style="font-family:宋体">分离</span><span style="font-family:'Times New Roman'">”</span><span style="font-family:宋体">，分别得到数字&nbsp;</span><span style="font-family:'Times New Roman'">3&nbsp;</span><span style="font-family:宋体">和&nbsp;</span><span style="font-family:'Times New Roman'">9</span><span style="font-family:宋体">，而</span><span style="font-family:'Times New Roman'">3&#43;9=12,</span><span style="font-family:宋体">且</span><span style="font-family:'Times New Roman'">12&gt;10</span><span style="font-family:宋体">；</span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所以依据规则再对&nbsp;<span style="font-family:'Times New Roman'">12&nbsp;</span><span style="font-family:宋体">进行相应的运算，最后得到数字</span><span style="font-family:'Times New Roman'">3</span><span style="font-family:宋体">，而</span><span style="font-family:'Times New Roman'">3&lt;10</span><span style="font-family:宋体">，所以就认为</span><span style="font-family:'Times New Roman'">3</span><span style="font-family:宋体">是数字</span><span style="font-family:'Times New Roman'">39</span><span style="font-family:宋体">的</span><span style="font-family:'Times New Roman'">“</span><span style="font-family:宋体">数根</span><span style="font-family:'Times New Roman'">”</span><span style="font-family:宋体">。</span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通过运算可以发现任何一个数的<span style="font-family:'Times New Roman'">“</span><span style="font-family:宋体">数根</span><span style="font-family:'Times New Roman'">”</span><span style="font-family:宋体">都是一个取&#20540;范围在&nbsp;</span><span style="font-family:'Times New Roman'">1&nbsp;~&nbsp;9</span><span style="font-family:宋体">之间的正整数，</span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;且任何一个正整数都只有唯一的一个<span style="font-family:'Times New Roman'">“</span><span style="font-family:宋体">数根</span><span style="font-family:'Times New Roman'">”</span><span style="font-family:宋体">与其相对应。</span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题目要求数字&nbsp;<span style="font-family:'Times New Roman'">n^n&nbsp;</span><span style="font-family:宋体">的</span><span style="font-family:'Times New Roman'">“</span><span style="font-family:宋体">数根</span><span style="font-family:'Times New Roman'">”</span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px">
<span style="font-family:'Times New Roman'">解题思路：</span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px">
<span style="font-family:'Times New Roman'"><strong>九余数定理</strong></span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px">
<span style="font-family:'Times New Roman'"><strong>一个数对九取余后的结果称为九余数。</strong></span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px">
<span style="font-family:'Times New Roman'"><strong>一个数的各位数字之和想加后得到的&lt;10的数字称为这个数的九余数（如果相加结果大于9，则继续各位相加）</strong></span></p>
</div>
<div>代码如下：</div>
<div class="panel_title" align="left"><pre name="code" class="cpp">#include &lt;stdio.h&gt;
#include &lt;stdlib.h&gt;
#include&lt;string.h&gt;
int main()
{
    char a[1010];
    int i,j,s,l;
    while(~scanf(&quot;%s&quot;,&amp;a)&amp;&amp;a[0]!=&#39;0&#39;)
    {
        l=strlen(a);
        s=0;
        for(i=0;i&lt;l;i++)
        {
            s=s+a[i]-&#39;0&#39;;
        }
        s=s%9;
        if(s==0)
            s=9;
        printf(&quot;%d\n&quot;,s);
    }
    return 0;
}
</pre><br>
<br>
</div>
<div style="top:0px">
<div style="color:rgb(50,62,50); font-size:14px; line-height:21px; background-color:rgb(156,174,193); font-family:'Courier new',Courier,monospace">
一个数对九取余，得到的数称之为九余数；</div>
<div style="color:rgb(50,62,50); font-size:14px; line-height:21px; background-color:rgb(156,174,193); font-family:'Courier new',Courier,monospace">
一个数的九余数等于它的各个数位上的数之和的九余数！</div>
</div>


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
