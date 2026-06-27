package com.example.backend.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.backend.config.UserContext;
import com.example.backend.constant.ReturnConstant;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FieldHandler implements MetaObjectHandler {
    /**
     * 插入时的填充策略
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        String username = "system";
        if (UserContext.getUsername() != null){
            username = UserContext.getUsername();
        }
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("createBy", username, metaObject);
        this.setFieldValByName("updateBy", username, metaObject);
        this.setFieldValByName("delFlag", ReturnConstant.DEFAULT_DEL, metaObject);
    }

    /**
     * 更新时的填充策略
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        String username = "system";
        if (UserContext.getUsername() != null){
            username = UserContext.getUsername();
        }
        this.setFieldValByName("updateBy", username, metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
