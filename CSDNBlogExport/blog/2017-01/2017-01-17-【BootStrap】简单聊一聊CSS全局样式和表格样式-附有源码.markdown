---
layout: post
title: "【BootStrap】简单聊一聊CSS全局样式和表格样式-附有源码"
date: 2017-01-17 10:47:40 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- BootStrap
tags: [bootstrap,css,源码]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】




CSS全局样式



1、布局容器类样式：.container 和 .container-fluid

.container 固定宽度并且具有响应式。
.container-fluid 自由宽度(100%宽度)。

这2个class是直接在body标签下建立一个div标签，c 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】




CSS全局样式



1、布局容器类样式：.container 和 .container-fluid

.container 固定宽度并且具有响应式。
.container-fluid 自由宽度(100%宽度)。

这2个class是直接在body标签下建立一个div标签，c
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

#CSS全局样式

##1、布局容器类样式：.container 和 .container-fluid
```
.container 固定宽度并且具有响应式。
.container-fluid 自由宽度(100%宽度)。
```
这2个class是直接在body标签下建立一个div标签，class等于这2个中的一个。
然后其他内容全部写在这个div标签中即可！
例如:

```
<!DOCTYPE html>
<html>
<head>
	<title>BootStrap基础入门</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<link rel="stylesheet" href="bootstrap3/css/bootstrap.min.css">
	
	<script type="text/javascript" src="js/jquery.slim.min.js" ></script>
	<script type="text/javascript" src="bootstrap3/js/bootstrap.min.js" ></script>
</head>
<body>
	<div class="container">
		<h1>标题H1</h1>
		<p>正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文</p>
	</div>
</body>
</html>
```

![](http://img.blog.csdn.net/20170117204421502?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

再看.container-fluid：
只修改了这里，其他地方不变
```
<div class="container-fluid">
```
![](http://img.blog.csdn.net/20170117204538190?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

也就是说，container-fluid这个是和页面两边是没有间隔的。
而container是有一定间隔的，而且左右两边的间隔相等。


##2、标题样式：`<h1>到<h6>`、.h1 ~ .h6 

`<h1>~<h6>`样式重写了，基本上做到了兼容性。
（如未加说明，则新代码是接在上面的代码后面）
下面的代码在上面代码的p标签后
```
<h1>标题H1</h1>
<font class="h1">标题H1</font>
```

![](http://img.blog.csdn.net/20170117211214000?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##3、行内文本样式：

```
<b>：加粗
<strong>加粗
<i>：斜体
<em>斜体，HTML5新标记
<del>删除线，HTML5新标记。
<s>删除线
```
这几个就不演示了，你自己简单的用一个就懂了。

##4、文本对齐样式：.text-left、.text-center、.text-right、.text-justify

```
.text-left：文本左对齐
.text-right：右对齐
.text-center：居中对齐
.text-justify：两端对齐
```

```
		<div class="text-left">左对齐:正文正正文正文正文正文正</div>
		<div class="text-right">右对齐:正文正正文正文正文正文正</div>
		<div class="text-center">居中对齐:正文正文正文正文正</div>
		<div class="text-justify">两端对齐:正正文正文正文正正</div>
```
![](http://img.blog.csdn.net/20170117212440927?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##5、列表样式：

```
.list-unstyled(无符号)：去掉前面的符号。
.list-inline(行内块)
```
![](http://img.blog.csdn.net/20170117212715319?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
普通的列表样式：首先是前面有一定的空隙，不是和文本同间隔的。
另外的就是有小圆点，当然，你可以改这个符号。

在BootStrap中，我们只需要在ul上加一个class就可以解决这个问题。

在这里，我发现BootStrap4不支持ul在一行显示，也就是添加class="list-inline"是无效的。
所以，我在这里就改用bootstrap3了。

```
<ul class="list-unstyled">
			<li>HTML</li>
			<li>Java</li>
			<li>JavaScript</li>
		</ul>
		<ul class="list-inline">
			<li>在一行</li>
			<li>HTML</li>
			<li>Java</li>
			<li>JavaScript</li>
		</ul>
```

![](http://img.blog.csdn.net/20170117220634372?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


#表格样式

##1、.table ：表格全局样式(少量padding和水平方向的分割线)。

```
			<table class="table">
				<tr>
					<td>编号</td>
					<td>新闻标题</td>
					<td>发布者</td>
					<td>发布时间</td>
				</tr>
				<tr>
					<td>001</td>
					<td>A</td>
					<td>CHX</td>
					<td>2017</td>
				</tr>
				<tr>
					<td>002</td>
					<td>B</td>
					<td>ANYI</td>
					<td>2017</td>
				</tr>
			</table>

```

![](http://img.blog.csdn.net/20170117221032502?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


##2、.table-striped：有条纹的背景色行(隔行变色)

```
<table class="table table-striped">
...
</table>
```
![](http://img.blog.csdn.net/20170117221158754?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
颜色很浅，不知道你们能不能看清。

##3、.table-bordered：带边框的表格

```
<table class="table table-striped table-bordered">
...
</table>
```

![](http://img.blog.csdn.net/20170117221315184?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


##4、.table-hover：鼠标悬停效果(放上变色、离开恢复)

```
<table class="table table-striped table-bordered table-hover">
...
</table>
```

![](http://img.blog.csdn.net/20170117221540447?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##5、.table-condensed：紧凑的表格(单元格内补会减半)

```
<table class="table table-striped table-bordered table-hover table-condensed">
...
</table>
```
![](http://img.blog.csdn.net/20170117222421876?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##6、行或单元格背景色：

注意：只能给tr或td添加类样式。

```
.active：当前样式
.success 
.info
.warning
.danger
```
success ：![](http://img.blog.csdn.net/20170117222754573?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
info：![](http://img.blog.csdn.net/20170117222904403?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
warning：![](http://img.blog.csdn.net/20170117222935395?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
danger：![](http://img.blog.csdn.net/20170117222943911?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

```
				<tr class="active">
					<td>编号</td>
					<td>新闻标题</td>
					<td>发布者</td>
					<td>发布时间</td>
				</tr>
				<tr class="success">
					<td>001</td>
					<td>A</td>
					<td>CHX</td>
					<td>2017</td>
				</tr>
				<tr class="info">
					<td>002</td>
					<td>B</td>
					<td class="warning">ANYI</td>
					<td class="danger">2017</td>
				</tr>
```

![](http://img.blog.csdn.net/20170117222651806?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##7、响应式表格： 

将.table元素包裹在.table-responsive元素内，即可创建响应式表格
当屏幕宽度小于768px时，表格会出现滚动条。
当屏幕宽度大于768px时，表格的滚动条自然消失。

也就是在table标签外再创一个div标签，div的class设置为table-responsive即可。

```
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover table-condensed">
					<tr class="active">
						<td>编号</td>
						<td>新闻标题</td>
						<td>发布者</td>
						<td>发布时间</td>
						<td>发布者</td>
						<td>发布时间</td>
						<td>发布者</td>
						<td>发布时间</td>
					</tr>
					<tr class="success">
						<td>001</td>
						<td>A</td>
						<td>CHX</td>
						<td>2017</td>
						<td>CHX</td>
						<td>2017</td>
						<td>CHX</td>
						<td>2017</td>
					</tr>
					<tr class="info">
						<td>002</td>
						<td>B</td>
						<td class="warning">ANYI</td>
						<td class="danger">2017</td>
						<td>CHX</td>
						<td>2017</td>
						<td>CHX</td>
						<td>2017</td>
					</tr>
				</table>
			</div>
```

![](http://img.blog.csdn.net/20170117223435881?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


本节源码:

https://github.com/chenhaoxiang/BootStrap/tree/master/OneDay


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
