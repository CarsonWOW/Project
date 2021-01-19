package Dao;

import Po.Shops;
import Utils.Page;

import java.util.List;

public interface ShopsDao {
    /**
     * 添加店面
     */

    public int save(Shops shops);
    /**
     * 删除店面
     */
    public int delete(int id);

    /**
     * 根据id查询店面
     */
    public Shops findById(int id);
    /**
     * 修改店面
     */
    public int update(Shops shops);
    /**
     * 分页查询
     */
    public List<Shops> FoodsQueryAll(Shops shops, Page page);
    /**
     * 获取总条数
     */
    public int getTotalCount(Shops shops);
}
