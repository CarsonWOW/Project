package Service;

import Dao.FoodsTypeDao;
import Dao.FoodsTypeDaoImp;
import Po.FoodsType;

import java.util.List;

public class FoodTypeServiceImp implements FoodTypeService {
    private FoodsTypeDao foodsTypeDao=new FoodsTypeDaoImp();
    @Override
    public List<FoodsType> findAll(FoodsType foodsType) {
        return foodsTypeDao.findAll(foodsType);
    }
}
