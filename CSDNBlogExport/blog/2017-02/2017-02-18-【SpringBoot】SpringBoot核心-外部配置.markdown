---
layout: post
title: "【SpringBoot】SpringBoot核心-外部配置"
date: 2017-02-18 05:10:01 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring Boot
tags: [java,SpringBoot]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
Spring Boot允许使用properties文件、yaml文件或者命令行参数作为外部配置。命令行参数配置Spring Boot可以是基于jar包运行的，打成jar包的程序可以直接通过下面命令运行：java -jar *.jar如果你的Tomcat的端口和你其他的端口起冲突了， 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
Spring Boot允许使用properties文件、yaml文件或者命令行参数作为外部配置。命令行参数配置Spring Boot可以是基于jar包运行的，打成jar包的程序可以直接通过下面命令运行：java -jar *.jar如果你的Tomcat的端口和你其他的端口起冲突了，
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

Spring Boot允许使用properties文件、yaml文件或者命令行参数作为外部配置。

#命令行参数配置

Spring Boot可以是基于jar包运行的，打成jar包的程序可以直接通过下面命令运行：
```
java -jar *.jar
```

如果你的Tomcat的端口和你其他的端口起冲突了，
还可以通过以下命令修改Tomcat端口号：

```
java -jar *.jar --server.port=10090
```
*为你的jar包名。

#常规属性配置

在常规Spring环境下，注入properties文件里面的值的方式可以通过@PropertySource指明properties文件的位置，然后通过@Value注入值。
详情见此篇博客：
<blockquote cite='陈浩翔'>
<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>【Spring】Spring常用配置-Spring EL和资源调用 </a>】</strong>
</blockquote>

在Spring Boot中，我们只需要在application.properties定义属性，直接使用@Value注入即可。

##实战

利用IDEA-->Spring-Initializr
创建好SpringBoot骨架！
步骤如下(以后的博客中可能就不再累赘写创建SpringBoot骨架啦):
![](http://img.blog.csdn.net/20170218162421605?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170218162618421?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170218162625840?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


创建好骨架后，进行如下的修改。

1、application.properties增加属性
```
springBoot2_2.author=chenhaoxiang
springBoot2_2.name=spring Boot

#修改Tomcat启动端口
server.port=10090
#修改访问路径-也就是把默认的"/"修改为了"/helloboot"
server.context-path=/helloboot
```

2、修改入口类

```
package cn.hncu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBoot22Application {
	@Value("${springBoot2_2.author}")
	private String author;
	@Value("${springBoot2_2.name}")
	private String name;

	@RequestMapping("/")
	String index(){
		return "name:"+name+" and author:"+author;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot22Application.class, args);
	}
}

```
3、运行程序，访问http://localhost:10090/helloboot/

效果如下：

![](http://img.blog.csdn.net/20170218164355241?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

#类型安全的配置

上面我们使用@Value注入每个配置，但是在实际项目中会显得格外麻烦，因为我们的配置通常会是许多个，若使用上例的方式则要使用@Value注入很多次。

Spring Boot 还提供了基于类型安全的配置方式，通过@ConfigurationProperties将properties属性和一个Bean及其属性关联，从而实现类型安全配置。

##实战
我们在上面的例子上修改。

1、添加配置，即在application.properties上添加：

```
author.name=chx
author.age=20
```

当然，如果你不想在这个properties中配置属性，也可以自己新建一个properties文件，这就需要我们在@ConfigurationProperties的属性locations里指定properties的位置，且需要在入口类上配置。

2、类型安全的Bean

```
package cn.hncu.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/18.
 * Time: 下午 4:52.
 * Explain:类型安全的Bean
 */
@Component
@ConfigurationProperties(prefix = "author")
//通过locations指定properties文件的位置，这里是在application.properties文件中，可以不指定
public class AuthorSettings {
    private String name;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}

```
通过@ConfigurationProperties加载properties文件内的配置，通过prefix属性指定properties的配置的前缀，通过locations指定properties文件的位置。

如果不是在application.properties文件中，则需要配置locations。例如：

```
@ConfigurationProperties(prefix  = "author",locations = {"classpath:author.properties"})
```
本例不需要配置locations。

3、检验代码

```
package cn.hncu;

import cn.hncu.model.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/18.
 * Time: 下午 4:59.
 * Explain:检验代码类 - 类型安全的配置
 */
@RestController
public class CheckoutAuthor {
    @Autowired //直接注入该配置
    private AuthorSettings authorSettings;

    @RequestMapping("/author")
    public String index2(){
        return "author name is "+ authorSettings.getName() +" and author age is "+authorSettings.getAge();
    }

}
```

运行。

访问：http://localhost:10090/helloboot/author

效果如下：
![](http://img.blog.csdn.net/20170218170632609?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


本篇博客涉及到的源码链接：
<blockquote cite='陈浩翔'>
<strong>【<a href='https://github.com/chenhaoxiang/SpringBoot/tree/master/springBoot2_2' target='_blank'>-&gt;点击访问源码-&copy;CHX</a>】</strong>
</blockquote>


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
