package com.example.backend.mapping;

import com.example.backend.domain.entity.ProjectIssue;
import com.example.backend.domain.dto.create.ProjectIssueCreate;
import com.example.backend.domain.dto.update.ProjectIssueUpdate;
import com.example.backend.domain.vo.ProjectIssueVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProjectIssueMapping {
    ProjectIssueMapping INSTANCE = Mappers.getMapper(ProjectIssueMapping.class);

    ProjectIssueVo to(ProjectIssue entity);

    List<ProjectIssueVo> toVoList(List<ProjectIssue> entities);

    ProjectIssue fromCreate(ProjectIssueCreate createParam);

    ProjectIssue fromUpdate(ProjectIssueUpdate updateParam);
}
