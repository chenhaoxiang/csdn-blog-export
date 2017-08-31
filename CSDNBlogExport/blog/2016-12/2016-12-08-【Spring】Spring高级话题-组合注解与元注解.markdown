---
layout: post
title: "【Spring】Spring高级话题-组合注解与元注解"
date: 2016-12-08 08:53:19 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring
tags: [maven,spring,元注解,组合注解]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
分析
所谓的元注解： 
其实就是可以注解到别的注解上的注解。 
而被注解的注解我们就称之为组合注解。（仔细理解，可能有点绕）

组合注解同时 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
分析
所谓的元注解： 
其实就是可以注解到别的注解上的注解。 
而被注解的注解我们就称之为组合注解。（仔细理解，可能有点绕）

组合注解同时
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


进行本示例的演示，需要先配置好Maven和Spring哦、
见:
<a href="http://blog.csdn.net/qq_26525215/article/details/53010442" target='_blank'>【Spring】基于IntelliJ IDEA搭建Maven</a>

#分析

所谓的元注解：
其实就是可以注解到别的注解上的注解。
而被注解的注解我们就称之为组合注解。（仔细理解，可能有点绕）

组合注解同时具备元注解的功能！

Spring的很多注解都可以作为元注解，而且Spring本身已经有很多组合注解。

组合注解的好处：
简化了注解配置。也提供了很好的扩展性。

比如@Configuration就是一个组合@Component注解，表明这个类其实也是一个Bean。
@Configuration的源码:
```
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.springframework.context.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Component;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Configuration {
    String value() default "";
}

```

有的时候，我们可能大量同时使用到几个注解到同一个类上，这个时候，我们就可以考虑将这几个注解到别的注解上。

比如下面的示例就是将@Configuration和@ComponentScan注解到一个注解上！

这样，我们就可以用一个注解来表示这两个注解。

#示例

##组合注解

```
package cn.hncu.p3.p5_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/12/8.
 * Time: 下午 4:00.
 * Explain:组合注解
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration//组合@Configuration元注解  bean注解
@ComponentScan//组合@ComponentScan元注解  自动扫描对应value（package路径）值下面的所有bean
public @interface WiselyConfiguration {
    String[] value() default {};//覆盖value参数
    //就是覆盖@ComponentScan注解中的value参数----必须要写，否则组合注解中放入value值时会报错
}

```
解释一下@Documented：
表明这个注解应该被 javadoc工具记录. 默认情况下,javadoc是不包括注解的. 但如果声明注解时指定了 @Documented,则它会被 javadoc 之类的工具处理, 所以注解类型信息也会被包括在生成的文档中.

##服务Bean

```
package cn.hncu.p3.p5_annotation;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/12/8.
 * Time: 下午 8:17.
 * Explain:服务Bean
 */
@Service
public class DemoService {
    public void outputResult(){
        System.out.println("从组合注解配置照样获得的bean");
    }
}

```

##配置类

现在就只需要我们自定义的那个注解就可以代表那两个注解了。

```
package cn.hncu.p3.p5_annotation;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/12/8.
 * Time: 下午 8:19.
 * Explain:配置类--组合注解
 */
@WiselyConfiguration("cn.hncu.p3.p5_annotation")
//自定义注解，扫描的所有的bean来源于value值所对应的包路径下
//使用@WiselyConfiguration组合注解替代@Configuration和@ComponentScan
public class DemoConfig {
}

```

##运行类

```
package cn.hncu.p3.p5_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/12/8.
 * Time: 下午 8:21.
 * Explain:运行类
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService demoService = context.getBean(DemoService.class);
        demoService.outputResult();
        context.close();
    }
}

```

#运行结果

![](http://img.blog.csdn.net/20161208204519300)



<a href="https://github.com/chenhaoxiang/Java/tree/master/springBoot/src/main/java/cn/hncu/p3/p5_annotation" target='_blank'>此为项目源码链接，点击进入</a>




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
