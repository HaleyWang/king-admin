package com.oukingtim.domain.customer;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotations.TableName;
import com.oukingtim.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by haley on 11/01/2018.
 */


@TableName("tb_customer_group")
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerGroup extends BaseModel<com.oukingtim.domain.customer.CustomerGroup> {

    public CustomerGroup(String name, String remark) {
        this.name = name;
        this.remark = remark;
    }

    public CustomerGroup() {
    }

    @Excel(name = "名称", orderNum = "0")
    private String name;
    @Excel(name = "备注", orderNum = "1")
    private String remark;

}

