package com.oukingtim.web;

import com.oukingtim.domain.NameTypeObj;
import com.oukingtim.domain.TbDict;
import com.oukingtim.domain.customer.Customer;
import com.oukingtim.service.NameTypeObjService;
import com.oukingtim.service.customer.CustomerService;
import com.oukingtim.web.vm.ResultVM;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by haley on 21/01/2018.
 */


@RestController
@RequestMapping("/api/name_type_obj")
public class NameTypeObjController extends BaseController<NameTypeObjService, NameTypeObj> {

    @GetMapping("/getlist/{code}")
    public ResultVM getList(@PathVariable String code) {
        List<NameTypeObj> list = service.findByCode(code);
        return ResultVM.ok(list);
    }

}
