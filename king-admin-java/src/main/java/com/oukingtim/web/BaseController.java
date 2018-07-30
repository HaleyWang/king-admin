package com.oukingtim.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.google.common.base.Splitter;
import com.oukingtim.domain.BaseModel;
import com.oukingtim.domain.customer.Customer;
import com.oukingtim.domain.customer.CustomerGroup;
import com.oukingtim.dto.IdName;
import com.oukingtim.util.ReflectionUtils;
import com.oukingtim.util.ShiroUtils;
import com.oukingtim.util.StringTools;
import com.oukingtim.util.excel.FileUtil;
import com.oukingtim.util.exception.NormalException;
import com.oukingtim.util.export.ExportUtils;
import com.oukingtim.util.export.excel.ExportGrid;
import com.oukingtim.util.export.grid.Column;
import com.oukingtim.util.export.grid.Grid;
import com.oukingtim.util.export.grid.Settings;
import com.oukingtim.web.vm.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 通用Controller（增删改查）
 * Created by oukingtim
 */
public abstract class BaseController<S extends IService<T>, T extends BaseModel<T>> {

    @Autowired
    protected S service;

    @Autowired
    protected MessageSource messageSource;

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

        if(spage.getDateFilterParams() != null) {
            String id = spage.getDateFilterParams().getId();
            String dateRange = spage.getDateFilterParams().getDateRange();
            if(StringUtils.isNotEmpty(id) && dateRange != null && dateRange.indexOf(" - ") > 0) {
                String[] arr = dateRange.split(" - ");
                String fieldname = StringTools.underscoreName(id);
                wrapper.and().between(fieldname, arr[0] + " 00:00:00", arr[1] + " 23:59:59");
            }
        }

        if (spage.getSearch()!=null){
            Field[] fields = spage.getSearch().getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                try {
                    fields[i].setAccessible(true);
                    Object value = fields[i].get(spage.getSearch());
                    if (null != value && !value.equals("")) {
                        String fieldname = StringTools.underscoreName(fields[i].getName());
                        wrapper.or().like(fieldname, value.toString());

                    }
                    fields[i].setAccessible(false);
                } catch (Exception e) {
                }
            }
        }

        return  ResultVM.ok(service.selectPage(page, wrapper)).of(getGridOptions());
    }

    protected Grid getGridOptions() {

        Class entityClass = (Class) (ReflectionUtils.getSuperclassActualTypeArguments(getClass())[1]);

        Locale locale = LocaleContextHolder.getLocale();

        List<Column> cols = ExportUtils.colsData(entityClass, messageSource, locale);

        String actionColumn = ExportUtils.getValeBySubKey(entityClass, messageSource, locale, "action.column", "");
        String excelName = ExportUtils.getValeBySubKey(entityClass, messageSource, locale, "file.excelName", "untitle.xlsx");
        String datePickerOptionsStr = ExportUtils.getValeBySubKey(entityClass, messageSource, locale, "datePicker.options", "");

        List<IdName> datePickerOptions = null;
        if(datePickerOptionsStr.indexOf(",") > 0) {
            datePickerOptions = Splitter.on(";").withKeyValueSeparator(",").split(datePickerOptionsStr).entrySet()
                    .stream().map(it -> new IdName(it.getKey(), it.getValue()))
                    .collect(Collectors.toList());
        }else {
            datePickerOptions = new ArrayList<>();
        }

        //datePicker
        Settings s =  new Settings().ofActionCol(actionColumn).ofExcelName(excelName).ofDatePickerOptions(datePickerOptions);

        return new Grid(cols, s);
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

