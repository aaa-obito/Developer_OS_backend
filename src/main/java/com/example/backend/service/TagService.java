package com.example.backend.service;

import com.example.backend.domain.entity.TagEntity;
import com.example.backend.domain.dto.create.TagCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.TagUpdate;
import com.example.backend.domain.vo.TagVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

public interface TagService extends IService<TagEntity> {

    PageInfo<TagVo> queryList(PageQuery query);

    boolean add(TagCreate createParam);

    boolean updateTag(TagUpdate updateParam);
}
