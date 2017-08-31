---
layout: post
title: "【PHP】Window7环境下配置PHP7+Apache2.4 环境"
date: 2016-11-09 04:15:45 +0800
comments: true
categories:❹ PHP
tags: [apache,php]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天第一次接触PHP，配置这个环境也是搞了一个多小时。 
买的PHP的这本书，上面的环境配置有些老了，Apache还是2.2的版本配置。 
果断抛弃书本，然后谷歌文档学习。现在成功在电脑上配置好了PHP环境。首先讲一下电脑环境与版本: 
电脑:window7-X64 
Apache:h 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天第一次接触PHP，配置这个环境也是搞了一个多小时。 
买的PHP的这本书，上面的环境配置有些老了，Apache还是2.2的版本配置。 
果断抛弃书本，然后谷歌文档学习。现在成功在电脑上配置好了PHP环境。首先讲一下电脑环境与版本: 
电脑:window7-X64 
Apache:h
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

今天第一次接触PHP，配置这个环境也是搞了一个多小时。
买的PHP的这本书，上面的环境配置有些老了，Apache还是2.2的版本配置。
果断抛弃书本，然后谷歌文档学习。

现在成功在电脑上配置好了PHP环境。

首先讲一下电脑环境与版本:
电脑:window7-X64
Apache:httpd-2.4.23-win64-VC14
PHP:7.0.12-Win32-VC14-x64
电脑32位系统的请下载X84的。

#下载PHP7和Apache2.4


##首先当然是下载对应的安装包：


PHP:
http://windows.php.net/download/
下载的版本号是:VC14 x64 Thread Safe

![](http://img.blog.csdn.net/20161109035452584)

因为它是VC14编译的，这意味着需要安装VC2015(即vc14)运行时环境，同时需要Apache2.4才可以运行PHP7。

VC2015:
http://www.microsoft.com/zh-cn/download/details.aspx?id=48145

![](http://img.blog.csdn.net/20161109035631147)

然后选择电脑对应的版本号就好。
32位系统选择X84的。
64位系统选择X64的。
然后安装VC2015，安装成功后需要重启电脑哦、


Apache:
http://www.apachelounge.com/download/
下载的版本号是:httpd-2.4.23-win64-VC14

![](http://img.blog.csdn.net/20161109035406068)

接下来就是将安装包解压了:
我解压的路径是:
PHP7为:
**H:\server\php7**

![](http://img.blog.csdn.net/20161109035912633)

Apache为:
**H:\server\Apache24**

![](http://img.blog.csdn.net/20161109035953243)

存放php网站脚本的目录
**H:\server\phpCode**

![](http://img.blog.csdn.net/20161109040401041)



#配置httpd.conf和php.ini ：

##httpd.conf


打开Apache24/conf/httpd.conf
修改：ServerRoot "H:/server/Apache24"
修改：DocumentRoot "H:/server/phpCode"

![](http://img.blog.csdn.net/20161109040554136)

修改：ServerName 127.0.0.1:80

![](http://img.blog.csdn.net/20161109040741035)

添加:
PHPIniDir "H:/server/php7"
AddType application/x-httpd-php .php .html .htm
LoadModule php7_module "H:/server/php7/php7apache2_4.dll"

![](http://img.blog.csdn.net/20161109040654668)

##配置php.ini


打开php目录，复制php.ini-development ，重命名为php.ini。
打开php.ini.

###修改扩展文件的存放目录：
找到: 
 ;extension_dir = "ext"
修改为: 
extension_dir = "H:/server/php7/ext"
也就是改为扩展文件的实际存放位置。

###修改当前时区:
找到: 
 ;date.timezone =
修改为: 
date.timezone =Asia/Shanghai
所支持的时区列表:
http://php.net/manual/zh/timezones.php

###设置PHP支持的动态模块
找到"Windows Extensions"
在其下面找到需要的模块，去掉前面的";"。如下，打开了一些常用的动态模块：
```
extension=php_curl.dll
extension=php_gd2.dll
extension=php_mbstring.dll
extension=php_mysqli.dll
extension=php_openssl.dll
extension=php_pdo_mysql.dll
extension=php_sockets.dll
```

![](http://img.blog.csdn.net/20161109045654835)

###配置Session功能
不配置则无法使用Session.
首先需要建立一个可读写的文件夹，一般建在php文件夹中，
如建立目录:"H:\server\php7\sessiontmp"
在配置php.ini找到:
;session.save_path = "/tmp"
修改为:
session.save_path = "H:/server/php7/sessiontmp"

###配置PHP的文件上传功能。
网站为了能使用PHP文件上传功能，需要指定一个临时文件夹，否则文件上传时会失败。
首先需要建立一个可读写的文件夹，一般建在php文件夹中，
如建立目录:"H:\server\php7\uploadtmp"
在配置php.ini找到:
;upload_tmp_dir =
修改为:
upload_tmp_dir ="H:/server/php7/uploadtmp"

同时，可以修改上传单个文件的大小限制：
在配置php.ini找到:
upload_max_filesize = 2M
修改为:
upload_max_filesize = 20M

也就是允许上传文件的最大值为20MB。

把Apache24加入windows服务，并启动Apache
------------------------------

cmd命令行，进入h盘，

cd   H:\server\Apache24\bin
httpd –k install
httpd –k start

这样就启动成功了。

在H:\server\phpCode创建helloWorld.php文件
文件中写:
```
<?php echo 'Hello World!'; ?>
```
浏览器访问:
http://127.0.0.1/helloWorld.php
查看实际运行效果。
![](http://img.blog.csdn.net/20161109041427484)


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
