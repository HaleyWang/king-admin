package com.oukingtim.util.export.grid;

import java.util.HashMap;
import java.util.List;

public class Row extends HashMap<String, Object>{
    private static final long serialVersionUID = -4152391319260698066L;
   
     private List<Row> subs;
    public List<Row> getSubs() {
        return subs;
    }
    public void setSubs(List<Row> subs) {
        this.subs = subs;
        this.put("subs", subs);
    }
   
    public Row add(String key, Object value) {
       this.put(key, value);
       return this;
    }
   
    public static Row create() {
       return new Row();
    }
   
}