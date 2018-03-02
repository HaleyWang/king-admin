package com.oukingtim.service;

import com.baomidou.mybatisplus.service.IService;
import com.oukingtim.domain.NameTypeObj;
import com.oukingtim.domain.SysMenu;
import com.oukingtim.domain.TbDict;

import java.util.List;

/**
 * Created by haley on 21/01/2018.
 */
public interface NameTypeObjService extends IService<NameTypeObj> {
    List<NameTypeObj> findByCode(String code);
}
