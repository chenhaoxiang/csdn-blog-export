---
layout: post
title: "JavaScript---网络编程(8)-DHTML技术演示(1)"
date: 2016-06-16 04:52:27 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,html,技术,css]
keyword: 陈浩翔, 谙忆
description: DHTML技术使用的基本思路： 
         1. 用标签封装数据—html范畴 
         2. 定义样式—css范畴 
         3. 明确事件源、事件和要处理的节点—dom范畴 
         4. 明确具体的操作方式，其实就是事件的处理内容(过程)—js范畴新闻字体第一种方式：html范畴 演示代码：<html>
  <head>
    <title>>DHTML 
---


DHTML技术使用的基本思路： 
         1. 用标签封装数据—html范畴 
         2. 定义样式—css范畴 
         3. 明确事件源、事件和要处理的节点—dom范畴 
         4. 明确具体的操作方式，其实就是事件的处理内容(过程)—js范畴新闻字体第一种方式：html范畴 演示代码：<html>
  <head>
    <title>>DHTML
<!-- more -->
----------

DHTML技术使用的基本思路：
  		 1. 用标签封装数据---html范畴
   		 2. 定义样式---css范畴
  		 3. 明确事件源、事件和要处理的节点---dom范畴
   		 4. 明确具体的操作方式，其实就是事件的处理内容(过程)---js范畴

**新闻字体**
====

**第一种方式：html范畴 演示代码：**
---------

```
<html>
  <head>
    <title>>DHTML技术演示---新闻字体1</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
		function changeFont(size,color){
			//alert("aa");
			var oNewsDiv = document.getElementById("newsDiv");
			
			//以下用js+dom来设置下面html方式对应的功能
	        //<div id="newsDiv" style="font-size:28px">
            //oNewsDiv.style.font-size= "28px"; //左边的方式是html方式中的属性名，不是js中用的属性名
			//oNewsDiv.style.fontSize="28px";//写死了，字体大小用参数更好
			oNewsDiv.stye.fontSize=size;//字体大小
			oNewsDiv.style.color=color;			
		}
		
	</script>
	
  </head>
  		<!--DHTML技术使用的基本思路：
  		 1. 用标签封装数据---html范畴
   		 2. 定义样式---css范畴
  		 3. 明确事件源、事件和要处理的节点---dom范畴
   		 4. 明确具体的操作方式，其实就是事件的处理内容(过程)---js范畴
  		-->
  <body>
		<!--用“#”号可以屏蔽href的默认超链接功能，但有个不足：地址栏中会添加一个"#"号----改用javascript的方式更好！---javascript:void(0)
  	  	<a href="#" onclick="changeFont()"> 大字体</a>
		-->
		<a href="javascript:void(0)" onclick="changeFont('28px','#aaaaaa')">大字体</a>
		<a href="javascript:void(0)" onclick="changeFont('20px','#000000')">中字体</a>
		<a href="javascript:void(0)" onclick="changeFont('12px','#ff0000')">小字体</a>
		<hr/>
		<!--开始这样先测试下：
			先用html的方式测试一下这样设置字体大小行不行，如果行，再采用API文档右侧栏中的js来实现对应功能
	    	<div id="newsDiv" style="font-size:28px">
   		 -->
		<div id="newsDiv">
       5月31日下午14：30，副校长何振在电信楼视频会议室，为学生处、团委、计划财务处、信息科学与工程学院和体育学院全体师生党员上了一堂题为“讲政治，有信念，做合格党员”的党课。
何振阐述了“讲政治，有信念”的重要性，并讲述了如何才能把握“讲政治，有信念”。他认为，党员应当从把握“讲政治，有信念”的深刻内涵、核心要义和方法路径这三个方面入手。他指出，践行“讲政治，有信念”，必须将其与高校管理、教学、科研相结合，运用到实践当中去，“办人民满意的大学”，并结合学校具体情况进行了深入的分析。<br/>
（信息科学与工程学院）
		</div>
  </body>
</html>

```

360浏览器8.1 演示结果：
---------------
大字体：
![](http://img.blog.csdn.net/20160616153151750)
中字体：
![](http://img.blog.csdn.net/20160616153220504)
小字体：
![](http://img.blog.csdn.net/20160616153228769)




**第二种方式：css范畴 演示代码：**
---------

```
<html>
  <head>
    <title>>DHTML技术演示---新闻字体1</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<style type="text/css">
		.max{
			color:#808080;
			font-size:28px;
			background-color:#9ce9b4;/*背景色*/
		}
		.norm{
	 		color:#000000;
			font-size:20px;
			background-color:#cdd8d0;
	 	}
	 	.min{
	 		color:#ff0000;
			font-size:16px;
			background-color:#f9fac2;
	 	}
	</style>
	<script type="text/javascript">
		function changeFont(sClass){
			var oNewsDiv = document.getElementById("newsDiv") ;
			//利用js+dom的方式来更改节点的样式---class属性
			oNewsDiv.className = sClass;
		}
	</script>
	
  </head>
  		<!--DHTML技术使用的基本思路：
  		 1. 用标签封装数据---html范畴
   		 2. 定义样式---css范畴
  		 3. 明确事件源、事件和要处理的节点---dom范畴
   		 4. 明确具体的操作方式，其实就是事件的处理内容(过程)---js范畴
  		-->
  <body>
  		<a href="javascript:void(0)" onclick="changeFont('max')" > 大字体 </a>
  		<a href="javascript:void(0)" onclick="changeFont('norm')" > 中字体 </a>
  		<a href="javascript:void(0)" onclick="changeFont('min')" > 小字体 </a>
		
		<!--先用html的方式测试一下，然后再用js+dom
	  		<div id="newsDiv" class="norm">
		-->
		<div id="newsDiv">
       5月31日下午14：30，副校长何振在电信楼视频会议室，为学生处、团委、计划财务处、信息科学与工程学院和体育学院全体师生党员上了一堂题为“讲政治，有信念，做合格党员”的党课。
何振阐述了“讲政治，有信念”的重要性，并讲述了如何才能把握“讲政治，有信念”。他认为，党员应当从把握“讲政治，有信念”的深刻内涵、核心要义和方法路径这三个方面入手。他指出，践行“讲政治，有信念”，必须将其与高校管理、教学、科研相结合，运用到实践当中去，“办人民满意的大学”，并结合学校具体情况进行了深入的分析。<br/>
（信息科学与工程学院）
		</div>
  </body>
</html>

```


360浏览器8.1 演示结果：
---------------
大字体：
![](http://img.blog.csdn.net/20160616155451669)
中字体：
![](http://img.blog.csdn.net/20160616155501965)
小字体：
![](http://img.blog.csdn.net/20160616155510606)

**第三种方式：dom，js范畴 演示代码：**
---------
1.css：

```
.max {
    color: #808080;
    font-size: 28px;
    background-color: #9ce9b4;
}

.norm {
    color: #000000;
    font-size: 20px;
    /*background-color:#cdd8d0;*/
}

.min {
    color: #ff0000;
    font-size: 16px;
    background-color: #f9fac2;
}

```
2.css:

```
.max {
    color: #808080;
    font-size: 28px;
   	background-image:url(img/back1.jpg);
}

.norm {
    color: #000000;
    font-size: 20px;
    background-image: url(img/back2.jpg);
}

.min {
    color: #ff0000;
    font-size: 16px;
    background-image: url(img/back3.jpg);
}
```
html：

```
<html>
  <head>
    <title>DHTML技术演示---新闻字体3--换套装</title>
     <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	 <link rel="stylesheet" type="text/css" href="1.css" id="linkChgSuit">
	 
	 <style type="text/css">
	 	span:hover{
	 		background-color:#ff0000;
			cursor:hand;/*鼠标移到那时，显示小手形状*/
	 	}
	 </style>
	 <script type="text/javascript">
	 	//更改类样式
		function changeFont(sClass){
			var oNewsDiv = document.getElementById("newsDiv");
			//利用js+dom的方式来更改节点的样式---class属性
			oNewsDiv.className = sClass;
		}
		//换套装
		function changeSuit(sNum){
			var oLink = document.getElementById("linkChgSuit");
			oLink.href = sNum+".css";
		}
		
		
	 </script>
	 
  </head>
  <!--DHTML技术使用的基本思路：
   1. 用标签封装数据---html范畴
   2. 定义样式---css范畴
   3. 明确事件源、事件和要处理的节点---dom范畴
   4. 明确具体的操作方式，其实就是事件的处理内容(过程)---js范畴
  -->
  
  <body>
  	<a href="javascript:void(0)" onClick="changeFont('max')"> 大字体</a>
  	<a href="javascript:void(0)" onClick="changeFont('norm')">  中字体</a>
  	<a href="javascript:void(0)" onClick="changeFont('min')"> 小字体</a>
  	<br/>
	<span onClick="changeSuit('1')">风格1</span>
	<span onClick="changeSuit('2')">风格2</span>
	<hr/>
	<!--先用html的方式测试一下，然后再用js+dom
	  <div id="newsDiv" class="norm">
	-->
	<div id="newsDiv">
       5月31日下午14：30，副校长何振在电信楼视频会议室，为学生处、团委、计划财务处、信息科学与工程学院和体育学院全体师生党员上了一堂题为“讲政治，有信念，做合格党员”的党课。
何振阐述了“讲政治，有信念”的重要性，并讲述了如何才能把握“讲政治，有信念”。他认为，党员应当从把握“讲政治，有信念”的深刻内涵、核心要义和方法路径这三个方面入手。他指出，践行“讲政治，有信念”，必须将其与高校管理、教学、科研相结合，运用到实践当中去，“办人民满意的大学”，并结合学校具体情况进行了深入的分析。<br/>
（信息科学与工程学院）
    </div>

  </body>
  
</html>

```

360浏览器8.1 演示结果：
---------------

风格2大字体：
![](http://img.blog.csdn.net/20160616162510276)
风格2中字体：
![](http://img.blog.csdn.net/20160616162517946)
风格1大字体：
![](http://img.blog.csdn.net/20160616162525415)
风格1中字体：
![](http://img.blog.csdn.net/20160616162532540)


菜单列表：
=====
代码演示：

```
<html>
  <head>
    <title>DHTML技术演示---菜单列表1</title>
     <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	 <style type="text/css">
		/*老版本的IE支持，新版本不支持了
		dl{
			height:18px;
			overflow:hidden;
		}*/
		
		/*
block  :　 CSS1  块对象的默认值。将对象强制作为块对象呈递，为对象之后添加新行
none  :　 CSS1  隐藏对象。与 visibility 属性的hidden值不同，其不为被隐藏的对象保留其物理空间  
		ul{
			//display:none;//不显示
			display:block;//块显示
		}
		*/
		table {
			border:#ff80ff;
			width:80px;
		}
		
		table ul{
			list-style:none;
			margin:0px;/*外补丁*/
			padding:0px;/*内补丁*/
			background-color:#ff8000;
			display:none;
		}
		table td{
			border:#0000ff 1px solid;
			background:#80ff00;
		}
		
		table td a:link, table td a:visited{
			color:#8080c0;
			text-decoration:none;
		}
		table td a:hover{
			color:#0000ff;;
		}
		
		.open{
			display:block;
		}
		.close{
			display:none;
		}
		
		
	 </style>
	 
	 <script type="text/javascript">
	 	function list(node){
			var oTdNode = node.parentNode;
			//alert( oTdNode.nodeName);//TD
			var oUlNode = oTdNode.getElementsByTagName("ul")[0];
			//alert( oUlNode.nodeName);//UL
			if( oUlNode.className =="open"){
				oUlNode.className ="close";
			}else{
				oUlNode.className ="open";
			}
		}
	 
	 </script>
  </head>
  <!--DHTML技术使用的基本思路：
   1. 用标签封装数据---html范畴
   2. 定义样式---css范畴
   3. 明确事件源、事件和要处理的节点---dom范畴
   4. 明确具体的操作方式，其实就是事件的处理内容(过程)---js范畴
  -->
  
  <body>
	<table>
		<tr>
			<td>
				<a href="javascript:void(0)" onclick="list(this)">文件菜单</a>
				<ul>
					<li>菜单项一</li>
					<li>菜单项二</li>
					<li>菜单项三</li>
					<li>菜单项四</li>
				</ul>
		    </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0)" onclick="list(this)">编辑菜单</a>
				<ul>
					<li>菜单项一</li>
					<li>菜单项二</li>
					<li>菜单项三</li>
					<li>菜单项四</li>
				</ul>
		    </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0)" onclick="list(this)">调试菜单</a>
				<ul>
					<li>菜单项一</li>
					<li>菜单项二</li>
					<li>菜单项三</li>
					<li>菜单项四</li>
				</ul>
		    </td>
		</tr>
	</table>
	
  </body>
  
</html>

```

360 8.1 演示结果;
![](http://img.blog.csdn.net/20160616164857175)


下面就是只能点开一个菜单（点一个菜单时，把其他菜单全部关闭）：

```
<html>
    <head>
        <title>DHTML技术演示---菜单列表2</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <style type="text/css">
            /*老版本的IE支持，新版本不支持了
             dl{
             height:18px;
             overflow:hidden;
             }*/
            /*
             ul{
             //display:none;//不显示
             display:block;//块显示
             }
             */
            table {
                border: #ff80ff;
                width: 80px;
            }
            
            table ul {
                list-style: none;
                margin: 0px;
                padding: 0px;
                background-color: #ff8000;
                display: none;
            }
            
            table td {
                border: #0000ff 1px solid;
                background: #80ff00;
            }
            
            table td a:link, table td a:visited {
                color: #8080c0;
                text-decoration: none;
            }
            
            table td a:hover {
                color: #0000ff;;
            }
            
            .open {
                display: block;
            }
            
            .close {
                display: none;
            }
        </style>
        <script type="text/javascript">
            function list(node){
                var oTdNode = node.parentNode;
                //alert( oTdNode.nodeName);//TD
                var oUlNode = oTdNode.getElementsByTagName("ul")[0];
                //alert( oUlNode.nodeName);//UL
                
                var oNode = document.getElementsByName("men");
                for (x = 0; x < oNode.length; x++) {
					var ulNode = oNode[x].parentNode.getElementsByTagName("ul")[0];
                    if (oNode[x].innerText == node.innerText) {
                        if (ulNode.className == "open") {
                            ulNode.className = "close";
                        }
                        else {
                            ulNode.className = "open";
                        }
                    }
                    else 
                        if (ulNode.className == "open") {
                            ulNode.className = "close";
                        }
                }
                
            }
        </script>
    </head>
    <!--DHTML技术使用的基本思路：
    1. 用标签封装数据---html范畴
    2. 定义样式---css范畴
    3. 明确事件源、事件和要处理的节点---dom范畴
    4. 明确具体的操作方式，其实就是事件的处理内容(过程)---js范畴
    -->
    <body>
        <table>
            <tr>
                <td>
                    <a href="javascript:void(0)" onclick="list(this)" name="men">文件菜单</a>
                    <ul>
                        <li>
                            菜单项一
                        </li>
                        <li>
                            菜单项二
                        </li>
                        <li>
                            菜单项三
                        </li>
                        <li>
                            菜单项四
                        </li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>
                    <a href="javascript:void(0)" onclick="list(this)" name="men">编辑菜单</a>
                    <ul>
                        <li>
                            菜单项一
                        </li>
                        <li>
                            菜单项二
                        </li>
                        <li>
                            菜单项三
                        </li>
                        <li>
                            菜单项四
                        </li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>
                    <a href="javascript:void(0)" onclick="list(this)" name="men">调试菜单</a>
                    <ul>
                        <li>
                            菜单项一
                        </li>
                        <li>
                            菜单项二
                        </li>
                        <li>
                            菜单项三
                        </li>
                        <li>
                            菜单项四
                        </li>
                    </ul>
                </td>
            </tr>
        </table>
    </body>
</html>

```

演示结果：

![](http://img.blog.csdn.net/20160616165209879)

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
