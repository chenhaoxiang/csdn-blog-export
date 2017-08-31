---
layout: post
title: "【系统】[CentOS]装完CentOS7重启提示Initial setup of CentOS Linux 7 (core)"
date: 2016-09-13 06:50:59 +0800
comments: true
categories:❻ 其他,----- Linux/Unix
tags: [centos,linux]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


在用U盘装完CentOS后，重新开机启动后显示： 
Initial setup of CentOS Linux 7 (core)  
1) [x] Creat user 2) [!] License information 
(no user will be created) ( 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


在用U盘装完CentOS后，重新开机启动后显示： 
Initial setup of CentOS Linux 7 (core)  
1) [x] Creat user 2) [!] License information 
(no user will be created) (
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


在用U盘装完CentOS后，重新开机启动后显示：
Initial setup of CentOS Linux 7 (core) 
1) [x] Creat user 2) [!] License information
(no user will be created) (license not accepted)
Please make your choice from above ['q' to quit | 'c' to continue | 'r' to refresh]:
解决方法：
输入“1”，按Enter键
输入“2”，按Enter键
输入“q"，按Enter键
输入“yes”，按Enter键
也就是出现如下情况。

![](http://img.blog.csdn.net/20160913171741593)

用上面的方法能解决。
然后会进入一个什么都没有的页面，也就是让你登录，

![](http://img.blog.csdn.net/20160913171123433)

点击后会让你输入用户名和密码，可以输入你之前创建的用户。
或者是
用户名:root  
密码:你创建系统的时候建立的密码。

输入正确的话，就可以进入图形化系统了：

![](http://img.blog.csdn.net/20160913171613750)


至于为什么出现这个原因：

![](http://img.blog.csdn.net/20160913171857719)

另外一种解决方法是:
press 1, the screen changes slightly:

1) Read the License Agreement
[ ] 2) I accept the License Agreement

press 2, this will select the checkbox

[X] 2) I accept the License Agreement
press c, a confirmation will be displayed, stating that you accepted the license

press c again and you'll find the login prompt 

其实就是：
输入“1”，按Enter键
输入“2”，按Enter键
输入“c"，按Enter键
输入“c”，按Enter键
然后会提示你输入用户名和密码。


本文章由<a href="https://chenhaoxiang.github.io/">[谙忆]</a>编写， 所有权利保留。 
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
