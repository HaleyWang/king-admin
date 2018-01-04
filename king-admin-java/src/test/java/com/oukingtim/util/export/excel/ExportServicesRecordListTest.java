package com.oukingtim.util.export.excel;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by haley on 03/01/2018.
 */
public class ExportServicesRecordListTest {
    @Test
    public void getCellNumber() throws Exception {


        String[] tableHeader = {"客服人员名称","客服工号","客户名称","客户号","服务时段","服务时长","评价","应答"};
        String[] cellsFeildNames = new String[]{"serviceName"};


        ExportServicesRecordList e = new ExportServicesRecordList();
        e.withTableHeader(tableHeader).withCellsFeildNames(cellsFeildNames);

        List reportHeads = Arrays.asList(new ReportHeader("11", "12", 11111));

        ServiceObj a = new ServiceObj();
        a.setServiceName("a");
        List reportDatas = Arrays.asList(a);

        File file = new File("/Users/haley/Documents/w/king-admin/aa.xls");
        OutputStream output = new FileOutputStream(file);
        e.export(reportHeads, reportDatas, output);

    }

}