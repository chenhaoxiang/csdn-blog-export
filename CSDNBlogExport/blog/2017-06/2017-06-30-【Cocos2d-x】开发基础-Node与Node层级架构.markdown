---
layout: post
title: "【Cocos2d-x】开发基础-Node与Node层级架构"
date: 2017-06-30 10:23:04 +0800
comments: true
categories:cocos2d-x
tags: [cocos2d-x,结构]
keyword: 陈浩翔, 谙忆
description: 本篇博客讲解: 
1.Node与Node层级架构 
2.Node中重要的操作 
3.Node中重要的属性 
4.游戏循环与调度  Node与Node层级架构首先来看一张图 
 
这个图反应了Node与Node的层级架构 
所谓层级架构其实就是树形结构/层次结构，从图上可以看出来，树的根是Scene(场景)，然后是层，层里面又包含了精灵，菜单，粒子系统，瓦片地图 
所有这些元素，都有一个共同的父类，就 
---


本篇博客讲解: 
1.Node与Node层级架构 
2.Node中重要的操作 
3.Node中重要的属性 
4.游戏循环与调度  Node与Node层级架构首先来看一张图 
 
这个图反应了Node与Node的层级架构 
所谓层级架构其实就是树形结构/层次结构，从图上可以看出来，树的根是Scene(场景)，然后是层，层里面又包含了精灵，菜单，粒子系统，瓦片地图 
所有这些元素，都有一个共同的父类，就
<!-- more -->
----------

---
layout: post
title: "【Cocos2d-x】开发基础-Node与Node层级架构"
date: 2017-06-11 13:38:54 +0800
comments: true
categories: Cocos2d-x
tags: [Cocos2d-x, basis]
keyword: 陈浩翔, 谙忆, C++, Cocos2d-x,Node与Node层级架构
description: 1.Node与Node层级架2.Node中重要的操作3.Node中重要的属性4.游戏循环与调度  

---

本篇博客讲解:  
1.Node与Node层级架构  
2.Node中重要的操作  
3.Node中重要的属性  
4.游戏循环与调度  

<!-- more -->
----------

#Node与Node层级架构
首先来看一张图  
![](http://i.imgur.com/kGQ1oxN.png)  
这个图反应了Node与Node的层级架构  
所谓层级架构其实就是树形结构/层次结构，从图上可以看出来，树的根是Scene(场景)，然后是层，层里面又包含了精灵，菜单，粒子系统，瓦片地图  
所有这些元素，都有一个共同的父类，就是Node  

这个树形结构，其实就是一种包含关系  
![](http://i.imgur.com/wFK51kL.png)  
这2个文件共同定义了一个HelloWorld的层  
class HelloWorld : public cocos2d::Layer  
我们自己自定义了一个类HelloWorld继承了Layer，层最后要放到场景里去  
```c++
Scene* HelloWorld::createScene()
{
    // 创建场景对象
    auto scene = Scene::create();
    // 创建层对象
    auto layer = HelloWorld::create();
    // 把层放到场景里
    scene->addChild(layer);
    // 返回这个场景
    return scene;
}
```
创建场景以及HelloWord这个层，然后把层放到场景里  
通过addChild这个方法，把子节点加到父节点里面去  
以此类推，可以把Layer添加到Scene里，也可以这样把精灵，菜单等添加到层里  
```c++
this->addChild(menu, 1);//把菜单放到当前层
//把标签加入到层中
this->addChild(label, 1);
//把图片精灵加入到层中
this->addChild(sprite, 0);
```
代码在HelloWord.cpp中可以看到  
所以，最开始的图上的层次结构，是通过add的这个方法添加上来的  
既然有添加，那么就有移除方法，后面再介绍。  
主要是树形结构，需要注意的就是添加的顺序和个数  
一般来说，一个场景会有多个层，我们建立的HelloWord实例中，场景和层是一对一的关系  
也就是场景中只放了一个层。实际上场景与层是一对多的关系  
为了减少绘制的次数，不要建立太多的层，那样很消耗cpu  

层与精灵也是一对多的关系，然后层与菜单，粒子系统，瓦片地图都是一对多的关系  
菜单与菜单项是一对多的关系，一个菜单里会有多个菜单项  
当cocos2d启动一个场景的时候，场景就会加载层，层会加载菜单等等，菜单会加载菜单项。就是这样一种树形结构  

#Node中重要的操作
由于场景、层、菜单、精灵...都是继承的Node，所以它们有一些共同的属性和方法  

##创建节点
```c++ 创建节点
Node* childNode = Node::create()
```
##增加新的子节点
```c++ 增加新的子节点
node->addChild(childNode,0,123)
```
第一个参数是添加的节点；第二个参数是添加的Node的z轴的顺序(添加节点的时候会有顺序的，相当于绘制的时候的先后顺序)；第三个参数是Tag/标签，可以理解成id，通过这个tag来操作node对象      
![](http://i.imgur.com/eae63yS.png)  
附带第二个参数的英文介绍：  
```
LocalZOrder is the 'key' used to sort the node relative to its siblings.

The Node's parent will sort all its children based on the LocalZOrder value. If two nodes have the same LocalZOrder, then the node that was added first to the children's array will be in front of the other node in the array.

Also, the Scene Graph is traversed using the "In-Order" tree traversal algorithm ( http://en.wikipedia.org/wiki/Tree_traversal#In-order ) And Nodes that have LocalZOrder values < 0 are the "left" subtree While Nodes with LocalZOrder >=0 are the "right" subtree.
```
addChild有4个方法
```c++ 
virtual void addChild 	( Node * child) 	
virtual void addChild 	( Node * child,int localZOrder) 	
virtual void addChild 	( Node * child,int localZOrder,int tag) 
virtual void addChild 	( Node * child,int localZOrder,const std::string & name) 	
```

##查找子节点
```c++ 通过Tag查找子节点
Node* node = node->getChildByTag(123)
```
##删除子节点
```c++ 删除子节点，并停止所有该节点上的一切动作
node->removeChildByTag(123,true)//第二个参数表示是否在内存中清除这个对象
```
```c++ 通过Node指针删除节点
node->removeChild(childNode)//直接删除节点
```
```c++ 删除所有子节点，并停止这些子节点上的一切动作
node->removeAllChildrenWithCleanup(true) //true-清除内存
```
```c++ 从父节点Node中删除当前的节点对象，并停止所有该节点上的一切动作
node->removeFromParentAndCleanup(true) //true-清除内存
```

#Node中重要的属性
Node两个非常重要的属性:  
position和anchorPoint  
position是指的位置，anchorPoint是指的锚点  
位置(坐标)很好理解，就是比如放在(5,5),x=5,y=5.但是精灵图片是有大小的，这个时候就需要锚点了。    
我们用图来理解吧
1.anchorPoint为(0.5,0.5)，这个是默认值  
![](http://i.imgur.com/P68puku.png)  
第一个参数0.5，是锚点距离左边边线的距离和图片整个的宽度的比例，也就是1/2  
第二个参数0.5，是锚点距离底边高度和整个高度的比值，也就是1/2    

2.anchorPoint为(0,0)，也就是精灵图片的左下角  
![](http://i.imgur.com/DqOBDal.png)  

3.anchorPoint为(1.0,1.0)，也就是精灵图片的右上角    
![](http://i.imgur.com/hHux4IT.png)

4.anchorPoint为(0.66,0.5)，这个具有普遍性  
![](http://i.imgur.com/4ZzjNcC.png)

#游戏循环与调度
每一个游戏程序都有一个循环在不断运行，它是有导演对象来管理和维护。  
如果需要场景中的精灵运动起来，我们可以在游戏循环中使用定时器（Scheduler）对精灵等对象的运行进行调度。  
因为Node类封装了Scheduler类，所以我们也可以直接使用Node中调用函数。  
Node中调用函数主要有：  
```
void scheduleUpdate ( void )//开始游戏调度，每个Node对象只要调用该函数，那么这个Node对象就会定时地每帧回调用一次自己的update(float dt)函数，每帧调用一次update函数！这是固定的时间和函数  
//下面这个函数更加个性化，可以自定义回调函数和时间
void schedule ( SEL_SCHEDULE selector,  float  interval )//与scheduleUpdate函数功能一样，不同的是我们可以指定回调函数（通过selector指定），也可以根据需要指定回调时间间隔
//一旦调度开始，就会不断循环

void unscheduleUpdate ( void )//停止update(float dt)函数调度  和scheduleUpdate对应
void unschedule ( SEL_SCHEDULE selector )//可以指定具体函数停止调度  和schedule对应

void unscheduleAllSelectors ( void )//可以停止所有调度
```

#源代码下载地址：
<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/cocos2d-x/tree/master/20170611/HelloWorld' target='_blank'>点我进行下载</a>】</strong></p>
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
