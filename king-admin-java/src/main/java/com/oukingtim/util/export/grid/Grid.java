package com.oukingtim.util.export.grid;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Grid {

    private Settings settings;
    private List<Column> columns;
    private List<Row> rows;
    public Grid() {}

    public Grid(List<Column> columns, Settings settings) {
        this.columns = columns;
        this.settings = settings;
    }

}