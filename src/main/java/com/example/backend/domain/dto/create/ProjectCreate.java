package com.example.backend.domain.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Schema(description = "新增项目表参数")
public class ProjectCreate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Max(value = 10,message = "项目名称最大为10个字")
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
