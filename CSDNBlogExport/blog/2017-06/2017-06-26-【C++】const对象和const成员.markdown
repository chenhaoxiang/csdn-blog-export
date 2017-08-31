---
layout: post
title: "【C++】const对象和const成员"
date: 2017-06-26 08:51:42 +0800
comments: true
categories:❸ C/C++语言基础,cocos2d-x
tags: [函数,c语言,数据]
keyword: 陈浩翔, 谙忆
description: 如果我们在定义一个对象之后，不希望在后面对这个对象进行修改，那么我们可以把这个对象声明为const对象。 
声明为const对象之后，这个对象的所有数据成员后面都不能被修改！  const对象定义类对象时可以将其指定为const对象。定义后const对象不能再被修改。 
const对象不能调用非const类型的成员函数。 
有两种方法来定义一个const对象： 
const 类名 对象名 
类名 c 
---


如果我们在定义一个对象之后，不希望在后面对这个对象进行修改，那么我们可以把这个对象声明为const对象。 
声明为const对象之后，这个对象的所有数据成员后面都不能被修改！  const对象定义类对象时可以将其指定为const对象。定义后const对象不能再被修改。 
const对象不能调用非const类型的成员函数。 
有两种方法来定义一个const对象： 
const 类名 对象名 
类名 c
<!-- more -->
----------

---
layout: post
title: "【C++】const对象和const成员"
date: 2017-06-03 21:38:54 +0800
comments: true
categories: C++
tags: [C++, basis]
keyword: 陈浩翔, 谙忆, C++, const对象和const成员
description: 定义类对象时可以将其指定为const对象。定义后const对象不能再被修改。const对象不能调用非const类型的成员函数。
---

如果我们在定义一个对象之后，不希望在后面对这个对象进行修改，那么我们可以把这个对象声明为const对象。  
声明为const对象之后，这个对象的所有数据成员后面都不能被修改！  
<!-- more -->
----------

#const对象 

定义类对象时可以将其指定为const对象。定义后const对象不能再被修改。  
const对象不能调用非const类型的成员函数。  
有两种方法来定义一个const对象：
const 类名 对象名  
类名 const 对象名  
这两种方法是等价的。  

如果一个对象被定义成const对象，那么它就不能调用这个类中的非const成员函数。  
const对象调用的成员函数一定都得是const！  

```c++ 定义const对象
//const
const CTime time4(10);
CTime const time5;
```
如果你用const对象引用了这个类中的非const成员函数，就会报错:
```
错误	1	error C2662: “int CTime::getHour(void)”: 不能将“this”指针从“const CTime”转换为“CTime &”
e:\chenhaoxiang\20170603\test2\test2\mian.cpp	34	1	test2
```
其实就是告诉我们const对象不能引用非const成员函数  
为什么要有这个规则:  
因为在非const成员函数内部可能对对象进行修改，比如set函数  
这个规则也就是强制用户不要对const成员进行错误的修改    

#const成员

##1.const数据成员
也就是变量，比如实例中的m_hour，m_minute是普通数据成员  

在类内部使用const关键字来声明const数据成员。const数据成员的值不能被修改。  
初始化时比较特殊，只能通过初始化列表初始化。不能在构造函数里赋值。  

##2.初始化列表
初始化列表：  
除了在构造函数中对数据成员进行初始化，C++还提供另外一种方法来对数据成员进行初始化  
初始化列表并不是在构造函数内进行初始化  
构造函数初始化列表以一个冒号开始，接着是以逗号分隔的数据成员列表，每个数据成员后面跟一个放在括号中的初始化式。
```
const int num;
```
必须初始化，而且不能在构造函数中初始化！  
```
CTime::CTime() : num(10){
	
	m_hour = 0;
	m_minute = 0;
	m_second = 0;
	m_nNum++;
	cout << m_nNum << endl;
}
CTime::CTime(int hour) : num(10){
	this->m_hour = hour;
	//(*this).m_hour = hour; //效果一样的
}

//复制构造函数
CTime::CTime(CTime& time) : num(10){
	m_hour = time.m_hour;
	m_minute = time.m_minute;
	m_second = time.m_second;
	//cout << "进入复制构造函数" << endl;
}

```
每一个构造函数都需要初始化这个const成员，而且复制构造函数也需要初始化num，因为复制构造函数也是一种构造函数！  


##3.const成员函数
const成员函数只能被const对象引用。const成员函数内可以引用const数据成员，也可以引用非const数据成员，但不能修改非const数据成员的值。但不能调用非const成员函数。
```C++ 声明
int getNum() const;
```
对于const函数的外部定义，也需要写const限定符  
```c++ 实现
int CTime::getNum() const {
	return num;
}
```
const成员函数存在的意义在于它能被const常对象调用  
```c++ 调用
CTime const time5;
	cout << time5.getNum() <<endl;
```
 如果在const成员函数的定义中出现了任何修改对象成员数据的现象，都会在编译时被检查出来  
 
如果我们是真的想在const成员函数中修改值呢，比如我需要m_age++;  
比如下面定义了一个m_age 类成员：
```
int m_age;
```
```
int CTime::getNum() const {
	if (m_age == 0){
		m_age++;
	}
	else{
		m_age = 0;
	}
	return num;
}
```
假如我们不做其他事情，这样的写法，在编译时是无法通过的。  

有些时候，我们想要让const函数具有修改某个成员数据值的能力。  
比如一些内部的状态量，对外部用户无所谓，但是对整个对象的运行却大有用处,如支持缓存的技术。  
遇到这种问题，我们可以把一个成员数据定义为mutable（多变的），它表示这个成员变量可以被const成员函数修改却不违法。  
比如下面定义了这样一个m_age 类成员：
```
mutable int m_age;
```
```
int CTime::getNum() const {
	if (m_age == 0){
		m_age++;
	}
	else{
		m_age = 0;
	}
	return num;
}
```
这样，即使像getNum()这样的const成员函数修改它也是合法的。  
但需要注意的时，不要滥用mutabe描述符，如果在某个类中只有少数一部分是被允许const常量函数修改的，使用mutable是再合适不过的。如果大部分数据都定义为mutable，那么最好将这些需要修改的数据放入另一个独立的对象里，并间接地访问它。


#源代码下载地址：
<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/C-Study/tree/master/20170603/test2' target='_blank'>点我进行下载</a>】</strong></p>
</blockquote>


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
