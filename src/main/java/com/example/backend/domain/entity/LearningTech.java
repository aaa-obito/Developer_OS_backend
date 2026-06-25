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
* learning_tech : 学习技术表
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "学习技术表")
public class LearningTech extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

        @TableId(type = IdType.AUTO)
        @Schema(description = "技术ID")
        private Long id;

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
