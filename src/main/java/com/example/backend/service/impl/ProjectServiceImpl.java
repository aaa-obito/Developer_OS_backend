package com.example.backend.service.impl;

import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.entity.Project;
import com.example.backend.domain.dto.create.ProjectCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.ProjectUpdate;
import com.example.backend.domain.vo.ProjectVo;
import com.example.backend.mapper.ProjectMapper;
import com.example.backend.mapping.ProjectMapping;
import com.example.backend.service.ProjectService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public PageInfo<ProjectVo> queryList(PageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<Project> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Project::getDelFlag, ReturnConstant.DEFAULT_DEL);
        List<Project> records = projectMapper.selectList(queryWrapper);
        return new PageInfo<>(ProjectMapping.INSTANCE.toVoList(records));
    }

    @Override
    public boolean add(ProjectCreate createParam) {
        Project entity = ProjectMapping.INSTANCE.fromCreate(createParam);
        return save(entity);
    }

    @Override
    public boolean updateProject(ProjectUpdate updateParam) {
        Project entity = ProjectMapping.INSTANCE.fromUpdate(updateParam);
        return updateById(entity);
    }
}
