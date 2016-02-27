package personal.moneybook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO 다른 예제는 이것도 적용하던데 이유 파악해보자.
// @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 메소드별 권한 설정에 필요
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// 참고 : https://github.com/bkielczewski/example-spring-boot-security
	// 참고 : http://www.slideshare.net/meadunhansa/ss-53303729

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean // TODO salt 살트? 이거였나 랜덤키값 적용시켜 비밀번호 보호강화 시키기.
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 정적자원 이그노어 시키는 방법.
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/public/**", "/등등");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http //
				.authorizeRequests() //
				.antMatchers("/").permitAll() //
				.antMatchers("/admin/**", "/h2/**", "/private/**").hasAuthority("ADMIN") //
				.antMatchers("/user/**").hasAnyAuthority("ADMIN", "USER") // .hasAuthority("USER")
				.anyRequest().fullyAuthenticated()//
				.and() //
				//
				.formLogin() //
				.loginPage("/signin") //
				.failureUrl("/signin?error") //
				.usernameParameter("email").permitAll() //
				.and() //
				//
				.logout() //
				.logoutUrl("/signout") //
				// .deleteCookies("JSESSIONID") // TODO 이거 뭐하는 녀석인지 파악해봐야함
				.deleteCookies("remember-me") //
				.logoutSuccessUrl("/signin?signout").permitAll() //
				.and() //
				//
				.rememberMe() //
				.and() //
				//
				.exceptionHandling().accessDeniedPage("/403");

		http.csrf().disable();
		http.headers().frameOptions().disable(); // TODO 이 부분은 h2 console 사용하려고
													// 적용하였는데 뭐하는건진 정확히 모름.

		super.configure(http); // TODO 예제들보면 이거 안넣어도 잘되는데 왜 내가 짠거는 안되는거야!!!
								// 해결책으로 넣었음.
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

}
