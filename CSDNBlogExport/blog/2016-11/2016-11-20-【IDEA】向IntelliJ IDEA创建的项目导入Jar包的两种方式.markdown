---
layout: post
title: "【IDEA】向IntelliJ IDEA创建的项目导入Jar包的两种方式"
date: 2016-11-20 09:19:00 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具
tags: [idea,intellij idea,jar]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天用IDEA，需要导入一个Jar包，因为以前都是用eclipse的，所以对这个idea还不怎么上手，连打个Jar包都是谷歌了一下。但是发现网上谷歌到的做法一般都是去File –> Project Structure中去设置，有没有如同eclipse一样简便的右键添加方法呢。然后自己摸 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天用IDEA，需要导入一个Jar包，因为以前都是用eclipse的，所以对这个idea还不怎么上手，连打个Jar包都是谷歌了一下。但是发现网上谷歌到的做法一般都是去File –> Project Structure中去设置，有没有如同eclipse一样简便的右键添加方法呢。然后自己摸
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

今天用IDEA，需要导入一个Jar包，因为以前都是用eclipse的，所以对这个idea还不怎么上手，连打个Jar包都是谷歌了一下。

但是发现网上谷歌到的做法一般都是去File –> Project Structure中去设置，有没有如同eclipse一样简便的右键添加方法呢。

然后自己摸索了一下，找到了。

以阿里大于的依赖包为例子，因为正好是我遇到要导入的Jar包。

先说下第一种方法吧。也就是

#File –> Project Structure导入方法

先是进入：File –> Project Structure

![](http://img.blog.csdn.net/20161120091128267)

再找到Modules->Dependencies
点击最右侧的绿色+号
如图:

![](http://img.blog.csdn.net/20161120091317312)

选择1或者2都行的：

![](http://img.blog.csdn.net/20161120091439735)

然后就是选择你要导入的Jar包了。

然后再讲下第二种方式。

#右键添加Jar包

也就是在你需要导入的Jar包上，点击右键，选择Add as Library...

![](http://img.blog.csdn.net/20161120091704629)

点击OK就行了。

![](http://img.blog.csdn.net/20161120091759801)

嗯~我知道的也就这2种方式了~

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
