package com.example.backend.mapping;

import com.example.backend.domain.dto.other.RegisterDTO;
import com.example.backend.domain.entity.SysUser;
import com.example.backend.domain.dto.create.SysUserCreate;
import com.example.backend.domain.dto.update.SysUserUpdate;
import com.example.backend.domain.vo.SysUserVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysUserMapping {
    SysUserMapping INSTANCE = Mappers.getMapper(SysUserMapping.class);

    SysUser register(RegisterDTO registerDTO);

    SysUserVo to(SysUser entity);

    List<SysUserVo> toVoList(List<SysUser> entities);

    SysUser fromCreate(SysUserCreate createParam);

    SysUser fromUpdate(SysUserUpdate updateParam);
}
