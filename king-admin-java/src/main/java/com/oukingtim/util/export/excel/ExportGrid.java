package com.oukingtim.util.export.excel;


import com.oukingtim.util.export.grid.Column;
import com.oukingtim.util.export.grid.Grid;
import com.oukingtim.util.export.grid.Row;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author <a href="mailto:lingyuanbo@foresee.com.cn">lingyuanbo</a>
 * @version $LastChangedRevision: 0 $
 */

public class ExportGrid extends AbstractReport {

//	表头   
    private String[] tableHeader = {};

	Grid grid;
    
	/* (non-Javadoc)
	 * @see com.foresee.export.AbstractReport#getCellNumber()
	 */
	protected short getCellNumber() {
		return (short)tableHeader.length;
	}

    @Override
    protected String[] getCells() {
        return grid.getColumns().stream().map(Column::getId).collect(Collectors.toList()).toArray(new String[]{});
    }


    /* (non-Javadoc)
     * @see com.foresee.export.AbstractReport#getTableHeader()
     */
	protected String[] getTableHeader() {
		return tableHeader;
	}

    private void withTableHeader(String[] tableHeader) {
        this.tableHeader = tableHeader;
    }


    public void export(Grid grid, OutputStream output) {

        this.grid = grid;

        List<String> tableHeaderList = grid.getColumns().stream().map(Column::getName).collect(Collectors.toList());

        String[] tableHeader = tableHeaderList.toArray(new String[]{});

        withTableHeader(tableHeader);

        List reportHeads = new ArrayList();

        this.export(reportHeads, grid.getRows(), output);
    }



    @Override
    protected  void exportDatas(HSSFWorkbook workBook, List reportHeads, List rows, HSSFSheet sheet){
//		 创建row行的开始


        List<Row> rowList = (List<Row>)rows;



        int size = reportHeads.size()+1;
        // 创建body数据开始
        sheet.setDefaultColumnWidth((short)25);
        for (int i = 0; null != rowList && i < rowList.size(); i++) {
            Row rowData = rowList.get(i);
            HSSFRow row = sheet.createRow((short) size+i);
            String[] cells = getCells();
            for(int j=0;j<cells.length;j++){
                HSSFCell cell = row.createCell((short) j);

                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                //cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                try {
                    //cell.setCellValue(BeanUtils.getProperty(obj, cells[j]));

                    Object cellData = rowData.get(cells[j]);
                    if(cellData instanceof String) {
                        cell.setCellValue((String) cellData);
                    }else if(cellData instanceof Double) {
                        cell.setCellValue((Double) cellData);
                    }else if(cellData instanceof Integer) {
                        cell.setCellValue((Integer) cellData);
                    }else if(cellData instanceof Float) {
                        cell.setCellValue((Float) cellData);
                    }else {
                        cell.setCellValue((String) cellData);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}