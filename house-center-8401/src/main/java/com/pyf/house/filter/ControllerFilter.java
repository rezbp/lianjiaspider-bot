package com.pyf.house.filter;

import com.pyf.house.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ADMIN
 */
@Component
public class ControllerFilter implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("ControllerFilter:preHandle:request-path:{}:,request.cookies:{}", request.getRequestURI(), request.getCookies());
        Long currentTime = TimeUtil.getCurrentTime();
        request.setAttribute("startTime", currentTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("ControllerFilter:postHandle:");
        TimeUtil.getCurrentTime();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long startTime = (Long) request.getAttribute("startTime");
        Long endTime = TimeUtil.getCurrentTime();
        Long useTime = endTime - startTime;
        logger.info("ControllerFilter:afterCompletion: use time :{} ms", useTime);
        logger.info("ControllerFilter:afterCompletion:status:" + response.getStatus());

    }

}
