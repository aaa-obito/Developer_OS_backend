package com.example.backend.config;

import com.example.backend.domain.entity.SysUser;

/**
 * 用户上下文信息
 */
public class UserContext {

    private static final ThreadLocal<SysUser> USER_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 保存当前登录用户
     */
    public static void set(SysUser sysUser) {
        USER_THREAD_LOCAL.set(sysUser);
    }

    /**
     * 获取当前登录用户
     */
    public static SysUser get() {
        return USER_THREAD_LOCAL.get();
    }

    /**
     * 获取当前用户ID
     */
    public static Long getUserId() {
        SysUser loginUser = get();
        return loginUser == null ? null : loginUser.getId();
    }

    /**
     * 获取当前用户名
     */
    public static String getUsername() {
        SysUser loginUser = get();
        return loginUser == null ? null : loginUser.getUsername();
    }

    /**
     * 清理当前线程中的用户信息
     *
     * 这个一定要清理，否则在线程复用时可能出现用户信息污染。
     */
    public static void clear() {
        USER_THREAD_LOCAL.remove();
    }
}
