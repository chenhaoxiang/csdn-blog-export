---
layout: post
title: "【框架】[MyBatis]DAO层只写接口，不用写实现类"
date: 2016-10-11 09:01:18 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具
tags: [框架,mybatis]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
团队开发一个项目，由老大架了一个框架，遇到了DAO层不用写接口了，我也是用了2次才记住这个事的，因为自己一直都是习惯于写DAO层的实现类，所以，习惯性的还是写了个实现类。于是遇到错误了。找不到那个方法。问了团队的人才知道，方法名和Mapper中配置的id名必须一样。实现:一、配置Spr 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
团队开发一个项目，由老大架了一个框架，遇到了DAO层不用写接口了，我也是用了2次才记住这个事的，因为自己一直都是习惯于写DAO层的实现类，所以，习惯性的还是写了个实现类。于是遇到错误了。找不到那个方法。问了团队的人才知道，方法名和Mapper中配置的id名必须一样。实现:一、配置Spr
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

团队开发一个项目，由老大架了一个框架，遇到了DAO层不用写接口了，我也是用了2次才记住这个事的，因为自己一直都是习惯于写DAO层的实现类，所以，习惯性的还是写了个实现类。于是遇到错误了。

找不到那个方法。问了团队的人才知道，方法名和Mapper中配置的id名必须一样。

#实现:

##一、配置Spring集成MyBatis:

```
<beans xmlns="http://www.springframework.org/schema/beans"
	   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	   xmlns:p="http://www.springframework.org/schema/p"...

-------------------------------------------------

<!-- 配置数据源 -->
	<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
	...
-------------------------------------------------

<!-- 产生sqlsessionfactory -->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource" />
    <property name="configLocation" value="classpath:mybatis-config.xml" /> 
</bean>  

--------------------------------------------------
```

要实现对数据库的操作必须要有sqlSession,而sqlSession是由sqlSessionFactory创建的。我们可以在Spring配置好bean。

```
<!-- 自动扫描mapper接口-->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer"
			p:basePackage="com.xiaojuzi.chaojijuhui.**.dao"
			p:sqlSessionFactoryBeanName="sqlSessionFactory" />
```
这个配置就是配置映射文件的路径，这样做的好处就是不用再写Dao的实现类了，也就是说，我们写好接口，写好配置文件，会自动映射到对应的方法和sql语句。

##二、开发mapper.xml映射文件

```
<mapper namespace="com.xiaojuzi.chaojijuhui.user.dao.UserDao">

-------------------------------------------------------
```

![](http://img.blog.csdn.net/20160924093941233)

在这里只有一个UserDao(被代理的接口)。
user.mapper.xml--namespace配置的就是UserDao的包全名。

##三、开发mapper.java的接口

```
     /**
     * 根据用户的用户名查询用户
     * @param user
     * @return
     */
    User queryUserByLoginName (String loginName);

    /**
     * 用户通过手机号码去修改密码
     * @param userModel
     * @return
     */
	Boolean updatePasswordByMobile(UserModel userModel);

```

如果需要特定类型的参数，就自己再造一个POJO类(例如:UserModel)。

```
 <sql id="userColumns">
        u.id,
        u.login_name as "loginName",
        u.head_img as "headImg",
        ...
---------------------------------------------

<select id="queryUserByLoginName" resultType="User" parameterType="User">
        SELECT <include refid="userColumns" />
        FROM juhui_user u
        WHERE u.login_name = #{loginName}
        and u.del_flag = #{DEL_FLAG_NORMAL}
    </select>

<update id="updatePasswordByMobile" parameterType="UserModel">
        update juhui_user set
            update_date=DATE_FORMAT(#{updateDate}, '%Y-%m-%d %H:%i:%S'),
            salt = #{salt},
            password = #{password}
        where mobile = #{mobile}
    </update>
```

这里mapper.xml的(select、insert、update..)标签的id必须和DAO接口的方法名一样！

##Mapper开发规则
1、 在mapper.xml中将namespace设置为mapper.java的全限定名
2、 将mapper.java接口的方法名和mapper.xml中statement的id保持一致。
3、 将mapper.java接口的方法输入参数类型和mapper.xml中statement的parameterType保持一致
4、 将mapper.java接口的方法输出 结果类型和mapper.xml中statement的resultType保持一致

注意遵循上边四点规范！

这样抛弃Dao实现类的写法：
具有更好的可扩展性，提高了灵活度。

#原理
再根据网上的一些知识点，讲一下原理:

mybatis通过JDK的动态代理方式，在启动加载配置文件时，根据配置mapper的xml去生成Dao的实现。

session.getMapper()使用了代理，当调用一次此方法，都会产生一个代理class的instance,看看这个代理class的实现. 

```
public class MapperProxy implements InvocationHandler { 
... 
public static <T> T newMapperProxy(Class<T> mapperInterface, SqlSession sqlSession) { 
    ClassLoader classLoader = mapperInterface.getClassLoader(); 
    Class<?>[] interfaces = new Class[]{mapperInterface}; 
    MapperProxy proxy = new MapperProxy(sqlSession); 
    return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy); 
  } 

public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { 
    if (!OBJECT_METHODS.contains(method.getName())) { 
      final Class<?> declaringInterface = findDeclaringInterface(proxy, method); 
      final MapperMethod mapperMethod = new MapperMethod(declaringInterface, method, sqlSession); 
      final Object result = mapperMethod.execute(args); 
      if (result == null && method.getReturnType().isPrimitive()) { 
        throw new BindingException("Mapper method '" + method.getName() + "' (" + method.getDeclaringClass() + ") attempted to return null from a method with a primitive return type (" +    method.getReturnType() + ")."); 
      } 
      return result; 
    } 
    return null; 
  } 
```
这里是用到了JDK的代理Proxy。 newMapperProxy()可以取得实现interfaces 的class的代理类的实例。

当执行interfaces中的方法的时候，会自动执行invoke()方法，其中public Object invoke(Object proxy, Method method, Object[] args)中 method参数就代表你要执行的方法.

MapperMethod类会使用method方法的methodName 和declaringInterface去取 sqlMapxml 取得对应的sql，也就是拿declaringInterface的类全名加上 sql-id.. 

总结:
这个就是利用JDK的代理类实现的。



本文章由<a href="https://chenhaoxiang.github.io/">[谙忆]</a>编写， 所有权利保留。 
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
