---
layout: post
title: "【问题解决】MyBatis分页查询SQL Server2008时出现'@P0' 附近有语法错误"
date: 2017-08-24 10:40:09 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- 上网技巧/问题解决
tags: [sql server,mybatis]
keyword: 陈浩翔, 谙忆
description: MyBatis分页查询SQL Server2008时出现’@P0’ 附近有语法错误” 
Error querying database.  Cause: com.microsoft.sqlserver.jdbc.SQLServerException: ‘@P0’ 附近有语法错误。错误如下:org.springframework.jdbc.UncategorizedSQLException: 
### 
---


MyBatis分页查询SQL Server2008时出现’@P0’ 附近有语法错误” 
Error querying database.  Cause: com.microsoft.sqlserver.jdbc.SQLServerException: ‘@P0’ 附近有语法错误。错误如下:org.springframework.jdbc.UncategorizedSQLException: 
###
<!-- more -->
----------

---
layout: post
title: "【问题解决】MyBatis分页查询SQL Server2008时出现'@P0' 附近有语法错误"
date: 2017-07-04 13:38:54 +0800
comments: true
categories: Java
tags: [Java, basis]
keyword: 陈浩翔, 谙忆, MyBatis, SQL Server2008
description: MyBatis分页查询SQL Server2008时出现'@P0' 附近有语法错误"
---

MyBatis分页查询SQL Server2008时出现'@P0' 附近有语法错误"  
Error querying database.  Cause: com.microsoft.sqlserver.jdbc.SQLServerException: '@P0' 附近有语法错误。

<!-- more -->
----------

错误如下:
```
org.springframework.jdbc.UncategorizedSQLException: 
### Error querying database.  Cause: com.microsoft.sqlserver.jdbc.SQLServerException: '@P0' 附近有语法错误。
### The error may exist in file [E:\Client\KaiXinHuYu\target\classes\cn\kx59\user\mapping\AccountsInfoMapper.xml]
### The error may involve cn.kx59.user.dao.AccountsInfoMapper.selectPageData-Inline
### The error occurred while setting parameters
### SQL: select top ?       UserID, GameID, ProtectID, PasswordID, SpreaderID, Accounts, NickName, RegAccounts,      UnderWrite, PassPortID, Compellation, LogonPass, InsurePass, FaceID, CustomID, Present,      UserMedal, Experience, LoveLiness, UserRight, MasterRight, ServiceRight, MasterOrder,      MemberOrder, MemberOverDate, MemberSwitchDate, CustomFaceVer, Gender, Nullity, NullityOverDate,      StunDown, MoorMachine, IsAndroid, WebLogonTimes, GameLogonTimes, PlayTimeCount, OnLineTimeCount,      LastLogonIP, LastLogonDate, LastLogonMobile, LastLogonMachine, RegisterIP, RegisterDate,      RegisterMobile, RegisterMachine     from AccountsInfo where UserID not in(select top ? UserID from AccountsInfo)
### Cause: com.microsoft.sqlserver.jdbc.SQLServerException: '@P0' 附近有语法错误。
; uncategorized SQLException for SQL []; SQL state [S0001]; error code [102]; '@P0' 附近有语法错误。; nested exception is com.microsoft.sqlserver.jdbc.SQLServerException: '@P0' 附近有语法错误。

	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:84)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:371)
	at $Proxy24.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:198)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:122)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:64)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:53)
	at $Proxy25.selectPageData(Unknown Source)
	at cn.kx59.user.service.imp.AccountsInfoServiceImp.selectPageData(AccountsInfoServiceImp.java:33)
	at cn.kx59.user.service.imp.AccountsInfoServiceImp$$FastClassBySpringCGLIB$$f0736e8f.invoke(<generated>)
	at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:204)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:718)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor.invoke(MethodBeforeAdviceInterceptor.java:52)
...
```

出错代码的MyBatis中查询语句为：
```
  <!--分页查询-->
  <select id="selectPageData" resultMap="BaseResultMap" parameterType="java.lang.Integer">
    select top #{pageSize} <include refid="Base_Column_List" /> from AccountsInfo where UserID not in(select top #{startN} UserID from AccountsInfo)
  </select>
```

其实这是因为top后面不能跟占位符'？'号的原因，可以看调试的sql语句，mybatis为了防止注入，会先使用?号占位符。  

错误解释如下：  
在Java中对数据库查询时经常使用“Select Top ？ * From 表名 Where 列名 = ？”的SQL语句，此时的问号是PreparedStatement预编译对象的参数占位符，需要使用setXX()系列方法对其赋值后再执行。但是，Top后面是不允许使用问号占位符的，此处的错误就是由此引起的。

解决方法:  
使用```$```代替#，使用#传入参数是，sql语句解析是会加上"",当成字符串来解析，会加入占位符?，再使用setXX()方法后赋值再执行，#{}传参能防止sql注入。  
而```${}```这种方式 是直接传值！在这里无法使用占位符的情况下，可以使用```$```，但是自己写好防范哦，以免被注入了  


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
