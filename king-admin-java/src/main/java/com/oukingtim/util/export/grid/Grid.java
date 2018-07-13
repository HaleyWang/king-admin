package com.oukingtim.util.export.grid;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Grid {

    private Settings settings;
    private List<Column> columns;
    private List<Row> rows;

}