package com.example.backend.service.impl;

import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.entity.ProjectIssue;
import com.example.backend.domain.dto.create.ProjectIssueCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.ProjectIssueUpdate;
import com.example.backend.domain.vo.ProjectIssueVo;
import com.example.backend.mapper.ProjectIssueMapper;
import com.example.backend.mapping.ProjectIssueMapping;
import com.example.backend.service.ProjectIssueService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectIssueServiceImpl extends ServiceImpl<ProjectIssueMapper, ProjectIssue> implements ProjectIssueService {

    @Autowired
    private ProjectIssueMapper projectIssueMapper;

    @Override
    public PageInfo<ProjectIssueVo> queryList(PageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<ProjectIssue> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProjectIssue::getDelFlag, ReturnConstant.DEFAULT_DEL);
        List<ProjectIssue> records = projectIssueMapper.selectList(queryWrapper);
        return new PageInfo<>(ProjectIssueMapping.INSTANCE.toVoList(records));
    }

    @Override
    public boolean add(ProjectIssueCreate createParam) {
        ProjectIssue entity = ProjectIssueMapping.INSTANCE.fromCreate(createParam);
        return save(entity);
    }

    @Override
    public boolean updateProjectIssue(ProjectIssueUpdate updateParam) {
        ProjectIssue entity = ProjectIssueMapping.INSTANCE.fromUpdate(updateParam);
        return updateById(entity);
    }
}
