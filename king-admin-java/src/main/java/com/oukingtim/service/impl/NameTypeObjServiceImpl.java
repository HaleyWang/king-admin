package com.oukingtim.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.oukingtim.domain.NameType;
import com.oukingtim.domain.NameTypeObj;
import com.oukingtim.domain.SysMenu;
import com.oukingtim.domain.SysUser;
import com.oukingtim.mapper.NameTypeObjMapper;
import com.oukingtim.mapper.SysMenuMapper;
import com.oukingtim.service.NameTypeObjService;
import com.oukingtim.service.NameTypeService;
import com.oukingtim.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by haley on 21/01/2018.
 */
@Service
public class NameTypeObjServiceImpl extends ServiceImpl<NameTypeObjMapper, NameTypeObj> implements NameTypeObjService {


    @Autowired
    NameTypeService nameTypeService;

    @Override
    public List<NameTypeObj> findByCode(String code) {
        List<NameType> nameTypes = nameTypeService.selectList(new EntityWrapper<>(new NameType().withCode(code)));
        if(CollectionUtils.isEmpty(nameTypes)) {
            return new ArrayList<>();
        }
        String nameTypeId = nameTypes.get(0).getId();
        List<NameTypeObj> NameTypeObjs = selectList(new EntityWrapper<>(new NameTypeObj().widthNameTypeId(nameTypeId)));
        return NameTypeObjs;
    }
}
