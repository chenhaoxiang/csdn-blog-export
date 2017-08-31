---
layout: post
title: "【Spring】定时任务详解实例-@Scheduled"
date: 2017-03-27 07:38:50 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具
tags: [spring,实例,博客,框架]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
最近在做项目，时间比较紧张，也有比较久没写博客了。 
现在项目的Redis缓存需要用到定时任务，就学习了一下Spring 的@Scheduled注解。使用起来很简单。这个例子是建立在之前我的一篇博客的实例上面的。 
也就是架好了SSM框架。 
SSM框架博客的链接：
【->点击访问上篇 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
最近在做项目，时间比较紧张，也有比较久没写博客了。 
现在项目的Redis缓存需要用到定时任务，就学习了一下Spring 的@Scheduled注解。使用起来很简单。这个例子是建立在之前我的一篇博客的实例上面的。 
也就是架好了SSM框架。 
SSM框架博客的链接：
【->点击访问上篇
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

最近在做项目，时间比较紧张，也有比较久没写博客了。
现在项目的Redis缓存需要用到定时任务，就学习了一下Spring 的@Scheduled注解。使用起来很简单。

这个例子是建立在之前我的一篇博客的实例上面的。
也就是架好了SSM框架。
SSM框架博客的链接：
<blockquote cite='陈浩翔'>
<strong>【<a href='http://blog.csdn.net/qq_26525215/article/details/54317939' target='_blank'>-&gt;点击访问上篇博客源码-&copy;CHX</a>】</strong>
</blockquote>

首先当然是在Spring的xml配置文件加入task的命名空间
```
xmlns:task="http://www.springframework.org/schema/task"
```
还需要在xsi:schemaLocation中加上:
```
http://www.springframework.org/schema/task
http://www.springframework.org/schema/task/spring-task-3.0.xsd
```
后面的版本可以根据需要修改哦。


Spring扫描注解的配置:
```
 <!-- 包自动扫描 不扫描Controller注解-->
    <context:component-scan base-package="cn.hncu">
        <context:exclude-filter type="annotation"
                                expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
```
不扫描Controller注解的原因是，交给SpringMVC管理Controller了。

定时任务扫描注解:
```
<!-- S 配置定时任务-->
    <task:executor id="executor" pool-size="5" />
    <!--配置线程池-->
    <task:scheduler id="scheduler" pool-size="10" />
    <task:annotation-driven executor="executor" scheduler="scheduler" />
    <!--E 配置定时任务-->
```

#实现类

```
package cn.hncu.task;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/3/27.
 * Time: 下午 1:17.
 * Explain: 定时任务测试类
 */
@Component //把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
public class DemoTask {
    private Logger logger = Logger.getLogger(DemoTask.class);
    @Scheduled(fixedDelay = 5000)//@Scheduled 可以作为一个触发源添加到一个方法中
    //以一个固定延迟时间5秒钟调用一次执行
    // 这个周期是以上一个调用任务的##完成时间##为基准，在上一个任务完成之后，5s后再次执行
    public void demo1(){
        logger.info("定时任务demo1开始......");
        long begin = System.currentTimeMillis();
        //执行你需要操作的定时任务
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("定时任务demo1结束，共耗时：[" + (end-begin)+ "]毫秒");
    }
    @Scheduled(fixedRate  = 5000)
    //以一个固定延迟时间5秒钟调用一次执行
    // 这个周期是以上一个任务##开始时间##为基准，从上一任务开始执行后5s再次调用：
    public void demo2(){
        logger.info("定时任务demo2开始.");
        long begin = System.currentTimeMillis();
        //执行你需要操作的定时任务
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("定时任务demo2结束，共耗时：[" + (end-begin)+ "]毫秒");
    }

    @Scheduled(cron = "0 34 13 * * ?") //如果你需要在特定的时间执行，就需要用到cron 了
    //这里是在每天的13点30分执行一次
    public void demo3(){
        logger.info("定时任务demo3开始.");
        long begin = System.currentTimeMillis();
        //执行你需要操作的定时任务
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("定时任务demo3结束，共耗时：[" + (end-begin)+ "]毫秒");
    }
}

```

上面的源码中有3个方法，前2个方法实现的是每隔5秒运行一次。
demo3方法实现的是在固定每天的某个时间点运行一次。


方法里面的代码，可以根据你的需要来添加执行。

测试类:

```
package cn.hncu;

import cn.hncu.model.User;
import cn.hncu.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Date;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/1/9.
 * Time: 下午 3:33.
 * Explain:
 */
public class MyBatisTest {

    /**
     * 这个before方法在所有的测试方法之前执行，并且只执行一次
     * 所有做Junit单元测试时一些初始化工作可以在这个方法里面进行
     * 比如在before方法里面初始化ApplicationContext和userService
     */
    @Before
    public void before() {
        //使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml", "spring-mybatis.xml");
    }

    /**
     * 测试定时任务的执行
     * @throws InterruptedException
     */
    @Test
    public void testTask() throws InterruptedException {
        System.out.println("开始执行了...");
        Thread.sleep(1000000);
        System.out.println("结束执行了...");
    }

}
;
```

演示结果:

![](http://img.blog.csdn.net/20170327192419931?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


现在讲一下cron表达式：

一个cron表达式有至少6个（也可能7个）有空格分隔的时间元素。
```
 按顺序依次为
      1 秒（0~59）
      2 分钟（0~59）
      3 小时（0~23）
      4 天（0~31）
      5 月（0~11）
      6 星期（1~7 1为SUN-依次为SUN，MON，TUE，WED，THU，FRI，SAT）
      7.年份（1970－2099）
```

```
其中每个元素可以是一个值(如6),一个连续区间(9-12),一个间隔时间(8-18/4)(/表示每隔4小时),一个列表(1,3,5),通配符。
由于"月份中的日期"和"星期中的日期"这两个元素互斥的,必须要对其中一个设置?.
       0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
       0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
       0 0 12 ? * WED 表示每个星期三中午12点
       "0 0 12 * * ?" 每天中午12点触发
       "0 15 10 ? * *" 每天上午10:15触发
       "0 15 10 * * ?" 每天上午10:15触发
       "0 15 10 * * ? *" 每天上午10:15触发
       "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
       "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
       "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
       "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
       "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
       "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
       "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
       "0 15 10 15 * ?" 每月15日上午10:15触发
       "0 15 10 L * ?" 每月最后一日的上午10:15触发
       "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
       "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
       "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
       有些子表达式能包含一些范围或列表
       例如：子表达式（天（星期））可以为 “MON-FRI”，“MON，WED，FRI”，“MON-WED,SAT”
       “*”字符代表所有可能的值
       “/”字符用来指定数值的增量
       例如：在子表达式（分钟）里的“0/15”表示从第0分钟开始，每15分钟
                在子表达式（分钟）里的“3/20”表示从第3分钟开始，每20分钟（它和“3，23，43”）的含义一样
       “？”字符仅被用于天（月）和天（星期）两个子表达式，表示不指定值
       当2个子表达式其中之一被指定了值以后，为了避免冲突，需要将另一个子表达式的值设为“？”
       “L” 字符仅被用于天（月）和天（星期）两个子表达式，它是单词“last”的缩写
       如果在“L”前有具体的内容，它就具有其他的含义了。例如：“6L”表示这个月的倒数第６天
       注意：在使用“L”参数时，不要指定列表或范围，因为这会导致问题
       W 字符代表着平日(Mon-Fri)，并且仅能用于日域中。它用来指定离指定日的最近的一个平日。
       大部分的商业处理都是基于工作周的，所以 W 字符可能是非常重要的。
假如15号是星期六，那么 trigger 会在14号(星期五)触发，因为星期四比星期一离15号更近。
       C：代表“Calendar”的意思。它的意思是计划所关联的日期，如果日期没有被关联，则相当于日历中所有日期。
       例如5C在日期字段中就相当于日历5日以后的第一天。1C在星期字段中相当于星期日后的第一天。
```

| 字段  | 允许值   | 允许的特殊字符 |
| ------------- |:-------------:| -----:|
|  秒 | 0-59 |  , - * / |
| 分 | 0-59| , - * / |
|  小时 |  0-23 |  , - * / |
|  日期 |  1-31 | , - * ? / L W C |
|  月份           | 1-12 或者 JAN-DEC| , - * /|
|  星期           | 1-7 或者 SUN-SAT| , - * ? / L C #|
|  年（可选）| 留空, 1970-2099 | , - * /|



SSM框架加本实例源码的链接：
<blockquote cite='陈浩翔'>
<strong>【<a href='https://github.com/chenhaoxiang/S3S3M3/tree/master/S3S3M3' target='_blank'>-&gt;点击访问本篇源码-&copy;CHX</a>】</strong>
</blockquote>



本文章由<a href="https://chenhaoxiang.github.io/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
