package com.oukingtim.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.oukingtim.domain.customer.Customer;
import com.oukingtim.domain.customer.CustomerGroup;
import com.oukingtim.domain.customer.Market;
import com.oukingtim.service.customer.CustomerService;
import com.oukingtim.service.customer.MarketService;
import com.oukingtim.util.excel.FileUtil;
import com.oukingtim.util.exception.NormalException;
import com.oukingtim.web.vm.ResultVM;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
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


    @PostMapping("import")
    public String importExcel(@RequestParam("file") MultipartFile file) throws NormalException {
        //解析excel，
        List<Market> list = FileUtil.importExcel(file,1,1,Market.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+list.size()+"】行");

        //TODO 保存数据库

        return "ok";
    }



    @RequestMapping(value = "/testDownload", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response) throws NormalException {

        Market m1 = new Market();
        m1.setMarketCode("aa");
        m1.setName("aaaa");
        m1.setRemark("re");
        Market m2 = new Market();
        m2.setName("中文");
        m2.setMarketCode("cc");
        List<Market> list = Arrays.asList(m1, m2);
        String title = "tt";
        String sheetName = "ss";
        Class pojoClass = Market.class;
        String fileName = "aa";

        FileUtil.exportExcel(list,title, sheetName, pojoClass, fileName, response);
    }


}
