---
layout: post
title: "【Cocos2d-x】开发基础-第一个Cocos2d-x游戏"
date: 2017-06-29 09:42:11 +0800
comments: true
categories:cocos2d-x
tags: [cocos2d-x,cocos2d,游戏]
keyword: 陈浩翔, 谙忆
description: 本篇博客讲解: 
1.第一个Cocos2d-x游戏第一个Cocos2d-x游戏创建工程cocos工具： 
就是这个，看图 
 
命令工具cocos实现，cocos工具其实是cocos2d团队自己开发的。是使用Python脚本编写的，cocos工具的运行需要安装Python环境 
(还会用到ant,eclipse等工具哦，后面介绍) 
Python下载地址 
https://www.python.or 
---


本篇博客讲解: 
1.第一个Cocos2d-x游戏第一个Cocos2d-x游戏创建工程cocos工具： 
就是这个，看图 
 
命令工具cocos实现，cocos工具其实是cocos2d团队自己开发的。是使用Python脚本编写的，cocos工具的运行需要安装Python环境 
(还会用到ant,eclipse等工具哦，后面介绍) 
Python下载地址 
https://www.python.or
<!-- more -->
----------

---
layout: post
title: "【Cocos2d-x】开发基础-第一个Cocos2d-x游戏"
date: 2017-06-07 13:38:54 +0800
comments: true
categories: Cocos2d-x
tags: [Cocos2d-x, basis]
keyword: 陈浩翔, 谙忆, C++, Cocos2d-x,第一个Cocos2d-x游戏
description: 第一个Cocos2d-x游戏 
---

本篇博客讲解:  
1.第一个Cocos2d-x游戏

<!-- more -->
----------
#第一个Cocos2d-x游戏
##创建工程
cocos工具：  
就是这个，看图
![](http://i.imgur.com/WHlXrKy.png)
命令工具cocos实现，cocos工具其实是cocos2d团队自己开发的。是使用Python脚本编写的，cocos工具的运行需要安装Python环境  
(还会用到ant,eclipse等工具哦，后面介绍)  
Python下载地址
https://www.python.org/ 
需要注意的是它目前有Python3和Python2可以下载，我们选择Python 2，不要下载3，因为2和3语法有很大差别，cocos这个工具是使用2编写的，如果你使用了3，会在脚本编译就出问题    
(我的源代码中有window的Python安装包)  
下载->安装->配置环境变量(Path中添加Python根目录)  
![](http://i.imgur.com/n5L6JbI.png)

点击确定设置好。

因为你还没有设置其他环境变量，所以你需要到此目录下：  
cocos2d-x-3.13.1\tools\cocos2d-console\bin  
直接输入cmd回车
![](http://i.imgur.com/pMcZqEi.png)
或者shift鼠标右键打开命令窗口，都行

如果你不知道怎么用，直接输入cocos会有帮助
![](http://i.imgur.com/r1BMr1e.png)

终端中执行如下指令：

```
cocos new -p com.uifuture -l cpp -d E://chxCocosWork HelloWord
```
com.uifuture是包名，最好是写上(可以不写)，因为在安卓发布打包需要  
cpp是语言，表示生成c++语言，还有lua,js  
E://chxCocosWork 为生成目录  
HelloWord为工程名  
![](http://i.imgur.com/atnBoCF.png)
如果你生成过程有问题，或者无法找到cocos命令，有可能是你的Path没有加进去，或者你使用的Python版本是3.X。

也可以用这种写法
```
cocos new HelloWord -p
com.uifuture -l cpp -d E://chxCocosWork
```
##工程文件结构
生成的目录结构是这样的：
![](http://i.imgur.com/iK0PwUP.png)

Resources文件夹是资源文件夹。  
图片，声音，字体，字库等都在这个目录  

Class目录是我们开发重点关注的文件夹，这里面都是cpp文件  
其他的文件夹，基本都是和平台有关的  

现在刚刚入门，我们不考虑平台移植的问题，现在只关心Class目录中文件的编写  

打开目录proj.win32，使用VS打开项目。 (使用VS打开HelloWorld.sln即可)  
![](http://i.imgur.com/8hfsLDh.png)

还有一些其他的工程：
![](http://i.imgur.com/p4cogHU.png)

也就是说，HelloWord这个工程需要运行，需要依赖这些工程！  
libcocos2d就是所有cocos2d的源码都是放在这个工程里面的，这个是和项目根目录cocos2d这个文件夹对应的  

运行工程：(第一次编译可能需要较长时间)
![](http://i.imgur.com/pmlDOeB.png)

左下角的一些数字，就是输出的帧;GL vwets就是绘制图形需要的顶点;GL calls 就是绘制的精灵的个数。右下角的按钮是菜单，你可以选择退出游戏  

##代码解释

我们看HelloWordScene.h  
```c++ HelloWordScene.h
#ifndef __HELLOWORLD_SCENE_H__
#define __HELLOWORLD_SCENE_H__

#include "cocos2d.h"

class HelloWorld : public cocos2d::Layer
{
public:
    static cocos2d::Scene* createScene();

    virtual bool init();
    
    // a selector callback
    void menuCloseCallback(cocos2d::Ref* pSender);
    
    // implement the "static create()" method manually
    CREATE_FUNC(HelloWorld);
};

#endif // __HELLOWORLD_SCENE_H__

```
里面定义了一个类HelloWorld,继承了cocos2d::Layer(层)  
虽然文件名叫HelloWordScene,Scene是场景，但是实际上里面的类是HelloWorld，实际上是层  
创建层的同时会先创建层所在的场景，层是要放在场景里面的。  

AppDelegate是一个应用程序委托对象，如果懂ios开发的，应该会对这个比较熟悉。  
它的作用就是，应用程序启动的时候会调用它。
```c++ AppDelegate.h
#ifndef  _APP_DELEGATE_H_
#define  _APP_DELEGATE_H_

#include "cocos2d.h"

/**
@brief    The cocos2d Application.

Private inheritance here hides part of interface from Director.
*/
class  AppDelegate : private cocos2d::Application
{
public:
    AppDelegate();
    virtual ~AppDelegate();

    virtual void initGLContextAttrs();

    /**
    @brief    Implement Director and Scene init code here.
    @return true    Initialize success, app continue.
    @return false   Initialize failed, app terminate.
    */
    virtual bool applicationDidFinishLaunching();

    /**
    @brief  Called when the application moves to the background
    @param  the pointer of the application
    */
    virtual void applicationDidEnterBackground();

    /**
    @brief  Called when the application reenters the foreground
    @param  the pointer of the application
    */
    virtual void applicationWillEnterForeground();
};

#endif // _APP_DELEGATE_H_
```
applicationDidFinishLaunching 这个函数是在程序启动的时候会调用它，也就是在游戏启动的时候调用，一般进行游戏的初始化，比如游戏的导演啊，场景啊等在这里进行初始化。  
applicationDidEnterBackground 是退到后台，就是点击home键，回到桌面。接电话或者跳到另一个应用程序去，都会调用这个函数。  
applicationWillEnterForeground 是从后台重新回到前台，也就是从手机任务栏重新回到游戏，会调用这个函数   
以上三个函数是和游戏的生命周期有关系的。  
HelloWorldScene.cpp
```c++ HelloWorldScene.cpp
#include "HelloWorldScene.h"
#include "SimpleAudioEngine.h"

USING_NS_CC;

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

// on "init" you need to initialize your instance
// 初始化当前这个层
bool HelloWorld::init()
{
    //////////////////////////////
    // 1. super init first
    if ( !Layer::init() )
    {
        return false;
    }
    
    auto visibleSize = Director::getInstance()->getVisibleSize();//得到屏幕的大小(可见区域大小)
    Vec2 origin = Director::getInstance()->getVisibleOrigin();//得到可见区域大小的左下角坐标

    /////////////////////////////
    // 2. add a menu item with "X" image, which is clicked to quit the program
    //    you may modify it.

    // add a "close" icon to exit the progress. it's an autorelease object
	// 得到图片菜单 以及设置回调函数
    auto closeItem = MenuItemImage::create(
                                           "CloseNormal.png",
                                           "CloseSelected.png",
                                           CC_CALLBACK_1(HelloWorld::menuCloseCallback, this));
    //关闭的按钮 
    closeItem->setPosition(Vec2(origin.x + visibleSize.width - closeItem->getContentSize().width/2 ,
                                origin.y + closeItem->getContentSize().height/2));

    // create menu, it's an autorelease object
	//把菜单项放到菜单里
    auto menu = Menu::create(closeItem, NULL);
	//指定菜单的位置 设置显示的坐标位置
    menu->setPosition(Vec2::ZERO);
    this->addChild(menu, 1);//把菜单放到当前层

    /////////////////////////////
    // 3. add your codes below...

    //标签 也就是中间显示的那个文字  以及加载字体
    auto label = Label::createWithTTF("Hello World", "fonts/Marker Felt.ttf", 24);
    
	//指定标签的位置
    label->setPosition(Vec2(origin.x + visibleSize.width/2,
                            origin.y + visibleSize.height - label->getContentSize().height));

	//把标签加入到层中
    this->addChild(label, 1);

	//指定一个图片的精灵
    auto sprite = Sprite::create("HelloWorld.png");

    // 设置图片精灵的位置
    sprite->setPosition(Vec2(visibleSize.width/2 + origin.x, visibleSize.height/2 + origin.y));

	//把图片精灵加入到层中
    this->addChild(sprite, 0);
    
    return true;
}

//点击close菜单项来回调的
void HelloWorld::menuCloseCallback(Ref* pSender)
{
    //Close the cocos2d-x game scene and quit the application
    Director::getInstance()->end();

	//条件编译 ，也就是满足条件就编译过去，如果不满足，就相当于注释了
#if (CC_TARGET_PLATFORM == CC_PLATFORM_IOS) 
    exit(0);
#endif
    
    /*To navigate back to native iOS screen(if present) without quitting the application  ,do not use Director::getInstance()->end() and exit(0) as given above,instead trigger a custom event created in RootViewController.mm as below*/
    
    //EventCustom customEndEvent("game_scene_close_event");
    //_eventDispatcher->dispatchEvent(&customEndEvent);
}
```

这样我们就得到一个能执行的HelloWord程序啦

因为cocos2dx项目工程太大，只上传Classes一些cpp文件啦，你可以手动把代码加入到你的cocos2dx项目工程中。  

#源代码下载地址：
<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/cocos2d-x/tree/master/20170607/HelloWorld' target='_blank'>点我进行下载</a>】</strong></p>
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
