package com.zrxxjd.springboot.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {

    public static final long EXPIRES = 3 * 24 * 60 * 60 * 1000;
    public static final String HEADER = "Authorization";
    private static final String SECRET = "21HRVGPIBJED3XN6WTUOYFZK5LS8C907";

    /**
     * 根据用户信息生成Token
     *
     * @param username 用户名
     * @return Token
     */
    public static String generateToken(String username) {
        return Jwts.builder()
                // header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // payload
                .claim("user", username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRES))
                // signature
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }


    /**
     * 验证Token是否有效
     *
     * @param token token
     * @return 是否有效
     */
    public static boolean validateToken(String token) {
        if (StringUtils.isInvalid(token)) return false;
        Claims claims = getClaimsFromToken(token);
        return claims != null && claims.getExpiration().after(new Date());
    }

    /**
     * 根据Token获取用户名
     *
     * @param token token
     * @return 用户名
     */
    public static String getUsernameFromToken(String token) {
        if (StringUtils.isInvalid(token)) return null;
        Claims claims = getClaimsFromToken(token);
        if (claims == null) return null;
        return claims.get("user", String.class);
    }

    /**
     * 从Token中获取荷载
     *
     * @param token token
     * @return 荷载
     */
    private static Claims getClaimsFromToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }
}
