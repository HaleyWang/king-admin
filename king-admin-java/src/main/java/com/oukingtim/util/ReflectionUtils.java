package com.oukingtim.util;

import com.google.common.base.CaseFormat;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by haley on 2018/7/13.
 */
public class ReflectionUtils extends org.springframework.util.ReflectionUtils {

    public static String getClassName(Class<?> clazz) {
        return clazz.getName();
    }

    public static String getClsName(Class<?> clazz) {
        CaseFormat fromFormat = CaseFormat.UPPER_CAMEL;
        CaseFormat toFormat = CaseFormat.LOWER_CAMEL;
        String s = clazz.getName() ;
        s = s.substring(s.lastIndexOf(".")+1);
        return fromFormat.to(toFormat, s);
    }

    public static List<String> getFieldsNames(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        int len = fields.length;

        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Field field = fields[i];
            String fieldName = field.getName();
            list.add(fieldName);
        }

        return list;
    }
}
