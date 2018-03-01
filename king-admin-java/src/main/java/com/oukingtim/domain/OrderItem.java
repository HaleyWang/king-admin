package com.oukingtim.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Created by haley on 01/03/2018.
 */


@TableName("tb_order_item")
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderItem extends BaseModel<com.oukingtim.domain.OrderItem> {

    private String customerNum;
    private Integer num;
    private String warehouseNum;
    private String wholesalerId;
    private String addressId;
    private Date orderDate;



}