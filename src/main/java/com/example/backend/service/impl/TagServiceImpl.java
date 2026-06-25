package com.example.backend.service.impl;

import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.entity.TagEntity;
import com.example.backend.domain.dto.create.TagCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.TagUpdate;
import com.example.backend.domain.vo.TagVo;
import com.example.backend.mapper.TagMapper;
import com.example.backend.mapping.TagMapping;
import com.example.backend.service.TagService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, TagEntity> implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public PageInfo<TagVo> queryList(PageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<TagEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TagEntity::getDelFlag, ReturnConstant.DEFAULT_DEL);
        List<TagEntity> records = tagMapper.selectList(queryWrapper);
        return new PageInfo<>(TagMapping.INSTANCE.toVoList(records));
    }

    @Override
    public boolean add(TagCreate createParam) {
        TagEntity entity = TagMapping.INSTANCE.fromCreate(createParam);
        return save(entity);
    }

    @Override
    public boolean updateTag(TagUpdate updateParam) {
        TagEntity entity = TagMapping.INSTANCE.fromUpdate(updateParam);
        return updateById(entity);
    }
}
