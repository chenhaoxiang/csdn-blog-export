---
layout: post
title: "【Web】Java生成中文GIF动态验证码-集成SpringMVC"
date: 2017-03-07 01:17:39 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅
tags: [java,验证码,spring mvc,web]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
说明GIF验证码相对于JPG图片验证码来说，要更难破解一些，加大了破解的代价。 
从昨天到现在，写了一个小小的GIF验证码项目(中文成语)。 
当然，你可以自己修改成字母数字的。我只是单纯的觉得中文验证码的破解代价更高一点~我在这里生成GIF图片的类，用到了国外牛人的三个类，也就是: 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
说明GIF验证码相对于JPG图片验证码来说，要更难破解一些，加大了破解的代价。 
从昨天到现在，写了一个小小的GIF验证码项目(中文成语)。 
当然，你可以自己修改成字母数字的。我只是单纯的觉得中文验证码的破解代价更高一点~我在这里生成GIF图片的类，用到了国外牛人的三个类，也就是:
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>

#说明

GIF验证码相对于JPG图片验证码来说，要更难破解一些，加大了破解的代价。
从昨天到现在，写了一个小小的GIF验证码项目(中文成语)。
当然，你可以自己修改成字母数字的。我只是单纯的觉得中文验证码的破解代价更高一点~

我在这里生成GIF图片的类，用到了国外牛人的三个类，也就是:
AnimatedGifEncoder
LZWEncoder
和NeuQuant，这三个类。

没办法，谁让自己还没有那个本事写出这样的类呢，只能用别人的，不过挺好用飞，大家可以搜索一下这3个类，一下就能搜出源码的。
在这里，我就不贴出这三个类的源码了，需要的，可以在本文最后的项目链接拿整个项目，其中有所有源代码。

本来一开始是写的字母和数字生成的GIF验证码，后来还是改成了汉字成语验证码。

在这里，我并没有用数据库来存储成语，因为重点不在哪里，所以就只是建立了一个静态块来先写入成语。
(如果是实际开发，我可能会这样做：
以便于管理员在后台可以添加成语到验证码成语库，以及可以刷新验证码到成语库中，所以，可以在一个请求方法中操作成语。
如果用来Redis，基本上也是一样，实现同步就行。)

#GIF验证码类

```
package cn.hncu.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/3/6.
 * Time: 下午 8:23.
 * Explain:Gif验证码类
 */
public class GifCaptcha {
    private Font font = new Font("宋体", Font.BOLD, 20); // 字体
    private int width = 160; // 验证码显示长度
    private int height = 40; // 验证码显示高度
    private String word = ""; // 当前的字符串
    private int delay = 100; // 帧延迟 (默认100)
    private int quality = 10;//量化器取样间隔 - 默认是10ms
    private int repeat = 0; // 帧循环次数
    private int minColor =0;//设置随机颜色时，最小的取色范围
    private int maxColor = 255;//设置随机颜色时，最大的取色范围
    private int right = 0; //设置字符最右边的相对位置---相对原始位置 ，默认为0
    private static java.util.List<String> words = new ArrayList<String>();// 所有成语

    //这里应该去数据库中读取成语，然后存储在内存中
    //在实际开发中，应该是可以在后台中添加成语，以及刷新成语到内存中去！利用访问某个方法来实现
    static {
        words.add("一唱一和");
        words.add("一呼百应");
        words.add("一干二净");
        words.add("一举两得");
        words.add("一落千丈");
        words.add("两面三刀");
        words.add("六神无主");
        words.add("千辛万苦");
        words.add("万无一失");
        words.add("拔刀相助");
        words.add("过时黄花");
        words.add("地动山摇");
        words.add("不可多得");
        words.add("沧海一粟");
        words.add("水泄不通");
        words.add("不可计数");
    }

    /**
     * 空参构造函数
     */
    public GifCaptcha() {
    }

    /**
     * 可以设置验证码宽度，高度的构造函数
     * @param width -验证码宽度
     * @param height -验证码高度
     */
    public GifCaptcha(int width, int height) {
        this.width = width;
        this.height = height;
    }
    /**
     *
     * @param width -验证码宽度
     * @param height -验证码高度
     * @param font -字体
     */
    public GifCaptcha(int width, int height,  Font font) {
        this(width, height);
        this.font = font;
    }

    /**
     * @param width -验证码宽度
     * @param height -验证码高度
     * @param font -字体
     * @param delay -帧延迟
     */
    public GifCaptcha(int width, int height, Font font,int delay) {
        this(width, height,font);
        this.delay = delay;
    }

    public Font getFont() {
        return font;
    }

    /**
     * 设置字体
     * @param font
     */
    public void setFont(Font font) {
        this.font = font;
    }

    public int getWidth() {
        return width;
    }
    /**
     * 设置验证码宽度
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * 设置验证码高度
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    public String getWord() {
        return word;
    }

    /**
     * 设置验证码字符
     * @param chars
     */
    public void setWord(String chars) {
        this.word = chars;
    }

    public int getDelay() {
        return delay;
    }

    /**
     * 设置每一帧之间的延迟时间,或改变它的后续帧(适用于最后一帧添加)。
     * @param delay 单位是毫秒
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getQuality() {
        return quality;
    }

    /**
     * 设置图像的颜色量化(转换质量 由GIF规范允许的最大256种颜色)。
     * 低的值(最小值= 1)产生更好的颜色,但处理显著缓慢。
     * 10是默认,并产生良好的颜色而且有以合理的速度。
     * 值更大(大于20)不产生显著的改善速度
     * @param quality 大于1
     */
    public void setQuality(int quality) {
        if(quality<1){
            quality=1;
        }
        this.quality = quality;
    }

    public int getRepeat() {
        return repeat;
    }

    /**
     * 设置GIF帧应该播放的次数。
     * 默认是 0; 0意味着无限循环。
     * 必须在添加的第一个图像之前被调用。
     * @param repeat 必须大于等于0
     */
    public void setRepeat(int repeat) {
        if (repeat>=0) {
            this.repeat = repeat;
        }
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getMaxColor() {
        return maxColor;
    }

    public void setMaxColor(int maxColor) {
        this.maxColor = maxColor;
    }

    public int getMinColor() {
        return minColor;
    }

    public void setMinColor(int minColor) {
        this.minColor = minColor;
    }

    /**
     * 给定一个输出流 输入图片
     * @param os
     */
    public void out(OutputStream os) {
        try {
            AnimatedGifEncoder gifEncoder = new AnimatedGifEncoder();// gif编码类
            //生成字符
            gifEncoder.start(os);
            gifEncoder.setQuality(quality);//设置量化器取样间隔
            gifEncoder.setDelay(delay);//设置帧延迟
            gifEncoder.setRepeat(repeat);//帧循环次数
            BufferedImage frame;
            char[] rands = createWordChar();
            Color fontcolor[] = new Color[word.length()];
            for (int i = 0; i < word.length(); i++) {
                fontcolor[i] = getRandomColor(minColor,maxColor);
            }
            for (int i = 0; i < word.length(); i++) {
                frame = graphicsImage(fontcolor, rands, i);
                gifEncoder.addFrame(frame);
                frame.flush();
            }
            gifEncoder.finish();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                // TODO 异常处理
                e.printStackTrace();
            }
        }

    }

    /**
     * 画随机码图
     *
     * @param fontcolor 随机字体颜色
     * @param strs      字符数组
     * @param flag      透明度使用
     * @return BufferedImage
     */
    private BufferedImage graphicsImage(Color[] fontcolor, char[] strs, int flag) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //或得图形上下文
        Graphics2D g2d=image.createGraphics();
        //Graphics2D g2d = (Graphics2D) image.getGraphics();
        //利用指定颜色填充背景
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        AlphaComposite ac;
        float y = (height >> 1) + (font.getSize() >> 1) ;// 字符的y坐标
        float m = (width-(word.length()*font.getSize()))/word.length();
        float x = m/2;//字符的x坐标
        g2d.setFont(font);
        for (int i = 0; i < word.length(); i++) {
            ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getPellucidity(flag, i));
            g2d.setComposite(ac);
            g2d.setColor(fontcolor[i]);
            g2d.drawOval(Randoms.num(width), Randoms.num(height), Randoms.num(5,30), 5 + Randoms.num(5,30));//绘制椭圆边框
            g2d.drawString(strs[i] + "",x+(font.getSize()+m)*i+right,y);
        }
        g2d.dispose();
        return image;
    }

    /**
     * 获取透明度,从0到1,自动计算步长
     * @return float 透明度
     */
    private float getPellucidity(int i, int j) {
        int num = i + j;
        float r = (float) 1 / word.length(), s = (word.length() + 1) * r;
        return num > word.length() ? (num * r - s) : num * r;
    }


    /**
     * 生成随机字符数组
     * @return 字符数组
     */
    protected char[] createWordChar() {
        word = words.get(Randoms.num(words.size()));
        return word.toCharArray();
    }

    /**
     * 通过给定范围获得随机的颜色
     * @return Color 获得随机的颜色
     */
    protected Color getRandomColor(int min, int max) {
        if (min > 255) {
            min = 255;
        }
        if (max > 255) {
            max = 255;
        }
        if(min<0){
            min=0;
        }
        if(max<0){
            max=0;
        }
        if(min>max){
            min=0;
            max=255;
        }
        return new Color(min + Randoms.num(max - min), min + Randoms.num(max - min), min + Randoms.num(max - min));
    }
}

```
注释没写很多~有点懒~

#请求GIF验证码的Controller类

```
package cn.hncu.controller;

import cn.hncu.utils.GifCaptcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/3/6.
 * Time: 下午 8:26.
 * Explain:演示GIF验证码的控制器
 */
@Controller
public class CaptchaController {
    private Logger logger = LoggerFactory.getLogger(CaptchaController.class);
    /**
     * 获取Gif验证码
     * @param response
     */
    @RequestMapping(value = "gifCaptcha",method= RequestMethod.GET)
    public void getGifCaptcha(HttpServletResponse response,HttpServletRequest request){
        //告诉客户端，输出的格式
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/gif");
        GifCaptcha gifCaptcha =  new GifCaptcha(200,80,new Font("宋体", Font.BOLD, 40),100);
        try {
            gifCaptcha.out(response.getOutputStream());
            logger.info("获取验证码！验证码字符为："+gifCaptcha.getWord());
            HttpSession session = request.getSession(true);
            //存入Session
            session.setAttribute("captchaWord",gifCaptcha.getWord());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("index")
    public String index()    {
        return "index";
    }

}

```
#JSP页面

```
<%--
  Created by IntelliJ IDEA.
  User: 陈浩翔
  Date: 2017/3/6
  Time: 下午 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>演示动态验证码</title>
    <script type="text/javascript">
        var path = "${pageScope.basePath}";
        function changImg() {
            var img = document.getElementById("servletImg");
            var d = new Date();
            var time = d.getTime();//如果没有这个,下面的img.src = path + "gifCaptcha?" + time;不会起作用，因为浏览器的缓存技术，图片可能并不会刷新

            img.src = "";//解决火狐下验证码刷不出的问题
            img.src = path + "gifCaptcha?" + time;
            //?号后面的东西是通过get方式传递的
        }
    </script>
</head>
<body>
演示动态验证码：
<a onclick="javascript:changImg();" href="javascript:void(0);">
    <img id="servletImg" src="gifCaptcha" alt="UIFuture验证码"/>
</a>
</body>
</html>
```

#演示效果

![](http://img.blog.csdn.net/20170306214409430?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

大家其实可以看到，在我点击验证码的时候，有一个小停顿，会显示alt的内容，那是因为我在JS中，2次赋值给img的src属性。
原因是为了解决火狐浏览器显示GIF图的一个问题，如果我不加那个img.src = "";，在刷新验证码2次后，验证码gif图只显示第一帧！也就是变成了静态图~但是接收到的图片其实还是GIF动图。
我加img.src = "";，就只是为了解决火狐上验证码刷新2次后会变成静图的问题，该问题在谷歌浏览器，以及360浏览器上没有出现！

有知道原因的请评论，谢谢

出问题的是下面这样的情况，在第三次点击图片刷新时(此时用的是同一张图片，随机图片出现的问题是一样的，也就是只显示GIF动图的第一帧图片)(火狐浏览器)
![](http://img.blog.csdn.net/20170306222554472?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
谷歌浏览器，360浏览器没有出现该问题。


本篇博客涉及到的源码链接：
<blockquote cite='陈浩翔'>
<strong>【<a href='https://github.com/chenhaoxiang/captcha/tree/master/verificationCode' target='_blank'>-&gt;点击访问源码-&copy;CHX</a>】</strong>
</blockquote>


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
