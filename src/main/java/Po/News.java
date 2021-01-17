package Po;

import java.sql.Date;

public class News {
    private int newId;
    private String newPicture;//新闻图片
    private String newTitle;
    private String newDes;//新闻大纲
    private String newDDes;//新闻描述
    private Date createTime;//时间

    public News() {

    }

    @Override
    public String toString() {
        return "News{" +
                "newId=" + newId +
                ", newTitle='" + newTitle + '\'' +
                ", newDes='" + newDes + '\'' +
                ", newDDes='" + newDDes + '\'' +
                ", createTime=" + createTime +
                ", newPicture='" + newPicture + '\'' +
                '}';
    }



    public News(int newId, String newTitle, String newDes, String newDDes, Date createTime, String newPicture) {
        this.newId = newId;
        this.newTitle = newTitle;
        this.newDes = newDes;
        this.newDDes = newDDes;
        this.createTime = createTime;
        this.newPicture = newPicture;
    }

    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getNewDes() {
        return newDes;
    }

    public void setNewDes(String newDes) {
        this.newDes = newDes;
    }

    public String getNewDDes() {
        return newDDes;
    }

    public void setNewDDes(String newDDes) {
        this.newDDes = newDDes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNewPicture() {
        return newPicture;
    }

    public void setNewPicture(String newPicture) {
        this.newPicture = newPicture;
    }
}
