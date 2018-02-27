package com.oukingtim.domain.customer;

import com.baomidou.mybatisplus.annotations.TableName;
import com.oukingtim.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by haley on 11/01/2018.
 */



@TableName("tb_customer")
@Data
@EqualsAndHashCode(callSuper = false)
public class Customer extends BaseModel<com.oukingtim.domain.customer.Customer> {

    private String name;
    private String phone;
    private String phone1;
    private String remark;
    private String customerGroupId;


}