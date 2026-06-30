package com.example.backend.domain.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Schema(description = "新增学习记录表参数")
public class LearningRecordCreate implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "关联技术ID不能为空")
    @Schema(description = "关联技术ID")
    private Long techId;

    @NotBlank(message = "项目名称不能为空")
    @Schema(description = "记录标题")
    private String title;

    @Schema(description = "学习内容")
    private String content;

    @Schema(description = "学习时长，单位分钟")
    private Integer durationMinutes;

    @Schema(description = "学习日期")
    private Date studyDate;
}
