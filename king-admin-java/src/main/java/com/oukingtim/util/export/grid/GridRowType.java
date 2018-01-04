package com.oukingtim.util.export.grid;

import java.util.Arrays;
import java.util.List;

public enum GridRowType{

    GROUP(1, "group"),
    LEAF(2, "leaf");


    private Integer key;

    private String value;

    private GridRowType(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Integer getKey() {
        return key;
    }
   
    public static GridRowType parse(Integer key) {
       GridRowType rowType = null;
       if (key != null) {
          List<GridRowType> gridRowTypeList = Arrays.asList(values());
          rowType = gridRowTypeList.stream().filter(type -> type.getKey().equals(key)).findFirst().orElse(null);
       }
       return rowType;
    }

}