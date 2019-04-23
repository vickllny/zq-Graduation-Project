package com.zq.vm.filter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 登录拦截器
 */
public class LoginFilter implements Filter {

    private static final List<String> exts = Arrays.asList(new String[]{"/login", ".js", ".css", ".ico", ".jpg", ".png", ".gif"});

    public static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        if(checkUrl(uri)){
            filterChain.doFilter(request, response);
            return;
        }
        Object userId = request.getSession().getAttribute("userId");
        if(Objects.equals(userId, null)){
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    public boolean checkUrl(String url) {
        String end = StringUtils.substring(url, url.lastIndexOf("/"), url.length());
        for (String ext : exts) {
            if(end.endsWith(ext)){
                return true;
            }
        }
        return false;
    }
}
