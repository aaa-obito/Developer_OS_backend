package com.example.backend.domain.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "新增技术笔记表参数")
public class NoteCreate implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "笔记标题不能为空")
    @Schema(description = "笔记标题")
    private String title;

    @Schema(description = "笔记内容，支持Markdown")
    private String content;

    @Schema(description = "笔记摘要")
    private String summary;

    @Schema(description = "笔记分类")
    private String category;
}
