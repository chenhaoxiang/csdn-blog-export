---
layout: post
title: "【1】JAVA---地址App小软件（AddressApp.class）（初步接触项目开发的分层思想）（表现层）"
date: 2016-03-30 11:45:40 +0800
comments: true
categories:❷ Java大学之行,----- ②、Java设计模块,----- ----- Java地址App
tags: [软件,app]
keyword: 陈浩翔, 谙忆
description: 这个是表现层的main方法。 
实现的地址信息有： 
姓名，性别，年龄，电话，地址。 
实现的功能有： 
增加地址； 
删除地址； 
修改地址； 
查找地址：其中年龄的查找为年龄段的查找。数据存储的方式为文件存储和读写。分层的思想是：表现层调用逻辑层，逻辑层调用数据层。不可以反过来每个class文件都带了包名字，建好文件就可以了。/*
 * AddressApp.java
 *
 */package 
---


这个是表现层的main方法。 
实现的地址信息有： 
姓名，性别，年龄，电话，地址。 
实现的功能有： 
增加地址； 
删除地址； 
修改地址； 
查找地址：其中年龄的查找为年龄段的查找。数据存储的方式为文件存储和读写。分层的思想是：表现层调用逻辑层，逻辑层调用数据层。不可以反过来每个class文件都带了包名字，建好文件就可以了。/*
 * AddressApp.java
 *
 */package
<!-- more -->
----------

这个是表现层的main方法。
实现的地址信息有：
姓名，性别，年龄，电话，地址。
实现的功能有：
增加地址；
删除地址；
修改地址；
查找地址：其中年龄的查找为年龄段的查找。

数据存储的方式为文件存储和读写。

分层的思想是：表现层调用逻辑层，逻辑层调用数据层。不可以反过来

每个class文件都带了包名字，建好文件就可以了。
```
/*
 * AddressApp.java
 *
 */

package cn.hncu.addr;

import java.awt.Panel;

import javax.swing.JPanel;

import cn.hncu.addr.ui.AddPanel;
import cn.hncu.addr.ui.ListPanel;
/**
*
* @author  __chx__
*/
public class AddressApp extends javax.swing.JFrame {
	/** Creates new form AddressApp */
	public AddressApp() {
		super("地址的增删改查小软件!");
		initComponents();
		this.setContentPane(new ListPanel(this));
		this.setResizable(false);//设置窗口不能缩放
	}

	
	private void initComponents() {

		menuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		openMenuItem = new javax.swing.JMenuItem();
		saveMenuItem = new javax.swing.JMenuItem();
		saveAsMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		editMenu = new javax.swing.JMenu();
		cutMenuItem = new javax.swing.JMenuItem();
		copyMenuItem = new javax.swing.JMenuItem();
		pasteMenuItem = new javax.swing.JMenuItem();
		deleteMenuItem = new javax.swing.JMenuItem();
		helpMenu = new javax.swing.JMenu();
		contentsMenuItem = new javax.swing.JMenuItem();
		aboutMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(new java.awt.Rectangle(150, 150, 0, 0));
		setMinimumSize(new java.awt.Dimension(800, 600));
		getContentPane().setLayout(null);

		fileMenu.setText("File");

		openMenuItem.setText("Open");
		fileMenu.add(openMenuItem);

		saveMenuItem.setText("Save");
		fileMenu.add(saveMenuItem);

		saveAsMenuItem.setText("Save As ...");
		fileMenu.add(saveAsMenuItem);

		exitMenuItem.setText("Exit");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		editMenu.setText("Edit");

		cutMenuItem.setText("Cut");
		editMenu.add(cutMenuItem);

		copyMenuItem.setText("Copy");
		editMenu.add(copyMenuItem);

		pasteMenuItem.setText("Paste");
		editMenu.add(pasteMenuItem);

		deleteMenuItem.setText("Delete");
		editMenu.add(deleteMenuItem);

		menuBar.add(editMenu);

		helpMenu.setText("Help");

		contentsMenuItem.setText("Contents");
		helpMenu.add(contentsMenuItem);

		aboutMenuItem.setText("About");
		helpMenu.add(aboutMenuItem);

		menuBar.add(helpMenu);

		setJMenuBar(menuBar);

		pack();
	}

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
		System.exit(0);
	}

	
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AddressApp().setVisible(true);
			}
		});
	}

	private javax.swing.JMenuItem aboutMenuItem;
	private javax.swing.JMenuItem contentsMenuItem;
	private javax.swing.JMenuItem copyMenuItem;
	private javax.swing.JMenuItem cutMenuItem;
	private javax.swing.JMenuItem deleteMenuItem;
	private javax.swing.JMenu editMenu;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JMenu helpMenu;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenuItem openMenuItem;
	private javax.swing.JMenuItem pasteMenuItem;
	private javax.swing.JMenuItem saveAsMenuItem;
	private javax.swing.JMenuItem saveMenuItem;
	

}
```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
