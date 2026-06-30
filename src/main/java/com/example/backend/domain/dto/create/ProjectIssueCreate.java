package com.example.backend.domain.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "新增项目问题记录表参数")
public class ProjectIssueCreate implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "项目ID不能为空")
    @Schema(description = "项目ID")
    private Long projectId;

    @NotBlank(message = "问题标题不能为空")
    @Size(max = 10,message = "问题标题最大为10个字")
    @Schema(description = "问题标题")
    private String title;

    @Schema(description = "问题描述")
    private String description;

    @Schema(description = "状态：0未解决，1处理中，2已解决，3关闭")
    private Integer status;

    @Schema(description = "优先级：1低，2中，3高")
    private Integer priority;

    @Schema(description = "解决方案")
    private String solution;
}
