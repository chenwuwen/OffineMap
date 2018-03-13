//package cn.kanyun.offinemap.util;
//
//import cn.kanyun.offinemap.model.Poi;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 读取Excel
// *
// * @author lp
// */
//public class ExcelUtil {
//    public List<Poi> loadScoreInfo(String xlsPath) throws IOException {
//        FileInputStream fis = null;
//        XSSFWorkbook xwb ;
//        List<Poi> pois = new ArrayList<>();
//        try {
//             fis = new FileInputStream(xlsPath);
//
//            xwb = new XSSFWorkbook(fis);
//            Sheet sheet = xwb.getSheetAt(0);
//            int rowNum = sheet.getLastRowNum();
//            for (int i = 2; i < rowNum; i++) {
//                Poi info = new Poi();
//
//                info.getCityCode(sheet.getCell(0, i).getContents());
//                info.setName(sheet.getCell(1, i).getContents());
//
//                info.setAddress(sheet.getCell(2, i).getContents());
//                info.setTel(sheet.getCell(3, i).getContents());
//                info.setType(sheet.getCell(4, i).getContents());
//                info.setLng(sheet.getCell(5, i).getContents());
//                info.setLat(sheet.getCell(6, i).getContents());
//                pois.add(info);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        } finally {
//            fis.close();
//        }
//        return pois;
//    }
//}
//
//
