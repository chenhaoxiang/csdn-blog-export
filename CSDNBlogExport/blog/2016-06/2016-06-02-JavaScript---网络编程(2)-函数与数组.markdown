---
layout: post
title: "JavaScript---网络编程(2)-函数与数组"
date: 2016-06-02 11:12:16 +0800
comments: true
categories:❶ ACM,❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,javascript,函数,java,语言]
keyword: 陈浩翔, 谙忆
description: 上节，学完循环了~ 
现在学Javascript的函数和数组。 
JavaScript语法 
每一种语言都有自己的语法规则，JS语法与Java很像，所以学习起来比较容易。JS中也一样有变量，语句，函数，数组等常见语言组成元素。1.一般函数 
格式：function  函数名(形式参数...)
{
    执行语句；
    return 返回值；
}函数是多条执行语句的封装体，只有被调用才会被运行。 
---


上节，学完循环了~ 
现在学Javascript的函数和数组。 
JavaScript语法 
每一种语言都有自己的语法规则，JS语法与Java很像，所以学习起来比较容易。JS中也一样有变量，语句，函数，数组等常见语言组成元素。1.一般函数 
格式：function  函数名(形式参数...)
{
    执行语句；
    return 返回值；
}函数是多条执行语句的封装体，只有被调用才会被运行。
<!-- more -->
----------

上节，学完循环了~
现在学Javascript的函数和数组。
JavaScript语法
每一种语言都有自己的语法规则，JS语法与Java很像，所以学习起来比较容易。JS中也一样有变量，语句，函数，数组等常见语言组成元素。

1.一般函数
格式：

```
function  函数名(形式参数...)
{
	执行语句；
	return 返回值；
}
```

函数是多条执行语句的封装体，只有被调用才会被运行。
注意：调用有参数的函数，但没有给其传值，函数一样可以运行，或者调用没有参数的函数，给其传值，该函数也一样运行。
说的简单点：只要写了函数名后面跟了一对小括号，该函数就会运行。那么传递的参数呢？
其实，在函数中有一个参数数组对象（arguments），该对象将传递的参数都封装在一个数组中。
例：

```
function demo()//定义函数。
{
	alert(arguments.length);
}
```

demo(“hello”,123,true);//调用函数。
那么弹出的对话框结果是3，如果想得到所有的参数值，可以通过for循环遍历该数组。

```
for(var x=0; x<arguments.length; x++)
{
	alert(arguments[x]);
}
```

为了增强阅读性，最好按照规范，按定义好的形式参数传递实际参数。
函数在调用时的其他写法：
var show = demo();//show变量接收demo函数的返回值。
var show = demo;//这种写法是可以的，意为show和demo代表同一个函数。
				//那么该函数也可以通过show()的方式运行。

代码演示1：

```
<html>
  <head>
    <title>javascript函数用法演示</title>
  </head>
  
  <body>
  <!-- 
      ※java中函数定义的格式：
    int sum(int a,int b){
      ....
      return s
    }
    
      ※js中函数定义的格式：
    function sum(a,b){
      ....
      return s
    }
    ▲▲js中的函数可以理解成一个function类型的对象
   -->
  
	  <script type="text/javascript">
	      //※浏览器对js代码是边解析边执行的
	      //注意，函数的调用  应该在浏览器解析完 该函数的定义 之后进行
	      //调用
	      hello();//ie11中无效---因为浏览器解析该语句时，此函数还没有定义
	  </script>
  
     <script type="text/javascript">
        //定义---无参函数
        function hello(){
        	document.write("hello function!");
        } 
        hello();//调用
        
        //定义---有参函数
        function add(a,b){
        	var s = a+b;
        	return s;
        }
        document.write("<br/>")
        document.write("s="+add(10,23));
     </script>
  
  </body>
  
  
</html>

```

360浏览器8.1 演示1结果：
![](http://img.blog.csdn.net/20160602101718685)

代码演示2：

```
<html>
<head>
<title>javascript函数用法演示2---一点小细节</title>
</head>

<body>
	<script type="text/javascript">
		function show(x, y) {
			document.write(x + "," + y);
			document.write("<br/>");
		}
		show(23, 22);//23,22
		show(23); //23,undefined
		show(); //undefined,undefined
		show(23, 22, 11);//23,22 后面的一个参数函数接收了但没有用

		//函数的参数全部是js内部用一个arguments数组来接收与存放的---该对象是js内部隐含帮我们做的，我们可以访问到这个数组对象
		function show2(x, y) {
			arguments[0] = 1000;//可以把形参x的值改掉
			document.write(x + "," + y + "<br/>");
			for ( var i = 0; i < arguments.length; i++) {
				document.write(arguments[i] + ",");
			}
		}
		show2(11, 22, 33, 44);
		document.write("<br/>");
		//※综上，函数的技术细节：
		//1, js中的函数是没有重载，只以函数名来识别的---其实函数名就是一个function对象的引用的名字
		//2, js函数中有一个内部维护的arguments数组来接收与保存形参
	</script>

	<script type="text/javascript">
		function getValue() {
			document.write("aa");
			document.write("<br/>");
			return 100;
		}
		var v = getValue();
		document.write("v=" + v);
		document.write("<br/>");
		var v2 = getValue; //相当于getValue把引用值传给v2，因此v2也是一个“function对象”----getValue和v2都是引用变量
		document.write("v2=" + v2);//其实是输出v2对象的toString()
		document.write("<br/>");
		document.write("v2=" + v2()); //调用v2这个函数对象---调用函数
		document.write("<br/>");
	</script>

</body>


</html>

```

360浏览器8.1 演示2结果：
![](http://img.blog.csdn.net/20160602101806989)

动态函数
	通过Js的内置对象Function实现。
	例：
```
	var demo = new Function(“x,y”;”alert(x+y);”);
		demo(4,6);
		如同：
		function demo(x,y)
		{
			alert(x+y);
		}
		demo(4,6);
```
不同的是，动态函数，参数以及函数体都可以通过参数进行传递，可以动态指定。

匿名函数
&nbsp;&nbsp;&nbsp;格式 : function(){...}
&nbsp;&nbsp; 例：
&nbsp;&nbsp;&nbsp;&nbsp;	var demo = function(){...}
&nbsp;&nbsp;&nbsp;&nbsp;demo();
		通常在定义事件属性的行为时较为常用。
		例：
		

```
function test()
		{
			alert(“load ok”);
		}
		window.onload = test;
```
可以写成匿名函数的形式：
		

```
window.onload = function()
		{
			alert(“load ok”);
		}
```
匿名函数就是一种简写格式。	

代码演示：

```
<html>
  <head>
    <title>javascript函数用法演示3---动态函数，匿名函数</title>
  </head>
  
  <body>
  	  	
  	<!-- 
  	  ※1※ 动态函数:使用的是js中内置的一个对象---- Function
  	   注意，小写的function是用来声明的，而大写的Function是用来new对象的
  	 
  	  //把下面的函数写成动态函数
        function add(a,b){
        	var s = a+b;
        	return s;
        }
  	 -->
  	<script type="text/javascript">
  	   //把函数的形参用第1个参数传入，函数体中的代码用第2个参数传入----可以通过调用者动态传入函数体，因此非常灵活，该思想类似Java当中的类反射。
  	   var add = new Function("a,b","var s = a+b; return s; ");
  	   document.write( add(12,13) );
  	</script>
  	
  	
  	<!-- 
  	  ※2※ 匿名函数: 没有函数名的函数。这种方式我们以后在事件处理时会经常使用，类似Java中的匿名内部类经常用在事件监听器中一样
  	-->
  	<script type="text/javascript">
  	    var fun= function(a,b){
    	  return a+b;
    	};
    	document.write( fun(2,3) );
  	
  	</script>
  	
  	<!-- 用匿名函数给按钮添加事件绑定  -->
  	<button id="btn1">一个按钮</button>
  	<script type="text/javascript">
  	  btn1.onclick=function(){
  		  alert('aa');
  	  };
  	</script>
  	
  </body>
  
  
</html>

```

360浏览器8.1 演示结果：

![](http://img.blog.csdn.net/20160602102719892)
弹窗：
![](http://img.blog.csdn.net/20160602102759315)

5.数组
	方便操作多元素的容器，可以对其中的元素进行编号。
	特点：可以存任意元素，长度是可变的。
	格式：
	

```
var arr = new Array();
	arr[0] = “hello”;
	arr[1] = 123;
	var arr = [‘hello’,123,true,”abc”];
```
通过遍历即可对数组进行基本操作。
	

```
for(var x=0; x<arr.length; x++)
	{
		alert(arr[x]);
	}
```

代码演示：

```
<html>
  <head>
    <title>javascript数组用法演示</title>
  </head>
  
  <body>
     <script type="text/javascript">
        //数组定义的方式1: 定义时直接赋初值
        var arr =[12,34,2,-3,90,12];
     	document.write( typeof(arr) );
        //object
        document.write("<br/>");
        document.write("len:" + arr.length);
        document.write("<br/>");
        //遍历数组
        for(var x=0;x<arr.length;x++){
        	document.write("arr["+x+"]="+ arr[x]+"&nbsp;");
        }
        document.write("<br/>");
        
        arr[0]=-10;
        arr[7]=66;//数组可以自动增长，且arr[6]没有赋值则是undefined
        
        document.write("len:"+arr.length+" 数组长度自动加长");
        document.write("<br/>");
        
        for(var x=0;x<arr.length;x++){
        	document.write("arr["+x+"]="+ arr[x]+"&nbsp;");
        }
        document.write("<br/>");
        document.write("<hr/>");
        
        var arr2=[];
        
        document.write("arr2.length="+arr2.length);//0
        document.write("<br/>");
        
        arr2[1]=10;
        for(var x=0;x<arr2.length;x++){
        	document.write("arr2["+x+"]="+ arr2[x]+"&nbsp;");
        }
        document.write("<br/>");
        
        //※※错误的声明方式--数组
        //int[] arr3 ={1,2,3};
        //var[] arr3 = [1,2,3];//错的，[]代表的是数组类型，而js中，所有数据类型只有一个var声明，不存在“var[]”这种类型
        
        document.write("同一个数组的元素可以是不同类型！！！<br/>");
        var arr4=[1,2,3,100];
        arr4[0]="abc";
        arr4[1]=true;
        for(var x=0;x<arr4.length;x++){
        	document.write("arr4["+x+"]="+ arr4[x]+"&nbsp;");
        }
        document.write("<br/>");
        
        //※※综上,js数组的两个特点：
        //1,长度是可变的
        //2,元素的类型是任意的
     </script>
     
     <hr/>
     
    <script type="text/javascript">
       //数组定义的方式2: 使用js中的Array对象来定义
       var arr10 = new Array(); //※ 空参
       for(var x=0;x<arr10.length;x++){
       	document.write("arr10["+x+"]="+ arr10[x]+"&nbsp;");
       }//什么都没有,因为长度是0
       document.write("arr10.length="+arr10.length);//0
       document.write("<br/>");
       
       var arr11 = new Array(8); //※ 一个参数，代表的是数组的长度
       arr11[2]=12;
       arr11[3]="abc";
       for(var x=0;x<arr11.length;x++){
    	   if(x==2||x==3){
		       	document.write("<font color=red >arr11["+x+"]="+ arr11[x]+"&nbsp;</font>");
    	   }else{
		       	document.write("arr11["+x+"]="+ arr11[x]+"&nbsp;");
    	   }
       }
       document.write("<br/>");
       
       var arr12 = new Array(10,11,12); //※ 多个参数，代表的是数组元素值
       arr12[5]="aaa";
       for(var x=0;x<arr12.length;x++){
       	document.write("arr12["+x+"]="+ arr12[x]+"&nbsp;");
       }
       document.write("<br/>");
    
       
    </script>
  
  </body>
  
  
</html>

```

360浏览器8.1 演示结果：
![](http://img.blog.csdn.net/20160602104142834)


接下来将函数和数组结合起来用用，写个排序和二分查找。

```
<html>
  <head>
    <title>javascript数组与函数练习</title>
  </head>
  
  <body>
  <script type="text/javascript">
    //写一个获取数组中元素最大值的函数
    //若有多个，返回第一个
    function getMax(arr){
    	var max=0;//最大值的下标
    	for(var x=1;x<arr.length;x++){
    		if(arr[x]>arr[max]){
    			max = x;
    		}
    	}
    	return arr[max];
    }
    //调用
    var arr=[23,-3,45,0,-100,47,22];
    var v = getMax(arr);
    document.write("数组最大值的下标："+v);
    document.write("<br/>");
    document.write("数组最大值:"+v);
    document.write("<br/>");
	
    
    //数组选择排序
    function sortArray(arr){
    	for(var x=0;x<arr.length-1;x++){
    		var min=x;
    		for( var y=x+1;y<arr.length;y++){
    			if(arr[min]>arr[y]){
    				min=y;
    			}
    		}
    		if(min!=x){
    			swap(arr,x,min);
    		}
    	}
    }
    function swap(arr,x,y){
    	var temp = arr[x];
    	arr[x] = arr[y];
    	arr[y] = temp;
    }
    document.write("<hr/>");
    document.write("排序前："+arr+"<br/>");
   	sortArray(arr);
    document.write("排序后："+arr+"<br/>");
    
    
    //我们的输出函数---把内容输出到页面且换行
    function println(str){
    	 document.write(str+"<br/>");
    }
    println(arr);
    sortArray(arr);
    println(arr);
    
    //到数组当中查找元素
    function searchElement(arr,key){
    	for(var x=0;x<arr.length;x++){
    		if(arr[x]==key){
    			return x;
    		}
    	}
    	return -1;
    }
    println( searchElement(arr,0) );
    println( searchElement(arr,123) );
    
  </script>
  
  <script type="text/javascript">
    //二分查找
    function binarySearch(arr,key){
    	var max,min,mid;
    	min=0;
    	max=arr.length-1;
    	while(min<=max){
    		mid = (max+min)>>1;
    		if(key>arr[mid]){//落在右边
    			min = mid+1;    			
    		}else if(key<arr[mid]){//落在左边
    			max = mid-1;
    		}else{
    			return mid;
    		}
    	}
    	return -1;
    }
    println("二分查找结果：");
    println( binarySearch(arr,0) );
    println( binarySearch(arr,123) );
    
    //数组反转
    function reverseArray(arr){
    	for(var start=0,end=arr.length-1; start<end; start++,end--){
    		swap(arr,start,end);
    	}
    }
    reverseArray(arr);
    println("反转之后:"+arr);
  </script>
  
  	  	
  </body>
  
  
</html>

```

360浏览器8.1 演示结果：

![](http://img.blog.csdn.net/20160602110254140)


JS中的全局变量和局部变量解答：

代码演示：

```
<html>
  <head>
    <title>javascript中的全局变量与局部变量</title>
  </head>
  
  <body>
    <!-- 
            全局变量: js中，直接在脚本当中定义的变量全都是全局变量。
            局部变量: 在函数中定义的变量是局部的。
     -->
  
	  <script type="text/javascript">
	     function println(str){
	    	 document.write(str+"<br/>");
	     }
	     var a=100;
	     println("遍历输出0-9：");
	     for(var x=0;x<10;x++){
	    	 println("x="+x);
	     }
	  </script> 
	  
	  <script type="text/javascript">
	     println("aaaa="+a);
	     println("xxxx="+x);
	     
	     function aa(){
	    	 var y=123;
	    	 document.write("y="+y);
	    	 return;
	     }
	     aa();
	     document.write("<br/>");

	     println("yyyy="+y);//不能访问函数内部定义的变量，因为它是局部的
	  </script> 
	  
	  <!-- 一点小细节 -->
	  <script type="text/javascript">
	     var n=3;//全局变量n
	     function abc(n){//局部变量n---形参是方法内部声明的局部变量，值由arguments[0]在使用n时临时赋给它的
	    	 n=6;
	     }
	     abc(n);//把x传给方法abc，并在其中试图对该值进行更改--未遂!----本质上实参n是把值传给了函数中的arguments数组了
	     println("n="+n);
	  </script>
	  
  </body>
  
  
</html>

```


360浏览器8.1 演示结果：

![](http://img.blog.csdn.net/20160602111120170)

下一次就学习JS的对象了。毕竟JS是基于对象的语言。

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
