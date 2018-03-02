package com.oukingtim.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * Created by haley on 03/03/2018.
 */
@Data
public class MarketDto {

    @Excel(name = "市场", orderNum = "0")
    String name;

    @Excel(name = "市场简写", orderNum = "1")
    String code;

}
