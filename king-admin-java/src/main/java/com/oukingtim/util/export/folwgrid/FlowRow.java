package com.oukingtim.util.export.folwgrid;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FlowRow {

    List<FlowCell> flowCell = new ArrayList<>();


    public static FlowRow ofEmpty() {
        FlowRow c = new FlowRow();
        c.flowCell.add(FlowCell.ofNameCell(""));
        return c;
    }

    public static FlowRow obj() {
        FlowRow c = new FlowRow();
        return c;
    }

    public FlowRow addCell(FlowCell folwCell) {
        this.flowCell.add(folwCell);
        return this;
    }


    public FlowRow addFolwRow(FlowRow flowRow) {
        this.flowCell.addAll(flowRow.getFlowCell());
        return this;
    }
}
