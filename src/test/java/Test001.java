import Dao.FoodsTypeDao;
import Dao.FoodsTypeDaoImp;
import Po.Foods;
import Po.FoodsType;
import Po.News;
import Service.*;
import Utils.Page;

import java.util.ArrayList;
import java.util.List;

public class Test001 {
    public static void main(String[] args) {
        NewsService newsService=new NewsServiceImp();
        FoodsService foodsService=new FoodsServiceImp();
        FoodTypeService foodTypeService=new FoodTypeServiceImp();
        Page page=new Page();
        Foods foods=new Foods();
        foods.setfTid(1);
       List<Foods> list= foodsService.FoodsQueryAll(foods,page);
       for (Foods f:list){
           System.out.println(f);
       }
        /*Foods food=new Foods();
        food.setFoodName("牛");
        int i= foodsService.getTotalCount(food);
        System.out.println(i);*/
        //Foods foods=new Foods();
        //foods.setFoodName("牛");
       /* Foods foods=new Foods();
        Page page=new Page();
         List<Foods> list= foodsService.FoodsQueryAll(foods,page);
         for (Foods f:list){
             System.out.println(f);
         }*/
        /*Foods foods=new Foods();
        foods.setfPicture("33.img");
        foods.setFoodName("测试");
        foods.setfPrice("10元");
        foods.setfTid(1);
         int i= foodsService.save(foods);
        System.out.println(i);*/
        /*List<FoodsType> list1=foodTypeService.findAll(null);
        for (FoodsType f:list1){
            System.out.println(f);
        }*/
       /* News news=newsService.findById(1);
        System.out.println(news);*/
       /* Page page=new Page();
        List<News> list=newsService.NewsQueryAll(null,page);
        for (News n:list){
            System.out.println(n);
        }*/
       /* News news=new News();
        news.setNewDes("ssss");
        news.setNewPicture("sss");
        news.setNewDDes("dddddddd");
        news.setNewTitle("sssssssssssss");
        int i= newsService.save(news);
        System.out.println(i);*/
       /* Page page=new Page();
       List<Foods> list=foodsService.FoodsQueryAll(null,page);
       for (Foods f:list){
           System.out.println(f);
       }*/

    }
}
