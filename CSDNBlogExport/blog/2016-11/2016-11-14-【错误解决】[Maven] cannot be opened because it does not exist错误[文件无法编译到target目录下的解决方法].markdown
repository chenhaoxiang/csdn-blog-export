---
layout: post
title: "【错误解决】[Maven] cannot be opened because it does not exist错误[文件无法编译到target目录下的解决方法]"
date: 2016-11-14 10:08:52 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,❻ 其他,----- 上网技巧/问题解决
tags: [path,idea,class,maven]
keyword: 陈浩翔, 谙忆
description: 使用IDEA搭建的Maven项目，在写SpringEL和资源调用时出现了如下错误:
相信我，代码没问题的、
Caused by: java.io.FileNotFoundException: class path resource [cn/hncu/p2_2_2SpringEL/test.properties] cannot be opened because it does not exist 
---


使用IDEA搭建的Maven项目，在写SpringEL和资源调用时出现了如下错误:
相信我，代码没问题的、
Caused by: java.io.FileNotFoundException: class path resource [cn/hncu/p2_2_2SpringEL/test.properties] cannot be opened because it does not exist
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

使用IDEA搭建的Maven项目，在写SpringEL和资源调用时出现了如下错误:
相信我，代码没问题的、
```
Caused by: java.io.FileNotFoundException: class path resource [cn/hncu/p2_2_2SpringEL/test.properties] cannot be opened because it does not exist
```
![](http://img.blog.csdn.net/20161114092449245)

文件无法找到，后来在csdn论坛提问后才知道。

因为IDEA有个配置项，默认只把.class的文件放到编译目录中，也就是target目录。

后来我去看了target目录下，确实没有那文件。
![](http://img.blog.csdn.net/20161114092611652)

我的Java目录下是有的：

![](http://img.blog.csdn.net/20161114092651527)

找到了问题所在，就好办了.

开始我想重新去改一下IDEA的配置。但是没找到怎么改。

现在先说下用代码配置、
原因是： idea不会编译src的java目录的除Java外的文件

解决办法:
```
将IDEA maven项目中src源代码下的资源文件编译进target目录classes文件夹
具体操作方法就是：配置maven的pom文件配置，在<build>节点下添加<resources>代码：
```
也就是:
```
<build>
		<resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.*</include>
                </includes>
                <excludes>
                    <exclude>**/*.java</exclude>
                </excludes>
            </resource>
        </resources>
</build>
```

这样就是把除.java外的src下的文件，自动编译到target目录classes文件夹下！

问题解决！

因为是刚用IDEA，也不知道怎么去IDEA配置编译其他文件到target目录，也不知道是不是IDEA不支持自动拷贝其他类型的文件到target目录。

![](http://img.blog.csdn.net/20161114100416918)

如果有朋友知道，望在评论区解答，谢谢。

Eclipse是在build path里配置的:

![](http://img.blog.csdn.net/20161114100502410)

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
