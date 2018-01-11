package com.oukingtim.util.export.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;


/**
 * <p></p>
 *
 * @author <a href="mailto:lingyuanbo@foresee.com.cn">lingyuanbo</a>
 * @version $LastChangedRevision: 0 $
 */
public abstract class AbstractReport implements IReport {

	/**
     * 空字符
     */
    protected static final String NULL_STR = "";
    
    /**
     * The staring position of rows
     */
    protected int startRow = 1;
    

	
	/**
     * 当前类自己的logger
     */
    protected static Logger logger = Logger.getLogger(AbstractReport.class);

	/* (non-Javadoc)
	 * @see com.foresee.gdntax.interaction.export.IReport#export(java.util.List, java.util.List, java.io.OutputStream)
	 */
	public void export(List reportHeads, List reportDatas, OutputStream output){
		
		HSSFWorkbook workBook = new HSSFWorkbook();
		
		exportExcel(workBook, reportHeads, reportDatas);

		   // 开始导出Excel工作簿
        try {
            workBook.write(output);
            output.flush();
        } catch (IOException e1) {
        	String msg = "开始导出Excel工作簿出现错误";
            logger.warn(msg);
            //throw new SurveyException(msg);
        } finally {
        	if (null != output) {
        		try {
        			output.close();
				} catch (IOException e) {
					String msg = "close out stream error";
					logger.warn(msg);
				}
        	}
        }

	}
	
	/**
	 * 导出到excel工作薄
	 * @param workBook
	 * @param reportHeads
	 * @param reportDatas
	 */
	protected  void exportExcel(HSSFWorkbook workBook, List reportHeads, List reportDatas){
		HSSFSheet sheet = exportHeader(workBook, reportHeads);
		exportDatas(workBook, reportHeads, reportDatas, sheet);
	}
	
	/**
	 * 导出Excel表头
	 * @param workBook
	 * @param reportHeads
	 * @return HSSFSheet
	 */
	protected   HSSFSheet exportHeader(HSSFWorkbook workBook, List reportHeads){
		String[] tableHeader=getTableHeader();
		short cellNumber=getCellNumber();
		int colSize = reportHeads.size();
		// 新建Excel表单
		HSSFSheet sheet = workBook.createSheet();
		for (int i = 0; i < colSize; i++) {
			ReportHeader header = (ReportHeader) reportHeads.get(i);
			HSSFRow row = sheet.createRow(i);
			HSSFCell cell=null;
            for(int j=0;j<cellNumber;j++){
            	cell = row.createCell((short)j);
    			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
    			//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
    			cell.setCellStyle(SheetStyle.getIndagateHeaderStyle(workBook));
            }


			sheet.addMergedRegion(new CellRangeAddress(i,(short)0,i,(short)(cellNumber-1)));
			String cellValue = header.getDisplayName();
			if (cellValue == null) {
				cellValue = NULL_STR;
			}
			row.getCell((short)0).setCellValue(cellValue);	         
		}
		HSSFRow row = sheet.createRow((short) (colSize));
		for(int k=0;k<cellNumber;k++)   
        {   		
            HSSFCell headerCell = row.createCell((short) k);
            headerCell.setCellType(HSSFCell.CELL_TYPE_STRING);
            //headerCell.setEncoding(HSSFCell.ENCODING_UTF_16);
            headerCell.setCellValue(tableHeader[k]);               
        }  
		return sheet;
	}

	/**
	 * 设置表的列宽度
	 * @param sheet
	 * @param i
	 * @param header
	 */
	protected void formatTableColumns(HSSFSheet sheet, int i, ReportHeader header) {
		    sheet.setColumnWidth((short)i, (short)header.getLength());
	}
	
	/**
	 * 设置表的列宽度
	 * @param sheet
	 * @param i
	 * @param length
	 */
	protected void formatTableColumns(HSSFSheet sheet, int i,  short length) {
		    sheet.setColumnWidth((short)i, length);
	}

	
	/**
	 * 设置表的列宽度
	 * @param sheet
	 * @param cols
	 * @param header
	 */
	protected void formatTableColumns(HSSFSheet sheet, int[] cols, ReportHeader header) {
		if(null==cols||cols.length==0){
			return;
		}
		for(int i=0;i<cols.length;i++){
			sheet.setColumnWidth((short)cols[i], (short)header.getLength());
		}
		    
	}
	
	/**
	 * 设置表的列宽度
	 * @param sheet
	 * @param cols
	 * @param lengths
	 */
	protected void formatTableColumns(HSSFSheet sheet, int[] cols, short[] lengths) {
		if(null==cols||cols.length==0||cols.length!=lengths.length){
			return;
		}
		for(int i=0;i<cols.length;i++){
			sheet.setColumnWidth((short)cols[i], lengths[i]);
		}
		    
	}
	
	/**
	 * 设置表的列宽度
	 * @param sheet
	 * @param cols
	 * @param length
	 */
	protected void formatTableColumns(HSSFSheet sheet, int[] cols, short length) {
		if(null==cols||cols.length==0){
			return;
		}
		for(int i=0;i<cols.length;i++){
			sheet.setColumnWidth((short)cols[i], length);
		}
		    
	}

	/**
	 * 返回tableHeader
	 * <p>@return</p>
	 */
	protected abstract String[] getTableHeader();
	
	/**
	 * 返回cellNumber
	 * <p>@return</p>
	 */
	protected abstract short getCellNumber();
	/**
	 * 返回cellNumber
	 * <p>@return</p>
	 */
	protected abstract String[] getCells();
	
	
	
	/**
	 * 导出reportDatas
	 * @param workBook
	 * @param reportHeads
	 * @param reportDatas
	 * @param sheet
	 */
	protected  void exportDatas(HSSFWorkbook workBook,List reportHeads,List reportDatas, HSSFSheet sheet){
//		 创建row行的开始
		int size = reportHeads.size()+1;
		// 创建body数据开始
		sheet.setDefaultColumnWidth((short)25);
		for (int i = 0; null != reportDatas && i < reportDatas.size(); i++) {
			Object obj = (Object)reportDatas.get(i);
	        HSSFRow row = sheet.createRow((short) size+i);   
	        String[] cells = getCells();
	        for(int j=0;j<cells.length;j++){
	        	HSSFCell cell = row.createCell((short) j);
	        	
	        	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	        	//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	        	try {
					cell.setCellValue(BeanUtils.getProperty(obj, cells[j]));
				} catch (Exception e) {
					e.printStackTrace();
				} 
	        }
		}
	}
}