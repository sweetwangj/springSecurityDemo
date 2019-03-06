package com.operation.qkwall.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AccessDeniedServletHandler implements AccessDeniedHandler {
    //自定义403无权访问页面
    private static final String DEF_ERROR_PAGE_PATH="/403";
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.sendRedirect(DEF_ERROR_PAGE_PATH);
    }
}
