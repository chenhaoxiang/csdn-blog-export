---
layout: post
title: "【Linux】Linux服务器搭建JDK环境"
date: 2016-10-13 05:21:38 +0800
comments: true
categories:❻ 其他,----- Linux/Unix
tags: [服务器,linux,博客]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


首先，当然是去下载Linux的JDK咯。

先看你Linux的系统多少位：

getconf LONG_BIT



然后去下载对应的JDK位数 版本.—自己去谷歌搜索哦

我这里下载的是:jdk-7u79-linux-x64.tar.gz

首先我创建了2个文件夹:



mk 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


首先，当然是去下载Linux的JDK咯。

先看你Linux的系统多少位：

getconf LONG_BIT



然后去下载对应的JDK位数 版本.—自己去谷歌搜索哦

我这里下载的是:jdk-7u79-linux-x64.tar.gz

首先我创建了2个文件夹:



mk
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

首先，当然是去下载Linux的JDK咯。

先看你Linux的系统多少位：
```
getconf LONG_BIT
```
![](http://img.blog.csdn.net/20160925103307762)

然后去下载对应的JDK位数 版本.---自己去谷歌搜索哦

我这里下载的是:jdk-7u79-linux-x64.tar.gz

首先我创建了2个文件夹:

```
mkdir -p /java/jdk
```
jdk-7u79-linux-x64.tar.gz我放在java目录下

```
java -version     #查看服务器是否安装过jdk
```
我没有安装过，会提示
-bash: java: command not found

解压配置安装jdk1.7：

```
tar zxvf /java/jdk-7u79-linux-x64.tar.gz -C /java/jdk
```
![](http://img.blog.csdn.net/20160925112012775)

全部解压到jdk目录下了。

mv命令完成文件重命名:
```
mv /java/jdk/jdk1.7.0_79 /java/jdk/java7
```
![](http://img.blog.csdn.net/20160925112354144)


添加jdk1.7到系统环境变量:
```
cp /etc/profile /etc/profile.bak    #备份
```

```
vi /etc/profile     #编辑,在最后添加下面的内容 
```
```
export JAVA_HOME=/java/jdk/java7
export JRE_HOME=${JAVA_HOME}/jre  
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib  
export PATH=${JAVA_HOME}/bin:$PATH 
```
![](http://img.blog.csdn.net/20160925114505919)

编辑完如何保存退出编辑呢。
先按:Esc --> :wq -->回车

```
source /etc/profile 　　　#使配置文件立即生效
```

测试是否安装成功:
```
java -version       # 测试是否成功 
```

![](http://img.blog.csdn.net/20160925115708388)

这样就是jdk1.7安装成功了。

如果你下载的jdk是rpm后缀的：
用此命令安装
```
rpm -ivh ***(你下载的文件名).rpm
```
会安装到/usr/java目录下面

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
