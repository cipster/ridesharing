package ro.arnia.ridesharing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ro.arnia.ridesharing.service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new SuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new FailureHandler();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
            http.cors().and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/", "/persons").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .and()
                .formLogin()
                .permitAll()
                .loginProcessingUrl("/login")
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(4);
    }
}
