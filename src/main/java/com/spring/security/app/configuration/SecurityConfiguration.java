package com.spring.security.app.configuration;

import com.spring.security.app.service.impl.PersonDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    protected PersonDetailsServiceImpl personDetailsService;


    // Authentications configure
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailsService).passwordEncoder(getPasswordEncoder());
    }

    // Spring Security configure
    // Authorization configure
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/auth/login", "/error","/auth/registration").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/auth/login")
                    .loginProcessingUrl("/process_login")
                    .defaultSuccessUrl("/hello", true)
                    .failureUrl("/auth/login?error")
                .and()
                    .logout().logoutUrl("/logout")
                    .logoutSuccessUrl("/auth/login");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
