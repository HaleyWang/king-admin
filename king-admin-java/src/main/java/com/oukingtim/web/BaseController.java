package com.oukingtim.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.oukingtim.domain.BaseModel;
import com.oukingtim.domain.customer.CustomerGroup;
import com.oukingtim.util.ShiroUtils;
import com.oukingtim.util.StringTools;
import com.oukingtim.util.excel.FileUtil;
import com.oukingtim.util.exception.NormalException;
import com.oukingtim.util.export.excel.ExportGrid;
import com.oukingtim.util.export.grid.Column;
import com.oukingtim.util.export.grid.Grid;
import com.oukingtim.util.export.grid.Settings;
import com.oukingtim.web.vm.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 通用Controller（增删改查）
 * Created by oukingtim
 */
public abstract class BaseController<S extends IService<T>, T extends BaseModel<T>> {

    @Autowired
    protected S service;

    @PostMapping("export_excel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response, @RequestBody Grid grid) throws IOException {


        new ExportGrid().export(grid, request, response);

        //导出操作
        //FileUtil.exportExcel(data, head, sheetName, fileName, response);
    }

    @GetMapping("export")
    public void export(HttpServletResponse response, SmartPageVM<T> spage,
                       String head, String sheetName, String fileName) throws NormalException {


        if(spage == null) {
            spage = new SmartPageVM<>();

        }
        if(spage.getPagination() == null) {

            SmartPagination p = new SmartPagination();
            p.setStart(0);
            p.setNumberOfPages(0);
            p.setNumber(1000);
            spage.setPagination(p);

        }
        if(spage.getSort() == null) {

            SmartSort sort = new SmartSort();
            sort.setPredicate("id");
            spage.setSort(sort);
        }

        ResultVM result = getSmartData(spage);


        Page<T> page = (Page<T>)result.getResult();
        List<T> list = page.getRecords();

        //导出操作
        FileUtil.exportExcel(list, head, sheetName, CustomerGroup.class, fileName,response);
    }

    /**
     * 根据smarttable对象分页查询
     * @param spage
     * @return
     */
    @PostMapping("/getSmartData")
    public ResultVM getSmartData(@RequestBody SmartPageVM<T> spage){
        Page<T> page = new Page<T>(spage.getPagination().getStart()
                ,spage.getPagination().getNumber());

        if (StringUtils.isBlank(spage.getSort().getPredicate())) {
            spage.getSort().setPredicate("update_time");
        }
        page.setOrderByField(spage.getSort().getPredicate());
        page.setAsc(spage.getSort().getReverse());
        EntityWrapper<T> wrapper = new EntityWrapper<T>();
        if (spage.getSearch()!=null){
            Field[] fields = spage.getSearch().getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                try {
                    fields[i].setAccessible(true);
                    Object value = fields[i].get(spage.getSearch());
                    if (null != value && !value.equals("")) {
                        String fieldname = StringTools.underscoreName(fields[i].getName());
                        wrapper.like(fieldname,value.toString());
                    }
                    fields[i].setAccessible(false);
                } catch (Exception e) {
                }
            }
        }
        return  ResultVM.ok(service.selectPage(page, wrapper)).of(getColumns(), getSettings());
    }

    protected List<Column> getColumns() {
        return new ArrayList<>();
    }

    protected Settings getSettings() {
        return new Settings();
    }

    /**
     * 新增
     * @param t
     * @return
     */
    @PostMapping
    public ResultVM create(@RequestBody T t) {

        t.setCreateUserId(ShiroUtils.getUserId());
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        t.setUpdateUserId(ShiroUtils.getUserId());
        if(service.insert(t)){
            return ResultVM.ok();
        }else{
            return ResultVM.error();
        }
    }

    /**
     * 更新
     * @param t
     * @return
     */
    @PutMapping
    public ResultVM update(@RequestBody T t) {

        t.setUpdateTime(new Date());
        t.setUpdateUserId(ShiroUtils.getUserId());
        if(service.updateById(t)){
            return ResultVM.ok();
        }else{
            return ResultVM.error();
        }
    }

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public T getInfo(@PathVariable String id) {
        return service.selectById(id);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResultVM delete(@PathVariable String id) {
        if(service.deleteById(id)){
            return ResultVM.ok();
        }else{
            return ResultVM.error();
        }
    }
}
