package com.mmall.common;

import com.mmall.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
/**
 * Http请求前后监听工具
 * @author Administrator
 *
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    private static final String START_TIME = "requestStartTime";
    /**
     * 请求处理之前调用执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取当前请求路径
    	String url = request.getRequestURI().toString();
        //获取请求参数
    	Map parameterMap = request.getParameterMap();
        log.info("request start. url:{}, params:{}", url, JsonMapper.obj2String(parameterMap));
        //记录请求相应时间，开始
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
        return true;
    }
    /**
     * 请求处理完之后执行，只执行正常请求
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        String url = request.getRequestURI().toString();
//        long start = (Long) request.getAttribute(START_TIME);
//        long end = System.currentTimeMillis();
//        log.info("request finished. url:{}, cost:{}", url, end - start);
        removeThreadLocalInfo();
    }
    /**
     * 请求处理完之后执行，任何请求，包括出现异常后也执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURI().toString();
        long start = (Long) request.getAttribute(START_TIME);
        long end = System.currentTimeMillis();
        log.info("request completed. url:{}, cost:{}毫秒", url, end - start);

        removeThreadLocalInfo();
    }
    /**
     * 移除当前线程的信息
     */
    public void removeThreadLocalInfo() {
        RequestHolder.remove();;
    }
}
