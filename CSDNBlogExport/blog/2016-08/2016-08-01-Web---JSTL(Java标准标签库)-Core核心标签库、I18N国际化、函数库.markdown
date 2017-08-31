---
layout: post
title: "Web---JSTL(Java标准标签库)-Core核心标签库、I18N国际化、函数库"
date: 2016-08-01 04:21:59 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- JSP/XML知识点
tags: [国际化,java,JSTL,JSP,Web]
keyword: 陈浩翔, 谙忆
description: 前面为JSTL中的常用EL函数，后面的为具体演示实例！JSTL简介：JSTL(Java Standard Tag Library) –Java标准标签库。 
SUN公司制定的一套标准标签库的规范。 
 JSTL标签库，是由一些Java类组成的。JSTL组成：JSTL –Core 核心标签库。 重点 
JSTL – I18N － 国际化标签库。Internationalization-    I18N 
---


前面为JSTL中的常用EL函数，后面的为具体演示实例！JSTL简介：JSTL(Java Standard Tag Library) –Java标准标签库。 
SUN公司制定的一套标准标签库的规范。 
 JSTL标签库，是由一些Java类组成的。JSTL组成：JSTL –Core 核心标签库。 重点 
JSTL – I18N － 国际化标签库。Internationalization-    I18N
<!-- more -->
----------

前面为JSTL中的常用EL函数，后面的为具体演示实例！

JSTL简介：
=======

JSTL(Java Standard Tag Library) –Java标准标签库。
SUN公司制定的一套标准标签库的规范。
 JSTL标签库，是由一些Java类组成的。


JSTL组成：
-------

JSTL –Core 核心标签库。 重点
JSTL – I18N － 国际化标签库。Internationalization-    I18N
JSTL – SQL – 数据库操作标签(有悖于MVC设计模式),现在都不用这个。
JSTL － Functions – 函数库。
JSTL － XML ，对XML的操作(同SQL标签-有悖于MVC设计模式)，现在都不用这个。


JSTL核心标签库：
==========

使用JSTL核心标签：
如果你的Web项目是基于JavaEE2.5或以上的。可以在你项目的任意页面上通过<%@ taglib 指令使用JSTL的核心标签库。

```
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
```

uri是引用标签库的资源定位符，并不代表一个实际的地址。
Prefix是自定义的前缀。

如果你的项目是JavaEE2.5以下的项目，必须在在你项目中的lib目录下，存在以下两个jar文件为：
Jstl.jar、standard.jar
在上面的包中，存在着jstl的tld文件，用于描述jstl标签的属性、名称、资源等信息。
程序就是通过这个tld文件找到相关java类以供运行的。
然后再在任意的JSP页面通过指令导入jstl.


JSTL-Core一共包含以下几个子标签：
---------------------


```
<c:out> ${name}	输出标签
<c:set>   		pageContext.setAttirbute(key,value,scope);	声明标签
C:remove		删除某个范畴内的数据
<c:if>			判断c:else,c:elsfif
<c:choose><c:when><c:otherwise>	判断分枝c:if,c:else if c:
<c:forEach>		遍历
<c:forTokens>	分隔
<c:import>		导入其他资源,相当于动态包含共享同一个request
<c:url>  - 		重写url
<c:redirect>	重定向  response.sendRedirect(‘’..)
```

JSTL标签－out：

```
属性名			可选值							 说明
value	EL表达式、java表达式、或直接字符串	需要输出的内容
escapeXml	 true | false	  是否将html转成&lt;&gt;&quat;等输出。
default	       默认值       	如果value内容不存在时则输出默认值
```

```
<c:out  value=…/>用于在页面上输出结果。
<c:out value=“${requestScope.name}”/> -将request中的name值输出
<c:out value=“${param.username}”/> - 用于将参数输出到页面上。
<c:out value=“${name}” default=“hello”/>从page到application开始查找，如果没有找到，就显示默认值hello.
另一种设置默认值的方式：
<c:out value=“${name}”>
Default-value-默认值。
</c:out>
只有当要求的信息为null或不存在时才会输出默认值。
excapeXml属性：默认值为true,用于将html等标签转换成&lt;等转换元素，示例：
 <%
     String name="<font color='red'>Red</font>";
      pageContext.setAttribute("name",name);
  %>
<c:out value=“${name}” escapeXml=“false”></c:out> 不对xml或html进行转换，直接输出，这样就会在页面上看到红色的Red字符，因为浏览器会解析html数据。
```


JSTL-Core的演示：(通常命名为c命名空间)
---------------------

-----jstl.jsp:
---------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
	  <h1>JSTL技术演示</h1>

  	  <!-- c:out -->
  	  <%
  	  	pageContext.setAttribute("name", "Tom");
  	  	pageContext.setAttribute("name2", "<font color='red'>Tom</font>");
  	  %>
	  <c:out value="${name}"></c:out><br/>
	  
	  ${name}<br/>
	  
	  <c:out value="${name2}" escapeXml="true" /><br/>
	  ${name2}<br/>
	  	
	  <!-- c:if -->
	  <c:if test="${20>10}" var="boo" scope="session">
	  	OKOK<br/>
	  </c:if>
	  <!-- 想要用if-else 就这样再用一句 -->
  	  <c:if test="${!boo}">
  	  	NONO<br/>
  	  </c:if>
  	  
  	  <br/><!-- 用El中的问号表达式能输出简单的if-else -->
  	  ${ 20>10?"yes":"no" }<br/>
  	  
  	  <hr/>
  	  <!-- forEach -->
  	  <%
	  	List list = new ArrayList();
	 	list.add("aaaaa111");
	 	list.add("bbbbb222");
	 	list.add(200);
	 	list.add(100);
	  	request.setAttribute("list", list);
	  %>
	  <table border="1px">
	 	<c:forEach items="${list}" var="li">
	  		<tr> <td>:: ${li}</td>  </tr>
	  	</c:forEach>
  	  </table>
  	  
  	  <%
  	  	Map<String,Object> map = new HashMap<String,Object>();
  	  	map.put("name", "Pose");
  	  	map.put("age", 55);
  	  	map.put("tel", "12345678911");
		pageContext.setAttribute("map", map);  	  
  	  %>
  	  <br/>
  	  <c:forEach items="${map}" var="m">
  	  	${m.key} = ${m.value}<br/>
  	  </c:forEach>
  	  
  	  <%
  	  	String strs[] = {"aaa","bbb","ccc","ddd"};
  	  	pageContext.setAttribute("strs", strs);
  	  %>
  	  <br/>
  	  <c:forEach items="${strs}" var="str">
		${str},  	  
  	  </c:forEach>
  	  <br/>
  	  
  	  <h3>看看forEach标签中的varStatus属性---idx.index是输出元素的下标(从begin开始的)，idx.count是元素的计数(从1开始)</h3>
  	  <c:forEach items="${strs}" var="str" varStatus="idx">
		${str}---index = ${idx.index} --- count=${idx.count}<br/>  	  	
  	  </c:forEach>
  	  
  	  <!-- forEach的普通循环功能 -->
  	  <c:forEach begin="20" end="40" var="i" step="2" varStatus="idx">
  	  	${i} -- ${idx.index} -- ${idx.count}<br/>
  	  </c:forEach>
  	  
  	  <br/>
  	  <!-- c:set设置属性，默认作用域：pageScope -->
  	  <c:set var="aa" value="abc123" />
  	  <c:set var="aa" value="cccc222" scope="request"/>
  	  ${aa},${requestScope.aa}<br/>
  	  
  	  <br/>
  	  
  	  <!-- c:remove 删除属性，默认作用域:pageScope,request等4个容器！ -->
  	  <!-- 也就是，如果不设置作用域(scope属性),则那4个容器中的属性都会被清除，如果写了，则只清除指定作用域的属性 -->
  	  <c:remove var="aa" scope="request"/>
  	  ${aa},${requestScope.aa}<br/>
  	  
  	  <!-- c:choose,c:when,c:otherwise  -->
  	  <!-- 类似Java中的switch-case-default而且每项自动带break -->
  	  <c:set var="score" value="98"></c:set>
  	  <c:choose>
  	  	<c:when test="${score>=90}">
  	  		优秀
  	  	</c:when>
  	  	<c:when test="${score>=80}">
  	  		良好
  	  	</c:when>
  	  	<c:when test="${score>=70}">
  	  		中等
  	  	</c:when>
  	  	<c:otherwise>
			不合格  	  	
  	  	</c:otherwise>
  	  </c:choose>
  	  
  	  <br/>
  	  <!-- c:forTokens 用分隔符去拆分字符串 -->
  	  <c:forTokens items="aa,ds,sdf,df,dddd,sss" delims="," var="str">
  	  	${str}&nbsp;
  	  </c:forTokens>
  	  <br/>
  	  
  	  <!-- c:import 导入资源，相当于动态包含，共享同一个request，但是在不同的类 -->
  	  <c:import url="/jsps/b.jsp"></c:import>
  	  <br/>
  	  
  	  <!-- c:redirect 重定向，相当于response.sendRedirect(...) -->
      <%-- 
      <c:redirect url="/jsps/a.jsp"></c:redirect>
  	  --%>
  	  
  	  
  	  <br/><br/><br/><br/>
  </body>
</html>

```

-----b.jsp:
------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<h3>这是被动态导入的页面内容...b.jsp...</h3>
  </body>
</html>

```

a.jsp就不写出来了，那个只是为了演示一些JSTL的重定向。a.jsp的源码没意义。


-----演示结果：
-----

![](http://img.blog.csdn.net/20160801021002701)





JSTL中的国际化--I18N:
================

在演示JSTL的国际化之前，我们先用java的国际化过渡下~

首先在src目录下配好这3个文件:

![](http://img.blog.csdn.net/20160801023224139)

依次设置值：(空行表示是另外一个文件中了，一共3文件)
```
welcome=welcome you---US
time=this time is:---US

welcome=\u6B22\u8FCE\u4F60---CN
time=\u73B0\u5728\u65F6\u95F4\u662F\uFF1A---CN

welcome=welcome
time=this time is:
```



I18nDemo.java
-------------

```
package cn.hncu.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nDemo {
	
	public static void main(String[] args){
		//参数是：baseName--本例指的是资源文件名是：msg.*.properties
		//ResourceBundle rd = ResourceBundle.getBundle("msg");//输出：欢迎你---CN:::现在时间是：---CN   //读取的是:msg_zh_CN.properties
		//ResourceBundle rd = ResourceBundle.getBundle("msg",Locale.US);//输出：welcome you---US:::this time is:---US   //读取的是:msg_en_US.properties
		ResourceBundle rd = ResourceBundle.getBundle("msg",Locale.CANADA);////输出：欢迎你---CN:::现在时间是：---CN   //读取的是:msg_zh_CN.properties
		//因为我们的是中文系统.如果没找到对应语种的资源文件(如果不存在时，会根据系统的国家语种再找一遍,如果还没有)，则是读取默认的:msg.properties
		System.out.println(rd.getString("welcome")+":::"+rd.getString("time"));
	}
}

```


通过上面Java的演示我们应该猜得到，SJTL的国际化应该和这个其实差不了多少的，毕竟jsp最后是翻译成Java的。


I18N标签简介：
---------

I18N是Internationalization的简称，因为I到N之间有18个字符所以叫i18n。

```
在java的核心库当中，提供了对i18n的支持，java.util.Locale类是最重要的i18n相关类。
首先介绍一下Locale类：
获取Locale类的实例，有以下几种方式：
Locale ch = new Locale(“zh”,”CN”);
Locale ch = Locale.CHINA;
或获取默认值：
Locale zh = Locale.getDefault();
然后可以通过以下方法输出语言和国家：
getLanguage
getCountry
```
Java.util.ResourceBundle类，用于管理和Locale相关的资源的功能。
ResourceBundle类提供了两个方法，用于创建ResourceBundle对像的静态工厂方法：
getBundle(String baseName)—通过此方法获取资源文件的名称
getBundle(String baseName,Locale locale);
参数中的baseName是资源文件的名称，资源文件通常以properties为扩展名。

资源文件的命名规则如下：
默认资源文件：resources.properties
英文资源文件：resources_en_US.properties
中文资源文件：resources_zh_CN.properties

演示代码：
---

再准备2个资源文件：
![](http://img.blog.csdn.net/20160801034406507)

里面分别只设：

```
address=beijing

address=\u5317\u4EAC
```

i18n.jsp:
---------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<fmt:setLocale value="zh_CN"/>
  	<fmt:setBundle basename="msg"/>
  	<!-- 如果是真正的搞国际化，应该把要设置Locale和Bundle的代码放在head标签中，页面只负责显示 -->
  </head>
  
  <body>
  	张三，<fmt:message key="welcome"></fmt:message>
  	<fmt:message key="time" /> 2016-**-**
  	<br/><hr/>
  	<!-- 相比上面的版本，把国家语种用参数来进行传递了 -->
  	<a href="?loc=en_US">English</a><!-- 这里href="?***" 直接加问号，就表示当前页面 -->
  	<a href="?loc=zh_CN">中文</a>
  	<fmt:setLocale value="${param.loc}"/>
  	<fmt:setBundle basename="msg"/>
  	张三，<fmt:message key="welcome"></fmt:message>
  	<fmt:message key="time" /> 2016-**-**
  	
  	<br/><hr/>
  	<!-- 再演示一下多个资源的情况，第二个资源及以后都必须取别名(变量名)。前面没取变量名的那个叫默认资源 -->
  	<fmt:setBundle basename="a" var="aaa" scope="session"/>
  	<!-- 如果有多个页面需要使用这个,那么把作用域设置成session就可以了 -->
  	
  	张三，<fmt:message key="welcome"></fmt:message>
  	<fmt:message key="time" /> 2016-**-**
  	<br/><br/>
  	<%-- 如果从非默认的资源中读取，那么得指定资源的别名这里是：aaa,得设置成：bundle="${aaa}"。如果没有指定名称，那么就是从默认的资源读取 --%>
  	<fmt:message key="address" bundle="${aaa}"></fmt:message>
  	<br/><br/>
  	
  	<a href='<c:url value="/jsps/c.jsp"></c:url>'>到网站的其他页面去看看~</a>
  
  </body>
</html>

```

c.jsp:
------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<!-- 从作用域是session的资源中读取 -->
  	<fmt:message key="address" bundle="${aaa}"></fmt:message>
  	<!-- i18n中aaa设的loc是什么这里就显示那个国家语言的资源文件 -->
  </body>
</html>

```

演示结果：
-----

选择中文：

![](http://img.blog.csdn.net/20160801034651305)

选择中文：

![](http://img.blog.csdn.net/20160801034659024)


当然，现在很多网站都不是这样来做国际化的，而是准备多套版本的网站，你点什么语言，我就给你跳到对应语言的网站去。
这样有一个很明显的不好，如果语种很多呢？难道准备那么多套网站，显然是不合理的，而用I18N只需要我们有一个网站模板，读取属性，配置对应的语种资源文件就可以了。在语种很多的情况下方便很多，架构当然无论是什么情况下，都是这个好些的。



JSTL中的常用EL函数
============

由于在JSP页面中显示数据时，经常需要对显示的字符串进行处理，SUN公司针对于一些常见处理定义了一套EL函数库供开发者使用。
这些EL函数在JSTL开发包中进行描述，因此在JSP页面中使用SUN公司的EL函数库，需要导入JSTL开发包，并在页面中导入EL函数库，
如下所示：(我们完全可以将JSTLl理解成EL函数库)
在页面中使用JSTL定义的EL函数：
```
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
```

fn:toLowerCase
--------------
fn:toLowerCase函数将一个字符串中包含的所有字符转换为小写形式，并返回转换后的字符串，它接收一个字符串类型的参数，例如
fn:toLowerCase("Www.IT315.org") 的返回值为字符串“www.it315.org”
fn:toLowerCase("")的返回值为空字符串


fn:toUpperCase
--------------

fn:toUpperCase函数将一个字符串中包含的所有字符转换为大写形式，并返回转换后的字符串，它接收一个字符串类型的参数。例如：
fn:toUpperCase("Www.IT315.org") 的返回值为字符串“WWW.IT315.ORG”
fn:toUpperCase("")的返回值为空字符串


fn:trim
-------

fn:trim函数删除一个字符串的首尾的空格，并返回删除空格后的结果字符串，它接收一个字符串类型的参数。需要注意的是，fn:trim函数不能删除字符串中间位置的空格。
例如，fn:trim("   www.it  315.org  ") 的返回值为字符串“www.it  315.org”。


fn:length
---------

fn:length函数返回一个集合或数组对象中包含的元素的个数，或返回一个字符串中包含的字符的个数，返回值为int类型。

fn:length函数接收一个参数，这个参数可以是`<c:forEach>`标签的items属性支持的任何类型，包括任意类型的数组、java.util.Collection、java.util.Iterator、java.util.Enumeration、java.util.Map等类的实例对象和字符串。

如果fn:length函数的参数为null或者是元素个数为0的集合或数组对象，则函数返回0；如果参数是空字符串，则函数返回0。 


fn:split
--------

fn:split函数以指定字符串作为分隔符，将一个字符串分割成字符串数组并返回这个字符串数组。

fn:split函数接收两个字符串类型的参数，第一个参数表示要分割的字符串，第二个参数表示作为分隔符的字符串。

例如，fn:split("www.it315.org", ".")[1]的返回值为字符串“it315”。


fn:join
-------

fn:join函数以一个字符串作为分隔符，将一个字符串数组中的所有元素合并为一个字符串并返回合并后的结果字符串。fn:join函数接收两个参数，第一个参数是要操作的字符串数组，第二个参数是作为分隔符的字符串。

如果fn:join函数的第二个参数是空字符串，则fn:join函数的返回值直接将元素连接起来。
例如：
假设stringArray是保存在Web域中的一个属性，它表示一个值为{"www","it315","org"}的字符串数组，则fn:join(stringArray, “.")返回字符串“www.it315.org”
fn:join(fn:split("www,it315,org", ","), ".") 的返回值为字符串“www.it315.org”


fn:indexOf
----------

fn:indexOf函数返回指定字符串在一个字符串中第一次出现的索引值，返回值为int类型。
fn:indexOf函数接收两个字符串类型的参数，如果第一个参数字符串中包含第二个参数字符串，那么，不管第二个参数字符串在第一个参数字符串中出现几次，fn:indexOf函数总是返回第一次出现的索引值；
如果第一个参数中不包含第二个参数，则fn:indexOf函数返回-1。
如果第二个参数为空字符串，则fn:indexOf函数总是返回0。
例如：
fn:indexOf("www.it315.org","t3") 的返回值为5


fn:contains
-----------

fn:contains函数检测一个字符串中是否包含指定的字符串，返回值为布尔类型。

fn:contains函数在比较两个字符串是否相等时是大小写敏感的。
fn:contains函数接收两个字符串类型的参数，如果第一个参数字符串中包含第二个参数字符串，则fn:contains函数返回true，否则返回false。

如果第二个参数的值为空字符串，则fn:contains函数总是返回true。实际上，fn:contains(string, substring)等价于fn:indexOf(string, substring) != -1。

如果想用忽略大小的EL函数：
那么就用：fn:containsIgnoreCase --参数和fn:contains函数一样


fn:startsWith
-------------

fn:startsWith函数用于检测一个字符串是否是以指定字符串开始的，返回值为布尔类型。

fn:startsWith函数接收两个字符串类型的参数，如果第一个参数字符串以第二个参数字符串开始，则函数返回true，否则函数返回false。如果第二个参数为空字符串，则fn:startsWith函数总是返回true。例如：

fn:startsWith("www.it315.org","it315")的返回值为false

与之对应的EL函数：fn:endsWith 



fn:replace
----------

fn:replace函数将一个字符串中包含的指定子字符串替换为其它的指定字符串，并返回替换后的结果字符串。fn:replace方法接收三个字符串类型的参数，第一个参数表示要操作的源字符串，第二个参数表示源字符串中要被替换的子字符串，第三个参数表示要被替换成的字符串。例如：

fn:replace("www it315 org", " ", ".")的返回值为字符串“www.it315.org”


fn:substring
------------


fn:substring函数用于截取一个字符串的子字符串并返回截取到的子字符串。fn:substring函数接收三个参数，
第一个参数是用于指定要操作的源字符串，
第二个参数是用于指定截取子字符串开始的索引值，
第三个参数是用于指定截取子字符串结束的索引值，第二个参数和第三个参数都是int类型，其值都从0开始。例如：

fn:substring("www.it315.org", 4, 9) 的返回值为字符串“it315”


fn:substringAfter
-----------------

fn:substringAfter函数用于截取并返回一个字符串中的指定子字符串第一次出现之后的子字符串。fn:substringAfter函数接收两个字符串类型的参数，第一个参数表示要操作的源字符串，第二个参数表示指定的子字符串，例如：

fn:substringAfter(“www.it315.org”, “.”)的返回值为字符串“it315.org”。

与之对应的EL函数为：fn:substringBefore 


这里我只演示几个常用的函数：

演示代码：
---

fn.jsp:
-------

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<c:set value="hello word function" var="str"></c:set>
  	${fn:indexOf(str,"wor")}<br/><br/>
  	${fn:contains(str,"Func")}<br/><br/>
  	${fn:containsIgnoreCase(str,"Func")}<br/><br/>
  	${fn:trim(str).length()}<br/>
  </body>
</html>

```

演示结果：
-----

![](http://img.blog.csdn.net/20160801041600631)

	${fn:indexOf(str,"wor")}  //从0开始第6个开始匹配上了wor，所以输出是：6
  	${fn:contains(str,"Func")} //区别大小写，str中不包含字符串"Func" ,输出为：false
  	${fn:containsIgnoreCase(str,"Func")}//不区分大小写，str中包含字符串"func"，输出位：true
  	${fn:trim(str).length()} //trim()返回去掉字符串首尾的空格length()返回字符串的长度"hello word function"---19

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
