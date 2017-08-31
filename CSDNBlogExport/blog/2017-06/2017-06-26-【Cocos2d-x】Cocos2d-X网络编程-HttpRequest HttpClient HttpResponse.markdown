---
layout: post
title: "【Cocos2d-x】Cocos2d-X网络编程-HttpRequest HttpClient HttpResponse"
date: 2017-06-26 08:53:52 +0800
comments: true
categories:cocos2d-x
tags: [网络编程,cocos2d-x]
keyword: 陈浩翔, 谙忆
description: Cocos2d-x封装了3个类来处理HTTP请求： 
HttpRequest,HttpClient和HttpResponse.  使用HttpRequest,HttpClient和HttpResponse这3个类进行Http进行请求时，需要遵循一定流程  请求过程: 
1.创建HttpRequest的实例。 
2.设置请求方式，Get、Post等。(千万不要以为只有get和post方式哦,这是一般新 
---


Cocos2d-x封装了3个类来处理HTTP请求： 
HttpRequest,HttpClient和HttpResponse.  使用HttpRequest,HttpClient和HttpResponse这3个类进行Http进行请求时，需要遵循一定流程  请求过程: 
1.创建HttpRequest的实例。 
2.设置请求方式，Get、Post等。(千万不要以为只有get和post方式哦,这是一般新
<!-- more -->
----------

---
layout: post
title: "【Cocos2d-x】Cocos2d-X网络编程-HttpRequest/HttpClient/HttpResponse"
date: 2017-05-31 13:38:54 +0800
comments: true
categories: Cocos2dx
tags: [Cocos2dx]
keyword: 陈浩翔, 谙忆, C++, Cocos2d-x ,Cocos2d-X网络编程
description: Cocos2d-x封装了3个类来处理HTTP请求：HttpRequest,HttpClient和HttpResponse. 使用HttpRequest,HttpClient和HttpResponse这3个类进行Http进行请求时，需要遵循一定流程  
---

Cocos2d-x封装了3个类来处理HTTP请求：  
HttpRequest,HttpClient和HttpResponse.  

使用HttpRequest,HttpClient和HttpResponse这3个类进行Http进行请求时，需要遵循一定流程  
 
<!-- more -->
----------

请求过程:   
1.创建HttpRequest的实例。  
2.设置请求方式，Get、Post等。(千万不要以为只有get和post方式哦,这是一般新手以为的,只是其他请求方式我们平时用到的很少)  
3.设置请求地址和发送的数据(如果没有发送的数据，可不设置发送数据)。  
4.设置响应回调函数，在回调函数中处理获取的数据。  
5.创建HttpClient实例，发送请求。  
6.释放请求连接。 

#使用Cocos2d封装的HttpRequest设置请求信息
HttpRequest：  
是一种数据类型，它提供了一些方法用来定义或获取HTTP请求的参数，  
常用方法包括下面几种:  
设置请求连接  
void setUrl(const char * url);  
设置请求类型  
void setRequestType(Type type);  

这里的Type是Cocos2d-x定义的一个枚举类型，包括5种类型。  
源码:  
```C++
class CC_DLL HttpRequest : public Ref
{
public:
    /**
     * The HttpRequest type enum used in the HttpRequest::setRequestType.
     */
    enum class Type
    {
        GET,
        POST,
        PUT,
        DELETE,
        UNKNOWN,
    };
...
}
```
设置回调函数:  
void setResponseCallback(Ref* pTarget,SEL_HttpResponse pSelector);  

设置请求的数据，参数buffer是提交的数据，len是请求数据的长度(使用发送数据的实际长度):  
void setRequestData(const char* buffer,unsigned int len);  

头文件和命名空间:
```c++ 头文件和命名空间
#include "network/HttpRequest.h" //1
using namespace cocos2d::network; //2
```
完整的Request对象创建
```c++ 完整的Request对象创建
	auto request = new HttpRequest();
	//设置请求网址
	request->setUrl("请填写你需要请求的网址");
	//设置请求类型
	request->setRequestType(HttpRequest::Type::GET);
	//设置请求的数据
	char data[50] = "data";
	request->setRequestData(data,strlen(data));
```


#使用Cocos2d封装的HttpClient发送请求

HttpClient:
 用来控制请求相关的参数，比如发送请求，设置请求超时时间。  
它使用单例模型。 这一模式的目的是使得类的一个对象成为系统中的唯一实例。  
cocos2d中多处用到这一模型。  
比如Director对象，创建Director::getInstance().获取的都是同一个对象，方便统一管理  
又比如，音频处理对象： SimpleAudioEngine::getInstance();  

常用方法  
发送请求：
send(HttpRequest* request)  
设置连接超时时间:  
setTimeoutForConnect(int value)  

```C++ 头文件和命名空间
#include "network/HttpClient.h"
using namespace cocos2d::network; //2

```

``` C++ 创建HttpClient对象
	//创建HttpClient对象
	auto client = HttpClient::getInstance();//getInstance静态成员函数-单例模式模型
	client->setTimeoutForConnect(60);//当客户端向服务端发送请求超过这个时间，就会返回一个错误信息
	client->setTimeoutForRead(100);//接收数据的读取时间
	client->send(request);
```

#使用Cocos2d封装的HttpResponse处理返回的结果

HttpResponse:  
包含服务器返回的数据等信息。使用HttpResponse提供的方法可以获取这些数据。  
常用方法：  
std::vector<char> * getResponseData();  
获取请求返回的数据 -返回的是一个char型的数组   

getResponseState  
获取服务器返回的状态，返回值是一个整数，200表示请求成功，400表示服务器错误，404表示服务器上找不到相应的文件。  
  
issucced(),用来判断是否返回成功。  

```c++ 实现回调函数
//实现回调函数
void HelloWorld::complete(HttpClient *client, HttpResponse *response){
	//使用HttpResponse类的相关函数，获取状态和数据
	log("response code is:%d",response->getResponseCode());//获取请求返回的状态码
	if (response->isSucceed()){//判断返回是否成功  成功就返回true
		std::vector<char> * data = response->getResponseData();
		log("response data is:");
		//for (int i = 0; i < data->size(); i++){
		//	log("%c",(*data)[i]);
		//	//因为data是一个指针，所以需要取内容操作符，(*data)这样获取的就是数组的首地址，然后再加上角标
		//}
	}

	else{
		log("error msg is:%s", response->getErrorBuffer()); // getErrorBuffer-会返回请求数据错误的信息
	}

}

```

#完整源代码下载地址：
<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/cocos2d-x/tree/master/20170531/httpTest' target='_blank'>点我进行下载</a>】</strong></p>
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
