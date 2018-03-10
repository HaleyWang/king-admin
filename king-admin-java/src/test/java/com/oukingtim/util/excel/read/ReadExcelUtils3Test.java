package com.oukingtim.util.excel.read;

import com.oukingtim.util.PathUtils;
import org.apache.poi.ss.usermodel.Name;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by haley on 21/01/2018.
 */
public class ReadExcelUtils3Test {
    @Test
    public void readExcelTitle() throws Exception {

        String filepath = PathUtils.getClassUrl(ReadExcelUtils3Test.class) + "/2018-2-28.xlsx";
        ReadExcelUtils excelReader = new ReadExcelUtils(filepath);


        
        int sheetIdx = excelReader.getSheetIndex("振安");

        String[] title = excelReader.readExcelTitle(sheetIdx, 2);
        System.out.println("Excel title:");
        for (String s : title) {
            System.out.print(s + " ");
        }
        System.out.println();

        excelReader.close();

    }

    @Test
    public void readExcelContent() throws Exception {

        String filepath = PathUtils.getClassUrl(ReadExcelUtils3Test.class) + "/2018-2-28.xlsx";
        ReadExcelUtils excelReader = new ReadExcelUtils(filepath);
        int sheetIdx = excelReader.getSheetIndex("振安");

        Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent(sheetIdx,3);
        System.out.println("Excel content:");
        System.out.println(map);
        for (Integer idx : map.keySet()) {
            System.out.println(map.get(idx));
        }

    }




}