---
layout: post
title: "利用Eclipse自带的插件连接GIT的详解"
date: 2016-09-10 10:46:05 +0800
comments: true
categories:❻ 其他,----- 好文/知识点
tags: [eclipse,git,github,svn,插件]
keyword: 陈浩翔, 谙忆
description: 第一次与团队合作开发项目，首先就是学习使用git或者svn。 
本来自己使用git提交代码到github也有一段时间了，但是发现团队另外2人都是用命令行，哈哈，很明显，自己水平就显得差了很多。偷偷的说下，自己以前都是用图形化软件。 
建议大家，平时自己用的时候尽量使用命令行，而不要依赖 
---


第一次与团队合作开发项目，首先就是学习使用git或者svn。 
本来自己使用git提交代码到github也有一段时间了，但是发现团队另外2人都是用命令行，哈哈，很明显，自己水平就显得差了很多。偷偷的说下，自己以前都是用图形化软件。 
建议大家，平时自己用的时候尽量使用命令行，而不要依赖
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

第一次与团队合作开发项目，首先就是学习使用git或者svn。
本来自己使用git提交代码到github也有一段时间了，但是发现团队另外2人都是用命令行，哈哈，很明显，自己水平就显得差了很多。偷偷的说下，自己以前都是用图形化软件。
建议大家，平时自己用的时候尽量使用命令行，而不要依赖图形界面。

在这里，仅仅讲解下如何使用eclipse连接到git。

首先第一步，当然是打开eclipselal，
然后
步骤是:Window-->Show View-->Other...
看图:

![](http://img.blog.csdn.net/20160910223541863)

接下来会显示如下框：
Git-->Git Repositories

![](http://img.blog.csdn.net/20160910223644830)

点OK之后，下面的视图会出现:Git Repositories

选择Clone a Git repository

![](http://img.blog.csdn.net/20160910223729459)

点击之后会出现如下框，URL是需要我们填写的，
你输入你项目的URL就好了。

![](http://img.blog.csdn.net/20160910224122731)

再点Next。
选择分支。
再点Next。

![](http://img.blog.csdn.net/20160910224220388)

这个时候，我们需要选择一个本地文件路径，存放git云端的项目。

下面那个钩一定要选上，否则clone过来的项目会是空的。

![](http://img.blog.csdn.net/20160910224347375)

然后就完成了，出现如下图片:

![](http://img.blog.csdn.net/20160910224403755)

项目已经导入，可以和团队一起开发了。


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
