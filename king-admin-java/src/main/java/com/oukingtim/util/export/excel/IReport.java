package com.oukingtim.util.export.excel;

import java.io.OutputStream;
import java.util.List;  
  
  
/** 
 * <p>导出excel的接口</p> 
 * 
 * @version $LastChangedRevision: 0 $ 
 */  
public interface IReport {  
  
    /** 
     * 导出文件 
     * @param reportHeads  列名 
     * @param reportDatas  列数据 
     * @param OutputStream 文件输出流 
     * @throws IndagateException  
     */  
    void export(List reportHeads, List reportDatas, OutputStream output);  
}  