package com.example.springboot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class AnnotationAspect {
    @Before("@annotation(com.example.springboot.interfaces.XXService)")
    public void doBefore(JoinPoint joinPoint) {
        // 获取HttpServletRequest
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取要记录的日志内容
        // BasicDBObject logInfo = getBasicDBObject(request, joinPoint);
        HashMap logInfo = getRequestInfo(request, joinPoint);
        log.info("入库详情：{}", logInfo);
    }

    private HashMap getRequestInfo(HttpServletRequest request, JoinPoint joinPoint) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("requestURL", request.getRequestURL().toString());
        map.put("requestURI", request.getRequestURI());
        map.put("queryString", request.getQueryString());
        map.put("remoteAddr", request.getRemoteAddr());
        map.put("remoteHost", request.getRemoteHost());
        map.put("remotePort", request.getRemotePort());
        map.put("localAddr", request.getLocalAddr());
        map.put("localName", request.getLocalName());
        map.put("method", request.getMethod());
        map.put("headers", getHeadersInfo(request));
        map.put("parameters", getParameterMapInfo(request));
        map.put("classMethod", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        map.put("args", Arrays.toString(joinPoint.getArgs()));
        return map;
    }

    private String getParameterMapInfo(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuilder sb = new StringBuilder(500);
        parameterMap.entrySet().forEach(e -> sb.append(e.getKey() + ":" + e.getValue() + ", "));
        return sb.toString();
    }

    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}
