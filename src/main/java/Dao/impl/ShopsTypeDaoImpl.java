package Dao.impl;

import Dao.ShopsTypeDao;
import Po.ShopsType;
import Utils.BaseDao001;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopsTypeDaoImpl implements ShopsTypeDao {
    /**
     * 查询所有店面种类
     * @param shopsType
     * @return
     */
    @Override
    public List<ShopsType> findAll(ShopsType shopsType) {
        List<ShopsType>list=new ArrayList<ShopsType>();
        ShopsType shopsType1=null;
        String sql="SELECT * FROM ShopType";
        Connection con=null;
        PreparedStatement pstm=null;
        ResultSet res=null;
        con= BaseDao001.getConnection();
        try {
            pstm=con.prepareStatement(sql);
            res=pstm.executeQuery();
            while (res.next()){
                shopsType1=new ShopsType();
                shopsType1.setBU_Id(res.getInt(1));
                shopsType1.setBU_Name(res.getString(2));
                shopsType1.setBU_shopTypeId(res.getInt(3));
                list.add(shopsType1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao001.closeAll(con,pstm,res);
        }
        return list;
    }
}
