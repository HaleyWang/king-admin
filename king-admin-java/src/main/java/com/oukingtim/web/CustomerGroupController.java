package com.oukingtim.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.oukingtim.domain.NameTypeObj;
import com.oukingtim.domain.TbDictClass;
import com.oukingtim.domain.customer.Customer;
import com.oukingtim.domain.customer.CustomerGroup;
import com.oukingtim.domain.customer.Market;
import com.oukingtim.service.customer.CustomerGroupService;
import com.oukingtim.service.customer.CustomerService;
import com.oukingtim.service.customer.MarketService;
import com.oukingtim.util.excel.FileUtil;
import com.oukingtim.util.excel.read.ReadExcelUtils;
import com.oukingtim.util.exception.NormalException;
import com.oukingtim.web.vm.ResultVM;
import com.oukingtim.web.vm.SmartPageVM;
import com.oukingtim.web.vm.SmartPagination;
import com.oukingtim.web.vm.SmartSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by haley on 11/01/2018.
 */

@RestController
@RequestMapping("/api/customer-group")
public class CustomerGroupController extends BaseController<CustomerGroupService, CustomerGroup> {



    /**
     * 获取集合
     * @return
     */
    @GetMapping("/getlist")
    public ResultVM getList() {
        List<CustomerGroup> list = service.selectList(new EntityWrapper<>());
        return ResultVM.ok(list);
    }



    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "upload error," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "upload error," + e.getMessage();
            }
            return "ok";
        } else {
            return "upload error, file is empty.";
        }
    }





    @GetMapping("export1")
    public void export1(HttpServletResponse response,
                       String head, String sheetName, String fileName) throws NormalException {


        CustomerGroup c = new CustomerGroup();
        c.setName("aa");
        c.setRemark("hhha");
        List<CustomerGroup> list = Arrays.asList(c);

        //导出操作
        FileUtil.exportExcel(list, head, sheetName, CustomerGroup.class, fileName,response);
    }


}
