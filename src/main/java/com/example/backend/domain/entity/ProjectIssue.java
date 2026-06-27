package com.example.backend.domain.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
* project_issue : 项目问题记录表
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "项目问题记录表")
public class ProjectIssue extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

        @TableId(type = IdType.AUTO)
        @Schema(description = "问题ID")
        private Long id;

        @Schema(description = "项目ID")
        private Long projectId;

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
