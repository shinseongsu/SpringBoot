package info.theocodinglive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/assets/**")
				.addResourceLocations("classpath:/assets/", "/assets/")
		.setCachePeriod(60 * 60 * 24 * 365)
		.resourceChain(true)
		.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
		
	}
	
}
