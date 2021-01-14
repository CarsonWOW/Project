package Po;

import java.sql.Date;

public class News {
    private int id;
    private String NewsTitle;//新闻标题
    private String NewsDes;//新闻大纲
    private String NewsDDes;//新闻描述
    private Date createTime;//创建时间
    private String NewsPicture;//新闻图片

    public News() {
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", NewsTitle='" + NewsTitle + '\'' +
                ", NewsDes='" + NewsDes + '\'' +
                ", NewsDDes='" + NewsDDes + '\'' +
                ", createTime=" + createTime +
                ", NewsPicture='" + NewsPicture + '\'' +
                '}';
    }

    public News(int id, String newsTitle, String newsDes, String newsDDes, Date createTime, String newsPicture) {
        this.id = id;
        NewsTitle = newsTitle;
        NewsDes = newsDes;
        NewsDDes = newsDDes;
        this.createTime = createTime;
        NewsPicture = newsPicture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return NewsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        NewsTitle = newsTitle;
    }

    public String getNewsDes() {
        return NewsDes;
    }

    public void setNewsDes(String newsDes) {
        NewsDes = newsDes;
    }

    public String getNewsDDes() {
        return NewsDDes;
    }

    public void setNewsDDes(String newsDDes) {
        NewsDDes = newsDDes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNewsPicture() {
        return NewsPicture;
    }

    public void setNewsPicture(String newsPicture) {
        NewsPicture = newsPicture;
    }
}
