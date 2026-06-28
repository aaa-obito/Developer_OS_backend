package com.example.backend.controller;

import com.example.backend.domain.entity.TagEntity;
import com.example.backend.service.TagService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.pagehelper.PageInfo;
import com.example.backend.api.CommonResult;
import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.dto.create.TagCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.TagUpdate;
import com.example.backend.domain.vo.TagVo;
import com.example.backend.mapping.TagMapping;
import com.example.backend.utils.TableInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tag")
@Tag(name = "标签表模块")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
    * 分页查询列表
    */
    @GetMapping("/list")
    @Operation(summary = "查询标签表列表")
    public TableInfo queryList(@ParameterObject PageQuery query) {
    PageInfo<TagVo> pageInfo = tagService.queryList(query);
        return TableInfo.success(pageInfo.getList(), pageInfo.getTotal());
        }

    /**
    * 查询详情
    */
    @GetMapping("/{id}")
    @Operation(summary = "查询标签表详情")
    public CommonResult queryById(@PathVariable("id") Long id) {
    TagEntity tag = tagService.getById(id);
    TagVo vo = TagMapping.INSTANCE.to(tag);
    return CommonResult.success(vo);
    }

    /**
    * 新增
    */
    @PostMapping
    @Operation(summary = "添加标签表")
    public CommonResult create(@RequestBody @Validated TagCreate createParam) {
    boolean b = tagService.add(createParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 修改
    */
    @PutMapping
    @Operation(summary = "修改标签表")
    public CommonResult update(@RequestBody @Validated TagUpdate updateParam) {
    boolean b = tagService.updateTag(updateParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 批量删除 (逻辑删除)
    */
    @DeleteMapping("/{ids}")
    @Operation(summary = "批量删除标签表")
    public CommonResult delete(@PathVariable List<Long> ids) {
        LambdaUpdateWrapper<TagEntity> uw = new LambdaUpdateWrapper<>();
        uw.in(TagEntity::getId, ids)
        .set(TagEntity::getDelFlag, ReturnConstant.DELETE);
        boolean b = tagService.update(uw);
        return b ? CommonResult.success(null) : CommonResult.failed();
        }
}
