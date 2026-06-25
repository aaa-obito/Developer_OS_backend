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
* project_feature : 项目功能表
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "项目功能表")
public class ProjectFeature extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

        @TableId(type = IdType.AUTO)
        @Schema(description = "项目功能ID")
        private Long id;

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

        @Schema(description = "创建者ID")
        private Long createBy;

        @Schema(description = "更新者ID")
        private Long updateBy;

        @Schema(description = "创建时间")
        private Date createTime;

        @Schema(description = "更新时间")
        private Date updateTime;

        @Schema(description = "删除标志：0未删除，1已删除")
        @TableLogic
        private Integer delFlag;

}
