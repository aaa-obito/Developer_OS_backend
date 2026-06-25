package com.example.backend.mapping;

import com.example.backend.domain.entity.Note;
import com.example.backend.domain.dto.create.NoteCreate;
import com.example.backend.domain.dto.update.NoteUpdate;
import com.example.backend.domain.vo.NoteVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NoteMapping {
    NoteMapping INSTANCE = Mappers.getMapper(NoteMapping.class);

    NoteVo to(Note entity);

    List<NoteVo> toVoList(List<Note> entities);

    Note fromCreate(NoteCreate createParam);

    Note fromUpdate(NoteUpdate updateParam);
}
