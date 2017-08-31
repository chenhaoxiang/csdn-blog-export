---
layout: post
title: "【深入分析Java Web】HTTP解析-常见请求头 响应头 状态码"
date: 2016-10-28 08:43:39 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- Web深入学习
tags: [java web,java,http协议,互联网,浏览器]
keyword: 陈浩翔, 谙忆
description: B/S网络架构的核心是HTTP协议，掌握HTTP协议对一个从事互联网工作的程序员来说是非常重要的。

要理解HTTP协议，最重要的就是要熟悉HTTP协议中的HTTP Header。

**HTTP Header控制着互联网上成千上万的用户的数据的传输。**

最关键的是，它控制着用户浏览器的渲染行为和服务器的执行逻辑。

例如，当服务器没有用户请求的数据时就会返回一个404状态码，告诉浏览器没有要请求的数据，通常浏览 
---


B/S网络架构的核心是HTTP协议，掌握HTTP协议对一个从事互联网工作的程序员来说是非常重要的。

要理解HTTP协议，最重要的就是要熟悉HTTP协议中的HTTP Header。

**HTTP Header控制着互联网上成千上万的用户的数据的传输。**

最关键的是，它控制着用户浏览器的渲染行为和服务器的执行逻辑。

例如，当服务器没有用户请求的数据时就会返回一个404状态码，告诉浏览器没有要请求的数据，通常浏览
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

B/S网络架构的核心是HTTP协议，掌握HTTP协议对一个从事互联网工作的程序员来说是非常重要的。

要理解HTTP协议，最重要的就是要熟悉HTTP协议中的HTTP Header。

**HTTP Header控制着互联网上成千上万的用户的数据的传输。**

最关键的是，它控制着用户浏览器的渲染行为和服务器的执行逻辑。

例如，当服务器没有用户请求的数据时就会返回一个404状态码，告诉浏览器没有要请求的数据，通常浏览器就会展示一个非常不愿意看到的该页面不存在的错误信息。

下面来根据表格来了解常见的HTTP请求头、响应头以及状态码。

**常见的HTTP请求头**
---------------

|请求头|说明|
|:------:|:---------:|
|  Accept-Charset  |用于指定客户端接受的字符集 | 
| Accept-Encoding | 用于指定可接受的内容编码，如Accept-Encoding:gzip.deflate|
| Accept-Language | 用于指定一种自然语言，如Accept-Language:zh-cn |
|Host |用于指定被请求资源的Internet主机和端口号，如Host:www.chaojijuhui.com|
|User-Agent |客户端将它的操作系统、浏览器和其他属性告诉服务器l|
|Connection|当前连接是否保持，如Connection: Keep-Alive|


**常见的HTTP响应头**
|响应头|说明|
|:------:|:---------:|
|Server|使用的服务器名称，如Server: Apache/1.3.6 (Unix)|
|Content-Type|用来指明发送给接收者的实体正文的媒体类型，如Content-Type:text/html;charset=GBK|
|Content-Encoding |与请求报头Accept-Encoding对应，告诉浏览器服务端采用的是什么压缩编码-一般写全站压缩的时候需要用到的|
|Content-Language|描述了资源所用的自然语言，与Accept-Language对应|
|Content-Length|指明实体正文的长度，用以字节方式存储的十进制数字来表示|
|Keep-Alive |保持连接的时间，如Keep-Alive: timeout=5, max=120|

请求头和响应头，一般的浏览器进入开发者工具，监听网络都能看到的。
例如:
在(Firefox)火狐浏览器下,
首先:
![](http://img.blog.csdn.net/20161026033626108)

然后:
![](http://img.blog.csdn.net/20161026033641843)

再:
![](http://img.blog.csdn.net/20161026033652484)

最后:看看响应头
![](http://img.blog.csdn.net/20161026033705781)

请求头就在下面。

要看一个HTTP请求的请求头和响应头，可以通过很多浏览器插件来看，在Firefox中有Firebug和HttpFox，Chrome自带的开发工具也可以看到每个请求的请求头信息（可用F12快捷键打开），IE自带的调试工具也有类似的功能。

HttpFox:
火狐上安装HttpFox后，打开的快捷键:ctrl+shift+F2.

![](http://img.blog.csdn.net/20161026075519909)

然后启动监听;
![](http://img.blog.csdn.net/20161026075542474)


**常见的HTTP状态码**
|状态码|说明|
|:------:|:---------:|
|200|客户端请求成功|
|302|临时跳转，跳转的地址通过Location指定|
|400|客户端请求有语法错误，不能被服务器识别|
|403|服务器收到请求，但是拒绝提供服务|
|404|请求的资源不存在|
|500|服务器发生不可预期的错误|
|503|服务器暂时不可用|

对于状态码，可以这么理解,便于记忆。

**2xx（成功）2开头的状态码:**
用于表示服务器已成功处理了请求的状态代码。

**3xx（已重定向）3开头的状态码:**
要完成请求，您需要进一步进行操作。通常，这些状态代码是永远重定向的。
Google 建议每次请求时使用的重定向要少于 5 个。

**4xx（请求错误）4开头的状态码:**
这些状态代码表示，请求可能出错，已妨碍了服务器对请求的处理。

**5xx（服务器错误）5开头的状态码:**
这些状态代码表示，服务器在尝试处理请求时发生内部错误。这些错误可能是服务器本身的错误，而不是请求出错。



参考文献-《深入分析Java Web技术内幕》 
1.3章节

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
