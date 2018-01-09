package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*登陆认证的拦截器*/
public class LoginInterceptor implements HandlerInterceptor{

    /**
     * Handler执行之前调用这个方法
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        //获取Session
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");

        if(username != null){
            return true;
        }


        //不符合条件的，跳转到登录界面
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

        return false;
    }


    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }


    /**
     * Handler执行完成之后调用这个方法
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
