---
layout: post
title: "【Cocos2d-x】开发基础-Cocos2d-x核心概念"
date: 2017-06-30 09:54:32 +0800
comments: true
categories:cocos2d-x
tags: [cocos2d-x,博客]
keyword: 陈浩翔, 谙忆
description: 本篇博客讲解: 
1.Cocos2d-x的核心概念导演导演类Director(v3.0之前是CCDirector)用于管理场景对象。 
(所以3.0版本和以前的最大区别(我们看到的最大区别)就是类前面的CC，3.0版本是把所以的类前缀CC都去掉了)采用单例设计模式！(不多解释啦，不知道的朋友请搜索)auto director = Director::getInstance();//获取唯一的导演 
---


本篇博客讲解: 
1.Cocos2d-x的核心概念导演导演类Director(v3.0之前是CCDirector)用于管理场景对象。 
(所以3.0版本和以前的最大区别(我们看到的最大区别)就是类前面的CC，3.0版本是把所以的类前缀CC都去掉了)采用单例设计模式！(不多解释啦，不知道的朋友请搜索)auto director = Director::getInstance();//获取唯一的导演
<!-- more -->
----------

---
layout: post
title: "【Cocos2d-x】开发基础-Cocos2d-x核心概念"
date: 2017-06-10 13:38:54 +0800
comments: true
categories: Cocos2d-x
tags: [Cocos2d-x, basis]
keyword: 陈浩翔, 谙忆, C++, Cocos2d-x,Cocos2d-x核心概念
description:  Cocos2d-x的核心概念 导演 场景 层 精灵 菜单
---

本篇博客讲解:  
1.Cocos2d-x的核心概念

<!-- more -->
----------
#导演
导演类Director(v3.0之前是CCDirector)用于管理场景对象。  
(所以3.0版本和以前的最大区别(我们看到的最大区别)就是类前面的CC，3.0版本是把所以的类前缀CC都去掉了)

采用单例设计模式！(不多解释啦，不知道的朋友请搜索)
```c++ 获得导演类Director实例语句
auto director = Director::getInstance();//获取唯一的导演  单例模式
```

##导演对象的职责/作用
访问和改变场景  
访问Cocos2d-x的配置信息  
暂停、继续和停止游戏  
转换坐标  

上面只是导演对象的职责其中一部分，还有其他很多，但我们不需要让导演做很多事情(其他的事被隐藏了)，我们用的最多的应该就是访问和改变场景、暂停、继续和停止游戏和转换坐标  

#场景
场景类Scene(v3.0之前是CCScene)是构成游戏的界面，类似于电影中的场景。

像导演、场景、包括层，精灵等这些游戏的概念，其实都是从电影行业中过渡过来的。  
那么，电影行业，我们知道有场景，有导演。  
场景就是我们拍这场戏，我们布置的景  比如打斗的场景等  
场景中会有男主角，女主角，那么男女主角就相当于我们这里的精灵了，包括道具什么的(精灵)，这些东西在一起，就构成了层  
  
所以场景里面也会放一些层  

##场景大致可以分为以下几类
展示类场景。播放视频或简单的在图像上输出文字，来实现游戏的开场介绍、胜利和失败提示、帮助介绍  
选项类场景。主菜单，设置游戏参数等(比如开始，暂停，继续菜单)  
游戏场景。这是游戏的主要内容  

Scene类图:继承图
![](http://i.imgur.com/2S6h9PZ.png)

#层
层是我们写游戏的重点，我们大约99%以上的时间是在层上实现我们游戏内容。  
层的管理类似于Photoshop中的图层，它也是一层一层叠在一起  

我们一般写的很多类都是层，然后在层上面添加精灵等.然后把层放到场景里  
场景包含层，层包含精灵,菜单等对象  

理论上来说，层的层数越多(层与层之间有覆盖的问题，后面的层会覆盖先绘制的层)，需要绘制的深度越深，越耗CPU  
大家可以打开Photoshop，用里面的图层来理解，这样更加直观  
![](http://i.imgur.com/4XUGFsE.png)

#精灵
精灵类Sprite(v3.0之前是CCSprite)是游戏中非常重要的概念，它包括了敌人、玩家控制的对象、静态物体、地图和背景等  
通常情况它会进行运动，运动方式包括了：移动、旋转、放大、缩小和动画等  


#菜单
菜单在游戏中时非常重要的概念，它提供操作的集合，在Cococ2d-x中菜单类是Menu  

Menu中包含菜单项  
MenuItem，它有三个子类：  
MenuItemLabel、MenuItemSprite和MenuItemToggle  

之前的HelloWord中的关闭按钮其实就是一个菜单项  
我们也可以用精灵来实现，但是菜单项封装了一些触摸事件，你不需要关心它事件处理的细节问题  

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
