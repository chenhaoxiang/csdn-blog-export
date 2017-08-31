---
layout: post
title: "Java Mail---SMTP、POP3协议-DOS下手动收发邮件演示过程"
date: 2016-08-21 12:43:52 +0800
comments: true
categories:❷ Java大学之行,----- ③、Java知识点及应用,----- ----- JavaMail,----- ⑥、框架/第三方工具
tags: [java,邮件,邮件服务器,pop3,smtp]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处： http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
E-Mail协议简介：邮件服务器，按照提供的服务类型，可以分为发送邮件的服务器我接收邮件的服务器。 
发送邮件的服务器使用发送协议，现在常用的是SMTP协议。所以，通常发邮件的服务器也称为SMTP服务器。 
接收邮件的服务器使用接收协议，现在常用的是POP3协议或IMAP协议，所以通 
---


转载请注明出处： http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
E-Mail协议简介：邮件服务器，按照提供的服务类型，可以分为发送邮件的服务器我接收邮件的服务器。 
发送邮件的服务器使用发送协议，现在常用的是SMTP协议。所以，通常发邮件的服务器也称为SMTP服务器。 
接收邮件的服务器使用接收协议，现在常用的是POP3协议或IMAP协议，所以通
<!-- more -->
----------

<blockquote>
<p background-color='#D3D3D3'>转载请注明出处： http://blog.csdn.net/qq_26525215<br><br>
本文源自<strong>【<a href="http://blog.csdn.net/qq_26525215" target="_blank">大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

#E-Mail协议简介：


邮件服务器，按照提供的服务类型，可以分为发送邮件的服务器我接收邮件的服务器。
发送邮件的服务器使用发送协议，现在常用的是SMTP协议。所以，通常发邮件的服务器也称为SMTP服务器。
接收邮件的服务器使用接收协议，现在常用的是POP3协议或IMAP协议，所以通常也被称为POP3或IMAP服务器。
目前经常见到的服务器为SMTP和POP3服务器。如大家在注册了126的邮箱之后，它的发邮件服务器为smtp.126.com:25，而收邮件服务器则为pop3.126.com:110.(冒号后面的为端口号)。
当然，发邮件服务器和收邮件服务器也可能是同一台主机，但端口号一定不相同。默认发邮件服务器的端口为25，收邮件的端口为110.

注意：
```
QQ邮箱 POP3 和 SMTP 服务器地址设置如下： 
POP3服务器（端口110）pop.qq.com SMTP服务器（端口25） 
smtp.qq.com SMTP服务器需要身份验证。
如果是设置POP3和SMTP的SSL加密方式，则端口如下：
POP3服务器（端口995） SMTP服务器（端口465或587）。

```

##邮件发送的工作图：

![](http://img.blog.csdn.net/20160821003947795)


##邮件收/发协议：

●SMTP协议－发邮件协议
全称为Simple Mail Transfer Protocol（简单邮件传输协议），它定义了邮件客户端软件与SMTP服务器之间、以及两台SMTP服务器之间的通讯规则。端口一般为25.

●POP3协议－收邮件协议
全称为Post Office Protocol（邮局协议），它定义了邮件客户端软件与POP3服务器的通讯规则。端口一般为110.

●●如果是设置POP3和SMTP的SSL加密方式，则端口如下： POP3服务器（端口995） SMTP服务器（端口465或587）。

●IMAP协议－对POP3的扩展
全称为Internet Message Access Protocal（Internet消息访问协议），它是对POP3协议的一种扩展，定义了邮件客户端软件与IMAP服务器的通讯规则。


##打开SMTP和POP3的服务

win7系统中，默认下 telnet服务是关闭，得用如下方式：

1、控制面板-->程序-->打开或关闭windows功能，选择“telnet服务器” 和 “telnet客户端”框,点击确定即可。
2、控制面板-->系统安全-->管理工具-->服务-->telnet-->右击“属性”-->将“禁用”改为“手动”，应用，再选择“启动”

注意，必须先进行第一步，才能在第二步的服务中找到telnet.

Telnet 服务器不再列入 Windows 10 客户端或服务器， 为功能删除或弃用，如果要使用，请去谷歌上找第三方软件开启。


#SMTP发邮件协议的命令

SMTP命令及格式:
```
Ehlo<SP><domain>
<CRLF>
```
ehlo命令是SMTP邮件发送程序与SMTP邮件接收程序建立连接后必须发送的第一条SMTP命令，参数`<domain>`表示SMTP邮件发送者的主机名。ehlo命令用于替代传统SMTP协议中的helo命令。
`<SP>`表示一个空格，`<CRLF>`表示一个回车。


```
Auth<SP><para><CRLF>
```
如果SMTP邮件接收程序需要SMTP邮件发送程序进行认证时，它会向SMTP邮件发送程序提示它所采用的认证方式，SMTP邮件发送程序接着应该使用这个命令回应SMTP邮件接收程序，参数`<para>`表示回应的认证方式(login表示登录)，通常是SMTP邮件接收程序先前提示的认证方式。

后面2行就是你的邮箱地址还有密码(编码后)。
可以用Java中的BASE64Encoder 来进行编码

```
Mail<SP>From:<reverse-path><CRLF>
```
此命令用于指定邮件发送者的邮箱地址，参数`<reverse-path>`表示发件人的邮箱地址。

```
Rcpt<SP>To: <forword-path><CRLF>
```
此命令用于指定邮件接收者的邮箱地址，参数`<forward-path>`表示接收者的邮箱地址。如果邮件要发送给多个接收者，那么应使用多条Rcpt`<SP>`To命令来分别指定每一个接收者的邮箱地址。

```
Data<CRLF>
```
此命令用于表示SMTP邮件发送程序准备开始传送邮件内容，在这个命令后面发送的所有数据都将被当作邮件内容，直至遇到“`<CRLF>`.`<CRLF>`”标识符表示邮件内容结束。
也就是英文的句号

```
Quit<CRLF>
```
此命令表示要结束邮件发送过程，SMTP邮件接收程序接收到此命令后，将关闭与SMTP邮件发送程序的网络连接。

##DOS下发邮件

准备的是sina邮箱，注意在邮箱服务器(邮箱网站)中要把SMTP和POP3服务的开关打开(接收方的也需要打开)！！！
126邮箱服务器地址:
POP3服务器: pop3.sina.com
SMTP服务器: smtp.sina.com
在此处，我们用SMTP服务器: smtp.sina.com。

我们用下面的代码来对用户名和密码进行编码
```
public static void main(String[] args) {
		BASE64Encoder be = new BASE64Encoder();
		
		String name = "*****@sina.com";
		String pwd = "*********";
		name = be.encode(name.getBytes());
		pwd = be.encode(pwd.getBytes());
		//英文可以不指定编码
		System.out.println(name);
		System.out.println(pwd);
	}
```
DOS命令如下:
```
telnet smtp.sina.com 25
ehlo chx
auth login
Y2h4cG9zdGJveEBzaW5hLmNvbQ==
Y2h4NjE5Njk5NjI5
mail from:<chxpostbox@sina.com>
rcpt to:<chxpostbox@126.com>
data
from:<chxpostbox@sina.com>
to:<chxpostbox@126.com>
subject:chx 邮件测试

hello 你好啊，我进来了。
大家好.
.

```

请求登录：auth login后:
输入用户名：经过base64编码以后的。
输入密码，也是经过base64编码以后的。


如果是在Dos下对QQ邮箱发送的，可以到垃圾邮箱中去找！QQ把它归类为垃圾邮箱了。。。。

![](http://img.blog.csdn.net/20160821103710022)

![](http://img.blog.csdn.net/20160821103720183)

#POP3协议的命令-收邮件
命令及其使用格式

```
user<SP>username
<CRLF>
```
`<SP>`代表空格，`<CRLF>`代表回车
user命令是POP3客户端程序与POP3邮件服务器建立连接后通常发送的第一条命令，参数username表示收件人的帐户名称。

```
pass<SP>password
<CRLF>	
```

pass命令是在user命令成功通过后，POP3客户端程序接着发送的命令，它用于传递帐户的密码，参数password表示帐户的密码。

```
stat<CRLF>
```

stat命令用于查询邮箱中的统计信息，例如，邮箱中有邮件数和邮件占用的字节大小等。

```
list<SP>[msg#]
<CRLF>	
```

list命令用于列出邮箱中的邮件信息，参数msg#是可选参数，表示邮件的序号。当不指定参数时，POP3服务器列出邮箱中所有的邮件信息；当指定参数msg#时，POP3服务器只返回该序号对应邮件的信息。

```
retr<SP>msg#<CRLF>
```

list命令用于获取某封邮件的内容，参数msg#表示邮件的序号。

```
dele<SP>msg#<CRLF>	
```

dele命令用于在某封邮件上设置删除标记，参数msg#表示邮件的序号。POP3服务器执行dele命令时，只是为邮件设置了删除标记，并没有真正把邮件删除掉，只有POP3客户端程序发出quit命令后，POP3服务器才会真正删除所有设置了删除标记的邮件。

```
rset<CRLF>	
```

rset命令用于清除所有邮件的删除标记。

```
noop<CRLF>	
```

noop命令用于检测POP3客户端与POP3服务器的连接情况。

```
quit<CRLF>	
```

quit命令表示要结束邮件接收过程，POP3服务器接收到此命令，将删除所有设置了删除标记的邮件，并关闭与POP3客户端程序的网络连接


##DOS下显示邮件

```
telnet pop3.126.com 110
user chxpostbox
pass chx619699629
stat
list
retr 1
quit
```
stat   //显示总体信息
list   //列出所有信件
retr n   //收取序号为n的邮件

![](http://img.blog.csdn.net/20160821123417390)



<blockquote>
<p background-color='#D3D3D3'>转载请注明出处： http://blog.csdn.net/qq_26525215<br><br>
本文源自<strong>【<a href="http://blog.csdn.net/qq_26525215" target="_blank">大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
