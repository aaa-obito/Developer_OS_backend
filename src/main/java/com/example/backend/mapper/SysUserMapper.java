package com.example.backend.mapper;

import com.example.backend.domain.entity.SysUser;
import jakarta.validation.constraints.NotBlank;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper extends BaseMapper<SysUser>{

    SysUser selectByUsername(@NotBlank(message = "账号不能为空") String username);
}
