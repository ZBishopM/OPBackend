package pe.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
	//@Override
	//protected void configure(final HttpSecurity http) throws Exception{ http.headers().frameOptions().deny().and().authorizeRequests().antMatchers("/**").permitAll();}
	@Override
	protected void configure(final HttpSecurity http) throws Exception{
		http.authorizeRequests().
		antMatchers(HttpMethod.OPTIONS,"/**").denyAll().antMatchers("/**").permitAll();
	}
	
}
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}

