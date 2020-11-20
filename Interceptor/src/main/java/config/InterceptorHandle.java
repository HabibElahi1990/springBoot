package config;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Habib, on 19/11/2020
 */
@Component
public class InterceptorHandle implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("Pre Handle method is Calling");
        String contentType = request.getContentType();
        int contentLength = request.getContentLength();
        boolean result=true;
        if (contentType==null || !contentType.equals("application/json")){
            result=false;
        }
        if (contentLength<2){
            return false;
        }

        return result;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("Post Handle method is Calling");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
         System.out.println("Request and Response is completed");
    }
}
