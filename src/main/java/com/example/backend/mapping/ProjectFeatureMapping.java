package com.example.backend.mapping;

import com.example.backend.domain.entity.ProjectFeature;
import com.example.backend.domain.dto.create.ProjectFeatureCreate;
import com.example.backend.domain.dto.update.ProjectFeatureUpdate;
import com.example.backend.domain.vo.ProjectFeatureVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProjectFeatureMapping {
    ProjectFeatureMapping INSTANCE = Mappers.getMapper(ProjectFeatureMapping.class);

    ProjectFeatureVo to(ProjectFeature entity);

    List<ProjectFeatureVo> toVoList(List<ProjectFeature> entities);

    ProjectFeature fromCreate(ProjectFeatureCreate createParam);

    ProjectFeature fromUpdate(ProjectFeatureUpdate updateParam);
}
