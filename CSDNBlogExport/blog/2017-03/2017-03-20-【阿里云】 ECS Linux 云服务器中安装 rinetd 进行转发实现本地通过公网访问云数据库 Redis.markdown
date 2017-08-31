---
layout: post
title: "【阿里云】 ECS Linux 云服务器中安装 rinetd 进行转发实现本地通过公网访问云数据库 Redis"
date: 2017-03-20 11:07:14 +0800
comments: true
categories:❻ 其他,----- Linux/Unix
tags: [数据库,redis,云数据库,云服务器,阿里云]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天在阿里云买了一个月的云数据库Redis试试水，一开始因为我选择的云数据库Redis是经典网络，所以搭建好之后，设置键值对会超时。 
(注意ECS服务器和Redis数据库在一个地区！！！很重要) 
注意的事项是： 
redis是经典网络的, ecs是专有网络的,这两者内网不通, 所以 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天在阿里云买了一个月的云数据库Redis试试水，一开始因为我选择的云数据库Redis是经典网络，所以搭建好之后，设置键值对会超时。 
(注意ECS服务器和Redis数据库在一个地区！！！很重要) 
注意的事项是： 
redis是经典网络的, ecs是专有网络的,这两者内网不通, 所以
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

今天在阿里云买了一个月的云数据库Redis试试水，一开始因为我选择的云数据库Redis是经典网络，所以搭建好之后，设置键值对会超时。
(注意ECS服务器和Redis数据库在一个地区！！！很重要)
注意的事项是：
redis是经典网络的, ecs是专有网络的,这两者内网不通, 所以需要在redis控制台, 实例信息,基本信息,将redis切换到专有网络下即可连接. 
注意: 
1. redis切换到专有网络后无法再切回经典网络. 
2. vpc下必须有和redis相同可用区的交换机才可以切换成功. 

#ECS Linux 安装rinetd 

其实很多内容在阿里云的帮助文档有，不过为了方便大家阅读，就在这里照搬下阿里云的帮助文档。
目前云数据库 Redis 需要通过 ECS 的内网进行连接访问。如果您本地需要通过公网访问云数据库 Redis，可以在 ECS Linux 云服务器中安装 rinetd 进行转发实现。

##在云服务器 ECS Linux 中安装 rinetd。

```
     wget http://www.boutell.com/rinetd/http/rinetd.tar.gz&&tar -xvf rinetd.tar.gz&&cd rinetd
     sed -i 's/65536/65535/g' rinetd.c (修改端口范围)
     mkdir /usr/man&&make&&make install
```
注意：rinetd 安装包下载地址不确保下载可用性，您可以自行搜索安装包进行下载使用。
PS:2017.3.20截止，这个网址可以访问下载！

##创建配置文件。

```
vi /etc/rinetd.conf
```

##在文件里面输入如下内容：

```
     0.0.0.0 6379 Redis的链接地址 6379
     logfile /var/log/rinetd.log
```
这里的Redis的链接地址就是在这里显示的地址

![](http://img.blog.csdn.net/20170320230230700?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##执行如下命令启动rinetd

```
rinetd
```

设置为自启动:

```
echo rinetd >>/etc/rc.local
```

结束该进程

```
pkill rinetd
```

##验证测试

在本地通过 redis-cli 连接 ECS Linux 服务器后进行登录验证，比如安装了 rinetd 的ECS服务器的公网 IP 是 1.1.1.1：
```
redis-cli -h 1.1.1.1 -a Redis的实例ID:Redis密码
```
通过上述步骤即可实现：您本地的 PC 或服务器通过公网连接 ECS Linux 6379 端口，对云数据库 Redis 进行访问。

基本上这样操作完成后是不会出现问题的。
如果出现了问题，可能需要注意的就是，经典网络还是专用网络。
或者注意ECS服务器和云数据库是不是在同一个区。

![](http://img.blog.csdn.net/20170320230606070?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

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
