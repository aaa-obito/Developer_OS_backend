package com.example.backend.service.impl;

import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.entity.LearningTech;
import com.example.backend.domain.dto.create.LearningTechCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.LearningTechUpdate;
import com.example.backend.domain.vo.LearningTechVo;
import com.example.backend.mapper.LearningTechMapper;
import com.example.backend.mapping.LearningTechMapping;
import com.example.backend.service.LearningTechService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningTechServiceImpl extends ServiceImpl<LearningTechMapper, LearningTech> implements LearningTechService {

    @Autowired
    private LearningTechMapper learningTechMapper;

    @Override
    public PageInfo<LearningTechVo> queryList(PageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<LearningTech> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LearningTech::getDelFlag, ReturnConstant.DEFAULT_DEL);
        List<LearningTech> records = learningTechMapper.selectList(queryWrapper);
        return new PageInfo<>(LearningTechMapping.INSTANCE.toVoList(records));
    }

    @Override
    public boolean add(LearningTechCreate createParam) {
        LearningTech entity = LearningTechMapping.INSTANCE.fromCreate(createParam);
        return save(entity);
    }

    @Override
    public boolean updateLearningTech(LearningTechUpdate updateParam) {
        LearningTech entity = LearningTechMapping.INSTANCE.fromUpdate(updateParam);
        return updateById(entity);
    }
}
