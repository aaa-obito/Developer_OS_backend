package com.example.backend.service;

import com.example.backend.domain.entity.LearningTech;
import com.example.backend.domain.dto.create.LearningTechCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.LearningTechUpdate;
import com.example.backend.domain.vo.LearningTechVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

public interface LearningTechService extends IService<LearningTech> {

    PageInfo<LearningTechVo> queryList(PageQuery query);

    boolean add(LearningTechCreate createParam);

    boolean updateLearningTech(LearningTechUpdate updateParam);
}
