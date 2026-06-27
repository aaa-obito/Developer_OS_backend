package com.example.backend.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
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

}
