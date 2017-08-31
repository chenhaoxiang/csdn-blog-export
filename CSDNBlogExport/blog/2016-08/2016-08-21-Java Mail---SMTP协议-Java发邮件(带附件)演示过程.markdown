---
layout: post
title: "Java Mail---SMTP协议-Java发邮件(带附件)演示过程"
date: 2016-08-21 02:07:19 +0800
comments: true
categories:❷ Java大学之行,----- ③、Java知识点及应用,----- ----- JavaMail,----- ⑥、框架/第三方工具
tags: [java,邮件,smtp]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处： http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
JavaMail-API简介：邮件客户端的主要任务是向邮件服务器发送邮件，以及接收来自邮件服务器的邮件。 
Sun公司制定了一套API，它封装了邮件通信的各种协议。为Java开发者提供了收发电子邮件的公共接口。需要的jar包mail.jar和activation-1.1.0.jar链 
---


转载请注明出处： http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
JavaMail-API简介：邮件客户端的主要任务是向邮件服务器发送邮件，以及接收来自邮件服务器的邮件。 
Sun公司制定了一套API，它封装了邮件通信的各种协议。为Java开发者提供了收发电子邮件的公共接口。需要的jar包mail.jar和activation-1.1.0.jar链
<!-- more -->
----------

<blockquote>
<p background-color='#D3D3D3'>转载请注明出处： http://blog.csdn.net/qq_26525215<br><br>
本文源自<strong>【<a href="http://blog.csdn.net/qq_26525215" target="_blank">大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


#JavaMail-API简介：
邮件客户端的主要任务是向邮件服务器发送邮件，以及接收来自邮件服务器的邮件。
Sun公司制定了一套API，它封装了邮件通信的各种协议。为Java开发者提供了收发电子邮件的公共接口。

##需要的jar包
mail.jar和activation-1.1.0.jar链接:
https://github.com/chenhaoxiang/Java/tree/master/JavaMail

##Javax.mail.Session:
Session －用于设置服务器，协议类型和密码等
表示会话，是JavaMailApi的最高层入口类。Session对像从Properties中获取信息，如IP、协议、用户名密码等。

Javax.mail.Message类，它的一个重要子类为MimeMessage.

Message类表示电子邮件的正文部分。
一封电子邮件包含以下内容：
地址信息、标题、日期、正文。

Java.mail.Address：收件人地址
表示邮件的地址。常用的子类为：javax.mail.internet.InternetAddress.

Javax.mail.Transport：负责发送邮件
指定邮件发送的协议。通常为SMTP.
它的静态方法send(Message)负责发送邮件。

MailSSLSocketFactory-负责SSL加密(如果有邮箱是用ssl加密传输的，就需要用到这个类，否则不需要-以前的老版本jar包中没有此类)


#演示用QQ邮箱给网易126邮箱发邮件:

为什么要用QQ邮箱，那是因为QQ邮箱的发送用到了ssl加密，而且这里原本需要的密码，也需要用授权码才可以。

**JavaMail发送邮件:前提是QQ邮箱里帐号设置要开启POP3/SMTP协议**

##发送没有附件的邮件

###第一种方式:
```
@Test//发送没有附件的邮件
   public void send1() throws Exception{
		//跟smtp服务器建立一个连接
		Properties p = new Properties();
		// 设置邮件服务器主机名
		p.setProperty("mail.host", "smtp.qq.com");//指定邮件服务器，默认端口 25
		// 发送服务器需要身份验证
		p.setProperty("mail.smtp.auth", "true");//要采用指定用户名密码的方式去认证
		// 发送邮件协议名称
		p.setProperty("mail.transport.protocol", "smtp");
		
		// 开启SSL加密，否则会失败
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.ssl.socketFactory", sf);
		
		// 开启debug调试，以便在控制台查看
		//session.setDebug(true);也可以这样设置
		//p.setProperty("mail.debug", "true");
		
		// 创建session
		Session session = Session.getDefaultInstance(p, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				//用户名可以用QQ账号也可以用邮箱的别名
				PasswordAuthentication pa = new PasswordAuthentication("chenhaoxiang0117", "jnj*********dab");
				// 后面的字符是授权码，用qq密码不行！！
				return pa;
			}
	    });
		
	    session.setDebug(true);//设置打开调试状态
	    
	    for (int i = 0; i <1; i++) {//发送几封邮件
			//声明一个Message对象(代表一封邮件),从session中创建
			MimeMessage msg = new MimeMessage(session);
			//邮件信息封装
			//1发件人
			msg.setFrom(new InternetAddress("*****@qq.com"));
			//2收件人
			msg.setRecipient(RecipientType.TO, new InternetAddress(
					"******@126.com"));
			//3邮件内容:主题、内容
			msg.setSubject("这是我用Java发来的邮件QQ....");
			//msg.setContent("Hello, 今天没下雨!!!", "text/plain;charset=utf-8");//纯文本
			msg.setContent(
					"Hello <a href='http://www.baidu.com?id=ddd'>你好，快乐吗?<a/>",
					"text/html;charset=utf-8");//发html格式的文本
			//发送动作
			Transport.send(msg);
		}
   }
	
```
###第二种方式:

```
public class sendqqMail {

	public static void main(String[] args) throws Exception {

		Properties prop = new Properties();
		// 开启debug调试，以便在控制台查看
		prop.setProperty("mail.debug", "true");
		// 设置邮件服务器主机名
		prop.setProperty("mail.host", "smtp.qq.com");
		// 发送服务器需要身份验证
		prop.setProperty("mail.smtp.auth", "true");
		// 发送邮件协议名称
		prop.setProperty("mail.transport.protocol", "smtp");

		// 开启SSL加密，否则会失败
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf);

		// 创建session
		Session session = Session.getInstance(prop);
		
		// 通过session得到transport对象
		Transport ts = session.getTransport();
		// 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
		ts.connect("smtp.qq.com", "619***629", "jnjt***bdab");
		// 后面的字符是授权码，用qq密码失败了
		
		// 创建邮件
		Message message = createSimpleMail(session);
		// 发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	/**
	 * @Method: createSimpleMail
	 * @Description: 创建一封只包含文本的邮件
	 */
	public static MimeMessage createSimpleMail(Session session)
			throws Exception {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 指明邮件的发件人
		message.setFrom(new InternetAddress("61*****29@qq.com"));
		// 指明邮件的收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(
				"*****@126.com"));
		// 邮件的标题
		message.setSubject("QQ邮件测试");
		// 邮件的文本内容
		message.setContent("发送邮件成功！", "text/html;charset=UTF-8");
		// 返回创建好的邮件对象
		return message;
	}
}
```


###QQ邮箱生成授权码的位置:

![](http://img.blog.csdn.net/20160821133306619)

###126邮箱接收结果：
![](http://img.blog.csdn.net/20160821133341338)


##发送有附件的邮件

相对于没带附件的：用MimeBodyPart来构建体，向体中添加内容，附件。最后利用MimeMultipart  ---addBodyPart(body); 把体加入。

这里需要一个activation包。

```
@Test//发送含附件的邮件
	public void send2() throws Exception{
		//跟smtp服务器建立一个连接
		Properties p = new Properties();
		// 开启debug调试，以便在控制台查看
		p.setProperty("mail.debug", "true");
		p.setProperty("mail.host", "smtp.sina.com");//指定邮件服务器，默认端口 25
		p.setProperty("mail.smtp.auth", "true");//要采用指定用户名密码的方式去认证
		// 发送邮件协议名称
		p.setProperty("mail.transport.protocol", "smtp");
		
		// 开启SSL加密，否则会失败
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.ssl.socketFactory", sf);
		
		// 创建session
		Session session = Session.getInstance(p);
		
		// 通过session得到transport对象
		Transport ts = session.getTransport();
		
		// 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
		ts.connect("smtp.qq.com", "61*****29", "jnjt*******bdab");
		// 后面的字符是授权码，不能用qq密码
		
		//声明一个Message对象(代表一封邮件),从session中创建
		MimeMessage msg = new MimeMessage(session);
		//邮件信息封装
		//1发件人
		msg.setFrom( new InternetAddress("61******29@qq.com") );
		//2收件人
		msg.setRecipient(RecipientType.TO, new InternetAddress("ch*****ox@126.com") );
		//3邮件内容:主题、内容
		msg.setSubject("这是我用Java发来的邮件--带附件的....");
		
		//添加附件部分
		//邮件内容部分1---文本内容
		MimeBodyPart body0 = new MimeBodyPart(); //邮件中的文字部分
		body0.setContent("这是两张<font color='red'>图片</font>....","text/html;charset=utf-8");
		
		//邮件内容部分2---附件1
		MimeBodyPart body1 = new MimeBodyPart(); //附件1
		body1.setDataHandler( new DataHandler( new FileDataSource("./imgs/1.jpg")) );//./代表项目根目录下
		
		body1.setFileName( MimeUtility.encodeText("中文1.jpg") );//中文附件名，解决乱码
		
		//邮件内容部分3---附件2
		MimeBodyPart body2 = new MimeBodyPart(); //附件2
		body2.setDataHandler( new DataHandler( new FileDataSource("./imgs/2.jpg")) );
		body2.setFileName("2.jpg");
		
		//把上面的3部分组装在一起，设置到msg中
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(body0);
		mm.addBodyPart(body1);
		mm.addBodyPart(body2);
		msg.setContent(mm);
		
		// 发送邮件
		ts.sendMessage(msg,msg.getAllRecipients());
		ts.close();
	}
```

接收结果：

![](http://img.blog.csdn.net/20160821140431128)

##小知识点:

1.必须先启用QQ邮箱里POP3/STMP服务；然后生成授权码

2.导入mail.jar包和activation包
mail.jar和activation-1.1.0.jar链接:
https://github.com/chenhaoxiang/Java/tree/master/JavaMail

3.要在代码里加上开启SSL加密的代码(老版本的mail中没有MailSSLSocketFactory类)

4.密码不是QQ密码，而是授权码！


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
