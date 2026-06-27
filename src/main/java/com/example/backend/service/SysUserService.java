package com.example.backend.service;

import com.example.backend.domain.dto.other.LoginDTO;
import com.example.backend.domain.dto.other.RegisterDTO;
import com.example.backend.domain.entity.SysUser;
import com.example.backend.domain.dto.create.SysUserCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.SysUserUpdate;
import com.example.backend.domain.vo.SysUserVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

public interface SysUserService extends IService<SysUser> {

    PageInfo<SysUserVo> queryList(PageQuery query);

    boolean add(SysUserCreate createParam);

    boolean updateSysUser(SysUserUpdate updateParam);

    boolean register(RegisterDTO registerDTO);

    String login(LoginDTO loginDTO);

    void logout();
}
