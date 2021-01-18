package Dao;

import Po.Foods;
import Po.News;
import Utils.Page;

import java.util.List;

public interface FoodsDao {
    /**
     * 添加菜品
     */

    public int save(Foods foods);
    /**
     * 删除菜品
     */
    public int delete(int id);

    /**
     * 根据id查询菜品
     */
    public Foods findById(int id);
    /**
     * 修改菜品
     */
    public int update(Foods foods);
    /**
     * 分页查询菜品
     */
    public List<Foods> FoodsQueryAll(Foods foods, Page page);
    /**
     * 获取总条数
     */
    public int getTotalCount(Foods foods);
   /* *//**
     * 根据菜品种类id查询
     *//*
    public List<Foods> FindByFoodsTypeID(int foodTypeID,Page page);
    *//**
     * 获取相同种类的总条数
     *//*
    public int getFoodsTypeTotalCount(Foods foods);*/

}
