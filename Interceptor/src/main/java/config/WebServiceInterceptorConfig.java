package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by Habib, on 19/11/2020
 */

/*for illustrate and  run InterceptorHandle class should create a bean by configuration or component class like WebServiceInterceptorConfig
    and must extends WebMvcConfigurationSupport after that must inject  as registry.addInterceptor(interceptorHandle);
    */
@Configuration
public class WebServiceInterceptorConfig extends WebMvcConfigurationSupport {
   final InterceptorHandle interceptorHandle;

    public WebServiceInterceptorConfig(InterceptorHandle interceptorHandle) {
        this.interceptorHandle = interceptorHandle;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorHandle);
    }
}
