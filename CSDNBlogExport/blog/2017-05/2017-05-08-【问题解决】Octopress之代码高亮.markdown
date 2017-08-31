---
layout: post
title: "【问题解决】Octopress之代码高亮"
date: 2017-05-08 12:26:10 +0800
comments: true
categories:❻ 其他,----- 上网技巧/问题解决
tags: [Octopress]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
最近在学习cocos-2dx C++开发棋牌游戏，所以写博客的时间就少了很多。今天稍微有点空闲时间，发了几个小时学了下用Octopress搭建个人博客。中间遇到了一个问题，也就是代码高亮的问题，开始无论怎么都发布不了代码高亮的代码，后来经过一番搜索，解决了。Octopress默认是使用 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
最近在学习cocos-2dx C++开发棋牌游戏，所以写博客的时间就少了很多。今天稍微有点空闲时间，发了几个小时学了下用Octopress搭建个人博客。中间遇到了一个问题，也就是代码高亮的问题，开始无论怎么都发布不了代码高亮的代码，后来经过一番搜索，解决了。Octopress默认是使用
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

最近在学习cocos-2dx C++开发棋牌游戏，所以写博客的时间就少了很多。

今天稍微有点空闲时间，发了几个小时学了下用Octopress搭建个人博客。

中间遇到了一个问题，也就是代码高亮的问题，开始无论怎么都发布不了代码高亮的代码，后来经过一番搜索，解决了。

![](http://img.blog.csdn.net/20170508002307960)

Octopress默认是使用pygment这个语法高亮插件。
所以我们需要安装这个插件。

需要进行下面4步。


1、安装Python；
2、安装easy_install；
下载地址：https://pypi.python.org/pypi/ez_setup

![](http://img.blog.csdn.net/20170508002046998)

下载 ez_setup-0.9.tar.gz 后，解压，找到有ez_setup.py的目录
按住键盘的 shift 键，右击鼠标，选中“在此处打开命令窗口”
进入 DOS 界面，输入命令：python ez_setup.py

3、添加%Python%\Scripts到环境变量，%Python%是Python的安装目录；
4、安装pygements：
直接在cmd运行该命令(需要你把python安装目录添加到path)：
easy_install pygments


这时就可以看到我们的代码高亮了

![](http://img.blog.csdn.net/20170508002245922)

如果有时间的话，可能会把完整Octopress的搭建教程写一下，如果没空的话，就只能以后啦。

本文章由<a href="https://chenhaoxiang.github.io/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
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
