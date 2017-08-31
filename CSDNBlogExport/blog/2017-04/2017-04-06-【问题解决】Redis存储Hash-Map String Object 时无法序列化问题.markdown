---
layout: post
title: "【问题解决】Redis存储Hash-Map String Object 时无法序列化问题"
date: 2017-04-06 12:05:58 +0800
comments: true
categories:❷ Java大学之行,❻ 其他,----- 上网技巧/问题解决
tags: [string,redis,存储,对象]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天在使用Redis的Map存储Bean时，出现了一个问题。 
问题如下:java.lang.ClassCastException: com.uifuture.TestBean cannot be cast to java.lang.String
    at org.springfr 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天在使用Redis的Map存储Bean时，出现了一个问题。 
问题如下:java.lang.ClassCastException: com.uifuture.TestBean cannot be cast to java.lang.String
    at org.springfr
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

今天在使用Redis的Map存储Bean时，出现了一个问题。
问题如下:

```
java.lang.ClassCastException: com.uifuture.TestBean cannot be cast to java.lang.String
	at org.springframework.data.redis.serializer.StringRedisSerializer.serialize(StringRedisSerializer.java:32)
	at org.springframework.data.redis.core.AbstractOperations.rawHashValue(AbstractOperations.java:168)
	at org.springframework.data.redis.core.DefaultHashOperations.put(DefaultHashOperations.java:168)
	at org.springframework.data.redis.core.DefaultBoundHashOperations.put(DefaultBoundHashOperations.java:90)
	at com.uifuture.utils.RedisUtil.addMap(RedisUtil.java:299)
	at com.uifuture.utils.redis.SaveMapCallable.call(SaveMapCallable.java:33)
	at java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:334)
	at java.util.concurrent.FutureTask.run(FutureTask.java:166)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1110)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:603)
	at java.lang.Thread.run(Thread.java:722)
```

![](http://img.blog.csdn.net/20170405235522254?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

我项目使用的是 spring-data-redis管理Redis与序列化。

所以当时我在Spring配置文件中配置的时候，配置了
keySerializer ：对于普通K-V操作时，key采取的序列化策略
valueSerializer：value采取的序列化策略
这2种序列化策略。

其实我是少配置了另外2个序列化策略。
造成的后果就是，存储普通的Bean时，是不会出现问题的，也就导致了我从项目开始到现在过去了10多天，才遇到这个问题。

其实解决办法很简单，我少配置了
hashKeySerializer： 在hash数据结构中，hash-key的序列化策略
hashValueSerializer：hash-value的序列化策略
这两个序列化策略。

当时我Spring的配置序列化的策略是:

```
<!-- 如果不配置Serializer，那么存储的时候只能使用String，如果用对象类型存储，那么会提示错误 can't cast to String！！！-->
        <property name="keySerializer">
            <!--对key的默认序列化器。默认值是StringSerializer-->
            <bean class="org.springframework.data.redis.serializer.StringRedisSerializer"/>
        </property>
        <!--是对value的默认序列化器，默认值是取自DefaultSerializer的JdkSerializationRedisSerializer。-->
        <property name="valueSerializer">
            <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"/>
        </property>
```
需要再增加两种，也就是改成:

```
<!-- 如果不配置Serializer，那么存储的时候只能使用String，如果用对象类型存储，那么会提示错误 can't cast to String！！！-->
        <property name="keySerializer">
            <!--对key的默认序列化器。默认值是StringSerializer-->
            <bean class="org.springframework.data.redis.serializer.StringRedisSerializer"/>
        </property>
        <!--是对value的默认序列化器，默认值是取自DefaultSerializer的JdkSerializationRedisSerializer。-->
        <property name="valueSerializer">
            <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"/>
        </property>
        <!--存储Map时key需要的序列化配置-->
        <property name="hashKeySerializer">
            <bean class="org.springframework.data.redis.serializer.StringRedisSerializer"/>
        </property>
        <!--存储Map时value需要的序列化配置-->
        <property name="hashValueSerializer">
            <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"/>
        </property>
```

这样就可以解决无法序列化Map的问题！

也就是，大家记得写序列化策略的时候，记得一次把这四种都写上。
我查这个错误的时候，硬是看了很多篇博客才发现我少写了。
搞得我都差点要直接自己搞个序列化和反序列化的工具类了。

其他的一些Redis的基础知识，工具类啊，就不写出来了。毕竟只是一篇解决问题的博客、
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
