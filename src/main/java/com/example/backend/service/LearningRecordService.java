package com.example.backend.service;

import com.example.backend.domain.entity.LearningRecord;
import com.example.backend.domain.dto.create.LearningRecordCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.LearningRecordUpdate;
import com.example.backend.domain.vo.LearningRecordVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

public interface LearningRecordService extends IService<LearningRecord> {

    PageInfo<LearningRecordVo> queryList(PageQuery query);

    boolean add(LearningRecordCreate createParam);

    boolean updateLearningRecord(LearningRecordUpdate updateParam);
}
