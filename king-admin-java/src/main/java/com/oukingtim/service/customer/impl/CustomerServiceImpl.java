package com.oukingtim.service.customer.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.oukingtim.domain.SysMenu;
import com.oukingtim.domain.customer.Customer;
import com.oukingtim.mapper.SysMenuMapper;
import com.oukingtim.mapper.customer.CustomerMapper;
import com.oukingtim.service.SysMenuService;
import com.oukingtim.service.customer.CustomerService;
import org.springframework.stereotype.Service;

/**
 * Created by haley on 11/01/2018.
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
