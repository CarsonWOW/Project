package Action;

import Po.Foods;
import Po.FoodsType;
import Po.News;
import Service.*;
import Utils.Page;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(urlPatterns = "*.food")
public class FoodsAction  extends HttpServlet {
    private FoodsService foodsService = new FoodsServiceImp();
    private FoodTypeService foodTypeService = new FoodTypeServiceImp();
    private NewsService newsService = new NewsServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        /**
         * 获取url
         */
        String uri = req.getRequestURI();
        /**
         * 截取
         */
        String url = (String) uri.subSequence(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
        if ("Food".equals(url)) {
            //分页查询
            //获取当前页数
            String pageNow = req.getParameter("curPageNo");
            Integer curPageNo = 1;
            //判断不为空,否则会报空指针异常
            if (pageNow != null) {
                curPageNo = Integer.parseInt(pageNow);
            }
            //创建业务层
            Page page = new Page();
            Foods foods=new Foods();
            //将获取到的页数,存如pageInfo对象
            page.setCurPageNo(curPageNo);
            //将设置好的pageInfo对象,放入方法中
            List<Foods> list = foodsService.FoodsQueryAll(foods, page);
            //获取总条数
            int i = foodsService.getTotalCount(foods);
            //创建菜品种类
            List<FoodsType> foodsTypes = foodTypeService.findAll(null);
            //放入pageInfo对象中，获取总条数
            page.setTotalCount(i);
            //将list参数,存入作用域中,因为jsp需要键,来获取值
            req.setAttribute("foodsTypes", foodsTypes);
            req.setAttribute("list", list);
            //要将pageInfo对象存入作用域,因为需要键来获取页数
            req.setAttribute("page", page);
            //转发
            req.getRequestDispatcher("/manage/blogClass.jsp").forward(req, resp);
            /**
             * 添加菜单
             */
        } else if ("addFood".equals(url)) {
            List<FoodsType> foodsTypes = foodTypeService.findAll(null);
            //将参数存入作用域
            req.setAttribute("foodsTypes", foodsTypes);
            //转发
            req.getRequestDispatcher("/manage/blogClass-add.jsp").forward(req, resp);
        } else if ("showFood".equals(url)) {
            //获取请求参数
            String fieldName = "";
            String uploadFileName = "";
            Foods foods = new Foods();
            //解析请求之前先判断请求类型是否为文件上传类型
            boolean isMultipart = ServletFileUpload.isMultipartContent(req);
            String uploadFilePath = req.getServletContext().getRealPath("upload");

            File saveDir = new File(uploadFilePath);
            //如果目录不存在，就创建目录
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }

            if (isMultipart) {
                //创建文件上传核心类
                FileItemFactory factory = new DiskFileItemFactory(); // 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload
                ServletFileUpload upload = new ServletFileUpload(factory); // 用以上工厂实例化上传组件
                try {
                    //处理表单请求
                    List<FileItem> items = upload.parseRequest(req);
                    Iterator<FileItem> iter = items.iterator();
                    while (iter.hasNext()) {
                        FileItem item = (FileItem) iter.next();
                        if (item.isFormField()) {// 如果是普通表单控件
                            fieldName = item.getFieldName();// 获得该字段名称
                            if (fieldName.equals("parentId")) {
                                //news.setNewTitle(item.getString("UTF-8"));//获得该字段值
                                int parentId = Integer.parseInt(item.getString("UTF-8"));
                                foods.setfTid(parentId);
                            } else if (fieldName.equals("foodName")) {
                                //news.setNewDes(item.getString("UTF-8"));
                                foods.setFoodName(item.getString("UTF-8"));
                            } else if (fieldName.equals("foodPrice")) {
                                //news.setNewDDes(item.getString("UTF-8"));
                                foods.setfPrice(item.getString("UTF-8"));
                            }else if (fieldName.equals("foodPrint")){
                                foods.setFoodPrint(item.getString("UTF-8"));
                            }
                        } else {// 如果为文件域
                            String fileName = item.getName();// 获得文件名(全路径)
                            if (fileName != null && !fileName.equals("")) {
                                File fullFile = new File(fileName);
                                File saveFile = new File(uploadFilePath, fullFile.getName());//将文件保存到指定的路径
                                item.write(saveFile);
                                uploadFileName = fullFile.getName();
                                // news.setNewPicture(uploadFileName);
                                foods.setfPicture("img/"+uploadFileName);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("上传成功之后的文件名：" + foods.getfPicture());
                //调用业务层添加方法,将新闻信息添加进去
                int i = foodsService.save(foods);
                if (i>0) {
                    out.print("<script type='text/javascript'>\n" +
                            "    alert('添加成功！');\n" +
                            "    window.location.href='Food.food';\n" +
                            "</script>>");
                }
            }
            /**
             * 根据id查询
             */
        }else if ("findFoodsById".equals(url)){
            //获取请求参数id
            String idsbq=req.getParameter("id");
            Integer id=Integer.parseInt(idsbq);
            //调用业务层根据id查询方法
            Foods foods=foodsService.findById(id);
            //将foods对象存入作用域
            List<FoodsType> foodsTypes = foodTypeService.findAll(null);
            //将参数存入作用域
            req.setAttribute("foodsTypes", foodsTypes);
            req.setAttribute("foods",foods);
            //转发
            req.getRequestDispatcher("/manage/blogClass-modify.jsp").forward(req,resp);
            /**
             * 修改菜品
             */
        }else if ("updateFoods".equals(url)){
            //获取请求参数
            String idsbq=req.getParameter("id");//ID
            Integer id=Integer.parseInt(idsbq);
            String parentId=req.getParameter("parentId");//种类
            Integer parentId1=Integer.parseInt(parentId);
            String foodsName=req.getParameter("foodsName");//菜品名称
            String foodsPrice=req.getParameter("foodsPrice");//菜品价格
            String foodsPrint=req.getParameter("foodsPrint");
            //创建对象
            Foods foods=new Foods();
            foods.setfTid(parentId1);
            foods.setfPrice(foodsPrice);
            foods.setFoodPrint(foodsPrint);
            foods.setFoodName(foodsName);
            foods.setfId(id);
            //调用业务层修改方法
            foodsService.update(foods);
            //修改,转发到查询
            req.getRequestDispatcher("Food.food").forward(req,resp);
            /**
             * 删除菜品
             */
        }else if ("deleteFoods".equals(url)){
            //获取请求参数id
            String idsbq=req.getParameter("id");//ID
            Integer id=Integer.parseInt(idsbq);
            //调用业务层删除方法
            foodsService.delete(id);
            //转发
            req.getRequestDispatcher("Food.food").forward(req,resp);
            /**
             * 美食系列
             */
        }else if ("queryFoods".equals(url)){
            //分页查询
            //获取当前页数
            String pageNow = req.getParameter("curPageNo");
            Integer curPageNo = 1;
            //判断不为空,否则会报空指针异常
            if (pageNow != null) {
                curPageNo = Integer.parseInt(pageNow);
            }
            //创建业务层
            Page page = new Page();
            //将获取到的页数,存如pageInfo对象
            page.setCurPageNo(curPageNo);
            Foods foods=new Foods();
            //将设置好的pageInfo对象,放入方法中
            List<Foods> list = foodsService.FoodsQueryAll(foods, page);
            //获取总条数
            int i = foodsService.getTotalCount(foods);
            //放入pageInfo对象中，获取总条数
            page.setTotalCount(i);
            //将list参数,存入作用域中,因为jsp需要键,来获取值
            //将foods对象存入作用域
            List<FoodsType> foodsTypes = foodTypeService.findAll(null);
            //将参数存入作用域
            req.setAttribute("foodsTypes", foodsTypes);
            req.setAttribute("list", list);
            //要将pageInfo对象存入作用域,因为需要键来获取页数
            req.setAttribute("page", page);
            //转发
            req.getRequestDispatcher("meishi.jsp").forward(req, resp);
            /**
             * 点击美食,跳到meishi-con.jsp
             */
        }else if ("findFoodsByID".equals(url)){
            //获取请求参数id
            String idsbq=req.getParameter("id");
            Integer id=Integer.parseInt(idsbq);
            //调用业务层根据id查询方法
            Foods foods=foodsService.findById(id);
            //将foods对象存入作用域
            req.setAttribute("foods",foods);
            //转发
            req.getRequestDispatcher("meishi-con.jsp").forward(req,resp);
            /**
             * 首页显示新闻咨询信息
             */
        }else if ("findNews".equals(url)){
            //分页查询
            //获取当前页数
            String pageNow = req.getParameter("curPageNo");
            Integer curPageNo = 1;
            //判断不为空,否则会报空指针异常
            if (pageNow != null) {
                curPageNo = Integer.parseInt(pageNow);
            }
            //创建业务层
            Page page = new Page();
            //将获取到的页数,存如pageInfo对象
            page.setCurPageNo(curPageNo);
            Foods foods=new Foods();
            //将设置好的pageInfo对象,放入方法中
            List<Foods> listFood = foodsService.FoodsQueryAll(foods, page);
            //获取总条数
            int i = foodsService.getTotalCount(foods);
            int i1=newsService.getTotalCount(null);
            //创建菜品种类
            List<FoodsType> foodsTypes = foodTypeService.findAll(null);
            List<News> newsList = newsService.NewsQueryAll(null, page);
            //放入pageInfo对象中，获取总条数
            page.setTotalCount(i);
            //将list参数,存入作用域中,因为jsp需要键,来获取值
            req.setAttribute("foodsTypes", foodsTypes);
            req.setAttribute("listFood", listFood);
            req.setAttribute("newsList",newsList);
            //要将pageInfo对象存入作用域,因为需要键来获取页数
            req.setAttribute("page", page);
            //转发
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            /**
             * 点击首页新闻.跳转到news-con.jsp
             */
        }else if ("queryNews1".equals(url)){
            //获取请求参数id
            String idsbq=req.getParameter("id");
            Integer id=Integer.parseInt(idsbq);
            //调用业务层根据id查询方法
            newsService.findById(id);
            News news= newsService.findById(id);
            //将news对象存入作用域,前端需要获取对象值
            req.setAttribute("news",news);
            //转发
            req.getRequestDispatcher("news-con.jsp").forward(req,resp);
        }
    }
}





