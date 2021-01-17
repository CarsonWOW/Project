package Service;

import Dao.NewsDao;
import Dao.NewsDaoImp;
import Po.News;
import Utils.Page;

import java.util.List;

public class NewsServiceImp implements NewsService {
    private NewsDao newsDao=new NewsDaoImp();
    @Override
    public int save(News news) {
        return newsDao.save(news);
    }

    @Override
    public int delete(int id) {
        return newsDao.delete(id);
    }

    @Override
    public News findById(int id) {
        return newsDao.findById(id);
    }

    @Override
    public int update(News news) {
        return newsDao.update(news);
    }

    @Override
    public List<News> NewsQueryAll(News news, Page page) {
        return newsDao.NewsQueryAll(news,page);
    }

    @Override
    public int getTotalCount(News news) {
        return newsDao.getTotalCount(news);
    }
}
