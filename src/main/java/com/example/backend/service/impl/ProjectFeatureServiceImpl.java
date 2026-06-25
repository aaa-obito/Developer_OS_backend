package com.example.backend.service.impl;

import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.entity.ProjectFeature;
import com.example.backend.domain.dto.create.ProjectFeatureCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.ProjectFeatureUpdate;
import com.example.backend.domain.vo.ProjectFeatureVo;
import com.example.backend.mapper.ProjectFeatureMapper;
import com.example.backend.mapping.ProjectFeatureMapping;
import com.example.backend.service.ProjectFeatureService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectFeatureServiceImpl extends ServiceImpl<ProjectFeatureMapper, ProjectFeature> implements ProjectFeatureService {

    @Autowired
    private ProjectFeatureMapper projectFeatureMapper;

    @Override
    public PageInfo<ProjectFeatureVo> queryList(PageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<ProjectFeature> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProjectFeature::getDelFlag, ReturnConstant.DEFAULT_DEL);
        List<ProjectFeature> records = projectFeatureMapper.selectList(queryWrapper);
        return new PageInfo<>(ProjectFeatureMapping.INSTANCE.toVoList(records));
    }

    @Override
    public boolean add(ProjectFeatureCreate createParam) {
        ProjectFeature entity = ProjectFeatureMapping.INSTANCE.fromCreate(createParam);
        return save(entity);
    }

    @Override
    public boolean updateProjectFeature(ProjectFeatureUpdate updateParam) {
        ProjectFeature entity = ProjectFeatureMapping.INSTANCE.fromUpdate(updateParam);
        return updateById(entity);
    }
}
