---
layout: post
title: "【Apache Ant】ANT解析以及ANT在myEclipse中的使用"
date: 2016-08-24 03:14:51 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具
tags: [apache,java,ant,myeclipse]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
维基百科上对Ant的介绍:Apache Ant，是一个将软件编译、测试、部署等步骤联系在一起加以自动化的一个工具，大多用于Java环境中的软件开发。由Apache软件基金会所提供。默认情况下，它的buildfile(XML文件)名为build.xml。每一个buildfile含有一个< 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
维基百科上对Ant的介绍:Apache Ant，是一个将软件编译、测试、部署等步骤联系在一起加以自动化的一个工具，大多用于Java环境中的软件开发。由Apache软件基金会所提供。默认情况下，它的buildfile(XML文件)名为build.xml。每一个buildfile含有一个<
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

#维基百科上对Ant的介绍:

Apache Ant，是一个将软件编译、测试、部署等步骤联系在一起加以自动化的一个工具，大多用于Java环境中的软件开发。

由Apache软件基金会所提供。默认情况下，它的buildfile(XML文件)名为build.xml。每一个buildfile含有一个`<project>`和至少一个预设的`<target>`，这些targets包含许多task elements。每一个task element有一个用来被参考的id，此id必须是唯一的。

##`<project>`标签 
default表示默认的执行目标,必须有的。 
basedir-是工作的根目录   .号代表项目根目录，必须有的。
name表示项目名称。 

##`<property>`标签 

```
<property name="src" value="cn.hncu"/>
```

变量名为src，值为cn.hncu.
在其他标签中用${src}-引用src的值,cn.hncu.


##`<target>`标签 

一个项目`<project>`标签下可以有一个或多个target标签,
一个target标签可以依赖其他target标签,(被依赖的标签先执行)
target所有属性如下所示： 

name表示这个标签的名字,这个属性是必须的。 
depends表示依赖的目标target标签的name。 

Ant的depends属性指定了target的执行顺序,Ant会依照depends属性中target标签出现顺序依次执行每个target,在执行之前首先执行它所依赖的target标签

if表示仅当属性设置时才执行。 
unless表示当属性没有设置时才执行。 
description表示项目的描述(或者是对这个标签的作用进行表述)。 


##`<mkdir>`标签 
该标签用于创建目录,它有一个属性dir用户指定所创建的目录.

```
<target name="md">
	<mkdir dir="d:/a/a1"/>
</target>
```
表示在D盘下创建a文件夹，a文件夹下创建a1文件夹。


##`<delete>`标签

该标签用于删除目录,它有一个属性dir用户指定删除的目录.

```
<target name="del">
	  <delete dir="d:/a/a1"></delete>
</target>
```
表示删除d盘的a目录下的a1文件夹以及a1文件夹下的所有文件。


##`<jar>`标签 

该标签用来生成一个JAR包

```
<target name="jar">
	<jar basedir="." destfile="d:/a/mail.jar">
	</jar>
</target>
```
basedir表示被归档成jar的文件目录。
destfile表示压缩成jar输出到那个目录，名字为啥。
includes表示被归档的文件模式。 
exchudes表示被排除的文件模式。
manifest属性指定自己的META-INF/MANIFEST.MF文件，而不是由系统生成
 


##`<echo>`标签 

该标签用来在控制台输出信息,其输入如下： 
message表示输入的内容。 

```
<target name="hello2" depends="hello1" description="输出">
	<echo message="Hello222"></echo>
</target>
	
<target name="hello1" >
	<echo message="Hello111"></echo>
</target>
```
先输出Hello111再输出Hello222，因为hello2依赖hello1(depends)


##<javadoc>标签
效果图:

![](http://img.blog.csdn.net/20160824144528926)

```
<target name="jdoc">
	   <javadoc sourcepath="src"
	   	destdir="d:/a/a"
	   	packagenames="cn.hncu.*"
	   	encoding="utf-8"
	   	docencoding="gbk">
	   </javadoc>
	</target>
```
sourcepath-指定查找输入源文件的位置-src表示src下的所有源文件(.java)输入
destdir-输出的文件位置
packagenames-包名
encoding-源java文件的编码
docencoding-输出文件的编码


##简单的例子:

```
<?xml version="1.0" encoding="utf-8"?>
<project basedir="." name="myMailWeb" default="hello2" >
	<property name="src" value="src"/>
	
	<target name="hello2" depends="hello1" description="输出">
       <echo message="Hello222"></echo>
    </target>
	
	<target name="hello1" >
		<echo message="Hello111"></echo>
	</target>
	
	<target name="jar">
		<jar jarfile="mal.jar" basedir="." destfile="d:/a/mail.jar">
		</jar>
	</target>
	
	<target name="jdoc">
	   <javadoc sourcepath="src"
	   	destdir="d:/a/a"
	   	packagenames="cn.hncu.*"
	   	encoding="utf-8"
	   	docencoding="gbk">
	   </javadoc>
	</target>
	
	<target name="md">
	  <mkdir dir="d:/a/a1"/>
	</target>
	
	<target name="del">
	  <delete dir="d:/a/a1" ></delete>
	</target>
	
</project>

```

#在myEclipse中的运行:

![](http://img.blog.csdn.net/20160824145708738)

选第一个是上次运行的targets标签，如果上次没运行，就是默认的。

选第二个Ant Build....就是让我们自己选运行哪个或者哪几个。

![](http://img.blog.csdn.net/20160824150459226)

description就是运行时有提示的那个。


ant的知识点太多了，其实只是一个辅助我们的工具，个人觉得完全没必要去很熟练的使用所有的，但是打jar包，输出Javadoc等常用的，还是必须熟练。


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
