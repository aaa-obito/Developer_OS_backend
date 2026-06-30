package com.example.backend.service.impl;

import com.example.backend.config.UserContext;
import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.entity.LearningRecord;
import com.example.backend.domain.dto.create.LearningRecordCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.LearningRecordUpdate;
import com.example.backend.domain.vo.LearningRecordVo;
import com.example.backend.mapper.LearningRecordMapper;
import com.example.backend.mapping.LearningRecordMapping;
import com.example.backend.service.LearningRecordService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningRecordServiceImpl extends ServiceImpl<LearningRecordMapper, LearningRecord> implements LearningRecordService {

    @Autowired
    private LearningRecordMapper learningRecordMapper;

    @Override
    public PageInfo<LearningRecordVo> queryList(PageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<LearningRecord> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LearningRecord::getDelFlag, ReturnConstant.DEFAULT_DEL);
        List<LearningRecord> records = learningRecordMapper.selectList(queryWrapper);
        return new PageInfo<>(LearningRecordMapping.INSTANCE.toVoList(records));
    }

    @Override
    public boolean add(LearningRecordCreate createParam) {
        LearningRecord entity = LearningRecordMapping.INSTANCE.fromCreate(createParam);
        entity.setUserId(UserContext.getUserId());
        return save(entity);
    }

    @Override
    public boolean updateLearningRecord(LearningRecordUpdate updateParam) {
        LearningRecord entity = LearningRecordMapping.INSTANCE.fromUpdate(updateParam);
        entity.setUserId(UserContext.getUserId());
        return updateById(entity);
    }
}
