package cn.chenhaoxiang;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.*;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

public class CSDNBlogExport implements PageProcessor {
	private static Logger logger = Logger.getLogger(CSDNBlogExport.class);
	private static Set<String> blogIdSet = null;
	private static JTextArea textArea=null;
	// 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等  可以做成用户输入
	private Site site = Site.me().setRetryTimes(10).setSleepTime(5000).setCharset("utf-8");
	public static String name = "";// CSDN用户名
	public static Boolean nameIsOK = false;

	public static String oldName = "";

	private static int lastInt = 0;//总页数
	private static boolean isOnePage = true;//是否是第一页
	private static List<String> pageList = null;//某页的链接

	// 通过http://blog.csdn.net/" + name + "/article/list/9999 获取全部的文章，在2017.8月被csdn修复，也就是最后的数字不能大于用户实际的分页数，大于会返回404
// 	public void process(Page page) {
//		nameIsOK = true;
//		logger.info("开始获取" + name + "的所有博客文章ID...");
//		if(textArea!=null)
//			textArea.append("开始获取" + name + "的所有博客文章ID...\n");
//		List<String> urls = page.getHtml().xpath("//span[@class='link_title']").links()
//				.regex(".*/" + name + "/article/details/.*").all();
//		Iterator<String> iterator = urls.iterator();
//		int pageInt = 0;
//		while (iterator.hasNext()) {
//			String lastStr = iterator.next();
//			lastStr = lastStr.substring(lastStr.lastIndexOf("/") + 1);
//			if(blogIdSet==null){
//				blogIdSet = new HashSet<String>();
//			}
//			blogIdSet.add(lastStr);
//			if(textArea!=null)
//				textArea.append("已获取到您的博客文章ID:"+lastStr+"\n");
//			logger.info("已获取到您的博客文章ID:"+lastStr);
//			pageInt++;
//		}
//		logger.info("获取所有的文章博客ID完成，您一共有" + pageInt + "篇文章...");
//		if(textArea!=null)
//			textArea.append("获取所有的文章博客ID完成，您一共有" + pageInt + "篇文章...\n");
//		String names = page.getHtml().xpath("//div[@id='blog_userface']").links().regex(".*/my.csdn.net/.*").get();
//		names = names.substring(names.lastIndexOf("/") + 1);
//		if (!names.equals(name)) {
//			name = names;
//		}
//		logger.info("最终名称:"+name);
//	}

	public void process(Page page) {
		nameIsOK = true;
		if(isOnePage) {
			logger.info("开始获取" + name + "的博客文章ID...");
		}
		if(textArea!=null)
			textArea.append("开始获取" + name + "的博客文章ID...\n");
		List<String> urls = page.getHtml().xpath("//span[@class='link_title']").links()
				.regex(".*/" + oldName + "/article/details/.*").all();
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
			Main.blogs++;
		}
//		logger.info("获取所有的文章博客ID完成，您一共有" + pageInt + "篇文章...");
		if(textArea!=null)
			textArea.append("本次线程获取" + pageInt + "篇文章...共"+Main.blogs+"篇\n");
		//if(name.equals("")) {
		//}
		// 分页获取文章ID
		if(isOnePage) {
			String names = page.getHtml().xpath("//div[@id='blog_userface']").links().regex(".*/my.csdn.net/.*").get();
			names = names.substring(names.lastIndexOf("/") + 1);
			if (!names.equals(name)) {
				name = names;
			}
			logger.info("最终名称:" + name);

			List<String> backUrls = page.getHtml().xpath("//div[@id='papelist']").links().all();
			Iterator<String> iterator2 = backUrls.iterator();
			while (iterator2.hasNext()) {
				String lastStr2 = iterator2.next();
				logger.info("当前分解的页面链接:" + lastStr2);
				Integer integer = Integer.parseInt(lastStr2.substring(lastStr2.lastIndexOf("/") + 1).trim());
				if (integer > lastInt) {
					lastInt = integer;
				}
				logger.info("总页数为:" + lastInt);
			}
			if(pageList==null){
				pageList=new ArrayList<>();
			}
			for(int i=2;i<=lastInt;i++){
				pageList.add("http://blog.csdn.net/"+name+"/article/list/"+i);
			}
			isOnePage=false;
		}
		page.addTargetRequests(pageList);
	}

	public Site getSite() {
		return site;
	}

	/**
	 * Launch the application.
	 * qq_26525215
	 */
	public static void main(String[] args) {
		isOnePage =true;
		lastInt = 0;
		nameIsOK = false;
		name ="qq_26525215";
		pageList=new ArrayList<>();
		blogIdSet = new HashSet<String>();
		Spider.create(new CSDNBlogExport())
				// 从"https://github.com/code4craft"开始抓
				.addUrl("http://blog.csdn.net/" + name)
				// 开启5个线程抓取
				.thread(50)
				// 启动爬虫
				.run();
		if(!nameIsOK){
			System.out.println("请检查用户名是否正确或网络是否已经连接!");
		}
		logger.info("set的大小:"+blogIdSet.size());
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
		isOnePage =true;
		lastInt = 0;
		pageList=new ArrayList<>();
		name = userName;
		oldName = userName;
		logger.info("用户名:"+userName);
		Spider.create(new CSDNBlogExport())
				.addUrl("http://blog.csdn.net/" + name )
				.thread(50)
				.run();
		if(!nameIsOK){
			logger.error("请检查用户名或网络是否已经连接!");
			return null;
		}
		logger.info("本次查询的文章ID数量:"+blogIdSet.size());
		return blogIdSet;
	}

}
