package com.example.backend.service;

import com.example.backend.domain.entity.ProjectIssue;
import com.example.backend.domain.dto.create.ProjectIssueCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.ProjectIssueUpdate;
import com.example.backend.domain.vo.ProjectIssueVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

public interface ProjectIssueService extends IService<ProjectIssue> {

    PageInfo<ProjectIssueVo> queryList(PageQuery query);

    boolean add(ProjectIssueCreate createParam);

    boolean updateProjectIssue(ProjectIssueUpdate updateParam);
}
