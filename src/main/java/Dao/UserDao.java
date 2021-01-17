package Dao;

import Po.User;
import Utils.Page;

import java.util.List;

public interface UserDao {
    /**
     * 查询总条数
     */
    public int getTotalCount(User user);
    /**
     * 分页查询
     */
    public List<User> getPageUser(Page page, User user);
    /**
     * 登陆
     * @return
     */
    public User login(String userName, String pwd);
    /**
     * 添加
     */
    public int addUser(User user);
    /**
     * 删除,根据id删除
     */
    public int deleteUser(int id);
    /**
     * 修改
     * 先根据id查询,在修改
     */
    public User findbyid(int id);
    /**
     * 修改
     */
    public int updateUser(User user);
    /**
     * 根据用户名查询
     */
    public User findbyUsername(String name);
}
