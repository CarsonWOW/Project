package Dao;

import Po.FoodsType;
import Utils.BaseDao001;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodsTypeDaoImp implements FoodsTypeDao {
    @Override
    public List<FoodsType> findAll(FoodsType foodsType) {
        List<FoodsType>list=new ArrayList<FoodsType>();
        FoodsType foodsType1=null;
        String sql="SELECT * FROM foodtype";
        Connection con=null;
        PreparedStatement pstm=null;
        ResultSet res=null;
        con= BaseDao001.getConnection();
        try {
            pstm=con.prepareStatement(sql);
            res=pstm.executeQuery();
            while (res.next()){
                foodsType1=new FoodsType();
                foodsType1.setFoodsTypeId(res.getInt(1));
                foodsType1.setFoodsTypeName(res.getString(2));
                foodsType1.setChildId(res.getInt(3));
                list.add(foodsType1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao001.closeAll(con,pstm,res);
        }
        return list;
    }

    /*@Override
    public FoodsType findByTypeId(int id) {
        return null;
    }*/

}
