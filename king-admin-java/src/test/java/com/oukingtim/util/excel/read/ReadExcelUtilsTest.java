package com.oukingtim.util.excel.read;

import com.oukingtim.util.PathUtils;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by haley on 21/01/2018.
 */
public class ReadExcelUtilsTest {
    @Test
    public void readExcelTitle() throws Exception {

        String filepath = PathUtils.getClassUrl(ReadExcelUtilsTest.class) + "/grid.xls";
        ReadExcelUtils excelReader = new ReadExcelUtils(filepath);
        String[] title = excelReader.readExcelTitle();
        System.out.println("Excel title:");
        for (String s : title) {
            System.out.print(s + " ");
        }

    }

    @Test
    public void readExcelContent() throws Exception {

        String filepath = PathUtils.getClassUrl(ReadExcelUtilsTest.class) + "/grid.xls";
        ReadExcelUtils excelReader = new ReadExcelUtils(filepath);

        Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();
        System.out.println("Excel content:");
        for (int i = 1; i <= map.size(); i++) {
            System.out.println(map.get(i));
        }

    }




}