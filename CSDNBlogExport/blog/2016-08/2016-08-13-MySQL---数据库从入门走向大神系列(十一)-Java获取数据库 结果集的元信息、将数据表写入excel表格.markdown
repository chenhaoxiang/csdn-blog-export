---
layout: post
title: "MySQL---数据库从入门走向大神系列(十一)-Java获取数据库 结果集的元信息、将数据表写入excel表格"
date: 2016-08-13 02:45:02 +0800
comments: true
categories:❷ Java大学之行,----- ⑤、数据库
tags: [数据库,数据,excel,元数据]
keyword: 陈浩翔, 谙忆
description: 数据库的元信息：首先介绍一下数据库的元信息(元数据)：元数据(Metadata)是关于数据的数据。元数据是描述数据仓库内数据的结构和建立方法的数据。存储的数据是什么类型,什么驱动等等，这些描述数据的数据，就是元数据！准备：package cn.hncu.pool3;import java.lang.reflect.InvocationHandler;
import java.lang.reflect 
---


数据库的元信息：首先介绍一下数据库的元信息(元数据)：元数据(Metadata)是关于数据的数据。元数据是描述数据仓库内数据的结构和建立方法的数据。存储的数据是什么类型,什么驱动等等，这些描述数据的数据，就是元数据！准备：package cn.hncu.pool3;import java.lang.reflect.InvocationHandler;
import java.lang.reflect
<!-- more -->
----------

#数据库的元信息：

首先介绍一下数据库的元信息(元数据)：

元数据(Metadata)是关于数据的数据。

元数据是描述数据仓库内数据的结构和建立方法的数据。

存储的数据是什么类型,什么驱动等等，这些描述数据的数据，就是元数据！


##准备：

```
package cn.hncu.pool3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnsUtil {
	private static List<Connection> pool = new ArrayList<Connection>();
	private static final int NUM=3;
    static{
    	try {
			//读取配置文件
			Properties p = new Properties();
			p.load(ConnsUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("username");
			String password = p.getProperty("password");
			Class.forName(driver);
			
			for(int i=0;i<NUM;i++){
				final Connection conn = DriverManager.getConnection(url, user, password);
				
				//只需要改这里就行了！
				//使用动态代理代理conn对象，实现对close方法的拦截
				Object obj = Proxy.newProxyInstance(
						ConnsUtil.class.getClassLoader(),
						conn.getClass().getInterfaces(),
						new InvocationHandler() {
							
							@Override
							public Object invoke(Object proxy, Method method, Object[] args)
									throws Throwable {
								if(method.getName().equalsIgnoreCase("close") && (args==null || args.length==0)){
									pool.add((Connection)proxy);
									return null;
								}else{
									return method.invoke(conn, args);
								}
							}
						});
				pool.add((Connection)obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static synchronized Connection getConn() throws Exception{
    	if(pool.size()<=0){
    		Thread.sleep(100);
    		return getConn();
    	}
    	return pool.remove(0);
    }
    
}

```


使用java.sql 中的接口 DatabaseMetaData就可以实现：

##演示类：

```
package cn.hncu.meta;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.junit.Test;

import cn.hncu.pool3.ConnsUtil;

public class MetaDataDemo {
	// ※元信息1：通过con获得DatabaseMetaData(数据库元信息)---数据库连接信息、数据库名、表名
	@Test
	public void databaseMetadataDemo() throws Exception {
		// 获取数据库的元信息
		Connection con = ConnsUtil.getConn();
		// ********关键
		DatabaseMetaData dm = con.getMetaData();

		// 获取此 JDBC 驱动程序的名称。
		System.out.println(dm.getDriverName());
		// 获取此 JDBC 驱动程序的主版本号。
		System.out.println(dm.getDriverMajorVersion());
		// 获取在此数据库中在同一时间内可处于开放状态的最大活动语句数。--返回结果为零意味着没有限制或限制是未知的
		System.out.println(dm.getMaxStatements());
		// 获取此驱动程序的主 JDBC 版本号。
		System.out.println(dm.getJDBCMajorVersion());
		// 还有很多方法，可以去API自己查
		System.out.println("=========================");

		// 下面是动态获取数据库名

		ResultSet rs = dm.getCatalogs();
		// 相当于执行:show databases;

		while (rs.next()) {
			System.out.println(rs.getString(1));
			// 进行元数据操作获得数据库名
		}

		// 知道数据库的名字
		con.createStatement().execute("use hncu");
		// 动态获取表名

		// 可以把参数null写成“%o%”进行模糊查询
		ResultSet rs2 = dm.getTables("hncu", "hncu", null,
				new String[] { "TABLE" });
	
		while (rs2.next()) {
			System.out.println(rs2.getString("TABLE_NAME"));
			// 进行元数据操作，获得表名
		}
	}

	// ※元信息2：通过rs获得ResultSetMetaData(结果集元信息)---表头(每个字段名)、表格行数、列数
	// 在知道数据库名和表名的情况下，把表头和表内容都查询出来。
	@Test
	// 站在结果集的高度---也就是表格
	public void resultSetMetaDataDemo() throws Exception{
		Connection con1 = ConnsUtil.getConn();
		Statement st = con1.createStatement();
		//如果是跨库查询,sql:“数据库名.表名”----select * from 数据库.表名
		String sql = "select * from stud";//我们的连接是hncu数据库的，访问hncu数据库直接写表名就可以
		ResultSet rs = st.executeQuery(sql);
		
		//结果集的元信息
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		//获得表格的列数
		
		//输出整个数据表(包括表头)
		//表头
		for(int i=0;i<columns;i++){
			String columnName = rsmd.getColumnName(i+1);
			System.out.print(columnName+"\t");
		}
		System.out.println();
		System.out.println("------------------------");
		//表内容
		while(rs.next()){
			for(int i=0;i<columns;i++){
				String content = rs.getString(i+1);
				System.out.print(content+"\t");
			}
			System.out.println();
		}
	}

}

```

```
getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types)方法的参数解析：

catalog -类别名称：
它必须与存储在数据库中的类别名称匹配；该参数为 "" 表示获取没有类别的那些描述；为 null则表示该类别名称不应该用于缩小搜索范围 

schemaPattern - 模式名称的模式：
它必须与存储在数据库中的模式名称匹配；该参数为"" 表示获取没有模式的那些描述；为 null 则表示该模式名称不应该用于缩小搜索范围

tableNamePattern -表名称模式：
它必须与存储在数据库中的表名称匹配 

types - 要包括的表类型所组成的列表，必须取自从 getTableTypes()返回的表类型列表；null 表示返回所有类型

```

这样就遍历出来了。
![](http://img.blog.csdn.net/20160812162314331)



#将数据表写入excel表格


首先需要准备一个apache的Jar：

![](http://img.blog.csdn.net/20160812163609992)
链接：
https://github.com/chenhaoxiang/Java

##先创建一个简单的数据：

```
package cn.hncu.meta;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class ExportXls {
	
	@Test
	public void mkXlsDemo() throws IOException{
		//需求: 创建一个工作薄:a.xls, 工作表: 表1,  第4行第5列的单元格中写入文字:湖南城院
		HSSFWorkbook book = new HSSFWorkbook();
		HSSFSheet sheet = book.createSheet("表一");
		
		HSSFRow row4 = sheet.createRow(3);//行数为下标加1
		//该方法的参数值是从0开始的---真正的表格中的序号是从1开始标示
		
		HSSFCell cell5 = row4.createCell(4);
		
		FileOutputStream fout = new FileOutputStream("a.xls");
		book.write(fout);
	}
}

```
![](http://img.blog.csdn.net/20160812171906282)



##将数据库的所有表格数据遍历写入至excel表格

```
@Test
	public void exportTest() throws Exception{
		//这里我们只遍历存储hncu数据库
		String dbName="hncu";
		String xlsFileName="b.xls";
		exportDb2Xls(dbName,xlsFileName);
	}
	
	public void exportDb2Xls(String dbName,String xlsFileName) throws Exception{
		HSSFWorkbook book = new HSSFWorkbook();
		Connection con = ConnsUtil.getConn();
		DatabaseMetaData dm = con.getMetaData();
		
		//写代码时，尽量避免结果集套接操作，在一个结果集操作的内部进行其它结果集操作
		//如果有事务，一个结果集的回退或提交可能会波及另一个
		ResultSet rs = dm.getTables(dbName, dbName, null, new String[]{"TABLE"});
		
		List<String> tables = new ArrayList<String>();
		while(rs.next()){
			String tableName = rs.getString("TABLE_NAME");
			tables.add(tableName);
		}
		
		Statement st = con.createStatement();
		for(String tableName: tables){
			//创建一个表名为tableName的表
			HSSFSheet sheet = book.createSheet(tableName);
			//这样写，可以跨数据库访问
			String sql ="select * from "+dbName+"."+tableName;
			rs = st.executeQuery(sql);
			
			//把表头遍历出来且写到xls文件中
			HSSFRow row = sheet.createRow(0);//表头行
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int colNum = rsmd.getColumnCount();
			for(int i=0;i<colNum;i++){
				HSSFCell cell = row.createCell(i);
				String colName = rsmd.getColumnName(i+1);
				cell.setCellValue(colName);
			}
			
			//所有数据行
			int idx = 1;
			while(rs.next()){
				row = sheet.createRow(idx++);
				for(int i=0;i<colNum;i++){
					HSSFCell cell = row.createCell(i);
					cell.setCellValue( rs.getString(i+1) );
				}
			}
		}
		
		FileOutputStream fout = new FileOutputStream(xlsFileName);
		
		book.write(fout);
	}
```


![](http://img.blog.csdn.net/20160813144406169)


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
