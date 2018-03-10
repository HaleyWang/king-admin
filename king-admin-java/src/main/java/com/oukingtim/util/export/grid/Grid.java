package com.oukingtim.util.export.grid;

import java.util.List;
import java.util.Map;

public class Grid {

    private String title;
    private List<Column> columns;
    private List<Row> rows;


    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}