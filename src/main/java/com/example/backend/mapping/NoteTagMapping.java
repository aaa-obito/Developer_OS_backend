package com.example.backend.mapping;

import com.example.backend.domain.entity.NoteTag;
import com.example.backend.domain.dto.create.NoteTagCreate;
import com.example.backend.domain.dto.update.NoteTagUpdate;
import com.example.backend.domain.vo.NoteTagVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NoteTagMapping {
    NoteTagMapping INSTANCE = Mappers.getMapper(NoteTagMapping.class);

    NoteTagVo to(NoteTag entity);

    List<NoteTagVo> toVoList(List<NoteTag> entities);

    NoteTag fromCreate(NoteTagCreate createParam);

    NoteTag fromUpdate(NoteTagUpdate updateParam);
}
