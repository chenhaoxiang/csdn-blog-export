---
layout: post
title: "JavaScript---网络编程(9-2)--DHTML技术演示(2-2)-表格加强"
date: 2016-06-20 04:19:15 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,技术,dhtml,javaScript,web]
keyword: 陈浩翔, 谙忆
description: 对上篇博客的最后那个表格隔行高亮显示加了个功能，鼠标监听和年龄从小到大排序。

演示代码：



html>
  head>
    title>DHTML技术演示---表格中页面中的显示操纵--行间隔高亮显示title>
    meta http-equiv="content-type" content="text/html; charset=UTF-8">
    style type="t 
---


对上篇博客的最后那个表格隔行高亮显示加了个功能，鼠标监听和年龄从小到大排序。

演示代码：



html>
  head>
    title>DHTML技术演示---表格中页面中的显示操纵--行间隔高亮显示title>
    meta http-equiv="content-type" content="text/html; charset=UTF-8">
    style type="t
<!-- more -->
----------

对上篇博客的最后那个表格隔行高亮显示加了个功能，鼠标监听和年龄从小到大排序。

演示代码：

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
		.over{
			background-color:#ffff00;
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
				//为每一行动态注册事件处理方法
				var oldClassName;
				arrTrs[x].onmouseover=function(){
					//监听鼠标-移动到那一行
					oldClassName=this.className;
					this.className="over";
				};
				arrTrs[x].onmouseout=function(){
					//鼠标监听-移开
					this.className=oldClassName;
				};
				
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
	
	
	<script type="text/javascript">
		function sortTable(){
			var oTableNode = document.getElementById("dataTable");
			var arrTrs = oTableNode.rows;
			//思路：用一个新的容器来存放表格的行对象数组，并在新数组中进行排序,把排序后的每个元素(行对象)依次添加到表格对象中
			
			//放到新容器arrTrs2中
			var arrTrs2 = [];
			for (var x = 1; x < arrTrs.length; x++) {
				arrTrs2[x - 1] = arrTrs[x];
			}
			//arrTrs2数组可以看成arrTrs数组的引用
			
			//对容器arrTrs2中的元素进行排序	
			mySort(arrTrs2);
			
			//把排序后的行对象重新加到表格中
			for (var x = 0; x < arrTrs2.length; x++) {
				//arrTrs2[x].parentNode.nodeName//TBODY
				arrTrs2[x].parentNode.appendChild(arrTrs2[x]);
				//arrTrs2数组可以看成arrTrs数组的引用
			}
			
		}
		
		function mySort(arr){
			for(var x=0;x<arr.length-1;x++){
				for(var y=x+1;y<arr.length;y++){
					if(parseInt(arr[x].cells[1].innerText) > parseInt(arr[y].cells[1].innerText)){
						var temp = arr[x];
						arr[x] = arr[y];
						arr[y] = temp;
					}
				}
			}
		}
		
	</script>
	
		
  </head>
  
  <body>
  		<table id="dataTable">
  			<tr>
  				<th>姓名</th> <th><a href="javascript:void(0)" onclick="sortTable()">年龄</a></th> <th>地址</th>
  			</tr>
			
			<tr>
				<td>张三</td> <td>23</td> <td>湖南长沙</td>
			</tr>
			<tr>
			<td>李四</td> <td>24</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>王五</td> <td>53</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Jack</td> <td>65</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Rose</td> <td>13</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Jack</td> <td>8</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Rose</td> <td>73</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Jack</td> <td>29</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Rose</td> <td>20</td> <td>湖南长沙</td>
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

演示结果：
鼠标监听：
![](http://img.blog.csdn.net/20160620160018328)

点一下年龄：实现表格按年龄从小到大排序
![](http://img.blog.csdn.net/20160620160028887)


现在我们觉得上面的不好，只能从小到大排序，而且排序后颜色也变了。不好看，现在我们来对它进行改进。

代码演示：

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
		.over{
			background-color:#ffff00;
		}	
		a{
			text-decoration:none;/*装饰-去掉下划线*/
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
				//为每一行动态注册事件处理方法
				var oldClassName;
				arrTrs[x].onmouseover=function(){
					//监听鼠标-移动到那一行
					oldClassName=this.className;
					this.className="over";
				};
				arrTrs[x].onmouseout=function(){
					//鼠标监听-移开
					this.className=oldClassName;
				};
				
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
	
	
	<script type="text/javascript">
		var flag=true;
		function sortTable(aNode){
			var oTableNode = document.getElementById("dataTable");
			var arrTrs = oTableNode.rows;
			//思路：用一个新的容器来存放表格的行对象数组，并在新数组中进行排序,把排序后的每个元素(行对象)依次添加到表格对象中
			
			//放到新容器arrTrs2中
			var arrTrs2 = [];
			for (var x = 1; x < arrTrs.length; x++) {
				arrTrs2[x - 1] = arrTrs[x];
			}
			//arrTrs2数组可以看成arrTrs数组的引用
			
			//对容器arrTrs2中的元素进行排序	
			mySort(arrTrs2);
			
			//把排序后的行对象重新加到表格中
			if(flag){
				for (var x = 0; x < arrTrs2.length; x++) {
					//arrTrs2[x].parentNode.nodeName//TBODY
					arrTrs2[x].parentNode.appendChild(arrTrs2[x]);
					//arrTrs2数组可以看成arrTrs数组的引用
				}
				aNode.innerHTML="年龄↑";
			}else{
				for(var x=arrTrs2.length-1;x>=0;x--){
					arrTrs2[x].parentNode.appendChild(arrTrs2[x]);
				}
				aNode.innerHTML="年龄↓";
			}
			flag = !flag;
			trColor();
		}
		
		function mySort(arr){
			for(var x=0;x<arr.length-1;x++){
				for(var y=x+1;y<arr.length;y++){
					if(parseInt(arr[x].cells[1].innerText) > parseInt(arr[y].cells[1].innerText)){
						var temp = arr[x];
						arr[x] = arr[y];
						arr[y] = temp;
					}
				}
			}
		}
		
	</script>
	
		
  </head>
  
  <body>
  		<table id="dataTable">
  			<tr>
  				<th>姓名</th> <th><a href="javascript:void(0)" onclick="sortTable(this)">年龄</a></th> <th>地址</th>
  			</tr>
			
			<tr>
				<td>张三</td> <td>23</td> <td>湖南长沙</td>
			</tr>
			<tr>
			<td>李四</td> <td>24</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>王五</td> <td>53</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Jack</td> <td>65</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Rose</td> <td>13</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Jack</td> <td>8</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Rose</td> <td>73</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Jack</td> <td>29</td> <td>湖南长沙</td>
			</tr>
			<tr>
				<td>Rose</td> <td>20</td> <td>湖南长沙</td>
			</tr>
  		</table>
	
  </body>
</html>

```

演示结果：

![](http://img.blog.csdn.net/20160620161718879)

![](http://img.blog.csdn.net/20160620161726648)

![](http://img.blog.csdn.net/20160620161733024)

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
