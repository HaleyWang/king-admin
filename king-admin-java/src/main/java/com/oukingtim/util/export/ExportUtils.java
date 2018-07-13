package com.oukingtim.util.export;

import com.oukingtim.util.ReflectionUtils;
import com.oukingtim.util.export.grid.Column;
import com.oukingtim.util.export.grid.DataType;
import org.springframework.context.MessageSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by haley on 2018/7/13.
 */
public class ExportUtils {

    public static List<Column> colsData(Class c, MessageSource messageSource, Locale l) {

        String cName = ReflectionUtils.getClsName(c);

        List<String> fieldNames = ReflectionUtils.getFieldsNames(c);

        List<Column> list = new ArrayList<>();
        String widthDefaultStr = Column.DEFAULT_WIDTH + "";
        for(String fName : fieldNames) {


            String name = messageSource.getMessage(cName + "." + fName + ".name", null,null, l);
            if(name == null) {
                continue;
            }
            String type = messageSource.getMessage(cName + "." + fName + ".type", null,"string", l);
            String widthStr = messageSource.getMessage(cName + "." + fName + ".width", null, widthDefaultStr, l);



            DataType dataType =  DataType.valueOf(type);
            int width = Integer.parseInt(widthStr);
            list.add(Column.col(fName, name, dataType, width));
        }
        return list;

    }

}
