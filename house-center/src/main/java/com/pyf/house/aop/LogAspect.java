package com.pyf.house.aop;

import cn.hutool.core.util.IdUtil;
import com.pyf.house.annotation.Token;
import com.pyf.house.extension.AppRuntimeEnv;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author ADMIN
 */
@Component
@Aspect
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Pointcut("execution(* com.pyf.house.controller..*.*(..))")
    public void controllerLogAop() {
    }

    @Pointcut("execution(* com.pyf.house.service..*.*(..))")
    public void serviceLogAop() {
    }

    @Before("controllerLogAop()")
    public void setAppRuntimeEnv(JoinPoint joinPoint) throws Exception {
        appRuntimeEnv.setRequestId(IdUtil.simpleUUID());

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        logger.info("Aop:request: requestId:{}", appRuntimeEnv.getRequestId());
        logger.info("Aop:method:{}", method.toString());

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        Token tokenAnno = method.getAnnotation(Token.class);
        String token = request.getHeader("token");
        if (tokenAnno != null && tokenAnno.require()) {
            appRuntimeEnv.ensureToken(token);
            if (!"pyf".equals(token)) {
                throw new Exception("token校验不通过");
            }
        }

    }


}
