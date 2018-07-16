package com.oukingtim.util.export.grid;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * Created by haley on 2018/7/12.
 */
@Data
public class Settings {
    private String actionCol;
    private String excelName;
    private List<String> titles;

    public Settings() {}
    public Settings(String excelName, String ... title) {
        this.excelName = excelName;
        this.titles = Arrays.asList(title);
    }


    public Settings ofActionCol(String actionCol) {
        this.actionCol = actionCol;
        return this;
    }

    public Settings ofExcelName(String excelName) {
        this.excelName = excelName;
        return this;

    }
}
