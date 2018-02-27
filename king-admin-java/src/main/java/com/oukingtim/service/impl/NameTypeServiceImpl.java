package com.oukingtim.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.oukingtim.domain.NameType;
import com.oukingtim.domain.NameTypeObj;
import com.oukingtim.mapper.NameTypeMapper;
import com.oukingtim.mapper.NameTypeObjMapper;
import com.oukingtim.service.NameTypeObjService;
import com.oukingtim.service.NameTypeService;
import org.springframework.stereotype.Service;

/**
 * Created by haley on 21/01/2018.
 */
@Service
public class NameTypeServiceImpl extends ServiceImpl<NameTypeMapper, NameType> implements NameTypeService {
}
