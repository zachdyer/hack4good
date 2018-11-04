package com.borrowmyangel.hack4good.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 * Configure Spring MVC to use Apache Tiles and our resources folder.
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	/**
	 * Configure Spring MVC to use Apache Tiles.
	 *
	 * @return A UrlBasedViewResolver that instructs Spring MVC to use Tiles.
	 */
	@Bean
	public UrlBasedViewResolver tilesViewResolver() {
		UrlBasedViewResolver tilesResolver = new UrlBasedViewResolver();
		tilesResolver.setViewClass(TilesView.class);
		return tilesResolver;
	}

	/**
	 * Configure Spring MVC to identify the Tiles definition file.
	 *
	 * @return A TilesConfigurer object set up to point to /WEB-INF/views.xml.
	 */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("/WEB-INF/views.xml");
		return tilesConfigurer;
	}

	/**
	 * Configure Spring MVC to use our resources folder at /webapp/resources/.
	 *
	 * @param registry A ResourceHandlerRegistry object to manipulate.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
				.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/")
				.setCachePeriod(3600)
				.resourceChain(true)
				.addResolver(new PathResourceResolver());
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://ec2-18-216-155-150.us-east-2.compute.amazonaws.com");
			}
		};
	}
}
