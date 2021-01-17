package Dao.impl;

import Dao.UserDao;
import Po.User;
import Utils.BaseDao001;
import Utils.Page;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    /**
     * 查询总条数
     */
    public int getTotalCount(User user){
        int count = 0;
        Connection conn =null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            //1.加载驱动
            conn = BaseDao001.getConnection();
            String sql = "SELECT * FROM USER  WHERE 1=1 ";
            //3.处理预编译SQL语句  PreparedStatement  这里会使用到? 就是占位符  从左边开始数

            //4.如果有 第三步有使用到? 占位符，这里就必需给所有? 赋值   上面有多少个，必需全部赋值
            int num = 1;
            if(user!=null){
                if(!user.getBuSex().equals("")){
                    sql=sql+" and SEX= ?";

                }
            }
            pstm =conn.prepareStatement(sql);
            System.out.println(sql);
            if(user!=null){
                if(!user.getBuSex().equals("")){
                    pstm.setObject(num++,user.getBuSex());

                }
            }

            //结束
            //5.执行预编译SQL语句
            rs = pstm.executeQuery();
            //6.循环；
            while (rs.next()){
                //这里一定要创建User对象  请务必创建一个
                count =rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao001.closeAll(conn,pstm,rs);
        }

        return  count;
    }
    /**
     * 分页查询
     */
    public List<User> getPageUser(Page page, User user){
        //1.创建ArrayList
        List<User> list = new ArrayList<User>();
        Connection conn =null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            //1.加载驱动
            conn = BaseDao001.getConnection();
            String sql = "SELECT * FROM USER  WHERE 1=1 ";
            //3.处理预编译SQL语句  PreparedStatement  这里会使用到? 就是占位符  从左边开始数

            //4.如果有 第三步有使用到? 占位符，这里就必需给所有? 赋值   上面有多少个，必需全部赋值
            int num = 1;
            if(user!=null){
                if(!user.getBuSex().equals("")){
                    sql=sql+" and SEX= ?";

                }
            }

            sql+= " LIMIT ?,?";
            pstm =conn.prepareStatement(sql);

            System.out.println(sql);
            if(user!=null){
                if(!user.getBuSex().equals("")){
                    pstm.setObject(num++,user.getBuSex());

                }
            }
            //各位同学一定要debug调试
            //开始  (当前页-1)*每页显示几条
            int  begin = (page.getCurPageNo()-1)*page.getPageSize();
            int end = page.getPageSize();
            pstm.setObject(num++,begin);
            pstm.setObject(num++,end);

            //结束
            //5.执行预编译SQL语句
            rs = pstm.executeQuery();
            //6.循环；
            while (rs.next()){
                //这里一定要创建User对象  请务必创建一个
                User user1 = new User();
                user1.setBuUserId(rs.getInt(1));
                user1.setBuEmail(rs.getString(2));
                user1.setBuUserName(rs.getString(3));
                user1.setBuPassword(rs.getString(4));
                user1.setBuSex(rs.getString(5));
                user1.setBuBirthday(rs.getDate(6));
                user1.setBuMobile(rs.getString(7));
                user1.setBuCreatetime(rs.getDate(8));
                user1.setBuUpdatetime(rs.getDate(9));
                user1.setBuStatus(rs.getInt(10));
                list.add(user1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao001.closeAll(conn,pstm,rs);
        }

        return  list;

    }
    /**
     * 登陆
     * @return
     */
    public User login(String userName , String pwd){
        User user =null;
        Connection conn =null;
        PreparedStatement pstm =null;
        ResultSet rs=null;
        try {
            //1.建立连接  Connection
            conn = BaseDao001.getConnection();
            //2.处理预编译sql语句
            pstm = conn.prepareStatement("SELECT * FROM USER WHERE USER_NAME=? AND PASSWORD=? ");
            pstm.setObject(1,userName);
            pstm.setObject(2,pwd);
            //3.执行预编译sql语句
            rs = pstm.executeQuery();
            //4.循环遍历
            while (rs.next()){
                user = new User();
                user.setBuUserId(rs.getInt(1));
                user.setBuUserName(rs.getString(3));
                user.setBuPassword(rs.getString(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源,不管有没有错，都执行。
            BaseDao001.closeAll(conn,pstm,rs);
        }

        return user;
    }
    /**
     * 添加
     */
    @Override
    public int addUser(User user) {
        int i= 0;
        Connection conn =null;
        PreparedStatement pstm =null;
        try {
            //1.建立连接  Connection
            conn = BaseDao001.getConnection();
            //2.处理预编译sql语句
            String sql="INSERT INTO USER(EMAIL,USER_NAME,PASSWORD,SEX,BIRTHDAY,MOBILE,\n" +
                    "createtime,updatetime,STATUS)VALUES(?,\n" +
                    "?,?,?,?,?,NOW(),NULL,?);";
            pstm = conn.prepareStatement(sql);
            //3.给点位符赋值
            pstm.setObject(1,user.getBuEmail());
            pstm.setObject(2,user.getBuUserName());
            pstm.setObject(3,user.getBuPassword());
            pstm.setObject(4,user.getBuSex());
            pstm.setObject(5,user.getBuBirthday());
            pstm.setObject(6,user.getBuMobile());
            pstm.setObject(7,user.getBuStatus());
            //4.执行预编译sql语句executeUpdate(注意这里没有sql语句 ) DML使用
            i =pstm.executeUpdate();
            System.out.println("添加成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源,不管有没有错，都执行。
            BaseDao001.closeAll(conn,pstm,null);
        }
        return i;
    }
    /**
     * 删除
     */
    @Override
    public int deleteUser(int id) {
        int i= 0;
        Connection conn =null;
        PreparedStatement pstm =null;
        try {
            //1.加载驱动
            conn = BaseDao001.getConnection();
            //2.处理预编译sql语句
            String sql = "DELETE FROM USER WHERE User_ID=?";
            pstm = conn.prepareStatement(sql);
            //3.给点位符赋值
            pstm.setObject(1,id);
            //4.执行预编译sql语句executeUpdate(注意这里没有sql语句 ) DML使用
            i =pstm.executeUpdate();
            System.out.println("删除成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源,不管有没有错，都执行。
            BaseDao001.closeAll(conn,pstm,null);
        }
        return  i;

    }
    /**
     * 修改
     * 先根据id查询,在修改
     */
    @Override
    public User findbyid(int id) {
        User user=null;
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try {
            conn=BaseDao001.getConnection();
            //2.处理预编译SQL语句
            String sql="SELECT * FROM USER WHERE User_ID=?";
            pstm=conn.prepareStatement(sql);
            //3.给点位符赋值
            pstm.setObject(1,id);
            //4.执行预编译sql语句
            rs=pstm.executeQuery();
            //5.循环遍历
            while (rs.next()){
                user=new User();
                user.setBuUserId(rs.getInt(1));
                user.setBuEmail(rs.getString(2));
                user.setBuUserName(rs.getString(3));
                user.setBuPassword(rs.getString(4));
                user.setBuSex(rs.getString(5));
                user.setBuBirthday(rs.getDate(6));
                user.setBuMobile(rs.getString(7));
                user.setBuCreatetime(rs.getDate(8));
                user.setBuUpdatetime(rs.getDate(9));
                user.setBuStatus(rs.getInt(10));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            BaseDao001.closeAll(conn,pstm,rs);
        }
        return user;
    }
    /**
     * 修改
     */
    @Override
    public int updateUser(User user) {
        int i = 0;
        Connection conn =null;
        PreparedStatement pstm =null;
        try {
            //1.建立连接  Connection
            conn =BaseDao001.getConnection();
            //2.处理预编译sql语句
            String sql="UPDATE USER SET EMAIL=?,USER_NAME=?,PASSWORD=?,SEX=?,BIRTHDAY=?,MOBILE=?,updatetime=NOW(),STATUS=? WHERE User_ID=?";
            pstm=conn.prepareStatement(sql);
            //3.给点位符赋值
            pstm.setObject(1,user.getBuEmail());
            pstm.setObject(2,user.getBuUserName());
            pstm.setObject(3,user.getBuPassword());
            pstm.setObject(4,user.getBuSex());
            pstm.setObject(5,user.getBuBirthday());
            pstm.setObject(6,user.getBuMobile());
            pstm.setObject(7,user.getBuStatus());
            pstm.setObject(8,user.getBuUserId());
            //4.执行预编译sql语句executeUpdate(注意这里没有sql语句 ) DML使用
            i =pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao001.closeAll(conn,pstm,null);
        }
        return i;
    }

    /**
     * 根据用户名查询
     */
    @Override
    public User findbyUsername(String name) {
        User user=null;
        Connection conn=null;
        String sql="SELECT * FROM USER WHERE BU_USER_NAME=?";
        conn=BaseDao001.getConnection();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try {
            pstm=conn.prepareStatement(sql);
            //1.给点位符赋值
            pstm.setObject(1,name);
            //0.执行预编译sql语句
            rs=pstm.executeQuery();
            while (rs.next()){
                user=new User();
                user.setBuUserId(rs.getInt(1));
                user.setBuEmail(rs.getString(2));
                user.setBuUserName(rs.getString(3));
                user.setBuPassword(rs.getString(4));
                user.setBuSex(rs.getString(5));
                user.setBuBirthday(rs.getDate(6));
                user.setBuMobile(rs.getString(7));
                user.setBuCreatetime(rs.getDate(8));
                user.setBuUpdatetime(rs.getDate(9));
                user.setBuStatus(rs.getInt(10));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao001.closeAll(conn,pstm,rs);
        }
        return user;
    }
}
