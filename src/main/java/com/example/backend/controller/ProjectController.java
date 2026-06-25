package com.example.backend.controller;

import com.example.backend.domain.entity.Project;
import com.example.backend.service.ProjectService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.pagehelper.PageInfo;
import com.example.backend.api.CommonResult;
import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.dto.create.ProjectCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.ProjectUpdate;
import com.example.backend.domain.vo.ProjectVo;
import com.example.backend.mapping.ProjectMapping;
import com.example.backend.utils.TableInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/project")
@Tag(name = "项目表模块")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
    * 分页查询列表
    */
    @GetMapping("/list")
    @Operation(summary = "查询项目表列表")
    public TableInfo queryList(PageQuery query) {
    PageInfo<ProjectVo> pageInfo = projectService.queryList(query);
        return TableInfo.success(pageInfo.getList(), pageInfo.getTotal());
        }

    /**
    * 查询详情
    */
    @GetMapping("/{id}")
    @Operation(summary = "查询项目表详情")
    public CommonResult queryById(@PathVariable("id") Long id) {
    Project project = projectService.getById(id);
    ProjectVo vo = ProjectMapping.INSTANCE.to(project);
    return CommonResult.success(vo);
    }

    /**
    * 新增
    */
    @PostMapping
    @Operation(summary = "添加项目表")
    public CommonResult create(@RequestBody @Validated ProjectCreate createParam) {
    boolean b = projectService.add(createParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 修改
    */
    @PutMapping
    @Operation(summary = "修改项目表")
    public CommonResult update(@RequestBody @Validated ProjectUpdate updateParam) {
    boolean b = projectService.updateProject(updateParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 批量删除 (逻辑删除)
    */
    @DeleteMapping("/{ids}")
    @Operation(summary = "批量删除项目表")
    public CommonResult delete(@PathVariable List<Long> ids) {
        LambdaUpdateWrapper<Project> uw = new LambdaUpdateWrapper<>();
        uw.in(Project::getId, ids)
        .set(Project::getDelFlag, ReturnConstant.DELETE);
        boolean b = projectService.update(uw);
        return b ? CommonResult.success(null) : CommonResult.failed();
        }
}
