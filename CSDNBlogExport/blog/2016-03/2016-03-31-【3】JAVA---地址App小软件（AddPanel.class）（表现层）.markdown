---
layout: post
title: "【3】JAVA---地址App小软件（AddPanel.class）（表现层）"
date: 2016-03-31 12:07:10 +0800
comments: true
categories:❷ Java大学之行,----- ②、Java设计模块,----- ----- Java地址App
tags: [软件]
keyword: 陈浩翔, 谙忆
description: 添加地址信息界面。年龄和地址必须是数字，否则会弹出窗口提示。 
地址信息不能为空。 
/*
 * AddPanel.java
 *
 * Created on __DATE__, __TIME__
 */package cn.hncu.addr.ui;import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swi 
---


添加地址信息界面。年龄和地址必须是数字，否则会弹出窗口提示。 
地址信息不能为空。 
/*
 * AddPanel.java
 *
 * Created on __DATE__, __TIME__
 */package cn.hncu.addr.ui;import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swi
<!-- more -->
----------

添加地址信息界面。

![](http://img.blog.csdn.net/20160331000437168)



年龄和地址必须是数字，否则会弹出窗口提示。
![](http://img.blog.csdn.net/20160331000521372)


地址信息不能为空。
![](http://img.blog.csdn.net/20160331000603091)


```
/*
 * AddPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.addr.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cn.hncu.addr.business.AddrBusiness;

/**
 * 
 * @author __chx__
 */
public class AddPanel extends javax.swing.JPanel {
	private JFrame mainFrame = null;

	public AddPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		initComponents();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jlbAddress = new javax.swing.JLabel();
		jlbName1 = new javax.swing.JLabel();
		jlbxingbie = new javax.swing.JLabel();
		jlbAge = new javax.swing.JLabel();
		jlbDianhau = new javax.swing.JLabel();
		jtfAddress = new javax.swing.JTextField();
		jtfName = new javax.swing.JTextField();
		jtfxingbie = new javax.swing.JTextField();
		jtfAge = new javax.swing.JTextField();
		jtfDianhua = new javax.swing.JTextField();
		jbtnreturn = new javax.swing.JButton();
		jbtnsure = new javax.swing.JButton();
		jlbmost1 = new javax.swing.JLabel();
		jlbmost2 = new javax.swing.JLabel();
		jlbmost3 = new javax.swing.JLabel();
		jlbmost4 = new javax.swing.JLabel();
		jlbmost5 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();

		setPreferredSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 48));
		jLabel1.setForeground(new java.awt.Color(255, 51, 0));
		jLabel1.setText("\u6dfb\u52a0\u5730\u5740\u4fe1\u606f");
		add(jLabel1);
		jLabel1.setBounds(210, 20, 320, 90);

		jlbAddress.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbAddress.setText("\u5730\u5740\uff1a");
		add(jlbAddress);
		jlbAddress.setBounds(140, 310, 60, 40);

		jlbName1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbName1.setText("\u59d3\u540d\uff1a");
		add(jlbName1);
		jlbName1.setBounds(140, 150, 60, 40);

		jlbxingbie.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbxingbie.setText("\u6027\u522b\uff1a");
		add(jlbxingbie);
		jlbxingbie.setBounds(140, 190, 60, 40);

		jlbAge.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbAge.setText("\u5e74\u9f84\uff1a");
		add(jlbAge);
		jlbAge.setBounds(140, 230, 60, 40);

		jlbDianhau.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbDianhau.setText("\u7535\u8bdd\uff1a");
		add(jlbDianhau);
		jlbDianhau.setBounds(140, 270, 60, 40);
		add(jtfAddress);
		jtfAddress.setBounds(200, 320, 410, 23);
		add(jtfName);
		jtfName.setBounds(200, 160, 130, 23);
		add(jtfxingbie);
		jtfxingbie.setBounds(200, 200, 190, 23);
		add(jtfAge);
		jtfAge.setBounds(200, 240, 260, 23);
		add(jtfDianhua);
		jtfDianhua.setBounds(200, 280, 330, 23);

		jbtnreturn.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jbtnreturn.setForeground(new java.awt.Color(0, 204, 204));
		jbtnreturn.setText("\u8fd4\u56de");
		jbtnreturn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnreturnActionPerformed(evt);
			}
		});
		add(jbtnreturn);
		jbtnreturn.setBounds(490, 430, 110, 70);

		jbtnsure.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jbtnsure.setForeground(new java.awt.Color(255, 0, 51));
		jbtnsure.setText("\u786e\u5b9a");
		jbtnsure.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnsureActionPerformed(evt);
			}
		});
		add(jbtnsure);
		jbtnsure.setBounds(140, 430, 110, 70);

		jlbmost1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jlbmost1.setForeground(new java.awt.Color(255, 0, 51));
		jlbmost1.setText("*");
		add(jlbmost1);
		jlbmost1.setBounds(620, 320, 50, 30);

		jlbmost2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jlbmost2.setForeground(new java.awt.Color(255, 0, 51));
		jlbmost2.setText("*");
		add(jlbmost2);
		jlbmost2.setBounds(340, 160, 50, 30);

		jlbmost3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jlbmost3.setForeground(new java.awt.Color(255, 0, 51));
		jlbmost3.setText("*");
		add(jlbmost3);
		jlbmost3.setBounds(400, 200, 50, 30);

		jlbmost4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jlbmost4.setForeground(new java.awt.Color(255, 0, 51));
		jlbmost4.setText("*");
		add(jlbmost4);
		jlbmost4.setBounds(470, 240, 50, 30);

		jlbmost5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jlbmost5.setForeground(new java.awt.Color(255, 0, 51));
		jlbmost5.setText("*");
		add(jlbmost5);
		jlbmost5.setBounds(540, 280, 50, 30);

		jLabel2.setText("\u5e26\u2018*\u2019\u53f7\u7684\u4e3a\u5fc5\u586b");
		add(jLabel2);
		jLabel2.setBounds(610, 390, 150, 40);
	}

	private void jbtnreturnActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.setContentPane(new ListPanel(mainFrame));
		mainFrame.validate();
	}

	@SuppressWarnings("unused")
	private void jbtnsureActionPerformed(java.awt.event.ActionEvent evt) {

		// 表现层代码的基本写法

		// 1.收集参数
		String name = jtfName.getText();
		String xingbie = jtfxingbie.getText();
		String age = jtfAge.getText();
		String dianhua = jtfDianhua.getText();
		String address = jtfAddress.getText();
		boolean isNum = true;
		// 数据简单校验----示范，可以做得更好
		try {
			Integer.parseInt(age);
			Long.parseLong(dianhua);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "温馨提示：\n电话或年龄的输入格式不对,请重新输入！");
			isNum = false;
			// System.out.println("年龄或电话输入格式不对,请重新输入！");
		}

		//信息不能为空
		if (name.equals("") || xingbie.equals("") || age.equals("")
				|| dianhua.equals("") || address.equals("")) {
			JOptionPane.showMessageDialog(this, "温馨提示：\n信息不能为空，请重新输入！");
			isNum = false;
		}

		//地址和姓名中不能包含英文的逗号
		String s = "" + ',';
		if (address.contains(s) || name.contains(s) || xingbie.contains(s)) {
			JOptionPane
					.showMessageDialog(this, "温馨提示：\n地址或姓名中不能包含“，”逗号，请重新输入！");
			isNum = false;
		}

		if (isNum) {
			// 2.组织参数-这里是简单演示，直接用str封装。以后如果遇到复杂的数据，应该用值对象。
			String str = name + "," + xingbie + "," + age + "," + dianhua + ","
					+ address;

			// 3.调用逻辑层
			AddrBusiness set = new AddrBusiness();
			boolean flag = set.add(str);

			// 4.根据逻辑层的返回结果，导向不同的结果界面
			if (flag) {
				mainFrame.setContentPane(new ListPanel(mainFrame));
				mainFrame.validate();
			} else {
				JOptionPane.showMessageDialog(this,
						"温馨提示：\tt\n本次添加失败!\t\n请自行检查错误！");
			}
		}

	}

	
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JButton jbtnreturn;
	private javax.swing.JButton jbtnsure;
	private javax.swing.JLabel jlbAddress;
	private javax.swing.JLabel jlbAge;
	private javax.swing.JLabel jlbDianhau;
	private javax.swing.JLabel jlbName1;
	private javax.swing.JLabel jlbmost1;
	private javax.swing.JLabel jlbmost2;
	private javax.swing.JLabel jlbmost3;
	private javax.swing.JLabel jlbmost4;
	private javax.swing.JLabel jlbmost5;
	private javax.swing.JLabel jlbxingbie;
	private javax.swing.JTextField jtfAddress;
	private javax.swing.JTextField jtfAge;
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
