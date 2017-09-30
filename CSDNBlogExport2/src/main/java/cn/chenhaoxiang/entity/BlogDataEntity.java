package cn.chenhaoxiang.entity;

/**
 * 博客实体类
 * Created by 陈浩翔 on 2017/7/27 0027.
 */
public class BlogDataEntity {
    private int id;//文章标识
    private int articleedittype;//文章类型
    private int bury;//被踩数
    private int channel;//
    private int comment_count;//评论数
    private int digg;//推荐数
    private int level;
    private int status;//状态
    private int view_count;//浏览次数
    private String articlemore;
    private String categories; //分类
    private boolean comment_allowed;//允许评论
    private String content;//正文
    private String create;//创建日期和时间
    private String create_at;//创建时间 long
    private String description;//文章简介
    private String markdowncontent;//markdown格式文章
    private String tags;//标签
    private String title;//标题
    private String type;//类型  原创，翻译，转载等
    private String url;//链接

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleedittype() {
        return articleedittype;
    }

    public void setArticleedittype(int articleedittype) {
        this.articleedittype = articleedittype;
    }

    public int getBury() {
        return bury;
    }

    public void setBury(int bury) {
        this.bury = bury;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getDigg() {
        return digg;
    }

    public void setDigg(int digg) {
        this.digg = digg;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public String getArticlemore() {
        return articlemore;
    }

    public void setArticlemore(String articlemore) {
        this.articlemore = articlemore;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public boolean isComment_allowed() {
        return comment_allowed;
    }

    public void setComment_allowed(boolean comment_allowed) {
        this.comment_allowed = comment_allowed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMarkdowncontent() {
        return markdowncontent;
    }

    public void setMarkdowncontent(String markdowncontent) {
        this.markdowncontent = markdowncontent;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BlogDataEntity{" +
                "id=" + id +
                ", articleedittype=" + articleedittype +
                ", bury=" + bury +
                ", channel=" + channel +
                ", comment_count=" + comment_count +
                ", digg=" + digg +
                ", level=" + level +
                ", status=" + status +
                ", view_count=" + view_count +
                ", articlemore='" + articlemore + '\'' +
                ", categories='" + categories + '\'' +
                ", comment_allowed=" + comment_allowed +
                ", content='" + content + '\'' +
                ", create='" + create + '\'' +
                ", create_at='" + create_at + '\'' +
                ", description='" + description + '\'' +
                ", markdowncontent='" + markdowncontent + '\'' +
                ", tags='" + tags + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}
