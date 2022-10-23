package com.zrxxjd.springboot.filter;

import com.zrxxjd.springboot.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * 拦截需要权限的请求,根据Token判断是否有权访问
 */
@Component
public class RequestInterceptor implements HandlerInterceptor {
    // 无需鉴权的URI(仅需要header中的User)
    private final String[] ignoredUri = {
            "/admin/valid"
    };

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(JwtUtils.HEADER);
        // 1. 获取Token判断是否有效
        String uri = request.getRequestURI();
        long count = Arrays.stream(ignoredUri).filter(e -> e.equals(uri)).count();
        return count != 0 || !JwtUtils.validateToken(token);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
