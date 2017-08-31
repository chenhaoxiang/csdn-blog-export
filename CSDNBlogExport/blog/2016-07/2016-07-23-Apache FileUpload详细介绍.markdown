---
layout: post
title: "Apache FileUpload详细介绍"
date: 2016-07-23 01:38:30 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ⑥、框架/第三方工具
tags: [apache,html,php,服务器]
keyword: 陈浩翔, 谙忆
description: Apache FileUpload组件在最初的 http 协议中，没有上传文件方面的功能。RFC1867（”Form-based File Upload in HTML”.）为 http 协议添加了这个功能。客户端的浏览器，如 Microsoft IE, Mozila, Opera 等，按照此规范将用户指定的文件发送到服务器。服务器端的网页程序，如 php, asp, jsp 等，可以按照此规范，解 
---


Apache FileUpload组件在最初的 http 协议中，没有上传文件方面的功能。RFC1867（”Form-based File Upload in HTML”.）为 http 协议添加了这个功能。客户端的浏览器，如 Microsoft IE, Mozila, Opera 等，按照此规范将用户指定的文件发送到服务器。服务器端的网页程序，如 php, asp, jsp 等，可以按照此规范，解
<!-- more -->
----------

Apache FileUpload组件
===================

在最初的 http 协议中，没有上传文件方面的功能。RFC1867（"Form-based File Upload in HTML".）为 http 协议添加了这个功能。客户端的浏览器，如 Microsoft IE, Mozila, Opera 等，按照此规范将用户指定的文件发送到服务器。服务器端的网页程序，如 php, asp, jsp 等，可以按照此规范，解析出用户发送来的文件。

1.1、客户端
-------

简单来说，RFC1867规范要求http协议增加了file类型的input标签，用于浏览需要上传的文件。同时要求FORM表单的enctype属性设置为“multipart/form-data”，method属性设置为“post”即可，下面是我们文。件上传页面的表单代码：

```
<form action="<%=request.getContextPath()%>/Upload3Servlet" 
 method="post" 
 enctype="multipart/form-data">
File1:<input type="file" name="file"/><br/>
Desc:<input type="text" name="desc"/><br/>
<input type="submit" value="提交"/>
</form>
```

1.2、服务器端
--------

一个文件上传请求的消息实体由一系列根据 RFC1867（"Form-based File Upload in HTML".）编码的项目（文本参数和文件参数）组成。自己编程来解析获取这些数据是非常麻烦的，还需要了解RFC1867规范对请求数据编码的相关知识。FileUpload 可以帮助我们解析这样的请求，将每一个项目封装成一个实现了FileItem接口的对象，并以列表的形式返回。所以，我们只需要了解FileUpload的API如何使用即可，不用管它们的底层实现。
让我们来看一个简单文件上传处理代码：

```
package cn.itcast.servlet;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
/**
 * 文件上传
 */
public class UploadServlet extends HttpServlet {
@SuppressWarnings("unchecked")
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
DiskFileItemFactory f = new DiskFileItemFactory();//磁盘对象
f.setRepository(new File("d:/a")); //设置临时目录
f.setSizeThreshold(1024*8); //8k的缓冲区,文件大于8K则保存到临时目录
ServletFileUpload upload = new ServletFileUpload(f);//声明解析request的对象
upload.setHeaderEncoding("UTF-8"); //处理文件名中文
upload.setFileSizeMax(1024 * 1024 * 5);// 设置每个文件最大为5M
upload.setSizeMax(1024 * 1024 * 10);// 一共最多能上传10M
String path = getServletContext().getRealPath("/imgs");//获取文件要保存的目录
try {
List<FileItem> list = upload.parseRequest(request);// 解析
for (FileItem ff : list) {
if (ff.isFormField()) {
String ds = ff.getString("UTF-8");//处理中文
System.err.println("说明是:" + ds);
} else {
String ss = ff.getName();
ss = ss.substring(ss.lastIndexOf("\\") + 1);//解析文件名
FileUtils.copyInputStreamToFile( //直接使用commons.io.FileUtils
ff.getInputStream(),
new File(path + "/" + ss));
}
}
} catch (Exception e) {
e.printStackTrace();
}
}
}
```

1.3、FileItem接口
==============

org.apache.commons.fileupload.disk.DiskFileItem实现了FileItem接口，用来封装单个表单字段元素的数据。通过调用FileItem 定义的方法可以获得相关表单字段元素的数据。我们不需要关心DiskFileItem的具体实现，在程序中可以采用FileItem接口类型来对DiskFileItem对象进行引用和访问。FileItem类还实现了Serializable接口，以支持序列化操作。

FileItem类常用的方法：
---------------

1. boolean isFormField()方法
--------------------------

isFormField方法用于判断FileItem类对象封装的数据是一个普通文本表单字段，还是一个文件表单字段，如果是普通表单字段则返回true，否则返回false。

2. String getName()方法
---------------------

getName方法用于获得文件上传字段中的文件名，即表单字段元素描述头中的filename属性值，如“C:\Documents and Settings\All Users\Documents\My Pictures\示例图片\Sunset.jpg”。如果FileItem类对象对应的是普通表单字段，getName方法将返回null。

即使用户没有通过网页表单中的文件字段传递任何文件，但只要设置了文件表单字段的name属性，浏览器也会将文件字段的信息传递给服务器，只是文件名和文件内容部分都为空，但这个表单字段仍然对应一个FileItem对象，此时，getName方法返回结果为空字符串""，读者在调用Apache文件上传组件时要注意考虑这个情况。

注意：上面的数据包是通过IE提交，所以是完整的路径和名称。如 
C:\Documents and Settings\All Users\Documents\My Pictures\示例图片\Sunset.jpg。如果是其它浏览器，如火狐和Chromium，则仅仅是名字，没有路径，如Sunset.jpg。


3. String getFieldName()方法
--------------------------

getFieldName方法用于返回表单字段元素描述头的name属性值，也是表单标签name属性的值。例如“name=file1”中的“file1”。

4. void write(File file)方法
--------------------------

write方法用于将FileItem对象中保存的主体内容保存到某个指定的文件中。如果FileItem对象中的主体内容是保存在某个临时文件中，该方法顺利完成后，临时文件有可能会被清除。该方法也可将普通表单字段内容写入到一个文件中，但它主要用途是将上传的文件内容保存在本地文件系统中。

5. String getString()方法
-----------------------

getString方法用于将FileItem对象中保存的数据流内容以一个字符串返回，它有两个重载的定义形式：

```
public java.lang.String getString()
public java.lang.String getString(java.lang.String encoding)　throws java.io.UnsupportedEncodingException
```

前者使用缺省的字符集编码将主体内容转换成字符串，后者使用参数指定的字符集编码将主体内容转换成字符串。如果在读取普通表单字段元素的内容时出现了中文乱码现象，请调用第二个getString方法，并为之传递正确的字符集编码名称。


6. String getContentType()方法
----------------------------

getContentType 方法用于获得上传文件的类型，即表单字段元素描述头属性“Content-Type”的值，如“image/jpeg”。如果FileItem类对象对应的是普通表单字段，该方法将返回null。

7. boolean isInMemory()方法
-------------------------

isInMemory方法用来判断FileItem对象封装的数据内容是存储在内存中，还是存储在临时文件中，如果存储在内存中则返回true，否则返回false。

8. void delete()方法
------------------

delete方法用来清空FileItem类对象中存放的主体内容，如果主体内容被保存在临时文件中，delete方法将删除该临时文件。尽管当FileItem对象被垃圾收集器收集时会自动清除临时文件，但及时调用delete方法可以更早的清除临时文件，释放系统存储资源。另外，当系统出现异常时，仍有可能造成有的临时文件被永久保存在了硬盘中。

9. InputStream getInputStream()方法
---------------------------------

以流的形式返回上传文件的数据内容。

10. long getSize()方法
--------------------

返回该上传文件的大小（以字节为单位）。

1.4、DiskFileItemFactory
=======================

此类将请求消息实体中的每一个项目封装成单独的DiskFileItem (FileItem接口的实现) 对象的任务由 

```
org.apache.commons.fileupload.FileItemFactory 接口的默认实现 org.apache.commons.fileupload.disk.DiskFileItemFactory 来完成。
```

当上传的文件项目比较小时，直接保存在内存中（速度比较快），比较大时，以临时文件的形式，保存在磁盘临时文件夹（虽然速度慢些，但是内存资源是有限的）。

属性：
---

**1) public static final int DEFAULT_SIZE_THRESHOLD ：**
将文件保存在内存还是磁盘临时文件夹的默认临界值，值为10240，即10kb。
**2) private File repository：**
用于配置在创建文件项目时，当文件项目大于临界值时使用的临时文件夹，默认采用系统默认的临时文件路径，可以通过系统属java.io.tmpdir 
获取。代码：System.getProperty("java.io.tmpdir");
**3) private int sizeThreshold：**
用于保存将文件保存在内存还是磁盘临时文件夹的临界值。

构造方法：
-----

**1) public DiskFileItemFactory()：**
采用默认临界值和系统临时文件夹构造文件项工厂对象。
**2) public DiskFileItemFactory(int sizeThreshold,File repository)：**
采用参数指定临界值和系统临时文件夹构造文件项工厂对象。
其他方法：
**1、FileItem createItem() 方法**
根据DiskFileItemFactory相关配置将每一个请求消息实体项目创建 成DiskFileItem 实例，并返回。该方法从来不需要我们亲自调用，FileUpload组件在解析请求时内部使用。
**2、void setSizeThreshold(int sizeThreshold)**
Apache文件上传组件在解析上传数据中的每个字段内容时，需要临时保存解析出的数据，以便在后面进行数据的进一步处理（保存在磁盘特定位置或插入数据库）。因为Java虚拟机默认可以使用的内存空间是有限的，超出限制时将会抛出“java.lang.OutOfMemoryError”错误。如果上传的文件
很大，例如800M的文件，在内存中将无法临时保存该文件内容，Apache文件上传组件转而采用临时文件来保存这些数据；但如果上传的文件很小，例如600个字节的文件，显然将其直接保存在内存中性能会更加好些。
**3、setSizeThreshold**
方法用于设置是否将上传文件已临时文件的形式保存在磁盘的临界值（以字节为单位的int值），如果从没有调用该方法设置此临界值，将会采用系统默认值10KB。对应的getSizeThreshold() 方法用来获取此临界值。
**4、void setRepository(File repository)**
setRepositoryPath方法用于设置当上传文件尺寸大于setSizeThreshold方法设置的临界值时，将文件以临时文件形式保存在磁盘上的存放目录。有一个对应的获得临时文件夹的 File getRespository() 方法。
注意：当从没有调用此方法设置临时文件存储目录时，默认采用系统默认的临时文件路径，可以通过系统属性 java.io.tmpdir 获取。
如下代码：
System.getProperty("java.io.tmpdir");
Tomcat系统默认临时目录为
`“<tomcat安装目录>/temp/”。`

说明：
使用List<FileItem>list=servletFileUpload.parseRequest(httpServletRequest);方法，则临时目录受用户设置的管理。
即，如果用户设置的临时目录为d:/a，则当文件上传大于，大于缓冲区设置时会向d:/a下保存临时文件。如果用户没有设置临时目录，才会将临时文件保存到CATALINA_HOME\temp目录下。

```
此种方式保存的临时文件名为：upload_2eb46fea_13615ef5327__8000_00000000.tmp
```

使用
FileItemIterator fii=servletFileUpload.getItemIterator(httpServletRequest)方法时，则不受用户设置临时目录的影响。

总是会将文件保临时文件保存到CATALINA_HOME\temp目录下。
此种情况下保存的临时文件名为：hsperfdata_Administrator　（这是一个文件夹，用里面的文件做为数据交互）
图示：
 

1.5、ServletFileUpload类
======================

org.apache.commons.fileupload.servlet.ServletFileUpload类是Apache文件上传组件处理文件上传的核心高级类（所谓高级就是不需要管底层实现，暴露给用户的简单易用的接口）。

使用其 parseRequest(HttpServletRequest) 方法可以将通过表单中每一个HTML标签提交的数据封装成一个FileItem对象，然后以List列表的形式返回。使用该方法处理上传文件简单易用。

如果你希望进一步提高性能，你可以采用 getItemIterator 方法，直接获得每一个文件项的数据输入流，对数据做直接处理。

在使用ServletFileUpload对象解析请求时需要根据DiskFileItemFactory对象的属性 sizeThreshold（临界值）和repository（临时目录） 来决定将解析得到的数据保存在内存还是临时文件中，如果是临时文件，保存在哪个临时目录中？

所以，我们需要在进行解析工作前构造好DiskFileItemFactory对象，
通过ServletFileUpload对象的构造方法或setFileItemFactory()方法设置 ServletFileUpload对象的fileItemFactory属性。
ServletFileUpload的继承结构为：
 

构造方法：
-----

**1) public ServletFileUpload()：**
构造一个未初始化的实例，需要在解析请求之前先调用setFileItemFactory()方法设置 fileItemFactory属性。
**2) public ServletFileUpload(FileItemFactory fileItemFactory)：**
构造一个实例，并根据参数指定的FileItemFactory 对象，设置 

fileItemFactory属性。
------------------

ServletFileUpload类常用方法：
**1. public void setSizeMax(long sizeMax)**
方法setSizeMax方法继承自FileUploadBase类，用于设置请求消息实体内容（即所有上传数据）的最大尺寸限制，以防止客户端恶意上传超大文件来浪费服务器端的存储空间。其参数是以字节为单位的long型数字。
在请求解析的过程中，如果请求消息体内容的大小超过了setSizeMax方法的设置值，将会抛出FileUploadBase内部定义的SizeLimitExceededException异常(FileUploadException的子类)。
如：

```
org.apache.commons.fileupload.FileUploadBase$SizeLimitExceededException: 
the request was rejected because its size (1649104) exceeds the configured 
maximum (153600)
```
该方法有一个对应的读方法：public long getSizeMax()方法。

**2. public void setFileSizeMax(long fileSizeMax)**
方法setFileSizeMax方法继承自FileUploadBase类，用于设置单个上传文件的最大尺寸限制，以防止客户端恶意上传超大文件来浪费服务器端的存储空间。其参数是以字节为单位的long型数字。
该方法有一个对应的读方法：public long geFileSizeMax()方法。
在请求解析的过程中，如果单个上传文件的大小超过了setFileSizeMax方法的设置值，将会抛出FileUploadBase内部定义的FileSizeLimitExceededException异常(FileUploadException的子类)。
如：

```
org.apache.commons.fileupload.FileUploadBase$FileSizeLimitExceededException: The field file1 exceeds its
  maximum permitted size of 51200 characters.
```

**3. public List parseRequest(javax.servlet.http.HttpServletRequest req)**

parseRequest 方法是ServletFileUpload类的重要方法，它是对HTTP请求消息体内容进行解析的入口方法。它解析出FORM表单中的每个字段的数据，并将它们分别包装成独立的FileItem对象，然后将这些FileItem对象加入进一个List类型的集合对象中返回。

该方法抛出FileUploadException异常来处理诸如文件尺寸过大、请求消息中的实体内容的类型不是“multipart/form-data”、IO异常、请求消息体长度信息丢失等各种异常。每一种异常都是FileUploadException的一个子类型。

**4. public FileItemIterator getItemIterator(HttpServletRequest request)**

getItemIterator方法和parseRequest 方法基本相同。
但是getItemIterator方法返回的是一个迭代器，该迭代器中保存的不是FileItem对象，而是FileItemStream 对象，如果你希望进一步提高性能，你可以采用 getItemIterator 方法，直接获得每一个文件项的数据输入流，做底层处理；
如果性能不是问题，你希望代码简单，则采用parseRequest方法即可。 

**5. public stiatc boolean isMultipartContent(HttpServletRequest req)**
isMultipartContent方法方法用于判断请求消息中的内容是否是“multipart/form-data”类型，是则返回true，否则返回false。

isMultipartContent方法是一个静态方法，不用创建ServletFileUpload类的实例对象即可被调用。


**6. getFileItemFactory()和setFileItemFactory(FileItemFactory)**

两个方法继承自FileUpload类，用于设置和读取fileItemFactory属性。

**7. public void setProgressListener(ProgressListener pListener)**
设置文件上传进度监听器。该方法有一个对应的读取方法：
ProgressListener getProgressListener()。

**8.public void setHeaderEncoding()方法**

在文件上传请求的消息体中，除了普通表单域的值是文本内容以外，文件上传字段中的文件路径名也是文本，在内存中保存的是它们的某种字符集编码的字节数组，Apache文件上传组件在读取这些内容时，必须知道它们所采用的字符集编码，才能将它们转换成正确的字符文本返回。

setHeaderEncoding方法继承自FileUploadBase类，用于设置上面提到的字符编码。
如果没有设置，则对应的读方法getHeaderEncoding()方法返回null，将采用HttpServletRequest设置的字符编码，如果HttpServletRequest的字符编码也为null，则采用系统默认字符编码。
可以通过一下语句获得系统默认字符编码：
System.getProperty("file.encoding"));



1.6、FileItemStream性能提升
======================

以下是使用FileItemStream三次上传一个70M文件的时间：
文件名为：电影.avi
Desc:这是信息
用时:1516
文件名为：电影.avi
Desc:这是信息
用时:703
文件名为：电影.avi
Desc:这是信息
用时:656
对比：
以下是用FileItem三次上传一个70M文件的时间：
文件名为：电影.avi
说明是:这是信息
用时:1687
文件名为：电影.avi
说明是:这是信息
用时:2578
文件名为：电影.avi
说明是:这是信息
用时:2297
可见：FileItemSteam（servletFileUpload.getItemIterator(httpServletRequest)）速度要快于FileItem(servletFileUpload.parseRequest(request))速度。
且一般情况下，FileItemSteam不产生临时文件：

源代码：

```
package cn.itcast.servlet;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
/**
 * FileItemStream示例
 * @author <a href="mailto:wj@itcast.cn">王健</a>
 * @version 1.0 2012-3-15
 */
public class Upload3Servlet extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
long start = System.currentTimeMillis();
String path = getServletContext().getRealPath("/imgs");
DiskFileItemFactory factory = new DiskFileItemFactory();
factory.setSizeThreshold(1024 * 8);// 设置8k的缓存空间
factory.setRepository(new File("d:/a"));
ServletFileUpload upload = new ServletFileUpload(factory);
upload.setHeaderEncoding("UTF-8");// 设置文件名处理中文编码
try {
FileItemIterator fii = upload.getItemIterator(request);// 使用遍历类
while (fii.hasNext()) {
FileItemStream fis = fii.next();
if (fis.isFormField()) {//FileItemStream同样使用OpenStream获取普通表单的值
InputStreamReader in = new InputStreamReader(fis.openStream(),"UTF-8");
Scanner sc = new Scanner(in);
StringBuffer sb = new StringBuffer();
if(sc.hasNextLine()){
sb.append(sc.nextLine());
}
System.err.println("Desc:"+sb.toString());
} else {
String fileName = fis.getName();
fileName = fileName
.substring(fileName.lastIndexOf("\\") + 1);
System.err.println("文件名为：" + fileName);
InputStream in = fis.openStream();
FileUtils.copyInputStreamToFile(in, new File(path+"/"+fileName));
}
}
} catch (FileUploadException e) {
e.printStackTrace();
}
long end = System.currentTimeMillis();
System.err.println("用时:"+(end-start));
}
}
```



1.7、FileCleanerCleanup清理资源
==========================

只适用于你使用 DiskFileItem 的情况.换句话说,就是在你处理上传的数据之前它们被存放在临时文件中。

这些临时文件在不再被使用的时候(如果相应的java.io.File是可回收的则更好)会自动被删除.
这会被org.apache.commons.io.FileCleaningTracker的一个实例启动的一个收割线程默默执行。
你的web应用应该使用org.apache.commons.fileupload.FileCleanerCleanup的一个实例.那很简单,你只要把它加到你的 web.xml 中:

```
  <listener>
  <listener-class>org.apache.commons.fileupload.servlet.FileCleanerCleanup</listener-class>
  </listener>
```

然后，在创建了DiskFileItemFactory以后，设置资源回收：

```
DiskFileItemFactory f = new DiskFileItemFactory();//声明临时文件对象
f.setFileCleaningTracker(FileCleanerCleanup.getFileCleaningTracker(this.getServletContext()));
f.setSizeThreshold(1024*8); //设置在内存中最多可以放多少个字节，如果超出这个字节，保存到临文件中去
f.setRepository(new File("d:/a")); //设置临时目录
```

注意：必须要正常关闭Tomcat服务器。因为此线程在tomcat终止时会调用清空临时文件的代码。
正常关闭，是指执行CATALINA_HOME\bin\shutdown.bat文件。


1.8、进度ProgressListener
======================

这个进度条比较合适于在后台监控进度，如果在作上传进度，还是使用ajax更加合适：

示例代码：

```
upload.setProgressListener(new ProgressListener() {
double dd = 0;
long len = 0;
//参数1:已经上传完成的数量
//参数2:总长度
//参数3:第几个元素从1开始。0为没有
public void update(long pBytesRead, long pContentLength, int pItems) {
double persent = pBytesRead*100/pContentLength;
if(dd!=persent){
System.err.println(dd+"%");
dd=persent;
}else if(persent==100){
System.err.println("100%");
}
}
});
```




本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
