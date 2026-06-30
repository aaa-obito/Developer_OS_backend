package com.example.backend.controller;

import com.example.backend.domain.entity.Note;
import com.example.backend.exception.BusinessException;
import com.example.backend.service.NoteService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.pagehelper.PageInfo;
import com.example.backend.api.CommonResult;
import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.dto.create.NoteCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.NoteUpdate;
import com.example.backend.domain.vo.NoteVo;
import com.example.backend.mapping.NoteMapping;
import com.example.backend.utils.TableInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/note")
@Tag(name = "技术笔记表模块")
public class NoteController {

    @Autowired
    private NoteService noteService;

    /**
    * 分页查询列表
    */
    @GetMapping("/list")
    @Operation(summary = "查询技术笔记表列表")
    public TableInfo queryList(@ParameterObject PageQuery query) {
    PageInfo<NoteVo> pageInfo = noteService.queryList(query);
        return TableInfo.success(pageInfo.getList(), pageInfo.getTotal());
        }

    /**
    * 查询详情
    */
    @GetMapping("/{id}")
    @Operation(summary = "查询技术笔记表详情")
    public CommonResult queryById(@PathVariable Long id) {
    Note note = noteService.getById(id);
    if (note == null){
        throw new BusinessException("技术笔记为空");
    }
    NoteVo vo = NoteMapping.INSTANCE.to(note);
    return CommonResult.success(vo);
    }

    /**
    * 新增
    */
    @PostMapping
    @Operation(summary = "添加技术笔记表")
    public CommonResult create(@RequestBody @Validated NoteCreate createParam) {
    boolean b = noteService.add(createParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 修改
    */
    @PutMapping
    @Operation(summary = "修改技术笔记表")
    public CommonResult update(@RequestBody @Validated NoteUpdate updateParam) {
    boolean b = noteService.updateNote(updateParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 批量删除 (逻辑删除)
    */
    @DeleteMapping("/{ids}")
    @Operation(summary = "批量删除技术笔记表")
    public CommonResult delete(@PathVariable List<Long> ids) {
        LambdaUpdateWrapper<Note> uw = new LambdaUpdateWrapper<>();
        uw.in(Note::getId, ids)
        .set(Note::getDelFlag, ReturnConstant.DELETE);
        boolean b = noteService.update(uw);
        return b ? CommonResult.success(null) : CommonResult.failed();
        }
}
