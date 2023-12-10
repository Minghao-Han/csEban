package com.AAA.csEban.Utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //跨域请求会首先发一个option请求，直接返回正常状态并通过拦截器
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        String token = (String)request.getSession().getAttribute("jwt");
        String requestUrl = request.getServletPath();
        if (token!=null){
            JwtVerifyResult result = JwtUtils.verifyJwt(token);
            // 验证token,user和admin用不同的验证方式
            if (result.validate && requestUrl.contains(result.userRole)) {
                return true;
            }
        }
        /**
         * 还可以在此处检验其他操作
         */
        response.sendRedirect("/");//重定向到进入页
        return false;
    }
}
