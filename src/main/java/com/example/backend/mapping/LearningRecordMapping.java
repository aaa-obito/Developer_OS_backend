package com.example.backend.mapping;

import com.example.backend.domain.entity.LearningRecord;
import com.example.backend.domain.dto.create.LearningRecordCreate;
import com.example.backend.domain.dto.update.LearningRecordUpdate;
import com.example.backend.domain.vo.LearningRecordVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LearningRecordMapping {
    LearningRecordMapping INSTANCE = Mappers.getMapper(LearningRecordMapping.class);

    LearningRecordVo to(LearningRecord entity);

    List<LearningRecordVo> toVoList(List<LearningRecord> entities);

    LearningRecord fromCreate(LearningRecordCreate createParam);

    LearningRecord fromUpdate(LearningRecordUpdate updateParam);
}
