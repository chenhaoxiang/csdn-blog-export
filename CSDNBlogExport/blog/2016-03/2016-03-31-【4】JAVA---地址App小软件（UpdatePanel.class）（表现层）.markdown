---
layout: post
title: "【4】JAVA---地址App小软件（UpdatePanel.class）（表现层）"
date: 2016-03-31 12:13:21 +0800
comments: true
categories:❷ Java大学之行,----- ②、Java设计模块,----- ----- Java地址App
tags: []
keyword: 陈浩翔, 谙忆
description: 修改地址信息的一个表现层类。 
必须选中地址，才能修改，否则会弹出窗口提示， 
修改地址界面： 
/*
 * UpdatePanel.java
 *
 */package cn.hncu.addr.ui;import javax.swing.JFrame;
import javax.swing.JOptionPane;import cn.hncu.addr.business.AddrBusiness 
---


修改地址信息的一个表现层类。 
必须选中地址，才能修改，否则会弹出窗口提示， 
修改地址界面： 
/*
 * UpdatePanel.java
 *
 */package cn.hncu.addr.ui;import javax.swing.JFrame;
import javax.swing.JOptionPane;import cn.hncu.addr.business.AddrBusiness
<!-- more -->
----------

修改地址信息的一个表现层类。
必须选中地址，才能修改，否则会弹出窗口提示，
![](http://img.blog.csdn.net/20160331001237953)


修改地址界面：
![](http://img.blog.csdn.net/20160331001259859)


```
/*
 * UpdatePanel.java
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
public class UpdatePanel extends javax.swing.JPanel {
	private JFrame mainFrame = null;
	private String oldStrAdd = null;


	public UpdatePanel(JFrame mainFrame, String oldStrAdd) {
		this.mainFrame = mainFrame;
		this.oldStrAdd = oldStrAdd;
		//System.out.println(oldStrAdd);
		initComponents();

		myInitCompoData();
	}

	private void myInitCompoData() {
		String[] oldstrs = oldStrAdd.split(",");
		String oldname = oldstrs[0];
		String oldxingbie = oldstrs[1];
		String oldage = oldstrs[2];
		String olddianhua = oldstrs[3];
		String oldaddress = oldstrs[4];

		jtfName.setText(oldname);
		jtfxingbie.setText(oldxingbie);
		jtfAge.setText(oldage);
		jtfDianhua.setText(olddianhua);
		jtfAddress.setText(oldaddress);
	}


	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
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

		setMinimumSize(new java.awt.Dimension(800, 600));
		setPreferredSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
		jPanel1.setLayout(null);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 48));
		jLabel2.setForeground(new java.awt.Color(255, 51, 0));
		jLabel2.setText("\u4fee\u6539\u5730\u5740\u4fe1\u606f");
		jPanel1.add(jLabel2);
		jLabel2.setBounds(230, 20, 330, 90);

		jlbAddress.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbAddress.setText("\u5730\u5740\uff1a");
		jPanel1.add(jlbAddress);
		jlbAddress.setBounds(140, 310, 60, 40);

		jlbName1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbName1.setText("\u59d3\u540d\uff1a");
		jPanel1.add(jlbName1);
		jlbName1.setBounds(140, 150, 60, 40);

		jlbxingbie.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbxingbie.setText("\u6027\u522b\uff1a");
		jPanel1.add(jlbxingbie);
		jlbxingbie.setBounds(140, 190, 60, 40);

		jlbAge.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbAge.setText("\u5e74\u9f84\uff1a");
		jPanel1.add(jlbAge);
		jlbAge.setBounds(140, 230, 60, 40);

		jlbDianhau.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jlbDianhau.setText("\u7535\u8bdd\uff1a");
		jPanel1.add(jlbDianhau);
		jlbDianhau.setBounds(140, 270, 60, 40);
		jPanel1.add(jtfAddress);
		jtfAddress.setBounds(200, 320, 410, 23);
		jPanel1.add(jtfName);
		jtfName.setBounds(200, 160, 130, 23);
		jPanel1.add(jtfxingbie);
		jtfxingbie.setBounds(200, 200, 190, 23);
		jPanel1.add(jtfAge);
		jtfAge.setBounds(200, 240, 260, 23);
		jPanel1.add(jtfDianhua);
		jtfDianhua.setBounds(200, 280, 330, 23);

		jbtnreturn.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jbtnreturn.setForeground(new java.awt.Color(0, 204, 204));
		jbtnreturn.setText("\u53d6\u6d88");
		jbtnreturn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnreturnActionPerformed(evt);
			}
		});
		jPanel1.add(jbtnreturn);
		jbtnreturn.setBounds(490, 430, 110, 70);

		jbtnsure.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jbtnsure.setForeground(new java.awt.Color(255, 0, 51));
		jbtnsure.setText("\u4fee\u6539");
		jbtnsure.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtnsureActionPerformed(evt);
			}
		});
		jPanel1.add(jbtnsure);
		jbtnsure.setBounds(140, 430, 110, 70);

		add(jPanel1);
		jPanel1.setBounds(0, 0, 810, 600);
	}

	//修改地址信息
	private void jbtnsureActionPerformed(java.awt.event.ActionEvent evt) {
		// 表现层代码的基本写法

		String newname = jtfName.getText();
		String newxingbie = jtfxingbie.getText();
		String newage = jtfAge.getText();
		String newdianhua = jtfDianhua.getText();
		String newaddress = jtfAddress.getText();

		//测试数据是否对上
		//		System.out.println("name="+name);
		//		System.out.println("xingbie="+xingbie);
		//		System.out.println("age="+age);
		//		System.out.println("dianhua="+dianhua);
		//		System.out.println("address="+address);

		boolean isNum = true;
		// 数据简单校验----示范，可以做得更好
		try {
			Integer.parseInt(newage);
			Long.parseLong(newdianhua);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "温馨提示：\n电话或年龄的输入格式不对,请重新输入！");
			isNum = false;
			// System.out.println("年龄或电话输入格式不对,请重新输入！");
		}

		//地址和姓名中不能包含英文的逗号
		String s = "" + ',';
		if (newaddress.contains(s) || newname.contains(s)
				|| newxingbie.contains(s)) {
			JOptionPane
					.showMessageDialog(this, "温馨提示：\n地址或姓名中不能包含“，”逗号，请重新输入！");
			isNum = false;
		}

		if (isNum) {
			// 2.组织参数-这里是简单演示，直接用str封装。以后如果遇到复杂的数据，应该用值对象。
			String newStrAdd = newname + "," + newxingbie + "," + newage + ","
					+ newdianhua + "," + newaddress;

			// 3.调用逻辑层
			AddrBusiness set = new AddrBusiness();
			boolean flag = set.update(oldStrAdd, newStrAdd);

			// 4.根据逻辑层的返回结果，导向不同的结果界面
			if (flag) {
				mainFrame.setContentPane(new ListPanel(mainFrame));
				mainFrame.validate();
			} else {
				JOptionPane.showMessageDialog(this, "温馨提示：\n本次修改失败!\n请自行检查错误！");
			}
		}
	}

	private void jbtnreturnActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.setContentPane(new ListPanel(mainFrame));
		mainFrame.validate();
	}

	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JButton jbtnreturn;
	private javax.swing.JButton jbtnsure;
	private javax.swing.JLabel jlbAddress;
	private javax.swing.JLabel jlbAge;
	private javax.swing.JLabel jlbDianhau;
	private javax.swing.JLabel jlbName1;
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
