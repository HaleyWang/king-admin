package com.oukingtim.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Created by haley on 10/03/2018.
 */


@TableName("tb_advances")
@Data
@EqualsAndHashCode(callSuper = false)
public class Advances extends BaseModel<com.oukingtim.domain.Advances> {

    private String customerId;
    private Integer advancesNum;
    private Date advancesDate;
    private Date payDate;
    private String remark;


}
