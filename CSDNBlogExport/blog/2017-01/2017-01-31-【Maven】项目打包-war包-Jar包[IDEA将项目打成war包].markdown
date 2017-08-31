---
layout: post
title: "【Maven】项目打包-war包-Jar包[IDEA将项目打成war包]"
date: 2017-01-31 12:21:06 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- Web深入学习
tags: [idea,maven,发布,博客,插件]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
首先，项目必须得是Maven配置的项目。增加了一个发布插件来实现。 
在项目的pom.xml中增加如下代码:<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
首先，项目必须得是Maven配置的项目。增加了一个发布插件来实现。 
在项目的pom.xml中增加如下代码:<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

首先，项目必须得是Maven配置的项目。

增加了一个发布插件来实现。
在项目的pom.xml中增加如下代码:

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    ...
    
    <!--这里影响的是将项目打成什么后缀的包
	如果修改为jar，就是打包成jar包
    -->
    <packaging>war</packaging>
    
    ...
    
    <build>
        <plugins>
            <!--下面是将应用打包发布需要增加的插件-->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

</project>
```

增加了一个打包插件：spring-boot-maven-plugin,并增加了一行配置：
```
<packaging>war</packaging>
```
这行配置指定将应用工程打包成war文件。

这样就可以在IDEA中增加一个打包的配置，打开Run/Debug Configurations对话框，选择增加配置一个Maven打包项目

![](http://img.blog.csdn.net/20170130230044923?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

在工作目录中选择工程所在根目录，在命令行中输入package，并将配置保存为package

![](http://img.blog.csdn.net/20170130230541232?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

现在项目的target目录是这样的：
![](http://img.blog.csdn.net/20170130231039075?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

运行package打包项目，就可以将实例工程打包，打包的文件将输出在工程的target文件

![](http://img.blog.csdn.net/20170130231331453?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

然后，我们看工程的target目录下：

![](http://img.blog.csdn.net/20170130231415720?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

也可以直接使用Maven的命令打包。打开一个命令行窗口，将路径切换到工程跟目录下，直接在命令行输入mav package，一样的可以实现这个运行打包成war。

如果需要打包成jar，可以不写
```
<packaging>war</packaging>
```
此句，也可以写成
```
<packaging>jar</packaging>
```

如果你打包的是war文件，打包完成后将war文件放置在Tomcat的webapp路径中，启动Tomcat就能自动运行程序。

如果你打包的jar文件，假如打包后在工程的target目录种生成jar文件为：springBootHelloM-1.0-SNAPSHOT.jar。
在命令行窗口中切换到target目录中，运行如下命令，就能启动应用：

```
java -jar springBootHelloM-1.0-SNAPSHOT.jar
```

#IDEA将项目打包成war包

![](http://img.blog.csdn.net/20170131001719353?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

选择之后：

![](http://img.blog.csdn.net/20170131001814636?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

勾选 bulid on make

然后需要编译：

![](http://img.blog.csdn.net/20170131001853907?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

然后可以看到：

![](http://img.blog.csdn.net/20170131001936576?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


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
