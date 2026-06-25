package com.example.backend.mapping;

import com.example.backend.domain.entity.LearningTech;
import com.example.backend.domain.dto.create.LearningTechCreate;
import com.example.backend.domain.dto.update.LearningTechUpdate;
import com.example.backend.domain.vo.LearningTechVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LearningTechMapping {
    LearningTechMapping INSTANCE = Mappers.getMapper(LearningTechMapping.class);

    LearningTechVo to(LearningTech entity);

    List<LearningTechVo> toVoList(List<LearningTech> entities);

    LearningTech fromCreate(LearningTechCreate createParam);

    LearningTech fromUpdate(LearningTechUpdate updateParam);
}
