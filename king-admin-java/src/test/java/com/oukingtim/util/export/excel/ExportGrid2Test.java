package com.oukingtim.util.export.excel;

import com.oukingtim.domain.customer.Customer;
import com.oukingtim.util.export.ExportUtils;
import com.oukingtim.util.export.grid.Column;
import com.oukingtim.util.export.grid.Grid;
import com.oukingtim.util.export.grid.Row;
import com.oukingtim.util.export.grid.Settings;
import org.apache.el.util.ReflectionUtil;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Created by haley on 04/01/2018.
 */
public class ExportGrid2Test {

    @Test
    public void export() throws Exception {

        //ReflectionUtils.ge
        Column column = new Column("name", "Name");
        Column column1 = new Column("age", "Age");

        Row row = new Row();
        Row row1 = new Row();
        row.put("name", "Jim111");
        row.put("age", 20);

        row1.put("name", "Tim");
        row1.put("age", 30);


        Grid grid = new Grid();
        grid.setSettings(new Settings("gridfile.xls", "AA Table"));
        grid.setColumns(Arrays.asList(column, column1));
        grid.setRows(Arrays.asList(row, row1));

        File file = new File(grid.getSettings().getExcelName());
        System.out.println(file.getAbsoluteFile());
        OutputStream output = new FileOutputStream(file);

        ExportGrid eg = new ExportGrid();
        eg.export(grid, output);

    }

}