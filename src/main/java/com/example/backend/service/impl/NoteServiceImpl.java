package com.example.backend.service.impl;

import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.entity.Note;
import com.example.backend.domain.dto.create.NoteCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.NoteUpdate;
import com.example.backend.domain.vo.NoteVo;
import com.example.backend.mapper.NoteMapper;
import com.example.backend.mapping.NoteMapping;
import com.example.backend.service.NoteService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Override
    public PageInfo<NoteVo> queryList(PageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<Note> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Note::getDelFlag, ReturnConstant.DEFAULT_DEL);
        List<Note> records = noteMapper.selectList(queryWrapper);
        return new PageInfo<>(NoteMapping.INSTANCE.toVoList(records));
    }

    @Override
    public boolean add(NoteCreate createParam) {
        Note entity = NoteMapping.INSTANCE.fromCreate(createParam);
        return save(entity);
    }

    @Override
    public boolean updateNote(NoteUpdate updateParam) {
        Note entity = NoteMapping.INSTANCE.fromUpdate(updateParam);
        return updateById(entity);
    }
}
