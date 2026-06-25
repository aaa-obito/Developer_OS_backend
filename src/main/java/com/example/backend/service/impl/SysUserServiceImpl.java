package com.example.backend.service.impl;

import com.example.backend.constant.ReturnConstant;
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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

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
}
