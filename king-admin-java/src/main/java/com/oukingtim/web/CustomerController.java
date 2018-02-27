package com.oukingtim.web;

import com.oukingtim.domain.TbDict;
import com.oukingtim.domain.customer.Customer;
import com.oukingtim.service.TbDictService;
import com.oukingtim.service.customer.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haley on 11/01/2018.
 */

@RestController
@RequestMapping("/api/customer")
public class CustomerController extends BaseController<CustomerService, Customer> {
}
