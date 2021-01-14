package Utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao001 {
    //创建一个mysql配置文件,将相同的属性名放在外面定义,
    private static String forname;
    private static String Url;
    private static String user;
    private static String pwd;
    static {
        init();
    }

    private static void init() {
        //在这里面,给上面的属性赋值,值从哪里来？
        //这个代码,不需要大家自己写,会赋值就可以
        //1.创建Properties文件
        Properties properties=new Properties();
        //2.拿到文件路径 sbq.properties是在scr目录下
        String path="dq.properties";
        //通过输入流读取sbq.properties
        InputStream is= BaseDao001.class.getClassLoader().getResourceAsStream(path);
        //把值加载到Properties对象中
        try {
            properties.load(is);
        }catch (Exception e){
            e.printStackTrace();
        }
        //通过键去获取值
        forname=properties.getProperty("name");
        System.out.println(forname);
        Url=properties.getProperty("url");
        user=properties.getProperty("user1");
        pwd=properties.getProperty("pwd1");
    }

    //封装加载驱动和建立连接
    public static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName(forname);
            con= DriverManager.getConnection(Url,user,pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
    //封装释放资源,三个释放资源的参数
    public static void closeAll(Connection con, Statement pstm, ResultSet res){
        //必须判断不能为空,才能释放资源,否则会报空指针错误
        try {
            if (res!=null){
                res.close();
            }
            if (pstm!=null){
                pstm.close();
            }
            if (con!=null){
                con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 封装executeUpdate,增删改
     * @param
     */
    public static int executeUpdate(String sql,Object sbq[]) throws SQLException {
        int num=0;
        Connection con=null;
        PreparedStatement pstm=null;
        con= BaseDao001.getConnection();
        pstm=con.prepareStatement(sql);
        //循环存放的数组,数组里面是赋值语句,赋值语句有多少,长度就有多少,赋值从1开始,所有i+1
        for (int i=0;i<sbq.length;i++){
            pstm.setObject(i+1,sbq[i]);
        }
        //执行预编制语言
        num=pstm.executeUpdate();
        //释放资源
        BaseDao001.closeAll(con,pstm,null);
        return num;
    }

    public static void main(String[] args) {
        System.out.println(forname);
    }
}
