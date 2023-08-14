package com.niit.usermovieservice;

//import com.niit.usermovieservice.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class UserMovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMovieServiceApplication.class, args);
	}
//		    @Bean
//    		public FilterRegistrationBean jwtFilterBean() {
//			FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//			filterRegistrationBean.setFilter(new JwtFilter());
//			filterRegistrationBean.addUrlPatterns("/api/v2/user/*");
//			return filterRegistrationBean;
//		}
}
