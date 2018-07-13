package com.oukingtim.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.oukingtim.domain.customer.Customer;
import com.oukingtim.domain.customer.Market;
import com.oukingtim.service.customer.CustomerService;
import com.oukingtim.service.customer.MarketService;
import com.oukingtim.util.excel.read.ReadExcelUtils;
import com.oukingtim.util.export.ExportUtils;
import com.oukingtim.util.export.grid.Column;
import com.oukingtim.util.export.grid.Settings;
import com.oukingtim.web.vm.ResultVM;
import org.apache.poi.ss.formula.functions.Columns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

import static com.oukingtim.util.export.grid.Column.colS;

/**
 * Created by haley on 11/01/2018.
 */

@RestController
@RequestMapping("/api/customer")
public class CustomerController extends BaseController<CustomerService, Customer> {

    @Autowired
    MarketService marketService;

    @Autowired
    private MessageSource messageSource;

    @PostMapping("import")
    public ResultVM importExcel(@RequestParam("file") MultipartFile file) throws Exception {
        //解析excel，
        ReadExcelUtils excelReader = null;
        try {
            excelReader = new ReadExcelUtils(file.getInputStream(), true);
            int sheetIdx = excelReader.getSheetIndex("Sheet3");

            Map<Integer, Map<Integer, Object>> data = excelReader.readExcelContent(sheetIdx, 1);


            System.out.println(data);

            List<Market> marketList = marketService.selectList(new EntityWrapper<>());

            Map<String, Market> marketMap = marketList.stream().collect(Collectors.toMap(p -> p.getName(), o -> o, (r, s) -> r));


            for (Integer k : data.keySet()) {

                //5
                String name = data.get(k).get(5)+"";
                String code = data.get(k).get(6)+"";

                if(!marketMap.containsKey(name)) {
                    Market model = new Market();
                    model.setMarketCode(code);
                    model.setName(name);
                    marketService.insert(model);
                }
            }

            marketList = marketService.selectList(new EntityWrapper<>());
            marketMap = marketList.stream().collect(Collectors.toMap(p -> p.getName(), o -> o, (r, s) -> r));

            for (Integer k : data.keySet()) {


                Map<Integer, Object> integerObjectMap = data.get(k);
                String code = Objects.toString(integerObjectMap.get(2), null);
                String num = Objects.toString(integerObjectMap.get(3), null);
                String fullName = Objects.toString(integerObjectMap.get(4), null);
                String marketName = Objects.toString(integerObjectMap.get(5), null);
                String marketCode = Objects.toString(integerObjectMap.get(6), null);
                String phone = Objects.toString(integerObjectMap.get(7), null);
                String phone1 = Objects.toString(integerObjectMap.get(8), null);
                String idcard = Objects.toString(integerObjectMap.get(9), null);
                String address = Objects.toString(integerObjectMap.get(10), null);

                Map<String, Object> map1 = new HashMap<>();
                map1.put("name", fullName);
                List<Customer> cList = service.selectByMap(map1);

                if(cList.size() == 0 && marketMap.containsKey(marketName)) {
                    Market market = marketMap.get(marketName);
                    Customer model = new Customer();
                    model.setMarketId(market.getId());

                    model.setCustomerCode(code);
                    model.setCustomerNum(num);
                    model.setName(fullName);
                    model.setPhone(phone);
                    model.setPhone1(phone1);
                    model.setIdentityNum(idcard);
                    model.setAddress(address);
                    service.insert(model);
                }


            }


            //TODO 保存数据库

        }finally {
            if(excelReader != null) {
                excelReader.close();
            }
        }

        return ResultVM.ok("ok");
    }


    @Override
    protected List<Column> getColumns() {
        System.out.println(messageSource.getMessage("welcome", null, LocaleContextHolder.getLocale()));


        List<Column> ss = ExportUtils.colsData(Customer.class, messageSource, LocaleContextHolder.getLocale());



        return ss;
    }

    @Override
    protected Settings getSettings() {
        return new Settings().ofActionCol("customerCode");
    }

    /**
     * 获取集合
     * @return
     */
    @GetMapping("/getlist")
    public ResultVM getList() {
        List<Customer> list = service.selectList(new EntityWrapper<>());
        return ResultVM.ok(list);
    }
}


