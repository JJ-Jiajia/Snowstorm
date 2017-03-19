package com.jiajia.Snowstorm.filter;

import org.springframework.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jim on 17-3-19.
 */
public class checkLoginFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uri =((HttpServletRequest)servletRequest).getRequestURI();
        if(uri.contains("login") ||uri.contains("index")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            String userid=(String)((HttpServletRequest) servletRequest).getSession().getAttribute("userid");
            if(null ==userid|| "".equals(userid)){
                HttpServletResponse response=(HttpServletResponse)servletResponse;
                response.sendRedirect("login");
                return;
            }
        }
    }

    public void destroy() {

    }
}
