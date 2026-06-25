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
* tag : 标签表
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "标签表")
public class TagEntity extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

        @TableId(type = IdType.AUTO)
        @Schema(description = "标签ID")
        private Long id;

        @Schema(description = "用户ID")
        private Long userId;

        @Schema(description = "标签名称")
        private String name;

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
