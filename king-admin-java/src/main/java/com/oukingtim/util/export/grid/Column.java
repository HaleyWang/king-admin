package com.oukingtim.util.export.grid;

import lombok.Data;

import java.util.List;

@Data
public class Column {
    public static final int DEFAULT_WIDTH = 90;
    private String id;
    private String name;
    private int width = DEFAULT_WIDTH;
    private int orderNum;
    private String startDate;
    private String endDate;
    private DataType dataType = DataType.string;
    private List<Column> subs;
   
     public Column() {}
   
    public Column(String id, String name, int width, DataType dataType, int orderNum){
        this.id = id;
        this.name = name;
        this.width = width;
        this.dataType = dataType;
        this.orderNum = orderNum;
    }

    public Column(String id, String name, int width, DataType dataType){
        this.id = id;
        this.name = name;
        this.width = width;
        this.dataType = dataType;
        this.orderNum = 0;
    }

    public Column(String id, String name, int width){
        this(id, name, width, DataType.string);
    }
    public Column(String id, String name){
        this(id, name, DEFAULT_WIDTH, DataType.string);
    }

    public static Column colS(String id, String name) {
        return new Column(id, name);
    }

    public static Column col(String id, String name, DataType dataType, int width, int orderNum) {
        return new Column(id, name, width, dataType, orderNum);
    }

    public static Column colS(String id, String name, int width) {
        return new Column(id, name, width);
    }

    public static Column colN(String id, String name) {
        return new Column(id, name);
    }

    public static Column colD(String id, String name) {
        return new Column(id, name);
    }


}