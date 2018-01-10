package com.oukingtim.util.export.folwgrid;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FolwRow {

    List<FolwCell> folwCell = new ArrayList<>();


    public static FolwRow ofEmpty() {
        FolwRow c = new FolwRow();
        c.folwCell.add(FolwCell.ofNameCell(""));
        return c;
    }

    public static FolwRow of() {
        FolwRow c = new FolwRow();
        return c;
    }

    public FolwRow addCell(FolwCell folwCell) {
        this.folwCell.add(folwCell);
        return this;
    }


    public FolwRow addFolwRow(FolwRow folwRow) {
        this.folwCell.addAll(folwRow.getFolwCell());
        return this;
    }
}
