---
layout: post
title: "【BootStrap】栅格系统、表单样式与按钮样式-附有源码"
date: 2017-01-18 09:03:08 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- BootStrap
tags: [bootstrap,表单,移动设备,响应式]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
栅格系统1、栅格系统介绍Bootstrap 提供了一套响应式、移动设备优先的流式栅格系统，随着屏幕或视口（viewport）尺寸的增加，系统会自动分为最多12列。Bootstrap的栅格系统，由一个行(.row)和多个列构成。栅格系统用于通过一系列的行（row）与列（column）的组 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
栅格系统1、栅格系统介绍Bootstrap 提供了一套响应式、移动设备优先的流式栅格系统，随着屏幕或视口（viewport）尺寸的增加，系统会自动分为最多12列。Bootstrap的栅格系统，由一个行(.row)和多个列构成。栅格系统用于通过一系列的行（row）与列（column）的组
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

#栅格系统
##1、栅格系统介绍

Bootstrap 提供了一套响应式、移动设备优先的流式栅格系统，随着屏幕或视口（viewport）尺寸的增加，系统会自动分为最多12列。

Bootstrap的栅格系统，由一个行(.row)和多个列构成。

栅格系统用于通过一系列的行（row）与列（column）的组合来创建页面布局，你的内容就可以放入这些创建好的网页布局中。具体的数据(文字、图片等都可以)放入列当中。

注意：栅格系统，必须放在.container（固定宽度）或.container-fluid（100% 宽度）中，以便为其赋予合适的排列（aligment）和内补（padding）。

如果一“行（row）”中包含了的“列（column）”大于 12，多余的“列（column）”所在的元素将被作为一个整体另起一行排列。

##2、栅格系统参数

![](http://img.blog.csdn.net/20170118200605929?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##实例：从堆叠到水平排列

使用单一的一组 .col-md-* 栅格类，就可以创建一个基本的栅格系统，在手机和平板设备上一开始是堆叠在一起的（超小屏幕到小屏幕这一范围），在桌面（中等）屏幕设备上变为水平排列。所有“列（column）必须放在 ” .row 内。

```
<div class="row">
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
</div>
<div class="row">
  <div class="col-md-8">.col-md-8</div>
  <div class="col-md-4">.col-md-4</div>
</div>
<div class="row">
  <div class="col-md-4">.col-md-4</div>
  <div class="col-md-4">.col-md-4</div>
  <div class="col-md-4">.col-md-4</div>
</div>
<div class="row">
  <div class="col-md-6">.col-md-6</div>
  <div class="col-md-6">.col-md-6</div>
</div>
```

![](http://img.blog.csdn.net/20170118200731775?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##实例：移动设备和桌面屏幕

是否不希望在小屏幕设备上所有列都堆叠在一起？那就使用针对超小屏幕和中等屏幕设备所定义的类吧，即 .col-xs-* 和 .col-md-*。请看下面的实例，研究一下这些是如何工作的。

```
<!-- Stack the columns on mobile by making one full-width and the other half-width -->
<div class="row">
  <div class="col-xs-12 col-md-8">.col-xs-12 .col-md-8</div>
  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
</div>

<!-- Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop -->
<div class="row">
  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
</div>

<!-- Columns are always 50% wide, on mobile and desktop -->
<div class="row">
  <div class="col-xs-6">.col-xs-6</div>
  <div class="col-xs-6">.col-xs-6</div>
</div>

```
![](http://img.blog.csdn.net/20170118201001636?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


##实例：手机、平板、桌面

在上面案例的基础上，通过使用针对平板设备的 .col-sm-* 类，我们来创建更加动态和强大的布局吧。

```
<div class="row">
  <div class="col-xs-12 col-sm-6 col-md-8">.col-xs-12 .col-sm-6 .col-md-8</div>
  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
</div>
<div class="row">
  <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
  <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
  <!-- Optional: clear the XS cols if their content doesn't match in height -->
  <div class="clearfix visible-xs-block"></div>
  <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
</div>

```

![](http://img.blog.csdn.net/20170118201157777?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##实例：多余的列（column）将另起一行排列

如果在一个 .row 内包含的列（column）大于12个，包含多余列（column）的元素将作为一个整体单元被另起一行排列。

```
<div class="row">
  <div class="col-xs-9">.col-xs-9</div>
  <div class="col-xs-4">.col-xs-4<br>Since 9 + 4 = 13 &gt; 12, this 4-column-wide div gets wrapped onto a new line as one contiguous unit.</div>
  <div class="col-xs-6">.col-xs-6<br>Subsequent columns continue along the new line.</div>
</div>

```

![](http://img.blog.csdn.net/20170118201240559?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


##列偏移

使用 .col-md-offset-* 类可以将列向右侧偏移。这些类实际是通过使用 * 选择器为当前元素增加了左侧的边距（margin）。例如，.col-md-offset-4 类将 .col-md-4 元素向右侧偏移了4个列（column）的宽度。

```
<div class="row">
  <div class="col-md-4">.col-md-4</div>
  <div class="col-md-4 col-md-offset-4">.col-md-4 .col-md-offset-4</div>
</div>
<div class="row">
  <div class="col-md-3 col-md-offset-3">.col-md-3 .col-md-offset-3</div>
  <div class="col-md-3 col-md-offset-3">.col-md-3 .col-md-offset-3</div>
</div>
<div class="row">
  <div class="col-md-6 col-md-offset-3">.col-md-6 .col-md-offset-3</div>
</div>

```

![](http://img.blog.csdn.net/20170118201906180?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##嵌套列
列嵌套：就是在某个栏中，再嵌套一个完整的栅格系统。

为了使用内置的栅格系统将内容再次嵌套，可以通过添加一个新的 .row 元素和一系列 .col-sm-* 元素到已经存在的 .col-sm-* 元素内。被嵌套的行（row）所包含的列（column）的个数不能超过12（其实，没有要求你必须占满12列）。
![](http://img.blog.csdn.net/20170118202733035?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
```
<div class="row">
  <div class="col-sm-9">
    Level 1: .col-sm-9
    <div class="row">
      <div class="col-xs-8 col-sm-6">
        Level 2: .col-xs-8 .col-sm-6
      </div>
      <div class="col-xs-4 col-sm-6">
        Level 2: .col-xs-4 .col-sm-6
      </div>
    </div>
  </div>
</div>

```

![](http://img.blog.csdn.net/20170118202017494?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


##列排序

通过使用 .col-md-push-* 和 .col-md-pull-* 类就可以很容易的改变列（column）的顺序。
.col-md-push-n 向右移n列！
 .col-md-pull-n 向左移n列！
 注意！！！这个是绝对定位，也就是其他列不动！这个列会和其他列重叠！
```
<div class="row">
  <div class="col-md-9 col-md-push-3">.col-md-9 .col-md-push-3</div>
  <div class="col-md-3 col-md-pull-9">.col-md-3 .col-md-pull-9</div>
</div>

```

![](http://img.blog.csdn.net/20170118202054718?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##看一个完整的实例:

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
			<div class="row">
				<div class="col-md-4" style="border: 1px solid #D9534F;">
					应中国共产党中央委员会总书记中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				</div>
				<div class="col-md-4" style="border: 1px solid #D9534F;">
					应中国共产党国中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				</div>
				<div class="col-md-4" style="border: 1px solid #D9534F;">
					应中国共产党中央委员会总书记、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				</div>
			</div>

			<div class="row">
				<div class="col-md-8" style="border: 1px solid #D9534F;">
					应中国共产党中央委员会总书记中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				</div>
				<div class="col-md-4" style="border: 1px solid #D9534F;">
					应中国共产党中央委员会总书记、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				</div>
			</div>

			<div class="row">
				<div class="col-md-9" style="border: 1px solid #D9534F;">
					应中国共产党中央委员会总书记中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				</div>
				<div class="col-md-6" style="border: 1px solid #D9534F;">
					应中国共产党中央委员会总书记、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				</div>
			</div>
			<!-- --           	
				作者：chenhaoxiang@chaojijuhui.com
            	时间：2017-01-18
            	描述：列向右偏移
            -->
			<div class="row">
				<div class="col-md-4" style="border: 1px solid #D9534F;">
					应中国共产党中央委员会总书记中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				</div>
				<div class="col-md-offset-4 col-md-4" style="border: 1px solid #D9534F;">
					应中国共产党中央委员会总书记、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				</div>
			</div>

			<!--
            	作者：chenhaoxiang@chaojijuhui.com
            	时间：2017-01-18
            	描述：列嵌套
            -->
			<div class="row">
				<div class="col-md-4" style="border: 1px solid #D9534F;">
					应中国共产党中央委员会总书记中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				</div>
				<div class="col-md-8" style="border: 1px solid #D9534F;">
					应中国共产党中央委员会总书记、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
					<!--
                    	作者：chenhaoxiang@chaojijuhui.com
                    	时间：2017-01-18
                    	描述：嵌套栅格系统
                    -->
					<div class="row">
						<div class="col-md-6" style="background-color: #204D74;height: 150px;"></div>
						<div class="col-md-6" style="background-color: #31B0D5;height: 100px;"></div>
					</div>
				</div>
			</div>

			<!--
            	作者：chenhaoxiang@chaojijuhui.com
            	时间：2017-01-18
            	描述：列排序
            -->
			<div class="row">
				<div class="col-md-6 col-md-push-5" style="background-color: #204D74;height: 150px;"></div>
				<div class="col-md-6" style="background-color: #31B0D5;height: 100px;"></div>
			</div>

		</div>

		<script type="text/javascript" src="js/jquery.slim.min.js"></script>
		<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	</body>

</html>
```
整个效果都在：
![](http://img.blog.csdn.net/20170118202605955?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

#表单样式
##说明

.form-group表单组样式：将`<label>`和表单元素包含其中，可以获得更好的排列。
.form-control表单元素样式：常用于`<input>`、`<textarea>`、`<select>`元素。
.form-inline内联表单样式(用于form元素)：可以使元素一行排列。
.checkbox复选框样式
.radio单选框样式
.disabled可以禁用单选框或复选项的文本。 disabled="disabled"
.form-horizontal水平排列的表单(用于form元素，类似row)。
.sr-only：可以用于隐藏元素。
.checkbox-inline 控制多个复选框元素在同一行显示。
.radio-inline控制多个单选框元素在同一行显示。

##添加额外的图标
你还可以针对校验状态为输入框添加额外的图标。只需设置相应的 .has-feedback 类并添加正确的图标即可。

反馈图标只处理带 `<input class="form-control">` 这个class的input


图标、label 和输入控件组

对于不带有 label 标签的输入框以及右侧带有附加组件的输入框组，需要手动为其图标定位。为了让所有用户都能访问你的网站，我们强烈建议为所有输入框添加 label 标签。如果你不希望将 label 标签展示出来，可以通过添加 sr-only 类来实现。如果的确不能添加 label 标签，请调整图标的 top 值。对于输入框组，请根据你的实际情况调整 right 值。

```
<div class="form-group has-success has-feedback">
  <label class="control-label" for="inputSuccess2">Input with success</label>
  <input type="text" class="form-control" id="inputSuccess2">
  <span class="glyphicon glyphicon-ok form-control-feedback"></span>
</div>
<div class="form-group has-warning has-feedback">
  <label class="control-label" for="inputWarning2">Input with warning</label>
  <input type="text" class="form-control" id="inputWarning2">
  <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
</div>
<div class="form-group has-error has-feedback">
  <label class="control-label" for="inputError2">Input with error</label>
  <input type="text" class="form-control" id="inputError2">
  <span class="glyphicon glyphicon-remove form-control-feedback"></span>
</div>

```

![](http://img.blog.csdn.net/20170118204525433?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


##实例

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
			<form class="form-horizontal">
				<!--表单中的栅栏系统用form-horizontal，其他的用row -->
				<h1>用户注册表单</h1>
				<div class="form-group">
					<!--control-label控制label和input之间的水平距离 -->
					<label class="col-md-2 control-label" for="username">用户名</label>
					<div class="col-md-10">
						<input type="text" class="form-control" id="username" placeholder="请输入用户名" disabled="disabled"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="password">密码</label>
					<div class="col-md-10">
						<input type="password" class="form-control" id="password" placeholder="请输入密码" />
					</div>
				</div>
				<!--
                	作者：chenhaoxiang@chaojijuhui.com
                	时间：2017-01-18
                	描述：sr-only -隐藏元素
                -->
				<div class="form-group sr-only">
					<label class="col-md-2 control-label" for="email">邮箱</label>
					<div class="col-md-10">
						<input type="email" class="form-control" id="email" placeholder="请输入邮箱" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">上传图片</label>
					<div class="col-md-10">
					<input type="file" />
					<!--
                    	作者：chenhaoxiang@chaojijuhui.com
                    	时间：2017-01-18
                    	描述：class="help-block" 帮助信息以块显示- 间距变长了点，颜色变淡了。
                    -->
					<p class="help-block">上传的图片类型只能是:.jpg/.gif/.png</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">兴趣爱好:</label>
					<div class="col-md-10">
						<label class="checkbox-inline">
							<input type="checkbox" value="画画" />画画
						</label>
						<label class="checkbox-inline">
							<input type="checkbox" value="音乐" />音乐
						</label>
						<label class="checkbox-inline">
							<input type="checkbox" value="体育" />体育
						</label>
						<label class="checkbox-inline">
							<input type="checkbox" value="唱歌" />唱歌
						</label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">学历:</label>
					<div class="col-md-10">
						<label class="radio-inline">
							<input type="radio" name="xueli"/>小学
						</label>
						<label class="radio-inline">
							<input type="radio" name="xueli"/>初中
						</label>
						<label class="radio-inline">
							<input type="radio" name="xueli"/>高中
						</label>
						<label class="radio-inline">
							<input type="radio" name="xueli"/>大专
						</label>
						<label class="radio-inline">
							<input type="radio" name="xueli"/>本科
						</label>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-2 control-label">个人简介:</label>
					<div class="col-md-10">
						<textarea class="form-control" rows="5" placeholder="请输入你的个人简介信息"></textarea>
					</div>
				</div>
				<div class="col-md-10 col-md-offset-2">
					<button type="button" class="btn btn-default btn-lg">提交表单</button>
				</div>
			</form>

		</div>

		<script type="text/javascript" src="js/jquery.slim.min.js"></script>
		<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	</body>

</html>
```

![](http://img.blog.csdn.net/20170118204609824?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

#按钮样式

```
可作为按钮使用的元素：<a>、<input>、<button>
.btn：按钮的全局样式。<input type = “button” class = “btn”>
预定义样式：.btn-default、.btn-primary、.btn-success、.btn-info、.btn-warning、.btn-danger、.btn-link
.active按钮激活状态、.disabled按钮禁用状态
按钮尺寸：.btn-lg(大按钮)、.btn-sm(小按钮)、.btn-xs(超小按钮)
.btn-block：将按钮拉伸到撑满整个父元素。
```
##预定义样式
```
<!-- Standard button -->
<button type="button" class="btn btn-default">Default</button>

<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
<button type="button" class="btn btn-primary">Primary</button>

<!-- Indicates a successful or positive action -->
<button type="button" class="btn btn-success">Success</button>

<!-- Contextual button for informational alert messages -->
<button type="button" class="btn btn-info">Info</button>

<!-- Indicates caution should be taken with this action -->
<button type="button" class="btn btn-warning">Warning</button>

<!-- Indicates a dangerous or potentially negative action -->
<button type="button" class="btn btn-danger">Danger</button>

<!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
<button type="button" class="btn btn-link">Link</button>
```
![](http://img.blog.csdn.net/20170118203444991?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##尺寸

按钮尺寸：.btn-lg(大按钮)、.btn-sm(小按钮)、.btn-xs(超小按钮)

通过给按钮添加 .btn-block 类可以将其拉伸至父元素100%的宽度，而且按钮也变为了块级（block）元素。

##激活状态

```
当按钮处于激活状态时，其表现为被按压下去（底色更深、边框夜色更深、向内投射阴影）。对于 <button> 元素，是通过 :active 状态实现的。对于 <a> 元素，是通过 .active 类实现的。然而，你还可以将 .active 应用到 <button> 上，并通过编程的方式使其处于激活状态。
```

###button 元素

由于 :active 是伪状态，因此无需额外添加，但是在需要让其表现出同样外观的时候可以添加 .active 类。

```
<button type="button" class="btn btn-primary btn-lg active">Primary button</button>
<button type="button" class="btn btn-default btn-lg active">Button</button>
```
![](http://img.blog.csdn.net/20170118204807689?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


###链接（`<a>`）元素
可以为基于 `<a>` 元素创建的按钮添加 .active 类。
这里的role="button"  ， role是无障碍设计里的标签（属性role的存在，是为了告诉Accessibility类应用（比如屏幕朗读程序，为盲人提供的访问网络的便利程序），这是一个按钮。在html5元素内，标签本身就是有语义的，因此role是不必添加的，至少是不推荐的，但是bootstrap的案例内很多都是有类似的属性和声明的，目的是为了兼容老版本的浏览器（用户代理））
```
<a href="#" class="btn btn-primary btn-lg active" role="button">Primary link</a>
<a href="#" class="btn btn-default btn-lg active" role="button">Link</a>
```
显示效果和上面的图片一样！

##禁用状态

为 `<button>` 元素添加 disabled 属性，使其表现出禁用状态。

```
<button type="button" class="btn btn-lg btn-primary" disabled="disabled">Primary button</button>
<button type="button" class="btn btn-default btn-lg" disabled="disabled">Button</button>

```

为基于 `<a>` 元素创建的按钮添加 .disabled 类。

```
<a href="#" class="btn btn-primary btn-lg disabled" role="button">Primary link</a>
<a href="#" class="btn btn-default btn-lg disabled" role="button">Link</a>

```

#两个完整实例源码链接:

https://github.com/chenhaoxiang/BootStrap/tree/master/day2

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
