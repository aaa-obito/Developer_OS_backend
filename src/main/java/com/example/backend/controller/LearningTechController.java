package com.example.backend.controller;

import com.example.backend.domain.entity.LearningTech;
import com.example.backend.exception.BusinessException;
import com.example.backend.service.LearningTechService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.pagehelper.PageInfo;
import com.example.backend.api.CommonResult;
import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.dto.create.LearningTechCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.LearningTechUpdate;
import com.example.backend.domain.vo.LearningTechVo;
import com.example.backend.mapping.LearningTechMapping;
import com.example.backend.utils.TableInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/learningTech")
@Tag(name = "学习技术表模块")
public class LearningTechController {

    @Autowired
    private LearningTechService learningTechService;

    /**
    * 分页查询列表
    */
    @GetMapping("/list")
    @Operation(summary = "查询学习技术表列表")
    public TableInfo queryList(@ParameterObject PageQuery query) {
    PageInfo<LearningTechVo> pageInfo = learningTechService.queryList(query);
        return TableInfo.success(pageInfo.getList(), pageInfo.getTotal());
        }

    /**
    * 查询详情
    */
    @GetMapping("/{id}")
    @Operation(summary = "查询学习技术表详情")
    public CommonResult queryById(@PathVariable Long id) {
    LearningTech learningTech = learningTechService.getById(id);
    if (learningTech == null){
        throw new BusinessException("学习笔记不存在");
    }
    LearningTechVo vo = LearningTechMapping.INSTANCE.to(learningTech);
    return CommonResult.success(vo);
    }

    /**
    * 新增
    */
    @PostMapping
    @Operation(summary = "添加学习技术表")
    public CommonResult create(@RequestBody @Validated LearningTechCreate createParam) {
    boolean b = learningTechService.add(createParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 修改
    */
    @PutMapping
    @Operation(summary = "修改学习技术表")
    public CommonResult update(@RequestBody @Validated LearningTechUpdate updateParam) {
    boolean b = learningTechService.updateLearningTech(updateParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 批量删除 (逻辑删除)
    */
    @DeleteMapping("/{ids}")
    @Operation(summary = "批量删除学习技术表")
    public CommonResult delete(@PathVariable List<Long> ids) {
        LambdaUpdateWrapper<LearningTech> uw = new LambdaUpdateWrapper<>();
        uw.in(LearningTech::getId, ids)
        .set(LearningTech::getDelFlag, ReturnConstant.DELETE);
        boolean b = learningTechService.update(uw);
        return b ? CommonResult.success(null) : CommonResult.failed();
        }
}
