package Service;

import Po.News;
import Utils.Page;

import java.util.List;

public interface NewsService {
    /**
     * 添加新闻
     */
    /**
     * 添加新闻
     */
    public int save(News news);
    /**
     * 删除新闻
     */
    public int delete(int id);

    /**
     * 根据id查询新闻
     */
    public News findById(int id);
    /**
     * 修改
     */
    public int update(News news);
    /**
     * 分页查询
     */
    public List<News> NewsQueryAll(News news, Page page);
    /**
     * 获取总条数
     */
    public int getTotalCount(News news);
}
