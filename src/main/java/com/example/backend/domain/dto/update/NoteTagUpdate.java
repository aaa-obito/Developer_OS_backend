package com.example.backend.domain.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "修改笔记标签关联表参数")
public class NoteTagUpdate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "关联ID")
    private Long id;

    @Schema(description = "笔记ID")
    private Long noteId;

    @Schema(description = "标签ID")
    private Long tagId;
}
