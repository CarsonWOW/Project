package Service;

import Po.Foods;
import Utils.Page;

import java.util.List;

public interface FoodsService {
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
}
