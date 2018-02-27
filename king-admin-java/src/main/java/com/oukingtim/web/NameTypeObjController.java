package com.oukingtim.web;

import com.oukingtim.domain.NameTypeObj;
import com.oukingtim.domain.customer.Customer;
import com.oukingtim.service.NameTypeObjService;
import com.oukingtim.service.customer.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haley on 21/01/2018.
 */


@RestController
@RequestMapping("/api/name_type_obj")
public class NameTypeObjController extends BaseController<NameTypeObjService, NameTypeObj> {
}
