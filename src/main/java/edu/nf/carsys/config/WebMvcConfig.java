package edu.nf.carsys.config;

import edu.nf.carsys.controller.interceptor.UserInterceptor;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LWP
 * @date 2020/1/8
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html", "/adminLogin", "/js/**", "/css/**");
    }

    /**
     * 配置Bean Validator验证器
     */
    @Override
    public Validator getValidator() {
        //创建本地校验的的工厂Bean
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        //指定校验器为HibernateValidator
        factoryBean.setProviderClass(HibernateValidator.class);
        //配置验证消息资源文件
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message");
        messageSource.setDefaultEncoding("UTF-8");
        //将资源信息设置到factoryBean
        factoryBean.setValidationMessageSource(messageSource);
        return factoryBean;
    }
}