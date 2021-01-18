package Action;

import Po.News;
import Service.NewsService;
import Service.NewsServiceImp;
import Utils.Page;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.junit.Test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(urlPatterns = "*.new")

public class NewsAction extends HttpServlet {
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
        //判断
        if ("New".equals(url)) {
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
            page.setPageSize(2);
            //将获取到的页数,存如pageInfo对象
            page.setCurPageNo(curPageNo);
            //将设置好的pageInfo对象,放入方法中
            List<News> list = newsService.NewsQueryAll(null, page);
            //获取总条数
            int i = newsService.getTotalCount(null);
            //放入pageInfo对象中，获取总条数
            page.setTotalCount(i);
            //将list参数,存入作用域中,因为jsp需要键,来获取值
            req.setAttribute("list", list);
            //要将pageInfo对象存入作用域,因为需要键来获取页数
            req.setAttribute("page", page);
            //转发
            req.getRequestDispatcher("/manage/blog.jsp").forward(req, resp);
            /**
             * 添加新闻
             */
        } else if ("show".equals(url)) {
            String fieldName = "";
            String uploadFileName = "";
            News news = new News();
            //解析请求之前先判断请求类型是否为文件上传类型
            boolean isMultipart = ServletFileUpload.isMultipartContent(req);
            String uploadFilePath =req.getServletContext().getRealPath("upload/");


            File saveDir = new File(uploadFilePath);
            //如果目录不存在，就创建目录
            if(!saveDir.exists()){
                saveDir.mkdir();
            }

            if(isMultipart){
                //创建文件上传核心类
                FileItemFactory factory = new DiskFileItemFactory(); // 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload
                ServletFileUpload upload = new ServletFileUpload(factory); // 用以上工厂实例化上传组件
                try{
                    //处理表单请求
                    List<FileItem> items = upload.parseRequest(req);
                    Iterator<FileItem> iter = items.iterator();
                    while(iter.hasNext()){
                        FileItem item = (FileItem)iter.next();
                        if(item.isFormField()){// 如果是普通表单控件
                            fieldName = item.getFieldName();// 获得该字段名称
                            if(fieldName.equals("title")){
                                news.setNewTitle(item.getString("UTF-8"));//获得该字段值
                            }else if(fieldName.equals("description")){
                                news.setNewDes(item.getString("UTF-8"));
                            }else if(fieldName.equals("D_description")){
                                news.setNewDDes(item.getString("UTF-8"));
                            }
                        }else{// 如果为文件域
                            String fileName = item.getName();// 获得文件名(全路径)
                            if(fileName != null && !fileName.equals("")){
                                File fullFile = new File(fileName);
                                File saveFile = new File(uploadFilePath,fullFile.getName());//将文件保存到指定的路径
                                item.write(saveFile);
                                uploadFileName = fullFile.getName();
                                news.setNewPicture("img/"+uploadFileName);
                            }
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
            System.out.println("上传成功之后的文件名：" + news.getNewPicture());
            //调用业务层添加方法,将新闻信息添加进去
            int i=newsService.save(news);
            if (i>0){
                out.print("<script type='text/javascript'>\n" +
                        "    alert('添加成功！');\n" +
                        "    window.location.href='New.new';\n" +
                        "</script>>");

        }
            /**
             * 删除新闻
             */
        }else if ("deleteNew".equals(url)){
            //获取请求参数id
            String idsbq=req.getParameter("id");
            Integer id=Integer.parseInt(idsbq);
            //调用业务层删除方法
            int i= newsService.delete(id);
            if (i>0){
                out.print("<script type='text/javascript'>\n" +
                        "    alert('删除成功！');\n" +
                        "    window.location.href='New.new';\n" +
                        "</script>>");
            }
            /**
             * 修改新闻
             */
        }else if ("findNewById".equals(url)){
            //获取请求参数id
            String idsbq=req.getParameter("id");
            Integer id=Integer.parseInt(idsbq);
            //调用业务层根据id查询方法
            News news= newsService.findById(id);
            //将news对象存入作用域,前端需要获取对象值
            req.setAttribute("news",news);
            //转发
            req.getRequestDispatcher("/manage/blog-modify.jsp").forward(req,resp);
            /**
             * 修改新闻
             */
        }else if ("updateNews".equals(url)){
            //获取请求参数
            String idsbq=req.getParameter("id");
            Integer id=Integer.parseInt(idsbq);
            String title=req.getParameter("title");
            String description=req.getParameter("description");
            String D_description=req.getParameter("D_description");
            //创建对象
            News news=new News();
            news.setNewId(id);
            news.setNewDDes(D_description);
            news.setNewDes(description);
            news.setNewTitle(title);
            //调用业务层修改方法
            newsService.update(news);
            //转发
            req.getRequestDispatcher("New.new").forward(req,resp);
            /**
             * 新闻分页查询
             */
        }else if ("queryNew".equals(url)){
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
            //将设置好的pageInfo对象,放入方法中
            List<News> list = newsService.NewsQueryAll(null, page);
            //获取总条数
            int i = newsService.getTotalCount(null);
            //放入pageInfo对象中，获取总条数
            page.setTotalCount(i);
            //将list参数,存入作用域中,因为jsp需要键,来获取值
            HttpSession session=req.getSession();
            session.setAttribute("list", list);
            //req.setAttribute("list", list);
            //要将pageInfo对象存入作用域,因为需要键来获取页数
            req.setAttribute("page", page);
            //转发
            req.getRequestDispatcher("news.jsp").forward(req, resp);
            /**
             * 查询详细新闻信息
             */
        }else if ("findD_des".equals(url)){
            //获取请求参数id
            String idsbq=req.getParameter("id");
            Integer id=Integer.parseInt(idsbq);
            //调用业务层根据id查询方法
            News news= newsService.findById(id);
            //将news对象存入作用域,前端需要获取对象值
            req.setAttribute("news",news);
            //转发
            req.getRequestDispatcher("news-con.jsp").forward(req,resp);
        }
    }
}

