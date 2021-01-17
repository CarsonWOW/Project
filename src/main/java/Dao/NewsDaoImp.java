package Dao;

import Po.News;
import Utils.BaseDao001;
import Utils.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImp implements NewsDao {
    @Override
    public int save(News news) {
        String sql="INSERT INTO NEWS(New_title,New_description,New_Ddescription,New_createtime,New_Picture) VALUES(?,?,?,NOW(),?)";
        Object num[]={news.getNewTitle(),news.getNewDes(),news.getNewDDes(),news.getNewPicture()};
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
        String sql="DELETE FROM NEWS WHERE New_id=?";
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
    public News findById(int id) {
        News news = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM NEWS WHERE New_id=?";
        conn = BaseDao001.getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setObject(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                news = new News();
                news.setNewId(rs.getInt(1));
                news.setNewTitle(rs.getString(2));
                news.setNewDes(rs.getString(3));
                news.setNewDDes(rs.getString(4));
                news.setCreateTime(rs.getDate(5));
                news.setNewPicture(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao001.closeAll(conn, pstm, rs);
        }
        return news;

    }

    @Override
    public int update(News news) {
        String sql="UPDATE NEWS SET New_title=?,New_description=?,New_Ddescription=? WHERE New_id=?";
        Object num[]={news.getNewTitle(),news.getNewDes(),news.getNewDDes(),news.getNewId()};
        int i=0;
        try {
            i= BaseDao001.executeUpdate(sql,num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public List<News> NewsQueryAll(News news1, Page page) {
        List<News>list=new ArrayList<News>();
        News news = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM NEWS LIMIT ?,?";
        conn = BaseDao001.getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            int begin = (page.getCurPageNo() - 1) * page.getPageSize();
            int end = page.getPageSize();
            pstm.setObject(1, begin);
            pstm.setObject(2, end);
            rs = pstm.executeQuery();
            while (rs.next()) {
                news = new News();
                news.setNewId(rs.getInt(1));
                news.setNewTitle(rs.getString(2));
                news.setNewDes(rs.getString(3));
                news.setNewDDes(rs.getString(4));
                news.setCreateTime(rs.getDate(5));
                news.setNewPicture(rs.getString(6));
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao001.closeAll(conn, pstm, rs);
        }
        return list;
    }


    @Override
    public int getTotalCount(News news) {
        int count = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM NEWS ";
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
