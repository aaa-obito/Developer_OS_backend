package com.example.backend.mapping;

import com.example.backend.domain.entity.Project;
import com.example.backend.domain.dto.create.ProjectCreate;
import com.example.backend.domain.dto.update.ProjectUpdate;
import com.example.backend.domain.vo.ProjectVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProjectMapping {
    ProjectMapping INSTANCE = Mappers.getMapper(ProjectMapping.class);

    ProjectVo to(Project entity);

    List<ProjectVo> toVoList(List<Project> entities);

    Project fromCreate(ProjectCreate createParam);

    Project fromUpdate(ProjectUpdate updateParam);
}
