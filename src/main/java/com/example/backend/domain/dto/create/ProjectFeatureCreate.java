package com.example.backend.domain.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Schema(description = "新增项目功能表参数")
public class ProjectFeatureCreate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "项目ID")
    private Long projectId;

    @Schema(description = "功能标题")
    private String title;

    @Schema(description = "功能描述")
    private String description;

    @Schema(description = "状态：0待开始，1进行中，2已完成，3取消")
    private Integer status;

    @Schema(description = "优先级：1低，2中，3高")
    private Integer priority;

    @Schema(description = "截止日期")
    private Date dueDate;
}
