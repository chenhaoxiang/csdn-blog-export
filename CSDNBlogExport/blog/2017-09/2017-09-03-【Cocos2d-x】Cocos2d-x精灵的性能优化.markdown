---
layout: post
title: "【Cocos2d-x】Cocos2d-x精灵的性能优化"
date: 2017-09-03 12:23:19 +0800
comments: true
categories:cocos2d-x
tags: [cocos2d-x,性能优化,图片]
keyword: 陈浩翔, 谙忆
description: Cocos2d-x精灵的性能优化-使用纹理图集和精灵帧缓存使用纹理图集纹理图集(Texture)也称为精灵表(Sprite Sheet)   使用纹理图集的优点: 
1、减少文件读取次数，读取一张图片比读取一推小文件要快 
2、减少OpenGL ES绘制调用并且加速渲染 
OpenGL ES 1.1仅仅能够使用2的n次幂大小的图片(即宽度或者高度是2、4、8、64…)。 
如果采用小图片OpenGL 
---


Cocos2d-x精灵的性能优化-使用纹理图集和精灵帧缓存使用纹理图集纹理图集(Texture)也称为精灵表(Sprite Sheet)   使用纹理图集的优点: 
1、减少文件读取次数，读取一张图片比读取一推小文件要快 
2、减少OpenGL ES绘制调用并且加速渲染 
OpenGL ES 1.1仅仅能够使用2的n次幂大小的图片(即宽度或者高度是2、4、8、64…)。 
如果采用小图片OpenGL
<!-- more -->
----------

---
layout: post
title: "【Cocos2d-x】Cocos2d-x精灵的性能优化"
date: 2017-08-24 13:38:54 +0800
comments: true
categories: Cocos2d-x
tags: [Cocos2d-x, basis]
keyword: 陈浩翔, 谙忆, C++, Cocos2d-x,Cocos2d-x精灵的性能优化
description:  Cocos2d-x精灵的性能优化-使用纹理图集和精灵帧缓存 使用纹理图集的优点:1、减少文件读取次数，读取一张图片比读取一推小文件要快 2、减少OpenGL ES绘制调用并且加速渲染 OpenGL ES 1.1仅仅能够使用2的n次幂大小的图片(即宽度或者高度是2、4、8、64...)。 
---

Cocos2d-x精灵的性能优化-使用纹理图集和精灵帧缓存

<!-- more -->
----------

#使用纹理图集
纹理图集(Texture)也称为精灵表(Sprite Sheet)   

使用纹理图集的优点:
1、减少文件读取次数，读取一张图片比读取一推小文件要快  
2、减少OpenGL ES绘制调用并且加速渲染  
OpenGL ES 1.1仅仅能够使用2的n次幂大小的图片(即宽度或者高度是2、4、8、64...)。  
如果采用小图片OpenGL ES1.1会分配给每个图片2的n次幂大小的内存空间，即使这张图片达不到这样的宽度和高度也会分配大于此图片的2的n次幂大小的空间。那么运用这种图片集的方式将会减少内存碎片。  
虽然在Cocos2d-x v2.0后使用OpenGL ES2.0,它不会再分配2的几次幂的内存块了，但是减少读取次数和绘制的优势依然存在。  
3、减少内存消耗。  
4、Cocos2d-x全面支持Zwoptex和TexturePacker，所以创建和使用纹理图集是很容易的  

![](http://i.imgur.com/g2Z6XnO.png)  
这样一张大图，可以让美工来完成，但是记得需要记下坐标，图集中小图的左上角坐标是多少，宽和高是多少，这是需要知道的。  
这是很耗时的。实际上这是可以由软件(Zwoptex和TexturePacker)来完成的。  
做出来的纹理图集由两部分构成。一部分是存有纹理的，也就是大图文件。另一部分就是里面精灵/小图的坐标等信息文件  
 
![](http://i.imgur.com/0CWjIUB.png)  
plist文件是属性列表文件，一种xml文件。每一个小图称为帧(frame),每一个frame包含了该帧的名(key)，坐标,高宽。是否旋转等。这是给程序读的  
```C++ 加载纹理缓存图片/大图
bool HelloWorld::init()
{
	if ( !Layer::init() )
	{
		return false;
	}

	Size visibleSize = Director::getInstance()->getVisibleSize();
	Vec2 origin = Director::getInstance()->getVisibleOrigin();

	auto background = Sprite::create("background.png");
	background->setAnchorPoint(Vec2::ZERO);
    this->addChild(background,0);   

    auto mountain1 = Sprite::create("SpriteSheet.png",Rect(2,391, 934, 388));//截取图片
	mountain1->setAnchorPoint(Vec2::ZERO);//设置锚点
    mountain1->setPosition(Vec2(-200,80));//设置坐标
    this->addChild(mountain1,0);

    Texture2D* cache = Director::getInstance()->getTextureCache()->addImage("SpriteSheet.png");//加载整个图片到纹理缓存
    auto hero1 = Sprite::create();
    hero1->setTexture(cache);
    hero1->setTextureRect(Rect(2,1706,391,327));//在纹理缓存中截取图片  左上角坐标 以及截取图片的宽高
    hero1->setPosition(Vec2(800,200));
    this->addChild(hero1,0);
	
	return true;
}

```


##源代码下载地址：
<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/cocos2d-x/tree/master/20170824/code/Cocos2dSpriteSheet' target='_blank'>点我进行下载</a>】</strong></p>
</blockquote>



#精灵帧缓存
精灵帧缓存是缓存的一种，缓存有如下几种:  
1、纹理缓存(TextureCache)  
使用纹理缓存可以创建纹理对象  
2、精灵帧缓存(SpriteFrameCache)  
和纹理图集相对应，把plist文件读到内存，到文件里面创建精灵帧缓存，然后再从精灵帧缓存中获得精灵对象，反复使用精灵对象时候，使用精灵帧缓存可以节省内存消耗  
将一个图读到精灵帧缓存中，同时也会加载到纹理缓存中  

3、动画缓存(AnimationCache)  
动画缓存主要用于精灵动画，精灵动画中的每一帧是从动画缓存中获取的  

```c++ 精灵帧缓存
SpriteFrameCache *frameCache = SpriteFrameCache::getInstance();
frameCache->addSpriteFramesWithFile("SpriteSheet.plist");
//单例-将精灵图集的坐标读进去 根据这个坐标获取图集，这个加载过程是在游戏启动的时候加载，并不是在用的时候加载(肯定会占用很多内存的,不过现在手机一般内存都挺多的)  
auto mountain1 = Sprite::createWithSpriteFrameName("mountain1.png");//缓存被创建后，可以通过frame名字(**注意名字冲突的问题，名字一样的精灵帧，后面的会覆盖前面的,可以加前缀以区分**)指定精灵帧来创建一个精灵   这个过程并不是通过大图去创建的，而是通过SpriteFrameCache缓存取出来的，这个速度很快  
//还可以通过精灵帧来创建精灵  
SpriteFrame *heroSpriteFrame = frameCache->getSpriteFrameByName("hero1.png");//通过精灵帧名字获取精灵帧
Sprite *hero1 = Sprite::createWithSpriteFrame(heroSpriteFrame);//通过精灵帧创建精灵
```

清空或移除精灵帧的缓存函数:
```C++ 
void removeSpriteFrameByName(const std::string& name);//指定具体的精灵帧名将精灵帧从缓存中移除，具体到精灵帧
void removeSpriteFrames();//指定清空所有的精灵帧缓存
void removeSpriteFramesFromFile(const std::string& plist);//指定具体的坐标文件(plist文件)移除精灵帧
void removeUnusedSpriteFrames();//移除没有使用的精灵帧
```
建议初学者不要轻易使用清除缓存函数！  

#小项目实例
现在还做不了太复杂的项目，在目前这个阶段  
项目描述:  
我们有这样一个场景，一个背景草地，山，和一个精灵牛仔(还没学帧动画，先做个静态的)。 把这三个精灵放到一个场景中  
利用精灵帧缓存完成  
![](http://i.imgur.com/6IbcWnk.png)  

背景没有放到精灵图集中去，这是因为背景是不需要透明的  
```C++
bool HelloWorld::init()
{
	if ( !Layer::init() )
	{
		return false;
	}

	Size visibleSize = Director::getInstance()->getVisibleSize();
	Vec2 origin = Director::getInstance()->getVisibleOrigin();

	auto background = Sprite::create("background.png");//加载背景精灵
	background->setAnchorPoint(Vec2::ZERO);
    this->addChild(background,0);
	
	SpriteFrameCache *frameCache = SpriteFrameCache::getInstance();//单例对象
	frameCache->addSpriteFramesWithFile("SpriteSheet.plist");//加载精灵图集

    auto mountain1 = Sprite::createWithSpriteFrameName("mountain1.png");//通过精灵帧名创建精灵
	mountain1->setAnchorPoint(Vec2::ZERO);//设置锚点
    mountain1->setPosition(Vec2(-200,80));
    this->addChild(mountain1,0);

	SpriteFrame *heroSpriteFrame = frameCache->getSpriteFrameByName("hero1.png");//通过精灵帧名字获取精灵帧
	Sprite *hero1 = Sprite::createWithSpriteFrame(heroSpriteFrame);//通过精灵帧创建精灵
//上面的两条语句相当于前面一条语句的效果auto mountain1 = Sprite::createWithSpriteFrameName("mountain1.png");
    hero1->setPosition(Vec2(800,200));
    this->addChild(hero1,0);

	return true;
}

```

##源代码下载地址：
<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/cocos2d-x/tree/master/20170824/code/Cocos2dxHero' target='_blank'>点我进行下载</a>】</strong></p>
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
