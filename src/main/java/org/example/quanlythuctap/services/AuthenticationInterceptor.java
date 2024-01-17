package org.example.quanlythuctap.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username=request.getHeader("username");
        String password=request.getHeader("password");
        if (!xacThuc(username,password)){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
                return false;
        }
        return true;
    }
    private boolean xacThuc(String username, String password) {
        String validUsername = "abc";
        String validPassword = "123";
        return validUsername.equals(username) && validPassword.equals(password);
    }
}
