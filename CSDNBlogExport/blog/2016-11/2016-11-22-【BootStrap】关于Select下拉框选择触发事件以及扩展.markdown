---
layout: post
title: "【BootStrap】关于Select下拉框选择触发事件以及扩展"
date: 2016-11-22 12:47:55 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- BootStrap
tags: [bootstrap,select]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
Select下拉框的问题，想在选择一个选项后，前台显示做出变动，并且知道选择的是第几个选项。 
这个很好解决： 
如下:<div class="page-header">
    <div class="form-horizontal">
    <div class="control 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
Select下拉框的问题，想在选择一个选项后，前台显示做出变动，并且知道选择的是第几个选项。 
这个很好解决： 
如下:<div class="page-header">
    <div class="form-horizontal">
    <div class="control
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


Select下拉框的问题，想在选择一个选项后，前台显示做出变动，并且知道选择的是第几个选项。
这个很好解决：
如下:

```
<div class="page-header">
	<div class="form-horizontal">
	<div class="control-label col-lg-0">
	</div>
	<div class="col-lg-2">
		<select class="form-control" onchange="selectOnchang(this)">
			<option>所有申请商家</option>
			<option>待审核商家</option>
			<option>未通过审核商家</option>
			<option>已通过审核商家</option>
		</select>
	</div>
</div>
```
JS:
```
function selectOnchang(obj){  
 //获取被选中的option标签选项 
 alert(obj.selectedIndex);
}
```

这里利用的就是onchange和selectedIndex。

onchange 事件会在域的内容改变时发生。
onchange 事件也可用于单选框与复选框改变后触发的事件。

selectedIndex: 设置或返回下拉列表中被选项目的索引号。

这样，在我们改变选项时就会触发改事件。
效果如图:

![](http://img.blog.csdn.net/20161122003338293)

这样做，我们只能获得选中哪项，而如果我们选中哪项，需要传递特殊的信息，这个时候该怎么办呢。

```
<div class="page-header">
	<div class="form-horizontal">
	<div class="control-label col-lg-0">
	</div>
	<div class="col-lg-2">
		<select class="form-control" onchange="selectOnchang(this)">
			<option value="all">所有申请商家</option>
			<option value="check_pending">待审核商家</option>
			<option value="no">未通过审核商家</option>
			<option value="yes">已通过审核商家</option>
		</select>
	</div>
</div>
```
也就是说，我在选中的同时，想获得那个value值，这个时候怎么做。

这里只用一种方法实现，其他的方法应该还有很多。
```
function selectOnchang(obj){  
 var value = obj.options[obj.selectedIndex].value;
 alert(value);
}
```
效果图如下:

![](http://img.blog.csdn.net/20161122004643653)

其他方法，请自己尝试哦。


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
