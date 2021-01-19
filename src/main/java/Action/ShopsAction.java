package Action;


import Po.Shops;
import Po.ShopsType;
import Service.ShopTypeService;
import Service.ShopsService;

import Service.impl.ShopTypeServiceImpl;
import Service.impl.ShopsServiceImpl;
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

@WebServlet(urlPatterns = "*.shop")
public class ShopsAction extends HttpServlet {
    private ShopsService shopsService = new ShopsServiceImpl();
    private ShopTypeService shopTypeService = new ShopTypeServiceImpl();

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
        if ("Shop".equals(url)) {
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
            page.setPageSize(5);
            Shops shops=new Shops();
            //将获取到的页数,存如pageInfo对象
            page.setCurPageNo(curPageNo);
            //将设置好的pageInfo对象,放入方法中
            List<Shops> list = shopsService.FoodsQueryAll(shops, page);
            //获取总条数
            int i = shopsService.getTotalCount(shops);
            //创建店面种类
            List<ShopsType> shopsTypes = shopTypeService.findAll(null);
            //放入pageInfo对象中，获取总条数
            page.setTotalCount(i);
            //将list参数,存入作用域中,因为jsp需要键,来获取值
            req.setAttribute("shopsTypes", shopsTypes);
            req.setAttribute("list", list);
            //要将pageInfo对象存入作用域,因为需要键来获取页数
            req.setAttribute("page", page);
            //转发
            req.getRequestDispatcher("/manage/guestbook.jsp").forward(req, resp);
            /**
             * 添加店面
             */
        } else if ("addShop".equals(url)) {
            List<ShopsType> shopsTypes = shopTypeService.findAll(null);
            //将参数存入作用域
            req.setAttribute("shopsTypes", shopsTypes);
            //转发
            req.getRequestDispatcher("/manage/guestbook-add.jsp").forward(req, resp);
        } else if ("showShop".equals(url)) {
            //获取请求参数
            String fieldName = "";
            String uploadFileName = "";
            Shops shops = new Shops();
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
                                shops.setShopTypeId(parentId);
                            } else if (fieldName.equals("shopName")) {
                                //news.setNewDes(item.getString("UTF-8"));
                                shops.setShopName(item.getString("UTF-8"));
                            } else if (fieldName.equals("shopCuisine")) {
                                //news.setNewDDes(item.getString("UTF-8"));
                                shops.setShopCuisine(item.getString("UTF-8"));
                            }else if (fieldName.equals("shopBusiness")){
                                shops.setShopBusiness(item.getString("UTF-8"));
                            }else if (fieldName.equals("shopPark")){
                                shops.setShopPark(item.getString("UTF-8"));
                            }else if (fieldName.equals("shopSite")){
                                shops.setShopSite(item.getString("UTF-8"));
                            }else if (fieldName.equals("shopLabel")){
                                shops.setShopLabel(item.getString("UTF-8"));
                            }
                        } else {// 如果为文件域
                            String fileName = item.getName();// 获得文件名(全路径)
                            if (fileName != null && !fileName.equals("")) {
                                File fullFile = new File(fileName);
                                File saveFile = new File(uploadFilePath, fullFile.getName());//将文件保存到指定的路径
                                item.write(saveFile);
                                uploadFileName = fullFile.getName();
                                // news.setNewPicture(uploadFileName);
                                shops.setShopPicture("img/"+uploadFileName);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("上传成功之后的文件名：" + shops.getShopPicture());
                //调用业务层添加方法,将店面信息添加进去
                int i = shopsService.save(shops);
                if (i>0) {
                    out.print("<script type='text/javascript'>\n" +
                            "    alert('添加成功！');\n" +
                            "    window.location.href='Shop.shop';\n" +
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
            Shops shops=shopsService.findById(id);
            //将foods对象存入作用域
            List<ShopsType> shopsTypes = shopTypeService.findAll(null);
            //将参数存入作用域
            req.setAttribute("shopsTypes", shopsTypes);
            req.setAttribute("shops",shops);
            //转发
            req.getRequestDispatcher("/manage/guestbook-modify.jsp").forward(req,resp);
            /**
             * 修改店面
             */
        }else if ("updateShops".equals(url)){
            //获取请求参数
            String idsbq=req.getParameter("id");//ID
            Integer id=Integer.parseInt(idsbq);
            String parentId=req.getParameter("parentId");//种类
            Integer parentId1=Integer.parseInt(parentId);
            String shopName=req.getParameter("shopName");//店面名字
            String shopCuisine=req.getParameter("shopCuisine");//特色菜品
            String shopBusiness=req.getParameter("shopBusiness");//营业时间
            //创建对象
            Shops shops=new Shops();
            shops.setShopTypeId(parentId1);
            shops.setShopName(shopName);
            shops.setShopCuisine(shopCuisine);
            shops.setShopBusiness(shopBusiness);
            shops.setShopId(id);
            //调用业务层修改方法
            shopsService.update(shops);
            //修改,转发到查询
            req.getRequestDispatcher("Shop.shop").forward(req,resp);
            /**
             * 删除店面
             */
        }else if ("deleteShops".equals(url)){
            //获取请求参数id
            String idsbq=req.getParameter("id");//ID
            Integer id=Integer.parseInt(idsbq);
            //调用业务层删除方法
            shopsService.delete(id);
            //转发
            req.getRequestDispatcher("Shop.shop").forward(req,resp);
            /**
             * 店面展示
             */
        }else if ("queryShops".equals(url)){
            //分页查询
            //获取当前页数
            String pageNow = req.getParameter("curPageNo");
            //获取搜索名
            String FoodName=req.getParameter("FoodName");
            //创建对象
            Integer curPageNo = 1;
            //判断不为空,否则会报空指针异常
            if (pageNow != null) {
                curPageNo = Integer.parseInt(pageNow);
            }
            //创建业务层
            Page page = new Page();
            //将获取到的页数,存如pageInfo对象
            page.setPageSize(6);
            page.setCurPageNo(curPageNo);
            Shops shops=new Shops();
            shops.setShopName(FoodName);
            //将设置好的pageInfo对象,放入方法中
            List<Shops> list = shopsService.FoodsQueryAll(shops, page);
            //获取总条数
            int i = shopsService.getTotalCount(shops);
            //放入pageInfo对象中，获取总条数
            page.setTotalCount(i);
            //将list参数,存入作用域中,因为jsp需要键,来获取值
            //将foods对象存入作用域
            List<ShopsType> shopsTypes = shopTypeService.findAll(null);
            //将参数存入作用域
            req.setAttribute("shopsTypes", shopsTypes);
            req.setAttribute("list", list);
            //要将pageInfo对象存入作用域,因为需要键来获取页数
            req.setAttribute("page", page);
            //转发
            req.getRequestDispatcher("shop.jsp").forward(req, resp);
            /**
             * 点击美食,跳到shop-con.jsp
             */
        }else if ("findShopsByID".equals(url)){
            //获取请求参数id
            String idsbq=req.getParameter("id");
            Integer id=Integer.parseInt(idsbq);
            //调用业务层根据id查询方法
            Shops shops=shopsService.findById(id);
            //将foods对象存入作用域
            req.setAttribute("shops",shops);
            //转发
            req.getRequestDispatcher("shop-con.jsp").forward(req,resp);
        }
    }
}





