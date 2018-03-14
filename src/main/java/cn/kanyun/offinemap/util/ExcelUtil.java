package cn.kanyun.offinemap.util;

import cn.kanyun.offinemap.model.Poi;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 读取Excel
 *
 * @author lp
 */
public class ExcelUtil {
    public static List<Poi> loadScoreInfo(String xlsPath) throws IOException {
        FileInputStream fis = null;
        XSSFWorkbook xwb;
        List<Poi> pois = new ArrayList<>();
        try {
            fis = new FileInputStream(xlsPath);

            xwb = new XSSFWorkbook(fis);
            Sheet sheet = xwb.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for (int i = 2; i < 10; i++) {
                Poi info = new Poi();
                Row hssfRow = sheet.getRow(i);
                String value1 = null == hssfRow.getCell(0).getStringCellValue() ? "" : hssfRow.getCell(0).getStringCellValue();
                info.setCityCode(value1);
                String value2 = null == hssfRow.getCell(1).getStringCellValue() ? "" : hssfRow.getCell(1).getStringCellValue();
                info.setName(value2);
                String value3 = null == hssfRow.getCell(2).getStringCellValue() ? "" : hssfRow.getCell(2).getStringCellValue();
                info.setAddress(value3);
                String value4 = null == hssfRow.getCell(3).getStringCellValue() ? "" : hssfRow.getCell(3).getStringCellValue();
                info.setTel(value4);
                String value5 = null == hssfRow.getCell(4).getStringCellValue() ? "" : hssfRow.getCell(4).getStringCellValue();
                info.setType(value5);
                String value6 = null == hssfRow.getCell(5).getStringCellValue() ? "" : hssfRow.getCell(5).getStringCellValue();
                info.setLng(value6);
                String value7 = null == hssfRow.getCell(6).getStringCellValue() ? "" : hssfRow.getCell(6).getStringCellValue();
                info.setLat(value7);
                info.setInsertDate(new Date());
                pois.add(info);
                System.out.println("当前记录为：" + pois.size() + "条");
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            fis.close();
        }
        return pois;
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\Administrator\\Desktop\\mybatis\\po1.xlsx";
        List<Poi> pois = new ArrayList<>();
        try {
            pois = ExcelUtil.loadScoreInfo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pois.size());
    }
}


