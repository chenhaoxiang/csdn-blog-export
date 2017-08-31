---
layout: post
title: "JavaScript---网络编程(11)--DHTML技术演示(4)-单选框 下拉菜单 添加文件"
date: 2016-06-25 05:06:59 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,javascript,html,css,技术]
keyword: 陈浩翔, 谙忆
description: 本节讲述单选框/下拉菜单/添加文件，综合css，html和JavaScript。单选框：实现的功能是：（类似平时的性格测试） 
先隐藏一部分页面，然后通过点击单选框来显示。 
再通过选项的选择-（每个选项有不同的积分）积分的多少来给出评语演示代码：<html>
  <head>
    <title>DHTML技术演示---radio的使用</title>
    <meta http-equiv= 
---


本节讲述单选框/下拉菜单/添加文件，综合css，html和JavaScript。单选框：实现的功能是：（类似平时的性格测试） 
先隐藏一部分页面，然后通过点击单选框来显示。 
再通过选项的选择-（每个选项有不同的积分）积分的多少来给出评语演示代码：<html>
  <head>
    <title>DHTML技术演示---radio的使用</title>
    <meta http-equiv=
<!-- more -->
----------

本节讲述单选框/下拉菜单/添加文件，综合css，html和JavaScript。

单选框：
====
<b><font color="red">实现的功能是：（类似平时的性格测试）
先隐藏一部分页面，然后通过点击单选框来显示。
再通过选项的选择-（每个选项有不同的积分）积分的多少来给出评语</font></b>

演示代码：
-----

```
<html>
  <head>
    <title>DHTML技术演示---radio的使用</title>
	<meta http-equiv="content-Type" content="text/html; charset=utf-8"/>
	<style type="text/css">
		#contentid{
			display:none;/*显示：默认隐藏*/
		}
		
		ul{/*无序列表*/
			background-color:#80ff00;/*背景色*/
			list-style:none;//前面的默认小圆点取消
			margin:0px;//外补丁
		}
		
		ul li{/*设置ul中的li的字体颜色*/
			color:#ff0000;
		}
		
		.close{
			display:none;
		}
		
		.open{
			display:block;
		}
		
	</style>
	<script type="text/javascript">
		function showContent(oRadioNode){
			var oDivNode = document.getElementById("contentid");
			
			if(oRadioNode.value=="yes"){
				oDivNode.style.display="block";				
			}else{
				oDivNode.style.display="none";
			}
			//第二种方式：利用with
			/*
			with(oDivNode.style){
				if(oRadioNode.value=="yes"){
					display="block";
				}else{
					display="none";
				}
			}
			*/
		}
		
		function showResult(){
			var oNolRadioNodes = document.getElementsByName("nol");
			var val=0;
			//undefined如果被用作boolean型也是false
			//alert(val);
			for(var x=0;x<oNolRadioNodes.length;x++ ){
				//找到那个被选中的单选框
				if(oNolRadioNodes[x].checked){
					val = parseInt( oNolRadioNodes[x].value );
					break;
				}
			}
			
			if(!val){
				document.getElementById("erroinfo").innerHTML="没有任何答案被选中".fontcolor("red");
				return;
			}
			//错误信息赋值为空。
			document.getElementById("erroinfo").innerHTML="";
			
			if(val>=1 && val<=3){
				document.getElementById("res_1").className="open";
				document.getElementById("res_2").className="close";
			}else{
				document.getElementById("res_1").className="close";
				document.getElementById("res_2").className="open";
			}
			
		}
	</script>
  </head>
  
  <body>
  	<div>
  		您要参与问卷调查吗？<br/>
		<!--radio 单选框 name一样就是互斥-->
		<input type="radio" name="wenjuan" value="yes" onclick="showContent(this)"/> 是
		<input type="radio" name="wenjuan" value="no" onclick="showContent(this)" checked="checked" /> 否
		<br/>
  	</div>
	<div id="contentid">
		问卷调查内容:<br/>
		您的姓名：<input type="text" name="name" /><br/>
		您的电话：<input type="text" name="tel"/ >
	</div>
	
	<hr/>
	<h2>欢迎您参与性格测试</h2>
	<h3>第一题：</h3>
	<span>您喜欢的水果是什么？</span>
	<ul id="nolul">
		<li><input type="radio" name="nol" value="1"/> 葡萄</li>
		<li><input type="radio" name="nol" value="2"/> 西瓜</li>
		<li><input type="radio" name="nol" value="3"/> 苹果</li>
		<li><input type="radio" name="nol" value="4"/> 芒果</li>
		<li><input type="radio" name="nol" value="5"/> 樱桃</li>
	</ul>
	<div>
		<input type="button" value="查看测试结果" onclick="showResult()">
		<span id="erroinfo"></span>
		<div id="res_1" class="close">1-3分：你的性格偏内向，建议。。。</div>
		<div id="res_2" class="close">4分以上：你的性格偏外向，建议。。。</div>
	</div>
  </body>
</html>

```

360浏览器8.1 演示结果：
---------------
一开始的页面：
![](http://img.blog.csdn.net/20160621213721112)

单选框选中"是”：
![](http://img.blog.csdn.net/20160621213731159)

不选中水果时的提示：
![](http://img.blog.csdn.net/20160621213806503)

选中水果时的提示：
![](http://img.blog.csdn.net/20160621213814878)


下拉列表：
=====

简单的演示代码：
--------

```
<html>
  <head>
    <title>DHTML技术演示---select的使用</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<style type="text/css">
		.clrclass{
			height:50px;
			width:50px;
			float:left;/*漂浮*/
			margin-right:30px;
			margin-bottom:20px;/*下-外补丁*/			
		}
		#text{
			clear:left;/*左边不能漂浮*/
		}
	</style>
	<script type="text/javascript">
		function changeColor( oDicClrNode ){
			//得到要设置的颜色对象
			var colorVal = oDicClrNode.style.backgroundColor;
			//alert(colorVal);
			//设置字体的颜色
			document.getElementById("text").style.color=colorVal;
		}
		
		function changeColor2(){
			//alert("aabb");//试试能不能监听
			var oSelectNode = document.getElementsByName("selectColor")[0];
			var collOptionNodes =oSelectNode.options;//options 获取 select 对象中 option 对象的集合。 
//			for(var x=0;x<collOptionNodes.length;x++){
//				alert( collOptionNodes[x].innerHTML );
//			}//遍历一下。
			//选中的选项
			//alert( collOptionNodes[ oSelectNode.selectedIndex ].innerHTML );
			
			var colorVar = collOptionNodes[ oSelectNode.selectedIndex ].value;
			document.getElementById("text").style.color=colorVar;
		}
		
		function changeColor3(){
			var oSelectNode = document.getElementsByName("selectColor")[1];
			var collOptionNodes = oSelectNode.options;
			var colorVar = collOptionNodes[ oSelectNode.selectedIndex ].value;
			document.getElementById("text").style.color=colorVar;
		}
		
	</script>
	
  </head>
  
  <body>
  	<div class="clrclass" id="clr1" style="background-color:black" onclick="changeColor(this)"></div>
  	<div class="clrclass" id="clr1" style="background-color:red" onclick="changeColor(this)"></div>
  	<div class="clrclass" id="clr2" style="background-color:green" onclick="changeColor(this)"></div>
  	<div class="clrclass" id="clr3" style="background-color:blue" onclick="changeColor(this)"></div>
  	<div class="clrclass" id="clr4" style="background-color:#c0c0c0;" onclick="changeColor(this)"></div>
  	<div class="clrclass" id="clr5" style="background-color:#00ffff" onclick="changeColor(this)"></div>
	<div id="text">
		<img src=""/><br/>
		显示效果文字<br/>
		显示效果文字<br/>
		显示效果文字<br/>
		显示效果文字<br/>
	</div>
	<hr/>
	<!-- //本例，给select注册onclick事件不合适，因为每次点击下拉菜单最外层时就会执行
	   <select name="selectColor" onclick="changeColor2()">
	-->
	<br/>
	
	<select name="selectColor" onchange="changeColor2()">
		<option value="black">--选择颜色--</option>
		<option value="red">红色</option>
		<option value="green">绿色</option>
		<option value="blue">蓝色</option>
		<option value="#c0c0c0">银色</option>
	</select>
	<hr/>
	
	<select name="selectColor" onchange="changeColor3()">
		<!--background-color 设置背景色 -->
		<option value="black" style="background-color:black">--选择颜色--</option>
		<option value="red" style="background-color:red"> </option>
		<option value="green" style="background-color:green"> </option>
		<option value="blue" style="background-color:blue"> </option>
		<option value="#c0c0c0" style="background-color:#c0c0c0"> </option>
	</select>
	
	
  </body>
</html>

```

360浏览器8.1 演示结果：
---------------

这个下拉框是用文字来说明。
![](http://img.blog.csdn.net/20160625151822532)

下面这个下拉框直接用颜色来表明设置文字为什么颜色
![](http://img.blog.csdn.net/20160625151833720)


加强的下拉列表-二级连动菜单-代码演示：
--------------

<b><font color="red">实现的功能就是，根据第一个菜单的选项，来决定第二个菜单的显示。</font></b>

```
<html>
  <head>
    <title>DHTML技术演示---select的使用--二级连动菜单</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<script type="text/javascript">
		function selectCity(){
			//json: 用一个二维数组存储"省份-城市集合",以后该数据要来自后台
			var collProvices ={"beijing" : ['海淀区','东城区','西城区','朝阳区'],
			           "zhejiang"     : ['杭州','宁波','金华','温州'],
					   "hunan"     : ['益阳','长沙','株洲','湘潭'],
					   "jiangxi"     : ['南昌','九江','萍乡','上饶']
					   };
			//{}这个是用来存key:value的，value可以是任意类型（数组集合都可以）、[]这个是数组
			
			//alert(collProvices["beijing"][2]);//西城区
			//获取用户所选择省份的下辖城市集合
			
			var oSelNode = document.getElementById("selid");
			var index = oSelNode.selectedIndex;// selectedIndex选中哪项，返回数字
			var proviceName = oSelNode.options[index].value;//获得选中的那项的value
			var arrCities = collProvices[proviceName];//获得选中的那个省份的下辖城市数组
			
			var oSubSelNode = document.getElementById("subselid");//获得第二个下拉列表对象
			
			//把下拉菜单"subselid"中原有的内容清空
			//注意，数组删除之后，长度是自动更新的
			
			//法1--列表从前面开始移除
//			for(var x=1;x<oSubSelNode.options.length;){//注意，数组删除之后，长度是自动更新的，因此for最后不要用"x++"修正
//				oSubSelNode.removeChild( oSubSelNode.options[x] );
//			}

			//oSubSelNode.length和oSubSelNode.options.length的值一样
			//oSubSelNode[x]和oSubSelNode.options[x]一样
			
			//法2--列表从后面开始移除
//			for(var x=oSubSelNode.length-1;x>=1;x--){
//				oSubSelNode.removeChild( oSubSelNode[x] );
//			}
			
			//法3--直接给oSubSelNode.options.length或oSubSelNode.length赋值
			oSubSelNode.options.length=1; //长度设置为1 ，那么剩余的选项自动被删掉
			
			//把城市集合中的每个元素添加到下拉菜单"subselid"当中
			for(var x=0;x<arrCities.length;x++){
				var optionNode = document.createElement("option");
				optionNode.innerHTML=arrCities[x];
				//oPtionNode.value=...[x];//正式开发，应该还有该选项对应的value值要赋,这里我们就省略了。
				oSubSelNode.appendChild(optionNode);
			}
			
			
		}
		
	</script>
	
  </head>
  
  <body>
  	<select id="selid" onchange="selectCity()">
  		<option>--选择省份--</option>
		<option value="beijing">北京</option>
		<option value="hunan">湖南</option>
		<option value="zhejiang">浙江</option>
		<option value="jiangxi">江西</option>
  	</select>
	
	<select id="subselid">
		<option>--选择城市--</option>
	</select>
  </body>
</html>

```

360浏览器8.1 演示结果：
---------------
![](http://img.blog.csdn.net/20160625155730194)

![](http://img.blog.csdn.net/20160625155738304)

![](http://img.blog.csdn.net/20160625155747057)


file组件--添加与删除附件
===============
没有与后台联系的功能哦，只是学下html中的技术

演示代码：
-----

```
<html>
	<head>
		<title>DHTML技术--file组件--添加与删除附件</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<style type="text/css">
			/*
			 a:link  超链接未点击状态。
			 a:visited 被访问后的状态。
			 a:hover 光标移到超链接上的状态（未点击）。
			 a:active 点击超链接时的状态。
			 使用顺序： L – V – H – A
			*/
			table a:link,table a:visited, img{
				text-decoration:none;
				/*检索或设置对象中的文本的装饰。
				 text-decoration:
				 none  :　 默认值。无装饰 
				 blink  :　 闪烁 
				 underline  :　 下划线 
				 line-through  :　 贯穿线 
				 overline  :　 上划线 
				 */
				color:#0000ff;
			}
			table a:hover{
				color:#ff0000;
			}
			
		</style>
		<script type="text/javascript">
			function addFile(){
				var oFileTableNode = document.getElementById("fileTable");
				var oTrNode = oFileTableNode.insertRow();//insertRow 在表格中创建新行(tr)，并将行添加到 rows 集合中。 
				
				var oTdNodeFile = oTrNode.insertCell();//insertCell 在表格行(tr)中创建新单元格，并将单元格添加到 cells 集合中。 
				
				oTdNodeFile.innerHTML="<input type='file'/>";
				
				var oTdNodeDel = oTrNode.insertCell();
				//用文字
				//oTdNodeDel.innerHTML="<a href='javascript:void(0)' onclick='deleteFile(this)'>删除附件</a>";
				
				//用图片---自己找个图片，取名为a.jpg就可以了-或者改代码
				oTdNodeDel.innerHTML="<img src='a.jpg' alt='删除附件' onclick='deleteFile(this)'/>";
				
			}
			
			function deleteFile(oANode){
				//a标签的父节点是td，td父节点是tr。
				var oTrNodeDel = oANode.parentNode.parentNode;//TR
				oTrNodeDel.parentNode.removeChild( oTrNodeDel );
				
			}
			
			
		</script>
		
	</head>
	
	<body>
		<table id="fileTable">
			<tr>
				<th>
					<a href="javascript:void(0)" onclick="addFile()">添加附件</a>
				</th>
			</tr>
		<!--点按钮来添加附件，所以不用html，用JavaScript写
			<tr>
				<td><input type="file"/> </td>
				<td> <a href="javascript:void(0)" onclick="deleteFile(this)">删除附件</a> </td>
			</tr>
		-->		
		</table>
		
		
	</body>
	
</html>
```

360浏览器8.1 演示结果：
---------------

![](http://img.blog.csdn.net/20160625170609384)

![](http://img.blog.csdn.net/20160625170618353)

删除第二行的tr：
![](http://img.blog.csdn.net/20160625170625603)





本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
