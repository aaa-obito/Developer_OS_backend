package com.example.backend.domain.dto.other;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
@Schema(description = "登录参数")
public class ProjectStatusDTO {
    @NotNull(message = "项目id不能为空")
    @Schema(description = "项目id")
    private String id;

    @NotNull(message = "项目状态不能为空")
    @Schema(description = "项目状态：0计划中，1开发中，2已完成，3暂停")
    @Min(value = 0, message = "项目状态不能小于0")
    @Max(value = 3, message = "项目状态不能大于3")
    private Integer status;
}
