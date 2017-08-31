---
layout: post
title: "【Cocos2d-x】开发基础-Cocos2d-x坐标系"
date: 2017-07-01 11:05:45 +0800
comments: true
categories:cocos2d-x
tags: [cocos2d-x]
keyword: 陈浩翔, 谙忆
description: 本篇博客讲解: 
1.UI坐标 
2.OpenGL坐标 
3.世界坐标和模型坐标 
4.实例：世界坐标转换为模型坐标 
5.实例：模型坐标转换为世界坐标  UI坐标和OpenGL坐标 
UI坐标就是Android和iOS等应用开发的时候使用的二维坐标系。它的坐标原点是在左上角的。 
UI坐标也叫视图坐标，它是和我们的OpenGL坐标是不一样的。OpenGL坐标是基于左下角的 
 
OpenGL坐标是 
---


本篇博客讲解: 
1.UI坐标 
2.OpenGL坐标 
3.世界坐标和模型坐标 
4.实例：世界坐标转换为模型坐标 
5.实例：模型坐标转换为世界坐标  UI坐标和OpenGL坐标 
UI坐标就是Android和iOS等应用开发的时候使用的二维坐标系。它的坐标原点是在左上角的。 
UI坐标也叫视图坐标，它是和我们的OpenGL坐标是不一样的。OpenGL坐标是基于左下角的 
 
OpenGL坐标是
<!-- more -->
----------

---
layout: post
title: "【Cocos2d-x】开发基础-Cocos2d-x坐标系"
date: 2017-06-14 13:38:54 +0800
comments: true
categories: Cocos2d-x
tags: [Cocos2d-x, basis]
keyword: 陈浩翔, 谙忆, C++, Cocos2d-x,Cocos2d-x坐标系
description: 1.UI坐标2.OpenGL坐标3.世界坐标和模型坐标4.实例：世界坐标转换为模型坐标5.实例：模型坐标转换为世界坐标  
---

本篇博客讲解:  
1.UI坐标  
2.OpenGL坐标  
3.世界坐标和模型坐标  
4.实例：世界坐标转换为模型坐标  
5.实例：模型坐标转换为世界坐标  

<!-- more -->
----------
#UI坐标和OpenGL坐标  
![](http://i.imgur.com/tXyhhzQ.png)  
UI坐标就是Android和iOS等应用开发的时候使用的二维坐标系。它的坐标原点是在左上角的。  
UI坐标也叫视图坐标，它是和我们的OpenGL坐标是不一样的。OpenGL坐标是基于左下角的
![](http://i.imgur.com/698Z9ws.png)   
OpenGL坐标是一种3D坐标，OpenGL是一个渲染的标准，渲染标准的坐标系是一种3D坐标系。  
所以OpenGL主要是给3D世界来做渲染，但是cocos2d觉得OpenGL速度快，所以就把OpenGL拿过来了做为一个引擎，这样的话，cocos2d就使用OpenGL坐标作为默认坐标  
OpenGL坐标在二维世界里，并没有什么太大的问题，不过就是Z轴基本不用。但是有时候也会用到，就是在绘制的顺序的时候，就需要Z轴了。  

比如绘制两个精灵在一个位置，精灵之间会有遮挡的问题，这个就和z轴的绘制顺序有关了。  

##从UI坐标到OpenGL坐标的转换
其实就是左上角，左下角之间的转换。  
屏幕的高度 - OpenGL坐标 = UI坐标  
屏幕的高度 - UI坐标 = OpenGL坐标  
```
Vec2 touchLocation = touch->getLocationInView(); //获取触摸点的位置，UI坐标系里的坐标
Vec2 touchLocation2 = Director::getInstance()->convertToGL(touchLocation);
```
touch是触摸点(Touch)对象  


##右手坐标系和左手坐标系
![](http://i.imgur.com/kCbPAIl.png)  
在3D坐标系里，有两种坐标。一种是Z轴指向外面的坐标，一种是Z轴指向内部的坐标，如上图  

![](http://i.imgur.com/GQ9rtZL.png)  
指向外面的坐标称为右手坐标系  
指向内部的坐标称为左手坐标系  
大家用左右手演示一下就明白了。
注意大拇指指向X轴正方向，食指向上，中指弯曲  
OpenGL属于右手坐标！  
微软平台的Direct3D是左手坐标！  
这两个是类似的技术  

#世界坐标和模型坐标  
由于OpenGL坐标有可以分为：世界坐标和模型坐标，所以Cocos2d-x的坐标也有世界坐标和模型坐标。  

举一个例子：  
比如你去问路，可能有人会告诉你先向南走1000米，再向东走500米、  
也可能会有人告诉你，先向右走1000米，再向左走500米、  

世界坐标:  
先向南走1000米，再向东走500米、也就是说以地球为参照物  
模型坐标(也叫本地坐标):  
先向右走1000米，再向左走500米、这里是以自身为参照物

所谓模型是什么，就是这个物体，这个精灵，也就是称为模型。  
虽然cocos2d画的是2D对象，但是实际上是以3D技术来绘制的，因此还是叫模型坐标  

世界坐标的整个坐标的参考系在第三方！也就是不是本身  

比如：  
![](http://i.imgur.com/5q7jsI6.png)  
看上图，坐标系上有ABC三个点，C是坐标原点，A参考C，B也参考C，那么，C的坐标就是A和B坐标的坐标系  
所以我们把以C为参考的坐标(也就是以第三方为参考系的坐标)称为世界坐标  
所以A的坐标是(5,5),B的坐标是(6,4)  

采用A的模型坐标来描述B的位置:  
我们也可以这么说，B相对于A的坐标是(1,-1),这样B就把A作为它的参考系，A就是模型坐标了！  
也就是B在A这个模型坐标里所在的位置是(1,-1)  

##世界坐标与模型坐标互相转换
通过Node对象如下函数实现：  
```C++ 世界坐标与模型坐标互相转换
Vec2 convertToNodeSpace ( const Vec2 & worldPoint ) //将世界坐标转换为模型坐标。坐标原点看成模型(对象，精灵)的左下角所在
Vec2 convertToNodeSpaceAR ( const Vec2 & worldPoint ) //将世界坐标转换为模型坐标。AR表示相对于锚点。

Vec2 convertTouchToNodeSpace ( Touch * touch ) //将世界坐标中触摸点转换为模型坐标。
Vec2 convertTouchToNodeSpaceAR ( Touch * touch ) //将世界坐标中触摸点转换为模型坐标。AR表示相对于锚点。
//凡是后面是ToNodeSpace的这个函数，是从世界坐标到模型坐标的转换  Node就是节点，也就是我们说的模型
//所有带有AR的，表示相对于锚点，也就是坐标原点看成模型(对象，精灵)的锚点所在

Vec2 convertToWorldSpace ( const Vec2 & nodePoint ) //将模型坐标中触摸点转换为世界坐标。
Vec2 convertToWorldSpaceAR ( const Vec2 & nodePoint ) //将模型坐标中触摸点转换为世界坐标。AR表示相对于锚点。
```

#实例：世界坐标转换为模型坐标  
![](http://i.imgur.com/3yIjKwO.png)    
Node1和Node2的像素是(300,100)  
所以很容易得出:  
A(100,400)  
C(200,300)
C相对于A:(100,-100)

B(400,500)
C相对于B:(-200,-200)

Node2的世界坐标转换为相对于Node1的模型坐标:
```
//将Node2的位置转换为相对于Node1的模型坐标，不带AR的，表示相对于Node1的坐标原点,也就是A点
Vec2 point1 = node1->convertToNodeSpace(node2->getPosition());

//将Node2的位置转换为相对于Node1的模型坐标，不带AR的，表示相对于Node1的锚点,也就是B点
Vec2 point2 = node1->convertToNodeSpaceAR(node2->getPosition());
```

所以得出的结果就是:
```
log("Node2 NodeSpace = (%f,%f)",point1.x,point1.y);
//Node2 NodeSpace = (100.000000,-100.000000)

log("Node2 NodeSpaceAR = (%f,%f)", point2.x, point2.y);
//Node2 NodeSpaceAR = (-200.000000,-200.000000)
```

```
bool HelloWorld::init()
{
    // 1. super init first
    if ( !Layer::init() )
    {
        return false;
    }
    
	auto node1 = Sprite::create("Node1.png");//Sprite是精灵
	node1->setPosition(Vec2(400,500));//设置位置
	node1->setAnchorPoint(Vec2(1.0, 1.0));//设置锚点

	this->addChild(node1,0);//层添加精灵

	auto node2 = Sprite::create("Node2.png");//Sprite是精灵
	node2->setPosition(Vec2(200, 300));//设置位置
	node2->setAnchorPoint(Vec2(0.5, 0.5));//设置锚点
	this->addChild(node2, 0);

	Vec2 point1 = node1->convertToNodeSpace(node2->getPosition());//将Node2的位置转换为相对于Node1的模型坐标，不带AR的，表示相对于Node1的坐标原点
	
	Vec2 point2 = node1->convertToNodeSpaceAR(node2->getPosition());

	log("Node2 NodeSpace = (%f,%f)",point1.x,point1.y);//Node2 NodeSpace = (100.000000,-100.000000)
	log("Node2 NodeSpaceAR = (%f,%f)", point2.x, point2.y);//Node2 NodeSpaceAR = (-200.000000,-200.000000)

    return true;
}

```
![](http://i.imgur.com/IDhDV2w.png)  

#源代码下载地址：
<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/cocos2d-x/tree/master/20170614/code/OpenGLcoordinates' target='_blank'>点我进行下载</a>】</strong></p>
</blockquote>

#实例：模型坐标转换为世界坐标  

![](http://i.imgur.com/SOqOMNO.png)  

在游戏场景中有两个Node对象，其中Node1的坐标是(400,500),大小是300*100像素  
Node2是放置在Node1中的，它对于Node1的模型坐标是(0,0),大小是150*150像素  

Node2相对于Node1的模型坐标转换的世界坐标:  
```
Vec2 point1 = node1->convertToWorldSpace(node2->getPosition());
>//node2->getPosition()为Node2在Node1中的模型坐标(相对于Node1的坐标原点得到的坐标) ->(convertToWorldSpace)->转换为世界坐标，Node2在Node1中的坐标实际上是(0,0),在世界坐标中，Node2的坐标其实就是A点的坐标
```
(150,50)为Node2的宽高  
A点的坐标 = (400,500) - (150,50) = (250,450)  

上面的是没加上锚点的，如果加上锚点，是相对于锚点的坐标  
加上锚点之后，Node1的锚点是B点，所以Node2相对于Node1的锚点的坐标是:

```
Vec2 point2 = node1->convertToWorldSpaceAR(node2->getPosition());
>//node2->getPosition()为Node2在Node1中的模型坐标(相对于再加上Node1的锚点的坐标得到的坐标) ->(convertToWorldSpaceAR)->转换为世界坐标
```
Vec2 point2 得到的其实就是B点的坐标，也就是A点坐标，加上Node1锚点的坐标相对于A点的坐标。也就是(250,450)+(150,50) = (400,500)  
也就是我们说的Node2的世界坐标！  

```
bool HelloWorld::init()
{
	// 1. super init first
	if (!Layer::init())
	{
		return false;
	}

	auto node1 = Sprite::create("Node1.png");//Sprite是精灵
	node1->setPosition(Vec2(400, 500));//设置位置
	node1->setAnchorPoint(Vec2(0.5, 0.5));//设置锚点

	this->addChild(node1, 0);//层添加精灵

	auto node2 = Sprite::create("Node2.png");//Sprite是精灵
	node2->setPosition(Vec2(0.0, 0.0));//设置位置
	node2->setAnchorPoint(Vec2(0.0, 0.0));//设置锚点
	node1->addChild(node2, 0);//把Node2放到Node1

	//将Node2的位置转换为相对于Node1的模型坐标，不带AR的，表示相对于Node1的坐标原点
	Vec2 point1 = node1->convertToWorldSpace(node2->getPosition());
	Vec2 point2 = node1->convertToWorldSpaceAR(node2->getPosition());

	log("Node2 WorldSpace = (%f,%f)", point1.x, point1.y);//Node2 WorldSpace = (250.000000,450.000000)
	log("Node2 WorldSpaceAR = (%f,%f)", point2.x, point2.y);//Node2 WorldSpaceAR = (400.000000,500.000000)

	return true;
}
```

```C++ node1模型坐标来设置位置
node2->setPosition(Vec2(0.0, 0.0));//设置位置
node2->setAnchorPoint(Vec2(0.0, 0.0));//设置锚点
node1->addChild(node2, 0);//把Node2放到Node1
```
上面代码是使用node1模型坐标来设置位置的  
也可以用世界坐标描述
```C++ 世界坐标描述
node2->setPosition(Vec2(250, 450));
node2->setAnchorPoint(Vec2(0.0, 0.0));
this->addChild(node2, 0);
```

#源代码下载地址：
<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/cocos2d-x/tree/master/20170614/code/OpenGLcoordinates2' target='_blank'>点我进行下载</a>】</strong></p>
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
