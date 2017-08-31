---
layout: post
title: "【问题解决】IDEA右键选择new新文件的时候没有JSP文件选项解决"
date: 2016-12-18 01:00:02 +0800
comments: true
categories:❻ 其他,----- 上网技巧/问题解决
tags: [idea,jsp,博客]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
本人接触IDEA没多久，使用过程中遇到很多问题。特别是这个问题网上没找到很好的解决办法。 
所以我以前创建的时候都是创建文件，然后自己打后缀，拷贝jsp的模板，实在麻烦。经过差不多半天的逛论坛，谷歌百度，整合了下， 
问题出在了IDEA认为我这个包建的有问题，才导致这地方不应该创建js 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
本人接触IDEA没多久，使用过程中遇到很多问题。特别是这个问题网上没找到很好的解决办法。 
所以我以前创建的时候都是创建文件，然后自己打后缀，拷贝jsp的模板，实在麻烦。经过差不多半天的逛论坛，谷歌百度，整合了下， 
问题出在了IDEA认为我这个包建的有问题，才导致这地方不应该创建js
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

本人接触IDEA没多久，使用过程中遇到很多问题。特别是这个问题网上没找到很好的解决办法。
所以我以前创建的时候都是创建文件，然后自己打后缀，拷贝jsp的模板，实在麻烦。

经过差不多半天的逛论坛，谷歌百度，整合了下，
问题出在了IDEA认为我这个包建的有问题，才导致这地方不应该创建jsp文件，所以就没有创建JSP文件的选项。

![](http://img.blog.csdn.net/20161218125536169?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

在这里呢，找到了一个解决办法，就是让IDEA知道，你需要在这个包建JSP页面的。

![](http://img.blog.csdn.net/20161218125725032?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这样设置之后，IDEA就知道你这个包下面是放置web模块的文件，它会给你JSP文件选项的。

![](http://img.blog.csdn.net/20161218125836626?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

至于有的朋友是无法创建Java类型的文件，差不多是这个原理。
只是设置的位置不同，你需要把Java源码的包设置成那个包。

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
