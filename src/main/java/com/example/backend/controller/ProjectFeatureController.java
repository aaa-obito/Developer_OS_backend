package com.example.backend.controller;

import com.example.backend.domain.entity.ProjectFeature;
import com.example.backend.service.ProjectFeatureService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.pagehelper.PageInfo;
import com.example.backend.api.CommonResult;
import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.dto.create.ProjectFeatureCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.ProjectFeatureUpdate;
import com.example.backend.domain.vo.ProjectFeatureVo;
import com.example.backend.mapping.ProjectFeatureMapping;
import com.example.backend.utils.TableInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/projectFeature")
@Tag(name = "项目功能表模块")
public class ProjectFeatureController {

    @Autowired
    private ProjectFeatureService projectFeatureService;

    /**
    * 分页查询列表
    */
    @GetMapping("/list")
    @Operation(summary = "查询项目功能表列表")
    public TableInfo queryList(PageQuery query) {
    PageInfo<ProjectFeatureVo> pageInfo = projectFeatureService.queryList(query);
        return TableInfo.success(pageInfo.getList(), pageInfo.getTotal());
        }

    /**
    * 查询详情
    */
    @GetMapping("/{id}")
    @Operation(summary = "查询项目功能表详情")
    public CommonResult queryById(@PathVariable("id") Long id) {
    ProjectFeature projectFeature = projectFeatureService.getById(id);
    ProjectFeatureVo vo = ProjectFeatureMapping.INSTANCE.to(projectFeature);
    return CommonResult.success(vo);
    }

    /**
    * 新增
    */
    @PostMapping
    @Operation(summary = "添加项目功能表")
    public CommonResult create(@RequestBody @Validated ProjectFeatureCreate createParam) {
    boolean b = projectFeatureService.add(createParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 修改
    */
    @PutMapping
    @Operation(summary = "修改项目功能表")
    public CommonResult update(@RequestBody @Validated ProjectFeatureUpdate updateParam) {
    boolean b = projectFeatureService.updateProjectFeature(updateParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 批量删除 (逻辑删除)
    */
    @DeleteMapping("/{ids}")
    @Operation(summary = "批量删除项目功能表")
    public CommonResult delete(@PathVariable List<Long> ids) {
        LambdaUpdateWrapper<ProjectFeature> uw = new LambdaUpdateWrapper<>();
        uw.in(ProjectFeature::getId, ids)
        .set(ProjectFeature::getDelFlag, ReturnConstant.DELETE);
        boolean b = projectFeatureService.update(uw);
        return b ? CommonResult.success(null) : CommonResult.failed();
        }
}
