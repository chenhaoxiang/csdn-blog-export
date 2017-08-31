---
layout: post
title: "【SpringMVC】SpringMvc基础-常用注解、对象和json或xml之间的转换"
date: 2017-02-21 03:28:10 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring MVC
tags: [spring mvc]
keyword: 陈浩翔, 谙忆
description: #Spring MVC常用注解

##@Controller

@Controller注解在类上，表明这个类是Spring MVC里的Controller，将其声明为Spring的一个Bean，Dispatcher Servlet会自动扫描注解了此注解的类，并将Web请求映射到注解了@RequestMapping的方法上。

在声明普通Bean的时候，使用@Component、@Service、@Repository 
---


#Spring MVC常用注解

##@Controller

@Controller注解在类上，表明这个类是Spring MVC里的Controller，将其声明为Spring的一个Bean，Dispatcher Servlet会自动扫描注解了此注解的类，并将Web请求映射到注解了@RequestMapping的方法上。

在声明普通Bean的时候，使用@Component、@Service、@Repository
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

#Spring MVC常用注解

##@Controller

@Controller注解在类上，表明这个类是Spring MVC里的Controller，将其声明为Spring的一个Bean，Dispatcher Servlet会自动扫描注解了此注解的类，并将Web请求映射到注解了@RequestMapping的方法上。

在声明普通Bean的时候，使用@Component、@Service、@Repository和@Controller是等同的，因为@Service、@Repository、@Controller都组合了@Component注解。
但在Spring MVC声明控制器Bean的时候，只能使用@Controller。

##@RequestMapping

@RequestMapping注解是用来映射Web请求（访问路径和参数）、处类和方法的。
@RequestMapping可注解在类或者方法上。注解在方法上的@RequestMapping路径会继承注解在类上的路径，@RequestMapping支持Servlet的request和response作为参数，也支持对request和response的媒体类型进行配置。

##@ResponseBody

@ResponseBody支持将返回值放在response体内，而不是返回一个页面。
我们在很多基于Ajax的程序的时候，可以以此注解返回数据而不是页面，此注解可以放置在返回值前或者方法上。

##@RequestBody

@RequestBody允许request的参数在request体中，而不是在直接链接的地址后面。此注解放置在参数前。

@requestBody可以将请求体中的JSON字符串绑定到相应的bean上，当然，也可以将其分别绑定到对应的字符串上

例如说以下情况：

```
　　　　$.ajax({
　　　　　　　　url:"/login",
　　　　　　　　type:"POST",
　　　　　　　　data:'{"userName":"admin","pwd","admin123"}',
　　　　　　　　content-type:"application/json charset=utf-8",
　　　　　　　　success:function(data){
　　　　　　　　　　alert("request success ! ");
　　　　　　　　}
　　　　});


　　　　@requestMapping("/login")
　　　　public void login(@requestBody String userName,@requestBody String pwd){
　　　　　　System.out.println(userName+" ："+pwd);
　　　　}
```

这种情况是将JSON字符串中的两个变量的值分别赋予了两个字符串，但是呢假如我有一个User类，拥有如下字段：
　　　　　　String userName;
　　　　　　String pwd;
那么上述参数可以改为以下形式：@requestBody User user 这种形式会将JSON字符串中的值赋予user中对应的属性上
需要注意的是，JSON字符串中的key必须对应user中的属性名，否则是请求不过去的。


##@PathVariable

@PathVariable用来接收路径参数，如/new/001，可接收001作为参数，此注解放置在参数前。

例如：

```
@RequestMapping(value = "/new/{str}",produces = "text/plain;charset=UTF-8")
//@ResponseBody 放方法上也可以的
public @ResponseBody String demoPathVar(@PathVariable String str){
	return str;
}
```

##@RestController
@RestController是一个组合注解，组合了@Controller和@ResponseBody，这就意味着当你只开发一个和页面交互数据的控制的时候，需要使用此注解。
若没有此注解诶，要想实现上述功能，则需要自己在代码中加上@Controller和@ResponseBody两个注解。

#示例

下面这个示例将演示这几个注解的使用。
以及利用jackson，获得对象和json或xml之间的转换！

```
        <dependency>
            <groupId>com.fasterxml.jackson.dataformat</groupId>
            <artifactId>jackson-dataformat-xml</artifactId>
            <version>2.8.5</version>
        </dependency>
```

在实际项目中，我们其实主要是支持json数据，没必要同时支持json和xml，因为json比xml更加简洁。
由于JavaScript的广泛使用，json成为最推荐的格式，在这种情况下，我们的依赖包如下(上面的依赖包包含下面的依赖包)：

```
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.8.5</version>
        </dependency>
```

```
package cn.hncu.model;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/20.
 * Time: 下午 8:59.
 * Explain:此类用于演示获取request对象参数和返回此对象到response
 */
public class DemoObj {
    private Long id;
    private String name;

    public DemoObj() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

```
注意：jackson对对象和json做转换时一定需要空构造！！！

##注解演示控制器

###演示代码


```
package cn.hncu;

import cn.hncu.model.DemoObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/20.
 * Time: 下午 9:02.
 * Explain:控制器
 */
@Controller //声明此类是一个控制器
@RequestMapping("/chx") //映射此类的访问路径是/chx
public class DemoAnnoController {
    private static Logger logger = LoggerFactory.getLogger(DemoAnnoController.class);

    @RequestMapping(produces = "text/plain;charset=UTF-8")
    //此方法未标注路径，因此使用类级别的路径/chx；
    // produces可定制返回的response的媒体类型和字符集，或需返回值是json对象，则设置produces = "text/plain;charset=UTF-8"
    public @ResponseBody String index(HttpServletRequest request){
        //演示可接受HttpServletRequest作为参数，当然也可以接受HttpServletResponse作为参数，此处的@ResponseBody用在返回值前面
        logger.info("进入index方法！访问路径是："+request.getRequestURI());
        return "url:"+request.getRequestURI()+" can access";
    }

    //演示接受路径参数，并在方法参数前结合@PathVariable使用！
    @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathVar(@PathVariable String str,HttpServletRequest request){
        logger.info("进入demoPathVar方法！访问路径是："+request.getRequestURI());
        return "url:"+request.getRequestURI()+" can access";
    }

    //演示常规的request参数获取，访问路径为/chx/requestParam?id=001
    @RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id,HttpServletRequest request){
        logger.info("进入passRequestParam方法！访问路径是："+request.getRequestURI());
        return "url:"+request.getRequestURI()+" can access,id:"+id;
    }

    //演示解释参数到对象，访问路径为/chx/obj/?id=001&name=chx
    @RequestMapping(value = "obj",produces = "application/json;charset=UTF-8")
    @ResponseBody //也可以放在方法上
    public String passObj(DemoObj obj,HttpServletRequest request){
        logger.info("进入passObj方法！访问路径是："+request.getRequestURI());
        return "url:"+request.getRequestURI()+" can access,obj id:"+obj.getId()+" obj name:"+obj.getName();
    }

    //演示映射不同的路径到相同的方法上。
    //访问路径为/chx/name1 或/cha/name2
    @RequestMapping(value = {"/name1","name2"},produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request){
        logger.info("进入remove方法！访问路径是："+request.getRequestURI());
        return "url:"+request.getRequestURI()+" can access";
    }

}

```

###演示结果

![](http://img.blog.csdn.net/20170221151401788?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170221151410100?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170221151417007?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170221151424241?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170221151432366?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170221151440194?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##@RestController演示

###代码

```
package cn.hncu;

import cn.hncu.model.DemoObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/20.
 * Time: 下午 10:10.
 * Explain: @RestController演示
 */
@RestController //声明是控制器，并且返回数据时不需要@ResponseBody
@RequestMapping("rest")
public class DemoRestController {
    private static Logger logger = LoggerFactory.getLogger(DemoAnnoController.class);

    @RequestMapping(value = "getjson",produces = "application/json;charset=UTF-8")//返回数据的媒体类型为json
    public DemoObj getjson(DemoObj obj){
        logger.info("进入getjson方法.");
        return new DemoObj(obj.getId()+1,obj.getName()+" json");//直接返回对象，对象会自动转换成json
    }

    @RequestMapping(value = "getxml",produces = "application/xml;charset=UTF-8")//返回数据的媒体类型是xml
    public DemoObj getxml(DemoObj obj){
        logger.info("进入getxml方法.");
        return new DemoObj(obj.getId()+1,obj.getName()+" xml");//直接返回对象，对象会自动转换为xml
    }

}

```

###演示结果

转换成json的结果：

![](http://img.blog.csdn.net/20170221151639398?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

转换成xml的结果：

![](http://img.blog.csdn.net/20170221151646630?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


本篇博客涉及到的源码链接：
<blockquote cite='陈浩翔'>
<strong>【<a href='https://github.com/chenhaoxiang/springMVC/tree/master/springMVC2' target='_blank'>-&gt;点击访问源码-&copy;CHX</a>】</strong>
</blockquote>

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
