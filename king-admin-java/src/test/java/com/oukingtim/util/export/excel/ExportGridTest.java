package com.oukingtim.util.export.excel;

import com.oukingtim.util.export.grid.Column;
import com.oukingtim.util.export.grid.Grid;
import com.oukingtim.util.export.grid.Row;
import org.apache.poi.ss.formula.functions.Columns;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by haley on 04/01/2018.
 */
public class ExportGridTest {
    @Test
    public void export() throws Exception {

        Column column = new Column("name", "Name");
        Column column1 = new Column("age", "Age");

        Row row = new Row();
        Row row1 = new Row();
        row.put("name", "Jim");
        row.put("age", 20);

        row1.put("name", "Tim");
        row1.put("age", 30);


        Grid grid = new Grid();
        grid.setColumns(Arrays.asList(column, column1));
        grid.setRows(Arrays.asList(row, row1));

        File file = new File("/Users/haley/Documents/w/king-admin/grid.xls");
        OutputStream output = new FileOutputStream(file);

        ExportGrid eg = new ExportGrid();
        eg.export(grid, output);

    }

}