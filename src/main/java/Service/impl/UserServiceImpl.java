package Service.impl;

import Dao.UserDao;
import Dao.impl.UserDaoImpl;
import Po.User;
import Service.UserService;
import Utils.Page;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 查询总条数
     */
    public int getTotalCount(User user){
        return userDao.getTotalCount(user);
    }
    /**
     * 分页查询
     */
    public List<User> getPageUser(Page page, User user){
        return  userDao.getPageUser(page,user);
    }
    /**
     * 登陆
     */
    public User login(String userName, String pwd){
        return  userDao.login(userName,pwd);

    }
    /**
     * 添加
     */
    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }
    /**
     * 删除,根据id删除
     */
    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }
    /**
     * 修改
     * 先根据id查询,在修改
     */
    @Override
    public User findbyid(int id) {
        return userDao.findbyid(id);
    }
    /**
     * 修改
     */
    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
    /**
     * 根据用户名查询
     */
    @Override
    public User findbyUsername(String name) {
        return userDao.findbyUsername(name);
    }
}
