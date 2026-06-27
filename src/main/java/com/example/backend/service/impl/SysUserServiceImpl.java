package com.example.backend.service.impl;

import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.dto.other.LoginDTO;
import com.example.backend.domain.dto.other.RegisterDTO;
import com.example.backend.domain.entity.SysUser;
import com.example.backend.domain.dto.create.SysUserCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.SysUserUpdate;
import com.example.backend.domain.vo.SysUserVo;
import com.example.backend.mapper.SysUserMapper;
import com.example.backend.mapping.SysUserMapping;
import com.example.backend.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.utils.JwtUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final SysUserMapper sysUserMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    @Override
    public PageInfo<SysUserVo> queryList(PageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getDelFlag, ReturnConstant.DEFAULT_DEL);
        List<SysUser> records = sysUserMapper.selectList(queryWrapper);
        return new PageInfo<>(SysUserMapping.INSTANCE.toVoList(records));
    }

    @Override
    public boolean add(SysUserCreate createParam) {
        SysUser entity = SysUserMapping.INSTANCE.fromCreate(createParam);
        return save(entity);
    }

    @Override
    public boolean updateSysUser(SysUserUpdate updateParam) {
        SysUser entity = SysUserMapping.INSTANCE.fromUpdate(updateParam);
        return updateById(entity);
    }

    @Override
    public boolean register(RegisterDTO registerDTO) {
        SysUser sysUser = SysUserMapping.INSTANCE.register(registerDTO);
        sysUser.setPasswordHash(passwordEncoder.encode(registerDTO.getPasswordHash()));
        int user = sysUserMapper.insert(sysUser);
        return user > 0;
    }

    @Override
    public String login(LoginDTO loginDTO) {
        SysUser sysUser = sysUserMapper.selectByUsername(loginDTO.getUsername());
        if (sysUser == null){
            throw new RuntimeException("用户不存在");
        }
        boolean matches = passwordEncoder.matches(loginDTO.getPassword(), sysUser.getPasswordHash());
        if (!matches){
            throw new RuntimeException("密码错误");
        }
        return jwtUtil.generateToken(sysUser.getId(), sysUser.getUsername());
    }
}
