package com.example.backend.domain.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
* sys_user : 用户表
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Schema(description = "用户表")
public class SysUser extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

        @TableId(type = IdType.AUTO)
        @Schema(description = "用户ID")
        private Long id;

        @Schema(description = "用户名")
        private String username;

        @Schema(description = "邮箱")
        private String email;

        @Schema(description = "密码哈希")
        private String passwordHash;

        @Schema(description = "头像地址")
        private String avatar;

        @Schema(description = "状态：0禁用，1正常")
        private Integer status;

}
