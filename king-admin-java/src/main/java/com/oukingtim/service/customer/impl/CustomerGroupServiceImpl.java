package com.oukingtim.service.customer.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.oukingtim.domain.customer.CustomerGroup;
import com.oukingtim.mapper.customer.CustomerGroupMapper;
import com.oukingtim.service.customer.CustomerGroupService;
import org.springframework.stereotype.Service;

/**
 * Created by haley on 11/01/2018.
 */
@Service
public class CustomerGroupServiceImpl extends ServiceImpl<CustomerGroupMapper, CustomerGroup>
        implements CustomerGroupService {

}
