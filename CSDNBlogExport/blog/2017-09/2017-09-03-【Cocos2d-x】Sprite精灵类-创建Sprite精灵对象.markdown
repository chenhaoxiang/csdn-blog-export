---
layout: post
title: "【Cocos2d-x】Sprite精灵类-创建Sprite精灵对象"
date: 2017-09-03 12:21:25 +0800
comments: true
categories:cocos2d-x
tags: [cocos2d-x]
keyword: 陈浩翔, 谙忆
description: 精灵在Cocos2d-x中的地位就像一场电影中的主角，男主角/女主角，是一场电影中的灵魂所在。也是我们游戏中的灵魂 
无论我们控制的对象还是电脑控制的对象，我们都称之为精灵，或者背景中的图片，也可以称为精灵、只要在游戏场景中的东西，都是可以用精灵来做的。比如菜单，可以做成精灵菜单。 
还有些精灵是和物理引擎有关的，有一些物理特效。 
本章讲的精灵，只是一般意义上的精灵。创建Sprite精灵对象创建精 
---


精灵在Cocos2d-x中的地位就像一场电影中的主角，男主角/女主角，是一场电影中的灵魂所在。也是我们游戏中的灵魂 
无论我们控制的对象还是电脑控制的对象，我们都称之为精灵，或者背景中的图片，也可以称为精灵、只要在游戏场景中的东西，都是可以用精灵来做的。比如菜单，可以做成精灵菜单。 
还有些精灵是和物理引擎有关的，有一些物理特效。 
本章讲的精灵，只是一般意义上的精灵。创建Sprite精灵对象创建精
<!-- more -->
----------

---
layout: post
title: "【Cocos2d-x】Sprite精灵类-创建Sprite精灵对象"
date: 2017-08-22 13:38:54 +0800
comments: true
categories: Cocos2d-x
tags: [Cocos2d-x, basis]
keyword: 陈浩翔, 谙忆, C++, Cocos2d-x,Sprite精灵类
description:  精灵在Cocos2d-x中地位就像一场电影中的主角，男主角/女主角，是一场电影中的灵魂所在。也是我们游戏中的灵魂 无论我们控制的对象还是电脑控制的对象，我们都称之为精灵，或者背景中的图片，也可以称为精灵、只要在游戏场景中的东西，都是可以用精灵来做的。比如菜单，可以做成精灵菜单。  
---

精灵在Cocos2d-x中的地位就像一场电影中的主角，男主角/女主角，是一场电影中的灵魂所在。也是我们游戏中的灵魂  
无论我们控制的对象还是电脑控制的对象，我们都称之为精灵，或者背景中的图片，也可以称为精灵、只要在游戏场景中的东西，都是可以用精灵来做的。比如菜单，可以做成精灵菜单。  
还有些精灵是和物理引擎有关的，有一些物理特效。  
本章讲的精灵，只是一般意义上的精灵。

<!-- more -->
----------

#创建Sprite精灵对象

##创建精灵对象
创建精灵对象有多种方式，其中常用的函数如下:
```C++
static Sprite* create(); //创建一个精灵对象，纹理等属性需要在创建后设置
static Sprite* create(const std:string &filename); //指定图片创建精灵  这种方式在实际项目中很少用。我们不会简单的把每个精灵做一个图片，这样会消耗更多的IO读写时间  
//可以放在大图中(合成图)，进行一次读取，在使用中再截取，也就是下面的创建方法(这样内存会消耗多,但是IO操作少)
//如果使用的是iOS系统(苹果)，图片不能超过2048*2048，这是系统的限制
static Sprite* create(const std::string &filename,const Rect &rect); //指定图片和裁剪的矩形区域来创建精灵
static Sprite* createWithTexture(Texture2D *texture);//指定纹理创建精灵  如果已经有纹理对象了，直接把纹理对象拿过来创建精灵对象
static Sprite* createWithTexture(Texture2D *texture,const Rect &rect,bool rotated=false);//指定纹理和裁剪的矩形区域来创建精灵，第三个参数是否旋转纹理，默认不旋转  从纹理缓存区来裁剪矩形区域创建精灵
//旋转就是，可能某些情况下，我们合图时为了节省空间，将小图旋转再合图了，这个时候就需要旋转了
static Sprite* createWithSpriteFrame(SpriteFrame *pSpriteFrame);//通过一个精灵帧对象创建另一个精灵对象 帧缓存
static Sprite* createWithSpriteFrameName(const std::string &spriteFrameName);//通过精灵帧的名字的创建
```
##Sprite继承关系图:  
![](http://i.imgur.com/QsLMq4Z.png)  

##纹理
无论是计算机中的CPU还是GPU，做运算做处理，它不是对图片进行处理。图片读入到计算机里，需要对图片进行解码。最后，在计算机放的东西，就可以叫做纹理！   
实际上，纹理就是由图片或者计算机本身用绘图工具绘画出来的对象。这个东西本身最后的目的是为了放在图片上面，这个过程叫纹理贴图。  
在实际中，我们有时候是把纹理叫成图片的。或者图片叫成纹理。一般而言，在游戏里叫纹理或纹理图片，这是没问题的  

#使用纹理对象创建Sprite对象
场景设计:   
![](http://i.imgur.com/kSgYBRI.png)  

两个精灵(具体几个，看美工给几张图咯):  
草地图片:
![](http://i.imgur.com/UCauNT0.png)    

------------------------------
树图片:
![](http://i.imgur.com/NtzBfko.png)  
这张图上有三棵树，实际上我们不需要全部用到，所以不能简单的把树图片放到草地图片上面。  
而且摆放位置也不同。对于第二种图片，我们可以先读到内存里，形成一个纹理对象，然后从这个纹理对象中截图  
从里面裁剪出来来创建精灵对象。  
裁剪有两种方式，一是通过它的纹理缓存来裁剪。也可以从大图文件直接进行裁剪。  

不管是哪种方式，我们都需要去量树的坐标，Rect的参数是一样的！ 
去画图工具中量坐标:  
我们需要的参数是:左上角坐标，还有宽和高   
![](http://i.imgur.com/TEzpJkp.png)  

从纹理中创建tree精灵:
```C++ tree1精灵
auto tree1 = Sprite::create("tree1.png", Rect(608, 36, 300, 298));//左上角的坐标，宽，高
//指定大图，指定Rect获取树的截图
tree1->setPosition(Vec2(200,230));
this->addChild(tree1,0)
```
```C++ tree2精灵
Texture2D* cache = Director::getInstance()->getTextureCache()->addImage("tree1.png");
auto tree2 = Sprite::create();
tree2->setTexture(cache);
tree2->setTextureRect(Rect(70,72,187,267));
tree2->setPosition(Vec2(500,200));//设置精灵位置
this->addChild(tree2,0);
//通过纹理缓存截取树
```
平时我们玩游戏的时候，遇到游戏中loading的画面时，基本上就是在缓存纹理，经过这个步骤后，我们玩游戏会快很多。因为不会去临时加载图片  

##实例：
```C++

bool HelloWorld::init()
{
	if ( !Layer::init() )
	{
		return false;
	}

	Size visibleSize = Director::getInstance()->getVisibleSize();
	Vec2 origin = Director::getInstance()->getVisibleOrigin();

	//背景精灵
	auto background = Sprite::create("background.png");//背景图
	//background->setAnchorPoint(Vec2::ZERO);//指定锚点(默认坐标为0，0)或者:
	background->setPosition(Vec2(visibleSize.width/2,visibleSize.height/2));//指定位置(默认锚点为0.5，0.5)
	this->addChild(background,0);

	auto tree1 = Sprite::create("tree1.png", Rect(608, 36, 300, 298));//左上角的坐标，宽，高
	//指定大图，指定Rect获取树的截图
	tree1->setPosition(Vec2(200,230));
	this->addChild(tree1,0);
	
	Texture2D* cache = Director::getInstance()->getTextureCache()->addImage("tree1.png");
	auto tree2 = Sprite::create();
	tree2->setTexture(cache);
	tree2->setTextureRect(Rect(70, 72, 187, 267));
	tree2->setPosition(Vec2(500, 200));//设置精灵位置
	this->addChild(tree2, 0);
	//通过纹理缓存截取树
	
	return true;
}
```

#源代码下载地址：
<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/cocos2d-x/tree/master/20170822/code/Cocos2dxSprite' target='_blank'>点我进行下载</a>】</strong></p>
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
