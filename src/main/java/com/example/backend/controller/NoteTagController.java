package com.example.backend.controller;

import com.example.backend.domain.entity.NoteTag;
import com.example.backend.service.NoteTagService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.pagehelper.PageInfo;
import com.example.backend.api.CommonResult;
import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.dto.create.NoteTagCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.NoteTagUpdate;
import com.example.backend.domain.vo.NoteTagVo;
import com.example.backend.mapping.NoteTagMapping;
import com.example.backend.utils.TableInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/noteTag")
@Tag(name = "笔记标签关联表模块")
public class NoteTagController {

    @Autowired
    private NoteTagService noteTagService;

    /**
    * 分页查询列表
    */
    @GetMapping("/list")
    @Operation(summary = "查询笔记标签关联表列表")
    public TableInfo queryList(@ParameterObject PageQuery query) {
    PageInfo<NoteTagVo> pageInfo = noteTagService.queryList(query);
        return TableInfo.success(pageInfo.getList(), pageInfo.getTotal());
        }

    /**
    * 查询详情
    */
    @GetMapping("/{id}")
    @Operation(summary = "查询笔记标签关联表详情")
    public CommonResult queryById(@PathVariable("id") Long id) {
    NoteTag noteTag = noteTagService.getById(id);
    NoteTagVo vo = NoteTagMapping.INSTANCE.to(noteTag);
    return CommonResult.success(vo);
    }

    /**
    * 新增
    */
    @PostMapping
    @Operation(summary = "添加笔记标签关联表")
    public CommonResult create(@RequestBody @Validated NoteTagCreate createParam) {
    boolean b = noteTagService.add(createParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 修改
    */
    @PutMapping
    @Operation(summary = "修改笔记标签关联表")
    public CommonResult update(@RequestBody @Validated NoteTagUpdate updateParam) {
    boolean b = noteTagService.updateNoteTag(updateParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 批量删除 (逻辑删除)
    */
    @DeleteMapping("/{ids}")
    @Operation(summary = "批量删除笔记标签关联表")
    public CommonResult delete(@PathVariable List<Long> ids) {
        LambdaUpdateWrapper<NoteTag> uw = new LambdaUpdateWrapper<>();
        uw.in(NoteTag::getId, ids)
        .set(NoteTag::getDelFlag, ReturnConstant.DELETE);
        boolean b = noteTagService.update(uw);
        return b ? CommonResult.success(null) : CommonResult.failed();
        }
}
