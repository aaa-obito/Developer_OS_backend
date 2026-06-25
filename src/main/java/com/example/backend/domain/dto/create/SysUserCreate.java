package com.example.backend.domain.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "新增用户表参数")
public class SysUserCreate implements Serializable {

    private static final long serialVersionUID = 1L;

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
