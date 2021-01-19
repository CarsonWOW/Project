package Test;

import Po.User;
import Utils.ExcelExportSXXSSF;
import org.apache.poi.ss.formula.functions.Now;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
public class ExcelExportTest {
    public static void main(String[] args) throws Exception {
        /**            导出文件存放物理路径
         * @param fileWebPath
         *            导出文件web下载路径
         * @param filePrefix
         *            导出文件名的前缀
         * @param flushRows
         *            存放在内存的数据量
         * @param fieldNames
         *            导出文件列标题
         * @param fieldCodes
         * 			  导出数据对象的字段名称
         * @param flushRows*/
        //导出文件存放的路径，并且是虚拟目录指向的路径
        String filePath = "D:\\java\\excel\\temp\\";
        //导出文件的前缀
        String filePrefix="User信息";
        //-1表示关闭自动刷新，手动控制写磁盘的时机，其它数据表示多少数据在内存保存，超过的则写入磁盘
        int flushRows=100;

        //指导导出数据的title
        List<String> fieldNames=new ArrayList<String>();
        fieldNames.add("buUserId");
        fieldNames.add("buEmail");
        fieldNames.add("buUserName");
        fieldNames.add("buPassword");

        fieldNames.add("buSex");
        fieldNames.add("buMobile");
        fieldNames.add("buStatus");

        //告诉导出类数据list中对象的属性，让ExcelExportSXXSSF通过反射获取对象的值
        List<String> fieldCodes=new ArrayList<String>();
        fieldCodes.add("buUserId");//id
        fieldCodes.add("buEmail");//用户名
        fieldCodes.add("buUserName");//用户名
        fieldCodes.add("buPassword");//用户名

        fieldCodes.add("buSex");//用户名
        fieldCodes.add("buMobile");//用户名
        fieldCodes.add("buStatus");//用户名

        //注意：fieldCodes和fieldNames个数必须相同且属性和title顺序一一对应，这样title和内容才一一对应

        //开始导出，执行一些workbook及sheet等对象的初始创建
        ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(filePath, "/upload/", filePrefix, fieldNames, fieldCodes, flushRows);

        //准备导出的数据，将数据存入list，且list中对象的字段名称必须是刚才传入ExcelExportSXXSSF的名称
        List<User> list = new ArrayList<User>();
        User user=new User();
        user.setBuUserId(2);
        user.setBuEmail("888@qq.com");
        user.setBuUserName("JAKE");
        user.setBuPassword("abc123");
        user.setBuSex("女");
        user.setBuMobile("13131313131");
        user.setBuStatus(2);
        list.add(user);



        /*User user1 = new User(1,"好人",1);
        User user2 = new User(1,"好人",2);*/




        //执行导出
        excelExportSXXSSF.writeDatasByObject(list);
        //输出文件，返回下载文件的http地址
        String webpath = excelExportSXXSSF.exportFile();

        System.out.println(webpath);


    }
}
