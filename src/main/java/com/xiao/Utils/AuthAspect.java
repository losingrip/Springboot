package com.xiao.Utils;

import com.xiao.annotation.Auth;
import com.xiao.domian.dao.PartMapper;
import com.xiao.domian.entity.Part;
import com.xiao.domian.entity.Resource;
import com.xiao.domian.entity.User;
import com.xiao.service.AuthService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class AuthAspect {

    @Autowired
    AuthService authService;

    @Pointcut(value = "@annotation(com.xiao.annotation.Auth)")
    public void authCheck() {
    }


    @Around("authCheck()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        Logger logger = LoggerFactory.getLogger(AuthAspect.class);
        Signature signature = point.getSignature();
        String className = point.getTarget().getClass().getSimpleName();
        String methodName = signature.getName();
        logger.info(className, methodName);

        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        if (targetMethod.isAnnotationPresent(Auth.class)) {
            Auth auth = targetMethod.getAnnotation(Auth.class);
            String auths = auth.auth();
            System.out.println(auths + "============");
            EmptyUtil.isEmpty(auths, "auths");
            if (!getPart(auths)){
                throw new Exception("没有权限！");
            }
            return point.proceed();
        }
        return "pass";
    }

    public boolean getPart(String auth) {

        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String UserId = request.getHeader("token");
        List<Part> parts = authService.getUserResource(UserId, auth);
        for (Part part:parts) {
            List<Resource> resources = part.getResources();
            if (resources.size()>0){
                return true;
            }
        }
        return false;
    }
}
