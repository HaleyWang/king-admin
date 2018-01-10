package com.oukingtim.util.export.folwgrid;

import lombok.Data;

@Data
public class FolwCell<T> {

        T value;
        int rowStep;
        int colStep;


        public static GroupCellData ofGroupCell(String value) {
            GroupCellData c = new GroupCellData();
            c.value = value;
            return c;
        }

        public static NameCellData ofNameCell(String value) {
            NameCellData c = new NameCellData();
            c.value = value;
            return c;
        }


        public static NumCellData ofNumCell(Integer value) {
            NumCellData c = new NumCellData();
            c.value = value;
            return c;
        }


    @Data
    public static class GroupCellData extends FolwCell<String> {
        String value;
        int rowStep = 0;
        int colStep = 2;


    }

    @Data
    public static class NameCellData extends FolwCell<String> {
        String value;
        int rowStep = 0;
        int colStep = 0;


    }

    @Data
    public static class NumCellData extends FolwCell<Integer> {
        Integer value;
        int rowStep = 0;
        int colStep = 0;


    }

}
