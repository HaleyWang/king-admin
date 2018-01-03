package com.oukingtim.util.export.excel;

/**
 * Created by haley on 03/01/2018.
 */
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

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
