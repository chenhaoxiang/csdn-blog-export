---
layout: post
title: "【Linux】Linux下使用wget 命令下载JDK7的方法"
date: 2016-12-16 04:59:49 +0800
comments: true
categories:❻ 其他,----- Linux/Unix
tags: [jdk,linux]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


前几天去阿里云买了学生特权的云服务器。 
现在下载JDK的时候遇到了麻烦， 
输入命令:

wget http://download.oracle.com/otn-pub/java/jdk/7u79-b15/jdk-7u79-linux-x64.rpm

下载下来后，文件大小是8 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


前几天去阿里云买了学生特权的云服务器。 
现在下载JDK的时候遇到了麻烦， 
输入命令:

wget http://download.oracle.com/otn-pub/java/jdk/7u79-b15/jdk-7u79-linux-x64.rpm

下载下来后，文件大小是8
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

前几天去阿里云买了学生特权的云服务器。
现在下载JDK的时候遇到了麻烦，
输入命令:

```
wget http://download.oracle.com/otn-pub/java/jdk/7u79-b15/jdk-7u79-linux-x64.rpm
```

下载下来后，文件大小是8K...8K...

后来想到，应该是做了什么防护吧，监控网络，发现有cookie防护。

![](http://img.blog.csdn.net/20161214181506244?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


于是把命令改成:
```
wget -c -P /java/jdk --no-check-certificate --no-cookie --header "Cookie: s_nr=1479818001999; s_cc=true; s_sq=oracledevall%3D%2526pid%253Docom%25253Aen-us%25253A%25252Fcn%25252Fjava%25252Fjavase%25252Foverview%25252F%2526pidt%253D1%2526oid%253Dotn%25253Acn%25253Atab%25253Ajava%25253A%2525E4%2525B8%25258B%2525E8%2525BD%2525BD%2526oidt%253D1%2526ot%253DA%2526oi%253D1; ELOQUA=GUID=4b703a6e148b4855a6708de929b383a5; gpw_e24=http%3A%2F%2Fwww.oracle.com%2Ftechnetwork%2Fcn%2Fjava%2Fjavase%2Fdownloads%2Fjdk7-downloads-1880260.html; oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/7u79-b15/jdk-7u79-linux-x64.rpm
```

成功下载：

![](http://img.blog.csdn.net/20161214182128169?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这个下载到的目录是 /java/jdk 目录

还有一个短一点的代码，也可以：

```
wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/7u79-b15/jdk-7u79-linux-x64.rpm
```
这个下载到的目录是当前目录！

OK，希望大家解决了linux下载jdk问题。



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
