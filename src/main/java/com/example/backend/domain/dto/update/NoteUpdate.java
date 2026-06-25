package com.example.backend.domain.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "修改技术笔记表参数")
public class NoteUpdate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "笔记ID")
    private Long id;

    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "笔记标题")
    private String title;

    @Schema(description = "笔记内容，支持Markdown")
    private String content;

    @Schema(description = "笔记摘要")
    private String summary;

    @Schema(description = "笔记分类")
    private String category;
}
