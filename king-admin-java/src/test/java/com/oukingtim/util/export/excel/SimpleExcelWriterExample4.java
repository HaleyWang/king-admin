package com.oukingtim.util.export.excel;

import com.oukingtim.util.export.folwgrid.FlowCell;
import com.oukingtim.util.export.folwgrid.FlowRow;
import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A very simple program that writes some data to an Excel file
 * using the Apache POI library.
 * @author www.codejava.net
 *
 */
public class SimpleExcelWriterExample4 {

    private static final int CONTENT_ROW_OFFSET = 2;

    int maxRow = 20;
    int colOffset = 0;
    int rowOffset = 0;

    @Data
    public static class Group {
        String name;

        public static Group ofName(String name) {
            Group g = new Group();
            g.name = name;
            return g;
        }
    }

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        // start create excel
        XSSFSheet sheet = workbook.createSheet("Java Books");
        

        List<FlowRow> contentData = getContentData();

        SimpleExcelWriterExample4 e = new SimpleExcelWriterExample4();

        Pair<Integer, Integer> pair = e.createContent(workbook, sheet, contentData, 0, CONTENT_ROW_OFFSET, null);
        System.out.println(pair);

        SimpleExcelWriterExample4 e1 = new SimpleExcelWriterExample4();
        Pair<Integer, Integer> pair1 = e1.createContent(workbook, sheet, contentData, pair.getLeft() + 1, CONTENT_ROW_OFFSET, Group.ofName("aa"));
        System.out.println(pair1);

        SimpleExcelWriterExample4 e12 = new SimpleExcelWriterExample4();
        Pair<Integer, Integer> pair12 = e12.createContent(workbook, sheet, contentData, pair1.getLeft() + 1, CONTENT_ROW_OFFSET, Group.ofName("bb"));
        System.out.println(pair12);
        createHeader1(workbook, sheet, "aa table", pair12.getLeft());

        List<String> colNames = new ArrayList<>();
        for(int i= 0, n = (int)Math.ceil(pair12.getLeft()/3.0); i < n ; i++) {
            colNames.add("名称");
            colNames.add("数量");
            colNames.add("");
        }
        createHeader2(workbook, sheet, colNames);
        try (FileOutputStream outputStream = new FileOutputStream("JavaBooks4-1.xlsx")) {
            workbook.write(outputStream);
        }
    }

    private static void createHeader1(XSSFWorkbook workbook, XSSFSheet sheet, String title, int colNum) {
        Row row = sheet.getRow(0);
        if(row == null) {
            row = sheet.createRow(0);
        }
        Cell cell = row.createCell(0);

        cell.setCellValue(title);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, colNum));


    }

    private static void createHeader2(XSSFWorkbook workbook, XSSFSheet sheet, List<String> colNames) {
        Row row = sheet.getRow(1);
        if(row == null) {
            row = sheet.createRow(1);
        }

        for(int i = 0, n = colNames.size(); i < n; i++) {
            Cell cell = row.createCell(i);

            cell.setCellValue(colNames.get(i));
        }

    }


    public Pair<Integer, Integer> createContent(XSSFWorkbook workbook, XSSFSheet sheet, List<FlowRow> contentData, int colOffset, int rowOffset, Group group) {

        //start get data
        this.colOffset = colOffset;
        this.rowOffset = rowOffset;

        // to 2 wei shu zhu
        List<List<FlowRow>> arrArr = new ArrayList<>();

        int size = contentData.size();
        int n = (int) Math.ceil(size * 1.0 / maxRow) ;
        for(int i = 0 ; i< n; i++) {
            int toIdx = i * maxRow + maxRow;
            if(toIdx >= size) {
                toIdx = size;
            }

            List<FlowRow> l = new ArrayList<>();
            l.addAll(contentData.subList(i * maxRow, toIdx));

            if(l.size() < maxRow) {
                for(int m = 0, z = maxRow - l.size(); m< z; m++) {
                    l.add(
                        FlowRow.obj()
                                .addCell(FlowCell.ofNameCell(""))
                                .addCell(FlowCell.ofNameCell(""))
                                .addCell(FlowCell.ofNameCell(""))
                    );
                }
            }
            arrArr.add(i, l);
        }


        List<FlowRow> data = new ArrayList<>();

        for (int i = 0; i < maxRow; i++) {

            FlowRow bigRow = FlowRow.obj();
            for(int j= 0 ;  j< arrArr.size() ; j++ ) {
                if(i < arrArr.get(j).size() ) {
                    bigRow.addFolwRow (arrArr.get(j).get(i));

                }
            }
            data.add(bigRow);
        }

        int rowCount = group == null ? rowOffset : (rowOffset + 1);
        int columnCountFinal = colOffset;
         
        for (FlowRow item : data) {
            Row row = sheet.getRow(rowCount);
            if(row == null) {
                row = sheet.createRow(rowCount);
            }

            int columnCount = colOffset;
             
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
            columnCountFinal = columnCount;
            rowCount++;
        }

        columnCountFinal = columnCountFinal -1;
        int rowCountFinal = rowCount -1;

        if(group != null) {
            Row row = sheet.getRow(CONTENT_ROW_OFFSET);
            Cell cell = row.createCell(colOffset);
            cell.setCellValue(group.getName());
            sheet.addMergedRegion(new CellRangeAddress(CONTENT_ROW_OFFSET, CONTENT_ROW_OFFSET, colOffset, columnCountFinal));
            XSSFCellStyle cellStyle = workbook.createCellStyle();
            setStyle(workbook, sheet, CONTENT_ROW_OFFSET, colOffset, cellStyle);
        }

        return Pair.of(columnCountFinal, rowCountFinal);

    }

    private static List<FlowRow> getContentData() {
        List<FlowRow> bookData = new ArrayList<>();

        for (int  k = 0; k < 10; k++) {
            bookData.addAll(getFolwRows());
        }
        return bookData;
    }

    private static List<FlowRow> getFolwRows() {
        List<FlowRow> bookData = new ArrayList<>();

        bookData.add(FlowRow.obj()
                .addCell(FlowCell.ofGroupCell("FlowCell 中文"))
                .addCell(FlowCell.ofNameCell(null))
                .addCell(FlowCell.ofNameCell(null))
        );

        for(int i = 0; i< 10; i++) {
            bookData.add(
                    FlowRow.obj()
                            .addCell(FlowCell.ofNameCell("中文" + i))
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


