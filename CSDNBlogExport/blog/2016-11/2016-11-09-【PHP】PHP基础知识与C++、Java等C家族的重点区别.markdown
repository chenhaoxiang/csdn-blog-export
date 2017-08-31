---
layout: post
title: "【PHP】PHP基础知识与C++、Java等C家族的重点区别"
date: 2016-11-09 04:52:20 +0800
comments: true
categories:❹ PHP
tags: [php,java,博客,计算机,c语言]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
刚刚接触PHP，看着PHP的基础知识，发现还是有一些地方与Java有比较大的区别。然后就想着写一写基础知识的一点不同，方便记忆与区分。本篇博客适宜人群： 
对Java基础知识有着一定的了解(最好是已经深入学习Java的人，否则有时候，不同计算机语言之间的语法会把你弄懵逼的)。 
以及刚 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
刚刚接触PHP，看着PHP的基础知识，发现还是有一些地方与Java有比较大的区别。然后就想着写一写基础知识的一点不同，方便记忆与区分。本篇博客适宜人群： 
对Java基础知识有着一定的了解(最好是已经深入学习Java的人，否则有时候，不同计算机语言之间的语法会把你弄懵逼的)。 
以及刚
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

刚刚接触PHP，看着PHP的基础知识，发现还是有一些地方与Java有比较大的区别。

然后就想着写一写基础知识的一点不同，方便记忆与区分。

本篇博客适宜人群：
对Java基础知识有着一定的了解(最好是已经深入学习Java的人，否则有时候，不同计算机语言之间的语法会把你弄懵逼的)。
以及刚学习PHP的人。

在这里，我只列出PHP的基础知识是哪样的，Java的不列出。

##输出字符串
PHP的输出前面都是有着:echo。
```
<?php
  echo print 'Hello Word!';
  echo "<br/>";
?>
<?php
  echo printf("这是我的第%d个程序<br/><br/>",2);
?>
```

##数据类型
PHP有两种特殊类型、
1、NULL(Null)
2、resource(资源)
(前面的是数据类型，括号内的是中文名称)

PHP中:
Array-也就是数组。
3中定义方式:

```
<?php
  $array = array("a","b","c",12,"d");
  print_r($array);
  echo "<br/><br/>";
?>
<?php
  $array = array(
  	"key1" => "a",
	"key2" => 12,
	"key3" => "b",
  );
  print_r($array);
  echo "<br/><br/>";
  //自PHP5.4起，定义方式改为:
  $array = [
    "key1" => "a",
	"key2" => 12,
	//"key3" => "b",
	"key3" => "b"//最后写不写逗号都一样的
  ];
  print_r($array);
  echo "<br/><br/>";
?>
```

NULL类型的变量唯一的可能值就是NULL，而且不区分大小写！
用来表示一个变量没有值！

###Object对象-调用对象中的函数
```
<?php
  class hello{
  	function do_print(){
		echo "print";
	}
  }
  
  $a = new hello;//new 对象
  $a->do_print();//调用$a中函数
  echo "<br/><br/>";
?>
```


##变量
PHP表示一个变量的方法是：使用符号$开头，后跟变量名称。
PHP是弱类型语言。

```
<?php
  $a = 12;
  $b = "abc";
?>
```



##引用赋值
PHP中:
```
<?php
	$num1=5;
	$num2=&$num1;
	$num2=10;
	echo $num1;//输出10
?>
```

##局部变量与全局变量
PHP中:
局部变量只能在被定义的函数内使用，在该被定义的函数之外无法访问该变量。
全局变量指在函数的外部被定义，其只能在函数外部使用！

也就是说，全局变量与局部变量是分开的！

不过我们还是有一种方法可以在函数内部访问全局变量。
我们可以在函数内部也定义同样的变量，只是我们需要在变量前面加上关键字 global 。
示例如下:
```
<?php
	$sun=20;
	function example(){
		global $sum;
		$num1 = 10;
		$num2 = $num1 * 2;
		$sum = $num1+$num2; 
	}
	example();
	echo $sum; //输出30
?>
```

##常量
PHP中:
常量需要使用define()函数进行设置。
示例:

```
<?php
	define("FIRST","abc");
	echo FIRST;
?>
```
define()函数有3个参数。
1.定义常量名称
2.定义常量的值
3.定义了常量名称是否区分大小写，该参数可选，默认是false.

##运算符
PHP中：
比较运算符 "==="
三个等于表示是否完全相同。
也就是`$a`等于`$b`,而且它们的数据类型相同。为TRUE

"!=="非全等于
也就是`$a` 不等于`$b`,或它们的数据类型不相同。为TRUE

"<>"不等于，类似"!="

##逻辑运算符
PHP中
逻辑异或 "xor"

```
$a xor $b   
如果$a或$b任一为true，但不同时为true。结果为true。
也就是$a与$b值不同时，结果为true。
```

##"."运算符
PHP中
连接字符串的运算符、

##数组运算符
PHP中
"==="全等
```
如果$a和$b拥有相同的键/值对，且顺序相同，类型相同，则返回true、
```
"!=="不全等
```
与 === 相对
```

##条件判断语句
PHP中
elseif可以写在一起、

```
elseif和else if一样的
```


如有错误或者补充，欢迎在评论区指正，谢谢，我会继续编辑，以及加上补充者ID。


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
