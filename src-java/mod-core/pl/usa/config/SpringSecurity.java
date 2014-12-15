package pl.usa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import pl.usa.config.support.RedirectUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

	@Autowired DataSource dataSource;
	@Autowired RedirectUrlAuthenticationSuccessHandler successHandler;


	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
 
	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select email,password, 1 from users where email=?")
		.authoritiesByUsernameQuery(
			"select email, role from users where email=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/org/**").access("hasRole('ROLE_ORG')")
				.antMatchers("/gamer/**").access("hasRole('ROLE_USER')")
				.and()
			.logout()
				.logoutUrl("/logout.htm")
				.logoutSuccessUrl("/index.htm")
				.and()
			.formLogin()
				.loginPage("/login.htm")
				.loginProcessingUrl("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.successHandler(successHandler);

		http.csrf().disable();

	}
}