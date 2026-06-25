package com.example.backend.domain.dto.query;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "分页参数")
public class PageQuery {
    @Schema(description = "当前页码")
    private Integer pageNum;

    @Schema(description = "每页显示数量")
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
