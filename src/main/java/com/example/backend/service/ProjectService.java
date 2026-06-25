package com.example.backend.service;

import com.example.backend.domain.entity.Project;
import com.example.backend.domain.dto.create.ProjectCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.ProjectUpdate;
import com.example.backend.domain.vo.ProjectVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

public interface ProjectService extends IService<Project> {

    PageInfo<ProjectVo> queryList(PageQuery query);

    boolean add(ProjectCreate createParam);

    boolean updateProject(ProjectUpdate updateParam);
}
