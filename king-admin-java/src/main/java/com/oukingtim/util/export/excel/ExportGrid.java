package com.oukingtim.util.export.excel;


import com.oukingtim.util.export.grid.Column;
import com.oukingtim.util.export.grid.Grid;
import com.oukingtim.util.export.grid.Row;
import com.oukingtim.util.export.grid.Settings;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author <a href="mailto:lingyuanbo@foresee.com.cn">lingyuanbo</a>
 * @version $LastChangedRevision: 0 $
 */

public class ExportGrid extends AbstractReport {

//	表头   
    private Column[] tableHeader = {};

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
	protected Column[] getTableHeader() {
		return tableHeader;
	}

    private void withTableHeader(Column[] tableHeader) {
        this.tableHeader = tableHeader;
    }


    public void export(Grid grid,HttpServletRequest request, HttpServletResponse response) throws IOException {

        String filename = Optional.ofNullable(grid.getSettings()).map(Settings::getExcelName).orElse(DateFormatUtils.ISO_DATETIME_FORMAT.format(new Date())+".xlsx");//设置下载时客户端Excel的名称

        filename = encodeFilename(filename, request);//处理中文文件名
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + filename);
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Cache-Control", "must-revalidate");
        response.setHeader("Pragma", "public");

        OutputStream ouputStream = response.getOutputStream();
        export(grid, ouputStream);
    }


    public static String encodeFilename(String filename, HttpServletRequest request) {
        /**
         * 获取客户端浏览器和操作系统信息
         * 在IE浏览器中得到的是：User-Agent=Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Maxthon; Alexa Toolbar)
         * 在Firefox中得到的是：User-Agent=Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.7.10) Gecko/20050717 Firefox/1.0.6
         */
        String agent = request.getHeader("USER-AGENT");
        try {
            if ((agent != null) && (-1 != agent.indexOf("MSIE"))) {
                String newFileName = URLEncoder.encode(filename, "UTF-8");
                newFileName = StringUtils.replace(newFileName, "+", "%20");
                if (newFileName.length() > 150) {
                    newFileName = new String(filename.getBytes("GB2312"), "ISO8859-1");
                    newFileName = StringUtils.replace(newFileName, " ", "%20");
                }
                return newFileName;
            }
            if ((agent != null) && (-1 != agent.indexOf("Mozilla"))) {
                return new String(filename.getBytes("UTF-8"), "ISO8859-1");
                //下载javax.mail-api-1.4.7.jar包
                // return MimeUtility.encodeText(filename, "UTF-8", "B");
            }
            return filename;
        } catch (Exception ex) {
            return filename;
        }
    }

    public void export(Grid grid, OutputStream output) {

        // TODO muti header
        // TODO group,LV BVVVVVVVVBC       Q
        this.grid = grid;


        Column[] tableHeader = grid.getColumns().toArray(new Column[]{});

        withTableHeader(tableHeader);

        List reportHeads = new ArrayList();
        List<String> titles = Optional.ofNullable(grid).map(Grid::getSettings).map(Settings::getTitles).orElse(new ArrayList<>());
        for(String title : titles) {
            ReportHeader reportHeader = new ReportHeader();
            reportHeader.setName(title);
            reportHeader.setDisplayName(title);
            reportHeader.setLength(grid.getColumns().size());
            reportHeads.add(reportHeader);
        }

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