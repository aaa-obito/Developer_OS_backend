package com.example.backend.domain.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Schema(description = "修改项目表参数")
public class ProjectUpdate implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "项目ID不能为空")
    @Min(value = 1,message = "项目ID至少为1")
    @Schema(description = "项目ID")
    private Long id;

    @Size(max = 10,message = "项目名称最大为10个字")
    @Schema(description = "项目名称")
    private String name;

    @Schema(description = "项目描述")
    private String description;

    @Schema(description = "开始日期")
    private Date startDate;

    @Schema(description = "结束日期")
    private Date endDate;

    @Schema(description = "GitHub地址")
    private String githubUrl;

    @Schema(description = "部署地址")
    private String deployUrl;
}
