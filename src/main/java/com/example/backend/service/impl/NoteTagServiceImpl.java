package com.example.backend.service.impl;

import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.entity.NoteTag;
import com.example.backend.domain.dto.create.NoteTagCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.NoteTagUpdate;
import com.example.backend.domain.vo.NoteTagVo;
import com.example.backend.mapper.NoteTagMapper;
import com.example.backend.mapping.NoteTagMapping;
import com.example.backend.service.NoteTagService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteTagServiceImpl extends ServiceImpl<NoteTagMapper, NoteTag> implements NoteTagService {

    @Autowired
    private NoteTagMapper noteTagMapper;

    @Override
    public PageInfo<NoteTagVo> queryList(PageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<NoteTag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(NoteTag::getDelFlag, ReturnConstant.DEFAULT_DEL);
        List<NoteTag> records = noteTagMapper.selectList(queryWrapper);
        return new PageInfo<>(NoteTagMapping.INSTANCE.toVoList(records));
    }

    @Override
    public boolean add(NoteTagCreate createParam) {
        NoteTag entity = NoteTagMapping.INSTANCE.fromCreate(createParam);
        return save(entity);
    }

    @Override
    public boolean updateNoteTag(NoteTagUpdate updateParam) {
        NoteTag entity = NoteTagMapping.INSTANCE.fromUpdate(updateParam);
        return updateById(entity);
    }
}
