package com.example.backend.domain.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Schema(description = "修改学习记录表参数")
public class LearningRecordUpdate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "学习记录ID")
    private Long id;

    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "关联技术ID")
    private Long techId;

    @Schema(description = "记录标题")
    private String title;

    @Schema(description = "学习内容")
    private String content;

    @Schema(description = "学习时长，单位分钟")
    private Integer durationMinutes;

    @Schema(description = "学习日期")
    private Date studyDate;
}
