package com.oukingtim.util.excel.read;

import com.oukingtim.util.PathUtils;
import org.junit.Test;

import java.util.Map;

/**
 * Created by haley on 21/01/2018.
 */
public class ReadExcelUtils2Test {
    @Test
    public void readExcelTitle() throws Exception {

        String filepath = PathUtils.getClassUrl(ReadExcelUtils2Test.class) + "/grid2.xls";
        ReadExcelUtils excelReader = new ReadExcelUtils(filepath);
        String[] title = excelReader.readExcelTitle(0, 1);
        System.out.println("Excel title:");
        for (String s : title) {
            System.out.print(s + " ");
        }
        System.out.println();

    }

    @Test
    public void readExcelContent() throws Exception {

        String filepath = PathUtils.getClassUrl(ReadExcelUtils2Test.class) + "/grid2.xls";
        ReadExcelUtils excelReader = new ReadExcelUtils(filepath);

        Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent(0,2);
        System.out.println("Excel content:");
        System.out.println(map);
        for (Integer idx : map.keySet()) {
            System.out.println(map.get(idx));
        }

    }




}