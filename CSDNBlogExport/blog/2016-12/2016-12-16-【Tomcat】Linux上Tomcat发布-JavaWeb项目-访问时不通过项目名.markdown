---
layout: post
title: "【Tomcat】Linux上Tomcat发布-JavaWeb项目-访问时不通过项目名"
date: 2016-12-16 05:03:40 +0800
comments: true
categories:❻ 其他,----- Linux/Unix
tags: [tomcat,发布,linux]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


一开始自己不知道怎么直接通过域名访问到自己部署的Web项目，发布在Tomcat上的。 
因为自己以前写都是后面加了项目名， 
然后去百度谷歌，找到了下面的正确方法

如果你不想输入端口号访问，记得把端口号8080改为80哦。 
 
apache-tomcat-7.0.73/con 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


一开始自己不知道怎么直接通过域名访问到自己部署的Web项目，发布在Tomcat上的。 
因为自己以前写都是后面加了项目名， 
然后去百度谷歌，找到了下面的正确方法

如果你不想输入端口号访问，记得把端口号8080改为80哦。 
 
apache-tomcat-7.0.73/con
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

一开始自己不知道怎么直接通过域名访问到自己部署的Web项目，发布在Tomcat上的。
因为自己以前写都是后面加了项目名，
然后去百度谷歌，找到了下面的正确方法

如果你不想输入端口号访问，记得把端口号8080改为80哦。
![](http://img.blog.csdn.net/20161215135444842?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
apache-tomcat-7.0.73/conf/server.xml文件中

1、把项目名改成ROOT即可(如果有先删除之前的ROOT项目)
![](http://img.blog.csdn.net/20161215134501828?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

2、修改tomcat的server.xml文件
位置:apache-tomcat-7.0.73/conf/server.xml

原文件为：
![](http://img.blog.csdn.net/20161215135637535?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

修改为：

![](http://img.blog.csdn.net/20161215150014898?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

也就是加了:

```
<Context path="/" docBase="/tomcat/apache-tomcat-7.0.73/webapps/myBlog" reloadable="false" allowLinking="true"></Context>
```
path="/"，/表示的是你访问项目的时候不用加项目名。

/tomcat/apache-tomcat-7.0.73/webapps/myBlog为我的项目绝对路径。
myBlog为我的项目名。

这样就OK了。
![](http://img.blog.csdn.net/20161215150222370?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

环境为Linux-- CentOS 6.5 64位
Tomcat7
JDK7

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
