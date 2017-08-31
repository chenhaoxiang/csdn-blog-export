---
layout: post
title: "【问题解决】Eclipse安装Aptana插件-(注意对应版本问题)"
date: 2017-02-26 05:31:00 +0800
comments: true
categories:❻ 其他,----- 上网技巧/问题解决
tags: [aptana,eclipse,插件,博客]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
昨天，我同学用Eclipse安装Aptana插件，她弄了一天都没安装起，最后找了我。 
然后我也按照她的那个方法安装，结果一样，安装不成功！网上很多安装教程都是不完整的，我也不知道为什么，可能这是国内一些安装教程的通病！就是没有注重版本号的对应！而且中间会漏写一些关键步骤！假如你出现了 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
昨天，我同学用Eclipse安装Aptana插件，她弄了一天都没安装起，最后找了我。 
然后我也按照她的那个方法安装，结果一样，安装不成功！网上很多安装教程都是不完整的，我也不知道为什么，可能这是国内一些安装教程的通病！就是没有注重版本号的对应！而且中间会漏写一些关键步骤！假如你出现了
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

昨天，我同学用Eclipse安装Aptana插件，她弄了一天都没安装起，最后找了我。
然后我也按照她的那个方法安装，结果一样，安装不成功！

网上很多安装教程都是不完整的，我也不知道为什么，可能这是国内一些安装教程的通病！就是没有注重版本号的对应！而且中间会漏写一些关键步骤！

假如你出现了安装Aptana之后，Eclipse却没有出现Aptana的页面，也就是这个：
![](http://img.blog.csdn.net/20170226171543516?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
或者这里没有Aptana：
![](http://img.blog.csdn.net/20170226171627626?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

那么其中一个最大的可能原因就是：

你的Aptana插件版本太低！
(至于为什么！这就是国内一些安装教程的问题了！他们往往会直接给你一个网址，然后让你用那个网址，殊不知，这个网址的下载版本可能是几年前甚至是十年前的！)

所以，这个时候你需要做的就是去Aptana官网下载最新版本！

在这里，我只详细讲解Eclipse在线安装Aptana插件！
即使是在线安装，也需要去Aptana官网去找一下最新的Aptana的下载地址。
Aptana官网：http://www.aptana.com/

![](http://img.blog.csdn.net/20170226172041219?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

点击下载的那个蓝色按钮，进入下一个页面：

![](http://img.blog.csdn.net/20170226172147173?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

在这里，选择Eclipse Plug-in Version，打上勾就好。

然后再点击下方的蓝色下载按钮：(不需要注册，也不需要留邮箱就可以进入的)

![](http://img.blog.csdn.net/20170226172306673?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

复制下我箭头指向的那个网址
http://download.aptana.com/studio3/plugin/install
(注意！如果官网的链接不是这个，证明更新了版本，建议使用官网的最新版本网址)
接下来就是操作Eclipse了。

![](http://img.blog.csdn.net/20170226172443643?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170226172629675?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

点击Add...按钮，然后将网址粘贴进Location,至于Name，你可以自己随便填写！

然后点OK。

![](http://img.blog.csdn.net/20170226172759956?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

把箭头指向的4个钩都打上，点Select All，然后点Next。

接下来就一直按照那个步骤来就行了！

安装完成后会自动重启Eclipse，接下来会有两个弹框，你选择OK就行！

然后就会出现Aptana的页面。这就表示你安装成功了。



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
