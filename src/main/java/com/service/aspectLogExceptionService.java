package com.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;


public class aspectLogExceptionService {

    private final Logger logger = LogManager.getLogger(aspectLogExceptionService.class);

    //切入点
    public void afterThrow(JoinPoint joinPoint, Exception ex){
        //详细错误信息
        String errorMsg = "";
        StackTraceElement[] trace = ex.getStackTrace();
        for (StackTraceElement s : trace) {
            errorMsg += "\tat " + s + "\r\n";
        }

        //写入异常日志
        writeLog(errorMsg,joinPoint,ex);
    }

    /**
     *
     * @param detailErrMsg 详细错误信息
     * @Description: 日志异常
     * @author： Ma
     * @createTime： 2016-10-14
     */
    public void writeLog(String detailErrMsg,JoinPoint joinPoint,Exception ex) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.
                getRequestAttributes()).getRequest();
        //获取请求的URL
        StringBuffer requestURL = request.getRequestURL();
        //获取参 数信息
        String queryString = request.getQueryString();
        //封装完整请求URL带参数
        if(queryString != null){
            requestURL .append("?").append(queryString);
        }

        String methodName = joinPoint.getSignature().getName();
        String className  = joinPoint.getSignature().getClass().getName();
        try{
            StringBuffer sb = new StringBuffer();
            sb.append("exception!!!\r\n");
            sb.append("请求URL："+requestURL+"\r\n");
            sb.append("接口方法："+ className +"."+methodName+"\r\n");
            sb.append("详细错误信息："+ex+"\r\n");
            sb.append(detailErrMsg+"\r\n");
            logger.error(sb.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Object aroundThrow(ProceedingJoinPoint joinPoint) throws Throwable {
        Object retVal = joinPoint.proceed();
        return retVal;
    }
}
