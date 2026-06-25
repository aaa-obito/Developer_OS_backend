package com.example.backend.controller;

import com.example.backend.domain.entity.SysUser;
import com.example.backend.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.pagehelper.PageInfo;
import com.example.backend.api.CommonResult;
import com.example.backend.constant.ReturnConstant;
import com.example.backend.domain.dto.create.SysUserCreate;
import com.example.backend.domain.dto.query.PageQuery;
import com.example.backend.domain.dto.update.SysUserUpdate;
import com.example.backend.domain.vo.SysUserVo;
import com.example.backend.mapping.SysUserMapping;
import com.example.backend.utils.TableInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sysUser")
@Tag(name = "用户表模块")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
    * 分页查询列表
    */
    @GetMapping("/list")
    @Operation(summary = "查询用户表列表")
    public TableInfo queryList(PageQuery query) {
    PageInfo<SysUserVo> pageInfo = sysUserService.queryList(query);
        return TableInfo.success(pageInfo.getList(), pageInfo.getTotal());
        }

    /**
    * 查询详情
    */
    @GetMapping("/{id}")
    @Operation(summary = "查询用户表详情")
    public CommonResult queryById(@PathVariable("id") Long id) {
    SysUser sysUser = sysUserService.getById(id);
    SysUserVo vo = SysUserMapping.INSTANCE.to(sysUser);
    return CommonResult.success(vo);
    }

    /**
    * 新增
    */
    @PostMapping
    @Operation(summary = "添加用户表")
    public CommonResult create(@RequestBody @Validated SysUserCreate createParam) {
    boolean b = sysUserService.add(createParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 修改
    */
    @PutMapping
    @Operation(summary = "修改用户表")
    public CommonResult update(@RequestBody @Validated SysUserUpdate updateParam) {
    boolean b = sysUserService.updateSysUser(updateParam);
    return b ? CommonResult.success(null) : CommonResult.failed();
    }

    /**
    * 批量删除 (逻辑删除)
    */
    @DeleteMapping("/{ids}")
    @Operation(summary = "批量删除用户表")
    public CommonResult delete(@PathVariable List<Long> ids) {
        LambdaUpdateWrapper<SysUser> uw = new LambdaUpdateWrapper<>();
        uw.in(SysUser::getId, ids)
        .set(SysUser::getDelFlag, ReturnConstant.DELETE);
        boolean b = sysUserService.update(uw);
        return b ? CommonResult.success(null) : CommonResult.failed();
        }
}
