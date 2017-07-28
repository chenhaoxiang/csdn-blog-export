package cn.chenhaoxiang;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

public class CSDNBlogExport implements PageProcessor {
	private static Logger logger = Logger.getLogger(CSDNBlogExport.class);
	private static Set<String> blogIdSet = null;
	private static JTextArea textArea=null;
	// 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等  可以做成用户输入
	private Site site = Site.me().setRetryTimes(5).setSleepTime(5000).setCharset("utf-8");
	public static String name = "";// CSDN用户名
 	public static Boolean nameIsOK = false;
	public void process(Page page) {
		nameIsOK = true;
		logger.info("开始获取" + name + "的所有博客文章ID...");
		if(textArea!=null)
			textArea.append("开始获取" + name + "的所有博客文章ID...\n");
		List<String> urls = page.getHtml().xpath("//span[@class='link_title']").links()
				.regex(".*/" + name + "/article/details/.*").all();
		Iterator<String> iterator = urls.iterator();
		int pageInt = 0;
		while (iterator.hasNext()) {
			String lastStr = iterator.next();
			lastStr = lastStr.substring(lastStr.lastIndexOf("/") + 1);
			if(blogIdSet==null){
				blogIdSet = new HashSet<String>();
			}
			blogIdSet.add(lastStr);
			if(textArea!=null)
				textArea.append("已获取到您的博客文章ID:"+lastStr+"\n");
			logger.info("已获取到您的博客文章ID:"+lastStr);
			pageInt++;
		}
		logger.info("获取所有的文章博客ID完成，您一共有" + pageInt + "篇文章...");
		if(textArea!=null)
			textArea.append("获取所有的文章博客ID完成，您一共有" + pageInt + "篇文章...\n");
		String names = page.getHtml().xpath("//div[@id='blog_userface']").links().regex(".*/my.csdn.net/.*").get();
		names = names.substring(names.lastIndexOf("/") + 1);
		if (!names.equals(name)) {
			name = names;
		}
		logger.debug("最终名称:"+name);
		// 本来是想写成分页获取文章ID的，但是发现只要翻页的页码够大，(也就是大于你的最大页数)，就可以一次性获取你的所有文章ID，就偷懒了。
		// List<String> backUrls =
		// page.getHtml().xpath("//div[@id='papelist']").links().all();
		// Iterator<String> iterator2 = backUrls.iterator();
		//
		// while (iterator2.hasNext()){
		// String lastStr2 = iterator2.next();
		// Integer integer =
		// Integer.parseInt(lastStr2.substring(lastStr2.lastIndexOf("/")+1).trim());
		// if(integer>lastInt){
		// lastInt = integer;
		// }
		// System.out.println(lastInt);
		// }
		// page.addTargetRequests(page.getHtml().xpath("//div[@id='papelist']").links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
	}

	public Site getSite() {
		return site;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		nameIsOK = false;
		name ="ohenry88";
		Spider.create(new CSDNBlogExport())
				// 从"https://github.com/code4craft"开始抓
				.addUrl("http://blog.csdn.net/" + name + "/article/list/9999")
				// 开启5个线程抓取
				.thread(1)
				// 启动爬虫
				.run();
		if(!nameIsOK){
			System.out.println("请检查用户名是否正确或网络是否已经连接!");
		}
		//run 线程阻塞 
	}


	/**
	 * 通过用户名获取用户所有的文章ID
	 * @param userName
	 * @param textArea1
	 * @return
	 */
	public static Set<String> startGetBlogID(String userName,JTextArea textArea1){
		textArea = textArea1;
		blogIdSet = new HashSet<String>();
		nameIsOK = false;
		name = userName;
		System.out.println("用户名:"+userName);
		Spider.create(new CSDNBlogExport())
				.addUrl("http://blog.csdn.net/" + name + "/article/list/9999")
				.thread(1)
				.run();
		if(!nameIsOK){
			logger.error("请检查用户名或网络是否已经连接!");
			return null;
		}
		return blogIdSet;
	}

}
