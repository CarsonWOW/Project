package Service;

import Dao.FoodsDao;
import Dao.FoodsDaoImp;
import Po.Foods;
import Utils.Page;

import java.util.List;

public class FoodsServiceImp implements FoodsService {
    private FoodsDao foodsDao=new FoodsDaoImp();
    @Override
    public int save(Foods foods) {
        return foodsDao.save(foods);
    }

    @Override
    public int delete(int id) {
        return foodsDao.delete(id);
    }

    @Override
    public Foods findById(int id) {
        return foodsDao.findById(id);
    }

    @Override
    public int update(Foods foods) {
        return foodsDao.update(foods);
    }

    @Override
    public List<Foods> FoodsQueryAll(Foods foods, Page page) {
        return foodsDao.FoodsQueryAll(foods,page);
    }

    @Override
    public int getTotalCount(Foods foods) {
        return foodsDao.getTotalCount(foods);
    }

    /*@Override
    public List<Foods> FindByFoodsTypeID(int foodTypeID,Page page) {
        return foodsDao.FindByFoodsTypeID(foodTypeID,page);
    }*/
}
