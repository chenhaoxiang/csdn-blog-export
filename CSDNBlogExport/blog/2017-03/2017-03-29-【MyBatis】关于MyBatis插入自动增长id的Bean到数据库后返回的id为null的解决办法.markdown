---
layout: post
title: "【MyBatis】关于MyBatis插入自动增长id的Bean到数据库后返回的id为null的解决办法"
date: 2017-03-29 08:58:14 +0800
comments: true
categories:❷ Java大学之行,❻ 其他,----- 上网技巧/问题解决,----- ----- MyBatis
tags: [mybatis]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
解决办法其实很简单，只需要为你的**.xml中的insert增加两个属性就可以了。 
例如，我的SponsorsMapper.xml中原来的代码如下:<insert id="insertSelective" parameterType="com.uifuture.footer.enti 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
解决办法其实很简单，只需要为你的**.xml中的insert增加两个属性就可以了。 
例如，我的SponsorsMapper.xml中原来的代码如下:<insert id="insertSelective" parameterType="com.uifuture.footer.enti
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

解决办法其实很简单，只需要为你的**.xml中的insert增加两个属性就可以了。
例如，我的SponsorsMapper.xml中原来的代码如下:
```
<insert id="insertSelective" parameterType="com.uifuture.footer.entity.Sponsors">
    insert into sponsors
    <trim prefix="(" suffix=")" suffixOverrides="," >
      <if test="id != null" >
```
上面的那个是有问题的，也就是插入数据，却无法返回插入数据后的id的值。

修改上面的代码如下:

```
 <insert id="insertSelective" parameterType="com.uifuture.footer.entity.Sponsors" useGeneratedKeys="true" keyProperty="id">
    insert into sponsors
    <trim prefix="(" suffix=")" suffixOverrides="," >
```
增加了useGeneratedKeys="true" keyProperty="id" 两个属性。

这样就解决了无法获得id问题。

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
