---
layout: post
title: "JavaScript---网络编程(9-1)--DHTML技术演示(2-1)-表格创建的几种方式"
date: 2016-06-20 03:21:17 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,技术,对象,dhtml]
keyword: 陈浩翔, 谙忆
description: 一：用最底层的方式，该方式用来创建别的对象树也可以代码演示：<html>
  <head>
    <title>DHTML技术演示---表格创建--用最底层的方式，其实该方式用来创建别的对象树也可以</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style type="tex 
---


一：用最底层的方式，该方式用来创建别的对象树也可以代码演示：<html>
  <head>
    <title>DHTML技术演示---表格创建--用最底层的方式，其实该方式用来创建别的对象树也可以</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style type="tex
<!-- more -->
----------


一：用最底层的方式，该方式用来创建别的对象树也可以
=========================

**代码演示：**
-----
```
<html>
  <head>
    <title>DHTML技术演示---表格创建--用最底层的方式，其实该方式用来创建别的对象树也可以</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<style type="text/css">
		table{
			border:#ff80ff;
			width:500px;
			border-collapse:collapse;
		}
		table td{
			border:#0000ff 1px solid;
			padding:5px;/*内补丁*/
		}
	</style>
	<script type="text/javascript">
		function createTable(){
			//思路: 把表格子树中的每个节点对象创建出来，然后把这些对象组装成一棵树。最后再把这棵树挂到div对象下面
			//1通过document.createElement()创建每个标签对象
			var oTableNode = document.createElement("table");
			var oTbdNode = document.createElement("tbody");
			var oTrNode = document.createElement("tr");
			var oTdNode = document.createElement("td");
			oTdNode.innerHTML="单元格中的内容";
			//2把以上节点组装成一棵树
			oTrNode.appendChild(oTdNode);
			oTbdNode.appendChild(oTrNode);
			oTableNode.appendChild(oTbdNode);
			
			//3把这棵子树加到div对象下面
			document.getElementsByTagName("div")[0].appendChild(oTableNode);
		}
		
	</script>
	
	
  </head>
  
  <body>
  	<input type="button" value="创建表格" onclick="createTable()" />
	<hr/>
	<div></div>
	
  </body>
</html>

```

**360浏览器8.1 演示结果：**
-------------------
点击按钮：就创建一个表格：

![](http://img.blog.csdn.net/20160616172657144)


<font color="red">二、表格创建--用table对象和tr对象中现有的方法来操纵表格</font>
================================

代码演示：
-----

```
<html>
  <head>
    <title>DHTML技术演示---表格创建--用table对象和tr对象中现有的方法来操纵表格</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<style type="text/css">
		table {
			border:#ff80ff;
			width:800px;
			border-collapse:collapse;
			/*separate  :　 默认值。边框独立（标准HTML） 
			collapse  :　 相邻边被合并 
			*/
		}
		table td{
			border:#0000ff 1px solid;
			padding:5px;
		}
	 </style>
	 <script type="text/javascript">
	 	function createTable(){
			var oTableNode = document.createElement("table");
			var oTrNode = oTableNode.insertRow();//往表格对象中插入一个tr对象(空行),并返回该tr对象
			var oTdNode = oTrNode.insertCell();//往tr对象中插入一个Cell即td对象
			oTdNode.innerHTML="单元格中的内容";
			document.getElementsByTagName("div")[0].appendChild(oTableNode);
		}
		
		function createTable2(){
			var oTableNode = document.createElement("table");//创建表格对象
			
			//多行多列的表格,如5*6
			for(var x=1;x<=5;x++){
				
				var oTrNode = oTableNode.insertRow();//往表格对象中插入一个tr对象(空行),并返回该tr对象
				for(var y=1;y<=6;y++){
					var oTdNode = oTrNode.insertCell();//往tr对象中插入一个Cell即td对象
					oTdNode.innerHTML="单元格"+x+"-"+y+"中的内容";
				}
			}
			document.getElementsByTagName("div")[0].appendChild(oTableNode);
		}
		
		//用户自定义行号与列号的方式创建表格
		function createTable3(){
			var oTableNode = document.createElement("table");//创建表格对象
			//给表格动态地添加属性(id)
			//法1
			//oTableNode.id = "tableId";//变量方式
			//法2
			oTableNode.setAttribute("id","tableId");//函数方式
			
			//由用户指定行数和列数的表格
			//获取用户输入飞行数和列数
			var rowNum =parseInt(document.getElementsByName("rowNum")[0].value);
			var colNum =parseInt(document.getElementsByName("colNum")[0].value);
			
			//健壮性防护
			if(isNaN(rowNum) || isNaN(colNum) || rowNum<=0 || colNum<=0 ){
				alert("行号和列号必须是大于0的整数");
				return;
			}
			
			for(var x=1; x<=rowNum;x++){
				//往表格对象中插入一个tr对象（空行），并返回该tr对象
				var oTrNode =oTableNode.insertRow();
				for(var y=1;y<=colNum;y++){
					//往tr对象中插入一个Cell即td对象
					var oTdNode = oTrNode.insertCell();					
					oTdNode.innerHTML="单元格"+x+"-"+y+"中的内容";
				}
			}
			document.getElementsByTagName("div")[0].appendChild(oTableNode);			
		}
		
		
		//删除指定行
		function delRow(){
			//由指定的id来获取该表格
			var oTableNode = document.getElementById("tableId");
			//alert(oTableNode.nodeName);//TABLE
			//alert(oTableNode);
			//防护
			if(oTableNode==null){
				alert("表格不存在");
				return;
			}
			
			//删除行的处理代码
			//获取用户输入的行号
			var delRowNum = parseInt(document.getElementsByName("delRowNum")[0].value);
			
			//alert(delRowNum);
			//行号的健壮性防护
			if(isNaN(delRowNum) ){
				alert("行号必须是数字");
				return;
			}
			if(!(delRowNum>0 && delRowNum<=oTableNode.rows.length)){
				alert("该行不存在!");
				return;
			} 
			//删除行
			oTableNode.deleteRow(delRowNum-1);			
		}
		
		//删除指定的列
		function delCol(){
			//由指定id来获取该表格
			var oTableNode = document.getElementById("tableId");
			//alert(oTableNode.nodeName);
			//alert(oTableNode);
			//防护
			if(oTableNode==null){
				alert("表格不存在!");
				return;
			}
			//删除列的处理代码
			//获取用户输入的列号
			var delColNum = parseInt(document.getElementsByName("delColNum")[0].value);
			
			//alert(delColNum);
			//行号的健壮性防护
			if(isNaN(delColNum)){
				alert("列号必须是数字");
				return ;				
			}
			
			if(!(delColNum>0 && delColNum<=oTableNode.rows[0].cells.length)){
				alert("该列不存在!");
				return;
			}
			//删除列:※※表格中没有现成的删除列的函数，因此只能自己遍历行，然后通过tr对象中的deleteCell来实现
			for(var x=0;x<oTableNode.rows.length;x++){
				oTableNode.rows[x].deleteCell( delColNum-1 );
			}
		}
		
	 </script>
	 
	 
  </head>
  
  <body>
  	<input type="button" value="创建表格" onclick="createTable()" />
	<input type="button" value="创建多行多列表格" onclick="createTable2()" />
	<br/><br/><br/>
	<!--添加-->
	行数:<input type="text" name="rowNum" /> &nbsp;&nbsp;
	列数:<input type="text" name="colNum" /> 
	<input type="button" value="创建表格" onclick="createTable3()" />
	<br/><br/><br/>
	
	<!--删除-->
	<h3>删除前面由用户指定行列号方式创建的表格</h3>
	行号:<input type="text" name="delRowNum"/> &nbsp;&nbsp;
	<input type="button" value="删除行" onclick="delRow()" />
	列号:<input type="text" name="delColNum"/>
	<input type="button" value="删除列" onclick="delCol()" />
	
	<hr/>
	  
	<div></div>
  </body>
</html>

```

360浏览器8.1 演示结果：
---------------
创建一个9行9列的表格，然后删除了第二行和第二列


![](http://img.blog.csdn.net/20160620150515708)


三、表格中页面中的显示操纵--行间隔高亮显示
======================

代码演示：
-----

```
<html>
  <head>
    <title>DHTML技术演示---表格中页面中的显示操纵--行间隔高亮显示</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<style type="text/css">
		@import url(table.css);
		.one{
			background:#00ff00;
		}
		.two{
			background:rgb(210,0,0);
		}		
	</style>
	<script type="text/javascript">
		function trColor(){
			var oTableNode = document.getElementById("dataTable");
			var arrTrs = oTableNode.rows;//rows为表格属性，返回所以的行
			for(var x=1;x<arrTrs.length; x++){
				if(x%2==1){
					arrTrs[x].className="one";
				}else{
					arrTrs[x].className="two";
				}
			}
		}
		//onload = trColor();//这种方式赋值就是执行(本例中，这一句没有效果，因为table对象还没出来。
		//但如果把该段代码放在<table>之后则有效果)，而且只能执行这一个方法
		
		onload=function(){
			trColor();
			//还可以在这里写其它代码，甚至调用其它函数
		};
		//这种方式只是给onload事件注册响应函数，解析该句代码时函数并没有执行
		//而是在该事件发生时才会调用。并且可以在function()中调用多个函数.
		
	</script>
	
		
  </head>
  
  <body>
  		<table id="dataTable">
  			<tr>
  				<th>姓名</th> <th>年龄</th> <th>地址</th>
  			</tr>
			
			<tr>
				<td>张三</td> <td>23</td> <td>湖南长沙</td>
			</tr>
			<tr>
			<td>李四</td> <td>23</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>王五</td> <td>23</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Jack</td> <td>23</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Rose</td> <td>23</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Jack</td> <td>23</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Rose</td> <td>23</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Jack</td> <td>23</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Rose</td> <td>23</td> <td>湖南长沙</td>
			</tr>
  		</table>
	
  </body>
</html>

```

table.css:

```
table {
	border:#ff80ff 1px solid;
	/*solid  :　 实线边框 */
	width:800px;
	border-collapse:collapse;
	/*separate  :　 默认值。边框独立（标准HTML） 
	collapse  :　 相邻边被合并 
	*/	
}
table td{/*table 下面的td*/
	border:#0000ff 1px solid;
	padding:5px;/*内补丁*/
}
table th{
	border:#ff80ff 1px solid;
	padding:5px;
	background-color:#c0c0c0;
}
```


360浏览器8.1 演示结果：
---------------
![](http://img.blog.csdn.net/20160620152031086)


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
