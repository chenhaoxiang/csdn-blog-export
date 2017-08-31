---
layout: post
title: "【BootStrap】图片样式、辅助类样式和CSS组件 -附源码"
date: 2017-01-19 06:55:41 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程,----- ----- BootStrap
tags: [bootstrap,css,图片,class]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
首先把模板代码上上来:<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
首先把模板代码上上来:<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

首先把模板代码上上来:

```
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" />
		<!--判断IE9  用来支持HTML5  
		html5shiv.min.js-没有那个元素，就创建那个元素
		respond.min.js支持响应式布局的
		-->
		<!--[if lt IE 9]> 
      	<script src="js/html5shiv.min.js"></script>
      	<script src="js/respond.min.js"></script>
    	<![endif]-->
		<title>BootStrap基础入门</title>
	</head>

	<body style="background-color: #CCCCCC;">
		<div class="container" style="background-color: #FFFFFF;">
		</div>
		<script type="text/javascript" src="js/jquery.slim.min.js"></script>
		<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	</body>

</html>
```

#图片样式

.img-responsive：直接为图片添加该样式，可以实现响应式图片。
.center-block：图片居中样式，而不能使用text-center样式。
图片形状样式：.img-rounded(圆角图片)、.img-circle(圆形图片)、.img-thumbnail(边框圆角)

```
			<h2 class="page-header">图片样式应用</h2>
			<div>
				<img class="img-responsive img-thumbnail center-block" src="img/011.jpg" />
				<p>文字文字文字文字文字文字文字文字文字文字文字文字</p>
			</div>
```
![](http://img.blog.csdn.net/20170119181735579?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


#辅助类样式

文本颜色类：.text-muted(柔和的)、.text-primary、.text-success、.text-info、.text-warning、.text-danger
背景颜色类：.bg-primary、.bg-success、.bg-info、.bg-warning、.bg-danger
三角符号：<span class = “caret”></span>
快速浮动类：.pull-left(左浮动)、.pull-right(右浮动)
清除浮动：为父元素添加 .clearfix 可以清除浮动。
让内容块网页居中：<div class = “center-block”></div>

```
			<h2 class="page-header">清除浮动的应用</h2>
			<div class="clearfix" style="border: 1px solid red;width: 340px;">
				<ul class="list-unstyled">
					<li class="pull-left" style="padding: 10px;">
						<div class="text-center">
							<a href=""><img src="img/001.png" /></a><br />
							<a href="">文字1</a>
							<span class="caret"></span>
						</div>
					</li>
					<li class="pull-left" style="padding: 10px;">
						<div class="text-center">
							<a href=""><img src="img/002.png" /></a><br />
							<a href="">文字2</a>
						</div>
					</li>
					<li class="pull-left" style="padding: 10px;">
						<div class="text-center">
							<a href=""><img src="img/003.png" /></a><br />
							<a href="">文字3</a>
						</div>
					</li>
					<li class="pull-left" style="padding: 10px;">
						<div class="text-center">
							<a href=""><img src="img/004.png" /></a><br />
							<a href="">文字4</a>
						</div>
					</li>
				</ul>
			</div>
```

![](http://img.blog.csdn.net/20170119181926279?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


#CSS组件

##下拉菜单

.dropdown将下拉菜单触发器和下拉菜单包含在其中(下拉菜单父元素)。
data-toggle属性：下拉菜单触发器。取值为“dropdown”。
.dropdown-menu：给`<ul>`指定下拉菜单的样式。
.dropup：向上弹出的下拉菜单(下拉菜单父元素)。
下拉菜单对齐方式：.dropdown-menu-left和.dropdown-menu-right
.divider：为下拉菜单添加分隔线，用于将多个链接分组。
.disabled：禁用的菜单项。

```
			<h2 class="page-header">下拉菜单的应用</h2>
			<div class="dropdown">
				<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
					Java课 
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li>
						<a href="">HTML</a>
					</li>
					<li>
						<a href="">CSS</a>
					</li>
					<li>
						<a href="">Java</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="">Maven</a>
					</li>
					<li>
						<a href="">MySQL</a>
					</li>
					<li>
						<a href="">Spring</a>
					</li>
				</ul>
			</div>
```

![](http://img.blog.csdn.net/20170119182058186?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


##按钮组

.btn-group：按钮组(可以实现将一组按钮放在同一行)。
.btn-toolbar：按钮组工具栏(将多个按钮组放在其中)。
按钮组的尺寸：.btn-group-lg、.btn-group-sm、.btn-group-xs
.btn-group-vertical：垂直排列的按钮组。

```
			<h2 class="page-header">按钮组的应用</h2>
			<div class="btn-toolbar">
				<div class="btn-group btn-group-lg ">
					<button type="button" class="btn btn-default">按钮一</button>
					<button type="button" class="btn btn-default">按钮二</button>
					<button type="button" class="btn btn-default">按钮三</button>
					<button type="button" class="btn btn-default">按钮四</button>
					<button type="button" class="btn btn-default">按钮五</button>
				</div>
				<div class="btn-group">
					<button type="button" class="btn btn-danger">按钮一</button>
					<button type="button" class="btn btn-danger">按钮二</button>
				</div>
				<div class="btn-group btn-group-sm">
					<button type="button" class="btn btn-primary">按钮一</button>
					<button type="button" class="btn btn-primary">按钮二</button>
				</div>
				<div class="btn-group btn-group-xs btn-group-vertical">
					<button type="button" class="btn btn-success">按钮一</button>
					<button type="button" class="btn btn-success">按钮二</button>
					<button type="button" class="btn btn-success">按钮三</button>
				</div>
			</div>

```

![](http://img.blog.csdn.net/20170119182258858?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


##按钮式下拉菜单

```
			<h2 class="page-header">按钮式下拉菜单的应用</h2>
			<div class="btn-group dropup">
				<button type="button" class="btn btn-danger" data-toggle="dropdown">
            		按钮 
            		<span class="caret"></span>
            	</button>
				<ul class="dropdown-menu" style="overflow: auto;height: 100px;">
					<li>
						<a href="">按钮</a>
					</li>
					<li>
						<a href="">按钮</a>
					</li>
					<li>
						<a href="">按钮</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="">按钮</a>
					</li>
					<li>
						<a href="">按钮</a>
					</li>
					<li>
						<a href="">按钮</a>
					</li>
					<li>
						<a href="">按钮1</a>
					</li>
					<li>
						<a href="">按钮1</a>
					</li>
					<li>
						<a href="">按钮3</a>
					</li>
					<li>
						<a href="">按钮2</a>
					</li>
				</ul>
				<button type="button" class="btn btn-danger">
            		按钮 
            	</button>
			</div>
			<div class="btn-group dropup">
				<button type="button" class="btn btn-default">
            		按钮 
            	</button>
				<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
            		<span class="caret"></span>
            	</button>
				<ul class="dropdown-menu">
					<li>
						<a href="">按钮</a>
					</li>
					<li>
						<a href="">按钮</a>
					</li>
					<li>
						<a href="">按钮</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="">按钮</a>
					</li>
				</ul>
			</div>

```

![](http://img.blog.csdn.net/20170119182832752?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

在这里呢，如果我们下拉菜单很多，就可以用滚动条来解决！
用overflow: auto;，然后定义一个高度就好。

##输入框组

.input-group：只能用于文本框`<input>`，不能用于`<select>`和`<textarea>`。
.input-group-addon用于在`<input>`前后添加额外元素，赋给一个`<span>`元素即可。
注意：将.input-group-addon和`<input>`元素包在.input-group之中。
.input-group-lg 和 .input-group-sm 可以改变输入框组的尺寸。
.input-group-btn可以作为额外元素的按钮，应该是作为`<button>`的父元素。

```
			<h2 class="page-header">输入框组的应用</h2>
			<div class="input-group">
				<span class="input-group-addon">$</span>
				<input type="text" class="form-control" placeholder="username" />
				<span class="input-group-addon">.00</span>
			</div>
			<div class="input-group">
				<span class="input-group-btn">
            		<button class="btn btn-default">Go!</button>
            	</span>
				<input type="text" class="form-control" placeholder="username" />
			</div>
			<div class="input-group">
				<div class="input-group-btn">
					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Action <span class="caret"></span></button>
					<ul class="dropdown-menu" role="menu">
						<li>
							<a href="#">Action</a>
						</li>
						<li>
							<a href="#">Another action</a>
						</li>
						<li>
							<a href="#">Something else here</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="#">Separated link</a>
						</li>
					</ul>
				</div>
				<!-- /btn-group -->
				<input type="text" class="form-control">
			</div>
			<!-- /input-group -->
			<div class="input-group">
				<div class="input-group-btn">
					<button type="button" class="btn btn-default">
            		按钮 
            	</button>
					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
            		<span class="caret"></span>
            	</button>
					<ul class="dropdown-menu">
						<li>
							<a href="">按钮</a>
						</li>
						<li>
							<a href="">按钮</a>
						</li>
						<li>
							<a href="">按钮</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="">按钮</a>
						</li>
					</ul>
				</div>
				<input type="text" class="form-control">
			</div>

```

![](http://img.blog.csdn.net/20170119183139381?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##标签页(选项卡)

.nav是标签页的基类
.nav-tabs是标签页类样式
.active是标签页的状态类(当前样式)
.nav-pills胶囊式标签页
.nav-stacked胶囊式标签页堆放排列(垂直排列)

```
			<h2 class="page-header">选项卡效果</h2>
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active">
					<a href="#">Home</a>
				</li>
				<li role="presentation">
					<a href="#">Profile</a>
				</li>
				<li role="presentation">
					<a href="#">Messages</a>
				</li>
			</ul>
			<ul class="nav nav-pills" role="tablist">
				<li role="presentation" class="active">
					<a href="#">Home</a>
				</li>
				<li role="presentation">
					<a href="#">Profile</a>
				</li>
				<li role="presentation">
					<a href="#">Messages</a>
				</li>
			</ul>
```

![](http://img.blog.csdn.net/20170119183240723?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


##路径导航

.breadcrumb：赋给<ol>可以实现面包屑效果。
.active赋给当前栏目，当前栏目不加链接。


```
			<h2 class="page-header">路径导航效果</h2>
			<ol class="breadcrumb">
				<li>
					<a href="#">Home</a>
				</li>
				<li>
					<a href="#">Library</a>
				</li>
				<li class="active">Data</li>
			</ol>

```

![](http://img.blog.csdn.net/20170119183417776?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##分页

.pagination赋给<ul>元素可以实现分页效果
`&laquo;` 上一页
`&raquo;` 下一页
.disabled禁用状态
.active激活状态
.pagination-lg分页大尺寸
.pagination-sm分页小尺寸
.pager可以实现翻页效果。上一页、下一页效果。

```
			<div class="text-center" style="border: 1px solid red;">
				<ul class="pagination pagination-lg pager">
					<li class="previous">
						<a href="#">&larr; 上一页</a>
					</li>
					<li class="disabled">
						<a href="">&laquo;</a>
					</li>
					<li class="active">
						<a href="">1</a>
					</li>
					<li>
						<a href="">2</a>
					</li>
					<li>
						<a href="">3</a>
					</li>
					<li>
						<a href="">4</a>
					</li>
					<li>
						<a href="">5</a>
					</li>
					<li>
						<a href="">6</a>
					</li>
					<li>
						<a href="">7</a>
					</li>
					<li>
						<a href="">8</a>
					</li>
					<li>
						<a href="">9</a>
					</li>
					<li>
						<a href="">10</a>
					</li>
					<li>
						<a href="">&raquo;</a>
					</li>
					<li class="next">
						<a href="#">下一页 &rarr;</a>
					</li>
				</ul>
			</div>
			<div class="text-center" style="border: 1px solid red;">
				<ul class="pagination pagination-lg">
					<li>
						<a href="">&laquo;</a>
					</li>
					<li class="active">
						<a href="">1</a>
					</li>
					<li>
						<a href="">2</a>
					</li>
					<li>
						<a href="">3</a>
					</li>
					<li>
						<a href="">4</a>
					</li>
					<li>
						<a href="">5</a>
					</li>
					<li>
						<a href="">6</a>
					</li>
					<li>
						<a href="">7</a>
					</li>
					<li>
						<a href="">8</a>
					</li>
					<li>
						<a href="">9</a>
					</li>
					<li>
						<a href="">10</a>
					</li>
					<li>
						<a href="">&raquo;</a>
					</li>
				</ul>
			</div>
```

![](http://img.blog.csdn.net/20170119183913284?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##缩略图

.thumbnail赋给`<a>`元素，可以实现缩略图样式。
.caption 可以实现缩略图标题及描述

```
			<h2 class="page-header">缩略图效果</h2>
			<div class="row">
				<div class="col-md-2">
					<a href="" class="thumbnail"><img src="img/001.png" /></a>
					<div class="caption">
						<h4>图片一</h4>
					</div>
				</div>
				<div class="col-md-4">
					<a href="" class="thumbnail"><img src="img/001.png" /></a>
					<div class="caption">
						<h4>图片一</h4>
					</div>
				</div>
				<div class="col-md-6">
					<a href="" class="thumbnail"><img src="img/001.png" /></a>
					<div class="caption">
						<h4>图片一</h4>
					</div>
				</div>
			</div>

```

![](http://img.blog.csdn.net/20170119184221524?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


##导航栏

导航栏有一个不同，他不是写在container包含层里面了，而是那个div的上面！

.navbar：导航栏的基类，用于`<nav>`元素。
.navbar-default：导航栏默认样式，用于`<nav>`元素。
.container是`<nav>`的子元素。导航栏内容都放入其中。
.navbar-header：导航栏头部样式。
.navbar-brand：设置品牌图标样式
.collapse是折叠导航栏的样式的基类。
.navbar-collapse是折叠导航栏样式。
.nav是导航栏的链接基类。
.navbar-nav是导航栏的链接样式。
.navbar-from：导航栏表单，可以使表单元素排在同一行。
.navbar-left 或 .navbar-right ：组件排列。导航链接、表单、按钮或文本对齐。
.navbar-btn：对于不在`<form>`中的`<button>`元素，实现垂直对齐。
.navbar-text：对于导航栏的普通文本有了行距和颜色，通常用于`<p>`元素。
.navbar-fixed-top：导航栏固定在顶部，用于`<nav>`元素。需要为`<body>`设置padding-top:70px
.navbar-fixed-bottom：导航栏固定在底部，用于`<nav>`元素。需要为`<body>`设置padding-bottom:70px;
.navbar-static-top：导航栏静止在顶部，用于`<nav>`元素。会随着滚动条移动而消失。
.navbar-inverse：可以实现反色导航栏，用于`<nav>`元素。


```
<nav class="navbar navbar-default navbar-static-top">
			<!--导航栏头部信息-->
			<div class="container">
				<!--品牌信息-->
				<div class="navbar-header">
					<a class="navbar-brand" href="">Brand</a>
					<p class="navbar-text">欢迎光临</p>
				</div>

				<!--导航栏主链接-->
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-left">
						<li class="active">
							<a href="">起步</a>
						</li>
						<li>
							<a href="">CSS全局样式</a>
						</li>
						<li>
							<a href="">组件</a>
						</li>
						<li>
							<a href="">插件</a>
						</li>
						<li>
							<a href="">网站案例</a>
						</li>
					</ul>
					<!--表单 搜索框-->
					<form class="navbar-form navbar-left">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="搜索">
						</div>
						<button type="submit" class="btn btn-default">搜索</button>
					</form>

					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="">Link</a>
						</li>
						<li class="dropdown">
							<a href="" class="dropdown-toggle" data-toggle="dropdown">
								Dropdown 
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Action</a>
								</li>
								<li>
									<a href="#">Another action</a>
								</li>
								<li>
									<a href="#">Something else here</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="#">Separated link</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="container" style="background-color: #FFFFFF;">
		...
		</div>
```

![](http://img.blog.csdn.net/20170119184611214?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


好了，然后直接上完整的源码:

#完整的源码链接:

https://github.com/chenhaoxiang/BootStrap/tree/master/day3


像学后台的，把这个BootStrap学到这里，然后能灵活应用基本就差不多啦~~~
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
