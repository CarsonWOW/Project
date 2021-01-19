package Service.impl;

import Dao.ShopsTypeDao;
import Dao.impl.ShopsTypeDaoImpl;
import Po.ShopsType;
import Service.ShopTypeService;

import java.util.List;

public class ShopTypeServiceImpl implements ShopTypeService {
    private ShopsTypeDao shopsTypeDao=new ShopsTypeDaoImpl();
    /**
     * 查询所有店面种类
     * @param shopsType
     * @return
     */
    public List<ShopsType> findAll(ShopsType shopsType){
        return shopsTypeDao.findAll(shopsType);
    }
}
