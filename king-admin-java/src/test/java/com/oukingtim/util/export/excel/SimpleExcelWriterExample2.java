package com.oukingtim.util.export.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.oukingtim.util.export.folwgrid.FlowRow;
import com.oukingtim.util.export.folwgrid.FlowCell;
 
/**
 * A very simple program that writes some data to an Excel file
 * using the Apache POI library.
 * @author www.codejava.net
 *
 */
public class SimpleExcelWriterExample2 {

    static int MAX_ROW = 20;

    static int ROW_OFFSET = 2;

    static int COL_OFFSET = 2;


    public static void main(String[] args) throws IOException {

        //start get data
        List<FlowRow> bookData = new ArrayList<>();

        for (int  k = 0; k < 10; k++) {
            bookData.addAll(getFolwRows());
        }


        // to 2 wei shu zhu
        List<List<FlowRow>> arrArr = new ArrayList<>();

        int size = bookData.size();
        int n = (int) Math.ceil(size * 1.0 / MAX_ROW) ;
        for(int i = 0 ; i< n; i++) {
            int toIdx = i * MAX_ROW +  MAX_ROW;
            if(toIdx >= size) {
                toIdx = size;
            }

            List<FlowRow> l = bookData.subList(i * MAX_ROW, toIdx);
            arrArr.add(i, l);
        }


        List<FlowRow> data = new ArrayList<>();

        for (int i =0; i < MAX_ROW; i++) {

            FlowRow bigRow = FlowRow.obj();
            for(int j= 0 , js = arrArr.size();  j< js ; j++ ) {

                if(i < arrArr.get(j).size() ) {
                    bigRow.addFolwRow (arrArr.get(j).get(i));

                }
            }

            data.add(bigRow);
        }


        // start create excell
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");

        int rowCount = ROW_OFFSET;
         
        for (FlowRow item : data) {
            Row row = sheet.createRow(rowCount);
             
            int columnCount = COL_OFFSET;
             
            for (FlowCell flowCell : item.getFlowCell()) {
                Object field = flowCell.getValue();
                if(field != null) {
                    Cell cell = row.createCell(columnCount);

                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }

                    if (flowCell.getRowStep() > 0 || flowCell.getColStep() > 0) {
                        sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount + flowCell.getRowStep(), columnCount, columnCount + flowCell.getColStep()));


                        XSSFCellStyle cellStyle = workbook.createCellStyle();


                        setStyle(workbook, sheet, rowCount, columnCount, cellStyle);
                    }
                }
                columnCount++;
            }

            rowCount++;
             
        }


        try (FileOutputStream outputStream = new FileOutputStream("JavaBooks5.xlsx")) {
            workbook.write(outputStream);
        }
    }

    private static List<FlowRow> getFolwRows() {
        List<FlowRow> bookData = new ArrayList<>();

        bookData.add(FlowRow.obj()
                .addCell(FlowCell.ofGroupCell("FlowCell"))
                .addCell(FlowCell.ofNameCell(null))
                .addCell(FlowCell.ofNameCell(null))
        );

        for(int i = 0; i< 10; i++) {
            bookData.add(
                    FlowRow.obj()
                            .addCell(FlowCell.ofNameCell("name" + i))
                            .addCell(FlowCell.ofNumCell(i))
                            .addCell(FlowCell.ofNameCell(""))

            );
        }

        bookData.add(
                FlowRow.obj()
                        .addCell(FlowCell.ofNameCell(""))
                        .addCell(FlowCell.ofNameCell(""))
                        .addCell(FlowCell.ofNameCell(""))

        );
        bookData.add(
                FlowRow.obj()
                        .addCell(FlowCell.ofNameCell(""))
                        .addCell(FlowCell.ofNameCell(""))
                        .addCell(FlowCell.ofNameCell(""))

        );
        return bookData;
    }

    private static void setStyle(XSSFWorkbook workbook, XSSFSheet sheet, int rowCount, int columnCount, XSSFCellStyle cellStyle) {
        XSSFRow rowEl = sheet.getRow(rowCount);
        XSSFCell cellEL = rowEl.getCell(columnCount);

        XSSFFont font= workbook.createFont();
        font.setFontHeightInPoints((short)14);
        font.setFontName("Arial");
        font.setColor(IndexedColors.BLACK.getIndex());
        font.setBold(true);
        font.setItalic(false);
        cellStyle.setFont(font);
        cellEL.setCellStyle(cellStyle);
    }

}

