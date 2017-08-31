---
layout: post
title: "【Jekyll搭建GITHUB个人博客】安装Ruby 环境、包管理器 RubyGems、Jekyll与错误解决"
date: 2017-03-23 01:40:30 +0800
comments: true
categories:搭建个人博客,❻ 其他
tags: [github,博客,csdn,Jekyll]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天在博客专家群看到CSDN韩俊强发表了一篇用Jekyll搭建个人博客的文章，感觉很好。 
搭建博客方便很多，开始一直想着自己搭建博客，然后一直没什么时间，在做另外一个项目，所以现在就考虑用Jekyll在GITHUB上搭建博客了。介绍下JekyllJekyll 是一个简单的博客形态的静 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天在博客专家群看到CSDN韩俊强发表了一篇用Jekyll搭建个人博客的文章，感觉很好。 
搭建博客方便很多，开始一直想着自己搭建博客，然后一直没什么时间，在做另外一个项目，所以现在就考虑用Jekyll在GITHUB上搭建博客了。介绍下JekyllJekyll 是一个简单的博客形态的静
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

今天在博客专家群看到CSDN韩俊强发表了一篇用Jekyll搭建个人博客的文章，感觉很好。
搭建博客方便很多，开始一直想着自己搭建博客，然后一直没什么时间，在做另外一个项目，所以现在就考虑用Jekyll在GITHUB上搭建博客了。

#介绍下Jekyll 
Jekyll 是一个简单的博客形态的静态站点生产机器。它有一个模版目录，其中包含原始文本格式的文档，通过 Markdown （或者 Textile） 以及 Liquid 转化成一个完整的可发布的静态网站，你可以发布在任何你喜爱的服务器上。Jekyll 也可以运行在 GitHub Page 上，也就是说，你可以使用 GitHub 的服务来搭建你的项目页面、博客或者网站，而且是完全免费的。

使用 Jekyll 搭建博客之前需要安装环境
Git 环境、Ruby 环境、包管理器 RubyGems、

本机已安装好了Git，就不在演示了，git的话，搜索一下，有很多教程的。祝你安装成功~

#安装Ruby 环境、包管理器 RubyGems

首先去 http://rubyinstaller.org/downloads
下载需要的软件。
Ruby 2.3.3 (x64):
![](http://img.blog.csdn.net/20170323121259505?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

DevKit-mingw64-64-4.7.2-20130224-1432-sfx.exe:
![](http://img.blog.csdn.net/20170323121309349?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


安装ruby
运行下载好的rubyinstaller-2.3.3-x64.exe
选择安装路径
我选择的是D:/Ruby23
把钩打上
![](http://img.blog.csdn.net/20170323131054206?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

安装完毕后打开cmd
输入:
```
ruby -v
```
如果显示如下说明ruby安装成功：
![](http://img.blog.csdn.net/20170323121822324?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

使用RubyInstaller的同时也安装了rubyGems
输入:
```
gem -v
```
如果显示如下说明rubyGems安装成功：

![](http://img.blog.csdn.net/20170323121916461?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

安装devkit!
很重要哦

安装刚刚下载的文件DevKit-mingw64-64-4.7.2-20130224-1432-sfx.exe
![](http://img.blog.csdn.net/20170323131215237?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

进入你安装devkit的主目录，按住shift，点击鼠标右键，选择在此处打开命令窗口。
如果你没有进入devkit目录打开命令窗口(CMD)，就自己切换到devkit主目录下。
输入:
```
ruby dk.rb init
```
会提示你修改config.yml文件
![](http://img.blog.csdn.net/20170323131324190?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

然后你进入你安装的devkit的主目录下，去修改config.yml文件。
如果你没有运行该命令，可以自己建文件，然后配置。
原文件为:
![](http://img.blog.csdn.net/20170323122952201?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


修改为:
![](http://img.blog.csdn.net/20170323131418539?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

```
- D:/Ruby23
- D:/Ruby23
```

注意不要写成反斜杠！是/

这两个目录分别为你Ruby和devkit的安装目录。
如果和我安装的目录不在同一个下面，不要和我的写成一样了哦。

保存后关闭文件。
再输入命令
```
ruby dk.rb install
```
安装成功:
![](http://img.blog.csdn.net/20170323131512603?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


这里可能会有一个错误
![](http://img.blog.csdn.net/20170323131609792?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
尚无法解决，该错误请参考stackoverflow网址:
http://stackoverflow.com/questions/18803223/unable-to-find-rubygems-in-site-ruby-or-core-ruby
我的解决办法是重新装了一遍，把路径改成这样的。

ruby，rubygems，devkit的安装完毕了
运行:
```
gem install mongo
```
![](http://img.blog.csdn.net/20170323131633474?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

#获取最简单 Jekyll 模板并生成静态页面

需要的环境搭建好了之后，就是获取最简单 Jekyll 模板并生成静态页面、

##安装 jekyll
```
gem install jekyll
```
等待下载完成...
![](http://img.blog.csdn.net/20170323131721528?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

切换到你需要下载模板到那里的目录的上一级
我这里的目录是G:\Github\myBlog，我想把模板下载到myBlog目录下。
切换的G:\Github下输入:
```
jekyll new myblog
```
在这里你可能会遇到一个错误,见错误二(没有的，可忽略)，该错误课看本篇后面的可能的错误以及解决办法。
![](http://img.blog.csdn.net/20170323132006985?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

如果没有错误出现，就是下面这种情况
![](http://img.blog.csdn.net/20170323133624524?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
![](http://img.blog.csdn.net/20170323133631102?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
恭喜。

接下来切换到myblog目录下面、
![](http://img.blog.csdn.net/20170323133719922?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

输入:

```
jekyll serve
```
![](http://img.blog.csdn.net/20170323133800886?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这个时候就可以访问:
http://localhost:4000/
![](http://img.blog.csdn.net/20170323133850125?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

祝大家安装成功。

#可能的错误以及解决办法

##错误一：
Fetching: bson-4.2.1.gem (100%)
ERROR:  Error installing mongo:
        The 'bson' native gem requires installed build tools.
Please update your PATH to include build tools or download the DevKit
from 'http://rubyinstaller.org/downloads' and follow the instructions
at 'http://github.com/oneclick/rubyinstaller/wiki/Development-Kit'
![](http://img.blog.csdn.net/20170323122207884?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
###解决办法
安装刚刚下载的DevKit-mingw64-64-4.7.2-20130224-1432-sfx.exe就可以了。
见前面的安装devkit。

##错误二
运行 jekyll new myblog 的时候出现该错误：
```
  Dependency Error: Yikes! It looks like you don't have bundler or one of its de
pendencies installed. In order to use Jekyll as currently configured, you'll nee
d to install this gem. The full error message from Ruby is: 'cannot load such fi
le -- bundler' If you run into trouble, you can find helpful resources at https:
//jekyllrb.com/help/!
jekyll 3.4.3 | Error:  bundler
```
###解决办法
请安装bundler：
```
gem install bundler
```
然后安装bundle,bundle install
![](http://img.blog.csdn.net/20170323132519525?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

#错误三
```
 Conflict: G:/Github/myBlog exists and is not empty.
```
###解决办法
删除myBlog 下的所有文件即可解决

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
