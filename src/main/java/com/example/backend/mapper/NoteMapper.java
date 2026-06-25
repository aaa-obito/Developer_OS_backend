package com.example.backend.mapper;

import com.example.backend.domain.entity.Note;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteMapper extends BaseMapper<Note>{

}
