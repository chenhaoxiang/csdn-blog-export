---
layout: post
title: "【问题解决】BootStrap.css与layDate日期选择样式起冲突的解决办法"
date: 2017-04-06 06:48:18 +0800
comments: true
categories:❷ Java大学之行,❻ 其他,----- 上网技巧/问题解决
tags: [firefox,博客]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
 
问题如图: 
给大家看下正常的layDate年份选择图片: 
一开始想到的，以为是自己没有将layer.css导入，或者layDate.css没有导入，出现的这个问题，结果发现只要导入layer.css，会自动导入layDate.css的，所以问题不在这里。然后通过火狐浏览器去查 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
 
问题如图: 
给大家看下正常的layDate年份选择图片: 
一开始想到的，以为是自己没有将layer.css导入，或者layDate.css没有导入，出现的这个问题，结果发现只要导入layer.css，会自动导入layDate.css的，所以问题不在这里。然后通过火狐浏览器去查
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

问题如图:
![](http://img.blog.csdn.net/20170406180108259?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

给大家看下正常的layDate年份选择图片:
![](http://img.blog.csdn.net/20170406180153307?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

一开始想到的，以为是自己没有将layer.css导入，或者layDate.css没有导入，出现的这个问题，结果发现只要导入layer.css，会自动导入layDate.css的，所以问题不在这里。

![](http://img.blog.csdn.net/20170406180421639?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

然后通过火狐浏览器去查看样式，结果问题出在了BootStrap.css上

![](http://img.blog.csdn.net/20170406180603226?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

` * {box-sizing:border-box;}`重置了浏览器的盒子模型。

在网上搜索了一会，发现很多博客的解决办法是这样的：

是加上以下样式:
```
     .laydate_box, .laydate_box * {
          box-sizing:content-box;
    }
```
    另外，由于input的样式不一样，导致输入框大小不一致，可以加上下面的样式兼容：
```
    input.laydate-icon,div.laydate-icon{
    	display: block;
    	width: 100%;
    	height: 34px;
    	padding: 6px 12px;
    	font-size: 14px;
    	line-height: 1.42857143;
    	color: #555;
    	border: 1px solid #ccc;
    	border-radius: 4px;
    	-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    	box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    	-webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
    	-o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
    	transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
    }
    div.laydate-icon{
    	text-align: left;
    }
```

经过本人的实践证明，会出现这样的情况:
![](http://img.blog.csdn.net/20170406181136056?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

年份选择下拉时，会覆盖月份选择。所以这个解决办法解决了之前的那个问题，但是出来了新的问题，所以抛弃。

换一种思路，为什么不能将ul中的li强制在一行呢，或者说限制一下ul的高度呢，又因为宽度的原因，超过宽度的li自然会去下一行。

所以可以这样来解决这个问题：
![](http://img.blog.csdn.net/20170406181443374?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast) 

只加了一个样式，强制li在一行 。
```
inline-size: inherit;
```

完整的代码是:

```
/*为了解决BootStrap中css和layDate的css样式冲突*/
.laydate_body .laydate_y .laydate_yms ul {
	inline-size: inherit;
}
```

你加入到你的css中就可以解决这个问题了。
貌似这个css样式还处于实验期，我测试了一下，在火狐52.0.1 (32 位)是可以的，但是其他的浏览器还不支持~

所以这个也让我抛弃了，最后尝试了调整一下li的宽度，结果成功了。

原来的li样式是这样的:
![](http://img.blog.csdn.net/20170406183600216?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

我将这个宽度改成59px，结果就成功的分成了2列。

![](http://img.blog.csdn.net/20170406184045223?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
将此处改为59px即可。

但是这样不太好，修改了layDate的源代码(你如果在其他地方添加li的宽度，无法成功)，我就想，可不可以去修改ul的宽度呢。

结果又通过调试发现了如下两种解决办法:
一：
在你的其他的css中添加如下代码，设置ul的宽度，至于为什么是120px，这是因为li的宽度是60px。
```
/*为了解决BootStrap中css和layDate的css样式冲突*/
.laydate_body .laydate_y .laydate_yms ul{
	width: 120px;
}
```

二：
在你的其他的css中添加如下代码，设置ul的宽度继承父类元素的宽度，在这里，ul父类是div，它的宽度是121px。其实也就是相当与设置宽度为121px
```
/*为了解决BootStrap中css和layDate的css样式冲突*/
.laydate_body .laydate_y .laydate_yms ul{
	width: inherit;
}
```

这两种解决办法是我目前实践的最好的解决办法了。


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
