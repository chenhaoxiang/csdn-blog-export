---
layout: post
title: "JavaScript---网络编程(10)--DHTML技术演示(3)-多选框"
date: 2016-06-21 07:52:57 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,javascript,css,技术,checkbox]
keyword: 陈浩翔, 谙忆
description: 这节讲述多选框的使用，当然，肯定是结合css和Javascript一起的。checkbox的使用1：演示代码：<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>DHTML技术演示---checkbox的使用1</title>
    <scrip 
---


这节讲述多选框的使用，当然，肯定是结合css和Javascript一起的。checkbox的使用1：演示代码：<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>DHTML技术演示---checkbox的使用1</title>
    <scrip
<!-- more -->
----------

这节讲述多选框的使用，当然，肯定是结合css和Javascript一起的。

checkbox的使用1：
=============

演示代码：
-----

```
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>DHTML技术演示---checkbox的使用1</title>
	<script type="text/javascript">
		//html中<pre></pre>让代码原样输出-小提示
		function getSum(){
			var sum=0;
			var arrChkNode = document.getElementsByName("item");
			for(var x=0;x<arrChkNode.length;x++){
				if(arrChkNode[x].checked){
					sum+=parseInt(arrChkNode[x].value);
				}
			}
			var sVal = sum+"元";
			//字体颜色设置为红色
			//document.getElementById("sumid").innerHTML="<font color='red'>aaa</font>";
			document.getElementById("sumid").innerHTML=sVal.fontcolor("red");
			
		}
		
		function checkAll(aChkAllNode){
			var arrChkNodes = document.getElementsByName("item");
			for(var x=0;x<arrChkNodes.length;x++){
				//arrChkNodes[x].checked=true;//"true"也可以，但不建议这样使用，因为API中要求的是boolean类型
				arrChkNodes[x].checked= aChkAllNode.checked;
			}
		}
	</script>
	
	</head>
	
	<body>
		<input type="checkbox" name="item" value="8000"/>空调:8000元<br/>
		<input type="checkbox" name="item" value="160"/>风扇:160元<br/>
		<input type="checkbox" name="item" value="4500"/>电脑:4500元<br/>
		<input type="checkbox" name="item" value="5000"/>投影仪:5000元<br/>
		<input type="checkbox" onclick="checkAll(this)"/>全选<br/>
		<input type="button" value="总金额是：" onclick="getSum()"><span id="sumid"> </span>
	</body>
</html>

```

<font color="red">360浏览器8.1 演示结果:</font>
---------------
![](http://img.blog.csdn.net/20160620165128347)

![](http://img.blog.csdn.net/20160620165138024)

![](http://img.blog.csdn.net/20160620165147050)




checkbox的使用2：
=============
仿邮件选择的方式做多选框
table.css:

```
table{
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
.one{
	background-color:#80ff00;
}
.two{
	background-color:#ff80ff;
}
.over{
	background-color:#ffff00;
}

```

第一种方式：
代码：

```
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>DHTML技术演示---checkbox的使用2</title>
	<style type="text/css">
		@import url(table.css);
	</style>
	
	<script type="text/javascript">
		var name;
		function trColor(){
			var oTableNode = document.getElementById("mailTable");
			var collTrNodes = oTableNode.rows;//得到表格的所有行对象-返回数组
			for(var x=1; x<collTrNodes.length;x++ ){
				if(x%2==1){
					collTrNodes[x].className="one";
				}else{
					collTrNodes[x].className="two";
				}
				collTrNodes[x].onmouseover=function(){
					name=this.className;
					this.className="over";
					/*下面这种注册事件的方式也可以
					this.onmouseout=function(){
						this.className=name;
					}
					*/
				}
				collTrNodes[x].onmouseout=function(){
					this.className=name;
				}
			}
		}
		onload = function(){
			trColor();
		}
		
		function checkAll(aChkboxNode){
			var collChkboxAllNodes = document.getElementsByName("all");
			//取消部分选中时的显示样式
			collChkboxAllNodes[0].indeterminate=false;
			collChkboxAllNodes[1].indeterminate=false;
			
			var collMailNodes = document.getElementsByName("mail");
			for(var x=0;x<collMailNodes.length;x++){
				collMailNodes[x].checked = aChkboxNode.checked;
			}
			collChkboxAllNodes[0].checked = aChkboxNode.checked;
			collChkboxAllNodes[1].checked = aChkboxNode.checked;
		}
		
		function checkAllByBtn1(flag){
			var collMailNodes = document.getElementsByName("mail");
			for(var x=0;x<collMailNodes.length;x++){
				collMailNodes[x].checked = flag;
			}
			var collChkboxAllNodes = document.getElementsByName("all");
			collChkboxAllNodes[0].checked = flag;
			collChkboxAllNodes[1].checked = flag;
			//取消部分选中时的显示样式
			collChkboxAllNodes[0].indeterminate=false;
			collChkboxAllNodes[1].indeterminate=false;
		}
		
		function checkAllByBtn2(){
			var collMailNodes = document.getElementsByName("mail");
			var n=0;
			for(var x=0;x<collMailNodes.length;x++ ){
				collMailNodes[x].checked = !collMailNodes[x].checked;
				if( collMailNodes[x].checked ){
					n++;
				}
			}
			var collChkboxAllNodes = document.getElementsByName("all");
			collChkboxAllNodes[0].indeterminate=false;
			collChkboxAllNodes[1].indeterminate=false;
			if(n==0){
				collChkboxAllNodes[0].checked = false;
				collChkboxAllNodes[1].checked = false;
			}else if(n==collMailNodes.length){
				collChkboxAllNodes[0].checked = true;
				collChkboxAllNodes[1].checked = true;
			}else{//部分选中时的显示样式
				collChkboxAllNodes[0].indeterminate=true;
				collChkboxAllNodes[1].indeterminate=true;
			}
		}
		
		function deleteMail(){
			if(!confirm("你真的要删除所选邮件吗？")){//弹出确认对话框
				return;
			}
			
			//获取所有的邮件
			var collMailChkNodes = document.getElementsByName("mail");
			for(var x=0;x<collMailChkNodes.length;x++){
				if (collMailChkNodes[x].checked) {//选中，则删除
					//先拿到tr对象
					var oTrNode = collMailChkNodes[x].parentNode.parentNode;
					oTrNode.parentNode.removeChild(oTrNode);
					//bug:节点容器中，remove之后，长度会变。
					x--;//长度修正--还有一种解决方案是：从后往前删
				}
			}
			trColor();			
		}
		
		
	</script>
	
	
	</head>
	
	<body>
		<h2>邮件列表</h2>
		<table id="mailTable">
			<tr>
				<th><input type="checkbox" name="all" onclick="checkAll(this)"/>全选</th>
				
				<th>发件人</th> <th>邮件标题</th> <th>时间</th>
			</tr>
			<tr>
				<td><input type="checkbox" name="mail" /></td>
				<td>张三</td>  <td>邮件标题11</td> <td>2016年6月16日</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="mail" /></td>
				<td>李四</td>  <td>邮件标题22</td> <td>2016年6月15日</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="mail" /></td>
				<td>张四</td>  <td>邮件标题33</td> <td>2016年6月14日</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="mail" /></td>
				<td>Jack</td>  <td>邮件标题44</td> <td>2016年6月18日</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="mail" /></td>
				<td>Rose</td>  <td>邮件标题55</td> <td>2016年6月25日</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="mail" /></td>
				<td>张六</td>  <td>邮件标题66</td> <td>2016年6月16日</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="all" onClick="checkAll(this)"/>全选</td>
				
				<td colspan="3">
				<!--colspan=3-表示这一列占3列 -->
				<input type="button" value="全选" onclick="checkAllByBtn1(true)">
			  	<input type="button" value="取消全选" onclick="checkAllByBtn1(false)">
			  	<input type="button" value="反选" onclick="checkAllByBtn2()">
				
				<input type="button" value="删除所选邮件" onClick="deleteMail()">
				</td>
			</tr>
			
			
		</table>
		
	</body>
</html>

```

第二中方式：把2个方法合并为一个方法：

```
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>DHTML技术演示---checkbox的使用2</title>
	<style type="text/css">
		@import url(table.css);
	</style>
	
	<script type="text/javascript">
		var name;
		function trColor(){
			var oTableNode = document.getElementById("mailTable");
			var collTrNodes = oTableNode.rows;//得到表格的所有行对象-返回数组
			for(var x=1; x<collTrNodes.length;x++ ){
				if(x%2==1){
					collTrNodes[x].className="one";
				}else{
					collTrNodes[x].className="two";
				}
				collTrNodes[x].onmouseover=function(){
					name=this.className;
					this.className="over";
					/*下面这种注册事件的方式也可以
					this.onmouseout=function(){
						this.className=name;
					}
					*/
				}
				collTrNodes[x].onmouseout=function(){
					this.className=name;
				}
			}
		}
		onload = function(){
			trColor();
		}
		
		function checkAll(aChkboxNode){
			var collChkboxAllNodes = document.getElementsByName("all");
			//取消部分选中时的显示样式
			collChkboxAllNodes[0].indeterminate=false;
			collChkboxAllNodes[1].indeterminate=false;
			
			var collMailNodes = document.getElementsByName("mail");
			for(var x=0;x<collMailNodes.length;x++){
				collMailNodes[x].checked = aChkboxNode.checked;
			}
			collChkboxAllNodes[0].checked = aChkboxNode.checked;
			collChkboxAllNodes[1].checked = aChkboxNode.checked;
		}
		
		//合并的方法：
		function checkAllByBtn(num){
			//获得邮件的所有多选框对象
			var collMailNodes = document.getElementsByName("mail");
			
			var collChkboxAllNodes = document.getElementsByName("all");//获得那2个全选的多选框
			//取消部分选中时的显示样式
			collChkboxAllNodes[0].indeterminate=false;
			collChkboxAllNodes[1].indeterminate=false;
			
			var n=0;
			//遍历所有的邮件多选框
			for(var x=0;x<collMailNodes.length;x++){
				if(num>1){//反选
				  collMailNodes[x].checked = !collMailNodes[x].checked;
				}else{
				   collMailNodes[x].checked = num;
				}
				if(collMailNodes[x].checked){
					n++;
				}
			}
			
			if(n==0){
				collChkboxAllNodes[0].checked = false;
				collChkboxAllNodes[1].checked = false;
			}else if(n==collMailNodes.length){
				collChkboxAllNodes[0].checked = true;
				collChkboxAllNodes[1].checked = true;
			}else{//部分选中时的显示样式
				collChkboxAllNodes[0].indeterminate=true;
				collChkboxAllNodes[1].indeterminate=true;
			}
			
		}
		
		
		
		function deleteMail(){
			if(!confirm("你真的要删除所选邮件吗？")){//弹出确认对话框
				return;
			}
			
			//获取所有的邮件
			var collMailChkNodes = document.getElementsByName("mail");
			for(var x=0;x<collMailChkNodes.length;x++){
				if (collMailChkNodes[x].checked) {//选中，则删除
					//先拿到tr对象
					var oTrNode = collMailChkNodes[x].parentNode.parentNode;
					oTrNode.parentNode.removeChild(oTrNode);
					//bug:节点容器中，remove之后，长度会变。
					x--;//长度修正--还有一种解决方案是：从后往前删
				}
			}
			trColor();			
		}
		
		
	</script>
	
	
	</head>
	
	<body>
		<h2>邮件列表</h2>
		<table id="mailTable">
			<tr>
				<th><input type="checkbox" name="all" onclick="checkAll(this)"/>全选</th>
				
				<th>发件人</th> <th>邮件标题</th> <th>时间</th>
			</tr>
			<tr>
				<td><input type="checkbox" name="mail" /></td>
				<td>张三</td>  <td>邮件标题11</td> <td>2016年6月16日</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="mail" /></td>
				<td>李四</td>  <td>邮件标题22</td> <td>2016年6月15日</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="mail" /></td>
				<td>张四</td>  <td>邮件标题33</td> <td>2016年6月14日</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="mail" /></td>
				<td>Jack</td>  <td>邮件标题44</td> <td>2016年6月18日</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="mail" /></td>
				<td>Rose</td>  <td>邮件标题55</td> <td>2016年6月25日</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="mail" /></td>
				<td>张六</td>  <td>邮件标题66</td> <td>2016年6月16日</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="all" onClick="checkAll(this)"/>全选</td>
				
				<td colspan="3">
				<!--colspan=3-表示这一列占3列 -->
				 <input type="button" value="全选" onClick="checkAllByBtn(1)">
			 	 <input type="button" value="取消全选" onClick="checkAllByBtn(0)">
			  	 <input type="button" value="反选" onClick="checkAllByBtn(2)">
			  	 <input type="button" value="删除所选邮件" onClick="deleteMail()">
				</td>
			</tr>
			
			
		</table>
		
	</body>
</html>

```

360浏览器8.1演示结果：

![](http://img.blog.csdn.net/20160621195201173)

![](http://img.blog.csdn.net/20160621195209833)

![](http://img.blog.csdn.net/20160621195217536)



本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
