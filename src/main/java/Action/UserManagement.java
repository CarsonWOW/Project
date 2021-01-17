package Action;

import Po.User;
import Service.UserService;
import Service.impl.UserServiceImpl;
import Utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@WebServlet(urlPatterns = "*.user")
public class UserManagement extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求编码格式 Request  从前端传递过来的参数
        req.setCharacterEncoding("UTF-8");
        //处理  Response 响映编码格式  就是值从后台需要传递到前端
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        /**
         * 获取url
         */
        String uri = req.getRequestURI();
        /**
         * 截取
         */
        String url = (String) uri.subSequence(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
        //判断
        if ("queryUser".equals(url)) {  //分页
            //1.获取当前页
            String sbqCurPageNo = req.getParameter("curPageNo");
            //2.默认设置为第一页
            int curPageNo = 1;
            //3.判断  sbqCurPageNo 是否有值，如果有值 把值赋给    curPageNo
            if (sbqCurPageNo != null) {
                curPageNo = Integer.parseInt(sbqCurPageNo);
            }
            //4.创建Page 对象  把获取到的值存入Page中
            Page page = new Page();
            page.setCurPageNo(curPageNo);//把上面所定义的当前页赋值给Page 中的  curPageNo
            //5.调用分页查询方法
            List<User> list = userService.getPageUser(page, null);
            //这里还没有写完的，等会写，需要调用总条数方法，然后设置值
            //获取总条数
            int totalCount = userService.getTotalCount(null);
            //必需把值设置到 Page 中的 totalCount 总条数
            page.setTotalCount(totalCount);
            //6.把 list 和 page  值存入  HttpServletRequest 中
            req.setAttribute("list", list);
            req.setAttribute("page", page);
            //7.必需使用转发
            req.getRequestDispatcher("user.jsp").forward(req, resp);
        } else if ("addUser".equals(url)) {   //添加
            //获取input中的值
            String Email = req.getParameter("Email");
            String userName = req.getParameter("userName");
            String passWord = req.getParameter("passWord");
            String sex = req.getParameter("sex");
            String time = req.getParameter("birthyear") + "-" + req.getParameter("birthmonth") + "-" + req.getParameter("birthday");
            Date date = Date.valueOf(time);
            String mobile = req.getParameter("mobile");
            String status = req.getParameter("STATUS");
            Integer status1 = Integer.parseInt(status);
            /**
             * 创建user对象
             */
            User user = new User();
            user.setBuEmail(Email);
            user.setBuUserName(userName);
            user.setBuPassword(passWord);
            user.setBuSex(sex);
            user.setBuBirthday(date);
            user.setBuMobile(mobile);
            user.setBuStatus(status1);
            userService.addUser(user);
            req.getRequestDispatcher("queryUser.user").forward(req, resp);
        } else if ("findbyUsername".equals(url)) {  //根据用户名查询
            //获取用户名
            String UserName = req.getParameter("userName");
            User user = userService.findbyUsername(UserName);
            if (user != null) {
                out.println(1);
            } else {
                out.println(0);
            }
        } else if ("findbyid".equals(url)) {  //先根据id查询,在修改
            //获取id
            String idsbq = req.getParameter("id");
            Integer id = Integer.parseInt(idsbq);
            //调用根据id查询方法
            User user = userService.findbyid(id);
            //将user对象存入作用域中
            req.setAttribute("user", user);
            //转发
            req.getRequestDispatcher("user-modify.jsp").forward(req, resp);
        } else if ("updateUser".equals(url)) {  //修改
            //获取id
            String idsbq = req.getParameter("id");
            Integer id = Integer.parseInt(idsbq);
            String Email = req.getParameter("Email");
            String userName = req.getParameter("userName");
            String passWord = req.getParameter("passWord");
            String sex = req.getParameter("sex");
            String time = req.getParameter("birthyear") + "-" + req.getParameter("birthmonth") + "-" + req.getParameter("birthday");
            Date date = Date.valueOf(time);
            String mobile = req.getParameter("mobile");
            String status = req.getParameter("STATUS");
            Integer status1 = Integer.parseInt(status);
            //创建user对象
            User user = new User();
            user.setBuUserId(id);
            user.setBuSex(sex);
            user.setBuMobile(mobile);
            user.setBuBirthday(date);
            user.setBuPassword(passWord);
            user.setBuEmail(Email);
            user.setBuUserName(userName);
            user.setBuStatus(status1);
            //调用业务层修改方法
            userService.updateUser(user);
            req.getRequestDispatcher("queryUser.user").forward(req, resp);
        } else if ("user-delete".equals(url)) {   //删除
            //获取id
            String idsbq = req.getParameter("id");
            Integer id = Integer.parseInt(idsbq);
            //调用业务层删除方法
            userService.deleteUser(id);
            //转发
            req.getRequestDispatcher("queryUser.user").forward(req, resp);
        }else if ("login".equals(url)) {  //登录
            //获取字符串
            String name = req.getParameter("sbqUname");
            String pwd = req.getParameter("pwd");
            //1.创建业务层对象
            User user = userService.login(name, pwd);

            if (user != null) {
                req.getRequestDispatcher("/manage/index.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }
}
