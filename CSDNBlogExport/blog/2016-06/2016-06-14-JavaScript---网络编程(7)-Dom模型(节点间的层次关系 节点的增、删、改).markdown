---
layout: post
title: "JavaScript---网络编程(7)-Dom模型(节点间的层次关系 节点的增、删、改)"
date: 2016-06-14 02:05:45 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,标签,对象,DOM,JS]
keyword: 陈浩翔, 谙忆
description: 利用节点间的层次关系获取节点： 
上一节讲了3中获取的方式： 
 * ※※一、绝对获取，获取元素的3种方式：—Element 
         * 1、getElementById(): 通过标签中的id属性值获来取该标签对象 
         * 2、getElementsByName(): 通过标签中的name属性值来获取该标签对象集合 
         * 3、getElementsBy 
---


利用节点间的层次关系获取节点： 
上一节讲了3中获取的方式： 
 * ※※一、绝对获取，获取元素的3种方式：—Element 
         * 1、getElementById(): 通过标签中的id属性值获来取该标签对象 
         * 2、getElementsByName(): 通过标签中的name属性值来获取该标签对象集合 
         * 3、getElementsBy
<!-- more -->
----------

<font color="blue">**利用节点间的层次关系获取节点：**</font>
上一节讲了3中获取的方式：
 * ※※一、绝对获取，获取元素的3种方式：---Element
		 * 1、getElementById(): 通过标签中的id属性值获来取该标签对象
		 * 2、getElementsByName(): 通过标签中的name属性值来获取该标签对象集合
		 * 3、getElementsByTagName(): 通过标签名来获取该标签对象集合

<font color="blue">**现在来看看相对获取的方式：**</font>
   ※※二、相对获取(利用节点之间的层次关系)，获取节点：---Node
		   1、父节点：parentNode--属性
		   2、子节点：childNodes--集合
		   3、上一个兄弟节点：previousSibling--属性
		   4、下一个兄弟节点：nextSibling--属性
		   5、使用以上属性时，要小心空白符节点(#Text)的存在。对于表格，还要注意<tr>有一个隐含的父节点<tbody>。
		 */


<font color="red">**演示代码：**</font>

```
<html>
<head>
<title>Dom模型演示3---利用节点间的层次关系获取节点</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
	/*
	 * ※※一、绝对获取，获取元素的3种方式：---Element
	 * 1、getElementById(): 通过标签中的id属性值获来取该标签对象
	 * 2、getElementsByName(): 通过标签中的name属性值来获取该标签对象集合
	 * 3、getElementsByTagName(): 通过标签名来获取该标签对象集合
	   
	   ※※二、相对获取(利用节点之间的层次关系)，获取节点：---Node
	   1、父节点：parentNode--属性
	   2、子节点：childNodes--集合
	   3、上一个兄弟节点：previousSibling--属性
	   4、下一个兄弟节点：nextSibling--属性
	   5、使用以上属性时，要小心空白符节点(#Text)的存在。对于表格，还要注意<tr>有一个隐含的父节点<tbody>。
	 */

	//通过节点间的层次关系来获取节点
	function getNodeByLevel() {
		var tabNode = document.getElementById("table1");
		//获取父节点

		var node = tabNode.parentNode;
		//alert(node.nodeName);//BODY,如果是IE6则是：TBODY
		//alert( tabNode.parentNode.parentNode.nodeName);//HTML

		//获取子节点
		/*
		   使用childNodes时，需注意几点：
		   1，<table>标签下还隐藏一个<tbody>标签，<tbody>下面才是<tr>
		   2,空白符(空格或换行符)是被看成是一个文本节点的。例如，如果<table>和<tr>之间有换行或空格，则<table>的第一个孩子节点nodeName是：#text
		   3, 上面的<tbody>和#text节点是兄弟关系
		 */
		//需求：显示出表格中的所有姓名
		var children = tabNode.childNodes;
		//alert(children[0].nodeName);//#text
		//alert(children[1].nodeName);//<tbody>
		var trNodes = children[1].childNodes;
		alert(trNodes.length);
		var str="";
		
		for(var x=0;x<trNodes.length;x++){
			//用卫条件把<tr>与<td>之间的空白符过滤掉
			if(trNodes[x].nodeType==3){
				continue;
			}
			
			//注意，trNodes[x].childNodes[0]是空白符即#text节点，trNodes[x].childNodes[1]才是<td>节点
			//str=str+trNodes[x].childNodes[1].innerText+" ";
			//上面是偷懒写法，如果想写得兼容性好些，应该还用for循环遍历strNodes[x]的所有孩子节点且过滤掉#text节点，获取第一个非空白子节点的innerText
			
			
			for(var i=0;i<trNodes[x].childNodes.length;i++){
				if(trNodes[x].childNodes[i].nodeType==3){
					continue;
				}
				str=str+trNodes[x].childNodes[i].innerText+" ";
				break;
			}
			
		}
		alert(str);
		
		//获取兄弟节点
		
		//上一个
		var node  = tabNode.previousSibling;
		alert(node.nodeName);//#text
		node = node.previousSibling;
		alert(node.nodeName);//BR
		
		//下一个
		var node = tabNode.nextSibling;
		alert(node.nodeName);//#text
		node = node.nextSibling;
		alert(node.nodeName);//HR
	}
</script>

</head>

<body>
	<div id="divId1">div区域1中的文字</div>
	<br/>
	<table id="table1">
		<tr>
			<td>Jack</td>
			<td>20</td>
		</tr>
		<tr>
			<td>张三</td>
			<td>23</td>
		</tr>
		<tr>
			<td>李四</td>
			<td>22</td>
		</tr>
		<tr>
			<td>罗斯</td>
			<td>22</td>
		</tr>
	</table>
	<hr />

	<input type="button" value="获取元素" onclick="getNodeByLevel()" />
</body>

</html>

```

部分演示结果：
![](http://img.blog.csdn.net/20160614130942334)




**节点的增、删、改操作--查有6种，在前面已经讲过**

演示代码：

```
<html>
	<head>
		<title>Dom模型演示4---节点的增、删、改操作--查有6种，在前面已经讲过</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<style type="text/css">
			div{
				border: #0000ff solid 1px;
				width: 200px;
				padding: 30px;/*内补丁*/
				margin: 10px;/*外补丁*/
			}
			#div1{	background-color:#00ccff;	}/*设置或检索对象的背景颜色。*/
			#div2{	background-color:#ffccff;	}
			#div3{	background-color:#ffff00;	}
			#div4{	background-color:#00cc00;	}
		</style>
	</head>

	<body>
		<div id="div1"> </div>
		<div id="div2"> div区域2中的文字 </div>
		<div id="div3"> div区域3中的文字 </div>
		<div id="div4"> div区域4中的文字 </div>
		
		<hr/>
		
		<input type="button" value="添加一个文本节点" onclick="creataAndadd1()" >
		<input type="button" value="添加一个按钮节点" onclick="creataAndadd2()" >
		<input type="button" value="第三种添加方式" onclick="creataAndadd3()" >
		<br/>
		<input type="button" value="删除节点" onclick="delNode()" />
		<br/>
		<input type="button" value="移动替换节点" onclick="updateNode1()" />
		<input type="button" value="克隆替换节点" onclick="updateNode2()" />
		
		
		<script type="text/javascript">
			//添加一个文本节点
			function creataAndadd1(){
				//createTextNode 从指定值中创建文本字符串。 
				//创建一个文本节点
				var oTextNode = document.createTextNode("新添加的文本内容");
				//获取div1节点
				var oDivNode1 = document.getElementById("div1");
				//让div1节点把oTextNode节点添加为孩子
				oDivNode1.appendChild(oTextNode);
				//appendChild 给对象追加一个子元素。 
			}
			
			//添加一个按钮节点---基于对象,dom
			function creataAndadd2(){
				//创建一个按钮节点
				var oBtnNode = document.createElement("input");
				//createElement 为指定标签创建一个元素的实例。 
				
				oBtnNode.type="button";
				oBtnNode.value="一个按钮";
				
				//获取div1节点
				var oDivNode1 = document.getElementById("div1");
				//让div1节点把oBtnNode节点添加为孩子
				oDivNode1.appendChild(oBtnNode);
			}
			
			//第3种添加节点的方式---html的方式
			function creataAndadd3(){
				//获取div1节点
				var oDivNode1 = document.getElementById("div1");
				
				//innerHTML 设置或获取位于对象起始和结束标签内的 HTML。 
				//添加文本节点
				oDivNode1.innerHTML = "湖南城院";//只赋一个
				//oDivNode1.innerHTML +="湖南城院";//追加
				
				//继续添加按钮
				//oDivNode1.innerHTML = "<input type='button' value='按钮a'/> ";
				oDivNode1.innerHTML += "<input type='button' value='按钮a'/> ";
				//继续添加链接
				oDivNode1.innerHTML += "<a href='http://www.baidu.com'/>百度一下</a>";
			}
			
			//删除节点
			function delNode(){
				//获取div2节点
				var oDivNode2 = document.getElementById("div2");
				//oDivNode2.removeNode();//只删当前节点-removeNode 从文档层次中删除对象。
				//360-8.1浏览器中无效-IE支持
				//oDivNode2.removeNode(true);//删当前节点及子节点--子树-
				//360-8.1浏览器中无效-IE支持
				//※removeNode()方法不建议使用，因为这种删除不彻底!---建议使用父节点来删除
				//因为-自己删除自己，怎么可能删除干净嘛
				
				oDivNode2.parentNode.removeChild(oDivNode2);//都支持
				//removeChild 从元素上删除子结点。 
			}
			
			//修改节点1---移动替换
			function updateNode1(){
				var oDivNode1 = document.getElementById("div1");
				
				var oDivNode3 = document.getElementById("div3");
				//oDivNode1.replaceNode(oDivNode3);//自己替换，
				//不建议-360-8.1浏览器中无效-IE支持
				//replaceNode 用其它元素替换对象。 
				
				oDivNode1.parentNode.replaceChild(oDivNode3,oDivNode1);
				//replaceChild 用新的子元素替换已有的子元素。 
			}
			
			//修改节点2---克隆替换
			function updateNode2(){
				var oDivNode1 = document.getElementById("div1");
				var oDivNode3 = document.getElementById("div3");
				
				//var oDivNode3Clone = oDivNode3.cloneNode();//不包含子节点的克隆
				//cloneNode 从文档层次中复制对对象的引用。 
				var oDivNode3Clone = oDivNode3.cloneNode(true);//包含子节点的克隆
				oDivNode1.parentNode.replaceChild(oDivNode3Clone, oDivNode1);				
			}
			
			
		
		</script>

	</body>

</html>

```


演示结果：
一开始：
![](http://img.blog.csdn.net/20160614140321575)

点第一个按钮：
![](http://img.blog.csdn.net/20160614140344372)

再点第二个按钮：
![](http://img.blog.csdn.net/20160614140400356)

再点第三个按钮：
![](http://img.blog.csdn.net/20160614140415159)

再点第四个按钮：
![](http://img.blog.csdn.net/20160614140438300)

点第五个按钮：
![](http://img.blog.csdn.net/20160614140501675)

点第六个按钮;
![](http://img.blog.csdn.net/20160614140518341)


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
