package com.oukingtim.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by haley on 21/01/2018.
 */
public class PathUtils {

    public static String getClassRootUrl(Class c) {

        // 第一种：获取类加载的根路径   D:\git\daotie\daotie\target\classes
        File f = new File(c.getResource("/").getPath());
        return f.getAbsolutePath();

    }

    public static String getClassUrl(Class c) {


        // 获取当前类的所在工程路径; 如果不加“/”  获取当前类的加载目录  D:\git\daotie\daotie\target\classes\my
        File f = new File(c.getResource("").getPath());
        return f.getAbsolutePath();

    }

    public static String getProjectUrl() throws IOException {


        // 第二种：获取项目路径    D:\git\daotie\daotie
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        return courseFile;

    }

    public static String getClassLoaderUrl(Class c) {


        // 第三种：  file:/D:/git/daotie/daotie/target/classes/
        URL url = c.getClassLoader().getResource("");
        return url.getPath();

    }


    public static String getUserDirUrl() {

        // 第四种： D:\git\daotie\daotie
        return System.getProperty("user.dir");


    }

    public static String getClassPathUrl() {


        // 第五种：  获取所有的类路径 包括jar包的路径
        return System.getProperty("java.class.path");

    }


}
