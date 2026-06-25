package com.example.backend.domain.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "新增笔记标签关联表参数")
public class NoteTagCreate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "笔记ID")
    private Long noteId;

    @Schema(description = "标签ID")
    private Long tagId;
}
