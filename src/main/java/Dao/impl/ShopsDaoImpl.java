package Dao.impl;

import Dao.ShopsDao;
import Po.Shops;
import Utils.BaseDao001;
import Utils.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ShopsDaoImpl implements ShopsDao {
    /**
     * 添加店面
     */

    @Override
    public int save(Shops shops) {
        String sql="INSERT INTO Storefront (Shop_Name,Shop_TypeID,Shop_Cuisine,Shop_Business,Shop_Park,Shop_Site,Shop_Label,Shop_Picture)VALUES(?,?,?,?,?,?,?,?)";
        Object num[]={shops.getShopName(),shops.getShopTypeId(),shops.getShopCuisine(),shops.getShopBusiness(),shops.getShopPark(),shops.getShopSite(),shops.getShopLabel(),shops.getShopPicture()};
        int i=0;
        try {
            i= BaseDao001.executeUpdate(sql,num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    /**
     * 删除店面
     */
    @Override
    public int delete(int id) {
        String sql="DELETE FROM Storefront WHERE Shop_ID=?";
        Object num[]={id};
        int i=0;
        try {
            i= BaseDao001.executeUpdate(sql,num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    /**
     * 根据id查询店面
     */
    @Override
    public Shops findById(int id) {
        Shops shops = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Storefront WHERE Shop_ID=?";
        conn = BaseDao001.getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setObject(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                shops = new Shops();
                shops.setShopId(rs.getInt(1));
                shops.setShopName(rs.getString(2));
                shops.setShopTypeId(rs.getInt(3));
                shops.setShopCuisine(rs.getString(4));
                shops.setShopBusiness(rs.getString(5));
                shops.setShopPark(rs.getString(6));
                shops.setShopSite(rs.getString(7));
                shops.setShopLabel(rs.getString(8));
                shops.setShopPicture(rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao001.closeAll(conn, pstm, rs);
        }
        return shops;
    }
    /**
     * 修改店面
     */
    @Override
    public int update(Shops shops) {
        String sql="UPDATE Storefront SET Shop_Name=?,Shop_Cuisine=?,Shop_Business=?,Shop_TypeID=? WHERE Shop_ID=?";
        Object num[]={shops.getShopName(),shops.getShopCuisine(),shops.getShopBusiness(),shops.getShopTypeId(),shops.getShopId()};
        int i=0;
        try {
            i= BaseDao001.executeUpdate(sql,num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    /**
     * 分页查询
     */
    @Override
    public List<Shops> FoodsQueryAll(Shops shops, Page page) {
        Shops shops1=null;
        List<Shops> list = new ArrayList<Shops>();
        String sql ="SELECT * FROM Storefront WHERE 1=1 ";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        if (shops.getShopName()!=null){//按照店面名查询
            sql=sql+" AND Shop_Name LIKE '%"+shops.getShopName()+"%'";

        }else if (shops.getShopTypeId()!=0){
            sql=sql+"AND Shop_TypeID="+shops.getShopTypeId();
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
                shops = new Shops();
                shops.setShopId(rs.getInt(1));
                shops.setShopName(rs.getString(2));
                shops.setShopTypeId(rs.getInt(3));
                shops.setShopCuisine(rs.getString(4));
                shops.setShopBusiness(rs.getString(5));
                shops.setShopPark(rs.getString(6));
                shops.setShopSite(rs.getString(7));
                shops.setShopLabel(rs.getString(8));
                shops.setShopPicture(rs.getString(9));
                list.add(shops);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao001.closeAll(conn, pstm, rs);
        }
        return list;
    }
    /**
     * 获取总条数
     */
    @Override
    public int getTotalCount(Shops shops) {
        int count = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM Storefront ";
        if (shops.getShopName()!=null){//按照店面名查询
            sql=sql+" AND Shop_Name LIKE '%"+shops.getShopName()+"%'";
        }else if (shops.getShopTypeId()!=0){
            sql=sql+"AND Shop_TypeID="+shops.getShopTypeId();
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
}
