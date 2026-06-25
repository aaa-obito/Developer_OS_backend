package com.example.backend.service;

import com.example.backend.domain.entity.NoteTag;
import com.example.backend.domain.dto.create.NoteTagCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.NoteTagUpdate;
import com.example.backend.domain.vo.NoteTagVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

public interface NoteTagService extends IService<NoteTag> {

    PageInfo<NoteTagVo> queryList(PageQuery query);

    boolean add(NoteTagCreate createParam);

    boolean updateNoteTag(NoteTagUpdate updateParam);
}
