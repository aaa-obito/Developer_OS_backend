package com.example.backend.service;

import com.example.backend.domain.entity.ProjectFeature;
import com.example.backend.domain.dto.create.ProjectFeatureCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.ProjectFeatureUpdate;
import com.example.backend.domain.vo.ProjectFeatureVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

public interface ProjectFeatureService extends IService<ProjectFeature> {

    PageInfo<ProjectFeatureVo> queryList(PageQuery query);

    boolean add(ProjectFeatureCreate createParam);

    boolean updateProjectFeature(ProjectFeatureUpdate updateParam);
}
