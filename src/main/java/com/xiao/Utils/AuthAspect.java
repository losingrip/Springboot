package com.xiao.Utils;

import com.xiao.annotation.Auth;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

@Aspect
@Component
public class AuthAspect {

    @Pointcut(value = "@annotation(com.xiao.annotation.Auth)")
    public void authCheck(){}


    @Around("authCheck()")
    public Object around(ProceedingJoinPoint point) throws Throwable{

        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String token = request.getHeader("token");
        Map map = request.getParameterMap();
        System.out.println(map);
        System.out.println(token);
        Logger logger = LoggerFactory.getLogger(AuthAspect.class);
        Signature signature = point.getSignature();
        String className = point.getTarget().getClass().getSimpleName();
        String methodName = signature.getName();
        logger.info(className,methodName);

        MethodSignature methodSignature = (MethodSignature)signature;
        Method targetMethod = methodSignature.getMethod();
        if (targetMethod.isAnnotationPresent(Auth.class)){
            Auth auth = targetMethod.getAnnotation(Auth.class);
            String auths = auth.auth();
            if (StringUtils.isEmpty(auths)){
            }
            return point.proceed();
        }
        return "good";
    }
}
