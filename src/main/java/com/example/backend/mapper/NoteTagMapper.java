package com.example.backend.mapper;

import com.example.backend.domain.entity.NoteTag;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteTagMapper extends BaseMapper<NoteTag>{

}
