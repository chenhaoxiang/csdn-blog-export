---
layout: post
title: "JavaScript---网络编程(6)-Dom和Bom模型概念讲解(节点获取 window对象)"
date: 2016-06-11 10:07:47 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,函数,对象,dom]
keyword: 陈浩翔, 谙忆
description: 本节讲Dom和Bom模型概念讲解(节点获取,window对象)。 
out.js: 
写了2个输出到页面的函数。function println(param){
    document.write(param+"<br/>");
}
function print(param){
    document.write(param);
}window对象中的方式：方法： 
confirm ： 
bCo 
---


本节讲Dom和Bom模型概念讲解(节点获取,window对象)。 
out.js: 
写了2个输出到页面的函数。function println(param){
    document.write(param+"<br/>");
}
function print(param){
    document.write(param);
}window对象中的方式：方法： 
confirm ： 
bCo
<!-- more -->
----------

本节讲Dom和Bom模型概念讲解(节点获取,window对象)。
**out.js:**
写了2个输出到页面的函数。
```
function println(param){
	document.write(param+"<br/>");
}
function print(param){
	document.write(param);
}
```


<font color="red">window对象中的方式：</font>
============

<b><font color="red">方法：</font></b>
**confirm ：**
bConfirmed = window.confirm( [sMessage])
显示一个确认对话框，其中包含一个可选的消息和确定取消按钮。

**setInterval ：**
iTimerID = window.setInterval(vCode, iMilliSeconds [, sLanguage])
每经过指定毫秒值后计算一个表达式。 

**setTimeout ：**
iTimerID = window.setTimeout(vCode, iMilliSeconds [, sLanguage])
经过指定毫秒值后计算一个表达式。 

**clearInterval:**
window.clearInterval(iIntervalID)
使用 setInterval 方法取消先前开始的间隔事件。

**navigate:**
在当前窗口中装入指定 URL。 

**open:**
 打开新窗口并装入给定 URL 的文档。 

**moveBy:** 
将窗口的位置移动指定 x 和 y 偏移值。 

**moveTo:**
将窗口左上角的屏幕位置移动到指定的 x 和 y 位置。 

<font color="green">演示代码：</font>
--------------------------------

```
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Bom模型演示2---window对象中的方式</title>
    </head>
    <body>
        <script type="text/javascript" src="out.js">
        </script>
        <script type="text/javascript">
            //1. confirm方法
            function methodDemo(){
                //window. 可不写
                var boo = window.confirm("真的要删除吗？");
                alert(boo);
            }
            
            //2 setTimeout方法---只激活一次动作，setInterval方法
            //---每隔设定的时间就激活一次动作
            var timer1, timer2;
            function methodDemo2(){
                //setTimeout("alert('时间到...')",2000);//过3秒，执行:alert('时间到...')
                
                //setTimeout("methodDemo()",3000);//过3秒，执行methodDemo()方法
                //setTimeout(methodDemo,3000);//和上面那句一样的
                timer1 = setInterval("alert('时间到...')", 3000);//每隔2秒，会执行一次：alert('时间到...')
                timer2 = setInterval(methodDemo, 3000);//每隔2秒，会执行一次：alert('时间到...')
            }
            
            function timeStop1(){
                clearInterval(timer1);
            }
            
            function timeStop2(){
                clearInterval(timer2);
            }
            
            //3 moveBy---相对移动和moveTo方法---移动到
            
            function moveWindow(){//--IE11.3支持，360 8.1不支持
                //window.moveBy(10, 10);//“window.”可以省略
                //moveBy(-10, -10);
                //moveTo(40, 50);
				
				//窗口抖动
				for(var x=0;x<500;x++){
					moveBy(15,0);
					moveBy(0,15);
					moveBy(-15,0);
					moveBy(0,-15);
				}
            }
			
			//4 open--打开窗口  close--关闭窗口
			var timer3;
			var aNewWindow;
			function openWindow(){
				aNewWindow = window.open("ad.html",null,"height=200,width=400, status=yes,toolbar=no,menubar=no,location=no");
				aNewWindow.moveTo(100,200);
				//timer3 = setTimeout(closeWin,3000);//这句实现的功能可以写在ad.html中
			} 
			function closeWin(){
				aNewWindow.close();
			}
			
        </script>
        <input type="button" value="confirm方法" onclick="methodDemo()"/>
		<input type="button" value="定时器-开始" onclick="methodDemo2()"/>
		<input type="button" value="定时器1-停止" onClick="timeStop1()"/>
		<input type="button" value="定时器2-停止" onClick="timeStop2()"/>
		<br/>
		<input type="button" value="移动窗口" onClick="moveWindow()" />
		<input type="button" value="打开窗口" onClick="openWindow()" />
    </body>
</html>
```

<font color="green">**ad.html:**</font>
------------

```
<html>
  <head>
    <title>广而告之</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  </head>
  <body>
  	<h1>特价大优惠!!!</h1>
  	<h2>走过路过，不要错过!!!</h2>
  	<h3>电器大赌场!!!</h3>
  	<h3>特价大优惠!!!</h3>
	<script type="text/javascript">
		//setTimeout("close()",3000);//绿色广告，3秒后自己关闭
	</script>
	
	<script type="text/javascript">
		//垃圾广告，用户关闭之后，又打开
		onunload = function(){
			open("ad.html","_blank","height=200,width=400, status=yes,toolbar=no,menubar=no,location=no");
		};
		setInterval(focus,1000);// 如果当前窗口在后面 就每过1s---闪烁--IE11.3支持，360 8.1不支持
		//setInterval("focus()",1000);
	</script>
  </body>
</html>

```
<font color="blue">
**里面窗口抖动和那个关闭窗口继续弹窗口和setInterval(focus,1000);**
**IE11.3支持，360 8.1不支持**
</font>


<font color="red">window对象中的事件</font>
============

onload 在浏览器完成对象的装载后立即触发。 
onbeforeunload 在页面将要被卸载前触发。 
onunload 在对象卸载前立即触发。 

**演示代码：**
--

```
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Bom模型演示3---window对象中的事件</title>
    </head>
    <script type="text/javascript">
        //“window.”可以省略。onload事件是在浏览器解析完页面文档时触发，
        //只有当该事件触发时才会调用它的事件处理方法
        window.onload = function(){
            //window.status="欢迎来到湖南城市学院...";//浏览器的状态栏-360浏览器8.1不支持 -IE11.3支持
            //alert("2222...");
            setInterval(horse, 500);
        }
        
		window.onunload=function(){//是浏览器关闭之后才触发的-360浏览器8.1不支持 -IE11.3支持
			alert("ddddd...");//我们看不到
		}
		
		//是浏览器将要关闭之前触发的-360浏览器8.1不支持 -IE11.3支持
		window.onbeforeunload = function(){
			alert("kkkkk...");//我们看得到
		}
        
        var strs = ['欢', '迎', '来', '到', '湖', '南', '城', '市', '学', '院', ''];
        var index = 0;
        function horse(){
            window.status = window.status + strs[index++];
            if (index == strs.length) {
                window.status = "";
                index = 0;
            }
        }
    </script>
    <body>
        <h1>湖南城市学院</h1>
        <script type="text/javascript">
            alert("1111...");
        </script>
    </body>
    </body>
</html>

```

状态栏：（浏览器右下角位置）
![](http://img.blog.csdn.net/20160611211257261)


<font color="red">window对象中的document对象</font>
====================
      /*
         * ※※获取元素的3种方式：
         * 1、getElementById(): 通过标签中的id属性值获来取该标签对象
         * 2、getElementsByName(): 通过标签中的name属性值来获取该标签对象集合
         * 3、getElementsByTagName(): 通过标签名来获取该标签对象集合
         
         ※※所有节点(标签、属性、文本)都有3个属性：nodeName、nodeType、nodeValue
         1、nodeName： 节点的名称
         2、nodeType："标签"为1， "属性"为2，"文本"为3
         3、nodeValue："标签"节点是没有值的即null，属性和文本节点是有值的
         */
**演示代码：**

```
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Dom模型演示1---window对象中的document对象</title>
    </head>
    <script type="text/javascript">
        /*
         * ※※获取元素的3种方式：
         * 1、getElementById(): 通过标签中的id属性值获来取该标签对象
         * 2、getElementsByName(): 通过标签中的name属性值来获取该标签对象集合
         * 3、getElementsByTagName(): 通过标签名来获取该标签对象集合
         
         ※※所有节点(标签、属性、文本)都有3个属性：nodeName、nodeType、nodeValue
         1、nodeName： 节点的名称
         2、nodeType："标签"为1， "属性"为2，"文本"为3
         3、nodeValue："标签"节点是没有值的即null，属性和文本节点是有值的
         */
        //1、getElementById(): 通过标签中的id属性值获来取该标签对象
		function getElementDemo1(){
			var divNode = document.getElementById("divId1");
			alert(divNode.nodeName+","+divNode.nodeType+","+divNode.nodeValue);
			alert(divNode.innerText);//标签容器包含的文字
		}
		
		
		//2、getElementsByName(): 通过标签中的name属性值来获取该标签对象集合
		function getElementDemo2(){
			var aNode = document.getElementsByName("userName");
			alert(aNode);//Object，其实是一个数组※※※※
			alert(aNode[0].nodeName+","+aNode[0].nodeType+","+aNode[0].nodeValue);
			
			//注意，是编辑框元素，但它的nodeValue值仍是null，因为是标签节点。而如果要获取该编辑框中的内容，则采用如下方式:
			alert(aNode[0].value);//其实是读取aNode[0]节点中的属性"value"的值
		}
		
		// 3、getElementsByTagName(): 通过标签名来获取该标签对象集合
		function getElementDemo3(){
			var aNode = document.getElementsByTagName("input");
			alert(aNode);//Object，其实是一个数组※※※※
			alert(aNode[0].nodeName+","+aNode[0].nodeType+","+aNode[0].nodeValue);
		}
		
    </script>
    <body>
        <div id="divId1">
            div区域1中的文字 
        </div>
        <br/>
        <input type="button" value="获取元素byId-1" onClick="getElementDemo1()">
		姓名:<input type="text" name="userName"/>
		<hr/>
		<input type="button" value="获取元素byName-2" onClick="getElementDemo2()">
		<input type="button" value="获取元素byTagName-3" onClick="getElementDemo3()">
    </body>
    </body>
</html>
```
<b><font color="red">获取元素byName-2:</font></b>
编辑框中的字符：
![](http://img.blog.csdn.net/20160611215843423)

<b><font color="red">Dom模型演示---节点获取方式的一个示例</font></b>
===================================================

演示代码：

```
<html>
  <head>
    <title>Dom模型演示2---节点获取方式的一个示例</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript">
		onload = function(){
			var divNode = document.getElementById("link1");
			var aNodes = divNode.getElementsByTagName("a");//获取当前div元素下面的所有节点
			for(var x=0;x<aNodes.length;x++){
				aNodes[x].target="_blank";//新窗口打开
				aNodes[x].innerHTML="<b><font color='red'>商品"+(x+1)+"</font></b>"; 
				//aNodes[x].innerText="<b><font color='red'>商品"+(x+1)+"</font></b>"; 
				//innerHTML 设置或获取位于对象起始和结束标签内的 HTML。( HTML格式)
				//innerText 设置或获取位于对象起始和结束标签内的文本(文本格式)。 
			}	
		}
	</script>
	
  </head>
  
  <body>
  	<h2>友情链接：</h2>
  	<a href="http://www.hncu.net">城院首页</a>
  	<a href="http://www.sina.com">新浪首页</a>
	<br/>
	
	<h2>特价商品:</h2>
	<div id="link1">
		<a href="a.html">水杯</a>
	  	<a href="b.html">风扇</a>
	  	<a href="c.html">鼠标</a>
	  	<a href="d.html">背包</a>
	</div>
  </body>
	
</html>

```

a.html代码：

```
<html>
  <head>
    <title>水杯</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  </head>
  <body>
	<h1>特价水杯!!!</h1>
	<h1>特价水杯!!!</h1>
	<h1>特价水杯!!!</h1>
  </body>
</html>

```


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
