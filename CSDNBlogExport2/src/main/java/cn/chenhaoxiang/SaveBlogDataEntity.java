package cn.chenhaoxiang;

import cn.chenhaoxiang.entity.BlogDataEntity;
import cn.chenhaoxiang.entity.BlogEntity;
import cn.chenhaoxiang.utils.FileUtils;
import cn.chenhaoxiang.utils.JSONUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

/**
 * Created by 陈浩翔 on 2017/7/27 0027.
 */
public class SaveBlogDataEntity implements PageProcessor {
	private static Logger logger = Logger.getLogger(SaveBlogDataEntity.class);
	// 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	private static Site site;
	private static JTextArea textArea;
	private static List<String> blogIdList = null;
	public static BlogDataEntity json2BlogDataEntity(String str){
        BlogEntity blogEntity  = JSONUtils.json2obj(str,BlogEntity.class);
        String data = blogEntity.getData();
        BlogDataEntity blogDataEntity = JSONUtils.json2obj(data,BlogDataEntity.class);
        return blogDataEntity;
    }

	public void process(Page page) {
		logger.info(page.getJson().toString());
		BlogDataEntity blogDataEntity = json2BlogDataEntity(page.getJson().toString());
		if (blogDataEntity == null) {
			if(textArea!=null)
			textArea.append("返回值为空，文章不存在!\n");
			return;
		}
		// 开始写入文件
		String file = blogDataEntity.getCreate().substring(0, 7);
		String title = blogDataEntity.getTitle();
		title = title.replaceAll("[/,\\\\,:,*,?,|,<,>]", " ");
		blogDataEntity.setTitle(title);
		String fileName =FileUtils.basePath + "\\" + file + "\\" + blogDataEntity.getCreate().substring(0, 10) + "-"
				+ blogDataEntity.getTitle() + ".markdown";
		logger.info(fileName);
		try {
			//我自己导出我的博客时加的头部和尾部，你导出自己博客时删除即可
			String firstStr="---\nlayout: post\ntitle: \""+blogDataEntity.getTitle()+"\"\ndate: "+blogDataEntity.getCreate()+" +0800\ncomments: true\ncategories:"+blogDataEntity.getCategories()+"\ntags: ["+blogDataEntity.getTags()+"]\nkeyword: 陈浩翔, 谙忆\ndescription: "+blogDataEntity.getDescription()+" \n---\n";
			String description = "\n\n"+blogDataEntity.getDescription()+"\n<!-- more -->\n----------\n\n";
			//String endStr ="\n\n本文章由<a href=\"http://chenhaoxiang.cn/\">[谙忆]</a>编写， 所有权利保留。 \n欢迎转载，分享是进步的源泉。\n<blockquote cite='陈浩翔'>\n<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color=\"green\">http://chenhaoxiang.cn</font></a><br><br>\n本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>\n</blockquote>\n";
			String endStr ="";
			// logger.info(blogDataEntity.getMarkdowncontent());
			if (blogDataEntity.getMarkdowncontent() != null) {
				String str = description+blogDataEntity.getMarkdowncontent();
				str = str.replaceAll("<","&#60;");
				str = str.replaceAll(">","&#62;");
				str = str.replaceAll("&#62;=",">=");
				str = str.replaceAll("&#60;=",">=");
				FileUtils.saveStringToFile(firstStr+str+endStr, fileName, "utf-8");
			} else {
				String str = description+blogDataEntity.getContent();
				str = str.replaceAll("<","&#60;");
				str = str.replaceAll(">","&#62;");
				str = str.replaceAll("&#62;=",">=");
				str = str.replaceAll("&#60;=",">=");
				//修复原来的一个BUG，也是自己没有考虑全面出现的
				FileUtils.saveStringToFile(firstStr+str+endStr, fileName, "utf-8");
			}

			logger.info("存储博客《" + blogDataEntity.getTitle() + "》成功");
			if(textArea!=null)
			textArea.append("存储博客《" + blogDataEntity.getTitle() + "》成功\n");
		} catch (UnsupportedEncodingException e) {
			logger.info("存储博客《" + blogDataEntity.getTitle() + "》出现异常，" + e.getMessage());
			if(textArea!=null)
			textArea.append("存储博客《" + blogDataEntity.getTitle() + "》出现异常，" + e.getMessage() + "\n");
		}
		if(blogIdList!=null&&blogIdList.size()>0)
			page.addTargetRequests(blogIdList);
	}

	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		site = Site.me().setRetryTimes(3).setSleepTime(3000).setCharset("utf-8").setDomain("write.blog.csdn.net")
				//.addCookie("userName", "u012017783");
				.addCookie("userName", "qq_26525215");
		Spider.create(new SaveBlogDataEntity())
				// 从"https://github.com/code4craft"开始抓
				.addUrl("http://write.blog.csdn.net/mdeditor/getArticle?id=76254851")
				// 开启5个线程抓取
				.thread(1)
				// 启动爬虫
				.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(FileUtils.basePath);
	}

	public static void startGetBlogandSave(long begin, JButton btnNewButton, JTextArea textArea1, Set<String> blogIdSet, int threadNum) {
		textArea = textArea1;
		if(blogIdList!=null)
			blogIdList.clear();
		blogIdList=null;
		blogIdList = new ArrayList<String>();
		site = Site.me().setRetryTimes(10).setSleepTime(5000).setCharset("utf-8").setDomain("write.blog.csdn.net")
				.addCookie("userName", CSDNBlogExport.name);
		Iterator<String> iterator = blogIdSet.iterator();
		Boolean frist =true;
		String id="";
		while (iterator.hasNext()) {
			if(frist){
				frist=false;
				id = iterator.next();
				logger.info("此次存储的文章ID:" + id);
			}else{
				String idString = iterator.next();
				blogIdList.add("http://write.blog.csdn.net/mdeditor/getArticle?id="+idString);
			}
		}
		Spider.create(new SaveBlogDataEntity())
		// 从"https://github.com/code4craft"开始抓
		.addUrl("http://write.blog.csdn.net/mdeditor/getArticle?id=" + id)
		// 开启50个线程抓取
		.thread(threadNum)
		// 启动爬虫
		.run();
		
		textArea.append("您的全部博客导出成功!\n"); 
		btnNewButton.setEnabled(true);
        //执行你需要操作的定时任务 
        long end = System.currentTimeMillis(); 
		textArea.append("本次导出博客耗时:["+ ((end - begin)/1000)+"]秒\n");
	}

}
