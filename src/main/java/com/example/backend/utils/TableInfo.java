package com.example.backend.utils;

import java.util.List;

public class TableInfo<T> {
    private Integer code;
    private String msg;
    private List<T> rows;
    private Long total;

    public TableInfo() {
    }

    public TableInfo(Integer code, String msg, List<T> rows, Long total) {
        this.code = code;
        this.msg = msg;
        this.rows = rows;
        this.total = total;
    }

    public static <T> TableInfo<T> success(List<T> rows, Long total) {
        return new TableInfo<>(200, "查询成功", rows, total);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
