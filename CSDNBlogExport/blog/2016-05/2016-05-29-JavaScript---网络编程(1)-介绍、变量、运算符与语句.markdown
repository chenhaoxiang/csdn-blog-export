---
layout: post
title: "JavaScript---网络编程(1)-介绍、变量、运算符与语句"
date: 2016-05-29 06:39:24 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,java,javascript,编程语言]
keyword: 陈浩翔, 谙忆
description: JavaScript也是一种编程语言。并不是Java的分支哦。 
可以直接在浏览器中运行的编程语言。JavaScript 的历史故事： 
1、JavaScript语言与名称的由来（Netscape，Sun Java） 
最开始是叫LiveScript的~有一个小故事，有兴趣的朋友可以u百度一下。 
2、微软的Explorer和JScriptJavaScript 概述 
JavaScript是基于对象 
---


JavaScript也是一种编程语言。并不是Java的分支哦。 
可以直接在浏览器中运行的编程语言。JavaScript 的历史故事： 
1、JavaScript语言与名称的由来（Netscape，Sun Java） 
最开始是叫LiveScript的~有一个小故事，有兴趣的朋友可以u百度一下。 
2、微软的Explorer和JScriptJavaScript 概述 
JavaScript是基于对象
<!-- more -->
----------

JavaScript也是一种编程语言。并不是Java的分支哦。
可以直接在浏览器中运行的编程语言。

JavaScript 的历史故事：
1、JavaScript语言与名称的由来（Netscape，Sun Java）
最开始是叫LiveScript的~有一个小故事，有兴趣的朋友可以去百度一下。
2、微软的Explorer和JScript


JavaScript 概述
JavaScript是基于对象和事件驱动的脚本语言，主要应用在客户端。
特点：
1.交互性（它可以做的就是信息的动态交互）
2.安全性（不允许直接访问本地硬盘）
3.跨平台性（只要是可以解释Js的浏览器都可以执行，和平台无关）


JavaScript与Java不同

1.JS是Netscape公司的产品，前身是LiveScript;Java是Sun公司的产品，现在是Oracle公司的产品。
2.JS是基于对象的(对象都做好了的)，Java是面向对象的(自己写对象的)。
3.JS只需解释就可以执行，Java需要先编译成字节码文件，再执行。
4.JS是弱类型，Java是强类型。


JavaScript与Html的结合方式：
想要将其他代码融入到Html中，都是以标签的形式。
```
1.JS代码存放在标签对<script> js code．．．</script>中。
2.当有多个html页面使用到相同的JS脚本时，可以将js代码封装到一个文件中，只要在script标签的src属性引入一个js文件。
（方便后期维护，扩展）
注意：如果在script标签中定义了src属性，那么标签中的内容不会被执行。
例：<script src=”test.js” type=”text/javascript”></script>
注：规范中script标签早期有一个属性language
（因为早期认为可能有多种脚本语言，然而到现在，还是JS一家独大~所以。）,而现在使用type属性。
```

演示：
```
<html>
  <head>
	<title>javascript语言演示</title>
  </head>
  <body>
   	<script type="text/javascript">
   		alert("hello world!")
   	</script>
  </body>
</html>

```
写法一：
```
	<script type="text/javascript">
   		alert("hello world!")
   	</script>
   	这一句放哪里都可以的。别放html标签外就可以了。
```
![](http://img.blog.csdn.net/20160529151001999)

写法二：

```
<script type="text/javascript" src="a.js">
   	</script>
```
![](http://img.blog.csdn.net/20160529152753256)

![](http://img.blog.csdn.net/20160529152613599)


不可以嵌套用！但是可以有很多个script 标签(但是注意顺序啊)
```
 	<!-- 注意，这种写法不行--包含在标签内的js代码无效 -->
   	<script type="text/javascript" src="a.js">
   		alert("hello world!222");//无效代码，被上面的导入方式覆盖了。
   	</script>
```



JavaScript语法

每一种语言都有自己的语法规则，JS语法与Java很像，所以学习起来比较容易。JS中也一样有变量，语句，函数，数组等常见语言组成元素。
1.变量
通过关键字var来定义，弱类型既是不用指定具体的数据类型。
例：var x = 3; x = “hello”;
注：JS中特殊的常量值：undefined，当变量没有初始化就被使用，该变量的值就是undefined（未定义）。
注意：Javascript的语句在结尾处是可以不用分号结束的，非严谨语言的特点。
但为了符合编程规范，需要象java一样定义结束符。
而且有些情况是必须写分号的，如：var x = 3 ; var y =5 如果两条语句写在同一行，就需要分号隔开。

代码演示：

```
<html>
  <head>
	<title>javascript语法 演示</title>
  </head>
  
  <script type="text/javascript">
  	//1标识符,关键字,分隔符---几乎和Java一样
  	
  	//2注释：只支持 //单行注释  和  /*  多行注释  */
  	
  	//3变量（弱类型）, var（全部用这个定义,只有这个变量）
  	//所有的变量都是用var来声明---本质上就是java当中的Object类型
  	
  	var x = 3;
  	var y = "abc";
  	alert(x+","+y);//弹出: 3,acb
  	
  	x="xyz";
  	alert(x);  //弹出：xyz
  	
  	x=true;
  	alert(x); //弹出：true
  	
  	x=true+1;//和c一样，布尔类型有0和非0(1)的概念
  	alert(x); //弹出：2
  	
  	a=3.14;
  	alert(a);// 因为浏览器有兼容性，所以一个变量不声明类型也可以直接对其赋值，但不要去读
  	//因为是弱类型，写不写都是var
  	//弹出：3.14
  	
  	//aa没有声明也没有赋值却直接读取了。
  	//alert(aa);//出错的。没有什么弹窗。也没有提示！
  	
  	alert( typeof(a) ); //弹出：number
	// typeof(a) 返回a的类型
	
	a=3;
  	alert( typeof(a) ); //弹出：number
  	
  	a=3.156441564165564616541564156;
  	alert(a);//弹出：3.1564415641655645
  	alert( typeof(a) );//弹出：number
  	
  	a=3156441564165564616541564156;
  	alert(a);//弹出：3156441564165565e+27
  	alert( typeof(a) );//弹出：number
  	
  	a='a';
  	//JS当中，单引号和双引号是一样的，对应的变量都是字符串
  	//也就是说JS中没有字符类型---包含在字符串当中了。字符串只有一个字符时~
  	
  	//不用分号
  	var m=1
  	var n=2
  	alert(m+n);//弹出：3
  	//由于浏览器有兼容性，一条语句的末尾不加分号也可以正常执行。
  	//但这样写不规范，建议还是加上。
  	
  	//var mm=1 var nn=2;
  	//alert(mm+nn);//直接挂了。
  	//另外，同一行的多条语句之间的分号不能省，否则不能正常执行。
  </script>
  
  <script type="text/javascript">
  	//4 基本数据类型
  	alert( typeof("aaaa") );//弹出：string
  	//注意string是小写的
  	alert(typeof('0') );//弹出：string
  	
  	alert( typeof(false) );//弹出：boolean
  	
  	alert( typeof(100) );//弹出：number
  	alert( typeof(1.23) );//弹出number
	
	//判断是哪种类型
	alert( typeof('0')=="string" );//弹出：true
	alert( typeof('0')=="String" );//（大小写敏感）弹出：false
	//其他类型判断类似
	
	alert( typeof(x) );//一样可以。前面片段中，在这里仍然是有效的(所以说。注意顺序)
	alert( typeof(X) );//大小写敏感的！（没定义）弹出：undefined 
	
	//使用单引号和双引号效果是一样的
	alert( typeof(x)=='number');//弹出：true
  </script>
  
  <body>
  </body>
</html>

```


2.运算符
Javascript中的运算符和Java大致相同。
只是运算过程中需要注意几点：
1，var x = 3120/1000*1000; x = 3120;而不是3000。
2，var x = 2.4+3.6 ; x = 6;而不是6.0
3，var x = “12” + 1; x = “121”; x = “12” – 1 ; x = 11;
加号对于字符串是连接符
4，&&  || 是逻辑运算符  & | 是位运算符。
5，也支持三元运算符
6，特殊运算符 typeof : 返回一个操作表达式的数据类型的字符串。
var x = 3;
var y = “123”;
var z = false;
typeof(x); //number
typeof(y); //string
typeof(z); //boolean

代码演示：

```
 <script type="text/javascript">
  	//5 运算符：算术、赋值、比较、位运算、三元运算
  	
  	//5.1算术运算
	var a = 3710;
	alert("a="+a/1000);//a=3.71  	
	alert("a="+a/1000*1000);//a=3710
	var b = 2.3;
	var c = 5.7;
	alert( b+c );//	8
	alert( 23+11 ); //34
	
	alert("23"+11);//2311---string---加号为字符串连接
	alert("23"-11);//12
	//字符串遇到减号自动会转换成数值型进行运算
	alert(false+1);//1   false是0
	//true 和数值进行运算时，true为1，false为0
	
	alert(100%3);//1  
	alert(100%-3);//1  
	alert(-100%3);//-1  如果有负数，结果和前面那个数同符号-和Java一样的
	
	//5.2 赋值运算：= += -= *= /= %=
	var n=3,m;
	m=n++;//用法同Java
	alert("n="+n+",m="+m);//n=4,m=3
	
	var n=3,m;//JS中变量可以声明几次--和Java不同
	m=++n;
	alert("n="+n+",m="+m);//n=4,m=4
	
	var n;
	alert(n);//4---这里没有对该变量重新赋值，所以用的还是前面n的值(内存还是同一片)
	
	var i=3;
	i+=3;//其他的类似 -= *= /= %=
	alert("i="+i);//i=6
	
	//5.3 比较运算符---和Java类似
	var j=10;
	alert(j>5);//true
	//其他如：>= <= > < == != 类似
	
	//5.4 逻辑运算符 && || !
	var k=4;
	alert(k>3 && k<10);//true
	alert( !(k>3) ); //false
	alert( !k );//false---和C一样
	
	//5.5 位运算符 & | ^ >> << >>>(无符号右移)---和Java一样
	var c = 6;//6：110
	alert( c&3 );//3：011
	//结果是：010 弹出：2
	
	alert( c^100^100 );//结果还是c -- 6
	alert(c>>>1);//3
	
	//5.6 三元运算符（问号表达式）
	alert( 3>0?100:300 );//100
	
	var xxyy;
	alert(xxyy);//undefined---如果一个变量声明后没有赋值，就是这个
	
	alert(xxyy==undefined);//这里不要写成字符串的形式，true
	alert(xxyy=="undefined");//false
	//这个undefined代表和true和false等一样的，是一个值，所以不要用引号
		
	
  </script>
```


3.语句(与Java语句格式相同)
1.判断结构(if语句)
	注：var x = 3;
		if(x==4)//可以进行比较运算。
		if(x=4)//可以进行赋值运算，而且可以同样进行判断。不报错。
		因为在Js中0或者null就是false，
非0或者非null就是true（通常用1表示）。
		所以if(x=4)结果是true；
可以通过if(4==y)来解决该问题。因为4=y不会进行判断，而是会报错。
2.选择结构(switch语句)
与java不同的是：因为弱类型，也可以对字符串进行选择。
代码演示：

```
<html>
  <head>
	<title>javascript语法演示</title>
  </head>
  	
  	<script type="text/javascript">
  		//1 if语句
  		var x=3;
  		if(x>0){
  			alert("yes");//结果yes
  		}else{
  			alert("no");
  		}
  		
  		if(x-4){//和C一样非0的概念，不是0的都是true
  			alert("yes2");//结果yes2
  		}else{
  			alert("no2");
  		}
  		
  		if(x=4){//一个等于号是赋值，结果是4---非零，即是true
  			alert("yes3");//yes3
  		}else{
  			alert("no3");
  		}
  		
  		if(x=0){
  			alert("yes3");
  		}else{
  			alert("no3");//no3
  		}
  		//赋值是什么，该值同时也作为整个表达式的值
  		
  		//建议，如果是判断相等，写成如下方式
  		if(4==x){//把数字放在前面，可以避免一个等于号的bug
  		}
  		
  		//逗号表达式--以最后一个逗号后的结果为真正的值
  		var b =(3,4+5);
  		alert(b);//9 
		
		var c = 5;
		if(c>1){
			alert("a");//a
		}else if(c>2){
			alert("b");
		}else if(c>3){
			alert("c");
		}else{
			alert("d");
		}
  	</script>
  	
  	<script type="text/javascript">
  		//Java---switch表达式支持的类型：byte,int等整数，char
  		//Java1.7之后 支持字符串String
  		
  		//JavaScript语言：支持所有类型，即所有类型的数据都可以用于选择
  		var x = "abc";
  		switch(x){
  			case "aa":
  				alert("a");break;
  			case "abc":
  				alert("b");
  			default:
  				alert("c");
  		}
  		//弹出：b    c  
  		
  		switch(x){
  			default:
  				alert("c");
  			case "aa":
  				alert("a");break;
  			case "abc":
  				alert("b");
  		}
  		//弹出：b
  		
  		x="x";
  		switch(x){//如果没有匹配上
  			default:
  				alert("c");//这里运行完，还会运行后面的
  			case "aa":
  				alert("a");break;
  			case "abc":
  				alert("b");
  		}
  		//弹出：c    a
  		
  	</script>
  	
  <body>
  </body>
</html>

```


3.循环结构(while语句，do…while语句，for语句)。
注：不同的是，没有了具体数据类型的限制，使用时要注意。

代码演示：

```
<html>
  <head>
	<title>javascript语法演示</title>
	
	<link rel="stylesheet" href="table.css"/>
  </head>
  <body>
  
  	<h3>
  		湖南城市学院
  	</h3>
  	<script type="text/javascript">
  		//循环：for while do-while
  		var sum=0;
  		for(var i=1;i<=100;i++){
  			sum+=i;
  		}
  		document.write("sum="+sum);//直接显示在网页相对应位置！！！
  		//sum=5050
  		
  		var x=1;
  		sum=0;
  		while(x<=100){
  			sum+=x;
  			x++;
  		}
  		document.write("<br/><font color=\"#ff0000\" > sum2="+sum+"</font><br/>");
  		//写入了换行和font color=\"#ff0000\" color='#ff0000'  --单引号也可以的
  		
  	</script>
  	
  	<br/>
  	<a href="http://baidu.com"> 百度一下 </a>
  	<br/>
  	<hr>
  	
  	<script type="text/javascript">
  		//转移语句：break,continue,return
  		
  		for(var x=0;x<3;x++){
  			for(var y=0;y<4;y++){
  				document.write("x="+x+"&nbsp;");
  				break;
  			}
  			document.write("<br/>");
  		}
  		document.write("<hr/>");
  		a:for(var x=0;x<3;x++){
  			for(var y=0;y<4;y++){
  				document.write("x="+x+"&nbsp;");
  				break a;
  			}
  			document.write("<br/>");
  		}
  	</script>
  	<hr/>
  	<h2>九九乘法表</h2>
  	<script type="text/javascript">
  		for(var x=1;x<10;x++){
  			for(var y=1;y<=x;y++){
  				document.write(x+"*"+y+"="+x*y+"&nbsp;");
  			}
  			document.write("<br/>");
  		}
  	</script>
  	
  	<h2>九九乘法表2</h2>
  	<script type="text/javascript">
  		document.write("<table>");
  		for(var x=1;x<10;x++){
  			document.write("<tr>");
  			for(var y=1;y<=x;y++){
  				document.write("<td>"+x+"*"+y+"="+x*y+"</td>");
  			}
  			document.write("</tr>");
  		}
  		document.write("</table>");
  	</script>
  	
  </body>
</html>

```

table.css

```
table{
	width: 600px;
}
table td{
	border: #f00 solid 1px;
}
```

![](http://img.blog.csdn.net/20160529183856666)

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
