---
layout: post
title: "JavaScript---网络编程(3)-Object、String、Array对象和prototype属性"
date: 2016-06-04 05:23:32 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,javascript,string,函数,对象]
keyword: 陈浩翔, 谙忆
description: 本节学习JavaScript的对象和方法（函数）~Object 对象提供所有 JScript 对象通用的功能。obj = new Object([value]) 参数 
obj 
必选项。要赋值为 Object 对象的变量名。 
value 
可选项。任意一种 JScript 基本数据类型。（Number、Boolean、或 String。）如果 value 为一个对象，返回不作改动的该对象。如果 
---


本节学习JavaScript的对象和方法（函数）~Object 对象提供所有 JScript 对象通用的功能。obj = new Object([value]) 参数 
obj 
必选项。要赋值为 Object 对象的变量名。 
value 
可选项。任意一种 JScript 基本数据类型。（Number、Boolean、或 String。）如果 value 为一个对象，返回不作改动的该对象。如果
<!-- more -->
----------

本节学习JavaScript的对象和方法（函数）~

Object 对象
=========
提供所有 JScript 对象通用的功能。

obj = new Object([value]) 

参数
obj
必选项。要赋值为 Object 对象的变量名。
value
可选项。任意一种 JScript 基本数据类型。（Number、Boolean、或 String。）如果 value 为一个对象，返回不作改动的该对象。如果 value 为 null、undefined，或者没有给出，则产生没有内容的对象。
说明
Object 对象被包含在所有其它 JScript 对象中；在所有其它对象中它的方法和属性都是可用的。在用户定义的对象中可以重定义这些方法，并在适当的时候通过 JScript 调用。toString 方法是经常被重定义的 Object 方法的例子。

代码演示：
-----

```
<html>
  <head>
    <title>Object对象的用法演示</title>
  </head>
  
  <body>
   <script type="text/javascript">
   		/*toString():将对象转换成字符串*/
   		function show(){
   			document.write("show...");
   		}
   		
   		document.write(show);//默认调用的是toString()
   		document.write("<br/>");
   		document.write(show.toString());
   		document.write("<br/>");
   		document.write(show.toLocaleString());
   		document.write("<br/>");
   		
   		var arr=[1,5,6,20];
   		document.write(arr+"<br/>");//默认调用的是toString()
   		document.write(arr.toString()+"<br/>");
   		
   		/*valueOf(): 返回指定对象的原始值  */
   		document.write(arr.valueOf()+"<br/>");//结果和toString()一样
   		document.write(show.valueOf());//结果和toString()一样
   		
   </script>
  </body>
</html>

```

演示结果：
-----

![](http://img.blog.csdn.net/20160604160048556)


toLocaleString 方法说明：
------------------

就是根据你电脑的设置时区，来匹配输出时间的格式，一般在字符串用的少。
说明
toLocaleString 方法返回一个 String 对象，这个对象中包含了用当前区域设置的默认格式表示的日期。 
对于公元 1601 和 1999 之间的时间，日期格式要按照用户的“控制面板”中“区域设置”来确定。 
F对于此区间外的其他时间，使用 toString 方法的默认格式。 
例如，同样是 1 月 5 日，在美国，toLocaleString 可能会返回 "01/05/96 00:00:00"，而在欧洲，返回值则可能是 "05/01/96 00:00:00"，因为欧洲的惯例是将日期放在月份前面。

注意 toLocaleString 只用来显示结果给用户；不要在脚本中用来做基本计算，因为返回的结果是随机器不同而不同的。



String 对象：
=========

可用于处理或格式化文本字符串以及确定和定位字符串中的子字符串。 

语法
newString = new String(["stringLiteral"])

参数
newString
必选项。要赋值为 String 对象的变量名。

stringLiteral
可选项。任意 Unicode 字符群。

说明
String 对象可用字符串文字显式创建。用这种方法创建的 String 对象（指以标准字符串形式）与用 new 运算符创建的 String 对象处理上不同。所有字符串文字共享公用的全局字符串对象。如果为字符串文字添加属性，则它对所有标准字符串对象都是可用的： 

var alpha, beta;
alpha = "这是一个字符串";
beta = "这也是一个字符串";

alpha.test = 10;
在前一示例中，这时为 beta 和所有将来的字符串定义 test。然而，在下面的例子中，被添加属性的处理略有不同： 

var gamma, delta;
gamma = new String("这是一个字符串");
delta = new String("这是也一个字符串");

gamma.test = 10;
在这种情况下，不为 delta 定义 test。每个用 new String 声明的 String 对象有其自己的一组成员。这是对 String 对象和字符串文字的处理不同的唯一情况。 


replace 方法
----------

返回根据正则表达式进行文字替换后的字符串的复制。
stringObj.replace(rgExp, replaceText)

参数
stringObj 
必选项。要执行该替换的 String 对象或字符串文字。该字符串不会被 replace 方法修改。 

rgExp 
必选项。为包含正则表达式模式或可用标志的正则表达式对象。也可以是 String 对象或文字。如果 rgExp 不是正则表达式对象，它将被转换为字符串，并进行精确的查找；不要尝试将字符串转化为正则表达式。

replaceText 
必选项。是一个String 对象或字符串文字，对于stringObj 中每个匹配 rgExp 中的位置都用该对象所包含的文字加以替换。在 Jscript 5.5 或更新版本中，replaceText 参数也可以是返回替换文本的函数。

slice 方法 (String)
-----------------

返回字符串的片段。
stringObj.slice(start, [end])

参数
stringObj
必选项。是一个 String 对象或文字。 

start 
必选项。下标以 0 开始的 stringObj 指定部分起始索引。 

end 
可选项。下标以 0 起始的 stringObj 的指定部分结束索引。

说明
slice 方法返回一个包含 stringObj 的指定部分的 String 对象。 

slice 方法一直复制到 end 所指定的元素，但是不包括该元素。如果 start 为负，将它作为 length + start处理，此处 length 为数组的长度。如果 end 为负，就将它作为 length + end 处理，此处 length 为数组的长度。如果省略 end ，那么 slice 方法将一直复制到 arrayObj 的结尾。如果 end 出现在 start 之前，不复制任何元素到新数组中。

示例
在下面的示例中，slice 方法的两种用法将返回相同的结果。第二个示例中的 -1 指向 str1 中的最后一个字符，并作为提取操作的结束位置。 
str1.slice(0)
str2.slice(0,-1)

代码演示：
-----

```
<html>
<head>
<title>String对象的用法演示</title>
</head>

<body>
	<script type="text/javascript" src="out.js">
		//注意导入顺序，必须先导入，后面才能用
	</script>

	<script type="text/javascript">
		var str = new String("abc123");
		println(str);
		var str2 = "qwe234";
		println(str2);
	</script>
	<!-- 加个小知识点<pre>-按原格式输出到网页（空格回车不忽略） -->
	<pre>
	asdsad
			asfd
			sdf  dsfd
			dsfd   dsf
		</pre>
	<script type="text/javascript">
		//length属性：返回 String 对象的长度
		println(str.length);

		println(str.bold());//bold 方法 把 HTML <B> 标记放置在 String 对象中的文本两端。

		println(str2.bold());

		println(str.charAt(3));
		println(str.concat(str2));//连接str+str2---返回新的字符串

		println(str.fontcolor("red"));//fontcolor 方法
		//把带有 COLOR 属性的一个 HTML <FONT> 标记放置在 String 对象中的文本两端。

		println(str.link("http://www.hncu.net"));//link 方法
		//把一个有 HREF 属性的 HTML 锚点放置在 String 对象中的文本两端。 

		println(str.replace("1", "666"));//将1这个字符替换成666

		println(str.search("bc"));// 1
		//search 方法
		//返回与正则表达式查找内容匹配的第一个子字符串的位置。
		
		println( str.slice(1, 4));
		
		println( str.substring(1, 4));//返回位于 String 对象中指定位置的子字符串。 
		//substring 方法使用 start 和 end 两者中的较小值作为子字符串的起始点。
		//例如， strvar.substring(0, 3) 和 strvar.substring(3, 0) 将返回相同的子字符串。 
		//如果 start 或 end 为 NaN 或者负数，那么将其替换为0。 

		println( str.strike() );//字符串加删除线
		//将 HTML 的<STRIKE> 标识放置到 String 对象中的文本两端。

		println( str.substring(0, 4)+str.substring(4, 5).sub() );
		//sub()  -- 下标-将 HTML 的 <SUB> 标识放置到 String 对象中的文本两端。

		println( str.substr(1,3) ); //从位置1开始，截取3个字符
		str = "aBcewWfd677";
	  	println( str.toUpperCase() );//返回一个字符串，该字符串中的所有字母都被转化为大写字母。
	</script>

</body>
</html>

```

out.js--代码：
-----------

```
function println(param){
	document.write(param+"<br/>");
}

function print(param){
	document.write(param);
}
```


360浏览器8.1 演示结果：
---------------
![](http://img.blog.csdn.net/20160604163849322)


prototype属性的用法演示
================

返回对象类型原型的引用。
objectName.prototype
objectName 参数是对象的名称。 

JS是基于对象的，用对象的时候都是临时去读取复制原型的，这个属性，就是改变那个原型的。

用 prototype 属性提供对象的类的一组基本功能。 对象的新实例“继承”赋予该对象原型的操作。 

代码演示：
-----

```
<html>
  <head>
    <title>prototype属性的用法演示</title>
  </head>
  
  <body>
    <script type="text/javascript" src="out.js">
    </script>
    
    <script type="text/javascript">
      //※※※利用prototype更改原型时，如果属性或方法已经存在那么是修改，否则就是添加。
      //※※给String原型对象添加一个属性aa
       String.prototype.aa=100;
       var str = "abc123";
       println( str.aa );
       println( "aw12".aa );//只要是String型的，都能调用aa，结果都是100
    </script>
    
    <script type="text/javascript">
      //※※给String原型对象添加一个函数---以trim()为例--去前后空格
      //☆☆过渡版
      function trim(str){
    	 var start=0;
    	 var end = str.length-1;
    	 while(start<=end && str.charAt(start)==' '){
    		 start++;
    	 }
    	 while(start<=end && str.charAt(end)==' '){
    		 end--;
    	 }
    	 return str.substring(start,end+1); 
      }
      println( trim("   ewwewe  ewwewe   ") );
      //println( "   ewwewe  ewwewe   ".trim() );
     
    </script>
    
    <!-- 
	    <script type="text/javascript">
	      //※※给String原型对象添加一个函数---以trim()为例
	      //不用传参，将str改为this就可以了。
	      //☆☆法1---用非匿名函数
	      function trim(){
	    	 var start=0;
	    	 var end = this.length-1;
	    	 while(start<=end && this.charAt(start)==' '){
	    		 start++;
	    	 }
	    	 while(start<=end && this.charAt(end)==' '){
	    		 end--;
	    	 }
	    	 return this.substring(start,end+1); 
	      }
	      String.prototype.trim=trim;//给原型对象添加一个trim()方法
	      println( "  yyy 666   ".trim() );
	     
	    </script>
    
     -->
     
    <script type="text/javascript">
      //※※给String原型对象添加一个函数---以trim()为例
      //☆☆法2---用匿名函数
      String.prototype.trim= function(){ //给原型对象添加一个trim()方法
    	 var start=0;
    	 var end = this.length-1;
    	 while(start<=end && this.charAt(start)==' '){
    		 start++;
    	 }
    	 while(start<=end && this.charAt(end)==' '){
    		 end--;
    	 }
    	 return this.substring(start,end+1); 
      };
      
      println( "  yyrry 666888   ".trim() );
     
      var sstr = new String("  www eee  ");
      println( sstr.trim() );
      
    </script>
	  
  </body>
  
  
</html>

```

360浏览器8.1 演示结果：
---------------
![](http://img.blog.csdn.net/20160604164911467)


prototype扩展：
------------

我们现在扩展一下，假如我们先写好js，再导入，就可以直接用我们自己写的那个函数，那个值了。

代码演示：
-----

```
<html>
  <head>
    <title>利用prototype属性给API进行功能扩展</title>
  </head>
  
  <body>
    <script type="text/javascript" src="out.js">
    </script>
    <script type="text/javascript" src="stringtools.js">
    </script>
    
    <script type="text/javascript">
       var str="   hjdsh  ";
       println( str.trim() );//去掉字符串前后空格
       
       println( str.toCharArray() );//字符串转换为字符数组
       
       var str2 = "abc123";
       println( str2 );
       println( str2.reverse() );//字符串反转输出
       
    </script>
    
    	  
  </body>
  
  
</html>

```

stringtools.js的代码：
------------------

```
//给原型对象添加一个trim()方法
String.prototype.trim = function() {
	var start = 0;
	var end = this.length - 1;
	while (start <= end && this.charAt(start) == ' ') {
		start++;
	}
	while (start <= end && this.charAt(end) == ' ') {
		end--;
	}
	return this.substring(start, end + 1);
};

// 给原型对象添加一个toCharArray()方法
String.prototype.toCharArray = function() {
	var chs = [];
	for ( var x = 0; x < this.length; x++) {
		chs[x] = this.charAt(x);
	}
	return chs;
};

// 给原型对象添加一个reverse()方法 
String.prototype.reverse = function() {
	//☆☆js中，函数当中可以再定义函数--内部函数
	function swap(arr,x,y){
		var temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	var arr = this.toCharArray();
	for(var x=0,y=arr.length-1; x<y; x++,y--){
		swap(arr,x,y);
	}
	return arr.join("");//join(str)方法-返回字符串，str就是连接数组元素之间的符号。
};


```

360浏览器8.1 演示结果：
---------------
![](http://img.blog.csdn.net/20160604165550879)


Array对象使用方法
===========

代码演示：
-----

```
<html>
  <head>
    <title>Array对象使用方法演示</title>
  </head>
  
  <body>
    <script type="text/javascript" src="out.js">
    </script>
   <script type="text/javascript">
     var arr=["aaa","bbb","ccc","ddd"];
     println(arr);
     var arr2=["111","222","333","okok"];
     var newArr = arr.concat(arr2);
     println(newArr);
     
     println(newArr.join("-"));
     
     println("<hr/>");
     
     //pop() :  移除数组中的最后一个元素并返回该元素。
     println( newArr.pop() );
     println(newArr);
     //push() : 将新元素添加到一个数组中，并返回数组的新长度值。
     arr.push("x1",arr2,"x2");//注意1，arr2在arr当中是一个元素---即arr变成二维数组。注意2，push方法会改变原来的数组。arr长度为：9
     println(arr+"----二维数组了");
     println(arr.length);
     //arr.push("y1",arr2,"z1");//注意1，arr2在arr当中是一个元素---即arr变成二维数组。注意2，push方法会改变原来的数组。arr长度为：9
     arr=arr.concat("y1",arr2,"z1");
     //注意1，该方法会把数组arr2当中的每个元素取出来，分别添加到arr当中---arr还是一维数组
     //注意2，concat方法不会改变原来的数组，连接结果以新数组的形式返回。旧arr的长度还是6，新arr的长度是12
     println(arr);
     println(arr.length);
     
     arr.sort();
     println(arr);
     
     arr.splice(1, 3, "u1","u2","u3","u4","u5");//从1位置开始，删掉3个元素，并且在删除的位置插入:"u1","u2","u3","u4","u5"
     println(arr);
     
     //※※※做栈和队列的提示
     //unshift---addFirst  concat--addLast()  shift---removeFirst()  pop---removeLast()
     //Array.prototype.addFirst=unshift;
   
   </script>
    
    <script type="text/javascript" src="arraytools.js">
    </script>
    <script type="text/javascript">
       var arr=["aaa","bbb","ccc","ddd"];
       var max = arr.getMax();
       println(max);
       println(arr);
       
    </script>
    	  
  </body>
  
  
</html>

```

arraytools.js代码：
----------------

```
//给原型对象添加一个getMax()方法
Array.prototype.getMax = function() {
	var temp=0;
	for(var x=1;x<this.length;x++){
		if(this[x]>this[temp]){
			temp = x;
		}
	}
	return this[temp];
};
Array.prototype.toString = function() {
	return "["+this.join("")+"]";
};


```

360浏览器8.1 演示结果：
---------------
![](http://img.blog.csdn.net/20160604172253087)

prototype属性真的很强大~~~



本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
