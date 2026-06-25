package com.example.backend.domain.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Schema(description = "新增学习技术表参数")
public class LearningTechCreate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "技术名称")
    private String name;

    @Schema(description = "技术分类：后端、前端、数据库等")
    private String category;

    @Schema(description = "学习状态：0计划中，1学习中，2已完成，3暂停")
    private Integer status;

    @Schema(description = "掌握程度：0-100")
    private Integer level;

    @Schema(description = "开始日期")
    private Date startDate;

    @Schema(description = "目标完成日期")
    private Date targetDate;

    @Schema(description = "描述")
    private String description;
}
