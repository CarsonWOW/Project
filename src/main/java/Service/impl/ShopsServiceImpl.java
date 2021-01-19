package Service.impl;

import Dao.ShopsDao;
import Dao.impl.ShopsDaoImpl;
import Po.Shops;
import Service.ShopsService;
import Utils.Page;

import java.util.List;

public class ShopsServiceImpl implements ShopsService {
    private ShopsDao shopsDao=new ShopsDaoImpl();
    /**
     * 添加店面
     */

    public int save(Shops shops){
        return shopsDao.save(shops);
    }
    /**
     * 删除店面
     */
    public int delete(int id){
        return shopsDao.delete(id);
    }

    /**
     * 根据id查询店面
     */
    public Shops findById(int id){
        return shopsDao.findById(id);
    }
    /**
     * 修改店面
     */
    public int update(Shops shops){
        return shopsDao.update(shops);
    }
    /**
     * 分页查询
     */
    public List<Shops> FoodsQueryAll(Shops shops, Page page){
        return shopsDao.FoodsQueryAll(shops,page);
    }
    /**
     * 获取总条数
     */
    public int getTotalCount(Shops shops){
        return shopsDao.getTotalCount(shops);
    }
}
