package Service;

import Po.FoodsType;

import java.util.List;

public interface FoodTypeService {
    /**
     * 查询所有菜品种类
     * @param foodsType
     * @return
     */
    public List<FoodsType> findAll(FoodsType foodsType);
}
