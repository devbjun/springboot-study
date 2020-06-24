package kr.inhatc.spring.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  
  @Override
  protected void configure(HttpSecurity security) throws Exception {
    security.authorizeRequests()
    .antMatchers("/").permitAll()
    .antMatchers("/user/**").hasRole("ADMIN")
    .antMatchers("/board/**").hasAnyRole("MEMBER", "ADMIN");

    security.csrf().disable();

    security.formLogin().loginPage("/login/login").defaultSuccessUrl("/", true);

    security.exceptionHandling().accessDeniedPage("/login/accessDenied");

    security.logout().logoutUrl("/login/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
  }
}