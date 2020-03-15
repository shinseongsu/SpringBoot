package info.theocodinglive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import info.theocodinglive.ExecuteTimeInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ExecuteTimeInterceptor executeTimeInterceptor() {
		return new ExecuteTimeInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(executeTimeInterceptor())
			.addPathPatterns("/**")
			.excludePathPatterns("/");
	} 
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/assets/**")
				.addResourceLocations("classpath:/assets/", "/assets/")
//		.setCachePeriod(60 * 60 * 24 * 365)
		.setCachePeriod(3600)	
		.resourceChain(true)
		.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
		
	}
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
    }
	
}
