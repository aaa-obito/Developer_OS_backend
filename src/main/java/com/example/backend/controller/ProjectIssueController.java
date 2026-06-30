package com.example.backend.controller;

import com.example.backend.domain.entity.ProjectIssue;
import com.example.backend.exception.BusinessException;
import com.example.backend.service.ProjectIssueService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.pagehelper.PageInfo;
import com.example.backend.api.CommonResult;
import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.dto.create.ProjectIssueCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.ProjectIssueUpdate;
import com.example.backend.domain.vo.ProjectIssueVo;
import com.example.backend.mapping.ProjectIssueMapping;
import com.example.backend.utils.TableInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/projectIssue")
@Tag(name = "项目问题记录表模块")
public class ProjectIssueController {

    @Autowired
    private ProjectIssueService projectIssueService;

    /**
    * 分页查询列表
    */
    @GetMapping("/list")
    @Operation(summary = "查询项目问题记录表列表")
    public TableInfo queryList(@ParameterObject PageQuery query) {
    PageInfo<ProjectIssueVo> pageInfo = projectIssueService.queryList(query);
        return TableInfo.success(pageInfo.getList(), pageInfo.getTotal());
        }

    /**
    * 查询详情
    */
    @GetMapping("/{id}")
    @Operation(summary = "查询项目问题记录表详情")
    public CommonResult queryById(@PathVariable Long id) {
    ProjectIssue projectIssue = projectIssueService.getById(id);
    if(projectIssue == null){
        throw new BusinessException("项目问题记录表为空");
    }
    ProjectIssueVo vo = ProjectIssueMapping.INSTANCE.to(projectIssue);
    return CommonResult.success(vo);
    }

    /**
    * 新增
    */
    @PostMapping
    @Operation(summary = "添加项目问题记录表")
    public CommonResult create(@RequestBody @Validated ProjectIssueCreate createParam) {
    boolean b = projectIssueService.add(createParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 修改
    */
    @PutMapping
    @Operation(summary = "修改项目问题记录表")
    public CommonResult update(@RequestBody @Validated ProjectIssueUpdate updateParam) {
    boolean b = projectIssueService.updateProjectIssue(updateParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 批量删除 (逻辑删除)
    */
    @DeleteMapping("/{ids}")
    @Operation(summary = "批量删除项目问题记录表")
    public CommonResult delete(@PathVariable List<Long> ids) {
        LambdaUpdateWrapper<ProjectIssue> uw = new LambdaUpdateWrapper<>();
        uw.in(ProjectIssue::getId, ids)
        .set(ProjectIssue::getDelFlag, ReturnConstant.DELETE);
        boolean b = projectIssueService.update(uw);
        return b ? CommonResult.success(null) : CommonResult.failed();
        }
}
