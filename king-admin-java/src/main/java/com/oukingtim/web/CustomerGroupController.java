package com.oukingtim.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.oukingtim.domain.TbDictClass;
import com.oukingtim.domain.customer.Customer;
import com.oukingtim.domain.customer.CustomerGroup;
import com.oukingtim.service.customer.CustomerGroupService;
import com.oukingtim.service.customer.CustomerService;
import com.oukingtim.util.excel.FileUtil;
import com.oukingtim.util.exception.NormalException;
import com.oukingtim.web.vm.ResultVM;
import com.oukingtim.web.vm.SmartPageVM;
import com.oukingtim.web.vm.SmartPagination;
import com.oukingtim.web.vm.SmartSort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

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



    @PostMapping("import")
    public String importExcel(@RequestParam("file") MultipartFile file) throws NormalException {
        //解析excel，
        List<CustomerGroup> personList = FileUtil.importExcel(file,1,1,CustomerGroup.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");

        //TODO 保存数据库

        return "ok";
    }


}
