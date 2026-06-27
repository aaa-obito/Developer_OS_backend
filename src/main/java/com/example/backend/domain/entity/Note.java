package com.example.backend.domain.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
* note : 技术笔记表
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "技术笔记表")
public class Note extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

        @TableId(type = IdType.AUTO)
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
