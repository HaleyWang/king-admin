package com.oukingtim.web.vm;

import com.oukingtim.util.export.grid.Column;
import com.oukingtim.util.export.grid.Grid;
import com.oukingtim.util.export.grid.Settings;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by oukingtim
 */
@Data
public class ResultVM implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Integer CODE = 0;

    private Integer code;

    private Grid grid;

    private String msg;

    private Object result;

    public ResultVM() {

    }

    public ResultVM(Integer code) {
        this.code = code;
    }

    public ResultVM(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVM(Integer code, Object result) {
        this.code = code;
        this.result = result;
    }

    public ResultVM(Object result) {
        this.result = result;
    }

    public static ResultVM error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static ResultVM error(String msg) {
        return error(500, msg);
    }

    public static ResultVM error(Integer code, String msg) {
        return new ResultVM(code, msg);
    }

    public static ResultVM ok(String msg) {
        return new ResultVM(CODE, msg);
    }

    public static ResultVM ok(Object result) {
        return new ResultVM(CODE, result);
    }
    public static ResultVM ok() {
        return new ResultVM(CODE);
    }


    public ResultVM of(Grid grid) {
        this.grid = grid;
        return this;
    }

    public ResultVM of(List<Column> columns, Settings settings) {
        this.grid = new Grid();
        this.grid.setSettings(settings);
        this.grid.setColumns(columns);
        return this;
    }
}
