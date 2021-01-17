package Po;

import java.util.Date;

public class User {
    private  int buUserId;
    private  String buEmail;        //email
    private  String buUserName ;    //用户名
    private  String buPassword;     //密码
    private  String buSex;          //性别 1.男 2女 3未知
    private Date buBirthday;      //生日
    private  String buMobile;        //手机号码
    private  Date  buCreatetime;  //创建时间
    private  Date  buUpdatetime;  //修改时间
    private  int buStatus;       //用户权限状态，1普通用户  2管理员

    public User(int buUserId, String buEmail, String buUserName, String buPassword, String buSex, Date buBirthday, String buMobile, Date buCreatetime, Date buUpdatetime, int buStatus) {
        this.buUserId = buUserId;
        this.buEmail = buEmail;
        this.buUserName = buUserName;
        this.buPassword = buPassword;
        this.buSex = buSex;
        this.buBirthday = buBirthday;
        this.buMobile = buMobile;
        this.buCreatetime = buCreatetime;
        this.buUpdatetime = buUpdatetime;
        this.buStatus = buStatus;
    }

    public User() {
    }

    public int getBuUserId() {
        return buUserId;
    }

    public void setBuUserId(int buUserId) {
        this.buUserId = buUserId;
    }

    public String getBuEmail() {
        return buEmail;
    }

    public void setBuEmail(String buEmail) {
        this.buEmail = buEmail;
    }

    public String getBuUserName() {
        return buUserName;
    }

    public void setBuUserName(String buUserName) {
        this.buUserName = buUserName;
    }

    public String getBuPassword() {
        return buPassword;
    }

    public void setBuPassword(String buPassword) {
        this.buPassword = buPassword;
    }

    public String getBuSex() {
        return buSex;
    }

    public void setBuSex(String buSex) {
        this.buSex = buSex;
    }

    public Date getBuBirthday() {
        return buBirthday;
    }

    public void setBuBirthday(Date buBirthday) {
        this.buBirthday = buBirthday;
    }

    public String getBuMobile() {
        return buMobile;
    }

    public void setBuMobile(String buMobile) {
        this.buMobile = buMobile;
    }

    public Date getBuCreatetime() {
        return buCreatetime;
    }

    public void setBuCreatetime(Date buCreatetime) {
        this.buCreatetime = buCreatetime;
    }

    public Date getBuUpdatetime() {
        return buUpdatetime;
    }

    public void setBuUpdatetime(Date buUpdatetime) {
        this.buUpdatetime = buUpdatetime;
    }

    public int getBuStatus() {
        return buStatus;
    }

    public void setBuStatus(int buStatus) {
        this.buStatus = buStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "buUserId=" + buUserId +
                ", buEmail='" + buEmail + '\'' +
                ", buUserName='" + buUserName + '\'' +
                ", buPassword='" + buPassword + '\'' +
                ", buSex='" + buSex + '\'' +
                ", buBirthday=" + buBirthday +
                ", buMobile='" + buMobile + '\'' +
                ", buCreatetime=" + buCreatetime +
                ", buUpdatetime=" + buUpdatetime +
                ", buStatus=" + buStatus +
                '}';
    }
}
