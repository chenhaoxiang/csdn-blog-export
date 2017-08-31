---
layout: post
title: "【Spring】Spring常用配置-Bean的Scope"
date: 2016-11-11 11:07:39 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring
tags: [spring,singleton,实例,bean,博客]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
分析Scope(范围)描述的是Spring容器如何新建Bean的实例的。可以简单的理解成Bean的作用范围！ 
Spring的Scope有以下的几种，可以通过@Scope注解来实现。1、singleton:一个Spring容器中只有一个Bean的实例。
    这是Spring的默认配 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
分析Scope(范围)描述的是Spring容器如何新建Bean的实例的。可以简单的理解成Bean的作用范围！ 
Spring的Scope有以下的几种，可以通过@Scope注解来实现。1、singleton:一个Spring容器中只有一个Bean的实例。
    这是Spring的默认配
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

#分析

Scope(范围)描述的是Spring容器如何新建Bean的实例的。可以简单的理解成Bean的作用范围！
Spring的Scope有以下的几种，可以通过@Scope注解来实现。
```
1、singleton:一个Spring容器中只有一个Bean的实例。
	这是Spring的默认配置，也就是不写@Scope("singleton"),全容器共享一个实例。

2、prototype:每次调用都会新建一个Bean的实例。

3、request:Web项目中，给每一个http request新建一个Bean实例。
	也就是每一个request请求，都会新建一个Bean。

4、session:Web项目中，给每一个http session新建一个Bean实例。
	也就是同一个session访问的请求，都是同一个Bean。

5、globalSession:这个只在portal应用中有用，给每一个global http session新建一个Bean实例。

```

在Spring Batch中还有一个Scope是使用@StepScope的，这里就不介绍了。以后会有博客提到。
现在要去了解的，请自行谷歌。

下面的实例是简单的演示默认的singleton和prototype，分别从Spring容器中获得2次Bean，分别用==与equals判断Bean的实例是否相等！

#示例
##singleton的Bean

```
package cn.hncu.p2_1_1Scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/11/11.
 * Time: 上午 11:09.
 * Explain:Singleton---默认Spring-Scope
 */
@Service//默认@Scope为Singleton-相当于添加
//@Scope("singleton")
public class DemoSingletonService {
}

```

##prototype的Bean

```
package cn.hncu.p2_1_1Scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/11/11.
 * Time: 上午 11:23.
 * Explain:编写Prototype的Bean
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {
}

```

##配置类

```
package cn.hncu.p2_1_1Scope;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/11/11.
 * Time: 上午 11:42.
 * Explain:配置类
 */
@Configuration
@ComponentScan("cn.hncu.p2_1_1Scope.")
public class ScopeConfig {
}

```


##运行

```
package cn.hncu.p2_1_1Scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/11/11.
 * Time: 上午 11:43.
 * Explain:运行类
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);

        DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);

        DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService s2 = context.getBean(DemoSingletonService.class);

        System.out.println("p1.equals(p2):"+p1.equals(p2));//false
        System.out.println("p1==p2:"+(p1==p2));//false

        System.out.println("s1.equals(s2):"+s1.equals(s2));//true
        System.out.println("s1==s2:"+(s1==s2));//true
    }
}

```

#运行结果

![](http://img.blog.csdn.net/20161111230249504)


项目链接—具体包:
https://github.com/chenhaoxiang/Java/tree/master/springBoot/src/main/java/cn/hncu/p2_1_1Scope



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
