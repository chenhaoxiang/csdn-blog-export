---
layout: post
title: "【Linux】Linux下安装Tomcat服务器"
date: 2016-10-14 12:34:24 +0800
comments: true
categories:❻ 其他,----- Linux/Unix
tags: [tomcat,java,jdk,linux,服务器]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
上传Tomcat服务器:首先，需要下载Tomcat-上传到服务器。 
可以这样在线下载: 
http://tomcat.apache.org/download-70.cgi 下载地址选择tar.gz下载方式，复制下载地址，在linux终端中输入:在linux中输入:wget -c 下载 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
上传Tomcat服务器:首先，需要下载Tomcat-上传到服务器。 
可以这样在线下载: 
http://tomcat.apache.org/download-70.cgi 下载地址选择tar.gz下载方式，复制下载地址，在linux终端中输入:在linux中输入:wget -c 下载
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

#上传Tomcat服务器:

首先，需要下载Tomcat-上传到服务器。
![](http://img.blog.csdn.net/20160925120544522)

![](http://img.blog.csdn.net/20160925120701554)

可以这样在线下载:
http://tomcat.apache.org/download-70.cgi 下载地址

![](http://img.blog.csdn.net/20170320125110429?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

选择tar.gz下载方式，复制下载地址，在linux终端中输入:

在linux中输入:

```
wget -c 下载地址
```


#安装Tomcat服务器

##解压tomcat服务器压缩包

现在已经在java目录下了。
```
tar zxvf apache-tomcat-7.0.72.tar.gz
```
![](http://img.blog.csdn.net/20160925121039727)

解压成功了:
![](http://img.blog.csdn.net/20160925121126815)

##配置环境变量
tomcat服务器运行时是需要JDK支持的，所以必须配置好JDK用到的那些环境变量

```
cd /etc/
ls #显示目录下所有文件及文件夹
```

![](http://img.blog.csdn.net/20160925121338150)

编辑/etc下的profile文件：
```
vi profile
```
如果出现选项---按:e
![](http://img.blog.csdn.net/20160925121635215)

![](http://img.blog.csdn.net/20160925121513399)

也就是你配置JDK时的配置
![](http://img.blog.csdn.net/20160925121956654)


##修改tomcat服务器的启动端口

```
cd /java/apache-tomcat-7.0.72/conf/
```
进入Tomcat服务器的conf目录下:
![](http://img.blog.csdn.net/20160925122322175)
找到server.xml文件。

使用:
```
vi server.xml
```
编辑server.xml文件。
![](http://img.blog.csdn.net/20160925122428255)


修改Tomcat服务器启动时使用的端口，例如改成10001

![](http://img.blog.csdn.net/20160925122654774)

修改完server.xml文件之后，保存，退出。
Esc-->:wq -->回车
![](http://img.blog.csdn.net/20160925122747900)

#启动和关闭Tomcat服务器

##启动Tomcat服务器

进入tomcat服务器的bin目录
```
 cd /java/apache-tomcat-7.0.72/bin
```
![](http://img.blog.csdn.net/20160925123025049)


执行"./startup.sh"命令启动Tomcat服务器:
```
./startup.sh
```
![](http://img.blog.csdn.net/20160925123146424)

查看tomcat服务器的Log信息，看看tomcat服务器是否已经正常启动，进入tomcat服务器下的logs目录，打开catalina.out文件进行查看
```
cd /java/apache-tomcat-7.0.72/logs
```
![](http://img.blog.csdn.net/20160925123324816)


```
 cat catalina.out
```
查看catalina.out
![](http://img.blog.csdn.net/20160925123534752)
10001为访问的端口

最后，如果要通过ip访问:
```
/sbin/iptables -I INPUT -p tcp --dport 10001 -j ACCEPT
```
编辑防火墙规则.

![](http://img.blog.csdn.net/20160925124634410)


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
