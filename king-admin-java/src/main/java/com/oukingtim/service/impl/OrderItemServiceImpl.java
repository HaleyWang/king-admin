package com.oukingtim.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.oukingtim.domain.NameType;
import com.oukingtim.domain.OrderItem;
import com.oukingtim.mapper.NameTypeMapper;
import com.oukingtim.mapper.OrderItemMapper;
import com.oukingtim.service.NameTypeService;
import com.oukingtim.service.OrderItemService;
import org.springframework.stereotype.Service;

/**
 * Created by haley on 21/01/2018.
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {
}
