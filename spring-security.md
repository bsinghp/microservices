Create a Spring Boot application by selecting Spring Web and Spring starter security
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
Create a Sample Controller
@RestController
public class SampleController {

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "Hello " + name;
	}
	
	@GetMapping("/hi/{name}")
	public String hi(@PathVariable String name) {
		return "Hi " + name;
	}
}
If you want to authenticate access to /hello here's the configuration
Create a configuration class MyConfiguration
@Configuration
@EnableWebSecurity
public class MyConfiguration extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//			.anyRequest()
//			.authenticated()
//			.and().formLogin();//httpBasic();
//	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/hello/**")
			.authenticated()
			.and().formLogin();
		
		http
		.authorizeRequests()
		.antMatchers("/hi/**")
		.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("prabhu").password("{noop}prabhu").roles("admin");
	}
	
}
