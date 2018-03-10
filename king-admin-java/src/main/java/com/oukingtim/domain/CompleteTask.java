package com.oukingtim.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Created by haley on 10/03/2018.
 */


@TableName("tb_complete_task")
@Data
@EqualsAndHashCode(callSuper = false)
public class CompleteTask extends BaseModel<CompleteTask> {

    private String customerId;
    private Integer completeNum;
    private Date completeDate;
    private String remark;


}

