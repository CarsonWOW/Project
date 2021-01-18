package Dao;

import Po.Foods;
import Po.News;
import Utils.BaseDao001;
import Utils.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodsDaoImp implements FoodsDao {
    @Override
    public int save(Foods foods) {
        String sql="INSERT INTO food (FoodName,Pirce,Picture,FoodTypeID,Foodprint) VALUES(?,?,?,?,?)";
        Object num[]={foods.getFoodName(),foods.getfPrice(),foods.getfPicture(),foods.getfTid(),foods.getFoodPrint()};
        int i=0;
        try {
            i= BaseDao001.executeUpdate(sql,num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int delete(int id) {
        String sql="DELETE FROM food WHERE ID=?";
        Object num[]={id};
        int i=0;
        try {
            i= BaseDao001.executeUpdate(sql,num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Foods findById(int id) {
        Foods foods = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM food WHERE ID=?";
        conn = BaseDao001.getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setObject(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                foods = new Foods();
                foods.setfId(rs.getInt(1));
                foods.setFoodName(rs.getString(2));
                foods.setfPrice(rs.getString(3));
                foods.setfPicture(rs.getString(4));
                foods.setfTid(rs.getInt(5));
                foods.setFoodPrint(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao001.closeAll(conn, pstm, rs);
        }
        return foods;
    }

    @Override
    public int update(Foods foods) {
        String sql="UPDATE food SET FoodName=?,Pirce=?,FoodTypeID=?,Foodprint=? WHERE ID=?";
        Object num[]={foods.getFoodName(),foods.getfPrice(),foods.getfTid(),foods.getFoodPrint(),foods.getfId()};
        int i=0;
        try {
            i= BaseDao001.executeUpdate(sql,num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Foods> FoodsQueryAll(Foods foods, Page page) {
        Foods foods1=null;
        List<Foods> list = new ArrayList<Foods>();
        String sql ="SELECT * FROM food WHERE 1=1 ";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        if (foods.getFoodName()!=null){//按照食物名查询
            sql=sql+" AND FoodName LIKE '%"+foods.getFoodName()+"%'";

        }else if (foods.getfTid()!=0){
            sql=sql+"AND FoodTypeID="+foods.getfTid();
        }
            sql+=" LIMIT ?,?";
            System.out.println(sql);

        try {
            conn=BaseDao001.getConnection();
            pstm=conn.prepareStatement(sql);
            int begin = (page.getCurPageNo() - 1) * page.getPageSize();
            int end = page.getPageSize();
            pstm.setObject(1, begin);
            pstm.setObject(2, end);
            rs = pstm.executeQuery();
            while (rs.next()) {
                foods = new Foods();
                foods.setfId(rs.getInt(1));
                foods.setFoodName(rs.getString(2));
                foods.setfPrice(rs.getString(3));
                foods.setfPicture(rs.getString(4));
                foods.setfTid(rs.getInt(5));
                foods.setFoodPrint(rs.getString(6));
                list.add(foods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao001.closeAll(conn, pstm, rs);
        }
        return list;
    }

    @Override
    public int getTotalCount(Foods foods) {
        int count = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM food ";
        if (foods.getFoodName()!=null){
            sql=sql+" WHERE FoodName LIKE '%"+foods.getFoodName()+"%'";
        }else if (foods.getfTid()!=0){
            sql=sql+"WHERE FoodTypeID="+foods.getfTid();
        }
        System.out.println(sql);
        try {
            //1建立连接
            conn = BaseDao001.getConnection();
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while (rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao001.closeAll(conn,pstm,rs);
        }
        return count;
    }

    /*@Override
    public List<Foods> FindByFoodsTypeID(int foodTypeID,Page page) {
        List<Foods> list =new ArrayList<Foods>();
        Foods foods = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM food WHERE FoodTypeID=? LIMIT ?,?";

        conn = BaseDao001.getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setObject(1, foodTypeID);
            int begin = (page.getCurPageNo() - 1) * page.getPageSize();
            int end = page.getPageSize();
            pstm.setObject(2, begin);
            pstm.setObject(3, end);
            rs = pstm.executeQuery();
            while (rs.next()) {
                foods = new Foods();
                foods.setfId(rs.getInt(1));
                foods.setFoodName(rs.getString(2));
                foods.setfPrice(rs.getString(3));
                foods.setfPicture(rs.getString(4));
                foods.setfTid(rs.getInt(5));
                foods.setFoodPrint(rs.getString(6));
                list.add(foods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao001.closeAll(conn, pstm, rs);
        }
        return list;
    }*/
}
