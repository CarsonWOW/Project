package Dao;

import Po.FoodsType;

import java.util.List;

public interface FoodsTypeDao {
    /**
     * 查询所有菜品种类
     * @param foodsType
     * @return
     */
    public List<FoodsType> findAll(FoodsType foodsType);
    /**
     * 根据父id查询菜品种类
     */
    /*public FoodsType findByTypeId(int id);*/
}
