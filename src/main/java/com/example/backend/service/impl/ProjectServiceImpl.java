package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.backend.config.UserContext;
import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.dto.other.ProjectStatusDTO;
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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

    private final ProjectMapper projectMapper;

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
        Project project = ProjectMapping.INSTANCE.fromCreate(createParam);
        project.setUserId(UserContext.getUserId());
        return save(project);
    }

    @Override
    public boolean updateProject(ProjectUpdate updateParam) {
        Project entity = ProjectMapping.INSTANCE.fromUpdate(updateParam);
        return updateById(entity);
    }

    @Override
    public boolean updateStatus(ProjectStatusDTO projectStatusDTO) {
        LambdaUpdateWrapper<Project> uw = new LambdaUpdateWrapper<>();
        uw.eq(Project::getId,projectStatusDTO.getId())
                .set(Project::getStatus,projectStatusDTO.getStatus());
        return projectMapper.update(uw) > 0;
    }
}
