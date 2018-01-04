package com.oukingtim.util.export.grid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum DataType {
    string, number, date, icon;

    public static DataType valueOfDefault(String str) {
       for (DataType c : DataType.values()) {
            if (c.name().equals(str)) {
                return DataType.valueOf(str);
            }
        }
       return DataType.number;
    }


    public static Set<String> getStringAliasList() {
        //should be lowerCase
       return new HashSet<>(Arrays.asList("name", "ticker", "financial_health_grade"));
    }


    /**
     * if dataPointAlias in getStringAliasList return string DataType,
     * else return corresponding DataType by @param type
     * @param type eg: "string", "number", "date", "icon"
     * @param dataPointAlias eg: "name", "ticker" , "FACT830_3" ...
     * @return
     */
    public static DataType valueOfDefault(String type, String dataPointAlias) {
        if(dataPointAlias != null && getStringAliasList().contains(dataPointAlias.toLowerCase())) {
            return DataType.string;
        }
        return valueOfDefault(type);
    }

}