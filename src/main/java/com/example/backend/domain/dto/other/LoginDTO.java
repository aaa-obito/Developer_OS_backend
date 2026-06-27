package com.example.backend.domain.dto.other;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "登录参数")
public class LoginDTO {
    @NotBlank(message = "账号不能为空")
    @Schema(description = "账号")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Schema(description = "密码")
    private String password;

}
