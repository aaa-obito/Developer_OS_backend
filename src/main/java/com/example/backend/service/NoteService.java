package com.example.backend.service;

import com.example.backend.domain.entity.Note;
import com.example.backend.domain.dto.create.NoteCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.NoteUpdate;
import com.example.backend.domain.vo.NoteVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

public interface NoteService extends IService<Note> {

    PageInfo<NoteVo> queryList(PageQuery query);

    boolean add(NoteCreate createParam);

    boolean updateNote(NoteUpdate updateParam);
}
