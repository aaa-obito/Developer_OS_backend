package com.example.backend.interceptor;

import com.example.backend.config.UserContext;
import com.example.backend.domain.entity.SysUser;
import com.example.backend.exception.BusinessException;
import com.example.backend.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * JWT 登录拦截器
 *
 * 作用：
 * 1. 拦截请求
 * 2. 从请求头中获取 token
 * 3. 校验 token 是否合法
 * 4. 解析出当前登录用户
 * 5. 把用户信息保存到 UserContext
 */
@Component
@RequiredArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    private final RedisTemplate<Object,Object> redisTemplate;

    /**
     * Controller 方法执行之前会先执行这个方法
     *
     * 返回 true：放行，请求继续进入 Controller
     * 返回 false：拦截，请求到此结束
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        // 1. 从请求头中获取 Authorization
        String auth = request.getHeader("Authorization");

        // 2. 判断请求头是否为空
        if (auth == null || auth.isBlank()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // 3. 判断是否以 Bearer 开头
        if (!auth.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // 4. 去掉前面的 "Bearer "，只保留真正的 token
        String token = auth.substring(7);

        try {
            // 5. 解析 token
            // 如果 token 过期、被篡改、格式错误，这里会直接抛异常
            Claims claims = jwtUtil.parseToken(token);

            // 6. 从 subject 中获取用户ID
            Long userId = Long.valueOf(claims.getSubject());

            // 7. 从自定义字段中获取用户名
            String username = claims.get("username", String.class);

            // 8.验证redis
            String redisKey = "login:user:" + userId;
            String redisToken = (String) redisTemplate.opsForValue().get(redisKey);
            if (redisToken == null || !redisToken.equals(token)){
                throw new BusinessException(401, "请先登录");
            }

            // 9. 封装当前登录用户信息
            SysUser loginUser = SysUser.builder()
                    .id(userId)
                    .username(username)
                    .build();

            // 10. 保存到 UserContext
            // 后面的 Controller、Service 就可以直接通过 UserContext 获取当前用户
            UserContext.set(loginUser);
            return true;

        } catch (Exception e) {
            // token 无效、过期、解析失败，都返回 401
            throw new BusinessException(401, "请先登录");
        }
    }

    /**
     * 整个请求结束之后执行
     *
     * 这里必须清理 ThreadLocal，防止线程复用导致用户信息串号。
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        UserContext.clear();
    }
}