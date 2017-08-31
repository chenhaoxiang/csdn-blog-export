---
layout: post
title: "【IDEA】Intellij IDEA创建的Web项目配置Tomcat并启动Maven项目"
date: 2016-11-20 11:23:09 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ④、Web学习之旅
tags: [tomcat,idea,intellij idea,maven,web]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
本篇博客讲解IDEA如何配置Tomcat、大部分是直接上图哦、点击如图所示的地方，进行添加Tomcat配置页面弹出页面后，按照如图顺序找到，点击+号tomcat Service -> Local注意，这里不要选错了哦，还有一个TomEE Service！按照下面图所示进行配置。图中数字 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
本篇博客讲解IDEA如何配置Tomcat、大部分是直接上图哦、点击如图所示的地方，进行添加Tomcat配置页面弹出页面后，按照如图顺序找到，点击+号tomcat Service -> Local注意，这里不要选错了哦，还有一个TomEE Service！按照下面图所示进行配置。图中数字
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

本篇博客讲解IDEA如何配置Tomcat、

大部分是直接上图哦、

**点击如图所示的地方，进行添加Tomcat配置页面**

![](http://img.blog.csdn.net/20161120093455354)

**弹出页面后，按照如图顺序找到，点击+号**

![](http://img.blog.csdn.net/20161120093947267)

tomcat Service -> Local

![](http://img.blog.csdn.net/20161120094126348)

注意，这里不要选错了哦，还有一个TomEE Service！


按照下面图所示进行配置。


图中数字的地方代表的配置意思:
1代表名称，给配置的Tomcat取名称。
2代表配置Tomcat的安装路径。
3代表Tomcat服务器启动后，默认打开的浏览器，根据自己习惯打开。
4代表浏览器显示路径，根据自己喜好可以改。
5和6都是默认的，不需要修改。

![](http://img.blog.csdn.net/20161120095237254)

配置Deployment，webapp为项目的webapp，后面的名字可以自己定义，别忘了加“/”.

![](http://img.blog.csdn.net/20161120105753626)


如果你配置好Tomcat之后还是无法启动web项目，那么你可以试试下面的方法:

Facets 的web设置

![](http://img.blog.csdn.net/20161120111830114)

![](http://img.blog.csdn.net/20161120112025526)

添加Artifacts

![](http://img.blog.csdn.net/20161120112113870)

再添加tomcat

![](http://img.blog.csdn.net/20161120105753626)


启动tomcat

![](http://img.blog.csdn.net/20161120112211667)

![](http://img.blog.csdn.net/20161120112233308)



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
