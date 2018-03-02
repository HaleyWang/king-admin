package com.oukingtim.dto;

import com.oukingtim.domain.customer.CustomerGroup;
import com.oukingtim.util.excel.FileUtil;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by haley on 03/03/2018.
 */
public class MarketDtoTest {

    @Test
    public void readExcel() throws Exception {
        String file = "a.xls";
        //MultipartFile file = new MultipartFile();
        List<MarketDto> personList = FileUtil.importExcel(file,1,1,MarketDto.class);
    }

    @Test
    public void outExcel() throws Exception {
        String file = "a.xls";
        //MultipartFile file = new MultipartFile();
        List<MarketDto> personList = FileUtil.importExcel(file,1,1,MarketDto.class);


    }

}