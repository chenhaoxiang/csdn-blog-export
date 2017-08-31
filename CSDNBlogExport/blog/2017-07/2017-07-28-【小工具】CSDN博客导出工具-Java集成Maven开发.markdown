---
layout: post
title: "【小工具】CSDN博客导出工具-Java集成Maven开发"
date: 2017-07-28 02:43:39 +0800
comments: true
categories:❷ Java大学之行,----- ⑦、爬虫,----- ①、Java/Web小项目
tags: [java,csdn博客,maven]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://chenhaoxiang.cn
本文源自【人生之旅_谙忆的博客】


CSDNBlogExport

CSDN博客导出工具

之前一直想把CSDN的博客导入到自己的网站中，可是由于博客比较多，后面受朋友老郭启发，就找了个时间用Java开发了这款小工具。 
Had been trying to CSDN blog into their website, but beca 
---


转载请注明出处：http://chenhaoxiang.cn
本文源自【人生之旅_谙忆的博客】


CSDNBlogExport

CSDN博客导出工具

之前一直想把CSDN的博客导入到自己的网站中，可是由于博客比较多，后面受朋友老郭启发，就找了个时间用Java开发了这款小工具。 
Had been trying to CSDN blog into their website, but beca
<!-- more -->
----------

---
layout: post
title: "【小工具】CSDN博客导出工具-Java集成Maven开发"
date: 2017-07-28 13:38:54 +0800
comments: true
categories: java
tags: [java, maven]
keyword: 陈浩翔, 谙忆, java, maven,CSDN博客导出工具
description:  
---

CSDN博客导出工具  
之前一直想把CSDN的博客导入到自己的网站中，可是由于博客比较多，后面受朋友老郭启发，就找了个时间用Java开发了这款小工具。  
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
#CSDNBlogExport  
CSDN博客导出工具

之前一直想把CSDN的博客导入到自己的网站中，可是由于博客比较多，后面受朋友老郭启发，就找了个时间用Java开发了这款小工具。  
Had been trying to CSDN blog into their website, but because of the blog is more, inspired by my friend guo behind, will find a time this kind of small tools with Java development.  

#only use  
直接下载CSDNBlogExport.7z解压使用即可。   
Direct download CSDNBlogExport.7z decompression can be used.  
![](http://i.imgur.com/H5mMN3E.png)  

![](http://i.imgur.com/MBLoPTU.png)  

经过测试，667篇博客，开50个线程，在54秒左右可以全部导出到文件。  
Tested, 667 blog, open 50 threads, in 54 seconds can all exported to a file.
 
博客文件导出的存储规则是:  
软件运行目录\blog\年-月\年-月-日 博客标题名.markdown   
Blog file exported storage rule is:  
Software running directory/blog/year-month/year-month-day blog title name.markdown  

![](http://i.imgur.com/tWkpxob.png)  

#开发
CSDNBlogExport目录下是完整的程序代码  
使用了WebMagic爬虫框架，本来自己写HttpURLConnection工具类也能实现的，只是比较耗时，偷个小懒，既然别人有更好的工具，为什么不用呢  
技术含量呢，可以说基本没有什么，但是也是花了大半天时间做的。  
中间还遇到部分玩家无法导出博客的情况，因为CSDN对于用户的链接命名分了2种情况，当时写的时候没有发现，是测试别人博客的时候发现的，经过半小时解决了这个问题。  

虽然很想把这个程序完善，但是由于时间限制还是不能做太多事。  
不保证本版本一直能使用下去，如果某天本程序不能使用了(肯定是CSDN对返回的数据进行了处理或者进行了权限控制)，请留言或者联系我QQ:619699629或者邮箱:uifuture@uifuture.com  
我会利用空闲时间跟上csdn对博客的升级，以保证能继续使用  

此版本为1.0版本，希望用的朋友遇到bug，在这里留言或联系我，我会及时修复。

也欢迎朋友加入进来与我一起完善本程序。

本小程序可导出任意CSDN用户的博客，但是仅供学习使用。
免责声明:如果导出博客侵犯他人权益，引起纠纷的，一概与本人无关。


#development  
CSDNBlogExport directory is a complete program code
Used WebMagic crawler frame, original, write their own HttpURLConnection tools can be achieved only takes time, steal a little lazy, now that people have a better tools, why not
Technical content, it was basically have no what, but also spent most of time to do.   
And in case of some players cannot export blog because CSDN links named points to the user for two kinds of circumstances, then write not found, is to test others while on a blog, solved the problem after half an hour.
   
Although very want to send this application is perfect, but due to time constraints or can't do too many things.   
Does not guarantee that this version has been able to use, if one day can't use this program (must be CSDN on the returned data processing or access control), please leave a message or contact me QQ: 619699629 or email: uifuture@uifuture.com  

I will use free time keep up with the CSDN on updating the blog, to ensure that can continue to use  

This version is 1.0 version, hope to meet with friends bug, leave a message or contact me here, I'll repair in time.  
Also welcome friends to join in with me in perfect this procedure.  
This small program can export any CSDN user's blog, but only for the use of learning.  
Disclaimer: if the export blog infringement of rights and interests of others, cause disputes, all has nothing to do with himself.  

#Bug修复记录
2017.7.31：
修复html编辑器写完博客后导出博客不全的bug  
现在版本 v1.1  
感谢CSDN博主<a href="http://blog.csdn.net/zuochao_2013" target='_blank'>[三名狂客]</a>提出的Bug    

2017.8.16：  
进行版本升级，因为CSDN把一个分页的bug给堵上了，原来的版本不能使用，请下载最新版本2.0  
现在版本 v2.0    
感谢CSDN博主<a href="http://blog.csdn.net/u011637069" target='_blank'>[龙腾四海365]</a>提出的Bug   
 
本次bug修复后，时间会延长一点，因为我在里面把分页的线程写死了，50个线程，有兴趣的可以自己扩展。  
经过测试，在输入50线程时，668篇博客的爬取时间为92S。  
![](http://i.imgur.com/XPP3svY.png)

#源代码下载地址：
<blockquote cite='陈浩翔'>
GITHUB项目地址:<strong>【<a href='https://github.com/chenhaoxiang/CSDNBlogExport' target='_blank'>点我进行访问</a>】</strong>
</blockquote>
如果无法访问，请翻墙哦  


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
