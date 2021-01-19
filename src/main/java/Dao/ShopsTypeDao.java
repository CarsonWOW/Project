package Dao;

import Po.ShopsType;
import java.util.List;

public interface ShopsTypeDao {
    /**
     * 查询所有店面种类
     * @param shopsType
     * @return
     */
    public List<ShopsType> findAll(ShopsType shopsType);

}
