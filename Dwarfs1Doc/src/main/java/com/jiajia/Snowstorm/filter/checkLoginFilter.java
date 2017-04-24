package com.jiajia.Snowstorm.filter;


import com.jiajia.Snowstorm.beans.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jim on 17-3-19.
 */
public class checkLoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        if (uri.contains("login") || uri.contains("index")|| uri.contains("register")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            User user = (User) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
            if (null == user || null == user.getId()) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect("login.htm");
            }
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {
        System.out.println("yoyoyoyo!");
    }
}
