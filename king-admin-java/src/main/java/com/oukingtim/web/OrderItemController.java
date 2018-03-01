package com.oukingtim.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.oukingtim.domain.NameType;
import com.oukingtim.domain.OrderItem;
import com.oukingtim.service.NameTypeService;
import com.oukingtim.service.OrderItemService;
import com.oukingtim.web.vm.ResultVM;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by haley on 21/01/2018.
 */


@RestController
@RequestMapping("/api/order_item")
public class OrderItemController extends BaseController<OrderItemService, OrderItem> {


}
