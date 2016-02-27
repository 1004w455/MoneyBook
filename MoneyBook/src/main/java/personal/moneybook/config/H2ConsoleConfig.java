package personal.moneybook.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {

	// 접속할때 입력란에 필요한 정보. (JDBC URL 부분만 적용해주면 됨.)
	// Driver     Class org.h2.Driver
	// JDBC URL   jdbc:h2:mem:testdb
	// User Name  sa
	// Password   <blank>

	@Bean
	ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/h2console/*");
		return registrationBean;
	}

}
