package com.yl.demo.learning.aspect;

import com.yl.demo.learning.constant.staticfinal.OperationStatus;
import com.yl.demo.learning.entity.log.AuditLog;
import com.yl.demo.learning.service.AuditLogService;
import com.yl.demo.learning.utils.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
@Aspect
public class AuditLogAspect {

    @Autowired
    private AuditLogService auditLogService;

    private AuditLog auditLog;
    private HttpServletRequest request;
    private MethodSignature methodSignature;
    private String controllerName;
    private String methodName;
    private String location;
    private PrintWriter pw;
    private StringWriter sw;


    @Pointcut("@annotation(com.yl.demo.learning.annotation.AuditLog)")
    public void cut(){

    }

    @Around("cut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        auditLog = new AuditLog();

        return proceedingJoinPoint.proceed();
    }

    @Before("cut()")
    public void before() {
        /*log.info("===before log starts===");
        log.info("===before log ends===");*/
    }

    @After("cut()")
    public void after(JoinPoint joinpoint) throws Throwable {
        /*log.info("===after log starts===");*/
        long timestamp = System.currentTimeMillis();

        request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        methodSignature = (MethodSignature) joinpoint.getSignature();
        controllerName = joinpoint.getTarget().getClass().getName();
        methodName = joinpoint.getSignature().getName();
        location = controllerName+"."+methodName;
        sw = new StringWriter();
        pw = new PrintWriter(sw);


        String operationDesc = joinpoint.getTarget().getClass().getDeclaredMethod(methodName, methodSignature.getParameterTypes()).getAnnotation(com.yl.demo.learning.annotation.AuditLog.class).operationDesc();
        String operationType = joinpoint.getTarget().getClass().getDeclaredMethod(methodName, methodSignature.getParameterTypes()).getAnnotation(com.yl.demo.learning.annotation.AuditLog.class).operationType();
        String operatorName = joinpoint.getTarget().getClass().getDeclaredMethod(methodName, methodSignature.getParameterTypes()).getAnnotation(com.yl.demo.learning.annotation.AuditLog.class).operatorName();

        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = joinpoint.getArgs();
        List<String> argsArr = new ArrayList<>();

        for (int i=0; i<args.length; i++) {
            argsArr.add(parameterNames[i]+"="+args[i]);
        }

        /*log.info("request url:"+request.getRequestURL());
        log.info("request uri:"+request.getRequestURI());
        log.info("request remote address:"+request.getRemoteAddr());
        log.info("location:"+location);
        log.info("operation time:"+new Date(timestamp));
        log.info("operation type:"+operationType);
        log.info("operation description:"+operationDesc);*/

        auditLog.setOperationTime(new Date(timestamp));
        auditLog.setOperationType(operationType);
        auditLog.setOperationDescription(operationDesc);
        auditLog.setOperationInfo(operatorName+" is trying to "+operationDesc.toLowerCase()+": "+String.join(",", argsArr));
        auditLog.setOperatorName(operatorName);
        auditLog.setOperatorIp(IPUtil.getIpAddress(request));

        /*log.info("===after log ends===");*/
    }

    @AfterReturning("cut()")
    public void afterReturning() {
        /*log.info("===after returning log starts===");*/

        auditLog.setOperationStatus(OperationStatus.SUCCESS);
        auditLog.setOperationException("NONE");
        auditLog.setOperationExMsg("NONE");
        auditLogService.insert(auditLog);
        /*log.info("===after returning log ends===");*/
        log.info("inset audit log complete");
    }

    @AfterThrowing(value = "cut()", throwing = "throwable")
    public void afterThrowing(Throwable throwable) throws Throwable{
        //log.info("===after throwing log starts===");

        throwable.printStackTrace(pw);
        auditLog.setOperationStatus(OperationStatus.FAIL);
        auditLog.setOperationExMsg(throwable.getMessage());
        auditLog.setOperationException(location+"=>"+sw.toString());
        auditLogService.insert(auditLog);
        //log.info("===after throwing log ends===");
        log.info("inset audit log complete");
    }

}
