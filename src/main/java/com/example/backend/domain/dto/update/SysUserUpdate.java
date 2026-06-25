package com.example.backend.domain.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "修改用户表参数")
public class SysUserUpdate implements Serializable {

    private static final long serialVersionUID = 1L;

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
