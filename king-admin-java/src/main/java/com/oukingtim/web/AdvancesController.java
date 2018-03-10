package com.oukingtim.web;

import com.oukingtim.domain.Advances;
import com.oukingtim.domain.customer.Customer;
import com.oukingtim.service.AdvancesService;
import com.oukingtim.service.customer.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haley on 10/03/2018.
 */

@RestController
@RequestMapping("/api/advances")
public class AdvancesController extends BaseController<AdvancesService, Advances> {
}
