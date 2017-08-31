---
layout: post
title: "【系统】[Linux]CentOS 7之安装篇-详解"
date: 2016-09-13 06:49:21 +0800
comments: true
categories:❻ 其他,----- Linux/Unix
tags: [centos,linux,u盘]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


在上篇完成U盘系统盘的刻录后，接下来就是在电脑上安装CentOS7系统了。

在这里，我电脑的品牌是lenovo的。具体型号我也不知道了。

我是在开机的时候按F12进入”启动设备菜单”，选着U盘启动。 
PS:不同的电脑，选择过程可能不同。有的可能还需要进入BOIS中去设置。( 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


在上篇完成U盘系统盘的刻录后，接下来就是在电脑上安装CentOS7系统了。

在这里，我电脑的品牌是lenovo的。具体型号我也不知道了。

我是在开机的时候按F12进入”启动设备菜单”，选着U盘启动。 
PS:不同的电脑，选择过程可能不同。有的可能还需要进入BOIS中去设置。(
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

在上篇完成U盘系统盘的刻录后，接下来就是在电脑上安装CentOS7系统了。
<blockquote cite='陈浩翔'>
<strong>【<a href='http://blog.csdn.net/qq_26525215/article/details/52527833' target='_blank'>U盘系统盘的刻录</a>】</strong></p>
</blockquote>

在这里，我电脑的品牌是lenovo的。具体型号我也不知道了。

把U盘插入电脑USB接口，我是在开机的时候按F12进入"启动设备菜单"，选择U盘启动。

PS:不同的电脑，选择过程可能不同。有的可能还需要进入BOIS中去设置。(如不会，请自行根据电脑品牌百度)

![](http://img.blog.csdn.net/20160913175648405)

然后会进入如下页面:

![](http://img.blog.csdn.net/20160913175908213)
界面说明：
```
Install CentOS 7   安装CentOS 7
Test this media & install CentOS  7   测试安装文件并安装CentOS  7
Troubleshooting 修复故障
```
这里选择第一项，安装CentOS  7，回车，进入下一个界面

在这个页面不需要你去操作什么。直到下一个页面出现。

![](http://img.blog.csdn.net/20160913180023047)

也就是出现安装过程中语言的选择：

![](http://img.blog.csdn.net/20160913180128841)

我们当然是选择中文啦。

![](http://img.blog.csdn.net/20160913180158076)

首先选择安装源：

![](http://img.blog.csdn.net/20160913180316330)

如果有多个安装版本就需要看一下选择的是哪个系统镜像，这里我们只有一个，随便点上哪个都行。

![](http://img.blog.csdn.net/20160913180410939)

再点左上角的完成，返回到主界面，选择"软件选择"，点进去。

![](http://img.blog.csdn.net/20160913180547425)

这里的话，按照你的需要去选择吧，但是，注意哦，要选择带有图形界面的哦。否则系统总个都是黑白代码，看晕死你。

![](http://img.blog.csdn.net/20160913180710628)

点完成后。
接下来选择的是"安装位置"：

![](http://img.blog.csdn.net/20160913180903305)

进入之后:

![](http://img.blog.csdn.net/20160913181339561)
选中硬盘，再选中，我要配置分区。最后点左上角完成。

然后会出现一个页面，进行分区。

![](http://img.blog.csdn.net/20160913181646321)

如果在中途遇到空间不足，
(对于只会安装CentOS系统的解决方法-单系统)：
在这里，教大家一个解决办法。
/*
没出现的可以忽略，这是由于:"MBR模式下，一个硬盘最多只能有4个主分区，多了就不能建，就算是有空闲空间也不行，/boot文件系统必须单独分区，才能正常启动，其余的可以建在LVM的文件系统上合理安排一下自己的硬盘分区"


右下角有一个全部重设，点击，再回到主页面。

再点击进入"安装位置"：

这次选择自动分区，钩上我想让额外空间可用、再点击完成，
这个时候会出现：

![](http://img.blog.csdn.net/20160913182146104)

选择你需要删除的分区，注意，一旦删除，数据会丢失。
删除空间直到你理想中的大小。点击回收全部。
*/

然后点击完成，回到主页面，再进入安装源，这次我们选择"我要配置分区"。点完成，会进入如下界面：

![](http://img.blog.csdn.net/20160913182830357)
可以看到，硬盘的可用空间已经变成465.76GiB。

对于分区方案，我们选择标准分区就可以了。

![](http://img.blog.csdn.net/20160913182944379)

点击左下角的+号，出现如下对话框。
挂载点：swap
期望容量：4096

![](http://img.blog.csdn.net/20160913183050521)

大小的话，不写单位，默认是MB。

具体值，看你电脑的配置，一般写你电脑的2倍内存大小。

继续点左下角的“+”号
挂载点：/
期望容量：#  (剩余所有空间)
点击添加挂载点，如下图所示

![](http://img.blog.csdn.net/20160913183342274)


然后:看到如下图

![](http://img.blog.csdn.net/20160913183439078)

点左上角的“完成”，进入下面的界面:
（界面里面的摘要会有不同）
![](http://img.blog.csdn.net/20160913183542923)

点击接受更改，进入如下界面:

![](http://img.blog.csdn.net/20160913183643017)

点击右下角的开始安装:

进入下面的界面：

![](http://img.blog.csdn.net/20160913183950078)

然后选择-用户设置-ROOT密码，进入下面的界面

![](http://img.blog.csdn.net/20160913184101783)

设置好密码后点击完成，你也可以去创建用户。

然后耐心等待、、、

![](http://img.blog.csdn.net/20160913184212551)

完成之后，点击重启。


基本上就到这里就已经是CentOS7安装完成了。

至于安装完成后，可能会出现的一个问题(BUG)，在一篇博客中提出解决方案。


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
