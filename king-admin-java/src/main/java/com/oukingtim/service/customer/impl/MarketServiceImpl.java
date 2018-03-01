package com.oukingtim.service.customer.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.oukingtim.domain.customer.Customer;
import com.oukingtim.domain.customer.Market;
import com.oukingtim.mapper.customer.CustomerMapper;
import com.oukingtim.mapper.customer.MarketMapper;
import com.oukingtim.service.customer.CustomerService;
import com.oukingtim.service.customer.MarketService;
import org.springframework.stereotype.Service;

/**
 * Created by haley on 11/01/2018.
 */
@Service
public class MarketServiceImpl extends ServiceImpl<MarketMapper, Market> implements MarketService {

}
