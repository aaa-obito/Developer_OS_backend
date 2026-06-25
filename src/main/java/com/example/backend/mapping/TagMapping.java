package com.example.backend.mapping;

import com.example.backend.domain.entity.TagEntity;
import com.example.backend.domain.dto.create.TagCreate;
import com.example.backend.domain.dto.update.TagUpdate;
import com.example.backend.domain.vo.TagVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TagMapping {
    TagMapping INSTANCE = Mappers.getMapper(TagMapping.class);

    TagVo to(TagEntity entity);

    List<TagVo> toVoList(List<TagEntity> entities);

    TagEntity fromCreate(TagCreate createParam);

    TagEntity fromUpdate(TagUpdate updateParam);
}
