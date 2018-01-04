package com.oukingtim.util.export.grid;

import java.util.List;

public class Column {
    private String id;
    private String name;
    private String startDate;
    private String endDate;
    private DataType dataType = DataType.string;
    private List<Column> subs;
   
     public Column() {}
   
    public Column(String id, String name, DataType dataType){
        this(id, name);
        this.dataType = dataType;
    }
    public Column(String id, String name){
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Column> getSubs() {
        return subs;
    }

    public void setSubs(List<Column> subs) {
        this.subs = subs;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = DataType.valueOfDefault(dataType);
    }

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}