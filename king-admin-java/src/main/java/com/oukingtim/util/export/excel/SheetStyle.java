package com.oukingtim.util.export.excel;

import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 * Created by haley on 03/01/2018.
 */
public class SheetStyle {

    public static HSSFCellStyle getIndagateHeaderStyle(HSSFWorkbook workBook) {
        HSSFCellStyle cellStyle = workBook.createCellStyle();

        HSSFFont font = workBook.createFont();
        font.setFontHeightInPoints((short)16);
        font.setFontName("Arial");
        font.setColor(IndexedColors.BLACK.getIndex());
        font.setBold(true);
        font.setItalic(false);
        cellStyle.setFont(font);

        return cellStyle;
    }

    public static HSSFCellStyle getTableHeaderStyle(HSSFWorkbook workBook) {
        HSSFCellStyle cellStyle = workBook.createCellStyle();

        HSSFFont font = workBook.createFont();
        font.setFontHeightInPoints((short)16);
        font.setFontName("Arial");
        font.setColor(IndexedColors.BLACK.getIndex());
        font.setBold(true);
        font.setItalic(false);
        cellStyle.setFont(font);

        return cellStyle;
    }
}
