---
layout: post
title: "【代码管理】GitHub超详细图文攻略 - Git客户端下载安装 GitHub提交修改源码工作流程 Git分支 标签 过滤 Git版本工作流"
date: 2016-08-22 01:07:18 +0800
comments: true
categories:❻ 其他,----- 好文/知识点
tags: [github,git,管理]
keyword: 陈浩翔, 谙忆
description: 找到一篇很详细的Git教程，真的很不错，推荐！！！


GitHub操作总结 : 总结看不明白就看下面的详细讲解.

.
作者 :万境绝尘 
.

GitHub操作流程 :


第一次提交 :  
方案一 : 本地创建项目根目录, 然后与远程GitHub关联, 之后的操作一样;
-- 初始化git仓库 :git init ;
-- 提交改变到缓存 :git commi 
---


找到一篇很详细的Git教程，真的很不错，推荐！！！


GitHub操作总结 : 总结看不明白就看下面的详细讲解.

.
作者 :万境绝尘 
.

GitHub操作流程 :


第一次提交 :  
方案一 : 本地创建项目根目录, 然后与远程GitHub关联, 之后的操作一样;
-- 初始化git仓库 :git init ;
-- 提交改变到缓存 :git commi
<!-- more -->
----------


<p><span style="font-family:Courier New"><strong><br>
找到一篇很详细的Git教程，真的很不错，推荐！！！</strong></span></p>
<p><span style="font-family:Courier New"><strong><br>
</strong></span></p>
<p><span style="font-family:Courier New"><strong>GitHub操作总结 : 总结看不明白就看下面的详细讲解.</strong></span></p>
<p><span style="font-family:Courier New"></span></p>
<p><span style="font-family:'Courier New'">.</span></p>
<p><span style="font-family:'Courier New'"><span style="background-color:rgb(255,255,0)"><strong><span style="color:#ff00">作者</span></strong>&nbsp;:<strong><span style="color:#3333ff">万境绝尘&nbsp;</span></strong></span></span></p>
<p><span style="font-family:'Courier New'">.</span></p>
<br>
<p><span style="font-family:Courier New"><strong><span style="color:#330033">GitHub操作流程</span></strong> :</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">第一次提交</span></strong> : &nbsp;</span></p>
<p><span style="font-family:Courier New"><strong>方案一</strong> : <strong><span style="color:#cc33cc">本地创建项目根目录, 然后与远程GitHub关联, 之后的操作一样</span></strong>;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">初始化git仓库</span></strong> :<span style="color:#ffff00; background-color:rgb(0,0,0)"><strong>git init</strong></span> ;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">提交改变到缓存</span></strong> :<span style="color:#ffff00; background-color:rgb(0,0,0)"><strong>git commit -m 'description'</strong></span> ;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">本地git仓库关联GitHub仓库</span></strong> :&nbsp;<span style="color:#ffff00; background-color:rgb(0,0,0)"><strong>git remote add origin git@github.com:han1202012/TabHost_Test.git</strong></span>
 ;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">提交到GitHub中</span></strong> :&nbsp;<strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git push -u origin master</span></strong> ;</span></p>
<p><span style="font-family:Courier New"><strong>方案二 </strong>: <strong><span style="color:#cc33cc">方案二就是不用关联GitHub仓库, 直接从GitHub冲克隆源码到本地, 项目根目录也不用创建</span></strong>;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">从GitHub上克隆项目到本地</span></strong> :<strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git clone&nbsp;git@github.com:han1202012/NDKHelloworld.git</span></strong> , 注意克隆的时候直接在仓库根目录即可,
 不用再创建项目根目录 ;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">添加文件</span></strong> :<strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git add ./*</span></strong> , 将目录中所有文件添加;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">提交缓存</span></strong> :<strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git commit -m '提交'</span></strong>;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">提交到远程GitHub仓库</span></strong> :&nbsp;<span style="font-family:'Courier New'"><strong><span style="color:#ffff0; background-color:rgb(0,0,0)">git push -u origin master</span></strong></span><span style="font-family:'Courier New'">&nbsp;;</span></span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">之后修改提交</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">与GitHub远程仓库同步</span></strong> :<strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git pull</span></strong> ;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">查看文件变更</span></strong> :&nbsp;<strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git status</span></strong> ;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">提交代码到本地缓存</span></strong> :&nbsp;<span style="font-family:'Courier New'"><strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git commit -m 'description'</span></strong>;</span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'">--<strong><span style="color:#3333ff">提交代码到远程GitHub仓库</span></strong> :<strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git push</span></strong> ;</span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'"><br>
</span></span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">.gitignore用法</span></strong> : 开放模式 注明忽略的文件 直接列出文件名, 保守模式 注明保留的文件 !文件名 ;</span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'"><br>
</span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'"><strong><span style="color:#ff0000">Git标签操作</span></strong> : 轻量级标签, 带注释标签;</span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'">--<strong><span style="color:#3333ff">查看标签</span></strong> :<strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git tag</span></strong> ;</span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'">--<strong><span style="color:#3333ff">添加标签</span></strong> : 轻量级标签<strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git tag tagName</span></strong> , 带注释标签<strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git
 tag -a tagName -m 'description'</span></strong> ;</span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'">--<strong><span style="color:#3333ff">删除标签</span></strong> :<strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git tag -d tagName</span></strong> ;</span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'">--<strong><span style="color:#3333ff">提交标签到GitHub中</span></strong> :&nbsp;<span style="font-family:Consolas,'Courier New',Courier,mono,serif; line-height:18px"><strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git&nbsp;push&nbsp;origin&nbsp;--tags</span></strong>
 ;</span></span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'"><span style="font-family:Consolas,'Courier New',Courier,mono,serif; line-height:18px"><br>
</span></span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'"><span style="font-family:Consolas,'Courier New',Courier,mono,serif; line-height:18px"><strong><span style="color:#ff0000">Git分支操作</span></strong>: 创建分支后, 分支操作不会影响master分支, 但是master分支改变会影其它分支;</span></span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'"><span style="font-family:Consolas,'Courier New',Courier,mono,serif; line-height:18px">--<strong><span style="color:#3333ff">列出分支</span></strong> :<strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git
 branch</span></strong> ;</span></span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'"><span style="font-family:Consolas,'Courier New',Courier,mono,serif; line-height:18px">--<strong><span style="color:#3333ff">切换分支</span></strong> :<strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git
 checkout master</span></strong> ;</span></span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'"><span style="font-family:Consolas,'Courier New',Courier,mono,serif; line-height:18px">--<strong><span style="color:#3333ff">提交分支</span></strong> :&nbsp;<span style="font-family:Consolas,'Courier New',Courier,mono,serif; line-height:18px"><strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git&nbsp;push&nbsp;origin
 branchName</span></strong> ;</span></span></span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'"><span style="font-family:Consolas,'Courier New',Courier,mono,serif; line-height:18px"><span style="font-family:Consolas,'Courier New',Courier,mono,serif; line-height:18px">--<strong><span style="color:#3333ff">删除分支</span></strong>
 : <strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git branch -d branchName</span></strong> , 强制删除分支&nbsp;<span style="font-family:Consolas,'Courier New',Courier,mono,serif; line-height:18px"><strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git
 branch -D branchName</span></strong> ;</span></span></span></span></span></p>
<p><span style="font-family:Courier New"><span style="font-family:'Courier New'"><span style="font-family:Consolas,'Courier New',Courier,mono,serif; line-height:18px"><span style="font-family:Consolas,'Courier New',Courier,mono,serif; line-height:18px">--<strong><span style="color:#3333ff">合并分支</span></strong>
 : <strong><span style="color:#ffff00; background-color:rgb(0,0,0)">git merge branchName</span></strong> ;</span></span></span></span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New">.</span></p>
<h1><a target="_blank" name="t0"></a><span style="font-family:Courier New">一. Git介绍</span></h1>
<p><br>
</p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">分布式</span></strong> : Git版本控制系统是一个<strong><span style="color:#3333ff">分布式的系统</span></strong>, 是用来保存工程源代码历史状态的命令行工具;</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">保存点</span></strong> : Git的保存点可以<strong><span style="color:#3333ff">追踪源码中的文件</span></strong>, 并能得到某一个时间点上的整个工程项目额状态; 可以在该保存点将多人提交的源码合并, 也可以会退到某一个保存点上;</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">Git离线操作性</span></strong> :<strong><span style="color:#3333ff">Git可以离线进行代码提交</span></strong>, 因此它称得上是完全的分布式处理,&nbsp;<span style="font-family:'Courier New'">Git所有的操作<strong><span style="color:#3333ff">不需要在线进行</span></strong>;</span>
 这意味着Git的速度要比SVN等工具快得多, &nbsp;因为SVN等工具需要在线时才能操作, 如果网络环境不好, 提交代码会变得非常缓慢;&nbsp;</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">Git基于快照</span></strong> : SVN等老式版本控制工具是<strong><span style="color:#3333ff">将提交点保存成补丁文件</span></strong>, Git提交是将<strong><span style="color:#3333ff">提交点指向提交时的项目快照</span></strong>, 提交的东西包含一些元数据(作者,
 日期, GPG等);</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">Git的分支和合并</span></strong> : 分支模型是Git最显著的特点, 因为这改变了开发者的开发模式, SVN等版本控制工具将每个分支都要放在不同的目录中, Git可以在同一个目录中切换不同的分支;</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">分支即时性</span></strong> : 创建和切换分支几乎是同时进行的, 用户可以上传一部分分支, 另外一部分分支可以隐藏在本地, 不必将所有的分支都上传到GitHub中去;</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">分支灵活性</span></strong> : 用户可以<strong><span style="color:#3333ff">随时 创建 合并 删除分支</span></strong>, 多人实现不同的功能, 可以创建多个分支进行开发, 之后进行分支合并, 这种方式使开发变得快速, 简单, 安全;</span></p>
<p><br>
</p>
<h1><a target="_blank" name="t1"></a><span style="font-family:Courier New">二. Git通用客户端(msysgit)</span></h1>
<p><span style="font-family:Courier New"><br>
</span></p>
<h2><a target="_blank" name="t2"></a><span style="font-family:Courier New">1. 下载Git客户端</span></h2>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">Git客户端下载地址</span></strong> :<a target="_blank" target="_blank" href="https://code.google.com/p/msysgit/downloads/list">https://code.google.com/p/msysgit/downloads/list</a> 将地址复制到浏览器栏即可下载.<br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<h2><a target="_blank" name="t3"></a><span style="font-family:Courier New">2. 安装Git客户端</span></h2>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">欢迎界面</span></strong> : 直接下一步;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127131250906" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">协议</span></strong> : 必须接受;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127131306500" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">安装位置</span></strong> : 预留100M空间, 自定义安装位置;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127131319453" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">选择安装组件</span></strong> :<strong><span style="color:#6600cc">也可以默认选择</span></strong>;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">图标组件</span></strong>(Addition icons) : 选择是否创建快速启动栏图标 或者 是否创建桌面快捷方式;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">桌面浏览</span></strong>(Windows Explorer integration) : 浏览源码的方法, 单独的上下文浏览 只使用bash 或者 只用Git GUI工具; 高级的上下文浏览方法 使用git-cheetah plugin插件;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">关联配置文件</span></strong> : 是否关联git配置文件, 该配置文件主要显示文本编辑器的样式;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">关联shell脚本文件</span></strong> : 是否关联Bash命令行执行的脚本文件;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">使用TrueType编码</span></strong> : 在命令行中是否使用TruthType编码, 该编码是微软和苹果公司制定的通用编码;&nbsp;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127132319062" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">开始菜单快捷方式目录</span></strong> : 设置开始菜单中快捷方式的目录名称, 也可以选择<strong><span style="color:#cc33cc">不再开始菜单中创建快捷方式</span></strong>;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127133217750" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">设置环境变量</span></strong> : 选择使用什么样的命令行工具, 一般情况下我们<strong><span style="color:#3333ff">默认使用Git Bash即可, 默认选择</span></strong>;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">Git自带</span></strong> : 使用Git自带的Git Bash命令行工具;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">系统自带CMD</span></strong> : 使用Windows系统的命令行工具;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">二者都有</span></strong> : 上面二者同时配置, 但是注意, 这样会将windows中的find.exe 和 sort.exe工具覆盖, 如果不懂这些尽量不要选择;&nbsp;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127133754968" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">选择换行&#26684;式</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">检查出windows&#26684;式转换为unix&#26684;式</span></strong> : 将windows&#26684;式的换行转为unix&#26684;式的换行在进行提交;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">检查出原来&#26684;式转为unix&#26684;式</span></strong> : 不管什么&#26684;式的, 一律转为unix&#26684;式的换行在进行提交;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">不进行&#26684;式转换</span></strong> : 不进行转换, 检查出什么, 就提交什么;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127140258109" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New">开始安装 :&nbsp;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127140356218" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New">安装结束 : over;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127140436812" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<h2><a target="_blank" name="t4"></a><span style="font-family:Courier New">3. 配置GitHub</span></h2>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">修改Git Bash的配置 :</span></strong>&nbsp;将Git Bash设置为<strong><span style="color:#6600cc">快速编辑模式</span></strong>, 可以更好的使用该命令行工具 :&nbsp;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127142344843" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<h3><a target="_blank" name="t5"></a><span style="font-family:Courier New">(1) 创建本地ssh</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">使用命令</span></strong> : 创建本地ssh</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>ssh-keygen&nbsp;-t&nbsp;rsa&nbsp;-C&nbsp;&quot;13241153187@163.com&quot;&nbsp;&nbsp;</span></span></li></ol>
</div>
<strong><span style="color:#ff0000">GitHub邮箱</span></strong> : 该命令后面的邮箱就是GitHub的注册邮箱
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">路径选择</span></strong> : 使用该命令之后, 会出现提示选择ssh-key生成路径, 这里直接点回车默认即可, 生成的ssh-key在默认路径中;</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">密码确认</span></strong> : 这里我们不使用密码进行登录, 用密码太麻烦;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127142929718" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<h3><a target="_blank" name="t6"></a><span style="font-family:Courier New">(2) 将ssh配置到GitHub中</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">进入生成的ssh目录</span></strong> :&nbsp;C:\Documents and Settings\Administrator\.ssh 中, 使用记事本打开&nbsp;id_rsa.pub 文件, 将该文件中的内容复制;</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">id_rsa.pub 文件内容</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>ssh-rsa&nbsp;AAAAB3NzaC1yc2EAAAABIwAAAQEAtT1YCeaNulpfC&#43;ARqAWrCdfpi6CpW3gkGT0hp6Q8by7NnEfy4dah9CwSrNbWJH5eS4tiqckE&#43;bdbSVNvAboFD1MtGZjtzE4GDweG/6J/SDYV/ADFN/RLWGb&#43;5rQ8wMCjc/fODgLJDFxk1Fwk/TTqTcbtLab1toLcts3zGIW5DstA3RQ0CCX/sPew5m7vh7DcKXluj2TBd9hw==&nbsp;13241153187@163.com&nbsp;&nbsp;</span></span></li></ol>
</div>
<br>
<strong><span style="color:#ff0000">进入GitHub网站</span></strong> : 登录GitHub, 选择Account Setting 用户设置 :&nbsp;
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127143438453" alt=""><br>
<br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">选择左侧的SSH-KEY选项</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127143549718" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">点击右侧的Add SSH key</span></strong> :</span></p>
<p><span style="font-family:Courier New">&nbsp;<img src="http://img.blog.csdn.net/20140127143656390" alt=""></span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">将上面复制好的ssh-key复制进去</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127143818125" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">验证是否配置成功</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#3333ff">使用命令</span></strong> :&nbsp;</span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>ssh&nbsp;-T&nbsp;git@github.com&nbsp;&nbsp;</span></span></li></ol>
</div>
<p><span style="font-family:Courier New"><strong><span style="color:#3333ff">成功提示</span></strong> :&nbsp;</span><span style="font-family:Courier New">如果出现Hi han1202012! You've successfully authenticated, but GitHub does not provide shell access. 就说明配置成功, 可以连接上GitHub;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127144236984" alt=""><br>
</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<h3><a target="_blank" name="t7"></a><span style="font-family:Courier New">(3) 配置本地用户和邮箱</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">用户名邮箱作用</span></strong> : 我们需要设置一个用户名 和 邮箱, 这是用来上传本地仓库到GitHub中, 在GitHub中显示代码上传者;</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">使用命令</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_java">
<div class="bar">
<div class="tools"><strong>[java]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol class="dp-j" start="1">
<li class="alt"><span><span>git&nbsp;config&nbsp;--global&nbsp;user.name&nbsp;</span><span class="string">&quot;HanShuliang&quot;</span><span>&nbsp;</span><span class="comment">//设置用户名</span><span>&nbsp;&nbsp;</span></span></li><li><span>git&nbsp;config&nbsp;--global&nbsp;user.email&nbsp;<span class="string">&quot;13241153187@163.com&quot;</span><span>&nbsp;&nbsp;</span><span class="comment">//设置邮箱</span><span>&nbsp;&nbsp;</span></span></li></ol>
</div>
<br>
<img src="http://img.blog.csdn.net/20140127144927062" alt=""><br>
<p><span style="font-family:Courier New"><br>
</span></p>
<h2><a target="_blank" name="t8"></a><span style="font-family:Courier New">4. Git Bash提交源码到GitHub</span></h2>
<p><span style="font-family:Courier New"><br>
</span></p>
<h3><a target="_blank" name="t9"></a><span style="font-family:Courier New">(1) GitHub中创建一个工程</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">工程的https地址</span></strong>:&nbsp;https://github.com/han1202012/TabHost_Test.git .</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">工程的SSH地址</span></strong> :&nbsp;git@github.com:han1202012/TabHost_Test.git .</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">GitHub提示生成的命令</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New">--&nbsp;Create a new repository on the command line :&nbsp;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>touch&nbsp;README.md&nbsp;&nbsp;</span></span></li><li><span>git&nbsp;init&nbsp;&nbsp;</span></li><li class="alt"><span>git&nbsp;add&nbsp;README.md&nbsp;&nbsp;</span></li><li><span>git&nbsp;commit&nbsp;-m&nbsp;&quot;first&nbsp;commit&quot;&nbsp;&nbsp;</span></li><li class="alt"><span>git&nbsp;remote&nbsp;add&nbsp;origin&nbsp;git@github.com:han1202012/TabHost_Test.git&nbsp;&nbsp;</span></li><li><span>git&nbsp;push&nbsp;-u&nbsp;origin&nbsp;master&nbsp;&nbsp;</span></li></ol>
</div>
<br>
--&nbsp;Push an existing repository from the command line :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;remote&nbsp;add&nbsp;origin&nbsp;git@github.com:han1202012/TabHost_Test.git&nbsp;&nbsp;</span></span></li><li><span>git&nbsp;push&nbsp;-u&nbsp;origin&nbsp;master&nbsp;&nbsp;</span></li></ol>
</div>
<br>
<br>
<h3><a target="_blank" name="t10"></a><span style="font-family:Courier New">(2) 初始化git目录</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New">使用命令 :&nbsp;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;init&nbsp;&nbsp;</span></span></li></ol>
</div>
<br>
<span style="font-family:Courier New"><strong><span style="color:#cc33cc">如果不执行这条命令, 就会出现错误</span></strong> : fatal: Not a git repository (or any of the parent directories): .git&nbsp;.</span>
<p><span style="font-family:Courier New"><br>
</span></p>
<h3><a target="_blank" name="t11"></a><span style="font-family:Courier New">(3) 添加文件</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New">使用命令 :&nbsp;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;add&nbsp;./*&nbsp;&nbsp;</span></span></li></ol>
</div>
<p><span style="font-family:Courier New"><br>
</span></p>
<span style="font-family:Courier New">可能会报出一些警告, 不用理会 :&nbsp;</span>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>warning:&nbsp;LF&nbsp;will&nbsp;be&nbsp;replaced&nbsp;by&nbsp;CRLF&nbsp;in&nbsp;AndroidManifest.xml.&nbsp;&nbsp;</span></span></li><li><span>The&nbsp;file&nbsp;will&nbsp;have&nbsp;its&nbsp;original&nbsp;line&nbsp;endings&nbsp;in&nbsp;your&nbsp;working&nbsp;directory.&nbsp;&nbsp;</span></li><li class="alt"><span>warning:&nbsp;LF&nbsp;will&nbsp;be&nbsp;replaced&nbsp;by&nbsp;CRLF&nbsp;in&nbsp;bin/AndroidManifest.xml.&nbsp;&nbsp;</span></li><li><span>The&nbsp;file&nbsp;will&nbsp;have&nbsp;its&nbsp;original&nbsp;line&nbsp;endings&nbsp;in&nbsp;your&nbsp;working&nbsp;directory.&nbsp;&nbsp;</span></li><li class="alt"><span>warning:&nbsp;LF&nbsp;will&nbsp;be&nbsp;replaced&nbsp;by&nbsp;CRLF&nbsp;in&nbsp;gen/shuliang/han/tabhost_test/BuildConfig.java.&nbsp;&nbsp;</span></li></ol>
</div>
<br>
<span style="font-family:Courier New">将仓库中的所有文件添加到缓存中;</span>
<p><span style="font-family:Courier New"><br>
</span></p>
<h3><a target="_blank" name="t12"></a><span style="font-family:Courier New">(4) 提交缓存</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New">使用命令 :&nbsp;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;remote&nbsp;add&nbsp;origin&nbsp;git@github.com:han1202012/TabHost_Test.git&nbsp;&nbsp;</span></span></li></ol>
</div>
<br>
<span style="font-family:Courier New">将添加或者改变的内容提交到缓存中;</span>
<p><span style="font-family:Courier New"><br>
</span></p>
<h3><a target="_blank" name="t13"></a><span style="font-family:Courier New">(5) 将Git本地缓存提交到GitHub中</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New">使用命令 :&nbsp;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;push&nbsp;-u&nbsp;origin&nbsp;master&nbsp;&nbsp;</span></span></li></ol>
</div>
<br>
<p><span style="font-family:Courier New">执行该命令, 源码就被提交到了GitHub 中;</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"></span></p>
<p><span style="font-family:'Courier New'">.</span></p>
<p><span style="font-family:'Courier New'"><span style="background-color:rgb(255,255,0)"><strong><span style="color:#ff00">作者</span></strong>&nbsp;:<strong><span style="color:#3333ff">万境绝尘&nbsp;</span></strong></span></span></p>
<p><span style="font-family:'Courier New'"><span style="background-color:rgb(255,255,0)"><strong><span style="color:#993399">转载请注明出处 :&nbsp;<a target="_blank" target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279">http://blog.csdn.net/shulianghan/article/details/18812279</a></span></strong></span></span></p>
<p><span style="font-family:'Courier New'">.</span></p>
<br>
<h1><a target="_blank" name="t14"></a><span style="font-family:Courier New">三. Git的一些用法</span></h1>
<p><span style="font-family:Courier New"><br>
</span></p>
<h2><a target="_blank" name="t15"></a><span style="font-family:Courier New">1. .gitignore文件</span></h2>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">屏蔽文件</span></strong> : .gitignore文件是告诉Git哪些目录或者文件需要忽略, 这些文件将不被提交;&nbsp;</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">常用场景</span></strong> : 写完代码后会执行变异调试等操作, 使用 .gitignore 文件将这些编译后的文件屏蔽, 这些文件不需要Git工具进行管理;</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">Android中的.gitignore</span></strong> : 在Android中 bin 和 gen 两个目录可以忽略;</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">.gitignore位置</span></strong> : 项目根目录下;</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">过滤模式</span></strong> : Git中的 .gitignore 中有两种模式,<strong><span style="color:#3333ff">开放模式</span></strong> 和<strong><span style="color:#3333ff">保守模式</span></strong>,<strong><span style="color:#6600cc">保守模式的优先级要高于开放模式</span></strong>;</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">开放模式</span></strong> : 设置哪些文件 活 目录 被过滤, 凡是在文件中列出的文件或者目录都要被过滤掉;</span></p>
<p><span style="font-family:'Courier New'">-- <strong><span style="color:#3333ff">过滤目录</span></strong> : /bin/ 就是将bin目录过滤, 该文件下的所有目录和文件都不被提交;</span></p>
<p><span style="font-family:'Courier New'">-- <strong><span style="color:#3333ff">过滤某个类型文件</span></strong> : *.zip *.class 就是过滤zip 和 class 后缀的文件, 这些文件不被提交;</span></p>
<p><span style="font-family:'Courier New'">-- <strong><span style="color:#3333ff">过滤指定文件</span></strong> : /gen/R.java, 过滤该文件, 该文件不被提交;</span></p>
<p><span style="font-family:'Courier New'"><br>
</span></p>
<p><span style="font-family:'Courier New'"><strong><span style="color:#ff0000">保守模式</span></strong> : 设置哪些文件不被过滤, 凡是列在其中的文件都要完整的提交上去;</span></p>
<p><span style="font-family:'Courier New'">-- <strong><span style="color:#3333ff">跟踪目录</span></strong> : !/src , 该目录下的所有文件都要被提交;</span></p>
<p><span style="font-family:'Courier New'">-- <strong><span style="color:#3333ff">跟踪某类文件</span></strong> : !*.java , 凡是java文件都要保留;</span></p>
<p><span style="font-family:'Courier New'">-- <strong><span style="color:#3333ff">跟踪指定文件</span></strong> : !/AndroidManifest.xml , 该文件需要保留, 提交上去;</span></p>
<p><span style="font-family:'Courier New'"><br>
</span></p>
<p><span style="font-family:'Courier New'"><strong><span style="color:#ff0000">配置原则</span></strong> : 一般情况下采用开放模式鱼保守模式<strong><span style="color:#3333ff">共同使用</span></strong>;</span></p>
<p><span style="font-family:'Courier New'">eg : 一个目录下有很多目录和文件, 当我们只需要保留其中的一个文件的时候, 先用开放模式不保留这些文件, 然后用保守模式将这个文件留下来, 保守模式的优先级要高于开放模式;</span></p>
<p><span style="font-family:'Courier New'"><br>
</span></p>
<h2><a target="_blank" name="t16"></a><span style="font-family:'Courier New'">2. 标签使用(Tag</span><span style="font-family:'Courier New'">)</span></h2>
<p><span style="font-family:'Courier New'"><br>
</span></p>
<p><span style="font-family:'Courier New'"><strong><span style="color:#ff0000">标签作用</span><span style="color:#cc0000"></span></strong>: 在开发的一些关键时期,<strong><span style="color:#3333ff">使用标签来记录这些关键时刻</span></strong>, 例如发布版本, 有重大修改, 升级的时候, 会使用标签记录这些时刻, 来<strong><span style="color:#3333ff">永久标记项目中的关键历史时刻</span></strong>;</span></p>
<p><br>
</p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">查看标签</span></strong>: 列出的标签安装ASCII字母顺序确定, 排序没有很明确的意义;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">列出所有的标签</span></strong> : &nbsp;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;tag&nbsp;&nbsp;</span></span></li></ol>
</div>
-- <strong><span style="color:#3333ff">使用限定列出限定后的标签</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;tag&nbsp;-l&nbsp;v1.*&nbsp;&nbsp;</span></span></li></ol>
</div>
<img src="http://img.blog.csdn.net/20140127201126828" alt=""><br>
<br>
<br>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">标签分类</span></strong> : Git中的标签分为 轻量级标签(lightweight) 和 带注释的标签(annotated), 一般情况下推荐使用带注释的标签, 如果标签是临时的可以采用轻量级标签;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">轻量级标签</span></strong> : 轻量级标签中的信息含量很少, 这种标签只代表某时刻代码的提交, 相当于指向这个提交的指针;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">带注释标签</span></strong> : 这种标签是一种校验和, 包含标签名, 邮箱, 日期, 标签信息, GPG签名 和 验证, 它相当于一个对象, 封装了这些信息;</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">创建标签</span></strong> :</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">创建轻量级标签</span></strong> : 这样的标签没有附带其它的信息;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;tag&nbsp;v2.0&nbsp;&nbsp;</span></span></li></ol>
</div>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140127204745609" alt=""><br>
</span></p>
-- <strong><span style="color:#3333ff">创建带注释标签</span></strong> : -m 后跟的是注释信息, 当使用git show v2.1的时候, 会显示这个注释信息;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;tag&nbsp;-a&nbsp;v2.1&nbsp;-m&nbsp;'first&nbsp;version'&nbsp;&nbsp;</span></span></li></ol>
</div>
<img src="http://img.blog.csdn.net/20140127204837671" alt=""><br>
-- <strong><span style="color:#3333ff">创建GPG私钥的注释标签</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;tag&nbsp;-s&nbsp;v2.1&nbsp;-m&nbsp;'GPG&nbsp;version'&nbsp;&nbsp;</span></span></li></ol>
</div>
<strong><span style="color:#cc33cc"></span></strong>
<p><strong><span style="color:#cc33cc">在本机上实验不成功 出现下面的错误</span></strong> :&nbsp;</p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>Administrator@XRDPTJ9ILK6IWRA&nbsp;/storage/TabHost_Test&nbsp;(master)&nbsp;&nbsp;</span></span></li><li><span>$&nbsp;git&nbsp;tag&nbsp;-s&nbsp;v2.2&nbsp;-m&nbsp;'GPG&nbsp;version'&nbsp;&nbsp;</span></li><li class="alt"><span>gpg:&nbsp;error&nbsp;loading&nbsp;`iconv.dll':&nbsp;找不到指定的模块。&nbsp;&nbsp;</span></li><li><span>&nbsp;&nbsp;</span></li><li class="alt"><span>gpg:&nbsp;please&nbsp;see&nbsp;http://www.gnupg.org/download/iconv.html&nbsp;for&nbsp;more&nbsp;information&nbsp;&nbsp;</span></li><li><span>gpg:&nbsp;keyblock&nbsp;resource&nbsp;`c:/Documents&nbsp;and&nbsp;Settings/Administrator/.gnupg\secring.g&nbsp;&nbsp;</span></li><li class="alt"><span>pg':&nbsp;file&nbsp;open&nbsp;error&nbsp;&nbsp;</span></li><li><span>gpg:&nbsp;keyblock&nbsp;resource&nbsp;`c:/Documents&nbsp;and&nbsp;Settings/Administrator/.gnupg\pubring.g&nbsp;&nbsp;</span></li><li class="alt"><span>pg':&nbsp;file&nbsp;open&nbsp;error&nbsp;&nbsp;</span></li><li><span>gpg:&nbsp;skipped&nbsp;&quot;HanShuliang&nbsp;&lt;13241153187@163.com&gt;&quot;:&nbsp;secret&nbsp;key&nbsp;not&nbsp;available&nbsp;&nbsp;</span></li><li class="alt"><span>gpg:&nbsp;signing&nbsp;failed:&nbsp;secret&nbsp;key&nbsp;not&nbsp;available&nbsp;&nbsp;</span></li><li><span>error:&nbsp;gpg&nbsp;failed&nbsp;to&nbsp;sign&nbsp;the&nbsp;data&nbsp;&nbsp;</span></li><li class="alt"><span>error:&nbsp;unable&nbsp;to&nbsp;sign&nbsp;the&nbsp;tag&nbsp;&nbsp;</span></li></ol>
</div>
以后再找原因;
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">为之前的提交添加标签</span></strong> : 先使用 git log --oneline 命令列出之前的提交, 会有一个七位的十六进制数进行标记, 使用git tag -a v3.1 f1bb97a 命令即可为这个提交添加标签;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>$&nbsp;git&nbsp;log&nbsp;--oneline&nbsp;&nbsp;</span></span></li><li><span>&nbsp;&nbsp;</span></li><li class="alt"><span>f1bb97a&nbsp;first&nbsp;commit&nbsp;&nbsp;</span></li><li><span>&nbsp;&nbsp;</span></li><li class="alt"><span>git&nbsp;tag&nbsp;-a&nbsp;v3.1&nbsp;f1bb97a&nbsp;&nbsp;</span></li></ol>
</div>
<img src="http://img.blog.csdn.net/20140127211205234" alt=""><br>
<br>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">删除标签</span></strong> : 使用命令 git tag -d 标签名 命令删除标签;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;tag&nbsp;-d&nbsp;v0.1&nbsp;&nbsp;</span></span></li></ol>
</div>
<img src="http://img.blog.csdn.net/20140127211443140" alt=""><br>
<br>
<strong><span style="color:#ff0000"><br>
</span></strong>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">验证标签</span></strong> : 提交了GPG带注释标签才可以验证, 因为上面没有提交成功, 这里留下一个命令;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;tag&nbsp;-v&nbsp;v1.0&nbsp;&nbsp;</span></span></li></ol>
</div>
<br>
<br>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">共享标签</span></strong> : 即将标签提交到GitHub中;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;push&nbsp;origin&nbsp;--tags&nbsp;&nbsp;</span></span></li></ol>
</div>
<img src="http://img.blog.csdn.net/20140127211726203" alt=""><br>
<br>
<p><br>
</p>
<h2><a target="_blank" name="t17"></a><span style="font-family:Courier New">3. 分支和合并</span></h2>
<p><span style="font-family:Courier New"><br>
</span></p>
<h3><a target="_blank" name="t18"></a><span style="font-family:Courier New">(1) 查看现存分支</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">查看现存分支</span></strong> : git branch命令;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;branch&nbsp;&nbsp;</span></span></li></ol>
</div>
<img src="http://img.blog.csdn.net/20140127230927984" alt=""><br>
从结果可以看出, 现在只有一个分支master;
<p><span style="font-family:Courier New"><br>
</span></p>
<h3><a target="_blank" name="t19"></a><span style="font-family:Courier New">(2) 创建分支</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">创建分支</span></strong> : git branch 分之名称, 就可以创建一个分支, 创建完分支以后可以查看分支, 当前使用的分支会显示成为绿色, 前面带有 &quot;*&quot;, 如果不是当前使用的分支, 显示的是白色, 并且没有 &quot;*&quot; 前缀;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;branch&nbsp;branch1&nbsp;&nbsp;</span></span></li></ol>
</div>
<img src="http://img.blog.csdn.net/20140127231649312" alt=""><br>
<br>
<h3><a target="_blank" name="t20"></a><span style="font-family:Courier New">(3) 切换分支</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">切换分支</span></strong> : git checkout 分支名称, 切换分支以后, 在<strong><span style="color:#3333ff">分支进行操作</span></strong>,<strong><span style="color:#6600cc">文件的改变不会体现在master主分支中, 主分支改变, 会体现在其它分支中;</span></strong></span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;checkout&nbsp;branch1&nbsp;&nbsp;</span></span></li></ol>
</div>
<img src="http://img.blog.csdn.net/20140127232003687" alt=""><br>
<br>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">关于主分支和其它分支</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">分支编辑</span></strong> : 现有两个分支 master 主分支, 和刚创建的branch1 分支, 切换到 branch1 分支, 在branch1 中创建一个文件 description_branch1.txt;&nbsp;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">其它分支文件不会影响主分支</span></strong> : 然后在切换回 master 主分支, 发现没有description_branch1.txt文件, 创建一个文件 description_master.txt;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">主分支会影响其它分支</span></strong> : 在切换回 branch1 分支中, 发现存在 description_master.txt文件;</span></p>
<p><span style="font-family:Courier New">.</span></p>
<p><span style="font-family:Courier New"><strong>对比过程</strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">查看该工程项目分支情况</span></strong>&nbsp;:&nbsp;</span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;branch&nbsp;&nbsp;</span></span></li></ol>
</div>
<p><span style="font-family:Courier New"><strong><span style="color:#3333ff">-- 分支结果</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>branch1&nbsp;&nbsp;</span></span></li><li><span>master&nbsp;&nbsp;</span></li></ol>
</div>
<p><span style="font-family:Courier New"><br>
</span></p>
<strong><span style="color:#ff0000">切换到 branch1 分支</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;checkout&nbsp;branch1&nbsp;&nbsp;</span></span></li></ol>
</div>
<strong><span style="color:#3333ff">-- 切换结果</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>Switched&nbsp;to&nbsp;branch&nbsp;'branch1'&nbsp;&nbsp;</span></span></li></ol>
</div>
<p><span style="font-family:Courier New"><br>
</span></p>
<strong><span style="color:#ff0000">查看 branch1 分支下的文件</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>ls&nbsp;&nbsp;</span></span></li></ol>
</div>
-- <strong><span style="color:#3333ff">查看文件结果</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>AndroidManifest.xml&nbsp;&nbsp;ic_launcher-web.png&nbsp;&nbsp;&nbsp;res&nbsp;&nbsp;</span></span></li><li><span>assets&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;libs&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;src&nbsp;&nbsp;</span></li><li class="alt"><span>bin&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;proguard-project.txt&nbsp;&nbsp;</span></li><li><span>gen&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;project.properties&nbsp;&nbsp;</span></li></ol>
</div>
<br>
<strong><span style="color:#ff0000">创建一个文件</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>touch&nbsp;description_branch1.txt&nbsp;&nbsp;</span></span></li></ol>
</div>
<br>
<strong><span style="color:#ff0000">添加这个文件到本地缓存</span></strong> :
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;add&nbsp;description_branch1.txt&nbsp;&nbsp;</span></span></li></ol>
</div>
<br>
<strong><span style="color:#ff0000">提交本地缓存</span></strong> : 注意, 这里必须提交, <strong>
<span style="color:#3333ff">如果不提交缓存, 这个文件在主分支也会出现</span></strong>;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;commit&nbsp;-m&nbsp;'add&nbsp;a&nbsp;description&nbsp;of&nbsp;branch1'&nbsp;&nbsp;</span></span></li></ol>
</div>
-- <strong><span style="color:#3333ff">提交结果结果</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>[branch1&nbsp;7f5785e]&nbsp;add&nbsp;a&nbsp;description&nbsp;of&nbsp;branch1&nbsp;&nbsp;</span></span></li><li><span>&nbsp;1&nbsp;file&nbsp;changed,&nbsp;0&nbsp;insertions(&#43;),&nbsp;0&nbsp;deletions(-)&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;create&nbsp;mode&nbsp;100644&nbsp;description_branch1.txt&nbsp;&nbsp;</span></li></ol>
</div>
<br>
<strong><span style="color:#ff0000">查看该分支下的文件</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>ls&nbsp;&nbsp;</span></span></li></ol>
</div>
-- <strong><span style="color:#3333ff">查看文件结果</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>AndroidManifest.xml&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;libs&nbsp;&nbsp;</span></span></li><li><span>assets&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;proguard-project.txt&nbsp;&nbsp;</span></li><li class="alt"><span>bin&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;project.properties&nbsp;&nbsp;</span></li><li><span>&lt;strong&gt;description_branch1.txt&lt;/strong&gt;&nbsp;&nbsp;res&nbsp;&nbsp;</span></li><li class="alt"><span>gen&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;src&nbsp;&nbsp;</span></li><li><span>ic_launcher-web.png&nbsp;&nbsp;</span></li></ol>
</div>
<br>
<strong><span style="color:#ff0000">切换回主分支</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;checkout&nbsp;master&nbsp;&nbsp;</span></span></li></ol>
</div>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">切换分支结果</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>Switched&nbsp;to&nbsp;branch&nbsp;'master'&nbsp;&nbsp;</span></span></li><li><span>Your&nbsp;branch&nbsp;is&nbsp;up-to-date&nbsp;with&nbsp;'origin/master'.&nbsp;&nbsp;</span></li></ol>
</div>
<p><span style="font-family:Courier New"><br>
</span></p>
<strong><span style="color:#ff0000">查看主分支文件</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>ls&nbsp;&nbsp;</span></span></li></ol>
</div>
-- <strong><span style="color:#3333ff">查看文件结果</span></strong> : 没有在 branch1 中添加的文件;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>AndroidManifest.xml&nbsp;&nbsp;ic_launcher-web.png&nbsp;&nbsp;&nbsp;res&nbsp;&nbsp;</span></span></li><li><span>assets&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;libs&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;src&nbsp;&nbsp;</span></li><li class="alt"><span>bin&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;proguard-project.txt&nbsp;&nbsp;</span></li><li><span>gen&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;project.properties&nbsp;&nbsp;</span></li></ol>
</div>
<br>
<img src="http://img.blog.csdn.net/20140127235831296" alt=""><br>
.
<p><span style="font-family:Courier New"><br>
</span></p>
<h3><a target="_blank" name="t21"></a><span style="font-family:Courier New"><strong>(4) 提交分支&nbsp;</strong></span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">提交分支命令</span></strong> : 将本地的分支提交到 GitHub中;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;push&nbsp;origin&nbsp;experiment&nbsp;&nbsp;</span></span></li></ol>
</div>
<br>
<br>
<h3><a target="_blank" name="t22"></a><span style="font-family:Courier New">(5) 分支合并移除</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">合并分支命令</span></strong> : 合并分支之后, 分支中有的文件在 主分支中也会显示, 相当于将branch1 分支中的文件拷贝了一份到master分支中;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;merge&nbsp;branch1&nbsp;&nbsp;</span></span></li></ol>
</div>
<strong><span style="color:#ff0000">合并结果</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>Updating&nbsp;f1bb97a..7f5785e&nbsp;&nbsp;</span></span></li><li><span>Fast-forward&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;description_branch1.txt&nbsp;|&nbsp;0&nbsp;&nbsp;</span></li><li><span>&nbsp;1&nbsp;file&nbsp;changed,&nbsp;0&nbsp;insertions(&#43;),&nbsp;0&nbsp;deletions(-)&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;create&nbsp;mode&nbsp;100644&nbsp;description_branch1.txt&nbsp;&nbsp;</span></li></ol>
</div>
<p><span style="font-family:Courier New"><br>
</span></p>
<img src="http://img.blog.csdn.net/20140128001222750" alt=""><br>
<br>
.
<h3><a target="_blank" name="t23"></a><span style="font-family:Courier New">(6) 删除分支</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">删除分支命令</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;branch&nbsp;-d&nbsp;branch1&nbsp;&nbsp;</span></span></li></ol>
</div>
<br>
<strong><span style="color:#ff0000">强制删除分支命令</span></strong> : 如果branch1 分支还没有被合并的话, Git是不允许删除这个分支的, 此时要想删除该分支, 就只能使用下面的命令强制删除该分支 :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;branch&nbsp;-D&nbsp;branch1&nbsp;&nbsp;</span></span></li></ol>
</div>
<br>
<br>
<h2><a target="_blank" name="t24"></a><span style="font-family:Courier New">4. Git工作流程</span></h2>
<p><br>
</p>
<h3><a target="_blank" name="t25"></a><span style="font-family:Courier New">(1) 两种工作流程</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">协作开发工作流程</span></strong> : 这种情况是最复杂的情况, 多人团队共同开发一个项目;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">与远程仓库同步</span></strong> : git pull ;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">修改文件</span></strong> : 添加 删除 修改文件;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">查看变更</span></strong> : git status ;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">载入变更</span></strong> :<strong><span style="color:#6600cc">添加文件</span></strong>, 先使用git add fileName, 在使用 git commit -m 'note' 载入变更; 如果是<strong><span style="color:#6600cc">删除 修改文件</span></strong>,
 直接使用 git commit -m 'note' 提交;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">重复</span></strong> : 重复执行 修改文件 查看变更 载入变更 提交载入动作;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">上传</span></strong> : 使用 git push 命令将项目源码提交带GitHub中去;</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">单独开发工作流程</span></strong> : 如果是个人独立开发, 仅追踪本地文件变更, 就不需要提交到服务器上, 因为Git是分布式的;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">修改文件</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">提交变更</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">重复</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<h3><a target="_blank" name="t26"></a><span style="font-family:Courier New">(2) 简单示例</span></h3>
<p><span style="font-family:Courier New"><br>
</span></p>
<h4><a target="_blank" name="t27"></a><span style="font-family:Courier New">1&gt; 独立开发示例</span></h4>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">该示例不会上传, 仅在本地进行操作</span></strong>;</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">从GitHub中检出项目源码</span></strong> : 注意, 检出的源码是<strong><span style="color:#3333ff">根目录源码</span></strong>, 我们在总仓库的根目录检出即可,<strong><span style="color:#6600cc">不同再为项目创建目录</span></strong>;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;clone&nbsp;git@github.com:han1202012/AndroidPictureViewer.git&nbsp;&nbsp;</span></span></li></ol>
</div>
-- <strong><span style="color:#3333ff">检出克隆结果</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>Cloning&nbsp;into&nbsp;'AndroidPictureViewer'...&nbsp;&nbsp;</span></span></li><li><span>remote:&nbsp;Counting&nbsp;objects:&nbsp;86,&nbsp;done.&nbsp;&nbsp;</span></li><li class="alt"><span>remote:&nbsp;Compressing&nbsp;objects:&nbsp;100%&nbsp;(62/62),&nbsp;done.&nbsp;&nbsp;</span></li><li><span>remote:&nbsp;Total&nbsp;86&nbsp;(delta&nbsp;3),&nbsp;reused&nbsp;86&nbsp;(delta&nbsp;3)&nbsp;&nbsp;</span></li><li class="alt"><span>Receiving&nbsp;objects:&nbsp;100%&nbsp;(86/86),&nbsp;1.67&nbsp;MiB&nbsp;|&nbsp;109.00&nbsp;KiB/s,&nbsp;done.&nbsp;&nbsp;</span></li><li><span>Resolving&nbsp;deltas:&nbsp;100%&nbsp;(3/3),&nbsp;done.&nbsp;&nbsp;</span></li><li class="alt"><span>Checking&nbsp;connectivity...&nbsp;done.&nbsp;&nbsp;</span></li></ol>
</div>
<br>
<strong><span style="color:#ff0000">删除bin和gen目录</span></strong> : 这两个目录是Android工程编译产生的临时文件, 没有必要上传到GitHub中去;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>rm&nbsp;-rf&nbsp;bin&nbsp;gen&nbsp;&nbsp;</span></span></li></ol>
</div>
-- <strong><span style="color:#3333ff">查看删除结果状态</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;status&nbsp;&nbsp;</span></span></li></ol>
</div>
-- <strong><span style="color:#6600cc">结果</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>On&nbsp;branch&nbsp;master&nbsp;&nbsp;</span></span></li><li><span>Your&nbsp;branch&nbsp;is&nbsp;up-to-date&nbsp;with&nbsp;'origin/master'.&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;&nbsp;</span></li><li><span>Changes&nbsp;not&nbsp;staged&nbsp;for&nbsp;commit:&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;&nbsp;(use&nbsp;&quot;git&nbsp;add/rm&nbsp;&lt;file&gt;...&quot;&nbsp;to&nbsp;update&nbsp;what&nbsp;will&nbsp;be&nbsp;committed)&nbsp;&nbsp;</span></li><li><span>&nbsp;&nbsp;(use&nbsp;&quot;git&nbsp;checkout&nbsp;--&nbsp;&lt;file&gt;...&quot;&nbsp;to&nbsp;discard&nbsp;changes&nbsp;in&nbsp;working&nbsp;directory)&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;&nbsp;</span></li><li><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;deleted:&nbsp;&nbsp;&nbsp;&nbsp;bin/AndroidManifest.xml&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;deleted:&nbsp;&nbsp;&nbsp;&nbsp;bin/ImageView_Test.apk&nbsp;&nbsp;</span></li><li><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;deleted:&nbsp;&nbsp;&nbsp;&nbsp;bin/classes.dex&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;deleted:&nbsp;&nbsp;&nbsp;&nbsp;bin/res/crunch/drawable-xxhdpi/ic_launcher.png&nbsp;&nbsp;</span></li><li><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;deleted:&nbsp;&nbsp;&nbsp;&nbsp;bin/resources.ap_&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;deleted:&nbsp;&nbsp;&nbsp;&nbsp;gen/shuliang/han/imageview_test/BuildConfig.java&nbsp;&nbsp;</span></li><li><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;deleted:&nbsp;&nbsp;&nbsp;&nbsp;gen/shuliang/han/imageview_test/R.java&nbsp;&nbsp;</span></li></ol>
</div>
<p><span style="font-family:Courier New"><br>
</span></p>
<strong><span style="color:#ff0000">提交缓存</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;commit&nbsp;-a&nbsp;&nbsp;</span></span></li></ol>
</div>
-- <strong><span style="color:#3333ff">提交结果</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>[master&nbsp;e4377ba]&nbsp;delete&nbsp;bin&nbsp;and&nbsp;gen&nbsp;directory.&nbsp;&nbsp;</span></span></li><li><span>&nbsp;28&nbsp;files&nbsp;changed,&nbsp;2&nbsp;insertions(&#43;),&nbsp;110&nbsp;deletions(-)&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;create&nbsp;mode&nbsp;100644&nbsp;.gitignore&nbsp;&nbsp;</span></li><li><span>&nbsp;delete&nbsp;mode&nbsp;100644&nbsp;bin/AndroidManifest.xml&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;delete&nbsp;mode&nbsp;100644&nbsp;bin/ImageView_Test.apk&nbsp;&nbsp;</span></li><li><span>&nbsp;delete&nbsp;mode&nbsp;100644&nbsp;bin/classes.dex&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;delete&nbsp;mode&nbsp;100644&nbsp;bin/resources.ap_&nbsp;&nbsp;</span></li><li><span>&nbsp;delete&nbsp;mode&nbsp;100644&nbsp;gen/shuliang/han/imageview_test/BuildConfig.java&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;delete&nbsp;mode&nbsp;100644&nbsp;gen/shuliang/han/imageview_test/R.java&nbsp;&nbsp;</span></li></ol>
</div>
<p><br>
</p>
<h4><a target="_blank" name="t28"></a><span style="font-family:Courier New">2&gt; 协作开发示例</span></h4>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">与远程仓库同步</span></strong> :&nbsp;</span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;pull&nbsp;&nbsp;</span></span></li></ol>
</div>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">如果其他人没有提交项目到GitHub上, 就会出现下面结果</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>Already&nbsp;up-to-date.&nbsp;&nbsp;</span></span></li></ol>
</div>
<br>
<strong><span style="color:#ff0000">修改文件后查看变更</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;status&nbsp;&nbsp;</span></span></li></ol>
</div>
-- <strong><span style="color:#3333ff">如果没有变更会出现下面情况</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>On&nbsp;branch&nbsp;master&nbsp;&nbsp;</span></span></li><li><span>Your&nbsp;branch&nbsp;is&nbsp;ahead&nbsp;of&nbsp;'origin/master'&nbsp;by&nbsp;1&nbsp;commit.&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;&nbsp;(use&nbsp;&quot;git&nbsp;push&quot;&nbsp;to&nbsp;publish&nbsp;your&nbsp;local&nbsp;commits)&nbsp;&nbsp;</span></li><li><span>&nbsp;&nbsp;</span></li><li class="alt"><span>nothing&nbsp;to&nbsp;commit,&nbsp;working&nbsp;directory&nbsp;clean&nbsp;&nbsp;</span></li></ol>
</div>
<br>
<strong><span style="color:#ff0000">载入变更</span></strong> : 如果有变更, 那么使用命令载入变更. 使用 git commit -a 或者 git add 命令;
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">添加文件</span></strong> : 先使用 git add 文件名 来添加文件到缓存, 之后使用 git commit -m '' 命令提交代码到本地缓存;</span></p>
<p><span style="font-family:Courier New">-- <strong><span style="color:#3333ff">删除改变文件</span></strong> : 直接使用 git commit -m '', 提交删除 或则 改变 到本地缓存;</span></p>
<p><span style="font-family:Courier New"><br>
</span></p>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">提交项目源码到服务器</span></strong> :&nbsp;</span></p>
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>git&nbsp;push&nbsp;&nbsp;</span></span></li></ol>
</div>
-- <strong><span style="color:#3333ff">提交源码结果</span></strong> :&nbsp;
<p><span style="font-family:Courier New"></span></p>
<div class="dp-highlighter bg_plain">
<div class="bar">
<div class="tools"><strong>[plain]</strong> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="ViewSource" title="view plain">
view plain</a><span> <a target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279#" class="CopyToClipboard" title="copy">
copy</a></span><span> </span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418" target="_blank" title="在CODE上查看代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/CODE_ico.png" alt="在CODE上查看代码片" height="12" width="12" style="position:relative; top:1px; left:2px"></a></span><span class="tracking-ad"><a target="_blank" href="https://code.csdn.net/snippets/174418/fork" target="_blank" title="派生到我的代码片" style="text-indent:0"><img src="https://code.csdn.net/assets/ico_fork.svg" alt="派生到我的代码片" height="12" width="12" style="position:relative; top:2px; left:2px"></a></span></div>
</div>
<ol start="1">
<li class="alt"><span><span>warning:&nbsp;push.default&nbsp;is&nbsp;unset;&nbsp;its&nbsp;implicit&nbsp;value&nbsp;is&nbsp;changing&nbsp;in&nbsp;&nbsp;</span></span></li><li><span>Git&nbsp;2.0&nbsp;from&nbsp;'matching'&nbsp;to&nbsp;'simple'.&nbsp;To&nbsp;squelch&nbsp;this&nbsp;message&nbsp;&nbsp;</span></li><li class="alt"><span>and&nbsp;maintain&nbsp;the&nbsp;current&nbsp;behavior&nbsp;after&nbsp;the&nbsp;default&nbsp;changes,&nbsp;use:&nbsp;&nbsp;</span></li><li><span>&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;&nbsp;git&nbsp;config&nbsp;--global&nbsp;push.default&nbsp;matching&nbsp;&nbsp;</span></li><li><span>&nbsp;&nbsp;</span></li><li class="alt"><span>To&nbsp;squelch&nbsp;this&nbsp;message&nbsp;and&nbsp;adopt&nbsp;the&nbsp;new&nbsp;behavior&nbsp;now,&nbsp;use:&nbsp;&nbsp;</span></li><li><span>&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;&nbsp;git&nbsp;config&nbsp;--global&nbsp;push.default&nbsp;simple&nbsp;&nbsp;</span></li><li><span>&nbsp;&nbsp;</span></li><li class="alt"><span>See&nbsp;'git&nbsp;help&nbsp;config'&nbsp;and&nbsp;search&nbsp;for&nbsp;'push.default'&nbsp;for&nbsp;further&nbsp;information.&nbsp;&nbsp;</span></li><li><span>(the&nbsp;'simple'&nbsp;mode&nbsp;was&nbsp;introduced&nbsp;in&nbsp;Git&nbsp;1.7.11.&nbsp;Use&nbsp;the&nbsp;similar&nbsp;mode&nbsp;&nbsp;</span></li><li class="alt"><span>'current'&nbsp;instead&nbsp;of&nbsp;'simple'&nbsp;if&nbsp;you&nbsp;sometimes&nbsp;use&nbsp;older&nbsp;versions&nbsp;of&nbsp;Git)&nbsp;&nbsp;</span></li><li><span>&nbsp;&nbsp;</span></li><li class="alt"><span>Counting&nbsp;objects:&nbsp;4,&nbsp;done.&nbsp;&nbsp;</span></li><li><span>Delta&nbsp;compression&nbsp;using&nbsp;up&nbsp;to&nbsp;2&nbsp;threads.&nbsp;&nbsp;</span></li><li class="alt"><span>Compressing&nbsp;objects:&nbsp;100%&nbsp;(2/2),&nbsp;done.&nbsp;&nbsp;</span></li><li><span>Writing&nbsp;objects:&nbsp;100%&nbsp;(3/3),&nbsp;292&nbsp;bytes&nbsp;|&nbsp;0&nbsp;bytes/s,&nbsp;done.&nbsp;&nbsp;</span></li><li class="alt"><span>Total&nbsp;3&nbsp;(delta&nbsp;1),&nbsp;reused&nbsp;0&nbsp;(delta&nbsp;0)&nbsp;&nbsp;</span></li><li><span>To&nbsp;git@github.com:han1202012/AndroidPictureViewer.git&nbsp;&nbsp;</span></li><li class="alt"><span>&nbsp;&nbsp;&nbsp;1ddf8c7..e4377ba&nbsp;&nbsp;master&nbsp;-&gt;&nbsp;master&nbsp;&nbsp;</span></li></ol>
</div>
<br>
<br>
<p><span style="font-family:Courier New"><strong><span style="color:#ff0000">查看GitHub中的源码情况</span></strong> : gen 和 bin 目录果然被删除了;</span></p>
<p><span style="font-family:Courier New"><img src="http://img.blog.csdn.net/20140128113602000" alt=""><br>
</span></p>
<p><span style="font-family:'Courier New'">.</span></p>
<p><span style="font-family:'Courier New'"><span style="background-color:rgb(255,255,0)"><strong><span style="color:#ff00">作者</span></strong>&nbsp;:<strong><span style="color:#3333ff">万境绝尘&nbsp;</span></strong></span></span></p>
<p><span style="font-family:'Courier New'"><span style="background-color:rgb(255,255,0)"><strong><span style="color:#993399">转载请注明出处</span></strong>&nbsp; :&nbsp;<a target="_blank" target="_blank" href="http://blog.csdn.net/shulianghan/article/details/18812279">http://blog.csdn.net/shulianghan/article/details/18812279</a></span></span></p>
<p><span style="font-family:'Courier New'">.</span></p>


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
