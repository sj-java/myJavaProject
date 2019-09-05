package com.haoyun.personnelProject.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;



@Configuration
public class SimpleCORSFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletResponse httpResponse = (HttpServletResponse) response;
	     HttpServletRequest httpRequest = (HttpServletRequest) request;
	     // 不使用*，自动适配跨域域名，避免携带Cookie时失效
	        String origin = httpRequest.getHeader("Origin");
	        if(StringUtils.isNotBlank(origin)) {
	        	httpResponse.setHeader("Access-Control-Allow-Origin", origin);
	        }

	        // 自适应所有自定义头
	        String headers = httpRequest.getHeader("Access-Control-Request-Headers");
	        if(StringUtils.isNotBlank(headers)) {
	        	httpResponse.setHeader("Access-Control-Allow-Headers", headers);
	        	httpResponse.setHeader("Access-Control-Expose-Headers", headers);
	        }

	        // 允许跨域的请求方法类型
	        httpResponse.setHeader("Access-Control-Allow-Methods", "*");
	        // 预检命令（OPTIONS）缓存时间，单位：秒
	        httpResponse.setHeader("Access-Control-Max-Age", "3600");
	        // 明确许可客户端发送Cookie，不允许删除字段即可
	        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
	        
	        chain.doFilter(request, response);

	}
	@Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean<SimpleCORSFilter> bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*");
        bean.setFilter(new SimpleCORSFilter());
        // 过滤顺序，从小到大依次过滤
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return bean;
    }
}
