package com.oukingtim.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * Created by haley on 2018/7/17.
 */
@Data
public class IdName {

    String id;

    String name;


    public IdName(String id, String name) {
        this.name = name;
        this.id = id;
    }
}
