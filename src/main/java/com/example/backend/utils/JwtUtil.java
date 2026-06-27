package com.example.backend.utils;

import com.example.backend.config.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final JwtProperties jwtProperties;

    private SecretKey key;

    /**
     * Spring 创建对象后会自动执行这个方法
     * 根据配置文件中的密钥生成 SecretKey
     * jwt初始化
     */
    @PostConstruct
    public void init() {
        key = Keys.hmacShaKeyFor(
                jwtProperties.getSecret().getBytes(StandardCharsets.UTF_8)
        );
    }

    /**
     * 生成 JWT
     *
     * @param userId   用户ID
     * @param username 用户名
     * @return JWT字符串
     */
    public String generateToken(Long userId, String username) {

        // 当前时间
        Date now = new Date();

        // Token 过期时间
        Date expireDate = new Date(now.getTime() + jwtProperties.getExpire());

        // 创建 JWT
        return Jwts.builder()

                // 设置主题（一般放用户ID）
                .subject(String.valueOf(userId))

                // 自定义字段（可以放用户名、角色等）
                .claim("username", username)

                // Token 签发时间
                .issuedAt(now)

                // Token 过期时间
                .expiration(expireDate)

                // 使用密钥进行签名
                .signWith(key)

                // 生成最终字符串
                .compact();
    }

    /**
     * 解析 Token
     *
     * @param token JWT字符串
     * @return Token 中保存的数据
     */
    public Claims parseToken(String token) {

        return Jwts.parser()

                // 指定验证签名使用的密钥
                .verifyWith(key)

                // 创建解析器
                .build()

                // 解析 JWT
                .parseSignedClaims(token)

                // 获取载荷(Payload)
                .getPayload();
    }

    /**
     * 获取用户ID

     */
    public Long getUserId(String token) {
        return Long.valueOf(parseToken(token).getSubject());
    }

    /**
     * 获取用户名

     */
    public String getUsername(String token) {
        return parseToken(token).get("username", String.class);
    }

    /**
     * 判断 Token 是否过期
     */
    public boolean isExpired(String token) {

        // 获取过期时间
        Date expiration = parseToken(token).getExpiration();

        // 如果过期时间早于当前时间，则说明 Token 已失效
        return expiration.before(new Date());
    }

}


