package Utils;

import Po.User;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class POIImport {

    //（1）判断文件后缀名是xls，还是xlsx
    //（2）如果是xls，使用HSSFWorkbook；如果是xlsx，使用XSSFWorkbook
    /**
     * 导入  xlsx
     */
    @Test
    public void ImportPOI() throws IOException, ParseException {
        FileInputStream inputStream = new FileInputStream(new File("D:\\java\\excel\\temp\\abcc.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        //获得sheet
        XSSFSheet sheet =workbook.getSheetAt(0);
       // XSSFSheet sheet =workbook.getSheet("aaa");
        //HSSFSheet sheet = workbook.getSheet("importPOI");
        //获得总行数
        int rowNum = sheet.getLastRowNum();
        List<User> users = new ArrayList<User>();
        for (int i = 1; i <= rowNum; i++) {
            //HSSFRow row = sheet.getRow(i);
            XSSFRow row=sheet.getRow(i);
            User user = new User();
            double d = Double.parseDouble(String.valueOf(row.getCell(0)));
            int id = (int)d;
            user.setBuUserId(id);
            //user.setName(row.getCell(1).getStringCellValue());
            user.setBuUserName(row.getCell(1).getStringCellValue());
            users.add(user);
        }

        for(User user:users){
            System.out.println(user);
        }
    }


    /**
     * 导入  xls
     */
    @Test
    public void ImportPOIXLS() throws IOException, ParseException {
        FileInputStream inputStream = new FileInputStream(new File("D:\\java\\excel\\temp\\abcc.xlsx"));
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        //获得sheet
        //HSSFSheet sheet =workbook.getSheetAt(0);
        HSSFSheet sheet =workbook.getSheet("Sheet1");
        //获得总行数
        int rowNum = sheet.getLastRowNum();
        List<User> users = new ArrayList<User>();
        for (int i = 1; i <= rowNum; i++) {
            HSSFRow row = sheet.getRow(i);
            User user = new User();
            double d = Double.parseDouble(String.valueOf(row.getCell(0)));
            int id = (int)d;
            user.setBuUserId(id);
            user.setBuUserName(row.getCell(1).getStringCellValue());
            //user.setName(row.getCell(1).getStringCellValue());
            users.add(user);
        }

        for(User user:users){
            System.out.println(user);
        }
    }

}

