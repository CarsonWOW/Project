package Service;

import Po.ShopsType;

import java.util.List;

public interface ShopTypeService {
    /**
     * 查询所有店面种类
     * @param shopsType
     * @return
     */
    public List<ShopsType> findAll(ShopsType shopsType);
}
