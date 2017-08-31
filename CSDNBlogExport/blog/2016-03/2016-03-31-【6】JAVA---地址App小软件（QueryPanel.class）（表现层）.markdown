---
layout: post
title: "【6】JAVA---地址App小软件（QueryPanel.class）（表现层）"
date: 2016-03-31 12:24:02 +0800
comments: true
categories:❷ Java大学之行,----- ②、Java设计模块,----- ----- Java地址App
tags: []
keyword: 陈浩翔, 谙忆
description: 查找模块： 
年龄可进行段查找。 
其他的都是模糊匹配。 
空格为无用字符，会屏蔽的（除年龄）。 
（如果在年龄中输入空格，会出现异常，当时没想到这点，要防护这点很容易的，但因为在这个小软件的编写过程，我主要学的是java项目开发的分层思想，软件可能bug比较多，望见谅。）/*
 * QueryPanel.java
 *
 */package cn.hncu.addr.ui;import javax 
---


查找模块： 
年龄可进行段查找。 
其他的都是模糊匹配。 
空格为无用字符，会屏蔽的（除年龄）。 
（如果在年龄中输入空格，会出现异常，当时没想到这点，要防护这点很容易的，但因为在这个小软件的编写过程，我主要学的是java项目开发的分层思想，软件可能bug比较多，望见谅。）/*
 * QueryPanel.java
 *
 */package cn.hncu.addr.ui;import javax
<!-- more -->
----------

查找模块：
年龄可进行段查找。
其他的都是模糊匹配。
空格为无用字符，会屏蔽的（除年龄）。
（如果在年龄中输入空格，会出现异常，当时没想到这点，要防护这点很容易的，但因为在这个小软件的编写过程，我主要学的是java项目开发的分层思想，软件可能bug比较多，望见谅。）

![](http://img.blog.csdn.net/20160331002335629)




```
/*
 * QueryPanel.java
 *
 */

package cn.hncu.addr.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.hncu.addr.business.AddrBusiness;

/**
 *
 * @author  __chx__
 */
public class QueryPanel extends javax.swing.JPanel {
	private JFrame mainFrame = null;
	String[] strsQu = null;


	public QueryPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		initComponents();
		myInitComponents();
	}

	private void myInitComponents() {
		strsQu = new String[6];
		jtfAge1.setText("0");
		jtfAge.setText("999");
	}

	
	private void initComponents() {

		jLabel2 = new javax.swing.JLabel();
		jlbName1 = new javax.swing.JLabel();
		jtfName = new javax.swing.JTextField();
		jtfxingbie = new javax.swing.JTextField();
		jlbxingbie = new javax.swing.JLabel();
		jlbAge = new javax.swing.JLabel();
		jtfAge = new javax.swing.JTextField();
		jtfDianhua = new javax.swing.JTextField();
		jlbDianhau = new javax.swing.JLabel();
		jlbAddress = new javax.swing.JLabel();
		jtfAddress = new javax.swing.JTextField();
		jbtnFind = new javax.swing.JButton();
		jbtnreturn = new javax.swing.JButton();
		jtfAge1 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 48));
		jLabel2.setForeground(new java.awt.Color(255, 51, 0));
		jLabel2.setText("\u67e5\u627e\u5730\u5740\u4fe1\u606f");
		add(jLabel2);
		jLabel2.setBounds(230, 20, 330, 90);

		jlbName1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbName1.setText("\u59d3\u540d\uff1a");
		add(jlbName1);
		jlbName1.setBounds(140, 150, 60, 40);
		add(jtfName);
		jtfName.setBounds(200, 160, 130, 23);
		add(jtfxingbie);
		jtfxingbie.setBounds(200, 200, 190, 23);

		jlbxingbie.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbxingbie.setText("\u6027\u522b\uff1a");
		add(jlbxingbie);
		jlbxingbie.setBounds(140, 190, 60, 40);

		jlbAge.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbAge.setText("\u5e74\u9f84\u6bb5\uff1a");
		add(jlbAge);
		jlbAge.setBounds(120, 230, 80, 40);
		add(jtfAge);
		jtfAge.setBounds(340, 240, 70, 23);
		add(jtfDianhua);
		jtfDianhua.setBounds(200, 280, 330, 23);

		jlbDianhau.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbDianhau.setText("\u7535\u8bdd\uff1a");
		add(jlbDianhau);
		jlbDianhau.setBounds(140, 270, 60, 40);

		jlbAddress.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbAddress.setText("\u5730\u5740\uff1a");
		add(jlbAddress);
		jlbAddress.setBounds(140, 310, 60, 40);
		add(jtfAddress);
		jtfAddress.setBounds(200, 320, 410, 23);

		jbtnFind.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jbtnFind.setForeground(new java.awt.Color(255, 0, 51));
		jbtnFind.setText("\u67e5\u627e");
		jbtnFind.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnFindActionPerformed(evt);
			}
		});
		add(jbtnFind);
		jbtnFind.setBounds(140, 430, 110, 70);

		jbtnreturn.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jbtnreturn.setForeground(new java.awt.Color(0, 204, 204));
		jbtnreturn.setText("\u53d6\u6d88");
		jbtnreturn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnreturnActionPerformed(evt);
			}
		});
		add(jbtnreturn);
		jbtnreturn.setBounds(490, 430, 110, 70);
		add(jtfAge1);
		jtfAge1.setBounds(200, 240, 70, 23);

		jLabel1.setText("\u2014\u2014");
		add(jLabel1);
		jLabel1.setBounds(290, 240, 41, 17);
	}

	private void jbtnreturnActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.setContentPane(new ListPanel(mainFrame));
		mainFrame.validate();
	}

	private void jbtnFindActionPerformed(java.awt.event.ActionEvent evt) {
		// 表现层代码的基本写法
		strsQu[0] = jtfName.getText();
		strsQu[1] = jtfxingbie.getText();
		strsQu[2] = jtfAge1.getText();
		strsQu[3] = jtfDianhua.getText();
		strsQu[4] = jtfAddress.getText();
		strsQu[5] = jtfAge.getText();
		
		// 3.调用逻辑层
		AddrBusiness set = new AddrBusiness();
		Object[] objs = set.query(strsQu);
		
//		for(int i=0;i<objs.length;i++){
//			System.out.println(objs[i]);
//		}
		// 4.根据逻辑层的返回结果，导向不同的结果界面
		mainFrame.setContentPane(new ListPanel(mainFrame,objs));
		mainFrame.revalidate();
		
	}

	
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JButton jbtnFind;
	private javax.swing.JButton jbtnreturn;
	private javax.swing.JLabel jlbAddress;
	private javax.swing.JLabel jlbAge;
	private javax.swing.JLabel jlbDianhau;
	private javax.swing.JLabel jlbName1;
	private javax.swing.JLabel jlbxingbie;
	private javax.swing.JTextField jtfAddress;
	private javax.swing.JTextField jtfAge;
	private javax.swing.JTextField jtfAge1;
	private javax.swing.JTextField jtfDianhua;
	private javax.swing.JTextField jtfName;
	private javax.swing.JTextField jtfxingbie;
	

}
```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
