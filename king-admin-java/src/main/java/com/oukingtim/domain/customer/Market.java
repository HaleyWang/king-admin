package com.oukingtim.domain.customer;

import com.baomidou.mybatisplus.annotations.TableName;
import com.oukingtim.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by haley on 11/01/2018.
 */



@TableName("tb_market")
@Data
@EqualsAndHashCode(callSuper = false)
public class Market extends BaseModel<Market> {

    private String marketCode;
    private String name;
    private String remark;

}