---
layout: post
title: "【Cocos2d-x】开发实战-Cococs2d-x中的菜单"
date: 2017-08-24 02:07:30 +0800
comments: true
categories:cocos2d-x
tags: [cocos2d-x,图片,继承,博客,class]
keyword: 陈浩翔, 谙忆
description: 本篇博客讲解: 
1.使用菜单 
2.文本菜单 
3.精灵菜单和图片菜单 
4.开关菜单   使用菜单Menu - 菜单 
MenuItem - 菜单项  菜单分类实际上是按照菜单项分类的 
菜单和菜单项的继承关系图: 
  文本菜单,精灵菜单，图片菜单和开关菜单其实准确来讲，应该是: 
文本菜单项,精灵菜单项，图片菜单项和开关菜单项  继承MenuItemLabel的菜单其实都是文本菜单 
精灵菜 
---


本篇博客讲解: 
1.使用菜单 
2.文本菜单 
3.精灵菜单和图片菜单 
4.开关菜单   使用菜单Menu - 菜单 
MenuItem - 菜单项  菜单分类实际上是按照菜单项分类的 
菜单和菜单项的继承关系图: 
  文本菜单,精灵菜单，图片菜单和开关菜单其实准确来讲，应该是: 
文本菜单项,精灵菜单项，图片菜单项和开关菜单项  继承MenuItemLabel的菜单其实都是文本菜单 
精灵菜
<!-- more -->
----------

---
layout: post
title: "【Cocos2d-x】开发实战-Cococs2d-x中的菜单"
date: 2017-07-01 13:38:54 +0800
comments: true
categories: Cocos2d-x
tags: [Cocos2d-x, basis]
keyword: 陈浩翔, 谙忆, C++, Cocos2d-x,Cococs2d-x中的菜单
description: Cococs2d-x中的菜单，menu,menuItem,1.使用菜单2.文本菜单3.精灵菜单和图片菜单 4.开关菜单 菜单分类实际上是按照菜单项分类的 文本菜单,精灵菜单，图片菜单和开关菜单其实准确来讲，应该是,文本菜单项,精灵菜单项，图片菜单项和开关菜单项
---

本篇博客讲解:    
1.使用菜单  
2.文本菜单  
3.精灵菜单和图片菜单  
4.开关菜单   

<!-- more -->
----------

#使用菜单
Menu - 菜单  
MenuItem - 菜单项  

菜单分类实际上是按照菜单项分类的  
菜单和菜单项的继承关系图:  
![](http://i.imgur.com/OYKnEka.png)  

文本菜单,精灵菜单，图片菜单和开关菜单其实准确来讲，应该是:  
文本菜单项,精灵菜单项，图片菜单项和开关菜单项  

继承MenuItemLabel的菜单其实都是文本菜单    
精灵菜单:MenuItemSprite的子类是图片菜单MenuItemImage  
开关菜单:MenuItemToggle  

#文本菜单
文本菜单是菜单项只是显示文本  
文本菜单类包括了MenuItemLabel、MenuItemFont和MenuItemAtlasFont。MenuItemLabel是个抽象类，具体使用的时候是使用MenuItemFont和MenuItemAtlasFont两个类。
文本菜单类MenuItemFont，它的其中一个创建函数create定义如下:  

```C++
static MenuItemFont* create(const std::string &value, //要显示的文本
const ccMenuCallback & callback  //菜单操作的回调函数指针,菜单项被点击之后回调的函数
);
```

cocos2d帮我们做了一个宏来帮助我们传递回调函数的参数,CC_CALLBACK_n,n为回调的参数个数  
![](http://i.imgur.com/6JjL3zZ.png)  
```C++
// new callbacks based on C++11
#define CC_CALLBACK_0(__selector__,__target__, ...) std::bind(&__selector__,__target__, ##__VA_ARGS__)
#define CC_CALLBACK_1(__selector__,__target__, ...) std::bind(&__selector__,__target__, std::placeholders::_1, ##__VA_ARGS__)
#define CC_CALLBACK_2(__selector__,__target__, ...) std::bind(&__selector__,__target__, std::placeholders::_1, std::placeholders::_2, ##__VA_ARGS__)
#define CC_CALLBACK_3(__selector__,__target__, ...) std::bind(&__selector__,__target__, std::placeholders::_1, std::placeholders::_2, std::placeholders::_3, ##__VA_ARGS__)
```

文本菜单类MenuItemAtlasFont是基于图片集的文本菜单项，它的其中一个创建函数create定义如下:
```C++
static MenuItemAtlasFont* create(const std::string& value,//要显示的文本
 const std::string& charMapFile, //图片集文件
int itemWidth, //要截取的文字在图片中的宽度
int itemHeight, //要截取的文字在图片中的高度
char startCharMap,//文字之间的间隔符
 const ccMenuCallback& callback//菜单操作的回调函数指针
);
    
```
实例:
```C++
bool HelloWorld::init()
{
if (!Layer::init())
{
return false;
}

Size visibleSize = Director::getInstance()->getVisibleSize();
Vec2 origin = Director::getInstance()->getVisibleOrigin();

Sprite *bg = Sprite::create("menu/background.png"); //背景图片精灵
bg->setPosition(Vec2(origin.x + visibleSize.width / 2,
origin.y + visibleSize.height / 2));
this->addChild(bg);

MenuItemFont::setFontName("Times New Roman");//使用系统字体，设置系统字体的名字
MenuItemFont::setFontSize(86);//设置系统字体的大小
MenuItemFont *item1 = MenuItemFont::create("Start",
CC_CALLBACK_1(HelloWorld::menuItem1Callback, this)); //创建基于系统字体的MenuItemFont


MenuItemAtlasFont *item2 = MenuItemAtlasFont::create("Help",
"menu/tuffy_bold_italic-charmap.png", 48, 65, ' ',
CC_CALLBACK_1(HelloWorld::menuItem2Callback, this));

Menu* mn = Menu::create(item1, item2, NULL);//把MenuItem放到Menu里，不能直接把MenuItem放到层里
mn->alignItemsVertically();//设置菜单位置，垂直对齐
this->addChild(mn);//把菜单放到层里

return true;
}


void HelloWorld::menuItem1Callback(Ref* pSender)
{
//实际上这里传进来的参数是MenuItem类型，所以在这里可以强转，也可以直接把形参类型写成MenuItem，不写成Ref
MenuItem* item = (MenuItem*)pSender;
//一般情况下，我们不需要这个参数，只有在需要一些特定的信息的情况下，我们才需要进行转换拿值
log("Touch Start Menu Item %p", item); //这个输出是输出指针的地址，没有意义,在这里只是掩饰回调函数起作用了！且对象传过来了
}

void HelloWorld::menuItem2Callback(Ref* pSender)
{
MenuItem* item = (MenuItem*)pSender;
log("Touch Help Menu Item %p", item);
}

```

##显示效果:  
![](http://i.imgur.com/LyozJx3.gif)   

##源代码下载地址：

GITHUB源码下载地址:<strong>【[点我进行下载](https://github.com/chenhaoxiang/cocos2d-x/tree/master/20170701/code/Cocos2dTextMenu)】</strong>

#精灵菜单和图片菜单

##精灵菜单项类MenuItemSprite
创建函数create定义:
```C++
static MenuItemSprite * create(Node* normalSprite, Node* selectedSprite, Node* disabledSprite = nullptr);  
static MenuItemSprite* create(Node* normalSprite,//菜单项正常显示时候的精灵
Node* selectedSprite,//选择菜单项时候的精灵
Node* disableSprite,//菜单项禁用时候的精灵
const ccMenuCallback& callback //菜单操作的回调函数指针
)  
static MenuItemSprite * create(Node* normalSprite, Node* selectedSprite, const ccMenuCallback& callback);
```

##图片菜单项类MenuIemImage
创建函数create定义:
```C++
static MenuItemImage* create(const std::string& normallmage,//菜单项正常显示时候的图片
const std::string& selectedImage,//选择菜单项时候的图片
const std::string& disabledImage,//菜单项禁用时候的图片
const ccMenuCallback& callback//菜单操作的回调函数指针
)
```
精灵菜单和图片菜单都有三种状态，也就是正常状态，选中状态，还有禁用状态。  

##实例
```C++
bool HelloWorld::init()
{
if ( !Layer::init() )
{
	return false;
}

Size visibleSize = Director::getInstance()->getVisibleSize();
Vec2 origin = Director::getInstance()->getVisibleOrigin();

Sprite *bg = Sprite::create("menu/background.png");

bg->setPosition(Vec2(origin.x + visibleSize.width/2,
                         origin.y + visibleSize.height /2));
this->addChild(bg);

//开始精灵
Sprite *startSpriteNormal = Sprite::create("menu/start-up.png");
Sprite *startSpriteSelected = Sprite::create("menu/start-down.png");
//创建精灵菜单  添加精灵以及回调函数
MenuItemSprite *startMenuItem = MenuItemSprite::create(startSpriteNormal, 
												startSpriteSelected,
											   CC_CALLBACK_1(HelloWorld::menuItemStartCallback, this));
startMenuItem->setPosition(Director::getInstance()->convertToGL(Vec2(700, 170)));
//指定坐标    convertToGL转换-将左上角为原点的UI坐标转换为OpenGL坐标，cocos2d默认坐标为OpenGL坐标
//700, 170为UI坐标

// 设置 图片菜单 图片菜单的好处就是直接使用图片就好了
MenuItemImage *settingMenuItem = MenuItemImage::create(
                         "menu/setting-up.png",
                         "menu/setting-down.png",
						 CC_CALLBACK_1(HelloWorld::menuItemSettingCallback, this)); 

settingMenuItem->setPosition(Director::getInstance()->convertToGL(Vec2(480, 400)));	

// 帮助 图片菜单
MenuItemImage *helpMenuItem = MenuItemImage::create(
                         "menu/help-up.png",
                         "menu/help-down.png",
						 CC_CALLBACK_1(HelloWorld::menuItemHelpCallback, this));	

helpMenuItem->setPosition(Director::getInstance()->convertToGL(Vec2(860, 480)));
//在这里，精灵菜单和图片菜单没什么区别，视觉效果一样，也一样有回调函数

Menu* mu = Menu::create(startMenuItem, settingMenuItem, helpMenuItem, NULL);//指定菜单  NULL指定菜单列表的结束
mu->setPosition(Vec2::ZERO);//菜单处于坐标原点 - 因为菜单项已经都指定位置了
this->addChild(mu);

return true;
}

//回调函数
void HelloWorld::menuItemHelpCallback(Ref* pSender)
{
MenuItem* item = (MenuItem*)pSender;
log("Touch Help %p", item);
}

void HelloWorld::menuItemStartCallback(Ref* pSender)
{
MenuItem* item = (MenuItem*)pSender;
log("Touch Start %p", item);
}

void HelloWorld::menuItemSettingCallback(Ref* pSender)
{
MenuItem* item = (MenuItem*)pSender;
log("Touch Setting %p", item);
}
```
小提示:这里图片的UI坐标可以通过画图工具或者PhotoShop获得坐标  
##显示效果
![](http://i.imgur.com/cAgqpC1.gif)  

##源代码下载地址：
<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/cocos2d-x/tree/master/20170701/code/Cocos2dSpiritMenu' target='_blank'>点我进行下载</a>】</strong>
</blockquote>

#开关菜单MenulItemToggle
开关菜单有两种状态，这两种状态可以用任何的图片来替代(比如精灵-只要是菜单项就可以)  
函数创建:(也是菜单项)
```C++
static MenulItemToggle* createWithCallback(
const ccMenuCallback& callback,//菜单操作的回调函数指针 - 状态切换时调用的函数,菜单的事件处理
MenuItem* item,//进行切换的菜单项 MenuItem的集合，将其他菜单项放在开关菜单中
...
)
```

简单形式的文本类型的开关菜单:  
```C++
auto toggleMenuItem = MenuItemToggle::createWithCallback(
CC_CALLBACK_1(HelloWorld::menuItem1Callback,this),
MenuItemFont::create("On"),
MenuItemFont::create("Off"),
NULL);//最后记得加NULL(Object-c中区分元素集合的结束)，在开关菜单中，其实只能放两个子菜单项，多菜单项没意义，因为只是两个状态的切换  

Menu* mn=Menu::create(toggleMenuItem,NULL);//把菜单项放入菜单中
this->addChhild(mn);//把菜单放入层中
```  
这里只是简单的文本菜单，当然也可以是精灵菜单，也可以是图片菜单...   

##实例
```C++
bool HelloWorld::init()
{

if (!Layer::init()){
return false;
}

Size visibleSize = Director::getInstance()->getVisibleSize();//大小
Vec2 origin = Director::getInstance()->getVisibleOrigin();//锚点 默认为0.5  0.5

//Sprite* bg = Sprite::create("menu/setting-back.png");
auto bg = Sprite::create("menu/setting-back.png");// auto-自动推断类型
bg->setPosition(Vec2(origin.x+visibleSize.width/2,origin.y+visibleSize.height/2));
this->addChild(bg);

//音效菜单项
auto soundOnMenuItem = MenuItemImage::create("menu/on.png", "menu/on.png");//正常和按下是同一张图片 - 开
auto soundOffMenuItem = MenuItemImage::create("menu/off.png", "menu/off.png");//关
//音效开关菜单项
auto soundToggleMenuItem = MenuItemToggle::createWithCallback(CC_CALLBACK_1(HelloWorld::menuSoundToggleCallback,this),//函数指针
	soundOnMenuItem,soundOffMenuItem,//菜单项集合
	NULL//集合结束
	);
//设置坐标 - UI坐标(原点为左上角)转换为OpenGL坐标(原点为左下角)
soundToggleMenuItem->setPosition(Director::getInstance()->convertToGL(Vec2(818, 220)));

//音乐菜单项 
auto musicOnMenuItem = MenuItemImage::create(
	"menu/on.png",
	"menu/on.png");
auto musicOffMenuItem = MenuItemImage::create(
	"menu/off.png",
	"menu/off.png");
//音乐开关菜单项
auto musicToggleMenuItem = MenuItemToggle::createWithCallback(CC_CALLBACK_1(HelloWorld::menuMusicToggleCallback, this),
	musicOnMenuItem,
	musicOffMenuItem,
	NULL);
musicToggleMenuItem->setPosition(Director::getInstance()->convertToGL(Vec2(818, 362)));

//OK按钮
auto okMenuItem = MenuItemImage::create("menu/ok-up.png", "menu/ok-down.png");
okMenuItem->setPosition(Director::getInstance()->convertToGL(Vec2(600, 510)));

Menu* mn = Menu::create(soundToggleMenuItem, musicToggleMenuItem, okMenuItem, NULL);
mn->setPosition(Vec2::ZERO);
this->addChild(mn);

return true;
}


void HelloWorld::menuSoundToggleCallback(Ref* pSender)
{
log("menuSoundToggleCallback");
}


void HelloWorld::menuMusicToggleCallback(Ref* pSender)
{
log("menuMusicToggleCallback");
}
```
先是创建On和Off图片惨淡项->创建开关菜单->Menu  
Menu 放入 Layer  

##显示效果
![](http://i.imgur.com/lWaN1iT.gif)  


#源代码下载地址：
<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/cocos2d-x/tree/master/20170701/code/Cocos2dToggleMenuItem' target='_blank'>点我进行下载</a>】</strong>
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
