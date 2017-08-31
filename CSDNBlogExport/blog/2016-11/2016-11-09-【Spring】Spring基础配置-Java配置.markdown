---
layout: post
title: "【Spring】Spring基础配置-Java配置"
date: 2016-11-09 10:30:07 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring
tags: [spring,xml,java,bean]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】




分析

Java配置是Spring4.x推荐的配置方式，可以完全替代xml配置； 
Java配置也是Spring Boot推荐的配置方式。

Java配置不需要@Service声明Bean。 
也不需要@Autowired注入Bean。 
只需要通过@Configuratio 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】




分析

Java配置是Spring4.x推荐的配置方式，可以完全替代xml配置； 
Java配置也是Spring Boot推荐的配置方式。

Java配置不需要@Service声明Bean。 
也不需要@Autowired注入Bean。 
只需要通过@Configuratio
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

#分析

Java配置是Spring4.x推荐的配置方式，可以完全替代xml配置；
Java配置也是Spring Boot推荐的配置方式。

Java配置不需要@Service声明Bean。
也不需要@Autowired注入Bean。
只需要通过@Configuration和@Bean来实现。

```
@configuration声明当前类是一个配置类，相当于一个Spring配置的xml文件.
@Bean注解在方法上，声明当前方法的返回值为一个Bean.
```

本篇只是演示最简单的Java配置，本【Spring】系列博客会一直更新。
要一直学下去的，可以关注我博客。

对于类的说明，我一般是写在代码注释中。

#示例:

##编写功能类的Bean
```
package cn.hncu.p1_3_2;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/11/4.
 * Time: 下午 10:43.
 */

//注意！ 此处没有使用@Service
public class FunctionService {
    public String sayHello(String word){
        return "Hello "+word + " !";
    }
}
```


##使用功能类的Bean

```
package cn.hncu.p1_3_2;

import cn.hncu.p1_3_1.*;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/11/4.
 * Time: 下午 11:10.
 */
//注意！此处没有使用@Service声明Bean
public class UseFunctionService {
    FunctionService functionService;
    //此处没有使用@Autowired注解注入Bean
    public void setFunctionService(FunctionService functionService){
        this.functionService = functionService;
    }

    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}

```

##配置类

```
package cn.hncu.p1_3_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/11/4.
 * Time: 下午 11:17.
 */
@Configuration
//使用@Configuration注解表明当前类是一个配置类，这意味着这个类里可能有0个或者多个@Bean注解、
//此处没有使用包扫描，是因为所有的Bean都在此类中定义了
public class JavaConfig {
    @Bean
    //使用@Bean注解声明当前方法FunctionService的返回值是一个Bean，Bean的名称是方法名
    public FunctionService functionService(){
        return new FunctionService();
    }

    /*
    @Bean
    public UseFunctionService useFunctionService(){
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService());
        //注入FunctionService的Bean时候直接调用functionService()
        return useFunctionService;
    }
    */

    @Bean
    public  UseFunctionService useFunctionService(FunctionService functionService){
        //另外一种注入的方式，直接将FunctionService作为作为参数给useFunctionService()，这也是Spring容器提供的极好的功能。
        //在Spring容器中，只要容器中存在某个Bean，就可以在另外一个Bean的声明方法的参数中直接写入
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService);
        return useFunctionService;
    }
}

```

##运行类

```
package cn.hncu.p1_3_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/11/4.
 * Time: 下午 11:36.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("张三"));
        context.close();
    }
}

```

##运行结果

![](http://img.blog.csdn.net/20161109102250114)

项目链接-具体的包;
https://github.com/chenhaoxiang/Java/tree/master/springBoot/src/main/java/cn/hncu/p1_3_2


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
