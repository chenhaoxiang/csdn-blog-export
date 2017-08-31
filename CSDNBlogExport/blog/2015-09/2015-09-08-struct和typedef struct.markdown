---
layout: post
title: "struct和typedef struct"
date: 2015-09-08 08:07:46 +0800
comments: true
categories:❸ C/C++语言基础,----- 数据结构
tags: [c语言,typedef,struct]
keyword: 陈浩翔, 谙忆
description: “`typedef声明，简称typedef，为现有类型创建一个新的名字，或称为类型别名，在结构体定义，还有一些数组等地方都大量的用到。 
比如： 
typedef int DataType; 
给整型int起了一个新名字DataType，以后用DataType就如同int一样。 
分三块来讲述： 
　　1 首先：//注意在C和C++里不同 
　　　　在C中定义一个结构体类型要用typedef: 
---


“`typedef声明，简称typedef，为现有类型创建一个新的名字，或称为类型别名，在结构体定义，还有一些数组等地方都大量的用到。 
比如： 
typedef int DataType; 
给整型int起了一个新名字DataType，以后用DataType就如同int一样。 
分三块来讲述： 
　　1 首先：//注意在C和C++里不同 
　　　　在C中定义一个结构体类型要用typedef:
<!-- more -->
----------

```

typedef声明，简称typedef，为现有类型创建一个新的名字，或称为类型别名，在结构体定义，还有一些数组等地方都大量的用到。
比如：
typedef int DataType;
给整型int起了一个新名字DataType，以后用DataType就如同int一样。
分三块来讲述：
　　1 首先：//注意在C和C++里不同
　　　　在C中定义一个结构体类型要用typedef:
　　　　typedef struct Student
　　　　{
　　　　int a;
　　　　}Stu;
　　　　于是在声明变量的时候就可：Stu stu1;(如果没有typedef就必须用struct Student stu1;来声明)
　　　　这里的Stu实际上就是struct Student的别名。Stu==struct Student
　　　　另外这里也可以不写Student（于是也不能struct Student stu1;了，必须是Stu stu1;）
　　　　typedef struct
　　　　{
　　　　int a;
　　　　}Stu;
　　　　但在c++里很简单，直接
　　　　struct Student
　　　　{
　　　　int a;
　　　　};　　　　
　　　　于是就定义了结构体类型Student，声明变量时直接Student stu2；


　　2.其次：
　　　　在c++中如果用typedef的话，又会造成区别：
　　　　struct   Student   
　　　　{   
　　　　int   a;   
　　　　}stu1;//stu1是一个变量  

 
　　　　typedef   struct   Student2   
　　　　{   
　　　　int   a;   
　　　　}stu2;//stu2是一个结构体类型=struct Student  

 
　　　　使用时可以直接访问stu1.a
　　　　但是stu2则必须先   stu2 s2;
　　　　然后               s2.a=10;

　　3 掌握上面两条就可以了，不过最后我们探讨个没多大关系的问题
　　　　如果在c程序中我们写：
　　　　typedef struct  
　　　　{
　　　　int num;
　　　　int age;
　　　　}aaa,bbb,ccc;
　　　　这算什么呢？
　　　　我个人观察编译器（VC6）的理解，这相当于
　　　　typedef struct  
　　　　{
　　　　int num;
　　　　int age;
　　　　}aaa；
　　　　typedef aaa bbb;
　　　　typedef aaa ccc;
　　　　也就是说aaa,bbb,ccc三者都是结构体类型。声明变量时用任何一个都可以,在c++中也是如此。但是你要注意的是这个在c++中如果写掉了typedef关键字，那么aaa，bbb，ccc将是截然不同的三个对象。

　　　　//此处不是很理解。

　

　　　　typedef struct和struct的区别：

 

 

　　　　typedef struct tagMyStruct
　　　　{ 
　　　　　int iNum;
　　　　　long lLength;
　　　　} MyStruct;

　　　　上面的tagMyStruct是标识符，MyStruct是变量类型（相当于（int,char等））。

 

 

　　　　这语句实际上完成两个操作：

　　　　　　1) 定义一个新的结构类型

　　　　struct tagMyStruct
　　　　{　　 
　　　　　int iNum; 
　　　　　long lLength; 
　　　　};

　　分析：tagMyStruct称为“tag”，即“标签”，实际上是一个临时名字，
　　不论是否有typedefstruct 关键字和tagMyStruct一起，构成了这个结构类型，这个结构都存在。

　　我们可以用struct tagMyStruct varName来定义变量，但要注意，
　　使用tagMyStruct varName来定义变量是不对的，因为struct 和tagMyStruct合在一起才能表示一个结构类型。

　　2) typedef为这个新的结构起了一个名字，叫MyStruct。

　　　　typedef struct tagMyStruct MyStruct;

　　因此，MyStruct实际上相当于struct tagMyStruct，我们可以使用MyStruct varName来定义变量。

　　2.

　　　　typedef struct tagMyStruct
　　　　{ 
　　　　　int iNum;
　　　　　long lLength;
　　　　} MyStruct;

　　　　在C中，这个申明后申请结构变量的方法有两种：

　　　　（1）struct tagMyStruct 变量名

　　　　（2）MyStruct 变量名

　　　　在c++中可以有

　　　　（1）struct tagMyStruct 变量名

　　　　（2）MyStruct 变量名

　　　　（3）tagMyStruct 变量名

另外，加个指针：
typedef struct Student
　　　　{
　　　　 int a;
　　　　}Stu, *pStu;
pStu是Stu类型的指针。
就像int*一样。
可以在后面定义：
Stu student；
pStu p；
p=&student；

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
