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
* project : 项目表
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "项目表")
public class Project extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

        @TableId(type = IdType.AUTO)
        @Schema(description = "项目ID")
        private Long id;

        @Schema(description = "用户ID")
        private Long userId;

        @Schema(description = "项目名称")
        private String name;

        @Schema(description = "项目描述")
        private String description;

        @Schema(description = "项目状态：0计划中，1开发中，2已完成，3暂停")
        private Integer status;

        @Schema(description = "开始日期")
        private Date startDate;

        @Schema(description = "结束日期")
        private Date endDate;

        @Schema(description = "GitHub地址")
        private String githubUrl;

        @Schema(description = "部署地址")
        private String deployUrl;

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
