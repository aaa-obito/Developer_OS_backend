package com.example.backend.domain.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "修改技术笔记表参数")
public class NoteUpdate implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "学习记录ID不能为空")
    @Min(value = 1,message = "学习记录ID至少为1")
    @Schema(description = "笔记ID")
    private Long id;

    @Schema(description = "笔记标题")
    private String title;

    @Schema(description = "笔记内容，支持Markdown")
    private String content;

    @Schema(description = "笔记摘要")
    private String summary;

    @Schema(description = "笔记分类")
    private String category;
}
