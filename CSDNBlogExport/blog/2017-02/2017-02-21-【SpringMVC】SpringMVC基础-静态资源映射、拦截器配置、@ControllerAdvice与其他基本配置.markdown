---
layout: post
title: "【SpringMVC】SpringMVC基础-静态资源映射、拦截器配置、@ControllerAdvice与其他基本配置"
date: 2017-02-21 08:57:11 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring MVC
tags: [spring mvc]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
Spring MVC的定制配置需要我们的配置类继承一个WebMvcConfigurerAdapter类，并在此类使用@EnableWebMvc注解，来开启对Spring MVC的配置支持，这样我们就可以重写这个类的方法，完成我们的常用配置。静态资源映射程序的静态文件(js、css、图片 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
Spring MVC的定制配置需要我们的配置类继承一个WebMvcConfigurerAdapter类，并在此类使用@EnableWebMvc注解，来开启对Spring MVC的配置支持，这样我们就可以重写这个类的方法，完成我们的常用配置。静态资源映射程序的静态文件(js、css、图片
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

Spring MVC的定制配置需要我们的配置类继承一个WebMvcConfigurerAdapter类，并在此类使用@EnableWebMvc注解，来开启对Spring MVC的配置支持，这样我们就可以重写这个类的方法，完成我们的常用配置。

#静态资源映射

程序的静态文件(js、css、图片)等需要直接访问，这时我们可以在配置里重写addResourceHandlers方法来实现。

##示例

1、添加静态资源，我们在src/main/resources下建立assets/js目录，并复制一个jquery.js放置在此目录下，如下图：

![](http://img.blog.csdn.net/20170221163121120?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

```
package cn.hncu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/21.
 * Time: 下午 4:09.
 * Explain:配置类
 */
@Configuration
@EnableWebMvc //开启SpringMVC支持，如无此注解，重写WebMvcConfigurerAdapter类的方法无效
@ComponentScan("cn.hncu")
public class MyMvcConfig extends WebMvcConfigurerAdapter{
    //集成WebMvcConfigurerAdapter类，重写其方法可对Spring MVC进行配置

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/assets/");
        //addResourceHandler指的是对外暴露的访问路径,addResourceLocations指的是文件放置的目录，
    }
}

```

输入访问地址：http://localhost:8080/springMVC3/static/js/jquery.js

![](http://img.blog.csdn.net/20170221164418144?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

#拦截器配置

拦截器（Interceptor）实现对每一个请求处理前后进行相关的业务处理，类似于Servlet的Filter。

可让普通的Bean实现HanlderInterceptor接口或者集成HandlerInterceptorAdapter类实现自定义拦截器。

通过重写WebMvcConfigurerAdapter的addInterceptors方法来注册自定义的拦截器，本节演示一个简单的拦截器的开发和配置，业务含义为计算每一次请求的处理时间。

##示例

```
package cn.hncu.filter;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/21.
 * Time: 下午 5:00.
 * Explain:拦截器
 */
//配置拦截器的Bean
public class DemoInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //重写preHandle方法，在请求发生前执行
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //重写postHandle方法，在请求完成后执行
        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理时间为："+ new Long(endTime - startTime) +" ms");
        request.setAttribute("handlingTime",endTime-startTime);
    }
}

```

如果需要拦截特定的网址，可利用正则映射到需要拦截的路径 ，然后在preHandle方法中判断request.getRequestURL().toString()，进行匹配，用matches方法。

##配置

写在MyMvcConfig中

```
    @Bean //配置拦截器的Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }
```

##写一个控制器

```
package cn.hncu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/21.
 * Time: 下午 5:23.
 * Explain:控制器
 */
@Controller
@RequestMapping("index")
public class Index {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}

```
添加index.jsp

运行后，访问http://localhost:8080/springMVC3/index/

![](http://img.blog.csdn.net/20170221173229775?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170221173238970?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

访问静态资源不会拦截哦！也就是直接访问.js的那个文件不会被拦截。

#@ControllerAdvice

##定制ControllerAdvice

```
package cn.hncu.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/21.
 * Time: 下午 6:04.
 * Explain:定制ControllerAdvice
 */
@ControllerAdvice //声明一个控制器建言，@ControllerAdvice组合了@Component注解，所以自动注册为
public class ExceptinHandlerAdvice {

    @ExceptionHandler(value = Exception.class)
    //@ExceptionHandler在此处定义全局处理，通过@ExceptionHandler的value属性可过滤拦截的条件，在此处我们可以看出我们拦截所有的Exception
    public ModelAndView exception(Exception e, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error"); //error页面
        modelAndView.addObject("errorMessage",e.getMessage());
        return modelAndView;
    }

    @ModelAttribute //此处使用@ModelAttribute 注解将键值对添加到全局，所有注解@RequestMapping的方法可获得此键值对
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder //通过@InitBinder 注解定制 WebDataBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id"); //此处演示忽略request 参数的id
    }


}

```

##演示控制器

```
package cn.hncu.controller;

import cn.hncu.model.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/21.
 * Time: 下午 8:08.
 * Explain:演示控制器
 */
@Controller
public class AdviceController {

    @RequestMapping("advice")
    public String getSomething(@ModelAttribute("msg") String msg , DemoObj obj){
        System.out.println("id:"+obj.getId()+" , name:"+obj.getName());
        //访问 http://localhost:8080/springMVC3/advice?id=1&name=chx
        //id:null , name:chx -因为id被过滤掉了！
        throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute："+msg);
    }

}

```

##异常展示页面

在src/main/resources/views下，新建error.jsp，内容如下：

```
<%--
  Created by IntelliJ IDEA.
  User: 陈浩翔
  Date: 2016/12/18
  Time: 下午 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>@ControllerAdvice Demo</title>
</head>

<body>
    <pre>Welcome to Spring MVC</pre>
    <br/>
   ${errorMessage}
</body>
</html>

```


##运行

访问：http://localhost:8080/springMVC3/advice?id=1&name=chx

![](http://img.blog.csdn.net/20170221203346016?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


![](http://img.blog.csdn.net/20170221203455484?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
可以看到id被过滤掉了！


#其他配置


##快捷的ViewCOntroller

在前面我们配置页面转向的时候是这样写代码的：

```
@Controller
@RequestMapping("index")
public class Index {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}

```
此处无任何业务处理，只是简单的页面转向，写了很多冗余代码，在实际开发中会涉及大量这样的页面转向，如果都这样写会很麻烦。

所以，我们可以通过在配置中重写addViewControllers来简化配置：

```
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/inn").setViewName("/in");
        //addViewController是访问的URL，setViewName是设置in.jsp
    }
```
这样实现的代码更简洁，管理更集中。

访问：http://localhost:8080/springMVC3/inn

![](http://img.blog.csdn.net/20170221204445684?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


##在路径匹配参数配置

在Spring MVC中，路径参数如果带"."的话，"."后面的值都将被忽略，例如:
我们在AdviceController.java中增加代码：

```
    @RequestMapping("pathvar/{str}")
    public @ResponseBody String pathvarDemo(@PathVariable String str){
        return "str:"+str;
    }
```

接下来访问：http://localhost:8080/springMVC3/pathvar/chenhaoxiang.hncu

结果如下：
![](http://img.blog.csdn.net/20170221205006509?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

可以看到"."后面的参数没有传过去

我们可以这样解决、通过重写configurePathMatch方法可不忽略"."后面的参数，代码如下（写在Spring MVC配置类中）：

```

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);//不忽略 "."后面的参数
    }
```

这个时候，我们重新运行在看，继续访问刚才的地址

![](http://img.blog.csdn.net/20170221205306745?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)




本篇博客涉及到的源码链接：
<blockquote cite='陈浩翔'>
<strong>【<a href='https://github.com/chenhaoxiang/springMVC/tree/master/springMVC3' target='_blank'>-&gt;点击访问源码-&copy;CHX</a>】</strong>
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
