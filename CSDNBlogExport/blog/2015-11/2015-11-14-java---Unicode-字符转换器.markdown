---
layout: post
title: "java---Unicode-字符转换器"
date: 2015-11-14 02:23:46 +0800
comments: true
categories:❷ Java大学之行,----- ①、Java/Web小项目
tags: []
keyword: 陈浩翔, 谙忆
description: 实现一个字符（包括汉字）的简单互相转换；package cn.hncu.gui2;import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java. 
---


实现一个字符（包括汉字）的简单互相转换；package cn.hncu.gui2;import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.
<!-- more -->
----------

实现一个字符（包括汉字）的简单互相转换；

```
package cn.hncu.gui2;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class QueryFrame extends Frame implements ActionListener {
	private TextField tfd1,tfd2;
	private Button btnChar,btnUni;

	public QueryFrame(String str) {
		super(str);
		this.setBounds(300,240,300,150);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		
		tfd1 = new TextField("汉字",10);
		this.add(new Label("请输入要查询的汉字"));
		this.add(tfd1);
		tfd2 = new TextField(10);
		this.add(new Label("Unicode码值"));
		this.add(tfd2);
		
		btnUni =  new Button("查询Unicode码");
		btnChar = new Button("查询字符");
		this.add(btnUni);
		this.add(btnChar);
		
		btnUni.addActionListener(this);
		btnChar.addActionListener(this);
		
		this.addWindowListener(new Win2Close());
		
		this.setVisible(true);
		}

	public static void main(String[] args) {
		new QueryFrame("Unicode字符查询器");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnUni){
			String str = tfd1.getText();
			char ch = str.charAt(0);
			tfd2.setText(""+(int)ch);
		}else   if(e.getSource()==btnChar){
			String str = tfd2.getText();
				try {
					int n = Integer.parseInt(str);
					tfd1.setText(""+(char)n);
				} catch (NumberFormatException e1) {
					tfd1.setText(str+ "不能转换");
				}
		
		}
			
	}	
}

class Win2Close extends WindowAdapter{
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

```
正常转换：
![](http://img.blog.csdn.net/20151114142234466)

异常处理：
![](http://img.blog.csdn.net/20151114142324574)



本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
