---
layout: post
title: "【Cocos2d-x】开发基础-Cocos简介与环境搭建"
date: 2017-06-26 10:05:06 +0800
comments: true
categories:❸ C/C++语言基础,cocos2d-x
tags: [cocos2d-x,cocos2d,游戏引擎]
keyword: 陈浩翔, 谙忆
description: 本篇博客讲解: 
Cocos2d-x介绍与环境搭建 
1.移动平台游戏引擎介绍 
2.Cocos2d家谱介绍 
3.Cocos2d-x设计目标 
4.在Windows平台下开始开发Cocos2d-x游戏移动平台游戏引擎介绍
游戏引擎的定义
游戏引擎包含以下子系统
移动平台游戏引擎中主要可以分为
2D引擎主要有
3D引擎主要有
HTML 5的游戏引擎
Cocos2d家谱介绍
Cocos2d-x设计目标 
---


本篇博客讲解: 
Cocos2d-x介绍与环境搭建 
1.移动平台游戏引擎介绍 
2.Cocos2d家谱介绍 
3.Cocos2d-x设计目标 
4.在Windows平台下开始开发Cocos2d-x游戏移动平台游戏引擎介绍
游戏引擎的定义
游戏引擎包含以下子系统
移动平台游戏引擎中主要可以分为
2D引擎主要有
3D引擎主要有
HTML 5的游戏引擎
Cocos2d家谱介绍
Cocos2d-x设计目标
<!-- more -->
----------

---
layout: post
title: "【Cocos2d-x】开发基础-Cocos简介与环境搭建"
date: 2017-06-05 13:38:54 +0800
comments: true
categories: Cocos2d-x
tags: [Cocos2d-x, basis]
keyword: 陈浩翔, 谙忆, C++, Cocos2d-x,Cocos简介与环境搭建
description: Cocos2d-x介绍与环境搭建 1.移动平台游戏引擎介绍 2.Cocos2d家谱介绍 3.Cocos2d-x设计目标 4.在Windows平台下开始开发Cocos2d-x游戏

---

本篇博客讲解:  
Cocos2d-x介绍与环境搭建  
1.移动平台游戏引擎介绍  
2.Cocos2d家谱介绍  
3.Cocos2d-x设计目标  
4.在Windows平台下开始开发Cocos2d-x游戏

<!-- more -->
----------
[TOC]

#1.移动平台游戏引擎介绍  

##游戏引擎的定义
游戏引擎是指一些已编写好的可编辑游戏系统或者一些互交式图像应用程序的核心组件，游戏软件的主程序。  
通俗一点理解就是：  
游戏引擎其实就是一个半成品，它能帮你做什么，就是开发游戏。就是说，一些基础的工作帮你做好了。  
你拿过来之后，根据你的需求，根据你要开发的游戏的特点加上一些你自己的东西，那么这就是游戏引擎。  
如果没有游戏引擎，你完全可以自己做那些事情，有了游戏引擎之后，很多东西就不用自己去做了。  
游戏引擎你也可以理解成框架或者库！  

##游戏引擎包含以下子系统
渲染引擎:  
把从计算机中0101的代码变成我们能够识别的图像的过程！  
这样理解更好：相当与你拿一个染料桶在墙上刷染料，把染料刷到墙上的过程，这个就是渲染的过程。

物理引擎:  
其实就是模拟现实的物理环境，比如重力等  

碰撞检测系统、音效、脚本引擎、电脑动画、人工智能、网络引擎以及场景管理。

##移动平台游戏引擎中主要可以分为 
2D引擎和3D引擎

###2D引擎主要有
Coco2d-iphone,Cocos2d-x,Corona SDK,Construct 2,WiEngine和Cyclone 2D

Coco2d-iphone和Cocos2d-x看名字就知道有些联系了，Cocos2d-x很多类似管理的东西，比如对象，类的设计就是从Coco2d-iphone过度过来的。  
Corona SDK是用Lua脚本编写的  

###3D引擎主要有
Unity3D,Unreal Development Kit,ShiVa 3D 和Marmalade

现在很火的就是Unity3D  

##HTML 5的游戏引擎
Cocos2d-js,X-Canvas和Sphinx等

#2.Cocos2d家谱介绍  
![](http://i.imgur.com/yeghXaA.png)

其实这个家谱已经过时了，不过可以看到Cocos2d的发展路线  
有兴趣的大家可以自行搜索了解  

#3.Cocos2d-x设计目标 

##Cocos2d-x目标
![](http://i.imgur.com/ORpTwbq.png)

为什么Cocos2d这么优秀，为什么这么多人接受和推广它。  
我们看上面的图，首先，从横向来讲，cocos2d可以用很多平台开发，基于不同平台开发，很方便！  
还有发布平台，写一个程序，发布到多个平台！(节省大量时间和成本)  

从纵向往上来看，可以绑定Javascript和Lua脚本  
从纵向往下来看，就是和硬件有关了  
##Cocos2d-x绑定Javascript和Lua脚本
解释性的语言，结构非常严谨，编译速度很快！  

也就是在开发过程中，我们不止能使用c++开发，也能使用javascript和lua脚本开发！  

![](http://i.imgur.com/40Xt1bX.png)

可以看到，我们有4条线路来开发游戏  
1、C线路：通过c++  
2、D线路：通过Lua(我们不需要管和c++的绑定)  
3、B线路：JS绑定的引擎 cocos2d-js如果想开发本地游戏，需要调用cocos2d-x(我们不需要管怎么绑定的，只要会JS，就能开发本地游戏)  
4、A线路：开发网页游戏  

#4.在Windows平台下开始开发Cocos2d-x游戏
为什么选择在Window下开发游戏，因为对硬件设备要求没那么高  
而且先从window先学习cocos2dx是最容易学习的  
  
##使用Visual Studio开发工具
在这里我使用的是Visual Studio 2013  
操作系统是使用的Windows 7  

##下载和使用Cocos2d-x案例
网址：http://www.cocos2d-x.org/
![](http://i.imgur.com/2GQ3y9p.png)
下载:
![](http://i.imgur.com/vnnItnl.png)

下载解压之后：
![](http://i.imgur.com/aZAgVPh.png)

###build目录

我们要学习的话，先进入build目录里面，这个里面很多是工程文件 
.sln是基于微软的VS工具的解决方案  
 cocos2d_tests.xcodeproj和cocos2d_libs.xcodeproj在window下看起来是文件夹  
但是如果拿到mac系统里，但是其实就是mac xcode的工程文件，在xcode就可以运行cocos2d_tests.xcodeproj这个文件，运行之后，就会启动相关的案例代码  
在window就是启动cocos2d-win32.sln这个启动相关的案例代码  
![](http://i.imgur.com/kxLbiVg.png)

我们主要运行的就cpp-tests，cpp-tests就是我们看到的大部分帮助例子在这里！  
要想运行的，需要把这个设置为启动项目！然后就会看到这个是加粗的字体  
![](http://i.imgur.com/vHP1ovd.png)
然后运行它，第一次编译时间会比较长  
![](http://i.imgur.com/N6iotba.png)
运行之后，里面都是一些演示实例，大家可以看看  
看源代码的话，就搜索数字后面的名字，找源代码进行学习  

在window下开发选择win32，因为实际上在window下用VS开发出来，需要有模拟器来运行游戏场景，但是由于我们没有真机，所以把游戏场景在window的一个小窗口显示出来的，所以叫win32程序。
win32程序在最后发布的时候其实是没有用的，win32其实只是开发，模拟测试，还有学习的环境  

install-deps-linux.sh就是基于Linux的安装开发的文件    

###cocos目录
cocos2d引擎的源代码，全部放在这里
###docs目录
![](http://i.imgur.com/Wsl7Xmr.png)
文档目录，一开始是空的，只有上面的文件
###extensions目录
扩展的内库 - 一般也都是cocos2d团队开发的，但是它是扩展的
###external目录
第三方的扩展库，比如使用其他的物理引擎等
###plugin目录
插件什么的
###templates目录
这是模板，我们使用指令生成cocos2dx的模板，都是从这个模板里面生成的工程代码的  
###tests目录
就是刚刚的项目的cpp-tests的源码
###tools目录
工具目录
![](http://i.imgur.com/0gjch9N.png)
通过cocos的工具，python脚本编写的，可以帮助我们创建一个工程出来  

##生成API文档
看文件夹docs，里面没有帮助文档
![](http://i.imgur.com/kGgdSMr.png)
现在里面的内容是帮助我们生成帮助API文档的  
类似Java的网页式的帮助文档  
使用Doxygen(无法生成图片)和Graphviz工具，结合使用  
Doxygen:  
http://www.stack.nl/~dimitri/doxygen/download.html#latestsrc  
Graphviz:  
http://www.graphviz.org/Download_windows.php  
下载然后都安装就好了。  
启动Doxygen
![](http://i.imgur.com/4DEtFRw.png)
然后File->open  
打开cocos2d-x-3.13.1\docs下的doxygen.config文件  
我们不需要做其他事情，然后直接Run
![](http://i.imgur.com/Kdr1MRs.png)
会在docs目录下生成html目录，找到index.html文件
![](http://i.imgur.com/NmTwVH6.png)
然后直接用浏览器打开就行了  
![](http://i.imgur.com/8m5aul3.png)
这就是我们刚刚生成的cocos2dx的文档  

在此感谢CSDN学院关东升老师的教学视频！

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
