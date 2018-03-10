package com.oukingtim.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.oukingtim.domain.NameType;
import com.oukingtim.domain.NameTypeObj;
import com.oukingtim.domain.OrderItem;
import com.oukingtim.domain.customer.CustomerGroup;
import com.oukingtim.service.NameTypeObjService;
import com.oukingtim.service.NameTypeService;
import com.oukingtim.service.OrderItemService;
import com.oukingtim.util.PathUtils;
import com.oukingtim.util.excel.FileUtil;
import com.oukingtim.util.excel.read.ReadExcelUtils;
import com.oukingtim.util.exception.NormalException;
import com.oukingtim.web.vm.ResultVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by haley on 21/01/2018.
 */


@RestController
@RequestMapping("/api/order_item")
public class OrderItemController extends BaseController<OrderItemService, OrderItem> {

    @Autowired
    NameTypeObjService nameTypeObjService;


    @PostMapping("import")
    public ResultVM importExcel(@RequestParam("file") MultipartFile file) throws Exception {
        //解析excel，
        ReadExcelUtils excelReader = null;
        try {
            excelReader = new ReadExcelUtils(file.getInputStream(), true);
            int sheetIdx = excelReader.getSheetIndex("振安");

            Map<Integer, Map<Integer, Object>> data = excelReader.readExcelContent(sheetIdx, 3);



            String nameTypeId = nameTypeObjService.findNameTypeIdByCode("PIFASHANG");
            List<NameTypeObj> pfsList = nameTypeObjService.findByCode("PIFASHANG");


            String addressNameTypeId = nameTypeObjService.findNameTypeIdByCode("TUZAICHANG");
            List<NameTypeObj> addressList = nameTypeObjService.findByCode("TUZAICHANG");

            Map<String, NameTypeObj> pfsMap = pfsList.stream().collect(Collectors.toMap(p -> p.getName(), o -> o, (r, s) -> r));

            Map<String, NameTypeObj> addressMap = addressList.stream().collect(Collectors.toMap(p -> p.getName(), o -> o, (r, s) -> r));




            for (Integer k : data.keySet()) {



                {
                    String name = data.get(k).get(1)+"";
                    System.out.println(name);
                    if (!pfsMap.containsKey(name)) {
                        System.out.println(name);
                        NameTypeObj psfModel = new NameTypeObj();
                        psfModel.setName(name);
                        psfModel.setNameTypeId(nameTypeId);
                        nameTypeObjService.insert(psfModel);
                    }
                }

                {
                    String address = data.get(k).get(5) + "";
                    if (!addressMap.containsKey(address)) {
                        System.out.println(address);
                        NameTypeObj addressModel = new NameTypeObj();
                        addressModel.setName(address);
                        addressModel.setNameTypeId(addressNameTypeId);
                        nameTypeObjService.insert(addressModel);
                    }
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

}
