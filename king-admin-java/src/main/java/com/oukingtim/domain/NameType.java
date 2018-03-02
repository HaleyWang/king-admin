package com.oukingtim.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by haley on 21/01/2018.
 */

@TableName("tb_name_type")
@Data
@EqualsAndHashCode(callSuper = false)
public class NameType extends BaseModel<com.oukingtim.domain.NameType> {

    private String code;
    private String name;


    public NameType withCode(String code) {
        this.code = code;
        return this;
    }

}
