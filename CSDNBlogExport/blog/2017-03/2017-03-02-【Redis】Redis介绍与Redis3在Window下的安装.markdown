---
layout: post
title: "【Redis】Redis介绍与Redis3在Window下的安装"
date: 2017-03-02 12:52:07 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ⑤、数据库
tags: [redis,apache,免费,博客]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
前言其实在今天之前，我都不知道Redis是什么东西。至于为什么知道了这个东西，而且又要去学Redis。因为需要学习Apache Shiro权限控制-里面用到了Redis，所以就先把Redis学完再继续学习Shiro~Redis介绍Redis 是完全开源免费的，遵守BSD协议，是一个高性 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
前言其实在今天之前，我都不知道Redis是什么东西。至于为什么知道了这个东西，而且又要去学Redis。因为需要学习Apache Shiro权限控制-里面用到了Redis，所以就先把Redis学完再继续学习Shiro~Redis介绍Redis 是完全开源免费的，遵守BSD协议，是一个高性
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

#前言

其实在今天之前，我都不知道Redis是什么东西。至于为什么知道了这个东西，而且又要去学Redis。

因为需要学习Apache Shiro权限控制-里面用到了Redis，所以就先把Redis学完再继续学习Shiro~

#Redis介绍

Redis 是完全开源免费的，遵守BSD协议，是一个高性能的key-value数据库。

```
Redis 与其他 key - value 缓存产品有以下三个特点：

    Redis支持数据的持久化，可以将内存中的数据保存在磁盘中，重启的时候可以再次加载进行使用。
    Redis不仅仅支持简单的key-value类型的数据，同时还提供list，set，zset，hash等数据结构的存储。
    Redis支持数据的备份，即master-slave模式的数据备份。 
```

我先是学的MySQL，MySQL是持久化存储，存放在磁盘里面，检索的话，会涉及到一定的IO，为了解决这个瓶颈，于是出现了缓存。

首先，用户访问Redis，如果Redis重没有，就去访问MySQL，之后像内存和硬盘一样，把数据复制到Redis一部分。

Redis是驻留在内存中运行的，这大大提升了高数据量web访问的访问速度。

Redis+MySQL，它是内存+磁盘关系的一个映射，MySQL放在磁盘，Redis放在内存，这样的话，web应用每次只访问Redis，如果没有找到的数据，才去访问Mysql。

其他一些的Redis的特性和优势就不复制过来了。随便搜索网上一大片。

#Redis在Window下的安装

首先，当然是直接贴出下载地址咯：
https://github.com/MSOpenTech/redis/releases

![](http://img.blog.csdn.net/20170302120938993?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
Redis 支持 32 位和 64 位。这个需要根据你系统平台的实际情况选择。

在linux环境下Redis可以直接通过源码编译安装。Windows下编译一般不那么方便，我们使用已经编译好的.msi安装包来安装。

在这里，我们下载.msi安装包。

如果你下载很慢(反正我的下载是只有几KB每秒)，从这里去下载:

http://download.csdn.net/detail/qq_26525215/9768147

下载完成后。运行安装。

![](http://img.blog.csdn.net/20170302122019577?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170302122026780?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

在这里，我的安装位置是C:\Redis

下面的那个是添加该路径到环境变量path中去，可以勾上。

![](http://img.blog.csdn.net/20170302122514101?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

安装之后就是这样的。

然后打开CMD，运行 redis-server.exe redis.windows.conf 。
(如果你没有添加目录到Path变量中，就需要手动切换到 C:\Redis目录再输入命令运行)

我是添加了环境变量的：可是无法在其他路径打开，出现如下错误：
![](http://img.blog.csdn.net/20170302123928195?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
(不去细究了，有知道的朋友麻烦在评论区留言，O(∩_∩)O谢谢)

我还是老实的切到C:\Redis目录吧，再输入：redis-server.exe redis.windows.conf 。

![](http://img.blog.csdn.net/20170302124140295?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

启动完成后，这个CMD窗口别关，不然就无法访问服务端了，再打开另外一个窗口。

输入命令:
redis-cli.exe -h 127.0.0.1 -p 6379 。
(这里不用切换到C:\Redis目录也可以~环境变量的路径起作用了)
![](http://img.blog.csdn.net/20170302124543988?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

设置键值对 
```
set key chenhaoxiang
```
然后取出key

```
get key
```
这里的"key" 你可以自定义的
![](http://img.blog.csdn.net/20170302124727741?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这个有智能提示的，让我吃鲸了一下，哈哈，很不错，回车之后，智能提示会消失。
![](http://img.blog.csdn.net/20170302124929995?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170302124940167?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170302124958449?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

安装基本上就是这些啦，祝你安装成功！

关闭Redis:
```
 redis-cli shutdown
```

设置访问密码:
```
修改redis.conf文件配置 
# requirepass foobared去掉注释，foobared改为自己的密码
```

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
