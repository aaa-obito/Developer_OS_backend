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
* learning_record : 学习记录表
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "学习记录表")
public class LearningRecord extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

        @TableId(type = IdType.AUTO)
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
