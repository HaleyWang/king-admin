package com.oukingtim.util.export.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.oukingtim.util.export.folwgrid.FolwCell;
import com.oukingtim.util.export.folwgrid.FolwRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 * A very simple program that writes some data to an Excel file
 * using the Apache POI library.
 * @author www.codejava.net
 *
 */
public class SimpleExcelWriterExample2 {

    static int MAX_ROW = 20;
 
    public static void main(String[] args) throws IOException {


        //start get data
        List<FolwRow> bookData = new ArrayList<>();

        FolwCell gc = FolwCell.ofGroupCell("FolwCell");
        bookData.add(FolwRow.of()
                .addCell(gc)
                .addCell(FolwCell.ofNameCell(null))
                .addCell(FolwCell.ofNameCell(null))
        );

        for(int i = 0; i< 100; i++) {
            bookData.add(
                    FolwRow.of()
                            .addCell(FolwCell.ofNameCell("name" + i))
                            .addCell(FolwCell.ofNumCell(i))
                            .addCell(FolwCell.ofNameCell(""))

            );
        }

        bookData.add(
                FolwRow.of()
                        .addCell(FolwCell.ofNameCell(""))
                        .addCell(FolwCell.ofNameCell(""))
                        .addCell(FolwCell.ofNameCell(""))

        );
        bookData.add(
                FolwRow.of()
                        .addCell(FolwCell.ofNameCell(""))
                        .addCell(FolwCell.ofNameCell(""))
                        .addCell(FolwCell.ofNameCell(""))

        );

        // to 2 wei shu zhu
        List<List<FolwRow>> arrArr = new ArrayList<>();

        int size = bookData.size();
        int n = (int) Math.ceil(size * 1.0 / MAX_ROW) ;
        for(int i = 0 ; i< n; i++) {
            int toIdx = i * MAX_ROW +  MAX_ROW;
            if(toIdx >= size-1) {
                toIdx = size-1;
            }

            List<FolwRow> l = bookData.subList(i * MAX_ROW, toIdx);
            arrArr.add(i, l);
        }


        List<FolwRow> data = new ArrayList<>();

        for (int i =0; i < MAX_ROW; i++) {

            FolwRow bigRow = FolwRow.of();
            for(int j= 0 ;  j< arrArr.size() ; j++ ) {

                if(i < arrArr.get(j).size() ) {
                    bigRow.addFolwRow (arrArr.get(j).get(i));

                }
            }

            data.add(bigRow);
        }


        // start create excell
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");

        int rowCount = 0;
         
        for (FolwRow item : data) {
            Row row = sheet.createRow(rowCount);
             
            int columnCount = 0;
             
            for (FolwCell folwCell : item.getFolwCell()) {
                Object field = folwCell.getValue();
                if(field != null) {
                    Cell cell = row.createCell(columnCount);

                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }

                    if (folwCell.getRowStep() > 0 || folwCell.getColStep() > 0) {
                        sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount + folwCell.getRowStep(), columnCount, columnCount + folwCell.getColStep()));


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

    private static void setStyle(XSSFWorkbook workbook, XSSFSheet sheet, int rowCount, int columnCount, XSSFCellStyle cellStyle) {
        XSSFRow rowEl = sheet.getRow(rowCount);
        XSSFCell cellEL = rowEl.getCell(columnCount);

        XSSFFont font= workbook.createFont();
        font.setFontHeightInPoints((short)20);
        font.setFontName("Arial");
        font.setColor(IndexedColors.BLACK.getIndex());
        font.setBold(true);
        font.setItalic(false);
        cellStyle.setFont(font);
        cellEL.setCellStyle(cellStyle);
    }

}


