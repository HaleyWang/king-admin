package com.oukingtim.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by haley on 21/01/2018.
 */


@TableName("tb_name_type_obj")
@Data
@EqualsAndHashCode(callSuper = false)
public class NameTypeObj extends BaseModel<com.oukingtim.domain.NameTypeObj> {


    private String name;
    private String nameTypeId;
    private String remark;



    public NameTypeObj widthNameTypeId(String nameTypeId) {
        this.nameTypeId = nameTypeId;
        return  this;
    }
}



