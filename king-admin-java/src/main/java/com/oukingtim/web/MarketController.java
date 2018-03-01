package com.oukingtim.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.oukingtim.domain.customer.Customer;
import com.oukingtim.domain.customer.CustomerGroup;
import com.oukingtim.domain.customer.Market;
import com.oukingtim.service.customer.CustomerService;
import com.oukingtim.service.customer.MarketService;
import com.oukingtim.web.vm.ResultVM;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by haley on 11/01/2018.
 */

@RestController
@RequestMapping("/api/market")
public class MarketController extends BaseController<MarketService, Market> {

    /**
     * 获取集合
     * @return
     */
    @GetMapping("/getlist")
    public ResultVM getList() {
        List<Market> list = service.selectList(new EntityWrapper<>());
        return ResultVM.ok(list);
    }

}
