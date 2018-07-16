package com.oukingtim.util.export.excel;

import lombok.Data;

/**
 * Created by haley on 03/01/2018.
 */
@Data
public class ReportHeader {

    String name;
    String displayName;
    int length;

    public ReportHeader() {

    }

    public ReportHeader(String name, String displayName, int length) {
        this.name = name;
        this.displayName = displayName;
        this.length = length;
    }


}
