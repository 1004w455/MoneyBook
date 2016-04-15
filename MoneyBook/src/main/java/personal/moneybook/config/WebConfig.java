package personal.moneybook.config;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;

@Configuration
public class WebConfig {

	/**
	 * lucy xss filter
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean xssEscapeServletFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new XssEscapeServletFilter());
		registrationBean.setOrder(1); // @Order로 처리.
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}

}
