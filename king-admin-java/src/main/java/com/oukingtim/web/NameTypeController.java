package com.oukingtim.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.oukingtim.domain.NameType;
import com.oukingtim.domain.customer.CustomerGroup;
import com.oukingtim.service.NameTypeService;
import com.oukingtim.web.vm.ResultVM;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by haley on 21/01/2018.
 */


@RestController
@RequestMapping("/api/name_type")
public class NameTypeController extends BaseController<NameTypeService, NameType> {

    /**
     * 获取集合
     * @return
     */
    @GetMapping("/getlist")
    public ResultVM getList() {
        List<NameType> list = service.selectList(new EntityWrapper<>());
        return ResultVM.ok(list);
    }
}
