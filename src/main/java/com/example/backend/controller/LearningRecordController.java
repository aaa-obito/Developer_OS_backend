package com.example.backend.controller;

import com.example.backend.domain.entity.LearningRecord;
import com.example.backend.exception.BusinessException;
import com.example.backend.service.LearningRecordService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.pagehelper.PageInfo;
import com.example.backend.api.CommonResult;
import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.dto.create.LearningRecordCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.LearningRecordUpdate;
import com.example.backend.domain.vo.LearningRecordVo;
import com.example.backend.mapping.LearningRecordMapping;
import com.example.backend.utils.TableInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/learningRecord")
@Tag(name = "学习记录表模块")
public class LearningRecordController {

    @Autowired
    private LearningRecordService learningRecordService;

    /**
    * 分页查询列表
    */
    @GetMapping("/list")
    @Operation(summary = "查询学习记录表列表")
    public TableInfo queryList(@ParameterObject PageQuery query) {
    PageInfo<LearningRecordVo> pageInfo = learningRecordService.queryList(query);
        return TableInfo.success(pageInfo.getList(), pageInfo.getTotal());
        }

    /**
    * 查询详情
    */
    @GetMapping("/{id}")
    @Operation(summary = "查询学习记录表详情")
    public CommonResult queryById(@PathVariable Long id) {
    LearningRecord learningRecord = learningRecordService.getById(id);
        if (learningRecord == null){
            throw new BusinessException("学习记录不存在");
        }
    LearningRecordVo vo = LearningRecordMapping.INSTANCE.to(learningRecord);
    return CommonResult.success(vo);
    }

    /**
    * 新增
    */
    @PostMapping
    @Operation(summary = "添加学习记录表")
    public CommonResult create(@RequestBody @Validated LearningRecordCreate createParam) {
    boolean b = learningRecordService.add(createParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 修改
    */
    @PutMapping
    @Operation(summary = "修改学习记录表")
    public CommonResult update(@RequestBody @Validated LearningRecordUpdate updateParam) {
    boolean b = learningRecordService.updateLearningRecord(updateParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 批量删除 (逻辑删除)
    */
    @DeleteMapping("/{ids}")
    @Operation(summary = "批量删除学习记录表")
    public CommonResult delete(@PathVariable List<Long> ids) {
        LambdaUpdateWrapper<LearningRecord> uw = new LambdaUpdateWrapper<>();
        uw.in(LearningRecord::getId, ids)
        .set(LearningRecord::getDelFlag, ReturnConstant.DELETE);
        boolean b = learningRecordService.update(uw);
        return b ? CommonResult.success(null) : CommonResult.failed();
        }
}
