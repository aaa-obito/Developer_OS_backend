package com.example.backend.mapper;

import com.example.backend.domain.entity.LearningTech;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningTechMapper extends BaseMapper<LearningTech>{

}
