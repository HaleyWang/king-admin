package com.oukingtim.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.oukingtim.domain.NameTypeObj;
import com.oukingtim.domain.SysMenu;
import com.oukingtim.mapper.NameTypeObjMapper;
import com.oukingtim.mapper.SysMenuMapper;
import com.oukingtim.service.NameTypeObjService;
import com.oukingtim.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * Created by haley on 21/01/2018.
 */
@Service
public class NameTypeObjServiceImpl extends ServiceImpl<NameTypeObjMapper, NameTypeObj> implements NameTypeObjService {
}
