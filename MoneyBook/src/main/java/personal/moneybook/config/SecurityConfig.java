package personal.moneybook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// @EnableGlobalMethodSecurity(prePostEnabled = true)
// @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http //
				// .formLogin() //
				// .loginPage("/user/login")//
				// .and()//
				// //
				// .logout()//
				// .logoutUrl("/user/logout")//
				// .deleteCookies("JSESSIONID")//
				// .logoutSuccessUrl("/post/list")//
				// .and() //
				//
				.authorizeRequests() //
				.antMatchers("/").permitAll() //
				.antMatchers("/h2console").hasRole("ADMIN") //
				.anyRequest().fullyAuthenticated()//
				.and() //
				//
				.rememberMe()//
				.and()//
				//
				.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
