package com.mmall.filter;

import com.mmall.common.RequestHolder;
import com.mmall.model.SysUser;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 登录过滤器
 * @author Administrator
 *
 */
@Slf4j
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        SysUser sysUser = (SysUser)req.getSession().getAttribute("user");
        if (sysUser == null) {
            String path = "/signin.jsp";
            resp.sendRedirect(path);
            return;
        }
        //如果登陆成功把用户信息放到RequestHolder中，使用的时候再取出来
        RequestHolder.add(sysUser);
        RequestHolder.add(req);
        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }

    public void destroy() {

    }
}
